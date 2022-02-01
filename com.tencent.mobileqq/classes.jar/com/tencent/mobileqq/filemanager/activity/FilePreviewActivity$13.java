package com.tencent.mobileqq.filemanager.activity;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import atao;
import atap;

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
    if (this.this$0.jdField_a_of_type_Atao == null) {
      this.this$0.jdField_a_of_type_Atao = new atao(this.this$0.jdField_a_of_type_AndroidViewViewGroup);
    }
    atap localatap = new atap();
    localatap.jdField_a_of_type_JavaLangObject = localTranslateAnimation;
    localatap.jdField_a_of_type_Boolean = true;
    localatap.jdField_a_of_type_Int = atao.b;
    localatap.b = 250;
    this.this$0.jdField_a_of_type_Atao.a(localatap);
    this.this$0.jdField_a_of_type_Atao.a();
    this.this$0.e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.13
 * JD-Core Version:    0.7.0.1
 */