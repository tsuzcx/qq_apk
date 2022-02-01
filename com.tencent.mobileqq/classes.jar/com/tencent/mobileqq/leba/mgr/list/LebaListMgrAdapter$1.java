package com.tencent.mobileqq.leba.mgr.list;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LebaListMgrAdapter$1
  implements CompoundButton.OnCheckedChangeListener
{
  LebaListMgrAdapter$1(LebaListMgrAdapter paramLebaListMgrAdapter, RedTouch paramRedTouch, LebaViewItem paramLebaViewItem) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!AppSetting.d) {
      LebaListMgrAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLebaMgrListLebaListMgrAdapter, this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.list.LebaListMgrAdapter.1
 * JD-Core Version:    0.7.0.1
 */