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
    if ((ScanOcrActivity.p(this.e.a)) && (!TextUtils.isEmpty(ScanOcrActivity.q(this.e.a))) && (ScanOcrActivity.q(this.e.a).equals(this.a)))
    {
      if (!ScanOcrActivity.r(this.e.a))
      {
        ScanOcrActivity.a(this.e.a, this.b, this.c, this.a, this.d);
        return;
      }
      ScanOcrActivity.a(this.e.a, new ScanOcrActivity.OcrResultCache());
      ScanOcrActivity.s(this.e.a).a = this.b;
      ScanOcrActivity.s(this.e.a).b = this.c;
      ScanOcrActivity.s(this.e.a).c = this.a;
      ScanOcrActivity.s(this.e.a).d = this.d;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OcrCallback onResult is not In recog, mRecogPicPath:");
    localStringBuilder.append(ScanOcrActivity.q(this.e.a));
    localStringBuilder.append(" ,imagePath:");
    localStringBuilder.append(this.a);
    QLog.d("Q.ocr.ScanOcrActivity", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.8.1
 * JD-Core Version:    0.7.0.1
 */