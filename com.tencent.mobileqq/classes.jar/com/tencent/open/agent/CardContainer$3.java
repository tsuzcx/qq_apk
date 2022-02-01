package com.tencent.open.agent;

import android.graphics.drawable.Drawable;
import android.os.Message;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.LastModifySupportDownloader;

class CardContainer$3
  implements Runnable
{
  CardContainer$3(CardContainer paramCardContainer) {}
  
  public void run()
  {
    Object localObject = this.this$0.a();
    this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = Drawable.createFromPath(LastModifySupportDownloader.getCacheFilePath((String)localObject));
    if (this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      Message.obtain(this.this$0.jdField_a_of_type_AndroidOsHandler, 10001).sendToTarget();
    }
    do
    {
      return;
      localObject = CardContainer.a(this.this$0, (String)localObject);
    } while ((localObject == null) || (((URLDrawable)localObject).getStatus() != 1));
    this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
    Message.obtain(this.this$0.jdField_a_of_type_AndroidOsHandler, 10001).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.CardContainer.3
 * JD-Core Version:    0.7.0.1
 */