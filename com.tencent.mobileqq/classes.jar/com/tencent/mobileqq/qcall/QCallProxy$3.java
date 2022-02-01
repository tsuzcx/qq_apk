package com.tencent.mobileqq.qcall;

import android.database.Cursor;
import azwi;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.utils.SecurityUtile;

public class QCallProxy$3
  implements Runnable
{
  public QCallProxy$3(azwi paramazwi, String paramString) {}
  
  public void run()
  {
    Cursor localCursor = azwi.a(this.this$0, this.a);
    if (localCursor != null)
    {
      int i = localCursor.getColumnIndex("name");
      while (localCursor.moveToNext())
      {
        String str = SecurityUtile.encode(localCursor.getString(i));
        int j = azwi.a(this.this$0, str);
        if (j != -1) {
          azwi.a(this.this$0).addMsgQueue(this.a, j, str, null, null, 2, null);
        }
      }
      localCursor.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallProxy.3
 * JD-Core Version:    0.7.0.1
 */