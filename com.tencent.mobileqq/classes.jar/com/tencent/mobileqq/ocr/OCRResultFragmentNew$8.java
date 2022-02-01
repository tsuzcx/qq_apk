package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.qqfavor.api.IFavoriteOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.textpreview.BaseMenuUtil;
import com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView.OnMenuClickListener;

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
    BaseMenuUtil.copy(paramString, "OCR_Participle_copy");
  }
  
  public void b(String paramString)
  {
    OCRPerformUtil.a(OCRResultFragmentNew.a(this.a), paramString);
  }
  
  public void c(String paramString)
  {
    ((IFavoriteOCR)QRoute.api(IFavoriteOCR.class)).favorite(OCRResultFragmentNew.a(this.a), paramString);
  }
  
  public void d(String paramString)
  {
    TranslateFragment.a(OCRResultFragmentNew.a(this.a), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.8
 * JD-Core Version:    0.7.0.1
 */