package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class w
  extends oicq_request
{
  public w(t paramt)
  {
    this.t = 2064;
    this.u = 19;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.w;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = a(paramInt1, paramInt2, paramArrayOfLong);
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
  
  public byte[] a(int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    int[] arrayOfInt = new int[3];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 260;
    int[] tmp13_7 = tmp7_5;
    tmp13_7[1] = 8;
    int[] tmp18_13 = tmp13_7;
    tmp18_13[2] = 278;
    tmp18_13;
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfInt.length;
    async_context localasync_context = t.b(this.x.h);
    int n = 0;
    int j = 0;
    int i = 0;
    byte[] arrayOfByte;
    if (n < i1)
    {
      arrayOfByte = new byte[0];
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
        arrayOfByte = new tlv_t116().get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
      }
    }
    paramArrayOfLong = new byte[j];
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < i)
    {
      arrayOfByte = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(arrayOfByte, 0, paramArrayOfLong, paramInt2, arrayOfByte.length);
      paramInt2 += arrayOfByte.length;
      paramInt1 += 1;
    }
    return b(paramArrayOfLong, this.u, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.w
 * JD-Core Version:    0.7.0.1
 */