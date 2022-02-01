package com.tencent.timi.game.liveroom.impl.widget;

import android.widget.EditText;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnchorInputBoxView$layoutInflated$2
  implements Runnable
{
  AnchorInputBoxView$layoutInflated$2(AnchorInputBoxView paramAnchorInputBoxView) {}
  
  public final void run()
  {
    EditText localEditText = AnchorInputBoxView.c(this.this$0);
    if (localEditText != null) {
      localEditText.setEditableFactory(AnchorInputBoxView.d(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AnchorInputBoxView.layoutInflated.2
 * JD-Core Version:    0.7.0.1
 */