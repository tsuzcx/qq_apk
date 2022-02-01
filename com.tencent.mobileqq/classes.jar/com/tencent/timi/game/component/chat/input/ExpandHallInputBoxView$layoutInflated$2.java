package com.tencent.timi.game.component.chat.input;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ex.LayoutExKt;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ExpandHallInputBoxView$layoutInflated$2
  implements View.OnClickListener
{
  ExpandHallInputBoxView$layoutInflated$2(ExpandHallInputBoxView paramExpandHallInputBoxView) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.getCurrentState() == 3)
    {
      this.a.setState(1);
    }
    else
    {
      this.a.setState(3);
      Object localObject = this.a.getFuncLayout();
      if (localObject != null) {
        ((FrameLayout)localObject).removeAllViews();
      }
      localObject = TimiBaseInputView.a(this.a, null, 0, 3, null);
      FrameLayout localFrameLayout = this.a.getFuncLayout();
      if (localFrameLayout != null) {
        localFrameLayout.addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(LayoutExKt.b(this.a), LayoutExKt.b(this.a)));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.ExpandHallInputBoxView.layoutInflated.2
 * JD-Core Version:    0.7.0.1
 */