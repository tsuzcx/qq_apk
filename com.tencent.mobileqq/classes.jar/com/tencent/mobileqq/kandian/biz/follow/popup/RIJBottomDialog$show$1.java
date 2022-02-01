package com.tencent.mobileqq.kandian.biz.follow.popup;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJBottomDialog$show$1
  implements Runnable
{
  RIJBottomDialog$show$1(RIJBottomDialog paramRIJBottomDialog) {}
  
  public final void run()
  {
    View localView = this.this$0.a();
    if (localView != null) {
      localView.setVisibility(0);
    }
    RIJBottomDialog.a(this.this$0, true);
    RIJBottomDialog.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.popup.RIJBottomDialog.show.1
 * JD-Core Version:    0.7.0.1
 */