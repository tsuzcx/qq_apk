package com.tencent.mobileqq.kandian.glue.video.player;

import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.qphone.base.util.QLog;

public class ReadinjoyPlayerReporter$DecoderBlockAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
    }
    paramObject = this.a.a;
    paramObject.W += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.DecoderBlockAction
 * JD-Core Version:    0.7.0.1
 */