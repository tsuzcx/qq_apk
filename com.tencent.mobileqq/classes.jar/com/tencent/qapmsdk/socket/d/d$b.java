package com.tencent.qapmsdk.socket.d;

import java.util.Arrays;

class d$b
{
  Class<?>[] a;
  
  d$b(Class<?>[] paramArrayOfClass)
  {
    this.a = paramArrayOfClass;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof b)) {
      return Arrays.equals(((b)paramObject).a, this.a);
    }
    return false;
  }
  
  public int hashCode()
  {
    Class[] arrayOfClass = this.a;
    int j = 0;
    if ((arrayOfClass != null) && (arrayOfClass.length > 0))
    {
      int i = 0;
      for (;;)
      {
        arrayOfClass = this.a;
        k = i;
        if (j >= arrayOfClass.length) {
          break;
        }
        k = j + 1;
        i += arrayOfClass[j].hashCode() * k * this.a[j].getName().hashCode() * 11259375;
        j = k;
      }
    }
    int k = 0;
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.d.d.b
 * JD-Core Version:    0.7.0.1
 */