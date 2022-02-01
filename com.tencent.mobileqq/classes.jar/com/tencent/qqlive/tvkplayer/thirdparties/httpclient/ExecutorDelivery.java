package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.os.Handler;
import java.io.IOException;
import java.util.concurrent.Executor;

public class ExecutorDelivery
  implements ResponseDelivery
{
  private final Executor mResponsePoster;
  
  public ExecutorDelivery(Handler paramHandler)
  {
    this.mResponsePoster = new ExecutorDelivery.1(this, paramHandler);
  }
  
  public ExecutorDelivery(Executor paramExecutor)
  {
    this.mResponsePoster = paramExecutor;
  }
  
  public void postError(Request paramRequest, IOException paramIOException)
  {
    paramIOException = Response.error(paramIOException);
    this.mResponsePoster.execute(new ExecutorDelivery.ResponseDeliveryRunnable(paramRequest, paramIOException));
  }
  
  public void postResponse(Request paramRequest, Response paramResponse)
  {
    this.mResponsePoster.execute(new ExecutorDelivery.ResponseDeliveryRunnable(paramRequest, paramResponse));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.ExecutorDelivery
 * JD-Core Version:    0.7.0.1
 */