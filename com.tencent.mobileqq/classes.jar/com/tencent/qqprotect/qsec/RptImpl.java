package com.tencent.qqprotect.qsec;

import com.tencent.qqprotect.common.QSecRptController;

public class RptImpl
  implements IRpt, IRuntimeInterface
{
  private static volatile RptImpl a;
  
  private RptImpl()
  {
    QSecFramework.a(3L, new RptImpl.1(this));
  }
  
  public static RptImpl a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new RptImpl();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1)
    {
      QSecRptController.a(paramString, paramInt2);
      return;
    }
    if (paramInt1 == 2) {
      QSecRptController.b(paramString, paramInt2);
    }
  }
  
  public String getInterfaceName()
  {
    return "Rpt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.RptImpl
 * JD-Core Version:    0.7.0.1
 */