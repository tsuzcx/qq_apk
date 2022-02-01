package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TroopFoldMsgBean
{
  public boolean a = false;
  public int b = 5;
  public int c = 15;
  
  public static TroopFoldMsgBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        TroopFoldMsgBean localTroopFoldMsgBean = new TroopFoldMsgBean();
        paramString = new JSONObject(paramString);
        if (paramString.optInt("openSwitch", 0) == 1)
        {
          bool = true;
          localTroopFoldMsgBean.a = bool;
          localTroopFoldMsgBean.b = paramString.optInt("sameMsgCount", 5);
          localTroopFoldMsgBean.c = paramString.optInt("loadMoreCount", 15);
          if (localTroopFoldMsgBean.b < 2) {
            localTroopFoldMsgBean.a = false;
          }
          if (localTroopFoldMsgBean.c < 15) {
            localTroopFoldMsgBean.c = 15;
          }
          if (localTroopFoldMsgBean.c > 40) {
            localTroopFoldMsgBean.c = 40;
          }
          paramString = new StringBuilder();
          paramString.append("confBean = ");
          paramString.append(localTroopFoldMsgBean.toString());
          QLog.d("TogetherEntryConfProcessor", 2, paramString.toString());
          return localTroopFoldMsgBean;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TogetherEntryConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return null;
      }
      boolean bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("openSwitch = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",sameMsgCount = ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TroopFoldMsgBean
 * JD-Core Version:    0.7.0.1
 */