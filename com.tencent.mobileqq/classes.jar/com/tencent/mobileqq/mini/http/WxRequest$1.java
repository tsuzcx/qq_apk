package com.tencent.mobileqq.mini.http;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

final class WxRequest$1
  implements ThreadExcutor.IThreadListener
{
  public void onAdded()
  {
    WxRequest.access$000().getAndIncrement();
  }
  
  public void onPostRun()
  {
    WxRequest.access$000().getAndDecrement();
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.WxRequest.1
 * JD-Core Version:    0.7.0.1
 */