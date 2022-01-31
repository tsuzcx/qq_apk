package com.tencent.mobileqq.ocr;

import afob;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
  private String jdField_a_of_type_JavaLangString;
  
  public OCRShareHelper(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(int paramInt, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.OCRShareHelper", 2, "forWhat=" + paramInt + ",isTextEmpty=" + bool);
    }
    if (bool) {}
    do
    {
      do
      {
        return;
        if (paramInt != 2) {
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      } while (!QfavBuilder.a(null, paramString).c((String)localObject).a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject));
      ReportController.b(null, "dc00898", "", "", "0X80082ED", "0X80082ED", 0, 0, "", "", "", "");
      return;
    } while (paramInt != 1);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("forward_type", -1);
    ((Bundle)localObject).putString("forward_text", paramString);
    paramString = new Intent();
    paramString.putExtra("isFromShare", true);
    paramString.putExtras((Bundle)localObject);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramString, 21);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131439024);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131439022);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131439023);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131432998);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new afob(this));
    }
    try
    {
      if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.ocr.OCRShareHelper", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRShareHelper
 * JD-Core Version:    0.7.0.1
 */