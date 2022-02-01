import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class nrs
  implements View.OnClickListener
{
  nrs(nrk paramnrk, int paramInt, String paramString, nsf paramnsf) {}
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_Int == 1)
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Nrk.jdField_a_of_type_Nsj != null)) {
        this.jdField_a_of_type_Nrk.jdField_a_of_type_Nsj.a(this.jdField_a_of_type_JavaLangString);
      }
      bdll.b(this.jdField_a_of_type_Nrk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_Nrk.jdField_a_of_type_JavaLangString, "0X8006981", "0X8006981", 0, 0, String.valueOf(this.jdField_a_of_type_Nsf.a.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Nsf.a.d), String.valueOf(this.jdField_a_of_type_Nsf.a.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Nsf.a.jdField_b_of_type_Int));
      localJSONObject = new JSONObject();
      if (this.jdField_a_of_type_Nrk.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("cha_1", this.jdField_a_of_type_Nsf.a.jdField_b_of_type_JavaLangString);
        localJSONObject.put("cha_2", nrk.a(this.jdField_a_of_type_Nrk));
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_Nrk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str2 = this.jdField_a_of_type_Nrk.jdField_a_of_type_JavaLangString;
        int i = this.jdField_a_of_type_Nsf.a.jdField_a_of_type_Int;
        long l = this.jdField_a_of_type_Nsf.a.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Nrk.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1) {
          continue;
        }
        str1 = "02";
        bdll.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str2, "0X80077FA", "0X80077FA", 0, 0, String.valueOf(i), String.valueOf(l), str1, localJSONObject.toString());
      }
      catch (JSONException localJSONException)
      {
        String str1;
        localJSONException.printStackTrace();
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_Nrk.jdField_a_of_type_Nsj == null)) {
        break;
      }
      this.jdField_a_of_type_Nrk.jdField_a_of_type_Nsj.a(this.jdField_a_of_type_Nsf);
      break;
      str1 = "01";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrs
 * JD-Core Version:    0.7.0.1
 */