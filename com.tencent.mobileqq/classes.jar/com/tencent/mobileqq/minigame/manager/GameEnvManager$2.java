package com.tencent.mobileqq.minigame.manager;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.model.Version;

final class GameEnvManager$2
  implements Downloader.DownloadListener
{
  GameEnvManager$2(BaseLibInfo paramBaseLibInfo, GameEnvManager.IDownloadListener paramIDownloadListener, Version paramVersion, String paramString) {}
  
  public void onDownloadCanceled(String paramString)
  {
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "downloadLatestTritonEngine canceled, from:" + this.val$tritonEngineInfo);
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "downloadLatestTritonEngine failed, from:" + this.val$tritonEngineInfo);
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 5, null, null, null, 1, "1", 0L, null);
    if (this.val$callback != null) {
      this.val$callback.onDownloadResult(-4, "下载失败");
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 下载成功, version:" + this.val$version + ", path:" + paramString + ", url:" + this.val$tritonEngineInfo.baseLibUrl);
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 5, "1");
    ThreadManagerV2.executeOnFileThread(new GameEnvManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameEnvManager.2
 * JD-Core Version:    0.7.0.1
 */