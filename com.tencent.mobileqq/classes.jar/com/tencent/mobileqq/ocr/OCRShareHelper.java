package com.tencent.mobileqq.ocr;

import agfr;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.qqfav.QfavBuilder;

public class OCRShareHelper
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  
  public OCRShareHelper(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (paramInt == 2) {
      a(paramString);
    }
    while (paramInt != 1) {
      return;
    }
    b(paramString);
  }
  
  public void a(@Nullable String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X80082EC", "0X80082EC", 0, 0, "", "", "", "");
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.ocr.OCRShareHelper", 2, "addToFav error, content is empty");
      }
    }
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    } while (!QfavBuilder.a(null, paramString).c(str).a(this.jdField_a_of_type_AndroidAppActivity, str));
    ReportController.b(null, "dc00898", "", "", "0X80082ED", "0X80082ED", 0, 0, "", "", "", "");
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    ReportController.b(null, "dc00898", "", "", "0X80082D7", "0X80082D7", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131439077);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131439075);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131439076);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433029);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new agfr(this, paramString1, paramString2));
    }
    try
    {
      if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.ocr.OCRShareHelper", 2, "actionSheet.show exception=" + paramString1);
    }
  }
  
  public void b(@Nullable String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X80085CE", "0X80085CE", 0, 0, "", "", "", "");
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.ocr.OCRShareHelper", 2, "StartToSearchQuestion error, reconPicPath is empty");
      }
    }
    OCRRecognitionResultActivity localOCRRecognitionResultActivity;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_AndroidAppActivity == null) || (!(this.jdField_a_of_type_AndroidAppActivity instanceof OCRRecognitionResultActivity)));
      localOCRRecognitionResultActivity = (OCRRecognitionResultActivity)this.jdField_a_of_type_AndroidAppActivity;
    } while (TextUtils.isEmpty(paramString));
    localOCRRecognitionResultActivity.a(paramString, 105);
  }
  
  public void c(@Nullable String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X80082EB", "0X80082EB", 0, 0, "", "", "", "");
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.ocr.OCRShareHelper", 2, "ShareToFriend error, content is empty");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    localBundle.putString("forward_text", paramString);
    paramString = new Intent();
    paramString.putExtra("isFromShare", true);
    paramString.putExtras(localBundle);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramString, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRShareHelper
 * JD-Core Version:    0.7.0.1
 */