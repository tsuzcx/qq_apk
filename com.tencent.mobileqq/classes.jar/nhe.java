import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import org.json.JSONException;
import org.json.JSONObject;

class nhe
  implements View.OnClickListener
{
  nhe(ngw paramngw, int paramInt, String paramString, nhq paramnhq) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Ngw.jdField_a_of_type_Nhu != null)) {
        this.jdField_a_of_type_Ngw.jdField_a_of_type_Nhu.a(this.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_Ngw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_Ngw.jdField_a_of_type_JavaLangString, "0X8006981", "0X8006981", 0, 0, String.valueOf(this.jdField_a_of_type_Nhq.a.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Nhq.a.d), String.valueOf(this.jdField_a_of_type_Nhq.a.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Nhq.a.jdField_b_of_type_Int));
      JSONObject localJSONObject = new JSONObject();
      if (!this.jdField_a_of_type_Ngw.jdField_a_of_type_Boolean) {}
      try
      {
        localJSONObject.put("cha_1", this.jdField_a_of_type_Nhq.a.jdField_b_of_type_JavaLangString);
        localJSONObject.put("cha_2", ngw.a(this.jdField_a_of_type_Ngw));
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_Ngw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.jdField_a_of_type_Ngw.jdField_a_of_type_JavaLangString;
        int i = this.jdField_a_of_type_Nhq.a.jdField_a_of_type_Int;
        long l = this.jdField_a_of_type_Nhq.a.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Ngw.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) {}
        for (paramView = "02";; paramView = "01")
        {
          azqs.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str, "0X80077FA", "0X80077FA", 0, 0, String.valueOf(i), String.valueOf(l), paramView, localJSONObject.toString());
          return;
          if ((this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_Ngw.jdField_a_of_type_Nhu == null)) {
            break;
          }
          this.jdField_a_of_type_Ngw.jdField_a_of_type_Nhu.a(this.jdField_a_of_type_Nhq);
          break;
        }
        return;
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nhe
 * JD-Core Version:    0.7.0.1
 */