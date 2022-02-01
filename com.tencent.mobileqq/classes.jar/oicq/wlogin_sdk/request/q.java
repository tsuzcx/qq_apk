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
    Object localObject2 = t.b(this.x.h)._t104;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new tlv_t104();
    }
    int i = 0;
    for (;;)
    {
      localObject2 = a(((tlv_t104)localObject1).get_data(), paramInt1, paramInt2, paramArrayOfLong);
      a(this.i, this.t, this.j, this.x.f, this.m, this.n, j, this.p, (byte[])localObject2);
      int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (k != 0) {
        return k;
      }
      k = b();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("retry num:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" ret:");
      ((StringBuilder)localObject2).append(k);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.x.f);
      util.LOGI((String)localObject2, localStringBuilder.toString());
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
    System.arraycopy(paramArrayOfLong, 0, localObject2, paramInt1 + paramArrayOfByte.length, paramArrayOfLong.length);
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
    String str = getClass().getName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type=");
    localStringBuilder.append(paramInt2);
    util.LOGD(str, localStringBuilder.toString());
    paramInt1 += 5;
    int i;
    if (paramInt2 != 2)
    {
      if (paramInt2 != 180)
      {
        c(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
      }
      else
      {
        i = localtlv_t161.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
        if (i < 0) {
          return i;
        }
        a(localtlv_t161);
        c(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
      }
    }
    else
    {
      i = localtlv_t104.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1);
      if (i < 0) {
        return i;
      }
      localasync_context._t104 = localtlv_t104;
      i = localtlv_t105.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1);
      if (i < 0) {
        return i;
      }
      localasync_context._t105 = localtlv_t105;
      if (localtlv_t165.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1) >= 0) {
        localasync_context._t165 = localtlv_t165;
      } else {
        localasync_context._t165 = new tlv_t165();
      }
      paramInt1 = localtlv_t546.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1);
      if (paramInt1 >= 0)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("flush get tlv546 success len:");
        paramArrayOfByte.append(localtlv_t546.get_data_len());
        util.LOGI(paramArrayOfByte.toString(), "");
        localasync_context._t546 = localtlv_t546;
      }
      else
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("flush get tlv546 fail ret:");
        paramArrayOfByte.append(paramInt1);
        util.LOGI(paramArrayOfByte.toString(), "");
        localasync_context._t546 = new tlv_t546();
      }
      b.a(localtlv_t546.get_data());
      a((ErrMsg)null);
    }
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.q
 * JD-Core Version:    0.7.0.1
 */