package com.tencent.superplayer.datatransport;

import android.content.Context;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.ISPlayerDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.datatransport.ITPProxyManagerAdapter;
import com.tencent.thumbplayer.datatransport.TPProxyGlobalManager;
import com.tencent.thumbplayer.datatransport.TPProxyUtils;

public class SPlayerDownloaderImpl
  implements ISPlayerDownloader
{
  private static final String TAG = "SPlayerDownloaderImpl";
  private ITPDownloadProxy mTPDownloadProxy;
  
  public SPlayerDownloaderImpl(Context paramContext, int paramInt)
  {
    CommonUtil.a(CommonUtil.a(paramInt));
    paramContext = TPProxyGlobalManager.getInstance().getPlayerProxy(CommonUtil.a(paramInt));
    if ((paramContext != null) && (paramContext.getDownloadProxy() != null)) {
      this.mTPDownloadProxy = paramContext.getDownloadProxy();
    }
  }
  
  private int getDlTypeForDownloadParam(int paramInt)
  {
    if (paramInt != 101)
    {
      if (paramInt != 102) {
        return 10;
      }
      return 3;
    }
    return 1;
  }
  
  public void pauseOfflineDownload(int paramInt)
  {
    ITPDownloadProxy localITPDownloadProxy = this.mTPDownloadProxy;
    if (localITPDownloadProxy != null) {
      localITPDownloadProxy.pauseDownload(paramInt);
    }
  }
  
  public void resumeOfflineDownload(int paramInt)
  {
    ITPDownloadProxy localITPDownloadProxy = this.mTPDownloadProxy;
    if (localITPDownloadProxy != null) {
      localITPDownloadProxy.resumeDownload(paramInt);
    }
  }
  
  public int startOfflineDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, ISPlayerDownloader.Listener paramListener)
  {
    if ((this.mTPDownloadProxy != null) && (paramSuperPlayerVideoInfo != null))
    {
      localObject = new TPDownloadParamData();
      ((TPDownloadParamData)localObject).setUrl(paramSuperPlayerVideoInfo.getPlayUrl());
      ((TPDownloadParamData)localObject).setSavePath(paramSuperPlayerVideoInfo.getLocalSavePath());
      ((TPDownloadParamData)localObject).setDownloadFileID(CommonUtil.a(paramSuperPlayerVideoInfo));
      ((TPDownloadParamData)localObject).setUrlHostList(paramSuperPlayerVideoInfo.getUrlHostList());
      ((TPDownloadParamData)localObject).setDlType(getDlTypeForDownloadParam(paramSuperPlayerVideoInfo.getFormat()));
      if (paramSuperPlayerVideoInfo.getCookie() != null) {
        ((TPDownloadParamData)localObject).setUrlCookieList(paramSuperPlayerVideoInfo.getCookie());
      }
      int i = this.mTPDownloadProxy.startOfflineDownload(CommonUtil.a(paramSuperPlayerVideoInfo), TPProxyUtils.convertProxyDownloadParams(null, (TPDownloadParamData)localObject, null), null);
      TPListenerManager.getInstance().setOfflineDownloadListener(i, new SPlayerDownloaderImpl.1(this, paramListener, i));
      this.mTPDownloadProxy.startTask(i);
      return i;
    }
    paramListener = TAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("error, mTPDownloadProxy = ");
    ((StringBuilder)localObject).append(this.mTPDownloadProxy);
    ((StringBuilder)localObject).append(", videoInfo = ");
    ((StringBuilder)localObject).append(paramSuperPlayerVideoInfo);
    ((StringBuilder)localObject).append(", return");
    LogUtil.e(paramListener, ((StringBuilder)localObject).toString());
    return 0;
  }
  
  public void stopOfflineDownload(int paramInt)
  {
    ITPDownloadProxy localITPDownloadProxy = this.mTPDownloadProxy;
    if (localITPDownloadProxy != null) {
      localITPDownloadProxy.stopOfflineDownload(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */