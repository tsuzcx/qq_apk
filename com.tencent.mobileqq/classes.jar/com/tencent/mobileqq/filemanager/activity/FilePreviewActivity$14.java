package com.tencent.mobileqq.filemanager.activity;

import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;
import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$14
  implements Runnable
{
  FilePreviewActivity$14(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.P == null)
    {
      localObject = this.this$0;
      ((FilePreviewActivity)localObject).P = new FilePreviewAnimQueue(((FilePreviewActivity)localObject).u);
    }
    this.this$0.y.setVisibility(0);
    this.this$0.z.setText(2131892266);
    Object localObject = new AlphaAnimation(0.5F, 1.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = new FilePreviewAnimQueue.FilePreviewAnim();
    localFilePreviewAnim.a = localObject;
    localFilePreviewAnim.c = true;
    localFilePreviewAnim.b = FilePreviewAnimQueue.a;
    localFilePreviewAnim.d = 1000;
    this.this$0.P.a(localFilePreviewAnim);
    this.this$0.P.a();
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "showGetmore(1000)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.14
 * JD-Core Version:    0.7.0.1
 */