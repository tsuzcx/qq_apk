import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class nom
  implements BusinessObserver
{
  nom(Context paramContext, QQAppInterface paramQQAppInterface, bjbs parambjbs, EqqDetail paramEqqDetail, SessionInfo paramSessionInfo, String paramString) {}
  
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
          nok.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
          paramBundle = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
          if (paramBundle != null) {
            paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_CrmUtils", 4, "<<<end follow, ts=" + System.currentTimeMillis());
          }
          nok.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString);
          asuw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin, true);
          nok.a(this.jdField_a_of_type_Bjbs);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        nok.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
        nok.a(this.jdField_a_of_type_Bjbs);
        return;
      }
      if (paramInt == 58)
      {
        nok.a(this.jdField_a_of_type_AndroidContentContext, 2131694656);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "PublicAccount_max_limit_false", 0, 0, "", "", "", "");
      }
      else if (paramInt == 65)
      {
        nok.a(this.jdField_a_of_type_AndroidContentContext, 2131694633);
      }
      else if (paramInt == 20)
      {
        nok.a(this.jdField_a_of_type_AndroidContentContext, 2131694634);
      }
      else
      {
        nok.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
        continue;
        nok.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
        continue;
        nok.a(this.jdField_a_of_type_AndroidContentContext, 2131694659);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nom
 * JD-Core Version:    0.7.0.1
 */