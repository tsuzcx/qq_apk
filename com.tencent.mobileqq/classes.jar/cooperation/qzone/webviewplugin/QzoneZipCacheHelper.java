package cooperation.qzone.webviewplugin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import anlr;
import anls;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.PriorityThreadPool.Priority;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
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
  private static ConcurrentHashMap sDownloadindUrlMap = new ConcurrentHashMap();
  
  public static boolean checkAndDownLoadFileIfNeeded(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack)
  {
    for (;;)
    {
      String str;
      try
      {
        str = getFileCache().a(getFolderName(paramString2, paramString3));
        if (isDangerousLocalPath(str))
        {
          QLog.w("QzoneZipCacheHelper", 1, "路径不合法：" + str);
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
              QLog.i("QzoneZipCacheHelper", 2, String.format("file exist,update lru,url:%s,path:%s", new Object[] { paramString2, str }));
            }
            if (paramQzoneZipCacheHelperCallBack == null) {
              break label300;
            }
            paramQzoneZipCacheHelperCallBack.onResultOfNativeRequest(true, str, paramString1);
            break label300;
          }
        }
        synchronized (URL_LOCK)
        {
          if (sDownloadindUrlMap != null)
          {
            paramString3 = (CopyOnWriteArrayList)sDownloadindUrlMap.get(paramString1);
            if (paramString3 != null) {
              break label302;
            }
            paramString3 = new CopyOnWriteArrayList();
            i = 0;
            if (!paramString3.contains(paramQzoneZipCacheHelperCallBack))
            {
              if (paramQzoneZipCacheHelperCallBack != null)
              {
                paramString3.add(paramQzoneZipCacheHelperCallBack);
                sDownloadindUrlMap.put(paramString1, paramString3);
              }
            }
            else
            {
              if (i == 0) {
                break label274;
              }
              return false;
            }
            paramQzoneZipCacheHelperCallBack = new Object();
          }
        }
      }
      catch (Throwable paramAppInterface)
      {
        QLog.e("QzoneZipCacheHelper", 1, paramAppInterface, new Object[0]);
        return false;
      }
      label274:
      ThreadManager.postDownLoadTask(new anls(paramString2, str, paramInt, paramString1, paramAppInterface), 2, null, false);
      continue;
      label300:
      return true;
      label302:
      int i = 1;
    }
  }
  
  public static boolean checkDownloadZip(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.contains("?_offline=1")) && (!paramString.contains("&_offline=1")))) {}
    while ((!paramString.contains("&_type=1")) && (!paramString.contains("?_type=1"))) {
      return false;
    }
    return true;
  }
  
  private static void createAndClearFile(File paramFile)
  {
    if (!paramFile.exists()) {
      paramFile.mkdir();
    }
    for (;;)
    {
      return;
      if (!paramFile.isDirectory()) {
        break;
      }
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
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
      if (QLog.isColorLevel()) {
        QLog.i("QzoneZipCacheHelper", 2, "decodeByteArray out of memory");
      }
      return null;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QzoneZipCacheHelper", 2, "decodeByteArray exception ");
        }
      }
    }
  }
  
  public static String getBasePath(String paramString1, String paramString2)
  {
    return getFileCache().a(getFolderName(paramString1, paramString2));
  }
  
  private static FileCacheService getFileCache()
  {
    if (mFileCache == null) {
      mFileCache = CacheManager.c();
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
      paramAppInterface = getFileCache().a(getFolderName(paramString3, paramString4));
      paramString1 = new File(paramAppInterface + File.separator + paramString2);
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
  
  private static String getFileName(String paramString)
  {
    Object localObject2 = null;
    int i = paramString.lastIndexOf(File.separator);
    int j = paramString.indexOf('?');
    Object localObject1 = localObject2;
    if (i != -1)
    {
      localObject1 = localObject2;
      if (j != -1)
      {
        localObject1 = localObject2;
        if (j > i) {
          localObject1 = paramString.substring(i + 1, j);
        }
      }
    }
    return localObject1;
  }
  
  public static String[] getFolderFileNameList(String paramString1, String paramString2)
  {
    paramString1 = new File(getFileCache().a(getFolderName(paramString1, paramString2))).list();
    if (paramString1 != null) {
      Arrays.sort(paramString1);
    }
    return paramString1;
  }
  
  private static String getFolderName(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  private static String getUrlBase(String paramString)
  {
    return paramString.substring(0, paramString.lastIndexOf(File.separator));
  }
  
  public static boolean isDangerousLocalPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.contains("../")) && (!paramString.contains("..\\"))) {
      return false;
    }
    return true;
  }
  
  public static void unzipFile(String paramString1, String paramString2)
  {
    createAndClearFile(new File(paramString2));
    ZipUtils.a(paramString1, paramString2);
  }
  
  private static void updateLruFileInNewThread(String paramString1, String paramString2)
  {
    PriorityThreadPool.getDefault().submit(new anlr(paramString1, paramString2), PriorityThreadPool.Priority.LOW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneZipCacheHelper
 * JD-Core Version:    0.7.0.1
 */