package com.tencent.mobileqq.troop.robot;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

public class RobotResourcesManager
{
  private static RobotResourcesManager b = new RobotResourcesManager();
  String a;
  
  public static RobotResourcesManager a()
  {
    return b;
  }
  
  public void a(BaseChatPie paramBaseChatPie) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, RobotResourcesManager.LoadResourceCallback paramLoadResourceCallback) {}
  
  public void a(String paramString1, String paramString2, String paramString3) {}
  
  public void b() {}
  
  public boolean b(String paramString)
  {
    return true;
  }
  
  public void c() {}
  
  public boolean c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.a))) {
      return paramString.equals(this.a);
    }
    return false;
  }
  
  public boolean d()
  {
    return TextUtils.isEmpty(this.a) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.RobotResourcesManager
 * JD-Core Version:    0.7.0.1
 */