package com.tencent.qqmini.sdk.minigame.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import bexf;
import bfgs;
import bfho;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

public class VConsoleDragView
  extends ImageView
{
  private int jdField_a_of_type_Int;
  private DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  private bexf jdField_a_of_type_Bexf;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public VConsoleDragView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public VConsoleDragView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public VConsoleDragView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = bfho.a();
    int n = bfho.b();
    if (bfgs.a()) {}
    for (int m = bfgs.a(getContext());; m = 0)
    {
      this.b = (m + n);
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = MiniAppEnv.g().getContext().getResources().getDisplayMetrics();
      return;
    }
  }
  
  public void a()
  {
    int m = bfho.a();
    int i1 = bfho.b();
    if (m > i1)
    {
      n = m;
      this.jdField_a_of_type_Int = n;
      n = m;
      if (m > i1) {
        n = i1;
      }
      this.b = n;
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = MiniAppEnv.g().getContext().getResources().getDisplayMetrics();
      return;
    }
    if (bfgs.a()) {}
    for (int n = bfgs.a(getContext());; n = 0)
    {
      n += i1;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.c = getMeasuredWidth();
    this.d = getMeasuredHeight();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    this.e = ((int)paramMotionEvent.getRawX());
    this.f = ((int)paramMotionEvent.getRawY());
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    case 0: 
      this.g = this.e;
      this.h = this.f;
      return true;
    case 2: 
      int m = this.e - this.g;
      int n = this.f - this.h;
      this.i = (getLeft() + m);
      this.j = (getTop() + n);
      this.k = (m + getRight());
      this.l = (getBottom() + n);
      if (this.i < 0)
      {
        this.i = 0;
        this.k = (this.i + this.c);
        if (this.j >= 0) {
          break label348;
        }
        this.j = 0;
        this.l = (this.j + this.d);
      }
      for (;;)
      {
        localLayoutParams.setMargins(this.i, this.j, this.jdField_a_of_type_Int - this.k, this.b - this.l);
        setLayoutParams(localLayoutParams);
        if ((!this.jdField_a_of_type_Boolean) && ((Math.abs(this.e - this.g) > this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 2.0F) || (Math.abs(this.f - this.h) > this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 2.0F))) {
          this.jdField_a_of_type_Boolean = true;
        }
        this.g = this.e;
        this.h = this.f;
        return true;
        if (this.k <= this.jdField_a_of_type_Int) {
          break;
        }
        this.k = this.jdField_a_of_type_Int;
        this.i = (this.k - this.c);
        break;
        label348:
        if (this.l > this.b)
        {
          this.l = this.b;
          this.j = (this.b - this.d);
        }
      }
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bexf != null)) {
      this.jdField_a_of_type_Bexf.d();
    }
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
  
  public void setListener(bexf parambexf)
  {
    this.jdField_a_of_type_Bexf = parambexf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.VConsoleDragView
 * JD-Core Version:    0.7.0.1
 */