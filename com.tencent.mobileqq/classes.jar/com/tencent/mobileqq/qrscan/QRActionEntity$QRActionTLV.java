package com.tencent.mobileqq.qrscan;

import com.tencent.mobileqq.qrscan.utils.QRUtils;

public class QRActionEntity$QRActionTLV
{
  int a = 0;
  short b = 0;
  byte[] c = null;
  
  public QRActionEntity$QRActionTLV() {}
  
  public QRActionEntity$QRActionTLV(int paramInt, short paramShort, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.c = paramArrayOfByte;
    this.b = paramShort;
  }
  
  public int a()
  {
    return this.c.length + 4;
  }
  
  public String b()
  {
    return new String(this.c);
  }
  
  public long c()
  {
    return QRUtils.b(this.c);
  }
  
  public String toString()
  {
    return String.format("{t: %s, l: %s, v: %s}", new Object[] { Integer.valueOf(this.a), Short.valueOf(this.b), this.c });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.QRActionEntity.QRActionTLV
 * JD-Core Version:    0.7.0.1
 */