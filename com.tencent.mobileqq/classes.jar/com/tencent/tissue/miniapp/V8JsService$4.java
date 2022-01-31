package com.tencent.tissue.miniapp;

import com.tencent.qqmini.sdk.core.service.ServiceEventListener;
import com.tencent.tissue.v8rt.engine.IServiceEventHandler;

class V8JsService$4
  implements IServiceEventHandler
{
  V8JsService$4(V8JsService paramV8JsService, ServiceEventListener paramServiceEventListener) {}
  
  public void onServiceEvent(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    this.val$appBrandEventInterface.onServiceEvent(paramString1, paramString2, paramArrayOfInt);
  }
  
  public String onServiceNativeRequest(String paramString1, String paramString2, int paramInt)
  {
    return this.val$appBrandEventInterface.onServiceNativeRequest(paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.miniapp.V8JsService.4
 * JD-Core Version:    0.7.0.1
 */