package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.content.Context;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;

public class QQFloatingPermissionImpl
  implements IQQFloatingPermission
{
  public boolean checkPermission(Context paramContext)
  {
    return FloatingScreenPermission.checkPermission(paramContext);
  }
  
  public void enterPermissionRequestDialog(Context paramContext)
  {
    FloatingScreenPermission.enterPermissionRequestDialog(paramContext);
  }
  
  public void enterPermissionRequestDialogCustom(Context paramContext, int paramInt1, int paramInt2)
  {
    FloatingScreenPermission.enterPermissionRequestDialogCustom(paramContext, paramInt1, paramInt2);
  }
  
  public boolean requestPermission(Context paramContext)
  {
    return FloatingScreenPermission.requestPermission(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.QQFloatingPermissionImpl
 * JD-Core Version:    0.7.0.1
 */