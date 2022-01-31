package com.tencent.mobileqq.widget;

import android.view.View;
import bcrx;
import bcsb;

public class VoteViewV2$1
  implements Runnable
{
  VoteViewV2$1(VoteViewV2 paramVoteViewV2) {}
  
  public void run()
  {
    if (VoteViewV2.a(this.this$0))
    {
      this.this$0.findViewById(2131368902).setVisibility(0);
      bcrx.a(this.this$0);
      this.this$0.findViewById(2131368902).setOnClickListener(new bcsb(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteViewV2.1
 * JD-Core Version:    0.7.0.1
 */