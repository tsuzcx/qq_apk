package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ocr.view.TDProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class OCRResultFragmentNew$7$3
  implements Runnable
{
  OCRResultFragmentNew$7$3(OCRResultFragmentNew.7 param7) {}
  
  public void run()
  {
    OCRResultFragmentNew.a(this.a.a, false);
    OCRResultFragmentNew.a(this.a.a).dismiss();
    OCRResultFragmentNew.a(this.a.a).a(0);
    QQToast.a(OCRResultFragmentNew.a(this.a.a), 1, HardCodeUtil.a(2131707822), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.7.3
 * JD-Core Version:    0.7.0.1
 */