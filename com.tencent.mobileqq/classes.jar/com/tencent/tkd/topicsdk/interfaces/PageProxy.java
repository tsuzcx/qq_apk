package com.tencent.tkd.topicsdk.interfaces;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class PageProxy
  implements IPage
{
  private IPage a;
  
  @Nullable
  public Activity a()
  {
    return this.a.a();
  }
  
  @Nullable
  public Bundle a()
  {
    return this.a.a();
  }
  
  @Nullable
  public abstract View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle);
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent) {}
  
  public void a(@Nullable Bundle paramBundle) {}
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void a(@NotNull IPage paramIPage)
  {
    this.a = paramIPage;
    paramIPage = a();
    if (paramIPage != null) {
      paramIPage.setRequestedOrientation(1);
    }
  }
  
  public void b() {}
  
  public void d() {}
  
  public void e() {}
  
  public boolean e()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.interfaces.PageProxy
 * JD-Core Version:    0.7.0.1
 */