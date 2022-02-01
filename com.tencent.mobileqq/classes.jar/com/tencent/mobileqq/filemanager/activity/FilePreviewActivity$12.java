package com.tencent.mobileqq.filemanager.activity;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;

class FilePreviewActivity$12
  implements Runnable
{
  FilePreviewActivity$12(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.I) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - this.this$0.o.getHeight());
    if (this.this$0.N == null)
    {
      localObject = this.this$0;
      ((FilePreviewActivity)localObject).N = new FilePreviewAnimQueue(((FilePreviewActivity)localObject).o);
    }
    Object localObject = new FilePreviewAnimQueue.FilePreviewAnim();
    ((FilePreviewAnimQueue.FilePreviewAnim)localObject).a = localTranslateAnimation;
    ((FilePreviewAnimQueue.FilePreviewAnim)localObject).c = false;
    ((FilePreviewAnimQueue.FilePreviewAnim)localObject).b = FilePreviewAnimQueue.b;
    ((FilePreviewAnimQueue.FilePreviewAnim)localObject).d = 250;
    this.this$0.N.a((FilePreviewAnimQueue.FilePreviewAnim)localObject);
    this.this$0.N.a();
    this.this$0.I = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.12
 * JD-Core Version:    0.7.0.1
 */