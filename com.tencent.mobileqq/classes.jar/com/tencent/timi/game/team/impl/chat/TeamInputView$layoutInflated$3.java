package com.tencent.timi.game.team.impl.chat;

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
final class TeamInputView$layoutInflated$3
  implements View.OnClickListener
{
  TeamInputView$layoutInflated$3(TeamInputView paramTeamInputView) {}
  
  public final void onClick(View paramView)
  {
    if (TeamInputView.d(this.a) == 3)
    {
      this.a.setState(1);
    }
    else
    {
      this.a.setState(3);
      Object localObject = TeamInputView.e(this.a);
      if (localObject != null) {
        ((FrameLayout)localObject).removeAllViews();
      }
      localObject = TimiBaseInputView.a(this.a, null, 0, 3, null);
      FrameLayout localFrameLayout = TeamInputView.e(this.a);
      if (localFrameLayout != null) {
        localFrameLayout.addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(LayoutExKt.b(this.a), LayoutExKt.b(this.a)));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamInputView.layoutInflated.3
 * JD-Core Version:    0.7.0.1
 */