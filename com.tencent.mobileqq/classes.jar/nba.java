import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class nba
  implements BusinessObserver
{
  nba(Context paramContext, QQAppInterface paramQQAppInterface, bcqf parambcqf, SessionInfo paramSessionInfo, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "success:" + String.valueOf(paramBoolean));
    }
    mobileqq_mp.GetEqqAccountDetailInfoResponse localGetEqqAccountDetailInfoResponse;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localGetEqqAccountDetailInfoResponse = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      }
    }
    for (;;)
    {
      try
      {
        localGetEqqAccountDetailInfoResponse.mergeFrom(paramBundle);
        if (((mobileqq_mp.RetInfo)localGetEqqAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0)
        {
          paramBundle = new EqqDetail(localGetEqqAccountDetailInfoResponse);
          naz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
          naz.a(this.jdField_a_of_type_Bcqf);
          if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_CrmUtils", 4, "<<<end getDetail, ts=" + System.currentTimeMillis());
          }
          naz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramBundle, this.jdField_a_of_type_JavaLangString);
          naz.a(this.jdField_a_of_type_Bcqf);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        naz.a(this.jdField_a_of_type_AndroidContentContext, 2131695569);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
        naz.a(this.jdField_a_of_type_Bcqf);
        return;
      }
      naz.a(this.jdField_a_of_type_AndroidContentContext, 2131695569);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
      continue;
      naz.a(this.jdField_a_of_type_AndroidContentContext, 2131695569);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
      continue;
      naz.a(this.jdField_a_of_type_AndroidContentContext, 2131695569);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nba
 * JD-Core Version:    0.7.0.1
 */