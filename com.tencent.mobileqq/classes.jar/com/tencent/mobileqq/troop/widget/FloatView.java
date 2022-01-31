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
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = ((int)(this.jdField_a_of_type_Float - this.c));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = ((int)(this.b - this.d));
    this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Rect localRect = new Rect();
    getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
    this.b = (paramMotionEvent.getRawY() - i);
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.jdField_a_of_type_AndroidViewGestureDetector == null)
    {
      return true;
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      continue;
      b();
      continue;
      b();
      this.d = 0.0F;
      this.c = 0.0F;
    }
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnGestureListener(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = paramOnGestureListener;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, paramOnGestureListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.FloatView
 * JD-Core Version:    0.7.0.1
 */