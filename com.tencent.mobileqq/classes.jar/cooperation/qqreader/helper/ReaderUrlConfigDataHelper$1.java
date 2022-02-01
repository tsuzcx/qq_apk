package cooperation.qqreader.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qqreader.net.ReaderCgiResponse;
import cooperation.qqreader.net.ReaderCgiUIThreadCallback;
import cooperation.qqreader.utils.Log;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class ReaderUrlConfigDataHelper$1
  extends ReaderCgiUIThreadCallback
{
  ReaderUrlConfigDataHelper$1(ReaderUrlConfigDataHelper paramReaderUrlConfigDataHelper) {}
  
  public void a(@NonNull ReaderCgiResponse paramReaderCgiResponse)
  {
    paramReaderCgiResponse = paramReaderCgiResponse.a();
    if (paramReaderCgiResponse == null) {
      Log.a("ReaderUrlConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (paramReaderCgiResponse.length() == 0)
      {
        Log.a("ReaderUrlConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!ReaderUrlConfigDataHelper.a(this.a, paramReaderCgiResponse));
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    ReaderUrlConfigDataHelper.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_URL_CONFIG_DATA" + str, paramReaderCgiResponse.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.helper.ReaderUrlConfigDataHelper.1
 * JD-Core Version:    0.7.0.1
 */