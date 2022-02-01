package com.tencent.mobileqq.webprocess.temp.api;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IWebviewApi
  extends QRouteApi
{
  public abstract Object createShare(AppRuntime paramAppRuntime, Activity paramActivity);
  
  public abstract List<String> getMenuHideNameList(Object paramObject);
  
  public abstract Object getSharePd(Object paramObject);
  
  public abstract int getWebViewDialogMultiLineLayout();
  
  public abstract boolean onQRFromX5(Object paramObject);
  
  public abstract void removeLastUinCookies(String paramString);
  
  public abstract boolean shouldOverrideLongClick(View paramView, Object paramObject);
  
  public abstract void showActionSheet(long paramLong, Object paramObject1, Object paramObject2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.temp.api.IWebviewApi
 * JD-Core Version:    0.7.0.1
 */