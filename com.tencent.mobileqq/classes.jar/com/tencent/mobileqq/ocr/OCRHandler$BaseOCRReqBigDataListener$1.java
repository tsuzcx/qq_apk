package com.tencent.mobileqq.ocr;

import android.content.Intent;
import ayey;
import ayez;
import bdud;
import bdwt;
import com.tencent.qphone.base.util.QLog;

public class OCRHandler$BaseOCRReqBigDataListener$1
  implements Runnable
{
  public OCRHandler$BaseOCRReqBigDataListener$1(ayez paramayez, bdwt parambdwt) {}
  
  public void run()
  {
    int i = 0;
    ayey localayey;
    Intent localIntent;
    if ((this.jdField_a_of_type_Bdwt == null) || (this.jdField_a_of_type_Bdwt.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_a_of_type_Bdwt == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), resp is null");
        }
        bdud.a().a(6, ayez.a(this.jdField_a_of_type_Ayez));
        i = -10;
      }
    }
    else
    {
      localayey = this.jdField_a_of_type_Ayez.a;
      localIntent = ayez.a(this.jdField_a_of_type_Ayez);
      if (this.jdField_a_of_type_Bdwt == null) {
        break label191;
      }
    }
    label191:
    for (byte[] arrayOfByte = this.jdField_a_of_type_Bdwt.jdField_a_of_type_ArrayOfByte;; arrayOfByte = null)
    {
      ayey.a(localayey, i, localIntent, arrayOfByte, ayez.a(this.jdField_a_of_type_Ayez));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), mResult=" + this.jdField_a_of_type_Bdwt.jdField_a_of_type_Int + ",mErrCode=" + this.jdField_a_of_type_Bdwt.b + ",mHttpCode=" + this.jdField_a_of_type_Bdwt.c + ",mErrDesc=" + this.jdField_a_of_type_Bdwt.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRHandler.BaseOCRReqBigDataListener.1
 * JD-Core Version:    0.7.0.1
 */