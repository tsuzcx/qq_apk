package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import bfos;
import bfsg;
import bfsh;
import java.util.concurrent.atomic.AtomicBoolean;

public class GestureSelectGridView
  extends GridView
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  public bfos a;
  public bfsh a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  float jdField_b_of_type_Float;
  public int b;
  AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean b;
  public int c;
  AtomicBoolean c;
  final int d = 20000000;
  
  public GestureSelectGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GestureSelectGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 15);
    super.setOnScrollListener(new bfsg(this));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i;
    do
    {
      return bool1;
      i = paramMotionEvent.getAction();
      if (i != 2) {
        break;
      }
      bool1 = bool2;
    } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i & 0xFF)
    {
    }
    do
    {
      for (;;)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
        return super.onInterceptTouchEvent(paramMotionEvent);
        float f3 = Math.abs(f1 - this.jdField_a_of_type_Float);
        if ((f3 > Math.abs(f2 - this.jdField_b_of_type_Float) * 1.73F) && (f3 > this.jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          this.jdField_a_of_type_Float = f1;
          this.jdField_b_of_type_Float = f2;
          continue;
          this.jdField_a_of_type_Float = f1;
          this.jdField_b_of_type_Float = f2;
          i = pointToPosition((int)f1, (int)f2);
          if (i != -1)
          {
            this.jdField_c_of_type_Int = i;
            this.jdField_b_of_type_Int = i;
          }
        }
      }
      bool1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_b_of_type_Int = -1;
      this.jdField_c_of_type_Int = -1;
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    } while (!bool1);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i & 0xFF)
    {
    default: 
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        return true;
      }
      break;
    case 2: 
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        float f3 = Math.abs(f1 - this.jdField_a_of_type_Float);
        if ((f3 > Math.abs(f2 - this.jdField_b_of_type_Float) * 1.73F) && (f3 > this.jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          this.jdField_a_of_type_Float = f1;
          this.jdField_b_of_type_Float = f2;
        }
      }
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!this.jdField_a_of_type_Boolean)) {
        if ((f2 < 0.0F) || (f2 > getHeight()))
        {
          this.jdField_a_of_type_Boolean = true;
          if (f2 >= 0.0F) {
            break label334;
          }
          i = -20000000;
          this.jdField_b_of_type_Boolean = false;
        }
      }
      break;
    }
    for (;;)
    {
      label201:
      smoothScrollBy(i, 1000000);
      while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if ((!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_b_of_type_Int != -1))
        {
          if (this.jdField_a_of_type_Bfsh != null) {
            this.jdField_a_of_type_Bfsh.a(this.jdField_b_of_type_Int);
          }
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
        i = pointToPosition((int)f1, (int)f2);
        if (i == -1) {
          break;
        }
        if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label401;
        }
        this.jdField_c_of_type_Int = i;
        this.jdField_b_of_type_Int = i;
        if (this.jdField_a_of_type_Bfsh != null) {
          this.jdField_a_of_type_Bfsh.a(this.jdField_b_of_type_Int);
        }
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        break;
        label334:
        if (f2 <= getHeight()) {
          break label548;
        }
        i = 20000000;
        this.jdField_b_of_type_Boolean = true;
        break label201;
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_Boolean) && (f2 > 0.0F) && (f2 < getHeight()))
        {
          abordFling();
          this.jdField_a_of_type_Boolean = false;
        }
      }
      label401:
      if (this.jdField_c_of_type_Int == i) {
        break;
      }
      this.jdField_c_of_type_Int = i;
      if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bfsh == null)) {
        break;
      }
      this.jdField_a_of_type_Bfsh.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      break;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      break;
      if (this.jdField_a_of_type_Boolean)
      {
        abordFling();
        this.jdField_a_of_type_Boolean = false;
      }
      boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      this.jdField_b_of_type_Int = -1;
      this.jdField_c_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if ((bool) && (this.jdField_a_of_type_Bfsh != null)) {
        this.jdField_a_of_type_Bfsh.g();
      }
      if (!bool) {
        break;
      }
      return true;
      return super.onTouchEvent(paramMotionEvent);
      label548:
      i = 0;
    }
  }
  
  public void setOnIndexChangedListener(bfsh parambfsh)
  {
    this.jdField_a_of_type_Bfsh = parambfsh;
  }
  
  public void setOnScrollListener(bfos parambfos)
  {
    this.jdField_a_of_type_Bfos = parambfos;
  }
  
  public void setSelectMode(boolean paramBoolean)
  {
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
  }
  
  public void setTouchSlopRate(int paramInt)
  {
    this.jdField_a_of_type_Int = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.GestureSelectGridView
 * JD-Core Version:    0.7.0.1
 */