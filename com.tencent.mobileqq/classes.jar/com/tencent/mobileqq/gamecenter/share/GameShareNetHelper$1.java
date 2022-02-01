package com.tencent.mobileqq.gamecenter.share;

import android.os.Bundle;
import com.tencent.mobileqq.gamecenter.protocol.ReportTypeRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class GameShareNetHelper$1
  implements BusinessObserver
{
  GameShareNetHelper$1(GameShareNetHelper paramGameShareNetHelper) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (ReportTypeRsp)paramBundle.getSerializable("rsp");
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.NetHelper", 2, "ReportTypeRsp reportObserver:" + paramBoolean + "|" + paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareNetHelper.1
 * JD-Core Version:    0.7.0.1
 */