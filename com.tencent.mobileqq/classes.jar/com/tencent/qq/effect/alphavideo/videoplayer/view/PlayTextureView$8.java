package com.tencent.qq.effect.alphavideo.videoplayer.view;

import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener;

class PlayTextureView$8
  implements Runnable
{
  PlayTextureView$8(PlayTextureView paramPlayTextureView) {}
  
  public void run()
  {
    if (PlayTextureView.access$400(this.this$0) != null) {
      PlayTextureView.access$400(this.this$0).onPlayAtTime(PlayTextureView.access$1000(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.8
 * JD-Core Version:    0.7.0.1
 */