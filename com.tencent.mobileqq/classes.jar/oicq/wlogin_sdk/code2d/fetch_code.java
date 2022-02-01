package oicq.wlogin_sdk.code2d;

import java.util.ArrayList;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.util;

public class fetch_code
  extends c
{
  public fetch_code()
  {
    this._cmd = 49;
  }
  
  public byte[] get_request(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, fetch_code.QRCodeCustom paramQRCodeCustom, long paramLong4, long paramLong5, byte[] paramArrayOfByte2)
  {
    int j = paramArrayOfByte1.length + 17 + 2;
    int[] arrayOfInt = new int[7];
    int[] tmp18_16 = arrayOfInt;
    tmp18_16[0] = 17;
    int[] tmp23_18 = tmp18_16;
    tmp23_18[1] = 22;
    int[] tmp28_23 = tmp23_18;
    tmp28_23[2] = 27;
    int[] tmp33_28 = tmp28_23;
    tmp33_28[3] = 29;
    int[] tmp38_33 = tmp33_28;
    tmp38_33[4] = 31;
    int[] tmp43_38 = tmp38_33;
    tmp43_38[5] = 51;
    int[] tmp48_43 = tmp43_38;
    tmp48_43[6] = 53;
    tmp48_43;
    int n = tmp33_28.length;
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    Object localObject2;
    int m;
    Object localObject1;
    int i;
    if (k < n)
    {
      tlv_t localtlv_t = new tlv_t();
      localtlv_t.fill_head(tmp33_28[k]);
      localObject2 = null;
      m = 0;
      switch (tmp33_28[k])
      {
      default: 
        localObject1 = localObject2;
        i = m;
        label184:
        if (localObject1 != null)
        {
          localtlv_t.fill_body((byte[])localObject1, i);
          localtlv_t.set_length();
          localObject1 = localtlv_t.get_buf();
          i = localObject1.length + j;
          localArrayList.add(localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      k += 1;
      j = i;
      break;
      i = m;
      localObject1 = localObject2;
      if (paramArrayOfByte2 == null) {
        break label184;
      }
      i = m;
      localObject1 = localObject2;
      if (paramArrayOfByte2.length <= 0) {
        break label184;
      }
      i = paramArrayOfByte2.length;
      util.LOGI("qrpushsig of " + paramLong2, paramLong1 + "");
      localObject1 = paramArrayOfByte2;
      break label184;
      localObject1 = getAppInfo(paramLong2, paramLong3);
      i = localObject1.length;
      break label184;
      i = 30;
      localObject1 = new byte[30];
      util.int32_to_buf((byte[])localObject1, 0, paramQRCodeCustom.Micro);
      util.int32_to_buf((byte[])localObject1, 4, paramQRCodeCustom.Version);
      util.int32_to_buf((byte[])localObject1, 8, paramQRCodeCustom.Size);
      util.int32_to_buf((byte[])localObject1, 12, paramQRCodeCustom.Margin);
      util.int32_to_buf((byte[])localObject1, 16, paramQRCodeCustom.Dpi);
      util.int32_to_buf((byte[])localObject1, 20, paramQRCodeCustom.EcLevel);
      util.int32_to_buf((byte[])localObject1, 24, paramQRCodeCustom.Hint);
      util.int16_to_buf((byte[])localObject1, 28, 0);
      break label184;
      i = 14;
      localObject1 = new byte[14];
      util.int8_to_buf((byte[])localObject1, 0, 1);
      util.int64_to_buf32((byte[])localObject1, 1, paramLong4);
      util.int64_to_buf32((byte[])localObject1, 5, paramLong5);
      util.int8_to_buf((byte[])localObject1, 9, 0);
      util.int64_to_buf32((byte[])localObject1, 10, 0L);
      break label184;
      i = t.L.length + 3 + 2 + t.K.length + 2 + 2 + t.D.length + 2 + 0 + 2 + t.G.length;
      localObject1 = new byte[i];
      util.LOGI("os " + new String(t.L) + " sim info " + new String(t.D) + " apn " + new String(t.G), "");
      util.int8_to_buf((byte[])localObject1, 0, t.ab);
      m = fill_staff((byte[])localObject1, t.L, 1);
      m = fill_staff((byte[])localObject1, t.K, m);
      util.int16_to_buf((byte[])localObject1, m, t.E);
      m = fill_staff((byte[])localObject1, t.D, m + 2);
      m = fill_staff((byte[])localObject1, new byte[0], m);
      fill_staff((byte[])localObject1, t.G, m);
      break label184;
      localObject1 = (byte[])t.B.clone();
      i = localObject1.length;
      break label184;
      i = 4;
      localObject1 = new byte[4];
      util.int32_to_buf((byte[])localObject1, 0, t.aA);
      break label184;
      paramQRCodeCustom = new byte[j];
      util.int64_to_buf32(paramQRCodeCustom, 2, paramLong2);
      util.int64_to_buf(paramQRCodeCustom, 6, paramLong1);
      util.int8_to_buf(paramQRCodeCustom, 14, 8);
      i = fill_staff(paramQRCodeCustom, paramArrayOfByte1, 15);
      k = localArrayList.size();
      util.int16_to_buf(paramQRCodeCustom, i, k);
      j = i + 2;
      i = 0;
      while (i < k)
      {
        paramArrayOfByte1 = (byte[])localArrayList.get(i);
        System.arraycopy(paramArrayOfByte1, 0, paramQRCodeCustom, j, paramArrayOfByte1.length);
        j += paramArrayOfByte1.length;
        i += 1;
      }
      return get_request(paramLong1, true, paramQRCodeCustom);
      i = j;
    }
  }
  
  public int get_response(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = get_response(paramArrayOfByte, 0);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 11)) {
      return -1009;
    }
    _status.h = util.buf_to_int32(paramArrayOfByte, 2);
    _status.b = util.buf_to_int8(paramArrayOfByte, 6);
    if (_status.b != 0)
    {
      i = util.buf_to_int16(paramArrayOfByte, 7);
      _status.f = new byte[i];
      System.arraycopy(paramArrayOfByte, 9, _status.f, 0, i);
      return _status.b;
    }
    int i = util.buf_to_int16(paramArrayOfByte, 7);
    d.i = new byte[i];
    System.arraycopy(paramArrayOfByte, 9, d.i, 0, i);
    i += 9;
    int k = util.buf_to_int16(paramArrayOfByte, i);
    i += 2;
    int j = 0;
    if (j < k)
    {
      int m = util.buf_to_int16(paramArrayOfByte, i);
      i += 2;
      int n = util.buf_to_int16(paramArrayOfByte, i);
      i += 2;
      switch (m)
      {
      }
      for (;;)
      {
        j += 1;
        break;
        _status.j = new byte[n];
        System.arraycopy(paramArrayOfByte, i, _status.j, 0, n);
        i += n;
        continue;
        _status.k = util.buf_to_int32(paramArrayOfByte, i);
        i += 4;
        _status.l = util.buf_to_int16(paramArrayOfByte, i);
        i += 2;
      }
    }
    return _status.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.fetch_code
 * JD-Core Version:    0.7.0.1
 */