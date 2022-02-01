package com.tencent.qq.effect.impls;

import android.media.MediaPlayer;
import java.io.File;

class QEffectVideoView$PlayerVideo
  extends Thread
{
  private QEffectVideoView$PlayerVideo(QEffectVideoView paramQEffectVideoView) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(QEffectVideoView.access$100(this.this$0));
      if (!localFile.exists()) {
        return;
      }
      QEffectVideoView.access$202(this.this$0, new MediaPlayer());
      QEffectVideoView.access$200(this.this$0).setDataSource(localFile.getAbsolutePath());
      QEffectVideoView.access$200(this.this$0).setSurface(QEffectVideoView.access$300(this.this$0));
      QEffectVideoView.access$200(this.this$0).setAudioStreamType(3);
      QEffectVideoView.access$200(this.this$0).setOnPreparedListener(new QEffectVideoView.PlayerVideo.1(this));
      QEffectVideoView.access$200(this.this$0).setLooping(true);
      QEffectVideoView.access$200(this.this$0).prepare();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qq.effect.impls.QEffectVideoView.PlayerVideo
 * JD-Core Version:    0.7.0.1
 */