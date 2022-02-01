package com.tencent.mobileqq.qroute.route;

public abstract interface URIRequestCallback
  extends URIResultCode
{
  public abstract void onComplete(int paramInt);
  
  public abstract void onNext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.URIRequestCallback
 * JD-Core Version:    0.7.0.1
 */