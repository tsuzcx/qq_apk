package cooperation.qqreader.ui;

import android.content.res.Resources;
import android.widget.TextView;
import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.net.ReaderCgiResponse;
import cooperation.qqreader.net.ReaderCgiUIThreadCallback;
import cooperation.qqreader.utils.Config.UserConfig;
import cooperation.qqreader.utils.Log;
import org.json.JSONObject;

class ForceUserUpdateActivity$4
  extends ReaderCgiUIThreadCallback
{
  ForceUserUpdateActivity$4(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: QueryGrayUpdate error: " + paramString);
  }
  
  public void a(ReaderCgiResponse paramReaderCgiResponse)
  {
    JSONObject localJSONObject = paramReaderCgiResponse.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: QueryGrayUpdate response json is null");
      return;
    }
    catch (Exception paramReaderCgiResponse)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: QueryGrayUpdate parse failed: " + paramReaderCgiResponse.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    paramReaderCgiResponse = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: QueryGrayUpdate ret=" + i + "|msg=" + paramReaderCgiResponse);
      return;
    }
    i = localJSONObject.optInt("gray_level", 0);
    int j = localJSONObject.optInt("updateStatus", 0);
    int k = localJSONObject.optInt("updateStatus", 0);
    int m = localJSONObject.optInt("remainMaxTime", 0);
    Config.UserConfig.a(ForceUserUpdateActivity.a(this.a), i);
    Config.UserConfig.b(ForceUserUpdateActivity.a(this.a), j);
    Config.UserConfig.c(ForceUserUpdateActivity.a(this.a), k);
    Config.UserConfig.d(ForceUserUpdateActivity.a(this.a), m);
    Log.d("ForceUserUpdateActivity", "onReceiveData: QueryGrayUpdate result: level=" + i + "|status=" + j + "|remain=" + m + "|interval=" + k);
    if (j == 1)
    {
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    if (j == 2)
    {
      ForceUserUpdateActivity.a(this.a, k);
      ForceUserUpdateActivity.a(this.a).setText(this.a.getResources().getString(2131716995, new Object[] { Integer.valueOf(m) }));
      return;
    }
    ForceUserUpdateActivity.d(this.a);
    Config.UserConfig.b(ForceUserUpdateActivity.a(this.a), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ForceUserUpdateActivity.4
 * JD-Core Version:    0.7.0.1
 */