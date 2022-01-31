import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

class rtd
  implements wiu
{
  rtd(rsv paramrsv, String paramString, boolean paramBoolean) {}
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (this.jdField_a_of_type_Rsv.a != null) {
        this.jdField_a_of_type_Rsv.l();
      }
      String str = paramBundle.getString("pic_server_id");
      this.jdField_a_of_type_Rsv.a(paramBundle);
      if ("-1".equals(str)) {
        paramBundle = new JSONObject();
      }
    }
    else
    {
      try
      {
        paramBundle.put("retCode", -1);
        paramBundle.put("msg", "fail");
        this.jdField_a_of_type_Rsv.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
        if (this.jdField_a_of_type_Boolean)
        {
          ndn.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D27", "0X8005D27", 0, -1, "1", "", "", "", false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D30", "0X8005D30", 0, -1, "1", "", "", "");
        return;
      }
    }
    this.jdField_a_of_type_Rsv.a(localJSONException, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rtd
 * JD-Core Version:    0.7.0.1
 */