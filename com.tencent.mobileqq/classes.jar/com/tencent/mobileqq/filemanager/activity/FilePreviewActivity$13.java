package com.tencent.mobileqq.filemanager.activity;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import apvb;
import apvc;

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
    if (this.this$0.jdField_a_of_type_Apvb == null) {
      this.this$0.jdField_a_of_type_Apvb = new apvb(this.this$0.jdField_a_of_type_AndroidViewViewGroup);
    }
    apvc localapvc = new apvc();
    localapvc.jdField_a_of_type_JavaLangObject = localTranslateAnimation;
    localapvc.jdField_a_of_type_Boolean = true;
    localapvc.jdField_a_of_type_Int = apvb.b;
    localapvc.b = 250;
    this.this$0.jdField_a_of_type_Apvb.a(localapvc);
    this.this$0.jdField_a_of_type_Apvb.a();
    this.this$0.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.13
 * JD-Core Version:    0.7.0.1
 */