package com.tencent.tkd.topicsdk.interfaces;

import android.app.Activity;
import org.jetbrains.annotations.NotNull;

public abstract interface IPermission
{
  public abstract int a(@NotNull Activity paramActivity, @NotNull String paramString);
  
  public abstract void a(@NotNull Activity paramActivity, @NotNull String[] paramArrayOfString, int paramInt, @NotNull IPermission.Callback paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.interfaces.IPermission
 * JD-Core Version:    0.7.0.1
 */