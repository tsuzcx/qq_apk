import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ork
  implements wiu
{
  ork(org paramorg, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("ReadInJoyWebviewPlugin", 4, "receive setSkinAndSound callback resp:" + paramBundle.toString());
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramBundle = localJSONObject.put("retCode", paramBundle.getInt("retCode")).put("skinId", "" + paramBundle.getString("skinId"));
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
 * Qualified Name:     ork
 * JD-Core Version:    0.7.0.1
 */