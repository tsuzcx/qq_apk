package com.tencent.mobileqq.troop.redpoint.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.redpoint.RedPointListener;
import java.util.List;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface IRedPointUtilsApi
  extends QRouteApi
{
  public abstract void addRedPointListener(AppRuntime paramAppRuntime, RedPointListener paramRedPointListener);
  
  public abstract void cleanRedPointInfoById(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt);
  
  public abstract void cleanRedPointInfoByIds(AppRuntime paramAppRuntime, String paramString1, String paramString2, List<Integer> paramList);
  
  public abstract void notifyRedPointViewClick(AppRuntime paramAppRuntime, String paramString1, String paramString2, View paramView);
  
  public abstract void removeRedPointListener(AppRuntime paramAppRuntime, RedPointListener paramRedPointListener);
  
  public abstract void updateRedPointInfo(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi
 * JD-Core Version:    0.7.0.1
 */