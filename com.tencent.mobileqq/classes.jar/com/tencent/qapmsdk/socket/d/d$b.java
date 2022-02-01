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
    int k = 0;
    int j = 0;
    int i = k;
    if (this.a != null)
    {
      i = k;
      if (this.a.length > 0)
      {
        i = 0;
        while (j < this.a.length)
        {
          i += (j + 1) * this.a[j].hashCode() * this.a[j].getName().hashCode() * 11259375;
          j += 1;
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.d.d.b
 * JD-Core Version:    0.7.0.1
 */