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
      Object localObject = this.this$0;
      PlayTextureView.access$2202((PlayTextureView)localObject, PlayTextureView.access$2300((PlayTextureView)localObject));
      int i = PlayTextureView.access$2000(this.this$0).createDecoder(PlayTextureView.access$1200(this.this$0), PlayTextureView.access$2100(this.this$0));
      localObject = PlayTextureView.access$000(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ret =");
      localStringBuilder.append(i);
      LogUtil.e((String)localObject, localStringBuilder.toString());
      localObject = PlayTextureView.access$000(this.this$0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("===============hardware decode create return = ");
      localStringBuilder.append(i);
      LogUtil.v((String)localObject, localStringBuilder.toString());
      if (i == 1)
      {
        PlayTextureView.access$2000(this.this$0).decode();
        return;
      }
      LogUtil.e(PlayTextureView.access$000(this.this$0), " 不开始解码。。。。 ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.6
 * JD-Core Version:    0.7.0.1
 */