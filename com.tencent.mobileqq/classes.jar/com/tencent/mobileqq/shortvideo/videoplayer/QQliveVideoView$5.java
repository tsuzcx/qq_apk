package com.tencent.mobileqq.shortvideo.videoplayer;

import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class QQliveVideoView$5
  implements Runnable
{
  QQliveVideoView$5(QQliveVideoView paramQQliveVideoView) {}
  
  public void run()
  {
    if (QQliveVideoView.a(this.this$0) != null)
    {
      if (QQliveVideoView.a(this.this$0) != null) {
        QQliveVideoView.a(this.this$0).setVisibility(4);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.a(), 2, "onSeekComplete, mCoverImage.setVisibility(INVISIBLE)");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videoplayer.QQliveVideoView.5
 * JD-Core Version:    0.7.0.1
 */