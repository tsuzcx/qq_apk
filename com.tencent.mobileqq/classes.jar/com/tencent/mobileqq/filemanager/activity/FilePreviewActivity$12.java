package com.tencent.mobileqq.filemanager.activity;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import atwj;
import atwk;

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
    if (this.this$0.jdField_a_of_type_Atwj == null) {
      this.this$0.jdField_a_of_type_Atwj = new atwj(this.this$0.jdField_a_of_type_AndroidViewViewGroup);
    }
    atwk localatwk = new atwk();
    localatwk.jdField_a_of_type_JavaLangObject = localTranslateAnimation;
    localatwk.jdField_a_of_type_Boolean = false;
    localatwk.jdField_a_of_type_Int = atwj.b;
    localatwk.b = 250;
    this.this$0.jdField_a_of_type_Atwj.a(localatwk);
    this.this$0.jdField_a_of_type_Atwj.a();
    this.this$0.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.12
 * JD-Core Version:    0.7.0.1
 */