package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupConfirmQrRsp;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class MsgBackupPCConfirmFragment
  extends MsgBackupPcBaseFragment
{
  public static MsgBackupPCConfirmFragment a;
  
  protected void a()
  {
    super.a();
    MsgBackupManager.a().a().a(this);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mBizType = ");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d("MsgBackupMsgBackupPCConfirmFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      paramObject = (MsgBackupConfirmQrRsp)paramObject;
    }
  }
  
  protected void d()
  {
    super.d();
    ViewUtils.b(this.jdField_c_of_type_AndroidWidgetLinearLayout, 0);
    ViewUtils.b(this.d, 8);
    ViewUtils.b(this.jdField_b_of_type_AndroidWidgetButton, 8);
    ViewUtils.b(this.jdField_a_of_type_AndroidWidgetButton, 0);
    ViewUtils.b(this.jdField_b_of_type_AndroidWidgetButton, 8);
    this.g.setText(2131690550);
    this.h.setText(2131690598);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841346);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131690531);
    if (AppSetting.d) {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131690531));
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841345);
      this.g.setText(getActivity().getString(2131690604));
      this.h.setVisibility(8);
      if (AppSetting.d) {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131690603));
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(getActivity().getString(2131690603));
      MsgBackupReporter.a("0X800A280");
    }
    if (this.f)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftBackVisible(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightButton(2131690543);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(new MsgBackupPCConfirmFragment.1(this));
    if (MsgBackupManager.c) {
      MsgBackupReporter.a("0X800A254");
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      MsgBackupTransportProcessor.a().c();
      paramInt = MsgBackupAuthProcessor.a().a();
      if (paramInt == 2)
      {
        onBackEvent();
        return true;
      }
      if (paramInt == 1)
      {
        if (this.f)
        {
          onBackEvent();
          return true;
        }
        a(getActivity());
      }
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void h_(boolean paramBoolean)
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10001);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (getActivity() == null)
    {
      MsgBackupUtil.a("MsgBackupMsgBackupPCConfirmFragment", "activity is null------------->", new Object[0]);
      return false;
    }
    if (paramMessage.what != 10001) {
      return false;
    }
    int i = MsgBackupAuthProcessor.a().a();
    if (i == 2)
    {
      onBackEvent();
      return false;
    }
    if (i == 1)
    {
      if (this.f)
      {
        onBackEvent();
        return false;
      }
      a(getActivity());
    }
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if ((paramActivity != null) && (this.f)) {
      paramActivity.overridePendingTransition(2130772141, 2130772140);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    paramActivity = jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupPCConfirmFragment;
    if ((paramActivity != null) && (paramActivity.getActivity() != null)) {
      jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupPCConfirmFragment.getActivity().finish();
    } else {
      MsgBackupUtil.b("MsgBackupMsgBackupPCConfirmFragment", "fight1111.onAttach getActivity = null,sInstance = null", new Object[0]);
    }
    jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupPCConfirmFragment = this;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131371025)
    {
      Intent localIntent;
      if (this.jdField_b_of_type_Int == 1)
      {
        localIntent = new Intent();
        localIntent.putExtra("backup_select_from", 1);
        localIntent.putExtra("0x11bpush_extra", this.jdField_a_of_type_JavaLangString);
        QPublicFragmentActivity.startForResult(getActivity(), localIntent, MsgBackupSelectionFragment.class, 1000);
        MsgBackupUtil.a("MsgBackupMsgBackupPCConfirmFragment", "migrate_btn onclick BIZ_TYPE_BACKUP", new Object[0]);
        if (this.f) {
          MsgBackupReporter.a("0X800A255");
        }
      }
      else
      {
        localIntent = new Intent();
        localIntent.putExtra("param_start", 2);
        localIntent.putExtra("0x11bpush_extra", this.jdField_a_of_type_JavaLangString);
        QPublicFragmentActivity.startForResult(getActivity(), localIntent, MsgBackupPCTransportFragment.class, 1000);
        MsgBackupUtil.a("MsgBackupMsgBackupPCConfirmFragment", "migrate_btn onclick BIZ_TYPE_RESTORE", new Object[0]);
        MsgBackupReporter.a("0X800A281");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!MsgBackupManager.a) {
      MsgBackupManager.a().a().a(null);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupPCConfirmFragment == this) {
      jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupPCConfirmFragment = null;
    }
    MsgBackupUtil.b("MsgBackupMsgBackupPCConfirmFragment", "fight1111.onDetach l", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment
 * JD-Core Version:    0.7.0.1
 */