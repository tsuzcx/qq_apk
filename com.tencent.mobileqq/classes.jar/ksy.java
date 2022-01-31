import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class ksy
  implements BusinessObserver
{
  public ksy(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      if (this.a.e)
      {
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter == null) {
          break label112;
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b(false);
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.c -= 1;
      if (this.a.c == 0) {
        this.a.J();
      }
      return;
      label112:
      this.a.d(2131430016);
      continue;
      if (paramBoolean) {}
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
                QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest: need update local data , new seqno = " + localGetPublicAccountDetailInfoResponse.seqno.get());
              }
              this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse = localGetPublicAccountDetailInfoResponse;
              paramBundle = new AccountDetail(this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
              if ((this.a.g) && (paramBundle.followType == 1))
              {
                this.a.a(paramBundle, false);
                continue;
              }
              this.a.a(paramBundle, true);
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest: seqno is same, no need to update, seqno = " + this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno);
            }
            if ((!this.a.g) || (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
              continue;
            }
            this.a.f();
            continue;
          }
          this.a.d(2131430016);
          continue;
        }
        if (!this.a.e) {
          continue;
        }
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter != null)
        {
          this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b(false);
          this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.notifyDataSetChanged();
          continue;
        }
        this.a.d(2131430016);
      }
      catch (Exception paramBundle) {}
      if (this.a.e) {
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter != null)
        {
          this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b(false);
          this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.notifyDataSetChanged();
        }
        else
        {
          this.a.d(2131430016);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ksy
 * JD-Core Version:    0.7.0.1
 */