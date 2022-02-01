package com.tencent.mobileqq.guild.main;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.IDragView.OnChangeModeListener;

public abstract interface IChannelListControl
  extends DragFrameLayout.OnDragModeChangedListener
{
  public abstract String a();
  
  public abstract AppInterface b();
  
  public abstract IDragView.OnChangeModeListener c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.IChannelListControl
 * JD-Core Version:    0.7.0.1
 */