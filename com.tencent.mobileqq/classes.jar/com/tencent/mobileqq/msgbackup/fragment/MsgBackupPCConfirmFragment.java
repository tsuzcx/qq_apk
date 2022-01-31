package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import askv;
import aslg;
import aslq;
import asna;
import asnz;
import asog;
import asoi;
import bbll;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MsgBackupPCConfirmFragment
  extends MsgBackupPcBaseFragment
{
  public static MsgBackupPCConfirmFragment a;
  
  protected void a()
  {
    super.a();
    aslg.a().a().a(this);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupMsgBackupPCConfirmFragment", 2, "mBizType = " + this.jdField_b_of_type_Int);
    }
    if (paramBoolean) {
      paramObject = (aslq)paramObject;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10001);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  protected void c()
  {
    super.c();
    bbll.b(this.c, 0);
    bbll.b(this.d, 8);
    bbll.b(this.jdField_b_of_type_AndroidWidgetButton, 8);
    bbll.b(this.jdField_a_of_type_AndroidWidgetButton, 0);
    bbll.b(this.jdField_b_of_type_AndroidWidgetButton, 8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690359);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690417);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840905);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131690335);
    if (AppSetting.d) {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131690335));
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840904);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690426));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.d) {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131690425));
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(getActivity().getString(2131690425));
      asog.a("0X800A280");
    }
    if (this.e)
    {
      this.vg.setLeftBackVisible(8);
      this.vg.setRightButton(2131690347);
    }
    this.vg.setOnItemSelectListener(new asna(this));
    if (aslg.c) {
      asog.a("0X800A254");
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      asnz.a().c();
      paramInt = askv.a().a();
      if (paramInt == 2) {
        onBackEvent();
      }
      while (paramInt != 1) {
        return true;
      }
      if (this.e)
      {
        onBackEvent();
        return true;
      }
      a(getActivity());
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (getActivity() == null) {
      asoi.a("MsgBackupMsgBackupPCConfirmFragment", "activity is null------------->", new Object[0]);
    }
    int i;
    do
    {
      return false;
      switch (paramMessage.what)
      {
      default: 
        return false;
      }
      i = askv.a().a();
      if (i == 2)
      {
        onBackEvent();
        return false;
      }
    } while (i != 1);
    if (this.e)
    {
      onBackEvent();
      return false;
    }
    a(getActivity());
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if ((paramActivity != null) && (this.e)) {
      paramActivity.overridePendingTransition(2130772091, 2130772090);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupPCConfirmFragment != null) && (jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupPCConfirmFragment.getActivity() != null)) {
      jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupPCConfirmFragment.getActivity().finish();
    }
    for (;;)
    {
      jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupPCConfirmFragment = this;
      return;
      asoi.b("MsgBackupMsgBackupPCConfirmFragment", "fight1111.onAttach getActivity = null,sInstance = null", new Object[0]);
    }
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
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
      paramView = new Intent();
      paramView.putExtra("backup_select_from", 1);
      paramView.putExtra("0x11bpush_extra", this.jdField_a_of_type_JavaLangString);
      PublicFragmentActivity.a(getActivity(), paramView, MsgBackupSelectionFragment.class, 1000);
      asoi.a("MsgBackupMsgBackupPCConfirmFragment", "migrate_btn onclick BIZ_TYPE_BACKUP", new Object[0]);
    } while (!this.e);
    asog.a("0X800A255");
    return;
    paramView = new Intent();
    paramView.putExtra("param_start", 2);
    paramView.putExtra("0x11bpush_extra", this.jdField_a_of_type_JavaLangString);
    PublicFragmentActivity.a(getActivity(), paramView, MsgBackupPCTransportFragment.class, 1000);
    asoi.a("MsgBackupMsgBackupPCConfirmFragment", "migrate_btn onclick BIZ_TYPE_RESTORE", new Object[0]);
    asog.a("0X800A281");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!aslg.a) {
      aslg.a().a().a(null);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupPCConfirmFragment == this) {
      jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupPCConfirmFragment = null;
    }
    asoi.b("MsgBackupMsgBackupPCConfirmFragment", "fight1111.onDetach l", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment
 * JD-Core Version:    0.7.0.1
 */