package oicq.wlogin_sdk.a;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.HashMap;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class c
{
  public int a = 11;
  public int b = 0;
  public int c = 5;
  public int d = 0;
  protected int e = 3;
  
  public static int a(int paramInt, byte[] paramArrayOfByte, j paramj)
  {
    Object localObject = b(paramArrayOfByte);
    int j = localObject[0];
    int i = localObject[1];
    if (j == -1009) {}
    do
    {
      return j;
      if (i + 2 > paramArrayOfByte.length) {
        return -1009;
      }
      paramj.d = (util.buf_to_int16(paramArrayOfByte, i) & 0xFFFF);
      int k = i + 2;
      if (k + 2 > paramArrayOfByte.length) {
        return -1009;
      }
      i = util.buf_to_int16(paramArrayOfByte, k);
      k += 2;
      if (k + i > paramArrayOfByte.length) {
        return -1009;
      }
      localObject = new byte[i];
      System.arraycopy(paramArrayOfByte, k, localObject, 0, i);
      k += i;
      if (k + 1 > paramArrayOfByte.length) {
        return -1009;
      }
      i = util.buf_to_int8(paramArrayOfByte, k);
      k += 1;
      if (k + i > paramArrayOfByte.length) {
        return -1009;
      }
      paramj.e = new byte[i];
      System.arraycopy(paramArrayOfByte, k, paramj.e, 0, i);
      k += i;
      if (k + 2 > paramArrayOfByte.length) {
        return -1009;
      }
      i = util.buf_to_int16(paramArrayOfByte, k);
      k += 2;
      if (k + i > paramArrayOfByte.length) {
        return -1009;
      }
      paramj.f = new byte[i];
      System.arraycopy(paramArrayOfByte, k, paramj.f, 0, i);
      k += i;
      i = j;
      if (paramInt == 3)
      {
        i = j;
        if (k + 2 <= paramArrayOfByte.length)
        {
          paramInt = util.buf_to_int16(paramArrayOfByte, k);
          i = k + 2;
          util.LOGI("reg cmd 0x3 has " + paramInt + " tlv");
          i = d.a(paramInt, paramArrayOfByte, i, paramArrayOfByte.length - i, paramj.B);
          if (i != 0)
          {
            util.LOGI("parser tlv failed " + i, "");
            return -1009;
          }
          util.LOGI("reg cmd 0x3 tlv map size " + paramj.B.size());
        }
      }
      j = i;
    } while (localObject.length <= 0);
    switch (paramj.d)
    {
    default: 
      util.LOGW("unhandle return code int parse_checkvalid_rsp", "", "");
      return i;
    case 0: 
      if (4 > localObject.length) {
        return -1009;
      }
      paramj.m = util.buf_to_int32((byte[])localObject, 0);
      if (5 > localObject.length) {
        return -1009;
      }
      paramInt = util.buf_to_int8((byte[])localObject, 4);
      if (paramInt + 5 > localObject.length) {
        return -1009;
      }
      paramj.n = new byte[paramInt];
      System.arraycopy(localObject, 5, paramj.n, 0, paramInt);
      return i;
    case 2: 
      if (1 > localObject.length) {
        return -1009;
      }
      paramInt = util.buf_to_int8((byte[])localObject, 0);
      if (paramInt + 1 > localObject.length) {
        return -1009;
      }
      paramj.o = new byte[paramInt];
      System.arraycopy(localObject, 1, paramj.o, 0, paramInt);
      j = paramInt + 1;
      paramInt = j + 1;
      j = util.buf_to_int8((byte[])localObject, j);
      if (paramInt + j > localObject.length) {
        return -1009;
      }
      paramj.p = new byte[j];
      System.arraycopy(localObject, paramInt, paramj.p, 0, j);
      j += paramInt;
      paramInt = util.buf_to_int16((byte[])localObject, j);
      j += 2;
      if (j + paramInt > localObject.length) {
        return -1009;
      }
      paramj.q = new byte[paramInt];
      System.arraycopy(localObject, j, paramj.q, 0, paramInt);
      return i;
    case 3: 
    case 6: 
    case 44: 
    case 51: 
      if (2 > localObject.length) {
        return -1009;
      }
      paramInt = util.buf_to_int16((byte[])localObject, 0);
      if (paramInt + 2 > localObject.length) {
        return -1009;
      }
      paramj.r = new byte[paramInt];
      System.arraycopy(localObject, 2, paramj.r, 0, paramInt);
      return i;
    case 4: 
      if (2 > localObject.length) {
        return -1009;
      }
      paramj.s = util.buf_to_int16((byte[])localObject, 0);
      if (4 > localObject.length) {
        return -1009;
      }
      paramj.t = util.buf_to_int16((byte[])localObject, 2);
      return i;
    case 31: 
      paramj.s = 0;
      paramj.t = 0;
      return i;
    }
    if (2 > localObject.length) {
      return -1009;
    }
    paramj.s = util.buf_to_int16((byte[])localObject, 0);
    if (4 > localObject.length) {
      return -1009;
    }
    paramj.t = util.buf_to_int16((byte[])localObject, 2);
    return i;
  }
  
  public static int a(byte[] paramArrayOfByte, j paramj)
  {
    return a(0, paramArrayOfByte, paramj);
  }
  
  public static int b(byte[] paramArrayOfByte, j paramj)
  {
    int[] arrayOfInt = b(paramArrayOfByte);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    if (i == -1009) {}
    do
    {
      return i;
      if (j + 2 > paramArrayOfByte.length) {
        return -1009;
      }
      paramj.d = util.buf_to_int16(paramArrayOfByte, j);
      j += 2;
      if (j + 1 > paramArrayOfByte.length) {
        return -1009;
      }
      i = util.buf_to_int8(paramArrayOfByte, j);
      j += 1;
      if (j + i > paramArrayOfByte.length) {
        return -1009;
      }
      paramj.e = new byte[i];
      System.arraycopy(paramArrayOfByte, j, paramj.e, 0, i);
      j += i;
      if (j + 2 > paramArrayOfByte.length) {
        return -1009;
      }
      i = util.buf_to_int16(paramArrayOfByte, j);
      j += 2;
      if (j + i > paramArrayOfByte.length) {
        return -1009;
      }
      paramj.f = new byte[i];
      System.arraycopy(paramArrayOfByte, j, paramj.f, 0, i);
      j += i;
      if (j + 2 > paramArrayOfByte.length) {
        return 0;
      }
      i = util.buf_to_int16(paramArrayOfByte, j);
      j += 2;
      j = d.a(i, paramArrayOfByte, j, paramArrayOfByte.length - j, paramj.B);
      i = j;
    } while (j == 0);
    util.LOGI("parser tlv failed " + j, "");
    return -1009;
  }
  
  private static int[] b(byte[] paramArrayOfByte)
  {
    if (1 > paramArrayOfByte.length) {
      return new int[] { -1009, 0 };
    }
    if (3 > paramArrayOfByte.length) {
      return new int[] { -1009, 1 };
    }
    if (util.buf_to_int16(paramArrayOfByte, 1) != paramArrayOfByte.length) {
      return new int[] { -1009, 3 };
    }
    if (7 > paramArrayOfByte.length) {
      return new int[] { -1009, 3 };
    }
    if (8 > paramArrayOfByte.length) {
      return new int[] { -1009, 7 };
    }
    int i = util.buf_to_int8(paramArrayOfByte, 7);
    if (i + 8 > paramArrayOfByte.length) {
      return new int[] { -1009, 8 };
    }
    return new int[] { 0, i + 8 };
  }
  
  public static int c(byte[] paramArrayOfByte, j paramj)
  {
    Object localObject = b(paramArrayOfByte);
    int i = localObject[0];
    int j = localObject[1];
    if (i == -1009) {
      return i;
    }
    if (j + 2 > paramArrayOfByte.length) {
      return -1009;
    }
    paramj.d = util.buf_to_int16(paramArrayOfByte, j);
    int k = j + 2;
    if (k + 2 > paramArrayOfByte.length) {
      return -1009;
    }
    j = util.buf_to_int16(paramArrayOfByte, k);
    k += 2;
    if (k + j > paramArrayOfByte.length) {
      return -1009;
    }
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, k, arrayOfByte, 0, j);
    j += k;
    if (paramj.d == 0)
    {
      if ((paramj.j == null) || (paramj.j.length <= 0)) {}
      for (localObject = j.a.getBytes();; localObject = MD5.toMD5Byte(paramj.j))
      {
        localObject = cryptor.decrypt(arrayOfByte, 0, arrayOfByte.length, (byte[])localObject);
        if (localObject != null) {
          break;
        }
        return -1009;
      }
      if (1 > localObject.length) {
        return -1009;
      }
      i = util.buf_to_int8((byte[])localObject, 0);
      if (i + 1 > localObject.length) {
        return -1009;
      }
      i += 1;
      if (i + 8 > localObject.length) {
        return -1009;
      }
      paramj.u = util.buf_to_int64((byte[])localObject, i);
      k = i + 8;
      if (k + 2 > localObject.length) {
        return -1009;
      }
      i = util.buf_to_int16((byte[])localObject, k);
      k += 2;
      if (k + i > localObject.length) {
        return -1009;
      }
      paramj.v = new byte[i];
      System.arraycopy(localObject, k, paramj.v, 0, i);
      k += i;
      if (k + 2 > localObject.length) {
        return -1009;
      }
      i = util.buf_to_int16((byte[])localObject, k);
      k += 2;
      i = d.a(i, (byte[])localObject, k, localObject.length - k, paramj.B);
      if (i != 0)
      {
        util.LOGI("parse tlv failed " + i, "");
        return -1009;
      }
      localObject = (tlv_t)paramj.B.get(new Integer(7));
      if (localObject != null) {
        paramj.w = ((tlv_t)localObject).get_data();
      }
      localObject = (tlv_t)paramj.B.get(new Integer(12));
      if (localObject != null) {
        j.y = util.buf_to_int64(((tlv_t)localObject).get_data(), 0);
      }
    }
    if (j + 1 > paramArrayOfByte.length) {
      return -1009;
    }
    k = util.buf_to_int8(paramArrayOfByte, j);
    j += 1;
    if (j + k > paramArrayOfByte.length) {
      return -1009;
    }
    paramj.e = new byte[k];
    System.arraycopy(paramArrayOfByte, j, paramj.e, 0, k);
    k += j;
    if (k + 2 > paramArrayOfByte.length) {
      return -1009;
    }
    j = util.buf_to_int16(paramArrayOfByte, k);
    k += 2;
    if (k + j > paramArrayOfByte.length) {
      return -1009;
    }
    paramj.f = new byte[j];
    System.arraycopy(paramArrayOfByte, k, paramj.f, 0, j);
    return i;
  }
  
  public static int d(byte[] paramArrayOfByte, j paramj)
  {
    Object localObject = b(paramArrayOfByte);
    int i = localObject[0];
    int j = localObject[1];
    if (i == -1009) {}
    int k;
    do
    {
      do
      {
        return i;
        if (j + 2 > paramArrayOfByte.length) {
          return -1009;
        }
        paramj.d = util.buf_to_int16(paramArrayOfByte, j);
        k = j + 2;
        if (k + 2 > paramArrayOfByte.length) {
          return -1009;
        }
        j = util.buf_to_int16(paramArrayOfByte, k);
        k += 2;
        if (k + j > paramArrayOfByte.length) {
          return -1009;
        }
        paramj.f = new byte[j];
        System.arraycopy(paramArrayOfByte, k, paramj.f, 0, j);
        k += j;
      } while (k + 2 > paramArrayOfByte.length);
      j = util.buf_to_int16(paramArrayOfByte, k);
      k += 2;
      if (k + j > paramArrayOfByte.length) {
        return -1009;
      }
    } while (j <= 0);
    localObject = new byte[j + 2];
    System.arraycopy(paramArrayOfByte, k, localObject, 1, j);
    localObject[0] = 40;
    localObject[(j + 1)] = 41;
    paramj.f = new String(paramj.f).replace("。", new String((byte[])localObject) + "。").getBytes();
    return i;
  }
  
  public static int e(byte[] paramArrayOfByte, j paramj)
  {
    Object localObject = b(paramArrayOfByte);
    int i = localObject[0];
    int j = localObject[1];
    if (i == -1009) {
      return i;
    }
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, j, paramArrayOfByte.length - j);
    localObject = new DataInputStream(paramArrayOfByte);
    try
    {
      ((DataInputStream)localObject).readByte();
      paramj.d = ((DataInputStream)localObject).readShort();
      i = ((DataInputStream)localObject).readShort();
      if (i != 0)
      {
        byte[] arrayOfByte = new byte[i];
        ((DataInputStream)localObject).read(arrayOfByte);
        arrayOfByte = cryptor.decrypt(arrayOfByte, 0, arrayOfByte.length, paramj.l);
        if (arrayOfByte == null)
        {
          util.LOGI("no tlv in rsp", "");
          return -1;
        }
        i = d.a(util.buf_to_int16(arrayOfByte, 0), arrayOfByte, 2, arrayOfByte.length - 2, paramj.B);
        if (i != 0)
        {
          util.LOGI("parser tlv failed " + i, "");
          return -1009;
        }
      }
      paramj.e = new byte[((DataInputStream)localObject).readByte()];
      ((DataInputStream)localObject).read(paramj.e);
      i = ((DataInputStream)localObject).readShort();
      if (i != 0)
      {
        paramj.f = new byte[i];
        if (((DataInputStream)localObject).read(paramj.f) != i) {
          throw new Exception("msg len " + i + " error");
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      util.LOGI("parse0x10Rsp failed " + paramArrayOfByte.getMessage(), "");
      return -1009;
    }
    ((DataInputStream)localObject).close();
    paramArrayOfByte.close();
    return 0;
  }
  
  public static int f(byte[] paramArrayOfByte, j paramj)
  {
    Object localObject = b(paramArrayOfByte);
    int i = localObject[0];
    int j = localObject[1];
    if (i == -1009) {
      return i;
    }
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, j, paramArrayOfByte.length - j);
    localObject = new DataInputStream(paramArrayOfByte);
    try
    {
      ((DataInputStream)localObject).readByte();
      paramj.d = ((DataInputStream)localObject).readShort();
      i = ((DataInputStream)localObject).readShort();
      if (i != 0)
      {
        byte[] arrayOfByte = new byte[i];
        ((DataInputStream)localObject).read(arrayOfByte);
        arrayOfByte = cryptor.decrypt(arrayOfByte, 0, arrayOfByte.length, paramj.l);
        if (arrayOfByte == null)
        {
          util.LOGI("no tlv in rsp", "");
          return -1;
        }
        i = d.a(util.buf_to_int16(arrayOfByte, 0), arrayOfByte, 2, arrayOfByte.length - 2, paramj.B);
        if (i != 0)
        {
          util.LOGI("parser tlv failed " + i, "");
          return -1009;
        }
      }
      paramj.e = new byte[((DataInputStream)localObject).readByte()];
      ((DataInputStream)localObject).read(paramj.e);
      i = ((DataInputStream)localObject).readShort();
      if (i != 0)
      {
        paramj.f = new byte[i];
        if (((DataInputStream)localObject).read(paramj.f) != i) {
          throw new Exception("msg len " + i + " error");
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      util.LOGI("parse0x11Rsp failed " + paramArrayOfByte.getMessage(), "");
      return -1009;
    }
    ((DataInputStream)localObject).close();
    paramArrayOfByte.close();
    return 0;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[this.a + 2 + paramArrayOfByte.length];
    util.int8_to_buf(arrayOfByte, 0, 2);
    util.int16_to_buf(arrayOfByte, 1, this.a + paramArrayOfByte.length + 2);
    util.int16_to_buf(arrayOfByte, 3, this.e);
    util.int16_to_buf(arrayOfByte, 5, this.b);
    util.int8_to_buf(arrayOfByte, 7, 4);
    util.int32_to_buf(arrayOfByte, 8, 0);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 12, paramArrayOfByte.length);
    int i = paramArrayOfByte.length + 12;
    util.int8_to_buf(arrayOfByte, i, 3);
    return arrayOfByte;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + 1];
    util.int8_to_buf(arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 1, paramArrayOfByte1.length);
    paramArrayOfByte1 = MD5.toMD5Byte(paramArrayOfByte2);
    return cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.c
 * JD-Core Version:    0.7.0.1
 */