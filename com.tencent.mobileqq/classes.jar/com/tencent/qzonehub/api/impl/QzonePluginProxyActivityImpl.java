package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.qzonehub.api.IQzonePluginProxyActivity;
import cooperation.qzone.QzonePluginProxyActivity;

public class QzonePluginProxyActivityImpl
  implements IQzonePluginProxyActivity
{
  public ClassLoader getPhotoPlusClassLoader(Context paramContext)
  {
    return QzonePluginProxyActivity.getPhotoPlusClassLoader(paramContext);
  }
  
  public ClassLoader getQZonePluginClassLoader(Context paramContext)
  {
    return QzonePluginProxyActivity.getQZonePluginClassLoader(paramContext);
  }
  
  public ClassLoader getQzoneLiveClassLoader(Context paramContext)
  {
    return QzonePluginProxyActivity.getQzoneLiveClassLoader(paramContext);
  }
  
  public ClassLoader getQzoneVerticalVideoClassLoader(Context paramContext)
  {
    return QzonePluginProxyActivity.getQzoneVerticalVideoClassLoader(paramContext);
  }
  
  public ClassLoader getQzoneWeishiFeedsClassLoader(Context paramContext)
  {
    return QzonePluginProxyActivity.getQzoneWeishiFeedsClassLoader(paramContext);
  }
  
  public void launchPluingActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString, paramIntent, paramInt, paramBoolean);
  }
  
  public void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    QzonePluginProxyActivity.launchPluingActivityForResult(paramContext, paramString, paramIntent, paramInt);
  }
  
  public void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    QzonePluginProxyActivity.launchPluingActivityForResult(paramContext, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean);
  }
  
  public void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, boolean paramBoolean2)
  {
    QzonePluginProxyActivity.launchPluingActivityForResult(paramContext, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean1, paramPreloadProcHitPluginSession, paramBoolean2);
  }
  
  public void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    QzonePluginProxyActivity.launchPluingActivityForResult(paramContext, paramString, paramIntent, paramInt, paramPreloadProcHitPluginSession);
  }
  
  public void setActivityNameToIntent(Intent paramIntent, String paramString)
  {
    QzonePluginProxyActivity.setActivityNameToIntent(paramIntent, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzonePluginProxyActivityImpl
 * JD-Core Version:    0.7.0.1
 */