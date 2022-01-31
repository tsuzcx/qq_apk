package com.tencent.mobileqq.minigame.gpkg;

import android.os.Bundle;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;

final class GpkgManager$8
  extends CmdCallback.Stub
{
  GpkgManager$8(CmdCallback paramCmdCallback) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle.setClassLoader(DownloadResult.class.getClassLoader());
    this.val$cmdCallback.onCmdResult(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager.8
 * JD-Core Version:    0.7.0.1
 */