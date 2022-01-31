package com.tencent.mobileqq.msgbackup.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import arop;
import arsa;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;

public class MsgBackupWelcomeFragment
  extends MsgBackupBaseFragment
{
  protected void b()
  {
    super.b();
    setTitle(getActivity().getString(2131624801));
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
    if (AppSetting.c)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131624797));
      this.b.setContentDescription(getString(2131624798));
      this.vg.setLeftViewName(2131624838);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131309245: 
      arsa.a("0X800A22E");
      PublicFragmentActivity.a(getActivity(), MsgBackupMigrateFragment.class, 1000);
      return;
    }
    arsa.a("0X800A268");
    arop.a().a(1);
    PublicFragmentActivity.a(getActivity(), MsgBackupPCAuthFragment.class, 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupWelcomeFragment
 * JD-Core Version:    0.7.0.1
 */