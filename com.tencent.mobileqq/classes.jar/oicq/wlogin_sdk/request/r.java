package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t161;
import oicq.wlogin_sdk.tlv_type.tlv_t174;
import oicq.wlogin_sdk.tlv_type.tlv_t17a;
import oicq.wlogin_sdk.tlv_type.tlv_t17b;
import oicq.wlogin_sdk.tlv_type.tlv_t542;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class r
  extends oicq_request
{
  static int K = 0;
  
  public r(t paramt)
  {
    this.t = 2064;
    this.u = 8;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    int j = t.x;
    Object localObject = t.b(this.x.h);
    tlv_t104 localtlv_t104 = ((async_context)localObject)._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    for (;;)
    {
      localObject = ((async_context)localObject)._t174;
      if (localObject == null) {
        localObject = new tlv_t174();
      }
      for (;;)
      {
        int i = 0;
        for (;;)
        {
          byte[] arrayOfByte = a(localtlv_t104.get_data(), paramLong, ((tlv_t174)localObject).get_data(), paramInt1, paramInt2, paramArrayOfLong, paramArrayOfByte);
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
  }
  
  public byte[] a(byte[] paramArrayOfByte1, long paramLong, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, long[] paramArrayOfLong, byte[] paramArrayOfByte3)
  {
    Object localObject1 = new tlv_t8();
    tlv_t104 localtlv_t104 = new tlv_t104();
    tlv_t116 localtlv_t116 = new tlv_t116();
    tlv_t174 localtlv_t174 = new tlv_t174();
    Object localObject4 = new tlv_t17a();
    Object localObject2 = new tlv_t(407);
    Object localObject3 = new tlv_t542();
    localObject1 = ((tlv_t8)localObject1).get_tlv_8(0, t.v, 0);
    paramArrayOfByte1 = localtlv_t104.get_tlv_104(paramArrayOfByte1);
    paramArrayOfLong = localtlv_t116.get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
    paramArrayOfByte2 = localtlv_t174.get_tlv_174(paramArrayOfByte2);
    localObject4 = ((tlv_t17a)localObject4).get_tlv_17a(paramLong);
    paramArrayOfByte3 = ((tlv_t542)localObject3).get_tlv_542(paramArrayOfByte3);
    ((tlv_t)localObject2).set_data(new byte[] { (byte)K }, 1);
    localObject2 = ((tlv_t)localObject2).get_buf();
    localObject3 = new byte[localObject1.length + paramArrayOfByte1.length + paramArrayOfLong.length + paramArrayOfByte2.length + localObject4.length + localObject2.length + paramArrayOfByte3.length];
    System.arraycopy(localObject1, 0, localObject3, 0, localObject1.length);
    paramInt1 = localObject1.length + 0;
    System.arraycopy(paramArrayOfByte1, 0, localObject3, paramInt1, paramArrayOfByte1.length);
    paramInt1 += paramArrayOfByte1.length;
    System.arraycopy(paramArrayOfLong, 0, localObject3, paramInt1, paramArrayOfLong.length);
    paramInt1 += paramArrayOfLong.length;
    System.arraycopy(paramArrayOfByte2, 0, localObject3, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    System.arraycopy(localObject4, 0, localObject3, paramInt1, localObject4.length);
    paramInt1 += localObject4.length;
    System.arraycopy(localObject2, 0, localObject3, paramInt1, localObject2.length);
    System.arraycopy(paramArrayOfByte3, 0, localObject3, paramInt1 + localObject2.length, paramArrayOfByte3.length);
    return b((byte[])localObject3, this.u, 7);
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    tlv_t104 localtlv_t104 = new tlv_t104();
    tlv_t17b localtlv_t17b = new tlv_t17b();
    tlv_t161 localtlv_t161 = new tlv_t161();
    tlv_t543 localtlv_t543 = new tlv_t543();
    async_context localasync_context = t.b(this.x.h);
    paramInt2 = c(paramArrayOfByte, paramInt1 + 2);
    util.LOGD(getClass().getName(), "type=" + paramInt2);
    int j = paramInt1 + 5;
    paramInt1 = localtlv_t543.get_tlv(paramArrayOfByte, j, this.c - j);
    localasync_context._t543 = localtlv_t543;
    util.LOGI("flushsms tlv 543 ret:" + paramInt1, "");
    switch (paramInt2)
    {
    default: 
      c(paramArrayOfByte, j, this.c - j - 1);
      paramInt1 = paramInt2;
    }
    int i;
    do
    {
      do
      {
        do
        {
          return paramInt1;
          i = localtlv_t104.get_tlv(paramArrayOfByte, j, this.c - j);
          paramInt1 = i;
        } while (i < 0);
        localasync_context._t104 = localtlv_t104;
        i = localtlv_t17b.get_tlv(paramArrayOfByte, j, this.c - j);
        paramInt1 = i;
      } while (i < 0);
      localasync_context._t17b = localtlv_t17b;
      a((ErrMsg)null);
      return paramInt2;
      i = localtlv_t161.get_tlv(paramArrayOfByte, j, this.c - j - 1);
      paramInt1 = i;
    } while (i < 0);
    a(localtlv_t161);
    c(paramArrayOfByte, j, this.c - j - 1);
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.r
 * JD-Core Version:    0.7.0.1
 */