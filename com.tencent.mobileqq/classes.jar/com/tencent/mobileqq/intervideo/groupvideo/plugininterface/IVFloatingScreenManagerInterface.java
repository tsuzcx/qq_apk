package com.tencent.mobileqq.intervideo.groupvideo.plugininterface;

import android.content.Context;
import android.view.View;
import asgp;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;

public abstract interface IVFloatingScreenManagerInterface
{
  public abstract int abandonMediaFocus(asgp paramasgp);
  
  public abstract int enterFloatingScreen(Context paramContext, View paramView);
  
  public abstract void quitFloatingScreen();
  
  public abstract int requestMediaFocus(int paramInt, asgp paramasgp);
  
  public abstract IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener paramIVideoInnerStatusListener);
  
  public abstract void setFullScreenListener(IFullScreenEnterListener paramIFullScreenEnterListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVFloatingScreenManagerInterface
 * JD-Core Version:    0.7.0.1
 */