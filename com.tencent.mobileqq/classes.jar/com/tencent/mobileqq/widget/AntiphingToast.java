package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.Timer;

public class AntiphingToast
{
  Handler a = new AntiphingToast.1(this, Looper.getMainLooper());
  private int b = 0;
  private Resources c;
  private LayoutInflater d;
  private Drawable e = null;
  private CharSequence f = null;
  private FrameLayout g = null;
  private View h = null;
  private boolean i = true;
  private String j = "AntiPhing";
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, paramFloat1, paramFloat2);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(700L);
    localTranslateAnimation.setStartOffset(20L);
    if (paramBoolean == true) {
      localTranslateAnimation.setAnimationListener(new AntiphingToast.2(this));
    }
    this.g.startAnimation(localTranslateAnimation);
  }
  
  public void a(int paramInt)
  {
    a(this.c.getString(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, FrameLayout paramFrameLayout)
  {
    a(paramFrameLayout);
    a(paramInt1);
    b(paramInt2);
  }
  
  public void a(FrameLayout paramFrameLayout)
  {
    this.g = paramFrameLayout;
    this.c = paramFrameLayout.getContext().getResources();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.f = paramCharSequence;
  }
  
  public boolean a(String paramString)
  {
    if (this.i)
    {
      Object localObject = this.g;
      if (localObject == null) {
        return false;
      }
      this.i = false;
      ((FrameLayout)localObject).removeAllViewsInLayout();
      if (this.d == null) {
        this.d = LayoutInflater.from(this.g.getContext());
      }
      if (this.h == null)
      {
        this.h = this.d.inflate(2131628277, null);
        localObject = this.h;
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131428407);
          if ((localObject != null) && (paramString != null)) {
            ((TextView)localObject).setText(paramString);
          }
        }
      }
      this.g.addView(this.h);
      this.g.setFocusable(false);
      this.g.bringToFront();
      a(-80.0F, 0.0F, false);
      new Timer().schedule(new AntiphingToast.3(this), this.b + 700);
      return true;
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AntiphingToast
 * JD-Core Version:    0.7.0.1
 */