package com.tencent.mobileqq.ecshop.view.controller;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.TabConfBean;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TabLayoutController$setOnClickListener$1
  implements View.OnClickListener
{
  TabLayoutController$setOnClickListener$1(TabLayoutController paramTabLayoutController, TabItemController paramTabItemController, EcshopConfBean.TabConfBean paramTabConfBean) {}
  
  public final void onClick(View paramView)
  {
    if (this.c.b != TabLayoutController.a(this.a))
    {
      this.a.a(this.c.b);
      this.b.b();
      ReportUtil.a("gouwu.tab.click", String.valueOf(this.c.b), String.valueOf(NetConnInfoCenter.getServerTimeMillis()), "", TabLayoutController.a(this.a));
      ReportUtil.b("gouwu_tab_click", String.valueOf(this.c.b), String.valueOf(NetConnInfoCenter.getServerTimeMillis()), "", TabLayoutController.a(this.a));
      TabLayoutController.a(this.a, this.c);
      Object localObject = (Function1)TabLayoutController.b(this.a).get(Integer.valueOf(TabLayoutController.a(this.a)));
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(Integer.valueOf(this.c.b));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TabLayoutController.setOnClickListener.1
 * JD-Core Version:    0.7.0.1
 */