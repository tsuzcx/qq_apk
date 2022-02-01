package com.tencent.mobileqq.search.fragment.searchentry.nativemethod;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.TKDSearchHistoryBean;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.util.URLUtil;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;

class OpenHistoryMethod
  extends SearchNativeMethodBase
{
  public OpenHistoryMethod(Context paramContext, QQAppInterface paramQQAppInterface, INativeMethodHandler paramINativeMethodHandler)
  {
    super(paramContext, paramQQAppInterface, paramINativeMethodHandler);
  }
  
  @Nullable
  private TKDSearchHistoryBean getTargetHistoryBean(@NonNull HippyMap paramHippyMap)
  {
    Object localObject = SearchWordHistoryManager.a().c();
    int i = paramHippyMap.getInt("id");
    int j = paramHippyMap.getInt("fromWhere");
    paramHippyMap = ((List)localObject).iterator();
    while (paramHippyMap.hasNext())
    {
      localObject = (TKDSearchHistoryBean)paramHippyMap.next();
      if ((localObject != null) && (i == ((TKDSearchHistoryBean)localObject).getId()) && (j == ((TKDSearchHistoryBean)localObject).getFromWhere())) {
        return localObject;
      }
    }
    return null;
  }
  
  private boolean isHistoryBeanInvalid(TKDSearchHistoryBean paramTKDSearchHistoryBean)
  {
    return (paramTKDSearchHistoryBean == null) || ((TextUtils.isEmpty(paramTKDSearchHistoryBean.getTitle())) && (TextUtils.isEmpty(paramTKDSearchHistoryBean.getUrl())));
  }
  
  private void openHistory(@NonNull TKDSearchHistoryBean paramTKDSearchHistoryBean)
  {
    String str2 = paramTKDSearchHistoryBean.getUrl();
    String str1;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (URLUtil.e(str2)) {}
    }
    else
    {
      str1 = SearchConfigUtils.d(10);
      str1 = SearchConfigUtils.a(paramTKDSearchHistoryBean.getTitle(), 5, str1);
    }
    SearchUtils.a(this.app, this.context, str1);
  }
  
  public String getFuncName()
  {
    return "openHistory";
  }
  
  public void onCallBack(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = getTargetHistoryBean(paramHippyMap);
    if (isHistoryBeanInvalid(paramHippyMap))
    {
      paramPromise.reject("not have");
      return;
    }
    openHistory(paramHippyMap);
    SearchWordHistoryManager.a().a(paramHippyMap);
    paramPromise.resolve("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.nativemethod.OpenHistoryMethod
 * JD-Core Version:    0.7.0.1
 */