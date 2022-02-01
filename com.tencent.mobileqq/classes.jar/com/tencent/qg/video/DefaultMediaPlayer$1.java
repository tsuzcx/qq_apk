package com.tencent.qg.video;

import android.graphics.SurfaceTexture;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qg.video.videodecoder.MediaDecoder.DecodeListener;

class DefaultMediaPlayer$1
  implements MediaDecoder.DecodeListener
{
  DefaultMediaPlayer$1(DefaultMediaPlayer paramDefaultMediaPlayer) {}
  
  public void a()
  {
    SLog.b("DefaultMediaPlayer", "decoder -> onDecodeStart");
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    SLog.d("DefaultMediaPlayer", "decoder -> onDecodeError :%d , %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
  }
  
  public void a(long paramLong)
  {
    if (DefaultMediaPlayer.a(this.a) == 0)
    {
      VideoPerformanceMonitor.a(this.a.hashCode(), "[Player] on video decode first frame");
      DefaultMediaPlayer.a(this.a, 1);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    DefaultMediaPlayer.a(this.a, paramSurfaceTexture);
  }
  
  public void b()
  {
    SLog.d("DefaultMediaPlayer", "decoder -> onDecodeFinish");
    DefaultMediaPlayer.a(this.a);
  }
  
  public void b(long paramLong)
  {
    SLog.d("DefaultMediaPlayer", "decoder -> onDecodeSeekTo :%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public void c()
  {
    SLog.d("DefaultMediaPlayer", "decoder -> onDecodeCancel");
    DefaultMediaPlayer.a(this.a);
  }
  
  public void d()
  {
    SLog.d("DefaultMediaPlayer", "decoder -> onDecodeRepeat");
    DefaultMediaPlayer.a(this.a);
    DefaultMediaPlayer.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.video.DefaultMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */