package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class PttAutoChangeBean
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  
  public static PttAutoChangeBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      PttAutoChangeBean localPttAutoChangeBean = new PttAutoChangeBean();
      paramString = new JSONObject(paramString);
      localPttAutoChangeBean.a = paramString.optInt("showVoiceToTextSwitch", -1);
      localPttAutoChangeBean.b = paramString.optInt("grayTipShowPerThousand", -1);
      localPttAutoChangeBean.c = paramString.optInt("mainSwitch", -1);
      return localPttAutoChangeBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PttAutoChangeProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return null;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("open:");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PttAutoChangeBean
 * JD-Core Version:    0.7.0.1
 */