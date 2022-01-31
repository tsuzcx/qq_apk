package com.tencent.mobileqq.businessCard.views;

import abot;
import abou;
import abov;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.tencent.mobileqq.businessCard.helpers.BusinessCardChildViewTransform;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class BusinessCardView
  extends FrameLayout
  implements abot, BusinessCardViewScroller.DeckViewScrollerCallbacks, ViewPool.ViewPoolConsumer
{
  public float a;
  public int a;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public BusinessCardView.Callback a;
  BusinessCardViewLayoutAlgorithm jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm;
  public BusinessCardViewScroller a;
  BusinessCardViewTouchHandler jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewTouchHandler;
  ViewPool jdField_a_of_type_ComTencentMobileqqBusinessCardViewsViewPool;
  public Runnable a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = true;
  public int b;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  boolean jdField_b_of_type_Boolean = true;
  boolean c = false;
  
  public BusinessCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BusinessCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BusinessCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new abou(this);
    this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131559194);
  }
  
  private boolean a(ArrayList paramArrayList1, ArrayList paramArrayList2, float paramFloat, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i = paramArrayList1.size();
    int j = paramArrayList2.size();
    if (i < j) {
      while (i < j)
      {
        paramArrayList1.add(new BusinessCardChildViewTransform());
        i += 1;
      }
    }
    if (i > j) {
      paramArrayList1.subList(0, j);
    }
    i = j - 1;
    BusinessCardChildViewTransform localBusinessCardChildViewTransform = null;
    int k = -1;
    j = -1;
    if (i >= 0)
    {
      localBusinessCardChildViewTransform = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.a(paramArrayList2.get(i), paramFloat, (BusinessCardChildViewTransform)paramArrayList1.get(i), localBusinessCardChildViewTransform);
      if (localBusinessCardChildViewTransform.jdField_a_of_type_Boolean)
      {
        if (j >= 0) {
          break label235;
        }
        j = i;
      }
    }
    label235:
    for (;;)
    {
      k = i;
      for (;;)
      {
        if (paramBoolean) {
          localBusinessCardChildViewTransform.jdField_b_of_type_Int = Math.min(localBusinessCardChildViewTransform.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_a_of_type_AndroidGraphicsRect.bottom);
        }
        i -= 1;
        break;
        if (k != -1)
        {
          while (i >= 0)
          {
            ((BusinessCardChildViewTransform)paramArrayList1.get(i)).a();
            i -= 1;
          }
          if (paramArrayOfInt != null)
          {
            paramArrayOfInt[0] = j;
            paramArrayOfInt[1] = k;
          }
          return (j != -1) && (k != -1);
        }
      }
    }
  }
  
  public float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a();
    int[] arrayOfInt = new int[2];
    ArrayList localArrayList2 = new ArrayList();
    boolean bool = a(localArrayList2, localArrayList1, paramFloat, arrayOfInt, false);
    int i = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_b_of_type_Int;
    if (!bool) {
      return 0.0F;
    }
    if (arrayOfInt[0] <= 2) {
      return 0.0F;
    }
    BusinessCardChildViewTransform localBusinessCardChildViewTransform = (BusinessCardChildViewTransform)localArrayList2.get(arrayOfInt[0]);
    if (paramInt == BusinessCardViewScroller.jdField_b_of_type_Int) {
      if ((localBusinessCardChildViewTransform.jdField_b_of_type_Int > i) && (arrayOfInt[0] != 0)) {
        paramInt = ((BusinessCardChildViewTransform)localArrayList2.get(arrayOfInt[0] - 1)).jdField_b_of_type_Int - i;
      }
    }
    while ((arrayOfInt[0] == localArrayList1.size() - 1) && (Math.abs(paramInt) > this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.d.height() / 2))
    {
      return 0.0F;
      paramInt = localBusinessCardChildViewTransform.jdField_b_of_type_Int - i;
      continue;
      if (paramInt == BusinessCardViewScroller.jdField_a_of_type_Int)
      {
        if ((!paramBoolean) && (localBusinessCardChildViewTransform.jdField_b_of_type_Int < i) && (arrayOfInt[0] != localArrayList1.size() - 1)) {
          paramInt = ((BusinessCardChildViewTransform)localArrayList2.get(arrayOfInt[0] + 1)).jdField_b_of_type_Int - i;
        } else {
          paramInt = localBusinessCardChildViewTransform.jdField_b_of_type_Int - i;
        }
      }
      else {
        return 0.0F;
      }
    }
    float f = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_a_of_type_AndroidGraphicsRect.bottom);
    paramFloat = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_a_of_type_AndroidGraphicsRect.bottom + paramInt);
    if (paramInt > 0)
    {
      f = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_a_of_type_AndroidGraphicsRect.bottom - paramInt);
      paramFloat = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_a_of_type_AndroidGraphicsRect.bottom);
    }
    for (;;)
    {
      return paramFloat - f;
    }
  }
  
  public int a()
  {
    if (super.getChildCount() == 0) {
      return -1;
    }
    BusinessCardChildView localBusinessCardChildView = (BusinessCardChildView)super.getChildAt(getChildCount() / 2);
    if (localBusinessCardChildView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a().indexOf(localBusinessCardChildView.a());
    }
    return -1;
  }
  
  public BusinessCardChildView a(Context paramContext)
  {
    return (BusinessCardChildView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970249, this, false);
  }
  
  public BusinessCardChildView a(Object paramObject)
  {
    int j = super.getChildCount();
    int i = 0;
    while (i < j)
    {
      BusinessCardChildView localBusinessCardChildView = (BusinessCardChildView)super.getChildAt(i);
      if (localBusinessCardChildView.a().equals(paramObject)) {
        return localBusinessCardChildView;
      }
      i += 1;
    }
    return null;
  }
  
  public BusinessCardViewLayoutAlgorithm a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
    }
  }
  
  @TargetApi(16)
  public void a(float paramFloat)
  {
    b();
    if (BusinessCardUtils.a(16)) {
      postInvalidateOnAnimation();
    }
  }
  
  public void a(int paramInt)
  {
    if (a() == paramInt) {}
    float f;
    do
    {
      do
      {
        return;
      } while ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a().size()));
      f = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a().get(paramInt));
      f = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(f - 0.5F);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(f);
    } while (!QLog.isColorLevel());
    QLog.d("BusinessCard", 2, "scrollToChild childIndex:" + paramInt + " newScroll:" + f);
  }
  
  public void a(int paramInt1, int paramInt2, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.a(paramInt1, paramInt2, paramRect, this.jdField_b_of_type_Int);
    a(paramBoolean3, paramBoolean1, paramBoolean2);
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == this.jdField_a_of_type_Int) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a();
      } while ((paramInt < 0) || (paramInt >= ((ArrayList)localObject1).size()));
      this.jdField_a_of_type_Int = paramInt;
      Object localObject2 = ((ArrayList)localObject1).get(paramInt);
      BusinessCardChildView localBusinessCardChildView = a(localObject2);
      localObject1 = null;
      if (localBusinessCardChildView != null) {
        localBusinessCardChildView.setFocusedTask(paramBoolean2);
      }
      while (paramBoolean1)
      {
        float f = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.a(localObject2);
        f = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(f - 0.5F);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(), f, (Runnable)localObject1, BusinessCardViewScroller.d);
        return;
        localObject1 = new abov(this, paramBoolean2);
      }
    } while (localObject1 == null);
    ((Runnable)localObject1).run();
  }
  
  public void a(BusinessCardChildView paramBusinessCardChildView)
  {
    paramBusinessCardChildView.a();
    paramBusinessCardChildView.c();
    detachViewFromParent(paramBusinessCardChildView);
    paramBusinessCardChildView.a();
  }
  
  public void a(BusinessCardChildView paramBusinessCardChildView, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a(paramObject);
  }
  
  public void a(BusinessCardChildView paramBusinessCardChildView, Object paramObject, boolean paramBoolean)
  {
    paramBusinessCardChildView.a(paramObject);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a(new WeakReference(paramBusinessCardChildView), paramObject);
    String str = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a(paramObject);
    int i;
    if (str != null)
    {
      paramBusinessCardChildView.a(str);
      int j = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a().indexOf(paramObject);
      if (j == -1) {
        break label166;
      }
      int k = super.getChildCount();
      i = 0;
      label76:
      if (i >= k) {
        break label166;
      }
      paramObject = ((BusinessCardChildView)super.getChildAt(i)).a();
      if (j >= this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a().indexOf(paramObject)) {
        break label139;
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        addView(paramBusinessCardChildView, i);
      }
      for (;;)
      {
        paramBusinessCardChildView.a(this);
        return;
        paramBusinessCardChildView.a(null);
        break;
        label139:
        i += 1;
        break label76;
        attachViewToParent(paramBusinessCardChildView, i, paramBusinessCardChildView.getLayoutParams());
        paramBusinessCardChildView.requestLayout();
      }
      label166:
      i = -1;
    }
  }
  
  public void a(BusinessCardChildView paramBusinessCardChildView, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a().indexOf(paramBusinessCardChildView.a());
    }
  }
  
  public void a(BusinessCardView.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback = paramCallback;
    super.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsViewPool = new ViewPool(getContext(), this);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm = new BusinessCardViewLayoutAlgorithm();
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller = new BusinessCardViewScroller(getContext(), this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm, this);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewTouchHandler = new BusinessCardViewTouchHandler(getContext(), this, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller);
  }
  
  public void a(boolean paramBoolean)
  {
    a(true, false, false);
    if (paramBoolean)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label66;
      }
      this.c = paramBoolean;
    }
    for (;;)
    {
      b();
      a(true);
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard", 2, "notifyDataSetChanged scrollToBottom=" + paramBoolean);
      }
      return;
      label66:
      a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a().size() - 1);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a().size();
    if (j == 0) {
      return;
    }
    if (paramBoolean1) {}
    for (int i = -1;; i = 1)
    {
      i += this.jdField_a_of_type_Int;
      if ((i < 0) || (i > j - 1)) {
        break;
      }
      a(Math.max(0, Math.min(j - 1, i)), true, paramBoolean2);
      return;
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a(), paramBoolean2, paramBoolean3);
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
    }
  }
  
  public boolean a()
  {
    int j;
    int k;
    int m;
    int i;
    if (this.jdField_a_of_type_Int < 0)
    {
      j = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_b_of_type_AndroidGraphicsRect.centerX();
      k = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_b_of_type_AndroidGraphicsRect.centerY();
      m = super.getChildCount();
      i = m - 1;
    }
    for (;;)
    {
      if (i >= 0)
      {
        ((BusinessCardChildView)super.getChildAt(i)).getHitRect(this.jdField_b_of_type_AndroidGraphicsRect);
        if (this.jdField_b_of_type_AndroidGraphicsRect.contains(j, k)) {
          this.jdField_a_of_type_Int = i;
        }
      }
      else
      {
        if ((this.jdField_a_of_type_Int < 0) && (m > 0)) {
          this.jdField_a_of_type_Int = (m - 1);
        }
        if (this.jdField_a_of_type_Int < 0) {
          break;
        }
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, View paramView)
  {
    if (paramView == null) {
      return false;
    }
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    return localRect.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  public boolean a(BusinessCardChildView paramBusinessCardChildView, Object paramObject)
  {
    return (paramBusinessCardChildView.a() != null) && (paramBusinessCardChildView.a().equals(paramObject));
  }
  
  boolean a(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean)
    {
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a();
      float f = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
      int[] arrayOfInt = new int[2];
      bool = a(this.jdField_a_of_type_JavaUtilArrayList, localArrayList, f, arrayOfInt, false);
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      int i = super.getChildCount() - 1;
      BusinessCardChildView localBusinessCardChildView;
      Object localObject;
      if (i >= 0)
      {
        localBusinessCardChildView = (BusinessCardChildView)super.getChildAt(i);
        localObject = localBusinessCardChildView.a();
        int j = localArrayList.indexOf(localObject);
        if ((arrayOfInt[1] <= j) && (j <= arrayOfInt[0])) {
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject, localBusinessCardChildView);
        }
        for (;;)
        {
          i -= 1;
          break;
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsViewPool.a(localBusinessCardChildView);
        }
      }
      i = arrayOfInt[1];
      if ((bool) && (i <= arrayOfInt[0]))
      {
        localObject = localArrayList.get(i);
        localBusinessCardChildView = (BusinessCardChildView)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        if (localBusinessCardChildView == null) {
          localBusinessCardChildView = (BusinessCardChildView)this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsViewPool.a(localObject, localObject);
        }
        for (;;)
        {
          localBusinessCardChildView.a((BusinessCardChildViewTransform)this.jdField_a_of_type_JavaUtilArrayList.get(i), 0);
          localBusinessCardChildView.bringToFront();
          i += 1;
          break;
          if (paramBoolean) {
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a(new WeakReference(localBusinessCardChildView), localArrayList.get(i));
          }
        }
      }
      this.jdField_a_of_type_Boolean = false;
      bool = true;
    }
    return bool;
  }
  
  void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      super.invalidate();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
  }
  
  public void computeScroll()
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.c();
    a(false);
    super.sendAccessibilityEvent(4096);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewTouchHandler.c(paramMotionEvent);
  }
  
  @TargetApi(15)
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    int i = super.getChildCount();
    if (i > 0)
    {
      BusinessCardChildView localBusinessCardChildView1 = (BusinessCardChildView)super.getChildAt(0);
      BusinessCardChildView localBusinessCardChildView2 = (BusinessCardChildView)super.getChildAt(i - 1);
      paramAccessibilityEvent.setFromIndex(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a().indexOf(localBusinessCardChildView1.a()));
      paramAccessibilityEvent.setToIndex(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a().indexOf(localBusinessCardChildView2.a()));
    }
    paramAccessibilityEvent.setItemCount(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a().size());
    paramAccessibilityEvent.setScrollY(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.jdField_a_of_type_AndroidWidgetOverScroller.getCurrY());
    paramAccessibilityEvent.setMaxScrollY(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_b_of_type_Float));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    try
    {
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewTouchHandler.a(paramMotionEvent);
      return bool2;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return bool1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = super.getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      BusinessCardChildView localBusinessCardChildView = (BusinessCardChildView)super.getChildAt(paramInt1);
      if (localBusinessCardChildView.getBackground() != null) {
        localBusinessCardChildView.getBackground().getPadding(this.jdField_b_of_type_AndroidGraphicsRect);
      }
      for (;;)
      {
        localBusinessCardChildView.layout(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.d.left - this.jdField_b_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.d.top - this.jdField_b_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.d.right + this.jdField_b_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.d.bottom + this.jdField_b_of_type_AndroidGraphicsRect.bottom);
        paramInt1 += 1;
        break;
        this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
      }
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    Object localObject = new Rect(0, 0, j, paramInt2);
    if (this.jdField_a_of_type_AndroidGraphicsRect.width() != j) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set((Rect)localObject);
      a(j, paramInt2, new Rect(this.jdField_a_of_type_AndroidGraphicsRect), false, false, bool);
      if (this.jdField_b_of_type_Boolean)
      {
        b();
        a(false);
        if (this.c)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a().size() - 1);
          this.c = false;
        }
      }
      int k = super.getChildCount();
      paramInt1 = i;
      if (paramInt1 < k)
      {
        localObject = (BusinessCardChildView)super.getChildAt(paramInt1);
        if (((BusinessCardChildView)localObject).getBackground() != null) {
          ((BusinessCardChildView)localObject).getBackground().getPadding(this.jdField_b_of_type_AndroidGraphicsRect);
        }
        for (;;)
        {
          ((BusinessCardChildView)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.d.width() + this.jdField_b_of_type_AndroidGraphicsRect.left + this.jdField_b_of_type_AndroidGraphicsRect.right, 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.d.height() + this.jdField_b_of_type_AndroidGraphicsRect.top + this.jdField_b_of_type_AndroidGraphicsRect.bottom, 1073741824));
          paramInt1 += 1;
          break;
          this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
        }
      }
      super.setMeasuredDimension(j, paramInt2);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewTouchHandler.b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.views.BusinessCardView
 * JD-Core Version:    0.7.0.1
 */