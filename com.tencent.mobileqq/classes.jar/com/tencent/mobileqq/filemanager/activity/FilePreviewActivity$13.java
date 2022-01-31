package com.tencent.mobileqq.filemanager.activity;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import arsm;
import arsn;

class FilePreviewActivity$13
  implements Runnable
{
  FilePreviewActivity$13(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (!this.this$0.d) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0 - this.this$0.jdField_a_of_type_AndroidViewViewGroup.getHeight(), 0.0F);
    if (this.this$0.jdField_a_of_type_Arsm == null) {
      this.this$0.jdField_a_of_type_Arsm = new arsm(this.this$0.jdField_a_of_type_AndroidViewViewGroup);
    }
    arsn localarsn = new arsn();
    localarsn.jdField_a_of_type_JavaLangObject = localTranslateAnimation;
    localarsn.jdField_a_of_type_Boolean = true;
    localarsn.jdField_a_of_type_Int = arsm.b;
    localarsn.b = 250;
    this.this$0.jdField_a_of_type_Arsm.a(localarsn);
    this.this$0.jdField_a_of_type_Arsm.a();
    this.this$0.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.13
 * JD-Core Version:    0.7.0.1
 */