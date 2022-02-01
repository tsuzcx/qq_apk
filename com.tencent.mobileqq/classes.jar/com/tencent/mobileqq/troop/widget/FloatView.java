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
  private float jdField_a_of_type_Float;
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private float b;
  private float c;
  private float d;
  
  public FloatView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getApplicationContext().getSystemService("window"));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
  }
  
  private void b()
  {
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.x = ((int)(this.jdField_a_of_type_Float - this.c));
    localLayoutParams.y = ((int)(this.b - this.d));
    this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, localLayoutParams);
  }
  
  public void a()
  {
    WindowManager localWindowManager = this.jdField_a_of_type_AndroidViewWindowManager;
    if (localWindowManager != null) {
      localWindowManager.removeView(this);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = new Rect();
    getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
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
    localObject = this.jdField_a_of_type_AndroidViewGestureDetector;
    if (localObject == null) {
      return true;
    }
    return ((GestureDetector)localObject).onTouchEvent(paramMotionEvent);
  }
  
  public void setOnGestureListener(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = paramOnGestureListener;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, paramOnGestureListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.FloatView
 * JD-Core Version:    0.7.0.1
 */