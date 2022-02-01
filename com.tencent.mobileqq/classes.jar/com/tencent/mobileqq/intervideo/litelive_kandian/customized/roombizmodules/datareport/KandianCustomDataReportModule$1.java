package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent;
import com.tencent.qphone.base.util.QLog;

class KandianCustomDataReportModule$1
  implements Observer<PlayerStateEvent>
{
  KandianCustomDataReportModule$1(KandianCustomDataReportModule paramKandianCustomDataReportModule) {}
  
  public void a(@Nullable PlayerStateEvent paramPlayerStateEvent)
  {
    if (paramPlayerStateEvent == null) {
      return;
    }
    switch (KandianCustomDataReportModule.2.a[paramPlayerStateEvent.playerState.ordinal()])
    {
    default: 
      return;
    case 1: 
      KandianCustomDataReportModule.a(this.a, System.currentTimeMillis() - KandianCustomDataReportModule.a(this.a));
      KandianCustomDataReportModule.a(this.a, KandianCustomDataReportModule.b(this.a));
      QLog.i("DataReportMgr", 1, "FIRST_FRAME_READY");
      return;
    }
    QLog.i("DataReportMgr", 1, "PLAYER_STATE_ERROR");
    KandianCustomDataReportModule.a(this.a, "3");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.KandianCustomDataReportModule.1
 * JD-Core Version:    0.7.0.1
 */