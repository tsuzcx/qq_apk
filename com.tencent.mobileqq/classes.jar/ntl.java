import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity.8.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class ntl
  implements BusinessObserver
{
  public ntl(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "follow isSuccess:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.d(2131694617);
    }
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.jdField_c_of_type_Int -= 1;
      if (this.a.jdField_c_of_type_Int == 0) {
        this.a.M();
      }
      this.a.jdField_b_of_type_AndroidViewView.postDelayed(new AccountDetailActivity.8.1(this), 2000L);
      return;
      Object localObject = new JSONObject();
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {}
      try
      {
        ((JSONObject)localObject).put("uin", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
        ((JSONObject)localObject).put("name", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
        ((JSONObject)localObject).put("summary", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
        ((JSONObject)localObject).put("certified", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("find.mp.qq.com");
        localArrayList.add("post.mp.qq.com");
        localArrayList.add("article.mp.qq.com");
        avob.a("follow", (JSONObject)localObject, localArrayList, null);
        if (!paramBoolean) {
          break label748;
        }
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            continue;
          }
          localObject = new mobileqq_mp.FollowResponse();
          ((mobileqq_mp.FollowResponse)localObject).mergeFrom(paramBundle);
          paramInt = ((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.get();
          if (paramInt == 0) {
            if (this.a.f)
            {
              if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
              {
                paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
                bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.e, "mp_msg_sys_12", "scan_via", 0, 0, paramBundle, "", "", this.a.jdField_g_of_type_JavaLangString);
              }
            }
            else
            {
              this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType = 1;
              this.a.jdField_b_of_type_AndroidViewView.setEnabled(false);
              this.a.I();
              this.a.i();
              this.a.z();
              AccountDetailActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.e, this.a.jdField_a_of_type_AndroidContentIntent);
              if ((!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString)))
              {
                bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", this.a.jdField_b_of_type_JavaLangString, this.a.jdField_c_of_type_JavaLangString, 0, 0, "", "", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.e);
                if (QLog.isColorLevel()) {
                  QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "----[follow report done]----");
                }
              }
              if (this.a.jdField_g_of_type_Int == 50) {
                AccountDetailActivity.a(this.a, 1);
              }
              if ((this.a.h == 115) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
                ((odu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).a(134247140, this.a.e, null, null, null, 0L, false);
              }
              if (!this.a.jdField_a_of_type_AndroidContentIntent.hasExtra("report_business_tvalue")) {
                continue;
              }
              paramInt = this.a.jdField_a_of_type_AndroidContentIntent.getIntExtra("report_business_tvalue", -1);
              paramBundle = this.a.jdField_a_of_type_AndroidContentIntent.getStringExtra("strp1");
              if (paramInt == -1) {
                continue;
              }
              ((odu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).a(paramInt, this.a.e, paramBundle, null, null, 0L, false);
            }
          }
        }
        catch (Exception paramBundle) {}
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          continue;
          paramBundle = "";
        }
        if (paramInt == 58)
        {
          this.a.d(2131694614);
          continue;
        }
        if (paramInt == 65)
        {
          this.a.d(2131694591);
          continue;
        }
        this.a.d(2131694617);
      }
      continue;
      label748:
      this.a.d(2131694617);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ntl
 * JD-Core Version:    0.7.0.1
 */