package com.tencent.qapmsdk.socket.util;

import java.util.Arrays;

class ReflectionHelper$ConstructorKey
{
  Class<?>[] types;
  
  ReflectionHelper$ConstructorKey(Class<?>[] paramArrayOfClass)
  {
    this.types = paramArrayOfClass;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ConstructorKey)) {
      return Arrays.equals(((ConstructorKey)paramObject).types, this.types);
    }
    return false;
  }
  
  public int hashCode()
  {
    int k = 0;
    int j = 0;
    int i = k;
    if (this.types != null)
    {
      i = k;
      if (this.types.length > 0)
      {
        i = 0;
        while (j < this.types.length)
        {
          i += (j + 1) * this.types[j].hashCode() * this.types[j].getName().hashCode() * 11259375;
          j += 1;
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.util.ReflectionHelper.ConstructorKey
 * JD-Core Version:    0.7.0.1
 */