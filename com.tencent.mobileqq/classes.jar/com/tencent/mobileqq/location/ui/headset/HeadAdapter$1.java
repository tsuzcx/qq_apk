package com.tencent.mobileqq.location.ui.headset;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.location.ui.LocationShareController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HeadAdapter$1
  implements View.OnClickListener
{
  HeadAdapter$1(HeadAdapter paramHeadAdapter, String paramString) {}
  
  public void onClick(View paramView)
  {
    HeadAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadsetHeadAdapter).a(this.jdField_a_of_type_JavaLangString);
    ReportController.b(null, "CliOper", "", "", "0X800A770", "0X800A770", 0, 0, "", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.headset.HeadAdapter.1
 * JD-Core Version:    0.7.0.1
 */