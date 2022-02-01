package com.tencent.mobileqq.forward;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ForwardBaseOption$10
  implements Runnable
{
  ForwardBaseOption$10(ForwardBaseOption paramForwardBaseOption, Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.this$0.A.isShowing())
    {
      this.this$0.A.setPreviewImage(this.a, this.b, this.c, this.d);
      this.this$0.X();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.10
 * JD-Core Version:    0.7.0.1
 */