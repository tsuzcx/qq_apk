import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class qke
  implements aaea
{
  qke(qka paramqka, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("ReadInJoyWebviewPlugin", 4, "receive notifyLoadSkin callback resp:" + paramBundle.toString());
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramBundle = localJSONObject.put("retCode", paramBundle.getInt("retCode")).put("skinId", "" + paramBundle.getString("skinId")).put("rate", paramBundle.getInt("rate"));
      this.jdField_a_of_type_Qka.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      QLog.w("ReadInJoyWebviewPlugin", 1, "notifyLoadSkin error " + paramBundle.toString());
      this.jdField_a_of_type_Qka.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"retCode\":-1}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qke
 * JD-Core Version:    0.7.0.1
 */