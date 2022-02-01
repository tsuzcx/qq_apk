package com.tencent.tkd.topicsdk.widget;

import android.text.Editable;
import android.widget.EditText;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class LimitWordEditText$setSelectionEnd$1
  implements Runnable
{
  LimitWordEditText$setSelectionEnd$1(LimitWordEditText paramLimitWordEditText) {}
  
  public final void run()
  {
    this.this$0.getContentView().setSelection(this.this$0.getContentView().getText().length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.LimitWordEditText.setSelectionEnd.1
 * JD-Core Version:    0.7.0.1
 */