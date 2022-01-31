import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import mqq.observer.BusinessObserver;

public class kou
  implements BusinessObserver
{
  public kou(EqqAccountDetailActivity paramEqqAccountDetailActivity, PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "success:" + String.valueOf(paramBoolean));
    }
    EqqAccountDetailActivity.g(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.d(2131430033);
    }
    for (;;)
    {
      EqqAccountDetailActivity.i(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity);
      if (EqqAccountDetailActivity.j(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity) == 0) {
        EqqAccountDetailActivity.h(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity);
      }
      return;
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
            this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.b, this.jdField_a_of_type_Boolean);
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "状态切换成功");
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "状态切换失败1");
            }
            this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.d(2131430033);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.d(2131430033);
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "状态切换失败");
          }
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kou
 * JD-Core Version:    0.7.0.1
 */