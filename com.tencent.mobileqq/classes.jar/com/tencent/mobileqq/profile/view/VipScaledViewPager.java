package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class VipScaledViewPager
  extends ViewPager
{
  private int a;
  private Rect b = new Rect();
  private Rect c = new Rect();
  private Rect d = new Rect();
  private float e;
  private int f;
  private ViewGroup g = null;
  private int h = -1;
  private int i = -1;
  private int j;
  private boolean k;
  private AtomicBoolean l = new AtomicBoolean(false);
  private HashMap<Integer, Integer> m = new HashMap();
  
  public VipScaledViewPager(Context paramContext)
  {
    super(paramContext);
    setStaticTransformationsEnabled(true);
  }
  
  public VipScaledViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setStaticTransformationsEnabled(true);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    setClipChildren(false);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.VipScaledViewPager);
    setMaxWidth(paramContext.getDimensionPixelSize(0, -1));
    setMaxHeight(paramContext.getDimensionPixelSize(1, -1));
    setMatchChildWidth(paramContext.getResourceId(2, 0));
    paramContext.recycle();
  }
  
  private static void a(Point paramPoint1, Point paramPoint2)
  {
    if ((paramPoint2.x >= 0) && (paramPoint1.x > paramPoint2.x)) {
      paramPoint1.x = paramPoint2.x;
    }
    if ((paramPoint2.y >= 0) && (paramPoint1.y > paramPoint2.y)) {
      paramPoint1.y = paramPoint2.y;
    }
  }
  
  private void a(View paramView, Transformation paramTransformation)
  {
    Matrix localMatrix = paramTransformation.getMatrix();
    float f1 = a(paramView);
    localMatrix.setScale(f1, f1);
    int i1 = paramView.getHeight();
    int n = paramView.getWidth() / 2;
    f1 = -n;
    i1 /= 2;
    localMatrix.preTranslate(f1, -i1);
    localMatrix.postTranslate(n, i1);
    paramTransformation.setAlpha(b(paramView));
  }
  
  private int c(View paramView)
  {
    paramView.getGlobalVisibleRect(this.b);
    paramView.getLocalVisibleRect(this.c);
    this.d.left = ((this.b.left + this.c.left) / 2);
    this.d.right = ((this.b.right + this.c.right) / 2);
    return Math.abs(this.d.right) / 2 - this.d.left;
  }
  
  private int getCenterOfCoverflow()
  {
    return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();
  }
  
  public float a(View paramView)
  {
    int n = c(paramView);
    int i1 = this.a - n;
    n = i1;
    if (i1 <= 0) {
      n = 0;
    }
    float f2 = (getWidth() - n) / getWidth();
    float f3 = this.e;
    float f1 = f2;
    if (f2 < f3) {
      f1 = f3;
    }
    return f1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipScaledViewPager", 2, "stopScroll");
    }
    this.l.set(false);
    c();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (!this.k) {
      return;
    }
    if (this.j == 0)
    {
      this.k = false;
      return;
    }
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      localView.measure(paramInt1, paramInt2);
      paramInt1 = localView.getMeasuredWidth();
      localView = localView.findViewById(this.j);
      if (localView != null)
      {
        paramInt2 = localView.getMeasuredWidth();
        if (paramInt2 > 0)
        {
          this.k = false;
          float f1 = paramInt1 - paramInt2;
          float f2 = paramInt2;
          setPageMargin(-(int)(f1 + (1.0F - this.e) * f2 * 0.5F - this.f));
          setOffscreenPageLimit((int)Math.ceil(paramInt1 / f2) + 1);
          requestLayout();
        }
      }
      else
      {
        throw new NullPointerException("MatchWithChildResId did not find that ID in the first fragment of the ViewPager; is that view defined in the child view's layout? Note that MultiViewPager only measures the child for index 0.");
      }
    }
  }
  
  public float b(View paramView)
  {
    int n = c(paramView);
    int i1 = this.a - n;
    n = i1;
    if (i1 <= 0) {
      n = 0;
    }
    float f2 = (getWidth() - n * 1.6F) / getWidth();
    float f1 = f2;
    if (f2 < 0.3F) {
      f1 = 0.3F;
    }
    return f1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipScaledViewPager", 2, "startScroll");
    }
    this.l.set(true);
    c();
  }
  
  public void c()
  {
    int n = 0;
    while (n < getChildCount())
    {
      View localView = getChildAt(n);
      this.m.put(Integer.valueOf(localView.hashCode()), Integer.valueOf(0));
      localView.invalidate();
      n += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewGroup localViewGroup = this.g;
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getChildStaticTransformation child = ");
      localStringBuilder.append(paramView.hashCode());
      localStringBuilder.append(", mIsScroll = ");
      localStringBuilder.append(this.l);
      localStringBuilder.append(", mInvalidateMap = ");
      localStringBuilder.append(this.m);
      QLog.d("VipScaledViewPager", 2, localStringBuilder.toString());
    }
    int n = paramView.hashCode();
    a(paramView, paramTransformation);
    if (this.l.get())
    {
      paramView.invalidate();
      return true;
    }
    if (this.m.containsKey(Integer.valueOf(n)))
    {
      if (((Integer)this.m.get(Integer.valueOf(n))).intValue() < 1)
      {
        this.m.put(Integer.valueOf(n), Integer.valueOf(1));
        paramView.invalidate();
        return true;
      }
    }
    else {
      this.m.put(Integer.valueOf(n), Integer.valueOf(0));
    }
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipScaledViewPager", 2, "onInterceptTouchEvent");
    }
    ViewGroup localViewGroup = this.g;
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(true);
    }
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Point localPoint = new Point(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    if ((this.h >= 0) || (this.i >= 0))
    {
      a(localPoint, new Point(this.h, this.i));
      paramInt1 = View.MeasureSpec.makeMeasureSpec(localPoint.x, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(localPoint.y, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    a(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = getCenterOfCoverflow();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.k = true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      label8:
      break label8;
    }
    return false;
  }
  
  public void setGap(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setMatchChildWidth(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      this.k = true;
    }
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setParentView(ViewGroup paramViewGroup)
  {
    this.g = paramViewGroup;
  }
  
  public void setScale(float paramFloat)
  {
    this.e = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipScaledViewPager
 * JD-Core Version:    0.7.0.1
 */