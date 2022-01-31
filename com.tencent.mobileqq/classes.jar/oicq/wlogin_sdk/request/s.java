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
    int i = t.w;
    this.x.g = new String(paramArrayOfByte);
    paramInt1 = 0;
    for (;;)
    {
      Object localObject = a(paramLong1, paramLong2, i, paramInt2, paramArrayOfByte, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfLong, t.ac, t.A, paramWUserSigInfo);
      a(this.i, this.t, this.j, 0L, this.m, this.n, i, this.p, (byte[])localObject);
      localObject = String.valueOf(this.x.f);
      int j = a((String)localObject, false, paramWUserSigInfo);
      if (j != 0) {
        return j;
      }
      j = b();
      util.LOGI("retry num:" + paramInt1 + " ret:" + j + " uin: " + (String)localObject, this.x.g);
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
    Object localObject3 = new tlv_t112();
    Object localObject4 = new tlv_t107();
    Object localObject5 = new tlv_t108();
    Object localObject12 = new tlv_t124();
    Object localObject10 = new tlv_t128();
    Object localObject8 = new tlv_t52d();
    Object localObject6 = new tlv_t116();
    Object localObject7 = new tlv_t154();
    Object localObject9 = new tlv_t8();
    paramArrayOfByte3 = new tlv_t(283);
    Object localObject2 = new tlv_t(1313);
    tlv_t548 localtlv_t548 = new tlv_t548();
    Object localObject11 = new tlv_t191();
    localObject1 = ((tlv_t100)localObject1).get_tlv_100(paramLong1, paramLong2, paramInt1, paramInt2);
    localObject3 = ((tlv_t112)localObject3).get_tlv_112(paramArrayOfByte1);
    localObject4 = ((tlv_t107)localObject4).get_tlv_107(paramInt3, paramInt4, paramInt5, paramInt6);
    localObject5 = ((tlv_t108)localObject5).get_tlv_108(paramArrayOfByte2);
    localObject6 = ((tlv_t116)localObject6).get_tlv_116(paramInt7, paramInt8, paramArrayOfLong);
    localObject7 = ((tlv_t154)localObject7).get_tlv_154(this.x.i);
    localObject9 = ((tlv_t8)localObject9).get_tlv_8(0, t.u, 0);
    localObject11 = ((tlv_t191)localObject11).get_tlv_191(k.K);
    paramArrayOfByte3.set_data(new byte[] { 2 }, 1);
    paramArrayOfByte1 = util.get_os_type();
    paramArrayOfLong = util.get_os_version();
    paramInt1 = t.D;
    byte[] arrayOfByte1 = t.C;
    byte[] arrayOfByte2 = t.F;
    localObject12 = ((tlv_t124)localObject12).get_tlv_124(paramArrayOfByte1, paramArrayOfLong, paramInt1, arrayOfByte1, new byte[0], arrayOfByte2);
    localObject10 = ((tlv_t128)localObject10).get_tlv_128(t.U, t.V, t.W, t.Z, t.I, t.A, t.P);
    localObject8 = ((tlv_t52d)localObject8).get_tlv_52d(this.a);
    paramArrayOfLong = new byte[0];
    paramArrayOfByte1 = paramArrayOfLong;
    if (t.an != null)
    {
      paramArrayOfByte1 = paramArrayOfLong;
      if (t.an.length > 0)
      {
        paramArrayOfByte1 = localtlv_t548.get_tlv_548(t.an);
        paramArrayOfLong = new StringBuilder().append("t548 len:");
        if (paramArrayOfByte1 != null) {
          break label1100;
        }
        paramInt1 = 0;
        util.LOGI(paramInt1, "");
      }
    }
    paramArrayOfLong = new byte[6];
    util.int32_to_buf(paramArrayOfLong, 0, t.az);
    util.int16_to_buf(paramArrayOfLong, 4, 0);
    ((tlv_t)localObject2).set_data(paramArrayOfLong, 6);
    localObject2 = ((tlv_t)localObject2).get_buf();
    paramInt2 = localObject1.length + localObject3.length + localObject4.length + localObject5.length + localObject12.length + localObject10.length + localObject2.length + localObject6.length + localObject7.length + localObject9.length + localObject11.length + paramArrayOfByte3.get_buf().length;
    paramInt1 = paramInt2;
    if (localObject8 != null)
    {
      paramInt1 = paramInt2;
      if (localObject8.length > 0) {
        paramInt1 = paramInt2 + localObject8.length;
      }
    }
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0)) {}
    for (paramInt3 = paramInt1 + paramArrayOfByte1.length;; paramInt3 = paramInt1)
    {
      paramArrayOfLong = new byte[paramInt3 + 1024];
      System.arraycopy(localObject1, 0, paramArrayOfLong, 0, localObject1.length);
      paramInt1 = 0 + localObject1.length;
      System.arraycopy(localObject3, 0, paramArrayOfLong, paramInt1, localObject3.length);
      paramInt1 += localObject3.length;
      System.arraycopy(localObject4, 0, paramArrayOfLong, paramInt1, localObject4.length);
      paramInt1 += localObject4.length;
      System.arraycopy(localObject7, 0, paramArrayOfLong, paramInt1, localObject7.length);
      paramInt1 += localObject7.length;
      System.arraycopy(localObject9, 0, paramArrayOfLong, paramInt1, localObject9.length);
      paramInt4 = paramInt1 + localObject9.length;
      paramInt5 = 5;
      paramInt2 = paramInt4;
      paramInt1 = paramInt5;
      if (paramArrayOfByte2 != null)
      {
        paramInt2 = paramInt4;
        paramInt1 = paramInt5;
        if (paramArrayOfByte2.length > 0)
        {
          System.arraycopy(localObject5, 0, paramArrayOfLong, paramInt4, localObject5.length);
          paramInt2 = paramInt4 + localObject5.length;
          paramInt1 = 6;
        }
      }
      System.arraycopy(localObject2, 0, paramArrayOfLong, paramInt2, localObject2.length);
      paramInt2 += localObject2.length;
      System.arraycopy(localObject12, 0, paramArrayOfLong, paramInt2, localObject12.length);
      paramInt2 += localObject12.length;
      System.arraycopy(localObject10, 0, paramArrayOfLong, paramInt2, localObject10.length);
      paramInt2 += localObject10.length;
      System.arraycopy(localObject6, 0, paramArrayOfLong, paramInt2, localObject6.length);
      paramInt2 += localObject6.length;
      System.arraycopy(localObject11, 0, paramArrayOfLong, paramInt2, localObject11.length);
      paramInt2 += localObject11.length;
      System.arraycopy(paramArrayOfByte3.get_buf(), 0, paramArrayOfLong, paramInt2, paramArrayOfByte3.get_buf().length);
      paramInt4 = paramInt2 + paramArrayOfByte3.get_buf().length;
      paramInt5 = paramInt1 + 1 + 3 + 1 + 1;
      paramInt2 = paramInt4;
      paramInt1 = paramInt5;
      if (localObject8 != null)
      {
        paramInt2 = paramInt4;
        paramInt1 = paramInt5;
        if (localObject8.length > 0)
        {
          System.arraycopy(localObject8, 0, paramArrayOfLong, paramInt4, localObject8.length);
          paramInt2 = paramInt4 + localObject8.length;
          paramInt1 = paramInt5 + 1;
        }
      }
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
      {
        System.arraycopy(paramArrayOfByte1, 0, paramArrayOfLong, paramInt2, paramArrayOfByte1.length);
        paramInt2 = paramArrayOfByte1.length + paramInt2;
        paramInt1 += 1;
      }
      for (;;)
      {
        paramArrayOfByte1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
        paramInt4 = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = paramInt4;
        label967:
        if (paramArrayOfByte1.hasNext())
        {
          paramArrayOfByte2 = (Integer)paramArrayOfByte1.next();
          paramArrayOfByte3 = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte2)).get_buf();
          if (paramInt1 > paramInt3 + 1024 - paramArrayOfByte3.length) {
            break label1138;
          }
          System.arraycopy(paramArrayOfByte3, 0, paramArrayOfLong, paramInt1, paramArrayOfByte3.length);
          paramInt4 = paramArrayOfByte3.length;
          paramInt2 += 1;
          util.LOGI("Extra Tlv from user：0x" + paramArrayOfByte2);
          paramInt4 = paramInt1 + paramInt4;
          paramInt1 = paramInt2;
          paramInt2 = paramInt4;
        }
        for (;;)
        {
          paramInt4 = paramInt1;
          paramInt1 = paramInt2;
          paramInt2 = paramInt4;
          break label967;
          label1100:
          paramInt1 = paramArrayOfByte1.length;
          break;
          paramArrayOfByte1 = new byte[paramInt1];
          System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte1, 0, paramInt1);
          return b(paramArrayOfByte1, this.u, paramInt2);
          label1138:
          paramInt4 = paramInt2;
          paramInt2 = paramInt1;
          paramInt1 = paramInt4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.s
 * JD-Core Version:    0.7.0.1
 */