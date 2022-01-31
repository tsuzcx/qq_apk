package com.tencent.qq.effect.alphavideo.videoplayer.view;

import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener;
import com.tencent.qq.effect.utils.LogUtil;

class PlayTextureView$4$1
  implements Runnable
{
  PlayTextureView$4$1(PlayTextureView.4 param4) {}
  
  public void run()
  {
    LogUtil.v(PlayTextureView.access$000(this.this$1.this$0), "==============PlayView set gone");
    this.this$1.this$0.setVisibility(8);
    if (PlayTextureView.access$400(this.this$1.this$0) != null) {
      PlayTextureView.access$400(this.this$1.this$0).onEnd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.4.1
 * JD-Core Version:    0.7.0.1
 */