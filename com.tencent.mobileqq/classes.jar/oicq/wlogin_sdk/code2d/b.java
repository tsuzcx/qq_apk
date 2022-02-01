package oicq.wlogin_sdk.code2d;

import android.content.Context;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import oicq.wlogin_sdk.request.WloginAllSigInfo;
import oicq.wlogin_sdk.request.oicq_request;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.f;
import oicq.wlogin_sdk.tools.util;

public class b
  extends c
{
  protected static byte[] a;
  
  public b()
  {
    this._cmd = 20;
  }
  
  public int a(byte[] paramArrayOfByte, long paramLong, Context paramContext, Map<Integer, tlv_t> paramMap)
  {
    Object localObject2 = get_response(paramArrayOfByte, 0);
    if (localObject2 != null)
    {
      if (localObject2.length < 11) {
        return -1009;
      }
      _status.a = util.buf_to_int64((byte[])localObject2, 2);
      _status.b = (util.buf_to_int8((byte[])localObject2, 10) & 0xFF);
      if (_status.b != 0)
      {
        i = util.buf_to_int16((byte[])localObject2, 11);
        _status.f = new byte[i];
        System.arraycopy(localObject2, 13, _status.f, 0, i);
        return _status.b;
      }
      _status.c = (util.buf_to_int32((byte[])localObject2, 11) & 0xFFFFFFFF);
      int i = util.buf_to_int16((byte[])localObject2, 15);
      _status.d = new byte[i];
      System.arraycopy(localObject2, 17, _status.d, 0, i);
      int j = 17 + i;
      i = j + 2;
      if (i + 2 + 1 >= localObject2.length) {
        return _status.b;
      }
      j = util.buf_to_int16((byte[])localObject2, j);
      if (j == 0) {
        return _status.b;
      }
      byte[] arrayOfByte2 = cryptor.decrypt((byte[])localObject2, i, j, a);
      if ((arrayOfByte2 != null) && (arrayOfByte2.length != 0))
      {
        int k = i + j;
        int m = util.buf_to_int16(arrayOfByte2, 0);
        byte[] arrayOfByte1 = null;
        paramArrayOfByte = arrayOfByte1;
        Object localObject1 = paramArrayOfByte;
        i = 0;
        j = 2;
        while (i < m)
        {
          int n = util.buf_to_int16(arrayOfByte2, j);
          int i1 = j + 2;
          j = util.buf_to_int16(arrayOfByte2, i1);
          i1 += 2;
          if (n != 24)
          {
            if (n != 25)
            {
              if (n == 30)
              {
                localObject1 = new byte[j];
                System.arraycopy(arrayOfByte2, i1, localObject1, 0, j);
              }
            }
            else
            {
              arrayOfByte1 = new byte[j];
              System.arraycopy(arrayOfByte2, i1, arrayOfByte1, 0, j);
            }
          }
          else
          {
            paramArrayOfByte = new byte[j];
            System.arraycopy(arrayOfByte2, i1, paramArrayOfByte, 0, j);
          }
          j = i1 + j;
          i += 1;
        }
        i = util.buf_to_int16((byte[])localObject2, k);
        j = k + 2;
        i = f.a(i, (byte[])localObject2, j, localObject2.length - j, paramMap);
        if (i != 0)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("parseTLV failed ");
          paramArrayOfByte.append(i);
          util.LOGI(paramArrayOfByte.toString(), "");
          return -1009;
        }
        if (d.t) {
          if ((arrayOfByte1 != null) && (paramArrayOfByte != null))
          {
            if (localObject1 == null) {
              return -1009;
            }
            paramContext = oicq.wlogin_sdk.request.c.a(paramContext, "tk_file", 0L);
            if (paramContext == null) {
              return -1004;
            }
            paramMap = (WloginAllSigInfo)paramContext.get(Long.valueOf(_status.a));
            if (paramMap == null) {
              return -1004;
            }
            localObject2 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 5, 0 });
            i = 0;
            while (i < 5)
            {
              localObject2[i] = new byte[0];
              i += 1;
            }
            localObject2[0] = oicq_request.b(paramArrayOfByte, (byte[])localObject1);
            localObject2[1] = arrayOfByte1;
            if ((localObject2 != null) && (localObject2[0] != null) && (localObject2[0].length > 0))
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("A1_INFO: update A1 Close code: ");
              paramArrayOfByte.append(MD5.getMD5String(localObject2[0]));
              paramArrayOfByte = paramArrayOfByte.toString();
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("");
              ((StringBuilder)localObject1).append(_status.a);
              util.LOGI(paramArrayOfByte, ((StringBuilder)localObject1).toString());
            }
            paramMap.put_siginfo(paramLong, (byte[][])localObject2, t.f());
            paramContext.put(Long.valueOf(_status.a), paramMap.get_clone());
            t.ar.a(paramContext, "tk_file");
          }
          else
          {
            return -1009;
          }
        }
        return _status.b;
      }
      return -1014;
    }
    return -1009;
  }
  
  public byte[] a(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt, List<byte[]> paramList, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, long paramLong4, long paramLong5)
  {
    Object localObject1;
    if (paramList == null) {
      localObject1 = new ArrayList();
    } else {
      localObject1 = paramList;
    }
    paramArrayOfByte3 = new int[5];
    byte[] tmp28_26 = paramArrayOfByte3;
    tmp28_26[0] = 22;
    byte[] tmp33_28 = tmp28_26;
    tmp33_28[1] = 24;
    byte[] tmp38_33 = tmp33_28;
    tmp38_33[2] = 25;
    byte[] tmp43_38 = tmp38_33;
    tmp43_38[3] = 29;
    byte[] tmp48_43 = tmp43_38;
    tmp48_43[4] = 104;
    tmp48_43;
    Object localObject2;
    if ((d.t) && (paramArrayOfByte4.length > 16))
    {
      paramList = new byte[paramArrayOfByte4.length - 16];
      localObject2 = new byte[16];
      System.arraycopy(paramArrayOfByte4, 0, paramList, 0, paramList.length);
      System.arraycopy(paramArrayOfByte4, paramList.length, localObject2, 0, localObject2.length);
      a = (byte[])localObject2;
    }
    else
    {
      paramArrayOfByte3 = new int[0];
      paramList = null;
    }
    paramArrayOfByte4 = new tlv_t();
    paramArrayOfByte4.fill_head(104);
    paramArrayOfByte4.fill_body(t.B, t.B.length);
    paramArrayOfByte4.set_length();
    ((List)tmp43_38).add(paramArrayOfByte4.get_buf());
    paramInt = 0;
    paramArrayOfByte4 = paramArrayOfByte3;
    while (paramInt < paramArrayOfByte4.length)
    {
      localObject2 = new tlv_t();
      ((tlv_t)localObject2).fill_head(paramArrayOfByte4[paramInt]);
      i = paramArrayOfByte4[paramInt];
      if (i != 22)
      {
        if (i != 29) {
          if (i != 24) {
            if (i != 25) {
              paramArrayOfByte3 = null;
            }
          }
        }
        for (;;)
        {
          break;
          paramArrayOfByte3 = paramArrayOfByte5;
          break;
          paramArrayOfByte3 = paramList;
          continue;
          paramArrayOfByte3 = new byte[10];
          util.int8_to_buf(paramArrayOfByte3, 0, 0);
          util.int64_to_buf32(paramArrayOfByte3, 1, paramLong4);
          util.int64_to_buf32(paramArrayOfByte3, 5, paramLong5);
          util.int8_to_buf(paramArrayOfByte3, 9, 0);
        }
      }
      paramArrayOfByte3 = getAppInfo(paramLong2, paramLong3);
      if (paramArrayOfByte3 != null)
      {
        ((tlv_t)localObject2).fill_body(paramArrayOfByte3, paramArrayOfByte3.length);
        ((tlv_t)localObject2).set_length();
        ((List)tmp43_38).add(((tlv_t)localObject2).get_buf());
      }
      paramInt += 1;
    }
    int k = ((List)tmp43_38).size();
    int i = paramArrayOfByte1.length + 16 + 2 + paramArrayOfByte2.length + 1 + 2;
    paramInt = 0;
    while (paramInt < k)
    {
      int j = i;
      if (((List)tmp43_38).get(paramInt) != null) {
        j = i + ((byte[])((List)tmp43_38).get(paramInt)).length;
      }
      paramInt += 1;
      i = j;
    }
    paramArrayOfByte3 = new byte[i];
    util.int64_to_buf32(paramArrayOfByte3, 2, paramLong2);
    util.int64_to_buf(paramArrayOfByte3, 6, paramLong1);
    util.int16_to_buf(paramArrayOfByte3, 14, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, 16, paramArrayOfByte1.length);
    paramInt = 16 + paramArrayOfByte1.length;
    util.int16_to_buf(paramArrayOfByte3, paramInt, paramArrayOfByte2.length);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt, paramArrayOfByte2.length);
    paramInt += paramArrayOfByte2.length;
    util.int8_to_buf(paramArrayOfByte3, paramInt, 8);
    paramInt += 1;
    util.int16_to_buf(paramArrayOfByte3, paramInt, k);
    i = paramInt + 2;
    paramInt = 0;
    while (paramInt < k)
    {
      paramArrayOfByte1 = (byte[])((List)tmp43_38).get(paramInt);
      if (paramArrayOfByte1 != null)
      {
        System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, i, paramArrayOfByte1.length);
        i += paramArrayOfByte1.length;
      }
      paramInt += 1;
    }
    return get_request(paramLong1, true, paramArrayOfByte3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.b
 * JD-Core Version:    0.7.0.1
 */