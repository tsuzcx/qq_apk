package com.tencent.mobileqq.studymode.pwdverify;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.KidModeObserver.SetNewPasswordResult;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;

class StudyPwdSetConfirmFragment$2
  extends KidModeObserver
{
  StudyPwdSetConfirmFragment$2(StudyPwdSetConfirmFragment paramStudyPwdSetConfirmFragment) {}
  
  public void a(KidModeObserver.SetNewPasswordResult paramSetNewPasswordResult)
  {
    Object localObject = this.a.getQBaseActivity();
    if ((localObject != null) && (!((QBaseActivity)localObject).isFinishing()))
    {
      if (paramSetNewPasswordResult == null)
      {
        QLog.i("StudyPwdSetConfirmFragment", 1, "onSetNewPassword result == null");
        this.a.c(null);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetNewPassword errCode=");
      ((StringBuilder)localObject).append(paramSetNewPasswordResult.errCode);
      ((StringBuilder)localObject).append(",errMessage=");
      ((StringBuilder)localObject).append(paramSetNewPasswordResult.errMessage);
      ((StringBuilder)localObject).append(",token=");
      ((StringBuilder)localObject).append(paramSetNewPasswordResult.token);
      QLog.i("StudyPwdSetConfirmFragment", 1, ((StringBuilder)localObject).toString());
      if (paramSetNewPasswordResult.errCode != 0)
      {
        this.a.c(null);
        return;
      }
      StudyModeManager.b(2);
      if (TextUtils.isEmpty(paramSetNewPasswordResult.token))
      {
        this.a.c(null);
        return;
      }
      localObject = this.a;
      ((StudyPwdSetConfirmFragment)localObject).b = true;
      KidModeServlet.a((QQAppInterface)((StudyPwdSetConfirmFragment)localObject).f(), paramSetNewPasswordResult.token.getBytes());
      return;
    }
    QLog.i("StudyPwdSetConfirmFragment", 1, "onSetNewPassword activity is finishing");
  }
  
  public void e(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = this.a.getQBaseActivity();
    if ((paramBundle != null) && (!paramBundle.isFinishing()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSendSmsTokenSuccess activity isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",mIsSendPwdTokenRequest=");
      ((StringBuilder)localObject).append(this.a.b);
      QLog.i("StudyPwdVerifyFragment", 1, ((StringBuilder)localObject).toString());
      if (!this.a.b) {
        return;
      }
      localObject = this.a;
      ((StudyPwdSetConfirmFragment)localObject).b = false;
      if ((paramBoolean) && (StudyPwdSetConfirmFragment.c((StudyPwdSetConfirmFragment)localObject) != -1))
      {
        if (StudyPwdSetConfirmFragment.c(this.a) == 2)
        {
          this.a.a(paramBundle);
          return;
        }
        this.a.a(paramBundle, true);
        this.a.i();
        return;
      }
      this.a.c(null);
      return;
    }
    QLog.i("StudyPwdSetConfirmFragment", 1, "onSendSmsTokenSuccess activity is finishing.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.pwdverify.StudyPwdSetConfirmFragment.2
 * JD-Core Version:    0.7.0.1
 */