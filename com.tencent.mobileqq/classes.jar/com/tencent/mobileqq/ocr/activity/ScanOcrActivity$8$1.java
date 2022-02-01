package com.tencent.mobileqq.ocr.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.qphone.base.util.QLog;

class ScanOcrActivity$8$1
  implements Runnable
{
  ScanOcrActivity$8$1(ScanOcrActivity.8 param8, String paramString, int paramInt, OcrRecogResult paramOcrRecogResult, long paramLong) {}
  
  public void run()
  {
    if ((ScanOcrActivity.b(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$8.a)) && (!TextUtils.isEmpty(ScanOcrActivity.b(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$8.a))) && (ScanOcrActivity.b(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$8.a).equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (!ScanOcrActivity.c(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$8.a))
      {
        ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$8.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
        return;
      }
      ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$8.a, new ScanOcrActivity.OcrResultCache());
      ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$8.a).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$8.a).jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult = this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult;
      ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$8.a).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$8.a).jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OcrCallback onResult is not In recog, mRecogPicPath:");
    localStringBuilder.append(ScanOcrActivity.b(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$8.a));
    localStringBuilder.append(" ,imagePath:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("Q.ocr.ScanOcrActivity", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.8.1
 * JD-Core Version:    0.7.0.1
 */