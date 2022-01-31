package com.tencent.open.agent;

import android.graphics.drawable.Drawable;
import android.os.Message;
import aysf;

class CardHeadLayout$3
  implements Runnable
{
  public void run()
  {
    this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = Drawable.createFromPath(aysf.a(this.this$0.a()));
    if (this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      Message.obtain(this.this$0.jdField_a_of_type_AndroidOsHandler, 10001).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.CardHeadLayout.3
 * JD-Core Version:    0.7.0.1
 */