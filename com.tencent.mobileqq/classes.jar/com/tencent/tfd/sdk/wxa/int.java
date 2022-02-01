package com.tencent.tfd.sdk.wxa;

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

public final class int
{
  public ByteBuffer j;
  public String k = "GBK";
  
  public int(byte[] paramArrayOfByte)
  {
    this.j = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.j;
      paramInt = localByteBuffer.get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 0)
      {
        if (i != 11)
        {
          if (i == 12) {
            return 0;
          }
          throw new if("type mismatch.");
        }
      }
      else {
        return this.j.get();
      }
    }
    else
    {
      if (paramBoolean) {
        break label90;
      }
    }
    return paramByte;
    label90:
    throw new if("require field not exist.");
  }
  
  public double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.j;
      paramInt = localByteBuffer.get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 4)
      {
        if (i != 5)
        {
          if (i != 11)
          {
            if (i == 12) {
              return 0.0D;
            }
            throw new if("type mismatch.");
          }
        }
        else {
          return this.j.getDouble();
        }
      }
      else {
        return this.j.getFloat();
      }
    }
    else
    {
      if (paramBoolean) {
        break label107;
      }
    }
    return paramDouble;
    label107:
    throw new if("require field not exist.");
  }
  
  public float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.j;
      paramInt = localByteBuffer.get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 4)
      {
        if (i != 11)
        {
          if (i == 12) {
            return 0.0F;
          }
          throw new if("type mismatch.");
        }
      }
      else {
        return this.j.getFloat();
      }
    }
    else
    {
      if (paramBoolean) {
        break label91;
      }
    }
    return paramFloat;
    label91:
    throw new if("require field not exist.");
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (b(paramInt2))
    {
      ByteBuffer localByteBuffer = this.j;
      paramInt2 = localByteBuffer.get();
      int i = (byte)(paramInt2 & 0xF);
      if ((paramInt2 & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 11)
            {
              if (i == 12) {
                return 0;
              }
              throw new if("type mismatch.");
            }
          }
          else {
            return this.j.getInt();
          }
        }
        else {
          return this.j.getShort();
        }
      }
      else {
        return this.j.get();
      }
    }
    else
    {
      if (paramBoolean) {
        break label118;
      }
    }
    return paramInt1;
    label118:
    throw new if("require field not exist.");
  }
  
  public long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.j;
      paramInt = localByteBuffer.get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 11)
      {
        if (i != 12)
        {
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2)
              {
                if (i == 3) {
                  return this.j.getLong();
                }
                throw new if("type mismatch.");
              }
              paramInt = this.j.getInt();
            }
            else
            {
              paramInt = this.j.getShort();
            }
          }
          else {
            paramInt = this.j.get();
          }
          return paramInt;
        }
        return 0L;
      }
    }
    else
    {
      if (paramBoolean) {
        break label142;
      }
    }
    return paramLong;
    label142:
    throw new if("require field not exist.");
  }
  
  public try a(try paramtry, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt)) {
      try
      {
        paramtry = (try)paramtry.getClass().newInstance();
        ByteBuffer localByteBuffer = this.j;
        paramInt = localByteBuffer.get();
        int i = (byte)(paramInt & 0xF);
        if ((paramInt & 0xF0) >> 4 == 15) {
          localByteBuffer.get();
        }
        if (i == 10)
        {
          paramtry.a(this);
          j();
          return paramtry;
        }
        throw new if("type mismatch.");
      }
      catch (Exception paramtry)
      {
        throw new if(paramtry.getMessage());
      }
    }
    if (!paramBoolean) {
      return null;
    }
    throw new if("require field not exist.");
  }
  
  public <T> Object a(T paramT, int paramInt, boolean paramBoolean)
  {
    boolean bool = paramT instanceof Byte;
    int i = 0;
    if (bool) {
      return Byte.valueOf(a((byte)0, paramInt, paramBoolean));
    }
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
    if ((paramT instanceof Map))
    {
      paramT = (Map)paramT;
      localObject1 = new HashMap();
      if ((paramT != null) && (!paramT.isEmpty()))
      {
        paramT = (Map.Entry)paramT.entrySet().iterator().next();
        localObject2 = paramT.getKey();
        localObject3 = paramT.getValue();
        if (b(paramInt))
        {
          paramT = this.j;
          paramInt = paramT.get();
          i = (byte)(paramInt & 0xF);
          if ((paramInt & 0xF0) >> 4 == 15) {
            paramT.get();
          }
          if (i != 8)
          {
            if (i == 11) {
              return localObject1;
            }
            throw new if("type mismatch.");
          }
          i = a(0, 0, true);
          if (i >= 0)
          {
            paramInt = 0;
            for (;;)
            {
              paramT = (TT)localObject1;
              if (paramInt >= i) {
                break;
              }
              ((Map)localObject1).put(a(localObject2, 0, true), a(localObject3, 1, true));
              paramInt += 1;
            }
          }
          throw new if(do.a("size invalid: ", i));
        }
        if (!paramBoolean) {
          return localObject1;
        }
        throw new if("require field not exist.");
      }
      paramT = new HashMap();
      return paramT;
    }
    bool = paramT instanceof List;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    Object localObject7 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    if (bool)
    {
      paramT = (List)paramT;
      if ((paramT != null) && (!paramT.isEmpty()))
      {
        localObject2 = b(paramT.get(0), paramInt, paramBoolean);
        if (localObject2 == null) {
          return null;
        }
        localObject1 = new ArrayList();
        paramInt = i;
        for (;;)
        {
          paramT = (TT)localObject1;
          if (paramInt >= localObject2.length) {
            break;
          }
          ((ArrayList)localObject1).add(localObject2[paramInt]);
          paramInt += 1;
        }
      }
      paramT = new ArrayList();
      return paramT;
    }
    if ((paramT instanceof try)) {
      return a((try)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if ((!(paramT instanceof byte[])) && (!(paramT instanceof Byte[])))
      {
        if ((paramT instanceof boolean[]))
        {
          if (b(paramInt))
          {
            paramT = this.j;
            paramInt = paramT.get();
            i = (byte)(paramInt & 0xF);
            if ((paramInt & 0xF0) >> 4 == 15) {
              paramT.get();
            }
            if (i != 9)
            {
              if (i == 11) {
                return null;
              }
              throw new if("type mismatch.");
            }
            i = a(0, 0, true);
            if (i >= 0)
            {
              localObject1 = new boolean[i];
              paramInt = 0;
              for (;;)
              {
                paramT = (TT)localObject1;
                if (paramInt >= i) {
                  break;
                }
                localObject1[paramInt] = a(localObject1[0], 0, true);
                paramInt += 1;
              }
            }
            throw new if(do.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = localObject3;
            return paramT;
          }
          throw new if("require field not exist.");
        }
        if ((paramT instanceof short[]))
        {
          if (b(paramInt))
          {
            paramT = this.j;
            paramInt = paramT.get();
            i = (byte)(paramInt & 0xF);
            if ((paramInt & 0xF0) >> 4 == 15) {
              paramT.get();
            }
            if (i != 9)
            {
              if (i == 11) {
                return null;
              }
              throw new if("type mismatch.");
            }
            i = a(0, 0, true);
            if (i >= 0)
            {
              localObject1 = new short[i];
              paramInt = 0;
              for (;;)
              {
                paramT = (TT)localObject1;
                if (paramInt >= i) {
                  break;
                }
                localObject1[paramInt] = a(localObject1[0], 0, true);
                paramInt += 1;
              }
            }
            throw new if(do.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = localObject4;
            return paramT;
          }
          throw new if("require field not exist.");
        }
        if ((paramT instanceof int[]))
        {
          if (b(paramInt))
          {
            paramT = this.j;
            paramInt = paramT.get();
            i = (byte)(paramInt & 0xF);
            if ((paramInt & 0xF0) >> 4 == 15) {
              paramT.get();
            }
            if (i != 9)
            {
              if (i == 11) {
                return null;
              }
              throw new if("type mismatch.");
            }
            i = a(0, 0, true);
            if (i >= 0)
            {
              localObject1 = new int[i];
              paramInt = 0;
              for (;;)
              {
                paramT = (TT)localObject1;
                if (paramInt >= i) {
                  break;
                }
                localObject1[paramInt] = a(localObject1[0], 0, true);
                paramInt += 1;
              }
            }
            throw new if(do.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = localObject5;
            return paramT;
          }
          throw new if("require field not exist.");
        }
        if ((paramT instanceof long[]))
        {
          if (b(paramInt))
          {
            paramT = this.j;
            paramInt = paramT.get();
            i = (byte)(paramInt & 0xF);
            if ((paramInt & 0xF0) >> 4 == 15) {
              paramT.get();
            }
            if (i != 9)
            {
              if (i == 11) {
                return null;
              }
              throw new if("type mismatch.");
            }
            i = a(0, 0, true);
            if (i >= 0)
            {
              localObject1 = new long[i];
              paramInt = 0;
              for (;;)
              {
                paramT = (TT)localObject1;
                if (paramInt >= i) {
                  break;
                }
                localObject1[paramInt] = a(localObject1[0], 0, true);
                paramInt += 1;
              }
            }
            throw new if(do.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = localObject6;
            return paramT;
          }
          throw new if("require field not exist.");
        }
        if ((paramT instanceof float[]))
        {
          paramT = (float[])null;
          if (b(paramInt))
          {
            paramT = this.j;
            paramInt = paramT.get();
            i = (byte)(paramInt & 0xF);
            if ((paramInt & 0xF0) >> 4 == 15) {
              paramT.get();
            }
            if (i != 9)
            {
              if (i == 11) {
                return null;
              }
              throw new if("type mismatch.");
            }
            i = a(0, 0, true);
            if (i >= 0)
            {
              localObject1 = new float[i];
              paramInt = 0;
              for (;;)
              {
                paramT = (TT)localObject1;
                if (paramInt >= i) {
                  break;
                }
                localObject1[paramInt] = a(localObject1[0], 0, true);
                paramInt += 1;
              }
            }
            throw new if(do.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = (TT)localObject1;
            return paramT;
          }
          throw new if("require field not exist.");
        }
        if ((paramT instanceof double[]))
        {
          if (b(paramInt))
          {
            paramT = this.j;
            paramInt = paramT.get();
            i = (byte)(paramInt & 0xF);
            if ((paramInt & 0xF0) >> 4 == 15) {
              paramT.get();
            }
            if (i != 9)
            {
              if (i == 11) {
                return null;
              }
              throw new if("type mismatch.");
            }
            i = a(0, 0, true);
            if (i >= 0)
            {
              localObject1 = new double[i];
              paramInt = 0;
              for (;;)
              {
                paramT = (TT)localObject1;
                if (paramInt >= i) {
                  break;
                }
                localObject1[paramInt] = a(localObject1[0], 0, true);
                paramInt += 1;
              }
            }
            throw new if(do.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = localObject7;
            return paramT;
          }
          throw new if("require field not exist.");
        }
        paramT = (Object[])paramT;
        if (paramT.length != 0) {
          return b(paramT[0], paramInt, paramBoolean);
        }
        throw new if("unable to get type of key and value.");
      }
      if (b(paramInt))
      {
        paramT = this.j;
        int m = paramT.get();
        i = (byte)(m & 0xF);
        if ((m & 0xF0) >> 4 == 15) {
          paramT.get();
        }
        if (i != 9)
        {
          paramT = (TT)localObject2;
          if (i != 11)
          {
            if (i == 13)
            {
              paramT = this.j;
              int n = paramT.get();
              m = (byte)(n & 0xF);
              if ((n & 0xF0) >> 4 == 15) {
                paramT.get();
              }
              if (m == 0)
              {
                n = a(0, 0, true);
                if (n >= 0)
                {
                  paramT = new byte[n];
                  this.j.get(paramT);
                  return paramT;
                }
                paramT = new StringBuilder();
                paramT.append("invalid size, tag: ");
                paramT.append(paramInt);
                paramT.append(", type: ");
                paramT.append(i);
                paramT.append(", ");
                paramT.append(m);
                paramT.append(", size: ");
                paramT.append(n);
                throw new if(paramT.toString());
              }
              paramT = new StringBuilder();
              paramT.append("type mismatch, tag: ");
              paramT.append(paramInt);
              paramT.append(", type: ");
              paramT.append(i);
              paramT.append(", ");
              paramT.append(m);
              throw new if(paramT.toString());
            }
            throw new if("type mismatch.");
          }
        }
        else
        {
          i = a(0, 0, true);
          if (i >= 0)
          {
            localObject1 = new byte[i];
            paramInt = 0;
            for (;;)
            {
              paramT = (TT)localObject1;
              if (paramInt >= i) {
                break;
              }
              localObject1[paramInt] = a(localObject1[0], 0, true);
              paramInt += 1;
            }
          }
          throw new if(do.a("size invalid: ", i));
        }
      }
      else
      {
        if (paramBoolean) {
          break label1922;
        }
        paramT = (TT)localObject2;
      }
      return paramT;
      label1922:
      throw new if("require field not exist.");
    }
    paramT = new if("read object error: unsupport type.");
    for (;;)
    {
      throw paramT;
    }
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = this.j;
      paramInt = ((ByteBuffer)localObject).get();
      i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (i != 6)
      {
        if (i != 7)
        {
          if (i == 11) {
            break label219;
          }
          throw new if("type mismatch.");
        }
        paramInt = this.j.getInt();
        if ((paramInt <= 104857600) && (paramInt >= 0))
        {
          localObject = new byte[paramInt];
          this.j.get((byte[])localObject);
        }
      }
    }
    try
    {
      str = new String((byte[])localObject, this.k);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      String str;
      label127:
      break label127;
    }
    return new String((byte[])localObject);
    throw new if(do.a("String too long: ", paramInt));
    int i = this.j.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    Object localObject = new byte[paramInt];
    this.j.get((byte[])localObject);
    try
    {
      str = new String((byte[])localObject, this.k);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      label205:
      label219:
      break label205;
    }
    return new String((byte[])localObject);
    if (!paramBoolean) {
      return null;
    }
    throw new if("require field not exist.");
  }
  
  public short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.j;
      paramInt = localByteBuffer.get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 11)
          {
            if (i == 12) {
              return 0;
            }
            throw new if("type mismatch.");
          }
        }
        else {
          return this.j.getShort();
        }
      }
      else {
        return (short)this.j.get();
      }
    }
    else
    {
      if (paramBoolean) {
        break label105;
      }
    }
    return paramShort;
    label105:
    throw new if("require field not exist.");
  }
  
  public final void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new if("invalid type.");
    case 13: 
      Object localObject = this.j;
      b1 = ((ByteBuffer)localObject).get();
      b2 = (byte)(b1 & 0xF);
      if ((b1 & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (b2 == 0)
      {
        skip(a(0, 0, true));
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("skipField with invalid type, type value: ");
      ((StringBuilder)localObject).append(paramByte);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(b2);
      throw new if(((StringBuilder)localObject).toString());
    case 10: 
      j();
      return;
    case 9: 
      b2 = a(0, 0, true);
      paramByte = b1;
    case 8: 
    case 7: 
    case 6: 
    case 5: 
    case 4: 
    case 3: 
    case 2: 
    case 1: 
    case 0: 
      while (paramByte < b2)
      {
        i();
        paramByte += 1;
        continue;
        b1 = a(0, 0, true);
        paramByte = b2;
        while (paramByte < b1 * 2)
        {
          i();
          paramByte += 1;
          continue;
          skip(this.j.getInt());
          return;
          b1 = this.j.get();
          paramByte = b1;
          if (b1 < 0) {
            paramByte = b1 + 256;
          }
          skip(paramByte);
          return;
          skip(8);
          return;
          skip(4);
          return;
          skip(8);
          return;
          skip(4);
          return;
          skip(2);
          return;
          skip(1);
        }
      }
    }
  }
  
  public boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return a((byte)paramBoolean1, paramInt, paramBoolean2) != 0;
  }
  
  public boolean b(int paramInt)
  {
    boolean bool;
    int i;
    byte b;
    int m;
    for (;;)
    {
      bool = false;
      try
      {
        ByteBuffer localByteBuffer = this.j.duplicate();
        i = localByteBuffer.get();
        b = (byte)(i & 0xF);
        m = (i & 0xF0) >> 4;
        if (m != 15) {
          break;
        }
        m = localByteBuffer.get() & 0xFF;
        i = 2;
      }
      catch (if|BufferUnderflowException localif)
      {
        return false;
      }
      skip(i);
      a(b);
    }
    for (;;)
    {
      if (paramInt == m) {
        bool = true;
      }
      return bool;
      i = 1;
      if (paramInt > m) {
        if (b != 11) {
          break;
        }
      }
    }
  }
  
  public final <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      Object localObject = this.j;
      paramInt = ((ByteBuffer)localObject).get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (i != 9)
      {
        if (i != 11) {
          throw new if("type mismatch.");
        }
      }
      else
      {
        i = a(0, 0, true);
        if (i >= 0)
        {
          localObject = (Object[])Array.newInstance(paramT.getClass(), i);
          paramInt = 0;
          while (paramInt < i)
          {
            localObject[paramInt] = a(paramT, 0, true);
            paramInt += 1;
          }
          return localObject;
        }
        throw new if(do.a("size invalid: ", i));
      }
    }
    else
    {
      if (paramBoolean) {
        break label150;
      }
    }
    return null;
    label150:
    paramT = new if("require field not exist.");
    for (;;)
    {
      throw paramT;
    }
  }
  
  public final void i()
  {
    ByteBuffer localByteBuffer = this.j;
    int i = localByteBuffer.get();
    byte b = (byte)(i & 0xF);
    if ((i & 0xF0) >> 4 == 15) {
      localByteBuffer.get();
    }
    a(b);
  }
  
  public void j()
  {
    byte b;
    do
    {
      if (this.j.remaining() == 0) {
        return;
      }
      ByteBuffer localByteBuffer = this.j;
      int i = localByteBuffer.get();
      b = (byte)(i & 0xF);
      if ((i & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      a(b);
    } while (b != 11);
  }
  
  public final void skip(int paramInt)
  {
    ByteBuffer localByteBuffer = this.j;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.int
 * JD-Core Version:    0.7.0.1
 */