package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.mediafocus.MediaFocusManager;
import com.tencent.mobileqq.mediafocus.MediaFocusManager.OnMediaFocusChangeListener;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;

public class IVFloatingScreenManagerInterfaceImpl
{
  private static final String TAG = "IVFloatingScreenManagerInterfaceImpl";
  private static final IVFloatingScreenManagerInterfaceImpl sInstance = new IVFloatingScreenManagerInterfaceImpl();
  
  static IVFloatingScreenManagerInterfaceImpl getInstance()
  {
    return sInstance;
  }
  
  int abandonMediaFocus(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    return MediaFocusManager.a().a(paramOnMediaFocusChangeListener);
  }
  
  int enterFloatingScreen(Context paramContext, View paramView)
  {
    FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setIsHorizontal(false).setCanMove(true).setCanZoom(false).build();
    return ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(paramContext, paramView, localFloatingScreenParams, 2);
  }
  
  void quitFloatingScreen()
  {
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen();
  }
  
  int requestMediaFocus(int paramInt, MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    return MediaFocusManager.a().a(paramInt, paramOnMediaFocusChangeListener);
  }
  
  IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    return ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(paramIVideoInnerStatusListener);
  }
  
  void setFullScreenListener(IFullScreenEnterListener paramIFullScreenEnterListener)
  {
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFullScreenListener(paramIFullScreenEnterListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVFloatingScreenManagerInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */