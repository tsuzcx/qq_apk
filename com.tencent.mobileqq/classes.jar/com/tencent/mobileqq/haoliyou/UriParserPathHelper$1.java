package com.tencent.mobileqq.haoliyou;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

class UriParserPathHelper$1
  implements DialogInterface.OnClickListener
{
  UriParserPathHelper$1(UriParserPathHelper paramUriParserPathHelper, InputStream paramInputStream) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
    }
    catch (IOException paramDialogInterface)
    {
      QLog.e("UriParserPathHelper", 1, "system share.exception.e=", paramDialogInterface);
    }
    UriParserPathHelper.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouUriParserPathHelper).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.UriParserPathHelper.1
 * JD-Core Version:    0.7.0.1
 */