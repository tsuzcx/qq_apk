package com.tencent.qzonehub.api;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzonePluginProxyActivityProxy
  extends QRouteApi
{
  public abstract ClassLoader getPhotoPlusClassLoader(Context paramContext);
  
  public abstract String getPluginID();
  
  public abstract Class<? extends PluginProxyActivity> getProxyActivity(String paramString);
  
  public abstract ClassLoader getQzoneLiveClassLoader(Context paramContext);
  
  public abstract ClassLoader getQzoneVerticalVideoClassLoader(Context paramContext);
  
  public abstract ClassLoader getQzoneWeishiFeedsClassLoader(Context paramContext);
  
  public abstract void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzonePluginProxyActivityProxy
 * JD-Core Version:    0.7.0.1
 */