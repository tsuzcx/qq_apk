package com.tencent.mobileqq.utils.httputils;

import bgut;
import com.tencent.qphone.base.util.QLog;

public class HttpCommunicator$3
  implements Runnable
{
  public HttpCommunicator$3(bgut parambgut) {}
  
  public void run()
  {
    synchronized (bgut.a(this.this$0))
    {
      if (bgut.a(this.this$0)) {
        return;
      }
      bgut.a(this.this$0, true);
      bgut.b(this.this$0, false);
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