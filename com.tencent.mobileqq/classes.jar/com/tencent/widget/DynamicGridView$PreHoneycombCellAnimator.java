package com.tencent.widget;

class DynamicGridView$PreHoneycombCellAnimator
  implements DynamicGridView.SwitchCellAnimator
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public DynamicGridView$PreHoneycombCellAnimator(DynamicGridView paramDynamicGridView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    DynamicGridView localDynamicGridView = this.jdField_a_of_type_ComTencentWidgetDynamicGridView;
    DynamicGridView.a(localDynamicGridView, DynamicGridView.a(localDynamicGridView) + this.jdField_a_of_type_Int);
    localDynamicGridView = this.jdField_a_of_type_ComTencentWidgetDynamicGridView;
    DynamicGridView.b(localDynamicGridView, DynamicGridView.b(localDynamicGridView) + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.PreHoneycombCellAnimator
 * JD-Core Version:    0.7.0.1
 */