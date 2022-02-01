package com.tencent.mobileqq.widget;

import android.view.View;

class VoteViewV2$1
  implements Runnable
{
  VoteViewV2$1(VoteViewV2 paramVoteViewV2) {}
  
  public void run()
  {
    if (VoteViewV2.a(this.this$0))
    {
      this.this$0.findViewById(2131370060).setVisibility(0);
      Vote2RotateAnimation.a(this.this$0);
      this.this$0.findViewById(2131370060).setOnClickListener(new VoteViewV2.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteViewV2.1
 * JD-Core Version:    0.7.0.1
 */