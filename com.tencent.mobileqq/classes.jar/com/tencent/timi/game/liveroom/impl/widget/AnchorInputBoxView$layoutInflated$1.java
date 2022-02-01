package com.tencent.timi.game.liveroom.impl.widget;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.ex.LayoutExKt;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AnchorInputBoxView$layoutInflated$1
  implements View.OnClickListener
{
  AnchorInputBoxView$layoutInflated$1(AnchorInputBoxView paramAnchorInputBoxView) {}
  
  public final void onClick(View paramView)
  {
    if (AnchorInputBoxView.a(this.a) == 3)
    {
      this.a.h();
    }
    else
    {
      this.a.setState(3);
      Object localObject = AnchorInputBoxView.b(this.a);
      if (localObject != null) {
        ((FrameLayout)localObject).removeAllViews();
      }
      localObject = TimiBaseInputView.a(this.a, Integer.valueOf(Color.parseColor("#0B0820")), 0, 2, null);
      FrameLayout localFrameLayout = AnchorInputBoxView.b(this.a);
      if (localFrameLayout != null) {
        localFrameLayout.addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(LayoutExKt.b(this.a), LayoutExKt.b(this.a)));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AnchorInputBoxView.layoutInflated.1
 * JD-Core Version:    0.7.0.1
 */