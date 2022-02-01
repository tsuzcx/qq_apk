package com.tencent.mobileqq.config.business.newfriend;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SysSuspiciousConfBean
{
  private int a;
  
  public SysSuspiciousConfBean()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static SysSuspiciousConfBean a(QConfItem paramQConfItem)
  {
    SysSuspiciousConfBean localSysSuspiciousConfBean = new SysSuspiciousConfBean();
    if (paramQConfItem != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SysSuspiciousConfBean", 2, "parse taskid->" + paramQConfItem.jdField_a_of_type_Int + " content->" + paramQConfItem.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      localSysSuspiciousConfBean.jdField_a_of_type_Int = new JSONObject(paramQConfItem.jdField_a_of_type_JavaLangString).optInt("suspiciousSwitch", 1);
      return localSysSuspiciousConfBean;
    }
    catch (JSONException paramQConfItem)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SysSuspiciousConfBean", 2, "parse error->" + paramQConfItem.toString());
    }
    return localSysSuspiciousConfBean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.newfriend.SysSuspiciousConfBean
 * JD-Core Version:    0.7.0.1
 */