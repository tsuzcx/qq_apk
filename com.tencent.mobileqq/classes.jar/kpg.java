import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.activity.PubAccountMoreInfoActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class kpg
  implements BusinessObserver
{
  public kpg(PubAccountMoreInfoActivity paramPubAccountMoreInfoActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMoreInfoActivity", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.a(2131430033);
    }
    for (;;)
    {
      return;
      if (paramBoolean) {
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle != null)
          {
            mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
            localGetPublicAccountDetailInfoResponse.mergeFrom(paramBundle);
            if (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0)
            {
              if ((this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || ((localGetPublicAccountDetailInfoResponse.seqno.has()) && (localGetPublicAccountDetailInfoResponse.seqno.get() != this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("PubAccountMoreInfoActivity", 2, "sendPublicAccountDetailInfoRequest: need update local data , new seqno = " + localGetPublicAccountDetailInfoResponse.seqno.get());
                }
                this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse = localGetPublicAccountDetailInfoResponse;
                this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = new AccountDetail(this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
                PubAccountMoreInfoActivity.a(this.a);
              }
            }
            else
            {
              this.a.a(2131430033);
              return;
            }
          }
        }
        catch (Exception paramBundle) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kpg
 * JD-Core Version:    0.7.0.1
 */