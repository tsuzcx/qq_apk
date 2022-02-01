package com.tencent.mobileqq.filemanager.activity;

import android.view.animation.AlphaAnimation;
import atwj;
import atwk;

class FilePreviewActivity$11
  implements Runnable
{
  FilePreviewActivity$11(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      this.this$0.b = new atwj(this.this$0.a);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    atwk localatwk = new atwk();
    localatwk.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
    localatwk.jdField_a_of_type_Boolean = false;
    localatwk.jdField_a_of_type_Int = atwj.jdField_a_of_type_Int;
    localatwk.b = 1500;
    this.this$0.b.a(localatwk);
    this.this$0.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.11
 * JD-Core Version:    0.7.0.1
 */