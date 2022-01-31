package com.tencent.widget;

class FastScroller$1
  implements Runnable
{
  FastScroller$1(FastScroller paramFastScroller) {}
  
  public void run()
  {
    int k;
    int j;
    int i;
    if (this.this$0.jdField_a_of_type_ComTencentWidgetAbsListView.mIsAttached)
    {
      this.this$0.f();
      k = this.this$0.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight();
      j = (int)this.this$0.jdField_a_of_type_Float - this.this$0.jdField_a_of_type_Int + 10;
      if (j >= 0) {
        break label100;
      }
      i = 0;
    }
    for (;;)
    {
      this.this$0.c = i;
      this.this$0.a(this.this$0.c / (k - this.this$0.jdField_a_of_type_Int));
      this.this$0.b = false;
      return;
      label100:
      i = j;
      if (this.this$0.jdField_a_of_type_Int + j > k) {
        i = k - this.this$0.jdField_a_of_type_Int;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.FastScroller.1
 * JD-Core Version:    0.7.0.1
 */