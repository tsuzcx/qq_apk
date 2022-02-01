import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class pxx
  implements zop
{
  pxx(pxw parampxw, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("ALD_CONFIG_RESULT", "");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("value", paramBundle);
      this.jdField_a_of_type_Pxw.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyWebviewPlugin", 2, "Error in value:" + paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxx
 * JD-Core Version:    0.7.0.1
 */