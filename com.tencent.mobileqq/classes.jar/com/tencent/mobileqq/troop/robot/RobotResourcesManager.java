package com.tencent.mobileqq.troop.robot;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

public class RobotResourcesManager
{
  private static RobotResourcesManager jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager = new RobotResourcesManager();
  String jdField_a_of_type_JavaLangString;
  
  public static RobotResourcesManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager;
  }
  
  public void a() {}
  
  public void a(BaseChatPie paramBaseChatPie) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, RobotResourcesManager.LoadResourceCallback paramLoadResourceCallback) {}
  
  public void a(String paramString1, String paramString2, String paramString3) {}
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(String paramString)
  {
    return true;
  }
  
  public void b() {}
  
  public boolean b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    return paramString.equals(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.RobotResourcesManager
 * JD-Core Version:    0.7.0.1
 */