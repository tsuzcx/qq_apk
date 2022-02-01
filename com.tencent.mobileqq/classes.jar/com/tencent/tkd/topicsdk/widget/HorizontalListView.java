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
  private int jdField_a_of_type_Int;
  private final DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = (DataSetObserver)new HorizontalListView.mDataObserver.1(this);
  private final GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = (GestureDetector.OnGestureListener)new HorizontalListView.mOnGesture.1(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
  private AdapterView.OnItemLongClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener;
  private AdapterView.OnItemSelectedListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemSelectedListener;
  private ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private final Queue<View> jdField_a_of_type_JavaUtilQueue = (Queue)new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c = -1;
  private int d;
  private int e = 2147483647;
  private int f;
  
  public HorizontalListView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private final void a()
  {
    try
    {
      this.c = -1;
      this.d = 0;
      this.f = 0;
      this.jdField_a_of_type_Int = 0;
      this.b = 0;
      this.e = 2147483647;
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
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
      this.f += localView.getMeasuredWidth();
      this.jdField_a_of_type_JavaUtilQueue.offer(localView);
      removeViewInLayout(localView);
      this.c += 1;
    }
    for (localView = getChildAt(getChildCount() - 1); (localView != null) && (localView.getLeft() + paramInt >= getWidth()); localView = getChildAt(getChildCount() - 1))
    {
      this.jdField_a_of_type_JavaUtilQueue.offer(localView);
      removeViewInLayout(localView);
      this.d -= 1;
    }
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
    if (localListAdapter != null)
    {
      int i = paramInt1;
      while ((paramInt1 + paramInt2 < getWidth()) && (this.d < localListAdapter.getCount()))
      {
        View localView = localListAdapter.getView(this.d, (View)this.jdField_a_of_type_JavaUtilQueue.poll(), (ViewGroup)this);
        Intrinsics.checkExpressionValueIsNotNull(localView, "child");
        a(localView, -1);
        i += localView.getMeasuredWidth();
        if (this.d == localListAdapter.getCount() - 1) {
          this.e = (this.jdField_a_of_type_Int + i - getWidth());
        }
        if (this.e < 0) {
          this.e = 0;
        }
        this.d += 1;
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
  
  private final boolean a()
  {
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    if (localScroller == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mScroller");
    }
    localScroller.forceFinished(true);
    return true;
  }
  
  private final boolean a(float paramFloat)
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_AndroidWidgetScroller;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mScroller");
      }
      ((Scroller)localObject1).fling(this.b, 0, (int)-paramFloat, 0, 0, this.e, 0, 0);
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
    int j = 0;
    if (localView != null) {
      i = localView.getRight();
    } else {
      i = 0;
    }
    a(i, paramInt);
    localView = getChildAt(0);
    int i = j;
    if (localView != null) {
      i = localView.getLeft();
    }
    b(i, paramInt);
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
    if (localListAdapter != null) {
      while (paramInt1 + paramInt2 > 0)
      {
        int i = this.c;
        if (i < 0) {
          break;
        }
        View localView = localListAdapter.getView(i, (View)this.jdField_a_of_type_JavaUtilQueue.poll(), (ViewGroup)this);
        Intrinsics.checkExpressionValueIsNotNull(localView, "child");
        a(localView, 0);
        paramInt1 -= localView.getMeasuredWidth();
        this.c -= 1;
        this.f -= localView.getMeasuredWidth();
      }
    }
  }
  
  private final void c(int paramInt)
  {
    if (getChildCount() > 0)
    {
      this.f += paramInt;
      int i = this.f;
      int j = getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        View localView = getChildAt(paramInt);
        Intrinsics.checkExpressionValueIsNotNull(localView, "child");
        int k = localView.getMeasuredWidth();
        localView.layout(i, 0, i + k, localView.getMeasuredHeight());
        i += k + localView.getPaddingRight();
        paramInt += 1;
      }
    }
  }
  
  @Nullable
  public ListAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter;
  }
  
  public boolean dispatchTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    GestureDetector localGestureDetector = this.jdField_a_of_type_AndroidViewGestureDetector;
    if (localGestureDetector == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mGesture");
    }
    return localGestureDetector.onTouchEvent(paramMotionEvent) | bool;
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
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i == 0) {
        getParent().requestDisallowInterceptTouchEvent(true);
      } else if ((i == 1) || (i == 3)) {
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
      Object localObject1 = this.jdField_a_of_type_AndroidWidgetListAdapter;
      if (localObject1 == null) {
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        paramInt1 = this.jdField_a_of_type_Int;
        a();
        removeAllViewsInLayout();
        this.b = paramInt1;
        this.jdField_a_of_type_Boolean = false;
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetScroller;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mScroller");
      }
      if (((Scroller)localObject1).computeScrollOffset())
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetScroller;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mScroller");
        }
        this.b = ((Scroller)localObject1).getCurrX();
      }
      if (this.b <= 0)
      {
        this.b = 0;
        localObject1 = this.jdField_a_of_type_AndroidWidgetScroller;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mScroller");
        }
        ((Scroller)localObject1).forceFinished(true);
      }
      if (this.b >= this.e)
      {
        this.b = this.e;
        localObject1 = this.jdField_a_of_type_AndroidWidgetScroller;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mScroller");
        }
        ((Scroller)localObject1).forceFinished(true);
      }
      paramInt1 = this.jdField_a_of_type_Int - this.b;
      a(paramInt1);
      b(paramInt1);
      c(paramInt1);
      this.jdField_a_of_type_Int = this.b;
      localObject1 = this.jdField_a_of_type_AndroidWidgetScroller;
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
    ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
    if ((localListAdapter != null) && (localListAdapter != null)) {
      localListAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    paramListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
    if (paramListAdapter != null) {
      paramListAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    b();
  }
  
  public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(@Nullable AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public void setSelection(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.HorizontalListView
 * JD-Core Version:    0.7.0.1
 */