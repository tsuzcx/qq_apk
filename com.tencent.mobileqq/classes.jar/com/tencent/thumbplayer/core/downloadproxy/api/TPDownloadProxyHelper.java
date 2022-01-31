package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.Context;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPProxyAdapterManager;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;

public class TPDownloadProxyHelper
{
  private static final String FILE_NAME = "TPDownloadProxyHelper";
  private static Context applicationContext;
  private static ITPOfflineVinfoAdapter offlineVinfoAdapter = null;
  
  public static String checkVideoStatus(String paramString1, String paramString2)
  {
    if (!TPDownloadProxyFactory.canUseService()) {
      return "";
    }
    if (offlineVinfoAdapter != null) {
      return offlineVinfoAdapter.checkVideoStatus(paramString1, paramString2);
    }
    return TPProxyAdapterManager.getInstance().checkVideoStatus(paramString1, paramString2);
  }
  
  public static Context getContext()
  {
    return applicationContext;
  }
  
  public static String getHLSOfflineExttag(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    try
    {
      if (TPDownloadProxyNative.getInstance().isNativeLoaded())
      {
        paramString1 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getHLSOfflineExttag(paramString1, paramString2, paramInt, paramLong));
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyHelper", 0, "tpdlnative", "get exttag failed, error:" + paramString1.toString());
    }
    return "";
  }
  
  public static String getNativeLibVersion()
  {
    return TPDownloadProxyFactory.getNativeVersion();
  }
  
  public static int getRecordDuration(String paramString1, String paramString2)
  {
    if (offlineVinfoAdapter != null) {
      return offlineVinfoAdapter.getRecordDuration(paramString1, paramString2);
    }
    return TPProxyAdapterManager.getInstance().getRecordDuration(paramString1, paramString2);
  }
  
  public static boolean isReadyForDownload()
  {
    return TPDownloadProxyFactory.isReadyForDownload();
  }
  
  public static boolean isReadyForPlay()
  {
    return TPDownloadProxyFactory.isReadyForPlay();
  }
  
  public static void setContext(Context paramContext)
  {
    applicationContext = paramContext;
  }
  
  public static void setNativeLibLoader(ITPDLProxyNativeLibLoader paramITPDLProxyNativeLibLoader)
  {
    TPDownloadProxyNative.getInstance().setLibLoader(paramITPDLProxyNativeLibLoader);
  }
  
  public static void setTPOfflineVinfoAdapter(ITPOfflineVinfoAdapter paramITPOfflineVinfoAdapter)
  {
    offlineVinfoAdapter = paramITPOfflineVinfoAdapter;
  }
  
  public static void setTPProxyAdapter(ITPProxyAdapter paramITPProxyAdapter)
  {
    TPProxyAdapterManager.getInstance().setProxyAdapter(paramITPProxyAdapter);
  }
  
  public static void setUseService(boolean paramBoolean)
  {
    TPDownloadProxyFactory.setUseService(paramBoolean);
  }
  
  public static void updateProxyMessage(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    TPProxyAdapterManager.getInstance().updateProxyMessage(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public static long verifyOfflineCacheSync(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    try
    {
      if (TPDownloadProxyNative.getInstance().isNativeLoaded())
      {
        long l = TPDownloadProxyNative.getInstance().verifyOfflineCacheSync(paramString1, paramInt, paramString2, paramString3);
        return l;
      }
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyHelper", 0, "tpdlnative", "verify offline cache failed, error:" + paramString1.toString());
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper
 * JD-Core Version:    0.7.0.1
 */