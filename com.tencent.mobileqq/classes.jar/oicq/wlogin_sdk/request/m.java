package oicq.wlogin_sdk.request;

import java.util.List;
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
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte2, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("start request_change_sig", "" + paramLong1);
    int i = t.w;
    int j = paramInt2 & 0xFDFFFFFF;
    t.b(this.x.h)._main_sigmap = j;
    paramInt1 = 0;
    for (;;)
    {
      a(this.i, this.t, this.j, paramLong1, this.m, this.n, i, this.p, a(paramLong1, paramLong2, paramLong3, i, j, paramArrayOfByte1, paramInt3, paramInt4, paramArrayOfLong, t.aa, paramArrayOfByte2, paramWUserSigInfo._domains));
      paramInt2 = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (paramInt2 != 0) {
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        util.LOGI("end request_change_sig for user ret " + paramInt1, "" + paramLong1);
        return paramInt1;
        paramInt2 = b();
        util.LOGI("retry num:" + paramInt1 + " ret:" + paramInt2, "" + paramLong1);
        if (paramInt2 != 180)
        {
          paramInt1 = paramInt2;
        }
        else
        {
          if (paramInt1 < 1) {
            break;
          }
          paramInt1 = paramInt2;
        }
      }
      paramInt1 += 1;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, long[] paramArrayOfLong, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, List<String> paramList)
  {
    int i = this.u;
    Object localObject6 = new tlv_t100();
    Object localObject7 = new tlv_t10a();
    Object localObject8 = new tlv_t116();
    Object localObject22 = new tlv_t108();
    Object localObject16 = new tlv_t109();
    Object localObject9 = new tlv_t124();
    tlv_t128 localtlv_t128 = new tlv_t128();
    Object localObject5 = new tlv_t143();
    tlv_t112 localtlv_t112 = new tlv_t112();
    tlv_t144 localtlv_t144 = new tlv_t144();
    Object localObject11 = new tlv_t145();
    Object localObject17 = new tlv_t147();
    Object localObject10 = new tlv_t142();
    Object localObject12 = new tlv_t154();
    Object localObject13 = new tlv_t18();
    Object localObject14 = new tlv_t141();
    Object localObject15 = new tlv_t8();
    Object localObject21 = new tlv_t511();
    tlv_t16e localtlv_t16e = new tlv_t16e();
    Object localObject20 = new tlv_t172();
    Object localObject18 = new tlv_t177();
    Object localObject19 = new tlv_t187();
    Object localObject1 = new tlv_t188();
    Object localObject2 = new tlv_t194();
    Object localObject3 = new tlv_t201();
    Object localObject4 = new tlv_t202();
    localObject6 = ((tlv_t100)localObject6).get_tlv_100(paramLong2, paramLong3, paramInt1, paramInt2);
    localObject7 = ((tlv_t10a)localObject7).get_tlv_10a(paramArrayOfByte1);
    localObject8 = ((tlv_t116)localObject8).get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
    localObject11 = ((tlv_t145)localObject11).get_tlv_145(t.A);
    localObject10 = ((tlv_t142)localObject10).get_tlv_142(t.E);
    localObject12 = ((tlv_t154)localObject12).get_tlv_154(this.x.i);
    localObject13 = ((tlv_t18)localObject13).get_tlv_18(paramLong2, paramInt1, paramLong1, 0);
    localObject14 = ((tlv_t141)localObject14).get_tlv_141(t.C, t.D, t.F);
    localObject15 = ((tlv_t8)localObject15).get_tlv_8(0, t.u, 0);
    localObject17 = ((tlv_t147)localObject17).get_tlv_147(paramLong2, t.G, t.H);
    localObject18 = ((tlv_t177)localObject18).get_tlv_177(1523965574L, "6.0.0.2282");
    byte[] arrayOfByte = new byte[0];
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
      paramArrayOfByte1 = ((tlv_t108)localObject22).get_tlv_108(paramArrayOfByte2);
    }
    for (paramInt1 = 11;; paramInt1 = 10)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramArrayOfLong = ((tlv_t511)localObject21).get_tlv_511(paramList);
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((this.x.r != null) && (this.x.r.length > 0))
        {
          paramArrayOfByte2 = ((tlv_t172)localObject20).get_tlv_172(this.x.r);
          paramInt1 += 1;
        }
        for (;;)
        {
          if ((t.N != null) && (t.N.length > 0))
          {
            paramList = ((tlv_t187)localObject19).get_tlv_187(t.N);
            paramInt1 += 1;
          }
          for (;;)
          {
            if ((t.O != null) && (t.O.length > 0))
            {
              localObject1 = ((tlv_t188)localObject1).get_tlv_188(t.O);
              paramInt1 += 1;
            }
            for (;;)
            {
              if ((t.L != null) && (t.L.length > 0))
              {
                localObject2 = ((tlv_t194)localObject2).get_tlv_194(t.L);
                paramInt1 += 1;
              }
              for (;;)
              {
                if ((k.J != null) && (k.J.length > 0))
                {
                  localObject3 = ((tlv_t201)localObject3).get_tlv_201(k.J, k.K, "qq".getBytes(), k.L);
                  paramInt1 += 1;
                }
                for (;;)
                {
                  if ((t.R != null) && (t.R.length > 0))
                  {
                    localObject4 = ((tlv_t202)localObject4).get_tlv_202(t.R, t.S);
                    paramInt1 += 1;
                  }
                  for (;;)
                  {
                    localObject16 = ((tlv_t109)localObject16).get_tlv_109(t.M);
                    localObject19 = util.get_os_type();
                    localObject20 = util.get_os_version();
                    paramInt2 = t.D;
                    localObject21 = t.C;
                    localObject22 = t.F;
                    localObject9 = localtlv_t144.get_tlv_144((byte[])localObject16, ((tlv_t124)localObject9).get_tlv_124((byte[])localObject19, (byte[])localObject20, paramInt2, (byte[])localObject21, new byte[0], (byte[])localObject22), localtlv_t128.get_tlv_128(t.T, t.U, t.V, t.Y, t.I, t.A, t.P), localtlv_t16e.get_tlv_16e(t.I), this.x.b);
                    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
                    {
                      localObject5 = ((tlv_t143)localObject5).get_tlv_143(paramArrayOfByte3);
                      paramInt1 = paramInt1 + 1 + 1;
                      paramInt2 = 11;
                      paramArrayOfByte3 = new byte[localObject6.length + localObject7.length + localObject8.length + paramArrayOfByte1.length + localObject9.length + localObject5.length + localObject10.length + localObject12.length + localObject13.length + localObject14.length + localObject15.length + paramArrayOfLong.length + localObject17.length + paramArrayOfByte2.length + localObject18.length + paramList.length + localObject1.length + localObject2.length + localObject3.length + localObject4.length];
                      System.arraycopy(localObject6, 0, paramArrayOfByte3, 0, localObject6.length);
                      paramInt3 = 0 + localObject6.length;
                      System.arraycopy(localObject7, 0, paramArrayOfByte3, paramInt3, localObject7.length);
                      paramInt3 += localObject7.length;
                      System.arraycopy(localObject8, 0, paramArrayOfByte3, paramInt3, localObject8.length);
                      paramInt3 += localObject8.length;
                      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, paramInt3, paramArrayOfByte1.length);
                      paramInt3 += paramArrayOfByte1.length;
                      System.arraycopy(localObject9, 0, paramArrayOfByte3, paramInt3, localObject9.length);
                      paramInt3 = localObject9.length + paramInt3;
                      System.arraycopy(localObject5, 0, paramArrayOfByte3, paramInt3, localObject5.length);
                      paramInt3 += localObject5.length;
                      System.arraycopy(localObject10, 0, paramArrayOfByte3, paramInt3, localObject10.length);
                      paramInt3 += localObject10.length;
                      System.arraycopy(localObject12, 0, paramArrayOfByte3, paramInt3, localObject12.length);
                      paramInt3 += localObject12.length;
                      System.arraycopy(localObject13, 0, paramArrayOfByte3, paramInt3, localObject13.length);
                      paramInt3 += localObject13.length;
                      System.arraycopy(localObject14, 0, paramArrayOfByte3, paramInt3, localObject14.length);
                      paramInt3 += localObject14.length;
                      System.arraycopy(localObject15, 0, paramArrayOfByte3, paramInt3, localObject15.length);
                      paramInt3 += localObject15.length;
                      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte3, paramInt3, paramArrayOfLong.length);
                      paramInt3 += paramArrayOfLong.length;
                      System.arraycopy(localObject17, 0, paramArrayOfByte3, paramInt3, localObject17.length);
                      paramInt3 += localObject17.length;
                      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt3, paramArrayOfByte2.length);
                      paramInt3 += paramArrayOfByte2.length;
                      System.arraycopy(localObject18, 0, paramArrayOfByte3, paramInt3, localObject18.length);
                      paramInt3 += localObject18.length;
                      System.arraycopy(paramList, 0, paramArrayOfByte3, paramInt3, paramList.length);
                      paramInt3 += paramList.length;
                      System.arraycopy(localObject1, 0, paramArrayOfByte3, paramInt3, localObject1.length);
                      paramInt3 += localObject1.length;
                      System.arraycopy(localObject2, 0, paramArrayOfByte3, paramInt3, localObject2.length);
                      paramInt3 += localObject2.length;
                      System.arraycopy(localObject3, 0, paramArrayOfByte3, paramInt3, localObject3.length);
                      paramInt3 += localObject3.length;
                      System.arraycopy(localObject4, 0, paramArrayOfByte3, paramInt3, localObject4.length);
                      paramInt3 = localObject4.length;
                      paramArrayOfByte1 = paramArrayOfByte3;
                      return b(paramArrayOfByte1, paramInt2, paramInt1);
                    }
                    paramInt1 += 2;
                    if ((this.x.g != null) && (!util.check_uin_account(this.x.g).booleanValue()))
                    {
                      paramArrayOfByte3 = localtlv_t112.get_tlv_112(this.x.g.getBytes());
                      paramInt1 += 1;
                    }
                    for (;;)
                    {
                      localObject5 = new byte[localObject6.length + localObject7.length + localObject8.length + paramArrayOfByte1.length + localObject9.length + arrayOfByte.length + paramArrayOfByte3.length + localObject11.length + localObject10.length + localObject12.length + localObject13.length + localObject14.length + localObject15.length + paramArrayOfLong.length + localObject17.length + paramArrayOfByte2.length + localObject18.length + paramList.length + localObject1.length + localObject2.length + localObject3.length + localObject4.length];
                      System.arraycopy(localObject6, 0, localObject5, 0, localObject6.length);
                      paramInt2 = 0 + localObject6.length;
                      System.arraycopy(localObject7, 0, localObject5, paramInt2, localObject7.length);
                      paramInt2 += localObject7.length;
                      System.arraycopy(localObject8, 0, localObject5, paramInt2, localObject8.length);
                      paramInt2 += localObject8.length;
                      System.arraycopy(paramArrayOfByte1, 0, localObject5, paramInt2, paramArrayOfByte1.length);
                      paramInt2 += paramArrayOfByte1.length;
                      System.arraycopy(localObject9, 0, localObject5, paramInt2, localObject9.length);
                      paramInt2 = localObject9.length + paramInt2;
                      System.arraycopy(arrayOfByte, 0, localObject5, paramInt2, arrayOfByte.length);
                      paramInt2 += arrayOfByte.length;
                      System.arraycopy(paramArrayOfByte3, 0, localObject5, paramInt2, paramArrayOfByte3.length);
                      paramInt2 = paramArrayOfByte3.length + paramInt2;
                      System.arraycopy(localObject11, 0, localObject5, paramInt2, localObject11.length);
                      paramInt2 += localObject11.length;
                      System.arraycopy(localObject10, 0, localObject5, paramInt2, localObject10.length);
                      paramInt2 += localObject10.length;
                      System.arraycopy(localObject12, 0, localObject5, paramInt2, localObject12.length);
                      paramInt2 += localObject12.length;
                      System.arraycopy(localObject13, 0, localObject5, paramInt2, localObject13.length);
                      paramInt2 += localObject13.length;
                      System.arraycopy(localObject14, 0, localObject5, paramInt2, localObject14.length);
                      paramInt2 += localObject14.length;
                      System.arraycopy(localObject15, 0, localObject5, paramInt2, localObject15.length);
                      paramInt2 += localObject15.length;
                      System.arraycopy(paramArrayOfLong, 0, localObject5, paramInt2, paramArrayOfLong.length);
                      paramInt2 += paramArrayOfLong.length;
                      System.arraycopy(localObject17, 0, localObject5, paramInt2, localObject17.length);
                      paramInt2 += localObject17.length;
                      System.arraycopy(paramArrayOfByte2, 0, localObject5, paramInt2, paramArrayOfByte2.length);
                      paramInt2 += paramArrayOfByte2.length;
                      System.arraycopy(localObject18, 0, localObject5, paramInt2, localObject18.length);
                      paramInt2 += localObject18.length;
                      System.arraycopy(paramList, 0, localObject5, paramInt2, paramList.length);
                      paramInt2 += paramList.length;
                      System.arraycopy(localObject1, 0, localObject5, paramInt2, localObject1.length);
                      paramInt2 += localObject1.length;
                      System.arraycopy(localObject2, 0, localObject5, paramInt2, localObject2.length);
                      paramInt2 += localObject2.length;
                      System.arraycopy(localObject3, 0, localObject5, paramInt2, localObject3.length);
                      paramInt2 += localObject3.length;
                      System.arraycopy(localObject4, 0, localObject5, paramInt2, localObject4.length);
                      paramInt2 = localObject4.length;
                      paramArrayOfByte1 = (byte[])localObject5;
                      paramInt2 = i;
                      break;
                      paramArrayOfByte3 = new byte[0];
                    }
                    localObject4 = new byte[0];
                  }
                  localObject3 = new byte[0];
                }
                localObject2 = new byte[0];
              }
              localObject1 = new byte[0];
            }
            paramList = new byte[0];
          }
          paramArrayOfByte2 = new byte[0];
        }
        paramArrayOfLong = new byte[0];
      }
      paramArrayOfByte1 = new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.m
 * JD-Core Version:    0.7.0.1
 */