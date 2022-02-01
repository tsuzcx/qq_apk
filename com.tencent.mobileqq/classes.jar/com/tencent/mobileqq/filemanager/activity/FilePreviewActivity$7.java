package com.tencent.mobileqq.filemanager.activity;

import android.os.Bundle;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.core.ControlerCallback;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$7
  implements ControlerCallback
{
  FilePreviewActivity$7(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    if (this.a.d) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long = System.currentTimeMillis();
    }
    this.a.d = true;
    if (!paramBoolean)
    {
      if ((paramString3 != null) && (paramString3.length() > 0)) {
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(paramString3);
      } else {
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131704672));
      }
      this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramString1 = this.a;
      paramString1.jdField_g_of_type_Boolean = true;
      paramString1.stopTitleProgress();
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = false;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long - this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.h = paramString3;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_JavaLangString = paramString6;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_Long = (System.currentTimeMillis() - this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("OnCSReplay[false],retMsg[");
        paramString1.append(paramString3);
        paramString1.append("]");
        QLog.e("<FileAssistant>FilePreviewActivity", 2, paramString1.toString());
      }
      return;
    }
    if (paramBundle != null)
    {
      paramBoolean = paramBundle.getBoolean("ishttps", false);
      if (paramBoolean)
      {
        paramString1 = paramBundle.getString("httpsdomain", null);
        paramString3 = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramBundle.getShort("httpsport", (short)0));
        localStringBuilder.append("");
        paramString3.h = localStringBuilder.toString();
      }
    }
    else
    {
      paramBoolean = false;
    }
    paramString3 = this.a;
    paramString3.jdField_g_of_type_JavaLangString = paramString1;
    paramString3.h = paramString2;
    paramString3.jdField_b_of_type_Boolean = paramBoolean;
    paramString3.jdField_e_of_type_JavaLangString = paramString4;
    paramString3.jdField_f_of_type_JavaLangString = paramString5;
    if (paramBoolean)
    {
      paramString5 = new StringBuilder();
      paramString5.append("https://");
      paramString5.append(paramString1);
      paramString5.append(":");
      paramString5.append(paramString2);
      paramString5.append("/ftn_doc_previewer/");
      paramString5.append(this.a.i);
      paramString3.jdField_a_of_type_JavaLangString = paramString5.toString();
    }
    else
    {
      paramString5 = new StringBuilder();
      paramString5.append("http://");
      paramString5.append(paramString1);
      paramString5.append(":");
      paramString5.append(paramString2);
      paramString5.append("/ftn_doc_previewer/");
      paramString5.append(this.a.i);
      paramString3.jdField_a_of_type_JavaLangString = paramString5.toString();
    }
    paramString2 = this.a;
    paramString2.j = paramString6;
    if (paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = true;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_JavaLangString = paramString4;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.h = "";
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long = System.currentTimeMillis();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long - this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.b = paramString1;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_JavaLangString = this.a.jdField_a_of_type_JavaLangString;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_JavaLangString = paramString6;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_Long = (System.currentTimeMillis() - this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
    }
    if (this.a.jdField_a_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("mPreviewUrl is null ,threadid[");
        paramString1.append(Thread.currentThread().getId());
        paramString1.append("], mainId[");
        paramString1.append(Looper.getMainLooper().getThread().getId());
        paramString1.append("]");
        QLog.e("<FileAssistant>FilePreviewActivity", 2, paramString1.toString());
      }
      this.a.finish();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(this.a.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("time[");
      paramString1.append(System.currentTimeMillis());
      paramString1.append("]OnCSReplay mWebView.loadUrl(");
      paramString1.append(this.a.jdField_a_of_type_JavaLangString);
      paramString1.append(")");
      QLog.i("<FileAssistant>FilePreviewActivity", 2, paramString1.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long = System.currentTimeMillis();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.k = "2";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.7
 * JD-Core Version:    0.7.0.1
 */