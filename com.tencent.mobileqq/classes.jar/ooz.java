import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ooz
  implements AladdinConfigHandler
{
  public static String a()
  {
    return (String)bhvh.a("double_short_video_font_size", "14");
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("DoubleShortVideoFontSize", 2, "[onReceiveConfig] " + paramString);
    paramString = ooi.a(paramString);
    try
    {
      paramString = (String)paramString.get("double_videocard_textsize");
      if (!TextUtils.isEmpty(paramString)) {
        bhvh.a("double_short_video_font_size", paramString);
      }
      label55:
      return true;
    }
    catch (Exception paramString)
    {
      break label55;
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    bhvh.a("double_short_video_font_size", "14");
    if (QLog.isColorLevel()) {
      QLog.d("DoubleShortVideoFontSize", 2, "font size: " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ooz
 * JD-Core Version:    0.7.0.1
 */