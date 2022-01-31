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
import arop;
import arpa;
import arpo;
import arqr;
import arqs;
import arqt;
import arrt;
import arsa;
import arsq;
import bajq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MsgBackupPCAuthFragment
  extends MsgBackupPcBaseFragment
{
  private Handler a;
  private int f = 60;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  
  public MsgBackupPCAuthFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new arqr(this));
  }
  
  private void a(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130838998);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130848747);
  }
  
  private void n()
  {
    arsq.a(BaseApplicationImpl.getContext(), "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/pcqq_version_upgrade_919.html", true, true, true, false, null, "biz_src_msg_backup");
  }
  
  protected void a(arpo paramarpo)
  {
    super.a(paramarpo);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, "processGetQrRsp data = " + paramarpo);
    }
    if (paramarpo != null)
    {
      arop.a().a(paramarpo.a());
      arop.a().a(paramarpo.a());
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
    setTitle(getActivity().getString(2131624776));
  }
  
  protected void c()
  {
    super.c();
    bajq.b(this.c, 0);
    bajq.b(this.d, 8);
    bajq.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
    bajq.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
    bajq.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840843);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131624854);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131624857);
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131624861);
    if (AppSetting.c) {
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131624861));
    }
    this.vg.setRightViewTextVisible(0);
    this.vg.setOnItemSelectListener(new arqs(this));
    arpa.a().a(new arqt(this));
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
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131100170));
          this.jdField_a_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131624799));
        }
        if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (isDetached())) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131624857));
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
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101260));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131624854));
      }
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (!isDetached())) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131624857));
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    arpa.c = false;
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public void k()
  {
    arpa.a().a().c();
    arrt.a().b();
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
    do
    {
      return;
      if (this.jdField_g_of_type_Int == 0)
      {
        this.h = true;
        this.jdField_g_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, "migrate_sure onclick phone request backup!");
        }
        arpa.a().a(true);
        arsa.a("0X800A26A");
        return;
      }
    } while ((this.jdField_g_of_type_Int != 1) || (this.e));
    arsa.a("0X800A26B");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    arpa.a().a(null);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    arpa.a().a(null);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCAuthFragment
 * JD-Core Version:    0.7.0.1
 */