package com.tencent.mobileqq.kandian.base.view.widget;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class ReadInJoyDynamicGridView$6
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = -1;
  private int b = -1;
  private int c;
  private int d;
  private int e;
  
  ReadInJoyDynamicGridView$6(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView) {}
  
  private void c()
  {
    if ((this.d > 0) && (this.e == 0))
    {
      if ((ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView)) && (ReadInJoyDynamicGridView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView)))
      {
        ReadInJoyDynamicGridView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView);
        return;
      }
      if (ReadInJoyDynamicGridView.c(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView)) {
        ReadInJoyDynamicGridView.c(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView);
      }
    }
  }
  
  public void a()
  {
    if ((this.c != this.jdField_a_of_type_Int) && (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView)) && (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView) != -1L))
    {
      ReadInJoyDynamicGridView localReadInJoyDynamicGridView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView;
      ReadInJoyDynamicGridView.a(localReadInJoyDynamicGridView, ReadInJoyDynamicGridView.a(localReadInJoyDynamicGridView));
      ReadInJoyDynamicGridView.d(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView);
    }
  }
  
  public void b()
  {
    if ((this.c + this.d != this.jdField_a_of_type_Int + this.b) && (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView)) && (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView) != -1L))
    {
      ReadInJoyDynamicGridView localReadInJoyDynamicGridView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView;
      ReadInJoyDynamicGridView.a(localReadInJoyDynamicGridView, ReadInJoyDynamicGridView.a(localReadInJoyDynamicGridView));
      ReadInJoyDynamicGridView.d(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView);
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
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.e = paramInt;
    ReadInJoyDynamicGridView.c(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView, paramInt);
    c();
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.6
 * JD-Core Version:    0.7.0.1
 */