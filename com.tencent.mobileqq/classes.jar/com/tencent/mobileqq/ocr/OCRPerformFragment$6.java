package com.tencent.mobileqq.ocr;

import android.os.Message;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gallery.picocr.PicOcrObserver;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class OCRPerformFragment$6
  extends PicOcrObserver
{
  OCRPerformFragment$6(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void a()
  {
    OCRPerformFragment.c(this.a).sendEmptyMessageDelayed(101, 60000L);
  }
  
  public void a(PicOcrRspResult paramPicOcrRspResult)
  {
    OCRPerformFragment.c(this.a).obtainMessage(102, paramPicOcrRspResult).sendToTarget();
  }
  
  protected void a(boolean paramBoolean, PicOcrRspResult paramPicOcrRspResult)
  {
    if ((OCRPerformFragment.g(this.a)) && (OCRPerformFragment.a(this.a) != null))
    {
      OCRPerformFragment.c(this.a).removeMessages(101);
      OCRPerformFragment.a(this.a, false);
      OCRPerformFragment.a(this.a).runOnUiThread(new OCRPerformFragment.6.1(this, paramBoolean, paramPicOcrRspResult));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "onPicOcrResult other! or mActivity null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.6
 * JD-Core Version:    0.7.0.1
 */