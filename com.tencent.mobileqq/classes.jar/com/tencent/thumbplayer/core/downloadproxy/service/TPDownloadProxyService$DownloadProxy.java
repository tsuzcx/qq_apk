package com.tencent.thumbplayer.core.downloadproxy.service;

import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadParamAidl;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class TPDownloadProxyService$DownloadProxy
  extends ITPDownloadProxyAidl.Stub
{
  private ITPDownloadProxy downloadProxy = null;
  
  public TPDownloadProxyService$DownloadProxy(TPDownloadProxyService paramTPDownloadProxyService, int paramInt)
  {
    this.downloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(paramInt);
  }
  
  public String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.downloadProxy.getClipPlayUrl(paramInt1, paramInt2);
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    return this.downloadProxy.getPlayErrorCodeStr(paramInt);
  }
  
  public String getPlayUrl(int paramInt1, int paramInt2)
  {
    return this.downloadProxy.getPlayUrl(paramInt1);
  }
  
  public int init(String paramString)
  {
    try
    {
      paramString = (TPDLProxyInitParam)TPDLProxyUtils.serializeToObject(paramString);
      if (paramString == null)
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "param is null");
        return -1;
      }
      int i = this.downloadProxy.init(TPDownloadProxyHelper.getContext(), paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "init failed, error:" + paramString.toString());
    }
    return -2;
  }
  
  public int pauseDownload(int paramInt)
  {
    return this.downloadProxy.pauseDownload(paramInt);
  }
  
  public void pushEvent(int paramInt)
  {
    this.downloadProxy.pushEvent(paramInt);
  }
  
  public int resumeDownload(int paramInt)
  {
    return this.downloadProxy.resumeDownload(paramInt);
  }
  
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParamAidl paramTPDownloadParamAidl)
  {
    paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
    return this.downloadProxy.setClipInfo(paramInt1, paramInt2, paramString, paramTPDownloadParamAidl);
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    this.downloadProxy.setMaxStorageSizeMB(paramLong);
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    this.downloadProxy.setPlayState(paramInt1, paramInt2);
  }
  
  public void setUserData(Map paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (localEntry != null) {
          try
          {
            if (localEntry.getValue() != null) {
              this.downloadProxy.setUserData((String)localEntry.getKey(), localEntry.getValue());
            }
          }
          catch (Throwable localThrowable)
          {
            TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "setUserData failed, error:" + localThrowable.toString());
          }
        }
      }
    }
  }
  
  public int startClipPlay(String paramString, int paramInt, ITPPlayListenerAidl paramITPPlayListenerAidl)
  {
    paramITPPlayListenerAidl = new TPDownloadProxyService.DownloadProxy.2(this, paramITPPlayListenerAidl);
    return this.downloadProxy.startClipPlay(paramString, paramInt, paramITPPlayListenerAidl);
  }
  
  public int startPlay(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPlayListenerAidl paramITPPlayListenerAidl)
  {
    try
    {
      paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
      paramITPPlayListenerAidl = new TPDownloadProxyService.DownloadProxy.1(this, paramITPPlayListenerAidl);
      int i = this.downloadProxy.startPlay(paramString, paramTPDownloadParamAidl, paramITPPlayListenerAidl);
      return i;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "startPlay failed, error:" + paramString.toString());
    }
    return -1;
  }
  
  public int startPreload(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPreLoadListenerAidl paramITPPreLoadListenerAidl)
  {
    paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
    paramITPPreLoadListenerAidl = new TPDownloadProxyService.DownloadProxy.3(this, paramITPPreLoadListenerAidl);
    return this.downloadProxy.startPreload(paramString, paramTPDownloadParamAidl, paramITPPreLoadListenerAidl);
  }
  
  public void stopPlay(int paramInt)
  {
    this.downloadProxy.stopPlay(paramInt);
  }
  
  public void stopPreload(int paramInt)
  {
    this.downloadProxy.stopPreload(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy
 * JD-Core Version:    0.7.0.1
 */