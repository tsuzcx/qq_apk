package com.tencent.mobileqq.filemanager.activity;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import auev;
import auew;

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
    if (this.this$0.jdField_a_of_type_Auev == null) {
      this.this$0.jdField_a_of_type_Auev = new auev(this.this$0.jdField_a_of_type_AndroidViewViewGroup);
    }
    auew localauew = new auew();
    localauew.jdField_a_of_type_JavaLangObject = localTranslateAnimation;
    localauew.jdField_a_of_type_Boolean = false;
    localauew.jdField_a_of_type_Int = auev.b;
    localauew.b = 250;
    this.this$0.jdField_a_of_type_Auev.a(localauew);
    this.this$0.jdField_a_of_type_Auev.a();
    this.this$0.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.12
 * JD-Core Version:    0.7.0.1
 */