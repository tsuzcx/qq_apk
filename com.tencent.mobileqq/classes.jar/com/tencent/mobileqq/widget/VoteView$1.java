package com.tencent.mobileqq.widget;

import android.view.View;

class VoteView$1
  implements Runnable
{
  VoteView$1(VoteView paramVoteView) {}
  
  public void run()
  {
    if (VoteView.a(this.this$0))
    {
      VoteRotateAnimation.a(this.this$0);
      this.this$0.findViewById(2131369739).setOnClickListener(new VoteView.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteView.1
 * JD-Core Version:    0.7.0.1
 */