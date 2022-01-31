package com.tencent.mobileqq.richmedia.capture.view;

import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class GuideVideoView$1
  implements Runnable
{
  GuideVideoView$1(GuideVideoView paramGuideVideoView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onVideoPrepared");
    }
    this.this$0.a = true;
    if (this.this$0.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "has triggered start, now start");
      }
      GuideVideoView.a(this.this$0).setVisibility(8);
      GuideVideoView.a(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.GuideVideoView.1
 * JD-Core Version:    0.7.0.1
 */