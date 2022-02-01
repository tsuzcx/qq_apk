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
    Object localObject = this.a;
    if (this.b != null) {}
    try
    {
      localObject = (byte[])((Future)localObject).get();
      this.c.b.incrementAndGet();
      this.b.a((byte[])localObject);
      return;
    }
    catch (Exception localException)
    {
      this.b.a(-3, localException.getCause().getMessage());
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      this.c.b.incrementAndGet();
      WebServiceSSO.WebServiceSSOSender.SSOException localSSOException;
      if ((localExecutionException.getCause() instanceof WebServiceSSO.WebServiceSSOSender.SSOException))
      {
        localSSOException = (WebServiceSSO.WebServiceSSOSender.SSOException)localExecutionException.getCause();
        this.b.a(localSSOException.errorCode, localSSOException.errorMessage);
        return;
      }
      this.b.a(-2, localSSOException.getCause().getMessage());
      return;
      this.c.b.incrementAndGet();
      this.b.a(-1, "InterruptedException");
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      label131:
      break label131;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO.WebServiceSSOSender.1
 * JD-Core Version:    0.7.0.1
 */