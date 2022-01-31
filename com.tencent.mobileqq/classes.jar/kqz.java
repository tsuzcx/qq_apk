import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class kqz
  implements BusinessObserver
{
  public kqz(EqqAccountDetailActivity paramEqqAccountDetailActivity, PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt1, int paramInt2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "success:" + String.valueOf(paramBoolean));
    }
    EqqAccountDetailActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity);
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.d(2131430035);
    }
    for (;;)
    {
      EqqAccountDetailActivity.g(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity);
      if (EqqAccountDetailActivity.h(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity) == 0) {
        EqqAccountDetailActivity.f(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity);
      }
      return;
      if (paramBoolean) {
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle != null)
          {
            mobileqq_mp.SetFunctionFlagResponse localSetFunctionFlagResponse = new mobileqq_mp.SetFunctionFlagResponse();
            localSetFunctionFlagResponse.mergeFrom(paramBundle);
            if (((mobileqq_mp.RetInfo)localSetFunctionFlagResponse.ret_info.get()).ret_code.get() == 0)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.d = this.jdField_a_of_type_Int;
              this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.p();
              if (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.e == 6)
              {
                if (this.b != 1) {
                  break label316;
                }
                this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(1);
                ReportController.b(EqqAccountDetailActivity.q(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.p(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "mp_msg_ziliao_2", "share_click", 0, 0, "", "", "", "");
                ReportController.b(EqqAccountDetailActivity.r(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.q(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "0X8004F05", "0X8004F05", 0, 0, "", "", "", "");
              }
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, String.valueOf(this.b));
                }
                this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.g();
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "状态切换成功");
                }
                this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo);
                break;
                label316:
                ReportController.b(EqqAccountDetailActivity.s(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.r(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "0X8004F07", "0X8004F07", 0, 0, "", "", "", "");
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "状态切换失败1");
            }
            this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.d(2131430035);
          }
          else
          {
            this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.d(2131430035);
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "状态切换失败");
            }
          }
        }
        catch (Exception paramBundle) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqz
 * JD-Core Version:    0.7.0.1
 */