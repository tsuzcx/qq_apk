package com.tencent.timi.game.smoba.impl.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class SmobaAccountSelectView$Adapter$onBindViewHolder$1
  implements View.OnClickListener
{
  SmobaAccountSelectView$Adapter$onBindViewHolder$1(SmobaAccountSelectView.Adapter paramAdapter, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    SmobaAccountSelectView.Adapter.a(this.a).clear();
    int j = this.a.getItemCount();
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = SmobaAccountSelectView.Adapter.a(this.a);
      boolean bool;
      if (i == this.b) {
        bool = true;
      } else {
        bool = false;
      }
      localArrayList.add(Boolean.valueOf(bool));
      i += 1;
    }
    SmobaAccountSelectView.Adapter.a(this.a, this.b);
    this.a.notifyDataSetChanged();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.widget.SmobaAccountSelectView.Adapter.onBindViewHolder.1
 * JD-Core Version:    0.7.0.1
 */