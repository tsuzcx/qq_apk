package com.tencent.timi.game.expand.hall.impl.view;

import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandHallSmobaAuthView$hideAnim$1
  implements Runnable
{
  ExpandHallSmobaAuthView$hideAnim$1(ExpandHallSmobaAuthView paramExpandHallSmobaAuthView) {}
  
  public final void run()
  {
    LinearLayout localLinearLayout = (LinearLayout)this.this$0.a(2131431333);
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "contentRootLl");
    int i = localLinearLayout.getHeight();
    localLinearLayout = (LinearLayout)this.this$0.a(2131431333);
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "contentRootLl");
    localLinearLayout.setTranslationY(0.0F);
    localLinearLayout = (LinearLayout)this.this$0.a(2131431333);
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "contentRootLl");
    localLinearLayout.setVisibility(0);
    this.this$0.post((Runnable)new ExpandHallSmobaAuthView.hideAnim.1.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallSmobaAuthView.hideAnim.1
 * JD-Core Version:    0.7.0.1
 */