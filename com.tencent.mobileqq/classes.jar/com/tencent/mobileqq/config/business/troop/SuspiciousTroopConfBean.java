package com.tencent.mobileqq.config.business.troop;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SuspiciousTroopConfBean
{
  private int a = 0;
  
  public static SuspiciousTroopConfBean a(QConfItem paramQConfItem)
  {
    SuspiciousTroopConfBean localSuspiciousTroopConfBean = new SuspiciousTroopConfBean();
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
        QLog.d("SuspiciousTroopConfBean", 2, localStringBuilder.toString());
      }
      try
      {
        if (paramQConfItem.b == null) {
          paramQConfItem = "";
        } else {
          paramQConfItem = paramQConfItem.b;
        }
        localSuspiciousTroopConfBean.a = new JSONObject(paramQConfItem).optInt("suspiciousSwitch", 0);
        return localSuspiciousTroopConfBean;
      }
      catch (JSONException paramQConfItem)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parse error->");
          localStringBuilder.append(paramQConfItem.toString());
          QLog.d("SuspiciousTroopConfBean", 2, localStringBuilder.toString());
        }
      }
    }
    return localSuspiciousTroopConfBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.troop.SuspiciousTroopConfBean
 * JD-Core Version:    0.7.0.1
 */