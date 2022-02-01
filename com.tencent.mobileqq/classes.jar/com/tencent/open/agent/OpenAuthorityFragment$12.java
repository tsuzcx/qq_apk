package com.tencent.open.agent;

import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

class OpenAuthorityFragment$12
  extends AuthCallback
{
  OpenAuthorityFragment$12(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onDeleteVirtual isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    if (paramBoolean) {
      return;
    }
    this.a.k();
    if (paramInt == 151)
    {
      AuthorityUtil.a(this.a.getActivity(), HardCodeUtil.a(2131707831), false);
      this.a.c(OpenAuthorityFragment.b(this.a));
      return;
    }
    AuthorityUtil.a(this.a.getActivity(), HardCodeUtil.a(2131707833) + paramInt, false);
  }
  
  public void a(boolean paramBoolean, int paramInt, AuthResponse paramAuthResponse)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onDoAuthorize isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    ForwardStatisticsReporter.a("KEY_AUTHORIZE_REQUEST", OpenAuthorityFragment.a(this.a), paramBoolean);
    Object localObject;
    if ((paramBoolean) && (paramAuthResponse != null))
    {
      localObject = this.a.a.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramAuthResponse;
      this.a.a.sendMessage((Message)localObject);
      return;
    }
    if (paramInt == 110509)
    {
      if (OpenAuthorityFragment.e(this.a) >= 2)
      {
        AuthorityUtil.a(this.a.getActivity(), HardCodeUtil.a(2131707832), false);
        paramAuthResponse = OpenAuthorityFragment.a(this.a).a().a(OpenAuthorityFragment.a(this.a));
        localObject = this.a;
        if (paramAuthResponse == null) {}
        for (paramAuthResponse = null;; paramAuthResponse = paramAuthResponse.a)
        {
          ((OpenAuthorityFragment)localObject).c(paramAuthResponse);
          AuthReporter.a(OpenAuthorityFragment.b(this.a), "0X800B65F");
          return;
        }
      }
      OpenAuthorityFragment.f(this.a);
      OpenAuthorityFragment.a(this.a, 1);
      return;
    }
    if (paramInt == 110537)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onDoAuthorize 110537");
      AuthorityUtil.a(this.a.getActivity(), HardCodeUtil.a(2131707834), false);
      this.a.c(OpenAuthorityFragment.b(this.a));
      return;
    }
    AuthReporter.a(OpenAuthorityFragment.b(this.a), "0X800B65F");
    paramAuthResponse = AuthorityUtil.a(paramAuthResponse, this.a.getResources(), paramInt);
    AuthorityUtil.a(this.a.getActivity(), paramAuthResponse, false);
  }
  
  public void a(boolean paramBoolean, GetVirtualListResult paramGetVirtualListResult)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onGetVirtualList isSuccess=", Boolean.valueOf(paramBoolean) });
    if (OpenAuthorityFragment.a(this.a))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, " activity is isInvalid");
      return;
    }
    ForwardStatisticsReporter.a("KEY_GET_VIRTUAL_LIST_D24", OpenAuthorityFragment.a(this.a), paramBoolean);
    this.a.getActivity().runOnUiThread(new OpenAuthorityFragment.12.1(this, paramBoolean, paramGetVirtualListResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.12
 * JD-Core Version:    0.7.0.1
 */