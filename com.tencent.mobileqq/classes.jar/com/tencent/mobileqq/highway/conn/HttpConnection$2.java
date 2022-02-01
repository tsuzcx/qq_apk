package com.tencent.mobileqq.highway.conn;

import android.os.HandlerThread;

class HttpConnection$2
  implements Runnable
{
  HttpConnection$2(HttpConnection paramHttpConnection) {}
  
  public void run()
  {
    try
    {
      HttpConnection.access$100(this.this$0).quit();
      HttpConnection.access$102(this.this$0, null);
      HttpConnection.access$202(this.this$0, null);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.HttpConnection.2
 * JD-Core Version:    0.7.0.1
 */