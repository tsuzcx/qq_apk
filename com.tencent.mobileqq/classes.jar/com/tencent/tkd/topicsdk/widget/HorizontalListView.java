package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/HorizontalListView;", "Landroid/widget/AdapterView;", "Landroid/widget/ListAdapter;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mAdapter", "mCurrentX", "", "mDataChanged", "", "mDataObserver", "Landroid/database/DataSetObserver;", "mDisplayOffset", "mGesture", "Landroid/view/GestureDetector;", "mLeftViewIndex", "mMaxX", "mNextX", "mOnGesture", "Landroid/view/GestureDetector$OnGestureListener;", "mOnItemClicked", "Landroid/widget/AdapterView$OnItemClickListener;", "mOnItemLongClicked", "Landroid/widget/AdapterView$OnItemLongClickListener;", "mOnItemSelected", "Landroid/widget/AdapterView$OnItemSelectedListener;", "mRemovedViewQueue", "Ljava/util/Queue;", "Landroid/view/View;", "mRightViewIndex", "mScroller", "Landroid/widget/Scroller;", "addAndMeasureChild", "", "child", "viewPos", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "fillList", "dx", "fillListLeft", "leftEdge", "fillListRight", "rightEdge", "getAdapter", "getSelectedView", "initView", "onDown", "onFling", "velocityX", "", "onInterceptTouchEvent", "onLayout", "changed", "left", "top", "right", "bottom", "positionItems", "removeNonVisibleItems", "reset", "scrollTo", "x", "setAdapter", "adapter", "setOnItemClickListener", "listener", "setOnItemLongClickListener", "setOnItemSelectedListener", "setSelection", "position", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class HorizontalListView
  extends AdapterView<ListAdapter>
{
  private ListAdapter a;
  private int b;
  private int c;
  private int d = -1;
  private int e;
  private int f = 2147483647;
  private int g;
  private GestureDetector h;
  private Scroller i;
  private final Queue<View> j = (Queue)new LinkedList();
  private AdapterView.OnItemSelectedListener k;
  private AdapterView.OnItemClickListener l;
  private AdapterView.OnItemLongClickListener m;
  private final GestureDetector.OnGestureListener n = (GestureDetector.OnGestureListener)new HorizontalListView.mOnGesture.1(this);
  private boolean o;
  private final DataSetObserver p = (DataSetObserver)new HorizontalListView.mDataObserver.1(this);
  
  public HorizontalListView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private final void a()
  {
    try
    {
      this.d = -1;
      this.e = 0;
      this.g = 0;
      this.b = 0;
      this.c = 0;
      this.f = 2147483647;
      this.i = new Scroller(getContext());
      this.h = new GestureDetector(getContext(), this.n);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private final void a(int paramInt)
  {
    for (View localView = getChildAt(0); (localView != null) && (localView.getRight() + paramInt <= 0); localView = getChildAt(0))
    {
      this.g += localView.getMeasuredWidth();
      this.j.offer(localView);
      removeViewInLayout(localView);
      this.d += 1;
    }
    for (localView = getChildAt(getChildCount() - 1); (localView != null) && (localView.getLeft() + paramInt >= getWidth()); localView = getChildAt(getChildCount() - 1))
    {
      this.j.offer(localView);
      removeViewInLayout(localView);
      this.e -= 1;
    }
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    ListAdapter localListAdapter = this.a;
    if (localListAdapter != null)
    {
      int i1 = paramInt1;
      while ((paramInt1 + paramInt2 < getWidth()) && (this.e < localListAdapter.getCount()))
      {
        View localView = localListAdapter.getView(this.e, (View)this.j.poll(), (ViewGroup)this);
        Intrinsics.checkExpressionValueIsNotNull(localView, "child");
        a(localView, -1);
        i1 += localView.getMeasuredWidth();
        if (this.e == localListAdapter.getCount() - 1) {
          this.f = (this.b + i1 - getWidth());
        }
        if (this.f < 0) {
          this.f = 0;
        }
        this.e += 1;
      }
    }
  }
  
  private final void a(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
    }
    addViewInLayout(paramView, paramInt, localLayoutParams1, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
  }
  
  private final boolean a(float paramFloat)
  {
    try
    {
      Object localObject1 = this.i;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mScroller");
      }
      ((Scroller)localObject1).fling(this.c, 0, (int)-paramFloat, 0, 0, this.f, 0, 0);
      localObject1 = Unit.INSTANCE;
      requestLayout();
      return true;
    }
    finally {}
  }
  
  private final void b()
  {
    try
    {
      a();
      removeAllViewsInLayout();
      requestLayout();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private final void b(int paramInt)
  {
    View localView = getChildAt(getChildCount() - 1);
    int i2 = 0;
    if (localView != null) {
      i1 = localView.getRight();
    } else {
      i1 = 0;
    }
    a(i1, paramInt);
    localView = getChildAt(0);
    int i1 = i2;
    if (localView != null) {
      i1 = localView.getLeft();
    }
    b(i1, paramInt);
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    ListAdapter localListAdapter = this.a;
    if (localListAdapter != null) {
      while (paramInt1 + paramInt2 > 0)
      {
        int i1 = this.d;
        if (i1 < 0) {
          break;
        }
        View localView = localListAdapter.getView(i1, (View)this.j.poll(), (ViewGroup)this);
        Intrinsics.checkExpressionValueIsNotNull(localView, "child");
        a(localView, 0);
        paramInt1 -= localView.getMeasuredWidth();
        this.d -= 1;
        this.g -= localView.getMeasuredWidth();
      }
    }
  }
  
  private final void c(int paramInt)
  {
    if (getChildCount() > 0)
    {
      this.g += paramInt;
      int i1 = this.g;
      int i2 = getChildCount();
      paramInt = 0;
      while (paramInt < i2)
      {
        View localView = getChildAt(paramInt);
        Intrinsics.checkExpressionValueIsNotNull(localView, "child");
        int i3 = localView.getMeasuredWidth();
        localView.layout(i1, 0, i1 + i3, localView.getMeasuredHeight());
        i1 += i3 + localView.getPaddingRight();
        paramInt += 1;
      }
    }
  }
  
  private final boolean c()
  {
    Scroller localScroller = this.i;
    if (localScroller == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mScroller");
    }
    localScroller.forceFinished(true);
    return true;
  }
  
  public boolean dispatchTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    GestureDetector localGestureDetector = this.h;
    if (localGestureDetector == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mGesture");
    }
    return localGestureDetector.onTouchEvent(paramMotionEvent) | bool;
  }
  
  @Nullable
  public ListAdapter getAdapter()
  {
    return this.a;
  }
  
  @NotNull
  public View getSelectedView()
  {
    return new View(getContext());
  }
  
  public boolean onInterceptTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null)
    {
      int i1 = paramMotionEvent.getAction() & 0xFF;
      if (i1 == 0) {
        getParent().requestDisallowInterceptTouchEvent(true);
      } else if ((i1 == 1) || (i1 == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      Object localObject1 = this.a;
      if (localObject1 == null) {
        return;
      }
      if (this.o)
      {
        paramInt1 = this.b;
        a();
        removeAllViewsInLayout();
        this.c = paramInt1;
        this.o = false;
      }
      localObject1 = this.i;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mScroller");
      }
      if (((Scroller)localObject1).computeScrollOffset())
      {
        localObject1 = this.i;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mScroller");
        }
        this.c = ((Scroller)localObject1).getCurrX();
      }
      if (this.c <= 0)
      {
        this.c = 0;
        localObject1 = this.i;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mScroller");
        }
        ((Scroller)localObject1).forceFinished(true);
      }
      if (this.c >= this.f)
      {
        this.c = this.f;
        localObject1 = this.i;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mScroller");
        }
        ((Scroller)localObject1).forceFinished(true);
      }
      paramInt1 = this.b - this.c;
      a(paramInt1);
      b(paramInt1);
      c(paramInt1);
      this.b = this.c;
      localObject1 = this.i;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mScroller");
      }
      if (!((Scroller)localObject1).isFinished()) {
        post((Runnable)new HorizontalListView.onLayout.1(this));
      }
      return;
    }
    finally {}
  }
  
  public void setAdapter(@Nullable ListAdapter paramListAdapter)
  {
    ListAdapter localListAdapter = this.a;
    if ((localListAdapter != null) && (localListAdapter != null)) {
      localListAdapter.unregisterDataSetObserver(this.p);
    }
    this.a = paramListAdapter;
    paramListAdapter = this.a;
    if (paramListAdapter != null) {
      paramListAdapter.registerDataSetObserver(this.p);
    }
    b();
  }
  
  public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.l = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(@Nullable AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.m = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.k = paramOnItemSelectedListener;
  }
  
  public void setSelection(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.HorizontalListView
 * JD-Core Version:    0.7.0.1
 */