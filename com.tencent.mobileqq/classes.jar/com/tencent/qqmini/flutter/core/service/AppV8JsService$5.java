package com.tencent.qqmini.flutter.core.service;

import com.tencent.qqmini.miniapp.core.service.ServiceEventListener;
import com.tencent.tissue.v8rt.engine.IServiceEventHandler;

class AppV8JsService$5
  implements IServiceEventHandler
{
  AppV8JsService$5(AppV8JsService paramAppV8JsService, ServiceEventListener paramServiceEventListener) {}
  
  public void onServiceEvent(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    this.val$appBrandEventInterface.onServiceEvent(paramString1, paramString2, paramArrayOfInt);
  }
  
  public String onServiceNativeRequest(String paramString1, String paramString2, int paramInt)
  {
    return this.val$appBrandEventInterface.onServiceNativeRequest(paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.service.AppV8JsService.5
 * JD-Core Version:    0.7.0.1
 */