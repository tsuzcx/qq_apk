package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class PttWithTextSwitchBean
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 3000L;
  
  public static PttWithTextSwitchBean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        PttWithTextSwitchBean localPttWithTextSwitchBean = new PttWithTextSwitchBean();
        paramString = new JSONObject(paramString);
        localPttWithTextSwitchBean.jdField_a_of_type_Int = paramString.optInt("pttWithTextSwitch", -1);
        localPttWithTextSwitchBean.jdField_a_of_type_Long = paramString.optLong("aioSttSpliceTimeout", 45000L);
        return localPttWithTextSwitchBean;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("PttWithTextSwitchBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public String toString()
  {
    return "open:" + this.jdField_a_of_type_Int + "  |  aioSttSpliceTimeout:" + this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PttWithTextSwitchBean
 * JD-Core Version:    0.7.0.1
 */