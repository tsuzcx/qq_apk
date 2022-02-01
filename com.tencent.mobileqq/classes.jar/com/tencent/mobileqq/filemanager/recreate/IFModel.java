package com.tencent.mobileqq.filemanager.recreate;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

public abstract interface IFModel
{
  public abstract void a(Activity paramActivity, int paramInt);
  
  public abstract void a(Activity paramActivity, int paramInt1, int paramInt2);
  
  public abstract void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface);
  
  public abstract boolean a(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.recreate.IFModel
 * JD-Core Version:    0.7.0.1
 */