package com.tencent.mobileqq.richstatus;

import android.os.Bundle;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class StatusJsHandler$3
  implements BusinessObserver
{
  StatusJsHandler$3(StatusJsHandler paramStatusJsHandler) {}
  
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
      localObject = paramBundle.getByteArray("data");
      if (localObject != null)
      {
        paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        paramBundle.mergeFrom((byte[])localObject);
        if ((paramBundle.ret_info.has()) && (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.has()) && (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() == 0))
        {
          if ((this.a.d == null) || (this.a.d != null))
          {
            localObject = (IPublicAccountDetail)QRoute.api(IPublicAccountDetail.class);
            ((IPublicAccountDetail)localObject).init(paramBundle);
            this.a.a(localBaseActivity, (IPublicAccountDetail)localObject);
            StatusJsHandler.a(this.a, localBaseActivity, this.a.d.getUin());
          }
        }
        else {
          this.a.a(2131892951);
        }
      }
      else
      {
        this.a.a(2131892951);
      }
    }
    catch (Exception paramBundle)
    {
      label258:
      break label258;
    }
    paramBundle = this.a;
    paramBundle.a(paramBundle.h, "false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusJsHandler.3
 * JD-Core Version:    0.7.0.1
 */