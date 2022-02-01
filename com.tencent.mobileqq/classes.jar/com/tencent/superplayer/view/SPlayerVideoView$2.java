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
    LogUtil.i(SPlayerVideoView.access$000(this.this$0), "onViewChanged, NO: , w: " + paramInt1 + ", h: " + paramInt2 + ", pw: " + this.this$0.getWidth() + ", ph: " + this.this$0.getHeight());
    SPlayerVideoView.access$302(this.this$0, paramInt1);
    SPlayerVideoView.access$402(this.this$0, paramInt2);
    SPlayerVideoView.access$200(this.this$0, paramObject);
    SPlayerVideoView.access$1000(this.this$0, paramObject, paramInt1, paramInt2);
  }
  
  public void onViewCreated(Object paramObject, int paramInt1, int paramInt2)
  {
    SPlayerVideoView.access$802(this.this$0, true);
    LogUtil.i(SPlayerVideoView.access$000(this.this$0), "onViewCreated, is textrueview: " + SPlayerVideoView.access$100(this.this$0) + ", w: " + paramInt1 + ", h: " + paramInt2 + ", pw: " + this.this$0.getWidth() + ", ph: " + this.this$0.getHeight());
    SPlayerVideoView.access$200(this.this$0, paramObject);
    SPlayerVideoView.access$900(this.this$0, paramObject);
  }
  
  public boolean onViewDestroyed(Object paramObject)
  {
    boolean bool = false;
    LogUtil.i(SPlayerVideoView.access$000(this.this$0), "surfaceDestroyed");
    SPlayerVideoView.access$802(this.this$0, false);
    SPlayerVideoView.access$602(this.this$0, null);
    SPlayerVideoView.access$1100(this.this$0, paramObject);
    if (Build.VERSION.SDK_INT > 19) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerVideoView.2
 * JD-Core Version:    0.7.0.1
 */