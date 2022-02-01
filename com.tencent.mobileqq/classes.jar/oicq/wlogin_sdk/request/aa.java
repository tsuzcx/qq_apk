package oicq.wlogin_sdk.request;

import android.content.Context;
import android.util.Log;
import com.tencent.loginsecsdk.ProtocolDet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.a;
import oicq.wlogin_sdk.report.c;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t1;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t107;
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
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t166;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t16e;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tlv_type.tlv_t177;
import oicq.wlogin_sdk.tlv_type.tlv_t18;
import oicq.wlogin_sdk.tlv_type.tlv_t187;
import oicq.wlogin_sdk.tlv_type.tlv_t188;
import oicq.wlogin_sdk.tlv_type.tlv_t194;
import oicq.wlogin_sdk.tlv_type.tlv_t201;
import oicq.wlogin_sdk.tlv_type.tlv_t202;
import oicq.wlogin_sdk.tlv_type.tlv_t400;
import oicq.wlogin_sdk.tlv_type.tlv_t511;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t545;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class aa
  extends oicq_request
{
  public aa(t paramt, Context paramContext)
  {
    this.t = 2064;
    this.u = 15;
    this.v = "wtlogin.exchange_emp";
    this.x = paramt;
    this.x.m = 0;
    this.y = oicq_request.EncryptionMethod.EM_ST;
    this.a = paramContext;
  }
  
  private byte[] a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, long paramLong4, byte[] paramArrayOfByte5, List<String> paramList, int paramInt11, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject9 = new tlv_t18();
    Object localObject10 = new tlv_t1();
    Object localObject11 = new tlv_t106();
    Object localObject14 = new tlv_t116();
    Object localObject12 = new tlv_t100();
    Object localObject13 = new tlv_t107();
    Object localObject33 = new tlv_t108();
    Object localObject31 = new tlv_t109();
    Object localObject30 = new tlv_t52d();
    Object localObject29 = new tlv_t124();
    Object localObject28 = new tlv_t128();
    Object localObject25 = new tlv_t142();
    tlv_t112 localtlv_t112 = new tlv_t112();
    Object localObject26 = new tlv_t144();
    Object localObject15 = new tlv_t145();
    Object localObject19 = new tlv_t147();
    Object localObject32 = new tlv_t166();
    tlv_t16a localtlv_t16a = new tlv_t16a();
    Object localObject17 = new tlv_t141();
    Object localObject18 = new tlv_t8();
    Object localObject16 = new tlv_t154();
    tlv_t511 localtlv_t511 = new tlv_t511();
    Object localObject27 = new tlv_t16e();
    Object localObject1 = new tlv_t172();
    Object localObject8 = new tlv_t177();
    Object localObject24 = new tlv_t400();
    Object localObject2 = new tlv_t187();
    Object localObject3 = new tlv_t188();
    Object localObject4 = new tlv_t194();
    Object localObject5 = new tlv_t201();
    Object localObject6 = new tlv_t202();
    Object localObject23 = new tlv_t(1302);
    Object localObject22 = new tlv_t(1313);
    Object localObject20 = new tlv_t(1317);
    Object localObject7 = new tlv_t545();
    Object localObject21 = new tlv_t544();
    c.a(Thread.currentThread());
    long l1 = System.currentTimeMillis();
    WloginSigInfo localWloginSigInfo = this.x.a(paramLong2, paramLong4);
    localObject9 = ((tlv_t18)localObject9).get_tlv_18(paramLong1, paramInt1, paramLong2, paramInt2);
    localObject10 = ((tlv_t1)localObject10).get_tlv_1(paramLong2, paramArrayOfByte1);
    ((tlv_t106)localObject11).set_data(paramArrayOfByte2, paramArrayOfByte2.length);
    localObject11 = ((tlv_t106)localObject11).get_buf();
    util.LOGD("req2 a1:", util.buf_to_string((byte[])localObject11));
    localObject12 = ((tlv_t100)localObject12).get_tlv_100(paramLong1, paramLong3, paramInt1, paramInt5);
    localObject13 = ((tlv_t107)localObject13).get_tlv_107(paramInt7, paramInt8, paramInt9, paramInt10);
    localObject14 = ((tlv_t116)localObject14).get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
    localObject15 = ((tlv_t145)localObject15).get_tlv_145(t.B);
    localObject16 = ((tlv_t154)localObject16).get_tlv_154(this.x.i);
    localObject17 = ((tlv_t141)localObject17).get_tlv_141(t.D, t.E, t.G);
    localObject18 = ((tlv_t8)localObject18).get_tlv_8(0, t.v, 0);
    localObject19 = ((tlv_t147)localObject19).get_tlv_147(paramLong4, t.H, t.I);
    byte[] arrayOfByte = ((tlv_t177)localObject8).get_tlv_177(1609322643L, "6.0.0.2463");
    localObject8 = new byte[0];
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0)) {
      paramArrayOfLong = ((tlv_t108)localObject33).get_tlv_108(paramArrayOfByte4);
    }
    for (paramInt1 = 13;; paramInt1 = 12)
    {
      if ((paramInt3 & 0x80) != 0)
      {
        paramArrayOfByte4 = ((tlv_t166)localObject32).get_tlv_166(t.y);
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((this.x.s != null) && (this.x.s.length > 0))
        {
          localObject1 = ((tlv_t172)localObject1).get_tlv_172(this.x.s);
          paramInt1 += 1;
        }
        for (;;)
        {
          if ((t.O != null) && (t.O.length > 0))
          {
            localObject2 = ((tlv_t187)localObject2).get_tlv_187(t.O);
            paramInt1 += 1;
          }
          for (;;)
          {
            if ((t.P != null) && (t.P.length > 0))
            {
              localObject3 = ((tlv_t188)localObject3).get_tlv_188(t.P);
              paramInt1 += 1;
            }
            for (;;)
            {
              if ((t.M != null) && (t.M.length > 0))
              {
                localObject4 = ((tlv_t194)localObject4).get_tlv_194(t.M);
                paramInt1 += 1;
              }
              for (;;)
              {
                if ((k.L != null) && (k.L.length > 0))
                {
                  localObject5 = ((tlv_t201)localObject5).get_tlv_201(k.L, k.M, "qq".getBytes(), k.N);
                  paramInt1 += 1;
                }
                for (;;)
                {
                  if ((t.S != null) && (t.S.length > 0))
                  {
                    localObject6 = ((tlv_t202)localObject6).get_tlv_202(t.S, t.T);
                    paramInt1 += 1;
                  }
                  for (;;)
                  {
                    if ((t.U == null) || (t.U.length == 0)) {
                      t.U = util.get_qimei(t.u);
                    }
                    if ((t.U != null) && (t.U.length > 0))
                    {
                      localObject7 = ((tlv_t545)localObject7).get_tlv_545(t.U);
                      paramInt1 += 1;
                    }
                    for (;;)
                    {
                      paramArrayOfByte1 = ((tlv_t109)localObject31).get_tlv_109(t.P);
                      paramArrayOfByte2 = ((tlv_t52d)localObject30).get_tlv_52d(this.a);
                      localObject30 = util.get_os_type();
                      localObject31 = util.get_os_version();
                      paramInt2 = t.E;
                      localObject32 = t.D;
                      localObject33 = t.G;
                      localObject29 = ((tlv_t124)localObject29).get_tlv_124((byte[])localObject30, (byte[])localObject31, paramInt2, (byte[])localObject32, new byte[0], (byte[])localObject33);
                      localObject28 = ((tlv_t128)localObject28).get_tlv_128(t.V, t.W, t.X, t.aa, t.J, t.B, t.Q);
                      localObject27 = ((tlv_t16e)localObject27).get_tlv_16e(t.J);
                      util.LOGI("nopicsig tlv16e", "");
                      localObject26 = ((tlv_t144)localObject26).get_tlv_144(paramArrayOfByte1, paramArrayOfByte2, (byte[])localObject29, (byte[])localObject28, (byte[])localObject27, t.b(this.x.h)._tgtgt_key);
                      localObject25 = ((tlv_t142)localObject25).get_tlv_142(paramArrayOfByte5);
                      paramInt1 = paramInt1 + 1 + 1;
                      if ((this.x.g != null) && (!util.check_uin_account(this.x.g).booleanValue()))
                      {
                        paramArrayOfByte5 = localtlv_t112.get_tlv_112(this.x.g.getBytes());
                        paramInt1 += 1;
                        util.LOGI("nopicsig tlv112", "");
                      }
                      for (;;)
                      {
                        if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
                        {
                          paramArrayOfByte3 = localtlv_t16a.get_tlv_16a(paramArrayOfByte3);
                          paramInt1 += 1;
                          util.LOGI("nopicsig tlv16a", "");
                        }
                        for (;;)
                        {
                          if ((paramList != null) && (paramList.size() > 0))
                          {
                            paramList = localtlv_t511.get_tlv_511(paramList);
                            paramInt1 += 1;
                            util.LOGI("nopicsig tlv511", "");
                          }
                          label2743:
                          for (;;)
                          {
                            if ((localWloginSigInfo != null) && (localWloginSigInfo._G != null) && (localWloginSigInfo._G.length > 0) && (localWloginSigInfo._dpwd != null) && (localWloginSigInfo._dpwd.length > 0) && (localWloginSigInfo._randseed != null) && (localWloginSigInfo._randseed.length > 0))
                            {
                              localObject8 = ((tlv_t400)localObject24).get_tlv_400(localWloginSigInfo._G, paramLong2, t.B, localWloginSigInfo._dpwd, paramLong4, 1L, localWloginSigInfo._randseed);
                              util.LOGI("nopicsig tlv400", "");
                              paramInt1 += 1;
                            }
                            for (;;)
                            {
                              paramArrayOfByte1 = new byte[4];
                              util.int32_to_buf(paramArrayOfByte1, 0, paramInt11);
                              ((tlv_t)localObject23).set_data(paramArrayOfByte1, 4);
                              localObject23 = ((tlv_t)localObject23).get_buf();
                              util.LOGI("nopicsig tlv516", "");
                              paramArrayOfByte1 = new byte[6];
                              util.int32_to_buf(paramArrayOfByte1, 0, t.aA);
                              util.int16_to_buf(paramArrayOfByte1, 4, 0);
                              ((tlv_t)localObject22).set_data(paramArrayOfByte1, 6);
                              localObject22 = ((tlv_t)localObject22).get_buf();
                              paramInt1 = paramInt1 + 1 + 1;
                              util.LOGI("nopicsig tlv521", "");
                              paramLong3 = System.currentTimeMillis();
                              localObject21 = ((tlv_t544)localObject21).get_tlv_544(this.a, paramLong2, t.B.length, t.B, "6.0.0.2463".length(), "6.0.0.2463", this.u);
                              paramLong4 = System.currentTimeMillis();
                              util.LOGI("nopicsig tlv544 cost:" + (paramLong4 - paramLong3), "");
                              try
                              {
                                paramLong2 = System.currentTimeMillis();
                              }
                              catch (Throwable paramArrayOfByte2)
                              {
                                for (;;)
                                {
                                  label1729:
                                  paramLong1 = 0L;
                                  paramLong2 = 0L;
                                  paramArrayOfByte1 = null;
                                  util.LOGI("request_tgtgt_nopicsig tlv536 error" + Log.getStackTraceString(paramArrayOfByte2), "");
                                }
                                paramArrayOfByte2 = new byte[paramInt2];
                                System.arraycopy(localObject9, 0, paramArrayOfByte2, 0, localObject9.length);
                                paramInt1 = 0 + localObject9.length;
                                System.arraycopy(localObject10, 0, paramArrayOfByte2, paramInt1, localObject10.length);
                                paramInt1 += localObject10.length;
                                System.arraycopy(localObject11, 0, paramArrayOfByte2, paramInt1, localObject11.length);
                                paramInt1 += localObject11.length;
                                System.arraycopy(localObject14, 0, paramArrayOfByte2, paramInt1, localObject14.length);
                                paramInt1 += localObject14.length;
                                System.arraycopy(localObject12, 0, paramArrayOfByte2, paramInt1, localObject12.length);
                                paramInt1 += localObject12.length;
                                System.arraycopy(localObject13, 0, paramArrayOfByte2, paramInt1, localObject13.length);
                                paramInt1 += localObject13.length;
                                System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte2, paramInt1, paramArrayOfLong.length);
                                paramInt1 += paramArrayOfLong.length;
                                System.arraycopy(localObject26, 0, paramArrayOfByte2, paramInt1, localObject26.length);
                                paramInt1 += localObject26.length;
                                System.arraycopy(localObject25, 0, paramArrayOfByte2, paramInt1, localObject25.length);
                                paramInt1 += localObject25.length;
                                System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte2, paramInt1, paramArrayOfByte5.length);
                                paramInt1 += paramArrayOfByte5.length;
                                System.arraycopy(localObject15, 0, paramArrayOfByte2, paramInt1, localObject15.length);
                                paramInt1 += localObject15.length;
                                System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte2, paramInt1, paramArrayOfByte4.length);
                                paramInt1 += paramArrayOfByte4.length;
                                System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte2, paramInt1, paramArrayOfByte3.length);
                                paramInt1 += paramArrayOfByte3.length;
                                System.arraycopy(localObject16, 0, paramArrayOfByte2, paramInt1, localObject16.length);
                                paramInt1 += localObject16.length;
                                System.arraycopy(localObject17, 0, paramArrayOfByte2, paramInt1, localObject17.length);
                                paramInt1 += localObject17.length;
                                System.arraycopy(localObject18, 0, paramArrayOfByte2, paramInt1, localObject18.length);
                                paramInt1 += localObject18.length;
                                System.arraycopy(paramList, 0, paramArrayOfByte2, paramInt1, paramList.length);
                                paramInt1 += paramList.length;
                                System.arraycopy(localObject19, 0, paramArrayOfByte2, paramInt1, localObject19.length);
                                paramInt1 += localObject19.length;
                                System.arraycopy(localObject1, 0, paramArrayOfByte2, paramInt1, localObject1.length);
                                paramInt1 += localObject1.length;
                                System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, paramInt1, arrayOfByte.length);
                                paramInt1 += arrayOfByte.length;
                                System.arraycopy(localObject8, 0, paramArrayOfByte2, paramInt1, localObject8.length);
                                paramInt1 += localObject8.length;
                                System.arraycopy(localObject2, 0, paramArrayOfByte2, paramInt1, localObject2.length);
                                paramInt1 += localObject2.length;
                                System.arraycopy(localObject3, 0, paramArrayOfByte2, paramInt1, localObject3.length);
                                paramInt1 += localObject3.length;
                                System.arraycopy(localObject4, 0, paramArrayOfByte2, paramInt1, localObject4.length);
                                paramInt1 += localObject4.length;
                                System.arraycopy(localObject5, 0, paramArrayOfByte2, paramInt1, localObject5.length);
                                paramInt1 += localObject5.length;
                                System.arraycopy(localObject6, 0, paramArrayOfByte2, paramInt1, localObject6.length);
                                paramInt1 += localObject6.length;
                                System.arraycopy(localObject23, 0, paramArrayOfByte2, paramInt1, localObject23.length);
                                paramInt1 += localObject23.length;
                                System.arraycopy(localObject22, 0, paramArrayOfByte2, paramInt1, localObject22.length);
                                paramInt2 = paramInt1 + localObject22.length;
                                paramInt1 = paramInt2;
                                if (paramArrayOfByte1 != null)
                                {
                                  System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt2, paramArrayOfByte1.length);
                                  paramInt1 = paramInt2 + paramArrayOfByte1.length;
                                }
                                paramInt2 = paramInt1;
                                if (localObject21 != null)
                                {
                                  System.arraycopy(localObject21, 0, paramArrayOfByte2, paramInt1, localObject21.length);
                                  paramInt2 = paramInt1 + localObject21.length;
                                }
                                paramInt1 = paramInt2;
                                if (localObject7 != null)
                                {
                                  paramInt1 = paramInt2;
                                  if (localObject7.length > 0)
                                  {
                                    System.arraycopy(localObject7, 0, paramArrayOfByte2, paramInt2, localObject7.length);
                                    paramInt1 = paramInt2 + localObject7.length;
                                    util.LOGI("nopicsig qimei len:" + localObject7.length, "");
                                  }
                                }
                                paramArrayOfByte1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
                                while (paramArrayOfByte1.hasNext())
                                {
                                  paramArrayOfByte3 = (Integer)paramArrayOfByte1.next();
                                  paramArrayOfLong = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte3)).get_buf();
                                  System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte2, paramInt1, paramArrayOfLong.length);
                                  paramInt2 = paramArrayOfLong.length;
                                  util.LOGI("Extra Tlv from user：0x" + paramArrayOfByte3);
                                  paramInt1 = paramInt2 + paramInt1;
                                }
                                long l2 = System.currentTimeMillis();
                                a.a().a(2, l2 - l1, paramLong4 - paramLong3, paramLong1 - paramLong2);
                                c.b(Thread.currentThread());
                                return a(a(paramArrayOfByte2, this.u, paramInt3), this.y, this.A, this.B);
                              }
                              for (;;)
                              {
                                try
                                {
                                  paramArrayOfByte1 = new tlv_t(1334);
                                  paramArrayOfByte2 = ProtocolDet.getLoginExtraData(this.a);
                                  if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0)) {
                                    continue;
                                  }
                                  paramArrayOfByte1.set_data(paramArrayOfByte2, paramArrayOfByte2.length);
                                  paramArrayOfByte1 = paramArrayOfByte1.get_buf();
                                  localObject24 = new byte[paramArrayOfByte1.length + 2];
                                  util.int16_to_buf((byte[])localObject24, 0, 1);
                                  System.arraycopy(paramArrayOfByte1, 0, localObject24, 2, paramArrayOfByte1.length);
                                  ((tlv_t)localObject20).set_data((byte[])localObject24, localObject24.length);
                                  paramArrayOfByte1 = ((tlv_t)localObject20).get_buf();
                                  paramInt1 += 1;
                                }
                                catch (Throwable paramArrayOfByte2)
                                {
                                  paramLong1 = 0L;
                                  paramArrayOfByte1 = null;
                                  break label1885;
                                  paramArrayOfByte1 = null;
                                  break;
                                }
                                try
                                {
                                  util.LOGI("nopicsig tlv536 " + paramArrayOfByte2.length, "" + this.x.f);
                                }
                                catch (Throwable paramArrayOfByte2)
                                {
                                  paramLong1 = 0L;
                                  break label1885;
                                }
                              }
                              try
                              {
                                paramLong1 = System.currentTimeMillis();
                              }
                              catch (Throwable paramArrayOfByte2)
                              {
                                paramLong1 = 0L;
                                break;
                              }
                              try
                              {
                                util.LOGI("nopicsig tlv536 cost:" + (paramLong1 - paramLong2), "");
                                paramInt2 = localObject9.length + localObject10.length + localObject11.length + localObject14.length + localObject12.length + localObject13.length + paramArrayOfLong.length + localObject26.length + localObject25.length + paramArrayOfByte5.length + localObject15.length + paramArrayOfByte4.length + paramArrayOfByte3.length + localObject16.length + localObject17.length + localObject18.length + paramList.length + localObject19.length + localObject1.length + arrayOfByte.length + localObject8.length + localObject2.length + localObject3.length + localObject4.length + localObject5.length + localObject6.length + localObject23.length + localObject22.length;
                                paramInt3 = paramInt2;
                                if (paramArrayOfByte1 != null) {
                                  paramInt3 = paramInt2 + paramArrayOfByte1.length;
                                }
                                paramInt2 = paramInt3;
                                if (localObject7 != null)
                                {
                                  paramInt2 = paramInt3;
                                  if (localObject7.length > 0) {
                                    paramInt2 = paramInt3 + localObject7.length;
                                  }
                                }
                                if (localObject21 == null) {
                                  break label2743;
                                }
                                paramInt3 = localObject21.length;
                                paramInt1 += 1;
                                paramInt2 += paramInt3;
                              }
                              catch (Throwable paramArrayOfByte2)
                              {
                                break;
                                break label1729;
                              }
                              paramArrayOfByte2 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
                              paramInt3 = paramInt1;
                              while (paramArrayOfByte2.hasNext())
                              {
                                localObject20 = (Integer)paramArrayOfByte2.next();
                                localObject24 = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(localObject20)).get_buf();
                                paramInt1 = localObject24.length;
                                util.LOGI("Extra Tlv from user：0x" + localObject20 + " body_len:" + localObject24.length, "");
                                paramInt3 += 1;
                                paramInt2 = paramInt1 + paramInt2;
                              }
                              util.LOGI("request_tgtgt_nopicsig req without DA1", "" + paramLong2);
                            }
                            label1885:
                            paramList = new byte[0];
                          }
                          paramArrayOfByte3 = new byte[0];
                        }
                        paramArrayOfByte5 = new byte[0];
                      }
                      localObject7 = new byte[0];
                    }
                    localObject6 = new byte[0];
                  }
                  localObject5 = new byte[0];
                }
                localObject4 = new byte[0];
              }
              localObject3 = new byte[0];
            }
            localObject2 = new byte[0];
          }
          localObject1 = new byte[0];
        }
        paramArrayOfByte4 = new byte[0];
      }
      paramArrayOfLong = new byte[0];
    }
  }
  
  public int a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, long paramLong4, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("start request_tgtgt_nopicsig", "" + paramLong2);
    int i = t.x;
    paramArrayOfByte2 = c(paramArrayOfByte2);
    if (paramArrayOfByte2 == null) {
      return -1014;
    }
    paramInt1 = 0;
    for (;;)
    {
      if ((this.y == oicq_request.EncryptionMethod.EM_ST) && ((this.B == null) || (this.B.length == 0) || (this.A == null) || (this.A.length == 0)))
      {
        this.y = oicq_request.EncryptionMethod.EM_ECDH;
        t.at.attr_api(2413503);
        util.LOGI("using wt st encrypt body but no st key", "" + paramLong2);
      }
      a(paramLong2, a(paramLong1, i, paramLong2, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong3, i, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfByte4, paramLong4, t.F, paramWUserSigInfo._domains, paramWUserSigInfo._source_type, paramWUserSigInfo), this.y);
      paramInt6 = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (paramInt6 != 0) {
        paramInt1 = paramInt6;
      }
      for (;;)
      {
        util.LOGI("end request_tgtgt_nopicsig ret " + paramInt1, "" + paramLong2);
        return paramInt1;
        paramInt6 = b();
        util.LOGI("retry num:" + paramInt1 + " ret:" + paramInt6, "" + paramLong2);
        if (paramInt6 != 180)
        {
          paramInt1 = paramInt6;
        }
        else
        {
          if (paramInt1 < 1) {
            break;
          }
          paramInt1 = paramInt6;
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.aa
 * JD-Core Version:    0.7.0.1
 */