import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class opn
  extends SimpleConfigHandler
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("VideoFloatWindowConfigHandler", 2, "[onReceiveConfig] " + paramString);
    paramString = oof.a(paramString);
    if ((String)paramString.get("readinjoy_tinyvideo_window_switch") != null) {
      bhvy.b((String)paramString.get("readinjoy_tinyvideo_window_switch"));
    }
    paramString = (String)paramString.get("readinjoy_tinyvideo_autoplay_nextvideo");
    if (paramString != null) {}
    try
    {
      bhvy.d(Integer.parseInt(paramString));
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    bhvy.b(null);
    bhvy.d(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opn
 * JD-Core Version:    0.7.0.1
 */