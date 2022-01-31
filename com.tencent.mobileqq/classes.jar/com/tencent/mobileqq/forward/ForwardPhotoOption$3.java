package com.tencent.mobileqq.forward;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import arwy;
import arwz;
import bdfq;

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
        this.this$0.s();
      }
    }
    else
    {
      return;
    }
    ForwardPhotoOption.a(this.this$0).a.setOnTouchListener(new arwy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPhotoOption.3
 * JD-Core Version:    0.7.0.1
 */