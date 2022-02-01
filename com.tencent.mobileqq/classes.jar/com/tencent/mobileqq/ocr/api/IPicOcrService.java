package com.tencent.mobileqq.ocr.api;

import com.tencent.mobileqq.gallery.picocr.PicOcrObserver;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.ocr.req.OCRReqContext;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IPicOcrService
  extends IRuntimeService
{
  public abstract void putOcrResult(String paramString, PicOcrRspResult paramPicOcrRspResult);
  
  public abstract void requestOcr(OCRReqContext paramOCRReqContext, PicOcrObserver paramPicOcrObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.IPicOcrService
 * JD-Core Version:    0.7.0.1
 */