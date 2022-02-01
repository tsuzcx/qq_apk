package com.tencent.tkd.topicsdk.interfaces;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.jetbrains.annotations.NotNull;

public abstract interface IPageOpener
{
  public abstract void a(@NotNull Activity paramActivity, @NotNull Bundle paramBundle, int paramInt);
  
  public abstract void a(@NotNull Context paramContext, @NotNull Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.interfaces.IPageOpener
 * JD-Core Version:    0.7.0.1
 */