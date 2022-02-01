package com.tencent.mobileqq.leba.business;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ILebaRichApi
  extends QRouteApi
{
  public abstract void applyThemeBg(AppRuntime paramAppRuntime, View paramView, int paramInt, String paramString);
  
  public abstract boolean isShowQCircleEnter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.ILebaRichApi
 * JD-Core Version:    0.7.0.1
 */