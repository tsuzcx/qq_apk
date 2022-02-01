package com.tencent.mobileqq.filemanager.activity;

import android.view.animation.AlphaAnimation;
import atao;
import atap;

class FilePreviewActivity$11
  implements Runnable
{
  FilePreviewActivity$11(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      this.this$0.b = new atao(this.this$0.a);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    atap localatap = new atap();
    localatap.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
    localatap.jdField_a_of_type_Boolean = false;
    localatap.jdField_a_of_type_Int = atao.jdField_a_of_type_Int;
    localatap.b = 1500;
    this.this$0.b.a(localatap);
    this.this$0.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.11
 * JD-Core Version:    0.7.0.1
 */