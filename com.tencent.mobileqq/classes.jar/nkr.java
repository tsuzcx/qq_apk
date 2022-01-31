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

public class nkr
  implements BusinessObserver
{
  public nkr(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow isSuccess:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.d(2131695729);
    }
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.c -= 1;
      if (this.a.c == 0) {
        this.a.L();
      }
      return;
      Object localObject = new JSONObject();
      if (this.a.d != null) {}
      try
      {
        ((JSONObject)localObject).put("uin", this.a.d);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("find.mp.qq.com");
        localArrayList.add("post.mp.qq.com");
        localArrayList.add("article.mp.qq.com");
        athj.a("unfollow", (JSONObject)localObject, localArrayList, null);
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
            nrt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.d, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
            StructLongMessageDownloadProcessor.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.d);
            if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
              continue;
            }
            ((bcml)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
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
        this.a.d(2131695729);
      }
      continue;
      label350:
      this.a.d(2131695729);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nkr
 * JD-Core Version:    0.7.0.1
 */