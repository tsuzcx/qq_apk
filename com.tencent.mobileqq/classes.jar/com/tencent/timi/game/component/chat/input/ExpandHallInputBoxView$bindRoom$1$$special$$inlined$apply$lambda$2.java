package com.tencent.timi.game.component.chat.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/timi/game/component/chat/input/ExpandHallInputBoxView$bindRoom$1$1$2"}, k=3, mv={1, 1, 16})
final class ExpandHallInputBoxView$bindRoom$1$$special$$inlined$apply$lambda$2
  implements View.OnClickListener
{
  ExpandHallInputBoxView$bindRoom$1$$special$$inlined$apply$lambda$2(ExpandHallInputBoxView.bindRoom.1 param1) {}
  
  public final void onClick(View paramView)
  {
    IReportService localIReportService = (IReportService)ServiceCenter.a(IReportService.class);
    if (paramView != null)
    {
      localIReportService.a("clck", (Object)paramView, (Map)new LinkedHashMap());
      ExpandHallInputBoxView.e(this.a.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.ExpandHallInputBoxView.bindRoom.1..special..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */