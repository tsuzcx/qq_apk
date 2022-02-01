package com.tencent.mobileqq.richstatus;

import android.os.Bundle;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class StatusJsHandler$4
  implements BusinessObserver
{
  StatusJsHandler$4(StatusJsHandler paramStatusJsHandler) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.a.get();
    Object localObject;
    if (localBaseActivity != null)
    {
      if (localBaseActivity.isFinishing()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("success:");
        ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
        QLog.d("Q.richstatus.", 2, ((StringBuilder)localObject).toString());
      }
      if (!paramBoolean) {
        this.a.a(2131892951);
      }
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label327;
      }
      localObject = new mobileqq_mp.FollowResponse();
      ((mobileqq_mp.FollowResponse)localObject).mergeFrom(paramBundle);
      if ((!((mobileqq_mp.FollowResponse)localObject).ret_info.has()) || (!((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.has())) {
        break label347;
      }
      paramInt = ((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.get();
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        continue;
        paramInt = -1;
      }
    }
    if (paramInt == 0)
    {
      this.a.d.setFollowType(1);
      this.a.a(localBaseActivity, this.a.d);
      ((IPublicAccountHandler)localBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).onFollowPublicAccount(this.a.d);
      ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getMenuSetting(localBaseActivity.getApplicationContext(), localBaseActivity.app, this.a.d.getUin(), null, true);
      this.a.a(this.a.h, "true");
      return;
    }
    if (paramInt == 58) {
      this.a.a(2131892946);
    } else if (paramInt == 65) {
      this.a.a(2131892918);
    } else {
      this.a.a(2131892951);
    }
    label327:
    paramBundle = this.a;
    paramBundle.a(paramBundle.h, "false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusJsHandler.4
 * JD-Core Version:    0.7.0.1
 */