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
  public ByteBuffer a;
  public String b = "GBK";
  
  public try() {}
  
  public try(byte[] paramArrayOfByte)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public try(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    this.a = paramArrayOfByte;
    paramArrayOfByte.position(paramInt);
  }
  
  public byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.a;
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
          throw new for("type mismatch.");
        }
      }
      else {
        return this.a.get();
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
    throw new for("require field not exist.");
  }
  
  public double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.a;
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
            throw new for("type mismatch.");
          }
        }
        else {
          return this.a.getDouble();
        }
      }
      else {
        return this.a.getFloat();
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
    throw new for("require field not exist.");
  }
  
  public float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.a;
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
          throw new for("type mismatch.");
        }
      }
      else {
        return this.a.getFloat();
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
    throw new for("require field not exist.");
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (b(paramInt2))
    {
      ByteBuffer localByteBuffer = this.a;
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
              throw new for("type mismatch.");
            }
          }
          else {
            return this.a.getInt();
          }
        }
        else {
          return this.a.getShort();
        }
      }
      else {
        return this.a.get();
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
    throw new for("require field not exist.");
  }
  
  public long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.a;
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
                  return this.a.getLong();
                }
                throw new for("type mismatch.");
              }
              paramInt = this.a.getInt();
            }
            else
            {
              paramInt = this.a.getShort();
            }
          }
          else {
            paramInt = this.a.get();
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
    throw new for("require field not exist.");
  }
  
  public else a(else paramelse, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt)) {
      try
      {
        paramelse = (else)paramelse.getClass().newInstance();
        ByteBuffer localByteBuffer = this.a;
        paramInt = localByteBuffer.get();
        int i = (byte)(paramInt & 0xF);
        if ((paramInt & 0xF0) >> 4 == 15) {
          localByteBuffer.get();
        }
        if (i == 10)
        {
          paramelse.a(this);
          b();
          return paramelse;
        }
        throw new for("type mismatch.");
      }
      catch (Exception paramelse)
      {
        throw new for(paramelse.getMessage());
      }
    }
    if (!paramBoolean) {
      return null;
    }
    throw new for("require field not exist.");
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
      return b(paramInt, paramBoolean);
    }
    if ((paramT instanceof Map)) {
      return a((Map)paramT, paramInt, paramBoolean);
    }
    bool = paramT instanceof List;
    Object[] arrayOfObject = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    if (bool)
    {
      paramT = (List)paramT;
      if ((paramT != null) && (!paramT.isEmpty()))
      {
        arrayOfObject = b(paramT.get(0), paramInt, paramBoolean);
        if (arrayOfObject == null) {
          return null;
        }
        localObject1 = new ArrayList();
        paramInt = i;
        for (;;)
        {
          paramT = (TT)localObject1;
          if (paramInt >= arrayOfObject.length) {
            break;
          }
          ((ArrayList)localObject1).add(arrayOfObject[paramInt]);
          paramInt += 1;
        }
      }
      paramT = new ArrayList();
      return paramT;
    }
    if ((paramT instanceof else)) {
      return a((else)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if ((!(paramT instanceof byte[])) && (!(paramT instanceof Byte[])))
      {
        if ((paramT instanceof boolean[]))
        {
          if (b(paramInt))
          {
            paramT = this.a;
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
              throw new for("type mismatch.");
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
            paramT = new StringBuilder();
            paramT.append("size invalid: ");
            paramT.append(i);
            throw new for(paramT.toString());
          }
          if (!paramBoolean)
          {
            paramT = (TT)localObject1;
            return paramT;
          }
          throw new for("require field not exist.");
        }
        if ((paramT instanceof short[]))
        {
          if (b(paramInt))
          {
            paramT = this.a;
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
              throw new for("type mismatch.");
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
            paramT = new StringBuilder();
            paramT.append("size invalid: ");
            paramT.append(i);
            throw new for(paramT.toString());
          }
          if (!paramBoolean)
          {
            paramT = arrayOfObject;
            return paramT;
          }
          throw new for("require field not exist.");
        }
        if ((paramT instanceof int[]))
        {
          if (b(paramInt))
          {
            paramT = this.a;
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
              throw new for("type mismatch.");
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
            paramT = new StringBuilder();
            paramT.append("size invalid: ");
            paramT.append(i);
            throw new for(paramT.toString());
          }
          if (!paramBoolean)
          {
            paramT = localObject2;
            return paramT;
          }
          throw new for("require field not exist.");
        }
        if ((paramT instanceof long[]))
        {
          if (b(paramInt))
          {
            paramT = this.a;
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
              throw new for("type mismatch.");
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
            paramT = new StringBuilder();
            paramT.append("size invalid: ");
            paramT.append(i);
            throw new for(paramT.toString());
          }
          if (!paramBoolean)
          {
            paramT = localObject3;
            return paramT;
          }
          throw new for("require field not exist.");
        }
        if ((paramT instanceof float[]))
        {
          if (b(paramInt))
          {
            paramT = this.a;
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
              throw new for("type mismatch.");
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
            paramT = new StringBuilder();
            paramT.append("size invalid: ");
            paramT.append(i);
            throw new for(paramT.toString());
          }
          if (!paramBoolean)
          {
            paramT = localObject4;
            return paramT;
          }
          throw new for("require field not exist.");
        }
        if ((paramT instanceof double[]))
        {
          if (b(paramInt))
          {
            paramT = this.a;
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
              throw new for("type mismatch.");
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
            paramT = new StringBuilder();
            paramT.append("size invalid: ");
            paramT.append(i);
            throw new for(paramT.toString());
          }
          if (!paramBoolean)
          {
            paramT = localObject5;
            return paramT;
          }
          throw new for("require field not exist.");
        }
        paramT = (Object[])paramT;
        if (paramT.length != 0) {
          return b(paramT[0], paramInt, paramBoolean);
        }
        throw new for("unable to get type of key and value.");
      }
      return a(paramInt, paramBoolean);
    }
    paramT = new for("read object error: unsupport type.");
    for (;;)
    {
      throw paramT;
    }
  }
  
  public String a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (b(paramInt))
    {
      localObject = this.a;
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
            break label236;
          }
          throw new for("type mismatch.");
        }
        paramInt = this.a.getInt();
        if ((paramInt <= 104857600) && (paramInt >= 0))
        {
          paramString = new byte[paramInt];
          this.a.get(paramString);
        }
      }
    }
    try
    {
      localObject = new String(paramString, this.b);
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      label127:
      break label127;
    }
    return new String(paramString);
    paramString = new StringBuilder();
    paramString.append("String too long: ");
    paramString.append(paramInt);
    throw new for(paramString.toString());
    int i = this.a.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    paramString = new byte[paramInt];
    this.a.get(paramString);
    try
    {
      localObject = new String(paramString, this.b);
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      label223:
      break label223;
    }
    return new String(paramString);
    if (!paramBoolean) {
      label236:
      return paramString;
    }
    throw new for("require field not exist.");
  }
  
  public <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (Map.Entry)paramMap.entrySet().iterator().next();
      Object localObject1 = paramMap.getKey();
      Object localObject2 = paramMap.getValue();
      if (b(paramInt))
      {
        paramMap = this.a;
        paramInt = paramMap.get();
        int i = (byte)(paramInt & 0xF);
        if ((paramInt & 0xF0) >> 4 == 15) {
          paramMap.get();
        }
        if (i != 8)
        {
          if (i == 11) {
            return localHashMap;
          }
          throw new for("type mismatch.");
        }
        i = a(0, 0, true);
        if (i >= 0)
        {
          paramInt = 0;
          for (;;)
          {
            paramMap = localHashMap;
            if (paramInt >= i) {
              break;
            }
            localHashMap.put(a(localObject1, 0, true), a(localObject2, 1, true));
            paramInt += 1;
          }
        }
        paramMap = new StringBuilder();
        paramMap.append("size invalid: ");
        paramMap.append(i);
        throw new for(paramMap.toString());
      }
      if (!paramBoolean) {
        return localHashMap;
      }
      throw new for("require field not exist.");
    }
    paramMap = new HashMap();
    return paramMap;
  }
  
  public short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.a;
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
            throw new for("type mismatch.");
          }
        }
        else {
          return this.a.getShort();
        }
      }
      else {
        return (short)this.a.get();
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
    throw new for("require field not exist.");
  }
  
  public final void a()
  {
    ByteBuffer localByteBuffer = this.a;
    int i = localByteBuffer.get();
    byte b1 = (byte)(i & 0xF);
    if ((i & 0xF0) >> 4 == 15) {
      localByteBuffer.get();
    }
    a(b1);
  }
  
  public final void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new for("invalid type.");
    case 13: 
      Object localObject = this.a;
      b1 = ((ByteBuffer)localObject).get();
      b2 = (byte)(b1 & 0xF);
      if ((b1 & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (b2 == 0)
      {
        a(a(0, 0, true));
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("skipField with invalid type, type value: ");
      ((StringBuilder)localObject).append(paramByte);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(b2);
      throw new for(((StringBuilder)localObject).toString());
    case 10: 
      b();
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
        a();
        paramByte += 1;
        continue;
        b1 = a(0, 0, true);
        paramByte = b2;
        while (paramByte < b1 * 2)
        {
          a();
          paramByte += 1;
          continue;
          a(this.a.getInt());
          return;
          b1 = this.a.get();
          paramByte = b1;
          if (b1 < 0) {
            paramByte = b1 + 256;
          }
          a(paramByte);
          return;
          a(8);
          return;
          a(4);
          return;
          a(8);
          return;
          a(4);
          return;
          a(2);
          return;
          a(1);
        }
      }
    }
  }
  
  public final void a(int paramInt)
  {
    ByteBuffer localByteBuffer = this.a;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
  }
  
  public boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return a((byte)paramBoolean1, paramInt, paramBoolean2) != 0;
  }
  
  public byte[] a(int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = this.a;
      int j = ((ByteBuffer)localObject).get();
      int i = (byte)(j & 0xF);
      if ((j & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (i != 9)
      {
        if (i != 11)
        {
          if (i == 13)
          {
            localObject = this.a;
            int k = ((ByteBuffer)localObject).get();
            j = (byte)(k & 0xF);
            if ((k & 0xF0) >> 4 == 15) {
              ((ByteBuffer)localObject).get();
            }
            if (j == 0)
            {
              k = a(0, 0, true);
              if (k >= 0)
              {
                localObject = new byte[k];
                this.a.get((byte[])localObject);
                return localObject;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("invalid size, tag: ");
              ((StringBuilder)localObject).append(paramInt);
              ((StringBuilder)localObject).append(", type: ");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(", ");
              ((StringBuilder)localObject).append(j);
              ((StringBuilder)localObject).append(", size: ");
              ((StringBuilder)localObject).append(k);
              throw new for(((StringBuilder)localObject).toString());
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("type mismatch, tag: ");
            ((StringBuilder)localObject).append(paramInt);
            ((StringBuilder)localObject).append(", type: ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(", ");
            ((StringBuilder)localObject).append(j);
            throw new for(((StringBuilder)localObject).toString());
          }
          throw new for("type mismatch.");
        }
      }
      else
      {
        i = a(0, 0, true);
        if (i >= 0)
        {
          localObject = new byte[i];
          paramInt = 0;
          while (paramInt < i)
          {
            localObject[paramInt] = a(localObject[0], 0, true);
            paramInt += 1;
          }
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new for(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      if (paramBoolean) {
        break label403;
      }
    }
    return null;
    label403:
    Object localObject = new for("require field not exist.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public String b(int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = this.a;
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
            break label240;
          }
          throw new for("type mismatch.");
        }
        paramInt = this.a.getInt();
        if ((paramInt <= 104857600) && (paramInt >= 0))
        {
          localObject = new byte[paramInt];
          this.a.get((byte[])localObject);
        }
      }
    }
    try
    {
      str = new String((byte[])localObject, this.b);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      String str;
      label126:
      break label126;
    }
    return new String((byte[])localObject);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("String too long: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new for(((StringBuilder)localObject).toString());
    int i = this.a.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    localObject = new byte[paramInt];
    this.a.get((byte[])localObject);
    try
    {
      str = new String((byte[])localObject, this.b);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      label226:
      break label226;
    }
    return new String((byte[])localObject);
    if (!paramBoolean) {
      label240:
      return null;
    }
    throw new for("require field not exist.");
  }
  
  public void b()
  {
    byte b1;
    do
    {
      if (this.a.remaining() == 0) {
        return;
      }
      ByteBuffer localByteBuffer = this.a;
      int i = localByteBuffer.get();
      b1 = (byte)(i & 0xF);
      if ((i & 0xF0) >> 4 == 15) {
        localByteBuffer.get();
      }
      a(b1);
    } while (b1 != 11);
  }
  
  public boolean b(int paramInt)
  {
    boolean bool;
    int i;
    byte b1;
    int j;
    for (;;)
    {
      bool = false;
      try
      {
        ByteBuffer localByteBuffer = this.a.duplicate();
        i = localByteBuffer.get();
        b1 = (byte)(i & 0xF);
        j = (i & 0xF0) >> 4;
        if (j != 15) {
          break;
        }
        j = localByteBuffer.get() & 0xFF;
        i = 2;
      }
      catch (for|BufferUnderflowException localfor)
      {
        return false;
      }
      a(i);
      a(b1);
    }
    for (;;)
    {
      if (paramInt == j) {
        bool = true;
      }
      return bool;
      i = 1;
      if (paramInt > j) {
        if (b1 != 11) {
          break;
        }
      }
    }
  }
  
  public final <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      Object localObject = this.a;
      paramInt = ((ByteBuffer)localObject).get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (i != 9)
      {
        if (i != 11) {
          throw new for("type mismatch.");
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
        paramT = new StringBuilder();
        paramT.append("size invalid: ");
        paramT.append(i);
        throw new for(paramT.toString());
      }
    }
    else
    {
      if (paramBoolean) {
        break label169;
      }
    }
    return null;
    label169:
    paramT = new for("require field not exist.");
    for (;;)
    {
      throw paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.try
 * JD-Core Version:    0.7.0.1
 */