package com.tencent.qq.effect.alphavideo.videoplayer.view;

import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener;

class PlayTextureView$3
  implements Runnable
{
  PlayTextureView$3(PlayTextureView paramPlayTextureView, int paramInt) {}
  
  public void run()
  {
    if (PlayTextureView.access$400(this.this$0) != null) {
      PlayTextureView.access$400(this.this$0).onError(this.val$errorCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.3
 * JD-Core Version:    0.7.0.1
 */