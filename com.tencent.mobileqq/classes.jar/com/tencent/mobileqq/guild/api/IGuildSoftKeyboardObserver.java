package com.tencent.mobileqq.guild.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IGuildSoftKeyboardObserver
  extends QRouteApi
{
  public abstract void destroy();
  
  public abstract void newSoftKeyboardObserverImpl(View paramView, IGuildSoftKeyboardObserver.OnSoftKeyboardToggledListenerTemp paramOnSoftKeyboardToggledListenerTemp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildSoftKeyboardObserver
 * JD-Core Version:    0.7.0.1
 */