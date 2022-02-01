package com.tencent.mobileqq.miniapp;

import java.lang.ref.WeakReference;

public abstract class MiniAppInfoCallback<T>
{
  public WeakReference<T> b;
  
  public MiniAppInfoCallback(T paramT)
  {
    this.b = new WeakReference(paramT);
  }
  
  public abstract void a(T paramT, boolean paramBoolean, MiniAppInfo paramMiniAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppInfoCallback
 * JD-Core Version:    0.7.0.1
 */