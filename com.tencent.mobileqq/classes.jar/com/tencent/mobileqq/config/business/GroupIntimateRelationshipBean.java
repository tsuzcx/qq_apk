package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GroupIntimateRelationshipBean
{
  public int a;
  public boolean a;
  
  public GroupIntimateRelationshipBean()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
  }
  
  public static GroupIntimateRelationshipBean a(QConfItem paramQConfItem)
  {
    GroupIntimateRelationshipBean localGroupIntimateRelationshipBean = new GroupIntimateRelationshipBean();
    StringBuilder localStringBuilder;
    if (paramQConfItem != null) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse taskid->");
        localStringBuilder.append(paramQConfItem.jdField_a_of_type_Int);
        localStringBuilder.append(" content->");
        localStringBuilder.append(paramQConfItem.jdField_a_of_type_JavaLangString);
        QLog.d("GroupIntimateRelationshipBean", 2, localStringBuilder.toString());
      }
    }
    for (;;)
    {
      try
      {
        paramQConfItem = new JSONObject(paramQConfItem.jdField_a_of_type_JavaLangString);
        bool = true;
        if (paramQConfItem.optInt("isTroopCardOpen", 1) != 1) {
          break label157;
        }
        localGroupIntimateRelationshipBean.jdField_a_of_type_Boolean = bool;
        localGroupIntimateRelationshipBean.jdField_a_of_type_Int = paramQConfItem.optInt("prepareCount", 3);
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
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" prepareCount:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.GroupIntimateRelationshipBean
 * JD-Core Version:    0.7.0.1
 */