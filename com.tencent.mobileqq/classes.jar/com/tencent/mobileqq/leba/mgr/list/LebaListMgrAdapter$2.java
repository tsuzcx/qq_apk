package com.tencent.mobileqq.leba.mgr.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

class LebaListMgrAdapter$2
  implements View.OnClickListener
{
  LebaListMgrAdapter$2(LebaListMgrAdapter paramLebaListMgrAdapter, RedTouch paramRedTouch, LebaViewItem paramLebaViewItem) {}
  
  public void onClick(View paramView)
  {
    if (AppSetting.d)
    {
      Switch localSwitch = (Switch)paramView.findViewById(2131364078);
      if (localSwitch != null)
      {
        localSwitch.setChecked(localSwitch.isChecked() ^ true);
        LebaListMgrAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLebaMgrListLebaListMgrAdapter, this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem, localSwitch.isChecked());
        paramView.sendAccessibilityEvent(1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.list.LebaListMgrAdapter.2
 * JD-Core Version:    0.7.0.1
 */