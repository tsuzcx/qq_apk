package com.tencent.mobileqq.minigame.manager;

import NS_MINI_INTERFACE.INTERFACE.StReportExecuteRsp;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallback;
import com.tencent.qphone.base.util.QLog;

final class GameGrowthGuardianManager$3
  implements MiniAppSSOCmdHelper.MiniAppCmdCallback<INTERFACE.StReportExecuteRsp>
{
  public void onReceived(boolean paramBoolean, INTERFACE.StReportExecuteRsp paramStReportExecuteRsp)
  {
    QLog.d("GameGrowthGuardianManag", 1, "onReceived() called with: success = [" + paramBoolean + "], stReportExecuteRsp = [" + paramStReportExecuteRsp + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.3
 * JD-Core Version:    0.7.0.1
 */