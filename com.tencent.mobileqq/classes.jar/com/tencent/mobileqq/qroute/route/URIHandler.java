package com.tencent.mobileqq.qroute.route;

public abstract class URIHandler
{
  public void handle(URIRequest paramURIRequest, URIRequestCallback paramURIRequestCallback)
  {
    if (shouldHandleURI(paramURIRequest))
    {
      handleURI(paramURIRequest, paramURIRequestCallback);
      return;
    }
    paramURIRequestCallback.onNext();
  }
  
  protected abstract void handleURI(URIRequest paramURIRequest, URIRequestCallback paramURIRequestCallback);
  
  protected abstract boolean shouldHandleURI(URIRequest paramURIRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.URIHandler
 * JD-Core Version:    0.7.0.1
 */