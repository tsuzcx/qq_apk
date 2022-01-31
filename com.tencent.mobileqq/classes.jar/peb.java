import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;

class peb
  implements spj
{
  peb(pea parampea, int paramInt, oik paramoik) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("arg_callback", paramString);
      paramString = new Bundle();
      paramString.putString("action_update_biu_and_comment_request_string", paramJSONObject.toString());
      paramString = EIPCResult.createResult(0, paramString);
      this.jdField_a_of_type_Pea.callbackResult(this.jdField_a_of_type_Int, paramString);
      this.jdField_a_of_type_Oik.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     peb
 * JD-Core Version:    0.7.0.1
 */