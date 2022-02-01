package com.tencent.open.agent;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.AuthCmdCost.Record;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.BusinessObserver;

class AuthorityActivity$6
  implements BusinessObserver
{
  AuthorityActivity$6(AuthorityActivity paramAuthorityActivity, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.i("AuthorityActivity", 1, "getAppInfo observer onReceive isSuccess = " + paramBoolean);
    ForwardStatisticsReporter.a("KEY_GET_APP_INFO_REQUEST", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_ComTencentOpenModelAccountInfo, paramBoolean);
    AuthorityActivity.c(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long = (System.currentTimeMillis() - AuthorityActivity.c(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long);
    Object localObject = paramBundle.getString("ssoAccount");
    if (!this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString.equals(localObject)) {
      QLog.e("AuthorityActivity", 1, "mAccount.uin != ssoAccount");
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_JavaLangRunnable);
    } while (!paramBoolean);
    GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("data");
        localObject = arrayOfByte;
        if (this.jdField_a_of_type_Boolean) {
          localObject = OpenSdkVirtualUtil.b(arrayOfByte, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_ComTencentOpenModelAccountInfo);
        }
        if (localObject == null) {
          break;
        }
        localGetAppinfoResponse.mergeFrom((byte[])localObject);
        if (!localGetAppinfoResponse.has()) {
          break;
        }
        paramInt = localGetAppinfoResponse.ret.get();
        if (paramInt == 0)
        {
          localObject = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
          ((Message)localObject).what = 3;
          ((Message)localObject).obj = localGetAppinfoResponse;
          this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject);
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("report_type", "103");
        ((Bundle)localObject).putString("act_type", "12");
        if (paramBundle.getBoolean("isShort", false))
        {
          paramBundle = "2";
          ((Bundle)localObject).putString("intext_3", paramBundle);
          ((Bundle)localObject).putString("stringext_1", AuthorityActivity.c(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_JavaLangString);
          ((Bundle)localObject).putString("intext_2", "" + paramInt);
          ((Bundle)localObject).putString("intext_5", "" + AuthorityActivity.c(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity).jdField_a_of_type_Long);
          ReportCenter.a().a((Bundle)localObject, AuthorityActivity.e, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.jdField_a_of_type_JavaLangString, false, true);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("AuthorityActivity", 1, "getAppInfoResponse deal exception : " + paramBundle.getMessage());
        paramBundle.printStackTrace();
        return;
      }
      paramBundle = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.6
 * JD-Core Version:    0.7.0.1
 */