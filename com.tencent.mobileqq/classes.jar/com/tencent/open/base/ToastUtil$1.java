package com.tencent.open.base;

import android.widget.Toast;
import bexd;
import bfhq;

public class ToastUtil$1
  implements Runnable
{
  public ToastUtil$1(bfhq parambfhq, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.a == null)
    {
      this.this$0.a = Toast.makeText(bexd.a().a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      this.this$0.a.show();
      return;
    }
    this.this$0.a.setText(this.jdField_a_of_type_JavaLangString);
    this.this$0.a.setDuration(this.jdField_a_of_type_Int);
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.ToastUtil.1
 * JD-Core Version:    0.7.0.1
 */