package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.view.ViewGroup;

class ViolaVideoView$6
  implements Runnable
{
  ViolaVideoView$6(ViolaVideoView paramViolaVideoView) {}
  
  public void run()
  {
    if (ViolaVideoView.a(this.this$0).p())
    {
      ViolaVideoView.a(this.this$0, 2, null);
      return;
    }
    if (ViolaVideoView.b(this.this$0).getVisibility() == 0)
    {
      ViolaVideoView.a(this.this$0, 5, null);
      return;
    }
    ViolaVideoView.a(this.this$0, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.ViolaVideoView.6
 * JD-Core Version:    0.7.0.1
 */