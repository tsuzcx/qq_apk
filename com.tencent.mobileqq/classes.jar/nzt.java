import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.activity.PubAccountMoreInfoActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

public class nzt
  implements BusinessObserver
{
  public nzt(PubAccountMoreInfoActivity paramPubAccountMoreInfoActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMoreInfoActivity", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      this.a.a(2131694983);
      return;
    }
    for (;;)
    {
      byte[] arrayOfByte;
      oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse;
      try
      {
        arrayOfByte = paramBundle.getByteArray("data");
        paramInt = paramBundle.getInt("type", 0);
        if (arrayOfByte == null) {
          break;
        }
        paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        localGetPublicAccountDetailInfoResponse = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
        if (paramInt == 0)
        {
          paramBundle.mergeFrom(arrayOfByte);
          paramBoolean = true;
          if (!paramBoolean) {
            break;
          }
          if (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() != 0) {
            break label259;
          }
          if ((this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && ((!paramBundle.seqno.has()) || (paramBundle.seqno.get() == this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno))) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PubAccountMoreInfoActivity", 2, "sendPublicAccountDetailInfoRequest: need update local data , new seqno = " + paramBundle.seqno.get());
          }
          this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse = paramBundle;
          this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = new AccountDetail(this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
          PubAccountMoreInfoActivity.a(this.a);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        this.a.a(2131694983);
        return;
      }
      paramBoolean = uuc.a(arrayOfByte, localGetPublicAccountDetailInfoResponse, paramBundle);
    }
    label259:
    this.a.a(2131694983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzt
 * JD-Core Version:    0.7.0.1
 */