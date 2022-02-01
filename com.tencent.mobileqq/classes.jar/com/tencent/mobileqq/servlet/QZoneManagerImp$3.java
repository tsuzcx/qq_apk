package com.tencent.mobileqq.servlet;

import abfh;
import android.content.ContentResolver;
import android.content.ContentValues;
import bccv;
import blvg;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class QZoneManagerImp$3
  implements Runnable
{
  public QZoneManagerImp$3(bccv parambccv, blvg paramblvg, int paramInt) {}
  
  public void run()
  {
    if (bccv.a(this.this$0) == null) {
      return;
    }
    ContentValues localContentValues = this.jdField_a_of_type_Blvg.a();
    localContentValues.put("own_uin", bccv.a(this.this$0).getAccount());
    localContentValues.put("type", Integer.valueOf(this.jdField_a_of_type_Int));
    try
    {
      bccv.a(this.this$0).getApplication().getContentResolver().insert(abfh.h, localContentValues);
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