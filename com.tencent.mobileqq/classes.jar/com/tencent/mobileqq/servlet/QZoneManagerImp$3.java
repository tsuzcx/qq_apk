package com.tencent.mobileqq.servlet;

import abjl;
import android.content.ContentResolver;
import android.content.ContentValues;
import bcvn;
import bmwi;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class QZoneManagerImp$3
  implements Runnable
{
  public QZoneManagerImp$3(bcvn parambcvn, bmwi parambmwi, int paramInt) {}
  
  public void run()
  {
    if (bcvn.a(this.this$0) == null) {
      return;
    }
    ContentValues localContentValues = this.jdField_a_of_type_Bmwi.a();
    localContentValues.put("own_uin", bcvn.a(this.this$0).getAccount());
    localContentValues.put("type", Integer.valueOf(this.jdField_a_of_type_Int));
    try
    {
      bcvn.a(this.this$0).getApplication().getContentResolver().insert(abjl.h, localContentValues);
      return;
    }
    catch (Exception localException)
    {
      this.this$0.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.3
 * JD-Core Version:    0.7.0.1
 */