package com.tencent.timi.game.base;

import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TimiGameBaseFragment$showLoadingView$1
  implements Runnable
{
  TimiGameBaseFragment$showLoadingView$1(TimiGameBaseFragment paramTimiGameBaseFragment) {}
  
  public final void run()
  {
    TimiGamePageLoadingView localTimiGamePageLoadingView = TimiGameBaseFragment.a(this.this$0);
    if (localTimiGamePageLoadingView != null) {
      localTimiGamePageLoadingView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.base.TimiGameBaseFragment.showLoadingView.1
 * JD-Core Version:    0.7.0.1
 */