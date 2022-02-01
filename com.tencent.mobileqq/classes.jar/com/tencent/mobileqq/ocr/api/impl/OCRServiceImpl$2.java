package com.tencent.mobileqq.ocr.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ocr.OCRObserver;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import java.util.List;

class OCRServiceImpl$2
  extends OCRObserver
{
  OCRServiceImpl$2(OCRServiceImpl paramOCRServiceImpl) {}
  
  public void a(boolean paramBoolean, String paramString, List<OCRTextSearchInfo.SougouSearchInfo> paramList)
  {
    paramList = this.a.constructTextRearchResult(paramList);
    if (this.a.mApp == null) {
      return;
    }
    OCRHandler localOCRHandler = (OCRHandler)this.a.mApp.getBusinessHandler(OCRHandler.a);
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = -1;
    }
    localOCRHandler.notifyUI(3, paramBoolean, new Object[] { Integer.valueOf(i), paramString, paramList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.OCRServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */