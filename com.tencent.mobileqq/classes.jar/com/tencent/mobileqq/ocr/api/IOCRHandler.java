package com.tencent.mobileqq.ocr.api;

import com.tencent.mobileqq.app.IBusinessHandler;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IOCRHandler
  extends IBusinessHandler, IRuntimeService
{
  public abstract void batchTranslate(String paramString1, String paramString2, String paramString3);
  
  public abstract String getClassName();
  
  public abstract boolean getUSING_TEST_SERVERT();
  
  public abstract void setUSING_TEST_SERVERT(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.IOCRHandler
 * JD-Core Version:    0.7.0.1
 */