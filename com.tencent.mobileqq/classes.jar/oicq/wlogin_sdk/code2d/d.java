package oicq.wlogin_sdk.code2d;

import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.request.oicq_request;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tools.util;

public class d
  extends b
{
  public d()
  {
    this._cmd = 18;
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte3 = null;
    byte[] arrayOfByte4 = get_response(paramArrayOfByte, 0);
    if ((arrayOfByte4 == null) || (arrayOfByte4.length < 8)) {
      return -1009;
    }
    paramArrayOfByte = a(arrayOfByte4, 0);
    _status.a = paramArrayOfByte.b;
    _status.h = paramArrayOfByte.c;
    _status.b = paramArrayOfByte.d;
    int i = paramArrayOfByte.a + 0;
    if (_status.b != 0) {
      return _status.b;
    }
    _status.a = util.buf_to_int64(arrayOfByte4, i);
    i += 8;
    _status.c = util.buf_to_int32(arrayOfByte4, i);
    i += 4;
    _status.e = new ArrayList();
    int k = util.buf_to_int16(arrayOfByte4, i);
    i += 2;
    int j = 0;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1 = null;
    paramArrayOfByte = null;
    if (j < k)
    {
      int m = util.buf_to_int16(arrayOfByte4, i);
      int n = i + 2;
      i = util.buf_to_int16(arrayOfByte4, n);
      n += 2;
      switch (m)
      {
      default: 
        byte[] arrayOfByte5 = new byte[i + 4];
        System.arraycopy(arrayOfByte4, n - 4, arrayOfByte5, 0, arrayOfByte5.length);
        _status.e.add(arrayOfByte5);
        i = n + i;
      }
      for (;;)
      {
        j += 1;
        break;
        paramArrayOfByte = new byte[i];
        System.arraycopy(arrayOfByte4, n, paramArrayOfByte, 0, i);
        i = n + i;
        continue;
        arrayOfByte2 = new byte[i];
        System.arraycopy(arrayOfByte4, n, arrayOfByte2, 0, i);
        i = n + i;
        continue;
        arrayOfByte1 = new byte[i];
        System.arraycopy(arrayOfByte4, n, arrayOfByte1, 0, i);
        i = n + i;
        continue;
        arrayOfByte3 = new byte[i];
        System.arraycopy(arrayOfByte4, n, arrayOfByte3, 0, i);
        i = n + i;
        util.LOGI("get tgtQR len " + arrayOfByte3.length, "" + _status.a);
      }
    }
    if ((paramArrayOfByte == null) || (arrayOfByte1 == null) || (arrayOfByte2 == null)) {
      return -1009;
    }
    c.q = oicq_request.b(paramArrayOfByte, arrayOfByte1);
    c.r = arrayOfByte2;
    c.s = arrayOfByte3;
    return _status.b;
  }
  
  protected a a(byte[] paramArrayOfByte, int paramInt)
  {
    a locala = new a();
    int i = util.buf_to_int16(paramArrayOfByte, paramInt);
    int j = paramInt + 2;
    paramInt = 0;
    if (i != 0) {
      paramInt = util.buf_to_int8(paramArrayOfByte, j);
    }
    if (2 == paramInt) {
      locala.b = util.buf_to_int64(paramArrayOfByte, j + 1);
    }
    paramInt = j + i;
    locala.c = util.buf_to_int32(paramArrayOfByte, paramInt);
    locala.d = util.buf_to_int8(paramArrayOfByte, paramInt + 4);
    locala.a = (i + 2 + 4 + 1);
    return locala;
  }
  
  public byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + 13 + (paramArrayOfByte2.length + 11 + 2)];
    util.int16_to_buf(arrayOfByte, 0, 5);
    util.int8_to_buf(arrayOfByte, 2, 1);
    util.int32_to_buf(arrayOfByte, 3, t.au);
    util.int64_to_buf32(arrayOfByte, 7, paramLong2);
    int i = fill_staff(arrayOfByte, paramArrayOfByte1, 11);
    util.int64_to_buf(arrayOfByte, i, paramLong1);
    i += 8;
    util.int8_to_buf(arrayOfByte, i, 8);
    fill_staff(arrayOfByte, paramArrayOfByte2, i + 1);
    return get_request(paramLong1, true, arrayOfByte);
  }
  
  class a
  {
    int a;
    long b;
    long c;
    int d;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.d
 * JD-Core Version:    0.7.0.1
 */