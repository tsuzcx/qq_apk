package com.tencent.mobileqq.conditionsearch;

import android.os.Handler;
import android.os.Message;

class LocationSelectActivity$5
  extends Handler
{
  LocationSelectActivity$5(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000) {
      this.a.a(((Boolean)((java.lang.Object[])(java.lang.Object[])paramMessage.obj)[0]).booleanValue(), (String[])((java.lang.Object[])(java.lang.Object[])paramMessage.obj)[1]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.LocationSelectActivity.5
 * JD-Core Version:    0.7.0.1
 */