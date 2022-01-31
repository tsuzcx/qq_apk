package com.tencent.open.agent;

import android.graphics.drawable.Drawable;
import android.os.Message;
import aysf;

class OpenCardContainer$5
  implements Runnable
{
  OpenCardContainer$5(OpenCardContainer paramOpenCardContainer) {}
  
  public void run()
  {
    String str = this.this$0.a();
    this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = Drawable.createFromPath(aysf.a(str));
    if (this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      Message.obtain(this.this$0.jdField_a_of_type_AndroidOsHandler, 10001).sendToTarget();
      return;
    }
    Message localMessage = Message.obtain(this.this$0.jdField_a_of_type_AndroidOsHandler, 10002);
    localMessage.obj = str;
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.5
 * JD-Core Version:    0.7.0.1
 */