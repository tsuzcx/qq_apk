package io.flutter.view;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

class ResourceExtractor
{
  private static final String[] SUPPORTED_ABIS = ;
  private static final String TAG = "ResourceExtractor";
  private static final String TIMESTAMP_PREFIX = "res_timestamp-";
  @NonNull
  private final AssetManager mAssetManager;
  @NonNull
  private final String mDataDirPath;
  private ResourceExtractor.ExtractTask mExtractTask;
  @NonNull
  private final PackageManager mPackageManager;
  @NonNull
  private final String mPackageName;
  @NonNull
  private final HashSet<String> mResources;
  
  ResourceExtractor(@NonNull String paramString1, @NonNull String paramString2, @NonNull PackageManager paramPackageManager, @NonNull AssetManager paramAssetManager)
  {
    this.mDataDirPath = paramString1;
    this.mPackageName = paramString2;
    this.mPackageManager = paramPackageManager;
    this.mAssetManager = paramAssetManager;
    this.mResources = new HashSet();
  }
  
  private static String checkTimestamp(@NonNull File paramFile, @NonNull PackageManager paramPackageManager, @NonNull String paramString)
  {
    try
    {
      paramPackageManager = paramPackageManager.getPackageInfo(paramString, 0);
      if (paramPackageManager == null) {
        paramFile = "res_timestamp-";
      }
      do
      {
        do
        {
          do
          {
            return paramFile;
            paramString = new StringBuilder();
            paramString.append("res_timestamp-");
            paramString.append(getVersionCode(paramPackageManager));
            paramString.append("-");
            paramString.append(paramPackageManager.lastUpdateTime);
            paramPackageManager = paramString.toString();
            paramString = getExistingTimestamps(paramFile);
            paramFile = paramPackageManager;
          } while (paramString == null);
          int i = paramString.length;
          paramFile = paramPackageManager;
        } while (paramString.length != 1);
        paramFile = paramPackageManager;
      } while (!paramPackageManager.equals(paramString[0]));
      return null;
    }
    catch (PackageManager.NameNotFoundException paramFile) {}
    return "res_timestamp-";
  }
  
  private static void copy(@NonNull InputStream paramInputStream, @NonNull OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[16384];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i < 0) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static void deleteFiles(@NonNull String paramString, @NonNull HashSet<String> paramHashSet)
  {
    paramString = new File(paramString);
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      File localFile = new File(paramString, (String)paramHashSet.next());
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    paramHashSet = getExistingTimestamps(paramString);
    if (paramHashSet == null) {}
    for (;;)
    {
      return;
      int j = paramHashSet.length;
      int i = 0;
      while (i < j)
      {
        new File(paramString, paramHashSet[i]).delete();
        i += 1;
      }
    }
  }
  
  private static String[] getExistingTimestamps(File paramFile)
  {
    return paramFile.list(new ResourceExtractor.1());
  }
  
  private static String[] getSupportedAbis()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return Build.SUPPORTED_ABIS;
    }
    ArrayList localArrayList = new ArrayList(Arrays.asList(new String[] { Build.CPU_ABI, Build.CPU_ABI2 }));
    localArrayList.removeAll(Arrays.asList(new String[] { null, "" }));
    return (String[])localArrayList.toArray(new String[0]);
  }
  
  static long getVersionCode(@NonNull PackageInfo paramPackageInfo)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramPackageInfo.getLongVersionCode();
    }
    return paramPackageInfo.versionCode;
  }
  
  ResourceExtractor addResource(@NonNull String paramString)
  {
    this.mResources.add(paramString);
    return this;
  }
  
  ResourceExtractor addResources(@NonNull Collection<String> paramCollection)
  {
    this.mResources.addAll(paramCollection);
    return this;
  }
  
  ResourceExtractor start()
  {
    this.mExtractTask = new ResourceExtractor.ExtractTask(this.mDataDirPath, this.mResources, this.mPackageName, this.mPackageManager, this.mAssetManager);
    this.mExtractTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    return this;
  }
  
  void waitForCompletion()
  {
    if (this.mExtractTask == null) {
      return;
    }
    try
    {
      this.mExtractTask.get();
      return;
    }
    catch (CancellationException localCancellationException)
    {
      deleteFiles(this.mDataDirPath, this.mResources);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label18;
    }
    catch (ExecutionException localExecutionException)
    {
      label18:
      break label18;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.view.ResourceExtractor
 * JD-Core Version:    0.7.0.1
 */