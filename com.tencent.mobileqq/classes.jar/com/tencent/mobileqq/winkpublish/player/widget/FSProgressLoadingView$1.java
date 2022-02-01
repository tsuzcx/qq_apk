package com.tencent.mobileqq.winkpublish.player.widget;

import android.animation.AnimatorSet;

class FSProgressLoadingView$1
  implements Runnable
{
  FSProgressLoadingView$1(FSProgressLoadingView paramFSProgressLoadingView) {}
  
  public void run()
  {
    if (FSProgressLoadingView.a(this.this$0) != null)
    {
      FSProgressLoadingView.a(this.this$0).removeAllListeners();
      if (FSProgressLoadingView.b(this.this$0) != null) {
        FSProgressLoadingView.a(this.this$0).addListener(FSProgressLoadingView.b(this.this$0));
      }
      FSProgressLoadingView.a(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.widget.FSProgressLoadingView.1
 * JD-Core Version:    0.7.0.1
 */