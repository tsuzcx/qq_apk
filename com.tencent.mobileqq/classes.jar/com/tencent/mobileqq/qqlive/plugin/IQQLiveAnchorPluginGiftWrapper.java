package com.tencent.mobileqq.qqlive.plugin;

import android.content.Context;
import android.view.View;

public abstract interface IQQLiveAnchorPluginGiftWrapper
{
  public abstract void destroy(Context paramContext);
  
  public abstract View getBannerView(Context paramContext);
  
  public abstract View getGiftAnimationView(Context paramContext);
  
  public abstract int getGiftPushCmd();
  
  public abstract int getGiftPushSubCmd();
  
  public abstract void init(Context paramContext);
  
  public abstract void receivePushMsg(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.plugin.IQQLiveAnchorPluginGiftWrapper
 * JD-Core Version:    0.7.0.1
 */