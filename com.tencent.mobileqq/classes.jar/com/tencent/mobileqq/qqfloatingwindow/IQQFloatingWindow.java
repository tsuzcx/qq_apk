package com.tencent.mobileqq.qqfloatingwindow;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenViewClickListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowClickListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQFloatingWindow
  extends QRouteApi
{
  public abstract int enterCustomFloatingScreen(Context paramContext, View paramView, FloatingScreenParams paramFloatingScreenParams, String paramString, int paramInt);
  
  public abstract int enterFloatingScreen(Context paramContext, View paramView, FloatingScreenParams paramFloatingScreenParams, int paramInt);
  
  public abstract int enterLocationFloatingScreen(Context paramContext, View paramView, FloatingScreenParams paramFloatingScreenParams, String paramString);
  
  public abstract int enterWatchTogetherFloatingScreen(Context paramContext, View paramView, FloatingScreenParams paramFloatingScreenParams, String paramString);
  
  public abstract void quitFloatingScreen();
  
  public abstract void quitFloatingScreen(String paramString);
  
  public abstract void saveFloatingCenter(int paramInt1, int paramInt2);
  
  public abstract IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener paramIVideoInnerStatusListener);
  
  public abstract IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener paramIVideoInnerStatusListener, String paramString);
  
  @Deprecated
  public abstract void setFullScreenListener(IFullScreenEnterListener paramIFullScreenEnterListener);
  
  public abstract void setFullScreenViewClickListener(IFullScreenViewClickListener paramIFullScreenViewClickListener);
  
  public abstract void setWindowClickListener(String paramString, IWindowClickListener paramIWindowClickListener);
  
  public abstract void updateFloatingWindowRatio(float paramFloat, String paramString);
  
  public abstract void updateFloatingWindowShape(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow
 * JD-Core Version:    0.7.0.1
 */