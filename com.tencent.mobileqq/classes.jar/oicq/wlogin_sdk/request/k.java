package oicq.wlogin_sdk.request;

import android.content.Context;
import android.util.Log;
import com.tencent.loginsecsdk.ProtocolDet;
import com.tencent.secprotocol.t.ReportLogHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import oicq.wlogin_sdk.report.c;
import oicq.wlogin_sdk.report.event.b;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t1;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
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
import oicq.wlogin_sdk.tlv_type.tlv_t185;
import oicq.wlogin_sdk.tlv_type.tlv_t187;
import oicq.wlogin_sdk.tlv_type.tlv_t188;
import oicq.wlogin_sdk.tlv_type.tlv_t191;
import oicq.wlogin_sdk.tlv_type.tlv_t194;
import oicq.wlogin_sdk.tlv_type.tlv_t201;
import oicq.wlogin_sdk.tlv_type.tlv_t202;
import oicq.wlogin_sdk.tlv_type.tlv_t400;
import oicq.wlogin_sdk.tlv_type.tlv_t511;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t545;
import oicq.wlogin_sdk.tlv_type.tlv_t548;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class k
  extends oicq_request
{
  public static int K = 130;
  public static byte[] L = new byte[0];
  public static byte[] M = new byte[0];
  public static byte[] N = new byte[0];
  
  public k(t paramt, Context paramContext)
  {
    this.t = 2064;
    this.u = 9;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
    this.a = paramContext;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong4, int paramInt6, int paramInt7, int paramInt8, int paramInt9, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    int k = t.x;
    Object localObject1 = t.b(this.x.h);
    ((async_context)localObject1)._tgtgt_key = util.get_rand_16byte(t.C);
    byte[] arrayOfByte = ((async_context)localObject1)._tgtgt_key;
    Object localObject2 = ((async_context)localObject1)._t104;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new tlv_t104();
    }
    ReportLogHelper.startTimeTask();
    ReportLogHelper.report(7, 0);
    int i = 0;
    for (;;)
    {
      a(paramLong3, a(paramLong1, paramLong2, k, paramLong3, paramInt1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, arrayOfByte, paramInt2, null, null, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong4, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfByte4, ((tlv_t104)localObject1).get_data(), t.F, paramWUserSigInfo._domains, paramWUserSigInfo), this.y);
      int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (j != 0)
      {
        ReportLogHelper.report(7, 2);
        paramInt1 = j;
      }
      else
      {
        j = b();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("retry num:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" ret:");
        ((StringBuilder)localObject2).append(j);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramLong3);
        util.LOGI((String)localObject2, localStringBuilder.toString());
        if (j != 180)
        {
          ReportLogHelper.report(7, 3);
          paramInt1 = j;
        }
        else
        {
          if (i < 1) {
            break label310;
          }
          paramInt1 = j;
        }
      }
      ReportLogHelper.report(7, 1);
      ReportLogHelper.stopTimeTask();
      return paramInt1;
      label310:
      i += 1;
    }
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, long[] paramArrayOfLong, int paramInt4, long paramLong4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    ReportLogHelper.report(6, 0);
    int m = t.x;
    Object localObject2 = t.b(this.x.h)._t104;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new tlv_t104();
    }
    paramArrayOfByte2 = c(paramArrayOfByte2);
    if (paramArrayOfByte2 == null) {
      return -1014;
    }
    int k;
    for (int i = 0;; i = k)
    {
      localObject2 = a(paramLong1, paramLong2, m, paramLong3, paramInt1, paramArrayOfByte1, null, null, null, 0, paramArrayOfByte2, paramArrayOfByte3, paramInt2, paramInt3, paramArrayOfLong, paramInt4, paramLong4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfByte4, ((tlv_t104)localObject1).get_data(), t.F, paramWUserSigInfo._domains, paramWUserSigInfo);
      a(this.i, this.t, this.j, paramLong3, this.m, this.n, m, this.p, (byte[])localObject2);
      int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (j != 0)
      {
        ReportLogHelper.report(6, 2);
        paramInt1 = j;
      }
      else
      {
        j = b();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("retry num:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" ret:");
        ((StringBuilder)localObject2).append(j);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramLong3);
        util.LOGI((String)localObject2, localStringBuilder.toString());
        if (j != 180)
        {
          ReportLogHelper.report(6, 3);
          paramInt1 = j;
        }
        else
        {
          k = i + 1;
          if (i < 1) {
            continue;
          }
          paramInt1 = j;
        }
      }
      ReportLogHelper.report(6, 1);
      return paramInt1;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt3, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, int paramInt4, int paramInt5, long[] paramArrayOfLong, int paramInt6, long paramLong4, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, List<String> paramList, WUserSigInfo paramWUserSigInfo)
  {
    long l1 = paramLong3;
    Object localObject1 = paramArrayOfByte8;
    Object localObject5 = new int[37];
    Object tmp16_14 = localObject5;
    tmp16_14[0] = 24;
    Object tmp21_16 = tmp16_14;
    tmp21_16[1] = 1;
    Object tmp25_21 = tmp21_16;
    tmp25_21[2] = 262;
    Object tmp31_25 = tmp25_21;
    tmp31_25[3] = 278;
    Object tmp37_31 = tmp31_25;
    tmp37_31[4] = 256;
    Object tmp43_37 = tmp37_31;
    tmp43_37[5] = 263;
    Object tmp49_43 = tmp43_37;
    tmp49_43[6] = 264;
    Object tmp56_49 = tmp49_43;
    tmp56_49[7] = 260;
    Object tmp63_56 = tmp56_49;
    tmp63_56[8] = 322;
    Object tmp70_63 = tmp63_56;
    tmp70_63[9] = 274;
    Object tmp77_70 = tmp70_63;
    tmp77_70[10] = 324;
    Object tmp84_77 = tmp77_70;
    tmp84_77[11] = 325;
    Object tmp91_84 = tmp84_77;
    tmp91_84[12] = 327;
    Object tmp98_91 = tmp91_84;
    tmp98_91[13] = 358;
    Object tmp105_98 = tmp98_91;
    tmp105_98[14] = 362;
    Object tmp112_105 = tmp105_98;
    tmp112_105[15] = 340;
    Object tmp119_112 = tmp112_105;
    tmp119_112[16] = 321;
    Object tmp126_119 = tmp119_112;
    tmp126_119[17] = 8;
    Object tmp132_126 = tmp126_119;
    tmp132_126[18] = 1297;
    Object tmp139_132 = tmp132_126;
    tmp139_132[19] = 370;
    Object tmp146_139 = tmp139_132;
    tmp146_139[20] = 389;
    Object tmp153_146 = tmp146_139;
    tmp153_146[21] = 1024;
    Object tmp160_153 = tmp153_146;
    tmp160_153[22] = 391;
    Object tmp167_160 = tmp160_153;
    tmp167_160[23] = 392;
    Object tmp174_167 = tmp167_160;
    tmp174_167[24] = 404;
    Object tmp181_174 = tmp174_167;
    tmp181_174[25] = 401;
    Object tmp188_181 = tmp181_174;
    tmp188_181[26] = 513;
    Object tmp195_188 = tmp188_181;
    tmp195_188[27] = 514;
    Object tmp202_195 = tmp195_188;
    tmp202_195[28] = 375;
    Object tmp209_202 = tmp202_195;
    tmp209_202[29] = 1302;
    Object tmp216_209 = tmp209_202;
    tmp216_209[30] = 1313;
    Object tmp223_216 = tmp216_209;
    tmp223_216[31] = 1317;
    Object tmp230_223 = tmp223_216;
    tmp230_223[32] = 1321;
    Object tmp237_230 = tmp230_223;
    tmp237_230[33] = 792;
    Object tmp244_237 = tmp237_230;
    tmp244_237[34] = 1348;
    Object tmp251_244 = tmp244_237;
    tmp251_244[35] = 1349;
    Object tmp258_251 = tmp251_244;
    tmp258_251[36] = 1352;
    tmp258_251;
    Object localObject4 = t.b(this.x.h);
    ArrayList localArrayList = new ArrayList();
    String str = "";
    util.LOGI("tgtgt getRequestBody start", "");
    c.a(Thread.currentThread());
    long l8 = System.currentTimeMillis();
    Object localObject3 = new StringBuilder("tgtgt getRequestBody");
    ((StringBuilder)localObject3).append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
    int j = tmp16_14.length;
    long l4 = 0L;
    long l5 = l4;
    long l3 = l5;
    long l2 = l3;
    int k = 0;
    int i = 0;
    Object localObject6;
    for (;;)
    {
      byte[] arrayOfByte2 = paramArrayOfByte7;
      Object localObject10 = paramList;
      localObject6 = paramWUserSigInfo;
      if (k >= j) {
        break;
      }
      int m = tmp16_14[k];
      Object localObject8 = null;
      Object localObject7 = null;
      byte[] arrayOfByte1 = null;
      Object localObject9 = null;
      label940:
      label1839:
      Object localObject2;
      switch (m)
      {
      default: 
        localObject6 = localObject3;
      case 1352: 
      case 1349: 
      case 1348: 
      case 1317: 
      case 1313: 
      case 1302: 
      case 1297: 
      case 1024: 
      case 792: 
      case 514: 
      case 513: 
      case 404: 
      case 401: 
      case 392: 
      case 391: 
      case 389: 
      case 375: 
      case 370: 
      case 362: 
      case 358: 
      case 340: 
      case 327: 
      case 325: 
      case 324: 
      case 322: 
      case 321: 
      case 278: 
      case 274: 
      case 264: 
      case 263: 
      case 262: 
      case 260: 
        for (;;)
        {
          localObject3 = tmp16_14;
          tmp16_14 = arrayOfByte1;
          break label3732;
          if ((t.ao == null) || (t.ao.length <= 0)) {
            break;
          }
          localObject7 = new tlv_t548().get_tlv_548(t.ao);
          localObject6 = localObject9;
          if (localObject7 != null)
          {
            localObject6 = localObject9;
            if (localObject7.length > 0) {
              localObject6 = localObject7;
            }
          }
          localObject8 = new StringBuilder();
          ((StringBuilder)localObject8).append("t548_data ");
          if (localObject7 == null) {
            m = 0;
          } else {
            m = localObject7.length;
          }
          ((StringBuilder)localObject8).append(m);
          util.LOGI(((StringBuilder)localObject8).toString(), str);
          break label940;
          if ((t.U == null) || (t.U.length == 0)) {
            t.U = util.get_qimei(t.u);
          }
          if ((t.U != null) && (t.U.length > 0))
          {
            localObject6 = new tlv_t545().get_tlv_545(t.U);
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append(util.LOG_TAG_QIMEI);
            ((StringBuilder)localObject7).append("tgtgt qimei len =");
            ((StringBuilder)localObject7).append(t.U.length);
            localObject7 = ((StringBuilder)localObject7).toString();
            localObject8 = new StringBuilder();
            ((StringBuilder)localObject8).append(str);
            ((StringBuilder)localObject8).append(l1);
            util.LOGI((String)localObject7, ((StringBuilder)localObject8).toString());
            localObject8 = localObject1;
            localObject7 = localObject3;
            localObject1 = localObject6;
            localObject3 = localObject8;
            localObject6 = localObject7;
            break label3637;
          }
          b.a(new oicq.wlogin_sdk.report.event.a("wtlogin_qimei_error", "tgtgt_error", str).a(String.valueOf(paramLong3)));
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append(util.LOG_TAG_QIMEI);
          ((StringBuilder)localObject6).append("tgtgt qimei = null ");
          localObject6 = ((StringBuilder)localObject6).toString();
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append(str);
          ((StringBuilder)localObject7).append(l1);
          util.LOGI((String)localObject6, ((StringBuilder)localObject7).toString());
          break;
          l4 = System.currentTimeMillis();
          localObject1 = "6.0.0.2473".getBytes();
          localObject6 = new byte[t.B.length + 10 + 2 + localObject1.length + 4];
          util.int64_to_buf((byte[])localObject6, 0, (int)l1);
          util.int16_to_buf((byte[])localObject6, 4, t.B.length);
          System.arraycopy(t.B, 0, localObject6, 6, t.B.length);
          m = t.B.length + 6;
          util.int16_to_buf((byte[])localObject6, m, localObject1.length);
          m += 2;
          System.arraycopy(localObject1, 0, localObject6, m, localObject1.length);
          util.int32_to_buf((byte[])localObject6, m + localObject1.length, this.u);
          localObject1 = new tlv_t544().get_tlv_544(String.valueOf(paramLong3), "810_9", (byte[])localObject6);
          l5 = System.currentTimeMillis();
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("tgt 0x544 cost:");
          ((StringBuilder)localObject6).append(l5 - l4);
          localObject6 = ((StringBuilder)localObject6).toString();
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append(str);
          ((StringBuilder)localObject7).append(l1);
          util.LOGI((String)localObject6, ((StringBuilder)localObject7).toString());
          localObject6 = tmp16_14;
          tmp16_14 = localObject1;
          break label2138;
          localObject6 = localObject7;
          long l6 = l2;
          try
          {
            long l7 = System.currentTimeMillis();
            localObject6 = localObject7;
            l3 = l7;
            l6 = l2;
            localObject1 = new tlv_t(1334);
            localObject6 = localObject7;
            l3 = l7;
            l6 = l2;
            arrayOfByte1 = ProtocolDet.getLoginExtraData(this.a);
            if (arrayOfByte1 != null)
            {
              localObject6 = localObject7;
              l3 = l7;
              l6 = l2;
              if (arrayOfByte1.length > 0)
              {
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                localObject8 = new StringBuilder();
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                ((StringBuilder)localObject8).append("TGTGT 0x536:");
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                ((StringBuilder)localObject8).append(arrayOfByte1.length);
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                ((StringBuilder)localObject8).append(":");
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                ((StringBuilder)localObject8).append(util.buf_to_string(arrayOfByte1));
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                localObject8 = ((StringBuilder)localObject8).toString();
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                localObject9 = new StringBuilder();
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                ((StringBuilder)localObject9).append(l1);
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                ((StringBuilder)localObject9).append(str);
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                util.LOGI((String)localObject8, ((StringBuilder)localObject9).toString());
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                ((tlv_t)localObject1).set_data(arrayOfByte1, arrayOfByte1.length);
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                localObject1 = ((tlv_t)localObject1).get_buf();
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                localObject8 = new tlv_t(1317);
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                arrayOfByte1 = new byte[localObject1.length + 2];
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                util.int16_to_buf(arrayOfByte1, 0, 1);
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                System.arraycopy(localObject1, 0, arrayOfByte1, 2, localObject1.length);
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                ((tlv_t)localObject8).set_data(arrayOfByte1, arrayOfByte1.length);
                localObject6 = localObject7;
                l3 = l7;
                l6 = l2;
                localObject1 = ((tlv_t)localObject8).get_buf();
                break label1839;
              }
            }
            localObject6 = localObject7;
            l3 = l7;
            l6 = l2;
            localObject1 = new StringBuilder();
            localObject6 = localObject7;
            l3 = l7;
            l6 = l2;
            ((StringBuilder)localObject1).append(l1);
            localObject6 = localObject7;
            l3 = l7;
            l6 = l2;
            ((StringBuilder)localObject1).append(str);
            localObject6 = localObject7;
            l3 = l7;
            l6 = l2;
            util.LOGI("TGTGT 0x536:null", ((StringBuilder)localObject1).toString());
            localObject1 = localObject8;
            localObject6 = localObject1;
            l3 = l7;
            l6 = l2;
            l2 = System.currentTimeMillis();
            localObject6 = localObject1;
            l3 = l7;
            l6 = l2;
            localObject7 = new StringBuilder();
            localObject6 = localObject1;
            l3 = l7;
            l6 = l2;
            ((StringBuilder)localObject7).append("TGTGT 0x536 cost:");
            localObject6 = localObject1;
            l3 = l7;
            l6 = l2;
            ((StringBuilder)localObject7).append(l2 - l7);
            localObject6 = localObject1;
            l3 = l7;
            l6 = l2;
            util.LOGI(((StringBuilder)localObject7).toString(), str);
            l3 = l7;
          }
          catch (Throwable localThrowable)
          {
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append("TGTGT tlv536 error ");
            ((StringBuilder)localObject7).append(Log.getStackTraceString(localThrowable));
            localObject2 = ((StringBuilder)localObject7).toString();
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append(l1);
            ((StringBuilder)localObject7).append(str);
            util.LOGI((String)localObject2, ((StringBuilder)localObject7).toString());
            localObject2 = localObject6;
            l2 = l6;
          }
          localObject2 = new tlv_t(1313);
          localObject6 = new byte[6];
          util.int32_to_buf((byte[])localObject6, 0, t.aA);
          util.int16_to_buf((byte[])localObject6, 4, 0);
          ((tlv_t)localObject2).set_data((byte[])localObject6, 6);
          localObject2 = ((tlv_t)localObject2).get_buf();
          break label2130;
          localObject2 = new tlv_t(1302);
          localObject6 = new byte[4];
          util.int32_to_buf((byte[])localObject6, 0, paramWUserSigInfo._source_type);
          ((tlv_t)localObject2).set_data((byte[])localObject6, 4);
          for (localObject2 = ((tlv_t)localObject2).get_buf();; localObject2 = new tlv_t511().get_tlv_511((List)localObject10))
          {
            localObject6 = tmp16_14;
            tmp16_14 = localObject2;
            localObject7 = localObject3;
            localObject2 = paramArrayOfByte8;
            localObject3 = localObject6;
            localObject6 = localObject7;
            break label3732;
            if ((localObject10 == null) || (paramList.size() == 0)) {
              break;
            }
          }
          do
          {
            do
            {
              do
              {
                localObject2 = paramArrayOfByte8;
                localObject6 = localObject3;
                localObject3 = tmp16_14;
                tmp16_14 = arrayOfByte1;
                break label3732;
                localObject2 = tmp16_14;
                localObject2 = this.x.a(l1, paramLong1);
                if ((localObject2 == null) || (((WloginSigInfo)localObject2)._G == null)) {
                  break;
                }
              } while (((WloginSigInfo)localObject2)._G.length == 0);
              if (((WloginSigInfo)localObject2)._dpwd == null) {
                break;
              }
            } while (((WloginSigInfo)localObject2)._dpwd.length == 0);
            if (((WloginSigInfo)localObject2)._randseed == null) {
              break;
            }
          } while (((WloginSigInfo)localObject2)._randseed.length == 0);
          localObject6 = new tlv_t400();
          localObject7 = ((WloginSigInfo)localObject2)._G;
          localObject8 = t.B;
          arrayOfByte1 = ((WloginSigInfo)localObject2)._dpwd;
          localObject2 = ((WloginSigInfo)localObject2)._randseed;
          l1 = paramLong3;
          localObject2 = ((tlv_t400)localObject6).get_tlv_400((byte[])localObject7, l1, (byte[])localObject8, arrayOfByte1, paramLong1, paramLong2, (byte[])localObject2);
          break label3187;
          l1 = paramLong3;
          localObject2 = paramArrayOfByte8;
          break;
          localObject2 = localObject4;
          if ((((async_context)localObject2).tgtQR != null) && (((async_context)localObject2).tgtQR.length != 0))
          {
            localObject6 = new tlv_t(792);
            ((tlv_t)localObject6).set_data(((async_context)localObject2).tgtQR, ((async_context)localObject2).tgtQR.length);
            localObject6 = ((tlv_t)localObject6).get_buf();
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append("tgtQR len ");
            ((StringBuilder)localObject7).append(((async_context)localObject2).tgtQR.length);
            localObject2 = ((StringBuilder)localObject7).toString();
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append(str);
            l1 = paramLong3;
            ((StringBuilder)localObject7).append(l1);
            util.LOGI((String)localObject2, ((StringBuilder)localObject7).toString());
            localObject2 = localObject6;
          }
          else
          {
            l1 = paramLong3;
            break label3286;
            if ((t.S == null) || (t.S.length == 0)) {
              break label3286;
            }
            localObject2 = new tlv_t202().get_tlv_202(t.S, t.T);
            break label3187;
            localObject2 = L;
            if ((localObject2 == null) || (localObject2.length == 0)) {
              break label3286;
            }
            localObject2 = new tlv_t201().get_tlv_201(L, M, "qq".getBytes(), N);
            break label3187;
            if ((t.M == null) || (t.M.length == 0)) {
              break label3286;
            }
            localObject2 = new tlv_t194().get_tlv_194(t.M);
            break label3187;
            localObject2 = new tlv_t191().get_tlv_191(K);
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("request_TGTGT canWebVerify");
            ((StringBuilder)localObject6).append(K);
            util.LOGI(((StringBuilder)localObject6).toString(), str);
            break label3187;
            if ((t.P == null) || (t.P.length == 0)) {
              break label3286;
            }
            localObject2 = new tlv_t188().get_tlv_188(t.P);
            break label3187;
            if ((t.O == null) || (t.O.length == 0)) {
              break label3286;
            }
            localObject2 = new tlv_t187().get_tlv_187(t.O);
            break label3187;
            if (paramInt3 != 3) {
              break label3286;
            }
            localObject2 = new tlv_t185().get_tlv_185(1);
            break label3187;
            localObject2 = new tlv_t177().get_tlv_177(1619061003L, "6.0.0.2473");
            break label3187;
            if ((this.x.s == null) || (this.x.s.length == 0)) {
              break label3286;
            }
            localObject2 = new tlv_t172().get_tlv_172(this.x.s);
            break label3187;
            if ((paramArrayOfByte6 == null) || (paramArrayOfByte6.length == 0)) {
              break label3286;
            }
            localObject2 = new tlv_t16a().get_tlv_16a(paramArrayOfByte6);
            break label3187;
            if ((paramInt4 & 0x80) == 0) {
              break label3286;
            }
            localObject2 = new tlv_t166().get_tlv_166(t.y);
            break label3187;
            localObject2 = new tlv_t154().get_tlv_154(this.x.i);
            break label3187;
            localObject2 = new tlv_t147().get_tlv_147(paramLong1, t.H, t.I);
            break label3187;
            localObject2 = new tlv_t145().get_tlv_145(t.B);
            break label3187;
            localObject2 = new tlv_t109().get_tlv_109(t.P);
            localObject6 = new tlv_t52d().get_tlv_52d(this.a);
            localObject7 = new tlv_t124();
            localObject8 = util.get_os_type();
            arrayOfByte1 = util.get_os_version();
            m = t.E;
            localObject9 = t.D;
            localObject10 = t.G;
            localObject7 = ((tlv_t124)localObject7).get_tlv_124((byte[])localObject8, arrayOfByte1, m, (byte[])localObject9, new byte[0], (byte[])localObject10);
            localObject8 = new tlv_t128().get_tlv_128(t.V, t.W, t.X, t.aa, t.J, t.B, t.Q);
            arrayOfByte1 = new tlv_t16e().get_tlv_16e(t.J);
            localObject2 = new tlv_t144().get_tlv_144((byte[])localObject2, (byte[])localObject6, (byte[])localObject7, (byte[])localObject8, arrayOfByte1, ((async_context)localObject4)._tgtgt_key);
            break label3187;
            localObject2 = new tlv_t142().get_tlv_142(paramArrayOfByte9);
            break label3187;
            localObject2 = new tlv_t141().get_tlv_141(t.D, t.E, t.G);
            break label3187;
            localObject2 = new tlv_t116().get_tlv_116(paramInt4, paramInt5, paramArrayOfLong);
          }
          localObject6 = paramArrayOfByte8;
          localObject7 = localObject3;
          localObject3 = localObject6;
          localObject6 = localObject7;
          break label3637;
          if ((this.x.g != null) && (!util.check_uin_account(this.x.g).booleanValue()))
          {
            localObject6 = new tlv_t112().get_tlv_112(this.x.g.getBytes());
            localObject2 = localObject3;
            ((StringBuilder)localObject2).append(",0x404 = ");
            ((StringBuilder)localObject2).append(this.x.g);
          }
          else
          {
            localObject2 = paramArrayOfByte8;
            localObject6 = localObject3;
            continue;
            if ((arrayOfByte2 == null) || (arrayOfByte2.length == 0)) {
              break label3328;
            }
            localObject6 = new tlv_t108().get_tlv_108(arrayOfByte2);
          }
          break label3363;
          localObject2 = paramArrayOfByte8;
          localObject6 = localObject3;
          continue;
          localObject6 = new tlv_t107().get_tlv_107(paramInt7, paramInt8, paramInt9, paramInt10);
          l1 = paramLong3;
          localObject2 = paramArrayOfByte8;
          localObject7 = localObject3;
          localObject3 = localObject6;
          localObject6 = localObject7;
          break label3625;
          localObject2 = new tlv_t106();
          if ((paramArrayOfByte5 != null) && (paramArrayOfByte5.length > 0))
          {
            ((tlv_t106)localObject2).set_data(paramArrayOfByte5, paramArrayOfByte5.length);
            localObject7 = ((tlv_t106)localObject2).get_buf();
            l1 = paramLong3;
            localObject2 = paramArrayOfByte8;
            localObject6 = localObject3;
            localObject3 = localObject7;
            break label3625;
          }
          l1 = ((async_context)localObject4)._msalt;
          localObject7 = this.x.g.getBytes();
          m = t.W;
          localObject8 = t.B;
          localObject6 = localObject3;
          localObject3 = ((tlv_t106)localObject2).get_tlv_106(paramLong1, paramLong2, paramInt1, paramLong3, paramArrayOfByte2, paramArrayOfByte1, 1, paramArrayOfByte3, l1, (byte[])localObject7, paramArrayOfByte4, m, (byte[])localObject8, paramInt3);
          l1 = paramLong3;
          localObject2 = paramArrayOfByte8;
          break label3625;
          localObject8 = localObject2;
          localObject6 = localObject3;
          localObject7 = localObject4;
          if ((localObject8 != null) && (localObject8.length != 0))
          {
            localObject7 = new tlv_t104().get_tlv_104((byte[])localObject8);
            break label3613;
          }
          l1 = paramLong3;
          localObject2 = localObject8;
          localObject4 = localObject7;
        }
      case 256: 
        localObject7 = new tlv_t100().get_tlv_100(paramLong1, paramLong4, paramInt1, paramInt6);
        break;
      case 24: 
        localObject7 = new tlv_t18().get_tlv_18(paramLong1, paramInt1, paramLong3, paramInt2);
        l1 = paramLong3;
        localObject6 = localObject3;
        localObject3 = localObject7;
        localObject7 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject7;
        localObject7 = tmp16_14;
        tmp16_14 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject7;
        break;
      case 8: 
        label2130:
        label2138:
        label3187:
        localObject6 = tmp16_14;
        label3286:
        localObject7 = localObject3;
        label3328:
        label3363:
        label3625:
        label3637:
        tmp16_14 = new tlv_t8().get_tlv_8(0, t.v, 0);
        label3613:
        l1 = paramLong3;
        localObject3 = localObject6;
        localObject6 = localObject7;
        break;
      }
      localObject6 = new tlv_t1();
      l1 = paramLong3;
      localObject7 = ((tlv_t1)localObject6).get_tlv_1(l1, paramArrayOfByte1);
      localObject6 = localObject3;
      localObject3 = tmp16_14;
      tmp16_14 = localObject7;
      label3732:
      if (tmp16_14 != null)
      {
        localArrayList.add(tmp16_14);
        i += tmp16_14.length;
      }
      k += 1;
      tmp16_14 = localObject3;
      localObject3 = localObject6;
    }
    paramArrayOfByte1 = ((WUserSigInfo)localObject6).extraLoginTLVMap.keySet().iterator();
    while (paramArrayOfByte1.hasNext())
    {
      paramArrayOfByte2 = (Integer)paramArrayOfByte1.next();
      paramArrayOfByte3 = ((tlv_t)((WUserSigInfo)localObject6).extraLoginTLVMap.get(paramArrayOfByte2)).get_buf();
      localArrayList.add(paramArrayOfByte3);
      i += paramArrayOfByte3.length;
      paramArrayOfByte4 = new StringBuilder();
      paramArrayOfByte4.append("Extra Tlv from user：0x");
      paramArrayOfByte4.append(paramArrayOfByte2);
      paramArrayOfByte4.append(" len:");
      if (paramArrayOfByte3 != null) {
        paramInt1 = paramArrayOfByte3.length;
      } else {
        paramInt1 = 0;
      }
      paramArrayOfByte4.append(paramInt1);
      ((StringBuilder)localObject3).append(paramArrayOfByte4.toString());
    }
    util.LOGI(((StringBuilder)localObject3).toString());
    paramArrayOfByte1 = new byte[i];
    paramInt3 = localArrayList.size();
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < paramInt3)
    {
      paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, paramArrayOfByte2.length);
      paramInt2 += paramArrayOfByte2.length;
      paramInt1 += 1;
    }
    paramLong1 = System.currentTimeMillis();
    oicq.wlogin_sdk.report.a.a().a(1, paramLong1 - l8, l5 - l4, l2 - l3);
    c.b(Thread.currentThread());
    return b(paramArrayOfByte1, this.u, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.k
 * JD-Core Version:    0.7.0.1
 */