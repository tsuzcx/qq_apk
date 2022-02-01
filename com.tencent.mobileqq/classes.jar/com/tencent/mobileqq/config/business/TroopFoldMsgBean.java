package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TroopFoldMsgBean
{
  public int a;
  public boolean a;
  public int b = 15;
  
  public TroopFoldMsgBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 5;
  }
  
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
          localTroopFoldMsgBean.jdField_a_of_type_Boolean = bool;
          localTroopFoldMsgBean.jdField_a_of_type_Int = paramString.optInt("sameMsgCount", 5);
          localTroopFoldMsgBean.b = paramString.optInt("loadMoreCount", 15);
          if (localTroopFoldMsgBean.jdField_a_of_type_Int < 2) {
            localTroopFoldMsgBean.jdField_a_of_type_Boolean = false;
          }
          if (localTroopFoldMsgBean.b < 15) {
            localTroopFoldMsgBean.b = 15;
          }
          if (localTroopFoldMsgBean.b > 40) {
            localTroopFoldMsgBean.b = 40;
          }
          QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localTroopFoldMsgBean.toString());
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
    localStringBuilder.append("openSwitch = ").append(this.jdField_a_of_type_Boolean).append(",sameMsgCount = ").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TroopFoldMsgBean
 * JD-Core Version:    0.7.0.1
 */