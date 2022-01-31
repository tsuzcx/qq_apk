import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class oth
  implements AladdinConfigHandler
{
  public static String a()
  {
    return (String)bkbq.a("double_short_video_font_size", "14");
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("DoubleShortVideoFontSize", 2, "[onReceiveConfig] " + paramString);
    paramString = osq.a(paramString);
    try
    {
      paramString = (String)paramString.get("double_videocard_textsize");
      if (!TextUtils.isEmpty(paramString)) {
        bkbq.a("double_short_video_font_size", paramString);
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
    bkbq.a("double_short_video_font_size", "14");
    if (QLog.isColorLevel()) {
      QLog.d("DoubleShortVideoFontSize", 2, "font size: " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oth
 * JD-Core Version:    0.7.0.1
 */