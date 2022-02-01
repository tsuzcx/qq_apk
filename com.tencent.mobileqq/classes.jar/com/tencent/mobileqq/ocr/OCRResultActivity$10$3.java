package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ocr.view.TDProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class OCRResultActivity$10$3
  implements Runnable
{
  OCRResultActivity$10$3(OCRResultActivity.10 param10) {}
  
  public void run()
  {
    OCRResultActivity.a(this.a.a).dismiss();
    OCRResultActivity.a(this.a.a).a(0);
    OCRResultActivity.d(this.a.a, false);
    QQToast.a(this.a.a, 1, HardCodeUtil.a(2131707798), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.10.3
 * JD-Core Version:    0.7.0.1
 */