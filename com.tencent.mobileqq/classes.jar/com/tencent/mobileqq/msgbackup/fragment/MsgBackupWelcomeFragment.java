package com.tencent.mobileqq.msgbackup.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MsgBackupWelcomeFragment
  extends MsgBackupBaseFragment
{
  protected void b()
  {
    super.b();
    setTitle(getActivity().getString(2131690625));
  }
  
  protected void c()
  {
    super.c();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.b.setOnClickListener(this);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690621));
      this.b.setContentDescription(getString(2131690622));
      this.vg.setLeftViewName(2131690656);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MsgBackupReporter.a("0X800A22E");
      PublicFragmentActivity.a(getActivity(), MsgBackupMigrateFragment.class, 1000);
      continue;
      MsgBackupReporter.a("0X800A268");
      MsgBackupAuthProcessor.a().a(1);
      PublicFragmentActivity.a(getActivity(), MsgBackupPCAuthFragment.class, 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupWelcomeFragment
 * JD-Core Version:    0.7.0.1
 */