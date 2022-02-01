package com.tencent.mobileqq.kandian.base.view.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class ReadInJoyNinePicDeliverDynamicGridView$6
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = -1;
  private int b = -1;
  private int c;
  private int d;
  private int e;
  
  ReadInJoyNinePicDeliverDynamicGridView$6(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView) {}
  
  private void c()
  {
    if ((this.d > 0) && (this.e == 0))
    {
      if ((ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView)) && (ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView)))
      {
        ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView);
        return;
      }
      if (ReadInJoyNinePicDeliverDynamicGridView.c(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView)) {
        ReadInJoyNinePicDeliverDynamicGridView.c(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView);
      }
    }
  }
  
  public void a()
  {
    if ((this.c != this.jdField_a_of_type_Int) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView)) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView) != -1L))
    {
      ReadInJoyNinePicDeliverDynamicGridView localReadInJoyNinePicDeliverDynamicGridView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView;
      ReadInJoyNinePicDeliverDynamicGridView.a(localReadInJoyNinePicDeliverDynamicGridView, ReadInJoyNinePicDeliverDynamicGridView.a(localReadInJoyNinePicDeliverDynamicGridView));
      ReadInJoyNinePicDeliverDynamicGridView.d(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView);
    }
  }
  
  public void b()
  {
    if ((this.c + this.d != this.jdField_a_of_type_Int + this.b) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView)) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView) != -1L))
    {
      ReadInJoyNinePicDeliverDynamicGridView localReadInJoyNinePicDeliverDynamicGridView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView;
      ReadInJoyNinePicDeliverDynamicGridView.a(localReadInJoyNinePicDeliverDynamicGridView, ReadInJoyNinePicDeliverDynamicGridView.a(localReadInJoyNinePicDeliverDynamicGridView));
      ReadInJoyNinePicDeliverDynamicGridView.d(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView);
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
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.e = paramInt;
    ReadInJoyNinePicDeliverDynamicGridView.c(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView, paramInt);
    c();
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.6
 * JD-Core Version:    0.7.0.1
 */