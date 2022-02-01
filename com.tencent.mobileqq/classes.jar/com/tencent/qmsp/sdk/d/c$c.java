package com.tencent.qmsp.sdk.d;

class c$c
{
  public int a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  public int g;
  public boolean h;
  public int i;
  public long j;
  public int k;
  
  public c$c(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong, int paramInt5)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramInt3;
    this.h = paramBoolean;
    this.i = paramInt4;
    this.j = paramLong;
    this.k = paramInt5;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("filePath=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",fileName=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",fileId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",fileUrl=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",fileHash=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",fileVersion=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",zipFlag=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",startTime=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",tryTimes=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",downloadFlag=");
    localStringBuilder.append(this.k);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.d.c.c
 * JD-Core Version:    0.7.0.1
 */