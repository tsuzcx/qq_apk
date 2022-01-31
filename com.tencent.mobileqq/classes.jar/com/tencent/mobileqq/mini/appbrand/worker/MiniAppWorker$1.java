package com.tencent.mobileqq.mini.appbrand.worker;

import android.util.Log;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;

class MiniAppWorker$1
  implements JsContext.ExceptionHandler
{
  MiniAppWorker$1(MiniAppWorker paramMiniAppWorker) {}
  
  public void handleException(JsContext paramJsContext, JsError paramJsError)
  {
    Log.e("miniapp-worker", "X5Exception:" + paramJsError.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.worker.MiniAppWorker.1
 * JD-Core Version:    0.7.0.1
 */