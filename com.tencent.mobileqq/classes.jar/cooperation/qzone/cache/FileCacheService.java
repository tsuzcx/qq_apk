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
  private int version;
  
  public FileCacheService(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("file cache: name can NOT be empty!");
    }
    this.mName = paramString;
    this.version = paramInt1;
    this.mExternalCapacity = paramInt2;
    this.mInternalCapacity = paramInt3;
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
    if (this.mStorageCounter.getAndIncrement() < 5) {}
    String str;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          this.mStorageCounter.set(0);
          str = getDir();
        } while (TextUtils.isEmpty(str));
        for (localObject = new File(str); !((File)localObject).exists(); localObject = ((File)localObject).getParentFile()) {}
      } while (!FileStorageHandler.isStorageSizeLow(((File)localObject).getAbsolutePath()));
      localObject = this.mStorageHandler;
    } while (localObject == null);
    if (!CacheManager.isInternal(str)) {}
    for (boolean bool = true;; bool = false)
    {
      ((FileCacheService.StorageHandler)localObject).onLowStorage(this, bool);
      return;
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
    if (QLog.isColorLevel()) {
      QLog.i("CacheManager", 2, "FileCacheService deleteFile fileName:" + paramString);
    }
    paramString = getPath(paramString);
    FileUtils.delete(paramString);
    FileUtils.delete(paramString + ".headers");
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
    Object localObject;
    if (str == null)
    {
      localObject = null;
      if (!isFileValid((File)localObject)) {
        break label59;
      }
      updateLruFile(str, false);
      label37:
      if (!isFileValid((File)localObject)) {
        break label92;
      }
    }
    for (;;)
    {
      return localObject;
      localObject = new File(str);
      break;
      label59:
      if (!paramBoolean) {
        break label37;
      }
      paramString = createFile(paramString);
      localObject = paramString;
      if (!isFileValid(paramString)) {
        break label37;
      }
      updateLruFile(paramString.getAbsolutePath(), true);
      localObject = paramString;
      break label37;
      label92:
      localObject = null;
    }
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
    return str + File.separator + paramString;
  }
  
  public void setStorageHandler(FileCacheService.StorageHandler paramStorageHandler)
  {
    this.mStorageHandler = paramStorageHandler;
  }
  
  public void updateLruFile(String paramString, boolean paramBoolean)
  {
    File localFile = new File(paramString);
    if ((localFile.exists()) && (!localFile.setLastModified(System.currentTimeMillis())) && (QLog.isDevelopLevel())) {
      QLog.w("FileCacheService", 2, "更新缓存文件的lru文件时间失败. path=" + paramString);
    }
    ensureStorage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.cache.FileCacheService
 * JD-Core Version:    0.7.0.1
 */