package com.tencent.mobileqq.screendetect;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ScreenShotConfigProcessor$ScreenShotConfigData
{
  private boolean a = true;
  
  public static ScreenShotConfigData a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      ScreenShotConfigData localScreenShotConfigData = new ScreenShotConfigData();
      if (new JSONObject(paramString).optInt("enable", 1) == 1) {}
      for (;;)
      {
        localScreenShotConfigData.a = bool;
        return localScreenShotConfigData;
        bool = false;
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("ScreenShotConfigProcessor", 2, "ScreenShotConfigData parse error", paramString);
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "ScreenShotConfigData [mSwitchEnable = " + this.a + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotConfigProcessor.ScreenShotConfigData
 * JD-Core Version:    0.7.0.1
 */