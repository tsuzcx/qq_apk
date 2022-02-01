package com.tencent.mobileqq.now.netchannel.websso;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class WebServiceSSO$WebServiceSSOSender$1
  implements Runnable
{
  WebServiceSSO$WebServiceSSOSender$1(WebServiceSSO.WebServiceSSOSender paramWebServiceSSOSender, Future paramFuture, SSOCallback paramSSOCallback) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentFuture;
    if (this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoSSOCallback != null) {}
    try
    {
      localObject = (byte[])((Future)localObject).get();
      this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO$WebServiceSSOSender.b.incrementAndGet();
      this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoSSOCallback.a((byte[])localObject);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO$WebServiceSSOSender.b.incrementAndGet();
      this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoSSOCallback.a(-1, "InterruptedException");
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO$WebServiceSSOSender.b.incrementAndGet();
      WebServiceSSO.WebServiceSSOSender.SSOException localSSOException;
      if ((localExecutionException.getCause() instanceof WebServiceSSO.WebServiceSSOSender.SSOException))
      {
        localSSOException = (WebServiceSSO.WebServiceSSOSender.SSOException)localExecutionException.getCause();
        this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoSSOCallback.a(localSSOException.errorCode, localSSOException.errorMessage);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoSSOCallback.a(-2, localSSOException.getCause().getMessage());
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoSSOCallback.a(-3, localException.getCause().getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO.WebServiceSSOSender.1
 * JD-Core Version:    0.7.0.1
 */