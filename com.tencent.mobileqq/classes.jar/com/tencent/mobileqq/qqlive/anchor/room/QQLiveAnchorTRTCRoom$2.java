package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.anchor.report.QQLiveAnchorTechReport;
import com.tencent.mobileqq.qqlive.data.datareport.StatisticData;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.StatisticDataListener;

class QQLiveAnchorTRTCRoom$2
  implements StatisticDataListener
{
  QQLiveAnchorTRTCRoom$2(QQLiveAnchorTRTCRoom paramQQLiveAnchorTRTCRoom) {}
  
  public void a(StatisticData paramStatisticData)
  {
    if (this.a.k != null) {
      this.a.k.a(paramStatisticData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorTRTCRoom.2
 * JD-Core Version:    0.7.0.1
 */