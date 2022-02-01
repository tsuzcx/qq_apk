package com.tencent.open.agent;

import android.content.res.Resources;
import android.os.Message;
import android.widget.Button;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.open.virtual.OpenSdkVirtualManager.PreAuthCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

class OpenAuthorityFragment$7
  implements OpenSdkVirtualManager.PreAuthCallback
{
  OpenAuthorityFragment$7(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a()
  {
    if (!OpenAuthorityFragment.b(this.a))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer onSuccess for activity is finished");
      return;
    }
    Object localObject1 = OpenAuthorityFragment.a(this.a).a().a(OpenAuthorityFragment.a(this.a));
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "updatePreAuthFromServer use cached realAppid=", OpenAuthorityFragment.a(this.a), ", appInfo=", localObject1 });
    Object localObject2 = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    ((Message)localObject2).what = 3;
    ((Message)localObject2).obj = localObject1;
    this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject2);
    localObject1 = OpenAuthorityFragment.a(this.a).a().a(OpenAuthorityFragment.a(this.a));
    boolean bool;
    if (localObject1 != null)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer onSuccess null != virtualResult");
      localObject2 = this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback;
      if (((GetVirtualListResult)localObject1).a == 0)
      {
        bool = true;
        ((AuthCallback)localObject2).a(bool, (GetVirtualListResult)localObject1);
      }
    }
    for (;;)
    {
      if (!OpenAuthorityFragment.c(this.a)) {
        OpenAuthorityFragment.a(this.a).setEnabled(true);
      }
      localObject1 = OpenAuthorityFragment.a(this.a).a().a(OpenAuthorityFragment.a(this.a));
      localObject2 = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      ((Message)localObject2).what = 0;
      ((Message)localObject2).obj = localObject1;
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject2);
      return;
      bool = false;
      break;
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer onSuccess null == virtualResult");
      this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback.a(false, null);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "updatePreAuthFromServer | onFail: | uin : *" + AuthorityUtil.a(OpenAuthorityFragment.a(this.a).a), ", errorCode=", Integer.valueOf(paramInt), ", errorMsg=", paramString });
    if (!OpenAuthorityFragment.b(this.a))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer onFail for activity is finished");
      return;
    }
    if (OpenAuthorityFragment.a(this.a, paramInt, false))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer handle110537");
      return;
    }
    if (OpenAuthorityFragment.a(this.a, paramInt, 3))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer handle110509");
      return;
    }
    this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback.a(false, null);
    paramString = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    paramString.what = 6;
    paramString.arg1 = 3001;
    paramString.obj = this.a.getResources().getString(2131694670);
    this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.7
 * JD-Core Version:    0.7.0.1
 */