package com.tencent.mobileqq.onlinestatus.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/onlinestatus/view/ConstellationView$bindView$4$1"}, k=3, mv={1, 1, 16})
final class ConstellationView$bindView$$inlined$apply$lambda$1
  implements View.OnClickListener
{
  ConstellationView$bindView$$inlined$apply$lambda$1(ConstellationView paramConstellationView, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    ConstellationView localConstellationView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewConstellationView;
    ConstellationView.a(localConstellationView, (Activity)localConstellationView.a(), (Function0)new ConstellationView.bindView..inlined.apply.lambda.1.1(this), (Function0)new ConstellationView.bindView..inlined.apply.lambda.1.2(this));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewConstellationView.a.a(1040);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewConstellationView.dismiss();
    ReportHelperKt.a("0X800AF44", 0, null, null, 14, null);
    ReportHelperKt.a("0X8009DE0", 1040, null, null, 12, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.ConstellationView.bindView..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */