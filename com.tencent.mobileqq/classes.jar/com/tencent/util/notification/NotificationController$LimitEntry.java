package com.tencent.util.notification;

public class NotificationController$LimitEntry
{
  String a;
  int b;
  int c;
  long d;
  int e;
  
  public NotificationController$LimitEntry(NotificationController paramNotificationController, String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramLong;
    this.e = paramInt3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.notification.NotificationController.LimitEntry
 * JD-Core Version:    0.7.0.1
 */