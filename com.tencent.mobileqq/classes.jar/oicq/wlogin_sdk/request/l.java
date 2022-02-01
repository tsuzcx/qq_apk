package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t112;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t124;
import oicq.wlogin_sdk.tlv_type.tlv_t128;
import oicq.wlogin_sdk.tlv_type.tlv_t141;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t144;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t147;
import oicq.wlogin_sdk.tlv_type.tlv_t148;
import oicq.wlogin_sdk.tlv_type.tlv_t153;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t16e;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tlv_type.tlv_t177;
import oicq.wlogin_sdk.tlv_type.tlv_t18;
import oicq.wlogin_sdk.tlv_type.tlv_t187;
import oicq.wlogin_sdk.tlv_type.tlv_t188;
import oicq.wlogin_sdk.tlv_type.tlv_t194;
import oicq.wlogin_sdk.tlv_type.tlv_t202;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class l
  extends oicq_request
{
  public l(t paramt)
  {
    this.t = 2064;
    this.u = 13;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
    this.a = this.x.h();
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte3, long paramLong4, long paramLong5, long paramLong6, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.x;
    paramArrayOfByte1 = c(paramArrayOfByte1);
    if (paramArrayOfByte1 == null) {
      return -1014;
    }
    int i;
    for (paramInt1 = 0;; paramInt1 = i)
    {
      Object localObject = a(paramLong1, paramLong2, paramLong3, j, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt3, paramInt4, paramArrayOfLong, t.ad, paramArrayOfByte3, paramLong4, paramLong5, paramLong6, paramArrayOfByte4, paramArrayOfByte5);
      a(this.i, this.t, this.j, paramLong1, this.m, this.n, j, this.p, (byte[])localObject);
      i = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (i != 0) {
        return i;
      }
      int k = b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("retry num:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ret:");
      ((StringBuilder)localObject).append(k);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramLong1);
      util.LOGI((String)localObject, localStringBuilder.toString());
      if (k != 180) {
        return k;
      }
      i = paramInt1 + 1;
      if (paramInt1 >= 1) {
        return k;
      }
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, long paramLong4, long paramLong5, long paramLong6, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
  {
    Object localObject9 = new tlv_t106();
    tlv_t144 localtlv_t144 = new tlv_t144();
    Object localObject10 = new tlv_t100();
    Object localObject1 = new tlv_t108();
    Object localObject11 = new tlv_t116();
    Object localObject23 = new tlv_t112();
    Object localObject12 = new tlv_t142();
    Object localObject14 = new tlv_t145();
    Object localObject2 = new tlv_t16a();
    Object localObject15 = new tlv_t18();
    Object localObject5 = new tlv_t141();
    Object localObject6 = new tlv_t8();
    Object localObject19 = new tlv_t109();
    Object localObject18 = new tlv_t52d();
    Object localObject17 = new tlv_t124();
    Object localObject16 = new tlv_t128();
    Object localObject4 = new tlv_t147();
    tlv_t148 localtlv_t148 = new tlv_t148();
    tlv_t153 localtlv_t153 = new tlv_t153();
    Object localObject13 = new tlv_t16e();
    Object localObject22 = new tlv_t172();
    Object localObject3 = new tlv_t177();
    Object localObject7 = new tlv_t187();
    Object localObject8 = new tlv_t188();
    Object localObject21 = new tlv_t194();
    Object localObject20 = new tlv_t202();
    tlv_t544 localtlv_t544 = new tlv_t544();
    ((tlv_t106)localObject9).set_data(paramArrayOfByte1, paramArrayOfByte1.length);
    localObject9 = ((tlv_t106)localObject9).get_buf();
    localObject10 = ((tlv_t100)localObject10).get_tlv_100(paramLong5, paramLong6, paramInt1, paramInt2);
    localObject11 = ((tlv_t116)localObject11).get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
    localObject12 = ((tlv_t142)localObject12).get_tlv_142(t.F);
    localObject14 = ((tlv_t145)localObject14).get_tlv_145(t.B);
    localObject15 = ((tlv_t18)localObject15).get_tlv_18(paramLong2, paramInt1, paramLong1, 0);
    localObject5 = ((tlv_t141)localObject5).get_tlv_141(t.D, t.E, t.G);
    localObject6 = ((tlv_t8)localObject6).get_tlv_8(0, t.v, 0);
    localObject4 = ((tlv_t147)localObject4).get_tlv_147(paramLong2, t.H, t.I);
    byte[] arrayOfByte = ((tlv_t177)localObject3).get_tlv_177(1619061003L, "6.0.0.2473");
    paramArrayOfByte1 = new byte[0];
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
    {
      paramArrayOfByte3 = ((tlv_t108)localObject1).get_tlv_108(paramArrayOfByte3);
      paramInt1 = 11;
    }
    else
    {
      paramInt1 = 10;
      paramArrayOfByte3 = new byte[0];
    }
    localObject3 = this;
    paramInt2 = paramInt1;
    localObject1 = paramArrayOfByte1;
    if (((l)localObject3).x.g != null)
    {
      paramInt2 = paramInt1;
      localObject1 = paramArrayOfByte1;
      if (!util.check_uin_account(((l)localObject3).x.g).booleanValue())
      {
        localObject1 = ((tlv_t112)localObject23).get_tlv_112(((l)localObject3).x.g.getBytes());
        paramInt2 = paramInt1 + 1;
      }
    }
    paramInt1 = paramInt2;
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0))
    {
      localObject2 = ((tlv_t16a)localObject2).get_tlv_16a(paramArrayOfByte2);
      paramInt1 += 1;
    }
    else
    {
      localObject2 = new byte[0];
    }
    if ((((l)localObject3).x.s != null) && (((l)localObject3).x.s.length > 0))
    {
      paramArrayOfByte1 = ((tlv_t172)localObject22).get_tlv_172(((l)localObject3).x.s);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte1 = new byte[0];
    }
    if ((t.O != null) && (t.O.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t187)localObject7).get_tlv_187(t.O);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte2 = new byte[0];
    }
    localObject7 = paramArrayOfByte1;
    if ((t.P != null) && (t.P.length > 0))
    {
      paramArrayOfLong = ((tlv_t188)localObject8).get_tlv_188(t.P);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfLong = new byte[0];
    }
    localObject8 = paramArrayOfByte2;
    if ((t.M != null) && (t.M.length > 0))
    {
      paramArrayOfByte1 = ((tlv_t194)localObject21).get_tlv_194(t.M);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte1 = new byte[0];
    }
    if ((t.S != null) && (t.S.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t202)localObject20).get_tlv_202(t.S, t.T);
      paramInt1 += 1;
    }
    else
    {
      paramArrayOfByte2 = new byte[0];
    }
    localObject19 = ((tlv_t109)localObject19).get_tlv_109(t.P);
    localObject18 = ((tlv_t52d)localObject18).get_tlv_52d(((l)localObject3).a);
    localObject20 = util.get_os_type();
    localObject21 = util.get_os_version();
    paramInt2 = t.E;
    localObject22 = t.D;
    localObject23 = t.G;
    localObject17 = ((tlv_t124)localObject17).get_tlv_124((byte[])localObject20, (byte[])localObject21, paramInt2, (byte[])localObject22, new byte[0], (byte[])localObject23);
    localObject16 = ((tlv_t128)localObject16).get_tlv_128(t.V, t.W, t.X, 0, t.J, t.B, t.Q);
    paramArrayOfByte4 = localtlv_t148.get_tlv_148(paramArrayOfByte4, paramLong4, paramLong5, paramLong6, paramArrayOfByte5, paramArrayOfByte6);
    paramArrayOfByte5 = localtlv_t153.get_tlv_153(t.ab);
    paramArrayOfByte6 = ((tlv_t16e)localObject13).get_tlv_16e(t.J);
    localObject13 = t.b(((l)localObject3).x.h)._tgtgt_key;
    paramArrayOfByte4 = localtlv_t144.get_tlv_144((byte[])localObject19, (byte[])localObject18, (byte[])localObject17, (byte[])localObject16, paramArrayOfByte4, new byte[0], paramArrayOfByte5, paramArrayOfByte6, (byte[])localObject13);
    paramInt3 = paramInt1 + 1;
    paramArrayOfByte5 = "6.0.0.2473".getBytes();
    paramArrayOfByte6 = new byte[t.B.length + 10 + 2 + paramArrayOfByte5.length + 4];
    util.int64_to_buf(paramArrayOfByte6, 0, (int)paramLong1);
    util.int16_to_buf(paramArrayOfByte6, 4, t.B.length);
    System.arraycopy(t.B, 0, paramArrayOfByte6, 6, t.B.length);
    paramInt1 = 6 + t.B.length;
    util.int16_to_buf(paramArrayOfByte6, paramInt1, paramArrayOfByte5.length);
    paramInt1 += 2;
    System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte6, paramInt1, paramArrayOfByte5.length);
    util.int32_to_buf(paramArrayOfByte6, paramInt1 + paramArrayOfByte5.length, ((l)localObject3).u);
    paramArrayOfByte5 = localtlv_t544.get_tlv_544(String.valueOf(paramLong1), "810_d", paramArrayOfByte6);
    paramInt4 = localObject9.length + localObject10.length + paramArrayOfByte3.length + localObject11.length + localObject1.length + localObject12.length + localObject14.length + paramArrayOfByte4.length + localObject2.length + localObject15.length + localObject5.length + localObject6.length + localObject4.length + localObject7.length + arrayOfByte.length + localObject8.length + paramArrayOfLong.length + paramArrayOfByte1.length + paramArrayOfByte2.length;
    paramInt2 = paramInt4;
    paramInt1 = paramInt3;
    if (paramArrayOfByte5 != null)
    {
      paramInt2 = paramInt4 + paramArrayOfByte5.length;
      paramInt1 = paramInt3 + 1;
    }
    paramArrayOfByte6 = new byte[paramInt2];
    System.arraycopy(localObject9, 0, paramArrayOfByte6, 0, localObject9.length);
    paramInt2 = localObject9.length + 0;
    System.arraycopy(localObject10, 0, paramArrayOfByte6, paramInt2, localObject10.length);
    paramInt2 += localObject10.length;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte6, paramInt2, paramArrayOfByte3.length);
    paramInt2 += paramArrayOfByte3.length;
    System.arraycopy(localObject11, 0, paramArrayOfByte6, paramInt2, localObject11.length);
    paramInt2 += localObject11.length;
    System.arraycopy(localObject1, 0, paramArrayOfByte6, paramInt2, localObject1.length);
    paramInt2 += localObject1.length;
    System.arraycopy(localObject12, 0, paramArrayOfByte6, paramInt2, localObject12.length);
    paramInt2 += localObject12.length;
    System.arraycopy(localObject14, 0, paramArrayOfByte6, paramInt2, localObject14.length);
    paramInt2 += localObject14.length;
    System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte6, paramInt2, paramArrayOfByte4.length);
    paramInt2 += paramArrayOfByte4.length;
    System.arraycopy(localObject2, 0, paramArrayOfByte6, paramInt2, localObject2.length);
    paramInt2 += localObject2.length;
    System.arraycopy(localObject15, 0, paramArrayOfByte6, paramInt2, localObject15.length);
    paramInt2 += localObject15.length;
    System.arraycopy(localObject5, 0, paramArrayOfByte6, paramInt2, localObject5.length);
    paramInt2 += localObject5.length;
    System.arraycopy(localObject6, 0, paramArrayOfByte6, paramInt2, localObject6.length);
    paramInt2 += localObject6.length;
    System.arraycopy(localObject4, 0, paramArrayOfByte6, paramInt2, localObject4.length);
    paramInt2 += localObject4.length;
    System.arraycopy(localObject7, 0, paramArrayOfByte6, paramInt2, localObject7.length);
    paramInt2 += localObject7.length;
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte6, paramInt2, arrayOfByte.length);
    paramInt2 += arrayOfByte.length;
    System.arraycopy(localObject8, 0, paramArrayOfByte6, paramInt2, localObject8.length);
    paramInt2 += localObject8.length;
    System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte6, paramInt2, paramArrayOfLong.length);
    paramInt2 += paramArrayOfLong.length;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte6, paramInt2, paramArrayOfByte1.length);
    paramInt2 += paramArrayOfByte1.length;
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte6, paramInt2, paramArrayOfByte2.length);
    paramInt3 = paramArrayOfByte2.length;
    if (paramArrayOfByte5 != null)
    {
      System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte6, paramInt2 + paramInt3, paramArrayOfByte5.length);
      paramInt2 = paramArrayOfByte5.length;
    }
    return b(paramArrayOfByte6, this.u, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.l
 * JD-Core Version:    0.7.0.1
 */