package com.tencent.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DynamicGridView$6
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = -1;
  private int b = -1;
  private int c;
  private int d;
  private int e;
  
  DynamicGridView$6(DynamicGridView paramDynamicGridView) {}
  
  private void c()
  {
    if ((this.d > 0) && (this.e == 0))
    {
      if ((DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView)) && (DynamicGridView.b(this.jdField_a_of_type_ComTencentWidgetDynamicGridView)))
      {
        DynamicGridView.b(this.jdField_a_of_type_ComTencentWidgetDynamicGridView);
        return;
      }
      if (DynamicGridView.c(this.jdField_a_of_type_ComTencentWidgetDynamicGridView)) {
        DynamicGridView.c(this.jdField_a_of_type_ComTencentWidgetDynamicGridView);
      }
    }
  }
  
  public void a()
  {
    if ((this.c != this.jdField_a_of_type_Int) && (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView)) && (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView) != -1L))
    {
      DynamicGridView localDynamicGridView = this.jdField_a_of_type_ComTencentWidgetDynamicGridView;
      DynamicGridView.a(localDynamicGridView, DynamicGridView.a(localDynamicGridView));
      DynamicGridView.d(this.jdField_a_of_type_ComTencentWidgetDynamicGridView);
    }
  }
  
  public void b()
  {
    if ((this.c + this.d != this.jdField_a_of_type_Int + this.b) && (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView)) && (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView) != -1L))
    {
      DynamicGridView localDynamicGridView = this.jdField_a_of_type_ComTencentWidgetDynamicGridView;
      DynamicGridView.a(localDynamicGridView, DynamicGridView.a(localDynamicGridView));
      DynamicGridView.d(this.jdField_a_of_type_ComTencentWidgetDynamicGridView);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j == -1) {
      i = this.c;
    }
    this.jdField_a_of_type_Int = i;
    j = this.b;
    i = j;
    if (j == -1) {
      i = this.d;
    }
    this.b = i;
    a();
    b();
    this.jdField_a_of_type_Int = this.c;
    this.b = this.d;
    if (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView) != null) {
      DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    this.e = paramInt;
    DynamicGridView.c(this.jdField_a_of_type_ComTencentWidgetDynamicGridView, paramInt);
    c();
    if (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView) != null) {
      DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.6
 * JD-Core Version:    0.7.0.1
 */