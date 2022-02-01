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
        i = localView.getMeasuredWidth() + i;
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
    int j = 0;
    View localView = getChildAt(getChildCount() - 1);
    if (localView != null) {}
    for (int i = localView.getRight();; i = 0)
    {
      a(i, paramInt);
      localView = getChildAt(0);
      i = j;
      if (localView != null) {
        i = localView.getLeft();
      }
      b(i, paramInt);
      return;
    }
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
    if (localListAdapter != null) {
      while ((paramInt1 + paramInt2 > 0) && (this.c >= 0))
      {
        View localView = localListAdapter.getView(this.c, (View)this.jdField_a_of_type_JavaUtilQueue.poll(), (ViewGroup)this);
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
        i += localView.getPaddingRight() + k;
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
    return bool | localGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  @NotNull
  public View getSelectedView()
  {
    return new View(getContext());
  }
  
  public boolean onInterceptTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    int i;
    if (paramMotionEvent != null)
    {
      i = paramMotionEvent.getAction() & 0xFF;
      if (i != 0) {
        break label39;
      }
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      return super.onInterceptTouchEvent(paramMotionEvent);
      label39:
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  /* Error */
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: iload_2
    //   5: iload_3
    //   6: iload 4
    //   8: iload 5
    //   10: invokespecial 350	android/widget/AdapterView:onLayout	(ZIIII)V
    //   13: aload_0
    //   14: getfield 157	com/tencent/tkd/topicsdk/widget/HorizontalListView:jdField_a_of_type_AndroidWidgetListAdapter	Landroid/widget/ListAdapter;
    //   17: astore 6
    //   19: aload 6
    //   21: ifnonnull +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 268	com/tencent/tkd/topicsdk/widget/HorizontalListView:jdField_a_of_type_Boolean	Z
    //   31: ifeq +26 -> 57
    //   34: aload_0
    //   35: getfield 163	com/tencent/tkd/topicsdk/widget/HorizontalListView:jdField_a_of_type_Int	I
    //   38: istore_2
    //   39: aload_0
    //   40: invokespecial 142	com/tencent/tkd/topicsdk/widget/HorizontalListView:a	()V
    //   43: aload_0
    //   44: invokevirtual 301	com/tencent/tkd/topicsdk/widget/HorizontalListView:removeAllViewsInLayout	()V
    //   47: aload_0
    //   48: iload_2
    //   49: putfield 165	com/tencent/tkd/topicsdk/widget/HorizontalListView:b	I
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 268	com/tencent/tkd/topicsdk/widget/HorizontalListView:jdField_a_of_type_Boolean	Z
    //   57: aload_0
    //   58: getfield 176	com/tencent/tkd/topicsdk/widget/HorizontalListView:jdField_a_of_type_AndroidWidgetScroller	Landroid/widget/Scroller;
    //   61: astore 6
    //   63: aload 6
    //   65: ifnonnull +9 -> 74
    //   68: ldc_w 270
    //   71: invokestatic 274	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   74: aload 6
    //   76: invokevirtual 353	android/widget/Scroller:computeScrollOffset	()Z
    //   79: ifeq +29 -> 108
    //   82: aload_0
    //   83: getfield 176	com/tencent/tkd/topicsdk/widget/HorizontalListView:jdField_a_of_type_AndroidWidgetScroller	Landroid/widget/Scroller;
    //   86: astore 6
    //   88: aload 6
    //   90: ifnonnull +9 -> 99
    //   93: ldc_w 270
    //   96: invokestatic 274	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: aload 6
    //   102: invokevirtual 356	android/widget/Scroller:getCurrX	()I
    //   105: putfield 165	com/tencent/tkd/topicsdk/widget/HorizontalListView:b	I
    //   108: aload_0
    //   109: getfield 165	com/tencent/tkd/topicsdk/widget/HorizontalListView:b	I
    //   112: ifgt +31 -> 143
    //   115: aload_0
    //   116: iconst_0
    //   117: putfield 165	com/tencent/tkd/topicsdk/widget/HorizontalListView:b	I
    //   120: aload_0
    //   121: getfield 176	com/tencent/tkd/topicsdk/widget/HorizontalListView:jdField_a_of_type_AndroidWidgetScroller	Landroid/widget/Scroller;
    //   124: astore 6
    //   126: aload 6
    //   128: ifnonnull +9 -> 137
    //   131: ldc_w 270
    //   134: invokestatic 274	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   137: aload 6
    //   139: iconst_1
    //   140: invokevirtual 278	android/widget/Scroller:forceFinished	(Z)V
    //   143: aload_0
    //   144: getfield 165	com/tencent/tkd/topicsdk/widget/HorizontalListView:b	I
    //   147: aload_0
    //   148: getfield 115	com/tencent/tkd/topicsdk/widget/HorizontalListView:e	I
    //   151: if_icmplt +34 -> 185
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 115	com/tencent/tkd/topicsdk/widget/HorizontalListView:e	I
    //   159: putfield 165	com/tencent/tkd/topicsdk/widget/HorizontalListView:b	I
    //   162: aload_0
    //   163: getfield 176	com/tencent/tkd/topicsdk/widget/HorizontalListView:jdField_a_of_type_AndroidWidgetScroller	Landroid/widget/Scroller;
    //   166: astore 6
    //   168: aload 6
    //   170: ifnonnull +9 -> 179
    //   173: ldc_w 270
    //   176: invokestatic 274	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   179: aload 6
    //   181: iconst_1
    //   182: invokevirtual 278	android/widget/Scroller:forceFinished	(Z)V
    //   185: aload_0
    //   186: getfield 163	com/tencent/tkd/topicsdk/widget/HorizontalListView:jdField_a_of_type_Int	I
    //   189: aload_0
    //   190: getfield 165	com/tencent/tkd/topicsdk/widget/HorizontalListView:b	I
    //   193: isub
    //   194: istore_2
    //   195: aload_0
    //   196: iload_2
    //   197: invokespecial 358	com/tencent/tkd/topicsdk/widget/HorizontalListView:a	(I)V
    //   200: aload_0
    //   201: iload_2
    //   202: invokespecial 360	com/tencent/tkd/topicsdk/widget/HorizontalListView:b	(I)V
    //   205: aload_0
    //   206: iload_2
    //   207: invokespecial 362	com/tencent/tkd/topicsdk/widget/HorizontalListView:c	(I)V
    //   210: aload_0
    //   211: aload_0
    //   212: getfield 165	com/tencent/tkd/topicsdk/widget/HorizontalListView:b	I
    //   215: putfield 163	com/tencent/tkd/topicsdk/widget/HorizontalListView:jdField_a_of_type_Int	I
    //   218: aload_0
    //   219: getfield 176	com/tencent/tkd/topicsdk/widget/HorizontalListView:jdField_a_of_type_AndroidWidgetScroller	Landroid/widget/Scroller;
    //   222: astore 6
    //   224: aload 6
    //   226: ifnonnull +9 -> 235
    //   229: ldc_w 270
    //   232: invokestatic 274	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   235: aload 6
    //   237: invokevirtual 365	android/widget/Scroller:isFinished	()Z
    //   240: ifne -216 -> 24
    //   243: aload_0
    //   244: new 367	com/tencent/tkd/topicsdk/widget/HorizontalListView$onLayout$1
    //   247: dup
    //   248: aload_0
    //   249: invokespecial 368	com/tencent/tkd/topicsdk/widget/HorizontalListView$onLayout$1:<init>	(Lcom/tencent/tkd/topicsdk/widget/HorizontalListView;)V
    //   252: checkcast 370	java/lang/Runnable
    //   255: invokevirtual 374	com/tencent/tkd/topicsdk/widget/HorizontalListView:post	(Ljava/lang/Runnable;)Z
    //   258: pop
    //   259: goto -235 -> 24
    //   262: astore 6
    //   264: aload_0
    //   265: monitorexit
    //   266: aload 6
    //   268: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	HorizontalListView
    //   0	269	1	paramBoolean	boolean
    //   0	269	2	paramInt1	int
    //   0	269	3	paramInt2	int
    //   0	269	4	paramInt3	int
    //   0	269	5	paramInt4	int
    //   17	219	6	localObject1	Object
    //   262	5	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	262	finally
    //   27	57	262	finally
    //   57	63	262	finally
    //   68	74	262	finally
    //   74	88	262	finally
    //   93	99	262	finally
    //   99	108	262	finally
    //   108	126	262	finally
    //   131	137	262	finally
    //   137	143	262	finally
    //   143	168	262	finally
    //   173	179	262	finally
    //   179	185	262	finally
    //   185	224	262	finally
    //   229	235	262	finally
    //   235	259	262	finally
  }
  
  public void setAdapter(@Nullable ListAdapter paramListAdapter)
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null)
    {
      ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
      if (localListAdapter != null) {
        localListAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.HorizontalListView
 * JD-Core Version:    0.7.0.1
 */