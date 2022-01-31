package com.tencent.mobileqq.mini.reuse;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import org.json.JSONObject;

public class MiniappDownloadUtil
{
  private static final String TAG = "[mini] MiniappDownloadUtil";
  public static float gDownloadProgressStep = 0.2F;
  private static volatile MiniappDownloadUtil instance;
  private Downloader resumableDownloader;
  
  public MiniappDownloadUtil()
  {
    int i;
    if (this.resumableDownloader == null)
    {
      if (QDLog.getLog() == null) {
        QDLog.setLog(new MiniappDownloadUtil.1(this));
      }
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_use_download_optimize", 1) != 1) {
        break label143;
      }
      i = 1;
      if (i == 0) {
        break label148;
      }
      Config.setConfig(new MiniDownloadConfig());
      DownloaderFactory.getInstance(BaseApplicationImpl.getContext());
    }
    label143:
    label148:
    for (this.resumableDownloader = DownloaderFactory.createDownloader("mini_app_downloader");; this.resumableDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader())
    {
      this.resumableDownloader.enableResumeTransfer(true);
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_https_ipdirect_enable", 1) == 1) {
        bool = true;
      }
      this.resumableDownloader.setHttpsIpDirectEnable(bool);
      try
      {
        Object localObject = new QzoneIPStracyConfig();
        this.resumableDownloader.setDirectIPConfigStrategy((IPStrategy)localObject);
        localObject = new QzoneBackupConfig();
        this.resumableDownloader.setBackupIPConfigStrategy((IPStrategy)localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[mini] MiniappDownloadUtil", 1, "", localThrowable);
      }
      i = 0;
      break;
    }
  }
  
  public static MiniappDownloadUtil getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MiniappDownloadUtil();
      }
      return instance;
    }
    finally {}
  }
  
  public static void preLoadDownloader()
  {
    getInstance();
  }
  
  public void abort(String paramString)
  {
    this.resumableDownloader.abort(paramString, null);
  }
  
  public boolean download(String paramString1, String paramString2, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener, Downloader.DownloadMode paramDownloadMode, JSONObject paramJSONObject)
  {
    if (NetworkUtils.isNetworkUrl(paramString1))
    {
      paramDownloadListener = new MiniappDownloadUtil.ProgressResampleDownloadListener(paramDownloadListener, gDownloadProgressStep);
      paramString1 = new DownloadRequest(paramString1, new String[] { paramString2 }, false, paramDownloadListener);
      paramString1.mode = paramDownloadMode;
      paramString1.addParam("Accept-Encoding", "gzip, deflat");
      if (paramJSONObject != null)
      {
        paramString2 = paramJSONObject.keys();
        while (paramString2.hasNext())
        {
          paramDownloadListener = (String)paramString2.next();
          paramString1.addParam(paramDownloadListener, paramJSONObject.optString(paramDownloadListener));
        }
      }
      return this.resumableDownloader.download(paramString1, paramBoolean);
    }
    QLog.w("[mini] MiniappDownloadUtil", 1, "download unsupported url:" + paramString1 + ", callback fail");
    ThreadManager.excute(new MiniappDownloadUtil.3(this, paramDownloadListener, paramString1), 16, null, false);
    return false;
  }
  
  public boolean downloadApkg(MiniAppConfig paramMiniAppConfig, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, Downloader.DownloadListener paramDownloadListener, Downloader.DownloadMode paramDownloadMode, JSONObject paramJSONObject)
  {
    return download(paramString1, paramString2, paramBoolean2, new MiniappDownloadUtil.2(this, paramDownloadListener, paramBoolean1, paramMiniAppConfig), paramDownloadMode, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil
 * JD-Core Version:    0.7.0.1
 */