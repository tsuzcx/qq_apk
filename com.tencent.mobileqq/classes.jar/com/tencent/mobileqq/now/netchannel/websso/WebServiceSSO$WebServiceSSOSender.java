package com.tencent.mobileqq.now.netchannel.websso;

import aydx;
import aydz;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Dispatcher;

public class WebServiceSSO$WebServiceSSOSender
{
  final int jdField_a_of_type_Int = 10;
  final ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(10);
  final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  final ExecutorService jdField_b_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(10);
  final AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public WebServiceSSO$WebServiceSSOSender(WebServiceSSO paramWebServiceSSO) {}
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
    this.jdField_b_of_type_JavaUtilConcurrentExecutorService.shutdown();
    WebServiceSSO.a(this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO).cancelAll();
    ThreadManager.executeOnSubThread(new WebServiceSSO.WebServiceSSOSender.2(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, aydx paramaydx)
  {
    paramString = new aydz(this, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet(), paramString, paramArrayOfByte);
    paramString = this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(paramString);
    this.jdField_b_of_type_JavaUtilConcurrentExecutorService.submit(new WebServiceSSO.WebServiceSSOSender.1(this, paramString, paramaydx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO.WebServiceSSOSender
 * JD-Core Version:    0.7.0.1
 */