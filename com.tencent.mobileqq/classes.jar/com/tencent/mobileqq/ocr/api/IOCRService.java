package com.tencent.mobileqq.ocr.api;

import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IOCRService
  extends IRuntimeService
{
  public abstract void doSougouSearch(String paramString1, String paramString2, long paramLong);
  
  public abstract String generateTextSearchSessionID();
  
  public abstract String getAIOText(String paramString);
  
  public abstract int getConfigVersion();
  
  public abstract OcrConfig getOCRConfig(boolean paramBoolean);
  
  public abstract boolean isQZoneSupportOcr(String paramString);
  
  public abstract boolean isSupportOcr(String paramString, int paramInt);
  
  public abstract void onGetOCRConfig(boolean paramBoolean, OcrConfig paramOcrConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.IOCRService
 * JD-Core Version:    0.7.0.1
 */