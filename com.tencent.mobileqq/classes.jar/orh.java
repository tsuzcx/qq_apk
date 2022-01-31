import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class orh
  implements wiu
{
  orh(org paramorg, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    QLog.d("ReadInJoyWebviewPlugin", 4, "receive readSkinAndSound callback resp:" + paramBundle.toString());
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramBundle = localJSONObject.put("retCode", paramBundle.getInt("retCode")).put("skinId", paramBundle.getString("skinId")).put("volumeIsOn", paramBundle.getInt("volumeIsOn"));
      this.jdField_a_of_type_Org.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      QLog.w("ReadInJoyWebviewPlugin", 1, "readSkinAndSound error " + paramBundle.toString());
      this.jdField_a_of_type_Org.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"retCode\":-1}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orh
 * JD-Core Version:    0.7.0.1
 */