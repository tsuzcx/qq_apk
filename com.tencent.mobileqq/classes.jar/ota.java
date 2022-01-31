import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class ota
  implements AladdinConfigHandler
{
  public static int a(AppRuntime paramAppRuntime, int paramInt)
  {
    int i = 1;
    if (paramAppRuntime == null)
    {
      QLog.e("ChannelListDynamicOrder", 1, "getSharedPreferences: return null for runtime is null");
      return 0;
    }
    paramAppRuntime = "readinjoy_channel_list_dynamic_order_changed_map_" + paramAppRuntime.getAccount();
    if (BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, 0).getBoolean("channel_" + paramInt, false)) {}
    for (paramInt = i;; paramInt = 0) {
      return paramInt;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("ChannelListDynamicOrder", 1, "getSharedPreferences: return null for runtime is null");
      return;
    }
    paramAppRuntime = "readinjoy_channel_list_dynamic_order_changed_map_" + paramAppRuntime.getAccount();
    BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, 0).edit().putBoolean("channel_" + paramInt, true).apply();
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("ChannelListDynamicOrder", 2, "[onReceiveConfig] " + paramString);
    paramString = osq.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      if (TextUtils.equals("channel_list_dynamic_order_switch", str1)) {
        bkbq.a("sp_key_channel_list_dynamic_order_switch", Boolean.valueOf(TextUtils.equals(str2, "1")));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    bkbq.a("sp_key_channel_list_dynamic_order_switch", Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ota
 * JD-Core Version:    0.7.0.1
 */