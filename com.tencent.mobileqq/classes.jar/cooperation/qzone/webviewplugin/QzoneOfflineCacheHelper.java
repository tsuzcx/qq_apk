package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.URLUtil;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class QzoneOfflineCacheHelper
{
  private static final int DOWNLOAD_DELAY_TIME = 10000;
  private static final String TAG = "QzoneOfflineCacheHelper";
  private static final int UPDATE_LRU_FILE_DELAY_TIME = 20000;
  private static final byte[] URL_LOCK = new byte[0];
  private static ConcurrentHashMap<String, ArrayList<Object>> downloadindUrlMap = new ConcurrentHashMap();
  private static FileCacheService mFileCache;
  
  public static boolean checkFileIfExist(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {
      return false;
    }
    String str = urlKey2FileName(paramString, true);
    str = getFileCache().getPath(str);
    if (new File(str).exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QzoneOfflineCacheHelper", 2, String.format("check result file exist,url:%s,path:%s", new Object[] { paramString, str }));
      }
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("QzoneOfflineCacheHelper", 2, String.format("check result file not exist,url:%s,path:%s", new Object[] { paramString, str }));
    }
    return false;
  }
  
  public static File downLoadFileIfNeeded(AppInterface paramAppInterface, String paramString1, QzoneOfflineCacheHelperCallBack paramQzoneOfflineCacheHelperCallBack, boolean paramBoolean, String paramString2)
  {
    Object localObject1;
    try
    {
      if (!URLUtil.isNetworkUrl(paramString1)) {
        return null;
      }
      String str1 = urlKey2FileName(paramString1, true);
      String str2 = "";
      if (!paramBoolean)
      {
        str2 = CacheManager.getQzoneWidgetAICacheService().getPath("dressup");
        localObject1 = new File(str2);
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(str1);
        str1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        str1 = getFileCache().getPath(str1);
      }
      localObject1 = new File(str1);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(".headers");
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if ((((File)localObject1).exists()) && (((File)localObject1).length() > 0L) && (((File)localObject2).exists()) && (((File)localObject2).length() > 0L))
      {
        if (!paramBoolean) {
          updateLruFileInNewThread(str2);
        } else {
          updateLruFileInNewThread(str1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("QzoneOfflineCacheHelper", 2, String.format("file exist,update lru,url:%s ,path:%s", new Object[] { paramString1, str1 }));
        }
        if (paramQzoneOfflineCacheHelperCallBack == null) {
          break label339;
        }
        paramQzoneOfflineCacheHelperCallBack.onResultOfNativeRequest(true, str1);
        return localObject1;
      }
      if (paramBoolean)
      {
        int i = getTBSCoreVersion();
        if (!TextUtils.isEmpty(paramString2))
        {
          downloadAfterGetDomainAndTBSVersion(paramAppInterface, paramString1, str1, getProtocolAndDomainOfCurrentWebPage(paramString2), i, paramQzoneOfflineCacheHelperCallBack);
          return null;
        }
        if (QLog.isDevelopLevel())
        {
          QLog.e("QzoneOfflineCacheHelper", 1, "offline webview Url is empty!");
          return null;
        }
      }
      else
      {
        downloadAfterGetDomainAndTBSVersion(paramAppInterface, paramString1, str1, "", 0, paramQzoneOfflineCacheHelperCallBack);
        return null;
      }
    }
    catch (Throwable paramAppInterface)
    {
      QLog.e("QzoneOfflineCacheHelper", 1, paramAppInterface, new Object[0]);
    }
    return null;
    label339:
    return localObject1;
  }
  
  public static void downloadAfterGetDomainAndTBSVersion(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, QzoneOfflineCacheHelperCallBack paramQzoneOfflineCacheHelperCallBack)
  {
    for (;;)
    {
      synchronized (URL_LOCK)
      {
        if (downloadindUrlMap != null)
        {
          ArrayList localArrayList = (ArrayList)downloadindUrlMap.get(paramString1);
          if (localArrayList != null) {
            break label136;
          }
          localArrayList = new ArrayList();
          i = 0;
          if (!localArrayList.contains(paramQzoneOfflineCacheHelperCallBack))
          {
            if (paramQzoneOfflineCacheHelperCallBack == null) {
              paramQzoneOfflineCacheHelperCallBack = new Object();
            }
            localArrayList.add(paramQzoneOfflineCacheHelperCallBack);
            downloadindUrlMap.put(paramString1, localArrayList);
          }
          if (i != 0) {
            return;
          }
        }
        paramAppInterface = new QzoneOfflineCacheHelper.2(paramString1, paramString2, paramAppInterface, paramString3, paramInt);
        QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").postDelayed(paramAppInterface, 10000L);
        return;
      }
      label136:
      int i = 1;
    }
  }
  
  private static FileCacheService getFileCache()
  {
    if (mFileCache == null) {
      mFileCache = CacheManager.getWebviewOfflineFileCacheService();
    }
    return mFileCache;
  }
  
  private static String getProtocolAndDomainOfCurrentWebPage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new URL(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.getProtocol());
      localStringBuilder.append("://");
      localStringBuilder.append(paramString.getHost());
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.e("QzoneOfflineCacheHelper", 2, "getProtocolAndDomainOfCurrentWebPage error", paramString);
    }
    return null;
  }
  
  public static long getSmallGameLastCacheTime(long paramLong)
  {
    if (paramLong <= 0L) {
      return 0L;
    }
    long l = LocalMultiProcConfig.getLong4Uin("key_qzone_preload_small_game_finish_", 0L, paramLong);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",getSmallGameLastCacheTime cacheTime=");
      localStringBuilder.append(l);
      QLog.i("QzoneOfflineCacheHelper", 2, localStringBuilder.toString());
    }
    return l;
  }
  
  private static int getTBSCoreVersion()
  {
    int i = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tbsCoreVersion= ");
      localStringBuilder.append(i);
      QLog.i("QzoneOfflineCacheHelper", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public static void updataSmallGameLastCacheFinishTime(long paramLong1, long paramLong2)
  {
    if (paramLong1 <= 0L) {}
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updataSmallGameLastCacheFinishTime uin is invalid,uin=");
      localStringBuilder.append(paramLong1);
      QLog.w("QzoneOfflineCacheHelper", 1, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      QLog.w("QzoneOfflineCacheHelper", 1, "updataSmallGameLastCacheFinishTime error.", localException);
    }
    LocalMultiProcConfig.putLong4Uin("key_qzone_preload_small_game_finish_", paramLong2, paramLong1);
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",updataSmallGameLastCacheFinishTime timestamp=");
      localStringBuilder.append(paramLong2);
      QLog.i("QzoneOfflineCacheHelper", 2, localStringBuilder.toString());
      return;
    }
  }
  
  public static void updateLruFileInNewThread(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").postDelayed(new QzoneOfflineCacheHelper.1(paramString), 20000L);
  }
  
  private static String urlKey2FileName(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return String.valueOf(paramString.hashCode());
    }
    String str = paramString;
    if (paramString.startsWith("file://")) {
      str = paramString.substring(7, paramString.length());
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper
 * JD-Core Version:    0.7.0.1
 */