package dov.com.qq.im.aeeditor.lyric.interaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import bpam;
import bpbz;
import bpcb;
import bpcc;
import bpck;
import bpcl;
import com.tencent.mobileqq.R.styleable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AESlidingUpPanelLayout
  extends ViewGroup
{
  private static AESlidingUpPanelLayout.PanelState jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = AESlidingUpPanelLayout.PanelState.COLLAPSED;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842927 };
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 400;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private bpck jdField_a_of_type_Bpck = new bpck();
  private final bpcl jdField_a_of_type_Bpcl;
  private final List<bpcc> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 1.0F;
  private int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  private AESlidingUpPanelLayout.PanelState jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = -1;
  private View jdField_c_of_type_AndroidViewView;
  private AESlidingUpPanelLayout.PanelState jdField_c_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = -1;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = true;
  private int h;
  
  public AESlidingUpPanelLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AESlidingUpPanelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AESlidingUpPanelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_Bpcl = null;
      return;
    }
    TypedArray localTypedArray;
    if (paramAttributeSet != null)
    {
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt);
      if (localTypedArray != null)
      {
        setGravity(localTypedArray.getInt(0, 0));
        localTypedArray.recycle();
      }
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AESlidingUpPanelLayout);
      if (localTypedArray == null) {}
    }
    for (;;)
    {
      try
      {
        this.jdField_c_of_type_Int = localTypedArray.getDimensionPixelSize(7, -1);
        this.jdField_d_of_type_Int = localTypedArray.getDimensionPixelSize(11, -1);
        this.jdField_e_of_type_Int = localTypedArray.getDimensionPixelSize(8, -1);
        this.jdField_a_of_type_Int = localTypedArray.getInt(4, 400);
        this.jdField_b_of_type_Int = localTypedArray.getColor(3, 0);
        this.jdField_f_of_type_Int = localTypedArray.getResourceId(2, -1);
        this.jdField_g_of_type_Int = localTypedArray.getResourceId(10, -1);
        this.jdField_b_of_type_Boolean = localTypedArray.getBoolean(6, false);
        this.jdField_c_of_type_Boolean = localTypedArray.getBoolean(1, true);
        this.jdField_b_of_type_Float = localTypedArray.getFloat(0, 1.0F);
        this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = AESlidingUpPanelLayout.PanelState.values()[localTypedArray.getInt(5, jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState.ordinal())];
        paramInt = localTypedArray.getResourceId(9, -1);
        if (paramInt == -1) {
          break label540;
        }
        paramAttributeSet = AnimationUtils.loadInterpolator(paramContext, paramInt);
      }
      catch (Throwable paramAttributeSet)
      {
        float f1;
        bpam.a("SlidingUpPanelLayout", paramAttributeSet);
        localTypedArray.recycle();
        paramAttributeSet = null;
        continue;
      }
      finally
      {
        localTypedArray.recycle();
      }
      f1 = paramContext.getResources().getDisplayMetrics().density;
      if (this.jdField_c_of_type_Int == -1) {
        this.jdField_c_of_type_Int = ((int)(68.0F * f1 + 0.5F));
      }
      if (this.jdField_d_of_type_Int == -1) {
        this.jdField_d_of_type_Int = ((int)(4.0F * f1 + 0.5F));
      }
      if (this.jdField_e_of_type_Int == -1) {
        this.jdField_e_of_type_Int = ((int)(0.0F * f1));
      }
      if (this.jdField_d_of_type_Int > 0)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837742);
          setWillNotDraw(false);
          this.jdField_a_of_type_Bpcl = bpcl.a(this, 0.5F, paramAttributeSet, new bpcb(this, null));
          this.jdField_a_of_type_Bpcl.a(this.jdField_a_of_type_Int * f1);
          this.jdField_e_of_type_Boolean = true;
          return;
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837743);
        continue;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      continue;
      label540:
      paramAttributeSet = null;
      continue;
      paramAttributeSet = null;
    }
  }
  
  private float a(int paramInt)
  {
    int i = a(0.0F);
    if (this.jdField_a_of_type_Boolean) {
      return (i - paramInt) / this.h;
    }
    return (paramInt - i) / this.h;
  }
  
  private int a(float paramFloat)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {}
    int j;
    for (int i = this.jdField_c_of_type_AndroidViewView.getMeasuredHeight();; i = 0)
    {
      j = (int)(this.h * paramFloat);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      return getMeasuredHeight() - getPaddingBottom() - this.jdField_c_of_type_Int - j;
    }
    return getPaddingTop() - i + this.jdField_c_of_type_Int + j;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState != AESlidingUpPanelLayout.PanelState.DRAGGING) {
      this.jdField_c_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
    }
    a(AESlidingUpPanelLayout.PanelState.DRAGGING);
    this.jdField_a_of_type_Float = a(paramInt);
    d();
    a(this.jdField_c_of_type_AndroidViewView);
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    AESlidingUpPanelLayout.LayoutParams localLayoutParams = null;
    if ((localLayoutParams1 instanceof AESlidingUpPanelLayout.LayoutParams)) {
      localLayoutParams = (AESlidingUpPanelLayout.LayoutParams)localLayoutParams1;
    }
    if (localLayoutParams == null) {}
    do
    {
      return;
      int i = getHeight();
      int j = getPaddingBottom();
      int k = getPaddingTop();
      int m = this.jdField_c_of_type_Int;
      if ((this.jdField_a_of_type_Float <= 0.0F) && (!this.jdField_b_of_type_Boolean))
      {
        if (this.jdField_a_of_type_Boolean) {
          paramInt -= getPaddingBottom();
        }
        for (;;)
        {
          localLayoutParams.height = paramInt;
          if (localLayoutParams.height == i - j - k - m) {
            localLayoutParams.height = -1;
          }
          this.jdField_d_of_type_AndroidViewView.requestLayout();
          return;
          paramInt = getHeight() - getPaddingBottom() - this.jdField_c_of_type_AndroidViewView.getMeasuredHeight() - paramInt;
        }
      }
    } while ((localLayoutParams.height == -1) || (this.jdField_b_of_type_Boolean));
    localLayoutParams.height = -1;
    this.jdField_d_of_type_AndroidViewView.requestLayout();
  }
  
  private void a(AESlidingUpPanelLayout.PanelState paramPanelState)
  {
    if (this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState == paramPanelState) {
      return;
    }
    AESlidingUpPanelLayout.PanelState localPanelState = this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
    this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = paramPanelState;
    a(this, localPanelState, paramPanelState);
  }
  
  private static boolean a(View paramView)
  {
    paramView = paramView.getBackground();
    return (paramView != null) && (paramView.getOpacity() == -1);
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (paramView == null) {
      return false;
    }
    int[] arrayOfInt1 = new int[2];
    paramView.getLocationOnScreen(arrayOfInt1);
    int[] arrayOfInt2 = new int[2];
    getLocationOnScreen(arrayOfInt2);
    paramInt1 = arrayOfInt2[0] + paramInt1;
    paramInt2 = arrayOfInt2[1] + paramInt2;
    if ((paramInt1 >= arrayOfInt1[0]) && (paramInt1 < arrayOfInt1[0] + paramView.getWidth()) && (paramInt2 >= arrayOfInt1[1]) && (paramInt2 < arrayOfInt1[1] + paramView.getHeight())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  @SuppressLint({"NewApi"})
  private void d()
  {
    if (this.jdField_e_of_type_Int > 0)
    {
      int i = b();
      ViewCompat.setTranslationY(this.jdField_d_of_type_AndroidViewView, i);
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public AESlidingUpPanelLayout.PanelState a()
  {
    return this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
  }
  
  protected void a()
  {
    a(0.0F, 0);
  }
  
  void a(View paramView)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bpcc)localIterator.next()).a(paramView, this.jdField_a_of_type_Float);
    }
  }
  
  void a(View paramView, AESlidingUpPanelLayout.PanelState paramPanelState1, AESlidingUpPanelLayout.PanelState paramPanelState2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bpcc)localIterator.next()).a(paramView, paramPanelState1, paramPanelState2);
    }
    sendAccessibilityEvent(32);
  }
  
  public void a(bpcc parambpcc)
  {
    if (parambpcc != null) {
      this.jdField_a_of_type_JavaUtilList.add(parambpcc);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_e_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState != AESlidingUpPanelLayout.PanelState.HIDDEN);
  }
  
  boolean a(float paramFloat, int paramInt)
  {
    if ((!isEnabled()) || (this.jdField_c_of_type_AndroidViewView == null)) {}
    do
    {
      return false;
      paramInt = a(paramFloat);
    } while (!this.jdField_a_of_type_Bpcl.a(this.jdField_c_of_type_AndroidViewView, this.jdField_c_of_type_AndroidViewView.getLeft(), paramInt));
    c();
    ViewCompat.postInvalidateOnAnimation(this);
    return true;
  }
  
  public int b()
  {
    int j = (int)(this.jdField_e_of_type_Int * Math.max(this.jdField_a_of_type_Float, 0.0F));
    int i = j;
    if (this.jdField_a_of_type_Boolean) {
      i = -j;
    }
    return i;
  }
  
  public void b()
  {
    int i1 = 0;
    if (getChildCount() == 0) {
      return;
    }
    int i6 = getPaddingLeft();
    int i3 = getWidth();
    int i4 = getPaddingRight();
    int i5 = getPaddingTop();
    int n = getHeight();
    int i2 = getPaddingBottom();
    int m;
    int k;
    int j;
    int i;
    if ((this.jdField_c_of_type_AndroidViewView != null) && (a(this.jdField_c_of_type_AndroidViewView)))
    {
      m = this.jdField_c_of_type_AndroidViewView.getLeft();
      k = this.jdField_c_of_type_AndroidViewView.getRight();
      j = this.jdField_c_of_type_AndroidViewView.getTop();
      i = this.jdField_c_of_type_AndroidViewView.getBottom();
    }
    for (;;)
    {
      View localView = getChildAt(0);
      i6 = Math.max(i6, localView.getLeft());
      i5 = Math.max(i5, localView.getTop());
      i3 = Math.min(i3 - i4, localView.getRight());
      i2 = Math.min(n - i2, localView.getBottom());
      n = i1;
      if (i6 >= m)
      {
        n = i1;
        if (i5 >= j)
        {
          n = i1;
          if (i3 <= k)
          {
            n = i1;
            if (i2 <= i) {
              n = 4;
            }
          }
        }
      }
      localView.setVisibility(n);
      return;
      i = 0;
      j = 0;
      k = 0;
      m = 0;
    }
  }
  
  public void c()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i += 1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof AESlidingUpPanelLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if ((this.jdField_a_of_type_Bpcl != null) && (this.jdField_a_of_type_Bpcl.a(true)))
    {
      if (!isEnabled()) {
        this.jdField_a_of_type_Bpcl.b();
      }
    }
    else {
      return;
    }
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = -1;
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if ((!isEnabled()) || (!a()) || ((this.jdField_d_of_type_Boolean) && (i != 0)))
    {
      this.jdField_a_of_type_Bpcl.b();
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i == 0)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_c_of_type_Float = f1;
      this.jdField_d_of_type_Float = f2;
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (i == 2)
      {
        float f3 = this.jdField_c_of_type_Float;
        float f4 = f2 - this.jdField_d_of_type_Float;
        this.jdField_c_of_type_Float = f1;
        this.jdField_d_of_type_Float = f2;
        if (Math.abs(f1 - f3) > Math.abs(f4)) {
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        if (!a(this.jdField_b_of_type_AndroidViewView, (int)this.jdField_e_of_type_Float, (int)this.jdField_f_of_type_Float)) {
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        if (this.jdField_a_of_type_Boolean) {
          i = 1;
        }
        while (i * f4 > 0.0F) {
          if (this.jdField_a_of_type_Bpck.a(this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_Boolean) > 0)
          {
            this.jdField_f_of_type_Boolean = true;
            return super.dispatchTouchEvent(paramMotionEvent);
            i = -1;
          }
          else
          {
            if (this.jdField_f_of_type_Boolean)
            {
              MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
              localMotionEvent.setAction(3);
              super.dispatchTouchEvent(localMotionEvent);
              localMotionEvent.recycle();
              paramMotionEvent.setAction(0);
            }
            this.jdField_f_of_type_Boolean = false;
            return onTouchEvent(paramMotionEvent);
          }
        }
        i = j;
        if (this.jdField_a_of_type_Boolean) {
          i = 1;
        }
        if (i * f4 < 0.0F)
        {
          if (this.jdField_a_of_type_Float < 1.0F)
          {
            this.jdField_f_of_type_Boolean = false;
            return onTouchEvent(paramMotionEvent);
          }
          if ((!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Bpcl.a()))
          {
            this.jdField_a_of_type_Bpcl.a();
            paramMotionEvent.setAction(0);
          }
          this.jdField_f_of_type_Boolean = true;
          return super.dispatchTouchEvent(paramMotionEvent);
        }
      }
      else if ((i == 1) && (this.jdField_f_of_type_Boolean))
      {
        this.jdField_a_of_type_Bpcl.a(0);
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k;
    int j;
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_c_of_type_AndroidViewView != null))
    {
      k = this.jdField_c_of_type_AndroidViewView.getRight();
      if (!this.jdField_a_of_type_Boolean) {
        break label87;
      }
      j = this.jdField_c_of_type_AndroidViewView.getTop() - this.jdField_d_of_type_Int;
    }
    for (int i = this.jdField_c_of_type_AndroidViewView.getTop();; i = this.jdField_c_of_type_AndroidViewView.getBottom() + this.jdField_d_of_type_Int)
    {
      int m = this.jdField_c_of_type_AndroidViewView.getLeft();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(m, j, k, i);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
      label87:
      j = this.jdField_c_of_type_AndroidViewView.getBottom();
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i = paramCanvas.save();
    boolean bool2;
    if ((this.jdField_c_of_type_AndroidViewView != null) && (!this.jdField_c_of_type_AndroidViewView.equals(paramView)))
    {
      paramCanvas.getClipBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      if (!this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidGraphicsRect.bottom = Math.min(this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_c_of_type_AndroidViewView.getTop());
        }
      }
      else
      {
        if (this.jdField_c_of_type_Boolean) {
          paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRect);
        }
        bool2 = super.drawChild(paramCanvas, paramView, paramLong);
        bool1 = bool2;
        if (this.jdField_b_of_type_Int != 0)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Float > 0.0F)
          {
            int j = (int)(((this.jdField_b_of_type_Int & 0xFF000000) >>> 24) * this.jdField_a_of_type_Float);
            int k = this.jdField_b_of_type_Int;
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(j << 24 | k & 0xFFFFFF);
            paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = super.drawChild(paramCanvas, paramView, paramLong))
    {
      paramCanvas.restoreToCount(i);
      return bool1;
      this.jdField_a_of_type_AndroidGraphicsRect.top = Math.max(this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_c_of_type_AndroidViewView.getBottom());
      break;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new AESlidingUpPanelLayout.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new AESlidingUpPanelLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new AESlidingUpPanelLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new AESlidingUpPanelLayout.LayoutParams(paramLayoutParams);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_g_of_type_Boolean = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_g_of_type_Boolean = true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (this.jdField_f_of_type_Int != -1) {
      setDragView(findViewById(this.jdField_f_of_type_Int));
    }
    if (this.jdField_g_of_type_Int != -1) {
      setScrollableView(findViewById(this.jdField_g_of_type_Int));
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_f_of_type_Boolean) || (!a()))
    {
      this.jdField_a_of_type_Bpcl.b();
      return false;
    }
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = Math.abs(f1 - this.jdField_e_of_type_Float);
    float f4 = Math.abs(f2 - this.jdField_f_of_type_Float);
    int j = this.jdField_a_of_type_Bpcl.b();
    switch (i)
    {
    }
    do
    {
      do
      {
        do
        {
          return this.jdField_a_of_type_Bpcl.a(paramMotionEvent);
          this.jdField_d_of_type_Boolean = false;
          this.jdField_e_of_type_Float = f1;
          this.jdField_f_of_type_Float = f2;
        } while (a(this.jdField_a_of_type_AndroidViewView, (int)f1, (int)f2));
        this.jdField_a_of_type_Bpcl.a();
        this.jdField_d_of_type_Boolean = true;
        return false;
      } while ((f4 <= j) || (f3 <= f4));
      this.jdField_a_of_type_Bpcl.a();
      this.jdField_d_of_type_Boolean = true;
      return false;
      if (this.jdField_a_of_type_Bpcl.a())
      {
        this.jdField_a_of_type_Bpcl.a(paramMotionEvent);
        return true;
      }
    } while ((f4 > j) || (f3 > j) || (this.jdField_a_of_type_Float <= 0.0F) || (a(this.jdField_c_of_type_AndroidViewView, (int)this.jdField_e_of_type_Float, (int)this.jdField_f_of_type_Float)) || (this.jdField_a_of_type_AndroidViewView$OnClickListener == null));
    playSoundEffect(0);
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    paramInt4 = getPaddingTop();
    int j = getChildCount();
    if (this.jdField_g_of_type_Boolean) {}
    label71:
    View localView;
    switch (bpca.jdField_a_of_type_ArrayOfInt[this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState.ordinal()])
    {
    default: 
      this.jdField_a_of_type_Float = 0.0F;
      paramInt2 = 0;
      if (paramInt2 >= j) {
        break label320;
      }
      localView = getChildAt(paramInt2);
      if (localView != null) {
        break;
      }
    }
    AESlidingUpPanelLayout.LayoutParams localLayoutParams;
    do
    {
      paramInt2 += 1;
      break label71;
      this.jdField_a_of_type_Float = 1.0F;
      break;
      this.jdField_a_of_type_Float = this.jdField_b_of_type_Float;
      break;
      paramInt2 = a(0.0F);
      if (this.jdField_a_of_type_Boolean) {}
      for (paramInt1 = this.jdField_c_of_type_Int;; paramInt1 = -this.jdField_c_of_type_Int)
      {
        this.jdField_a_of_type_Float = a(paramInt1 + paramInt2);
        break;
      }
      ViewGroup.LayoutParams localLayoutParams1 = localView.getLayoutParams();
      localLayoutParams = null;
      if ((localLayoutParams1 instanceof AESlidingUpPanelLayout.LayoutParams)) {
        localLayoutParams = (AESlidingUpPanelLayout.LayoutParams)localLayoutParams1;
      }
    } while ((localLayoutParams == null) || ((localView.getVisibility() == 8) && ((paramInt2 == 0) || (this.jdField_g_of_type_Boolean))));
    int k = localView.getMeasuredHeight();
    if (localView.equals(this.jdField_c_of_type_AndroidViewView)) {}
    for (paramInt1 = a(this.jdField_a_of_type_Float);; paramInt1 = paramInt4)
    {
      paramInt3 = paramInt1;
      if (!this.jdField_a_of_type_Boolean)
      {
        paramInt3 = paramInt1;
        if (localView.equals(this.jdField_d_of_type_AndroidViewView))
        {
          paramInt3 = paramInt1;
          if (!this.jdField_b_of_type_Boolean) {
            paramInt3 = a(this.jdField_a_of_type_Float) + this.jdField_c_of_type_AndroidViewView.getMeasuredHeight();
          }
        }
      }
      paramInt1 = localLayoutParams.leftMargin + i;
      localView.layout(paramInt1, paramInt3, localView.getMeasuredWidth() + paramInt1, k + paramInt3);
      break;
      label320:
      if (this.jdField_g_of_type_Boolean) {
        b();
      }
      d();
      this.jdField_g_of_type_Boolean = false;
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt2);
    int n = View.MeasureSpec.getSize(paramInt2);
    if ((i != 1073741824) && (i != -2147483648)) {
      throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
    }
    if ((paramInt1 != 1073741824) && (paramInt1 != -2147483648)) {
      throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
    }
    int i1 = getChildCount();
    if (i1 != 2) {
      throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
    }
    this.jdField_d_of_type_AndroidViewView = getChildAt(0);
    this.jdField_c_of_type_AndroidViewView = getChildAt(1);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      setDragView(this.jdField_c_of_type_AndroidViewView);
    }
    if (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0) {
      this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = AESlidingUpPanelLayout.PanelState.HIDDEN;
    }
    i = n - getPaddingTop() - getPaddingBottom();
    int j = m - getPaddingLeft() - getPaddingRight();
    int k = 0;
    View localView;
    AESlidingUpPanelLayout.LayoutParams localLayoutParams;
    if (k < i1)
    {
      localView = getChildAt(k);
      if (localView == null) {}
      do
      {
        k += 1;
        break;
        localLayoutParams = (AESlidingUpPanelLayout.LayoutParams)localView.getLayoutParams();
      } while ((localLayoutParams == null) || ((localView.getVisibility() == 8) && (k == 0)));
      if (localView.equals(this.jdField_d_of_type_AndroidViewView)) {
        if ((this.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState == AESlidingUpPanelLayout.PanelState.HIDDEN)) {
          break label511;
        }
      }
    }
    label296:
    label432:
    label502:
    label511:
    for (paramInt1 = i - this.jdField_c_of_type_Int;; paramInt1 = i)
    {
      paramInt2 = localLayoutParams.leftMargin;
      int i2 = localLayoutParams.rightMargin;
      paramInt2 = j - (paramInt2 + i2);
      for (;;)
      {
        if (localLayoutParams.width == -2) {
          paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
        }
        for (;;)
        {
          if (localLayoutParams.height != -2) {
            break label432;
          }
          paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648);
          localView.measure(paramInt2, paramInt1);
          if (!localView.equals(this.jdField_c_of_type_AndroidViewView)) {
            break;
          }
          this.h = (this.jdField_c_of_type_AndroidViewView.getMeasuredHeight() - this.jdField_c_of_type_Int);
          break;
          if (!localView.equals(this.jdField_c_of_type_AndroidViewView)) {
            break label502;
          }
          paramInt1 = i - localLayoutParams.topMargin;
          paramInt2 = j;
          break label296;
          if (localLayoutParams.width == -1) {
            paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
          } else {
            paramInt2 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
          }
        }
        if ((localLayoutParams.jdField_a_of_type_Float > 0.0F) && (localLayoutParams.jdField_a_of_type_Float < 1.0F))
        {
          float f1 = paramInt1;
          paramInt1 = (int)(localLayoutParams.jdField_a_of_type_Float * f1);
        }
        for (;;)
        {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
          break;
          if (localLayoutParams.height != -1) {
            paramInt1 = localLayoutParams.height;
          }
        }
        setMeasuredDimension(m, n);
        return;
        paramInt2 = j;
        paramInt1 = i;
      }
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    Object localObject = paramParcelable;
    if ((paramParcelable instanceof Bundle))
    {
      localObject = (Bundle)paramParcelable;
      this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = ((AESlidingUpPanelLayout.PanelState)((Bundle)localObject).getSerializable("sliding_state"));
      if (this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState != null) {
        break label58;
      }
    }
    label58:
    for (paramParcelable = jdField_a_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;; paramParcelable = this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState)
    {
      this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = paramParcelable;
      localObject = ((Bundle)localObject).getParcelable("superState");
      super.onRestoreInstanceState((Parcelable)localObject);
      return;
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("superState", super.onSaveInstanceState());
    if (this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState != AESlidingUpPanelLayout.PanelState.DRAGGING) {}
    for (AESlidingUpPanelLayout.PanelState localPanelState = this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;; localPanelState = this.jdField_c_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState)
    {
      localBundle.putSerializable("sliding_state", localPanelState);
      return localBundle;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt2 != paramInt4) {
      this.jdField_g_of_type_Boolean = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if ((!isEnabled()) || (!a())) {
      bool = super.onTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool;
      try
      {
        this.jdField_a_of_type_Bpcl.a(paramMotionEvent);
        paramMotionEvent = this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
        AESlidingUpPanelLayout.PanelState localPanelState = AESlidingUpPanelLayout.PanelState.COLLAPSED;
        if (paramMotionEvent != localPanelState) {
          return true;
        }
      }
      catch (Exception paramMotionEvent) {}
    }
    return false;
  }
  
  public void setAnchorPoint(float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat <= 1.0F))
    {
      this.jdField_b_of_type_Float = paramFloat;
      this.jdField_g_of_type_Boolean = true;
      requestLayout();
    }
  }
  
  public void setDragView(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    setDragView(findViewById(paramInt));
  }
  
  public void setDragView(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setFocusable(false);
      this.jdField_a_of_type_AndroidViewView.setFocusableInTouchMode(false);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new bpbz(this));
    }
  }
  
  public void setFadeOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setGravity(int paramInt)
  {
    if ((paramInt != 48) && (paramInt != 80)) {
      throw new IllegalArgumentException("gravity must be set to either top or bottom");
    }
    if (paramInt == 80) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_g_of_type_Boolean) {
        requestLayout();
      }
      return;
    }
  }
  
  public void setPanelHeight(int paramInt)
  {
    if (a() == paramInt) {}
    do
    {
      return;
      this.jdField_c_of_type_Int = paramInt;
      if (!this.jdField_g_of_type_Boolean) {
        requestLayout();
      }
    } while (a() != AESlidingUpPanelLayout.PanelState.COLLAPSED);
    a();
    invalidate();
  }
  
  public void setPanelState(AESlidingUpPanelLayout.PanelState paramPanelState)
  {
    if (this.jdField_a_of_type_Bpcl.a() == 2)
    {
      Log.d("SlidingUpPanelLayout", "View is settling. Aborting animation.");
      this.jdField_a_of_type_Bpcl.b();
    }
    if ((paramPanelState == null) || (paramPanelState == AESlidingUpPanelLayout.PanelState.DRAGGING)) {
      throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
    }
    if ((!isEnabled()) || ((!this.jdField_g_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewView == null)) || (paramPanelState == this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState) || (this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState == AESlidingUpPanelLayout.PanelState.DRAGGING)) {
      return;
    }
    if (this.jdField_g_of_type_Boolean)
    {
      a(paramPanelState);
      return;
    }
    if (this.jdField_b_of_type_DovComQqImAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState == AESlidingUpPanelLayout.PanelState.HIDDEN)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      requestLayout();
    }
    switch (bpca.jdField_a_of_type_ArrayOfInt[paramPanelState.ordinal()])
    {
    default: 
      return;
    case 1: 
      a(1.0F, 0);
      return;
    case 2: 
      a(this.jdField_b_of_type_Float, 0);
      return;
    case 4: 
      a(0.0F, 0);
      return;
    }
    int j = a(0.0F);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_c_of_type_Int;; i = -this.jdField_c_of_type_Int)
    {
      a(a(i + j), 0);
      return;
    }
  }
  
  public void setScrollableView(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
  }
  
  public void setShadowHeight(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    if (!this.jdField_g_of_type_Boolean) {
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.interaction.AESlidingUpPanelLayout
 * JD-Core Version:    0.7.0.1
 */