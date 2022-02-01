package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzonePluginProxyActivity
  extends QRouteApi
{
  public abstract ClassLoader getPhotoPlusClassLoader(Context paramContext);
  
  public abstract ClassLoader getQZonePluginClassLoader(Context paramContext);
  
  public abstract ClassLoader getQzoneLiveClassLoader(Context paramContext);
  
  public abstract ClassLoader getQzoneVerticalVideoClassLoader(Context paramContext);
  
  public abstract ClassLoader getQzoneWeishiFeedsClassLoader(Context paramContext);
  
  public abstract void launchPluingActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, boolean paramBoolean);
  
  public abstract void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt);
  
  public abstract void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean);
  
  public abstract void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, boolean paramBoolean2);
  
  public abstract void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, PreloadProcHitPluginSession paramPreloadProcHitPluginSession);
  
  public abstract void setActivityNameToIntent(Intent paramIntent, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzonePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */