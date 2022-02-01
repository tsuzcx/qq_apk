package com.tencent.tkd.weibo.richEditText;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey"}, k=3, mv={1, 1, 16})
final class RichEditText$initKeyListener$1
  implements View.OnKeyListener
{
  RichEditText$initKeyListener$1(RichEditText paramRichEditText) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramView = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramKeyEvent, "event");
    return RichEditText.a(paramView, paramKeyEvent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.richEditText.RichEditText.initKeyListener.1
 * JD-Core Version:    0.7.0.1
 */