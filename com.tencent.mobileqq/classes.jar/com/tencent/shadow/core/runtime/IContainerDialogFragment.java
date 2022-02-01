package com.tencent.shadow.core.runtime;

import android.content.DialogInterface;

public abstract interface IContainerDialogFragment
  extends IContainerFragment
{
  public abstract void onDismiss(DialogInterface paramDialogInterface);
  
  public abstract void superOnDismiss(DialogInterface paramDialogInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.IContainerDialogFragment
 * JD-Core Version:    0.7.0.1
 */