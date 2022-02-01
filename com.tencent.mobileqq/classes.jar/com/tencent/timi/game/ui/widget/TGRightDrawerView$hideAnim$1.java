package com.tencent.timi.game.ui.widget;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TGRightDrawerView$hideAnim$1
  implements Runnable
{
  TGRightDrawerView$hideAnim$1(TGRightDrawerView paramTGRightDrawerView) {}
  
  public final void run()
  {
    FrameLayout localFrameLayout = (FrameLayout)this.this$0.a(2131431334);
    Intrinsics.checkExpressionValueIsNotNull(localFrameLayout, "contentRootView");
    int i = localFrameLayout.getWidth();
    localFrameLayout = (FrameLayout)this.this$0.a(2131431334);
    Intrinsics.checkExpressionValueIsNotNull(localFrameLayout, "contentRootView");
    localFrameLayout.setTranslationX(0.0F);
    localFrameLayout = (FrameLayout)this.this$0.a(2131431334);
    Intrinsics.checkExpressionValueIsNotNull(localFrameLayout, "contentRootView");
    localFrameLayout.setVisibility(0);
    this.this$0.post((Runnable)new TGRightDrawerView.hideAnim.1.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.TGRightDrawerView.hideAnim.1
 * JD-Core Version:    0.7.0.1
 */