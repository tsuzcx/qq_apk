package com.tencent.timi.game.gift.impl.timi;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TimiGiftPanelFragment$onSendGiftCancel$1
  implements Runnable
{
  TimiGiftPanelFragment$onSendGiftCancel$1(TimiGiftPanelFragment paramTimiGiftPanelFragment) {}
  
  public final void run()
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftPanelFragment.onSendGiftCancel.1
 * JD-Core Version:    0.7.0.1
 */