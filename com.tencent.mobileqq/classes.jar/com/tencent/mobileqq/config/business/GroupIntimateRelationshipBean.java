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
    boolean bool = true;
    GroupIntimateRelationshipBean localGroupIntimateRelationshipBean = new GroupIntimateRelationshipBean();
    if (paramQConfItem != null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipBean", 2, "parse taskid->" + paramQConfItem.jdField_a_of_type_Int + " content->" + paramQConfItem.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        paramQConfItem = new JSONObject(paramQConfItem.jdField_a_of_type_JavaLangString);
        if (paramQConfItem.optInt("isTroopCardOpen", 1) != 1) {
          continue;
        }
        localGroupIntimateRelationshipBean.jdField_a_of_type_Boolean = bool;
        localGroupIntimateRelationshipBean.jdField_a_of_type_Int = paramQConfItem.optInt("prepareCount", 3);
      }
      catch (Exception paramQConfItem)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GroupIntimateRelationshipBean", 2, "parse error->" + paramQConfItem.toString());
      }
      return localGroupIntimateRelationshipBean;
      bool = false;
    }
    return localGroupIntimateRelationshipBean;
  }
  
  public String toString()
  {
    return "isTroopCardOpen:" + this.jdField_a_of_type_Boolean + " prepareCount:" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.GroupIntimateRelationshipBean
 * JD-Core Version:    0.7.0.1
 */