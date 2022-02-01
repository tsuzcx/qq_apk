package com.tencent.mobileqq.kandian.biz.ugc.selecttopic;

import android.view.View;
import android.widget.RelativeLayout;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SlidingUpDialog$slidingUp$1
  implements Runnable
{
  SlidingUpDialog$slidingUp$1(SlidingUpDialog paramSlidingUpDialog) {}
  
  public final void run()
  {
    SlidingUpDialog.a(this.this$0).setVisibility(0);
    SlidingUpDialog localSlidingUpDialog = this.this$0;
    SlidingUpDialog.a(localSlidingUpDialog, (View)SlidingUpDialog.a(localSlidingUpDialog), SlidingUpDialog.a(this.this$0).getHeight(), 0.0F, 200L, null, 16, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selecttopic.SlidingUpDialog.slidingUp.1
 * JD-Core Version:    0.7.0.1
 */