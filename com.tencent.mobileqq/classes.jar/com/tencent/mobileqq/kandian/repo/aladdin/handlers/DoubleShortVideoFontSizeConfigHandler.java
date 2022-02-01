package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class DoubleShortVideoFontSizeConfigHandler
  extends SimpleConfigHandler
{
  public static String a()
  {
    return (String)RIJSPUtils.a("double_short_video_font_size", "14");
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReceiveConfig] ");
    localStringBuilder.append(paramString);
    QLog.d("DoubleShortVideoFontSize", 2, localStringBuilder.toString());
    paramString = AladdinParseUtils.a(paramString);
    try
    {
      paramString = (String)paramString.get("double_videocard_textsize");
      if (!TextUtils.isEmpty(paramString)) {
        RIJSPUtils.a("double_short_video_font_size", paramString);
      }
      label73:
      return true;
    }
    catch (Exception paramString)
    {
      break label73;
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJSPUtils.a("double_short_video_font_size", "14");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("font size: ");
      localStringBuilder.append(paramInt);
      QLog.d("DoubleShortVideoFontSize", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.DoubleShortVideoFontSizeConfigHandler
 * JD-Core Version:    0.7.0.1
 */