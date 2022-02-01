package com.tencent.mobileqq.ocr.view.gesture.animation;

import android.os.Build.VERSION;
import android.view.View;

public abstract class AnimationEngine
  implements Runnable
{
  private final View a;
  private final GestureFps b;
  
  public AnimationEngine(View paramView)
  {
    this.a = paramView;
    if (GestureFps.a()) {
      paramView = new GestureFps();
    } else {
      paramView = null;
    }
    this.b = paramView;
  }
  
  private void b()
  {
    this.a.removeCallbacks(this);
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.a.postOnAnimationDelayed(this, 10L);
      return;
    }
    this.a.postDelayed(this, 10L);
  }
  
  public void a(int paramInt)
  {
    GestureFps localGestureFps = this.b;
    if (localGestureFps != null) {
      localGestureFps.a(paramInt);
    }
    b();
  }
  
  public abstract boolean a();
  
  public final void run()
  {
    boolean bool = a();
    GestureFps localGestureFps = this.b;
    if (localGestureFps != null)
    {
      localGestureFps.c();
      if (!bool) {
        this.b.b();
      }
    }
    if (bool) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.animation.AnimationEngine
 * JD-Core Version:    0.7.0.1
 */