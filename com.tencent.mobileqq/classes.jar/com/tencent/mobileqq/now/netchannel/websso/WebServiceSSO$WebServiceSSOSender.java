package com.tencent.mobileqq.now.netchannel.websso;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Dispatcher;

class WebServiceSSO$WebServiceSSOSender
{
  final AtomicInteger a = new AtomicInteger(0);
  final AtomicInteger b = new AtomicInteger(0);
  final int c = 10;
  final ExecutorService d = Executors.newFixedThreadPool(10);
  final ExecutorService e = Executors.newFixedThreadPool(10);
  
  public WebServiceSSO$WebServiceSSOSender(WebServiceSSO paramWebServiceSSO) {}
  
  public void a()
  {
    this.d.shutdown();
    this.e.shutdown();
    WebServiceSSO.a(this.f).cancelAll();
    ThreadManager.executeOnSubThread(new WebServiceSSO.WebServiceSSOSender.2(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, SSOCallback paramSSOCallback)
  {
    paramString = new WebServiceSSO.WebServiceSSOSender.RequestCallable(this, this.a.incrementAndGet(), paramString, paramArrayOfByte);
    paramString = this.d.submit(paramString);
    this.e.submit(new WebServiceSSO.WebServiceSSOSender.1(this, paramString, paramSSOCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO.WebServiceSSOSender
 * JD-Core Version:    0.7.0.1
 */