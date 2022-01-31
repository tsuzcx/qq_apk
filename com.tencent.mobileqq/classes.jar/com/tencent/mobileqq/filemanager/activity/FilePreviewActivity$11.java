package com.tencent.mobileqq.filemanager.activity;

import android.view.animation.AlphaAnimation;
import apdf;
import apdg;

class FilePreviewActivity$11
  implements Runnable
{
  FilePreviewActivity$11(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      this.this$0.b = new apdf(this.this$0.a);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    apdg localapdg = new apdg();
    localapdg.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
    localapdg.jdField_a_of_type_Boolean = false;
    localapdg.jdField_a_of_type_Int = apdf.jdField_a_of_type_Int;
    localapdg.b = 1500;
    this.this$0.b.a(localapdg);
    this.this$0.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.11
 * JD-Core Version:    0.7.0.1
 */