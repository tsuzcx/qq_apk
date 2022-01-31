package com.tencent.mobileqq.ocr.activity;

import android.text.TextUtils;
import aucd;
import auce;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.qphone.base.util.QLog;

public class ScanOcrActivity$8$1
  implements Runnable
{
  public ScanOcrActivity$8$1(aucd paramaucd, String paramString, int paramInt, OcrRecogResult paramOcrRecogResult, long paramLong) {}
  
  public void run()
  {
    if ((!ScanOcrActivity.b(this.jdField_a_of_type_Aucd.a)) || (TextUtils.isEmpty(ScanOcrActivity.b(this.jdField_a_of_type_Aucd.a))) || (!ScanOcrActivity.b(this.jdField_a_of_type_Aucd.a).equals(this.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("Q.ocr.ScanOcrActivity", 1, "OcrCallback onResult is not In recog, mRecogPicPath:" + ScanOcrActivity.b(this.jdField_a_of_type_Aucd.a) + " ,imagePath:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (!ScanOcrActivity.c(this.jdField_a_of_type_Aucd.a))
    {
      ScanOcrActivity.a(this.jdField_a_of_type_Aucd.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
    ScanOcrActivity.a(this.jdField_a_of_type_Aucd.a, new auce());
    ScanOcrActivity.a(this.jdField_a_of_type_Aucd.a).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    ScanOcrActivity.a(this.jdField_a_of_type_Aucd.a).jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult = this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult;
    ScanOcrActivity.a(this.jdField_a_of_type_Aucd.a).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ScanOcrActivity.a(this.jdField_a_of_type_Aucd.a).jdField_a_of_type_Long = this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.8.1
 * JD-Core Version:    0.7.0.1
 */