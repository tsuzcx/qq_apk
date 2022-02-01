package com.tencent.mobileqq.filemanager.activity;

import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;

class FilePreviewActivity$11
  implements Runnable
{
  FilePreviewActivity$11(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.O == null)
    {
      localObject = this.this$0;
      ((FilePreviewActivity)localObject).O = new FilePreviewAnimQueue(((FilePreviewActivity)localObject).v);
    }
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = new FilePreviewAnimQueue.FilePreviewAnim();
    localFilePreviewAnim.a = localObject;
    localFilePreviewAnim.c = false;
    localFilePreviewAnim.b = FilePreviewAnimQueue.a;
    localFilePreviewAnim.d = 1500;
    this.this$0.O.a(localFilePreviewAnim);
    this.this$0.O.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.11
 * JD-Core Version:    0.7.0.1
 */