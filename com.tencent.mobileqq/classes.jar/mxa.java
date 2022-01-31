import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity.9.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

public class mxa
  extends akih
{
  public mxa(AccountDetailActivity paramAccountDetailActivity) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      paramObject = new JSONObject();
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {}
    }
    try
    {
      paramObject.put("uin", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      paramObject.put("name", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
      paramObject.put("summary", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
      paramObject.put("certified", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("find.mp.qq.com");
      localArrayList.add("post.mp.qq.com");
      localArrayList.add("article.mp.qq.com");
      aqrr.a("follow", paramObject, localArrayList, null);
      if (this.a.jdField_f_of_type_Boolean)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
        {
          paramObject = this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
          awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.d, "mp_msg_sys_12", "scan_via", 0, 0, paramObject, "", "", this.a.jdField_f_of_type_JavaLangString);
        }
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType = 1;
        this.a.jdField_b_of_type_AndroidViewView.setEnabled(false);
        this.a.H();
        this.a.i();
        this.a.y();
        AccountDetailActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.d, this.a.jdField_a_of_type_AndroidContentIntent);
        if ((!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString)))
        {
          awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", this.a.jdField_b_of_type_JavaLangString, this.a.jdField_c_of_type_JavaLangString, 0, 0, "", "", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.d);
          if (QLog.isColorLevel()) {
            QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "----[follow report done]----");
          }
        }
        if (this.a.g == 50) {
          AccountDetailActivity.a(this.a, 1);
        }
        if ((this.a.h == 115) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          ((ngh)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).a(134247140, this.a.d, null, null, null, 0L, false);
        }
        if (this.a.jdField_a_of_type_AndroidContentIntent.hasExtra("report_business_tvalue"))
        {
          int i = this.a.jdField_a_of_type_AndroidContentIntent.getIntExtra("report_business_tvalue", -1);
          paramObject = this.a.jdField_a_of_type_AndroidContentIntent.getStringExtra("strp1");
          if (i != -1) {
            ((ngh)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).a(i, this.a.d, paramObject, null, null, 0L, false);
          }
        }
        return;
      }
    }
    catch (JSONException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
        continue;
        paramObject = "";
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    this.a.d(2131629887);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    paramObject = this.a;
    paramObject.jdField_c_of_type_Int -= 1;
    if (this.a.jdField_c_of_type_Int == 0) {
      this.a.L();
    }
    this.a.jdField_b_of_type_AndroidViewView.postDelayed(new AccountDetailActivity.9.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxa
 * JD-Core Version:    0.7.0.1
 */