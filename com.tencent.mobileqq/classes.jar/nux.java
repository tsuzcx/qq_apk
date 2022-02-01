import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

public class nux
  implements BusinessObserver
{
  public nux(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      if (this.a.jdField_c_of_type_Boolean)
      {
        if (this.a.jdField_a_of_type_Nrk == null) {
          break label112;
        }
        this.a.jdField_a_of_type_Nrk.b(false);
        this.a.jdField_a_of_type_Nrk.notifyDataSetChanged();
      }
    }
    label393:
    label467:
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.jdField_c_of_type_Int -= 1;
      if (this.a.jdField_c_of_type_Int == 0) {
        this.a.M();
      }
      return;
      label112:
      this.a.d(2131694659);
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
            break label535;
          }
          paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          localGetPublicAccountDetailInfoResponse = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
          if (paramInt != 0) {
            break label339;
          }
          paramBundle.mergeFrom(arrayOfByte);
          paramBoolean = true;
          if (!paramBoolean) {
            break label479;
          }
          if (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() != 0) {
            break label467;
          }
          if ((this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && ((!paramBundle.seqno.has()) || (paramBundle.seqno.get() == this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno))) {
            break label393;
          }
          if (QLog.isColorLevel()) {
            QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest: need update local data , new seqno = " + paramBundle.seqno.get());
          }
          this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse = paramBundle;
          paramBundle = new AccountDetail(this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
          if (!tzq.a(paramBundle)) {
            break label351;
          }
          this.a.O();
        }
        catch (Exception paramBundle)
        {
          this.a.d(2131694659);
          QLog.w("com.tencent.biz.pubaccount.AccountDetailActivity", 4, paramBundle.getMessage(), paramBundle);
        }
        break;
        label339:
        paramBoolean = tzq.a(arrayOfByte, localGetPublicAccountDetailInfoResponse, paramBundle);
      }
      label351:
      if ((this.a.e) && (paramBundle.followType == 1))
      {
        this.a.a(paramBundle, false);
      }
      else
      {
        this.a.a(paramBundle, true);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest: seqno is same, no need to update, seqno = " + this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno);
        }
        if ((this.a.e) && (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1))
        {
          this.a.f();
          continue;
          this.a.d(2131694659);
          continue;
          label479:
          if (this.a.jdField_c_of_type_Boolean) {
            if (this.a.jdField_a_of_type_Nrk != null)
            {
              this.a.jdField_a_of_type_Nrk.b(false);
              this.a.jdField_a_of_type_Nrk.notifyDataSetChanged();
            }
            else
            {
              this.a.d(2131694659);
              continue;
              if (this.a.jdField_c_of_type_Boolean) {
                if (this.a.jdField_a_of_type_Nrk != null)
                {
                  this.a.jdField_a_of_type_Nrk.b(false);
                  this.a.jdField_a_of_type_Nrk.notifyDataSetChanged();
                }
                else
                {
                  this.a.d(2131694659);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nux
 * JD-Core Version:    0.7.0.1
 */