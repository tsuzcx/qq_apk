package com.tencent.mobileqq.ocr;

import android.content.Intent;
import avqx;
import avqy;
import baoc;
import baqw;
import com.tencent.qphone.base.util.QLog;

public class OCRHandler$BaseOCRReqBigDataListener$1
  implements Runnable
{
  public OCRHandler$BaseOCRReqBigDataListener$1(avqy paramavqy, baqw parambaqw) {}
  
  public void run()
  {
    int i = 0;
    avqx localavqx;
    Intent localIntent;
    if ((this.jdField_a_of_type_Baqw == null) || (this.jdField_a_of_type_Baqw.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_a_of_type_Baqw == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), resp is null");
        }
        baoc.a().a(6, avqy.a(this.jdField_a_of_type_Avqy));
        i = -10;
      }
    }
    else
    {
      localavqx = this.jdField_a_of_type_Avqy.a;
      localIntent = avqy.a(this.jdField_a_of_type_Avqy);
      if (this.jdField_a_of_type_Baqw == null) {
        break label191;
      }
    }
    label191:
    for (byte[] arrayOfByte = this.jdField_a_of_type_Baqw.jdField_a_of_type_ArrayOfByte;; arrayOfByte = null)
    {
      avqx.a(localavqx, i, localIntent, arrayOfByte, avqy.a(this.jdField_a_of_type_Avqy));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), mResult=" + this.jdField_a_of_type_Baqw.jdField_a_of_type_Int + ",mErrCode=" + this.jdField_a_of_type_Baqw.b + ",mHttpCode=" + this.jdField_a_of_type_Baqw.c + ",mErrDesc=" + this.jdField_a_of_type_Baqw.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRHandler.BaseOCRReqBigDataListener.1
 * JD-Core Version:    0.7.0.1
 */