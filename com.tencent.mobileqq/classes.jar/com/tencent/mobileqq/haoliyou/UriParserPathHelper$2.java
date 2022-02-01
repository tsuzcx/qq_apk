package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class UriParserPathHelper$2
  implements DialogInterface.OnClickListener
{
  UriParserPathHelper$2(UriParserPathHelper paramUriParserPathHelper, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      UriParserPathHelper.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("UriParserPathHelper", 1, "system share.copy file error", paramDialogInterface);
      if (UriParserPathHelper.jdField_a_of_type_JavaLangString != null) {}
    }
    for (paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper.jdField_a_of_type_AndroidContentContext.getString(2131719295);; paramDialogInterface = UriParserPathHelper.jdField_a_of_type_JavaLangString)
    {
      UriParserPathHelper.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper, paramDialogInterface);
      if (UriParserPathHelper.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper) == null) {
        break;
      }
      UriParserPathHelper.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper).a(this.jdField_a_of_type_AndroidNetUri);
      UriParserPathHelper.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.UriParserPathHelper.2
 * JD-Core Version:    0.7.0.1
 */