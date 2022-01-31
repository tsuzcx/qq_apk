package com.tencent.open.base;

import android.view.View;
import android.widget.Toast;
import bcyb;
import bdis;

public class ToastUtil$3
  implements Runnable
{
  public ToastUtil$3(bdis parambdis, View paramView, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.b == null)
    {
      this.this$0.b = new Toast(bcyb.a().a());
      this.this$0.b.setView(this.jdField_a_of_type_AndroidViewView);
      this.this$0.b.setDuration(this.jdField_a_of_type_Int);
      this.this$0.b.show();
      return;
    }
    this.this$0.b.setView(this.jdField_a_of_type_AndroidViewView);
    this.this$0.b.setDuration(this.jdField_a_of_type_Int);
    this.this$0.b.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.ToastUtil.3
 * JD-Core Version:    0.7.0.1
 */