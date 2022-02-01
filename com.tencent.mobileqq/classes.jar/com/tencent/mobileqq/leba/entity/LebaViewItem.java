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
    StringBuilder localStringBuilder = new StringBuilder(" print lebaData size = ");
    localStringBuilder.append(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (LebaViewItem)paramList.next();
      if (localObject == null)
      {
        localStringBuilder.append("|item = null");
      }
      else
      {
        localStringBuilder.append("|item = ");
        localStringBuilder.append(((LebaViewItem)localObject).jdField_a_of_type_Long);
        localStringBuilder.append("|");
        localStringBuilder.append(((LebaViewItem)localObject).jdField_a_of_type_JavaLangString);
        localStringBuilder.append("|");
        localStringBuilder.append(((LebaViewItem)localObject).jdField_b_of_type_JavaLangString);
        localStringBuilder.append("|");
        localStringBuilder.append(((LebaViewItem)localObject).jdField_a_of_type_Int);
        localStringBuilder.append("|");
        localStringBuilder.append(((LebaViewItem)localObject).jdField_a_of_type_Byte);
        localStringBuilder.append("|");
        localStringBuilder.append(((LebaViewItem)localObject).jdField_b_of_type_Long);
        localStringBuilder.append("|");
        localStringBuilder.append(((LebaViewItem)localObject).jdField_a_of_type_Boolean);
        localStringBuilder.append("|");
        localObject = ((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo;
        if (localObject == null) {
          localStringBuilder.append("info=null");
        } else {
          localStringBuilder.append(((LebaPluginInfo)localObject).toString());
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
    if (this.jdField_a_of_type_Boolean)
    {
      LebaPluginInfo localLebaPluginInfo = this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo;
      if ((localLebaPluginInfo != null) && (localLebaPluginInfo.cCanChangeState != 0)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean c()
  {
    return (!b()) || (this.jdField_b_of_type_Int == 2147483647);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      long l = this.jdField_a_of_type_Long;
      if (l == 0L) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      if (((paramObject instanceof LebaViewItem)) && (l == ((LebaViewItem)paramObject).jdField_a_of_type_Long)) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.jdField_a_of_type_Long).hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.entity.LebaViewItem
 * JD-Core Version:    0.7.0.1
 */