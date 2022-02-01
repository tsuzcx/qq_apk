package com.tencent.rtmp;

import android.os.Handler;
import com.tencent.liteav.audio.TXCAudioEngine;

class TXLivePusherImpl$a
  implements Runnable
{
  private int b = 300;
  
  private TXLivePusherImpl$a(TXLivePusherImpl paramTXLivePusherImpl) {}
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void run()
  {
    if (this.a.l())
    {
      int i = TXCAudioEngine.getInstance().getSoftwareCaptureVolumeLevel();
      if (TXLivePusherImpl.e(this.a) != null) {
        TXLivePusherImpl.e(this.a).onAudioVolumeEvaluationNotify(i);
      }
    }
    if ((TXLivePusherImpl.f(this.a) != null) && (this.b > 0)) {
      TXLivePusherImpl.f(this.a).postDelayed(TXLivePusherImpl.g(this.a), this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl.a
 * JD-Core Version:    0.7.0.1
 */