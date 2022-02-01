package com.tencent.mobileqq.listentogether.lyrics;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class FloatBaseLayout
  extends FrameLayout
{
  FloatLayoutCallback a;
  public int b;
  public int c;
  WindowManager d;
  WindowManager.LayoutParams e;
  boolean f = false;
  int g = 0;
  float h;
  float i;
  float j;
  float k;
  boolean l = false;
  float m = 6.0F;
  boolean n = false;
  
  public FloatBaseLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.m = AIOUtils.b(3.0F, getResources());
    this.d = ((WindowManager)getContext().getSystemService("window"));
    this.e = new WindowManager.LayoutParams();
    paramContext = this.e;
    paramContext.format = -3;
    paramContext.flags = 808;
    if (Build.VERSION.SDK_INT >= 26) {
      this.e.type = 2038;
    } else {
      this.e.type = 2002;
    }
    paramContext = this.e;
    paramContext.systemUiVisibility = 5892;
    paramContext.gravity = 85;
    paramContext.setTitle("FloatBaseLayout");
    paramContext = this.e;
    paramContext.x = 0;
    paramContext.y = 0;
    h();
  }
  
  private void h()
  {
    try
    {
      int i1 = ((Integer)this.e.getClass().getField("privateFlags").get(this.e)).intValue();
      this.e.getClass().getField("privateFlags").set(this.e, Integer.valueOf(i1 | 0x40));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.e.x) || (paramInt2 != this.e.y))
    {
      WindowManager.LayoutParams localLayoutParams = this.e;
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("showOrUpdate mAdded: ");
      localStringBuilder1.append(this.f);
      QLog.d("FloatBaseLayout", 2, localStringBuilder1.toString());
    }
    for (;;)
    {
      try
      {
        boolean bool2 = this.f;
        bool1 = false;
        StringBuilder localStringBuilder2;
        if (!bool2)
        {
          int i1 = this.g;
          if (i1 >= 4) {
            break label247;
          }
          try
          {
            this.d.addView(this, this.e);
            this.f = true;
            this.g = 0;
          }
          catch (Throwable localThrowable1)
          {
            this.g += 1;
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("showOrUpdate addView mExceptionCount:");
            localStringBuilder2.append(this.g);
            localStringBuilder2.append(" error:");
            localStringBuilder2.append(localThrowable1.getMessage());
            QLog.e("FloatBaseLayout", 1, localStringBuilder2.toString());
            continue;
          }
        }
        else
        {
          bool2 = this.f;
          if (!bool2) {
            break label247;
          }
          try
          {
            this.d.updateViewLayout(this, this.e);
          }
          catch (Throwable localThrowable2)
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("showOrUpdate updateViewLayout error: ");
            localStringBuilder2.append(localThrowable2.getMessage());
            QLog.e("FloatBaseLayout", 1, localStringBuilder2.toString());
          }
        }
        return bool1;
      }
      finally {}
      label247:
      boolean bool1 = true;
    }
  }
  
  public void b()
  {
    if (this.f) {
      try
      {
        this.d.updateViewLayout(this, this.e);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showOrUpdate updateViewLayout error: ");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("FloatBaseLayout", 1, localStringBuilder.toString());
      }
    }
  }
  
  public boolean c()
  {
    try
    {
      boolean bool3 = this.f;
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (bool3) {
        try
        {
          this.d.removeView(this);
          this.f = false;
          bool1 = bool2;
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("showOrUpdate addView error: ");
          localStringBuilder.append(localThrowable.getMessage());
          QLog.e("FloatBaseLayout", 1, localStringBuilder.toString());
          bool1 = false;
        }
      }
      this.g = 0;
      return bool1;
    }
    finally {}
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    int i1 = paramMotionEvent.getAction();
    boolean bool = false;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label253;
          }
        }
        else
        {
          if ((Math.abs(f1 - this.j) > this.m) && (Math.abs(f2 - this.k) > this.m) && (this.n) && (!this.l))
          {
            this.l = true;
            f();
          }
          localFloatLayoutCallback = this.a;
          if ((localFloatLayoutCallback != null) && (this.l)) {
            localFloatLayoutCallback.a((int)(f1 - this.h), (int)(f2 - this.i));
          }
          if (this.l)
          {
            bool = true;
            break label253;
          }
          bool = super.dispatchTouchEvent(paramMotionEvent);
          break label253;
        }
      }
      FloatLayoutCallback localFloatLayoutCallback = this.a;
      if ((localFloatLayoutCallback != null) && (this.l)) {
        localFloatLayoutCallback.a();
      }
      if (this.l)
      {
        g();
        bool = true;
      }
      else
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
      }
      this.l = false;
      this.n = false;
    }
    else
    {
      this.j = f1;
      this.k = f2;
      this.l = false;
      this.n = true;
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    label253:
    this.h = f1;
    this.i = f2;
    return bool;
  }
  
  public void e()
  {
    this.a = null;
  }
  
  protected void f() {}
  
  protected void g() {}
  
  public int getCurrentX()
  {
    return this.e.x;
  }
  
  public int getCurrentY()
  {
    return this.e.y;
  }
  
  public int getFloatCenterX()
  {
    return this.e.x + this.e.width / 2;
  }
  
  public int getFloatHeight()
  {
    return this.c;
  }
  
  public int getFloatLeft()
  {
    return this.e.x + this.e.width;
  }
  
  public int getFloatRight()
  {
    return this.e.x;
  }
  
  public int getFloatWidth()
  {
    return this.b;
  }
  
  public WindowManager.LayoutParams getLayoutParams()
  {
    return this.e;
  }
  
  public void setFloatLayoutCallback(FloatLayoutCallback paramFloatLayoutCallback)
  {
    this.a = paramFloatLayoutCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatBaseLayout
 * JD-Core Version:    0.7.0.1
 */