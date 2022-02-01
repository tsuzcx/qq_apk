package com.tencent.mobileqq.share.api;

import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
public abstract interface QCircleActionSheetClickListener
{
  public abstract void afterHandleClick(boolean paramBoolean);
  
  public abstract void dispatchEvent();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.share.api.QCircleActionSheetClickListener
 * JD-Core Version:    0.7.0.1
 */