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
      this.this$0.findViewById(2131436857).setVisibility(0);
      Vote2RotateAnimation.a(this.this$0);
      this.this$0.findViewById(2131436857).setOnClickListener(new VoteViewV2.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteViewV2.1
 * JD-Core Version:    0.7.0.1
 */