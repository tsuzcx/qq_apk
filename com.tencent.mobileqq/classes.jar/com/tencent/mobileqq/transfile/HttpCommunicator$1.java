package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.utils.httputils.HttpMsg;

class HttpCommunicator$1
  implements Runnable
{
  HttpCommunicator$1(HttpCommunicator paramHttpCommunicator, HttpMsg paramHttpMsg, HttpCommunicator.HttpCommunicatorHandler paramHttpCommunicatorHandler) {}
  
  public void run()
  {
    this.this$0.onResponseTimeout(this.val$msg, this.val$handler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpCommunicator.1
 * JD-Core Version:    0.7.0.1
 */