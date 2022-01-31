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
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
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
import auli;
import auln;
import aulo;
import aulp;
import aulq;
import aulr;
import auls;
import ault;
import aulu;
import aulv;
import aulw;
import aulx;
import auly;
import aumb;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MultiAIOBaseViewPager
  extends ViewGroup
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new aulo();
  private static final Comparator<auls> jdField_a_of_type_JavaUtilComparator;
  static final int[] jdField_a_of_type_ArrayOfInt = { 16842931 };
  private float jdField_a_of_type_Float = -3.402824E+038F;
  protected int a;
  private long jdField_a_of_type_Long;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Parcelable jdField_a_of_type_AndroidOsParcelable;
  public PagerAdapter a;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private EdgeEffect jdField_a_of_type_AndroidWidgetEdgeEffect;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private aulr jdField_a_of_type_Aulr;
  private final auls jdField_a_of_type_Auls = new auls();
  private aulw jdField_a_of_type_Aulw;
  private aulx jdField_a_of_type_Aulx;
  private auly jdField_a_of_type_Auly;
  private final aumb jdField_a_of_type_Aumb = new ault(this);
  private ClassLoader jdField_a_of_type_JavaLangClassLoader;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new MultiAIOBaseViewPager.3(this);
  private final ArrayList<auls> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<aulw> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = 3.4028235E+38F;
  public int b;
  private EdgeEffect jdField_b_of_type_AndroidWidgetEdgeEffect;
  private Scroller jdField_b_of_type_AndroidWidgetScroller;
  private aulw jdField_b_of_type_Aulw;
  private ArrayList<View> jdField_b_of_type_JavaUtilArrayList;
  private List<aulv> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  protected int c;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
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
  private boolean jdField_j_of_type_Boolean;
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
    jdField_a_of_type_JavaUtilComparator = new auln();
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
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      return paramRect;
    }
  }
  
  private auls a()
  {
    int i1 = d();
    float f1;
    float f2;
    label36:
    float f4;
    float f3;
    int i3;
    int i2;
    Object localObject1;
    label53:
    Object localObject2;
    auls localauls;
    if (i1 > 0)
    {
      f1 = getScrollX() / i1;
      if (i1 <= 0) {
        break label214;
      }
      f2 = this.jdField_g_of_type_Int / i1;
      f4 = 0.0F;
      f3 = 0.0F;
      i3 = -1;
      i1 = 0;
      i2 = 1;
      localObject1 = null;
      localObject2 = localObject1;
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localauls = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if ((i2 != 0) || (localauls.jdField_a_of_type_Int == i3 + 1)) {
          break label249;
        }
        localauls = this.jdField_a_of_type_Auls;
        localauls.jdField_b_of_type_Float = (f4 + f3 + f2);
        localauls.jdField_a_of_type_Int = (i3 + 1);
        localauls.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(localauls.jdField_a_of_type_Int);
        i1 -= 1;
      }
    }
    label214:
    label219:
    label249:
    for (;;)
    {
      f3 = localauls.jdField_b_of_type_Float;
      f4 = localauls.jdField_a_of_type_Float;
      if (i2 == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {}
      }
      else
      {
        if ((f1 >= f4 + f3 + f2) && (i1 != this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
          break label219;
        }
        localObject2 = localauls;
      }
      return localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      i3 = localauls.jdField_a_of_type_Int;
      f4 = localauls.jdField_a_of_type_Float;
      i2 = 0;
      i1 += 1;
      localObject1 = localauls;
      break label53;
    }
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
      f1 = getScrollX() / (paramInt2 - i3 - i4 + paramInt4);
      scrollTo((int)((paramInt1 - i1 - i2 + paramInt3) * f1), getScrollY());
      return;
    }
    auls localauls = a(this.jdField_b_of_type_Int);
    if (localauls != null) {}
    for (float f1 = Math.min(localauls.jdField_b_of_type_Float, this.jdField_b_of_type_Float);; f1 = 0.0F)
    {
      paramInt1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      b(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    auls localauls = a(paramInt1);
    float f1;
    if (localauls != null) {
      f1 = d();
    }
    for (int i1 = (int)(Math.max(this.jdField_a_of_type_Float, Math.min(localauls.jdField_b_of_type_Float, this.jdField_b_of_type_Float)) * f1);; i1 = 0)
    {
      if (paramBoolean1)
      {
        a(i1, 0, paramInt2);
        if (paramBoolean2) {
          d(paramInt1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MultiAIOBaseViewPager", 2, "scrollToItem() called with: item = [" + paramInt1 + "], smoothScroll = [" + paramBoolean1 + "], velocity = [" + paramInt2 + "], dispatchSelected = [" + paramBoolean2 + "]");
        }
        return;
      }
      if (paramBoolean2) {
        d(paramInt1);
      }
      b(false);
      scrollTo(i1, 0);
      a(i1);
      return;
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
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.p) {
      if (i1 != 0) {
        break label56;
      }
    }
    label56:
    for (i1 = 1;; i1 = 0)
    {
      this.jdField_c_of_type_Float = paramMotionEvent.getX(i1);
      this.p = paramMotionEvent.getPointerId(i1);
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      }
      return;
    }
  }
  
  private void a(auls paramauls1, int paramInt, auls paramauls2)
  {
    int i4 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount();
    int i1 = d();
    float f2;
    if (i1 > 0)
    {
      f2 = this.jdField_g_of_type_Int / i1;
      if (paramauls2 == null) {
        break label409;
      }
      i1 = paramauls2.jdField_a_of_type_Int;
      if (i1 < paramauls1.jdField_a_of_type_Int)
      {
        f1 = paramauls2.jdField_b_of_type_Float + paramauls2.jdField_a_of_type_Float + f2;
        i1 += 1;
        i2 = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i1 > paramauls1.jdField_a_of_type_Int) || (i2 >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
          break label409;
        }
        for (paramauls2 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i2);; paramauls2 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 <= paramauls2.jdField_a_of_type_Int) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 >= this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
            break;
          }
          i2 += 1;
        }
        f2 = 0.0F;
        break;
        while (i3 < paramauls2.jdField_a_of_type_Int)
        {
          f3 += this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(i3) + f2;
          i3 += 1;
        }
        paramauls2.jdField_b_of_type_Float = f3;
        f1 = f3 + (paramauls2.jdField_a_of_type_Float + f2);
        i1 = i3 + 1;
      }
    }
    if (i1 > paramauls1.jdField_a_of_type_Int)
    {
      i2 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      f1 = paramauls2.jdField_b_of_type_Float;
      i1 -= 1;
      while ((i1 >= paramauls1.jdField_a_of_type_Int) && (i2 >= 0))
      {
        for (paramauls2 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i2);; paramauls2 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 >= paramauls2.jdField_a_of_type_Int) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 <= 0) {
            break;
          }
          i2 -= 1;
        }
        while (i3 > paramauls2.jdField_a_of_type_Int)
        {
          f3 -= this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(i3) + f2;
          i3 -= 1;
        }
        f1 = f3 - (paramauls2.jdField_a_of_type_Float + f2);
        paramauls2.jdField_b_of_type_Float = f1;
        i1 = i3 - 1;
      }
    }
    label409:
    int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f3 = paramauls1.jdField_b_of_type_Float;
    i1 = paramauls1.jdField_a_of_type_Int - 1;
    if (paramauls1.jdField_a_of_type_Int == 0)
    {
      f1 = paramauls1.jdField_b_of_type_Float;
      this.jdField_a_of_type_Float = f1;
      if (paramauls1.jdField_a_of_type_Int != i4 - 1) {
        break label550;
      }
      f1 = paramauls1.jdField_b_of_type_Float + paramauls1.jdField_a_of_type_Float - 1.0F;
      label475:
      this.jdField_b_of_type_Float = f1;
      i2 = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (i2 < 0) {
        break label603;
      }
      paramauls2 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
      for (;;)
      {
        if (i1 > paramauls2.jdField_a_of_type_Int)
        {
          f1 -= this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(i1) + f2;
          i1 -= 1;
          continue;
          f1 = -3.402824E+038F;
          break;
          label550:
          f1 = 3.4028235E+38F;
          break label475;
        }
      }
      f1 -= paramauls2.jdField_a_of_type_Float + f2;
      paramauls2.jdField_b_of_type_Float = f1;
      if (paramauls2.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Float = f1;
      }
      i1 -= 1;
      i2 -= 1;
    }
    label603:
    float f1 = paramauls1.jdField_b_of_type_Float + paramauls1.jdField_a_of_type_Float + f2;
    int i2 = paramauls1.jdField_a_of_type_Int + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      paramauls1 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      while (paramInt < paramauls1.jdField_a_of_type_Int)
      {
        f1 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(paramInt) + f2 + f1;
        paramInt += 1;
      }
      if (paramauls1.jdField_a_of_type_Int == i4 - 1) {
        this.jdField_b_of_type_Float = (paramauls1.jdField_a_of_type_Float + f1 - 1.0F);
      }
      paramauls1.jdField_b_of_type_Float = f1;
      f1 += paramauls1.jdField_a_of_type_Float + f2;
      paramInt += 1;
      i1 += 1;
    }
    this.jdField_j_of_type_Boolean = false;
  }
  
  private boolean a(float paramFloat)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    float f1 = this.jdField_c_of_type_Float;
    this.jdField_c_of_type_Float = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int i3 = d();
    paramFloat = i3 * this.jdField_a_of_type_Float;
    f1 = i3;
    float f3 = this.jdField_b_of_type_Float;
    auls localauls1 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    auls localauls2 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (localauls1.jdField_a_of_type_Int != 0) {
      paramFloat = localauls1.jdField_b_of_type_Float * i3;
    }
    for (int i1 = 0;; i1 = 1)
    {
      if (localauls2.jdField_a_of_type_Int != this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() - 1) {
        f1 = localauls2.jdField_b_of_type_Float * i3;
      }
      for (int i2 = 0;; i2 = 1)
      {
        if (f2 < paramFloat)
        {
          if (i1 == 0) {
            break label249;
          }
          this.jdField_a_of_type_AndroidWidgetEdgeEffect.onPull(Math.abs(paramFloat - f2) / i3);
        }
        for (;;)
        {
          this.jdField_c_of_type_Float += paramFloat - (int)paramFloat;
          scrollTo((int)paramFloat, getScrollY());
          a((int)paramFloat);
          return bool1;
          if (f2 > f1)
          {
            if (i2 != 0) {
              this.jdField_b_of_type_AndroidWidgetEdgeEffect.onPull(Math.abs(f2 - f1) / i3);
            }
            for (bool1 = bool2;; bool1 = false)
            {
              paramFloat = f1;
              break;
            }
          }
          paramFloat = f2;
          bool1 = false;
          continue;
          label249:
          bool1 = false;
        }
        f1 *= f3;
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.n) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.n) && (paramFloat2 < 0.0F));
  }
  
  private static boolean a(View paramView)
  {
    return paramView.getClass().getAnnotation(aulq.class) != null;
  }
  
  private void b(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_Aulw != null) {
      this.jdField_a_of_type_Aulw.a(paramInt1, paramFloat, paramInt2);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        aulw localaulw = (aulw)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localaulw != null) {
          localaulw.a(paramInt1, paramFloat, paramInt2);
        }
        i1 += 1;
      }
    }
    if (this.jdField_b_of_type_Aulw != null) {
      this.jdField_b_of_type_Aulw.a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i1;
    if (this.w == 2)
    {
      i1 = 1;
      if (i1 != 0)
      {
        a(false);
        if (this.jdField_b_of_type_AndroidWidgetScroller.isFinished()) {
          break label170;
        }
      }
    }
    label170:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 != 0)
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
      this.jdField_e_of_type_Boolean = false;
      int i3 = 0;
      i2 = i1;
      i1 = i3;
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        auls localauls = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (localauls.jdField_a_of_type_Boolean)
        {
          localauls.jdField_a_of_type_Boolean = false;
          i2 = 1;
        }
        i1 += 1;
      }
      i1 = 0;
      break;
    }
    if (i2 != 0)
    {
      if (paramBoolean) {
        ViewCompat.postOnAnimation(this, this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  private void c(boolean paramBoolean)
  {
    int i3 = getChildCount();
    int i1 = 0;
    if (i1 < i3)
    {
      if (paramBoolean) {}
      for (int i2 = this.u;; i2 = 0)
      {
        getChildAt(i1).setLayerType(i2, null);
        i1 += 1;
        break;
      }
    }
  }
  
  private int d()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_Aulw != null) {
      this.jdField_a_of_type_Aulw.a(paramInt);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        aulw localaulw = (aulw)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localaulw != null) {
          localaulw.a(paramInt);
        }
        i1 += 1;
      }
    }
    if (this.jdField_b_of_type_Aulw != null) {
      this.jdField_b_of_type_Aulw.a(paramInt);
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
    if (this.jdField_a_of_type_Aulw != null) {
      this.jdField_a_of_type_Aulw.b(paramInt);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        aulw localaulw = (aulw)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localaulw != null) {
          localaulw.b(paramInt);
        }
        i1 += 1;
      }
    }
    if (this.jdField_b_of_type_Aulw != null) {
      this.jdField_b_of_type_Aulw.b(paramInt);
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
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
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
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          auls localauls1 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          auls localauls2 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
          paramInt2 = Math.max(localauls1.jdField_a_of_type_Int, Math.min(paramInt1, localauls2.jdField_a_of_type_Int));
        }
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.jdField_b_of_type_Int) {}
    for (float f1 = 0.4F;; f1 = 0.6F)
    {
      paramInt1 += (int)(f1 + paramFloat);
      break;
    }
  }
  
  public PagerAdapter a()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  }
  
  auls a(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      auls localauls = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (localauls.jdField_a_of_type_Int == paramInt) {
        return localauls;
      }
      i1 += 1;
    }
    return null;
  }
  
  auls a(int paramInt1, int paramInt2)
  {
    auls localauls = new auls();
    localauls.jdField_a_of_type_Int = paramInt1;
    localauls.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.instantiateItem(this, paramInt1);
    localauls.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localauls);
      return localauls;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt2, localauls);
    return localauls;
  }
  
  auls a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      auls localauls = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.isViewFromObject(paramView, localauls.jdField_a_of_type_JavaLangObject)) {
        return localauls;
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
    this.jdField_a_of_type_Int = auli.a(getContext(), this.jdField_c_of_type_Int);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetEdgeEffect = new EdgeEffect(localContext);
    this.jdField_b_of_type_AndroidWidgetEdgeEffect = new EdgeEffect(localContext);
    this.r = ((int)(25.0F * f1));
    this.s = ((int)(2.0F * f1));
    this.m = ((int)(16.0F * f1));
    ViewCompat.setAccessibilityDelegate(this, new aulu(this));
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    ViewCompat.setOnApplyWindowInsetsListener(this, new aulp(this));
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "fakeDragBy() called with: xOffset = [" + paramFloat + "]");
    }
    if (!this.jdField_h_of_type_Boolean) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter == null) {
      return;
    }
    this.jdField_c_of_type_Float += paramFloat;
    float f2 = getScrollX() - paramFloat;
    int i1 = d();
    paramFloat = i1;
    float f4 = this.jdField_a_of_type_Float;
    float f1 = i1;
    float f3 = this.jdField_b_of_type_Float;
    Object localObject = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    auls localauls = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (((auls)localObject).jdField_a_of_type_Int != 0) {}
    for (paramFloat = ((auls)localObject).jdField_b_of_type_Float * i1;; paramFloat *= f4)
    {
      if (localauls.jdField_a_of_type_Int != this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() - 1) {}
      for (f1 = localauls.jdField_b_of_type_Float * i1;; f1 *= f3)
      {
        if (f2 < paramFloat) {}
        for (;;)
        {
          this.jdField_c_of_type_Float += paramFloat - (int)paramFloat;
          scrollTo((int)paramFloat, getScrollY());
          a((int)paramFloat);
          long l1 = SystemClock.uptimeMillis();
          localObject = MotionEvent.obtain(this.jdField_a_of_type_Long, l1, 2, this.jdField_c_of_type_Float, 0.0F, 0);
          if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
            this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
          }
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement((MotionEvent)localObject);
          ((MotionEvent)localObject).recycle();
          return;
          if (f2 > f1) {
            paramFloat = f1;
          } else {
            paramFloat = f2;
          }
        }
      }
    }
  }
  
  void a(int paramInt)
  {
    if (this.w == paramInt) {
      return;
    }
    this.w = paramInt;
    if (this.jdField_a_of_type_Aulx != null) {
      if (paramInt == 0) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      c(bool);
      e(paramInt);
      return;
    }
  }
  
  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    View localView;
    if (this.t > 0)
    {
      int i6 = getScrollX();
      i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i7 = getWidth();
      int i8 = getChildCount();
      int i5 = 0;
      while (i5 < i8)
      {
        localView = getChildAt(i5);
        MultiAIOBaseViewPager.LayoutParams localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
        int i4;
        int i3;
        if (!localLayoutParams.jdField_a_of_type_Boolean)
        {
          i4 = i1;
          i3 = i2;
          i5 += 1;
          i1 = i4;
          i2 = i3;
        }
        else
        {
          switch (localLayoutParams.jdField_a_of_type_Int & 0x7)
          {
          case 2: 
          case 4: 
          default: 
            i3 = i1;
            i4 = i2;
            i2 = i1;
            i1 = i4;
          }
          for (;;)
          {
            int i9 = i3 + i6 - localView.getLeft();
            i3 = i1;
            i4 = i2;
            if (i9 == 0) {
              break;
            }
            localView.offsetLeftAndRight(i9);
            i3 = i1;
            i4 = i2;
            break;
            i3 = localView.getWidth();
            i4 = i3 + i1;
            i3 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = Math.max((i7 - localView.getMeasuredWidth()) / 2, i1);
            i4 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = i7 - i2 - localView.getMeasuredWidth();
            i9 = localView.getMeasuredWidth();
            i4 = i1;
            i1 = i2 + i9;
            i2 = i4;
          }
        }
      }
    }
    b(paramInt1, paramFloat, paramInt2);
    if (this.jdField_a_of_type_Aulx != null)
    {
      paramInt2 = getScrollX();
      i1 = getChildCount();
      paramInt1 = 0;
      if (paramInt1 < i1)
      {
        localView = getChildAt(paramInt1);
        if (((MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams()).jdField_a_of_type_Boolean) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramFloat = (localView.getLeft() - paramInt2) / d();
          this.jdField_a_of_type_Aulx.a(localView, paramFloat);
        }
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
    int i1;
    if ((this.jdField_b_of_type_AndroidWidgetScroller != null) && (!this.jdField_b_of_type_AndroidWidgetScroller.isFinished()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label125;
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label113;
      }
      i1 = this.jdField_b_of_type_AndroidWidgetScroller.getCurrX();
      label54:
      this.jdField_b_of_type_AndroidWidgetScroller.abortAnimation();
      a(false);
    }
    int i2;
    int i3;
    for (;;)
    {
      i2 = getScrollY();
      i3 = paramInt1 - i1;
      paramInt2 -= i2;
      if ((i3 != 0) || (paramInt2 != 0)) {
        break label134;
      }
      b(false);
      c();
      a(0);
      return;
      i1 = 0;
      break;
      label113:
      i1 = this.jdField_b_of_type_AndroidWidgetScroller.getStartX();
      break label54;
      label125:
      i1 = getScrollX();
    }
    label134:
    a(true);
    a(2);
    paramInt1 = d();
    int i4 = paramInt1 / 2;
    float f3 = Math.min(1.0F, Math.abs(i3) * 1.0F / paramInt1);
    float f1 = i4;
    float f2 = i4;
    f3 = a(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt3)) * 4;; paramInt1 = (int)((Math.abs(i3) / (f1 * f2 + this.jdField_g_of_type_Int) + 1.0F) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidWidgetScroller.startScroll(i1, i2, i3, paramInt2, paramInt1);
      ViewCompat.postInvalidateOnAnimation(this);
      return;
      f1 = paramInt1;
      f2 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(this.jdField_b_of_type_Int);
    }
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter == null) || (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() <= 0))
    {
      a(false);
      return;
    }
    if ((!paramBoolean2) && (this.jdField_d_of_type_Int == paramInt1) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0))
    {
      a(false);
      return;
    }
    int i1;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    for (;;)
    {
      paramInt1 = this.l;
      if ((i1 <= this.jdField_b_of_type_Int + paramInt1) && (i1 >= this.jdField_b_of_type_Int - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((auls)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Boolean = true;
        paramInt1 += 1;
      }
      i1 = paramInt1;
      if (paramInt1 >= this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount()) {
        i1 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.jdField_d_of_type_Int != i1) {
      paramBoolean2 = true;
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
  }
  
  public void a(aulw paramaulw)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramaulw);
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
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    for (;;)
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      this.jdField_a_of_type_Long = l1;
      return true;
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
    }
  }
  
  boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "pageScrolled() called with: xpos = [" + paramInt + "]");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      if (!this.jdField_i_of_type_Boolean) {}
    }
    auls localauls;
    do
    {
      do
      {
        return false;
        this.jdField_k_of_type_Boolean = false;
        a(0, 0.0F, 0);
      } while (this.jdField_k_of_type_Boolean);
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      localauls = a();
    } while (localauls == null);
    int i2 = d();
    int i3 = this.jdField_g_of_type_Int;
    float f1 = this.jdField_g_of_type_Int / i2;
    int i1 = localauls.jdField_a_of_type_Int;
    f1 = (paramInt / i2 - localauls.jdField_b_of_type_Float) / (localauls.jdField_a_of_type_Float + f1);
    paramInt = (int)((i3 + i2) * f1);
    this.jdField_k_of_type_Boolean = false;
    a(i1, f1, paramInt);
    if (!this.jdField_k_of_type_Boolean) {
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    return true;
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      }
    }
    do
    {
      return false;
      if (paramKeyEvent.hasModifiers(2)) {
        return c();
      }
      return b(17);
      if (paramKeyEvent.hasModifiers(2)) {
        return d();
      }
      return b(66);
      if (paramKeyEvent.hasNoModifiers()) {
        return b(2);
      }
    } while (!paramKeyEvent.hasModifiers(1));
    return b(1);
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      i1 = localViewGroup.getChildCount() - 1;
      if (i1 >= 0)
      {
        localView = localViewGroup.getChildAt(i1);
        if ((paramInt2 + i2 < localView.getLeft()) || (paramInt2 + i2 >= localView.getRight()) || (paramInt3 + i3 < localView.getTop()) || (paramInt3 + i3 >= localView.getBottom()) || (!a(localView, true, paramInt1, paramInt2 + i2 - localView.getLeft(), paramInt3 + i3 - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (paramView.canScrollHorizontally(-paramInt1)))
    {
      View localView;
      return true;
      i1 -= 1;
      break;
    }
    return false;
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
          auls localauls = a(localView);
          if ((localauls != null) && (localauls.jdField_a_of_type_Int == this.jdField_b_of_type_Int)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i1 += 1;
      }
    }
    if (((i3 == 262144) && (i2 != paramArrayList.size())) || (!isFocusable())) {}
    while (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
      return;
    }
    paramArrayList.add(this);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        auls localauls = a(localView);
        if ((localauls != null) && (localauls.jdField_a_of_type_Int == this.jdField_b_of_type_Int)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      MultiAIOBaseViewPager.LayoutParams localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)paramLayoutParams;
      localLayoutParams.jdField_a_of_type_Boolean |= a(paramView);
      if (this.jdField_c_of_type_Boolean)
      {
        if (localLayoutParams.jdField_a_of_type_Boolean) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localLayoutParams.jdField_b_of_type_Boolean = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  public int b()
  {
    return this.jdField_g_of_type_Int;
  }
  
  auls b(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return a(paramView);
  }
  
  public void b()
  {
    int i7 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount();
    this.jdField_e_of_type_Int = i7;
    int i1;
    int i2;
    int i3;
    int i5;
    int i4;
    label67:
    Object localObject;
    int i6;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() < this.l * 2 + 1) && (this.jdField_a_of_type_JavaUtilArrayList.size() < i7))
    {
      i1 = 1;
      i2 = this.jdField_b_of_type_Int;
      i3 = 0;
      i5 = 0;
      i4 = i1;
      i1 = i2;
      i2 = i3;
      i3 = i5;
      if (i3 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label299;
      }
      localObject = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i3);
      i5 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getItemPosition(((auls)localObject).jdField_a_of_type_JavaLangObject);
      if (i5 != -1) {
        break label157;
      }
      i5 = i3;
      i6 = i2;
      i3 = i4;
      i2 = i1;
      i1 = i6;
      i4 = i5;
    }
    for (;;)
    {
      i5 = i3;
      i6 = i2;
      i3 = i4 + 1;
      i2 = i1;
      i1 = i6;
      i4 = i5;
      break label67;
      i1 = 0;
      break;
      label157:
      if (i5 == -2)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i3);
        i4 = i3 - 1;
        i3 = i2;
        if (i2 == 0)
        {
          this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.startUpdate(this);
          i3 = 1;
        }
        this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.destroyItem(this, ((auls)localObject).jdField_a_of_type_Int, ((auls)localObject).jdField_a_of_type_JavaLangObject);
        if (this.jdField_b_of_type_Int == ((auls)localObject).jdField_a_of_type_Int)
        {
          i2 = Math.max(0, Math.min(this.jdField_b_of_type_Int, i7 - 1));
          i1 = i3;
          i3 = 1;
        }
      }
      else
      {
        if (((auls)localObject).jdField_a_of_type_Int != i5)
        {
          if (((auls)localObject).jdField_a_of_type_Int == this.jdField_b_of_type_Int) {
            i1 = i5;
          }
          ((auls)localObject).jdField_a_of_type_Int = i5;
          i5 = i1;
          i6 = 1;
          i4 = i3;
          i1 = i2;
          i2 = i5;
          i3 = i6;
          continue;
          label299:
          if (i2 != 0) {
            this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.finishUpdate(this);
          }
          Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, jdField_a_of_type_JavaUtilComparator);
          if (i4 != 0)
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
          return;
        }
        i5 = i1;
        i6 = i4;
        i4 = i3;
        i1 = i2;
        i2 = i5;
        i3 = i6;
        continue;
      }
      i2 = i1;
      i5 = 1;
      i1 = i3;
      i3 = i5;
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOBaseViewPager", 2, "populate() called with: newCurrentItem = [" + paramInt + "]");
    }
    Object localObject2;
    if (this.jdField_b_of_type_Int != paramInt)
    {
      localObject2 = a(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_Int = paramInt;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter == null) {
        d();
      }
      do
      {
        return;
        if (this.jdField_e_of_type_Boolean)
        {
          d();
          return;
        }
      } while (getWindowToken() == null);
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.startUpdate(this);
      paramInt = this.l;
      int i7 = Math.max(0, this.jdField_b_of_type_Int - paramInt);
      int i5 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount();
      int i6 = Math.min(i5 - 1, paramInt + this.jdField_b_of_type_Int);
      Object localObject1;
      if (i5 != this.jdField_e_of_type_Int) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.jdField_e_of_type_Int + ", found: " + i5 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject1 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (((auls)localObject1).jdField_a_of_type_Int >= this.jdField_b_of_type_Int) {
          if (((auls)localObject1).jdField_a_of_type_Int != this.jdField_b_of_type_Int) {
            break label1266;
          }
        }
      }
      for (;;)
      {
        if ((localObject1 == null) && (i5 > 0)) {}
        for (Object localObject3 = a(this.jdField_b_of_type_Int, paramInt);; localObject3 = localObject1)
        {
          int i4;
          label359:
          int i8;
          label372:
          int i1;
          float f3;
          int i3;
          int i2;
          Object localObject4;
          float f1;
          if (localObject3 != null)
          {
            i4 = paramInt - 1;
            if (i4 < 0) {
              break label640;
            }
            localObject1 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i4);
            i8 = d();
            if (i8 > 0) {
              break label646;
            }
            f2 = 0.0F;
            i1 = this.jdField_b_of_type_Int;
            f3 = 0.0F;
            i3 = i1 - 1;
            i2 = paramInt;
            localObject4 = localObject1;
            if (i3 >= 0)
            {
              if ((f3 < f2) || (i3 >= i7)) {
                break label801;
              }
              if (localObject4 != null) {
                break label667;
              }
            }
            f1 = ((auls)localObject3).jdField_a_of_type_Float;
            paramInt = i2 + 1;
            if (f1 < 2.0F)
            {
              if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
                break label921;
              }
              localObject1 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
              label459:
              if (i8 > 0) {
                break label927;
              }
            }
          }
          label640:
          label646:
          label667:
          label927:
          for (float f2 = 0.0F;; f2 = getPaddingRight() / i8 + 2.0F)
          {
            i1 = this.jdField_b_of_type_Int;
            i1 += 1;
            label478:
            if (i1 < i5)
            {
              if ((f1 < f2) || (i1 <= i6)) {
                break label1023;
              }
              if (localObject1 != null) {
                break label942;
              }
            }
            a((auls)localObject3, i2, (auls)localObject2);
            this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.setPrimaryItem(this, this.jdField_b_of_type_Int, ((auls)localObject3).jdField_a_of_type_JavaLangObject);
            this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.finishUpdate(this);
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
                  ((MultiAIOBaseViewPager.LayoutParams)localObject1).jdField_a_of_type_Float = ((auls)localObject2).jdField_a_of_type_Float;
                  ((MultiAIOBaseViewPager.LayoutParams)localObject1).jdField_b_of_type_Int = ((auls)localObject2).jdField_a_of_type_Int;
                }
              }
              paramInt += 1;
            }
            paramInt += 1;
            break;
            localObject1 = null;
            break label359;
            f2 = 2.0F - ((auls)localObject3).jdField_a_of_type_Float + getPaddingLeft() / i8;
            break label372;
            localObject1 = localObject4;
            paramInt = i4;
            f1 = f3;
            i1 = i2;
            if (i3 == localObject4.jdField_a_of_type_Int)
            {
              localObject1 = localObject4;
              paramInt = i4;
              f1 = f3;
              i1 = i2;
              if (!localObject4.jdField_a_of_type_Boolean)
              {
                this.jdField_a_of_type_JavaUtilArrayList.remove(i4);
                this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.destroyItem(this, i3, localObject4.jdField_a_of_type_JavaLangObject);
                paramInt = i4 - 1;
                i1 = i2 - 1;
                if (paramInt < 0) {
                  break label792;
                }
                localObject1 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
                f1 = f3;
              }
            }
            for (;;)
            {
              i3 -= 1;
              localObject4 = localObject1;
              i4 = paramInt;
              f3 = f1;
              i2 = i1;
              break;
              localObject1 = null;
              f1 = f3;
              continue;
              label801:
              if ((localObject4 != null) && (i3 == localObject4.jdField_a_of_type_Int))
              {
                f1 = f3 + localObject4.jdField_a_of_type_Float;
                paramInt = i4 - 1;
                if (paramInt >= 0)
                {
                  localObject1 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
                  i1 = i2;
                }
                else
                {
                  localObject1 = null;
                  i1 = i2;
                }
              }
              else
              {
                f1 = f3 + a(i3, i4 + 1).jdField_a_of_type_Float;
                i1 = i2 + 1;
                if (i4 >= 0)
                {
                  localObject1 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i4);
                  paramInt = i4;
                }
                else
                {
                  localObject1 = null;
                  paramInt = i4;
                }
              }
            }
            localObject1 = null;
            break label459;
          }
          label792:
          label921:
          label942:
          if ((i1 == ((auls)localObject1).jdField_a_of_type_Int) && (!((auls)localObject1).jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
            this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.destroyItem(this, i1, ((auls)localObject1).jdField_a_of_type_JavaLangObject);
            if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
              localObject1 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            }
          }
          for (;;)
          {
            i1 += 1;
            break label478;
            localObject1 = null;
            continue;
            label1023:
            if ((localObject1 != null) && (i1 == ((auls)localObject1).jdField_a_of_type_Int))
            {
              f3 = ((auls)localObject1).jdField_a_of_type_Float;
              paramInt += 1;
              if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {}
              for (localObject1 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);; localObject1 = null)
              {
                f1 += f3;
                break;
              }
            }
            localObject1 = a(i1, paramInt);
            paramInt += 1;
            f3 = ((auls)localObject1).jdField_a_of_type_Float;
            if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {}
            for (localObject1 = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);; localObject1 = null)
            {
              f1 += f3;
              break;
            }
            d();
            if (!hasFocus()) {
              break;
            }
            localObject1 = findFocus();
            if (localObject1 != null) {}
            for (localObject1 = b((View)localObject1);; localObject1 = null)
            {
              if ((localObject1 != null) && (((auls)localObject1).jdField_a_of_type_Int == this.jdField_b_of_type_Int)) {
                break label1254;
              }
              paramInt = 0;
              for (;;)
              {
                if (paramInt >= getChildCount()) {
                  break label1248;
                }
                localObject1 = getChildAt(paramInt);
                localObject2 = a((View)localObject1);
                if ((localObject2 != null) && (((auls)localObject2).jdField_a_of_type_Int == this.jdField_b_of_type_Int) && (((View)localObject1).requestFocus(2))) {
                  break;
                }
                paramInt += 1;
              }
              label1248:
              break;
            }
            label1254:
            break;
          }
        }
        label1266:
        localObject1 = null;
      }
      localObject2 = null;
    }
  }
  
  public void b(aulw paramaulw)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramaulw);
    }
  }
  
  public boolean b()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public boolean b(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int i2;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label328;
      }
      if (paramInt != 17) {
        break label265;
      }
      i1 = a(this.jdField_a_of_type_AndroidGraphicsRect, localView).left;
      i2 = a(this.jdField_a_of_type_AndroidGraphicsRect, (View)localObject).left;
      if ((localObject != null) && (i1 >= i2))
      {
        bool = c();
        label89:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label374;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label381;
      }
      if (localObject != this) {}
    }
    label265:
    label328:
    label374:
    label381:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        Log.e("MultiAIOBaseViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label89;
        if (paramInt == 66)
        {
          i1 = a(this.jdField_a_of_type_AndroidGraphicsRect, localView).left;
          i2 = a(this.jdField_a_of_type_AndroidGraphicsRect, (View)localObject).left;
          if ((localObject != null) && (i1 <= i2))
          {
            bool = d();
            break label89;
          }
          bool = localView.requestFocus();
          break label89;
          if ((paramInt == 17) || (paramInt == 1))
          {
            bool = c();
            break label89;
          }
          if ((paramInt == 66) || (paramInt == 2))
          {
            bool = d();
            break label89;
          }
        }
        bool = false;
        break label89;
      }
      localObject = localView;
      break;
    }
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
    auls localauls = a();
    if (localauls == null) {
      return;
    }
    a(a(localauls.jdField_a_of_type_Int, (i2 / i1 - localauls.jdField_b_of_type_Float) / localauls.jdField_a_of_type_Float, paramInt, this.r - 1), true, true, paramInt);
  }
  
  boolean c()
  {
    if (this.jdField_b_of_type_Int > 0)
    {
      setCurrentItem(this.jdField_b_of_type_Int - 1, true);
      return true;
    }
    return false;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter == null) {}
    int i1;
    int i2;
    do
    {
      return false;
      i1 = d();
      i2 = getScrollX();
      if (paramInt < 0)
      {
        if (i2 > (int)(i1 * this.jdField_a_of_type_Float)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (paramInt <= 0);
    if (i2 < (int)(i1 * this.jdField_b_of_type_Float)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
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
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      for (;;)
      {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          View localView = getChildAt(i1);
          this.jdField_b_of_type_JavaUtilArrayList.add(localView);
          i1 += 1;
        }
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
      Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aumb);
    }
  }
  
  boolean d()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() - 1))
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
    boolean bool2 = false;
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool1;
    }
    int i2 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= i2) {
        break;
      }
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        auls localauls = a(localView);
        if ((localauls != null) && (localauls.jdField_a_of_type_Int == this.jdField_b_of_type_Int) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i1 += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i3 = 0;
    int i1 = 0;
    int i4 = getOverScrollMode();
    boolean bool;
    if ((i4 == 0) || ((i4 == 1) && (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) && (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() > 1)))
    {
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
    }
    for (;;)
    {
      if (bool) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetEdgeEffect.finish();
      this.jdField_b_of_type_AndroidWidgetEdgeEffect.finish();
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
    if (!this.jdField_h_of_type_Boolean) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null)
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
      a(((auls)localObject).jdField_a_of_type_Int, (i3 / i2 - ((auls)localObject).jdField_b_of_type_Float) / ((auls)localObject).jdField_a_of_type_Float, i1, (int)(this.jdField_c_of_type_Float - this.jdField_e_of_type_Float));
    }
    h();
    this.jdField_h_of_type_Boolean = false;
  }
  
  protected boolean e()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_AndroidWidgetScroller != null) {
      this.jdField_b_of_type_AndroidWidgetScroller.abortAnimation();
    }
  }
  
  public boolean f()
  {
    if (this.jdField_b_of_type_AndroidWidgetScroller != null) {
      return this.jdField_b_of_type_AndroidWidgetScroller.isFinished();
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
    if ((this.jdField_b_of_type_AndroidWidgetScroller != null) && (!this.jdField_b_of_type_AndroidWidgetScroller.isFinished())) {
      this.jdField_b_of_type_AndroidWidgetScroller.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i3;
    int i4;
    float f3;
    Object localObject;
    float f1;
    int i5;
    int i1;
    int i6;
    int i2;
    if ((this.jdField_g_of_type_Int > 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null))
    {
      i3 = getScrollX();
      i4 = getWidth();
      f3 = this.jdField_g_of_type_Int / i4;
      localObject = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      f1 = ((auls)localObject).jdField_b_of_type_Float;
      i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
      i1 = ((auls)localObject).jdField_a_of_type_Int;
      i6 = ((auls)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1)).jdField_a_of_type_Int;
      i2 = 0;
    }
    for (;;)
    {
      float f2;
      if (i1 < i6)
      {
        while ((i1 > ((auls)localObject).jdField_a_of_type_Int) && (i2 < i5))
        {
          localObject = this.jdField_a_of_type_JavaUtilArrayList;
          i2 += 1;
          localObject = (auls)((ArrayList)localObject).get(i2);
        }
        if (i1 != ((auls)localObject).jdField_a_of_type_Int) {
          break label271;
        }
        f2 = (((auls)localObject).jdField_b_of_type_Float + ((auls)localObject).jdField_a_of_type_Float) * i4;
      }
      label271:
      float f4;
      for (f1 = ((auls)localObject).jdField_b_of_type_Float + ((auls)localObject).jdField_a_of_type_Float + f3;; f1 += f4 + f3)
      {
        if (this.jdField_g_of_type_Int + f2 > i3)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(Math.round(f2), this.jdField_h_of_type_Int, Math.round(this.jdField_g_of_type_Int + f2), this.jdField_i_of_type_Int);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
        if (f2 <= i3 + i4) {
          break;
        }
        return;
        f4 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(i1);
        f2 = (f1 + f4) * i4;
      }
      i1 += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 == 3) || (i1 == 1)) {
      g();
    }
    do
    {
      return false;
      if (i1 == 0) {
        break;
      }
      if (this.jdField_f_of_type_Boolean) {
        return true;
      }
    } while (this.jdField_g_of_type_Boolean);
    switch (i1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      return this.jdField_f_of_type_Boolean;
      i1 = this.p;
      if (i1 != -1)
      {
        i1 = paramMotionEvent.findPointerIndex(i1);
        if ((i1 >= 0) && (i1 <= paramMotionEvent.getPointerCount() - 1))
        {
          float f1 = this.jdField_c_of_type_Float;
          try
          {
            f2 = paramMotionEvent.getX(i1);
            f1 = f2;
            f4 = f1 - this.jdField_c_of_type_Float;
            f5 = Math.abs(f4);
            f2 = this.jdField_d_of_type_Float;
          }
          catch (Exception localException1)
          {
            try
            {
              f3 = paramMotionEvent.getY(i1);
              f2 = f3;
              f3 = Math.abs(f2 - this.jdField_f_of_type_Float);
              if ((f4 != 0.0F) && (!a(this.jdField_c_of_type_Float, f4)) && (a(this, false, (int)f4, (int)f1, (int)f2)))
              {
                this.jdField_c_of_type_Float = f1;
                this.jdField_d_of_type_Float = f2;
                this.jdField_g_of_type_Boolean = true;
                return false;
                localException1 = localException1;
                QLog.e("MultiAIOBaseViewPager", 1, "onInterceptTouchEvent: ", localException1);
              }
            }
            catch (Exception localException2)
            {
              float f2;
              float f4;
              float f5;
              float f3;
              for (;;)
              {
                QLog.e("MultiAIOBaseViewPager", 1, "onInterceptTouchEvent: ", localException2);
              }
              if ((f5 > this.o) && (0.5F * f5 > f3))
              {
                this.jdField_f_of_type_Boolean = true;
                d(true);
                a(1);
                if (f4 > 0.0F)
                {
                  f3 = this.jdField_e_of_type_Float + this.o;
                  label349:
                  this.jdField_c_of_type_Float = f3;
                  this.jdField_d_of_type_Float = f2;
                  a(true);
                }
              }
              while ((this.jdField_f_of_type_Boolean) && (a(f1)))
              {
                ViewCompat.postInvalidateOnAnimation(this);
                break;
                f3 = this.jdField_e_of_type_Float - this.o;
                break label349;
                if (f3 > this.o) {
                  this.jdField_g_of_type_Boolean = true;
                }
              }
            }
          }
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
          if ((this.w == 2) && (Math.abs(this.jdField_b_of_type_AndroidWidgetScroller.getFinalX() - this.jdField_b_of_type_AndroidWidgetScroller.getCurrX()) > this.s))
          {
            i1 = 1;
            label514:
            if (this.jdField_a_of_type_Aulr != null) {
              if (this.jdField_a_of_type_Aulr.a()) {
                break label597;
              }
            }
          }
          label597:
          for (i1 = 1;; i1 = 0)
          {
            if (i1 == 0) {
              break label603;
            }
            this.jdField_b_of_type_AndroidWidgetScroller.abortAnimation();
            if (this.jdField_a_of_type_Aulr != null) {
              this.jdField_a_of_type_Aulr.a();
            }
            this.jdField_e_of_type_Boolean = false;
            c();
            this.jdField_f_of_type_Boolean = true;
            d(true);
            a(1);
            break;
            i1 = 0;
            break label514;
          }
          label603:
          b(false);
          this.jdField_f_of_type_Boolean = false;
          continue;
          a(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i6 = getChildCount();
    int i8 = paramInt3 - paramInt1;
    int i7 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i1 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i9 = getScrollX();
    int i2 = 0;
    int i4 = 0;
    View localView;
    MultiAIOBaseViewPager.LayoutParams localLayoutParams;
    int i10;
    int i3;
    label154:
    int i5;
    if (i4 < i6)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() == 8) {
        break label671;
      }
      localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.jdField_a_of_type_Boolean) {
        break label671;
      }
      paramInt4 = localLayoutParams.jdField_a_of_type_Int;
      i10 = localLayoutParams.jdField_a_of_type_Int;
      switch (paramInt4 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt4 = paramInt2;
        i3 = paramInt2;
        switch (i10 & 0x70)
        {
        default: 
          i5 = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = i5;
          label204:
          paramInt4 += i9;
          localView.layout(paramInt4, paramInt3, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt3);
          i2 += 1;
          paramInt4 = i1;
          paramInt3 = i3;
          i1 = paramInt1;
          paramInt1 = i2;
        }
        break;
      }
    }
    for (;;)
    {
      i4 += 1;
      i3 = paramInt3;
      i2 = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i1;
      i1 = paramInt4;
      paramInt2 = i3;
      break;
      i3 = localView.getMeasuredWidth();
      paramInt4 = paramInt2;
      i3 += paramInt2;
      break label154;
      paramInt4 = Math.max((i8 - localView.getMeasuredWidth()) / 2, paramInt2);
      i3 = paramInt2;
      break label154;
      i3 = localView.getMeasuredWidth();
      paramInt4 = i1 + localView.getMeasuredWidth();
      i5 = i8 - i1 - i3;
      i1 = paramInt4;
      i3 = paramInt2;
      paramInt4 = i5;
      break label154;
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      i5 += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i5;
      break label204;
      i5 = Math.max((i7 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i5;
      break label204;
      i5 = i7 - paramInt3 - localView.getMeasuredHeight();
      i10 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i10;
      paramInt3 = i5;
      break label204;
      i1 = i8 - paramInt2 - i1;
      paramInt4 = 0;
      while (paramInt4 < i6)
      {
        localView = getChildAt(paramInt4);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.jdField_a_of_type_Boolean)
          {
            auls localauls = a(localView);
            if (localauls != null)
            {
              float f1 = i1;
              i3 = (int)(localauls.jdField_b_of_type_Float * f1) + paramInt2;
              if (localLayoutParams.jdField_b_of_type_Boolean)
              {
                localLayoutParams.jdField_b_of_type_Boolean = false;
                f1 = i1;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.jdField_a_of_type_Float * f1), 1073741824), View.MeasureSpec.makeMeasureSpec(i7 - paramInt1 - paramInt3, 1073741824));
              }
              localView.layout(i3, paramInt1, localView.getMeasuredWidth() + i3, localView.getMeasuredHeight() + paramInt1);
            }
          }
        }
        paramInt4 += 1;
      }
      this.jdField_h_of_type_Int = paramInt1;
      this.jdField_i_of_type_Int = (i7 - paramInt3);
      this.t = i2;
      if (this.jdField_i_of_type_Boolean) {
        a(this.jdField_b_of_type_Int, false, 0, false);
      }
      this.jdField_i_of_type_Boolean = false;
      return;
      label671:
      paramInt4 = i2;
      i2 = paramInt1;
      i3 = paramInt2;
      paramInt1 = paramInt4;
      paramInt4 = i1;
      i1 = paramInt3;
      paramInt2 = i2;
      paramInt3 = i3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.n = Math.min(paramInt1 / 10, this.m);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i9 = getChildCount();
    int i3 = 0;
    View localView;
    int i1;
    int i2;
    MultiAIOBaseViewPager.LayoutParams localLayoutParams;
    int i4;
    int i6;
    label183:
    int i5;
    if (i3 < i9)
    {
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
            i4 = localLayoutParams.jdField_a_of_type_Int & 0x70;
            i6 = -2147483648;
            i2 = -2147483648;
            if ((i4 != 48) && (i4 != 80)) {
              break label333;
            }
            i4 = 1;
            if ((i1 != 3) && (i1 != 5)) {
              break label339;
            }
            i5 = 1;
            label198:
            if (i4 == 0) {
              break label345;
            }
            i1 = 1073741824;
            label208:
            if (localLayoutParams.width == -2) {
              break label538;
            }
            i6 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label532;
            }
            i1 = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i8;
      if (localLayoutParams.height != -2)
      {
        i7 = 1073741824;
        i2 = i7;
        if (localLayoutParams.height != -1)
        {
          i8 = localLayoutParams.height;
          i2 = i7;
        }
      }
      for (int i7 = i8;; i7 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i1, i6), View.MeasureSpec.makeMeasureSpec(i7, i2));
        if (i4 != 0)
        {
          i2 = paramInt2 - localView.getMeasuredHeight();
          i1 = paramInt1;
        }
        for (;;)
        {
          i3 += 1;
          paramInt1 = i1;
          paramInt2 = i2;
          break;
          label333:
          i4 = 0;
          break label183;
          label339:
          i5 = 0;
          break label198;
          label345:
          i1 = i6;
          if (i5 == 0) {
            break label208;
          }
          i2 = 1073741824;
          i1 = i6;
          break label208;
          i1 = paramInt1;
          i2 = paramInt2;
          if (i5 != 0)
          {
            i1 = paramInt1 - localView.getMeasuredWidth();
            i2 = paramInt2;
          }
        }
        this.jdField_j_of_type_Int = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.jdField_k_of_type_Int = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.jdField_c_of_type_Boolean = true;
        c();
        this.jdField_c_of_type_Boolean = false;
        i1 = getChildCount();
        paramInt2 = 0;
        if (paramInt2 < i1)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (MultiAIOBaseViewPager.LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams == null) || (!localLayoutParams.jdField_a_of_type_Boolean)) {
              if (localLayoutParams == null) {
                break label521;
              }
            }
          }
        }
        label521:
        for (float f1 = localLayoutParams.jdField_a_of_type_Float;; f1 = 0.0F)
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(f1 * paramInt1), 1073741824), this.jdField_k_of_type_Int);
          paramInt2 += 1;
          break;
          return;
        }
      }
      label532:
      i1 = paramInt1;
      continue;
      label538:
      i6 = i1;
      i1 = paramInt1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i3 = -1;
    int i2 = getChildCount();
    int i1;
    if ((paramInt & 0x2) != 0)
    {
      i3 = 1;
      i1 = 0;
    }
    while (i1 != i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        auls localauls = a(localView);
        if ((localauls != null) && (localauls.jdField_a_of_type_Int == this.jdField_b_of_type_Int) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i1 = i2 - 1;
          i2 = -1;
          continue;
        }
      }
      i1 += i3;
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
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null)
    {
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.restoreState(paramParcelable.jdField_a_of_type_AndroidOsParcelable, paramParcelable.jdField_a_of_type_JavaLangClassLoader);
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
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) {
      localSavedState.jdField_a_of_type_AndroidOsParcelable = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      a(paramInt1, paramInt3, this.jdField_g_of_type_Int, this.jdField_g_of_type_Int);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    int i1 = 0;
    boolean bool2 = false;
    if (this.jdField_h_of_type_Boolean) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (paramMotionEvent.getAction() != 0) {
            break;
          }
          bool1 = bool2;
        } while (paramMotionEvent.getEdgeFlags() != 0);
        bool1 = bool2;
      } while (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter == null);
      bool1 = bool2;
    } while (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() == 0);
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    boolean bool1 = bool3;
    label144:
    float f1;
    float f2;
    label336:
    Object localObject;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = bool3;
    case 4: 
    case 0: 
    case 2: 
      label375:
      do
      {
        for (;;)
        {
          if (bool1) {
            ViewCompat.postInvalidateOnAnimation(this);
          }
          return true;
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
          bool1 = bool3;
          continue;
          if (this.jdField_f_of_type_Boolean) {
            break label375;
          }
          i1 = paramMotionEvent.findPointerIndex(this.p);
          if (i1 != -1) {
            break;
          }
          bool1 = g();
        }
        f1 = paramMotionEvent.getX(i1);
        float f3 = Math.abs(f1 - this.jdField_c_of_type_Float);
        f2 = paramMotionEvent.getY(i1);
        float f4 = Math.abs(f2 - this.jdField_d_of_type_Float);
        if ((f3 > this.o) && (f3 > f4))
        {
          this.jdField_f_of_type_Boolean = true;
          d(true);
          if (f1 - this.jdField_e_of_type_Float <= 0.0F) {
            break;
          }
          f1 = this.jdField_e_of_type_Float + this.o;
          this.jdField_c_of_type_Float = f1;
          this.jdField_d_of_type_Float = f2;
          a(1);
          a(true);
          localObject = getParent();
          if (localObject != null) {
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
          }
        }
        bool1 = bool3;
      } while (!this.jdField_f_of_type_Boolean);
      i1 = paramMotionEvent.findPointerIndex(this.p);
      if (i1 == -1) {
        break;
      }
    }
    for (bool1 = a(paramMotionEvent.getX(i1)) | false;; bool1 = false)
    {
      for (;;)
      {
        for (;;)
        {
          break label144;
          f1 = this.jdField_e_of_type_Float - this.o;
          break label336;
          bool1 = bool3;
          if (!this.jdField_f_of_type_Boolean) {
            break label144;
          }
          localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.jdField_c_of_type_Int);
          int i2 = (int)((VelocityTracker)localObject).getXVelocity(this.p);
          this.jdField_e_of_type_Boolean = true;
          int i4 = d();
          int i5 = getScrollX();
          localObject = a();
          bool1 = bool2;
          if (localObject == null) {
            break;
          }
          f1 = this.jdField_g_of_type_Int / i4;
          int i3 = ((auls)localObject).jdField_a_of_type_Int;
          f2 = (i5 / i4 - ((auls)localObject).jdField_b_of_type_Float) / (((auls)localObject).jdField_a_of_type_Float + f1);
          i4 = paramMotionEvent.findPointerIndex(this.p);
          f1 = this.jdField_c_of_type_Float;
          if (i4 != -1) {
            f1 = paramMotionEvent.getX(i4);
          }
          i4 = (int)(f1 - this.jdField_e_of_type_Float);
          if ((Math.abs(i4) > this.r * 4) && (Math.abs(i2) > this.q)) {
            i1 = 1;
          }
          for (;;)
          {
            bool1 = g();
            if ((i1 != 0) && (this.jdField_a_of_type_Aulr != null)) {
              this.jdField_a_of_type_Aulr.a(i2);
            }
            break;
            a(a(i3, f2, i2, i4), true, true, i2);
          }
          bool1 = bool3;
          if (!this.jdField_f_of_type_Boolean) {
            break label144;
          }
          a(this.jdField_b_of_type_Int, true, 0, false);
          bool1 = g();
          break label144;
          i1 = paramMotionEvent.getActionIndex();
          try
          {
            this.jdField_c_of_type_Float = paramMotionEvent.getX(i1);
            this.p = paramMotionEvent.getPointerId(i1);
            bool1 = bool3;
          }
          catch (Exception paramMotionEvent)
          {
            QLog.e("MultiAIOBaseViewPager", 1, "onTouchEvent: ", paramMotionEvent);
            bool1 = bool3;
          }
        }
        break label144;
        a(paramMotionEvent);
        i1 = paramMotionEvent.findPointerIndex(this.p);
        try
        {
          this.jdField_c_of_type_Float = paramMotionEvent.getX(i1);
          bool1 = bool3;
        }
        catch (Exception paramMotionEvent)
        {
          QLog.e("MultiAIOBaseViewPager", 1, "onTouchEvent: ", paramMotionEvent);
          bool1 = bool3;
        }
      }
      break label144;
    }
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
    int i2 = 0;
    int i1;
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null)
    {
      a(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter, null);
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.startUpdate(this);
      i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject = (auls)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.destroyItem(this, ((auls)localObject).jdField_a_of_type_Int, ((auls)localObject).jdField_a_of_type_JavaLangObject);
        i1 += 1;
      }
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.finishUpdate(this);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      g();
      this.jdField_b_of_type_Int = 0;
      this.jdField_d_of_type_Int = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = paramPagerAdapter;
    this.jdField_e_of_type_Int = 0;
    boolean bool;
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null)
    {
      if (this.jdField_a_of_type_Auly == null) {
        this.jdField_a_of_type_Auly = new auly(this);
      }
      a(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter, this.jdField_a_of_type_Auly);
      this.jdField_e_of_type_Boolean = false;
      bool = this.jdField_i_of_type_Boolean;
      this.jdField_i_of_type_Boolean = true;
      this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount();
      if (this.jdField_f_of_type_Int < 0) {
        break label305;
      }
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.restoreState(this.jdField_a_of_type_AndroidOsParcelable, this.jdField_a_of_type_JavaLangClassLoader);
      a(this.jdField_f_of_type_Int, false, true);
      this.jdField_f_of_type_Int = -1;
      this.jdField_a_of_type_AndroidOsParcelable = null;
      this.jdField_a_of_type_JavaLangClassLoader = null;
    }
    while ((this.jdField_b_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_JavaUtilList.isEmpty()))
    {
      int i3 = this.jdField_b_of_type_JavaUtilList.size();
      i1 = i2;
      while (i1 < i3)
      {
        ((aulv)this.jdField_b_of_type_JavaUtilList.get(i1)).a(this, (PagerAdapter)localObject, paramPagerAdapter);
        i1 += 1;
      }
      label305:
      if (!bool) {
        c();
      } else {
        requestLayout();
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_e_of_type_Boolean = false;
    if (!this.jdField_i_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
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
  
  public void setFlingListener(aulr paramaulr)
  {
    this.jdField_a_of_type_Aulr = paramaulr;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 1)
    {
      Log.w("MultiAIOBaseViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 1);
      i1 = 1;
    }
    if (i1 != this.l)
    {
      this.l = i1;
      c();
    }
  }
  
  @Deprecated
  public void setOnPageChangeListener(aulw paramaulw)
  {
    this.jdField_a_of_type_Aulw = paramaulw;
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
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }
  
  public void setPageTransformer(boolean paramBoolean, aulx paramaulx)
  {
    setPageTransformer(paramBoolean, paramaulx, 2);
  }
  
  public void setPageTransformer(boolean paramBoolean, aulx paramaulx, int paramInt)
  {
    int i2 = 1;
    boolean bool1;
    boolean bool2;
    label20:
    int i1;
    if (paramaulx != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Aulx == null) {
        break label80;
      }
      bool2 = true;
      if (bool1 == bool2) {
        break label86;
      }
      i1 = 1;
      label30:
      this.jdField_a_of_type_Aulx = paramaulx;
      setChildrenDrawingOrderEnabled(bool1);
      if (!bool1) {
        break label92;
      }
      if (paramBoolean) {
        i2 = 2;
      }
      this.v = i2;
      this.u = paramInt;
    }
    for (;;)
    {
      if (i1 != 0) {
        c();
      }
      return;
      bool1 = false;
      break;
      label80:
      bool2 = false;
      break label20;
      label86:
      i1 = 0;
      break label30;
      label92:
      this.v = 0;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager
 * JD-Core Version:    0.7.0.1
 */