package com.tencent.mobileqq.utils.httputils;

import com.tencent.qphone.base.util.QLog;

class HttpCommunicator$3
  implements Runnable
{
  HttpCommunicator$3(HttpCommunicator paramHttpCommunicator) {}
  
  public void run()
  {
    synchronized (HttpCommunicator.access$000(this.this$0))
    {
      if (HttpCommunicator.access$100(this.this$0)) {
        return;
      }
      HttpCommunicator.access$102(this.this$0, true);
      HttpCommunicator.access$202(this.this$0, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close.async doclose");
      }
      this.this$0.close_inter();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpCommunicator.3
 * JD-Core Version:    0.7.0.1
 */