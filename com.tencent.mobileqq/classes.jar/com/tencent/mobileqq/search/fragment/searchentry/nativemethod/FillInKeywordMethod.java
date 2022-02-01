package com.tencent.mobileqq.search.fragment.searchentry.nativemethod;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

class FillInKeywordMethod
  extends SearchNativeMethodBase
{
  public FillInKeywordMethod(Context paramContext, QQAppInterface paramQQAppInterface, INativeMethodHandler paramINativeMethodHandler)
  {
    super(paramContext, paramQQAppInterface, paramINativeMethodHandler);
  }
  
  public String getFuncName()
  {
    return "startPageFillInKeyword";
  }
  
  public void onCallBack(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.getString("KEYWORD");
    this.methodHandler.fillKeyword(paramHippyMap);
    paramPromise.resolve(Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.nativemethod.FillInKeywordMethod
 * JD-Core Version:    0.7.0.1
 */