package cooperation.qqreader.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.net.ReaderCgiResponse;
import cooperation.qqreader.net.ReaderCgiUIThreadCallback;
import cooperation.qqreader.utils.Config.UserConfig;
import cooperation.qqreader.utils.Log;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

class ForceUserUpdateActivity$3
  extends ReaderCgiUIThreadCallback
{
  ForceUserUpdateActivity$3(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: FetchTabConfigData error: " + paramString);
  }
  
  public void a(ReaderCgiResponse paramReaderCgiResponse)
  {
    int j = 0;
    i = 0;
    paramReaderCgiResponse = paramReaderCgiResponse.a();
    if ((paramReaderCgiResponse == null) || (paramReaderCgiResponse.length() == 0)) {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: FetchTabConfigData response illegal: " + paramReaderCgiResponse);
    }
    for (;;)
    {
      if (i == 0) {
        ForceUserUpdateActivity.b(this.a, "拉取新书城配置失败，请检查网络重试");
      }
      return;
      for (;;)
      {
        for (;;)
        {
          try
          {
            localObject = (JSONArray)paramReaderCgiResponse.get("tabList");
            if ((localObject != null) && (((JSONArray)localObject).length() > 0))
            {
              Log.d("ForceUserUpdateActivity", "onReceiveData: FetchTabConfigData succeed, length = " + ((JSONArray)localObject).length());
              localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
              ForceUserUpdateActivity.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + (String)localObject, paramReaderCgiResponse.toString()).apply();
              Config.UserConfig.d(ForceUserUpdateActivity.a(this.a), true);
            }
          }
          catch (Exception paramReaderCgiResponse)
          {
            Object localObject;
            i = j;
          }
          try
          {
            ForceUserUpdateActivity.b(this.a);
            i = 1;
          }
          catch (Exception paramReaderCgiResponse)
          {
            for (;;)
            {
              i = 1;
            }
          }
        }
        ForceUserUpdateActivity.a(this.a, "onReceiveData: FetchTabConfigData empty: " + localObject);
        i = 0;
      }
      ForceUserUpdateActivity.a(this.a, "onReceiveData: FetchTabConfigData parse failed: " + paramReaderCgiResponse.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ForceUserUpdateActivity.3
 * JD-Core Version:    0.7.0.1
 */