package com.tencent.qqprotect.qsec;

import alwp;
import alwq;
import alwr;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class CSProcessorImpl
  implements ICSProcessor, IRuntimeInterface
{
  private static volatile CSProcessorImpl a;
  
  private CSProcessorImpl()
  {
    QSecFramework.a(4, new alwp(this));
  }
  
  public static CSProcessorImpl a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new CSProcessorImpl();
      }
      return a;
    }
    finally {}
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, ICSProcessor.ICSProcessorListener paramICSProcessorListener)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (paramICSProcessorListener != null)
      {
        ProtoUtils.a(localQQAppInterface, new alwr(paramArrayOfByte, paramICSProcessorListener), paramArrayOfByte, paramString);
        return;
      }
      ProtoUtils.a(localQQAppInterface, new alwq(this), paramArrayOfByte, paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String getInterfaceName()
  {
    return "CSP";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CSProcessorImpl
 * JD-Core Version:    0.7.0.1
 */