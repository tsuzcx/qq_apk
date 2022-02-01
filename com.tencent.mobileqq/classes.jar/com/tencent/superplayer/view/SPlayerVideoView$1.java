package com.tencent.superplayer.view;

import com.tencent.superplayer.utils.LogUtil;

class SPlayerVideoView$1
  implements ISPlayerViewBase.viewCreateCallBack
{
  SPlayerVideoView$1(SPlayerVideoView paramSPlayerVideoView) {}
  
  public void onViewChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if ((SPlayerVideoView.access$400(this.this$0) == paramInt1) && (SPlayerVideoView.access$500(this.this$0) == paramInt2)) {
      return;
    }
    LogUtil.i(SPlayerVideoView.access$000(), "blockCallback,onViewChanged, NO: " + SPlayerVideoView.access$200(this.this$0) + ", w: " + paramInt1 + ", h: " + paramInt2 + ", pw: " + this.this$0.getWidth() + ", ph: " + this.this$0.getHeight());
    SPlayerVideoView.access$402(this.this$0, paramInt1);
    SPlayerVideoView.access$502(this.this$0, paramInt2);
    SPlayerVideoView.access$302(this.this$0, paramObject);
  }
  
  public void onViewCreated(Object paramObject, int paramInt1, int paramInt2)
  {
    LogUtil.i(SPlayerVideoView.access$000(), "blockCallback , onViewCreated, is textrueview: " + SPlayerVideoView.access$100(this.this$0) + "NO: " + SPlayerVideoView.access$200(this.this$0) + ", w: " + paramInt1 + ", h: " + paramInt2 + ", pw: " + this.this$0.getWidth() + ", ph: " + this.this$0.getHeight());
    SPlayerVideoView.access$302(this.this$0, paramObject);
  }
  
  public boolean onViewDestroyed(Object paramObject)
  {
    LogUtil.i(SPlayerVideoView.access$000(), "blockCallback,surfaceDestroyed, NO: " + SPlayerVideoView.access$200(this.this$0));
    if ((SPlayerVideoView.access$600(this.this$0) instanceof SPlayerTextureView)) {
      SPlayerVideoView.access$702(this.this$0, ((SPlayerTextureView)SPlayerVideoView.access$600(this.this$0)).getSurfaceTexture());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerVideoView.1
 * JD-Core Version:    0.7.0.1
 */