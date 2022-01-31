import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class kms
  implements BusinessObserver
{
  public kms(Context paramContext, QQAppInterface paramQQAppInterface, QQProgressDialog paramQQProgressDialog, EqqDetail paramEqqDetail, SessionInfo paramSessionInfo, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "success:" + String.valueOf(paramBoolean));
    }
    mobileqq_mp.FollowResponse localFollowResponse;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localFollowResponse = new mobileqq_mp.FollowResponse();
      }
    }
    for (;;)
    {
      try
      {
        localFollowResponse.mergeFrom(paramBundle);
        paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (paramInt == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType = 1;
          CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
          paramBundle = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
          if (paramBundle != null) {
            paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_CrmUtils", 4, "<<<end follow, ts=" + System.currentTimeMillis());
          }
          CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString);
          EnterpriseQQManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin, true);
          CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131430016);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
        CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
        return;
      }
      if (paramInt == 58)
      {
        CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131430024);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "PublicAccount_max_limit_false", 0, 0, "", "", "", "");
      }
      else if (paramInt == 65)
      {
        CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131430025);
      }
      else if (paramInt == 20)
      {
        CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131430026);
      }
      else
      {
        CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131430016);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
        continue;
        CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131430016);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
        continue;
        CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131430016);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kms
 * JD-Core Version:    0.7.0.1
 */