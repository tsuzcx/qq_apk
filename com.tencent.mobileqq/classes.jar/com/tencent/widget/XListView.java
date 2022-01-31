package com.tencent.widget;

import actj;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import bftz;
import bfxm;
import bfxn;
import com.tencent.mobileqq.R.styleable;

public class XListView
  extends ListView
{
  private int jdField_a_of_type_Int;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private bftz jdField_a_of_type_Bftz;
  private bfxm jdField_a_of_type_Bfxm;
  private bfxn jdField_a_of_type_Bfxn;
  private boolean jdField_a_of_type_Boolean;
  private int b = -1;
  private int c;
  private int d = 0;
  private int e;
  private int f;
  
  public XListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public XListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public XListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mOverscrollDistance = 2147483647;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.tencent_widget);
    setMaxHeight(localTypedArray.getDimensionPixelSize(0, -1));
    localTypedArray.recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.XListView);
    boolean bool = paramContext.getBoolean(0, false);
    paramContext.recycle();
    setEdgeEffectEnabled(bool);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
  }
  
  private int a()
  {
    if (getContext().getResources().getDisplayMetrics().widthPixels > getContext().getResources().getDisplayMetrics().heightPixels) {
      return 1;
    }
    return 2;
  }
  
  private void a()
  {
    if ((this.e == this.c) && (this.f == this.d)) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    this.e = this.c;
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    switch (this.d)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(new RectF(0.0F, 0.0F, i, j), this.c, this.c, Path.Direction.CW);
      return;
    case 2: 
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.c;
      f2 = this.c;
      f3 = this.c;
      f4 = this.c;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, 0.0F, 0.0F, 0.0F, 0.0F, f3, f4 }, localDirection);
      return;
    case 3: 
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.c;
      f2 = this.c;
      f3 = this.c;
      f4 = this.c;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
      return;
    case 4: 
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.c;
      f2 = this.c;
      f3 = this.c;
      f4 = this.c;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, f1, f2, f3, f4, 0.0F, 0.0F }, localDirection);
      return;
    }
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = new RectF(0.0F, 0.0F, i, j);
    float f1 = this.c;
    float f2 = this.c;
    float f3 = this.c;
    float f4 = this.c;
    Path.Direction localDirection = Path.Direction.CW;
    localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f2, f3, f4 }, localDirection);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if (this.jdField_a_of_type_Bftz != null) {
      this.jdField_a_of_type_Bftz.a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_Bfxm != null) {
      this.jdField_a_of_type_Bfxm.a();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Bfxn != null)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (localMotionEvent != null)
      {
        bool1 = this.jdField_a_of_type_Bfxn.a(this, localMotionEvent);
        localMotionEvent.recycle();
      }
    }
    for (;;)
    {
      if (!bool1) {
        try
        {
          bool2 = super.dispatchTouchEvent(paramMotionEvent);
          if (!bool1)
          {
            bool1 = bool3;
            if (!bool2) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
        catch (RuntimeException paramMotionEvent)
        {
          for (;;)
          {
            actj.a("XLISTVIEW_dispatchTouchEvent_ERROR", "dispatchTouchEvent_ERROR", paramMotionEvent);
            boolean bool2 = false;
          }
        }
      }
      return true;
      bool1 = false;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.d != 0)
    {
      int i = paramCanvas.save();
      a();
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i;
    if (this.b > 0)
    {
      int j = View.MeasureSpec.getMode(paramInt2);
      i = paramInt2;
      if (View.MeasureSpec.getSize(paramInt2) > this.b)
      {
        i = paramInt2;
        if (j != 0) {
          i = View.MeasureSpec.makeMeasureSpec(this.b, j);
        }
      }
    }
    for (;;)
    {
      super.onMeasure(paramInt1, i);
      return;
      i = paramInt2;
      if (this.jdField_a_of_type_Boolean) {
        i = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = a();
    if (this.jdField_a_of_type_Int != i) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt1, paramInt2, paramInt3, paramInt4, bool, i);
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public void setCornerRadiusAndMode(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void setDrawFinishedListener(bfxm parambfxm)
  {
    this.jdField_a_of_type_Bfxm = parambfxm;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.b = paramInt;
    if (this.b < getMeasuredHeight()) {
      requestLayout();
    }
  }
  
  public void setMotionEventInterceptor(bfxn parambfxn)
  {
    this.jdField_a_of_type_Bfxn = parambfxn;
  }
  
  public void setOnSizeChangeListener(bftz parambftz)
  {
    this.jdField_a_of_type_Bftz = parambftz;
  }
  
  public void setOverScrollDistance(int paramInt)
  {
    this.mOverscrollDistance = paramInt;
  }
  
  public void setWrapByScroll(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.XListView
 * JD-Core Version:    0.7.0.1
 */