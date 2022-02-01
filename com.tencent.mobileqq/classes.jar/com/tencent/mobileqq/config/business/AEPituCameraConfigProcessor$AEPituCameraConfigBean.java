package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class AEPituCameraConfigProcessor$AEPituCameraConfigBean
{
  private boolean a = false;
  
  public static AEPituCameraConfigBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        AEPituCameraConfigBean localAEPituCameraConfigBean = new AEPituCameraConfigBean();
        if (new JSONObject(paramString).optInt("showTakeSameEntrance", 0) == 1)
        {
          bool = true;
          localAEPituCameraConfigBean.a = bool;
          return localAEPituCameraConfigBean;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PttAutoChangeProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return null;
      }
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AEPituCameraConfigProcessor.AEPituCameraConfigBean
 * JD-Core Version:    0.7.0.1
 */