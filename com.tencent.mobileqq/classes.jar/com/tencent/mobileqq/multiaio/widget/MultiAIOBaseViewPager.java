package com.tencent.mobileqq.multiaio.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.multiaio.utils.VelocityUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MultiAIOBaseViewPager
  extends ViewGroup
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new MultiAIOBaseViewPager.2();
  private static final Comparator<MultiAIOBaseViewPager.ItemInfo> jdField_a_of_type_JavaUtilComparator;
  static final int[] jdField_a_of_type_ArrayOfInt = { 16842931 };
  private float jdField_a_of_type_Float = -3.402824E+038F;
  protected int a;
  private long jdField_a_of_type_Long;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Parcelable jdField_a_of_type_AndroidOsParcelable = null;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private EdgeEffect jdField_a_of_type_AndroidWidgetEdgeEffect;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  PagerAdapter jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
  private MultiAIOBaseViewPager.FlingListener jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$FlingListener;
  private final MultiAIOBaseViewPager.ItemInfo jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$ItemInfo = new MultiAIOBaseViewPager.ItemInfo();
  private MultiAIOBaseViewPager.OnPageChangeListener jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener;
  private MultiAIOBaseViewPager.PageTransformer jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$PageTransformer;
  private MultiAIOBaseViewPager.PagerObserver jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$PagerObserver;
  private final MultiAIOBaseViewPager.ViewPositionComparator jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$ViewPositionComparator = new MultiAIOBaseViewPager.MultiAIOViewPositionComparator(this);
  private ClassLoader jdField_a_of_type_JavaLangClassLoader = null;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new MultiAIOBaseViewPager.3(this);
  private final ArrayList<MultiAIOBaseViewPager.ItemInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<MultiAIOBaseViewPager.OnPageChangeListener> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = 3.4028235E+38F;
  int jdField_b_of_type_Int;
  private EdgeEffect jdField_b_of_type_AndroidWidgetEdgeEffect;
  private Scroller jdField_b_of_type_AndroidWidgetScroller;
  private MultiAIOBaseViewPager.OnPageChangeListener jdField_b_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener;
  private ArrayList<View> jdField_b_of_type_JavaUtilArrayList;
  private List<MultiAIOBaseViewPager.OnAdapterChangeListener> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  protected int c;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int l = 1;
  private int m;
  private int n;
  private int o;
  private int p = -1;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new MultiAIOBaseViewPager.1();
  }
  
  public MultiAIOBaseViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MultiAIOBaseViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private Rect a(Rect paramRect, View paramView)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    if (paramView == null)
    {
      localRect.set(0, 0, 0, 0);
      return localRect;
    }
    localRect.left = paramView.getLeft();
    localRect.right = paramView.getRight();
    localRect.top = paramView.getTop();
    localRect.bottom = paramView.getBottom();
    for (paramRect = paramView.getParent(); ((paramRect instanceof ViewGroup)) && (paramRect != this); paramRect = paramRect.getParent())
    {
      paramRect = (ViewGroup)paramRect;
      localRect.left += paramRect.getLeft();
      localRect.right += paramRect.getRight();
      localRect.top += paramRect.getTop();
      localRect.bottom += paramRect.getBottom();
    }
    return localRect;
  }
  
  private MultiAIOBaseViewPager.ItemInfo a()
  {
    int i1 = d();
    float f1;
    if (i1 > 0) {
      f1 = getScrollX() / i1;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (i1 > 0) {
      f2 = this.jdField_g_of_type_Int / i1;
    } else {
      f2 = 0.0F;
    }
    Object localObject = null;
    i1 = 0;
    int i2 = 1;
    int i3 = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      MultiAIOBaseViewPager.ItemInfo localItemInfo2 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      int i4 = i1;
      MultiAIOBaseViewPager.ItemInfo localItemInfo1 = localItemInfo2;
      if (i2 == 0)
      {
        int i5 = localItemInfo2.jdField_a_of_type_Int;
        i3 += 1;
        i4 = i1;
        localItemInfo1 = localItemInfo2;
        if (i5 != i3)
        {
          localItemInfo1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$ItemInfo;
          localItemInfo1.jdField_b_of_type_Float = (f3 + f4 + f2);
          localItemInfo1.jdField_a_of_type_Int = i3;
          localItemInfo1.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(localItemInfo1.jdField_a_of_type_Int);
          i4 = i1 - 1;
        }
      }
      f3 = localItemInfo1.jdField_b_of_type_Float;
      f4 = localItemInfo1.jdField_a_of_type_Float;
      if ((i2 == 0) && (f1 < f3)) {
        return localObject;
      }
      if (f1 >= f4 + f3 + f2)
      {
        if (i4 == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
          return localItemInfo1;
        }
        i3 = localItemInfo1.jdField_a_of_type_Int;
        f4 = localItemInfo1.jdField_a_of_type_Float;
        i1 = i4 + 1;
        i2 = 0;
        localObject = localItemInfo1;
      }
      else
      {
        return localItemInfo1;
      }
    }
    return localObject;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      if (!this.jdField_b_of_type_AndroidWidgetScroller.isFinished())
      {
        this.jdField_b_of_type_AndroidWidgetScroller.setFinalX(a() * d());
        return;
      }
      int i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i3 = getPaddingLeft();
      int i4 = getPaddingRight();
      scrollTo((int)(getScrollX() / (paramInt2 - i3 - i4 + paramInt4) * (paramInt1 - i1 - i2 + paramInt3)), getScrollY());
      return;
    }
    MultiAIOBaseViewPager.ItemInfo localItemInfo = a(this.jdField_b_of_type_Int);
    float f1;
    if (localItemInfo != null) {
      f1 = Math.min(localItemInfo.jdField_b_of_type_Float, this.jdField_b_of_type_Float);
    } else {
      f1 = 0.0F;
    }
    paramInt1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
    if (paramInt1 != getScrollX())
    {
      b(false);
      scrollTo(paramInt1, getScrollY());
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Object localObject = a(paramInt1);
    int i1;
    if (localObject != null) {
      i1 = (int)(d() * Math.max(this.jdField_a_of_type_Float, Math.min(((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_b_of_type_Float, this.jdField_b_of_type_Float)));
    } else {
      i1 = 0;
    }
    if (paramBoolean1)
    {
      a(i1, 0, paramInt2);
      if (paramBoolean2) {
        d(paramInt1);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("scrollToItem() called with: item = [");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("], smoothScroll = [");
        ((StringBuilder)localObject).append(paramBoolean1);
        ((StringBuilder)localObject).append("], velocity = [");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("], dispatchSelected = [");
        ((StringBuilder)localObject).append(paramBoolean2);
        ((StringBuilder)localObject).append("]");
        QLog.d("MultiAIOBaseViewPager", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      if (paramBoolean2) {
        d(paramInt1);
      }
      b(false);
      scrollTo(i1, 0);
      a(i1);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.p)
    {
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.jdField_c_of_type_Float = paramMotionEvent.getX(i1);
      this.p = paramMotionEvent.getPointerId(i1);
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  static void a(PagerAdapter paramPagerAdapter, DataSetObserver paramDataSetObserver)
  {
    try
    {
      Method localMethod = PagerAdapter.class.getDeclaredMethod("setViewPagerObserver", new Class[] { DataSetObserver.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramPagerAdapter, new Object[] { paramDataSetObserver });
      return;
    }
    catch (Exception paramPagerAdapter)
    {
      paramPagerAdapter.printStackTrace();
    }
  }
  
  private void a(MultiAIOBaseViewPager.ItemInfo paramItemInfo1, int paramInt, MultiAIOBaseViewPager.ItemInfo paramItemInfo2)
  {
    int i4 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount();
    int i1 = d();
    float f2;
    if (i1 > 0) {
      f2 = this.jdField_g_of_type_Int / i1;
    } else {
      f2 = 0.0F;
    }
    if (paramItemInfo2 != null)
    {
      i1 = paramItemInfo2.jdField_a_of_type_Int;
      if (i1 < paramItemInfo1.jdField_a_of_type_Int)
      {
        f1 = paramItemInfo2.jdField_b_of_type_Float + paramItemInfo2.jdField_a_of_type_Float + f2;
        i1 += 1;
        i2 = 0;
        while ((i1 <= paramItemInfo1.jdField_a_of_type_Int) && (i2 < this.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          for (paramItemInfo2 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);; paramItemInfo2 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2))
          {
            i3 = i1;
            f3 = f1;
            if (i1 <= paramItemInfo2.jdField_a_of_type_Int) {
              break;
            }
            i3 = i1;
            f3 = f1;
            if (i2 >= this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
              break;
            }
            i2 += 1;
          }
          while (i3 < paramItemInfo2.jdField_a_of_type_Int)
          {
            f3 += this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(i3) + f2;
            i3 += 1;
          }
          paramItemInfo2.jdField_b_of_type_Float = f3;
          f1 = f3 + (paramItemInfo2.jdField_a_of_type_Float + f2);
          i1 = i3 + 1;
        }
      }
      if (i1 > paramItemInfo1.jdField_a_of_type_Int)
      {
        i2 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        f1 = paramItemInfo2.jdField_b_of_type_Float;
        i1 -= 1;
        while ((i1 >= paramItemInfo1.jdField_a_of_type_Int) && (i2 >= 0))
        {
          for (paramItemInfo2 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);; paramItemInfo2 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2))
          {
            i3 = i1;
            f3 = f1;
            if (i1 >= paramItemInfo2.jdField_a_of_type_Int) {
              break;
            }
            i3 = i1;
            f3 = f1;
            if (i2 <= 0) {
              break;
            }
            i2 -= 1;
          }
          while (i3 > paramItemInfo2.jdField_a_of_type_Int)
          {
            f3 -= this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(i3) + f2;
            i3 -= 1;
          }
          f1 = f3 - (paramItemInfo2.jdField_a_of_type_Float + f2);
          paramItemInfo2.jdField_b_of_type_Float = f1;
          i1 = i3 - 1;
        }
      }
    }
    int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f3 = paramItemInfo1.jdField_b_of_type_Float;
    i1 = paramItemInfo1.jdField_a_of_type_Int - 1;
    if (paramItemInfo1.jdField_a_of_type_Int == 0) {
      f1 = paramItemInfo1.jdField_b_of_type_Float;
    } else {
      f1 = -3.402824E+038F;
    }
    this.jdField_a_of_type_Float = f1;
    int i2 = paramItemInfo1.jdField_a_of_type_Int;
    i4 -= 1;
    if (i2 == i4) {
      f1 = paramItemInfo1.jdField_b_of_type_Float + paramItemInfo1.jdField_a_of_type_Float - 1.0F;
    } else {
      f1 = 3.4028235E+38F;
    }
    this.jdField_b_of_type_Float = f1;
    i2 = paramInt - 1;
    float f1 = f3;
    while (i2 >= 0)
    {
      paramItemInfo2 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
      while (i1 > paramItemInfo2.jdField_a_of_type_Int)
      {
        f1 -= this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(i1) + f2;
        i1 -= 1;
      }
      f1 -= paramItemInfo2.jdField_a_of_type_Float + f2;
      paramItemInfo2.jdField_b_of_type_Float = f1;
      if (paramItemInfo2.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Float = f1;
      }
      i2 -= 1;
      i1 -= 1;
    }
    f1 = paramItemInfo1.jdField_b_of_type_Float + paramItemInfo1.jdField_a_of_type_Float + f2;
    i2 = paramItemInfo1.jdField_a_of_type_Int + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      paramItemInfo1 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      while (paramInt < paramItemInfo1.jdField_a_of_type_Int)
      {
        f1 += this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(paramInt) + f2;
        paramInt += 1;
      }
      if (paramItemInfo1.jdField_a_of_type_Int == i4) {
        this.jdField_b_of_type_Float = (paramItemInfo1.jdField_a_of_type_Float + f1 - 1.0F);
      }
      paramItemInfo1.jdField_b_of_type_Float = f1;
      f1 += paramItemInfo1.jdField_a_of_type_Float + f2;
      i1 += 1;
      paramInt += 1;
    }
    this.jdField_j_of_type_Boolean = false;
  }
  
  private boolean a(float paramFloat)
  {
    float f1 = this.jdField_c_of_type_Float;
    this.jdField_c_of_type_Float = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    float f3 = d();
    paramFloat = this.jdField_a_of_type_Float * f3;
    f1 = this.jdField_b_of_type_Float * f3;
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    localObject1 = (MultiAIOBaseViewPager.ItemInfo)((ArrayList)localObject1).get(0);
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    localObject2 = (MultiAIOBaseViewPager.ItemInfo)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
    if (((MultiAIOBaseViewPager.ItemInfo)localObject1).jdField_a_of_type_Int != 0)
    {
      paramFloat = ((MultiAIOBaseViewPager.ItemInfo)localObject1).jdField_b_of_type_Float * f3;
      i1 = 0;
    }
    else
    {
      i1 = 1;
    }
    int i2;
    if (((MultiAIOBaseViewPager.ItemInfo)localObject2).jdField_a_of_type_Int != this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount() - 1)
    {
      f1 = ((MultiAIOBaseViewPager.ItemInfo)localObject2).jdField_b_of_type_Float * f3;
      i2 = 0;
    }
    else
    {
      i2 = 1;
    }
    if (f2 < paramFloat)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_AndroidWidgetEdgeEffect.onPull(Math.abs(paramFloat - f2) / f3);
        bool1 = true;
      }
    }
    else
    {
      bool1 = bool3;
      paramFloat = f2;
      if (f2 > f1)
      {
        bool1 = bool2;
        if (i2 != 0)
        {
          this.jdField_b_of_type_AndroidWidgetEdgeEffect.onPull(Math.abs(f2 - f1) / f3);
          bool1 = true;
        }
        paramFloat = f1;
      }
    }
    f1 = this.jdField_c_of_type_Float;
    int i1 = (int)paramFloat;
    this.jdField_c_of_type_Float = (f1 + (paramFloat - i1));
    scrollTo(i1, getScrollY());
    a(i1);
    return bool1;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.n) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.n) && (paramFloat2 < 0.0F));
  }
  
  private static boolean a(View paramView)
  {
    return paramView.getClass().getAnnotation(MultiAIOBaseViewPager.DecorView.class) != null;
  }
  
  private void b(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      int i1 = 0;
      int i2 = ((List)localObject).size();
      while (i1 < i2)
      {
        localObject = (MultiAIOBaseViewPager.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localObject != null) {
          ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
        }
        i1 += 1;
      }
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.w == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      a(false);
      if ((this.jdField_b_of_type_AndroidWidgetScroller.isFinished() ^ true))
      {
        this.jdField_b_of_type_AndroidWidgetScroller.abortAnimation();
        i2 = getScrollX();
        i3 = getScrollY();
        int i4 = this.jdField_b_of_type_AndroidWidgetScroller.getCurrX();
        int i5 = this.jdField_b_of_type_AndroidWidgetScroller.getCurrY();
        if ((i2 != i4) || (i3 != i5))
        {
          scrollTo(i4, i5);
          if (i4 != i2) {
            a(i4);
          }
        }
      }
    }
    this.jdField_e_of_type_Boolean = false;
    int i3 = 0;
    int i2 = i1;
    int i1 = i3;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      MultiAIOBaseViewPager.ItemInfo localItemInfo = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (localItemInfo.jdField_a_of_type_Boolean)
      {
        localItemInfo.jdField_a_of_type_Boolean = false;
        i2 = 1;
      }
      i1 += 1;
    }
    if (i2 != 0)
    {
      if (paramBoolean)
      {
        ViewCompat.postOnAnimation(this, this.jdField_a_of_type_JavaLangRunnable);
        return;
      }
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i3 = getChildCount();
    int i1 = 0;
    while (i1 < i3)
    {
      int i2;
      if (paramBoolean) {
        i2 = this.u;
      } else {
        i2 = 0;
      }
      getChildAt(i1).setLayerType(i2, null);
      i1 += 1;
    }
  }
  
  private int d()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt);
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      int i1 = 0;
      int i2 = ((List)localObject).size();
      while (i1 < i2)
      {
        localObject = (MultiAIOBaseViewPager.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localObject != null) {
          ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt);
        }
        i1 += 1;
      }
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).a(paramInt);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void e(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).b(paramInt);
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      int i1 = 0;
      int i2 = ((List)localObject).size();
      while (i1 < i2)
      {
        localObject = (MultiAIOBaseViewPager.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localObject != null) {
          ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).b(paramInt);
        }
        i1 += 1;
      }
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((MultiAIOBaseViewPager.OnPageChangeListener)localObject).b(paramInt);
    }
  }
  
  private void g()
  {
    int i2;
    for (int i1 = 0; i1 < getChildCount(); i1 = i2 + 1)
    {
      i2 = i1;
      if (!((MultiAIOBaseViewPager.LayoutParams)getChildAt(i1).getLayoutParams()).jdField_a_of_type_Boolean)
      {
        removeViewAt(i1);
        i2 = i1 - 1;
      }
    }
  }
  
  private boolean g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "resetTouch() called");
    }
    this.p = -1;
    h();
    this.jdField_a_of_type_AndroidWidgetEdgeEffect.onRelease();
    this.jdField_b_of_type_AndroidWidgetEdgeEffect.onRelease();
    return (this.jdField_a_of_type_AndroidWidgetEdgeEffect.isFinished()) || (this.jdField_b_of_type_AndroidWidgetEdgeEffect.isFinished());
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "endDrag() called");
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  float a(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.r) && (Math.abs(paramInt2) > this.q))
    {
      if (paramInt2 <= 0) {
        paramInt1 += 1;
      }
    }
    else
    {
      float f1;
      if (paramInt1 >= this.jdField_b_of_type_Int) {
        f1 = 0.4F;
      } else {
        f1 = 0.6F;
      }
      paramInt1 += (int)(paramFloat + f1);
    }
    paramInt2 = paramInt1;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      MultiAIOBaseViewPager.ItemInfo localItemInfo = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
      localObject = (MultiAIOBaseViewPager.ItemInfo)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      paramInt2 = Math.max(localItemInfo.jdField_a_of_type_Int, Math.min(paramInt1, ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Int));
    }
    return paramInt2;
  }
  
  public PagerAdapter a()
  {
    return this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
  }
  
  MultiAIOBaseViewPager.ItemInfo a(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      MultiAIOBaseViewPager.ItemInfo localItemInfo = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (localItemInfo.jdField_a_of_type_Int == paramInt) {
        return localItemInfo;
      }
      i1 += 1;
    }
    return null;
  }
  
  MultiAIOBaseViewPager.ItemInfo a(int paramInt1, int paramInt2)
  {
    MultiAIOBaseViewPager.ItemInfo localItemInfo = new MultiAIOBaseViewPager.ItemInfo();
    localItemInfo.jdField_a_of_type_Int = paramInt1;
    localItemInfo.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.instantiateItem(this, paramInt1);
    localItemInfo.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(paramInt1);
    if ((paramInt2 >= 0) && (paramInt2 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt2, localItemInfo);
      return localItemInfo;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(localItemInfo);
    return localItemInfo;
  }
  
  MultiAIOBaseViewPager.ItemInfo a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      MultiAIOBaseViewPager.ItemInfo localItemInfo = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.isViewFromObject(paramView, localItemInfo.jdField_a_of_type_JavaLangObject)) {
        return localItemInfo;
      }
      i1 += 1;
    }
    return null;
  }
  
  void a()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.jdField_b_of_type_AndroidWidgetScroller = new Scroller(localContext, jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f1 = localContext.getResources().getDisplayMetrics().density;
    this.o = localViewConfiguration.getScaledPagingTouchSlop();
    this.q = ((int)(400.0F * f1));
    this.jdField_c_of_type_Int = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.jdField_a_of_type_Int = VelocityUtil.a(getContext(), this.jdField_c_of_type_Int);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetEdgeEffect = new EdgeEffect(localContext);
    this.jdField_b_of_type_AndroidWidgetEdgeEffect = new EdgeEffect(localContext);
    this.r = ((int)(25.0F * f1));
    this.s = ((int)(2.0F * f1));
    this.m = ((int)(f1 * 16.0F));
    ViewCompat.setAccessibilityDelegate(this, new MultiAIOBaseViewPager.MyAccessibilityDelegate(this));
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    ViewCompat.setOnApplyWindowInsetsListener(this, new MultiAIOBaseViewPager.4(this));
  }
  
  public void a(float paramFloat)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fakeDragBy() called with: xOffset = [");
      ((StringBuilder)localObject1).append(paramFloat);
      ((StringBuilder)localObject1).append("]");
      QLog.d("MultiAIOBaseViewPager", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_h_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter == null) {
        return;
      }
      this.jdField_c_of_type_Float += paramFloat;
      float f2 = getScrollX() - paramFloat;
      float f3 = d();
      paramFloat = this.jdField_a_of_type_Float * f3;
      float f1 = this.jdField_b_of_type_Float * f3;
      localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
      localObject2 = (MultiAIOBaseViewPager.ItemInfo)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
      if (((MultiAIOBaseViewPager.ItemInfo)localObject1).jdField_a_of_type_Int != 0) {
        paramFloat = ((MultiAIOBaseViewPager.ItemInfo)localObject1).jdField_b_of_type_Float * f3;
      }
      if (((MultiAIOBaseViewPager.ItemInfo)localObject2).jdField_a_of_type_Int != this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount() - 1) {
        f1 = ((MultiAIOBaseViewPager.ItemInfo)localObject2).jdField_b_of_type_Float * f3;
      }
      if (f2 >= paramFloat)
      {
        paramFloat = f2;
        if (f2 > f1) {
          paramFloat = f1;
        }
      }
      f1 = this.jdField_c_of_type_Float;
      int i1 = (int)paramFloat;
      this.jdField_c_of_type_Float = (f1 + (paramFloat - i1));
      scrollTo(i1, getScrollY());
      a(i1);
      long l1 = SystemClock.uptimeMillis();
      localObject1 = MotionEvent.obtain(this.jdField_a_of_type_Long, l1, 2, this.jdField_c_of_type_Float, 0.0F, 0);
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement((MotionEvent)localObject1);
      ((MotionEvent)localObject1).recycle();
      return;
    }
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  void a(int paramInt)
  {
    if (this.w == paramInt) {
      return;
    }
    this.w = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$PageTransformer != null)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      c(bool);
    }
    e(paramInt);
  }
  
  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1 = this.t;
    int i6 = 0;
    View localView;
    if (i1 > 0)
    {
      int i7 = getScrollX();
      i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i8 = getWidth();
      int i9 = getChildCount();
      int i4 = 0;
      while (i4 < i9)
      {
        localView = getChildAt(i4);
        MultiAIOBaseViewPager.LayoutParams localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.jdField_a_of_type_Boolean)
        {
          int i3 = localLayoutParams.jdField_a_of_type_Int & 0x7;
          if (i3 != 1)
          {
            int i5;
            if (i3 != 3)
            {
              if (i3 != 5)
              {
                i5 = i1;
                i3 = i1;
                i1 = i5;
              }
              else
              {
                i3 = i8 - i2 - localView.getMeasuredWidth();
                i2 += localView.getMeasuredWidth();
              }
            }
            else
            {
              i5 = localView.getWidth() + i1;
              i3 = i1;
              i1 = i5;
            }
          }
          else
          {
            i3 = Math.max((i8 - localView.getMeasuredWidth()) / 2, i1);
          }
          i3 = i3 + i7 - localView.getLeft();
          if (i3 != 0) {
            localView.offsetLeftAndRight(i3);
          }
        }
        i4 += 1;
      }
    }
    b(paramInt1, paramFloat, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$PageTransformer != null)
    {
      paramInt2 = getScrollX();
      i1 = getChildCount();
      paramInt1 = i6;
      while (paramInt1 < i1)
      {
        localView = getChildAt(paramInt1);
        if (!((MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams()).jdField_a_of_type_Boolean)
        {
          paramFloat = (localView.getLeft() - paramInt2) / d();
          this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$PageTransformer.a(localView, paramFloat);
        }
        paramInt1 += 1;
      }
    }
    this.jdField_k_of_type_Boolean = true;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      a(false);
      return;
    }
    Scroller localScroller = this.jdField_b_of_type_AndroidWidgetScroller;
    int i1;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      if (this.jdField_b_of_type_Boolean) {
        i1 = this.jdField_b_of_type_AndroidWidgetScroller.getCurrX();
      } else {
        i1 = this.jdField_b_of_type_AndroidWidgetScroller.getStartX();
      }
      this.jdField_b_of_type_AndroidWidgetScroller.abortAnimation();
      a(false);
    }
    else
    {
      i1 = getScrollX();
    }
    int i2 = getScrollY();
    int i3 = paramInt1 - i1;
    paramInt2 -= i2;
    if ((i3 == 0) && (paramInt2 == 0))
    {
      b(false);
      c();
      a(0);
      return;
    }
    a(true);
    a(2);
    paramInt1 = d();
    int i4 = paramInt1 / 2;
    float f2 = Math.abs(i3);
    float f1 = paramInt1;
    float f3 = Math.min(1.0F, f2 * 1.0F / f1);
    f2 = i4;
    f3 = a(f3);
    paramInt1 = Math.abs(paramInt3);
    if (paramInt1 > 0)
    {
      paramInt1 = Math.round(Math.abs((f2 + f3 * f2) / paramInt1) * 1000.0F) * 4;
    }
    else
    {
      f2 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(this.jdField_b_of_type_Int);
      paramInt1 = (int)((Math.abs(i3) / (f1 * f2 + this.jdField_g_of_type_Int) + 1.0F) * 100.0F);
    }
    paramInt1 = Math.min(paramInt1, 600);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetScroller.startScroll(i1, i2, i3, paramInt2, paramInt1);
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    PagerAdapter localPagerAdapter = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 0))
    {
      if ((!paramBoolean2) && (this.jdField_d_of_type_Int == paramInt1) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0))
      {
        a(false);
        return;
      }
      paramBoolean2 = true;
      int i1;
      if (paramInt1 < 0)
      {
        i1 = 0;
      }
      else
      {
        i1 = paramInt1;
        if (paramInt1 >= this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount()) {
          i1 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount() - 1;
        }
      }
      paramInt1 = this.l;
      int i2 = this.jdField_b_of_type_Int;
      if ((i1 > i2 + paramInt1) || (i1 < i2 - paramInt1))
      {
        paramInt1 = 0;
        while (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          ((MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Boolean = true;
          paramInt1 += 1;
        }
      }
      if (this.jdField_d_of_type_Int == i1) {
        paramBoolean2 = false;
      }
      if (this.jdField_i_of_type_Boolean)
      {
        this.jdField_b_of_type_Int = i1;
        this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
        if (paramBoolean2) {
          d(i1);
        }
        requestLayout();
        return;
      }
      b(i1);
      this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
      a(i1, paramBoolean1, paramInt2, paramBoolean2);
      return;
    }
    a(false);
  }
  
  public void a(MultiAIOBaseViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramOnPageChangeListener);
  }
  
  void a(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean) {
      this.jdField_d_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "beginFakeDrag() called");
    }
    if (this.jdField_f_of_type_Boolean) {
      return false;
    }
    this.jdField_h_of_type_Boolean = true;
    a(1);
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_e_of_type_Float = 0.0F;
    Object localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localObject == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    } else {
      ((VelocityTracker)localObject).clear();
    }
    long l1 = SystemClock.uptimeMillis();
    localObject = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement((MotionEvent)localObject);
    ((MotionEvent)localObject).recycle();
    this.jdField_a_of_type_Long = l1;
    return true;
  }
  
  boolean a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pageScrolled() called with: xpos = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.d("MultiAIOBaseViewPager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (this.jdField_i_of_type_Boolean) {
        return false;
      }
      this.jdField_k_of_type_Boolean = false;
      a(0, 0.0F, 0);
      if (this.jdField_k_of_type_Boolean) {
        return false;
      }
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    int i2 = d();
    int i3 = this.jdField_g_of_type_Int;
    float f2 = i3;
    float f1 = i2;
    f2 /= f1;
    int i1 = ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Int;
    f1 = (paramInt / f1 - ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_b_of_type_Float) / (((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Float + f2);
    paramInt = (int)((i2 + i3) * f1);
    this.jdField_k_of_type_Boolean = false;
    a(i1, f1, paramInt);
    if (this.jdField_k_of_type_Boolean) {
      return true;
    }
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
    {
      int i1 = paramKeyEvent.getKeyCode();
      if (i1 != 21)
      {
        if (i1 != 22)
        {
          if (i1 == 61)
          {
            if (paramKeyEvent.hasNoModifiers()) {
              return b(2);
            }
            if (paramKeyEvent.hasModifiers(1)) {
              return b(1);
            }
          }
        }
        else
        {
          if (paramKeyEvent.hasModifiers(2)) {
            return d();
          }
          return b(66);
        }
      }
      else
      {
        if (paramKeyEvent.hasModifiers(2)) {
          return c();
        }
        return b(17);
      }
    }
    return false;
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      int i1 = localViewGroup.getChildCount() - 1;
      while (i1 >= 0)
      {
        View localView = localViewGroup.getChildAt(i1);
        int i4 = paramInt2 + i2;
        if ((i4 >= localView.getLeft()) && (i4 < localView.getRight()))
        {
          int i5 = paramInt3 + i3;
          if ((i5 >= localView.getTop()) && (i5 < localView.getBottom()) && (a(localView, true, paramInt1, i4 - localView.getLeft(), i5 - localView.getTop()))) {
            return true;
          }
        }
        i1 -= 1;
      }
    }
    return (paramBoolean) && (paramView.canScrollHorizontally(-paramInt1));
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i2 = paramArrayList.size();
    int i3 = getDescendantFocusability();
    if (i3 != 393216)
    {
      int i1 = 0;
      while (i1 < getChildCount())
      {
        View localView = getChildAt(i1);
        if (localView.getVisibility() == 0)
        {
          MultiAIOBaseViewPager.ItemInfo localItemInfo = a(localView);
          if ((localItemInfo != null) && (localItemInfo.jdField_a_of_type_Int == this.jdField_b_of_type_Int)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i1 += 1;
      }
    }
    if ((i3 != 262144) || (i2 == paramArrayList.size()))
    {
      if (!isFocusable()) {
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
        return;
      }
      paramArrayList.add(this);
    }
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        MultiAIOBaseViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.jdField_a_of_type_Int == this.jdField_b_of_type_Int)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams)) {
      localLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localLayoutParams;
    paramLayoutParams.jdField_a_of_type_Boolean |= a(paramView);
    if (this.jdField_c_of_type_Boolean)
    {
      if (!paramLayoutParams.jdField_a_of_type_Boolean)
      {
        paramLayoutParams.jdField_b_of_type_Boolean = true;
        addViewInLayout(paramView, paramInt, localLayoutParams);
        return;
      }
      throw new IllegalStateException("Cannot add pager decor view during layout");
    }
    super.addView(paramView, paramInt, localLayoutParams);
  }
  
  public int b()
  {
    return this.jdField_g_of_type_Int;
  }
  
  MultiAIOBaseViewPager.ItemInfo b(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break label34;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        break;
      }
      paramView = (View)localViewParent;
    }
    return null;
    label34:
    return a(paramView);
  }
  
  void b()
  {
    int i9 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount();
    this.jdField_e_of_type_Int = i9;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() < this.l * 2 + 1) && (this.jdField_a_of_type_JavaUtilArrayList.size() < i9)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = this.jdField_b_of_type_Int;
    int i6 = i1;
    int i1 = i2;
    int i3 = 0;
    i2 = 0;
    Object localObject;
    while (i3 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i3);
      int i8 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getItemPosition(((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_JavaLangObject);
      int i4;
      int i5;
      int i7;
      if (i8 == -1)
      {
        i4 = i3;
        i5 = i2;
        i7 = i1;
      }
      else
      {
        if (i8 == -2)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(i3);
          i5 = i3 - 1;
          i4 = i2;
          if (i2 == 0)
          {
            this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.startUpdate(this);
            i4 = 1;
          }
          this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.destroyItem(this, ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Int, ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_JavaLangObject);
          i3 = i5;
          i2 = i4;
          if (this.jdField_b_of_type_Int == ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Int)
          {
            i1 = Math.max(0, Math.min(this.jdField_b_of_type_Int, i9 - 1));
            i2 = i4;
            i3 = i5;
          }
        }
        for (;;)
        {
          i6 = 1;
          i4 = i3;
          i5 = i2;
          i7 = i1;
          break;
          i4 = i3;
          i5 = i2;
          i7 = i1;
          if (((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Int == i8) {
            break;
          }
          if (((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Int == this.jdField_b_of_type_Int) {
            i1 = i8;
          }
          ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Int = i8;
        }
      }
      i3 = i4 + 1;
      i2 = i5;
      i1 = i7;
    }
    if (i2 != 0) {
      this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.finishUpdate(this);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, jdField_a_of_type_JavaUtilComparator);
    if (i6 != 0)
    {
      i3 = getChildCount();
      i2 = 0;
      while (i2 < i3)
      {
        localObject = (MultiAIOBaseViewPager.LayoutParams)getChildAt(i2).getLayoutParams();
        if (!((MultiAIOBaseViewPager.LayoutParams)localObject).jdField_a_of_type_Boolean) {
          ((MultiAIOBaseViewPager.LayoutParams)localObject).jdField_a_of_type_Float = 0.0F;
        }
        i2 += 1;
      }
      a(i1, false, true);
      requestLayout();
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("populate() called with: newCurrentItem = [");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("]");
      QLog.d("MultiAIOBaseViewPager", 2, ((StringBuilder)localObject1).toString());
    }
    int i1 = this.jdField_b_of_type_Int;
    if (i1 != paramInt)
    {
      localObject2 = a(i1);
      this.jdField_b_of_type_Int = paramInt;
    }
    else
    {
      localObject2 = null;
    }
    if (this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter == null)
    {
      d();
      return;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      d();
      return;
    }
    if (getWindowToken() == null) {
      return;
    }
    this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.startUpdate(this);
    paramInt = this.l;
    int i7 = Math.max(0, this.jdField_b_of_type_Int - paramInt);
    int i5 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount();
    int i6 = Math.min(i5 - 1, this.jdField_b_of_type_Int + paramInt);
    if (i5 == this.jdField_e_of_type_Int)
    {
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (((MultiAIOBaseViewPager.ItemInfo)localObject1).jdField_a_of_type_Int >= this.jdField_b_of_type_Int)
        {
          if (((MultiAIOBaseViewPager.ItemInfo)localObject1).jdField_a_of_type_Int != this.jdField_b_of_type_Int) {
            break;
          }
          break label236;
        }
        paramInt += 1;
      }
      localObject1 = null;
      label236:
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (i5 > 0) {
          localObject3 = a(this.jdField_b_of_type_Int, paramInt);
        }
      }
      if (localObject3 != null)
      {
        i1 = paramInt - 1;
        if (i1 >= 0) {
          localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        } else {
          localObject1 = null;
        }
        int i8 = d();
        float f3;
        float f1;
        if (i8 <= 0)
        {
          f3 = 0.0F;
        }
        else
        {
          f1 = ((MultiAIOBaseViewPager.ItemInfo)localObject3).jdField_a_of_type_Float;
          f3 = getPaddingLeft() / i8 + (2.0F - f1);
        }
        int i4 = this.jdField_b_of_type_Int - 1;
        float f2 = 0.0F;
        int i3;
        Object localObject4;
        while (i4 >= 0)
        {
          if ((f2 >= f3) && (i4 < i7))
          {
            if (localObject1 == null) {
              break;
            }
            f1 = f2;
            i3 = paramInt;
            localObject4 = localObject1;
            i2 = i1;
            if (i4 != ((MultiAIOBaseViewPager.ItemInfo)localObject1).jdField_a_of_type_Int) {
              break label623;
            }
            f1 = f2;
            i3 = paramInt;
            localObject4 = localObject1;
            i2 = i1;
            if (((MultiAIOBaseViewPager.ItemInfo)localObject1).jdField_a_of_type_Boolean) {
              break label623;
            }
            this.jdField_a_of_type_JavaUtilArrayList.remove(i1);
            this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.destroyItem(this, i4, ((MultiAIOBaseViewPager.ItemInfo)localObject1).jdField_a_of_type_JavaLangObject);
            i1 -= 1;
            paramInt -= 1;
            f1 = f2;
            i2 = paramInt;
            i3 = i1;
            if (i1 >= 0)
            {
              localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
              f1 = f2;
              break label612;
            }
          }
          else if ((localObject1 != null) && (i4 == ((MultiAIOBaseViewPager.ItemInfo)localObject1).jdField_a_of_type_Int))
          {
            f2 += ((MultiAIOBaseViewPager.ItemInfo)localObject1).jdField_a_of_type_Float;
            i1 -= 1;
            f1 = f2;
            i2 = paramInt;
            i3 = i1;
            if (i1 >= 0)
            {
              localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
              f1 = f2;
              break label612;
            }
          }
          else
          {
            f2 += a(i4, i1 + 1).jdField_a_of_type_Float;
            paramInt += 1;
            f1 = f2;
            i2 = paramInt;
            i3 = i1;
            if (i1 >= 0)
            {
              localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
              f1 = f2;
              break label612;
            }
          }
          localObject1 = null;
          i1 = i3;
          paramInt = i2;
          label612:
          i2 = i1;
          localObject4 = localObject1;
          i3 = paramInt;
          label623:
          i4 -= 1;
          f2 = f1;
          paramInt = i3;
          localObject1 = localObject4;
          i1 = i2;
        }
        f2 = ((MultiAIOBaseViewPager.ItemInfo)localObject3).jdField_a_of_type_Float;
        int i2 = paramInt + 1;
        if (f2 < 2.0F)
        {
          if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
            localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
          } else {
            localObject1 = null;
          }
          if (i8 <= 0) {
            f3 = 0.0F;
          } else {
            f3 = getPaddingRight() / i8 + 2.0F;
          }
          i1 = this.jdField_b_of_type_Int;
          localObject4 = localObject1;
          for (;;)
          {
            i3 = i1 + 1;
            if (i3 >= i5) {
              break;
            }
            if ((f2 >= f3) && (i3 > i6))
            {
              if (localObject4 == null) {
                break;
              }
              f1 = f2;
              i1 = i2;
              localObject1 = localObject4;
              if (i3 != localObject4.jdField_a_of_type_Int) {
                break label1005;
              }
              f1 = f2;
              i1 = i2;
              localObject1 = localObject4;
              if (localObject4.jdField_a_of_type_Boolean) {
                break label1005;
              }
              this.jdField_a_of_type_JavaUtilArrayList.remove(i2);
              this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.destroyItem(this, i3, localObject4.jdField_a_of_type_JavaLangObject);
              f1 = f2;
              i1 = i2;
              if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
              {
                localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
                f1 = f2;
                i1 = i2;
                break label1005;
              }
            }
            do
            {
              do
              {
                localObject1 = null;
                break label1005;
                if ((localObject4 == null) || (i3 != localObject4.jdField_a_of_type_Int)) {
                  break;
                }
                f2 += localObject4.jdField_a_of_type_Float;
                i2 += 1;
                f1 = f2;
                i1 = i2;
              } while (i2 >= this.jdField_a_of_type_JavaUtilArrayList.size());
              localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
              f1 = f2;
              i1 = i2;
              break;
              localObject1 = a(i3, i2);
              i2 += 1;
              f2 += ((MultiAIOBaseViewPager.ItemInfo)localObject1).jdField_a_of_type_Float;
              f1 = f2;
              i1 = i2;
            } while (i2 >= this.jdField_a_of_type_JavaUtilArrayList.size());
            localObject1 = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
            i1 = i2;
            f1 = f2;
            label1005:
            f2 = f1;
            i2 = i1;
            localObject4 = localObject1;
            i1 = i3;
          }
        }
        a((MultiAIOBaseViewPager.ItemInfo)localObject3, paramInt, (MultiAIOBaseViewPager.ItemInfo)localObject2);
        this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.setPrimaryItem(this, this.jdField_b_of_type_Int, ((MultiAIOBaseViewPager.ItemInfo)localObject3).jdField_a_of_type_JavaLangObject);
      }
      this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.finishUpdate(this);
      i1 = getChildCount();
      paramInt = 0;
      while (paramInt < i1)
      {
        localObject2 = getChildAt(paramInt);
        localObject1 = (MultiAIOBaseViewPager.LayoutParams)((View)localObject2).getLayoutParams();
        ((MultiAIOBaseViewPager.LayoutParams)localObject1).jdField_c_of_type_Int = paramInt;
        if ((!((MultiAIOBaseViewPager.LayoutParams)localObject1).jdField_a_of_type_Boolean) && (((MultiAIOBaseViewPager.LayoutParams)localObject1).jdField_a_of_type_Float == 0.0F))
        {
          localObject2 = a((View)localObject2);
          if (localObject2 != null)
          {
            ((MultiAIOBaseViewPager.LayoutParams)localObject1).jdField_a_of_type_Float = ((MultiAIOBaseViewPager.ItemInfo)localObject2).jdField_a_of_type_Float;
            ((MultiAIOBaseViewPager.LayoutParams)localObject1).jdField_b_of_type_Int = ((MultiAIOBaseViewPager.ItemInfo)localObject2).jdField_a_of_type_Int;
          }
        }
        paramInt += 1;
      }
      d();
      if (hasFocus())
      {
        localObject1 = findFocus();
        if (localObject1 != null) {
          localObject1 = b((View)localObject1);
        } else {
          localObject1 = null;
        }
        if ((localObject1 == null) || (((MultiAIOBaseViewPager.ItemInfo)localObject1).jdField_a_of_type_Int != this.jdField_b_of_type_Int))
        {
          paramInt = 0;
          while (paramInt < getChildCount())
          {
            localObject1 = getChildAt(paramInt);
            localObject2 = a((View)localObject1);
            if ((localObject2 != null) && (((MultiAIOBaseViewPager.ItemInfo)localObject2).jdField_a_of_type_Int == this.jdField_b_of_type_Int) && (((View)localObject1).requestFocus(2))) {
              return;
            }
            paramInt += 1;
          }
        }
      }
      return;
    }
    try
    {
      localObject1 = getResources().getResourceName(getId());
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label1280:
      break label1280;
    }
    Object localObject1 = Integer.toHexString(getId());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
    ((StringBuilder)localObject2).append(this.jdField_e_of_type_Int);
    ((StringBuilder)localObject2).append(", found: ");
    ((StringBuilder)localObject2).append(i5);
    ((StringBuilder)localObject2).append(" Pager id: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" Pager class: ");
    ((StringBuilder)localObject2).append(getClass());
    ((StringBuilder)localObject2).append(" Problematic adapter: ");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getClass());
    localObject1 = new IllegalStateException(((StringBuilder)localObject2).toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public void b(MultiAIOBaseViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.remove(paramOnPageChangeListener);
    }
  }
  
  public boolean b()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public boolean b(int paramInt)
  {
    View localView2 = findFocus();
    boolean bool = false;
    View localView1 = null;
    Object localObject;
    int i1;
    if (localView2 == this)
    {
      localObject = localView1;
    }
    else
    {
      if (localView2 != null)
      {
        for (localObject = localView2.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent)localObject).getParent()) {
          if (localObject == this)
          {
            i1 = 1;
            break label70;
          }
        }
        i1 = 0;
        label70:
        if (i1 == 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localView2.getClass().getSimpleName());
          for (localObject = localView2.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent)localObject).getParent())
          {
            localStringBuilder.append(" => ");
            localStringBuilder.append(localObject.getClass().getSimpleName());
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("arrowScroll tried to find focus based on non-child current focused view ");
          ((StringBuilder)localObject).append(localStringBuilder.toString());
          Log.e("MultiAIOBaseViewPager", ((StringBuilder)localObject).toString());
          localObject = localView1;
          break label199;
        }
      }
      localObject = localView2;
    }
    label199:
    localView1 = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
    int i2;
    if ((localView1 != null) && (localView1 != localObject)) {
      if (paramInt == 17)
      {
        i1 = a(this.jdField_a_of_type_AndroidGraphicsRect, localView1).left;
        i2 = a(this.jdField_a_of_type_AndroidGraphicsRect, (View)localObject).left;
        if ((localObject != null) && (i1 >= i2)) {
          bool = c();
        } else {
          bool = localView1.requestFocus();
        }
      }
    }
    for (;;)
    {
      break;
      if (paramInt == 66)
      {
        i1 = a(this.jdField_a_of_type_AndroidGraphicsRect, localView1).left;
        i2 = a(this.jdField_a_of_type_AndroidGraphicsRect, (View)localObject).left;
        if ((localObject != null) && (i1 <= i2))
        {
          bool = d();
        }
        else
        {
          bool = localView1.requestFocus();
          continue;
          if ((paramInt != 17) && (paramInt != 1))
          {
            if ((paramInt == 66) || (paramInt == 2)) {
              bool = d();
            }
          }
          else {
            bool = c();
          }
        }
      }
    }
    if (bool) {
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
    }
    return bool;
  }
  
  public int c()
  {
    return this.w;
  }
  
  void c()
  {
    b(this.jdField_b_of_type_Int);
  }
  
  public void c(int paramInt)
  {
    this.jdField_e_of_type_Boolean = true;
    int i1 = d();
    int i2 = getScrollX();
    MultiAIOBaseViewPager.ItemInfo localItemInfo = a();
    if (localItemInfo == null) {
      return;
    }
    a(a(localItemInfo.jdField_a_of_type_Int, (i2 / i1 - localItemInfo.jdField_b_of_type_Float) / localItemInfo.jdField_a_of_type_Float, paramInt, this.r - 1), true, true, paramInt);
  }
  
  boolean c()
  {
    int i1 = this.jdField_b_of_type_Int;
    if (i1 > 0)
    {
      setCurrentItem(i1 - 1, true);
      return true;
    }
    return false;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    PagerAdapter localPagerAdapter = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localPagerAdapter == null) {
      return false;
    }
    int i1 = d();
    int i2 = getScrollX();
    if (paramInt < 0)
    {
      if (i2 > (int)(i1 * this.jdField_a_of_type_Float)) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (paramInt > 0)
    {
      bool1 = bool2;
      if (i2 < (int)(i1 * this.jdField_b_of_type_Float)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof MultiAIOBaseViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    this.jdField_b_of_type_Boolean = true;
    if ((!this.jdField_b_of_type_AndroidWidgetScroller.isFinished()) && (this.jdField_b_of_type_AndroidWidgetScroller.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.jdField_b_of_type_AndroidWidgetScroller.getCurrX();
      int i4 = this.jdField_b_of_type_AndroidWidgetScroller.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (!a(i3))
        {
          this.jdField_b_of_type_AndroidWidgetScroller.abortAnimation();
          scrollTo(0, i4);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    b(true);
  }
  
  protected void d()
  {
    if (this.v != 0)
    {
      Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
      if (localObject == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      } else {
        ((ArrayList)localObject).clear();
      }
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = getChildAt(i1);
        this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
        i1 += 1;
      }
      Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$ViewPositionComparator);
    }
  }
  
  boolean d()
  {
    PagerAdapter localPagerAdapter = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if ((localPagerAdapter != null) && (this.jdField_b_of_type_Int < localPagerAdapter.getCount() - 1))
    {
      setCurrentItem(this.jdField_b_of_type_Int + 1, true);
      return true;
    }
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 4096) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        MultiAIOBaseViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.jdField_a_of_type_Int == this.jdField_b_of_type_Int) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i1 += 1;
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i4 = getOverScrollMode();
    int i3 = 0;
    int i1 = 0;
    if (i4 != 0) {
      if (i4 == 1)
      {
        PagerAdapter localPagerAdapter = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
        if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 1)) {}
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetEdgeEffect.finish();
        this.jdField_b_of_type_AndroidWidgetEdgeEffect.finish();
        break label256;
      }
    }
    int i2;
    if (!this.jdField_a_of_type_AndroidWidgetEdgeEffect.isFinished())
    {
      i3 = paramCanvas.save();
      i1 = getHeight() - getPaddingTop() - getPaddingBottom();
      i4 = getWidth();
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-i1 + getPaddingTop(), this.jdField_a_of_type_Float * i4);
      this.jdField_a_of_type_AndroidWidgetEdgeEffect.setSize(i1, i4);
      i2 = false | this.jdField_a_of_type_AndroidWidgetEdgeEffect.draw(paramCanvas);
      paramCanvas.restoreToCount(i3);
    }
    i3 = i2;
    boolean bool;
    if (!this.jdField_b_of_type_AndroidWidgetEdgeEffect.isFinished())
    {
      i4 = paramCanvas.save();
      i3 = getWidth();
      int i5 = getHeight();
      int i6 = getPaddingTop();
      int i7 = getPaddingBottom();
      paramCanvas.rotate(90.0F);
      paramCanvas.translate(-getPaddingTop(), -(this.jdField_b_of_type_Float + 1.0F) * i3);
      this.jdField_b_of_type_AndroidWidgetEdgeEffect.setSize(i5 - i6 - i7, i3);
      bool = i2 | this.jdField_b_of_type_AndroidWidgetEdgeEffect.draw(paramCanvas);
      paramCanvas.restoreToCount(i4);
    }
    label256:
    if (bool) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "endFakeDrag() called");
    }
    if (this.jdField_h_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter != null)
      {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
          this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
        }
        Object localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
        ((VelocityTracker)localObject).clear();
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.jdField_c_of_type_Int);
        int i1 = (int)((VelocityTracker)localObject).getXVelocity(this.p);
        this.jdField_e_of_type_Boolean = true;
        int i2 = d();
        int i3 = getScrollX();
        localObject = a();
        if (localObject == null) {
          return;
        }
        a(((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Int, (i3 / i2 - ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_b_of_type_Float) / ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Float, i1, (int)(this.jdField_c_of_type_Float - this.jdField_e_of_type_Float));
      }
      h();
      this.jdField_h_of_type_Boolean = false;
      return;
    }
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  protected boolean e()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public void f()
  {
    Scroller localScroller = this.jdField_b_of_type_AndroidWidgetScroller;
    if (localScroller != null) {
      localScroller.abortAnimation();
    }
  }
  
  public boolean f()
  {
    Scroller localScroller = this.jdField_b_of_type_AndroidWidgetScroller;
    if (localScroller != null) {
      return localScroller.isFinished();
    }
    return true;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new MultiAIOBaseViewPager.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new MultiAIOBaseViewPager.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (this.v == 2) {
      i1 = paramInt1 - 1 - paramInt2;
    }
    return ((MultiAIOBaseViewPager.LayoutParams)((View)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).getLayoutParams()).jdField_c_of_type_Int;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_i_of_type_Boolean = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    Scroller localScroller = this.jdField_b_of_type_AndroidWidgetScroller;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      this.jdField_b_of_type_AndroidWidgetScroller.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_g_of_type_Int > 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter != null))
    {
      int i3 = getScrollX();
      int i4 = getWidth();
      float f1 = this.jdField_g_of_type_Int;
      float f5 = i4;
      float f2 = f1 / f5;
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
      int i2 = 0;
      localObject = (MultiAIOBaseViewPager.ItemInfo)((ArrayList)localObject).get(0);
      f1 = ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_b_of_type_Float;
      int i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i1 = ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Int;
      int i6 = ((MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1)).jdField_a_of_type_Int;
      while (i1 < i6)
      {
        while ((i1 > ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Int) && (i2 < i5))
        {
          localObject = this.jdField_a_of_type_JavaUtilArrayList;
          i2 += 1;
          localObject = (MultiAIOBaseViewPager.ItemInfo)((ArrayList)localObject).get(i2);
        }
        float f3;
        if (i1 == ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Int)
        {
          f3 = (((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_b_of_type_Float + ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Float) * f5;
          f1 = ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_b_of_type_Float + ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Float + f2;
        }
        else
        {
          float f4 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(i1);
          f3 = f1 + (f4 + f2);
          f4 = (f1 + f4) * f5;
          f1 = f3;
          f3 = f4;
        }
        if (this.jdField_g_of_type_Int + f3 > i3)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(Math.round(f3), this.jdField_h_of_type_Int, Math.round(this.jdField_g_of_type_Int + f3), this.jdField_i_of_type_Int);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
        if (f3 > i3 + i4) {
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 != 3) && (i1 != 1))
    {
      if (i1 != 0)
      {
        if (this.jdField_f_of_type_Boolean) {
          return true;
        }
        if (this.jdField_g_of_type_Boolean) {
          return false;
        }
      }
      float f1;
      if (i1 != 0)
      {
        if (i1 != 2)
        {
          if (i1 == 6) {
            a(paramMotionEvent);
          }
        }
        else
        {
          i1 = this.p;
          if (i1 != -1)
          {
            i1 = paramMotionEvent.findPointerIndex(i1);
            if ((i1 >= 0) && (i1 <= paramMotionEvent.getPointerCount() - 1))
            {
              f1 = this.jdField_c_of_type_Float;
              try
              {
                f2 = paramMotionEvent.getX(i1);
                f1 = f2;
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  QLog.e("MultiAIOBaseViewPager", 1, "onInterceptTouchEvent: ", localException1);
                }
              }
              float f4 = f1 - this.jdField_c_of_type_Float;
              float f5 = Math.abs(f4);
              float f2 = this.jdField_d_of_type_Float;
              try
              {
                f3 = paramMotionEvent.getY(i1);
                f2 = f3;
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  QLog.e("MultiAIOBaseViewPager", 1, "onInterceptTouchEvent: ", localException2);
                }
              }
              float f3 = Math.abs(f2 - this.jdField_f_of_type_Float);
              if ((f4 != 0.0F) && (!a(this.jdField_c_of_type_Float, f4)) && (a(this, false, (int)f4, (int)f1, (int)f2)))
              {
                this.jdField_c_of_type_Float = f1;
                this.jdField_d_of_type_Float = f2;
                this.jdField_g_of_type_Boolean = true;
                return false;
              }
              if ((f5 > this.o) && (f5 * 0.5F > f3))
              {
                this.jdField_f_of_type_Boolean = true;
                d(true);
                a(1);
                if (f4 > 0.0F) {
                  f3 = this.jdField_e_of_type_Float + this.o;
                } else {
                  f3 = this.jdField_e_of_type_Float - this.o;
                }
                this.jdField_c_of_type_Float = f3;
                this.jdField_d_of_type_Float = f2;
                a(true);
              }
              else if (f3 > this.o)
              {
                this.jdField_g_of_type_Boolean = true;
              }
              if ((this.jdField_f_of_type_Boolean) && (a(f1))) {
                ViewCompat.postInvalidateOnAnimation(this);
              }
            }
          }
        }
      }
      else
      {
        f1 = paramMotionEvent.getX();
        this.jdField_e_of_type_Float = f1;
        this.jdField_c_of_type_Float = f1;
        f1 = paramMotionEvent.getY();
        this.jdField_f_of_type_Float = f1;
        this.jdField_d_of_type_Float = f1;
        this.p = paramMotionEvent.getPointerId(0);
        this.jdField_g_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetScroller.computeScrollOffset();
        if ((this.w == 2) && (Math.abs(this.jdField_b_of_type_AndroidWidgetScroller.getFinalX() - this.jdField_b_of_type_AndroidWidgetScroller.getCurrX()) > this.s)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        MultiAIOBaseViewPager.FlingListener localFlingListener = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$FlingListener;
        boolean bool;
        if (localFlingListener != null) {
          bool = localFlingListener.a() ^ true;
        }
        if (bool)
        {
          this.jdField_b_of_type_AndroidWidgetScroller.abortAnimation();
          localFlingListener = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$FlingListener;
          if (localFlingListener != null) {
            localFlingListener.a();
          }
          this.jdField_e_of_type_Boolean = false;
          c();
          this.jdField_f_of_type_Boolean = true;
          d(true);
          a(1);
        }
        else
        {
          b(false);
          this.jdField_f_of_type_Boolean = false;
        }
      }
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      return this.jdField_f_of_type_Boolean;
    }
    g();
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i8 = getChildCount();
    int i9 = paramInt3 - paramInt1;
    int i10 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i2 = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int i11 = getScrollX();
    int i3 = 0;
    int i4 = 0;
    View localView;
    int i1;
    MultiAIOBaseViewPager.LayoutParams localLayoutParams;
    while (i4 < i8)
    {
      localView = getChildAt(i4);
      i1 = paramInt2;
      int i7 = i2;
      int i6 = paramInt1;
      int i5 = paramInt4;
      paramInt3 = i3;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
        i1 = paramInt2;
        i7 = i2;
        i6 = paramInt1;
        i5 = paramInt4;
        paramInt3 = i3;
        if (localLayoutParams.jdField_a_of_type_Boolean)
        {
          paramInt3 = localLayoutParams.jdField_a_of_type_Int & 0x7;
          i5 = localLayoutParams.jdField_a_of_type_Int & 0x70;
          if (paramInt3 != 1)
          {
            if (paramInt3 != 3)
            {
              if (paramInt3 != 5)
              {
                paramInt3 = paramInt2;
                i1 = paramInt2;
              }
              else
              {
                paramInt3 = i9 - i2 - localView.getMeasuredWidth();
                i2 += localView.getMeasuredWidth();
                i1 = paramInt2;
              }
            }
            else
            {
              i1 = localView.getMeasuredWidth();
              paramInt3 = paramInt2;
              i1 += paramInt2;
            }
          }
          else
          {
            paramInt3 = Math.max((i9 - localView.getMeasuredWidth()) / 2, paramInt2);
            i1 = paramInt2;
          }
          if (i5 != 16)
          {
            if (i5 != 48)
            {
              if (i5 != 80)
              {
                paramInt2 = paramInt1;
              }
              else
              {
                paramInt2 = i10 - paramInt4 - localView.getMeasuredHeight();
                paramInt4 += localView.getMeasuredHeight();
              }
            }
            else
            {
              i5 = localView.getMeasuredHeight();
              paramInt2 = paramInt1;
              paramInt1 = i5 + paramInt1;
            }
          }
          else {
            paramInt2 = Math.max((i10 - localView.getMeasuredHeight()) / 2, paramInt1);
          }
          paramInt3 += i11;
          localView.layout(paramInt3, paramInt2, localView.getMeasuredWidth() + paramInt3, paramInt2 + localView.getMeasuredHeight());
          paramInt3 = i3 + 1;
          i5 = paramInt4;
          i6 = paramInt1;
          i7 = i2;
        }
      }
      i4 += 1;
      paramInt2 = i1;
      i2 = i7;
      paramInt1 = i6;
      paramInt4 = i5;
      i3 = paramInt3;
    }
    paramInt3 = 0;
    while (paramInt3 < i8)
    {
      localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.jdField_a_of_type_Boolean)
        {
          MultiAIOBaseViewPager.ItemInfo localItemInfo = a(localView);
          if (localItemInfo != null)
          {
            float f1 = i9 - paramInt2 - i2;
            i1 = (int)(localItemInfo.jdField_b_of_type_Float * f1) + paramInt2;
            if (localLayoutParams.jdField_b_of_type_Boolean)
            {
              localLayoutParams.jdField_b_of_type_Boolean = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(f1 * localLayoutParams.jdField_a_of_type_Float), 1073741824), View.MeasureSpec.makeMeasureSpec(i10 - paramInt1 - paramInt4, 1073741824));
            }
            localView.layout(i1, paramInt1, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
    this.jdField_h_of_type_Int = paramInt1;
    this.jdField_i_of_type_Int = (i10 - paramInt4);
    this.t = i3;
    if (this.jdField_i_of_type_Boolean) {
      a(this.jdField_b_of_type_Int, false, 0, false);
    }
    this.jdField_i_of_type_Boolean = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.n = Math.min(paramInt1 / 10, this.m);
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    paramInt2 = getMeasuredHeight();
    int i3 = getPaddingTop();
    int i4 = getPaddingBottom();
    int i9 = getChildCount();
    paramInt2 = paramInt2 - i3 - i4;
    paramInt1 = paramInt1 - i1 - i2;
    i3 = 0;
    View localView;
    MultiAIOBaseViewPager.LayoutParams localLayoutParams;
    for (;;)
    {
      int i6 = 1;
      int i8 = 1073741824;
      if (i3 >= i9) {
        break;
      }
      localView = getChildAt(i3);
      i1 = paramInt1;
      i2 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
        i1 = paramInt1;
        i2 = paramInt2;
        if (localLayoutParams != null)
        {
          i1 = paramInt1;
          i2 = paramInt2;
          if (localLayoutParams.jdField_a_of_type_Boolean)
          {
            i1 = localLayoutParams.jdField_a_of_type_Int & 0x7;
            i2 = localLayoutParams.jdField_a_of_type_Int & 0x70;
            int i5;
            if ((i2 != 48) && (i2 != 80)) {
              i5 = 0;
            } else {
              i5 = 1;
            }
            i4 = i6;
            if (i1 != 3) {
              if (i1 == 5) {
                i4 = i6;
              } else {
                i4 = 0;
              }
            }
            i1 = -2147483648;
            if (i5 != 0)
            {
              i2 = 1073741824;
            }
            else
            {
              i2 = i1;
              if (i4 != 0)
              {
                i6 = 1073741824;
                i2 = i1;
                i1 = i6;
                break label282;
              }
            }
            i1 = -2147483648;
            label282:
            int i7;
            if (localLayoutParams.width != -2)
            {
              if (localLayoutParams.width != -1) {
                i2 = localLayoutParams.width;
              } else {
                i2 = paramInt1;
              }
              i6 = 1073741824;
              i7 = i2;
            }
            else
            {
              i7 = paramInt1;
              i6 = i2;
            }
            if (localLayoutParams.height != -2)
            {
              if (localLayoutParams.height != -1) {
                i1 = localLayoutParams.height;
              } else {
                i1 = paramInt2;
              }
            }
            else
            {
              i2 = paramInt2;
              i8 = i1;
              i1 = i2;
            }
            localView.measure(View.MeasureSpec.makeMeasureSpec(i7, i6), View.MeasureSpec.makeMeasureSpec(i1, i8));
            if (i5 != 0)
            {
              i2 = paramInt2 - localView.getMeasuredHeight();
              i1 = paramInt1;
            }
            else
            {
              i1 = paramInt1;
              i2 = paramInt2;
              if (i4 != 0)
              {
                i1 = paramInt1 - localView.getMeasuredWidth();
                i2 = paramInt2;
              }
            }
          }
        }
      }
      i3 += 1;
      paramInt1 = i1;
      paramInt2 = i2;
    }
    this.jdField_j_of_type_Int = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    this.jdField_k_of_type_Int = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    this.jdField_c_of_type_Boolean = true;
    c();
    paramInt2 = 0;
    this.jdField_c_of_type_Boolean = false;
    i1 = getChildCount();
    while (paramInt2 < i1)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams == null) || (!localLayoutParams.jdField_a_of_type_Boolean))
        {
          float f1 = 0.0F;
          if (localLayoutParams != null) {
            f1 = localLayoutParams.jdField_a_of_type_Float;
          }
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * f1), 1073741824), this.jdField_k_of_type_Int);
        }
      }
      paramInt2 += 1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i1 = getChildCount();
    int i3 = -1;
    int i2;
    if ((paramInt & 0x2) != 0)
    {
      i3 = i1;
      i1 = 0;
      i2 = 1;
    }
    else
    {
      i1 -= 1;
      i2 = -1;
    }
    while (i1 != i3)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        MultiAIOBaseViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.jdField_a_of_type_Int == this.jdField_b_of_type_Int) && (localView.requestFocus(paramInt, paramRect))) {
          return true;
        }
      }
      i1 += i2;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof MultiAIOBaseViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (MultiAIOBaseViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    PagerAdapter localPagerAdapter = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if (localPagerAdapter != null)
    {
      localPagerAdapter.restoreState(paramParcelable.jdField_a_of_type_AndroidOsParcelable, paramParcelable.jdField_a_of_type_JavaLangClassLoader);
      a(paramParcelable.jdField_a_of_type_Int, false, true);
      return;
    }
    this.jdField_f_of_type_Int = paramParcelable.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidOsParcelable = paramParcelable.jdField_a_of_type_AndroidOsParcelable;
    this.jdField_a_of_type_JavaLangClassLoader = paramParcelable.jdField_a_of_type_JavaLangClassLoader;
  }
  
  public Parcelable onSaveInstanceState()
  {
    MultiAIOBaseViewPager.SavedState localSavedState = new MultiAIOBaseViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    PagerAdapter localPagerAdapter = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if (localPagerAdapter != null) {
      localSavedState.jdField_a_of_type_AndroidOsParcelable = localPagerAdapter.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      paramInt2 = this.jdField_g_of_type_Int;
      a(paramInt1, paramInt3, paramInt2, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_h_of_type_Boolean) {
      return true;
    }
    int i2 = paramMotionEvent.getAction();
    boolean bool2 = false;
    int i1 = 0;
    if ((i2 == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if (localObject != null)
    {
      if (((PagerAdapter)localObject).getCount() == 0) {
        return false;
      }
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      i2 = paramMotionEvent.getAction() & 0xFF;
      boolean bool1;
      float f1;
      if (i2 != 0)
      {
        float f2;
        if (i2 != 1)
        {
          if (i2 != 2)
          {
            if (i2 != 3)
            {
              if (i2 != 5)
              {
                if (i2 != 6)
                {
                  bool1 = bool2;
                }
                else
                {
                  a(paramMotionEvent);
                  i1 = paramMotionEvent.findPointerIndex(this.p);
                  try
                  {
                    this.jdField_c_of_type_Float = paramMotionEvent.getX(i1);
                    bool1 = bool2;
                  }
                  catch (Exception paramMotionEvent)
                  {
                    QLog.e("MultiAIOBaseViewPager", 1, "onTouchEvent: ", paramMotionEvent);
                    bool1 = bool2;
                  }
                }
              }
              else
              {
                i1 = paramMotionEvent.getActionIndex();
                try
                {
                  this.jdField_c_of_type_Float = paramMotionEvent.getX(i1);
                  this.p = paramMotionEvent.getPointerId(i1);
                  bool1 = bool2;
                }
                catch (Exception paramMotionEvent)
                {
                  QLog.e("MultiAIOBaseViewPager", 1, "onTouchEvent: ", paramMotionEvent);
                  bool1 = bool2;
                }
              }
            }
            else
            {
              bool1 = bool2;
              if (this.jdField_f_of_type_Boolean)
              {
                a(this.jdField_b_of_type_Int, true, 0, false);
                bool1 = g();
              }
            }
          }
          else
          {
            if (!this.jdField_f_of_type_Boolean)
            {
              i1 = paramMotionEvent.findPointerIndex(this.p);
              if (i1 == -1)
              {
                bool1 = g();
                break label776;
              }
              f1 = paramMotionEvent.getX(i1);
              float f3 = Math.abs(f1 - this.jdField_c_of_type_Float);
              f2 = paramMotionEvent.getY(i1);
              float f4 = Math.abs(f2 - this.jdField_d_of_type_Float);
              if ((f3 > this.o) && (f3 > f4))
              {
                this.jdField_f_of_type_Boolean = true;
                d(true);
                f3 = this.jdField_e_of_type_Float;
                if (f1 - f3 > 0.0F) {
                  f1 = f3 + this.o;
                } else {
                  f1 = f3 - this.o;
                }
                this.jdField_c_of_type_Float = f1;
                this.jdField_d_of_type_Float = f2;
                a(1);
                a(true);
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
              }
            }
            bool1 = bool2;
            if (this.jdField_f_of_type_Boolean)
            {
              i1 = paramMotionEvent.findPointerIndex(this.p);
              bool1 = bool2;
              if (i1 != -1) {
                bool1 = false | a(paramMotionEvent.getX(i1));
              }
            }
          }
        }
        else
        {
          bool1 = bool2;
          if (this.jdField_f_of_type_Boolean)
          {
            localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
            ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.jdField_c_of_type_Int);
            i2 = (int)((VelocityTracker)localObject).getXVelocity(this.p);
            this.jdField_e_of_type_Boolean = true;
            int i3 = d();
            int i4 = getScrollX();
            localObject = a();
            if (localObject == null) {
              return false;
            }
            f2 = this.jdField_g_of_type_Int;
            f1 = i3;
            f2 /= f1;
            i3 = ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Int;
            f2 = (i4 / f1 - ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_b_of_type_Float) / (((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Float + f2);
            i4 = paramMotionEvent.findPointerIndex(this.p);
            f1 = this.jdField_c_of_type_Float;
            if (i4 != -1) {
              f1 = paramMotionEvent.getX(i4);
            }
            i4 = (int)(f1 - this.jdField_e_of_type_Float);
            if ((Math.abs(i4) > this.r * 4) && (Math.abs(i2) > this.q)) {
              i1 = 1;
            } else {
              a(a(i3, f2, i2, i4), true, true, i2);
            }
            bool1 = g();
            if (i1 != 0)
            {
              paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$FlingListener;
              if (paramMotionEvent != null) {
                paramMotionEvent.a(i2);
              }
            }
          }
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetScroller.abortAnimation();
        this.jdField_e_of_type_Boolean = false;
        c();
        f1 = paramMotionEvent.getX();
        this.jdField_e_of_type_Float = f1;
        this.jdField_c_of_type_Float = f1;
        f1 = paramMotionEvent.getY();
        this.jdField_f_of_type_Float = f1;
        this.jdField_d_of_type_Float = f1;
        this.p = paramMotionEvent.getPointerId(0);
        bool1 = bool2;
      }
      label776:
      if (bool1) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return true;
    }
    return false;
  }
  
  public void removeView(View paramView)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    Object localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    int i2 = 0;
    int i1;
    if (localObject != null)
    {
      a((PagerAdapter)localObject, null);
      this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.startUpdate(this);
      i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject = (MultiAIOBaseViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.destroyItem(this, ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_Int, ((MultiAIOBaseViewPager.ItemInfo)localObject).jdField_a_of_type_JavaLangObject);
        i1 += 1;
      }
      this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.finishUpdate(this);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      g();
      this.jdField_b_of_type_Int = 0;
      this.jdField_d_of_type_Int = 0;
      scrollTo(0, 0);
    }
    localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter = paramPagerAdapter;
    this.jdField_e_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$PagerObserver == null) {
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$PagerObserver = new MultiAIOBaseViewPager.PagerObserver(this);
      }
      a(this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter, this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$PagerObserver);
      this.jdField_e_of_type_Boolean = false;
      boolean bool = this.jdField_i_of_type_Boolean;
      this.jdField_i_of_type_Boolean = true;
      this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount();
      if (this.jdField_f_of_type_Int >= 0)
      {
        this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.restoreState(this.jdField_a_of_type_AndroidOsParcelable, this.jdField_a_of_type_JavaLangClassLoader);
        a(this.jdField_f_of_type_Int, false, true);
        this.jdField_f_of_type_Int = -1;
        this.jdField_a_of_type_AndroidOsParcelable = null;
        this.jdField_a_of_type_JavaLangClassLoader = null;
      }
      else if (!bool)
      {
        c();
      }
      else
      {
        requestLayout();
      }
    }
    List localList = this.jdField_b_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i3 = this.jdField_b_of_type_JavaUtilList.size();
      i1 = i2;
      while (i1 < i3)
      {
        ((MultiAIOBaseViewPager.OnAdapterChangeListener)this.jdField_b_of_type_JavaUtilList.get(i1)).a(this, (PagerAdapter)localObject, paramPagerAdapter);
        i1 += 1;
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_e_of_type_Boolean = false;
    a(paramInt, this.jdField_i_of_type_Boolean ^ true, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    setCurrentItem(paramInt, paramBoolean, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_e_of_type_Boolean = false;
    a(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void setFlingListener(MultiAIOBaseViewPager.FlingListener paramFlingListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$FlingListener = paramFlingListener;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Requested offscreen page limit ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" too small; defaulting to ");
      localStringBuilder.append(1);
      Log.w("MultiAIOBaseViewPager", localStringBuilder.toString());
      i1 = 1;
    }
    if (i1 != this.l)
    {
      this.l = i1;
      c();
    }
  }
  
  @Deprecated
  public void setOnPageChangeListener(MultiAIOBaseViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$OnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i1 = this.jdField_g_of_type_Int;
    this.jdField_g_of_type_Int = paramInt;
    int i2 = getWidth();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    boolean bool;
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    }
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setPageTransformer(boolean paramBoolean, MultiAIOBaseViewPager.PageTransformer paramPageTransformer)
  {
    setPageTransformer(paramBoolean, paramPageTransformer, 2);
  }
  
  public void setPageTransformer(boolean paramBoolean, MultiAIOBaseViewPager.PageTransformer paramPageTransformer, int paramInt)
  {
    int i2 = 1;
    boolean bool1;
    if (paramPageTransformer != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$PageTransformer != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int i1;
    if (bool1 != bool2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOBaseViewPager$PageTransformer = paramPageTransformer;
    setChildrenDrawingOrderEnabled(bool1);
    if (bool1)
    {
      if (paramBoolean) {
        i2 = 2;
      }
      this.v = i2;
      this.u = paramInt;
    }
    else
    {
      this.v = 0;
    }
    if (i1 != 0) {
      c();
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager
 * JD-Core Version:    0.7.0.1
 */