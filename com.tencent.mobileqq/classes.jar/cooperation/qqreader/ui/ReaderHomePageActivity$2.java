package cooperation.qqreader.ui;

import android.support.annotation.NonNull;
import cooperation.qqreader.net.ReaderCgiResponse;
import cooperation.qqreader.net.ReaderCgiUIThreadCallback;
import cooperation.qqreader.utils.Config.UserConfig;
import cooperation.qqreader.utils.Log;
import org.json.JSONObject;

class ReaderHomePageActivity$2
  extends ReaderCgiUIThreadCallback
{
  ReaderHomePageActivity$2(ReaderHomePageActivity paramReaderHomePageActivity) {}
  
  public void a(@NonNull ReaderCgiResponse paramReaderCgiResponse)
  {
    paramReaderCgiResponse = paramReaderCgiResponse.a();
    if (paramReaderCgiResponse == null) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = paramReaderCgiResponse.getJSONObject("data").getInt("identity");
        paramReaderCgiResponse = this.a;
        if (i == 2)
        {
          bool = true;
          Config.UserConfig.e(paramReaderCgiResponse, bool);
          Log.d("ReaderHomePageActivity", "queryUserIdentityForTabSwitch: identity = " + i);
          return;
        }
      }
      catch (Exception paramReaderCgiResponse)
      {
        Log.a("ReaderHomePageActivity", "queryUserIdentityForTabSwitch:", paramReaderCgiResponse);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderHomePageActivity.2
 * JD-Core Version:    0.7.0.1
 */