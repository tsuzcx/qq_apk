package com.tencent.shadow.core.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.shadow.core.runtime.qcircle.container.HostActivityDelegator;
import com.tencent.shadow.core.runtime.qcircle.container.PluginContainerActivity;

public class ShadowDialog
  extends ReportDialog
{
  public ShadowDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  public ShadowDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ShadowDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  public final ShadowActivity getOwnerPluginActivity()
  {
    PluginContainerActivity localPluginContainerActivity = (PluginContainerActivity)getOwnerActivity();
    if (localPluginContainerActivity != null) {
      return (ShadowActivity)localPluginContainerActivity.getPluginActivity();
    }
    return null;
  }
  
  public final void setOwnerPluginActivity(ShadowActivity paramShadowActivity)
  {
    setOwnerActivity((Activity)paramShadowActivity.mHostActivityDelegator.getHostActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.ShadowDialog
 * JD-Core Version:    0.7.0.1
 */