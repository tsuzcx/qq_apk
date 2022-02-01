package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.mtt.MttBrowerWrapper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class MsgBackupPCAuthFragment
  extends MsgBackupPcBaseFragment
{
  private Handler a;
  private int f = 60;
  private int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean = false;
  private boolean h = false;
  
  public MsgBackupPCAuthFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new MsgBackupPCAuthFragment.1(this));
  }
  
  private void a(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839424);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130850453);
  }
  
  private void n()
  {
    MttBrowerWrapper.a(BaseApplicationImpl.getContext(), "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/pcqq_version_upgrade_919.html", true, true, true, false, null, "biz_src_msg_backup");
  }
  
  protected void a(MsgBackupGetQrRsp paramMsgBackupGetQrRsp)
  {
    super.a(paramMsgBackupGetQrRsp);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, "processGetQrRsp data = " + paramMsgBackupGetQrRsp);
    }
    if (paramMsgBackupGetQrRsp != null)
    {
      MsgBackupAuthProcessor.a().a(paramMsgBackupGetQrRsp.a());
      MsgBackupAuthProcessor.a().a(paramMsgBackupGetQrRsp.a());
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.a(paramInteger);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, "processGetQrError result = " + paramInteger);
    }
    if (paramInteger.intValue() == 1028) {
      n();
    }
  }
  
  protected void b()
  {
    setTitle(getActivity().getString(2131690605));
  }
  
  protected void c()
  {
    super.c();
    ViewUtils.b(this.c, 0);
    ViewUtils.b(this.d, 8);
    ViewUtils.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
    ViewUtils.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
    ViewUtils.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841465);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690669);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690671);
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131690674);
    if (AppSetting.d) {
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131690674));
    }
    this.vg.setRightViewTextVisible(0);
    this.vg.setOnItemSelectListener(new MsgBackupPCAuthFragment.2(this));
    MsgBackupManager.a().a(new MsgBackupPCAuthFragment.3(this));
    this.jdField_b_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = 0;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if (paramMessage.arg1 == 1) {}
      for (int i = 1;; i = 0)
      {
        if (this.jdField_b_of_type_AndroidWidgetButton != null)
        {
          if (!this.h) {
            break label149;
          }
          a(1);
        }
        if (i != 0) {
          break label166;
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!isDetached()))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165877));
          this.jdField_a_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690623));
        }
        if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (isDetached())) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690671));
        break;
      }
      label149:
      if (i != 0) {}
      for (;;)
      {
        a(j);
        break;
        j = 2;
      }
      label166:
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!isDetached()))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167033));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690669));
      }
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (!isDetached())) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690671));
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    MsgBackupManager.c = false;
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  protected void k()
  {
    MsgBackupManager.a().a().c();
    MsgBackupTransportProcessor.a().b();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_g_of_type_Int == 0)
      {
        this.h = true;
        this.jdField_g_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, "migrate_sure onclick phone request backup!");
        }
        MsgBackupManager.a().a(true);
        MsgBackupReporter.a("0X800A26A");
      }
      else if ((this.jdField_g_of_type_Int == 1) && (!this.e))
      {
        MsgBackupReporter.a("0X800A26B");
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    MsgBackupManager.a().a(null);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    MsgBackupManager.a().a(null);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCAuthFragment
 * JD-Core Version:    0.7.0.1
 */