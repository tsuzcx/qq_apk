package com.tencent.mobileqq.filemanager.activity;

import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;
import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$15
  implements Runnable
{
  FilePreviewActivity$15(FilePreviewActivity paramFilePreviewActivity, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.P == null)
    {
      localObject = this.this$0;
      ((FilePreviewActivity)localObject).P = new FilePreviewAnimQueue(((FilePreviewActivity)localObject).u);
    }
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = new FilePreviewAnimQueue.FilePreviewAnim();
    localFilePreviewAnim.a = localObject;
    localFilePreviewAnim.c = false;
    localFilePreviewAnim.b = FilePreviewAnimQueue.a;
    localFilePreviewAnim.d = this.a;
    this.this$0.P.a(localFilePreviewAnim);
    this.this$0.P.a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideGetMore(");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(")");
      QLog.i("<FileAssistant>FilePreviewActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.15
 * JD-Core Version:    0.7.0.1
 */