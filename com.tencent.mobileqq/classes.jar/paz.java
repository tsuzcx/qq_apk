import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class paz
  implements AladdinConfigHandler
{
  private static final boolean a;
  private static boolean b;
  
  static
  {
    if (((Integer)bnrf.a("readinjoy_channel_mode", Integer.valueOf(-1))).intValue() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = true;
      return;
    }
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean b()
  {
    return b;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("ChannelModeConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = pan.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("ChannelModeConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "channel_mode")) {
        bnrf.a("readinjoy_channel_mode", Integer.valueOf(Integer.valueOf(str2).intValue()));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("ChannelModeConfigHandler", 1, "[onWipeConfig]");
    bnrf.a("readinjoy_channel_mode", Integer.valueOf(-1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     paz
 * JD-Core Version:    0.7.0.1
 */