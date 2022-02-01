package com.tencent.superplayer.datatransport;

import android.content.Context;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.ISPlayerDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.Utils;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.datatransport.ITPProxyManagerAdapter;
import com.tencent.thumbplayer.datatransport.TPProxyGlobalManager;
import com.tencent.thumbplayer.datatransport.TPProxyUtils;

public class SPlayerDownloaderImpl
  implements ISPlayerDownloader
{
  private static final String TAG = SPlayerDownloaderImpl.class.getSimpleName();
  private ITPDownloadProxy mTPDownloadProxy;
  
  public SPlayerDownloaderImpl(Context paramContext, int paramInt)
  {
    Utils.initDataTransportDataFolder(Utils.getDownloadProxyServiceType(paramInt));
    paramContext = TPProxyGlobalManager.getInstance().getPlayerProxy(Utils.getDownloadProxyServiceType(paramInt));
    if ((paramContext != null) && (paramContext.getDownloadProxy() != null)) {
      this.mTPDownloadProxy = paramContext.getDownloadProxy();
    }
  }
  
  private int getDlType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 301: 
      return 1;
    }
    return 10;
  }
  
  public int startOfflineDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, ISPlayerDownloader.Listener paramListener)
  {
    if (this.mTPDownloadProxy == null)
    {
      LogUtil.e(TAG, "error, mTPDownloadProxy == null, return");
      return 0;
    }
    TPDownloadParamData localTPDownloadParamData = new TPDownloadParamData();
    localTPDownloadParamData.setUrl(paramSuperPlayerVideoInfo.getPlayUrl());
    localTPDownloadParamData.setSavePath(paramSuperPlayerVideoInfo.getLocalSavePath());
    localTPDownloadParamData.setDownloadFileID(Utils.calculateFileIDForVideoInfo(paramSuperPlayerVideoInfo));
    localTPDownloadParamData.setUrlHostList(paramSuperPlayerVideoInfo.getUrlHostList());
    localTPDownloadParamData.setDlType(getDlType(paramSuperPlayerVideoInfo.getFormat()));
    if (paramSuperPlayerVideoInfo.getCookie() != null) {
      localTPDownloadParamData.setUrlCookieList(paramSuperPlayerVideoInfo.getCookie());
    }
    int i = this.mTPDownloadProxy.startOfflineDownload(Utils.calculateFileIDForVideoInfo(paramSuperPlayerVideoInfo), TPProxyUtils.convertProxyDownloadParams(null, localTPDownloadParamData), new SPlayerDownloaderImpl.1(this, paramListener));
    this.mTPDownloadProxy.startTask(i);
    return i;
  }
  
  public void stopOfflineDownload(int paramInt)
  {
    if (this.mTPDownloadProxy != null) {
      this.mTPDownloadProxy.stopOfflineDownload(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */