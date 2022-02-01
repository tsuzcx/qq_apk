package com.tencent.mobileqq.utils.httputils;

import bhuw;
import com.tencent.qphone.base.util.QLog;

public class HttpCommunicator$3
  implements Runnable
{
  public HttpCommunicator$3(bhuw parambhuw) {}
  
  public void run()
  {
    synchronized (bhuw.a(this.this$0))
    {
      if (bhuw.a(this.this$0)) {
        return;
      }
      bhuw.a(this.this$0, true);
      bhuw.b(this.this$0, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close.async doclose");
      }
      this.this$0.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpCommunicator.3
 * JD-Core Version:    0.7.0.1
 */