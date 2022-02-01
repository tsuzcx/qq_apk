package com.tencent.thumbplayer.core.downloadproxy.client;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadParamAidl;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.HashMap;
import java.util.Map;

public class TPDownloadProxyClient
  implements ITPDownloadProxy
{
  private static final String FILE_NAME = "TPDownloadProxyClient";
  private ITPDownloadProxyAidl downloadProxyAidl = null;
  
  public TPDownloadProxyClient(ITPDownloadProxyAidl paramITPDownloadProxyAidl)
  {
    this.downloadProxyAidl = paramITPDownloadProxyAidl;
  }
  
  public int deinit()
  {
    return 0;
  }
  
  public String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      String str = this.downloadProxyAidl.getClipPlayUrl(paramInt1, paramInt2, paramInt3);
      return str;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getClipPlayUrl failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", localStringBuilder.toString());
    }
    return null;
  }
  
  public String getNativeInfo(int paramInt)
  {
    try
    {
      String str = this.downloadProxyAidl.getNativeInfo(paramInt);
      return str;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNativeInfo failed, error:");
      localStringBuilder.append(localException.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", localStringBuilder.toString());
    }
    return null;
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    try
    {
      String str = this.downloadProxyAidl.getPlayErrorCodeStr(paramInt);
      return str;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPlayErrorCodeStr failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", localStringBuilder.toString());
    }
    return null;
  }
  
  public String getPlayUrl(int paramInt1, int paramInt2)
  {
    try
    {
      String str = this.downloadProxyAidl.getPlayUrl(paramInt1, paramInt2);
      return str;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPlayUrl failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", localStringBuilder.toString());
    }
    return null;
  }
  
  public int init(Context paramContext, TPDLProxyInitParam paramTPDLProxyInitParam)
  {
    paramContext = TPDLProxyUtils.serialize(paramTPDLProxyInitParam);
    if (TextUtils.isEmpty(paramContext))
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "param is null");
      return -1;
    }
    try
    {
      int i = this.downloadProxyAidl.init(paramContext);
      return i;
    }
    catch (Throwable paramContext)
    {
      paramTPDLProxyInitParam = new StringBuilder();
      paramTPDLProxyInitParam.append("init failed, error:");
      paramTPDLProxyInitParam.append(paramContext.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", paramTPDLProxyInitParam.toString());
    }
    return -2;
  }
  
  public int pauseDownload(int paramInt)
  {
    try
    {
      paramInt = this.downloadProxyAidl.pauseDownload(paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseDownload failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", localStringBuilder.toString());
    }
    return -1;
  }
  
  public void pushEvent(int paramInt)
  {
    try
    {
      this.downloadProxyAidl.pushEvent(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pushEvent failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public int removeStorageCache(String paramString)
  {
    return -1;
  }
  
  public int resumeDownload(int paramInt)
  {
    try
    {
      paramInt = this.downloadProxyAidl.resumeDownload(paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resumeDownload failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", localStringBuilder.toString());
    }
    return -1;
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    try
    {
      this.downloadProxyAidl.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBusinessDownloadStrategy failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParam paramTPDownloadParam)
  {
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    try
    {
      boolean bool = this.downloadProxyAidl.setClipInfo(paramInt1, paramInt2, paramString, paramTPDownloadParam);
      return bool;
    }
    catch (Throwable paramString)
    {
      paramTPDownloadParam = new StringBuilder();
      paramTPDownloadParam.append("setClipInfo failed, error:");
      paramTPDownloadParam.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", paramTPDownloadParam.toString());
    }
    return false;
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    TPDLProxyLog.setLogListener(10303, paramITPDLProxyLogListener);
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    try
    {
      this.downloadProxyAidl.setMaxStorageSizeMB(paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMaxStorageSizeMB failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    try
    {
      this.downloadProxyAidl.setPlayState(paramInt1, paramInt2);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPlayState failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public void setUpdatePlayerInfoInterval(int paramInt)
  {
    try
    {
      this.downloadProxyAidl.setUpdatePlayerInfoInterval(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUpdatePlayerInfoInterval failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public void setUserData(String paramString, Object paramObject)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString, paramObject);
    try
    {
      this.downloadProxyAidl.setUserData(localHashMap);
      return;
    }
    catch (Throwable paramString)
    {
      paramObject = new StringBuilder();
      paramObject.append("setUserData failed, error:");
      paramObject.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", paramObject.toString());
    }
  }
  
  public int startClipOfflineDownload(String paramString, int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    return -1;
  }
  
  public int startClipPlay(String paramString, int paramInt, ITPPlayListener paramITPPlayListener)
  {
    if (paramITPPlayListener == null) {}
    try
    {
      return this.downloadProxyAidl.startClipPlay(paramString, paramInt, null);
    }
    catch (Throwable paramString)
    {
      paramITPPlayListener = new StringBuilder();
      paramITPPlayListener.append("startClipPlay failed, error:");
      paramITPPlayListener.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", paramITPPlayListener.toString());
    }
    paramITPPlayListener = new TPDownloadProxyClient.2(this, paramITPPlayListener);
    paramInt = this.downloadProxyAidl.startClipPlay(paramString, paramInt, paramITPPlayListener);
    return paramInt;
    return -1;
  }
  
  public int startOfflineDownload(String paramString, TPDownloadParam paramTPDownloadParam, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    return -1;
  }
  
  public int startPlay(String paramString, TPDownloadParam paramTPDownloadParam, ITPPlayListener paramITPPlayListener)
  {
    if (this.downloadProxyAidl != null)
    {
      if (paramTPDownloadParam == null) {
        return -1;
      }
      paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
      if (paramITPPlayListener == null) {}
      try
      {
        return this.downloadProxyAidl.startPlay(paramString, paramTPDownloadParam, null);
      }
      catch (Throwable paramString)
      {
        int i;
        paramTPDownloadParam = new StringBuilder();
        paramTPDownloadParam.append("startPlay failed, error:");
        paramTPDownloadParam.append(paramString.toString());
        TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", paramTPDownloadParam.toString());
      }
      paramITPPlayListener = new TPDownloadProxyClient.1(this, paramITPPlayListener);
      i = this.downloadProxyAidl.startPlay(paramString, paramTPDownloadParam, paramITPPlayListener);
      return i;
    }
    return -1;
  }
  
  public int startPreload(String paramString, TPDownloadParam paramTPDownloadParam, ITPPreLoadListener paramITPPreLoadListener)
  {
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    paramITPPreLoadListener = new TPDownloadProxyClient.3(this, paramITPPreLoadListener);
    try
    {
      int i = this.downloadProxyAidl.startPreload(paramString, paramTPDownloadParam, paramITPPreLoadListener);
      return i;
    }
    catch (Throwable paramString)
    {
      paramTPDownloadParam = new StringBuilder();
      paramTPDownloadParam.append("startPreload failed, error:");
      paramTPDownloadParam.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", paramTPDownloadParam.toString());
    }
    return -1;
  }
  
  public void startTask(int paramInt) {}
  
  public void stopOfflineDownload(int paramInt) {}
  
  public void stopPlay(int paramInt)
  {
    try
    {
      this.downloadProxyAidl.stopPlay(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopPlay failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public void stopPreload(int paramInt)
  {
    try
    {
      this.downloadProxyAidl.stopPreload(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopPreload failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public void updateAidl(ITPDownloadProxyAidl paramITPDownloadProxyAidl)
  {
    this.downloadProxyAidl = paramITPDownloadProxyAidl;
  }
  
  public void updateStoragePath(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient
 * JD-Core Version:    0.7.0.1
 */