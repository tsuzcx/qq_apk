package com.tencent.mobileqq.filemanager.activity;

import android.view.animation.AlphaAnimation;
import arod;
import aroe;

class FilePreviewActivity$11
  implements Runnable
{
  FilePreviewActivity$11(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      this.this$0.b = new arod(this.this$0.a);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    aroe localaroe = new aroe();
    localaroe.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
    localaroe.jdField_a_of_type_Boolean = false;
    localaroe.jdField_a_of_type_Int = arod.jdField_a_of_type_Int;
    localaroe.b = 1500;
    this.this$0.b.a(localaroe);
    this.this$0.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.11
 * JD-Core Version:    0.7.0.1
 */