import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class psg
  implements aasd
{
  psg(psd parampsd, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    QLog.d("ReadInJoyWebviewPlugin", 4, "receive readSkinAndSound callback resp:" + paramBundle.toString());
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramBundle = localJSONObject.put("retCode", paramBundle.getInt("retCode")).put("skinId", paramBundle.getString("skinId")).put("volumeIsOn", paramBundle.getInt("volumeIsOn"));
      this.jdField_a_of_type_Psd.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      QLog.w("ReadInJoyWebviewPlugin", 1, "readSkinAndSound error " + paramBundle.toString());
      this.jdField_a_of_type_Psd.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"retCode\":-1}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psg
 * JD-Core Version:    0.7.0.1
 */