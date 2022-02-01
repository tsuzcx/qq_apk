package com.tencent.mobileqq.qcall;

import android.database.Cursor;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;

class QCallProxy$3
  implements Runnable
{
  QCallProxy$3(QCallProxy paramQCallProxy, String paramString) {}
  
  public void run()
  {
    try
    {
      Cursor localCursor = QCallProxy.a(this.this$0, this.a);
      if (localCursor != null)
      {
        int i = localCursor.getColumnIndex("name");
        while (localCursor.moveToNext())
        {
          String str = SecurityUtile.encode(localCursor.getString(i));
          int j = QCallProxy.b(this.this$0, str);
          if (j != -1) {
            QCallProxy.a(this.this$0).addMsgQueue(this.a, j, str, null, null, 2, null);
          }
        }
        localCursor.close();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.i("QCallProxy", 1, "deleteAllRecordFromDB", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallProxy.3
 * JD-Core Version:    0.7.0.1
 */