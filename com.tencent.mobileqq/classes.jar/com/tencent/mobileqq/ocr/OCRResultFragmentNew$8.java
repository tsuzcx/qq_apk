package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.textpreview.MenuUtil;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView.OnMenuClickListener;

class OCRResultFragmentNew$8
  implements ParticipleBottomMenuView.OnMenuClickListener
{
  OCRResultFragmentNew$8(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  public void a()
  {
    OCRResultFragmentNew.a(this.a, 0);
  }
  
  public void a(String paramString)
  {
    MenuUtil.copy(paramString, "OCR_Participle_copy");
  }
  
  public void b(String paramString)
  {
    OCRPerformUtil.a(OCRResultFragmentNew.a(this.a), paramString);
  }
  
  public void c(String paramString)
  {
    MenuUtil.a(OCRResultFragmentNew.a(this.a), OCRResultFragmentNew.a(this.a).app, paramString);
  }
  
  public void d(String paramString)
  {
    TranslateFragment.a(OCRResultFragmentNew.a(this.a), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.8
 * JD-Core Version:    0.7.0.1
 */