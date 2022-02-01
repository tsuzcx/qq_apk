package com.tencent.mobileqq.qroute.route;

import java.util.Iterator;

class Router$3
  implements URIRequestCallback
{
  Router$3(Router paramRouter, Iterator paramIterator, URIRequest paramURIRequest, Router.OnCompleteListener paramOnCompleteListener) {}
  
  public void onComplete(int paramInt)
  {
    if (paramInt == 0) {
      if (this.val$listener != null) {
        this.val$listener.onSuccess();
      }
    }
    while (this.val$listener == null) {
      return;
    }
    this.val$listener.onError(paramInt);
  }
  
  public void onNext()
  {
    this.this$0.handleURI(this.val$iterator, this.val$request, this.val$listener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.Router.3
 * JD-Core Version:    0.7.0.1
 */