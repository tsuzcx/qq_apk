package com.tencent.mobileqq.msgbackup.fragment;

import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import audv;
import auff;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MsgBackupMigrateFragment
  extends MsgBackupBaseFragment
{
  protected void b()
  {
    super.b();
    setTitle(getActivity().getString(2131690414));
    this.vg.setOnItemSelectListener(new audv(this));
  }
  
  protected void c()
  {
    super.c();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131690386);
    if (AppSetting.c) {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131690386));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690412));
    this.c.setVisibility(0);
    this.jdField_b_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if (paramMessage.arg1 == 1) {}
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidWidgetButton != null) {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool);
        }
        if (bool) {
          break label141;
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!isDetached()))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165798));
          this.jdField_a_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690411));
        }
        if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (isDetached())) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690439));
        break;
        bool = false;
      }
      label141:
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!isDetached()))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166901));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690412));
      }
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (!isDetached())) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690440));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    PublicFragmentActivity.a(getActivity(), MsgBackupSelectionFragment.class, 1000);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupMigrateFragment", 2, "migrate_btn onclick");
    }
    auff.a("0X800A230");
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupMigrateFragment
 * JD-Core Version:    0.7.0.1
 */