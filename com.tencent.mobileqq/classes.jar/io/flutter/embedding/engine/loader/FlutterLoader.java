package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.util.PathUtils;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlutterLoader
{
  private static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
  private static final String DEFAULT_AOT_SHARED_LIBRARY_NAME = "libapp.so";
  private static final String DEFAULT_FLUTTER_ASSETS_DIR = "flutter_assets";
  private static final String DEFAULT_ISOLATE_SNAPSHOT_DATA = "isolate_snapshot_data";
  private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
  private static final String DEFAULT_LIBRARY = "libflutter.so";
  private static final String DEFAULT_VM_SNAPSHOT_DATA = "vm_snapshot_data";
  private static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
  private static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
  private static final String PUBLIC_AOT_SHARED_LIBRARY_NAME;
  private static final String PUBLIC_FLUTTER_ASSETS_DIR_KEY;
  private static final String PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY;
  private static final String PUBLIC_VM_SNAPSHOT_DATA_KEY;
  private static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
  private static final String TAG = "FlutterLoader";
  private static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
  private static FlutterLoader instance;
  private static String sAotSharedLibraryPath = null;
  private static String sNativeLibDir;
  private String aotSharedLibraryName = "libapp.so";
  private String flutterAssetsDir = "flutter_assets";
  private boolean initialized = false;
  private String isolateSnapshotData = "isolate_snapshot_data";
  @Nullable
  private ResourceExtractor resourceExtractor;
  @Nullable
  private FlutterLoader.Settings settings;
  private String vmSnapshotData = "vm_snapshot_data";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterLoader.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("aot-shared-library-name");
    PUBLIC_AOT_SHARED_LIBRARY_NAME = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterLoader.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("vm-snapshot-data");
    PUBLIC_VM_SNAPSHOT_DATA_KEY = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterLoader.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("isolate-snapshot-data");
    PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterLoader.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("flutter-assets-dir");
    PUBLIC_FLUTTER_ASSETS_DIR_KEY = localStringBuilder.toString();
    sNativeLibDir = null;
  }
  
  @NonNull
  private String fullAssetPathFrom(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.flutterAssetsDir);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @NonNull
  private ApplicationInfo getApplicationInfo(@NonNull Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
  }
  
  @NonNull
  public static FlutterLoader getInstance()
  {
    if (instance == null) {
      instance = new FlutterLoader();
    }
    return instance;
  }
  
  private void initConfig(@NonNull Context paramContext)
  {
    paramContext = getApplicationInfo(paramContext).metaData;
    if (paramContext == null) {
      return;
    }
    this.aotSharedLibraryName = paramContext.getString(PUBLIC_AOT_SHARED_LIBRARY_NAME, "libapp.so");
    this.flutterAssetsDir = paramContext.getString(PUBLIC_FLUTTER_ASSETS_DIR_KEY, "flutter_assets");
    this.vmSnapshotData = paramContext.getString(PUBLIC_VM_SNAPSHOT_DATA_KEY, "vm_snapshot_data");
    this.isolateSnapshotData = paramContext.getString(PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY, "isolate_snapshot_data");
  }
  
  private void initResources(@NonNull Context paramContext)
  {
    new ResourceCleaner(paramContext).start();
  }
  
  public static void setNativeLibDir(String paramString)
  {
    sNativeLibDir = paramString;
  }
  
  public void ensureInitializationComplete(@NonNull Context paramContext, @Nullable String[] paramArrayOfString)
  {
    if (this.initialized) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      if (this.settings != null) {
        for (;;)
        {
          ArrayList localArrayList;
          try
          {
            if (this.resourceExtractor != null) {
              this.resourceExtractor.waitForCompletion();
            }
            localArrayList = new ArrayList();
            localArrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
            Object localObject = getApplicationInfo(paramContext);
            if (sNativeLibDir == null)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("--icu-native-lib-path=");
              localStringBuilder.append(((ApplicationInfo)localObject).nativeLibraryDir);
              localStringBuilder.append(File.separator);
              localStringBuilder.append("libflutter.so");
              localArrayList.add(localStringBuilder.toString());
              if (paramArrayOfString != null) {
                Collections.addAll(localArrayList, paramArrayOfString);
              }
              if (sNativeLibDir != null) {
                break label427;
              }
              paramArrayOfString = new StringBuilder();
              paramArrayOfString.append("--aot-shared-library-name=");
              paramArrayOfString.append(this.aotSharedLibraryName);
              localArrayList.add(paramArrayOfString.toString());
              paramArrayOfString = new StringBuilder();
              paramArrayOfString.append("--aot-shared-library-name=");
              paramArrayOfString.append(((ApplicationInfo)localObject).nativeLibraryDir);
              paramArrayOfString.append(File.separator);
              paramArrayOfString.append(this.aotSharedLibraryName);
              localArrayList.add(paramArrayOfString.toString());
              paramArrayOfString = new StringBuilder();
              paramArrayOfString.append("--cache-dir-path=");
              paramArrayOfString.append(PathUtils.getCacheDirectory(paramContext));
              localArrayList.add(paramArrayOfString.toString());
              if (this.settings.getLogTag() != null)
              {
                paramArrayOfString = new StringBuilder();
                paramArrayOfString.append("--log-tag=");
                paramArrayOfString.append(this.settings.getLogTag());
                localArrayList.add(paramArrayOfString.toString());
              }
              paramArrayOfString = PathUtils.getFilesDir(paramContext);
              localObject = PathUtils.getCacheDirectory(paramContext);
              FlutterJNI.nativeInit(paramContext, (String[])localArrayList.toArray(new String[0]), null, paramArrayOfString, (String)localObject);
              this.initialized = true;
              return;
            }
          }
          catch (Exception paramContext)
          {
            Log.e("FlutterLoader", "Flutter initialization failed.", paramContext);
            throw new RuntimeException(paramContext);
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("--icu-native-lib-path=");
          localStringBuilder.append(sNativeLibDir);
          localStringBuilder.append(File.separator);
          localStringBuilder.append("libflutter.so");
          localArrayList.add(localStringBuilder.toString());
          continue;
          label427:
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("--aot-shared-library-name=");
          paramArrayOfString.append(sNativeLibDir);
          paramArrayOfString.append(File.separator);
          paramArrayOfString.append(this.aotSharedLibraryName);
          localArrayList.add(paramArrayOfString.toString());
        }
      }
      throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
    }
    throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
  }
  
  public void ensureInitializationCompleteAsync(@NonNull Context paramContext, @Nullable String[] paramArrayOfString, @NonNull Handler paramHandler, @NonNull Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      if (this.settings != null)
      {
        if (this.initialized) {
          return;
        }
        new Thread(new FlutterLoader.1(this, paramContext, paramArrayOfString, paramHandler, paramRunnable)).start();
        return;
      }
      throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
    }
    throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
  }
  
  @NonNull
  public String findAppBundlePath()
  {
    return this.flutterAssetsDir;
  }
  
  @NonNull
  public String getLookupKeyForAsset(@NonNull String paramString)
  {
    return fullAssetPathFrom(paramString);
  }
  
  @NonNull
  public String getLookupKeyForAsset(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("packages");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    return getLookupKeyForAsset(localStringBuilder.toString());
  }
  
  public void startInitialization(@NonNull Context paramContext)
  {
    startInitialization(paramContext, new FlutterLoader.Settings());
  }
  
  public void startInitialization(@NonNull Context paramContext, @NonNull FlutterLoader.Settings paramSettings)
  {
    if (this.settings != null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.settings = paramSettings;
      long l = SystemClock.uptimeMillis();
      initConfig(paramContext);
      initResources(paramContext);
      if (sNativeLibDir == null) {
        System.loadLibrary("flutter");
      }
      for (;;)
      {
        VsyncWaiter.getInstance((WindowManager)paramContext.getSystemService("window")).init();
        FlutterJNI.nativeRecordStartTimestamp(SystemClock.uptimeMillis() - l);
        return;
        paramSettings = new StringBuilder();
        paramSettings.append(sNativeLibDir);
        paramSettings.append(File.separator);
        paramSettings.append("libflutter.so");
        System.load(paramSettings.toString());
      }
    }
    throw new IllegalStateException("startInitialization must be called on the main thread");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.FlutterLoader
 * JD-Core Version:    0.7.0.1
 */