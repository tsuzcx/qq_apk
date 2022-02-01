package oicq.wlogin_sdk.request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t107;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t112;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t124;
import oicq.wlogin_sdk.tlv_type.tlv_t128;
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t191;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t548;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class s
  extends oicq_request
{
  public s(t paramt)
  {
    this.t = 2064;
    this.u = 4;
    this.v = "wtlogin.name2uin";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int i = t.x;
    this.x.g = new String(paramArrayOfByte);
    paramInt1 = 0;
    for (;;)
    {
      Object localObject = a(paramLong1, paramLong2, i, paramInt2, paramArrayOfByte, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfLong, t.ad, t.B, paramWUserSigInfo);
      a(this.i, this.t, this.j, 0L, this.m, this.n, i, this.p, (byte[])localObject);
      localObject = String.valueOf(this.x.f);
      int j = a((String)localObject, false, paramWUserSigInfo);
      if (j != 0) {
        return j;
      }
      j = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retry num:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" ret:");
      localStringBuilder.append(j);
      localStringBuilder.append(" uin: ");
      localStringBuilder.append((String)localObject);
      util.LOGI(localStringBuilder.toString(), this.x.g);
      if (j != 180) {
        return j;
      }
      if (paramInt1 >= 1) {
        return j;
      }
      paramInt1 += 1;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long[] paramArrayOfLong, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject1 = new tlv_t100();
    Object localObject2 = new tlv_t112();
    Object localObject3 = new tlv_t107();
    Object localObject4 = new tlv_t108();
    Object localObject11 = new tlv_t124();
    Object localObject12 = new tlv_t128();
    paramArrayOfByte3 = new tlv_t52d();
    Object localObject5 = new tlv_t116();
    Object localObject6 = new tlv_t154();
    Object localObject7 = new tlv_t8();
    tlv_t localtlv_t = new tlv_t(283);
    Object localObject8 = new tlv_t(1313);
    Object localObject10 = new tlv_t548();
    Object localObject9 = new tlv_t191();
    localObject1 = ((tlv_t100)localObject1).get_tlv_100(paramLong1, paramLong2, paramInt1, paramInt2);
    localObject2 = ((tlv_t112)localObject2).get_tlv_112(paramArrayOfByte1);
    localObject3 = ((tlv_t107)localObject3).get_tlv_107(paramInt3, paramInt4, paramInt5, paramInt6);
    localObject4 = ((tlv_t108)localObject4).get_tlv_108(paramArrayOfByte2);
    localObject5 = ((tlv_t116)localObject5).get_tlv_116(paramInt7, paramInt8, paramArrayOfLong);
    localObject6 = ((tlv_t154)localObject6).get_tlv_154(this.x.i);
    localObject7 = ((tlv_t8)localObject7).get_tlv_8(0, t.v, 0);
    localObject9 = ((tlv_t191)localObject9).get_tlv_191(k.K);
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("request_getuin canWebVerify");
    paramArrayOfByte1.append(k.K);
    util.LOGI(paramArrayOfByte1.toString(), "");
    localtlv_t.set_data(new byte[] { 2 }, 1);
    paramArrayOfByte1 = util.get_os_type();
    paramArrayOfLong = util.get_os_version();
    paramInt1 = t.E;
    byte[] arrayOfByte = t.D;
    Object localObject13 = t.G;
    localObject11 = ((tlv_t124)localObject11).get_tlv_124(paramArrayOfByte1, paramArrayOfLong, paramInt1, arrayOfByte, new byte[0], (byte[])localObject13);
    localObject12 = ((tlv_t128)localObject12).get_tlv_128(t.V, t.W, t.X, t.aa, t.J, t.B, t.Q);
    paramArrayOfLong = paramArrayOfByte3.get_tlv_52d(this.a);
    paramArrayOfByte3 = new byte[0];
    paramArrayOfByte1 = paramArrayOfByte3;
    if (t.ao != null)
    {
      paramArrayOfByte1 = paramArrayOfByte3;
      if (t.ao.length > 0)
      {
        paramArrayOfByte1 = ((tlv_t548)localObject10).get_tlv_548(t.ao);
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("t548 len:");
        if (paramArrayOfByte1 == null) {
          paramInt1 = 0;
        } else {
          paramInt1 = paramArrayOfByte1.length;
        }
        paramArrayOfByte3.append(paramInt1);
        util.LOGI(paramArrayOfByte3.toString(), "");
      }
    }
    paramArrayOfByte3 = new byte[6];
    util.int32_to_buf(paramArrayOfByte3, 0, t.aA);
    util.int16_to_buf(paramArrayOfByte3, 4, 0);
    ((tlv_t)localObject8).set_data(paramArrayOfByte3, 6);
    localObject8 = ((tlv_t)localObject8).get_buf();
    paramInt2 = localObject1.length + localObject2.length + localObject3.length + localObject4.length + localObject11.length + localObject12.length + localObject8.length + localObject5.length + localObject6.length + localObject7.length + localObject9.length + localtlv_t.get_buf().length;
    paramInt1 = paramInt2;
    if (paramArrayOfLong != null)
    {
      paramInt1 = paramInt2;
      if (paramArrayOfLong.length > 0) {
        paramInt1 = paramInt2 + paramArrayOfLong.length;
      }
    }
    paramInt2 = paramInt1;
    if (paramArrayOfByte1 != null)
    {
      paramInt2 = paramInt1;
      if (paramArrayOfByte1.length > 0) {
        paramInt2 = paramInt1 + paramArrayOfByte1.length;
      }
    }
    paramArrayOfByte3 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
    paramInt1 = paramInt2;
    while (paramArrayOfByte3.hasNext())
    {
      localObject10 = (Integer)paramArrayOfByte3.next();
      arrayOfByte = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(localObject10)).get_buf();
      paramInt2 = arrayOfByte.length;
      localObject13 = new StringBuilder();
      ((StringBuilder)localObject13).append("add length Tlv from user：0x");
      ((StringBuilder)localObject13).append(localObject10);
      ((StringBuilder)localObject13).append(" body_len:");
      ((StringBuilder)localObject13).append(arrayOfByte.length);
      util.LOGI(((StringBuilder)localObject13).toString(), "");
      paramInt1 += paramInt2;
    }
    paramInt5 = paramInt1 + 1024;
    paramArrayOfByte3 = new byte[paramInt5];
    System.arraycopy(localObject1, 0, paramArrayOfByte3, 0, localObject1.length);
    paramInt1 = localObject1.length + 0;
    System.arraycopy(localObject2, 0, paramArrayOfByte3, paramInt1, localObject2.length);
    paramInt1 += localObject2.length;
    System.arraycopy(localObject3, 0, paramArrayOfByte3, paramInt1, localObject3.length);
    paramInt1 += localObject3.length;
    System.arraycopy(localObject6, 0, paramArrayOfByte3, paramInt1, localObject6.length);
    paramInt1 += localObject6.length;
    System.arraycopy(localObject7, 0, paramArrayOfByte3, paramInt1, localObject7.length);
    paramInt3 = paramInt1 + localObject7.length;
    paramInt4 = 5;
    paramInt2 = paramInt3;
    paramInt1 = paramInt4;
    if (paramArrayOfByte2 != null)
    {
      paramInt2 = paramInt3;
      paramInt1 = paramInt4;
      if (paramArrayOfByte2.length > 0)
      {
        System.arraycopy(localObject4, 0, paramArrayOfByte3, paramInt3, localObject4.length);
        paramInt2 = paramInt3 + localObject4.length;
        paramInt1 = 6;
      }
    }
    System.arraycopy(localObject8, 0, paramArrayOfByte3, paramInt2, localObject8.length);
    paramInt2 += localObject8.length;
    System.arraycopy(localObject11, 0, paramArrayOfByte3, paramInt2, localObject11.length);
    paramInt2 += localObject11.length;
    System.arraycopy(localObject12, 0, paramArrayOfByte3, paramInt2, localObject12.length);
    paramInt2 += localObject12.length;
    System.arraycopy(localObject5, 0, paramArrayOfByte3, paramInt2, localObject5.length);
    paramInt2 += localObject5.length;
    System.arraycopy(localObject9, 0, paramArrayOfByte3, paramInt2, localObject9.length);
    paramInt2 += localObject9.length;
    System.arraycopy(localtlv_t.get_buf(), 0, paramArrayOfByte3, paramInt2, localtlv_t.get_buf().length);
    paramInt3 = paramInt2 + localtlv_t.get_buf().length;
    paramInt4 = paramInt1 + 1 + 3 + 1 + 1;
    paramInt2 = paramInt3;
    paramInt1 = paramInt4;
    if (paramArrayOfLong != null)
    {
      paramInt2 = paramInt3;
      paramInt1 = paramInt4;
      if (paramArrayOfLong.length > 0)
      {
        System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte3, paramInt3, paramArrayOfLong.length);
        paramInt2 = paramInt3 + paramArrayOfLong.length;
        paramInt1 = paramInt4 + 1;
      }
    }
    paramInt3 = paramInt2;
    paramInt4 = paramInt1;
    if (paramArrayOfByte1 != null)
    {
      paramInt3 = paramInt2;
      paramInt4 = paramInt1;
      if (paramArrayOfByte1.length > 0)
      {
        System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, paramInt2, paramArrayOfByte1.length);
        paramInt3 = paramInt2 + paramArrayOfByte1.length;
        paramInt4 = paramInt1 + 1;
      }
    }
    paramArrayOfByte1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
    while (paramArrayOfByte1.hasNext())
    {
      paramArrayOfLong = (Integer)paramArrayOfByte1.next();
      paramArrayOfByte2 = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfLong)).get_buf();
      if (paramInt3 <= paramInt5 - paramArrayOfByte2.length)
      {
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt3, paramArrayOfByte2.length);
        paramInt3 += paramArrayOfByte2.length;
        paramInt4 += 1;
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("Extra Tlv from user：0x");
        paramArrayOfByte2.append(paramArrayOfLong);
        util.LOGI(paramArrayOfByte2.toString());
      }
    }
    paramArrayOfByte1 = new byte[paramInt3];
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramInt3);
    return b(paramArrayOfByte1, this.u, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.s
 * JD-Core Version:    0.7.0.1
 */