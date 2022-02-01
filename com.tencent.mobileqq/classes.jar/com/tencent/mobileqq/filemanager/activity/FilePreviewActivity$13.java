package com.tencent.mobileqq.filemanager.activity;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;

class FilePreviewActivity$13
  implements Runnable
{
  FilePreviewActivity$13(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (!this.this$0.e) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0 - this.this$0.jdField_a_of_type_AndroidViewViewGroup.getHeight(), 0.0F);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue == null)
    {
      localObject = this.this$0;
      ((FilePreviewActivity)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue = new FilePreviewAnimQueue(((FilePreviewActivity)localObject).jdField_a_of_type_AndroidViewViewGroup);
    }
    Object localObject = new FilePreviewAnimQueue.FilePreviewAnim();
    ((FilePreviewAnimQueue.FilePreviewAnim)localObject).jdField_a_of_type_JavaLangObject = localTranslateAnimation;
    ((FilePreviewAnimQueue.FilePreviewAnim)localObject).jdField_a_of_type_Boolean = true;
    ((FilePreviewAnimQueue.FilePreviewAnim)localObject).jdField_a_of_type_Int = FilePreviewAnimQueue.b;
    ((FilePreviewAnimQueue.FilePreviewAnim)localObject).b = 250;
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.a((FilePreviewAnimQueue.FilePreviewAnim)localObject);
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.a();
    this.this$0.e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.13
 * JD-Core Version:    0.7.0.1
 */