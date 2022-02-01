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
    a(getActivity().getString(2131887465));
    this.p.setOnItemSelectListener(new MsgBackupMigrateFragment.1(this));
  }
  
  protected void d()
  {
    super.d();
    this.w.setEnabled(true);
    this.w.setText(2131887442);
    if (AppSetting.e) {
      this.w.setContentDescription(getString(2131887442));
    }
    this.y.setText(getActivity().getString(2131887463));
    this.d.setVisibility(0);
    this.J.post(this.N);
  }
  
  protected void e()
  {
    super.e();
    this.w.setOnClickListener(this);
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
      if (this.w != null) {
        this.w.setEnabled(bool);
      }
      if (!bool)
      {
        if ((this.y != null) && (!isDetached()))
        {
          this.y.setTextColor(getResources().getColor(2131166523));
          this.y.setText(getActivity().getString(2131887462));
        }
        if ((this.z != null) && (!isDetached())) {
          this.z.setText(getActivity().getString(2131887486));
        }
      }
      else
      {
        if ((this.y != null) && (!isDetached()))
        {
          this.y.setTextColor(getResources().getColor(2131167993));
          this.y.setText(getActivity().getString(2131887463));
        }
        if ((this.z != null) && (!isDetached())) {
          this.z.setText(getActivity().getString(2131887487));
        }
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131438364)
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
    if (this.N != null) {
      this.J.removeCallbacks(this.N);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupMigrateFragment
 * JD-Core Version:    0.7.0.1
 */