package com.tencent.timi.game.liveroom.impl.live.widget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.SystemUiFlagUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class HorBottomControllerView$1
  implements View.OnClickListener
{
  HorBottomControllerView$1(HorBottomControllerView paramHorBottomControllerView) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = HorBottomControllerView.b(this.a);
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getWindow();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.window");
      SystemUiFlagUtil.b(((Window)localObject).getDecorView());
      this.a.post((Runnable)new HorBottomControllerView.1..special..inlined.let.lambda.1(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.HorBottomControllerView.1
 * JD-Core Version:    0.7.0.1
 */