package com.tencent.timi.game.ex;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k=3, mv={1, 1, 16})
final class ViewExKt$setOnFocusLoseListener$1
  implements View.OnFocusChangeListener
{
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Function1 localFunction1 = this.a;
      Intrinsics.checkExpressionValueIsNotNull(paramView, "v");
      localFunction1.invoke(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ex.ViewExKt.setOnFocusLoseListener.1
 * JD-Core Version:    0.7.0.1
 */