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
    a(getActivity().getString(2131887464));
  }
  
  protected void d()
  {
    super.d();
    this.b.setVisibility(0);
  }
  
  protected void e()
  {
    super.e();
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    if (AppSetting.e)
    {
      this.f.setContentDescription(getString(2131887460));
      this.g.setContentDescription(getString(2131887461));
      this.p.setLeftViewName(2131887495);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131444488)
    {
      MsgBackupReporter.a("0X800A22E");
      QPublicFragmentActivity.startForResult(getActivity(), MsgBackupMigrateFragment.class, 1000);
    }
    else if (i == 2131444484)
    {
      MsgBackupReporter.a("0X800A268");
      MsgBackupAuthProcessor.a().a(1);
      QPublicFragmentActivity.startForResult(getActivity(), MsgBackupPCAuthFragment.class, 1000);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupWelcomeFragment
 * JD-Core Version:    0.7.0.1
 */