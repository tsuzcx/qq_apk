package com.tencent.mobileqq.filemanager.activity;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import apuz;
import apva;

class FilePreviewActivity$12
  implements Runnable
{
  FilePreviewActivity$12(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.d) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - this.this$0.jdField_a_of_type_AndroidViewViewGroup.getHeight());
    if (this.this$0.jdField_a_of_type_Apuz == null) {
      this.this$0.jdField_a_of_type_Apuz = new apuz(this.this$0.jdField_a_of_type_AndroidViewViewGroup);
    }
    apva localapva = new apva();
    localapva.jdField_a_of_type_JavaLangObject = localTranslateAnimation;
    localapva.jdField_a_of_type_Boolean = false;
    localapva.jdField_a_of_type_Int = apuz.b;
    localapva.b = 250;
    this.this$0.jdField_a_of_type_Apuz.a(localapva);
    this.this$0.jdField_a_of_type_Apuz.a();
    this.this$0.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.12
 * JD-Core Version:    0.7.0.1
 */