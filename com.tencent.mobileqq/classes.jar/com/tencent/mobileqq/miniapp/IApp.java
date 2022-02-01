package com.tencent.mobileqq.miniapp;

import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;

public abstract class IApp
{
  public MiniAppActivity a;
  public MiniAppInfo b;
  
  public IApp(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
  {
    this.a = paramMiniAppActivity;
  }
  
  public abstract void a();
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.b = paramMiniAppInfo;
    MiniAppActivity localMiniAppActivity = this.a;
    if (localMiniAppActivity != null) {
      localMiniAppActivity.c = paramMiniAppInfo;
    }
  }
  
  public abstract void b();
  
  public abstract boolean c();
  
  public void d()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.IApp
 * JD-Core Version:    0.7.0.1
 */