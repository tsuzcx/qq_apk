package com.tencent.mobileqq.filemanager.activity;

import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import auoe;
import auof;
import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$14
  implements Runnable
{
  FilePreviewActivity$14(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.jdField_c_of_type_Auoe == null) {
      this.this$0.jdField_c_of_type_Auoe = new auoe(this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.this$0.jdField_c_of_type_AndroidWidgetTextView.setText(2131694097);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.5F, 1.0F);
    localAlphaAnimation.setFillAfter(true);
    auof localauof = new auof();
    localauof.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
    localauof.jdField_a_of_type_Boolean = true;
    localauof.jdField_a_of_type_Int = auoe.jdField_a_of_type_Int;
    localauof.b = 1000;
    this.this$0.jdField_c_of_type_Auoe.a(localauof);
    this.this$0.jdField_c_of_type_Auoe.a();
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "showGetmore(1000)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.14
 * JD-Core Version:    0.7.0.1
 */