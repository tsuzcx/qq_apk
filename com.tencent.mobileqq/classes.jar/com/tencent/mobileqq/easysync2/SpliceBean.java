package com.tencent.mobileqq.easysync2;

import com.tencent.mobileqq.easysync2.utils.Utils;
import java.util.Arrays;

class SpliceBean
{
  int a;
  int b;
  String c;
  
  public SpliceBean(int paramInt1, int paramInt2, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (SpliceBean)paramObject;
      return (this.a == paramObject.a) && (this.b == paramObject.b) && (Utils.a(this.c, paramObject.c));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), this.c });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.SpliceBean
 * JD-Core Version:    0.7.0.1
 */