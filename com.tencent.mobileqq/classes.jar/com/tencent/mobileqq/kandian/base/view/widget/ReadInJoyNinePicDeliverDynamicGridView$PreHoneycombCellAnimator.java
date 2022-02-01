package com.tencent.mobileqq.kandian.base.view.widget;

class ReadInJoyNinePicDeliverDynamicGridView$PreHoneycombCellAnimator
  implements ReadInJoyNinePicDeliverDynamicGridView.SwitchCellAnimator
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public ReadInJoyNinePicDeliverDynamicGridView$PreHoneycombCellAnimator(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ReadInJoyNinePicDeliverDynamicGridView localReadInJoyNinePicDeliverDynamicGridView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView;
    ReadInJoyNinePicDeliverDynamicGridView.a(localReadInJoyNinePicDeliverDynamicGridView, ReadInJoyNinePicDeliverDynamicGridView.a(localReadInJoyNinePicDeliverDynamicGridView) + this.jdField_a_of_type_Int);
    localReadInJoyNinePicDeliverDynamicGridView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyNinePicDeliverDynamicGridView;
    ReadInJoyNinePicDeliverDynamicGridView.b(localReadInJoyNinePicDeliverDynamicGridView, ReadInJoyNinePicDeliverDynamicGridView.b(localReadInJoyNinePicDeliverDynamicGridView) + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.PreHoneycombCellAnimator
 * JD-Core Version:    0.7.0.1
 */