package com.tencent.mobileqq.filemanager.activity;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import apdf;
import apdg;

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
    if (this.this$0.jdField_a_of_type_Apdf == null) {
      this.this$0.jdField_a_of_type_Apdf = new apdf(this.this$0.jdField_a_of_type_AndroidViewViewGroup);
    }
    apdg localapdg = new apdg();
    localapdg.jdField_a_of_type_JavaLangObject = localTranslateAnimation;
    localapdg.jdField_a_of_type_Boolean = false;
    localapdg.jdField_a_of_type_Int = apdf.b;
    localapdg.b = 250;
    this.this$0.jdField_a_of_type_Apdf.a(localapdg);
    this.this$0.jdField_a_of_type_Apdf.a();
    this.this$0.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.12
 * JD-Core Version:    0.7.0.1
 */