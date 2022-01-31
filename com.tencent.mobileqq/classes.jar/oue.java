import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class oue
  extends SimpleConfigHandler
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("VideoSingleModeConfigHandler", 2, "[onReceiveConfig] " + paramString);
    paramString = osq.a(paramString);
    if ((String)paramString.get("readinjoy_single_video_switch") != null) {
      bkbq.a((String)paramString.get("readinjoy_single_video_switch"));
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    bkbq.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oue
 * JD-Core Version:    0.7.0.1
 */