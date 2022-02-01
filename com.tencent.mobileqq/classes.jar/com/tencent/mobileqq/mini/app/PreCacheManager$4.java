package com.tencent.mobileqq.mini.app;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.util.ParcelableUtil;
import com.tencent.qphone.base.util.QLog;

class PreCacheManager$4
  implements Downloader.DownloadListener
{
  PreCacheManager$4(PreCacheManager paramPreCacheManager, String paramString1, PreCacheManager.OnCacheListener paramOnCacheListener, PreCacheManager.PreCacheDescData paramPreCacheDescData, String paramString2, MiniAppConfig paramMiniAppConfig, String paramString3) {}
  
  public void onDownloadCanceled(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.val$logPrefix);
    localStringBuilder.append(" fetch PreCache url canceled! url=");
    localStringBuilder.append(paramString);
    QLog.i("miniapp-start_PreCacheManager", 1, localStringBuilder.toString());
    paramString = this.val$listener;
    if (paramString != null) {
      paramString.onCacheUpdated(false, false);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append(this.val$logPrefix);
    paramDownloadResult.append(" fetch PreCache url failed! url=");
    paramDownloadResult.append(paramString);
    QLog.i("miniapp-start_PreCacheManager", 1, paramDownloadResult.toString());
    paramString = this.val$listener;
    if (paramString != null) {
      paramString.onCacheUpdated(false, false);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.val$logPrefix);
      localStringBuilder.append(" fetch PreCache succful. url");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" length=");
      localStringBuilder.append(paramDownloadResult.getContent().length);
      QLog.i("miniapp-start_PreCacheManager", 1, localStringBuilder.toString());
      if (paramDownloadResult.getContent().length <= PreCacheManager.access$200(this.this$0))
      {
        this.val$cacheInfo.timeStamp = System.currentTimeMillis();
        this.val$cacheInfo.filePath = this.val$tmpFilePath;
        MiniAppFileManager.getInstance();
        paramString = this.val$miniAppConfig.config.appId;
        paramDownloadResult = this.val$cacheType;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.val$cacheInfo.getCacheKey(this.val$cacheType));
        localStringBuilder.append("_index");
        paramString = MiniAppFileManager.getPreCacheFilePath(paramString, paramDownloadResult, localStringBuilder.toString());
        ParcelableUtil.writeParcelableToFile(this.val$cacheInfo, paramString);
        paramDownloadResult = new StringBuilder();
        paramDownloadResult.append(this.val$logPrefix);
        paramDownloadResult.append(" save PreCache info. index=");
        paramDownloadResult.append(paramString);
        paramDownloadResult.append(" content=");
        paramDownloadResult.append(this.val$tmpFilePath);
        QLog.i("miniapp-start_PreCacheManager", 1, paramDownloadResult.toString());
        if (this.val$listener != null)
        {
          this.val$listener.onCacheUpdated(true, true);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append(this.val$logPrefix);
      paramDownloadResult.append(" fetch PreCache exception!");
      QLog.i("miniapp-start_PreCacheManager", 1, paramDownloadResult.toString(), paramString);
      paramString = this.val$listener;
      if (paramString != null) {
        paramString.onCacheUpdated(false, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager.4
 * JD-Core Version:    0.7.0.1
 */