package com.tencent.mobileqq.filemanager.activity;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import atao;
import atap;

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
    if (this.this$0.jdField_a_of_type_Atao == null) {
      this.this$0.jdField_a_of_type_Atao = new atao(this.this$0.jdField_a_of_type_AndroidViewViewGroup);
    }
    atap localatap = new atap();
    localatap.jdField_a_of_type_JavaLangObject = localTranslateAnimation;
    localatap.jdField_a_of_type_Boolean = false;
    localatap.jdField_a_of_type_Int = atao.b;
    localatap.b = 250;
    this.this$0.jdField_a_of_type_Atao.a(localatap);
    this.this$0.jdField_a_of_type_Atao.a();
    this.this$0.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.12
 * JD-Core Version:    0.7.0.1
 */