package com.tencent.open.agent.auth.presenter;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.agent.util.AuthModelUtil;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import mqq.observer.SSOAccountObserver;

class BaseAuthorityPresenter$3
  extends SSOAccountObserver
{
  BaseAuthorityPresenter$3(BaseAuthorityPresenter paramBaseAuthorityPresenter) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    String str = paramBundle.getString("error");
    paramInt1 = paramBundle.getInt("code");
    paramBundle = AuthorityUtil.a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(", code=");
    SSOLog.a("BaseAuthorityPresenter", new Object[] { "onFailed uin=", paramBundle, ", ret=", Integer.valueOf(paramInt2), ", error=", localStringBuilder.toString(), Integer.valueOf(paramInt1) });
    BaseAuthorityPresenter.a(this.a, paramString, paramInt2, str, paramInt1);
    BaseAuthorityPresenter.a(this.a, paramString, paramInt2, paramInt1);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetTicketNoPasswd uin=");
    ((StringBuilder)localObject).append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityPresenter", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = this.a;
    ((BaseAuthorityPresenter)localObject).jdField_a_of_type_ComTencentOpenModelAccountInfo = AuthModelUtil.a(((BaseAuthorityPresenter)localObject).jdField_a_of_type_MqqManagerWtloginManager, paramString, paramArrayOfByte, paramInt, paramBundle);
    localObject = this.a;
    ((BaseAuthorityPresenter)localObject).d = ((BaseAuthorityPresenter)localObject).jdField_a_of_type_ComTencentOpenModelAccountInfo.a;
    BaseAuthorityPresenter.a(this.a, paramString, paramArrayOfByte, paramBundle);
    this.a.a(paramString, paramInt, paramBundle);
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("onUserCancel uin=");
    paramBundle.append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityPresenter", new Object[] { paramBundle.toString() });
    paramBundle = this.a;
    paramBundle.jdField_a_of_type_Int = 0;
    paramBundle.c = SystemClock.elapsedRealtime();
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString, false);
    AuthReporter.a("KEY_LOGIN_STAGE_1_TOTAL", paramString, this.a.jdField_a_of_type_Long, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter.3
 * JD-Core Version:    0.7.0.1
 */