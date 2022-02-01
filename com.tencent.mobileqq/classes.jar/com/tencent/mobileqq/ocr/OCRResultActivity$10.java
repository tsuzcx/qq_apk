package com.tencent.mobileqq.ocr;

import android.app.Activity;
import com.tencent.mobileqq.teamwork.TenDocOCRExportObserver;
import mqq.os.MqqHandler;

class OCRResultActivity$10
  extends TenDocOCRExportObserver
{
  OCRResultActivity$10(OCRResultActivity paramOCRResultActivity, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    OCRResultActivity.a(this.a).post(new OCRResultActivity.10.1(this));
  }
  
  public void a(int paramInt)
  {
    OCRResultActivity.a(this.a).post(new OCRResultActivity.10.4(this, paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    OCRResultActivity.a(this.a).post(new OCRResultActivity.10.3(this));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    OCRResultActivity.a(this.a).post(new OCRResultActivity.10.2(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.10
 * JD-Core Version:    0.7.0.1
 */