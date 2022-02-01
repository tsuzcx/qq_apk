package com.tencent.qqprotect.common;

import com.tencent.mobileqq.utils.HexUtil;

public class QSecRptHelper
{
  private StringBuilder a;
  private boolean b;
  
  public QSecRptHelper()
  {
    a();
  }
  
  private void b()
  {
    b(",");
  }
  
  private void b(String paramString)
  {
    if (this.b) {
      this.a.append(paramString);
    }
    this.b = true;
  }
  
  public QSecRptHelper a()
  {
    this.a = new StringBuilder();
    this.b = false;
    return this;
  }
  
  public QSecRptHelper a(int paramInt)
  {
    return a(String.format("%d", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public QSecRptHelper a(String paramString)
  {
    b();
    paramString = paramString.replace(',', ';');
    this.a.append(paramString);
    return this;
  }
  
  public QSecRptHelper a(byte[] paramArrayOfByte)
  {
    return a(HexUtil.bytes2HexStr(paramArrayOfByte));
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.common.QSecRptHelper
 * JD-Core Version:    0.7.0.1
 */