package com.tencent.mobileqq.widget;

import android.os.Handler;

class CustomHorizontalScrollView$1
  implements Runnable
{
  CustomHorizontalScrollView$1(CustomHorizontalScrollView paramCustomHorizontalScrollView) {}
  
  public void run()
  {
    int i = this.this$0.getScrollX();
    if (i == this.this$0.jdField_a_of_type_Int)
    {
      int j = i % (this.this$0.b + this.this$0.c);
      if (this.this$0.e + i >= this.this$0.d) {
        return;
      }
      if (j < this.this$0.b / 2) {
        this.this$0.smoothScrollBy(-j, 0);
      }
      for (;;)
      {
        this.this$0.jdField_a_of_type_Int = i;
        return;
        if (j >= this.this$0.b / 2)
        {
          int k = this.this$0.b;
          int m = this.this$0.c;
          this.this$0.smoothScrollBy(k + m - j, 0);
        }
      }
    }
    this.this$0.jdField_a_of_type_Int = i;
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 5L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomHorizontalScrollView.1
 * JD-Core Version:    0.7.0.1
 */