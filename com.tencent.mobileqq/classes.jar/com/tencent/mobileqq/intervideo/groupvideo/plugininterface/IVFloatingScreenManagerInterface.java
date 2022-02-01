package com.tencent.mobileqq.intervideo.groupvideo.plugininterface;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.mediafocus.MediaFocusManager.OnMediaFocusChangeListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;

public abstract interface IVFloatingScreenManagerInterface
{
  public abstract int abandonMediaFocus(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener);
  
  public abstract int enterFloatingScreen(Context paramContext, View paramView);
  
  public abstract void quitFloatingScreen();
  
  public abstract int requestMediaFocus(int paramInt, MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener);
  
  public abstract IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener paramIVideoInnerStatusListener);
  
  public abstract void setFullScreenListener(IFullScreenEnterListener paramIFullScreenEnterListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVFloatingScreenManagerInterface
 * JD-Core Version:    0.7.0.1
 */