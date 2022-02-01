package com.tencent.rmonitor.bigbitmap.datainfo;

import android.support.annotation.NonNull;
import com.tencent.rmonitor.base.reporter.data.IMetaData;
import com.tencent.rmonitor.common.util.Objects;
import java.util.Arrays;

public class ExceedBitmapInfo
  implements IMetaData
{
  public String a;
  private final String b;
  private final String c;
  private final String d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  private final long j;
  private final long k;
  
  public ExceedBitmapInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, String paramString4, long paramLong2)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
    this.i = paramInt5;
    this.j = paramLong1;
    this.a = paramString4;
    this.k = paramLong2;
  }
  
  private boolean a(ExceedBitmapInfo paramExceedBitmapInfo)
  {
    return (this.e == paramExceedBitmapInfo.e) && (this.f == paramExceedBitmapInfo.f) && (this.g == paramExceedBitmapInfo.g) && (this.h == paramExceedBitmapInfo.h) && (this.i == paramExceedBitmapInfo.i) && (Objects.a(this.b, paramExceedBitmapInfo.b)) && (Objects.a(this.d, paramExceedBitmapInfo.d)) && (Objects.a(this.a, paramExceedBitmapInfo.a));
  }
  
  @NonNull
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append(this.k);
    localStringBuffer.append(",");
    localStringBuffer.append(this.b);
    localStringBuffer.append(",");
    localStringBuffer.append(this.g);
    localStringBuffer.append(",");
    localStringBuffer.append(this.h);
    localStringBuffer.append(",");
    localStringBuffer.append(this.e);
    localStringBuffer.append(",");
    localStringBuffer.append(this.f);
    localStringBuffer.append(",");
    localStringBuffer.append(this.d);
    localStringBuffer.append(",");
    localStringBuffer.append(this.c);
    localStringBuffer.append(",");
    localStringBuffer.append(this.i);
    localStringBuffer.append(",");
    localStringBuffer.append(this.j);
    localStringBuffer.append(",");
    localStringBuffer.append(this.a);
    localStringBuffer.append("\r\n");
    return localStringBuffer.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass())) {
      return a((ExceedBitmapInfo)paramObject);
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.b, this.d, Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), this.a });
  }
  
  public String toString()
  {
    return String.format("ExceedBitmapInfo{%s}", new Object[] { a() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.datainfo.ExceedBitmapInfo
 * JD-Core Version:    0.7.0.1
 */