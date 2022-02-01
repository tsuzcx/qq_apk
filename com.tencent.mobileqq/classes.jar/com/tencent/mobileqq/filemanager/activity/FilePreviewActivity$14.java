package com.tencent.mobileqq.filemanager.activity;

import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import auev;
import auew;
import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$14
  implements Runnable
{
  FilePreviewActivity$14(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.jdField_c_of_type_Auev == null) {
      this.this$0.jdField_c_of_type_Auev = new auev(this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.this$0.jdField_c_of_type_AndroidWidgetTextView.setText(2131694398);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.5F, 1.0F);
    localAlphaAnimation.setFillAfter(true);
    auew localauew = new auew();
    localauew.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
    localauew.jdField_a_of_type_Boolean = true;
    localauew.jdField_a_of_type_Int = auev.jdField_a_of_type_Int;
    localauew.b = 1000;
    this.this$0.jdField_c_of_type_Auev.a(localauew);
    this.this$0.jdField_c_of_type_Auev.a();
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "showGetmore(1000)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.14
 * JD-Core Version:    0.7.0.1
 */