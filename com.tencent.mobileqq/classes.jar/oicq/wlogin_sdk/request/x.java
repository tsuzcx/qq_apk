package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t126;
import oicq.wlogin_sdk.tlv_type.tlv_t127;
import oicq.wlogin_sdk.tlv_type.tlv_t184;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class x
  extends oicq_request
{
  public x(t paramt)
  {
    this.t = 2064;
    this.u = 18;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(String paramString, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.w;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = a(paramString.getBytes(), paramInt1, paramInt2, paramArrayOfLong);
      a(this.i, this.t, this.j, this.x.f, this.m, this.n, j, this.p, arrayOfByte);
      int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (k != 0) {
        return k;
      }
      k = b();
      util.LOGI("retry num:" + i + " ret:" + k, "" + this.x.f);
      if (k != 180) {
        return k;
      }
      if (i >= 1) {
        return k;
      }
      i += 1;
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    int i = 0;
    int[] arrayOfInt = new int[5];
    int[] tmp10_8 = arrayOfInt;
    tmp10_8[0] = 260;
    int[] tmp16_10 = tmp10_8;
    tmp16_10[1] = 8;
    int[] tmp21_16 = tmp16_10;
    tmp21_16[2] = 295;
    int[] tmp27_21 = tmp21_16;
    tmp27_21[3] = 388;
    int[] tmp33_27 = tmp27_21;
    tmp33_27[4] = 278;
    tmp33_27;
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfInt.length;
    int j = 0;
    async_context localasync_context = t.b(this.x.h);
    int n = 0;
    if (n < i1)
    {
      byte[] arrayOfByte = new byte[0];
      switch (arrayOfInt[n])
      {
      }
      for (;;)
      {
        int k = j;
        int m = i;
        if (arrayOfByte.length > 4)
        {
          m = i + 1;
          k = j + arrayOfByte.length;
          localArrayList.add(arrayOfByte);
        }
        n += 1;
        i = m;
        j = k;
        break;
        arrayOfByte = localasync_context._t104.get_buf();
        continue;
        arrayOfByte = new tlv_t8().get_tlv_8(0, t.u, 0);
        continue;
        arrayOfByte = new tlv_t127().get_tlv_127(paramArrayOfByte, localasync_context._t126.get_random());
        continue;
        arrayOfByte = new tlv_t184().get_tlv_184(localasync_context._msalt, localasync_context._mpasswd);
        continue;
        arrayOfByte = new tlv_t116().get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
      }
    }
    paramArrayOfByte = new byte[j];
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      paramArrayOfLong = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte, paramInt2, paramArrayOfLong.length);
      paramInt2 += paramArrayOfLong.length;
      paramInt1 += 1;
    }
    return b(paramArrayOfByte, this.u, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.x
 * JD-Core Version:    0.7.0.1
 */