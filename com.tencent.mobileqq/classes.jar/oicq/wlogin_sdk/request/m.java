package oicq.wlogin_sdk.request;

import java.util.List;
import java.util.List<Ljava.lang.String;>;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t10a;
import oicq.wlogin_sdk.tlv_type.tlv_t112;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t124;
import oicq.wlogin_sdk.tlv_type.tlv_t128;
import oicq.wlogin_sdk.tlv_type.tlv_t141;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t143;
import oicq.wlogin_sdk.tlv_type.tlv_t144;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t147;
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t16e;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tlv_type.tlv_t177;
import oicq.wlogin_sdk.tlv_type.tlv_t18;
import oicq.wlogin_sdk.tlv_type.tlv_t187;
import oicq.wlogin_sdk.tlv_type.tlv_t188;
import oicq.wlogin_sdk.tlv_type.tlv_t194;
import oicq.wlogin_sdk.tlv_type.tlv_t201;
import oicq.wlogin_sdk.tlv_type.tlv_t202;
import oicq.wlogin_sdk.tlv_type.tlv_t511;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class m
  extends oicq_request
{
  public m(t paramt)
  {
    this.t = 2064;
    this.u = 10;
    this.v = "wtlogin.exchange_emp";
    this.x = paramt;
    this.x.m = 0;
    this.a = this.x.h();
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte2, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject2 = new StringBuilder();
    Object localObject1 = "";
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramLong1);
    util.LOGI("start request_change_sig", ((StringBuilder)localObject2).toString());
    int j = t.x;
    paramInt2 &= 0xFDFFFFFF;
    t.b(this.x.h)._main_sigmap = paramInt2;
    paramInt1 = 0;
    for (;;)
    {
      localObject2 = this;
      a(((m)localObject2).i, ((m)localObject2).t, ((m)localObject2).j, paramLong1, ((m)localObject2).m, ((m)localObject2).n, j, ((m)localObject2).p, a(paramLong1, paramLong2, paramLong3, j, paramInt2, paramArrayOfByte1, paramInt3, paramInt4, paramArrayOfLong, t.ad, paramArrayOfByte2, paramWUserSigInfo._domains));
      int i = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (i != 0)
      {
        paramInt1 = i;
      }
      else
      {
        i = b();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("retry num:");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append(" ret:");
        ((StringBuilder)localObject2).append(i);
        String str = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localObject2 = localObject1;
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(paramLong1);
        util.LOGI(str, localStringBuilder.toString());
        if (i != 180)
        {
          paramInt1 = i;
        }
        else
        {
          if (paramInt1 < 1) {
            break label355;
          }
          paramInt1 = i;
        }
      }
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("end request_change_sig for user ret ");
      paramArrayOfByte1.append(paramInt1);
      paramArrayOfByte1 = paramArrayOfByte1.toString();
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append((String)localObject1);
      paramArrayOfLong.append(paramLong1);
      util.LOGI(paramArrayOfByte1, paramArrayOfLong.toString());
      return paramInt1;
      label355:
      localObject1 = localObject2;
      paramInt1 += 1;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, List<String> paramList)
  {
    int i = this.u;
    Object localObject11 = new tlv_t100();
    Object localObject12 = new tlv_t10a();
    Object localObject13 = new tlv_t116();
    Object localObject1 = new tlv_t108();
    Object localObject20 = new tlv_t109();
    Object localObject19 = new tlv_t52d();
    Object localObject17 = new tlv_t124();
    Object localObject18 = new tlv_t128();
    tlv_t143 localtlv_t143 = new tlv_t143();
    tlv_t112 localtlv_t112 = new tlv_t112();
    tlv_t144 localtlv_t144 = new tlv_t144();
    Object localObject15 = new tlv_t145();
    Object localObject3 = new tlv_t147();
    Object localObject14 = new tlv_t142();
    Object localObject16 = new tlv_t154();
    Object localObject6 = new tlv_t18();
    Object localObject5 = new tlv_t141();
    Object localObject4 = new tlv_t8();
    tlv_t511 localtlv_t511 = new tlv_t511();
    tlv_t16e localtlv_t16e = new tlv_t16e();
    Object localObject23 = new tlv_t172();
    Object localObject2 = new tlv_t177();
    Object localObject22 = new tlv_t187();
    Object localObject9 = new tlv_t188();
    Object localObject7 = new tlv_t194();
    Object localObject8 = new tlv_t201();
    Object localObject21 = new tlv_t202();
    Object localObject10 = new tlv_t544();
    localObject11 = ((tlv_t100)localObject11).get_tlv_100(paramLong2, paramLong3, paramInt1, paramInt2);
    localObject12 = ((tlv_t10a)localObject12).get_tlv_10a(paramArrayOfByte1);
    localObject13 = ((tlv_t116)localObject13).get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
    localObject15 = ((tlv_t145)localObject15).get_tlv_145(t.B);
    localObject14 = ((tlv_t142)localObject14).get_tlv_142(t.F);
    localObject16 = ((tlv_t154)localObject16).get_tlv_154(this.x.i);
    byte[] arrayOfByte1 = ((tlv_t18)localObject6).get_tlv_18(paramLong2, paramInt1, paramLong1, 0);
    byte[] arrayOfByte2 = ((tlv_t141)localObject5).get_tlv_141(t.D, t.E, t.G);
    byte[] arrayOfByte3 = ((tlv_t8)localObject4).get_tlv_8(0, t.v, 0);
    localObject6 = ((tlv_t147)localObject3).get_tlv_147(paramLong2, t.H, t.I);
    localObject5 = ((tlv_t177)localObject2).get_tlv_177(1619061003L, "6.0.0.2473");
    localObject4 = new byte[0];
    localObject3 = new byte[0];
    paramArrayOfByte1 = new byte[0];
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0))
    {
      localObject1 = ((tlv_t108)localObject1).get_tlv_108(paramArrayOfByte2);
      paramInt1 = 11;
    }
    else
    {
      localObject1 = new byte[0];
      paramInt1 = 10;
    }
    paramArrayOfLong = paramList;
    localObject2 = paramArrayOfByte1;
    paramInt2 = paramInt1;
    if (paramArrayOfLong != null)
    {
      localObject2 = paramArrayOfByte1;
      paramInt2 = paramInt1;
      if (paramList.size() > 0)
      {
        localObject2 = localtlv_t511.get_tlv_511(paramArrayOfLong);
        paramInt2 = paramInt1 + 1;
      }
    }
    if ((this.x.s != null) && (this.x.s.length > 0))
    {
      paramArrayOfByte1 = ((tlv_t172)localObject23).get_tlv_172(this.x.s);
      paramInt2 += 1;
    }
    else
    {
      paramArrayOfByte1 = new byte[0];
    }
    if ((t.O != null) && (t.O.length > 0))
    {
      paramArrayOfLong = ((tlv_t187)localObject22).get_tlv_187(t.O);
      paramInt2 += 1;
    }
    else
    {
      paramArrayOfLong = new byte[0];
    }
    paramList = (List<String>)localObject4;
    if ((t.P != null) && (t.P.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t188)localObject9).get_tlv_188(t.P);
      paramInt2 += 1;
    }
    else
    {
      paramArrayOfByte2 = new byte[0];
    }
    localObject4 = paramArrayOfLong;
    if ((t.M != null) && (t.M.length > 0))
    {
      paramArrayOfLong = ((tlv_t194)localObject7).get_tlv_194(t.M);
      paramInt2 += 1;
    }
    else
    {
      paramArrayOfLong = new byte[0];
    }
    localObject7 = paramArrayOfByte2;
    if ((k.L != null) && (k.L.length > 0))
    {
      paramArrayOfByte2 = ((tlv_t201)localObject8).get_tlv_201(k.L, k.M, "qq".getBytes(), k.N);
      paramInt2 += 1;
    }
    else
    {
      paramArrayOfByte2 = new byte[0];
    }
    localObject8 = paramArrayOfByte1;
    localObject9 = paramArrayOfLong;
    if ((t.S != null) && (t.S.length > 0))
    {
      paramArrayOfByte1 = ((tlv_t202)localObject21).get_tlv_202(t.S, t.T);
      paramInt2 += 1;
    }
    else
    {
      paramArrayOfByte1 = new byte[0];
    }
    paramArrayOfLong = ((tlv_t109)localObject20).get_tlv_109(t.P);
    localObject19 = ((tlv_t52d)localObject19).get_tlv_52d(this.a);
    localObject20 = util.get_os_type();
    localObject21 = util.get_os_version();
    paramInt1 = t.E;
    localObject22 = t.D;
    localObject23 = t.G;
    localObject17 = localtlv_t144.get_tlv_144(paramArrayOfLong, (byte[])localObject19, ((tlv_t124)localObject17).get_tlv_124((byte[])localObject20, (byte[])localObject21, paramInt1, (byte[])localObject22, new byte[0], (byte[])localObject23), ((tlv_t128)localObject18).get_tlv_128(t.V, t.W, t.X, t.aa, t.J, t.B, t.Q), localtlv_t16e.get_tlv_16e(t.J), this.x.b);
    paramArrayOfLong = "6.0.0.2473".getBytes();
    localObject18 = new byte[t.B.length + 10 + 2 + paramArrayOfLong.length + 4];
    util.int64_to_buf((byte[])localObject18, 0, (int)paramLong1);
    util.int16_to_buf((byte[])localObject18, 4, t.B.length);
    System.arraycopy(t.B, 0, localObject18, 6, t.B.length);
    paramInt1 = 6 + t.B.length;
    util.int16_to_buf((byte[])localObject18, paramInt1, paramArrayOfLong.length);
    paramInt1 += 2;
    System.arraycopy(paramArrayOfLong, 0, localObject18, paramInt1, paramArrayOfLong.length);
    util.int32_to_buf((byte[])localObject18, paramInt1 + paramArrayOfLong.length, this.u);
    localObject10 = ((tlv_t544)localObject10).get_tlv_544(String.valueOf(paramLong1), "810_a", (byte[])localObject18);
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
    {
      paramArrayOfByte3 = localtlv_t143.get_tlv_143(paramArrayOfByte3);
      paramInt3 = paramInt2 + 1 + 1;
      paramInt4 = localObject11.length + localObject12.length + localObject13.length + localObject1.length + localObject17.length + paramArrayOfByte3.length + localObject14.length + localObject16.length + arrayOfByte1.length + arrayOfByte2.length + arrayOfByte3.length + localObject2.length + localObject6.length + localObject8.length + localObject5.length + localObject4.length + localObject7.length + localObject9.length + paramArrayOfByte2.length + paramArrayOfByte1.length;
      paramInt2 = paramInt4;
      paramInt1 = paramInt3;
      if (localObject10 != null)
      {
        paramInt2 = paramInt4 + localObject10.length;
        paramInt1 = paramInt3 + 1;
      }
      paramArrayOfLong = new byte[paramInt2];
      System.arraycopy(localObject11, 0, paramArrayOfLong, 0, localObject11.length);
      paramInt2 = localObject11.length + 0;
      System.arraycopy(localObject12, 0, paramArrayOfLong, paramInt2, localObject12.length);
      paramInt2 += localObject12.length;
      System.arraycopy(localObject13, 0, paramArrayOfLong, paramInt2, localObject13.length);
      paramInt2 += localObject13.length;
      System.arraycopy(localObject1, 0, paramArrayOfLong, paramInt2, localObject1.length);
      paramInt2 += localObject1.length;
      System.arraycopy(localObject17, 0, paramArrayOfLong, paramInt2, localObject17.length);
      paramInt2 += localObject17.length;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfLong, paramInt2, paramArrayOfByte3.length);
      paramInt2 += paramArrayOfByte3.length;
      System.arraycopy(localObject14, 0, paramArrayOfLong, paramInt2, localObject14.length);
      paramInt2 += localObject14.length;
      System.arraycopy(localObject16, 0, paramArrayOfLong, paramInt2, localObject16.length);
      paramInt2 += localObject16.length;
      System.arraycopy(arrayOfByte1, 0, paramArrayOfLong, paramInt2, arrayOfByte1.length);
      paramInt2 += arrayOfByte1.length;
      System.arraycopy(arrayOfByte2, 0, paramArrayOfLong, paramInt2, arrayOfByte2.length);
      paramInt2 += arrayOfByte2.length;
      System.arraycopy(arrayOfByte3, 0, paramArrayOfLong, paramInt2, arrayOfByte3.length);
      paramInt2 += arrayOfByte3.length;
      System.arraycopy(localObject2, 0, paramArrayOfLong, paramInt2, localObject2.length);
      paramInt2 += localObject2.length;
      System.arraycopy(localObject6, 0, paramArrayOfLong, paramInt2, localObject6.length);
      paramInt2 += localObject6.length;
      System.arraycopy(localObject8, 0, paramArrayOfLong, paramInt2, localObject8.length);
      paramInt2 += localObject8.length;
      System.arraycopy(localObject5, 0, paramArrayOfLong, paramInt2, localObject5.length);
      paramInt2 += localObject5.length;
      System.arraycopy(localObject4, 0, paramArrayOfLong, paramInt2, localObject4.length);
      paramInt2 += localObject4.length;
      System.arraycopy(localObject7, 0, paramArrayOfLong, paramInt2, localObject7.length);
      paramInt2 += localObject7.length;
      System.arraycopy(localObject9, 0, paramArrayOfLong, paramInt2, localObject9.length);
      paramInt2 += localObject9.length;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfLong, paramInt2, paramArrayOfByte2.length);
      paramInt2 += paramArrayOfByte2.length;
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfLong, paramInt2, paramArrayOfByte1.length);
      paramInt3 = paramArrayOfByte1.length;
      if (localObject10 != null)
      {
        System.arraycopy(localObject10, 0, paramArrayOfLong, paramInt2 + paramInt3, localObject10.length);
        paramInt2 = localObject10.length;
      }
      paramInt2 = 11;
      paramArrayOfByte1 = paramArrayOfLong;
    }
    else
    {
      paramInt1 = paramInt2 + 2;
      if ((this.x.g != null) && (!util.check_uin_account(this.x.g).booleanValue()))
      {
        paramArrayOfLong = localtlv_t112.get_tlv_112(this.x.g.getBytes());
        paramInt1 += 1;
      }
      else
      {
        paramArrayOfLong = (long[])localObject3;
      }
      paramInt2 = localObject11.length + localObject12.length + localObject13.length + localObject1.length + localObject17.length + paramList.length + paramArrayOfLong.length + localObject15.length + localObject14.length + localObject16.length + arrayOfByte1.length + arrayOfByte2.length + arrayOfByte3.length + localObject2.length + localObject6.length + localObject8.length + localObject5.length + localObject4.length + localObject7.length + localObject9.length + paramArrayOfByte2.length + paramArrayOfByte1.length;
      if (localObject10 != null)
      {
        paramInt2 += localObject10.length;
        paramInt1 += 1;
      }
      paramArrayOfByte3 = new byte[paramInt2];
      System.arraycopy(localObject11, 0, paramArrayOfByte3, 0, localObject11.length);
      paramInt2 = localObject11.length + 0;
      System.arraycopy(localObject12, 0, paramArrayOfByte3, paramInt2, localObject12.length);
      paramInt2 += localObject12.length;
      System.arraycopy(localObject13, 0, paramArrayOfByte3, paramInt2, localObject13.length);
      paramInt2 += localObject13.length;
      System.arraycopy(localObject1, 0, paramArrayOfByte3, paramInt2, localObject1.length);
      paramInt2 += localObject1.length;
      System.arraycopy(localObject17, 0, paramArrayOfByte3, paramInt2, localObject17.length);
      paramInt2 += localObject17.length;
      System.arraycopy(paramList, 0, paramArrayOfByte3, paramInt2, paramList.length);
      paramInt2 += paramList.length;
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte3, paramInt2, paramArrayOfLong.length);
      paramInt2 += paramArrayOfLong.length;
      System.arraycopy(localObject15, 0, paramArrayOfByte3, paramInt2, localObject15.length);
      paramInt2 += localObject15.length;
      System.arraycopy(localObject14, 0, paramArrayOfByte3, paramInt2, localObject14.length);
      paramInt2 += localObject14.length;
      System.arraycopy(localObject16, 0, paramArrayOfByte3, paramInt2, localObject16.length);
      paramInt2 += localObject16.length;
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte3, paramInt2, arrayOfByte1.length);
      paramInt2 += arrayOfByte1.length;
      System.arraycopy(arrayOfByte2, 0, paramArrayOfByte3, paramInt2, arrayOfByte2.length);
      paramInt2 += arrayOfByte2.length;
      System.arraycopy(arrayOfByte3, 0, paramArrayOfByte3, paramInt2, arrayOfByte3.length);
      paramInt2 += arrayOfByte3.length;
      System.arraycopy(localObject2, 0, paramArrayOfByte3, paramInt2, localObject2.length);
      paramInt2 += localObject2.length;
      System.arraycopy(localObject6, 0, paramArrayOfByte3, paramInt2, localObject6.length);
      paramInt2 += localObject6.length;
      System.arraycopy(localObject8, 0, paramArrayOfByte3, paramInt2, localObject8.length);
      paramInt2 += localObject8.length;
      System.arraycopy(localObject5, 0, paramArrayOfByte3, paramInt2, localObject5.length);
      paramInt2 += localObject5.length;
      System.arraycopy(localObject4, 0, paramArrayOfByte3, paramInt2, localObject4.length);
      paramInt2 += localObject4.length;
      System.arraycopy(localObject7, 0, paramArrayOfByte3, paramInt2, localObject7.length);
      paramInt2 += localObject7.length;
      System.arraycopy(localObject9, 0, paramArrayOfByte3, paramInt2, localObject9.length);
      paramInt2 += localObject9.length;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt2, paramArrayOfByte2.length);
      paramInt2 += paramArrayOfByte2.length;
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, paramInt2, paramArrayOfByte1.length);
      paramInt3 = paramArrayOfByte1.length;
      if (localObject10 != null)
      {
        System.arraycopy(localObject10, 0, paramArrayOfByte3, paramInt2 + paramInt3, localObject10.length);
        paramInt2 = localObject10.length;
      }
      paramInt2 = i;
      paramArrayOfByte1 = paramArrayOfByte3;
    }
    return b(paramArrayOfByte1, paramInt2, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.m
 * JD-Core Version:    0.7.0.1
 */