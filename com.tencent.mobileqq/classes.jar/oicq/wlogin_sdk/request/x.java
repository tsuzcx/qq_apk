package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.HashMap;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class x
  extends oicq_request
{
  public x(t paramt)
  {
    this.t = 2064;
    this.u = 19;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  private byte[] b(int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = 0;
    int[] arrayOfInt = new int[4];
    int[] tmp10_8 = arrayOfInt;
    tmp10_8[0] = 260;
    int[] tmp16_10 = tmp10_8;
    tmp16_10[1] = 8;
    int[] tmp21_16 = tmp16_10;
    tmp21_16[2] = 278;
    int[] tmp27_21 = tmp21_16;
    tmp27_21[3] = 1313;
    tmp27_21;
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfInt.length;
    int i = 0;
    async_context localasync_context = t.b(this.x.h);
    int n = 0;
    if (n < i1)
    {
      Object localObject = new byte[0];
      switch (arrayOfInt[n])
      {
      }
      for (;;)
      {
        int k = i;
        int m = j;
        if (localObject.length > 4)
        {
          m = j + 1;
          k = i + localObject.length;
          localArrayList.add(localObject);
        }
        n += 1;
        j = m;
        i = k;
        break;
        localObject = localasync_context._t104.get_buf();
        continue;
        localObject = new tlv_t8().get_tlv_8(0, t.u, 0);
        continue;
        localObject = new tlv_t116().get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
        continue;
        localObject = new tlv_t(1313);
        byte[] arrayOfByte = new byte[6];
        util.int32_to_buf(arrayOfByte, 0, t.ax);
        util.int16_to_buf(arrayOfByte, 4, 0);
        ((tlv_t)localObject).set_data(arrayOfByte, 6);
        localObject = ((tlv_t)localObject).get_buf();
      }
    }
    paramArrayOfLong = (tlv_t)paramWUserSigInfo._loginExtraProductTLVMap.get(Integer.valueOf(1322));
    paramInt2 = i;
    paramInt1 = j;
    if (paramArrayOfLong != null)
    {
      paramArrayOfLong = paramArrayOfLong.get_buf();
      paramInt1 = j + 1;
      paramInt2 = i + paramArrayOfLong.length;
      localArrayList.add(paramArrayOfLong);
    }
    paramArrayOfLong = new byte[paramInt2];
    i = 0;
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      paramWUserSigInfo = (byte[])localArrayList.get(paramInt2);
      System.arraycopy(paramWUserSigInfo, 0, paramArrayOfLong, i, paramWUserSigInfo.length);
      i += paramWUserSigInfo.length;
      paramInt2 += 1;
    }
    return b(paramArrayOfLong, this.u, paramInt1);
  }
  
  public int a(int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.w;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = b(paramInt1, paramInt2, paramArrayOfLong, paramWUserSigInfo);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.x
 * JD-Core Version:    0.7.0.1
 */