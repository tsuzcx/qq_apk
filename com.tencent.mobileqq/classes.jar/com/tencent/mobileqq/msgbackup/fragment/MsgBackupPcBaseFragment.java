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
  protected String ab;
  protected boolean ac = false;
  protected boolean ad = false;
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_start", 5);
    localIntent.putExtra("BIZ_TYPE", paramInt);
    QPublicFragmentActivity.start(paramContext, localIntent, MsgBackupPCTransportFragment.class);
  }
  
  private void w()
  {
    if ((getActivity() != null) && (this.O != null)) {
      getQBaseActivity().addObserver(this.O);
    }
  }
  
  private void x()
  {
    if ((getActivity() != null) && (this.O != null)) {
      getQBaseActivity().removeObserver(this.O);
    }
  }
  
  protected void b()
  {
    super.b();
    w();
  }
  
  protected void c()
  {
    super.c();
    a(getActivity().getString(2131887444));
    if (MsgBackupAuthProcessor.a().c() == 2) {
      a(getActivity().getString(2131887441));
    }
  }
  
  protected void d()
  {
    super.d();
    MsgBackupUtil.a("MsgBackup_MsgBackupPcBaseFragment", "MsgBackupPcBaseFragment bindview is called! biztype = %d, isFromPcHandle = %b", new Object[] { Integer.valueOf(this.K), Boolean.valueOf(this.ac) });
  }
  
  public void de_()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      Object localObject = HardCodeUtil.a(2131904807);
      String str1 = HardCodeUtil.a(2131904793);
      this.K = MsgBackupAuthProcessor.a().c();
      if (this.K == 2) {
        localObject = HardCodeUtil.a(2131904789);
      }
      if (this.K == 2) {
        str1 = HardCodeUtil.a(2131904795);
      }
      String str2 = HardCodeUtil.a(2131904803);
      if (this.K == 1) {
        str2 = HardCodeUtil.a(2131904790);
      }
      localObject = DialogUtil.a(localFragmentActivity, 0, (String)localObject, str2, localFragmentActivity.getString(2131887454), str1, new MsgBackupPcBaseFragment.2(this), new MsgBackupPcBaseFragment.3(this));
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      ((QQCustomDialog)localObject).show();
    }
  }
  
  protected void e()
  {
    super.e();
    this.w.setOnClickListener(this);
    this.H.setOnClickListener(this);
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
        this.a = paramActivity.getIntExtra("param_start", -1);
        this.K = paramActivity.getIntExtra("BIZ_TYPE", 1);
        this.ab = paramActivity.getStringExtra("0x11bpush_extra");
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("toPage = ");
          paramActivity.append(this.a);
          paramActivity.append("; mBizType = ");
          paramActivity.append(this.K);
          QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, paramActivity.toString());
        }
      }
      boolean bool1 = bool2;
      if (TextUtils.isEmpty(this.ab)) {
        if (MsgBackupManager.s) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      this.ac = bool1;
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyView topage = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", bizType = ");
      localStringBuilder.append(MsgBackupAuthProcessor.a().c());
      localStringBuilder.append(", sIsShouQiBtnClick = ");
      localStringBuilder.append(MsgBackupManager.a);
      QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, localStringBuilder.toString());
    }
    x();
  }
  
  public void u()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      String str2 = HardCodeUtil.a(2131892267);
      this.K = MsgBackupAuthProcessor.a().c();
      String str1 = HardCodeUtil.a(2131904804);
      if (this.K == 1) {
        str1 = HardCodeUtil.a(2131904794);
      }
      DialogUtil.a(localFragmentActivity, 0, null, str1, null, str2, new MsgBackupPcBaseFragment.1(this), null).show();
    }
  }
  
  protected void v()
  {
    if (this.K == 1)
    {
      MsgBackupCompleteFragment.a(getActivity(), this.R, this.S, this.ac);
      return;
    }
    if (this.K == 2) {
      MsgBackupCompleteFragment.i(getActivity(), this.R, this.S);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment
 * JD-Core Version:    0.7.0.1
 */