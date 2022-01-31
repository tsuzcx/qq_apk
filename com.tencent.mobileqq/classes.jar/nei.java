import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import org.json.JSONException;
import org.json.JSONObject;

class nei
  implements View.OnClickListener
{
  nei(nea paramnea, int paramInt, String paramString, neu paramneu) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Nea.jdField_a_of_type_Ney != null)) {
        this.jdField_a_of_type_Nea.jdField_a_of_type_Ney.a(this.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      axqy.b(this.jdField_a_of_type_Nea.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_Nea.jdField_a_of_type_JavaLangString, "0X8006981", "0X8006981", 0, 0, String.valueOf(this.jdField_a_of_type_Neu.a.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Neu.a.d), String.valueOf(this.jdField_a_of_type_Neu.a.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Neu.a.jdField_b_of_type_Int));
      JSONObject localJSONObject = new JSONObject();
      if (!this.jdField_a_of_type_Nea.jdField_a_of_type_Boolean) {}
      try
      {
        localJSONObject.put("cha_1", this.jdField_a_of_type_Neu.a.jdField_b_of_type_JavaLangString);
        localJSONObject.put("cha_2", nea.a(this.jdField_a_of_type_Nea));
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_Nea.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.jdField_a_of_type_Nea.jdField_a_of_type_JavaLangString;
        int i = this.jdField_a_of_type_Neu.a.jdField_a_of_type_Int;
        long l = this.jdField_a_of_type_Neu.a.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Nea.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) {}
        for (paramView = "02";; paramView = "01")
        {
          axqy.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str, "0X80077FA", "0X80077FA", 0, 0, String.valueOf(i), String.valueOf(l), paramView, localJSONObject.toString());
          return;
          if ((this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_Nea.jdField_a_of_type_Ney == null)) {
            break;
          }
          this.jdField_a_of_type_Nea.jdField_a_of_type_Ney.a(this.jdField_a_of_type_Neu);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nei
 * JD-Core Version:    0.7.0.1
 */