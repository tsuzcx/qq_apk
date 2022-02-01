package com.tencent.mtt.hippy.b;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class b
{
  private static final List<Integer> n;
  private static final List<Integer> o;
  private d a;
  private boolean b = true;
  private int c;
  private boolean d;
  private boolean e;
  private int f;
  private int g;
  private int h;
  private int i;
  private byte[] j = new byte[0];
  private byte[] k = new byte[0];
  private boolean l = false;
  private ByteArrayOutputStream m = new ByteArrayOutputStream();
  
  static
  {
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(1);
    Integer localInteger3 = Integer.valueOf(2);
    n = Arrays.asList(new Integer[] { localInteger1, localInteger2, localInteger3, Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10) });
    o = Arrays.asList(new Integer[] { localInteger1, localInteger2, localInteger3 });
  }
  
  public b(d paramd)
  {
    this.a = paramd;
  }
  
  private void a()
  {
    Object localObject1 = this.k;
    Object localObject2 = this.j;
    int i1 = 0;
    localObject1 = a((byte[])localObject1, (byte[])localObject2, 0);
    int i2 = this.f;
    if (i2 == 0)
    {
      if (this.i != 0)
      {
        this.m.write((byte[])localObject1);
        if (this.d)
        {
          localObject1 = this.m.toByteArray();
          if (this.i == 1) {
            this.a.d().b(c((byte[])localObject1));
          } else {
            this.a.d().a((byte[])localObject1);
          }
          b();
        }
      }
      else
      {
        throw new b.b("Mode was not set.");
      }
    }
    else
    {
      if (i2 == 1) {
        if (this.d)
        {
          localObject1 = c((byte[])localObject1);
          this.a.d().b((String)localObject1);
          return;
        }
      }
      for (this.i = 1;; this.i = 2)
      {
        this.m.write((byte[])localObject1);
        return;
        if (i2 != 2) {
          break;
        }
        if (this.d)
        {
          this.a.d().a((byte[])localObject1);
          return;
        }
      }
      if (i2 == 8)
      {
        if (localObject1.length >= 2)
        {
          i1 = localObject1[0];
          i1 = localObject1[1] + i1 * 256;
        }
        if (localObject1.length > 2) {
          localObject1 = c(a((byte[])localObject1, 2));
        } else {
          localObject1 = null;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Got close op! ");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append((String)localObject1);
        Log.d("HybiParser", ((StringBuilder)localObject2).toString());
        this.a.d().a(i1, (String)localObject1);
        return;
      }
      if (i2 == 9)
      {
        if (localObject1.length <= 125)
        {
          Log.d("HybiParser", "Sending pong!!");
          this.a.b(a((byte[])localObject1, 10, -1));
          return;
        }
        throw new b.b("Ping payload too large");
      }
      if (i2 == 10)
      {
        localObject1 = c((byte[])localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Got pong! ");
        ((StringBuilder)localObject2).append((String)localObject1);
        Log.d("HybiParser", ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private void a(byte paramByte)
  {
    int i1;
    if ((paramByte & 0x40) == 64) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if ((paramByte & 0x20) == 32) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i3;
    if ((paramByte & 0x10) == 16) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    if ((i1 == 0) && (i2 == 0) && (i3 == 0))
    {
      boolean bool;
      if ((paramByte & 0x80) == 128) {
        bool = true;
      } else {
        bool = false;
      }
      this.d = bool;
      this.f = (paramByte & 0xF);
      this.j = new byte[0];
      this.k = new byte[0];
      if (n.contains(Integer.valueOf(this.f)))
      {
        if ((!o.contains(Integer.valueOf(this.f))) && (!this.d)) {
          throw new b.b("Expected non-final packet");
        }
        this.c = 1;
        return;
      }
      throw new b.b("Bad opcode");
    }
    throw new b.b("RSV not zero");
  }
  
  private byte[] a(Object paramObject, int paramInt1, int paramInt2)
  {
    if (this.l) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Creating frame for: ");
    ((StringBuilder)localObject).append(paramObject);
    ((StringBuilder)localObject).append(" op: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" err: ");
    ((StringBuilder)localObject).append(paramInt2);
    Log.d("HybiParser", ((StringBuilder)localObject).toString());
    if ((paramObject instanceof String)) {
      paramObject = b((String)paramObject);
    } else {
      paramObject = (byte[])paramObject;
    }
    int i2;
    if (paramInt2 > 0) {
      i2 = 2;
    } else {
      i2 = 0;
    }
    int i4 = paramObject.length + i2;
    int i1;
    if (i4 <= 125) {
      i1 = 2;
    } else if (i4 <= 65535) {
      i1 = 4;
    } else {
      i1 = 10;
    }
    int i3;
    if (this.b) {
      i3 = 4;
    } else {
      i3 = 0;
    }
    int i5 = i3 + i1;
    if (this.b) {
      i3 = 128;
    } else {
      i3 = 0;
    }
    localObject = new byte[i4 + i5];
    localObject[0] = ((byte)((byte)paramInt1 | 0xFFFFFF80));
    if (i4 <= 125) {
      localObject[1] = ((byte)(i4 | i3));
    }
    for (;;)
    {
      break;
      if (i4 <= 65535)
      {
        localObject[1] = ((byte)(i3 | 0x7E));
        localObject[2] = ((byte)(int)Math.floor(i4 / 256));
        localObject[3] = ((byte)(i4 & 0xFF));
      }
      else
      {
        localObject[1] = ((byte)(i3 | 0x7F));
        double d1 = i4;
        double d2 = Math.pow(2.0D, 56.0D);
        Double.isNaN(d1);
        localObject[2] = ((byte)((int)Math.floor(d1 / d2) & 0xFF));
        d2 = Math.pow(2.0D, 48.0D);
        Double.isNaN(d1);
        localObject[3] = ((byte)((int)Math.floor(d1 / d2) & 0xFF));
        d2 = Math.pow(2.0D, 40.0D);
        Double.isNaN(d1);
        localObject[4] = ((byte)((int)Math.floor(d1 / d2) & 0xFF));
        d2 = Math.pow(2.0D, 32.0D);
        Double.isNaN(d1);
        localObject[5] = ((byte)((int)Math.floor(d1 / d2) & 0xFF));
        d2 = Math.pow(2.0D, 24.0D);
        Double.isNaN(d1);
        localObject[6] = ((byte)((int)Math.floor(d1 / d2) & 0xFF));
        d2 = Math.pow(2.0D, 16.0D);
        Double.isNaN(d1);
        localObject[7] = ((byte)((int)Math.floor(d1 / d2) & 0xFF));
        d2 = Math.pow(2.0D, 8.0D);
        Double.isNaN(d1);
        localObject[8] = ((byte)((int)Math.floor(d1 / d2) & 0xFF));
        localObject[9] = ((byte)(i4 & 0xFF));
      }
    }
    if (paramInt2 > 0)
    {
      localObject[i5] = ((byte)((int)Math.floor(paramInt2 / 256) & 0xFF));
      localObject[(i5 + 1)] = ((byte)(paramInt2 & 0xFF));
    }
    System.arraycopy(paramObject, 0, localObject, i5 + i2, paramObject.length);
    if (this.b)
    {
      paramObject = new byte[4];
      paramObject[0] = ((byte)(int)Math.floor(Math.random() * 256.0D));
      paramObject[1] = ((byte)(int)Math.floor(Math.random() * 256.0D));
      paramObject[2] = ((byte)(int)Math.floor(Math.random() * 256.0D));
      paramObject[3] = ((byte)(int)Math.floor(Math.random() * 256.0D));
      System.arraycopy(paramObject, 0, localObject, i1, paramObject.length);
      a((byte[])localObject, paramObject, i5);
    }
    return localObject;
  }
  
  private byte[] a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2);
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return b(paramArrayOfByte, paramInt, paramArrayOfByte.length);
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if (paramArrayOfByte2.length == 0) {
      return paramArrayOfByte1;
    }
    int i1 = 0;
    while (i1 < paramArrayOfByte1.length - paramInt)
    {
      int i2 = paramInt + i1;
      paramArrayOfByte1[i2] = ((byte)(paramArrayOfByte1[i2] ^ paramArrayOfByte2[(i1 % 4)]));
      i1 += 1;
    }
    return paramArrayOfByte1;
  }
  
  private void b()
  {
    this.i = 0;
    this.m.reset();
  }
  
  private void b(byte paramByte)
  {
    boolean bool;
    if ((paramByte & 0x80) == 128) {
      bool = true;
    } else {
      bool = false;
    }
    this.e = bool;
    this.h = (paramByte & 0x7F);
    paramByte = this.h;
    if ((paramByte >= 0) && (paramByte <= 125))
    {
      if (this.e) {
        paramByte = 3;
      } else {
        paramByte = 4;
      }
      this.c = paramByte;
      return;
    }
    if (this.h == 126) {
      paramByte = 2;
    } else {
      paramByte = 8;
    }
    this.g = paramByte;
    this.c = 2;
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    this.h = d(paramArrayOfByte);
    int i1;
    if (this.e) {
      i1 = 3;
    } else {
      i1 = 4;
    }
    this.c = i1;
  }
  
  private byte[] b(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  private static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i1 = paramArrayOfByte.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i1))
      {
        paramInt2 -= paramInt1;
        i1 = Math.min(paramInt2, i1 - paramInt1);
        byte[] arrayOfByte = new byte[paramInt2];
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, i1);
        return arrayOfByte;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  private static long c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte.length >= paramInt2)
    {
      long l1 = 0L;
      int i1 = 0;
      while (i1 < paramInt2)
      {
        l1 += ((paramArrayOfByte[(i1 + paramInt1)] & 0xFF) << (paramInt2 - 1 - i1) * 8);
        i1 += 1;
      }
      return l1;
    }
    paramArrayOfByte = new IllegalArgumentException("length must be less than or equal to b.length");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  private String c(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  private int d(byte[] paramArrayOfByte)
  {
    long l1 = c(paramArrayOfByte, 0, paramArrayOfByte.length);
    if ((l1 >= 0L) && (l1 <= 2147483647L)) {
      return (int)l1;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Bad integer: ");
    paramArrayOfByte.append(l1);
    throw new b.b(paramArrayOfByte.toString());
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.l) {
      return;
    }
    this.a.a(a(paramString, 8, paramInt));
    this.l = true;
  }
  
  public void a(b.a parama)
  {
    for (;;)
    {
      if (parama.available() == -1)
      {
        this.a.d().a(0, "EOF");
        return;
      }
      int i1 = this.c;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 == 4)
              {
                this.k = parama.a(this.h);
                a();
                this.c = 0;
              }
            }
            else
            {
              this.j = parama.a(4);
              this.c = 4;
            }
          }
          else {
            b(parama.a(this.g));
          }
        }
        else {
          b(parama.readByte());
        }
      }
      else {
        a(parama.readByte());
      }
    }
  }
  
  public byte[] a(String paramString)
  {
    return a(paramString, 1, -1);
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 2, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.b.b
 * JD-Core Version:    0.7.0.1
 */