package com.tencent.mobileqq.leba.entity;

import java.util.Iterator;
import java.util.List;

public class LebaViewItem
{
  public byte a;
  public int a;
  public long a;
  public LebaPluginInfo a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  
  public LebaViewItem()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 2147483647;
  }
  
  public static String a(List<LebaViewItem> paramList)
  {
    if (paramList == null) {
      return " print lebaData == null";
    }
    if (paramList.isEmpty()) {
      return " print lebaData.isEmpty()";
    }
    StringBuilder localStringBuilder = new StringBuilder(" print lebaData size = ").append(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)paramList.next();
      if (localLebaViewItem == null)
      {
        localStringBuilder.append("|item = null");
      }
      else
      {
        localStringBuilder.append("|item = ").append(localLebaViewItem.jdField_a_of_type_Long).append("|").append(localLebaViewItem.jdField_a_of_type_JavaLangString).append("|").append(localLebaViewItem.jdField_b_of_type_JavaLangString).append("|").append(localLebaViewItem.jdField_a_of_type_Int).append("|").append(localLebaViewItem.jdField_a_of_type_Byte).append("|").append(localLebaViewItem.jdField_b_of_type_Long).append("|").append(localLebaViewItem.jdField_a_of_type_Boolean).append("|");
        if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) {
          localStringBuilder.append("info=null");
        } else {
          localStringBuilder.append(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.toString());
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Byte = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Byte == 0;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Byte = 1;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.cCanChangeState != 0);
  }
  
  public boolean c()
  {
    return (!b()) || (this.jdField_b_of_type_Int == 2147483647);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (this.jdField_a_of_type_Long == 0L)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this == paramObject);
      if (!(paramObject instanceof LebaViewItem)) {
        break;
      }
      paramObject = (LebaViewItem)paramObject;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long);
    return false;
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.jdField_a_of_type_Long).hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.entity.LebaViewItem
 * JD-Core Version:    0.7.0.1
 */