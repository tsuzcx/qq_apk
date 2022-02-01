package cooperation.qqreader.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qqreader.net.ReaderCgiResponse;
import cooperation.qqreader.net.ReaderCgiUIThreadCallback;
import cooperation.qqreader.utils.Log;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class ReaderTabConfigDataHelper$2
  extends ReaderCgiUIThreadCallback
{
  ReaderTabConfigDataHelper$2(ReaderTabConfigDataHelper paramReaderTabConfigDataHelper) {}
  
  public void a(ReaderCgiResponse paramReaderCgiResponse)
  {
    paramReaderCgiResponse = paramReaderCgiResponse.a();
    if (paramReaderCgiResponse == null) {
      Log.a("ReaderTabConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (paramReaderCgiResponse.length() == 0)
      {
        Log.a("ReaderTabConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!ReaderTabConfigDataHelper.a(this.a, paramReaderCgiResponse, false));
    ReaderTabConfigDataHelper.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramReaderCgiResponse.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.helper.ReaderTabConfigDataHelper.2
 * JD-Core Version:    0.7.0.1
 */