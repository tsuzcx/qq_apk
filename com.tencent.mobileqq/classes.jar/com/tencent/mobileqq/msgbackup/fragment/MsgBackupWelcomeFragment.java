package com.tencent.mobileqq.msgbackup.fragment;

import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MsgBackupWelcomeFragment
  extends MsgBackupBaseFragment
{
  protected void c()
  {
    super.c();
    a(getActivity().getString(2131690553));
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setOnClickListener(this);
    this.b.setOnClickListener(this);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setContentDescription(getString(2131690549));
      this.b.setContentDescription(getString(2131690550));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftViewName(2131690584);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131376279)
    {
      MsgBackupReporter.a("0X800A22E");
      QPublicFragmentActivity.startForResult(getActivity(), MsgBackupMigrateFragment.class, 1000);
    }
    else if (i == 2131376275)
    {
      MsgBackupReporter.a("0X800A268");
      MsgBackupAuthProcessor.a().a(1);
      QPublicFragmentActivity.startForResult(getActivity(), MsgBackupPCAuthFragment.class, 1000);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupWelcomeFragment
 * JD-Core Version:    0.7.0.1
 */