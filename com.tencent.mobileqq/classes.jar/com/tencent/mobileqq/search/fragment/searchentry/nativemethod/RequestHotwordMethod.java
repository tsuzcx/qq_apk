package com.tencent.mobileqq.search.fragment.searchentry.nativemethod;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

public class RequestHotwordMethod
  extends SearchNativeMethodBase
{
  public RequestHotwordMethod(Context paramContext, QQAppInterface paramQQAppInterface, INativeMethodHandler paramINativeMethodHandler)
  {
    super(paramContext, paramQQAppInterface, paramINativeMethodHandler);
  }
  
  public String getFuncName()
  {
    return "requestHotword";
  }
  
  public void onCallBack(HippyMap paramHippyMap, Promise paramPromise)
  {
    boolean bool;
    if ((paramHippyMap != null) && (paramHippyMap.containsKey("isForce"))) {
      bool = paramHippyMap.getBoolean("isForce");
    } else {
      bool = true;
    }
    this.methodHandler.requestSearchHotWord(bool);
    paramPromise.resolve("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.nativemethod.RequestHotwordMethod
 * JD-Core Version:    0.7.0.1
 */