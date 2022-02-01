package com.tencent.mobileqq.studymode.pwdverify;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.KidModeObserver.VerifyPasswordResult;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.KidModeUtils;
import com.tencent.qphone.base.util.QLog;

class StudyPwdVerifyFragment$2
  extends KidModeObserver
{
  StudyPwdVerifyFragment$2(StudyPwdVerifyFragment paramStudyPwdVerifyFragment) {}
  
  public void a(KidModeObserver.VerifyPasswordResult paramVerifyPasswordResult)
  {
    Object localObject = this.a.getQBaseActivity();
    if ((localObject != null) && (!((QBaseActivity)localObject).isFinishing()))
    {
      if (paramVerifyPasswordResult == null)
      {
        this.a.c(null);
        QLog.i("StudyPwdVerifyFragment", 1, "onVerifyPassword result == null");
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onVerifyPassword errCode=");
      ((StringBuilder)localObject).append(paramVerifyPasswordResult.errCode);
      ((StringBuilder)localObject).append(",errMessage=");
      ((StringBuilder)localObject).append(paramVerifyPasswordResult.errMessage);
      ((StringBuilder)localObject).append(",token=");
      ((StringBuilder)localObject).append(KidModeUtils.a(paramVerifyPasswordResult.token));
      QLog.i("StudyPwdVerifyFragment", 1, ((StringBuilder)localObject).toString());
      if (paramVerifyPasswordResult.errCode != 0)
      {
        if (paramVerifyPasswordResult.errCode == 20003)
        {
          this.a.a(null);
          paramVerifyPasswordResult = this.a.getString(2131897405);
          ReportController.b(StudyPwdVerifyFragment.a(this.a), "dc00898", "", "", "0X800BD49", "0X800BD49", 0, 0, "", "", "", "");
        }
        else if (paramVerifyPasswordResult.errCode == 30001)
        {
          this.a.a(null);
          paramVerifyPasswordResult = this.a.getString(2131897406);
          ReportController.b(StudyPwdVerifyFragment.a(this.a), "dc00898", "", "", "0X800BD48", "0X800BD48", 0, 0, "", "", "", "");
        }
        else
        {
          paramVerifyPasswordResult = "";
        }
        this.a.c(paramVerifyPasswordResult);
        return;
      }
      if (TextUtils.isEmpty(paramVerifyPasswordResult.token))
      {
        this.a.c(null);
        return;
      }
      localObject = this.a;
      ((StudyPwdVerifyFragment)localObject).b = true;
      KidModeServlet.a((QQAppInterface)((StudyPwdVerifyFragment)localObject).f(), paramVerifyPasswordResult.token.getBytes());
      return;
    }
    QLog.i("StudyPwdVerifyFragment", 1, "onVerifyPassword activity is finishing");
  }
  
  public void e(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = this.a.getQBaseActivity();
    if ((paramBundle != null) && (!paramBundle.isFinishing()))
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onSendSmsTokenSuccess activity isSuccess=");
      paramBundle.append(paramBoolean);
      paramBundle.append(",mIsSendPwdTokenRequest=");
      paramBundle.append(this.a.b);
      QLog.i("StudyPwdVerifyFragment", 1, paramBundle.toString());
      if (!this.a.b) {
        return;
      }
      paramBundle = this.a;
      paramBundle.b = false;
      if (!paramBoolean)
      {
        paramBundle.c(null);
        return;
      }
      paramBundle.n();
      this.a.i();
      return;
    }
    QLog.i("StudyPwdVerifyFragment", 1, "onSendSmsTokenSuccess activity is finishing.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.pwdverify.StudyPwdVerifyFragment.2
 * JD-Core Version:    0.7.0.1
 */