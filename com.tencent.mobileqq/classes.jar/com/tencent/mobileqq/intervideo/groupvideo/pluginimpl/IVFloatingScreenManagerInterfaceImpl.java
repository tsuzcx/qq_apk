package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.content.Context;
import android.view.View;
import asgl;
import asgp;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;

public class IVFloatingScreenManagerInterfaceImpl
{
  private static final String TAG = "IVFloatingScreenManagerInterfaceImpl";
  private static final IVFloatingScreenManagerInterfaceImpl sInstance = new IVFloatingScreenManagerInterfaceImpl();
  
  static IVFloatingScreenManagerInterfaceImpl getInstance()
  {
    return sInstance;
  }
  
  int abandonMediaFocus(asgp paramasgp)
  {
    return asgl.a().a(paramasgp);
  }
  
  int enterFloatingScreen(Context paramContext, View paramView)
  {
    FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setIsHorizontal(false).setCanMove(true).build();
    return FloatingScreenManager.getInstance().enterFloatingScreen(paramContext, paramView, localFloatingScreenParams, 2);
  }
  
  void quitFloatingScreen()
  {
    FloatingScreenManager.getInstance().quitFloatingScreen();
  }
  
  int requestMediaFocus(int paramInt, asgp paramasgp)
  {
    return asgl.a().a(paramInt, paramasgp);
  }
  
  IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    return FloatingScreenManager.getInstance().setFloatingVideoListener(paramIVideoInnerStatusListener);
  }
  
  void setFullScreenListener(IFullScreenEnterListener paramIFullScreenEnterListener)
  {
    FloatingScreenManager.getInstance().setFullScreenListener(paramIFullScreenEnterListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVFloatingScreenManagerInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */