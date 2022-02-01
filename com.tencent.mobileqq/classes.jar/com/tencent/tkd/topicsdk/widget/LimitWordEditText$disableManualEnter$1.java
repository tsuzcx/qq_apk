package com.tencent.tkd.topicsdk.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"}, k=3, mv={1, 1, 16})
final class LimitWordEditText$disableManualEnter$1
  implements TextView.OnEditorActionListener
{
  LimitWordEditText$disableManualEnter$1(boolean paramBoolean) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.a) && (paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.LimitWordEditText.disableManualEnter.1
 * JD-Core Version:    0.7.0.1
 */