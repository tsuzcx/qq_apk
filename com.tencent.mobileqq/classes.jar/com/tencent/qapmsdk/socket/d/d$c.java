package com.tencent.qapmsdk.socket.d;

import java.util.Arrays;

class d$c
{
  String a;
  Class<?>[] b;
  
  d$c(String paramString, Class<?>[] paramArrayOfClass)
  {
    this.a = paramString;
    this.b = paramArrayOfClass;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      return (paramObject.a.equals(this.a)) && (Arrays.equals(paramObject.b, this.b));
    }
    return false;
  }
  
  public int hashCode()
  {
    Class[] arrayOfClass = this.b;
    int j = 0;
    if ((arrayOfClass != null) && (arrayOfClass.length > 0))
    {
      int i = 0;
      for (;;)
      {
        arrayOfClass = this.b;
        k = i;
        if (j >= arrayOfClass.length) {
          break;
        }
        k = j + 1;
        i += arrayOfClass[j].hashCode() * k * this.b[j].getName().hashCode() * 11259375;
        j = k;
      }
    }
    int k = 0;
    return k + this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.d.d.c
 * JD-Core Version:    0.7.0.1
 */