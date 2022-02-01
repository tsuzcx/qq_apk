import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class nvc
  implements BusinessObserver
{
  public nvc(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow isSuccess:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.d(2131694659);
    }
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.c -= 1;
      if (this.a.c == 0) {
        this.a.M();
      }
      return;
      Object localObject = new JSONObject();
      if (this.a.e != null) {}
      try
      {
        ((JSONObject)localObject).put("uin", this.a.e);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("find.mp.qq.com");
        localArrayList.add("post.mp.qq.com");
        localArrayList.add("article.mp.qq.com");
        awgm.a("unfollow", (JSONObject)localObject, localArrayList, null);
        if (!paramBoolean) {
          break label350;
        }
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            continue;
          }
          localObject = new mobileqq_mp.UnFollowResponse();
          ((mobileqq_mp.UnFollowResponse)localObject).mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)((mobileqq_mp.UnFollowResponse)localObject).ret_info.get()).ret_code.get() == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow success");
            }
            this.a.h();
            ocd.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.e, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
            StructLongMessageDownloadProcessor.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.e);
            if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
              continue;
            }
            ((bgre)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
          }
        }
        catch (Exception paramBundle) {}
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        this.a.d(2131694659);
      }
      continue;
      label350:
      this.a.d(2131694659);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nvc
 * JD-Core Version:    0.7.0.1
 */