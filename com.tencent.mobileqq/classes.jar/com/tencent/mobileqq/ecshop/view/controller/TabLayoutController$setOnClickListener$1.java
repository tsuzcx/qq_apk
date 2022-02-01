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
    if (this.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean.a != TabLayoutController.a(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController))
    {
      this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController.a(this.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean.a);
      this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabItemController.a();
      ReportUtil.a("gouwu.tab.click", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean.a), String.valueOf(NetConnInfoCenter.getServerTimeMillis()), "", TabLayoutController.a(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController));
      ReportUtil.b("gouwu_tab_click", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean.a), String.valueOf(NetConnInfoCenter.getServerTimeMillis()), "", TabLayoutController.a(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController));
      TabLayoutController.a(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController, this.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean);
      Object localObject = (Function1)TabLayoutController.a(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController).get(Integer.valueOf(TabLayoutController.a(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController)));
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean.a));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TabLayoutController.setOnClickListener.1
 * JD-Core Version:    0.7.0.1
 */