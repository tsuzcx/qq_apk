package com.tencent.timi.game.component.chat.input;

import android.widget.FrameLayout;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TimiBaseInputView$setState$2
  implements Runnable
{
  TimiBaseInputView$setState$2(TimiBaseInputView paramTimiBaseInputView) {}
  
  public final void run()
  {
    FrameLayout localFrameLayout = this.this$0.getFuncLayout();
    if (localFrameLayout != null) {
      localFrameLayout.removeAllViews();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.TimiBaseInputView.setState.2
 * JD-Core Version:    0.7.0.1
 */