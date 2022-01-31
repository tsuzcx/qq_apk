package com.tencent.mobileqq.ocr;

import android.content.Intent;
import atdn;
import atdo;
import axpy;
import axsq;
import com.tencent.qphone.base.util.QLog;

public class OCRHandler$BaseOCRReqBigDataListener$1
  implements Runnable
{
  public OCRHandler$BaseOCRReqBigDataListener$1(atdo paramatdo, axsq paramaxsq) {}
  
  public void run()
  {
    int i = 0;
    atdn localatdn;
    Intent localIntent;
    if ((this.jdField_a_of_type_Axsq == null) || (this.jdField_a_of_type_Axsq.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_a_of_type_Axsq == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), resp is null");
        }
        axpy.a().a(6, atdo.a(this.jdField_a_of_type_Atdo));
        i = -10;
      }
    }
    else
    {
      localatdn = this.jdField_a_of_type_Atdo.a;
      localIntent = atdo.a(this.jdField_a_of_type_Atdo);
      if (this.jdField_a_of_type_Axsq == null) {
        break label191;
      }
    }
    label191:
    for (byte[] arrayOfByte = this.jdField_a_of_type_Axsq.jdField_a_of_type_ArrayOfByte;; arrayOfByte = null)
    {
      atdn.a(localatdn, i, localIntent, arrayOfByte, atdo.a(this.jdField_a_of_type_Atdo));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), mResult=" + this.jdField_a_of_type_Axsq.jdField_a_of_type_Int + ",mErrCode=" + this.jdField_a_of_type_Axsq.b + ",mHttpCode=" + this.jdField_a_of_type_Axsq.c + ",mErrDesc=" + this.jdField_a_of_type_Axsq.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRHandler.BaseOCRReqBigDataListener.1
 * JD-Core Version:    0.7.0.1
 */