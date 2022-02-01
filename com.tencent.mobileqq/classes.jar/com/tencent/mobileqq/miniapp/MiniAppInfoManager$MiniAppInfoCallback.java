package com.tencent.mobileqq.miniapp;

import java.lang.ref.WeakReference;

public abstract class MiniAppInfoManager$MiniAppInfoCallback<T>
{
  public WeakReference<T> a;
  
  public MiniAppInfoManager$MiniAppInfoCallback(T paramT)
  {
    this.a = new WeakReference(paramT);
  }
  
  public abstract void a(T paramT, boolean paramBoolean, MiniAppInfo paramMiniAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppInfoManager.MiniAppInfoCallback
 * JD-Core Version:    0.7.0.1
 */