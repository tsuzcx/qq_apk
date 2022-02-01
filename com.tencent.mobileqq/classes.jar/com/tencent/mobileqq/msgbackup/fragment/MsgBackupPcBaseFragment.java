package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupPcBaseFragment
  extends MsgBackupBaseFragment
{
  protected String a;
  protected boolean f = false;
  protected boolean g = false;
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_start", 5);
    localIntent.putExtra("BIZ_TYPE", paramInt);
    QPublicFragmentActivity.start(paramContext, localIntent, MsgBackupPCTransportFragment.class);
  }
  
  private void o()
  {
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver != null)) {
      getQBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
    }
  }
  
  private void p()
  {
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver != null)) {
      getQBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
    }
  }
  
  protected void a()
  {
    super.a();
    o();
  }
  
  public void aJ_()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      Object localObject = HardCodeUtil.a(2131706964);
      String str1 = HardCodeUtil.a(2131706950);
      this.jdField_b_of_type_Int = MsgBackupAuthProcessor.a().a();
      if (this.jdField_b_of_type_Int == 2) {
        localObject = HardCodeUtil.a(2131706946);
      }
      if (this.jdField_b_of_type_Int == 2) {
        str1 = HardCodeUtil.a(2131706952);
      }
      String str2 = HardCodeUtil.a(2131706960);
      if (this.jdField_b_of_type_Int == 1) {
        str2 = HardCodeUtil.a(2131706947);
      }
      localObject = DialogUtil.a(localFragmentActivity, 0, (String)localObject, str2, localFragmentActivity.getString(2131690543), str1, new MsgBackupPcBaseFragment.2(this), new MsgBackupPcBaseFragment.3(this));
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      ((QQCustomDialog)localObject).show();
    }
  }
  
  protected void c()
  {
    super.c();
    a(getActivity().getString(2131690533));
    if (MsgBackupAuthProcessor.a().a() == 2) {
      a(getActivity().getString(2131690530));
    }
  }
  
  protected void d()
  {
    super.d();
    MsgBackupUtil.a("MsgBackup_MsgBackupPcBaseFragment", "MsgBackupPcBaseFragment bindview is called! biztype = %d, isFromPcHandle = %b", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(this.f) });
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      boolean bool2 = true;
      if (paramActivity != null)
      {
        this.jdField_a_of_type_Int = paramActivity.getIntExtra("param_start", -1);
        this.jdField_b_of_type_Int = paramActivity.getIntExtra("BIZ_TYPE", 1);
        this.jdField_a_of_type_JavaLangString = paramActivity.getStringExtra("0x11bpush_extra");
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("toPage = ");
          paramActivity.append(this.jdField_a_of_type_Int);
          paramActivity.append("; mBizType = ");
          paramActivity.append(this.jdField_b_of_type_Int);
          QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, paramActivity.toString());
        }
      }
      boolean bool1 = bool2;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        if (MsgBackupManager.c) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      this.f = bool1;
    }
  }
  
  public void m()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      String str2 = HardCodeUtil.a(2131694583);
      this.jdField_b_of_type_Int = MsgBackupAuthProcessor.a().a();
      String str1 = HardCodeUtil.a(2131706961);
      if (this.jdField_b_of_type_Int == 1) {
        str1 = HardCodeUtil.a(2131706951);
      }
      DialogUtil.a(localFragmentActivity, 0, null, str1, null, str2, new MsgBackupPcBaseFragment.1(this), null).show();
    }
  }
  
  protected void n()
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      MsgBackupCompleteFragment.a(getActivity(), this.c, this.d, this.f);
      return;
    }
    if (this.jdField_b_of_type_Int == 2) {
      MsgBackupCompleteFragment.i(getActivity(), this.c, this.d);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyView topage = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", bizType = ");
      localStringBuilder.append(MsgBackupAuthProcessor.a().a());
      localStringBuilder.append(", sIsShouQiBtnClick = ");
      localStringBuilder.append(MsgBackupManager.a);
      QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, localStringBuilder.toString());
    }
    p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment
 * JD-Core Version:    0.7.0.1
 */