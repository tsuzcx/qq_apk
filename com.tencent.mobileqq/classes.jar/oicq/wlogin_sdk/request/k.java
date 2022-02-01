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
import oicq.wlogin_sdk.report.a;
import oicq.wlogin_sdk.report.c;
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
    Object localObject = t.b(this.x.h);
    ((async_context)localObject)._tgtgt_key = util.get_rand_16byte(t.C);
    byte[] arrayOfByte = ((async_context)localObject)._tgtgt_key;
    localObject = ((async_context)localObject)._t104;
    if (localObject == null) {
      localObject = new tlv_t104();
    }
    for (;;)
    {
      ReportLogHelper.startTimeTask();
      ReportLogHelper.report(7, 0);
      int i = 0;
      for (;;)
      {
        a(paramLong3, a(paramLong1, paramLong2, k, paramLong3, paramInt1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, arrayOfByte, paramInt2, null, null, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong4, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfByte4, ((tlv_t104)localObject).get_data(), t.F, paramWUserSigInfo._domains, paramWUserSigInfo), this.y);
        int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
        if (j != 0)
        {
          ReportLogHelper.report(7, 2);
          paramInt1 = j;
        }
        for (;;)
        {
          ReportLogHelper.report(7, 1);
          ReportLogHelper.stopTimeTask();
          return paramInt1;
          j = b();
          util.LOGI("retry num:" + i + " ret:" + j, "" + paramLong3);
          if (j != 180)
          {
            ReportLogHelper.report(7, 3);
            paramInt1 = j;
          }
          else
          {
            if (i < 1) {
              break;
            }
            paramInt1 = j;
          }
        }
        i += 1;
      }
    }
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, long[] paramArrayOfLong, int paramInt4, long paramLong4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    ReportLogHelper.report(6, 0);
    int k = t.x;
    tlv_t104 localtlv_t104 = t.b(this.x.h)._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    for (;;)
    {
      paramArrayOfByte2 = c(paramArrayOfByte2);
      if (paramArrayOfByte2 == null) {
        return -1014;
      }
      int i = 0;
      for (;;)
      {
        byte[] arrayOfByte = a(paramLong1, paramLong2, k, paramLong3, paramInt1, paramArrayOfByte1, null, null, null, 0, paramArrayOfByte2, paramArrayOfByte3, paramInt2, paramInt3, paramArrayOfLong, paramInt4, paramLong4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfByte4, localtlv_t104.get_data(), t.F, paramWUserSigInfo._domains, paramWUserSigInfo);
        a(this.i, this.t, this.j, paramLong3, this.m, this.n, k, this.p, arrayOfByte);
        int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
        if (j != 0)
        {
          ReportLogHelper.report(6, 2);
          paramInt1 = j;
        }
        for (;;)
        {
          ReportLogHelper.report(6, 1);
          return paramInt1;
          j = b();
          util.LOGI("retry num:" + i + " ret:" + j, "" + paramLong3);
          if (j != 180)
          {
            ReportLogHelper.report(6, 3);
            paramInt1 = j;
          }
          else
          {
            if (i < 1) {
              break;
            }
            paramInt1 = j;
          }
        }
        i += 1;
      }
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt3, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, int paramInt4, int paramInt5, long[] paramArrayOfLong, int paramInt6, long paramLong4, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, List<String> paramList, WUserSigInfo paramWUserSigInfo)
  {
    int[] arrayOfInt = new int[37];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 24;
    int[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 1;
    int[] tmp17_13 = tmp13_8;
    tmp17_13[2] = 262;
    int[] tmp23_17 = tmp17_13;
    tmp23_17[3] = 278;
    int[] tmp29_23 = tmp23_17;
    tmp29_23[4] = 256;
    int[] tmp35_29 = tmp29_23;
    tmp35_29[5] = 263;
    int[] tmp41_35 = tmp35_29;
    tmp41_35[6] = 264;
    int[] tmp48_41 = tmp41_35;
    tmp48_41[7] = 260;
    int[] tmp55_48 = tmp48_41;
    tmp55_48[8] = 322;
    int[] tmp62_55 = tmp55_48;
    tmp62_55[9] = 274;
    int[] tmp69_62 = tmp62_55;
    tmp69_62[10] = 324;
    int[] tmp76_69 = tmp69_62;
    tmp76_69[11] = 325;
    int[] tmp83_76 = tmp76_69;
    tmp83_76[12] = 327;
    int[] tmp90_83 = tmp83_76;
    tmp90_83[13] = 358;
    int[] tmp97_90 = tmp90_83;
    tmp97_90[14] = 362;
    int[] tmp104_97 = tmp97_90;
    tmp104_97[15] = 340;
    int[] tmp111_104 = tmp104_97;
    tmp111_104[16] = 321;
    int[] tmp118_111 = tmp111_104;
    tmp118_111[17] = 8;
    int[] tmp124_118 = tmp118_111;
    tmp124_118[18] = 1297;
    int[] tmp131_124 = tmp124_118;
    tmp131_124[19] = 370;
    int[] tmp138_131 = tmp131_124;
    tmp138_131[20] = 389;
    int[] tmp145_138 = tmp138_131;
    tmp145_138[21] = 1024;
    int[] tmp152_145 = tmp145_138;
    tmp152_145[22] = 391;
    int[] tmp159_152 = tmp152_145;
    tmp159_152[23] = 392;
    int[] tmp166_159 = tmp159_152;
    tmp166_159[24] = 404;
    int[] tmp173_166 = tmp166_159;
    tmp173_166[25] = 401;
    int[] tmp180_173 = tmp173_166;
    tmp180_173[26] = 513;
    int[] tmp187_180 = tmp180_173;
    tmp187_180[27] = 514;
    int[] tmp194_187 = tmp187_180;
    tmp194_187[28] = 375;
    int[] tmp201_194 = tmp194_187;
    tmp201_194[29] = 1302;
    int[] tmp208_201 = tmp201_194;
    tmp208_201[30] = 1313;
    int[] tmp215_208 = tmp208_201;
    tmp215_208[31] = 1317;
    int[] tmp222_215 = tmp215_208;
    tmp222_215[32] = 1321;
    int[] tmp229_222 = tmp222_215;
    tmp229_222[33] = 792;
    int[] tmp236_229 = tmp229_222;
    tmp236_229[34] = 1348;
    int[] tmp243_236 = tmp236_229;
    tmp243_236[35] = 1349;
    int[] tmp250_243 = tmp243_236;
    tmp250_243[36] = 1352;
    tmp250_243;
    async_context localasync_context = t.b(this.x.h);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    util.LOGI("tgtgt getRequestBody start", "");
    c.a(Thread.currentThread());
    long l6 = System.currentTimeMillis();
    long l1 = 0L;
    long l2 = 0L;
    long l4 = 0L;
    long l3 = 0L;
    int m = tmp8_6.length;
    int j = 0;
    int k;
    byte[] arrayOfByte1;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    label648:
    long l5;
    if (j < m)
    {
      k = tmp8_6[j];
      arrayOfByte1 = null;
      localObject2 = null;
      localObject3 = null;
      switch (k)
      {
      default: 
        localObject1 = localObject3;
        l5 = l2;
        l2 = l1;
        l1 = l5;
        label660:
        if (localObject1 != null)
        {
          localArrayList.add(localObject1);
          i = localObject1.length + i;
        }
        break;
      }
    }
    for (;;)
    {
      j += 1;
      l5 = l2;
      l2 = l1;
      l1 = l5;
      break;
      localObject1 = new tlv_t18().get_tlv_18(paramLong1, paramInt1, paramLong3, paramInt2);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t1().get_tlv_1(paramLong3, paramArrayOfByte1);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t106();
      if ((paramArrayOfByte5 != null) && (paramArrayOfByte5.length > 0))
      {
        ((tlv_t106)localObject1).set_data(paramArrayOfByte5, paramArrayOfByte5.length);
        localObject1 = ((tlv_t106)localObject1).get_buf();
        l5 = l1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = ((tlv_t106)localObject1).get_tlv_106(paramLong1, paramLong2, paramInt1, paramLong3, paramArrayOfByte2, paramArrayOfByte1, 1, paramArrayOfByte3, localasync_context._msalt, this.x.g.getBytes(), paramArrayOfByte4, t.W, t.B, paramInt3);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t116().get_tlv_116(paramInt4, paramInt5, paramArrayOfLong);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t100().get_tlv_100(paramLong1, paramLong4, paramInt1, paramInt6);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t107().get_tlv_107(paramInt7, paramInt8, paramInt9, paramInt10);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (paramArrayOfByte7 == null) {
        break label648;
      }
      if (paramArrayOfByte7.length == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = new tlv_t108().get_tlv_108(paramArrayOfByte7);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (paramArrayOfByte8 == null) {
        break label648;
      }
      if (paramArrayOfByte8.length == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = new tlv_t104().get_tlv_104(paramArrayOfByte8);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t142().get_tlv_142(paramArrayOfByte9);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (this.x.g == null) {
        break label648;
      }
      if (util.check_uin_account(this.x.g).booleanValue())
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = new tlv_t112().get_tlv_112(this.x.g.getBytes());
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t109().get_tlv_109(t.P);
      localObject2 = new tlv_t52d().get_tlv_52d(this.a);
      localObject3 = new tlv_t124();
      arrayOfByte1 = util.get_os_type();
      byte[] arrayOfByte2 = util.get_os_version();
      k = t.E;
      byte[] arrayOfByte3 = t.D;
      byte[] arrayOfByte4 = t.G;
      localObject3 = ((tlv_t124)localObject3).get_tlv_124(arrayOfByte1, arrayOfByte2, k, arrayOfByte3, new byte[0], arrayOfByte4);
      arrayOfByte1 = new tlv_t128().get_tlv_128(t.V, t.W, t.X, t.aa, t.J, t.B, t.Q);
      arrayOfByte2 = new tlv_t16e().get_tlv_16e(t.J);
      localObject1 = new tlv_t144().get_tlv_144((byte[])localObject1, (byte[])localObject2, (byte[])localObject3, arrayOfByte1, arrayOfByte2, localasync_context._tgtgt_key);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t145().get_tlv_145(t.B);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t147().get_tlv_147(paramLong1, t.H, t.I);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      if ((paramInt4 & 0x80) == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = new tlv_t166().get_tlv_166(t.y);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (paramArrayOfByte6 == null) {
        break label648;
      }
      if (paramArrayOfByte6.length == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = new tlv_t16a().get_tlv_16a(paramArrayOfByte6);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t154().get_tlv_154(this.x.i);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t141().get_tlv_141(t.D, t.E, t.G);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t8().get_tlv_8(0, t.v, 0);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (paramList == null) {
        break label648;
      }
      if (paramList.size() == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = new tlv_t511().get_tlv_511(paramList);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (this.x.s == null) {
        break label648;
      }
      if (this.x.s.length == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = new tlv_t172().get_tlv_172(this.x.s);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (paramInt3 != 3) {
        break label648;
      }
      localObject1 = new tlv_t185().get_tlv_185(1);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject2 = this.x.a(paramLong3, paramLong1);
      localObject1 = localObject3;
      if (localObject2 == null) {
        break label648;
      }
      localObject1 = localObject3;
      if (((WloginSigInfo)localObject2)._G == null) {
        break label648;
      }
      if (((WloginSigInfo)localObject2)._G.length == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = localObject3;
      if (((WloginSigInfo)localObject2)._dpwd == null) {
        break label648;
      }
      if (((WloginSigInfo)localObject2)._dpwd.length == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = localObject3;
      if (((WloginSigInfo)localObject2)._randseed == null) {
        break label648;
      }
      if (((WloginSigInfo)localObject2)._randseed.length == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = new tlv_t400().get_tlv_400(((WloginSigInfo)localObject2)._G, paramLong3, t.B, ((WloginSigInfo)localObject2)._dpwd, paramLong1, paramLong2, ((WloginSigInfo)localObject2)._randseed);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (t.O == null) {
        break label648;
      }
      if (t.O.length == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = new tlv_t187().get_tlv_187(t.O);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (t.P == null) {
        break label648;
      }
      if (t.P.length == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = new tlv_t188().get_tlv_188(t.P);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (t.M == null) {
        break label648;
      }
      if (t.M.length == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = new tlv_t194().get_tlv_194(t.M);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t191().get_tlv_191(K);
      util.LOGI("request_TGTGT canWebVerify" + K, "");
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (L == null) {
        break label648;
      }
      if (L.length == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = new tlv_t201().get_tlv_201(L, M, "qq".getBytes(), N);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (t.S == null) {
        break label648;
      }
      if (t.S.length == 0)
      {
        l5 = l1;
        localObject1 = arrayOfByte1;
        l1 = l2;
        l2 = l5;
        break label660;
      }
      localObject1 = new tlv_t202().get_tlv_202(t.S, t.T);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t177().get_tlv_177(1601002028L, "6.0.0.2438");
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t(1302);
      localObject2 = new byte[4];
      util.int32_to_buf((byte[])localObject2, 0, paramWUserSigInfo._source_type);
      ((tlv_t)localObject1).set_data((byte[])localObject2, 4);
      localObject1 = ((tlv_t)localObject1).get_buf();
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = new tlv_t(1313);
      localObject2 = new byte[6];
      util.int32_to_buf((byte[])localObject2, 0, t.aA);
      util.int16_to_buf((byte[])localObject2, 4, 0);
      ((tlv_t)localObject1).set_data((byte[])localObject2, 6);
      localObject1 = ((tlv_t)localObject1).get_buf();
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      for (;;)
      {
        for (;;)
        {
          try
          {
            l5 = System.currentTimeMillis();
            l4 = l5;
          }
          catch (Throwable localThrowable1)
          {
            localObject1 = null;
          }
          try
          {
            localObject1 = new tlv_t(1334);
            localObject2 = ProtocolDet.getLoginExtraData(this.a);
            if ((localObject2 != null) && (localObject2.length > 0))
            {
              util.LOGI("TGTGT 0x536:" + localObject2.length + ":" + util.buf_to_string((byte[])localObject2), paramLong3 + "");
              ((tlv_t)localObject1).set_data((byte[])localObject2, localObject2.length);
              localObject1 = ((tlv_t)localObject1).get_buf();
              localObject2 = new tlv_t(1317);
              localObject3 = new byte[localObject1.length + 2];
              util.int16_to_buf((byte[])localObject3, 0, 1);
              System.arraycopy(localObject1, 0, localObject3, 2, localObject1.length);
              ((tlv_t)localObject2).set_data((byte[])localObject3, localObject3.length);
              localObject1 = ((tlv_t)localObject2).get_buf();
            }
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              StringBuilder localStringBuilder;
              localObject1 = null;
            }
          }
          try
          {
            l5 = System.currentTimeMillis();
            l3 = l5;
          }
          catch (Throwable localThrowable3)
          {
            break label2879;
          }
          try
          {
            util.LOGI("TGTGT 0x536 cost:" + (l3 - l4), "");
            l5 = l1;
            l1 = l2;
            l2 = l5;
          }
          catch (Throwable localThrowable4)
          {
            break label2879;
          }
        }
        util.LOGI("TGTGT 0x536:null", paramLong3 + "");
        localObject1 = null;
      }
      label2879:
      util.LOGI("TGTGT tlv536 error " + Log.getStackTraceString(localThrowable1), paramLong3 + "");
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (localasync_context.tgtQR == null) {
        break label648;
      }
      localObject1 = localObject3;
      if (localasync_context.tgtQR.length == 0) {
        break label648;
      }
      localObject1 = new tlv_t(792);
      ((tlv_t)localObject1).set_data(localasync_context.tgtQR, localasync_context.tgtQR.length);
      localObject1 = ((tlv_t)localObject1).get_buf();
      util.LOGI("tgtQR len " + localasync_context.tgtQR.length, "" + paramLong3);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      l2 = System.currentTimeMillis();
      localObject1 = new tlv_t544().get_tlv_544(this.a, paramLong3, t.B.length, t.B, "6.0.0.2438".length(), "6.0.0.2438", this.u);
      l1 = System.currentTimeMillis();
      util.LOGI("tgt 0x544 cost:" + (l1 - l2), "" + paramLong3);
      break label660;
      if ((t.U == null) || (t.U.length == 0)) {
        t.U = util.get_qimei(t.u);
      }
      localObject1 = localObject3;
      if (t.U == null) {
        break label648;
      }
      localObject1 = localObject3;
      if (t.U.length <= 0) {
        break label648;
      }
      localObject1 = new tlv_t545().get_tlv_545(t.U);
      util.LOGI("tgtgt qimei len " + t.U.length, "" + paramLong3);
      l5 = l1;
      l1 = l2;
      l2 = l5;
      break label660;
      localObject1 = localObject3;
      if (t.ao == null) {
        break label648;
      }
      localObject1 = localObject3;
      if (t.ao.length <= 0) {
        break label648;
      }
      localObject3 = new tlv_t548().get_tlv_548(t.ao);
      localObject1 = localThrowable1;
      if (localObject3 != null)
      {
        localObject1 = localThrowable1;
        if (localObject3.length > 0) {
          localObject1 = localObject3;
        }
      }
      localStringBuilder = new StringBuilder().append("t548_data ");
      if (localObject3 == null) {}
      for (k = 0;; k = localObject3.length)
      {
        util.LOGI(k, "");
        break;
      }
      paramArrayOfByte1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
      if (paramArrayOfByte1.hasNext())
      {
        paramArrayOfByte3 = (Integer)paramArrayOfByte1.next();
        paramArrayOfByte2 = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte3)).get_buf();
        localArrayList.add(paramArrayOfByte2);
        i += paramArrayOfByte2.length;
        paramArrayOfByte3 = new StringBuilder().append("Extra Tlv from user：0x").append(paramArrayOfByte3).append(" len:");
        if (paramArrayOfByte2 != null) {}
        for (paramInt1 = paramArrayOfByte2.length;; paramInt1 = 0)
        {
          util.LOGI(paramInt1);
          break;
        }
      }
      paramArrayOfByte1 = new byte[i];
      paramInt3 = localArrayList.size();
      paramInt2 = 0;
      paramInt1 = 0;
      while (paramInt1 < paramInt3)
      {
        paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, paramArrayOfByte2.length);
        paramInt2 += paramArrayOfByte2.length;
        paramInt1 += 1;
      }
      paramLong1 = System.currentTimeMillis();
      a.a().a(1, paramLong1 - l6, l2 - l1, l3 - l4);
      c.b(Thread.currentThread());
      return b(paramArrayOfByte1, this.u, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.k
 * JD-Core Version:    0.7.0.1
 */