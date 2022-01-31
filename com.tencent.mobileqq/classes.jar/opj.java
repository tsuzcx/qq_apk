import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class opj
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("NativeProteusBidConfigHandler", 1, "[onReceiveConfig] " + paramString);
    for (;;)
    {
      try
      {
        Object localObject1 = ooi.a(paramString);
        Object localObject2 = ((Map)localObject1).keySet();
        paramString = new JSONObject();
        paramInt1 = 0;
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          String str1 = (String)((Iterator)localObject2).next();
          String str2 = (String)((Map)localObject1).get(str1);
          if (!TextUtils.isEmpty(str2))
          {
            paramString.put(str1, str2);
            paramInt1 = 1;
          }
        }
        else
        {
          if (paramInt1 != 0)
          {
            localObject1 = onk.a();
            if (localObject1 != null)
            {
              bhvh.a((AppRuntime)localObject1, "local_kd_native_main_text_style", paramString.toString());
              QLog.d("NativeProteusBidConfigHandler", 1, "[onReceiveConfig],content: " + paramString.toString());
            }
          }
          return true;
        }
      }
      catch (Exception paramString)
      {
        return true;
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    AppRuntime localAppRuntime = onk.a();
    if (localAppRuntime != null) {
      bhvh.a(localAppRuntime, "local_kd_native_main_text_style", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opj
 * JD-Core Version:    0.7.0.1
 */