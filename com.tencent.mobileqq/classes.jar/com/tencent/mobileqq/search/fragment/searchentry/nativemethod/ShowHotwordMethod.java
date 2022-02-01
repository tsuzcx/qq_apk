package com.tencent.mobileqq.search.fragment.searchentry.nativemethod;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

public class ShowHotwordMethod
  extends SearchNativeMethodBase
{
  public ShowHotwordMethod(Context paramContext, QQAppInterface paramQQAppInterface, INativeMethodHandler paramINativeMethodHandler)
  {
    super(paramContext, paramQQAppInterface, paramINativeMethodHandler);
  }
  
  public String getFuncName()
  {
    return "showHotword";
  }
  
  public void onCallBack(HippyMap paramHippyMap, Promise paramPromise)
  {
    boolean bool = paramHippyMap.getBoolean("show");
    this.methodHandler.setHotwordVisible(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.nativemethod.ShowHotwordMethod
 * JD-Core Version:    0.7.0.1
 */