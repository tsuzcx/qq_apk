package com.tencent.mobileqq.ocr;

import android.app.Activity;
import com.tencent.mobileqq.teamwork.TenDocOCRExportObserver;
import mqq.os.MqqHandler;

class OCRResultFragmentNew$7
  extends TenDocOCRExportObserver
{
  OCRResultFragmentNew$7(OCRResultFragmentNew paramOCRResultFragmentNew, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    OCRResultFragmentNew.e(this.a).post(new OCRResultFragmentNew.7.1(this));
  }
  
  public void a(int paramInt)
  {
    OCRResultFragmentNew.e(this.a).post(new OCRResultFragmentNew.7.4(this, paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    OCRResultFragmentNew.e(this.a).post(new OCRResultFragmentNew.7.3(this));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    OCRResultFragmentNew.e(this.a).post(new OCRResultFragmentNew.7.2(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.7
 * JD-Core Version:    0.7.0.1
 */