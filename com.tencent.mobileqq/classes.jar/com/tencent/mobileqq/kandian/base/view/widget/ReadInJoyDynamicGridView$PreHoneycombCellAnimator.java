package com.tencent.mobileqq.kandian.base.view.widget;

class ReadInJoyDynamicGridView$PreHoneycombCellAnimator
  implements ReadInJoyDynamicGridView.SwitchCellAnimator
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public ReadInJoyDynamicGridView$PreHoneycombCellAnimator(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ReadInJoyDynamicGridView localReadInJoyDynamicGridView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView;
    ReadInJoyDynamicGridView.a(localReadInJoyDynamicGridView, ReadInJoyDynamicGridView.a(localReadInJoyDynamicGridView) + this.jdField_a_of_type_Int);
    localReadInJoyDynamicGridView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyDynamicGridView;
    ReadInJoyDynamicGridView.b(localReadInJoyDynamicGridView, ReadInJoyDynamicGridView.b(localReadInJoyDynamicGridView) + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.PreHoneycombCellAnimator
 * JD-Core Version:    0.7.0.1
 */