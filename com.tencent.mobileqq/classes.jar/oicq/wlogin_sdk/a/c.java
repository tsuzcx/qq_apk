package oicq.wlogin_sdk.a;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.HashMap;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.g;
import oicq.wlogin_sdk.tools.util;

public class c
{
  public int a = 11;
  public int b = 0;
  public int c = 5;
  public int d = 0;
  protected int e = 3;
  
  public static int a(int paramInt, byte[] paramArrayOfByte, k paramk)
  {
    Object localObject = b(paramArrayOfByte);
    int j = localObject[0];
    int i = localObject[1];
    if (j == -1009) {
      return j;
    }
    int k = i + 2;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    paramk.d = (util.buf_to_int16(paramArrayOfByte, i) & 0xFFFF);
    i = k + 2;
    if (i > paramArrayOfByte.length) {
      return -1009;
    }
    int m = util.buf_to_int16(paramArrayOfByte, k);
    k = i + m;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    localObject = new byte[m];
    System.arraycopy(paramArrayOfByte, i, localObject, 0, m);
    i = k + 1;
    if (i > paramArrayOfByte.length) {
      return -1009;
    }
    m = util.buf_to_int8(paramArrayOfByte, k);
    k = i + m;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    paramk.e = new byte[m];
    System.arraycopy(paramArrayOfByte, i, paramk.e, 0, m);
    i = k + 2;
    if (i > paramArrayOfByte.length) {
      return -1009;
    }
    m = util.buf_to_int16(paramArrayOfByte, k);
    k = i + m;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    paramk.f = new byte[m];
    System.arraycopy(paramArrayOfByte, i, paramk.f, 0, m);
    i = j;
    if (paramInt == 3)
    {
      paramInt = k + 2;
      i = j;
      if (paramInt <= paramArrayOfByte.length)
      {
        i = util.buf_to_int16(paramArrayOfByte, k);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reg cmd 0x3 has ");
        localStringBuilder.append(i);
        localStringBuilder.append(" tlv");
        util.LOGI(localStringBuilder.toString());
        i = g.a(i, paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt, paramk.C);
        if (i != 0)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("parser tlv failed ");
          paramArrayOfByte.append(i);
          util.LOGI(paramArrayOfByte.toString(), "");
          return -1009;
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("reg cmd 0x3 tlv map size ");
        paramArrayOfByte.append(paramk.C.size());
        util.LOGI(paramArrayOfByte.toString());
      }
    }
    if (localObject.length <= 0) {
      return i;
    }
    paramInt = paramk.d;
    if (paramInt != 0)
    {
      if (paramInt != 31)
      {
        if ((paramInt != 44) && (paramInt != 51)) {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              if (paramInt != 4)
              {
                if (paramInt != 5)
                {
                  if ((paramInt != 6) && (paramInt != 58))
                  {
                    if (paramInt != 59)
                    {
                      util.LOGW("unhandle return code int parse_checkvalid_rsp", "", "");
                      return i;
                    }
                    if (2 > localObject.length) {
                      return -1009;
                    }
                    paramInt = util.buf_to_int16((byte[])localObject, 0);
                    if (2 + paramInt > localObject.length) {
                      return -1009;
                    }
                    paramk.s = new byte[paramInt];
                    System.arraycopy(localObject, 2, paramk.s, 0, paramInt);
                    return i;
                  }
                }
                else
                {
                  if (2 > localObject.length) {
                    return -1009;
                  }
                  paramk.t = util.buf_to_int16((byte[])localObject, 0);
                  if (4 > localObject.length) {
                    return -1009;
                  }
                  paramk.u = util.buf_to_int16((byte[])localObject, 2);
                  return i;
                }
              }
              else
              {
                if (2 > localObject.length) {
                  return -1009;
                }
                paramk.t = util.buf_to_int16((byte[])localObject, 0);
                if (4 > localObject.length) {
                  return -1009;
                }
                paramk.u = util.buf_to_int16((byte[])localObject, 2);
                return i;
              }
            }
          }
          else
          {
            if (1 > localObject.length) {
              return -1009;
            }
            paramInt = util.buf_to_int8((byte[])localObject, 0);
            j = 1 + paramInt;
            if (j > localObject.length) {
              return -1009;
            }
            paramk.o = new byte[paramInt];
            System.arraycopy(localObject, 1, paramk.o, 0, paramInt);
            paramInt = j + 1;
            k = util.buf_to_int8((byte[])localObject, j);
            j = paramInt + k;
            if (j > localObject.length) {
              return -1009;
            }
            paramk.p = new byte[k];
            System.arraycopy(localObject, paramInt, paramk.p, 0, k);
            paramInt = util.buf_to_int16((byte[])localObject, j);
            j += 2;
            if (j + paramInt > localObject.length) {
              return -1009;
            }
            paramk.q = new byte[paramInt];
            System.arraycopy(localObject, j, paramk.q, 0, paramInt);
            return i;
          }
        }
        if (2 > localObject.length) {
          return -1009;
        }
        paramInt = util.buf_to_int16((byte[])localObject, 0);
        if (2 + paramInt > localObject.length) {
          return -1009;
        }
        paramk.r = new byte[paramInt];
        System.arraycopy(localObject, 2, paramk.r, 0, paramInt);
        return i;
      }
      paramk.t = 0;
      paramk.u = 0;
      return i;
    }
    if (4 > localObject.length) {
      return -1009;
    }
    paramk.m = util.buf_to_int32((byte[])localObject, 0);
    if (5 > localObject.length) {
      return -1009;
    }
    paramInt = util.buf_to_int8((byte[])localObject, 4);
    if (5 + paramInt > localObject.length) {
      return -1009;
    }
    paramk.n = new byte[paramInt];
    System.arraycopy(localObject, 5, paramk.n, 0, paramInt);
    return i;
  }
  
  public static int a(byte[] paramArrayOfByte, k paramk)
  {
    return a(0, paramArrayOfByte, paramk);
  }
  
  public static int b(byte[] paramArrayOfByte, k paramk)
  {
    int[] arrayOfInt = b(paramArrayOfByte);
    int j = arrayOfInt[0];
    int i = arrayOfInt[1];
    if (j == -1009) {
      return j;
    }
    j = i + 2;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    paramk.d = util.buf_to_int16(paramArrayOfByte, i);
    i = j + 1;
    if (i > paramArrayOfByte.length) {
      return -1009;
    }
    int k = util.buf_to_int8(paramArrayOfByte, j);
    j = i + k;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    paramk.e = new byte[k];
    System.arraycopy(paramArrayOfByte, i, paramk.e, 0, k);
    i = j + 2;
    if (i > paramArrayOfByte.length) {
      return -1009;
    }
    k = util.buf_to_int16(paramArrayOfByte, j);
    j = i + k;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    paramk.f = new byte[k];
    System.arraycopy(paramArrayOfByte, i, paramk.f, 0, k);
    i = j + 2;
    if (i > paramArrayOfByte.length) {
      return 0;
    }
    i = g.a(util.buf_to_int16(paramArrayOfByte, j), paramArrayOfByte, i, paramArrayOfByte.length - i, paramk.C);
    if (i != 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("parser tlv failed ");
      paramArrayOfByte.append(i);
      util.LOGI(paramArrayOfByte.toString(), "");
      return -1009;
    }
    return i;
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
    int i = 8 + util.buf_to_int8(paramArrayOfByte, 7);
    if (i > paramArrayOfByte.length) {
      return new int[] { -1009, 8 };
    }
    return new int[] { 0, i };
  }
  
  public static int c(byte[] paramArrayOfByte, k paramk)
  {
    Object localObject = b(paramArrayOfByte);
    int i = localObject[0];
    int j = localObject[1];
    if (i == -1009) {
      return i;
    }
    int k = j + 2;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    paramk.d = util.buf_to_int16(paramArrayOfByte, j);
    j = k + 2;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    int m = util.buf_to_int16(paramArrayOfByte, k);
    k = j + m;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    byte[] arrayOfByte = new byte[m];
    System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, m);
    if (paramk.d == 0)
    {
      if ((paramk.j != null) && (paramk.j.length > 0)) {
        localObject = MD5.toMD5Byte(paramk.j);
      } else {
        localObject = k.a.getBytes();
      }
      localObject = cryptor.decrypt(arrayOfByte, 0, arrayOfByte.length, (byte[])localObject);
      if (localObject == null) {
        return -1009;
      }
      if (1 > localObject.length) {
        return -1009;
      }
      i = 1 + util.buf_to_int8((byte[])localObject, 0);
      if (i > localObject.length) {
        return -1009;
      }
      j = i + 8;
      if (j > localObject.length) {
        return -1009;
      }
      paramk.v = util.buf_to_int64((byte[])localObject, i);
      i = j + 2;
      if (i > localObject.length) {
        return -1009;
      }
      m = util.buf_to_int16((byte[])localObject, j);
      j = i + m;
      if (j > localObject.length) {
        return -1009;
      }
      paramk.w = new byte[m];
      System.arraycopy(localObject, i, paramk.w, 0, m);
      i = j + 2;
      if (i > localObject.length) {
        return -1009;
      }
      j = g.a(util.buf_to_int16((byte[])localObject, j), (byte[])localObject, i, localObject.length - i, paramk.C);
      if (j != 0)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("parse tlv failed ");
        paramArrayOfByte.append(j);
        util.LOGI(paramArrayOfByte.toString(), "");
        return -1009;
      }
      localObject = (tlv_t)paramk.C.get(new Integer(7));
      if (localObject != null) {
        paramk.x = ((tlv_t)localObject).get_data();
      }
      localObject = (tlv_t)paramk.C.get(new Integer(12));
      i = j;
      if (localObject != null)
      {
        k.z = util.buf_to_int64(((tlv_t)localObject).get_data(), 0);
        i = j;
      }
    }
    j = k + 1;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    m = util.buf_to_int8(paramArrayOfByte, k);
    k = j + m;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    paramk.e = new byte[m];
    System.arraycopy(paramArrayOfByte, j, paramk.e, 0, m);
    j = k + 2;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    k = util.buf_to_int16(paramArrayOfByte, k);
    if (j + k > paramArrayOfByte.length) {
      return -1009;
    }
    paramk.f = new byte[k];
    System.arraycopy(paramArrayOfByte, j, paramk.f, 0, k);
    return i;
  }
  
  public static int d(byte[] paramArrayOfByte, k paramk)
  {
    Object localObject = b(paramArrayOfByte);
    int i = localObject[0];
    int j = localObject[1];
    if (i == -1009) {
      return i;
    }
    int k = j + 2;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    paramk.d = util.buf_to_int16(paramArrayOfByte, j);
    j = k + 2;
    if (j > paramArrayOfByte.length) {
      return -1009;
    }
    int m = util.buf_to_int16(paramArrayOfByte, k);
    k = j + m;
    if (k > paramArrayOfByte.length) {
      return -1009;
    }
    paramk.f = new byte[m];
    System.arraycopy(paramArrayOfByte, j, paramk.f, 0, m);
    j = k + 2;
    if (j <= paramArrayOfByte.length)
    {
      k = util.buf_to_int16(paramArrayOfByte, k);
      if (j + k > paramArrayOfByte.length) {
        return -1009;
      }
      if (k > 0)
      {
        localObject = new byte[k + 2];
        System.arraycopy(paramArrayOfByte, j, localObject, 1, k);
        localObject[0] = 40;
        localObject[(k + 1)] = 41;
        paramArrayOfByte = new String(paramk.f);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(new String((byte[])localObject));
        localStringBuilder.append("。");
        paramk.f = paramArrayOfByte.replace("。", localStringBuilder.toString()).getBytes();
      }
    }
    return i;
  }
  
  public static int e(byte[] paramArrayOfByte, k paramk)
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
      paramk.d = ((DataInputStream)localObject).readShort();
      i = ((DataInputStream)localObject).readShort();
      if (i != 0)
      {
        byte[] arrayOfByte = new byte[i];
        ((DataInputStream)localObject).read(arrayOfByte);
        arrayOfByte = cryptor.decrypt(arrayOfByte, 0, arrayOfByte.length, paramk.l);
        if (arrayOfByte == null)
        {
          util.LOGI("no tlv in rsp", "");
          return -1;
        }
        i = g.a(util.buf_to_int16(arrayOfByte, 0), arrayOfByte, 2, arrayOfByte.length - 2, paramk.C);
        if (i != 0)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("parser tlv failed ");
          paramArrayOfByte.append(i);
          util.LOGI(paramArrayOfByte.toString(), "");
          return -1009;
        }
      }
      paramk.e = new byte[((DataInputStream)localObject).readByte()];
      ((DataInputStream)localObject).read(paramk.e);
      i = ((DataInputStream)localObject).readShort();
      if (i != 0)
      {
        paramk.f = new byte[i];
        if (((DataInputStream)localObject).read(paramk.f) != i)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("msg len ");
          paramArrayOfByte.append(i);
          paramArrayOfByte.append(" error");
          throw new Exception(paramArrayOfByte.toString());
        }
      }
      ((DataInputStream)localObject).close();
      paramArrayOfByte.close();
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      paramk = new StringBuilder();
      paramk.append("parse0x10Rsp failed ");
      paramk.append(paramArrayOfByte.getMessage());
      util.LOGI(paramk.toString(), "");
    }
    return -1009;
  }
  
  public static int f(byte[] paramArrayOfByte, k paramk)
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
      paramk.d = ((DataInputStream)localObject).readShort();
      i = ((DataInputStream)localObject).readShort();
      if (i != 0)
      {
        byte[] arrayOfByte = new byte[i];
        ((DataInputStream)localObject).read(arrayOfByte);
        arrayOfByte = cryptor.decrypt(arrayOfByte, 0, arrayOfByte.length, paramk.l);
        if (arrayOfByte == null)
        {
          util.LOGI("no tlv in rsp", "");
          return -1;
        }
        i = g.a(util.buf_to_int16(arrayOfByte, 0), arrayOfByte, 2, arrayOfByte.length - 2, paramk.C);
        if (i != 0)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("parser tlv failed ");
          paramArrayOfByte.append(i);
          util.LOGI(paramArrayOfByte.toString(), "");
          return -1009;
        }
      }
      paramk.e = new byte[((DataInputStream)localObject).readByte()];
      ((DataInputStream)localObject).read(paramk.e);
      i = ((DataInputStream)localObject).readShort();
      if (i != 0)
      {
        paramk.f = new byte[i];
        if (((DataInputStream)localObject).read(paramk.f) != i)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("msg len ");
          paramArrayOfByte.append(i);
          paramArrayOfByte.append(" error");
          throw new Exception(paramArrayOfByte.toString());
        }
      }
      ((DataInputStream)localObject).close();
      paramArrayOfByte.close();
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      paramk = new StringBuilder();
      paramk.append("parse0x11Rsp failed ");
      paramk.append(paramArrayOfByte.getMessage());
      util.LOGI(paramk.toString(), "");
    }
    return -1009;
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
    util.int8_to_buf(arrayOfByte, 12 + paramArrayOfByte.length, 3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.a.c
 * JD-Core Version:    0.7.0.1
 */