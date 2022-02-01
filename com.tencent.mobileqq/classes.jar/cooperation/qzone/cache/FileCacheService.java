package cooperation.qzone.cache;

import android.text.TextUtils;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class FileCacheService
{
  public static final String HeaderFileSuffix = ".headers";
  private static final int STORAGE_CHECK_INTERVAL = 5;
  public static final String VERSION_FILE = "OldVersion.version";
  private int mExternalCapacity;
  private int mInternalCapacity;
  private final String mName;
  private AtomicInteger mStorageCounter = new AtomicInteger(0);
  private FileCacheService.StorageHandler mStorageHandler;
  private int version = 0;
  
  public FileCacheService(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.mName = paramString;
      this.version = paramInt1;
      this.mExternalCapacity = paramInt2;
      this.mInternalCapacity = paramInt3;
      return;
    }
    throw new NullPointerException("file cache: name can NOT be empty!");
  }
  
  private File createFile(String paramString)
  {
    paramString = getPath(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new File(paramString);
    if (isFileValid(paramString)) {
      FileUtils.delete(paramString);
    }
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      QLog.e("CacheManager", 1, "", localIOException);
    }
    return paramString;
  }
  
  private void ensureStorage()
  {
    if (this.mStorageCounter.getAndIncrement() < 5) {
      return;
    }
    this.mStorageCounter.set(0);
    String str = getDir();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    for (Object localObject = new File(str); !((File)localObject).exists(); localObject = ((File)localObject).getParentFile()) {}
    if (FileStorageHandler.isStorageSizeLow(((File)localObject).getAbsolutePath()))
    {
      localObject = this.mStorageHandler;
      if (localObject != null) {
        ((FileCacheService.StorageHandler)localObject).onLowStorage(this, CacheManager.isInternal(str) ^ true);
      }
    }
  }
  
  public static boolean isFileValid(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile());
  }
  
  public void deleteFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("FileCacheService deleteFile fileName:");
      localStringBuilder.append(paramString);
      QLog.i("CacheManager", 2, localStringBuilder.toString());
    }
    paramString = getPath(paramString);
    FileUtils.delete(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".headers");
    FileUtils.delete(localStringBuilder.toString());
  }
  
  public int getCapacity(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mExternalCapacity;
    }
    return this.mInternalCapacity;
  }
  
  public String getDir()
  {
    return CacheManager.getCacheDir(this.mName, this.version);
  }
  
  public File getFile(String paramString)
  {
    return getFile(paramString, false);
  }
  
  public File getFile(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = getPath(paramString);
    File localFile;
    if (str == null) {
      localFile = null;
    } else {
      localFile = new File(str);
    }
    if (isFileValid(localFile))
    {
      updateLruFile(str, false);
    }
    else if (paramBoolean)
    {
      localFile = createFile(paramString);
      paramString = localFile;
      if (!isFileValid(localFile)) {
        break label88;
      }
      updateLruFile(localFile.getAbsolutePath(), true);
      paramString = localFile;
      break label88;
    }
    paramString = localFile;
    label88:
    if (isFileValid(paramString)) {
      return paramString;
    }
    return null;
  }
  
  public String getPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = getDir();
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void setStorageHandler(FileCacheService.StorageHandler paramStorageHandler)
  {
    this.mStorageHandler = paramStorageHandler;
  }
  
  public void updateLruFile(String paramString, boolean paramBoolean)
  {
    Object localObject = new File(paramString);
    if ((((File)localObject).exists()) && (!((File)localObject).setLastModified(System.currentTimeMillis())) && (QLog.isDevelopLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("更新缓存文件的lru文件时间失败. path=");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("FileCacheService", 2, ((StringBuilder)localObject).toString());
    }
    ensureStorage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.cache.FileCacheService
 * JD-Core Version:    0.7.0.1
 */