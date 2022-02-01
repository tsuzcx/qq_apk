package com.tencent.mobileqq.forward;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import avah;
import avai;
import bhpc;

public class ForwardPhotoOption$3
  implements Runnable
{
  ForwardPhotoOption$3(ForwardPhotoOption paramForwardPhotoOption, Drawable paramDrawable, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.a.isShowing()) && (ForwardPhotoOption.a(this.this$0) != null))
    {
      ForwardPhotoOption.a(this.this$0).a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, false);
      if (ForwardPhotoOption.a(this.this$0)) {
        this.this$0.t();
      }
    }
    else
    {
      return;
    }
    ForwardPhotoOption.a(this.this$0).a.setOnTouchListener(new avah(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPhotoOption.3
 * JD-Core Version:    0.7.0.1
 */