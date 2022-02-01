package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;
import com.tencent.qphone.base.util.QLog;

class VideoSprite$2
  implements Runnable
{
  VideoSprite$2(VideoSprite paramVideoSprite, String paramString, int paramInt) {}
  
  public void run()
  {
    if (((this.this$0.ae == null) || (!this.this$0.ae.equals(this.a)) || (!this.this$0.ah)) && (this.this$0.ac != null))
    {
      this.this$0.ac.stop();
      this.this$0.ac.reset();
      try
      {
        this.this$0.ac.setDataSource(this.a);
        this.this$0.ac.prepare();
        this.this$0.af = this.this$0.ac.getVideoWidth();
        this.this$0.ag = this.this$0.ac.getVideoHeight();
        this.this$0.ac.setOnSeekCompleteListener(new VideoSprite.2.1(this));
        this.this$0.ac.seekTo(this.b);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("playVideo Exception: ");
          localStringBuilder.append(QLog.getStackTraceString(localException));
          QLog.e("VideoSprite", 2, localStringBuilder.toString());
        }
        if (this.this$0.ad != null) {
          this.this$0.ad.a();
        }
      }
    }
    this.this$0.ae = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.2
 * JD-Core Version:    0.7.0.1
 */