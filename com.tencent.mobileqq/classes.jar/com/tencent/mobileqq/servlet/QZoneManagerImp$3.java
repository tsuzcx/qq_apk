package com.tencent.mobileqq.servlet;

import android.content.ContentResolver;
import android.content.ContentValues;
import azbw;
import bjha;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;
import zij;

public class QZoneManagerImp$3
  implements Runnable
{
  public QZoneManagerImp$3(azbw paramazbw, bjha parambjha, int paramInt) {}
  
  public void run()
  {
    if (azbw.a(this.this$0) == null) {
      return;
    }
    ContentValues localContentValues = this.jdField_a_of_type_Bjha.a();
    localContentValues.put("own_uin", azbw.a(this.this$0).getAccount());
    localContentValues.put("type", Integer.valueOf(this.jdField_a_of_type_Int));
    try
    {
      azbw.a(this.this$0).getApplication().getContentResolver().insert(zij.h, localContentValues);
      return;
    }
    catch (Exception localException)
    {
      this.this$0.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.3
 * JD-Core Version:    0.7.0.1
 */