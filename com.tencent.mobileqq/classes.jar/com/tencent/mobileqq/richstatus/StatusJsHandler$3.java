package com.tencent.mobileqq.richstatus;

import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class StatusJsHandler$3
  implements BusinessObserver
{
  StatusJsHandler$3(StatusJsHandler paramStatusJsHandler) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.a(2131695222);
    }
    for (;;)
    {
      this.a.a(this.a.c, "false");
      return;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          localGetPublicAccountDetailInfoResponse.mergeFrom(paramBundle);
          if ((localGetPublicAccountDetailInfoResponse.ret_info.has()) && (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.has()) && (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0))
          {
            if ((this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null))
            {
              paramBundle = new AccountDetail(localGetPublicAccountDetailInfoResponse);
              this.a.a(localBaseActivity, paramBundle);
              StatusJsHandler.a(this.a, localBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
            }
          }
          else {
            this.a.a(2131695222);
          }
        }
        else
        {
          this.a.a(2131695222);
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusJsHandler.3
 * JD-Core Version:    0.7.0.1
 */