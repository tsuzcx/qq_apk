package com.tencent.mobileqq.studymode;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

class ModeChoiceViewContainer$2
  extends KidModeObserver
{
  ModeChoiceViewContainer$2(ModeChoiceViewContainer paramModeChoiceViewContainer) {}
  
  public void a(KidModeObserver.QueryPasswordStateResult paramQueryPasswordStateResult)
  {
    if (paramQueryPasswordStateResult == null)
    {
      QLog.i("KidModeObserver", 1, "onQueryPasswordState result == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQueryPasswordState errCode=");
    localStringBuilder.append(paramQueryPasswordStateResult.errCode);
    localStringBuilder.append(",State=");
    localStringBuilder.append(paramQueryPasswordStateResult.passwordState);
    localStringBuilder.append(",salt=");
    localStringBuilder.append(KidModeUtils.a(paramQueryPasswordStateResult.salt));
    QLog.i("KidModeObserver", 1, localStringBuilder.toString());
    if (paramQueryPasswordStateResult.errCode == 0) {
      StudyModeManager.a(paramQueryPasswordStateResult.passwordState, paramQueryPasswordStateResult.salt);
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (!ModeChoiceViewContainer.a(this.a).isResume())
    {
      if (QLog.isColorLevel()) {
        QLog.d("KidModeObserver", 2, "onSendGetKidModeStatusSuccess but setting Activity is not resume");
      }
      return;
    }
    if (paramBoolean) {
      StudyModeManager.a(paramBundle.getInt("KID_MODE_NEED_VERIFY"));
    }
  }
  
  public void d(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("onSendSmsCodeSuccess isSuccess");
    paramBundle.append(paramBoolean);
    QLog.i("KidModeObserver", 1, paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeChoiceViewContainer.2
 * JD-Core Version:    0.7.0.1
 */