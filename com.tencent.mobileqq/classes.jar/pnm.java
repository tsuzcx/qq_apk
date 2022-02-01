import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;

class pnm
  implements tfg
{
  pnm(pnl parampnl, int paramInt, ono paramono) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("arg_callback", paramString);
      paramString = new Bundle();
      paramString.putString("action_update_biu_and_comment_request_string", paramJSONObject.toString());
      paramString = EIPCResult.createResult(0, paramString);
      this.jdField_a_of_type_Pnl.callbackResult(this.jdField_a_of_type_Int, paramString);
      this.jdField_a_of_type_Ono.a();
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnm
 * JD-Core Version:    0.7.0.1
 */