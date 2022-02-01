package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import java.util.List;
import java.util.concurrent.Executor;

class EmoticonFromGroupManager$6
  implements URLDrawable.URLDrawableListener
{
  EmoticonFromGroupManager$6(EmoticonFromGroupManager paramEmoticonFromGroupManager, URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    EmoticonFromGroupManager.b(this.b).getUploadDrawableList().remove(this.a);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    EmoticonFromGroupManager.b(this.b).getUploadDrawableList().remove(this.a);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    EmoticonFromGroupManager.b(this.b).getUploadDrawableList().remove(this.a);
    EmoticonFromGroupManager.g().execute(new EmoticonFromGroupManager.6.1(this, paramURLDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.6
 * JD-Core Version:    0.7.0.1
 */