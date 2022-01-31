package com.tencent.mobileqq.secspy;

import aibq;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;

public class SecSpyFileManager$2$1
  extends ResultReceiver
{
  public SecSpyFileManager$2$1(aibq paramaibq, Handler paramHandler, String paramString1, String paramString2)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    long l = paramBundle.getLong("seq");
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Aibq.a.a(l, -1, new Object[] { "x5 log upload failed, x5 upload result code = " + paramInt });
      return;
    case 0: 
      this.jdField_a_of_type_Aibq.a.a(l, 0, new Object[0]);
      return;
    }
    SecSpyFileManager.a(this.jdField_a_of_type_Aibq.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aibq.a.a.getCurrentAccountUin(), l, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.2.1
 * JD-Core Version:    0.7.0.1
 */