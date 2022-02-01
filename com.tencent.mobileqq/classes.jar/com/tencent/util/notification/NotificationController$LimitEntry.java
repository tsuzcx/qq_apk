package com.tencent.util.notification;

public class NotificationController$LimitEntry
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  int b;
  int c;
  
  public NotificationController$LimitEntry(NotificationController paramNotificationController, String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
    this.c = paramInt3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.notification.NotificationController.LimitEntry
 * JD-Core Version:    0.7.0.1
 */