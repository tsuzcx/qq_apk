package com.tencent.mobileqq.studymode;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

class KidModeVerifyFragment$1
  extends KidModeObserver
{
  KidModeVerifyFragment$1(KidModeVerifyFragment paramKidModeVerifyFragment) {}
  
  public void c(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = this.a.getBaseActivity();
    if ((localObject != null) && (!((BaseActivity)localObject).isFinishing()))
    {
      if (!paramBoolean)
      {
        QLog.i("KidModeVerifyFragment", 1, "onVerifySmsCodeSuccess is not success.");
        KidModeUtils.a((BaseActivity)localObject, HardCodeUtil.a(2131917817), 1);
        return;
      }
      int i = paramBundle.getInt("SMS_TOKEN_TYPE");
      paramBundle = paramBundle.getByteArray("SMS_TOKEN");
      if (paramBundle == null)
      {
        QLog.i("KidModeVerifyFragment", 1, "onVerifySmsCodeSuccess bytes == null");
        KidModeUtils.a((BaseActivity)localObject, HardCodeUtil.a(2131917817), 1);
        return;
      }
      QLog.i("KidModeVerifyFragment", 1, "onVerifySmsCodeSuccess sendSmsTokenRequest");
      localObject = this.a;
      ((KidModeVerifyFragment)localObject).c = true;
      KidModeServlet.a(KidModeVerifyFragment.c((KidModeVerifyFragment)localObject), "86", "", i, paramBundle);
      return;
    }
    QLog.i("KidModeVerifyFragment", 1, "onVerifySmsCodeSuccess activity is finishing.");
  }
  
  public void d(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = this.a.getBaseActivity();
    if (localObject != null)
    {
      if (((BaseActivity)localObject).isFinishing()) {
        return;
      }
      int i = paramBundle.getInt("REQ_RESULT");
      if (i != 0)
      {
        KidModeVerifyFragment.a(this.a).setEnabled(true);
        if (i == 85)
        {
          KidModeUtils.a((BaseActivity)localObject, HardCodeUtil.a(2131891099), 1);
          return;
        }
        if (i == 84)
        {
          KidModeVerifyFragment.a(this.a, paramBundle.getInt("RESENT_INTERVAL_TIMEOUT", 0));
          return;
        }
        KidModeUtils.a((BaseActivity)localObject, HardCodeUtil.a(2131914072), 1);
        return;
      }
      SharedPreUtils.a("sp_key_count_time", Long.valueOf(NetConnInfoCenter.getServerTime()));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSendSmsCodeSuccess res=");
      ((StringBuilder)localObject).append(i);
      QLog.i("KidModeVerifyFragment", 1, ((StringBuilder)localObject).toString());
      i = 60;
      int j = paramBundle.getInt("RESENT_INTERVAL_TIMEOUT", 0);
      if (j > 0) {
        i = j;
      }
      KidModeVerifyFragment.b(this.a).setVisibility(0);
      KidModeVerifyFragment.a(this.a, i);
    }
  }
  
  public void e(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = this.a.getBaseActivity();
    if ((paramBundle != null) && (!paramBundle.isFinishing()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onVerifySmsCodeSuccess activity isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",isSendSmsTokenRequest=");
      ((StringBuilder)localObject).append(this.a.c);
      QLog.i("KidModeVerifyFragment", 1, ((StringBuilder)localObject).toString());
      if (!this.a.c) {
        return;
      }
      localObject = this.a;
      ((KidModeVerifyFragment)localObject).c = false;
      if (!paramBoolean)
      {
        KidModeUtils.a(paramBundle, HardCodeUtil.a(2131917817), 1);
        return;
      }
      ((KidModeVerifyFragment)localObject).a();
      return;
    }
    QLog.i("KidModeVerifyFragment", 1, "onSendSmsTokenSuccess activity is finishing.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeVerifyFragment.1
 * JD-Core Version:    0.7.0.1
 */