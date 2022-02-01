package com.tencent.mobileqq.qrscan.view;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

class ScannerMultiResultSelectView$1
  implements Runnable
{
  ScannerMultiResultSelectView$1(ScannerMultiResultSelectView paramScannerMultiResultSelectView, ScannerMultiResultSelectView.ImageData paramImageData) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeBitmap mShowing：");
      localStringBuilder.append(ScannerMultiResultSelectView.a(this.this$0));
      QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, localStringBuilder.toString());
    }
    if (!ScannerMultiResultSelectView.a(this.this$0)) {
      return;
    }
    try
    {
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))
      {
        ScannerMultiResultSelectView.a(this.this$0, ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeBitmapFromFile(this.a.jdField_a_of_type_JavaLangString, ViewUtils.a(), ViewUtils.b()));
      }
      else if (this.a.jdField_a_of_type_ArrayOfByte != null)
      {
        ScannerMultiResultSelectView.a(this.this$0, ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeBitmapFromYuv(this.a.jdField_a_of_type_ArrayOfByte, this.a.jdField_a_of_type_Int, this.a.b));
        this.a.jdField_a_of_type_ArrayOfByte = null;
      }
    }
    catch (Throwable localThrowable)
    {
      ScannerMultiResultSelectView.a(this.this$0, null);
      QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, "decodeBitmap error:", localThrowable);
    }
    ScannerMultiResultSelectView.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.1
 * JD-Core Version:    0.7.0.1
 */