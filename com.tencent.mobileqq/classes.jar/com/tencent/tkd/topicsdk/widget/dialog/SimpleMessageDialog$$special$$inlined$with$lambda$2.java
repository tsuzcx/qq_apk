package com.tencent.tkd.topicsdk.widget.dialog;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "event", "Landroid/view/KeyEvent;", "onEditorAction", "com/tencent/tkd/topicsdk/widget/dialog/SimpleMessageDialog$1$2"}, k=3, mv={1, 1, 16})
final class SimpleMessageDialog$$special$$inlined$with$lambda$2
  implements TextView.OnEditorActionListener
{
  SimpleMessageDialog$$special$$inlined$with$lambda$2(SimpleMessageDialog paramSimpleMessageDialog) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66))
    {
      SimpleMessageDialog.b(this.a).callOnClick();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.SimpleMessageDialog..special..inlined.with.lambda.2
 * JD-Core Version:    0.7.0.1
 */