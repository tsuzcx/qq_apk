package com.tencent.mobileqq.data;

import acdb;
import android.content.Context;
import cooperation.qzone.QZoneCommonRequest;
import mqq.app.NewIntent;

public class QzoneCommonIntent
  extends NewIntent
{
  static RespProcessor defaultProcessor = new acdb();
  private RespProcessor processor;
  private QZoneCommonRequest request;
  
  public QzoneCommonIntent(Context paramContext, Class paramClass)
  {
    super(paramContext, paramClass);
  }
  
  public static boolean succeeded(int paramInt)
  {
    return (paramInt == 0) || ((Math.abs(paramInt) <= 19999) && (Math.abs(paramInt) >= 19000));
  }
  
  public RespProcessor getProcessor()
  {
    if (this.processor == null) {
      return defaultProcessor;
    }
    return this.processor;
  }
  
  public QZoneCommonRequest getRequest()
  {
    return this.request;
  }
  
  public void setRequest(QZoneCommonRequest paramQZoneCommonRequest)
  {
    this.request = paramQZoneCommonRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.QzoneCommonIntent
 * JD-Core Version:    0.7.0.1
 */