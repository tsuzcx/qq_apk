package com.tencent.weiyun.transmission.upload.uploader;

import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.utils.ILog;

public class UploaderLog
  implements ILog
{
  public void d(String paramString1, String paramString2)
  {
    TsLog.d(paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    TsLog.d(paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    TsLog.e(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    TsLog.e(paramString1, paramString2, paramThrowable);
  }
  
  public int getLogLevel()
  {
    return 3;
  }
  
  public void i(String paramString1, String paramString2)
  {
    TsLog.i(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    TsLog.i(paramString1, paramString2, paramThrowable);
  }
  
  public void v(String paramString1, String paramString2)
  {
    TsLog.v(paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    TsLog.v(paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2)
  {
    TsLog.w(paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    TsLog.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.uploader.UploaderLog
 * JD-Core Version:    0.7.0.1
 */