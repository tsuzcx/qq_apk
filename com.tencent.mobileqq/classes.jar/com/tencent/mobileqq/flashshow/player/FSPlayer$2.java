package com.tencent.mobileqq.flashshow.player;

import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.Collections;

class FSPlayer$2
  implements FSQUICStatus.QUICListener
{
  FSPlayer$2(FSPlayer paramFSPlayer, String paramString) {}
  
  public void a(FSQUICStatus paramFSQUICStatus)
  {
    FSPlayer.a(this.b, "video_quic_to_http", Collections.singletonList(QCircleReportHelper.newEntry("video_url", this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.FSPlayer.2
 * JD-Core Version:    0.7.0.1
 */