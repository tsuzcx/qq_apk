package com.tencent.mobileqq.filemanager.widget;

import adrg;
import adri;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.LinkedList;
import java.util.Queue;

public class QfileHorizontalListView
  extends AdapterView
{
  protected int a;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new adrg(this);
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new adri(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public ListAdapter a;
  protected Scroller a;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  private AdapterView.OnItemLongClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener;
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener;
  private Queue jdField_a_of_type_JavaUtilQueue = new LinkedList();
  public boolean a;
  public int b;
  private boolean b;
  private int c = -1;
  private int d;
  private int e = 2147483647;
  private int f;
  
  public QfileHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  private void a()
  {
    try
    {
      this.c = -1;
      this.d = 0;
      this.f = 0;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
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
  
  private void a(int paramInt)
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
  
  private void a(int paramInt1, int paramInt2)
  {
    while ((paramInt1 + paramInt2 < getWidth()) && (this.d < this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()))
    {
      View localView = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(this.d, (View)this.jdField_a_of_type_JavaUtilQueue.poll(), this);
      a(localView, -1);
      paramInt1 += localView.getMeasuredWidth();
      if (this.d == this.jdField_a_of_type_AndroidWidgetListAdapter.getCount() - 1) {
        this.e = (this.jdField_a_of_type_Int + paramInt1 - getWidth());
      }
      if (this.e < 0) {
        this.e = 0;
      }
      this.d += 1;
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    addViewInLayout(paramView, paramInt, localLayoutParams1, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
  }
  
  private void b()
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
  
  private void b(int paramInt)
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
  
  private void b(int paramInt1, int paramInt2)
  {
    while ((paramInt1 + paramInt2 > 0) && (this.c >= 0))
    {
      View localView = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(this.c, (View)this.jdField_a_of_type_JavaUtilQueue.poll(), this);
      a(localView, 0);
      paramInt1 -= localView.getMeasuredWidth();
      this.c -= 1;
      this.f -= localView.getMeasuredWidth();
    }
  }
  
  private void c(int paramInt)
  {
    if (getChildCount() > 0)
    {
      this.f += paramInt;
      int i = this.f;
      paramInt = 0;
      while (paramInt < getChildCount())
      {
        View localView = getChildAt(paramInt);
        int j = localView.getMeasuredWidth();
        localView.layout(i, 0, i + j, localView.getMeasuredHeight());
        i += localView.getPaddingRight() + j;
        paramInt += 1;
      }
    }
  }
  
  public ListAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetScroller.fling(this.jdField_b_of_type_Int, 0, (int)-paramFloat1, 0, 0, this.e, 0, 0);
      requestLayout();
      return true;
    }
    finally {}
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent) | this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  /* Error */
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
    //   10: invokespecial 219	com/tencent/widget/AdapterView:onLayout	(ZIIII)V
    //   13: aload_0
    //   14: getfield 117	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_a_of_type_AndroidWidgetListAdapter	Landroid/widget/ListAdapter;
    //   17: astore 6
    //   19: aload 6
    //   21: ifnonnull +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 168	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_b_of_type_Boolean	Z
    //   31: ifeq +26 -> 57
    //   34: aload_0
    //   35: getfield 70	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_a_of_type_Int	I
    //   38: istore_2
    //   39: aload_0
    //   40: invokespecial 53	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:a	()V
    //   43: aload_0
    //   44: invokevirtual 171	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:removeAllViewsInLayout	()V
    //   47: aload_0
    //   48: iload_2
    //   49: putfield 72	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_b_of_type_Int	I
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 168	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_b_of_type_Boolean	Z
    //   57: aload_0
    //   58: getfield 83	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_a_of_type_AndroidWidgetScroller	Landroid/widget/Scroller;
    //   61: invokevirtual 223	android/widget/Scroller:computeScrollOffset	()Z
    //   64: ifeq +14 -> 78
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 83	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_a_of_type_AndroidWidgetScroller	Landroid/widget/Scroller;
    //   72: invokevirtual 226	android/widget/Scroller:getCurrX	()I
    //   75: putfield 72	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_b_of_type_Int	I
    //   78: aload_0
    //   79: getfield 72	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_b_of_type_Int	I
    //   82: ifgt +16 -> 98
    //   85: aload_0
    //   86: iconst_0
    //   87: putfield 72	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_b_of_type_Int	I
    //   90: aload_0
    //   91: getfield 83	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_a_of_type_AndroidWidgetScroller	Landroid/widget/Scroller;
    //   94: iconst_1
    //   95: invokevirtual 198	android/widget/Scroller:forceFinished	(Z)V
    //   98: aload_0
    //   99: getfield 72	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_b_of_type_Int	I
    //   102: aload_0
    //   103: getfield 32	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:e	I
    //   106: if_icmplt +19 -> 125
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 32	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:e	I
    //   114: putfield 72	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_b_of_type_Int	I
    //   117: aload_0
    //   118: getfield 83	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_a_of_type_AndroidWidgetScroller	Landroid/widget/Scroller;
    //   121: iconst_1
    //   122: invokevirtual 198	android/widget/Scroller:forceFinished	(Z)V
    //   125: aload_0
    //   126: getfield 70	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_a_of_type_Int	I
    //   129: aload_0
    //   130: getfield 72	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_b_of_type_Int	I
    //   133: isub
    //   134: istore_2
    //   135: aload_0
    //   136: iload_2
    //   137: invokespecial 228	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:b	(I)V
    //   140: aload_0
    //   141: iload_2
    //   142: invokespecial 230	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:a	(I)V
    //   145: aload_0
    //   146: iload_2
    //   147: invokespecial 232	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:c	(I)V
    //   150: aload_0
    //   151: aload_0
    //   152: getfield 72	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_b_of_type_Int	I
    //   155: putfield 70	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_a_of_type_Int	I
    //   158: aload_0
    //   159: getfield 83	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:jdField_a_of_type_AndroidWidgetScroller	Landroid/widget/Scroller;
    //   162: invokevirtual 235	android/widget/Scroller:isFinished	()Z
    //   165: ifne -141 -> 24
    //   168: aload_0
    //   169: new 237	adrh
    //   172: dup
    //   173: aload_0
    //   174: invokespecial 238	adrh:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileHorizontalListView;)V
    //   177: invokevirtual 242	com/tencent/mobileqq/filemanager/widget/QfileHorizontalListView:post	(Ljava/lang/Runnable;)Z
    //   180: pop
    //   181: goto -157 -> 24
    //   184: astore 6
    //   186: aload_0
    //   187: monitorexit
    //   188: aload 6
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	QfileHorizontalListView
    //   0	191	1	paramBoolean	boolean
    //   0	191	2	paramInt1	int
    //   0	191	3	paramInt2	int
    //   0	191	4	paramInt3	int
    //   0	191	5	paramInt4	int
    //   17	3	6	localListAdapter	ListAdapter
    //   184	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	184	finally
    //   27	57	184	finally
    //   57	78	184	finally
    //   78	98	184	finally
    //   98	125	184	finally
    //   125	181	184	finally
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
      this.jdField_a_of_type_AndroidWidgetListAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    this.jdField_a_of_type_AndroidWidgetListAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    b();
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public void setSelection(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileHorizontalListView
 * JD-Core Version:    0.7.0.1
 */