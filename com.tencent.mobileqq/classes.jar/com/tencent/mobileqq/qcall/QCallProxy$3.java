package com.tencent.mobileqq.qcall;

import android.database.Cursor;
import axat;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.utils.SecurityUtile;

public class QCallProxy$3
  implements Runnable
{
  public QCallProxy$3(axat paramaxat, String paramString) {}
  
  public void run()
  {
    Cursor localCursor = axat.a(this.this$0, this.a);
    if (localCursor != null)
    {
      int i = localCursor.getColumnIndex("name");
      while (localCursor.moveToNext())
      {
        String str = SecurityUtile.a(localCursor.getString(i));
        int j = axat.a(this.this$0, str);
        if (j != -1) {
          axat.a(this.this$0).a(this.a, j, str, null, null, 2, null);
        }
      }
      localCursor.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallProxy.3
 * JD-Core Version:    0.7.0.1
 */