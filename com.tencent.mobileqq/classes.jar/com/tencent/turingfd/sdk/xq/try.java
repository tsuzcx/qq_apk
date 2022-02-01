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
  public ByteBuffer n;
  public String o = "GBK";
  
  public try() {}
  
  public try(byte[] paramArrayOfByte)
  {
    this.n = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public try(byte[] paramArrayOfByte, int paramInt)
  {
    this.n = ByteBuffer.wrap(paramArrayOfByte);
    this.n.position(paramInt);
  }
  
  public byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.n;
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
          throw new int("type mismatch.");
        }
      }
      else {
        return this.n.get();
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
    throw new int("require field not exist.");
  }
  
  public double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.n;
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
            throw new int("type mismatch.");
          }
        }
        else {
          return this.n.getDouble();
        }
      }
      else {
        return this.n.getFloat();
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
    throw new int("require field not exist.");
  }
  
  public float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.n;
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
          throw new int("type mismatch.");
        }
      }
      else {
        return this.n.getFloat();
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
    throw new int("require field not exist.");
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (b(paramInt2))
    {
      ByteBuffer localByteBuffer = this.n;
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
              throw new int("type mismatch.");
            }
          }
          else {
            return this.n.getInt();
          }
        }
        else {
          return this.n.getShort();
        }
      }
      else {
        return this.n.get();
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
    throw new int("require field not exist.");
  }
  
  public long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.n;
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
                  return this.n.getLong();
                }
                throw new int("type mismatch.");
              }
              paramInt = this.n.getInt();
            }
            else
            {
              paramInt = this.n.getShort();
            }
          }
          else {
            paramInt = this.n.get();
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
    throw new int("require field not exist.");
  }
  
  public case a(case paramcase, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt)) {
      try
      {
        paramcase = (case)paramcase.getClass().newInstance();
        ByteBuffer localByteBuffer = this.n;
        paramInt = localByteBuffer.get();
        int i = (byte)(paramInt & 0xF);
        if ((paramInt & 0xF0) >> 4 == 15) {
          localByteBuffer.get();
        }
        if (i == 10)
        {
          paramcase.a(this);
          j();
          return paramcase;
        }
        throw new int("type mismatch.");
      }
      catch (Exception paramcase)
      {
        throw new int(paramcase.getMessage());
      }
    }
    if (!paramBoolean) {
      return null;
    }
    throw new int("require field not exist.");
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
    if ((paramT instanceof Map)) {
      return a((Map)paramT, paramInt, paramBoolean);
    }
    bool = paramT instanceof List;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject5 = null;
    Object[] arrayOfObject = null;
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
    if ((paramT instanceof case)) {
      return a((case)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if ((!(paramT instanceof byte[])) && (!(paramT instanceof Byte[])))
      {
        if ((paramT instanceof boolean[]))
        {
          if (b(paramInt))
          {
            paramT = this.n;
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
              throw new int("type mismatch.");
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
            throw new int(do.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = arrayOfObject;
            return paramT;
          }
          throw new int("require field not exist.");
        }
        if ((paramT instanceof short[]))
        {
          if (b(paramInt))
          {
            paramT = this.n;
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
              throw new int("type mismatch.");
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
            throw new int(do.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = localObject2;
            return paramT;
          }
          throw new int("require field not exist.");
        }
        if ((paramT instanceof int[]))
        {
          if (b(paramInt))
          {
            paramT = this.n;
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
              throw new int("type mismatch.");
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
            throw new int(do.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = localObject3;
            return paramT;
          }
          throw new int("require field not exist.");
        }
        if ((paramT instanceof long[]))
        {
          if (b(paramInt))
          {
            paramT = this.n;
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
              throw new int("type mismatch.");
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
            throw new int(do.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = localObject4;
            return paramT;
          }
          throw new int("require field not exist.");
        }
        if ((paramT instanceof float[]))
        {
          paramT = (float[])null;
          if (b(paramInt))
          {
            paramT = this.n;
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
              throw new int("type mismatch.");
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
            throw new int(do.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = (TT)localObject1;
            return paramT;
          }
          throw new int("require field not exist.");
        }
        if ((paramT instanceof double[]))
        {
          if (b(paramInt))
          {
            paramT = this.n;
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
              throw new int("type mismatch.");
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
            throw new int(do.a("size invalid: ", i));
          }
          if (!paramBoolean)
          {
            paramT = localObject5;
            return paramT;
          }
          throw new int("require field not exist.");
        }
        paramT = (Object[])paramT;
        if (paramT.length != 0) {
          return b(paramT[0], paramInt, paramBoolean);
        }
        throw new int("unable to get type of key and value.");
      }
      return a(null, paramInt, paramBoolean);
    }
    paramT = new int("read object error: unsupport type.");
    for (;;)
    {
      throw paramT;
    }
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = this.n;
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
            break label217;
          }
          throw new int("type mismatch.");
        }
        paramInt = this.n.getInt();
        if ((paramInt <= 104857600) && (paramInt >= 0))
        {
          localObject = new byte[paramInt];
          this.n.get((byte[])localObject);
        }
      }
    }
    try
    {
      str = new String((byte[])localObject, this.o);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      String str;
      label126:
      break label126;
    }
    return new String((byte[])localObject);
    throw new int(do.a("String too long: ", paramInt));
    int i = this.n.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    Object localObject = new byte[paramInt];
    this.n.get((byte[])localObject);
    try
    {
      str = new String((byte[])localObject, this.o);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      label203:
      label217:
      break label203;
    }
    return new String((byte[])localObject);
    if (!paramBoolean) {
      return null;
    }
    throw new int("require field not exist.");
  }
  
  public String a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (b(paramInt))
    {
      localObject = this.n;
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
            break label217;
          }
          throw new int("type mismatch.");
        }
        paramInt = this.n.getInt();
        if ((paramInt <= 104857600) && (paramInt >= 0))
        {
          paramString = new byte[paramInt];
          this.n.get(paramString);
        }
      }
    }
    try
    {
      localObject = new String(paramString, this.o);
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      label127:
      break label127;
    }
    return new String(paramString);
    throw new int(do.a("String too long: ", paramInt));
    int i = this.n.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    paramString = new byte[paramInt];
    this.n.get(paramString);
    try
    {
      localObject = new String(paramString, this.o);
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      label204:
      label217:
      break label204;
    }
    return new String(paramString);
    if (!paramBoolean) {
      return paramString;
    }
    throw new int("require field not exist.");
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
        paramMap = this.n;
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
          throw new int("type mismatch.");
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
        throw new int(do.a("size invalid: ", i));
      }
      if (!paramBoolean) {
        return localHashMap;
      }
      throw new int("require field not exist.");
    }
    paramMap = new HashMap();
    return paramMap;
  }
  
  public short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      ByteBuffer localByteBuffer = this.n;
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
            throw new int("type mismatch.");
          }
        }
        else {
          return this.n.getShort();
        }
      }
      else {
        return (short)this.n.get();
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
    throw new int("require field not exist.");
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
      Object localObject = this.n;
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
      throw new int(((StringBuilder)localObject).toString());
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
          skip(this.n.getInt());
          return;
          b1 = this.n.get();
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
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      paramArrayOfByte = this.n;
      int j = paramArrayOfByte.get();
      int i = (byte)(j & 0xF);
      if ((j & 0xF0) >> 4 == 15) {
        paramArrayOfByte.get();
      }
      if (i != 9)
      {
        if (i != 11)
        {
          if (i == 13)
          {
            paramArrayOfByte = this.n;
            int k = paramArrayOfByte.get();
            j = (byte)(k & 0xF);
            if ((k & 0xF0) >> 4 == 15) {
              paramArrayOfByte.get();
            }
            if (j == 0)
            {
              k = a(0, 0, true);
              if (k >= 0)
              {
                paramArrayOfByte = new byte[k];
                this.n.get(paramArrayOfByte);
                return paramArrayOfByte;
              }
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("invalid size, tag: ");
              paramArrayOfByte.append(paramInt);
              paramArrayOfByte.append(", type: ");
              paramArrayOfByte.append(i);
              paramArrayOfByte.append(", ");
              paramArrayOfByte.append(j);
              paramArrayOfByte.append(", size: ");
              paramArrayOfByte.append(k);
              throw new int(paramArrayOfByte.toString());
            }
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("type mismatch, tag: ");
            paramArrayOfByte.append(paramInt);
            paramArrayOfByte.append(", type: ");
            paramArrayOfByte.append(i);
            paramArrayOfByte.append(", ");
            paramArrayOfByte.append(j);
            throw new int(paramArrayOfByte.toString());
          }
          throw new int("type mismatch.");
        }
      }
      else
      {
        i = a(0, 0, true);
        if (i >= 0)
        {
          paramArrayOfByte = new byte[i];
          paramInt = 0;
          while (paramInt < i)
          {
            paramArrayOfByte[paramInt] = a(paramArrayOfByte[0], 0, true);
            paramInt += 1;
          }
          return paramArrayOfByte;
        }
        throw new int(do.a("size invalid: ", i));
      }
    }
    else
    {
      if (paramBoolean) {
        break label360;
      }
    }
    return null;
    label360:
    paramArrayOfByte = new int("require field not exist.");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public boolean b(int paramInt)
  {
    boolean bool;
    int i;
    byte b;
    int j;
    for (;;)
    {
      bool = false;
      try
      {
        ByteBuffer localByteBuffer = this.n.duplicate();
        i = localByteBuffer.get();
        b = (byte)(i & 0xF);
        j = (i & 0xF0) >> 4;
        if (j != 15) {
          break;
        }
        j = localByteBuffer.get() & 0xFF;
        i = 2;
      }
      catch (int|BufferUnderflowException localint)
      {
        return false;
      }
      skip(i);
      a(b);
    }
    for (;;)
    {
      if (paramInt == j) {
        bool = true;
      }
      return bool;
      i = 1;
      if (paramInt > j) {
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
      Object localObject = this.n;
      paramInt = ((ByteBuffer)localObject).get();
      int i = (byte)(paramInt & 0xF);
      if ((paramInt & 0xF0) >> 4 == 15) {
        ((ByteBuffer)localObject).get();
      }
      if (i != 9)
      {
        if (i != 11) {
          throw new int("type mismatch.");
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
        throw new int(do.a("size invalid: ", i));
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
    paramT = new int("require field not exist.");
    for (;;)
    {
      throw paramT;
    }
  }
  
  public int c(String paramString)
  {
    this.o = paramString;
    return 0;
  }
  
  public final void i()
  {
    ByteBuffer localByteBuffer = this.n;
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
      if (this.n.remaining() == 0) {
        return;
      }
      ByteBuffer localByteBuffer = this.n;
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
    ByteBuffer localByteBuffer = this.n;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
  }
  
  public void wrap(byte[] paramArrayOfByte)
  {
    this.n = ByteBuffer.wrap(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.try
 * JD-Core Version:    0.7.0.1
 */