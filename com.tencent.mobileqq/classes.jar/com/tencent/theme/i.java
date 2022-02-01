package com.tencent.theme;

import java.io.IOException;
import java.nio.ByteBuffer;

public class i
{
  private static final int g = 1835009;
  private int[] a;
  private String[] b;
  private int[] c;
  private int[] d;
  private int e;
  private ByteBuffer f;
  
  private static final int a(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt[(paramInt / 4)];
    if (paramInt % 4 / 2 == 0) {
      return i & 0xFFFF;
    }
    return i >>> 16;
  }
  
  public static i a(ByteBuffer paramByteBuffer)
  {
    a.a(paramByteBuffer, 1835009);
    int j = paramByteBuffer.getInt();
    int m = paramByteBuffer.getInt();
    int i = paramByteBuffer.getInt();
    int n = paramByteBuffer.getInt();
    int i1 = paramByteBuffer.getInt();
    int k = paramByteBuffer.getInt();
    i locali = new i();
    locali.a = a.c(paramByteBuffer, m);
    if (i != 0) {
      locali.c = a.c(paramByteBuffer, i);
    }
    int i2 = paramByteBuffer.position();
    locali.e = n;
    if (k == 0) {
      i = j;
    } else {
      i = k;
    }
    i -= i1;
    if (i % 4 == 0)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramByteBuffer.array(), i2, i);
      localByteBuffer.order(paramByteBuffer.order());
      locali.f = localByteBuffer;
      locali.b = new String[m];
      a.b(paramByteBuffer, i);
      if ((n != 0) && (n != 256))
      {
        paramByteBuffer = new StringBuilder();
        paramByteBuffer.append("Unknow version xml file: version: ");
        paramByteBuffer.append(n);
        throw new IOException(paramByteBuffer.toString());
      }
      if (k != 0)
      {
        i = j - k;
        if (i % 4 == 0)
        {
          locali.d = a.c(paramByteBuffer, i / 4);
          return locali;
        }
        paramByteBuffer = new StringBuilder();
        paramByteBuffer.append("Style data size is not multiple of 4 (");
        paramByteBuffer.append(i);
        paramByteBuffer.append(").");
        throw new IOException(paramByteBuffer.toString());
      }
      return locali;
    }
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("String data size is not multiple of 4 (");
    paramByteBuffer.append(i);
    paramByteBuffer.append(").");
    throw new IOException(paramByteBuffer.toString());
  }
  
  private int[] d(int paramInt)
  {
    int[] arrayOfInt3 = this.c;
    int[] arrayOfInt2 = null;
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt3 != null)
    {
      arrayOfInt1 = arrayOfInt2;
      if (this.d != null)
      {
        if (paramInt >= arrayOfInt3.length) {
          return null;
        }
        paramInt = arrayOfInt3[paramInt] / 4;
        int k = 0;
        int i = paramInt;
        int j = 0;
        for (;;)
        {
          arrayOfInt1 = this.d;
          if ((i >= arrayOfInt1.length) || (arrayOfInt1[i] == -1)) {
            break;
          }
          j += 1;
          i += 1;
        }
        arrayOfInt1 = arrayOfInt2;
        if (j != 0)
        {
          if (j % 3 != 0) {
            return null;
          }
          arrayOfInt2 = new int[j];
          i = k;
          for (;;)
          {
            arrayOfInt3 = this.d;
            arrayOfInt1 = arrayOfInt2;
            if (paramInt >= arrayOfInt3.length) {
              break;
            }
            if (arrayOfInt3[paramInt] == -1) {
              return arrayOfInt2;
            }
            arrayOfInt2[i] = arrayOfInt3[paramInt];
            i += 1;
            paramInt += 1;
          }
        }
      }
    }
    return arrayOfInt1;
  }
  
  public int a()
  {
    int[] arrayOfInt = this.a;
    if (arrayOfInt != null) {
      return arrayOfInt.length;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    int i = 0;
    for (;;)
    {
      Object localObject1 = this.b;
      if (i >= localObject1.length) {
        break;
      }
      Object localObject2 = localObject1[i];
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a(i);
      }
      if (paramString.equals(localObject1)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public String a(int paramInt)
  {
    if (paramInt >= 0)
    {
      int[] arrayOfInt = this.a;
      if ((arrayOfInt != null) && (paramInt < arrayOfInt.length))
      {
        String str = this.b[paramInt];
        Object localObject = str;
        if (str == null)
        {
          int i = arrayOfInt[paramInt];
          this.f.mark();
          a.b(this.f, i);
          if (this.e == 0)
          {
            localObject = new char[this.f.getShort()];
            i = 0;
            while (i < localObject.length)
            {
              localObject[i] = this.f.getChar();
              i += 1;
            }
            localObject = new String((char[])localObject);
          }
          else
          {
            i = this.f.get();
            this.f.get();
            localObject = new String(a.d(this.f, i));
          }
          this.b[paramInt] = localObject;
          this.f.reset();
        }
        return localObject;
      }
    }
    return null;
  }
  
  public CharSequence b(int paramInt)
  {
    return a(paramInt);
  }
  
  public String c(int paramInt)
  {
    String str = a(paramInt);
    if (str == null) {
      return str;
    }
    int[] arrayOfInt = d(paramInt);
    if (arrayOfInt == null) {
      return str;
    }
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 32);
    paramInt = 0;
    for (;;)
    {
      int i = 0;
      int j;
      for (int k = -1; i != arrayOfInt.length; k = j)
      {
        m = i + 1;
        if (arrayOfInt[m] == -1)
        {
          j = k;
        }
        else if (k != -1)
        {
          j = k;
          if (arrayOfInt[(k + 1)] <= arrayOfInt[m]) {}
        }
        else
        {
          j = i;
        }
        i += 3;
      }
      if (k != -1) {
        i = arrayOfInt[(k + 1)];
      } else {
        i = str.length();
      }
      int m = 0;
      while (m != arrayOfInt.length)
      {
        int n = m + 2;
        int i1 = arrayOfInt[n];
        j = paramInt;
        if (i1 != -1) {
          if (i1 >= i)
          {
            j = paramInt;
          }
          else
          {
            j = paramInt;
            if (paramInt <= i1)
            {
              j = i1 + 1;
              localStringBuilder.append(str, paramInt, j);
            }
            arrayOfInt[n] = -1;
            localStringBuilder.append('<');
            localStringBuilder.append('/');
            localStringBuilder.append(a(arrayOfInt[m]));
            localStringBuilder.append('>');
          }
        }
        m += 3;
        paramInt = j;
      }
      if (paramInt < i)
      {
        localStringBuilder.append(str, paramInt, i);
        paramInt = i;
      }
      if (k == -1) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append('<');
      localStringBuilder.append(a(arrayOfInt[k]));
      localStringBuilder.append('>');
      arrayOfInt[(k + 1)] = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.i
 * JD-Core Version:    0.7.0.1
 */