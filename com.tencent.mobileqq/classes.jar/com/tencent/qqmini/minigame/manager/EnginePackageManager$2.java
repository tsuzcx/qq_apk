package com.tencent.qqmini.minigame.manager;

import com.tencent.mobileqq.triton.model.Version;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.util.List;
import java.util.Map;

final class EnginePackageManager$2
  implements DownloaderProxy.DownloadListener
{
  EnginePackageManager$2(BaseLibInfo paramBaseLibInfo, Version paramVersion, String paramString) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "downloadLatestTritonEngine failed, from:" + this.val$tritonEngineInfo);
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 5, null, null, null, 1, "1", 0L, null);
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 下载成功, version:" + this.val$version + ", path:" + paramString + ", url:" + this.val$tritonEngineInfo.baseLibUrl);
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 5, "1");
    ThreadManager.executeOnDiskIOThreadPool(new EnginePackageManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.EnginePackageManager.2
 * JD-Core Version:    0.7.0.1
 */