package com.tencent.open.agent;

import android.graphics.drawable.Drawable;
import android.os.Message;
import aysh;

class CardContainer$3
  implements Runnable
{
  CardContainer$3(CardContainer paramCardContainer) {}
  
  public void run()
  {
    String str = this.this$0.a();
    this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = Drawable.createFromPath(aysh.a(str));
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
 * Qualified Name:     com.tencent.open.agent.CardContainer.3
 * JD-Core Version:    0.7.0.1
 */