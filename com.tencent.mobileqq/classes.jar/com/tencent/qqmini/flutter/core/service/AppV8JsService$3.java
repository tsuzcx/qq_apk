package com.tencent.qqmini.flutter.core.service;

import android.webkit.ValueCallback;
import com.tencent.tissue.v8rt.engine.Callback;

class AppV8JsService$3
  implements Callback
{
  AppV8JsService$3(AppV8JsService paramAppV8JsService, ValueCallback paramValueCallback) {}
  
  public void onFinish(Object paramObject)
  {
    this.val$valueCallback.onReceiveValue(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.service.AppV8JsService.3
 * JD-Core Version:    0.7.0.1
 */