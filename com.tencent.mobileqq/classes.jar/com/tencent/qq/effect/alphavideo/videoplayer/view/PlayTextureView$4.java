package com.tencent.qq.effect.alphavideo.videoplayer.view;

import android.os.Handler;
import com.tencent.qq.effect.utils.LogUtil;

class PlayTextureView$4
  implements Runnable
{
  PlayTextureView$4(PlayTextureView paramPlayTextureView) {}
  
  public void run()
  {
    PlayTextureView.access$1500(this.this$0);
    PlayTextureView.access$500(this.this$0).post(new PlayTextureView.4.1(this));
    long l = System.currentTimeMillis();
    for (;;)
    {
      if (this.this$0.getVisibility() != 8) {
        LogUtil.v(PlayTextureView.access$000(this.this$0), "==============PlayView wait set GONE");
      }
      try
      {
        Thread.sleep(50L);
        if (System.currentTimeMillis() - l <= 3000L) {
          continue;
        }
        LogUtil.v(PlayTextureView.access$000(this.this$0), "==============PlayView set GONE time out");
        LogUtil.v(PlayTextureView.access$000(this.this$0), "==============PlayView set GONE over");
        PlayTextureView.access$1602(this.this$0, false);
        PlayTextureView.access$1702(this.this$0, false);
        if (PlayTextureView.access$1800(this.this$0)) {
          PlayTextureView.access$500(this.this$0).post(new PlayTextureView.4.2(this));
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.4
 * JD-Core Version:    0.7.0.1
 */