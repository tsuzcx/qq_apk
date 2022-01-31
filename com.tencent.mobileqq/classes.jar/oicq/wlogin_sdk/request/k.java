package oicq.wlogin_sdk.request;

import android.content.Context;
import android.util.Log;
import com.tencent.loginsecsdk.ProtocolDet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class k
  extends oicq_request
{
  public static int K = 0;
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
    int j = t.w;
    Object localObject = t.b(this.x.h);
    ((async_context)localObject)._tgtgt_key = util.get_rand_16byte(t.B);
    byte[] arrayOfByte = ((async_context)localObject)._tgtgt_key;
    localObject = ((async_context)localObject)._t104;
    if (localObject == null) {
      localObject = new tlv_t104();
    }
    for (;;)
    {
      int i = 0;
      for (;;)
      {
        a(paramLong3, a(paramLong1, paramLong2, j, paramLong3, paramInt1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, arrayOfByte, paramInt2, null, null, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong4, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfByte4, ((tlv_t104)localObject).get_data(), t.E, paramWUserSigInfo._domains, paramWUserSigInfo), this.y);
        int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
        if (k != 0) {
          return k;
        }
        k = b();
        util.LOGI("retry num:" + i + " ret:" + k, "" + paramLong3);
        if (k != 180) {
          return k;
        }
        if (i >= 1) {
          return k;
        }
        i += 1;
      }
    }
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, long[] paramArrayOfLong, int paramInt4, long paramLong4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    int m = t.w;
    tlv_t104 localtlv_t104 = t.b(this.x.h)._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    for (;;)
    {
      paramArrayOfByte2 = c(paramArrayOfByte2);
      int j;
      if (paramArrayOfByte2 == null)
      {
        j = -1014;
        return j;
      }
      int i = 0;
      for (;;)
      {
        byte[] arrayOfByte = a(paramLong1, paramLong2, m, paramLong3, paramInt1, paramArrayOfByte1, null, null, null, 0, paramArrayOfByte2, paramArrayOfByte3, paramInt2, paramInt3, paramArrayOfLong, paramInt4, paramLong4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfByte4, localtlv_t104.get_data(), t.E, paramWUserSigInfo._domains, paramWUserSigInfo);
        a(this.i, this.t, this.j, paramLong3, this.m, this.n, m, this.p, arrayOfByte);
        int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
        j = k;
        if (k != 0) {
          break;
        }
        j = b();
        util.LOGI("retry num:" + i + " ret:" + j, "" + paramLong3);
        if (j != 180) {
          return j;
        }
        if (i >= 1) {
          return j;
        }
        i += 1;
      }
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt3, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, int paramInt4, int paramInt5, long[] paramArrayOfLong, int paramInt6, long paramLong4, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, List<String> paramList, WUserSigInfo paramWUserSigInfo)
  {
    int[] arrayOfInt = new int[36];
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
    tmp243_236;
    async_context localasync_context = t.b(this.x.h);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k = arrayOfInt.length;
    int j = 0;
    int m;
    byte[] arrayOfByte1;
    Object localObject1;
    if (j < k)
    {
      m = arrayOfInt[j];
      arrayOfByte1 = null;
      switch (m)
      {
      default: 
        localObject1 = arrayOfByte1;
        label596:
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
      for (;;)
      {
        j += 1;
        break;
        localObject1 = new tlv_t18().get_tlv_18(paramLong1, paramInt1, paramLong3, paramInt2);
        break label596;
        localObject1 = new tlv_t1().get_tlv_1(paramLong3, paramArrayOfByte1);
        break label596;
        localObject1 = new tlv_t106();
        if ((paramArrayOfByte5 != null) && (paramArrayOfByte5.length > 0))
        {
          ((tlv_t106)localObject1).set_data(paramArrayOfByte5, paramArrayOfByte5.length);
          localObject1 = ((tlv_t106)localObject1).get_buf();
          break label596;
        }
        localObject1 = ((tlv_t106)localObject1).get_tlv_106(paramLong1, paramLong2, paramInt1, paramLong3, paramArrayOfByte2, paramArrayOfByte1, 1, paramArrayOfByte3, localasync_context._msalt, this.x.g.getBytes(), paramArrayOfByte4, t.V, t.A, paramInt3);
        break label596;
        localObject1 = new tlv_t116().get_tlv_116(paramInt4, paramInt5, paramArrayOfLong);
        break label596;
        localObject1 = new tlv_t100().get_tlv_100(paramLong1, paramLong4, paramInt1, paramInt6);
        break label596;
        localObject1 = new tlv_t107().get_tlv_107(paramInt7, paramInt8, paramInt9, paramInt10);
        break label596;
        localObject1 = arrayOfByte1;
        if (paramArrayOfByte7 == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (paramArrayOfByte7.length == 0) {
          break label596;
        }
        localObject1 = new tlv_t108().get_tlv_108(paramArrayOfByte7);
        break label596;
        localObject1 = arrayOfByte1;
        if (paramArrayOfByte8 == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (paramArrayOfByte8.length == 0) {
          break label596;
        }
        localObject1 = new tlv_t104().get_tlv_104(paramArrayOfByte8);
        break label596;
        localObject1 = new tlv_t142().get_tlv_142(paramArrayOfByte9);
        break label596;
        localObject1 = arrayOfByte1;
        if (this.x.g == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (util.check_uin_account(this.x.g).booleanValue()) {
          break label596;
        }
        localObject1 = new tlv_t112().get_tlv_112(this.x.g.getBytes());
        break label596;
        localObject1 = new tlv_t109().get_tlv_109(t.O);
        arrayOfByte1 = new tlv_t52d().get_tlv_52d(this.a);
        Object localObject3 = new tlv_t124();
        byte[] arrayOfByte2 = util.get_os_type();
        byte[] arrayOfByte3 = util.get_os_version();
        m = t.D;
        byte[] arrayOfByte4 = t.C;
        byte[] arrayOfByte5 = t.F;
        localObject3 = ((tlv_t124)localObject3).get_tlv_124(arrayOfByte2, arrayOfByte3, m, arrayOfByte4, new byte[0], arrayOfByte5);
        arrayOfByte2 = new tlv_t128().get_tlv_128(t.U, t.V, t.W, t.Z, t.I, t.A, t.P);
        arrayOfByte3 = new tlv_t16e().get_tlv_16e(t.I);
        localObject1 = new tlv_t144().get_tlv_144((byte[])localObject1, arrayOfByte1, (byte[])localObject3, arrayOfByte2, arrayOfByte3, localasync_context._tgtgt_key);
        break label596;
        localObject1 = new tlv_t145().get_tlv_145(t.A);
        break label596;
        localObject1 = new tlv_t147().get_tlv_147(paramLong1, t.G, t.H);
        break label596;
        localObject1 = arrayOfByte1;
        if ((paramInt4 & 0x80) == 0) {
          break label596;
        }
        localObject1 = new tlv_t166().get_tlv_166(t.x);
        break label596;
        localObject1 = arrayOfByte1;
        if (paramArrayOfByte6 == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (paramArrayOfByte6.length == 0) {
          break label596;
        }
        localObject1 = new tlv_t16a().get_tlv_16a(paramArrayOfByte6);
        break label596;
        localObject1 = new tlv_t154().get_tlv_154(this.x.i);
        break label596;
        localObject1 = new tlv_t141().get_tlv_141(t.C, t.D, t.F);
        break label596;
        localObject1 = new tlv_t8().get_tlv_8(0, t.u, 0);
        break label596;
        localObject1 = arrayOfByte1;
        if (paramList == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (paramList.size() == 0) {
          break label596;
        }
        localObject1 = new tlv_t511().get_tlv_511(paramList);
        break label596;
        localObject1 = arrayOfByte1;
        if (this.x.r == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (this.x.r.length == 0) {
          break label596;
        }
        localObject1 = new tlv_t172().get_tlv_172(this.x.r);
        break label596;
        localObject1 = arrayOfByte1;
        if (paramInt3 != 3) {
          break label596;
        }
        localObject1 = new tlv_t185().get_tlv_185(1);
        break label596;
        localObject3 = this.x.a(paramLong3, paramLong1);
        localObject1 = arrayOfByte1;
        if (localObject3 == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (((WloginSigInfo)localObject3)._G == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (((WloginSigInfo)localObject3)._G.length == 0) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (((WloginSigInfo)localObject3)._dpwd == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (((WloginSigInfo)localObject3)._dpwd.length == 0) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (((WloginSigInfo)localObject3)._randseed == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (((WloginSigInfo)localObject3)._randseed.length == 0) {
          break label596;
        }
        localObject1 = new tlv_t400().get_tlv_400(((WloginSigInfo)localObject3)._G, paramLong3, t.A, ((WloginSigInfo)localObject3)._dpwd, paramLong1, paramLong2, ((WloginSigInfo)localObject3)._randseed);
        break label596;
        localObject1 = arrayOfByte1;
        if (t.N == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (t.N.length == 0) {
          break label596;
        }
        localObject1 = new tlv_t187().get_tlv_187(t.N);
        break label596;
        localObject1 = arrayOfByte1;
        if (t.O == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (t.O.length == 0) {
          break label596;
        }
        localObject1 = new tlv_t188().get_tlv_188(t.O);
        break label596;
        localObject1 = arrayOfByte1;
        if (t.L == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (t.L.length == 0) {
          break label596;
        }
        localObject1 = new tlv_t194().get_tlv_194(t.L);
        break label596;
        localObject1 = new tlv_t191().get_tlv_191(K);
        break label596;
        localObject1 = arrayOfByte1;
        if (L == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (L.length == 0) {
          break label596;
        }
        localObject1 = new tlv_t201().get_tlv_201(L, M, "qq".getBytes(), N);
        break label596;
        localObject1 = arrayOfByte1;
        if (t.R == null) {
          break label596;
        }
        localObject1 = arrayOfByte1;
        if (t.R.length == 0) {
          break label596;
        }
        localObject1 = new tlv_t202().get_tlv_202(t.R, t.S);
        break label596;
        localObject1 = new tlv_t177().get_tlv_177(1577331209L, "6.0.0.2425");
        break label596;
        localObject1 = new tlv_t(1302);
        arrayOfByte1 = new byte[4];
        util.int32_to_buf(arrayOfByte1, 0, paramWUserSigInfo._source_type);
        ((tlv_t)localObject1).set_data(arrayOfByte1, 4);
        localObject1 = ((tlv_t)localObject1).get_buf();
        break label596;
        localObject1 = new tlv_t(1313);
        arrayOfByte1 = new byte[6];
        util.int32_to_buf(arrayOfByte1, 0, t.ax);
        util.int16_to_buf(arrayOfByte1, 4, 0);
        ((tlv_t)localObject1).set_data(arrayOfByte1, 6);
        localObject1 = ((tlv_t)localObject1).get_buf();
        break label596;
        try
        {
          localObject1 = new tlv_t(1334);
          localObject3 = ProtocolDet.getLoginExtraData(this.a);
          if ((localObject3 != null) && (localObject3.length > 0))
          {
            util.LOGI("TGTGT 0x536:" + localObject3.length + ":" + util.buf_to_string((byte[])localObject3), paramLong3 + "");
            ((tlv_t)localObject1).set_data((byte[])localObject3, localObject3.length);
            localObject1 = ((tlv_t)localObject1).get_buf();
            localObject3 = new tlv_t(1317);
            arrayOfByte2 = new byte[localObject1.length + 2];
            util.int16_to_buf(arrayOfByte2, 0, 1);
            System.arraycopy(localObject1, 0, arrayOfByte2, 2, localObject1.length);
            ((tlv_t)localObject3).set_data(arrayOfByte2, arrayOfByte2.length);
            localObject1 = ((tlv_t)localObject3).get_buf();
            break label596;
          }
          util.LOGI("TGTGT 0x536:null", paramLong3 + "");
          localObject1 = arrayOfByte1;
        }
        catch (Throwable localThrowable)
        {
          util.LOGI("TGTGT tlv536 error " + Log.getStackTraceString(localThrowable), paramLong3 + "");
          localObject2 = arrayOfByte1;
        }
      }
      break label596;
      Object localObject2 = arrayOfByte1;
      if (localasync_context.tgtQR == null) {
        break label596;
      }
      localObject2 = arrayOfByte1;
      if (localasync_context.tgtQR.length == 0) {
        break label596;
      }
      localObject2 = new tlv_t(792);
      ((tlv_t)localObject2).set_data(localasync_context.tgtQR, localasync_context.tgtQR.length);
      localObject2 = ((tlv_t)localObject2).get_buf();
      util.LOGI("tgtQR len " + localasync_context.tgtQR.length, "" + paramLong3);
      break label596;
      localObject2 = new tlv_t544().get_tlv_544(this.a, paramLong3, t.A.length, t.A, "6.0.0.2425".length(), "6.0.0.2425", this.u);
      util.LOGI("tgt 0x544 ---------", "" + paramLong3);
      break label596;
      if ((t.T == null) || (t.T.length == 0)) {
        t.T = util.get_qimei(t.t);
      }
      localObject2 = arrayOfByte1;
      if (t.T == null) {
        break label596;
      }
      localObject2 = arrayOfByte1;
      if (t.T.length <= 0) {
        break label596;
      }
      localObject2 = new tlv_t545().get_tlv_545(t.T);
      util.LOGI("tgtgt qimei len " + t.T.length, "" + paramLong3);
      break label596;
      paramArrayOfByte1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
      while (paramArrayOfByte1.hasNext())
      {
        paramArrayOfByte2 = (Integer)paramArrayOfByte1.next();
        paramArrayOfByte3 = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte2)).get_buf();
        localArrayList.add(paramArrayOfByte3);
        i += paramArrayOfByte3.length;
        util.LOGI("Extra Tlv from user：0x" + paramArrayOfByte2);
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
      return b(paramArrayOfByte1, this.u, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.k
 * JD-Core Version:    0.7.0.1
 */