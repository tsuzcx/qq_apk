package com.tencent.mobileqq.msgbackup.fragment;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class MsgBackupMigrateFragment
  extends MsgBackupBaseFragment
{
  protected void c()
  {
    super.c();
    a(getActivity().getString(2131690554));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(new MsgBackupMigrateFragment.1(this));
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131690531);
    if (AppSetting.d) {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131690531));
    }
    this.g.setText(getActivity().getString(2131690552));
    this.c.setVisibility(0);
    this.b.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10012)
    {
      int i = paramMessage.arg1;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      if (this.jdField_a_of_type_AndroidWidgetButton != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool);
      }
      if (!bool)
      {
        if ((this.g != null) && (!isDetached()))
        {
          this.g.setTextColor(getResources().getColor(2131165880));
          this.g.setText(getActivity().getString(2131690551));
        }
        if ((this.h != null) && (!isDetached())) {
          this.h.setText(getActivity().getString(2131690575));
        }
      }
      else
      {
        if ((this.g != null) && (!isDetached()))
        {
          this.g.setTextColor(getResources().getColor(2131167056));
          this.g.setText(getActivity().getString(2131690552));
        }
        if ((this.h != null) && (!isDetached())) {
          this.h.setText(getActivity().getString(2131690576));
        }
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131371025)
    {
      QPublicFragmentActivity.startForResult(getActivity(), MsgBackupSelectionFragment.class, 1000);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupMigrateFragment", 2, "migrate_btn onclick");
      }
      MsgBackupReporter.a("0X800A230");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.b.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupMigrateFragment
 * JD-Core Version:    0.7.0.1
 */