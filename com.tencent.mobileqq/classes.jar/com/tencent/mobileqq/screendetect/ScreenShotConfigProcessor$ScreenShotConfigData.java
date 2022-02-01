package com.tencent.mobileqq.screendetect;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ScreenShotConfigProcessor$ScreenShotConfigData
{
  private boolean a = true;
  
  public static ScreenShotConfigData a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        ScreenShotConfigData localScreenShotConfigData = new ScreenShotConfigData();
        paramString = new JSONObject(paramString);
        bool = true;
        if (paramString.optInt("enable", 1) == 1)
        {
          localScreenShotConfigData.a = bool;
          return localScreenShotConfigData;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ScreenShotConfigProcessor", 2, "ScreenShotConfigData parse error", paramString);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScreenShotConfigData [mSwitchEnable = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotConfigProcessor.ScreenShotConfigData
 * JD-Core Version:    0.7.0.1
 */