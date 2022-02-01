package com.tencent.mobileqq.search.fragment.searchentry.nativemethod;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

public class OnHotwordClickMethod
  extends SearchNativeMethodBase
{
  public OnHotwordClickMethod(Context paramContext, QQAppInterface paramQQAppInterface, INativeMethodHandler paramINativeMethodHandler)
  {
    super(paramContext, paramQQAppInterface, paramINativeMethodHandler);
  }
  
  public String getFuncName()
  {
    return "onHotwordClick";
  }
  
  public void onCallBack(HippyMap paramHippyMap, Promise paramPromise)
  {
    int i = paramHippyMap.getInt("hotwordID");
    this.methodHandler.onHotwordClick(i);
    paramPromise.resolve("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.nativemethod.OnHotwordClickMethod
 * JD-Core Version:    0.7.0.1
 */