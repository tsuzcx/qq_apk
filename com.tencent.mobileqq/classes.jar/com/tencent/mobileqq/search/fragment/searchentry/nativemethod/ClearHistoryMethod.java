package com.tencent.mobileqq.search.fragment.searchentry.nativemethod;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

class ClearHistoryMethod
  extends SearchNativeMethodBase
{
  public ClearHistoryMethod(Context paramContext, QQAppInterface paramQQAppInterface, INativeMethodHandler paramINativeMethodHandler)
  {
    super(paramContext, paramQQAppInterface, paramINativeMethodHandler);
  }
  
  public String getFuncName()
  {
    return "clearHistoryData";
  }
  
  public void onCallBack(HippyMap paramHippyMap, Promise paramPromise)
  {
    SearchWordHistoryManager.a().d();
    paramPromise.resolve("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.nativemethod.ClearHistoryMethod
 * JD-Core Version:    0.7.0.1
 */