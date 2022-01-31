import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class opp
  extends SimpleConfigHandler
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("VideoSingleModeConfigHandler", 2, "[onReceiveConfig] " + paramString);
    paramString = oof.a(paramString);
    if ((String)paramString.get("readinjoy_single_video_switch") != null) {
      bhvy.a((String)paramString.get("readinjoy_single_video_switch"));
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    bhvy.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opp
 * JD-Core Version:    0.7.0.1
 */