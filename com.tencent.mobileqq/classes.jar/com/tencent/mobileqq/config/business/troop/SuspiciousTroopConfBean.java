package com.tencent.mobileqq.config.business.troop;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SuspiciousTroopConfBean
{
  private int a;
  
  public SuspiciousTroopConfBean()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static SuspiciousTroopConfBean a(QConfItem paramQConfItem)
  {
    localSuspiciousTroopConfBean = new SuspiciousTroopConfBean();
    if (paramQConfItem != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfBean", 2, "parse taskid->" + paramQConfItem.jdField_a_of_type_Int + " content->" + paramQConfItem.jdField_a_of_type_JavaLangString);
      }
      try
      {
        if (paramQConfItem.jdField_a_of_type_JavaLangString == null) {}
        for (paramQConfItem = "";; paramQConfItem = paramQConfItem.jdField_a_of_type_JavaLangString)
        {
          localSuspiciousTroopConfBean.jdField_a_of_type_Int = new JSONObject(paramQConfItem).optInt("suspiciousSwitch", 0);
          return localSuspiciousTroopConfBean;
        }
        return localSuspiciousTroopConfBean;
      }
      catch (JSONException paramQConfItem)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SuspiciousTroopConfBean", 2, "parse error->" + paramQConfItem.toString());
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.troop.SuspiciousTroopConfBean
 * JD-Core Version:    0.7.0.1
 */