package com.tencent.tkd.topicsdk.widget.dialog;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "event", "Landroid/view/KeyEvent;", "onEditorAction", "com/tencent/tkd/topicsdk/widget/dialog/SimpleMessageDialog$1$2"}, k=3, mv={1, 1, 16})
final class SimpleMessageDialog$$special$$inlined$with$lambda$2
  implements TextView.OnEditorActionListener
{
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    paramInt = 0;
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66))
    {
      paramTextView = SimpleMessageDialog.a(this.a).getText();
      Intrinsics.checkExpressionValueIsNotNull(paramTextView, "contentView.text");
      if (StringsKt.trim((CharSequence)paramTextView).length() > 0) {
        paramInt = 1;
      }
      if (paramInt != 0)
      {
        SimpleMessageDialog.c(this.a).callOnClick();
        return true;
      }
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.SimpleMessageDialog..special..inlined.with.lambda.2
 * JD-Core Version:    0.7.0.1
 */