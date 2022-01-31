package com.tencent.mobileqq.ocr;

import android.content.Intent;
import atzt;
import atzu;
import ayqh;
import aysz;
import com.tencent.qphone.base.util.QLog;

public class OCRHandler$BaseOCRReqBigDataListener$1
  implements Runnable
{
  public OCRHandler$BaseOCRReqBigDataListener$1(atzu paramatzu, aysz paramaysz) {}
  
  public void run()
  {
    int i = 0;
    atzt localatzt;
    Intent localIntent;
    if ((this.jdField_a_of_type_Aysz == null) || (this.jdField_a_of_type_Aysz.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_a_of_type_Aysz == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), resp is null");
        }
        ayqh.a().a(6, atzu.a(this.jdField_a_of_type_Atzu));
        i = -10;
      }
    }
    else
    {
      localatzt = this.jdField_a_of_type_Atzu.a;
      localIntent = atzu.a(this.jdField_a_of_type_Atzu);
      if (this.jdField_a_of_type_Aysz == null) {
        break label191;
      }
    }
    label191:
    for (byte[] arrayOfByte = this.jdField_a_of_type_Aysz.jdField_a_of_type_ArrayOfByte;; arrayOfByte = null)
    {
      atzt.a(localatzt, i, localIntent, arrayOfByte, atzu.a(this.jdField_a_of_type_Atzu));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), mResult=" + this.jdField_a_of_type_Aysz.jdField_a_of_type_Int + ",mErrCode=" + this.jdField_a_of_type_Aysz.b + ",mHttpCode=" + this.jdField_a_of_type_Aysz.c + ",mErrDesc=" + this.jdField_a_of_type_Aysz.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRHandler.BaseOCRReqBigDataListener.1
 * JD-Core Version:    0.7.0.1
 */