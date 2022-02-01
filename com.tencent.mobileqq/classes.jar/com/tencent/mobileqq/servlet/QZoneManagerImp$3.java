package com.tencent.mobileqq.servlet;

import android.content.ContentResolver;
import android.content.ContentValues;
import com.tencent.common.config.provider.QZoneConfigConst;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import mqq.app.MobileQQ;

class QZoneManagerImp$3
  implements Runnable
{
  QZoneManagerImp$3(QZoneManagerImp paramQZoneManagerImp, QZoneCountInfo paramQZoneCountInfo, int paramInt) {}
  
  public void run()
  {
    if (QZoneManagerImp.d(this.this$0) == null) {
      return;
    }
    ContentValues localContentValues = this.a.convertToContentValues();
    localContentValues.put("own_uin", QZoneManagerImp.d(this.this$0).getAccount());
    localContentValues.put("type", Integer.valueOf(this.b));
    try
    {
      QZoneManagerImp.d(this.this$0).getApplication().getContentResolver().insert(QZoneConfigConst.i, localContentValues);
      return;
    }
    catch (Exception localException)
    {
      this.this$0.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.3
 * JD-Core Version:    0.7.0.1
 */