package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

class OCRManager$2
  extends OCRObserver
{
  OCRManager$2(OCRManager paramOCRManager) {}
  
  public void a(boolean paramBoolean, String paramString, List<OCRTextSearchInfo.SougouSearchInfo> paramList)
  {
    paramList = this.a.a(paramList);
    OCRHandler localOCRHandler = (OCRHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.OCR_HANDLER);
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      localOCRHandler.notifyUI(3, paramBoolean, new Object[] { Integer.valueOf(i), paramString, paramList });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRManager.2
 * JD-Core Version:    0.7.0.1
 */