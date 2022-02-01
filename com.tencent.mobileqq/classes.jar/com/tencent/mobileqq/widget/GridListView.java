package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;

@Deprecated
public class GridListView
  extends XListView
{
  int jdField_a_of_type_Int = 0;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView = new View(getContext());
  GridListView.GridListAdapter jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter;
  GridListView.WraperAdapter jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter = new GridListView.WraperAdapter(this);
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  int b = 4;
  int c = 0;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  
  public GridListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GridListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GridListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    if (this.d != paramInt) {
      b(paramInt);
    }
  }
  
  private void b(int paramInt)
  {
    this.d = paramInt;
    this.c = this.d;
    if (this.jdField_a_of_type_Int == 1) {
      this.c = ((this.d + this.b - 1) / this.b);
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (paramListAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter = ((GridListView.GridListAdapter)paramListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.registerDataSetObserver(new GridListView.1(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.a(this.jdField_a_of_type_Int);
    this.i = this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.a();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getCount());
    super.setAdapter(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter);
  }
  
  public void setEmptyView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (this.d == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetChanged();
    }
  }
  
  public void setGridSize(int paramInt)
  {
    setGridSize(paramInt, paramInt);
  }
  
  public void setGridSize(int paramInt1, int paramInt2)
  {
    if ((this.g != paramInt1) || (this.h != paramInt2))
    {
      this.g = paramInt1;
      this.h = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetChanged();
    }
  }
  
  public void setGridSpacing(int paramInt1, int paramInt2)
  {
    if ((this.e != paramInt1) || (this.f != paramInt2))
    {
      this.e = paramInt1;
      this.f = paramInt2;
      if (this.jdField_a_of_type_Int == 1) {
        setPadding(0, 0, 0, this.f);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetChanged();
    }
  }
  
  public void setMode(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.a(this.jdField_a_of_type_Int);
        b(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getCount());
      }
      if (this.jdField_a_of_type_Int != 1) {
        break label71;
      }
    }
    label71:
    for (paramInt = this.f;; paramInt = 0)
    {
      setPadding(0, 0, 0, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetChanged();
      return;
    }
  }
  
  public void setNumColumns(int paramInt)
  {
    if (paramInt != this.b)
    {
      this.b = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getCount());
      }
    }
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new GridListView.2(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GridListView
 * JD-Core Version:    0.7.0.1
 */