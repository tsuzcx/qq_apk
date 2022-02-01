package com.tencent.mobileqq.config.business.newfriend;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SysSuspiciousConfBean
{
  private int a = 1;
  
  public static SysSuspiciousConfBean a(QConfItem paramQConfItem)
  {
    SysSuspiciousConfBean localSysSuspiciousConfBean = new SysSuspiciousConfBean();
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
        QLog.d("SysSuspiciousConfBean", 2, localStringBuilder.toString());
      }
      try
      {
        localSysSuspiciousConfBean.a = new JSONObject(paramQConfItem.b).optInt("suspiciousSwitch", 1);
        return localSysSuspiciousConfBean;
      }
      catch (JSONException paramQConfItem)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parse error->");
          localStringBuilder.append(paramQConfItem.toString());
          QLog.d("SysSuspiciousConfBean", 2, localStringBuilder.toString());
        }
      }
    }
    return localSysSuspiciousConfBean;
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.newfriend.SysSuspiciousConfBean
 * JD-Core Version:    0.7.0.1
 */