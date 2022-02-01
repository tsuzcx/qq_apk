package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;

public class FloatView
  extends ImageView
{
  private float a;
  private float b;
  private float c;
  private float d;
  private WindowManager e;
  private WindowManager.LayoutParams f;
  private GestureDetector g;
  private GestureDetector.OnGestureListener h;
  
  public FloatView(Context paramContext)
  {
    super(paramContext);
    this.e = ((WindowManager)paramContext.getApplicationContext().getSystemService("window"));
    this.f = new WindowManager.LayoutParams();
  }
  
  private void b()
  {
    WindowManager.LayoutParams localLayoutParams = this.f;
    localLayoutParams.x = ((int)(this.a - this.c));
    localLayoutParams.y = ((int)(this.b - this.d));
    this.e.updateViewLayout(this, localLayoutParams);
  }
  
  public void a()
  {
    WindowManager localWindowManager = this.e;
    if (localWindowManager != null) {
      localWindowManager.removeView(this);
    }
  }
  
  public WindowManager getWindowManager()
  {
    return this.e;
  }
  
  public WindowManager.LayoutParams getWindowParams()
  {
    return this.f;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = new Rect();
    getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    this.a = paramMotionEvent.getRawX();
    this.b = (paramMotionEvent.getRawY() - i);
    i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          b();
        }
      }
      else
      {
        b();
        this.d = 0.0F;
        this.c = 0.0F;
      }
    }
    else
    {
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
    }
    localObject = this.g;
    if (localObject == null) {
      return true;
    }
    return ((GestureDetector)localObject).onTouchEvent(paramMotionEvent);
  }
  
  public void setOnGestureListener(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this.h = paramOnGestureListener;
    this.g = new GestureDetector(paramContext, paramOnGestureListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.FloatView
 * JD-Core Version:    0.7.0.1
 */