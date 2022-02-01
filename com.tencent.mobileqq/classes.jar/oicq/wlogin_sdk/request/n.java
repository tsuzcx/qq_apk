package oicq.wlogin_sdk.request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t193;
import oicq.wlogin_sdk.tlv_type.tlv_t2;
import oicq.wlogin_sdk.tlv_type.tlv_t547;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class n
  extends oicq_request
{
  public static boolean K = false;
  
  public n(t paramt)
  {
    this.t = 2064;
    this.u = 2;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.x;
    Object localObject3 = t.b(this.x.h);
    Object localObject2 = ((async_context)localObject3)._t104;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new tlv_t104();
    }
    localObject2 = localObject1;
    localObject3 = ((async_context)localObject3)._t105;
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = new tlv_t105();
    }
    localObject3 = t.an;
    int k;
    for (int i = 0;; i = k)
    {
      Object localObject4 = a(((tlv_t104)localObject2).get_data(), paramArrayOfByte, ((tlv_t105)localObject1).get_sign(), paramInt1, paramInt2, paramArrayOfLong, (byte[])localObject3, paramWUserSigInfo);
      a(this.i, this.t, this.j, this.x.f, this.m, this.n, j, this.p, (byte[])localObject4);
      k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (k != 0) {
        return k;
      }
      int m = b();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("retry num:");
      ((StringBuilder)localObject4).append(i);
      ((StringBuilder)localObject4).append(" ret:");
      ((StringBuilder)localObject4).append(m);
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.x.f);
      util.LOGI((String)localObject4, localStringBuilder.toString());
      if (m != 180) {
        return m;
      }
      k = i + 1;
      if (i >= 1) {
        return m;
      }
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, long[] paramArrayOfLong, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject3 = new tlv_t2();
    Object localObject1 = new tlv_t8();
    Object localObject2 = new tlv_t104();
    tlv_t116 localtlv_t116 = new tlv_t116();
    Object localObject4 = new tlv_t193();
    tlv_t547 localtlv_t547 = new tlv_t547();
    localObject1 = ((tlv_t8)localObject1).get_tlv_8(0, t.v, 0);
    localObject2 = ((tlv_t104)localObject2).get_tlv_104(paramArrayOfByte1);
    paramArrayOfLong = localtlv_t116.get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
    paramArrayOfByte4 = localtlv_t547.get_tlv_547(paramArrayOfByte4);
    if (K) {
      paramArrayOfByte1 = ((tlv_t193)localObject4).get_tlv_193(paramArrayOfByte2);
    } else {
      paramArrayOfByte1 = ((tlv_t2)localObject3).get_tlv_2(paramArrayOfByte2, paramArrayOfByte3);
    }
    paramInt1 = paramArrayOfByte1.length + localObject1.length + localObject2.length + paramArrayOfLong.length + paramArrayOfByte4.length;
    paramArrayOfByte2 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
    while (paramArrayOfByte2.hasNext())
    {
      paramArrayOfByte3 = (Integer)paramArrayOfByte2.next();
      localObject3 = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte3)).get_buf();
      paramInt1 += localObject3.length;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("Extra Tlv key：0x");
      ((StringBuilder)localObject4).append(paramArrayOfByte3);
      ((StringBuilder)localObject4).append(" len:");
      ((StringBuilder)localObject4).append(localObject3.length);
      util.LOGI(((StringBuilder)localObject4).toString(), "");
    }
    paramArrayOfByte2 = new byte[paramInt1];
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
    paramInt1 = paramArrayOfByte1.length + 0;
    System.arraycopy(localObject1, 0, paramArrayOfByte2, paramInt1, localObject1.length);
    paramInt1 += localObject1.length;
    System.arraycopy(localObject2, 0, paramArrayOfByte2, paramInt1, localObject2.length);
    paramInt1 += localObject2.length;
    System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte2, paramInt1, paramArrayOfLong.length);
    paramInt1 += paramArrayOfLong.length;
    System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte2, paramInt1, paramArrayOfByte4.length);
    paramInt2 = paramInt1 + paramArrayOfByte4.length;
    paramInt1 = 5;
    paramArrayOfByte1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
    while (paramArrayOfByte1.hasNext())
    {
      paramArrayOfByte3 = (Integer)paramArrayOfByte1.next();
      paramArrayOfLong = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte3)).get_buf();
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte2, paramInt2, paramArrayOfLong.length);
      paramInt2 += paramArrayOfLong.length;
      paramInt1 += 1;
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append("Extra Tlv from user：0x");
      paramArrayOfLong.append(paramArrayOfByte3);
      util.LOGI(paramArrayOfLong.toString());
    }
    return b(paramArrayOfByte2, this.u, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.n
 * JD-Core Version:    0.7.0.1
 */