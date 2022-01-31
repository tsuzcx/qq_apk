package com.tencent.mobileqq.ocr;

import android.content.Intent;
import atzr;
import atzs;
import ayqf;
import aysx;
import com.tencent.qphone.base.util.QLog;

public class OCRHandler$BaseOCRReqBigDataListener$1
  implements Runnable
{
  public OCRHandler$BaseOCRReqBigDataListener$1(atzs paramatzs, aysx paramaysx) {}
  
  public void run()
  {
    int i = 0;
    atzr localatzr;
    Intent localIntent;
    if ((this.jdField_a_of_type_Aysx == null) || (this.jdField_a_of_type_Aysx.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_a_of_type_Aysx == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), resp is null");
        }
        ayqf.a().a(6, atzs.a(this.jdField_a_of_type_Atzs));
        i = -10;
      }
    }
    else
    {
      localatzr = this.jdField_a_of_type_Atzs.a;
      localIntent = atzs.a(this.jdField_a_of_type_Atzs);
      if (this.jdField_a_of_type_Aysx == null) {
        break label191;
      }
    }
    label191:
    for (byte[] arrayOfByte = this.jdField_a_of_type_Aysx.jdField_a_of_type_ArrayOfByte;; arrayOfByte = null)
    {
      atzr.a(localatzr, i, localIntent, arrayOfByte, atzs.a(this.jdField_a_of_type_Atzs));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), mResult=" + this.jdField_a_of_type_Aysx.jdField_a_of_type_Int + ",mErrCode=" + this.jdField_a_of_type_Aysx.b + ",mHttpCode=" + this.jdField_a_of_type_Aysx.c + ",mErrDesc=" + this.jdField_a_of_type_Aysx.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRHandler.BaseOCRReqBigDataListener.1
 * JD-Core Version:    0.7.0.1
 */