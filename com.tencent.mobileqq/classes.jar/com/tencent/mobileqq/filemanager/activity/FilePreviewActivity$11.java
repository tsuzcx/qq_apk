package com.tencent.mobileqq.filemanager.activity;

import android.view.animation.AlphaAnimation;
import auev;
import auew;

class FilePreviewActivity$11
  implements Runnable
{
  FilePreviewActivity$11(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      this.this$0.b = new auev(this.this$0.a);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    auew localauew = new auew();
    localauew.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
    localauew.jdField_a_of_type_Boolean = false;
    localauew.jdField_a_of_type_Int = auev.jdField_a_of_type_Int;
    localauew.b = 1500;
    this.this$0.b.a(localauew);
    this.this$0.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.11
 * JD-Core Version:    0.7.0.1
 */