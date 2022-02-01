package com.tencent.mobileqq.kandian.glue.video.player;

import com.tencent.qphone.base.util.QLog;

public class ReadinjoyPlayerReporter$HWDecodeFailedAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
    }
    this.a.a.aa = true;
    if ((paramObject instanceof String)) {
      this.a.a.ab = ((String)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.HWDecodeFailedAction
 * JD-Core Version:    0.7.0.1
 */