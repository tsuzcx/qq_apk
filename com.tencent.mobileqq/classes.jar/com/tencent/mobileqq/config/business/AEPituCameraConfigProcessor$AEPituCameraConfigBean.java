package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class AEPituCameraConfigProcessor$AEPituCameraConfigBean
{
  private boolean a = false;
  
  public static AEPituCameraConfigBean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        AEPituCameraConfigBean localAEPituCameraConfigBean = new AEPituCameraConfigBean();
        if (new JSONObject(paramString).optInt("showTakeSameEntrance", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localAEPituCameraConfigBean.a = bool;
          return localAEPituCameraConfigBean;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.e("PttAutoChangeProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AEPituCameraConfigProcessor.AEPituCameraConfigBean
 * JD-Core Version:    0.7.0.1
 */