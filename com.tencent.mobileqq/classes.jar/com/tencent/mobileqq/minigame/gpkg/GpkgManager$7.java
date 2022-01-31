package com.tencent.mobileqq.minigame.gpkg;

import android.os.Bundle;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;

final class GpkgManager$7
  extends CmdCallback.Stub
{
  GpkgManager$7(MiniGamePkg paramMiniGamePkg, String paramString1, String paramString2, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("key_download_retcode");
    String str = paramBundle.getString("key_download_retstring");
    GpkgManager.access$200(paramBoolean, i, paramBundle.getLong("key_download_progress_size", 0L), paramBundle.getFloat("key_download_process_percent", 0.0F), str, (DownloadResult)paramBundle.getParcelable("key_download_result_object"), this.val$miniGamePkg, this.val$savePath, this.val$subRoot, this.val$listener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager.7
 * JD-Core Version:    0.7.0.1
 */