package cooperation.comic.jsp;

import android.os.SystemClock;
import android.text.TextUtils;
import bfab;
import bfas;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class QQComicJsPlugin$3
  implements Runnable
{
  public QQComicJsPlugin$3(bfab parambfab, long paramLong, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "waitPluginAndHandleJsCall start");
    }
    if (!bfas.a)
    {
      bfas.a(BaseApplication.getContext());
      for (long l = 0L; (!bfas.a) && (l < this.jdField_a_of_type_Long); l += 50L) {
        SystemClock.sleep(50L);
      }
    }
    if (bfas.a) {
      ThreadManager.getUIHandler().post(new QQComicJsPlugin.3.1(this));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "waitPluginAndHandleJsCall end");
      }
      return;
      if (TextUtils.isEmpty(this.b)) {
        continue;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("code", 2001);
        localJSONObject.put("message", "QQComic is not ready");
        bfab.b(this.this$0, this.b, new String[] { localJSONObject.toString() });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.comic.jsp.QQComicJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */