package com.tencent.open.base;

import android.widget.Toast;
import com.tencent.open.adapter.CommonDataAdapter;

class ToastUtil$1
  implements Runnable
{
  ToastUtil$1(ToastUtil paramToastUtil, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.a == null)
    {
      this.this$0.a = Toast.makeText(CommonDataAdapter.a().a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      this.this$0.a.show();
      return;
    }
    this.this$0.a.setText(this.jdField_a_of_type_JavaLangString);
    this.this$0.a.setDuration(this.jdField_a_of_type_Int);
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.base.ToastUtil.1
 * JD-Core Version:    0.7.0.1
 */