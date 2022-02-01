package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVFloatingScreenManagerInterface;
import com.tencent.mobileqq.mediafocus.MediaFocusManager.OnMediaFocusChangeListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;

public class IVFloatingScreenManager
  implements IVFloatingScreenManagerInterface
{
  public int abandonMediaFocus(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    return IVFloatingScreenManagerInterfaceImpl.getInstance().abandonMediaFocus(paramOnMediaFocusChangeListener);
  }
  
  public int enterFloatingScreen(Context paramContext, View paramView)
  {
    return IVFloatingScreenManagerInterfaceImpl.getInstance().enterFloatingScreen(paramContext, paramView);
  }
  
  public void quitFloatingScreen()
  {
    IVFloatingScreenManagerInterfaceImpl.getInstance().quitFloatingScreen();
  }
  
  public int requestMediaFocus(int paramInt, MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    return IVFloatingScreenManagerInterfaceImpl.getInstance().requestMediaFocus(paramInt, paramOnMediaFocusChangeListener);
  }
  
  public IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    return IVFloatingScreenManagerInterfaceImpl.getInstance().setFloatingVideoListener(paramIVideoInnerStatusListener);
  }
  
  public void setFullScreenListener(IFullScreenEnterListener paramIFullScreenEnterListener)
  {
    IVFloatingScreenManagerInterfaceImpl.getInstance().setFullScreenListener(paramIFullScreenEnterListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVFloatingScreenManager
 * JD-Core Version:    0.7.0.1
 */