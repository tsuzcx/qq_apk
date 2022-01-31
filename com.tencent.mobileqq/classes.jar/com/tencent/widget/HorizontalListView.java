package com.tencent.widget;

import amby;
import ambz;
import amca;
import amcb;
import amcc;
import amcd;
import amce;
import amcf;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListView
  extends AdapterView
{
  public static final boolean a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private amcb jdField_a_of_type_Amcb;
  private amce jdField_a_of_type_Amce;
  amcf jdField_a_of_type_Amcf;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ContextMenu.ContextMenuInfo jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  public ListAdapter a;
  private HorizontalListView.OnItemScrollEventListener jdField_a_of_type_ComTencentWidgetHorizontalListView$OnItemScrollEventListener;
  private HorizontalListView.OnScrollLinstener jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollLinstener;
  private HorizontalListView.OnScrollStateChangedListener jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener;
  private HorizontalListView.RecycleListener jdField_a_of_type_ComTencentWidgetHorizontalListView$RecycleListener;
  private HorizontalListView.RunningOutOfDataListener jdField_a_of_type_ComTencentWidgetHorizontalListView$RunningOutOfDataListener;
  public OverScroller a;
  private Integer jdField_a_of_type_JavaLangInteger;
  public Runnable a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  public boolean b;
  private int jdField_c_of_type_Int = -1;
  private Runnable jdField_c_of_type_JavaLangRunnable;
  public boolean c;
  public int d;
  private Runnable d;
  public boolean d;
  public int e;
  private Runnable jdField_e_of_type_JavaLangRunnable = new amby(this);
  private boolean jdField_e_of_type_Boolean;
  protected int f;
  private boolean f;
  public int g;
  private boolean g;
  public int h;
  public int i = 2147483647;
  public int j;
  public int k;
  public int l;
  public int m;
  protected int n = 4097;
  public int o;
  public int p = -1;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public HorizontalListView(Context paramContext)
  {
    this(paramContext, null, false);
  }
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, false);
  }
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_d_of_type_Int = 50;
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(0);
    }
    b(paramBoolean);
    ViewCompat.setImportantForAccessibility(this, 1);
  }
  
  private int a()
  {
    return getHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetListAdapter;
    if (localObject == null) {
      paramInt1 = getPaddingLeft() + getPaddingRight();
    }
    int i1;
    int i3;
    label87:
    do
    {
      return paramInt1;
      int i4 = getPaddingLeft() + getPaddingRight();
      if ((this.jdField_f_of_type_Int <= 0) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
        break;
      }
      i1 = this.jdField_f_of_type_Int;
      paramInt4 = i4;
      i3 = paramInt1;
      int i2 = paramInt2;
      if (paramInt2 == -1)
      {
        i2 = ((ListAdapter)localObject).getCount() - 1;
        i3 = paramInt1;
        paramInt4 = i4;
      }
      if (i3 > i2) {
        break label193;
      }
      localObject = c(i3);
      if (localObject == null) {
        break label170;
      }
      a((View)localObject);
      paramInt1 = paramInt4;
      if (i3 > 0) {
        paramInt1 = paramInt4 + i1;
      }
      paramInt2 = paramInt1 + ((View)localObject).getMeasuredWidth();
      a(i3, (View)localObject);
      paramInt1 = paramInt3;
    } while (paramInt2 > paramInt3);
    paramInt1 = paramInt2;
    for (;;)
    {
      i3 += 1;
      paramInt4 = paramInt1;
      break label87;
      i1 = 0;
      break;
      label170:
      paramInt1 = paramInt4;
      if (QLog.isColorLevel())
      {
        QLog.i("HorizontalListView", 2, "measureWidthOfChildren obtainView is null");
        paramInt1 = paramInt4;
      }
    }
    label193:
    return paramInt4;
  }
  
  private View a(int paramInt, boolean paramBoolean)
  {
    View localView1 = a(paramInt);
    setTag(2131362520, Boolean.valueOf(paramBoolean));
    View localView2 = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt, localView1, this);
    b(localView2, paramInt);
    if ((localView1 != null) && (localView2 != localView1)) {
      a(paramInt, localView1);
    }
    if (localView2 != null) {
      c(localView2, paramInt);
    }
    return localView2;
  }
  
  private ViewGroup.LayoutParams a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (localLayoutParams == null) {
      paramView = new ViewGroup.LayoutParams(-2, -1);
    }
    return paramView;
  }
  
  private void a()
  {
    int i1 = getFirstVisiblePosition();
    int i2 = getLastVisiblePosition();
    while ((i1 >= 0) && (i1 <= i2))
    {
      View localView = b(i1);
      if (localView != null)
      {
        if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView$RecycleListener != null) {
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView$RecycleListener.a(localView);
        }
        a(i1, localView);
      }
      i1 += 1;
    }
  }
  
  private void a(float paramFloat, int paramInt)
  {
    int i3 = this.i;
    int i4 = this.j;
    int i1 = getOverScrollMode();
    int i7;
    int i5;
    int i6;
    int i2;
    if ((i1 == 0) || ((i1 == 1) && (i3 > 0)))
    {
      i1 = 1;
      i7 = getScrollX() + this.h;
      i5 = this.h;
      i6 = i7 + paramInt;
      if (i7 >= i4)
      {
        i2 = paramInt;
        if (i7 <= i3) {}
      }
      else
      {
        i2 = b(paramInt, i3);
      }
      if ((i1 == 0) || ((i6 >= i4) && (i6 <= i3))) {
        break label204;
      }
      if (i6 >= i4) {
        break label190;
      }
      paramInt = i6 - getScrollX() - i4;
      label118:
      i1 = getWidth();
      i2 = this.jdField_d_of_type_Int;
      overScrollBy(paramInt, 0, getScrollX(), 0, 0, 0, i1 - i2, 0, true);
      label149:
      if (i6 >= i4) {
        break label231;
      }
      this.h = i4;
    }
    for (;;)
    {
      if (i5 != this.h)
      {
        c();
        requestLayout();
      }
      this.jdField_a_of_type_Float = paramFloat;
      return;
      i1 = 0;
      break;
      label190:
      paramInt = i6 - getScrollX() - i3;
      break label118;
      label204:
      if (i7 != i5) {
        scrollTo(0, 0);
      }
      this.h += i2;
      break label149;
      label231:
      if (i6 > i3) {
        this.h = i3;
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    int i2 = getChildCount();
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    this.jdField_a_of_type_AndroidGraphicsRect.top = getPaddingTop();
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = (this.jdField_a_of_type_AndroidGraphicsRect.top + a());
    int i1 = 0;
    while (i1 < i2)
    {
      if ((i1 != i2 - 1) || (!a(this.l)))
      {
        View localView = getChildAt(i1);
        localRect.left = localView.getRight();
        localRect.right = (localView.getRight() + this.jdField_f_of_type_Int);
        if (localRect.left < getPaddingLeft()) {
          localRect.left = getPaddingLeft();
        }
        if (localRect.right > getWidth() - getPaddingRight()) {
          localRect.right = (getWidth() - getPaddingRight());
        }
        a(paramCanvas, localRect);
        if ((i1 == 0) && (localView.getLeft() > getPaddingLeft()))
        {
          localRect.left = getPaddingLeft();
          localRect.right = localView.getLeft();
          a(paramCanvas, localRect);
        }
      }
      i1 += 1;
    }
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramRect);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (paramMotionEvent.getPointerId(i1) == this.jdField_c_of_type_Int) {
      if (i1 != 0) {
        break label83;
      }
    }
    label83:
    for (i1 = 1;; i1 = 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getX(i1);
      this.jdField_c_of_type_Int = paramMotionEvent.getPointerId(i1);
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      }
      this.t = ((int)paramMotionEvent.getX(i1));
      this.u = ((int)paramMotionEvent.getY(i1));
      return;
    }
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = a(paramView);
    int i2 = ViewGroup.getChildMeasureSpec(this.jdField_b_of_type_Int, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    if (localLayoutParams.width > 0) {}
    for (int i1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);; i1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i1, i2);
      return;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      int i1 = getScrollX();
      View localView1;
      if (this.jdField_d_of_type_Boolean)
      {
        localView1 = getChildAt(getChildCount() - 1);
        if (!this.jdField_d_of_type_Boolean) {
          break label97;
        }
      }
      label97:
      for (View localView2 = getChildAt(0);; localView2 = getChildAt(getChildCount() - 1))
      {
        if ((paramInt1 < localView1.getLeft() - i1) || (paramInt2 < localView1.getTop()) || (paramInt1 >= localView2.getRight() - i1) || (paramInt2 >= localView2.getBottom())) {
          break label112;
        }
        return true;
        localView1 = getChildAt(0);
        break;
      }
      label112:
      return false;
    }
    return false;
  }
  
  private int b()
  {
    return getWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int i2 = getScrollX();
    int i1 = i2;
    if (getScrollX() > 0)
    {
      i1 = i2;
      if (getScrollX() > paramInt2) {
        i1 = getScrollX() - paramInt2;
      }
    }
    paramInt2 = getWidth();
    if (paramInt1 * i1 < 0) {}
    while (paramInt2 == 0) {
      return paramInt1;
    }
    return (paramInt2 - Math.abs(i1)) * paramInt1 / paramInt2 / 2;
  }
  
  private void b()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      a(getChildAt(i1));
      i1 += 1;
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    int i1 = 0;
    while (i1 < paramInt)
    {
      this.jdField_a_of_type_JavaUtilList.add(new LinkedList());
      i1 += 1;
    }
  }
  
  private void b(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView != paramView)
    {
      c();
      this.jdField_a_of_type_AndroidViewView = paramView;
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setPressed(true);
    }
    setPressed(true);
  }
  
  private void b(View paramView, int paramInt)
  {
    try
    {
      paramInt = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt);
      if ((paramView != null) && (b(paramInt))) {
        paramView.setTag(2131433004, Integer.valueOf(paramInt));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        paramInt = -1;
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size());
  }
  
  private View c(int paramInt)
  {
    View localView1 = a(paramInt);
    setTag(2131362520, Boolean.valueOf(true));
    View localView2 = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt, localView1, this);
    b(localView2, paramInt);
    if ((localView1 != null) && (localView2 != localView1)) {
      a(paramInt, localView1);
    }
    if (localView2 != null) {
      c(localView2, paramInt);
    }
    return localView2;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setPressed(false);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    setPressed(false);
  }
  
  private void c(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = generateDefaultLayoutParams();
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams1);
      return;
      localLayoutParams1 = localLayoutParams2;
      if (!checkLayoutParams(localLayoutParams2)) {
        localLayoutParams1 = generateLayoutParams(localLayoutParams2);
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      return;
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void g()
  {
    if (jdField_a_of_type_Boolean) {
      a("checkSpringback", new Object[] { Integer.valueOf(this.p) });
    }
    if (this.jdField_d_of_type_JavaLangRunnable == null) {
      this.jdField_d_of_type_JavaLangRunnable = new amca(this);
    }
    removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    getHandler().post(this.jdField_d_of_type_JavaLangRunnable);
  }
  
  private void h()
  {
    this.jdField_f_of_type_Boolean = false;
    f();
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView$RunningOutOfDataListener != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.getCount() - (this.l + 1) < this.jdField_a_of_type_Int) && (!this.jdField_e_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView$RunningOutOfDataListener.a();
    }
  }
  
  public float a()
  {
    return 0.005F;
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.jdField_b_of_type_AndroidGraphicsRect;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
      localObject1 = this.jdField_b_of_type_AndroidGraphicsRect;
    }
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      localObject2 = getChildAt(i1);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return getFirstVisiblePosition() + i1;
        }
      }
      i1 -= 1;
    }
    return -1;
  }
  
  ContextMenu.ContextMenuInfo a(View paramView, int paramInt, long paramLong)
  {
    return new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
  }
  
  protected View a(int paramInt)
  {
    int i1 = -1;
    try
    {
      paramInt = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt);
      if (b(paramInt)) {
        return (View)((Queue)this.jdField_a_of_type_JavaUtilList.get(paramInt)).poll();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        paramInt = i1;
      }
    }
    return null;
  }
  
  public ListAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter;
  }
  
  public void a(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    View localView;
    if (this.jdField_d_of_type_Boolean)
    {
      if ((paramInt1 + paramInt2 + this.jdField_f_of_type_Int < getWidth()) && (this.l >= 1))
      {
        this.l -= 1;
        localView = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(this.l, a(this.l), this);
        a(localView, 0);
        label82:
        int i2;
        if (this.l == 0)
        {
          i1 = 0;
          i1 = paramInt1 + (i1 + localView.getMeasuredWidth());
          i2 = this.jdField_e_of_type_Int;
          if (getWidth() - (i1 + paramInt2) != 0) {
            break label136;
          }
        }
        label136:
        for (paramInt1 = localView.getMeasuredWidth();; paramInt1 = this.jdField_f_of_type_Int + localView.getMeasuredWidth())
        {
          this.jdField_e_of_type_Int = (i2 - paramInt1);
          paramInt1 = i1;
          break;
          i1 = this.jdField_f_of_type_Int;
          break label82;
        }
      }
    }
    else {
      while ((i1 + paramInt2 + this.jdField_f_of_type_Int < getWidth()) && (this.l + 1 < this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()))
      {
        this.l += 1;
        if (this.k < 0) {
          this.k = this.l;
        }
        localView = a(this.l, false);
        if (localView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HorizontalListView", 2, "fillListRight obtainView is null");
          }
        }
        else
        {
          a(localView, -1);
          if (this.l == 0) {}
          for (paramInt1 = 0;; paramInt1 = this.jdField_f_of_type_Int)
          {
            paramInt1 = i1 + (paramInt1 + localView.getMeasuredWidth());
            i();
            i1 = paramInt1;
            if (!jdField_a_of_type_Boolean) {
              break;
            }
            a("fillListRight", new Object[] { "mRightViewAdapterIndex", Integer.valueOf(this.l) });
            i1 = paramInt1;
            break;
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Amcf == null) {
      this.jdField_a_of_type_Amcf = new amcf(this);
    }
    this.jdField_a_of_type_Amcf.a(paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (((paramBoolean) || (paramInt1 + paramInt2 - this.jdField_f_of_type_Int > 0)) && (this.k + 1 < this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()))
    {
      this.k += 1;
      if (this.l < 0) {
        this.l = this.k;
      }
      View localView = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(this.k, a(this.k), this);
      a(localView, -1);
      if (this.k == 0) {}
      for (int i1 = getWidth() - localView.getMeasuredWidth();; i1 = -(localView.getMeasuredWidth() + i1))
      {
        paramInt1 += i1;
        paramBoolean = false;
        break;
        i1 = this.jdField_f_of_type_Int;
      }
    }
  }
  
  protected void a(int paramInt, View paramView)
  {
    try
    {
      Object localObject = paramView.getTag(2131433004);
      if ((localObject instanceof Integer))
      {
        i1 = ((Integer)localObject).intValue();
        i2 = i1;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          if (!b(i1)) {
            i2 = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt);
          }
          if (b(i2))
          {
            ((Queue)this.jdField_a_of_type_JavaUtilList.get(i2)).offer(paramView);
            if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView$RecycleListener != null) {
              this.jdField_a_of_type_ComTencentWidgetHorizontalListView$RecycleListener.b(paramView);
            }
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          int i2;
          continue;
        }
        localThrowable1 = localThrowable1;
        int i1 = -1;
        localThrowable1.printStackTrace();
        i2 = i1;
        continue;
        i1 = -1;
      }
    }
  }
  
  protected void a(View paramView, int paramInt)
  {
    addViewInLayout(paramView, paramInt, a(paramView), true);
    a(paramView);
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    int i1 = 0;
    if ((jdField_a_of_type_Boolean) && (QLog.isDevelopLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      localStringBuilder.setLength(0);
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mDisplayOffset = ").append(this.jdField_e_of_type_Int);
      localStringBuilder.append(", mMaxX = ").append(this.i);
      localStringBuilder.append(", mMinX = ").append(this.j);
      localStringBuilder.append(", mCurrentX = ").append(this.jdField_g_of_type_Int);
      localStringBuilder.append(", mNextX = ").append(this.h);
      localStringBuilder.append(", mScrollX = ").append(getScrollX());
      localStringBuilder.append(", mLeftViewAdapterIndex= ").append(this.k);
      localStringBuilder.append(", mRightViewAdapterIndex = ").append(this.l);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        int i2 = paramVarArgs.length;
        while (i1 < i2)
        {
          paramString = paramVarArgs[i1];
          localStringBuilder.append(",").append(paramString);
          i1 += 1;
        }
      }
      QLog.i("HorizontalListView", 4, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      a();
    }
    b(this.jdField_d_of_type_Boolean);
    removeAllViewsInLayout();
    requestLayout();
  }
  
  public boolean a()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    int i1;
    do
    {
      View localView;
      do
      {
        return false;
        if (!this.jdField_d_of_type_Boolean) {
          if (Math.abs(this.jdField_g_of_type_Int - this.i) < this.o) {
            i1 = 1;
          }
        }
        while (i1 != 0)
        {
          i1 = this.i;
          this.jdField_g_of_type_Int = i1;
          this.h = i1;
          invalidate();
          return false;
          i1 = 0;
          continue;
          if (Math.abs(this.jdField_g_of_type_Int - this.j) < this.o) {
            i1 = 1;
          } else {
            i1 = 0;
          }
        }
        if (this.o + this.jdField_e_of_type_Int >= 0)
        {
          this.h += this.jdField_e_of_type_Int;
          invalidate();
          return false;
        }
        localView = getChildAt(0);
      } while (localView == null);
      i1 = this.h;
      int i2 = this.jdField_e_of_type_Int + i1;
      int i3 = localView.getMeasuredWidth();
      i1 = i2;
      if (this.jdField_e_of_type_Int <= -(i3 / 2 + 0.5D)) {
        i1 = i2 + i3;
      }
    } while (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.h + getScrollX(), 0, i1, i1, 0, 0));
    if (jdField_a_of_type_Boolean) {
      a("checkScrollToChild", new Object[] { Integer.valueOf(this.p), Integer.valueOf(i1) });
    }
    invalidate();
    return true;
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt == this.jdField_a_of_type_AndroidWidgetListAdapter.getCount() - 1;
  }
  
  public boolean a(View paramView, int paramInt, long paramLong)
  {
    AdapterView.OnItemLongClickListener localOnItemLongClickListener = getOnItemLongClickListener();
    if (localOnItemLongClickListener != null) {}
    for (boolean bool1 = localOnItemLongClickListener.onItemLongClick(this, paramView, paramInt, paramLong);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo = a(paramView, paramInt, paramLong);
        bool2 = super.showContextMenuForChild(this);
      }
      if (bool2) {
        performHapticFeedback(0);
      }
      return bool2;
    }
  }
  
  protected View b()
  {
    if (this.jdField_d_of_type_Boolean) {
      return getChildAt(getChildCount() - 1);
    }
    return getChildAt(0);
  }
  
  public View b(int paramInt)
  {
    if ((paramInt >= this.k) && (paramInt <= this.l)) {
      return getChildAt(paramInt - this.k);
    }
    return null;
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    while ((paramInt1 + paramInt2 - this.jdField_f_of_type_Int > 0) && (this.k >= 1))
    {
      this.k -= 1;
      View localView = a(this.k, false);
      if (localView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HorizontalListView", 2, "fillListLeft obtainView is null");
        }
      }
      else
      {
        a(localView, 0);
        int i1;
        label83:
        int i2;
        if (this.k == 0)
        {
          i1 = localView.getMeasuredWidth();
          i1 = paramInt1 - i1;
          i2 = this.jdField_e_of_type_Int;
          if (i1 + paramInt2 != 0) {
            break label167;
          }
        }
        label167:
        for (paramInt1 = localView.getMeasuredWidth();; paramInt1 = this.jdField_f_of_type_Int + localView.getMeasuredWidth())
        {
          this.jdField_e_of_type_Int = (i2 - paramInt1);
          paramInt1 = i1;
          if (!jdField_a_of_type_Boolean) {
            break;
          }
          a("fillListLeft", new Object[] { "mLeftViewAdapterIndex", Integer.valueOf(this.k) });
          paramInt1 = i1;
          break;
          i1 = this.jdField_f_of_type_Int + localView.getMeasuredWidth();
          break label83;
        }
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Amcf == null) {
      this.jdField_a_of_type_Amcf = new amcf(this);
    }
    this.jdField_a_of_type_Amcf.b(paramInt1, paramInt2, paramInt3);
  }
  
  @TargetApi(9)
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetOverScroller = new OverScroller(getContext());
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(a());
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.o = localViewConfiguration.getScaledTouchSlop();
    this.q = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.r = localViewConfiguration.getScaledMaximumFlingVelocity();
    setLayoutDirection(paramBoolean);
    this.jdField_g_of_type_Int = 0;
    this.h = this.jdField_g_of_type_Int;
    this.k = -1;
    this.l = -1;
    this.jdField_e_of_type_Int = 0;
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    this.p = -1;
    g(4097);
    this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new amcd(this);
  }
  
  int c(int paramInt)
  {
    int i1 = getChildCount();
    if (i1 > 0)
    {
      i1 -= 1;
      while (i1 >= 0)
      {
        if (paramInt >= getChildAt(i1).getLeft()) {
          return i1 + getFirstVisiblePosition();
        }
        i1 -= 1;
      }
    }
    return -1;
  }
  
  protected View c()
  {
    if (this.jdField_d_of_type_Boolean) {
      return getChildAt(0);
    }
    return getChildAt(getChildCount() - 1);
  }
  
  protected void c(int paramInt)
  {
    int i3 = 0;
    int i2 = 0;
    if (this.jdField_d_of_type_Boolean)
    {
      localView = b();
      boolean bool;
      if (localView != null)
      {
        i1 = localView.getLeft();
        bool = false;
      }
      for (;;)
      {
        a(i1, paramInt, bool);
        localView = c();
        i1 = i2;
        if (localView != null) {
          i1 = localView.getRight();
        }
        a(i1, paramInt);
        return;
        bool = true;
        i1 = 0;
      }
    }
    View localView = c();
    if (localView != null) {}
    for (int i1 = localView.getRight();; i1 = 0)
    {
      a(i1, paramInt);
      localView = b();
      i1 = i3;
      if (localView != null) {
        i1 = localView.getLeft();
      }
      b(i1, paramInt);
      return;
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.p = 4;
    g(4099);
    int i1 = this.jdField_g_of_type_Int;
    if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a())
    {
      i1 = getScrollX();
      i1 = this.h + i1;
    }
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(i1, 0, -paramInt1, 0, paramInt2);
    this.jdField_a_of_type_Float = 0.0F;
    f();
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  public boolean c()
  {
    return (this.jdField_g_of_type_Boolean) && ((getParent() instanceof View));
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_ComTencentWidgetOverScroller.b())
    {
      i1 = getScrollX();
      int i3 = this.h + i1;
      int i4 = this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
      int i5 = this.h;
      if (jdField_a_of_type_Boolean) {
        a("computeScroll", new Object[] { "MOVING", Integer.valueOf(i3), Integer.valueOf(i4) });
      }
      int i6;
      int i8;
      int i2;
      if (i3 != i4)
      {
        i6 = this.i;
        int i7 = this.j;
        i1 = getOverScrollMode();
        if ((i1 == 0) || ((i1 == 1) && (i6 > 0)))
        {
          i1 = 1;
          if ((i1 == 0) || ((i4 >= i7) && (i4 <= i6))) {
            break label316;
          }
          i8 = getWidth() - this.jdField_d_of_type_Int;
          i2 = 0;
          if ((i4 >= i7) || (i4 >= -i8) || (i4 >= i3)) {
            break label255;
          }
          i1 = 1;
          label168:
          if (i1 == 0) {
            break label289;
          }
          this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
          this.jdField_a_of_type_ComTencentWidgetOverScroller.a(getScrollX() + this.h, getScrollY(), this.h, this.h, 0, 0);
          label210:
          if (i4 >= i7) {
            break label344;
          }
          this.h = i7;
        }
      }
      for (;;)
      {
        if (i5 != this.h)
        {
          c();
          requestLayout();
        }
        awakenScrollBars();
        postInvalidate();
        return;
        i1 = 0;
        break;
        label255:
        i1 = i2;
        if (i6 == 2147483647) {
          break label168;
        }
        i1 = i2;
        if (i4 <= i6 + i8) {
          break label168;
        }
        i1 = i2;
        if (i4 <= i3) {
          break label168;
        }
        i1 = 1;
        break label168;
        label289:
        overScrollBy(i4 - i3, 0, getScrollX(), getScrollY(), 0, 0, i8, 0, false);
        break label210;
        label316:
        if (i3 != i5) {
          scrollTo(0, 0);
        }
        this.h += i4 - i3;
        break label210;
        label344:
        if (i4 > i6)
        {
          this.h = i6;
          continue;
          if (Math.abs(getScrollX()) < this.o)
          {
            this.h = i3;
            scrollTo(0, 0);
          }
          else
          {
            g();
          }
        }
      }
    }
    int i1 = getScrollX();
    if ((this.n == 4099) || ((this.n == 4097) && (this.i == this.h) && (i1 != 0))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((jdField_a_of_type_Boolean) && (QLog.isDevelopLevel())) {
        a("computeScroll", new Object[] { "over", Integer.valueOf(this.n), Boolean.valueOf(bool) });
      }
      if (!bool) {
        break;
      }
      this.p = -1;
      if (Math.abs(i1) >= this.o) {
        break label526;
      }
      scrollTo(0, 0);
      g(4097);
      return;
    }
    label526:
    g();
  }
  
  public int d()
  {
    return this.jdField_g_of_type_Int;
  }
  
  protected void d(int paramInt)
  {
    int i2;
    int i1;
    if (this.jdField_d_of_type_Boolean)
    {
      localView = c();
      if ((localView != null) && (localView.getLeft() + paramInt >= getWidth()))
      {
        i2 = this.jdField_e_of_type_Int;
        if (a(this.l)) {}
        for (i1 = localView.getMeasuredWidth();; i1 = this.jdField_f_of_type_Int + localView.getMeasuredWidth())
        {
          this.jdField_e_of_type_Int = (i1 + i2);
          a(this.l, localView);
          removeViewInLayout(localView);
          this.l += 1;
          localView = c();
          break;
        }
      }
      for (localView = b(); (localView != null) && (localView.getRight() + paramInt <= 0); localView = b())
      {
        a(this.k, localView);
        removeViewInLayout(localView);
        this.k -= 1;
      }
    }
    View localView = b();
    if ((localView != null) && (localView.getRight() + paramInt <= 0))
    {
      i2 = this.jdField_e_of_type_Int;
      if (a(this.k)) {}
      for (i1 = localView.getMeasuredWidth();; i1 = this.jdField_f_of_type_Int + localView.getMeasuredWidth())
      {
        this.jdField_e_of_type_Int = (i1 + i2);
        a(this.k, localView);
        removeViewInLayout(localView);
        if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnItemScrollEventListener != null) {
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnItemScrollEventListener.a(this.k, true);
        }
        this.k += 1;
        localView = b();
        break;
      }
    }
    for (localView = c(); (localView != null) && (localView.getLeft() + paramInt >= getWidth()); localView = c())
    {
      a(this.l, localView);
      removeViewInLayout(localView);
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnItemScrollEventListener != null) {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnItemScrollEventListener.a(this.l, false);
      }
      this.l -= 1;
    }
  }
  
  protected boolean d()
  {
    View localView;
    int i1;
    int i2;
    if (this.jdField_d_of_type_Boolean)
    {
      if (a(this.k))
      {
        localView = b();
        if (localView != null)
        {
          i1 = this.j;
          i2 = this.jdField_g_of_type_Int;
          this.j = (localView.getLeft() - getPaddingLeft() + i2);
          if (this.j > 0) {
            this.j = -2147483648;
          }
          if (this.j == i1) {}
        }
      }
    }
    else {
      do
      {
        return true;
        if (!a(this.l)) {
          break;
        }
        localView = c();
        if (localView == null) {
          break;
        }
        i1 = this.i;
        i2 = this.jdField_g_of_type_Int;
        this.i = (localView.getRight() - getPaddingLeft() + i2 - b());
        if (this.i < 0) {
          this.i = 0;
        }
      } while (this.i != i1);
    }
    return false;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  protected void e(int paramInt)
  {
    int i3 = 0;
    int i2 = 0;
    int i4 = getChildCount();
    if (i4 > 0)
    {
      if (jdField_a_of_type_Boolean) {
        a("positionChildren", new Object[] { Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramInt), Integer.valueOf(this.jdField_e_of_type_Int + paramInt) });
      }
      View localView;
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_e_of_type_Int -= paramInt;
        i1 = getWidth() - this.jdField_e_of_type_Int;
        paramInt = i2;
        while (paramInt < i4)
        {
          localView = getChildAt(paramInt);
          i2 = getPaddingRight() + i1;
          i3 = localView.getMeasuredWidth();
          int i5 = getPaddingTop();
          localView.layout(i2 - i3, i5, i2, localView.getMeasuredHeight() + i5);
          i1 -= localView.getMeasuredWidth() + this.jdField_f_of_type_Int;
          paramInt += 1;
        }
      }
      if (this.k == 0) {
        this.j = (this.jdField_e_of_type_Int + this.jdField_g_of_type_Int);
      }
      this.jdField_e_of_type_Int += paramInt;
      int i1 = this.jdField_e_of_type_Int;
      paramInt = i3;
      while (paramInt < i4)
      {
        localView = getChildAt(paramInt);
        i2 = getPaddingLeft() + i1;
        i3 = getPaddingTop();
        localView.layout(i2, i3, localView.getMeasuredWidth() + i2, localView.getMeasuredHeight() + i3);
        i1 += localView.getMeasuredWidth() + this.jdField_f_of_type_Int;
        paramInt += 1;
      }
    }
  }
  
  public void f(int paramInt)
  {
    this.p = 6;
    g(4099);
    if (getChildCount() > 0)
    {
      this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.h + getScrollX(), 0, a(paramInt), 0, this.j, this.i, 0, 0, Math.max(0, getWidth() / 2), 0);
      requestLayout();
    }
  }
  
  public void g(int paramInt)
  {
    int i1 = paramInt;
    if (this.jdField_c_of_type_Boolean)
    {
      i1 = paramInt;
      if (this.n != paramInt)
      {
        i1 = paramInt;
        if (paramInt == 4097) {
          switch (this.n)
          {
          default: 
            i1 = paramInt;
          }
        }
      }
    }
    for (;;)
    {
      if ((this.n != i1) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener != null)) {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener.a(i1);
      }
      this.n = i1;
      return;
      i1 = paramInt;
      if (a())
      {
        paramInt = 4099;
        i1 = paramInt;
        if (jdField_a_of_type_Boolean)
        {
          a("setCurrentScrollState", new Object[] { "SCROLL_STATE_TOUCH_SCROLL" });
          i1 = paramInt;
          continue;
          i1 = paramInt;
          if (a())
          {
            i1 = paramInt;
            if (jdField_a_of_type_Boolean)
            {
              a("setCurrentScrollState", new Object[] { "SCROLL_STATE_FLING" });
              i1 = paramInt;
            }
          }
        }
      }
    }
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo;
  }
  
  public int getFirstVisiblePosition()
  {
    if (this.jdField_d_of_type_Boolean) {
      return this.l;
    }
    return this.k;
  }
  
  public int getLastVisiblePosition()
  {
    if (this.jdField_d_of_type_Boolean) {
      return this.k;
    }
    return this.l;
  }
  
  @TargetApi(9)
  public int getOverScrollMode()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.getOverScrollMode();
    }
    return 0;
  }
  
  public View getSelectedView()
  {
    return b(this.m);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      a(paramCanvas);
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  @TargetApi(16)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(AbsListView.class.getName());
    if (isEnabled())
    {
      if (getFirstVisiblePosition() > 0) {
        paramAccessibilityNodeInfo.addAction(8192);
      }
      if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
        break label63;
      }
    }
    label63:
    for (int i1 = 0;; i1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount())
    {
      if (getLastVisiblePosition() < i1 - 1) {
        paramAccessibilityNodeInfo.addAction(4096);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if ((getContext() instanceof NearbyPeopleProfileActivity)) {
      ((NearbyPeopleProfileActivity)getContext()).a(false);
    }
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 2) && (this.jdField_f_of_type_Boolean)) {
      return true;
    }
    switch (i1 & 0xFF)
    {
    }
    for (;;)
    {
      boolean bool1;
      if (!this.jdField_f_of_type_Boolean)
      {
        bool1 = bool2;
        if (!super.onInterceptTouchEvent(paramMotionEvent)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      i1 = this.jdField_c_of_type_Int;
      if (i1 != -1)
      {
        float f1 = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(i1));
        if ((int)Math.abs(f1 - this.jdField_a_of_type_Float) > this.o)
        {
          this.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_Float = f1;
          e();
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
          ViewParent localViewParent = getParent();
          if (localViewParent != null)
          {
            localViewParent.requestDisallowInterceptTouchEvent(true);
            continue;
            f1 = paramMotionEvent.getX();
            if (!a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
            {
              this.jdField_f_of_type_Boolean = false;
              f();
            }
            else
            {
              this.jdField_a_of_type_Float = f1;
              this.jdField_c_of_type_Int = paramMotionEvent.getPointerId(0);
              d();
              this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
              if (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a()) {}
              for (bool1 = true;; bool1 = false)
              {
                this.jdField_f_of_type_Boolean = bool1;
                g(4097);
                break;
              }
              this.jdField_f_of_type_Boolean = false;
              this.jdField_c_of_type_Int = -1;
              f();
              if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a(getScrollX() + this.h, getScrollY(), this.h, this.h, 0, 0))
              {
                this.p = 6;
                g(4099);
                invalidate();
              }
              for (;;)
              {
                c();
                break;
                this.p = -1;
                g(4097);
              }
              a(paramMotionEvent);
            }
          }
        }
      }
    }
  }
  
  @SuppressLint({"WrongCall"})
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {}
    do
    {
      return;
      invalidate();
      int i1;
      if (this.jdField_b_of_type_Boolean)
      {
        a();
        i1 = this.jdField_g_of_type_Int;
        b(this.jdField_d_of_type_Boolean);
        removeAllViewsInLayout();
        this.h = i1;
        this.jdField_b_of_type_Boolean = false;
        if (this.jdField_a_of_type_JavaLangRunnable != null)
        {
          post(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_JavaLangRunnable = null;
        }
      }
      if (this.jdField_a_of_type_JavaLangInteger != null)
      {
        this.h = this.jdField_a_of_type_JavaLangInteger.intValue();
        this.jdField_a_of_type_JavaLangInteger = null;
      }
      if (this.h < this.j) {
        this.h = this.j;
      }
      for (;;)
      {
        b();
        i1 = this.jdField_g_of_type_Int - this.h;
        d(i1);
        c(i1);
        e(i1);
        this.jdField_g_of_type_Int = this.h;
        if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollLinstener != null) {
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollLinstener.a();
        }
        if (!d()) {
          break;
        }
        onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
        if (this.h > this.i) {
          this.h = this.i;
        }
      }
      View localView = c();
      if ((localView != null) && (localView.getRight() + this.jdField_f_of_type_Int < b()) && (this.l < this.jdField_a_of_type_AndroidWidgetListAdapter.getCount() - 1))
      {
        onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentWidgetOverScroller.a());
    ViewCompat.postOnAnimation(this, this.jdField_e_of_type_JavaLangRunnable);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int i1;
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null)
    {
      i1 = 0;
      if ((i1 <= 0) || ((i5 != 0) && (i5 != -2147483648) && (i4 != 0))) {
        break label199;
      }
      View localView = c(0);
      if (localView == null) {
        break label184;
      }
      measureChild(localView, paramInt1, paramInt2);
      paramInt1 = localView.getMeasuredWidth();
      i1 = localView.getMeasuredHeight();
      a(0, localView);
      label100:
      if ((i5 != 0) && (i5 != -2147483648)) {
        break label206;
      }
      paramInt2 = getPaddingTop() + getPaddingBottom() + i1 + getVerticalFadingEdgeLength() * 2;
      this.jdField_b_of_type_Int = View.MeasureSpec.makeMeasureSpec(paramInt2, i5);
      label142:
      if (i4 != 0) {
        break label217;
      }
      paramInt1 = getPaddingLeft() + getPaddingRight() + paramInt1 + getVerticalScrollbarWidth();
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      i1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
      break;
      label184:
      if (QLog.isColorLevel()) {
        QLog.i("HorizontalListView", 2, "onMeasure obtainView is null");
      }
      label199:
      i1 = 0;
      paramInt1 = 0;
      break label100;
      label206:
      this.jdField_b_of_type_Int = paramInt2;
      paramInt2 = i3;
      break label142;
      label217:
      paramInt1 = i2;
      if (i4 == -2147483648) {
        paramInt1 = a(0, -1, i2, -1);
      }
    }
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
    awakenScrollBars();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.jdField_g_of_type_Int);
    return localBundle;
  }
  
  @TargetApi(8)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    e();
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    label107:
    int i1;
    label403:
    label434:
    label753:
    label1270:
    label1277:
    do
    {
      do
      {
        Object localObject;
        int i2;
        do
        {
          do
          {
            return true;
            if (getChildCount() == 0) {
              return false;
            }
            if (this.p == 6)
            {
              this.p = 5;
              this.t = ((int)paramMotionEvent.getX());
              this.u = ((int)paramMotionEvent.getY());
              if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a()) {
                break label434;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              this.jdField_f_of_type_Boolean = bool;
              if (bool)
              {
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
              }
              if (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a()) {
                this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
              }
              this.jdField_a_of_type_Float = paramMotionEvent.getX();
              this.jdField_c_of_type_Int = paramMotionEvent.getPointerId(0);
              g(4097);
              if (!jdField_a_of_type_Boolean) {
                break;
              }
              a("onTouchEvent", new Object[] { "DOWN", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
              return true;
              if (c())
              {
                this.p = 0;
                if (this.jdField_b_of_type_JavaLangRunnable == null) {
                  this.jdField_b_of_type_JavaLangRunnable = new amcc(this);
                }
                postDelayed(this.jdField_b_of_type_JavaLangRunnable, ViewConfiguration.getTapTimeout());
                this.s = getFirstVisiblePosition();
                this.t = ((int)paramMotionEvent.getX());
                this.u = ((int)paramMotionEvent.getY());
                break label107;
              }
              i2 = a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
              i1 = i2;
              if (!this.jdField_b_of_type_Boolean)
              {
                if ((this.p == 4) || (i2 < 0) || (!a().isEnabled(i2))) {
                  break label403;
                }
                this.p = 0;
                if (this.jdField_b_of_type_JavaLangRunnable == null) {
                  this.jdField_b_of_type_JavaLangRunnable = new amcc(this);
                }
                postDelayed(this.jdField_b_of_type_JavaLangRunnable, ViewConfiguration.getTapTimeout());
                i1 = i2;
              }
              for (;;)
              {
                this.s = i1;
                break;
                i1 = i2;
                if (this.p == 4)
                {
                  this.p = 3;
                  i1 = c((int)paramMotionEvent.getX());
                }
              }
            }
            i1 = paramMotionEvent.findPointerIndex(this.jdField_c_of_type_Int);
          } while (i1 == -1);
          f1 = paramMotionEvent.getX(i1);
          i2 = (int)(this.jdField_a_of_type_Float - f1);
          i1 = i2;
          if (!this.jdField_f_of_type_Boolean)
          {
            i1 = i2;
            if (Math.abs(i2) > this.o)
            {
              paramMotionEvent = getParent();
              if (paramMotionEvent != null) {
                paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              }
              this.jdField_f_of_type_Boolean = true;
              if (i2 <= 0) {
                break;
              }
              i1 = i2 - this.o;
            }
          }
        } while (!this.jdField_f_of_type_Boolean);
        switch (this.p)
        {
        }
        for (;;)
        {
          g(4098);
          a(f1, i1);
          return true;
          i1 = i2 + this.o;
          break;
          paramMotionEvent = getHandler();
          if (paramMotionEvent != null) {
            paramMotionEvent.removeCallbacks(this.jdField_a_of_type_Amcb);
          }
          if (this.jdField_c_of_type_JavaLangRunnable != null) {
            removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
          }
          c();
          if (getScrollX() != 0)
          {
            this.p = 5;
          }
          else
          {
            this.p = 3;
            continue;
            if (getScrollX() != 0) {
              this.p = 5;
            } else {
              this.p = 3;
            }
          }
        }
        if ((this.jdField_f_of_type_Boolean) || (Math.abs(getScrollX()) > this.o))
        {
          localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.r);
          if (Build.VERSION.SDK_INT >= 8)
          {
            f1 = ((VelocityTracker)localObject).getXVelocity(this.jdField_c_of_type_Int);
            i1 = (int)f1;
            if (getChildCount() <= 0) {
              break label969;
            }
            if (Math.abs(i1) <= this.q) {
              break label906;
            }
            f(-i1);
            this.jdField_c_of_type_Int = -1;
            h();
          }
        }
        else
        {
          switch (this.p)
          {
          }
        }
        for (;;)
        {
          setPressed(false);
          invalidate();
          paramMotionEvent = getHandler();
          if (paramMotionEvent != null) {
            paramMotionEvent.removeCallbacks(this.jdField_a_of_type_Amcb);
          }
          if (!jdField_a_of_type_Boolean) {
            break;
          }
          a("onTouchEvent", new Object[] { "UP", Integer.valueOf(this.p) });
          return true;
          f1 = ((VelocityTracker)localObject).getXVelocity();
          break label753;
          if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a(getScrollX() + this.h, getScrollY(), this.h, this.h, 0, 0))
          {
            this.p = 6;
            g(4099);
            invalidate();
            break label783;
          }
          g(4097);
          break label783;
          g(4097);
          break label783;
          i2 = this.s;
          localObject = getChildAt(i2 - getFirstVisiblePosition());
          f1 = paramMotionEvent.getX();
          amce localamce;
          if ((f1 > getPaddingLeft()) && (f1 < getWidth() - getPaddingRight()))
          {
            i1 = 1;
            if (this.jdField_a_of_type_Amce == null) {
              this.jdField_a_of_type_Amce = new amce(this, null);
            }
            localamce = this.jdField_a_of_type_Amce;
            localamce.jdField_a_of_type_Int = i2;
            localamce.a();
            if ((localObject == null) || (((View)localObject).hasFocusable()) || (i1 == 0)) {
              break label1311;
            }
            if (this.p != 0)
            {
              c();
              if (this.jdField_c_of_type_JavaLangRunnable != null) {
                removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
              }
            }
            if ((this.p != 0) && (this.p != 1)) {
              break label1277;
            }
            Handler localHandler = getHandler();
            if (localHandler != null)
            {
              if (this.p != 0) {
                break label1253;
              }
              paramMotionEvent = this.jdField_b_of_type_JavaLangRunnable;
              localHandler.removeCallbacks(paramMotionEvent);
            }
            if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_AndroidWidgetListAdapter.isEnabled(i2))) {
              break label1270;
            }
            this.p = 1;
            if (!c()) {
              break label1261;
            }
            b((View)getParent());
          }
          for (;;)
          {
            if (this.jdField_c_of_type_JavaLangRunnable != null) {
              removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
            }
            this.jdField_c_of_type_JavaLangRunnable = new ambz(this, localamce);
            postDelayed(this.jdField_c_of_type_JavaLangRunnable, ViewConfiguration.getPressedStateDuration());
            return true;
            i1 = 0;
            break;
            paramMotionEvent = this.jdField_a_of_type_Amcb;
            break label1152;
            b((View)localObject);
          }
          this.p = -1;
          return true;
          if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetListAdapter.isEnabled(i2))) {
            localamce.run();
          }
          for (;;)
          {
            this.p = -1;
            break;
            localamce.run();
          }
          this.p = -1;
          continue;
          this.p = -1;
        }
        c();
        if ((this.jdField_f_of_type_Boolean) && (getChildCount() > 0))
        {
          if (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a(getScrollX() + this.h, getScrollY(), this.h, this.h, 0, 0)) {
            break label1501;
          }
          this.p = 6;
          g(4099);
          invalidate();
        }
        for (;;)
        {
          this.jdField_c_of_type_Int = -1;
          h();
          switch (this.p)
          {
          default: 
            this.p = -1;
            c();
            paramMotionEvent = getHandler();
            if (paramMotionEvent != null) {
              paramMotionEvent.removeCallbacks(this.jdField_a_of_type_Amcb);
            }
            break;
          }
          if (!jdField_a_of_type_Boolean) {
            break;
          }
          a("onTouchEvent", new Object[] { "CANCEL", Integer.valueOf(this.p) });
          return true;
          g(4097);
        }
        i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
        float f1 = paramMotionEvent.getX(i1);
        float f2 = paramMotionEvent.getY(i1);
        this.jdField_a_of_type_Float = f1;
        this.jdField_c_of_type_Int = paramMotionEvent.getPointerId(i1);
        this.t = ((int)f1);
        this.u = ((int)f2);
        i1 = a((int)f1, (int)f2);
      } while (i1 < 0);
      this.s = i1;
      return true;
      a(paramMotionEvent);
      i1 = paramMotionEvent.findPointerIndex(this.jdField_c_of_type_Int);
      if ((i1 < paramMotionEvent.getPointerCount()) && (-1 != i1)) {
        this.jdField_a_of_type_Float = paramMotionEvent.getX(i1);
      }
      i1 = a(this.t, this.u);
    } while (i1 < 0);
    label783:
    label969:
    label1253:
    label1261:
    this.s = i1;
    label906:
    label1311:
    label1501:
    return true;
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int i3 = getOverScrollMode();
    int i1;
    int i2;
    if (computeHorizontalScrollRange() > computeHorizontalScrollExtent())
    {
      i1 = 1;
      if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) {
        break label176;
      }
      i2 = 1;
      label34:
      if ((i3 != 0) && ((i3 != 1) || (i1 == 0))) {
        break label182;
      }
      i1 = 1;
      label53:
      if ((i3 != 0) && ((i3 != 1) || (i2 == 0))) {
        break label188;
      }
      i2 = 1;
      label72:
      paramInt3 += paramInt1;
      if (i1 == 0) {
        paramInt7 = 0;
      }
      paramInt4 += paramInt2;
      if (i2 == 0) {
        paramInt8 = 0;
      }
      i1 = -paramInt7;
      if (paramInt7 != 2147483647) {
        break label194;
      }
      paramInt1 = 2147483647;
      label113:
      paramInt5 = -paramInt8;
      if (paramInt8 != 2147483647) {
        break label203;
      }
      paramInt2 = 2147483647;
      label128:
      if (paramInt3 <= paramInt1) {
        break label212;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      label136:
      boolean bool = false;
      if (paramInt4 > paramInt2) {
        bool = true;
      }
      for (;;)
      {
        onOverScrolled(paramInt1, paramInt2, paramBoolean, bool);
        if ((paramBoolean) || (bool))
        {
          return true;
          i1 = 0;
          break;
          label176:
          i2 = 0;
          break label34;
          label182:
          i1 = 0;
          break label53;
          label188:
          i2 = 0;
          break label72;
          label194:
          paramInt1 = paramInt7 + paramInt5;
          break label113;
          label203:
          paramInt2 = paramInt8 + paramInt6;
          break label128;
          label212:
          if (paramInt3 >= i1) {
            break label251;
          }
          paramBoolean = true;
          paramInt1 = i1;
          break label136;
          if (paramInt4 >= paramInt5) {
            break label245;
          }
          bool = true;
          paramInt2 = paramInt5;
          continue;
        }
        return false;
        label245:
        paramInt2 = paramInt4;
      }
      label251:
      paramBoolean = false;
      paramInt1 = paramInt3;
    }
  }
  
  @TargetApi(16)
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramInt, paramBundle)) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {}
    for (int i1 = 0;; i1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    int i2;
    if ((isEnabled()) && (getLastVisiblePosition() < i1 - 1))
    {
      paramInt = getWidth();
      i1 = getPaddingLeft();
      i2 = getPaddingRight();
      a(this.jdField_a_of_type_Float, paramInt - i1 - i2);
      return true;
    }
    return false;
    if ((isEnabled()) && (getFirstVisiblePosition() > 0))
    {
      paramInt = getWidth();
      i1 = getPaddingLeft();
      i2 = getPaddingRight();
      a(this.jdField_a_of_type_Float, -(paramInt - i1 - i2));
      return true;
    }
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      f();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void sendAccessibilityEvent(int paramInt)
  {
    if (paramInt == 4096)
    {
      int i1 = getFirstVisiblePosition();
      int i2 = getLastVisiblePosition();
      if ((this.v == i1) && (this.w == i2)) {
        return;
      }
      this.v = i1;
      this.w = i2;
    }
    super.sendAccessibilityEvent(paramInt);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetListAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      if (paramListAdapter != null)
      {
        this.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
        this.jdField_a_of_type_AndroidWidgetListAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      }
      if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
        b(this.jdField_a_of_type_AndroidWidgetListAdapter.getViewTypeCount());
      }
      a(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      setDividerWidth(paramDrawable.getIntrinsicWidth());
      return;
    }
    setDividerWidth(0);
  }
  
  public void setDividerWidth(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setLayoutDirection(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.i = 0;
      this.j = -2147483648;
      return;
    }
    this.i = 2147483647;
    this.j = 0;
  }
  
  public void setOnItemScollEventListener(HorizontalListView.OnItemScrollEventListener paramOnItemScrollEventListener)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnItemScrollEventListener = paramOnItemScrollEventListener;
  }
  
  public void setOnScrollListener(HorizontalListView.OnScrollLinstener paramOnScrollLinstener)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollLinstener = paramOnScrollLinstener;
  }
  
  public void setOnScrollStateChangedListener(HorizontalListView.OnScrollStateChangedListener paramOnScrollStateChangedListener)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener = paramOnScrollStateChangedListener;
  }
  
  @TargetApi(9)
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(paramInt);
    }
  }
  
  public void setRecycleListener(HorizontalListView.RecycleListener paramRecycleListener)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView$RecycleListener = paramRecycleListener;
  }
  
  public void setRestoreX(int paramInt)
  {
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
  }
  
  public void setRunningOutOfDataListener(HorizontalListView.RunningOutOfDataListener paramRunningOutOfDataListener, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView$RunningOutOfDataListener = paramRunningOutOfDataListener;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setSelection(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setStayDisplayOffsetZero(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setTransTouchStateToParent(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView
 * JD-Core Version:    0.7.0.1
 */