import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ouc
  extends SimpleConfigHandler
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("VideoFloatWindowConfigHandler", 2, "[onReceiveConfig] " + paramString);
    paramString = osq.a(paramString);
    if ((String)paramString.get("readinjoy_tinyvideo_window_switch") != null) {
      bkbq.b((String)paramString.get("readinjoy_tinyvideo_window_switch"));
    }
    paramString = (String)paramString.get("readinjoy_tinyvideo_autoplay_nextvideo");
    if (paramString != null) {}
    try
    {
      bkbq.d(Integer.parseInt(paramString));
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
    bkbq.b(null);
    bkbq.d(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ouc
 * JD-Core Version:    0.7.0.1
 */