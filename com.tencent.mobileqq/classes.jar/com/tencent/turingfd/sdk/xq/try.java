package com.tencent.turingfd.sdk.xq;

import TT;;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class try
{
  public ByteBuffer i;
  public String j = "GBK";
  
  public try() {}
  
  public try(byte[] paramArrayOfByte)
  {
    this.i = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public try(byte[] paramArrayOfByte, int paramInt)
  {
    this.i = ByteBuffer.wrap(paramArrayOfByte);
    this.i.position(paramInt);
  }
  
  public byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localByteBuffer = this.i;
      paramInt = localByteBuffer.get();
      k = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (k != 0) {
        if (k != 11)
        {
          if (k != 12) {
            break label68;
          }
          paramByte = 0;
        }
      }
    }
    label68:
    while (!paramBoolean)
    {
      ByteBuffer localByteBuffer;
      int k;
      return paramByte;
      throw new int("type mismatch.");
      return this.i.get();
    }
    throw new int("require field not exist.");
  }
  
  public double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localByteBuffer = this.i;
      paramInt = localByteBuffer.get();
      k = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (k != 4) {
        if (k != 5) {
          if (k != 11)
          {
            if (k != 12) {
              break label75;
            }
            paramDouble = 0.0D;
          }
        }
      }
    }
    label75:
    while (!paramBoolean)
    {
      ByteBuffer localByteBuffer;
      int k;
      return paramDouble;
      throw new int("type mismatch.");
      return this.i.getDouble();
      return this.i.getFloat();
    }
    throw new int("require field not exist.");
  }
  
  public float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localByteBuffer = this.i;
      paramInt = localByteBuffer.get();
      k = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (k != 4) {
        if (k != 11)
        {
          if (k != 12) {
            break label69;
          }
          paramFloat = 0.0F;
        }
      }
    }
    label69:
    while (!paramBoolean)
    {
      ByteBuffer localByteBuffer;
      int k;
      return paramFloat;
      throw new int("type mismatch.");
      return this.i.getFloat();
    }
    throw new int("require field not exist.");
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (a(paramInt2))
    {
      localByteBuffer = this.i;
      k = localByteBuffer.get();
      paramInt2 = (byte)(k & 0xF);
      if ((k & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (paramInt2 != 0) {
        if (paramInt2 != 1) {
          if (paramInt2 != 2) {
            if (paramInt2 != 11)
            {
              if (paramInt2 != 12) {
                break label77;
              }
              paramInt1 = 0;
            }
          }
        }
      }
    }
    label77:
    while (!paramBoolean)
    {
      ByteBuffer localByteBuffer;
      int k;
      return paramInt1;
      throw new int("type mismatch.");
      return this.i.getInt();
      return this.i.getShort();
      return this.i.get();
    }
    throw new int("require field not exist.");
  }
  
  public long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localByteBuffer = this.i;
      paramInt = localByteBuffer.get();
      k = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (k != 11)
      {
        if (k == 12) {
          break label139;
        }
        switch (k)
        {
        default: 
          throw new int("type mismatch.");
        case 3: 
          paramLong = this.i.getLong();
        }
      }
    }
    label139:
    while (!paramBoolean)
    {
      ByteBuffer localByteBuffer;
      int k;
      return paramLong;
      return this.i.getInt();
      return this.i.getShort();
      return this.i.get();
      return 0L;
    }
    throw new int("require field not exist.");
  }
  
  public case a(case paramcase, int paramInt, boolean paramBoolean)
  {
    ByteBuffer localByteBuffer = null;
    if (a(paramInt)) {}
    do
    {
      try
      {
        paramcase = (case)paramcase.getClass().newInstance();
        localByteBuffer = this.i;
        paramInt = localByteBuffer.get();
        int k = (byte)(paramInt & 0xF);
        if ((paramInt & 0xF0) >> 4 == 15) {
          localByteBuffer.get();
        }
        if (k == 10)
        {
          paramcase.a(this);
          b();
          return paramcase;
        }
        throw new int("type mismatch.");
      }
      catch (Exception paramcase)
      {
        throw new int(paramcase.getMessage());
      }
      paramcase = localByteBuffer;
    } while (!paramBoolean);
    throw new int("require field not exist.");
  }
  
  public <T> Object a(T paramT, int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if ((paramT instanceof Byte)) {
      paramT = Byte.valueOf(a((byte)0, paramInt, paramBoolean));
    }
    label450:
    label467:
    label610:
    label627:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            Object[] arrayOfObject;
                            do
                            {
                              return paramT;
                              if ((paramT instanceof Boolean)) {
                                return Boolean.valueOf(a(false, paramInt, paramBoolean));
                              }
                              if ((paramT instanceof Short)) {
                                return Short.valueOf(a((short)0, paramInt, paramBoolean));
                              }
                              if ((paramT instanceof Integer)) {
                                return Integer.valueOf(a(0, paramInt, paramBoolean));
                              }
                              if ((paramT instanceof Long)) {
                                return Long.valueOf(a(0L, paramInt, paramBoolean));
                              }
                              if ((paramT instanceof Float)) {
                                return Float.valueOf(a(0.0F, paramInt, paramBoolean));
                              }
                              if ((paramT instanceof Double)) {
                                return Double.valueOf(a(0.0D, paramInt, paramBoolean));
                              }
                              if ((paramT instanceof String)) {
                                return a(paramInt, paramBoolean);
                              }
                              if ((paramT instanceof Map)) {
                                return a((Map)paramT, paramInt, paramBoolean);
                              }
                              if (!(paramT instanceof List)) {
                                break;
                              }
                              paramT = (List)paramT;
                              if ((paramT == null) || (paramT.isEmpty())) {
                                return new ArrayList();
                              }
                              arrayOfObject = b(paramT.get(0), paramInt, paramBoolean);
                              paramT = (TT)localObject;
                            } while (arrayOfObject == null);
                            localObject = new ArrayList();
                            paramInt = 0;
                            for (;;)
                            {
                              paramT = (TT)localObject;
                              if (paramInt >= arrayOfObject.length) {
                                break;
                              }
                              ((ArrayList)localObject).add(arrayOfObject[paramInt]);
                              paramInt += 1;
                            }
                            if ((paramT instanceof case)) {
                              return a((case)paramT, paramInt, paramBoolean);
                            }
                            if (!paramT.getClass().isArray()) {
                              break label1302;
                            }
                            if (((paramT instanceof byte[])) || ((paramT instanceof Byte[]))) {
                              return a(null, paramInt, paramBoolean);
                            }
                            if (!(paramT instanceof boolean[])) {
                              break label467;
                            }
                            if (!a(paramInt)) {
                              break label450;
                            }
                            paramT = this.i;
                            paramInt = paramT.get();
                            k = (byte)(paramInt & 0xF);
                            if ((paramInt & 0xF0) >> 4 == 15) {
                              paramT.get();
                            }
                            if (k == 9) {
                              break;
                            }
                            paramT = (TT)localObject;
                          } while (k == 11);
                          throw new int("type mismatch.");
                          k = a(0, 0, true);
                          if (k >= 0)
                          {
                            localObject = new boolean[k];
                            paramInt = 0;
                            for (;;)
                            {
                              paramT = (TT)localObject;
                              if (paramInt >= k) {
                                break;
                              }
                              localObject[paramInt] = a(localObject[0], 0, true);
                              paramInt += 1;
                            }
                          }
                          throw new int(do.a("size invalid: ", k));
                          paramT = (TT)localObject;
                        } while (!paramBoolean);
                        throw new int("require field not exist.");
                        if (!(paramT instanceof short[])) {
                          break label627;
                        }
                        if (!a(paramInt)) {
                          break label610;
                        }
                        paramT = this.i;
                        paramInt = paramT.get();
                        k = (byte)(paramInt & 0xF);
                        if ((paramInt & 0xF0) >> 4 == 15) {
                          paramT.get();
                        }
                        if (k == 9) {
                          break;
                        }
                        paramT = (TT)localObject;
                      } while (k == 11);
                      throw new int("type mismatch.");
                      k = a(0, 0, true);
                      if (k >= 0)
                      {
                        localObject = new short[k];
                        paramInt = 0;
                        for (;;)
                        {
                          paramT = (TT)localObject;
                          if (paramInt >= k) {
                            break;
                          }
                          localObject[paramInt] = a(localObject[0], 0, true);
                          paramInt += 1;
                        }
                      }
                      throw new int(do.a("size invalid: ", k));
                      paramT = (TT)localObject;
                    } while (!paramBoolean);
                    throw new int("require field not exist.");
                    if (!(paramT instanceof int[])) {
                      break label787;
                    }
                    if (!a(paramInt)) {
                      break label770;
                    }
                    paramT = this.i;
                    paramInt = paramT.get();
                    k = (byte)(paramInt & 0xF);
                    if ((paramInt & 0xF0) >> 4 == 15) {
                      paramT.get();
                    }
                    if (k == 9) {
                      break;
                    }
                    paramT = (TT)localObject;
                  } while (k == 11);
                  throw new int("type mismatch.");
                  k = a(0, 0, true);
                  if (k >= 0)
                  {
                    localObject = new int[k];
                    paramInt = 0;
                    for (;;)
                    {
                      paramT = (TT)localObject;
                      if (paramInt >= k) {
                        break;
                      }
                      localObject[paramInt] = a(localObject[0], 0, true);
                      paramInt += 1;
                    }
                  }
                  throw new int(do.a("size invalid: ", k));
                  paramT = (TT)localObject;
                } while (!paramBoolean);
                throw new int("require field not exist.");
                if (!(paramT instanceof long[])) {
                  break label947;
                }
                if (!a(paramInt)) {
                  break label930;
                }
                paramT = this.i;
                paramInt = paramT.get();
                k = (byte)(paramInt & 0xF);
                if ((paramInt & 0xF0) >> 4 == 15) {
                  paramT.get();
                }
                if (k == 9) {
                  break;
                }
                paramT = (TT)localObject;
              } while (k == 11);
              throw new int("type mismatch.");
              k = a(0, 0, true);
              if (k >= 0)
              {
                localObject = new long[k];
                paramInt = 0;
                for (;;)
                {
                  paramT = (TT)localObject;
                  if (paramInt >= k) {
                    break;
                  }
                  localObject[paramInt] = a(localObject[0], 0, true);
                  paramInt += 1;
                }
              }
              throw new int(do.a("size invalid: ", k));
              paramT = (TT)localObject;
            } while (!paramBoolean);
            throw new int("require field not exist.");
            if (!(paramT instanceof float[])) {
              break label1112;
            }
            paramT = (float[])null;
            if (!a(paramInt)) {
              break label1095;
            }
            paramT = this.i;
            paramInt = paramT.get();
            k = (byte)(paramInt & 0xF);
            if ((paramInt & 0xF0) >> 4 == 15) {
              paramT.get();
            }
            if (k == 9) {
              break;
            }
            paramT = (TT)localObject;
          } while (k == 11);
          throw new int("type mismatch.");
          k = a(0, 0, true);
          if (k >= 0)
          {
            localObject = new float[k];
            paramInt = 0;
            for (;;)
            {
              paramT = (TT)localObject;
              if (paramInt >= k) {
                break;
              }
              localObject[paramInt] = a(localObject[0], 0, true);
              paramInt += 1;
            }
          }
          throw new int(do.a("size invalid: ", k));
          paramT = (TT)localObject;
        } while (!paramBoolean);
        throw new int("require field not exist.");
        if (!(paramT instanceof double[])) {
          break label1272;
        }
        if (!a(paramInt)) {
          break label1255;
        }
        paramT = this.i;
        paramInt = paramT.get();
        k = (byte)(paramInt & 0xF);
        if ((paramInt & 0xF0) >> 4 == 15) {
          paramT.get();
        }
        if (k == 9) {
          break;
        }
        paramT = (TT)localObject;
      } while (k == 11);
      throw new int("type mismatch.");
      int k = a(0, 0, true);
      if (k >= 0)
      {
        localObject = new double[k];
        paramInt = 0;
        for (;;)
        {
          paramT = (TT)localObject;
          if (paramInt >= k) {
            break;
          }
          localObject[paramInt] = a(localObject[0], 0, true);
          paramInt += 1;
        }
      }
      throw new int(do.a("size invalid: ", k));
      paramT = (TT)localObject;
    } while (!paramBoolean);
    label770:
    label787:
    label930:
    label947:
    label1095:
    label1112:
    label1255:
    throw new int("require field not exist.");
    label1272:
    paramT = (Object[])paramT;
    if (paramT.length != 0) {
      return b(paramT[0], paramInt, paramBoolean);
    }
    throw new int("unable to get type of key and value.");
    label1302:
    throw new int("read object error: unsupport type.");
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localObject = this.i;
      paramInt = ((ByteBuffer)localObject).get();
      k = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (k != 6) {
        if (k != 7) {
          if (k != 11) {}
        }
      }
    }
    while (!paramBoolean)
    {
      return null;
      throw new int("type mismatch.");
      paramInt = this.i.getInt();
      if ((paramInt <= 104857600) && (paramInt >= 0))
      {
        localObject = new byte[paramInt];
        this.i.get((byte[])localObject);
        try
        {
          String str1 = new String((byte[])localObject, this.j);
          return str1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          return new String((byte[])localObject);
        }
      }
      throw new int(do.a("String too long: ", paramInt));
      int k = this.i.get();
      paramInt = k;
      if (k < 0) {
        paramInt = k + 256;
      }
      Object localObject = new byte[paramInt];
      this.i.get((byte[])localObject);
      try
      {
        String str2 = new String((byte[])localObject, this.j);
        return str2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        return new String((byte[])localObject);
      }
    }
    throw new int("require field not exist.");
  }
  
  public String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localObject = this.i;
      paramInt = ((ByteBuffer)localObject).get();
      k = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (k != 6) {
        if (k != 7) {
          if (k != 11) {}
        }
      }
    }
    while (!paramBoolean)
    {
      Object localObject;
      return paramString;
      throw new int("type mismatch.");
      paramInt = this.i.getInt();
      if ((paramInt <= 104857600) && (paramInt >= 0))
      {
        paramString = new byte[paramInt];
        this.i.get(paramString);
        try
        {
          localObject = new String(paramString, this.j);
          return localObject;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          return new String(paramString);
        }
      }
      throw new int(do.a("String too long: ", paramInt));
      int k = this.i.get();
      paramInt = k;
      if (k < 0) {
        paramInt = k + 256;
      }
      paramString = new byte[paramInt];
      this.i.get(paramString);
      try
      {
        String str = new String(paramString, this.j);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        return new String(paramString);
      }
    }
    throw new int("require field not exist.");
  }
  
  public <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return new HashMap();
    }
    Object localObject = (Map.Entry)paramMap.entrySet().iterator().next();
    paramMap = ((Map.Entry)localObject).getKey();
    localObject = ((Map.Entry)localObject).getValue();
    if (a(paramInt))
    {
      ByteBuffer localByteBuffer = this.i;
      paramInt = localByteBuffer.get();
      int k = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (k != 8)
      {
        if (k == 11) {
          return localHashMap;
        }
        throw new int("type mismatch.");
      }
      k = a(0, 0, true);
      if (k >= 0)
      {
        paramInt = 0;
        while (paramInt < k)
        {
          localHashMap.put(a(paramMap, 0, true), a(localObject, 1, true));
          paramInt += 1;
        }
      }
      throw new int(do.a("size invalid: ", k));
    }
    if (!paramBoolean) {
      return localHashMap;
    }
    throw new int("require field not exist.");
    return localHashMap;
  }
  
  public short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localByteBuffer = this.i;
      paramInt = localByteBuffer.get();
      k = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (k != 0) {
        if (k != 1) {
          if (k != 11)
          {
            if (k != 12) {
              break label74;
            }
            paramShort = 0;
          }
        }
      }
    }
    label74:
    while (!paramBoolean)
    {
      ByteBuffer localByteBuffer;
      int k;
      return paramShort;
      throw new int("type mismatch.");
      return this.i.getShort();
      return (short)this.i.get();
    }
    throw new int("require field not exist.");
  }
  
  public final void a()
  {
    ByteBuffer localByteBuffer = this.i;
    int k = localByteBuffer.get();
    byte b = (byte)(k & 0xF);
    if ((k & 0xF0) >> 4 == 15) {
      localByteBuffer.get();
    }
    a(b);
  }
  
  public final void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new int("invalid type.");
    case 13: 
      ByteBuffer localByteBuffer = this.i;
      b1 = localByteBuffer.get();
      b2 = (byte)(b1 & 0xF);
      if ((b1 & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (b2 == 0) {
        skip(a(0, 0, true));
      }
    case 11: 
    case 12: 
      return;
      throw new int("skipField with invalid type, type value: " + paramByte + ", " + b2);
    case 10: 
      b();
      return;
    case 9: 
      b2 = a(0, 0, true);
      paramByte = b1;
      while (paramByte < b2)
      {
        a();
        paramByte += 1;
      }
    case 8: 
      b1 = a(0, 0, true);
      paramByte = b2;
      while (paramByte < b1 * 2)
      {
        a();
        paramByte += 1;
      }
    case 7: 
      skip(this.i.getInt());
      return;
    case 6: 
      b1 = this.i.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      skip(paramByte);
      return;
    case 5: 
      skip(8);
      return;
    case 4: 
      skip(4);
      return;
    case 3: 
      skip(8);
      return;
    case 2: 
      skip(4);
      return;
    case 1: 
      skip(2);
      return;
    }
    skip(1);
  }
  
  public boolean a(int paramInt)
  {
    int k;
    byte b;
    int m;
    for (;;)
    {
      try
      {
        ByteBuffer localByteBuffer = this.i.duplicate();
        k = localByteBuffer.get();
        b = (byte)(k & 0xF);
        k = (k & 0xF0) >> 4;
        if (k != 15) {
          break label94;
        }
        k = localByteBuffer.get() & 0xFF;
        m = 2;
      }
      catch (int localint)
      {
        return false;
        return false;
      }
      catch (BufferUnderflowException localBufferUnderflowException)
      {
        continue;
      }
      skip(m);
      a(b);
    }
    while ((paramInt <= k) || (b == 11)) {
      if (paramInt == k)
      {
        return true;
        label94:
        m = 1;
      }
    }
  }
  
  public boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return a((byte)paramBoolean1, paramInt, paramBoolean2) != 0;
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    paramArrayOfByte = null;
    if (a(paramInt))
    {
      localObject = this.i;
      m = ((ByteBuffer)localObject).get();
      k = (byte)(m & 0xF);
      if ((m & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (k != 9) {
        if (k != 11)
        {
          if (k != 13) {
            break label254;
          }
          paramArrayOfByte = this.i;
          n = paramArrayOfByte.get();
          m = (byte)(n & 0xF);
          if ((n & 0xF0) >> 4 == 15) {
            paramArrayOfByte.get();
          }
          if (m != 0) {
            break label204;
          }
          n = a(0, 0, true);
          if (n < 0) {
            break label143;
          }
          paramArrayOfByte = new byte[n];
          this.i.get(paramArrayOfByte);
        }
      }
    }
    label143:
    label204:
    label254:
    while (!paramBoolean)
    {
      Object localObject;
      int m;
      int n;
      return paramArrayOfByte;
      throw new int("invalid size, tag: " + paramInt + ", type: " + k + ", " + m + ", size: " + n);
      throw new int("type mismatch, tag: " + paramInt + ", type: " + k + ", " + m);
      throw new int("type mismatch.");
      int k = a(0, 0, true);
      if (k >= 0)
      {
        localObject = new byte[k];
        paramInt = 0;
        for (;;)
        {
          paramArrayOfByte = (byte[])localObject;
          if (paramInt >= k) {
            break;
          }
          localObject[paramInt] = a(localObject[0], 0, true);
          paramInt += 1;
        }
      }
      throw new int(do.a("size invalid: ", k));
    }
    throw new int("require field not exist.");
  }
  
  public int b(String paramString)
  {
    this.j = paramString;
    return 0;
  }
  
  public void b()
  {
    byte b;
    do
    {
      if (this.i.remaining() == 0) {
        return;
      }
      ByteBuffer localByteBuffer = this.i;
      int k = localByteBuffer.get();
      b = (byte)(k & 0xF);
      if ((k & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      a(b);
    } while (b != 11);
  }
  
  public final <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localObject = this.i;
      paramInt = ((ByteBuffer)localObject).get();
      k = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (k != 9) {
        if (k != 11) {}
      }
    }
    while (!paramBoolean)
    {
      Object localObject = null;
      return localObject;
      throw new int("type mismatch.");
      int k = a(0, 0, true);
      if (k >= 0)
      {
        Object[] arrayOfObject = (Object[])Array.newInstance(paramT.getClass(), k);
        paramInt = 0;
        for (;;)
        {
          localObject = arrayOfObject;
          if (paramInt >= k) {
            break;
          }
          arrayOfObject[paramInt] = a(paramT, 0, true);
          paramInt += 1;
        }
      }
      throw new int(do.a("size invalid: ", k));
    }
    throw new int("require field not exist.");
  }
  
  public final void skip(int paramInt)
  {
    ByteBuffer localByteBuffer = this.i;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
  }
  
  public void wrap(byte[] paramArrayOfByte)
  {
    this.i = ByteBuffer.wrap(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.try
 * JD-Core Version:    0.7.0.1
 */