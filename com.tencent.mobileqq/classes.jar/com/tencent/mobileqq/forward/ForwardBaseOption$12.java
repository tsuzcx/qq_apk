package com.tencent.mobileqq.forward;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ForwardBaseOption$12
  implements Runnable
{
  ForwardBaseOption$12(ForwardBaseOption paramForwardBaseOption, Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.this$0.a.isShowing())
    {
      this.this$0.a.setPreviewImage(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.b);
      this.this$0.t();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.12
 * JD-Core Version:    0.7.0.1
 */