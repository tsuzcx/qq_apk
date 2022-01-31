package com.tencent.qq.effect.alphavideo.videoplayer.view;

import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener;

class PlayTextureView$1$1
  implements Runnable
{
  PlayTextureView$1$1(PlayTextureView.1 param1) {}
  
  public void run()
  {
    if (PlayTextureView.access$400(this.this$1.this$0) != null) {
      PlayTextureView.access$400(this.this$1.this$0).onVideoSize(PlayTextureView.access$100(this.this$1.this$0), PlayTextureView.access$300(this.this$1.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.1.1
 * JD-Core Version:    0.7.0.1
 */