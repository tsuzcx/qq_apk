package com.tencent.mobileqq.troop.robot;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopRobotConfBean
{
  private int a = 1;
  private String b = "";
  
  public static TroopRobotConfBean a(QConfItem paramQConfItem)
  {
    TroopRobotConfBean localTroopRobotConfBean = new TroopRobotConfBean();
    if (paramQConfItem != null)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse taskid->");
        localStringBuilder.append(paramQConfItem.a);
        localStringBuilder.append(" content->");
        localStringBuilder.append(paramQConfItem.b);
        QLog.d("TroopRobotConfBean", 2, localStringBuilder.toString());
      }
      try
      {
        paramQConfItem = new JSONObject(paramQConfItem.b);
        int i = paramQConfItem.optInt("robotswitch", 0);
        paramQConfItem = paramQConfItem.optString("c2cwarning", "");
        localTroopRobotConfBean.a(i);
        localTroopRobotConfBean.a(paramQConfItem);
        return localTroopRobotConfBean;
      }
      catch (JSONException paramQConfItem)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parse error->");
          localStringBuilder.append(paramQConfItem.toString());
          QLog.d("TroopRobotConfBean", 2, localStringBuilder.toString());
        }
      }
    }
    return localTroopRobotConfBean;
  }
  
  public static TroopRobotConfBean c()
  {
    return (TroopRobotConfBean)QConfigManager.b().b(460);
  }
  
  void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return String.format("mTroopRobotSwitch:%d", new Object[] { Integer.valueOf(this.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.TroopRobotConfBean
 * JD-Core Version:    0.7.0.1
 */