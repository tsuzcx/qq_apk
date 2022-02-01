package com.tencent.qqmini.sdk.launcher.core.model;

import com.tencent.qqmini.sdk.launcher.core.IJsService;

public class RequestEvent$Builder
{
  RequestEvent reqEvent = new RequestEvent();
  
  public RequestEvent build()
  {
    return this.reqEvent;
  }
  
  public Builder setCallbackId(int paramInt)
  {
    this.reqEvent.callbackId = paramInt;
    return this;
  }
  
  public Builder setEvent(String paramString)
  {
    this.reqEvent.event = paramString;
    return this;
  }
  
  public Builder setJsService(IJsService paramIJsService)
  {
    this.reqEvent.jsService = paramIJsService;
    return this;
  }
  
  public Builder setJsonParams(String paramString)
  {
    this.reqEvent.jsonParams = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.RequestEvent.Builder
 * JD-Core Version:    0.7.0.1
 */