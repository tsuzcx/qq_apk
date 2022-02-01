package com.tencent.mobileqq.config.business.robot;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopRobotConfBean
{
  private int jdField_a_of_type_Int = 1;
  private String jdField_a_of_type_JavaLangString = "";
  
  public static TroopRobotConfBean a()
  {
    return (TroopRobotConfBean)QConfigManager.a().a(460);
  }
  
  public static TroopRobotConfBean a(QConfItem paramQConfItem)
  {
    TroopRobotConfBean localTroopRobotConfBean = new TroopRobotConfBean();
    if (paramQConfItem != null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfBean", 2, "parse taskid->" + paramQConfItem.jdField_a_of_type_Int + " content->" + paramQConfItem.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramQConfItem = new JSONObject(paramQConfItem.jdField_a_of_type_JavaLangString);
      int i = paramQConfItem.optInt("robotswitch", 0);
      paramQConfItem = paramQConfItem.optString("c2cwarning", "");
      localTroopRobotConfBean.a(i);
      localTroopRobotConfBean.a(paramQConfItem);
      return localTroopRobotConfBean;
    }
    catch (JSONException paramQConfItem)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopRobotConfBean", 2, "parse error->" + paramQConfItem.toString());
    }
    return localTroopRobotConfBean;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public String toString()
  {
    return String.format("mTroopRobotSwitch:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.robot.TroopRobotConfBean
 * JD-Core Version:    0.7.0.1
 */