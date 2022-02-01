package com.tencent.mobileqq.ocr;

import android.content.Intent;
import ayxr;
import ayxs;
import besx;
import bevm;
import com.tencent.qphone.base.util.QLog;

public class OCRHandler$BaseOCRReqBigDataListener$1
  implements Runnable
{
  public OCRHandler$BaseOCRReqBigDataListener$1(ayxs paramayxs, bevm parambevm) {}
  
  public void run()
  {
    int i = 0;
    ayxr localayxr;
    Intent localIntent;
    if ((this.jdField_a_of_type_Bevm == null) || (this.jdField_a_of_type_Bevm.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_a_of_type_Bevm == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), resp is null");
        }
        besx.a().a(6, ayxs.a(this.jdField_a_of_type_Ayxs));
        i = -10;
      }
    }
    else
    {
      localayxr = this.jdField_a_of_type_Ayxs.a;
      localIntent = ayxs.a(this.jdField_a_of_type_Ayxs);
      if (this.jdField_a_of_type_Bevm == null) {
        break label191;
      }
    }
    label191:
    for (byte[] arrayOfByte = this.jdField_a_of_type_Bevm.jdField_a_of_type_ArrayOfByte;; arrayOfByte = null)
    {
      ayxr.a(localayxr, i, localIntent, arrayOfByte, ayxs.a(this.jdField_a_of_type_Ayxs));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), mResult=" + this.jdField_a_of_type_Bevm.jdField_a_of_type_Int + ",mErrCode=" + this.jdField_a_of_type_Bevm.b + ",mHttpCode=" + this.jdField_a_of_type_Bevm.c + ",mErrDesc=" + this.jdField_a_of_type_Bevm.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRHandler.BaseOCRReqBigDataListener.1
 * JD-Core Version:    0.7.0.1
 */