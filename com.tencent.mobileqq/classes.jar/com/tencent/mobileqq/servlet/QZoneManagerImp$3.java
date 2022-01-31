package com.tencent.mobileqq.servlet;

import android.content.ContentResolver;
import android.content.ContentValues;
import awcz;
import bfso;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;
import xge;

public class QZoneManagerImp$3
  implements Runnable
{
  public QZoneManagerImp$3(awcz paramawcz, bfso parambfso, int paramInt) {}
  
  public void run()
  {
    if (awcz.a(this.this$0) == null) {
      return;
    }
    ContentValues localContentValues = this.jdField_a_of_type_Bfso.a();
    localContentValues.put("own_uin", awcz.a(this.this$0).getAccount());
    localContentValues.put("type", Integer.valueOf(this.jdField_a_of_type_Int));
    try
    {
      awcz.a(this.this$0).getApplication().getContentResolver().insert(xge.h, localContentValues);
      return;
    }
    catch (Exception localException)
    {
      this.this$0.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.3
 * JD-Core Version:    0.7.0.1
 */