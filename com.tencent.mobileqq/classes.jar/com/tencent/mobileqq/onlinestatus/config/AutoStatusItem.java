package com.tencent.mobileqq.onlinestatus.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.utils.StringUtil;

public class AutoStatusItem
  extends OnlineStatusItem
{
  public Category a;
  public Sensor a;
  public boolean b;
  public String h;
  
  public AutoStatusItem()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public AutoStatusItem(long paramLong, String paramString1, String paramString2, Category paramCategory, String paramString3, Sensor paramSensor, String paramString4, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.h = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory = paramCategory;
    this.c = paramString3;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigSensor = paramSensor;
    this.e = paramString4;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public AutoStatusItem(long paramLong, String paramString1, String paramString2, Category paramCategory, String paramString3, String paramString4, Sensor paramSensor, String paramString5, boolean paramBoolean)
  {
    this(paramLong, paramString1, paramString2, paramCategory, paramString3, paramSensor, paramString5, paramBoolean);
    if (StringUtil.a(paramString4))
    {
      this.d = paramString3;
      return;
    }
    this.d = paramString4;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AutoStatus [id=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", title=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", category=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory);
    localStringBuilder.append(", sensor=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigSensor);
    localStringBuilder.append(", isHide=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.AutoStatusItem
 * JD-Core Version:    0.7.0.1
 */