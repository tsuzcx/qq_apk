package com.tencent.mobileqq.qqfloatingwindow;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQFloatingPermission
  extends QRouteApi
{
  public abstract boolean checkPermission(Context paramContext);
  
  public abstract void enterPermissionRequestDialog(Context paramContext);
  
  public abstract void enterPermissionRequestDialogCustom(Context paramContext, int paramInt1, int paramInt2);
  
  public abstract boolean requestPermission(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission
 * JD-Core Version:    0.7.0.1
 */