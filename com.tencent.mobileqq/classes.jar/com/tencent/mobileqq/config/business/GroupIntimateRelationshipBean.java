package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GroupIntimateRelationshipBean
{
  public boolean a = true;
  public int b = 3;
  
  public static GroupIntimateRelationshipBean a(QConfItem paramQConfItem)
  {
    GroupIntimateRelationshipBean localGroupIntimateRelationshipBean = new GroupIntimateRelationshipBean();
    StringBuilder localStringBuilder;
    if (paramQConfItem != null) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse taskid->");
        localStringBuilder.append(paramQConfItem.a);
        localStringBuilder.append(" content->");
        localStringBuilder.append(paramQConfItem.b);
        QLog.d("GroupIntimateRelationshipBean", 2, localStringBuilder.toString());
      }
    }
    for (;;)
    {
      try
      {
        paramQConfItem = new JSONObject(paramQConfItem.b);
        bool = true;
        if (paramQConfItem.optInt("isTroopCardOpen", 1) != 1) {
          break label157;
        }
        localGroupIntimateRelationshipBean.a = bool;
        localGroupIntimateRelationshipBean.b = paramQConfItem.optInt("prepareCount", 3);
        return localGroupIntimateRelationshipBean;
      }
      catch (Exception paramQConfItem)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parse error->");
          localStringBuilder.append(paramQConfItem.toString());
          QLog.d("GroupIntimateRelationshipBean", 2, localStringBuilder.toString());
        }
      }
      return localGroupIntimateRelationshipBean;
      label157:
      boolean bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isTroopCardOpen:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" prepareCount:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.GroupIntimateRelationshipBean
 * JD-Core Version:    0.7.0.1
 */