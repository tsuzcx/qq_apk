package com.tencent.mobileqq.qqlive.view;

import android.view.View;

class TPPlayerVideoView$2
  implements Runnable
{
  TPPlayerVideoView$2(TPPlayerVideoView paramTPPlayerVideoView) {}
  
  public void run()
  {
    if (TPPlayerVideoView.c(this.this$0))
    {
      TPPlayerVideoView.a(this.this$0, null);
    }
    else
    {
      if (TPPlayerVideoView.d(this.this$0) != null)
      {
        TPPlayerVideoView localTPPlayerVideoView = this.this$0;
        localTPPlayerVideoView.removeView((View)TPPlayerVideoView.d(localTPPlayerVideoView));
      }
      TPPlayerVideoView.a(this.this$0, null);
    }
    TPPlayerVideoView.e(this.this$0).setOpaqueInfo(true);
    ((View)TPPlayerVideoView.e(this.this$0)).requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.view.TPPlayerVideoView.2
 * JD-Core Version:    0.7.0.1
 */