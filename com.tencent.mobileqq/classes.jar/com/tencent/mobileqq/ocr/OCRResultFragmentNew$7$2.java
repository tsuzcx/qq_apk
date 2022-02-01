package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ocr.view.TDProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class OCRResultFragmentNew$7$2
  implements Runnable
{
  OCRResultFragmentNew$7$2(OCRResultFragmentNew.7 param7, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultFragmentNew.d(this.b.a).dismiss();
      OCRResultFragmentNew.d(this.b.a).a(0);
      OCRResultFragmentNew.a(this.b.a, true);
      QQToast.makeText(OCRResultFragmentNew.a(this.b.a), 2, HardCodeUtil.a(2131905639), 1).show();
      if ((this.a != null) && (this.a.length() > 0))
      {
        this.b.a.a(this.a);
        return;
      }
      QQToast.makeText(OCRResultFragmentNew.a(this.b.a), 1, HardCodeUtil.a(2131905633), 0).show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.7.2
 * JD-Core Version:    0.7.0.1
 */