package com.tencent.timi.game.liveroom.impl.view;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnchorTopAreaView$showCollapseHint$5
  implements Runnable
{
  AnchorTopAreaView$showCollapseHint$5(AnchorTopAreaView paramAnchorTopAreaView, View paramView, int paramInt) {}
  
  public final void run()
  {
    Object localObject = (RelativeLayout)this.a.findViewById(2131431338);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "hintView.contentView");
    localObject = ((RelativeLayout)localObject).getLayoutParams();
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.b;
      RelativeLayout localRelativeLayout = (RelativeLayout)this.a.findViewById(2131431338);
      Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "hintView.contentView");
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.this$0.post((Runnable)new AnchorTopAreaView.showCollapseHint.5.1(this));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorTopAreaView.showCollapseHint.5
 * JD-Core Version:    0.7.0.1
 */