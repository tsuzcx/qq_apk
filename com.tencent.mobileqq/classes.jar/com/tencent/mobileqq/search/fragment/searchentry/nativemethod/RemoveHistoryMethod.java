package com.tencent.mobileqq.search.fragment.searchentry.nativemethod;

import android.content.Context;
import aohb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.TKDSearchHistoryBean;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.util.List;

class RemoveHistoryMethod
  extends SearchNativeMethodBase
{
  public RemoveHistoryMethod(Context paramContext, QQAppInterface paramQQAppInterface, INativeMethodHandler paramINativeMethodHandler)
  {
    super(paramContext, paramQQAppInterface, paramINativeMethodHandler);
  }
  
  public String getFuncName()
  {
    return "removeHistoryData";
  }
  
  public void onCallBack(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramPromise = aohb.a().a();
    int i = 0;
    while (i < paramPromise.size())
    {
      TKDSearchHistoryBean localTKDSearchHistoryBean = (TKDSearchHistoryBean)paramPromise.get(i);
      if ((localTKDSearchHistoryBean != null) && (localTKDSearchHistoryBean.getId() == paramHippyMap.getInt("id")) && (localTKDSearchHistoryBean.getFromWhere() == paramHippyMap.getInt("fromWhere"))) {
        aohb.a().a(i);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.nativemethod.RemoveHistoryMethod
 * JD-Core Version:    0.7.0.1
 */