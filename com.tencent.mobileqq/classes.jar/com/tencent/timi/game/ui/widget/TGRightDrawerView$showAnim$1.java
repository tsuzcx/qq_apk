package com.tencent.timi.game.ui.widget;

import android.widget.FrameLayout;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TGRightDrawerView$showAnim$1
  implements Runnable
{
  TGRightDrawerView$showAnim$1(TGRightDrawerView paramTGRightDrawerView) {}
  
  public final void run()
  {
    Object localObject = (FrameLayout)this.this$0.a(2131431334);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentRootView");
    int i = ((FrameLayout)localObject).getWidth();
    localObject = (FrameLayout)this.this$0.a(2131431334);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentRootView");
    ((FrameLayout)localObject).setTranslationX(i);
    localObject = (FrameLayout)this.this$0.a(2131431334);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentRootView");
    ((FrameLayout)localObject).setVisibility(0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showAnim contentRootViewWidth=");
    ((StringBuilder)localObject).append(i);
    Logger.a("TGRightDrawerView", ((StringBuilder)localObject).toString());
    this.this$0.post((Runnable)new TGRightDrawerView.showAnim.1.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.TGRightDrawerView.showAnim.1
 * JD-Core Version:    0.7.0.1
 */