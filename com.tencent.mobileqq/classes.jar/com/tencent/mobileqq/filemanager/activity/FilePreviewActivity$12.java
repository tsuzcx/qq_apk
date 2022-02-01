package com.tencent.mobileqq.filemanager.activity;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import auoe;
import auof;

class FilePreviewActivity$12
  implements Runnable
{
  FilePreviewActivity$12(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.e) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - this.this$0.jdField_a_of_type_AndroidViewViewGroup.getHeight());
    if (this.this$0.jdField_a_of_type_Auoe == null) {
      this.this$0.jdField_a_of_type_Auoe = new auoe(this.this$0.jdField_a_of_type_AndroidViewViewGroup);
    }
    auof localauof = new auof();
    localauof.jdField_a_of_type_JavaLangObject = localTranslateAnimation;
    localauof.jdField_a_of_type_Boolean = false;
    localauof.jdField_a_of_type_Int = auoe.b;
    localauof.b = 250;
    this.this$0.jdField_a_of_type_Auoe.a(localauof);
    this.this$0.jdField_a_of_type_Auoe.a();
    this.this$0.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.12
 * JD-Core Version:    0.7.0.1
 */