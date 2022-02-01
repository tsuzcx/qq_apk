package com.tencent.open.agent;

import android.graphics.drawable.Drawable;
import android.os.Message;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.LastModifySupportDownloader;

class OpenCardContainer$5
  implements Runnable
{
  OpenCardContainer$5(OpenCardContainer paramOpenCardContainer) {}
  
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
      localObject = OpenCardContainer.a(this.this$0, (String)localObject);
    } while ((localObject == null) || (((URLDrawable)localObject).getStatus() != 1));
    this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
    Message.obtain(this.this$0.jdField_a_of_type_AndroidOsHandler, 10001).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.5
 * JD-Core Version:    0.7.0.1
 */