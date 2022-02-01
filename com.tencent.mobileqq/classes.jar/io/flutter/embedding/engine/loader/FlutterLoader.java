package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FlutterLoader
{
  static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
  private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
  private static final String DEFAULT_LIBRARY = "libflutter.so";
  static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
  static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
  static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
  private static final String TAG = "FlutterLoader";
  static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
  private static FlutterLoader instance;
  private static String sAotSharedLibraryPath;
  private static String sNativeLibDir;
  private FlutterApplicationInfo flutterApplicationInfo;
  @Nullable
  Future<FlutterLoader.InitResult> initResultFuture;
  private long initStartTimestampMillis;
  private boolean initialized = false;
  @Nullable
  private FlutterLoader.Settings settings;
  
  @NonNull
  private String fullAssetPathFrom(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.flutterApplicationInfo.flutterAssetsDir);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @Deprecated
  @NonNull
  public static FlutterLoader getInstance()
  {
    if (instance == null) {
      instance = new FlutterLoader();
    }
    return instance;
  }
  
  private ResourceExtractor initResources(@NonNull Context paramContext)
  {
    return null;
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
            FlutterLoader.InitResult localInitResult = (FlutterLoader.InitResult)this.initResultFuture.get();
            localArrayList = new ArrayList();
            localArrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
            if (sNativeLibDir == null)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("--icu-native-lib-path=");
              localStringBuilder.append(this.flutterApplicationInfo.nativeLibraryDir);
              localStringBuilder.append(File.separator);
              localStringBuilder.append("libflutter.so");
              localArrayList.add(localStringBuilder.toString());
              if (paramArrayOfString != null) {
                Collections.addAll(localArrayList, paramArrayOfString);
              }
              if (sNativeLibDir != null) {
                break label529;
              }
              paramArrayOfString = new StringBuilder();
              paramArrayOfString.append("--aot-shared-library-name=");
              paramArrayOfString.append(this.flutterApplicationInfo.aotSharedLibraryName);
              localArrayList.add(paramArrayOfString.toString());
              paramArrayOfString = new StringBuilder();
              paramArrayOfString.append("--aot-shared-library-name=");
              paramArrayOfString.append(this.flutterApplicationInfo.nativeLibraryDir);
              paramArrayOfString.append(File.separator);
              paramArrayOfString.append(this.flutterApplicationInfo.aotSharedLibraryName);
              localArrayList.add(paramArrayOfString.toString());
              paramArrayOfString = new StringBuilder();
              paramArrayOfString.append("--cache-dir-path=");
              paramArrayOfString.append(localInitResult.engineCachesPath);
              localArrayList.add(paramArrayOfString.toString());
              if (!this.flutterApplicationInfo.clearTextPermitted) {
                localArrayList.add("--disallow-insecure-connections");
              }
              if (this.flutterApplicationInfo.domainNetworkPolicy != null)
              {
                paramArrayOfString = new StringBuilder();
                paramArrayOfString.append("--domain-network-policy=");
                paramArrayOfString.append(this.flutterApplicationInfo.domainNetworkPolicy);
                localArrayList.add(paramArrayOfString.toString());
              }
              if (this.settings.getLogTag() != null)
              {
                paramArrayOfString = new StringBuilder();
                paramArrayOfString.append("--log-tag=");
                paramArrayOfString.append(this.settings.getLogTag());
                localArrayList.add(paramArrayOfString.toString());
              }
              long l1 = SystemClock.uptimeMillis();
              long l2 = this.initStartTimestampMillis;
              if (FlutterInjector.instance().shouldLoadNative()) {
                FlutterJNI.nativeInit(paramContext, (String[])localArrayList.toArray(new String[0]), null, localInitResult.appStoragePath, localInitResult.engineCachesPath, l1 - l2);
              }
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
          label529:
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("--aot-shared-library-name=");
          paramArrayOfString.append(sNativeLibDir);
          paramArrayOfString.append(File.separator);
          paramArrayOfString.append(this.flutterApplicationInfo.aotSharedLibraryName);
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
        if (this.initialized)
        {
          paramHandler.post(paramRunnable);
          return;
        }
        Executors.newSingleThreadExecutor().execute(new FlutterLoader.2(this, paramContext, paramArrayOfString, paramHandler, paramRunnable));
        return;
      }
      throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
    }
    throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
  }
  
  @NonNull
  public String findAppBundlePath()
  {
    return this.flutterApplicationInfo.flutterAssetsDir;
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
  
  public boolean initialized()
  {
    return this.initialized;
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
      paramContext = paramContext.getApplicationContext();
      this.settings = paramSettings;
      this.initStartTimestampMillis = SystemClock.uptimeMillis();
      this.flutterApplicationInfo = ApplicationInfoLoader.load(paramContext);
      VsyncWaiter.getInstance((WindowManager)paramContext.getSystemService("window")).init();
      paramContext = new FlutterLoader.1(this, paramContext);
      this.initResultFuture = Executors.newSingleThreadExecutor().submit(paramContext);
      return;
    }
    throw new IllegalStateException("startInitialization must be called on the main thread");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.FlutterLoader
 * JD-Core Version:    0.7.0.1
 */