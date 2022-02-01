package com.tencent.mobileqq.olympic.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PromotionEntry$2
  implements View.OnClickListener
{
  PromotionEntry$2(PromotionEntry paramPromotionEntry, PromotionConfigInfo.PromotionItem paramPromotionItem) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "CliOper", "", "", "0X8009C6B", "0X8009C6B", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem.a, "0", "0", "");
    PromotionEntry.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry).b(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry.2
 * JD-Core Version:    0.7.0.1
 */