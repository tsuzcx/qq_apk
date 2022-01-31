package com.tencent.mobileqq.multiaio.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import aull;
import aumc;
import aumd;
import aume;
import aumq;
import com.tencent.qphone.base.util.QLog;

public class MultiAIOViewPager
  extends MultiAIOBaseViewPager
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private aull jdField_a_of_type_Aull;
  private aume jdField_a_of_type_Aume;
  private aumq jdField_a_of_type_Aumq;
  private int d;
  private int e = -1;
  
  public MultiAIOViewPager(@NonNull Context paramContext)
  {
    super(paramContext);
    h();
  }
  
  public MultiAIOViewPager(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h();
  }
  
  private boolean g()
  {
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      Object localObject = localView.getTag();
      if ((localObject == null) || (!(localObject instanceof Integer))) {}
      int j;
      do
      {
        i += 1;
        break;
        j = ((Integer)localObject).intValue();
      } while ((localView.getScaleX() != 1.0F) || (j == a()));
      return false;
    }
    return true;
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new aumc(this), new Handler(Looper.getMainLooper()));
    a(new aumd(this));
  }
  
  public void b(float paramFloat)
  {
    this.c = ((int)(this.jdField_a_of_type_Int * paramFloat));
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOViewPager", 2, "updateMaxVelocity() called with: mMaximumVelocity = [" + this.c + "]");
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOViewPager", 2, "dispatchTouchEvent() called with: ev = [" + paramMotionEvent + "], handled " + bool);
    }
    if ((bool) && (this.jdField_a_of_type_Aumq != null)) {
      this.jdField_a_of_type_Aumq.b(this, paramMotionEvent);
    }
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_Aull != null) {
      this.jdField_a_of_type_Aull.b();
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Aull != null) {
      this.jdField_a_of_type_Aull.a();
    }
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i;
    try
    {
      i = super.getChildDrawingOrder(paramInt1, paramInt2);
      if ((i < 0) || (i >= paramInt1)) {
        throw new IndexOutOfBoundsException("childCount = " + paramInt1 + ", childDrawingOrder = " + i + ", try fix it");
      }
    }
    catch (Exception localException)
    {
      QLog.e("MultiAIOViewPager", 1, "getChildDrawingOrder: ", localException);
      super.d();
      return paramInt2;
    }
    return i;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOViewPager", 2, "onInterceptTouchEvent() called with: ev = [" + paramMotionEvent + "], handled = " + bool);
      }
      if (this.jdField_a_of_type_Aume != null) {
        this.jdField_a_of_type_Aume.a(bool);
      }
      return bool;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      paramMotionEvent = getContext();
      if (!(paramMotionEvent instanceof Activity)) {
        break label152;
      }
    }
    Activity localActivity = (Activity)paramMotionEvent;
    paramMotionEvent = "onInterceptTouchEvent: Dispatching touch event activity.isFinish = " + localActivity.isFinishing();
    if (Build.VERSION.SDK_INT >= 17) {
      paramMotionEvent = paramMotionEvent + ", isDestroyed = " + localActivity.isDestroyed();
    }
    for (;;)
    {
      QLog.e("MultiAIOViewPager", 1, paramMotionEvent, localIllegalArgumentException);
      label152:
      return true;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = true;
    int i = getChildCount();
    boolean bool1 = e();
    Object localObject = a();
    if ((localObject instanceof MultiAIOPagerAdapter))
    {
      localObject = (MultiAIOPagerAdapter)localObject;
      boolean bool3 = ((MultiAIOPagerAdapter)localObject).a();
      ((MultiAIOPagerAdapter)localObject).a(false);
      if (bool3) {
        bool1 = true;
      }
    }
    for (;;)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.d != i) {
        bool1 = true;
      }
      if (!g()) {}
      for (paramBoolean = bool2;; paramBoolean = bool1)
      {
        if (paramBoolean) {
          super.a(getScrollX());
        }
        this.d = i;
        return;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOViewPager", 2, "onTouchEvent() called with: ev = [" + paramMotionEvent + "], handled " + bool);
    }
    return bool;
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_Aull = new aull();
    this.jdField_a_of_type_Aull.a(paramString);
  }
  
  public void setAnchorX(int paramInt)
  {
    this.e = paramInt;
    invalidate();
  }
  
  public void setIdleListener(aume paramaume)
  {
    this.jdField_a_of_type_Aume = paramaume;
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setTouchEventConsumer(aumq paramaumq)
  {
    this.jdField_a_of_type_Aumq = paramaumq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager
 * JD-Core Version:    0.7.0.1
 */