package com.tencent.timi.game.component.chat.input;

import android.widget.EditText;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandHallInputBoxView$layoutInflated$1
  implements Runnable
{
  ExpandHallInputBoxView$layoutInflated$1(ExpandHallInputBoxView paramExpandHallInputBoxView) {}
  
  public final void run()
  {
    EditText localEditText = ExpandHallInputBoxView.g(this.this$0);
    if (localEditText != null) {
      localEditText.setEditableFactory(this.this$0.getEmojiEditableFactory());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.ExpandHallInputBoxView.layoutInflated.1
 * JD-Core Version:    0.7.0.1
 */