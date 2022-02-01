package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

class KidModeVerifyFragment$1
  extends KidModeObserver
{
  KidModeVerifyFragment$1(KidModeVerifyFragment paramKidModeVerifyFragment) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    int i = paramBundle.getInt("REQ_RESULT");
    if (i != 0)
    {
      KidModeVerifyFragment.a(this.a).setEnabled(true);
      if (i == 85)
      {
        KidModeUtils.a(localFragmentActivity, HardCodeUtil.a(2131693580), 1);
        return;
      }
      if (i == 84)
      {
        KidModeVerifyFragment.a(this.a, paramBundle.getInt("RESENT_INTERVAL_TIMEOUT", 0));
        return;
      }
      KidModeUtils.a(localFragmentActivity, HardCodeUtil.a(2131716956), 1);
      return;
    }
    SharedPreUtils.a("sp_key_count_time", Long.valueOf(NetConnInfoCenter.getServerTime()));
    if (QLog.isColorLevel()) {
      QLog.d("KidModeObserver", 2, "KidMode onRecvVerifyCode");
    }
    i = paramBundle.getInt("RESENT_INTERVAL_TIMEOUT", 0);
    if (i > 0) {}
    for (;;)
    {
      KidModeVerifyFragment.b(this.a).setVisibility(0);
      KidModeVerifyFragment.a(this.a, i);
      return;
      i = 60;
    }
  }
  
  public void d(boolean paramBoolean, Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("KidModeObserver", 2, "onVerifyClose activity is finishing.");
      }
      return;
    }
    if (!paramBoolean)
    {
      KidModeUtils.a(localFragmentActivity, HardCodeUtil.a(2131720472), 1);
      return;
    }
    int i = paramBundle.getInt("SMS_TOKEN_TYPE");
    paramBundle = paramBundle.getByteArray("SMS_TOKEN");
    if ((paramBundle == null) && (QLog.isColorLevel())) {
      QLog.d("KidModeObserver", 2, "verifySMSCodeSuccess but token is null");
    }
    if (paramBundle == null)
    {
      KidModeUtils.a(localFragmentActivity, HardCodeUtil.a(2131720472), 1);
      return;
    }
    KidModeServlet.a(KidModeVerifyFragment.a(this.a), "86", "", i, paramBundle);
  }
  
  public void e(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KidModeObserver", 1, new Object[] { "sendSmsTokenSuccess: res: ", Boolean.valueOf(paramBoolean) });
    }
    paramBundle = this.a.getActivity();
    if ((paramBundle == null) || (paramBundle.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("KidModeObserver", 2, "onVerifyClose activity is finishing.");
      }
      return;
    }
    switch (KidModeVerifyFragment.a(this.a))
    {
    default: 
      return;
    case 0: 
      if (!paramBoolean)
      {
        KidModeUtils.a(paramBundle, HardCodeUtil.a(2131720472), 1);
        return;
      }
      KidModeVerifyFragment.a(this.a);
      return;
    }
    if (!paramBoolean)
    {
      KidModeUtils.a(paramBundle, HardCodeUtil.a(2131720472), 1);
      return;
    }
    paramBundle = new Intent();
    paramBundle.putExtra("ExtraTargetMode", this.a.getActivity().getIntent().getIntExtra("ExtraTargetMode", -1));
    this.a.getActivity().setResult(-1, paramBundle);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeVerifyFragment.1
 * JD-Core Version:    0.7.0.1
 */