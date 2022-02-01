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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  private HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private int jdField_c_of_type_Int = -1;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  private int d = -1;
  private int e;
  
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
  
  private int a()
  {
    return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();
  }
  
  private int a(View paramView)
  {
    paramView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    paramView.getLocalVisibleRect(this.jdField_b_of_type_AndroidGraphicsRect);
    this.jdField_c_of_type_AndroidGraphicsRect.left = ((this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_b_of_type_AndroidGraphicsRect.left) / 2);
    this.jdField_c_of_type_AndroidGraphicsRect.right = ((this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_b_of_type_AndroidGraphicsRect.right) / 2);
    return Math.abs(this.jdField_c_of_type_AndroidGraphicsRect.right) / 2 - this.jdField_c_of_type_AndroidGraphicsRect.left;
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
    float f = a(paramView);
    localMatrix.setScale(f, f);
    int j = paramView.getHeight();
    int i = paramView.getWidth() / 2;
    f = -i;
    j /= 2;
    localMatrix.preTranslate(f, -j);
    localMatrix.postTranslate(i, j);
    paramTransformation.setAlpha(b(paramView));
  }
  
  public float a(View paramView)
  {
    int i = a(paramView);
    int j = this.jdField_a_of_type_Int - i;
    i = j;
    if (j <= 0) {
      i = 0;
    }
    float f2 = (getWidth() - i) / getWidth();
    float f3 = this.jdField_a_of_type_Float;
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
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    c();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.e == 0)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      localView.measure(paramInt1, paramInt2);
      paramInt1 = localView.getMeasuredWidth();
      localView = localView.findViewById(this.e);
      if (localView != null)
      {
        paramInt2 = localView.getMeasuredWidth();
        if (paramInt2 > 0)
        {
          this.jdField_a_of_type_Boolean = false;
          float f1 = paramInt1 - paramInt2;
          float f2 = paramInt2;
          setPageMargin(-(int)(f1 + (1.0F - this.jdField_a_of_type_Float) * f2 * 0.5F - this.jdField_b_of_type_Int));
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
    int i = a(paramView);
    int j = this.jdField_a_of_type_Int - i;
    i = j;
    if (j <= 0) {
      i = 0;
    }
    float f2 = (getWidth() - i * 1.6F) / getWidth();
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
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    c();
  }
  
  public void c()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localView.hashCode()), Integer.valueOf(0));
      localView.invalidate();
      i += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
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
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      localStringBuilder.append(", mInvalidateMap = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilHashMap);
      QLog.d("VipScaledViewPager", 2, localStringBuilder.toString());
    }
    int i = paramView.hashCode();
    a(paramView, paramTransformation);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramView.invalidate();
      return true;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i)))
    {
      if (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i))).intValue() < 1)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), Integer.valueOf(1));
        paramView.invalidate();
        return true;
      }
    }
    else {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), Integer.valueOf(0));
    }
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipScaledViewPager", 2, "onInterceptTouchEvent");
    }
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
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
    if ((this.jdField_c_of_type_Int >= 0) || (this.d >= 0))
    {
      a(localPoint, new Point(this.jdField_c_of_type_Int, this.d));
      paramInt1 = View.MeasureSpec.makeMeasureSpec(localPoint.x, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(localPoint.y, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    a(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = a();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Boolean = true;
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
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setMatchChildWidth(int paramInt)
  {
    if (this.e != paramInt)
    {
      this.e = paramInt;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setParentView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void setScale(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipScaledViewPager
 * JD-Core Version:    0.7.0.1
 */