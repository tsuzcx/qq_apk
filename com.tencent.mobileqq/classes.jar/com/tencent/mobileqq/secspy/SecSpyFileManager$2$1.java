package com.tencent.mobileqq.secspy;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import bbxa;
import com.tencent.mobileqq.app.QQAppInterface;

class SecSpyFileManager$2$1
  extends ResultReceiver
{
  SecSpyFileManager$2$1(SecSpyFileManager.2 param2, Handler paramHandler, String paramString1, String paramString2)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    long l = paramBundle.getLong("seq");
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager$2.this$0.a(l, -1, new Object[] { "x5 log upload failed, x5 upload result code = " + paramInt });
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager$2.this$0.a(l, 0, new Object[0]);
      return;
    }
    bbxa.a(this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager$2.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSecspySecSpyFileManager$2.this$0.a.getCurrentAccountUin(), l, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.2.1
 * JD-Core Version:    0.7.0.1
 */