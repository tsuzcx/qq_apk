package com.tencent.mobileqq.onlinestatus.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;

public class AutoStatusItem
  extends OnlineStatusItem
{
  public Category a;
  public Sensor a;
  public boolean b;
  public String g;
  
  public AutoStatusItem()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public AutoStatusItem(long paramLong, String paramString1, String paramString2, Category paramCategory, String paramString3, Sensor paramSensor, String paramString4, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.g = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory = paramCategory;
    this.c = paramString3;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigSensor = paramSensor;
    this.d = paramString4;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  @NonNull
  public String toString()
  {
    return "AutoStatus [id=" + this.jdField_a_of_type_Long + ", type=" + this.g + ", title=" + this.jdField_b_of_type_JavaLangString + ", category=" + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigCategory + ", sensor=" + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigSensor + ", isHide=" + this.jdField_b_of_type_Boolean + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.AutoStatusItem
 * JD-Core Version:    0.7.0.1
 */