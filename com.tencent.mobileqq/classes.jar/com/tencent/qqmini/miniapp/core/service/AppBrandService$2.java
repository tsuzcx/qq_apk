package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;

class AppBrandService$2
  implements JsContext.ExceptionHandler
{
  AppBrandService$2(AppBrandService paramAppBrandService) {}
  
  public void handleException(JsContext paramJsContext, JsError paramJsError)
  {
    paramJsContext = new StringBuilder();
    paramJsContext.append("X5Exception:");
    paramJsContext.append(paramJsError.getMessage());
    QMLog.e("AppBrandService", paramJsContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandService.2
 * JD-Core Version:    0.7.0.1
 */