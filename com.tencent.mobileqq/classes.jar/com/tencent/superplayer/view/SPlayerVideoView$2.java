package com.tencent.superplayer.view;

import android.os.Build.VERSION;
import com.tencent.superplayer.utils.LogUtil;

class SPlayerVideoView$2
  implements ISPlayerViewBase.ViewCreateCallBack
{
  SPlayerVideoView$2(SPlayerVideoView paramSPlayerVideoView) {}
  
  public void onViewChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if ((SPlayerVideoView.access$300(this.this$0) == paramInt1) && (SPlayerVideoView.access$400(this.this$0) == paramInt2)) {
      return;
    }
    String str = SPlayerVideoView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onViewChanged, NO: , w: ");
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
    SPlayerVideoView.access$1000(this.this$0, paramObject, paramInt1, paramInt2);
  }
  
  public void onViewCreated(Object paramObject, int paramInt1, int paramInt2)
  {
    SPlayerVideoView.access$802(this.this$0, true);
    String str = SPlayerVideoView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onViewCreated, is textrueview: ");
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
    SPlayerVideoView.access$900(this.this$0, paramObject);
  }
  
  public boolean onViewDestroyed(Object paramObject)
  {
    LogUtil.i(SPlayerVideoView.access$000(this.this$0), "surfaceDestroyed");
    SPlayerVideoView localSPlayerVideoView = this.this$0;
    boolean bool = false;
    SPlayerVideoView.access$802(localSPlayerVideoView, false);
    SPlayerVideoView.access$602(this.this$0, null);
    SPlayerVideoView.access$1100(this.this$0, paramObject);
    if (Build.VERSION.SDK_INT > 19) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerVideoView.2
 * JD-Core Version:    0.7.0.1
 */