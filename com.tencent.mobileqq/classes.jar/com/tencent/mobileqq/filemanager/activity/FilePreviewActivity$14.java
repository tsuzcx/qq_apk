package com.tencent.mobileqq.filemanager.activity;

import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import apdf;
import apdg;
import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$14
  implements Runnable
{
  FilePreviewActivity$14(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.jdField_c_of_type_Apdf == null) {
      this.this$0.jdField_c_of_type_Apdf = new apdf(this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.this$0.jdField_c_of_type_AndroidWidgetTextView.setText(2131629115);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.5F, 1.0F);
    localAlphaAnimation.setFillAfter(true);
    apdg localapdg = new apdg();
    localapdg.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
    localapdg.jdField_a_of_type_Boolean = true;
    localapdg.jdField_a_of_type_Int = apdf.jdField_a_of_type_Int;
    localapdg.b = 1000;
    this.this$0.jdField_c_of_type_Apdf.a(localapdg);
    this.this$0.jdField_c_of_type_Apdf.a();
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "showGetmore(1000)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.14
 * JD-Core Version:    0.7.0.1
 */