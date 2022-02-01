package cooperation.qqreader.ui;

import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.net.ReaderCgiResponse;
import cooperation.qqreader.net.ReaderCgiUIThreadCallback;
import cooperation.qqreader.utils.Config.UserConfig;
import cooperation.qqreader.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;

class ForceUserUpdateActivity$5
  extends ReaderCgiUIThreadCallback
{
  ForceUserUpdateActivity$5(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: UpdateToQQBookstore error: " + paramString);
  }
  
  public void a(ReaderCgiResponse paramReaderCgiResponse)
  {
    boolean bool = false;
    JSONObject localJSONObject = paramReaderCgiResponse.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore response json is null");
      return;
    }
    catch (JSONException paramReaderCgiResponse)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore parse failed: " + paramReaderCgiResponse.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    paramReaderCgiResponse = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore ret=" + i + "|msg=" + paramReaderCgiResponse);
      return;
    }
    i = localJSONObject.optInt("err_code", 0);
    paramReaderCgiResponse = localJSONObject.optString("err_msg");
    if (i == 0) {
      bool = true;
    }
    Config.UserConfig.b(ForceUserUpdateActivity.a(this.a), bool);
    if (bool)
    {
      Log.d("ForceUserUpdateActivity", "onReceiveData: UpdateToQQBookstore succeed");
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore errMsg=" + paramReaderCgiResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ForceUserUpdateActivity.5
 * JD-Core Version:    0.7.0.1
 */