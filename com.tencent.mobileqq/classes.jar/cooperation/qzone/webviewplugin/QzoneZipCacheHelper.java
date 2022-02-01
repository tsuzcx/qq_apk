package cooperation.qzone.webviewplugin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.PriorityThreadPool.Priority;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class QzoneZipCacheHelper
{
  public static final String BUSINESS = "business";
  public static final String CALLBACK = "callback";
  public static final String COUNT = "count";
  public static final String DIR = "dir";
  private static final int DOWNLOAD_DELAY_TIME = 3000;
  public static final String FILEB_NAME_LIST = "imageNameList";
  private static final String TAG = "QzoneZipCacheHelper";
  private static final byte[] URL_LOCK = new byte[0];
  public static final String ZIPURL = "zipurl";
  private static FileCacheService mFileCache;
  private static ConcurrentHashMap<String, CopyOnWriteArrayList<Object>> sDownloadindUrlMap = new ConcurrentHashMap();
  
  public static boolean checkAndDownLoadFileIfNeeded(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack)
  {
    for (;;)
    {
      try
      {
        String str = getFileCache().getPath(getFolderName(paramString2, paramString3));
        if (isDangerousLocalPath(str))
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("路径不合法：");
          paramAppInterface.append(str);
          QLog.w("QzoneZipCacheHelper", 1, paramAppInterface.toString());
          return false;
        }
        ??? = new File(str);
        if ((((File)???).exists()) && (((File)???).isDirectory()))
        {
          ??? = ((File)???).listFiles();
          if ((??? != null) && ((paramInt == -1) || (???.length == paramInt)) && (???.length > 0))
          {
            updateLruFileInNewThread(paramString2, paramString3);
            if (QLog.isColorLevel()) {
              QLog.i("QzoneZipCacheHelper", 2, String.format("file exist,update lru,url:%s,path:%s , zipUrl = %s ", new Object[] { paramString2, str, paramString1 }));
            }
            if (paramQzoneZipCacheHelperCallBack == null) {
              break label311;
            }
            paramQzoneZipCacheHelperCallBack.onResultOfNativeRequest(true, str, paramString1);
            return true;
          }
        }
        synchronized (URL_LOCK)
        {
          if (sDownloadindUrlMap != null)
          {
            paramString3 = (CopyOnWriteArrayList)sDownloadindUrlMap.get(paramString1);
            if (paramString3 != null) {
              break label313;
            }
            paramString3 = new CopyOnWriteArrayList();
            i = 0;
            if (!paramString3.contains(paramQzoneZipCacheHelperCallBack))
            {
              if (paramQzoneZipCacheHelperCallBack == null) {
                paramQzoneZipCacheHelperCallBack = new Object();
              }
              paramString3.add(paramQzoneZipCacheHelperCallBack);
              sDownloadindUrlMap.put(paramString1, paramString3);
            }
            if (i != 0) {
              return false;
            }
          }
          ThreadManager.postDownLoadTask(new QzoneZipCacheHelper.2(paramString2, str, paramString1, paramInt, paramAppInterface), 2, null, false);
          return false;
        }
        return true;
      }
      catch (Throwable paramAppInterface)
      {
        QLog.e("QzoneZipCacheHelper", 1, paramAppInterface, new Object[0]);
        return false;
      }
      label311:
      label313:
      int i = 1;
    }
  }
  
  public static boolean checkDownloadZip(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((!paramString.contains("?_offline=1")) && (!paramString.contains("&_offline=1"))) {
        return false;
      }
      return (paramString.contains("&_type=1")) || (paramString.contains("?_type=1"));
    }
    return false;
  }
  
  private static void createAndClearFile(File paramFile)
  {
    if (!paramFile.exists())
    {
      paramFile.mkdir();
      return;
    }
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile == null) {
        return;
      }
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        if (!localObject.isDirectory()) {
          localObject.delete();
        }
        i += 1;
      }
    }
    paramFile.mkdir();
  }
  
  public static Bitmap decodeByteArray(String paramString1, String paramString2, byte[] paramArrayOfByte, BitmapFactory.Options paramOptions, boolean paramBoolean)
  {
    if (paramBoolean) {
      updateLruFileInNewThread(paramString1, paramString2);
    }
    try
    {
      paramString1 = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, paramOptions);
      return paramString1;
    }
    catch (OutOfMemoryError paramString1)
    {
      break label38;
    }
    catch (Exception paramString1)
    {
      label21:
      label38:
      label52:
      break label21;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("QzoneZipCacheHelper", 2, "decodeByteArray exception ");
      break label52;
      if (QLog.isColorLevel()) {
        QLog.i("QzoneZipCacheHelper", 2, "decodeByteArray out of memory");
      }
    }
    return null;
  }
  
  public static String getBasePath(String paramString1, String paramString2)
  {
    return getFileCache().getPath(getFolderName(paramString1, paramString2));
  }
  
  private static FileCacheService getFileCache()
  {
    if (mFileCache == null) {
      mFileCache = CacheManager.getZipCacheService();
    }
    return mFileCache;
  }
  
  public static File getFileIfExists(AppInterface paramAppInterface, String paramString)
  {
    if (!android.webkit.URLUtil.isNetworkUrl(paramString)) {
      return null;
    }
    Map localMap = com.tencent.util.URLUtil.a(paramString);
    return getFileIfExists(paramAppInterface, getUrlBase(paramString), getFileName(paramString), (String)localMap.get("business"), (String)localMap.get("dir"), null);
  }
  
  public static File getFileIfExists(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, QzoneOfflineCacheHelperCallBack paramQzoneOfflineCacheHelperCallBack)
  {
    try
    {
      paramAppInterface = getFileCache().getPath(getFolderName(paramString3, paramString4));
      paramString1 = new StringBuilder();
      paramString1.append(paramAppInterface);
      paramString1.append(File.separator);
      paramString1.append(paramString2);
      paramString1 = new File(paramString1.toString());
      if ((paramString1.exists()) && (paramString1.length() > 0L))
      {
        updateLruFileInNewThread(paramString3, paramString4);
        if (QLog.isColorLevel()) {
          QLog.i("QzoneZipCacheHelper", 2, String.format("file exist,update lru,url:%s,path:%s", new Object[] { paramString3, paramAppInterface }));
        }
        return paramString1;
      }
    }
    catch (Throwable paramAppInterface)
    {
      QLog.e("QzoneZipCacheHelper", 1, paramAppInterface, new Object[0]);
    }
    return null;
  }
  
  public static String[] getFileList(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject = new File(paramString);
      if (!((File)localObject).exists())
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getFileList doesn't exists path = ");
          ((StringBuilder)localObject).append(paramString);
          QLog.i("QzoneZipCacheHelper", 2, ((StringBuilder)localObject).toString());
          return null;
        }
      }
      else
      {
        localObject = ((File)localObject).list();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFileList path = ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" nameList = ");
          localStringBuilder.append(localObject);
          QLog.i("QzoneZipCacheHelper", 2, localStringBuilder.toString());
        }
        if (localObject != null) {
          Arrays.sort((Object[])localObject);
        }
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      QZLog.e("QzoneZipCacheHelper", " getFileList ", paramString);
      return null;
    }
    return null;
  }
  
  private static String getFileName(String paramString)
  {
    int i = paramString.lastIndexOf(File.separator);
    int j = paramString.indexOf('?');
    if ((i != -1) && (j != -1) && (j > i)) {
      return paramString.substring(i + 1, j);
    }
    return null;
  }
  
  public static String[] getFolderFileNameList(String paramString1, String paramString2)
  {
    return getFileList(getFileCache().getPath(getFolderName(paramString1, paramString2)));
  }
  
  public static String[] getFolderFileNameList(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = getFileCache().getPath(getFolderName(paramString1, paramString2));
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(File.separator);
    paramString2.append(paramString3);
    return getFileList(paramString2.toString());
  }
  
  private static String getFolderName(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private static String getUrlBase(String paramString)
  {
    return paramString.substring(0, paramString.lastIndexOf(File.separator));
  }
  
  public static boolean isDangerousLocalPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return (paramString.contains("../")) || (paramString.contains("..\\"));
  }
  
  public static void unzipFile(String paramString1, String paramString2)
  {
    createAndClearFile(new File(paramString2));
    ZipUtils.unZipFolder(paramString1, paramString2);
  }
  
  private static void updateLruFileInNewThread(String paramString1, String paramString2)
  {
    PriorityThreadPool.getDefault().submit(new QzoneZipCacheHelper.1(paramString1, paramString2), PriorityThreadPool.Priority.LOW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneZipCacheHelper
 * JD-Core Version:    0.7.0.1
 */