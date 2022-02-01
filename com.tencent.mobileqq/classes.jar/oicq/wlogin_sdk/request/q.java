package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.pow.b;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t161;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t546;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class q
  extends oicq_request
{
  public q(t paramt)
  {
    this.t = 2064;
    this.u = 3;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.x;
    tlv_t104 localtlv_t104 = t.b(this.x.h)._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    for (;;)
    {
      int i = 0;
      for (;;)
      {
        byte[] arrayOfByte = a(localtlv_t104.get_data(), paramInt1, paramInt2, paramArrayOfLong);
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
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    Object localObject1 = new tlv_t8();
    tlv_t104 localtlv_t104 = new tlv_t104();
    Object localObject2 = new tlv_t116();
    localObject1 = ((tlv_t8)localObject1).get_tlv_8(0, t.v, 0);
    paramArrayOfByte = localtlv_t104.get_tlv_104(paramArrayOfByte);
    paramArrayOfLong = ((tlv_t116)localObject2).get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
    localObject2 = new byte[localObject1.length + paramArrayOfByte.length + paramArrayOfLong.length];
    System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
    paramInt1 = localObject1.length + 0;
    System.arraycopy(paramArrayOfByte, 0, localObject2, paramInt1, paramArrayOfByte.length);
    paramInt1 += paramArrayOfByte.length;
    System.arraycopy(paramArrayOfLong, 0, localObject2, paramInt1, paramArrayOfLong.length);
    paramInt1 = paramArrayOfLong.length;
    return b((byte[])localObject2, this.u, 3);
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    tlv_t104 localtlv_t104 = new tlv_t104();
    tlv_t105 localtlv_t105 = new tlv_t105();
    tlv_t165 localtlv_t165 = new tlv_t165();
    tlv_t161 localtlv_t161 = new tlv_t161();
    tlv_t546 localtlv_t546 = new tlv_t546();
    async_context localasync_context = t.b(this.x.h);
    paramInt2 = c(paramArrayOfByte, paramInt1 + 2);
    util.LOGD(getClass().getName(), "type=" + paramInt2);
    int j = paramInt1 + 5;
    switch (paramInt2)
    {
    default: 
      c(paramArrayOfByte, j, this.c - j - 1);
      paramInt1 = paramInt2;
    }
    int i;
    label325:
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
        i = localtlv_t105.get_tlv(paramArrayOfByte, j, this.c - j);
        paramInt1 = i;
      } while (i < 0);
      localasync_context._t105 = localtlv_t105;
      if (localtlv_t165.get_tlv(paramArrayOfByte, j, this.c - j) >= 0)
      {
        localasync_context._t165 = localtlv_t165;
        paramInt1 = localtlv_t546.get_tlv(paramArrayOfByte, j, this.c - j);
        if (paramInt1 < 0) {
          break label325;
        }
        util.LOGI("flush get tlv546 success len:" + localtlv_t546.get_data_len(), "");
      }
      for (localasync_context._t546 = localtlv_t546;; localasync_context._t546 = new tlv_t546())
      {
        b.a(localtlv_t546.get_data());
        a((ErrMsg)null);
        return paramInt2;
        localasync_context._t165 = new tlv_t165();
        break;
        util.LOGI("flush get tlv546 fail ret:" + paramInt1, "");
      }
      i = localtlv_t161.get_tlv(paramArrayOfByte, j, this.c - j - 1);
      paramInt1 = i;
    } while (i < 0);
    a(localtlv_t161);
    c(paramArrayOfByte, j, this.c - j - 1);
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.q
 * JD-Core Version:    0.7.0.1
 */