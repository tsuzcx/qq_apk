package com.tencent.mobileqq.writetogetherui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfBean.Template;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HorizontalAdapter$1
  implements View.OnClickListener
{
  HorizontalAdapter$1(HorizontalAdapter paramHorizontalAdapter, HorizontalAdapter.HorizontalViewHolder paramHorizontalViewHolder) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiHorizontalAdapter$HorizontalViewHolder.getAdapterPosition();
    if (i != HorizontalAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiHorizontalAdapter))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiHorizontalAdapter.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiHorizontalAdapter.a(paramView, i);
      }
      else
      {
        HorizontalAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiHorizontalAdapter).a(HorizontalAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiHorizontalAdapter)[i].b);
        HorizontalAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiHorizontalAdapter, i);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiHorizontalAdapter.notifyDataSetChanged();
      }
      ReportController.b(null, "dc00898", "", "", "0X800B355", "0X800B355", HorizontalAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiHorizontalAdapter)[i].a, 0, String.valueOf(HorizontalAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiHorizontalAdapter)), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.HorizontalAdapter.1
 * JD-Core Version:    0.7.0.1
 */