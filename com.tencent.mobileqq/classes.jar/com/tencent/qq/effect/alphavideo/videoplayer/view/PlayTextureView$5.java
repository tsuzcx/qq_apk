package com.tencent.qq.effect.alphavideo.videoplayer.view;

import android.os.Handler;
import android.util.Log;

class PlayTextureView$5
  implements Runnable
{
  PlayTextureView$5(PlayTextureView paramPlayTextureView, int paramInt) {}
  
  public void run()
  {
    PlayTextureView.access$1500(this.this$0);
    PlayTextureView.access$1602(this.this$0, false);
    PlayTextureView.access$500(this.this$0).post(new PlayTextureView.5.1(this));
    PlayTextureView.access$1702(this.this$0, false);
    if (this.val$errorCode == -2) {
      Log.v(PlayTextureView.access$000(this.this$0), "  need switch software decode ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.5
 * JD-Core Version:    0.7.0.1
 */