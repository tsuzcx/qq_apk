package com.tencent.qq.effect.alphavideo.videoplayer.view;

import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder;
import com.tencent.qq.effect.utils.LogUtil;

class PlayTextureView$6
  implements Runnable
{
  PlayTextureView$6(PlayTextureView paramPlayTextureView) {}
  
  public void run()
  {
    if ((PlayTextureView.access$1700(this.this$0) == true) && (PlayTextureView.access$2000(this.this$0) != null) && (PlayTextureView.access$1200(this.this$0) != null) && (PlayTextureView.access$2100(this.this$0) != null))
    {
      PlayTextureView.access$2202(this.this$0, PlayTextureView.access$2300(this.this$0));
      int i = PlayTextureView.access$2000(this.this$0).createDecoder(PlayTextureView.access$1200(this.this$0), PlayTextureView.access$2100(this.this$0));
      LogUtil.e(PlayTextureView.access$000(this.this$0), " ret =" + i);
      LogUtil.v(PlayTextureView.access$000(this.this$0), "===============hardware decode create return = " + i);
      if (i == 1) {
        PlayTextureView.access$2000(this.this$0).decode();
      }
    }
    else
    {
      return;
    }
    LogUtil.e(PlayTextureView.access$000(this.this$0), " 不开始解码。。。。 ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.6
 * JD-Core Version:    0.7.0.1
 */