import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.biz.webviewplugin.HotchatPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class pbg
  implements TroopMemberApiClient.Callback
{
  public pbg(HotchatPlugin paramHotchatPlugin, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    Object localObject = null;
    String str;
    if (paramBundle != null)
    {
      str = paramBundle.getString("content");
      paramBundle = paramBundle.getString("url");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("content", str);
      localJSONObject.put("url", paramBundle);
      paramBundle = localJSONObject.toString();
      this.jdField_a_of_type_ComTencentBizWebviewpluginHotchatPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        paramBundle = localObject;
        if (QLog.isColorLevel())
        {
          QLog.i("HotchatPlugin", 2, localJSONException.getMessage());
          paramBundle = localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbg
 * JD-Core Version:    0.7.0.1
 */