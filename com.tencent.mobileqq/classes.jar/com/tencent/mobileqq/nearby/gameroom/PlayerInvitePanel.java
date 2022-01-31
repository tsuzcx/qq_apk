package com.tencent.mobileqq.nearby.gameroom;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import auvf;
import auvg;
import java.util.LinkedList;
import java.util.List;

public class PlayerInvitePanel
  extends AdapterView<BaseAdapter>
{
  private int jdField_a_of_type_Int = 5;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new auvg(this);
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private List<View> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  public PlayerInvitePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected View a()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return (View)this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return null;
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter;
  }
  
  public void a()
  {
    b();
    detachAllViewsFromParent();
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetBaseAdapter.getView(i, a(), this);
      localView.setOnClickListener(new auvf(this, i));
      addViewInLayout(localView, i, new ViewGroup.LayoutParams(-2, -2));
      i += 1;
    }
    requestLayout();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < getChildCount())
    {
      this.jdField_a_of_type_JavaUtilList.add(getChildAt(i));
      i += 1;
    }
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = super.getChildCount();
    if (k > this.jdField_a_of_type_Int) {}
    for (int i = this.jdField_a_of_type_Int;; i = k)
    {
      int m = paramInt3 - paramInt1;
      int j = 0;
      while (j < k)
      {
        View localView = super.getChildAt(j);
        int n = localView.getMeasuredWidth();
        int i1 = localView.getMeasuredHeight();
        int i3 = (m - this.jdField_a_of_type_Int * n) / (this.jdField_a_of_type_Int + 1);
        int i2 = (m - i * n - (i - 1) * i3) / 2 + (n + i3) * (j % this.jdField_a_of_type_Int);
        i3 = (i3 + i1) * (j / this.jdField_a_of_type_Int);
        localView.layout(i2, i3, n + i2, i1 + i3);
        j += 1;
      }
    }
    invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      measureChild(getChildAt(i), paramInt1, paramInt2);
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    a();
  }
  
  public void setColumnCount(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void setSelection(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.PlayerInvitePanel
 * JD-Core Version:    0.7.0.1
 */