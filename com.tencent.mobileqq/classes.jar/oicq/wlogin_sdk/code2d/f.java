package oicq.wlogin_sdk.code2d;

import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.tools.util;

public class f
  extends c
{
  public f()
  {
    this._cmd = 19;
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = get_response(paramArrayOfByte, 0);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 11))
    {
      _status.a = util.buf_to_int64(paramArrayOfByte, 2);
      _status.b = (util.buf_to_int8(paramArrayOfByte, 10) & 0xFF);
      if (_status.b != 0)
      {
        i = util.buf_to_int16(paramArrayOfByte, 11);
        _status.f = new byte[i];
        System.arraycopy(paramArrayOfByte, 13, _status.f, 0, i);
        return _status.b;
      }
      _status.c = (util.buf_to_int32(paramArrayOfByte, 11) & 0xFFFFFFFF);
      int i = util.buf_to_int16(paramArrayOfByte, 15);
      _status.d = new byte[i];
      System.arraycopy(paramArrayOfByte, 17, _status.d, 0, i);
      i = 17 + i;
      int k = util.buf_to_int16(paramArrayOfByte, i);
      _status.g = new byte[0];
      _status.e = new ArrayList(k);
      int j = i + 2;
      i = 0;
      while (i < k)
      {
        int n = util.buf_to_int16(paramArrayOfByte, j);
        int m = util.buf_to_int16(paramArrayOfByte, j + 2);
        if (n == 13)
        {
          _status.g = new byte[m];
          System.arraycopy(paramArrayOfByte, j + 4, _status.g, 0, m);
        }
        else if (n == 26)
        {
          n = util.buf_to_int8(paramArrayOfByte, j + 4);
          boolean bool = true;
          if (n != 1) {
            bool = false;
          }
          d.t = bool;
        }
        else
        {
          n = m + 4;
          byte[] arrayOfByte = new byte[n];
          System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, n);
          _status.e.add(arrayOfByte);
        }
        j += m + 4;
        i += 1;
      }
      return _status.b;
    }
    return -1009;
  }
  
  public byte[] a(long paramLong1, long paramLong2, boolean paramBoolean, byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt, byte[] paramArrayOfByte5)
  {
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[0];
    }
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte2 = new byte[0];
    }
    if (paramArrayOfByte3 == null) {
      paramArrayOfByte3 = new byte[0];
    }
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte4 = new byte[0];
    }
    if (paramArrayOfByte5 == null) {
      paramArrayOfByte5 = new byte[0];
    }
    byte[] arrayOfByte;
    if ((paramArrayOfByte5 != null) && (paramArrayOfByte5.length > 0)) {
      arrayOfByte = new byte[paramArrayOfByte1.length + 16 + 2 + paramArrayOfByte2.length + 16 + 1 + 2 + 1 + 2 + paramArrayOfInt.length * 2 + 2 + 4 + paramArrayOfByte4.length + 4 + 4 + 4 + paramArrayOfByte5.length];
    } else {
      arrayOfByte = new byte[paramArrayOfByte1.length + 16 + 2 + paramArrayOfByte2.length + 16 + 1 + 2 + 1 + 2 + paramArrayOfInt.length * 2 + 2 + 4 + paramArrayOfByte4.length + 4 + 4];
    }
    util.int64_to_buf32(arrayOfByte, 2, paramLong2);
    util.int64_to_buf(arrayOfByte, 6, paramLong1);
    util.int16_to_buf(arrayOfByte, 14, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 16, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 16;
    util.int16_to_buf(arrayOfByte, i, paramArrayOfByte2.length);
    i += 2;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i, paramArrayOfByte2.length);
    i += paramArrayOfByte2.length;
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length == 16)) {
      System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, i, 16);
    }
    i += 16;
    util.int8_to_buf(arrayOfByte, i, 1);
    i += 1;
    util.int16_to_buf(arrayOfByte, i, paramInt);
    paramInt = i + 2;
    util.int8_to_buf(arrayOfByte, paramInt, 8);
    paramInt += 1;
    util.int16_to_buf(arrayOfByte, paramInt, paramArrayOfInt.length);
    paramInt += 2;
    i = 0;
    while (i < paramArrayOfInt.length)
    {
      util.int16_to_buf(arrayOfByte, paramInt, paramArrayOfInt[i]);
      paramInt += 2;
      i += 1;
    }
    if ((paramArrayOfByte5 != null) && (paramArrayOfByte5.length > 0)) {
      i = 2;
    } else {
      i = 1;
    }
    util.int16_to_buf(arrayOfByte, paramInt, i);
    paramInt += 2;
    util.int16_to_buf(arrayOfByte, paramInt, 9);
    paramInt += 2;
    util.int16_to_buf(arrayOfByte, paramInt, paramArrayOfByte4.length);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt, paramArrayOfByte4.length);
    i = paramInt + paramArrayOfByte4.length;
    paramInt = i;
    if (paramArrayOfByte5 != null)
    {
      paramInt = i;
      if (paramArrayOfByte5.length > 0)
      {
        util.int16_to_buf(arrayOfByte, i, 12);
        paramInt = i + 2;
        util.int16_to_buf(arrayOfByte, paramInt, paramArrayOfByte5.length);
        paramInt += 2;
        System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt, paramArrayOfByte5.length);
        paramInt += paramArrayOfByte5.length;
      }
    }
    util.int16_to_buf(arrayOfByte, paramInt, 57);
    paramInt += 2;
    util.int16_to_buf(arrayOfByte, paramInt, 4);
    util.int32_to_buf(arrayOfByte, paramInt + 2, 1);
    return get_request(paramLong1, paramBoolean, arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.f
 * JD-Core Version:    0.7.0.1
 */