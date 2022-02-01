package com.tencent.mobileqq.loginregister;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.managers.MessageRecordManagerImpl;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;

public class MessageLoginAction
  extends BaseLoginAction
{
  private void a(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime.stopPCActivePolling("deleteAccount");
    ((AccountManager)paramAppRuntime.getManager(0)).deleteAccount(paramString, paramString, null);
    HistoryChatMsgSearchKeyUtil.b(paramString);
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("----clear_sp----deleteDataFromSP: uin:");
      localStringBuilder.append(paramString);
      QLog.d("MessageLoginAction", 2, localStringBuilder.toString());
    }
    paramString = BaseApplicationImpl.sApplication.getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  private void b(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((IFTSDBRuntimeService)paramAppRuntime.getRuntimeService(IFTSDBRuntimeService.class, "")).clearFTS(paramAppRuntime, paramString, true);
    }
    new MessageRecordManagerImpl().a(paramString);
    b(paramString);
  }
  
  public void a(QBaseActivity paramQBaseActivity, String paramString, boolean paramBoolean)
  {
    if ((paramQBaseActivity != null) && (paramQBaseActivity.getAppRuntime() != null))
    {
      paramQBaseActivity = paramQBaseActivity.getAppRuntime();
      a(paramQBaseActivity, paramString);
      if (paramBoolean) {
        b(paramQBaseActivity, paramString);
      }
      return;
    }
    QLog.e("MessageLoginAction", 1, "onDeleteAccount, context or app runtime illegal");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.MessageLoginAction
 * JD-Core Version:    0.7.0.1
 */