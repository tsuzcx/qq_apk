package com.tencent.mobileqq.wxmini.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.module.base.QDLog;
import common.config.service.QzoneConfig;

public class WxMiniAppDownloadUtil
{
  public static float a = 0.2F;
  private static volatile WxMiniAppDownloadUtil b;
  private Downloader c;
  
  public WxMiniAppDownloadUtil()
  {
    if (this.c == null)
    {
      if (QDLog.getLog() == null) {
        QDLog.setLog(new WxMiniAppDownloadUtil.1(this));
      }
      QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
      boolean bool = true;
      localQzoneConfig.getConfig("qqminiapp", "mini_app_use_download_optimize", 1);
      this.c = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
      this.c.enableResumeTransfer(true);
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_https_ipdirect_enable", 1) != 1) {
        bool = false;
      }
      this.c.setHttpsIpDirectEnable(bool);
    }
  }
  
  public static WxMiniAppDownloadUtil a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new WxMiniAppDownloadUtil();
        }
      }
      finally {}
    }
    return b;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, Downloader.DownloadListener paramDownloadListener)
  {
    paramString1 = new DownloadRequest(paramString1, new String[] { paramString2 }, false, paramDownloadListener);
    paramString1.mode = Downloader.DownloadMode.StrictMode;
    paramString1.onResponseDataListener = null;
    paramString1.rangeNumber = -1;
    paramString1.progressCallbackStep = a;
    paramString1.addParam("Accept-Encoding", "gzip, deflate");
    paramString1.setFileSizeForRangeMode(0L);
    return this.c.download(paramString1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.WxMiniAppDownloadUtil
 * JD-Core Version:    0.7.0.1
 */