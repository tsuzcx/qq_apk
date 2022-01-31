package com.tencent.mobileqq.ocr;

import android.content.Intent;
import avvg;
import avvh;
import basl;
import bavf;
import com.tencent.qphone.base.util.QLog;

public class OCRHandler$BaseOCRReqBigDataListener$1
  implements Runnable
{
  public OCRHandler$BaseOCRReqBigDataListener$1(avvh paramavvh, bavf parambavf) {}
  
  public void run()
  {
    int i = 0;
    avvg localavvg;
    Intent localIntent;
    if ((this.jdField_a_of_type_Bavf == null) || (this.jdField_a_of_type_Bavf.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_a_of_type_Bavf == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), resp is null");
        }
        basl.a().a(6, avvh.a(this.jdField_a_of_type_Avvh));
        i = -10;
      }
    }
    else
    {
      localavvg = this.jdField_a_of_type_Avvh.a;
      localIntent = avvh.a(this.jdField_a_of_type_Avvh);
      if (this.jdField_a_of_type_Bavf == null) {
        break label191;
      }
    }
    label191:
    for (byte[] arrayOfByte = this.jdField_a_of_type_Bavf.jdField_a_of_type_ArrayOfByte;; arrayOfByte = null)
    {
      avvg.a(localavvg, i, localIntent, arrayOfByte, avvh.a(this.jdField_a_of_type_Avvh));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), mResult=" + this.jdField_a_of_type_Bavf.jdField_a_of_type_Int + ",mErrCode=" + this.jdField_a_of_type_Bavf.b + ",mHttpCode=" + this.jdField_a_of_type_Bavf.c + ",mErrDesc=" + this.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRHandler.BaseOCRReqBigDataListener.1
 * JD-Core Version:    0.7.0.1
 */