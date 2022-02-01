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
    if (this.this$0.b == null)
    {
      localObject = this.this$0;
      ((FilePreviewActivity)localObject).b = new FilePreviewAnimQueue(((FilePreviewActivity)localObject).a);
    }
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = new FilePreviewAnimQueue.FilePreviewAnim();
    localFilePreviewAnim.jdField_a_of_type_JavaLangObject = localObject;
    localFilePreviewAnim.jdField_a_of_type_Boolean = false;
    localFilePreviewAnim.jdField_a_of_type_Int = FilePreviewAnimQueue.jdField_a_of_type_Int;
    localFilePreviewAnim.b = 1500;
    this.this$0.b.a(localFilePreviewAnim);
    this.this$0.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.11
 * JD-Core Version:    0.7.0.1
 */