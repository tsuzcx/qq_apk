package com.tencent.mobileqq.wink.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQWinkLaucher
  extends QRouteApi
{
  public abstract void jumpToPreviewFragment(Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2);
  
  public abstract void jumpToWinkCamera(Context paramContext, Intent paramIntent, String paramString);
  
  public abstract void jumpToWinkCoverEditor(Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2);
  
  public abstract void jumpToWinkEditor(Context paramContext, Intent paramIntent, String paramString);
  
  public abstract void jumpToWinkPick(Context paramContext, Intent paramIntent, String paramString);
  
  public abstract void jumpToWinkPublish(Context paramContext, Intent paramIntent, String paramString);
  
  public abstract void preloadWink(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.api.IQQWinkLaucher
 * JD-Core Version:    0.7.0.1
 */