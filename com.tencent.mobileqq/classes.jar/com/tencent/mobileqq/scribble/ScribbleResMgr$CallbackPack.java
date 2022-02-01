package com.tencent.mobileqq.scribble;

import android.view.View;
import java.lang.ref.WeakReference;

class ScribbleResMgr$CallbackPack
{
  WeakReference<View> a;
  WeakReference<ResCallback> b;
  int c;
  int d;
  
  public ScribbleResMgr$CallbackPack(ScribbleResMgr paramScribbleResMgr, int paramInt1, int paramInt2, View paramView, ResCallback paramResCallback)
  {
    this.a = new WeakReference(paramView);
    this.b = new WeakReference(paramResCallback);
    this.d = paramInt1;
    this.c = paramInt2;
  }
  
  public View a()
  {
    return (View)this.a.get();
  }
  
  public ResCallback b()
  {
    return (ResCallback)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.CallbackPack
 * JD-Core Version:    0.7.0.1
 */