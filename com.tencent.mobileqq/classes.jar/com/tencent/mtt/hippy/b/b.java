package com.tencent.mtt.hippy.b;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class b
{
  private static final List<Integer> n = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10) });
  private static final List<Integer> o = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
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
  
  public b(d paramd)
  {
    this.a = paramd;
  }
  
  private void a()
  {
    int i1 = 0;
    Object localObject = a(this.k, this.j, 0);
    int i2 = this.f;
    if (i2 == 0)
    {
      if (this.i == 0) {
        throw new b.b("Mode was not set.");
      }
      this.m.write((byte[])localObject);
      if (this.d)
      {
        localObject = this.m.toByteArray();
        if (this.i != 1) {
          break label94;
        }
        this.a.d().b(c((byte[])localObject));
        b();
      }
    }
    label94:
    do
    {
      return;
      this.a.d().a((byte[])localObject);
      break;
      if (i2 == 1)
      {
        if (this.d)
        {
          localObject = c((byte[])localObject);
          this.a.d().b((String)localObject);
          return;
        }
        this.i = 1;
        this.m.write((byte[])localObject);
        return;
      }
      if (i2 == 2)
      {
        if (this.d)
        {
          this.a.d().a((byte[])localObject);
          return;
        }
        this.i = 2;
        this.m.write((byte[])localObject);
        return;
      }
      if (i2 == 8)
      {
        if (localObject.length >= 2) {
          i1 = localObject[0] * 256 + localObject[1];
        }
        if (localObject.length > 2) {}
        for (localObject = c(a((byte[])localObject, 2));; localObject = null)
        {
          Log.d("HybiParser", "Got close op! " + i1 + " " + (String)localObject);
          this.a.d().a(i1, (String)localObject);
          return;
        }
      }
      if (i2 == 9)
      {
        if (localObject.length > 125) {
          throw new b.b("Ping payload too large");
        }
        Log.d("HybiParser", "Sending pong!!");
        this.a.b(a((byte[])localObject, 10, -1));
        return;
      }
    } while (i2 != 10);
    localObject = c((byte[])localObject);
    Log.d("HybiParser", "Got pong! " + (String)localObject);
  }
  
  private void a(byte paramByte)
  {
    int i1;
    int i2;
    if ((paramByte & 0x40) == 64)
    {
      i1 = 1;
      if ((paramByte & 0x20) != 32) {
        break label62;
      }
      i2 = 1;
      label22:
      if ((paramByte & 0x10) != 16) {
        break label67;
      }
    }
    label62:
    label67:
    for (int i3 = 1;; i3 = 0)
    {
      if ((i1 == 0) && (i2 == 0) && (i3 == 0)) {
        break label73;
      }
      throw new b.b("RSV not zero");
      i1 = 0;
      break;
      i2 = 0;
      break label22;
    }
    label73:
    if ((paramByte & 0x80) == 128) {}
    for (boolean bool = true;; bool = false)
    {
      this.d = bool;
      this.f = (paramByte & 0xF);
      this.j = new byte[0];
      this.k = new byte[0];
      if (n.contains(Integer.valueOf(this.f))) {
        break;
      }
      throw new b.b("Bad opcode");
    }
    if ((!o.contains(Integer.valueOf(this.f))) && (!this.d)) {
      throw new b.b("Expected non-final packet");
    }
    this.c = 1;
  }
  
  private byte[] a(Object paramObject, int paramInt1, int paramInt2)
  {
    if (this.l) {
      return null;
    }
    Log.d("HybiParser", "Creating frame for: " + paramObject + " op: " + paramInt1 + " err: " + paramInt2);
    int i2;
    label75:
    int i4;
    int i1;
    label92:
    int i3;
    label102:
    int i5;
    label121:
    byte[] arrayOfByte;
    if ((paramObject instanceof String))
    {
      paramObject = b((String)paramObject);
      if (paramInt2 <= 0) {
        break label313;
      }
      i2 = 2;
      i4 = paramObject.length + i2;
      if (i4 > 125) {
        break label319;
      }
      i1 = 2;
      if (!this.b) {
        break label339;
      }
      i3 = 4;
      i5 = i1 + i3;
      if (!this.b) {
        break label345;
      }
      i3 = 128;
      arrayOfByte = new byte[i4 + i5];
      arrayOfByte[0] = ((byte)((byte)paramInt1 | 0xFFFFFF80));
      if (i4 > 125) {
        break label351;
      }
      arrayOfByte[1] = ((byte)(i3 | i4));
    }
    for (;;)
    {
      if (paramInt2 > 0)
      {
        arrayOfByte[i5] = ((byte)((int)Math.floor(paramInt2 / 256) & 0xFF));
        arrayOfByte[(i5 + 1)] = ((byte)(paramInt2 & 0xFF));
      }
      System.arraycopy(paramObject, 0, arrayOfByte, i2 + i5, paramObject.length);
      if (this.b)
      {
        paramObject = new byte[4];
        paramObject[0] = ((byte)(int)Math.floor(Math.random() * 256.0D));
        paramObject[1] = ((byte)(int)Math.floor(Math.random() * 256.0D));
        paramObject[2] = ((byte)(int)Math.floor(Math.random() * 256.0D));
        paramObject[3] = ((byte)(int)Math.floor(Math.random() * 256.0D));
        System.arraycopy(paramObject, 0, arrayOfByte, i1, paramObject.length);
        a(arrayOfByte, paramObject, i5);
      }
      return arrayOfByte;
      paramObject = (byte[])paramObject;
      break;
      label313:
      i2 = 0;
      break label75;
      label319:
      if (i4 <= 65535)
      {
        i1 = 4;
        break label92;
      }
      i1 = 10;
      break label92;
      label339:
      i3 = 0;
      break label102;
      label345:
      i3 = 0;
      break label121;
      label351:
      if (i4 <= 65535)
      {
        arrayOfByte[1] = ((byte)(i3 | 0x7E));
        arrayOfByte[2] = ((byte)(int)Math.floor(i4 / 256));
        arrayOfByte[3] = ((byte)(i4 & 0xFF));
      }
      else
      {
        arrayOfByte[1] = ((byte)(i3 | 0x7F));
        arrayOfByte[2] = ((byte)((int)Math.floor(i4 / Math.pow(2.0D, 56.0D)) & 0xFF));
        arrayOfByte[3] = ((byte)((int)Math.floor(i4 / Math.pow(2.0D, 48.0D)) & 0xFF));
        arrayOfByte[4] = ((byte)((int)Math.floor(i4 / Math.pow(2.0D, 40.0D)) & 0xFF));
        arrayOfByte[5] = ((byte)((int)Math.floor(i4 / Math.pow(2.0D, 32.0D)) & 0xFF));
        arrayOfByte[6] = ((byte)((int)Math.floor(i4 / Math.pow(2.0D, 24.0D)) & 0xFF));
        arrayOfByte[7] = ((byte)((int)Math.floor(i4 / Math.pow(2.0D, 16.0D)) & 0xFF));
        arrayOfByte[8] = ((byte)((int)Math.floor(i4 / Math.pow(2.0D, 8.0D)) & 0xFF));
        arrayOfByte[9] = ((byte)(i4 & 0xFF));
      }
    }
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
    if (paramArrayOfByte2.length == 0) {}
    for (;;)
    {
      return paramArrayOfByte1;
      int i1 = 0;
      while (i1 < paramArrayOfByte1.length - paramInt)
      {
        paramArrayOfByte1[(paramInt + i1)] = ((byte)(paramArrayOfByte1[(paramInt + i1)] ^ paramArrayOfByte2[(i1 % 4)]));
        i1 += 1;
      }
    }
  }
  
  private void b()
  {
    this.i = 0;
    this.m.reset();
  }
  
  private void b(byte paramByte)
  {
    boolean bool;
    if ((paramByte & 0x80) == 128)
    {
      bool = true;
      this.e = bool;
      this.h = (paramByte & 0x7F);
      if ((this.h < 0) || (this.h > 125)) {
        break label67;
      }
      if (!this.e) {
        break label62;
      }
    }
    label62:
    for (paramByte = 3;; paramByte = 4)
    {
      this.c = paramByte;
      return;
      bool = false;
      break;
    }
    label67:
    if (this.h == 126) {}
    for (paramByte = 2;; paramByte = 8)
    {
      this.g = paramByte;
      this.c = 2;
      return;
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    this.h = d(paramArrayOfByte);
    if (this.e) {}
    for (int i1 = 3;; i1 = 4)
    {
      this.c = i1;
      return;
    }
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
    if (paramInt1 > paramInt2) {
      throw new IllegalArgumentException();
    }
    int i1 = paramArrayOfByte.length;
    if ((paramInt1 < 0) || (paramInt1 > i1)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    paramInt2 -= paramInt1;
    i1 = Math.min(paramInt2, i1 - paramInt1);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, i1);
    return arrayOfByte;
  }
  
  private static long c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte.length < paramInt2) {
      throw new IllegalArgumentException("length must be less than or equal to b.length");
    }
    long l1 = 0L;
    int i1 = 0;
    while (i1 < paramInt2)
    {
      l1 += ((paramArrayOfByte[(i1 + paramInt1)] & 0xFF) << (paramInt2 - 1 - i1) * 8);
      i1 += 1;
    }
    return l1;
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
    if ((l1 < 0L) || (l1 > 2147483647L)) {
      throw new b.b("Bad integer: " + l1);
    }
    return (int)l1;
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
      switch (this.c)
      {
      default: 
        break;
      case 0: 
        a(parama.readByte());
        break;
      case 1: 
        b(parama.readByte());
        break;
      case 2: 
        b(parama.a(this.g));
        break;
      case 3: 
        this.j = parama.a(4);
        this.c = 4;
        break;
      }
      this.k = parama.a(this.h);
      a();
      this.c = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.b.b
 * JD-Core Version:    0.7.0.1
 */