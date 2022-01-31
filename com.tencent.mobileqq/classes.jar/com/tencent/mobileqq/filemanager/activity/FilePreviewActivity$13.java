package com.tencent.mobileqq.filemanager.activity;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import arod;
import aroe;

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
    if (this.this$0.jdField_a_of_type_Arod == null) {
      this.this$0.jdField_a_of_type_Arod = new arod(this.this$0.jdField_a_of_type_AndroidViewViewGroup);
    }
    aroe localaroe = new aroe();
    localaroe.jdField_a_of_type_JavaLangObject = localTranslateAnimation;
    localaroe.jdField_a_of_type_Boolean = true;
    localaroe.jdField_a_of_type_Int = arod.b;
    localaroe.b = 250;
    this.this$0.jdField_a_of_type_Arod.a(localaroe);
    this.this$0.jdField_a_of_type_Arod.a();
    this.this$0.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.13
 * JD-Core Version:    0.7.0.1
 */