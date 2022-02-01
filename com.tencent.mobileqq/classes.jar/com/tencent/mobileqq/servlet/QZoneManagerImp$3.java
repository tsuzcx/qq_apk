package com.tencent.mobileqq.servlet;

import aafu;
import android.content.ContentResolver;
import android.content.ContentValues;
import bbox;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import mqq.app.MobileQQ;

public class QZoneManagerImp$3
  implements Runnable
{
  public QZoneManagerImp$3(bbox parambbox, QZoneCountInfo paramQZoneCountInfo, int paramInt) {}
  
  public void run()
  {
    if (bbox.a(this.this$0) == null) {
      return;
    }
    ContentValues localContentValues = this.jdField_a_of_type_CooperationQzoneUndealCountQZoneCountInfo.convertToContentValues();
    localContentValues.put("own_uin", bbox.a(this.this$0).getAccount());
    localContentValues.put("type", Integer.valueOf(this.jdField_a_of_type_Int));
    try
    {
      bbox.a(this.this$0).getApplication().getContentResolver().insert(aafu.h, localContentValues);
      return;
    }
    catch (Exception localException)
    {
      this.this$0.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.3
 * JD-Core Version:    0.7.0.1
 */