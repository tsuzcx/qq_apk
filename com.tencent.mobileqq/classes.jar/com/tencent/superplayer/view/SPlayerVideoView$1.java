package com.tencent.superplayer.view;

import com.tencent.superplayer.utils.LogUtil;

class SPlayerVideoView$1
  implements ISPlayerViewBase.ViewCreateCallBack
{
  SPlayerVideoView$1(SPlayerVideoView paramSPlayerVideoView) {}
  
  public void onViewChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if ((SPlayerVideoView.access$300(this.this$0) == paramInt1) && (SPlayerVideoView.access$400(this.this$0) == paramInt2)) {
      return;
    }
    String str = SPlayerVideoView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("blockCallback, onViewChanged, w: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", h: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", pw: ");
    localStringBuilder.append(this.this$0.getWidth());
    localStringBuilder.append(", ph: ");
    localStringBuilder.append(this.this$0.getHeight());
    LogUtil.i(str, localStringBuilder.toString());
    SPlayerVideoView.access$302(this.this$0, paramInt1);
    SPlayerVideoView.access$402(this.this$0, paramInt2);
    SPlayerVideoView.access$200(this.this$0, paramObject);
  }
  
  public void onViewCreated(Object paramObject, int paramInt1, int paramInt2)
  {
    String str = SPlayerVideoView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("blockCallback , onViewCreated, is textrueview: ");
    localStringBuilder.append(SPlayerVideoView.access$100(this.this$0));
    localStringBuilder.append(", w: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", h: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", pw: ");
    localStringBuilder.append(this.this$0.getWidth());
    localStringBuilder.append(", ph: ");
    localStringBuilder.append(this.this$0.getHeight());
    LogUtil.i(str, localStringBuilder.toString());
    SPlayerVideoView.access$200(this.this$0, paramObject);
  }
  
  public boolean onViewDestroyed(Object paramObject)
  {
    LogUtil.i(SPlayerVideoView.access$000(this.this$0), "blockCallback, surfaceDestroyed");
    if ((SPlayerVideoView.access$500(this.this$0) instanceof SPlayerTextureView))
    {
      paramObject = this.this$0;
      SPlayerVideoView.access$602(paramObject, new SPlayerVideoView.SurfaceObject(paramObject));
      SPlayerVideoView.access$600(this.this$0).surfaceTexture = ((SPlayerTextureView)SPlayerVideoView.access$500(this.this$0)).getSurfaceTexture();
      SPlayerVideoView.access$600(this.this$0).surface = SPlayerVideoView.access$700(this.this$0).surface;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerVideoView.1
 * JD-Core Version:    0.7.0.1
 */