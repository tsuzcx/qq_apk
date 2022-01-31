import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

public class nhu
  implements BusinessObserver
{
  public nhu(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      if (this.a.jdField_c_of_type_Boolean)
      {
        if (this.a.jdField_a_of_type_Ned == null) {
          break label112;
        }
        this.a.jdField_a_of_type_Ned.b(false);
        this.a.jdField_a_of_type_Ned.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.jdField_c_of_type_Int -= 1;
      if (this.a.jdField_c_of_type_Int == 0) {
        this.a.L();
      }
      return;
      label112:
      this.a.d(2131695568);
      continue;
      for (;;)
      {
        byte[] arrayOfByte;
        oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse;
        try
        {
          arrayOfByte = paramBundle.getByteArray("data");
          paramInt = paramBundle.getInt("type", 0);
          if (arrayOfByte == null) {
            break label518;
          }
          paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          localGetPublicAccountDetailInfoResponse = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
          if (paramInt != 0) {
            break label352;
          }
          paramBundle.mergeFrom(arrayOfByte);
          paramBoolean = true;
          if (!paramBoolean) {
            break label462;
          }
          if (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() != 0) {
            break label450;
          }
          if ((this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && ((!paramBundle.seqno.has()) || (paramBundle.seqno.get() == this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno))) {
            break label376;
          }
          if (QLog.isColorLevel()) {
            QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest: need update local data , new seqno = " + paramBundle.seqno.get());
          }
          this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse = paramBundle;
          paramBundle = new AccountDetail(this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
          if ((!this.a.e) || (paramBundle.followType != 1)) {
            break label364;
          }
          this.a.a(paramBundle, false);
        }
        catch (Exception paramBundle)
        {
          this.a.d(2131695568);
          QLog.w("com.tencent.biz.pubaccount.AccountDetailActivity", 4, paramBundle.getMessage(), paramBundle);
        }
        break;
        label352:
        paramBoolean = sgj.a(arrayOfByte, localGetPublicAccountDetailInfoResponse, paramBundle);
      }
      label364:
      this.a.a(paramBundle, true);
      continue;
      label376:
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest: seqno is same, no need to update, seqno = " + this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno);
      }
      label518:
      if ((this.a.e) && (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1))
      {
        this.a.f();
        continue;
        label450:
        this.a.d(2131695568);
        continue;
        label462:
        if (this.a.jdField_c_of_type_Boolean) {
          if (this.a.jdField_a_of_type_Ned != null)
          {
            this.a.jdField_a_of_type_Ned.b(false);
            this.a.jdField_a_of_type_Ned.notifyDataSetChanged();
          }
          else
          {
            this.a.d(2131695568);
            continue;
            if (this.a.jdField_c_of_type_Boolean) {
              if (this.a.jdField_a_of_type_Ned != null)
              {
                this.a.jdField_a_of_type_Ned.b(false);
                this.a.jdField_a_of_type_Ned.notifyDataSetChanged();
              }
              else
              {
                this.a.d(2131695568);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhu
 * JD-Core Version:    0.7.0.1
 */