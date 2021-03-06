package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

class ExecutorDelivery$ResponseDeliveryRunnable
  implements Runnable
{
  private final Request mRequest;
  private final Response mResponse;
  
  public ExecutorDelivery$ResponseDeliveryRunnable(Request paramRequest, Response paramResponse)
  {
    this.mRequest = paramRequest;
    this.mResponse = paramResponse;
  }
  
  public void run()
  {
    if (this.mRequest.isCanceled())
    {
      this.mRequest.finish();
      return;
    }
    if (this.mResponse.isSuccess()) {
      this.mRequest.deliverResponse(this.mResponse);
    } else {
      this.mRequest.deliverError(this.mResponse.e);
    }
    this.mRequest.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.ExecutorDelivery.ResponseDeliveryRunnable
 * JD-Core Version:    0.7.0.1
 */