import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class npu
  implements View.OnClickListener
{
  npu(npm paramnpm, int paramInt, String paramString, nqh paramnqh) {}
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_Int == 1)
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Npm.jdField_a_of_type_Nql != null)) {
        this.jdField_a_of_type_Npm.jdField_a_of_type_Nql.a(this.jdField_a_of_type_JavaLangString);
      }
      bcst.b(this.jdField_a_of_type_Npm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_Npm.jdField_a_of_type_JavaLangString, "0X8006981", "0X8006981", 0, 0, String.valueOf(this.jdField_a_of_type_Nqh.a.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Nqh.a.d), String.valueOf(this.jdField_a_of_type_Nqh.a.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Nqh.a.jdField_b_of_type_Int));
      localJSONObject = new JSONObject();
      if (this.jdField_a_of_type_Npm.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("cha_1", this.jdField_a_of_type_Nqh.a.jdField_b_of_type_JavaLangString);
        localJSONObject.put("cha_2", npm.a(this.jdField_a_of_type_Npm));
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_Npm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str2 = this.jdField_a_of_type_Npm.jdField_a_of_type_JavaLangString;
        int i = this.jdField_a_of_type_Nqh.a.jdField_a_of_type_Int;
        long l = this.jdField_a_of_type_Nqh.a.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Npm.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1) {
          continue;
        }
        str1 = "02";
        bcst.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str2, "0X80077FA", "0X80077FA", 0, 0, String.valueOf(i), String.valueOf(l), str1, localJSONObject.toString());
      }
      catch (JSONException localJSONException)
      {
        String str1;
        localJSONException.printStackTrace();
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_Npm.jdField_a_of_type_Nql == null)) {
        break;
      }
      this.jdField_a_of_type_Npm.jdField_a_of_type_Nql.a(this.jdField_a_of_type_Nqh);
      break;
      str1 = "01";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npu
 * JD-Core Version:    0.7.0.1
 */