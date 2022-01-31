import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class odg
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("BiuTriggerTypeConfigHandler", 2, "[onReceiveConfig] " + paramString);
    paramString = ocx.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("BiuTriggerTypeConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "on_click"))
      {
        if (TextUtils.equals(str2, "fast_biu")) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          bgmq.a("sp_key_biu_button_click_behaviour", Integer.valueOf(paramInt1));
          break;
        }
      }
      if (TextUtils.equals(str1, "on_long_pressed"))
      {
        if (TextUtils.equals(str2, "fast_biu")) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          bgmq.a("sp_key_biu_button_long_click_behaviour", Integer.valueOf(paramInt1));
          break;
        }
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    bgmq.a("sp_key_biu_button_click_behaviour", Integer.valueOf(0));
    bgmq.a("sp_key_biu_button_long_click_behaviour", Integer.valueOf(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odg
 * JD-Core Version:    0.7.0.1
 */