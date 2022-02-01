package cooperation.qqreader.shadow;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import cooperation.qqreader.net.ReaderCgiNetThreadCallback;
import cooperation.qqreader.net.ReaderCgiResponse;
import cooperation.qqreader.utils.Log;
import org.json.JSONObject;

class ReaderShadowGrayManager$1
  extends ReaderCgiNetThreadCallback
{
  public void b(@NonNull ReaderCgiResponse paramReaderCgiResponse)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        paramReaderCgiResponse = paramReaderCgiResponse.a();
        Log.c("ReaderShadowGrayManager", "onReceiveDataOnSubThread: jsonResult:" + paramReaderCgiResponse);
        if (paramReaderCgiResponse == null) {
          break;
        }
        if (paramReaderCgiResponse.length() == 0) {
          return;
        }
        if ((paramReaderCgiResponse.getInt("ret") == 0) && (paramReaderCgiResponse.getJSONObject("data").getBoolean("isGrayUser")))
        {
          bool = true;
          ReaderShadowGrayManager.a(true);
          paramReaderCgiResponse = ReaderShadowGrayManager.a().edit();
          if (!bool) {
            break label140;
          }
          paramReaderCgiResponse.putInt("KEY_SHADOW_GRAY", i).apply();
          Log.c("ReaderShadowGrayManager", "onReceiveDataOnSubThread: result=" + bool);
          return;
        }
      }
      catch (Exception paramReaderCgiResponse)
      {
        Log.a("ReaderShadowGrayManager", "onReceiveDataOnSubThread: Exception happened ---> ", paramReaderCgiResponse);
        return;
      }
      boolean bool = false;
      continue;
      label140:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.shadow.ReaderShadowGrayManager.1
 * JD-Core Version:    0.7.0.1
 */