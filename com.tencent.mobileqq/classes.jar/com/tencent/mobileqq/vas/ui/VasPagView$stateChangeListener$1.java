package com.tencent.mobileqq.vas.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k=3, mv={1, 1, 16})
final class VasPagView$stateChangeListener$1
  extends Lambda
  implements Function1<View, Unit>
{
  public static final 1 INSTANCE = new 1();
  
  VasPagView$stateChangeListener$1()
  {
    super(1);
  }
  
  public final void invoke(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "it");
    if ((paramView instanceof PAGView))
    {
      paramView = ((PAGView)paramView).getLayoutParams();
      paramView.width = -1;
      paramView.height = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VasPagView.stateChangeListener.1
 * JD-Core Version:    0.7.0.1
 */