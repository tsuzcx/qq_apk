package com.tencent.mobileqq.profile.stickynote.publish.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.stickynote.publish.bean.BackgroundSelectBean;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class BackgroundSelectorAdapter$1
  implements View.OnClickListener
{
  BackgroundSelectorAdapter$1(BackgroundSelectorAdapter paramBackgroundSelectorAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (BackgroundSelectorAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter) == this.jdField_a_of_type_Int) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Iterator localIterator = BackgroundSelectorAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter).iterator();
      while (localIterator.hasNext()) {
        ((BackgroundSelectBean)localIterator.next()).a = false;
      }
      ((BackgroundSelectBean)BackgroundSelectorAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter).get(this.jdField_a_of_type_Int)).a = true;
      BackgroundSelectorAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter.notifyDataSetChanged();
      if (BackgroundSelectorAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter) != null) {
        BackgroundSelectorAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter).a((BackgroundSelectBean)BackgroundSelectorAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter).get(this.jdField_a_of_type_Int));
      }
      ReportController.b(null, "dc00898", "", "", "0X800AB2B", "0X800AB2B", 0, 0, "0", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.adapter.BackgroundSelectorAdapter.1
 * JD-Core Version:    0.7.0.1
 */