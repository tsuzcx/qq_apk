package oicq.wlogin_sdk.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.loginsecsdk.ProtocolDet;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.report_t3;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t102;
import oicq.wlogin_sdk.tlv_type.tlv_t103;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t10a;
import oicq.wlogin_sdk.tlv_type.tlv_t10b;
import oicq.wlogin_sdk.tlv_type.tlv_t10c;
import oicq.wlogin_sdk.tlv_type.tlv_t10d;
import oicq.wlogin_sdk.tlv_type.tlv_t10e;
import oicq.wlogin_sdk.tlv_type.tlv_t113;
import oicq.wlogin_sdk.tlv_type.tlv_t114;
import oicq.wlogin_sdk.tlv_type.tlv_t118;
import oicq.wlogin_sdk.tlv_type.tlv_t119;
import oicq.wlogin_sdk.tlv_type.tlv_t11a;
import oicq.wlogin_sdk.tlv_type.tlv_t11c;
import oicq.wlogin_sdk.tlv_type.tlv_t11d;
import oicq.wlogin_sdk.tlv_type.tlv_t11f;
import oicq.wlogin_sdk.tlv_type.tlv_t120;
import oicq.wlogin_sdk.tlv_type.tlv_t121;
import oicq.wlogin_sdk.tlv_type.tlv_t125;
import oicq.wlogin_sdk.tlv_type.tlv_t126;
import oicq.wlogin_sdk.tlv_type.tlv_t130;
import oicq.wlogin_sdk.tlv_type.tlv_t132;
import oicq.wlogin_sdk.tlv_type.tlv_t136;
import oicq.wlogin_sdk.tlv_type.tlv_t138;
import oicq.wlogin_sdk.tlv_type.tlv_t143;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t146;
import oicq.wlogin_sdk.tlv_type.tlv_t149;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tlv_type.tlv_t161;
import oicq.wlogin_sdk.tlv_type.tlv_t164;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t167;
import oicq.wlogin_sdk.tlv_type.tlv_t169;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t16d;
import oicq.wlogin_sdk.tlv_type.tlv_t171;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tlv_type.tlv_t173;
import oicq.wlogin_sdk.tlv_type.tlv_t174;
import oicq.wlogin_sdk.tlv_type.tlv_t178;
import oicq.wlogin_sdk.tlv_type.tlv_t179;
import oicq.wlogin_sdk.tlv_type.tlv_t17d;
import oicq.wlogin_sdk.tlv_type.tlv_t17e;
import oicq.wlogin_sdk.tlv_type.tlv_t17f;
import oicq.wlogin_sdk.tlv_type.tlv_t182;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import oicq.wlogin_sdk.tlv_type.tlv_t186;
import oicq.wlogin_sdk.tlv_type.tlv_t192;
import oicq.wlogin_sdk.tlv_type.tlv_t196;
import oicq.wlogin_sdk.tlv_type.tlv_t199;
import oicq.wlogin_sdk.tlv_type.tlv_t200;
import oicq.wlogin_sdk.tlv_type.tlv_t204;
import oicq.wlogin_sdk.tlv_type.tlv_t305;
import oicq.wlogin_sdk.tlv_type.tlv_t322;
import oicq.wlogin_sdk.tlv_type.tlv_t402;
import oicq.wlogin_sdk.tlv_type.tlv_t403;
import oicq.wlogin_sdk.tlv_type.tlv_t508;
import oicq.wlogin_sdk.tlv_type.tlv_t52b;
import oicq.wlogin_sdk.tools.EcdhCrypt;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.InternationMsg;
import oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class oicq_request
{
  static String[] C = { "111.30.137.20", "123.126.122.126", "123.151.176.23", "120.198.203.150", "14.17.41.156", "163.177.71.159", "101.227.130.77", "117.135.172.187", "140.207.69.123" };
  static String[] D = { "180.163.15.182", "183.192.200.28", "223.167.105.36", "183.61.56.18", "183.232.119.221", "163.177.86.123", "123.151.92.19", "125.39.52.120", "123.126.121.172", "117.135.169.107" };
  static String[] E = { "240e:e1:a900:50::10", "2408:8711:10:10::10", "240e:928:1400:10::1b" };
  static String[] F = { "sslv6.wlogin.qq.com" };
  static int H = 0;
  static String I = "";
  static String J = "";
  protected byte[] A = new byte[0];
  protected byte[] B = new byte[0];
  int G = 0;
  public Context a;
  int b = 8192;
  int c = 0;
  int d = 27;
  int e = 0;
  public int f = 15;
  protected int g = 0;
  protected byte[] h = new byte[this.b];
  protected int i = 8001;
  protected int j = 0;
  protected int k = 3;
  protected int l = 0;
  protected int m = 0;
  protected int n = 2;
  protected int o = 0;
  protected int p = 0;
  InetSocketAddress q = null;
  int r = 0;
  byte[] s = new byte[6144];
  protected int t = 0;
  protected int u = 0;
  protected String v = "";
  byte w;
  public t x;
  protected oicq_request.EncryptionMethod y = oicq_request.EncryptionMethod.EM_ECDH;
  protected boolean z = false;
  
  private void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (!this.z) {}
    for (int i1 = 7;; i1 = 135)
    {
      a(paramInt1, paramInt2, paramLong, i1, paramInt3, paramInt4, paramInt5, paramInt6);
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int i1 = this.j + 1;
    this.j = i1;
    this.c = 0;
    util.int8_to_buf(this.h, this.c, 2);
    this.c += 1;
    util.int16_to_buf(this.h, this.c, this.d + 2 + paramInt7);
    this.c += 2;
    util.int16_to_buf(this.h, this.c, paramInt1);
    this.c += 2;
    util.int16_to_buf(this.h, this.c, paramInt2);
    this.c += 2;
    util.int16_to_buf(this.h, this.c, i1);
    this.c += 2;
    util.int32_to_buf(this.h, this.c, (int)paramLong);
    this.c += 4;
    util.int8_to_buf(this.h, this.c, 3);
    this.c += 1;
    util.int8_to_buf(this.h, this.c, paramInt3);
    this.c += 1;
    util.int8_to_buf(this.h, this.c, paramInt4);
    this.c += 1;
    util.int32_to_buf(this.h, this.c, 2);
    this.c += 4;
    util.int32_to_buf(this.h, this.c, paramInt5);
    this.c += 4;
    util.int32_to_buf(this.h, this.c, paramInt6);
    this.c += 4;
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte)
  {
    a(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramInt5, paramArrayOfByte.length);
    a(paramArrayOfByte, paramArrayOfByte.length);
    a();
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    report_t3 localreport_t3 = new report_t3();
    localreport_t3._cmd = this.t;
    localreport_t3._sub = this.u;
    localreport_t3._rst2 = paramInt1;
    localreport_t3._used = ((int)(System.currentTimeMillis() - paramLong));
    localreport_t3._try = paramInt3;
    localreport_t3._host = J;
    if (localreport_t3._host == null) {
      localreport_t3._host = "";
    }
    if (this.q == null)
    {
      localreport_t3._ip = "";
      localreport_t3._port = e(paramBoolean1);
      localreport_t3._conn = paramInt2;
      localreport_t3._net = t.D;
      localreport_t3._str = "";
      localreport_t3._slen = 0;
      localreport_t3._rlen = 0;
      if (!paramBoolean1) {
        break label185;
      }
      if (!paramBoolean2) {
        break label176;
      }
      localreport_t3._wap = 2;
    }
    for (;;)
    {
      t.aq.add_t3(localreport_t3);
      return;
      localreport_t3._ip = this.q.getAddress().getHostAddress();
      break;
      label176:
      localreport_t3._wap = 1;
      continue;
      label185:
      localreport_t3._wap = 0;
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    H = paramInt;
    I = paramString;
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a(paramInt1, paramInt2, paramLong, 69, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte)
  {
    b(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramInt5, paramArrayOfByte.length);
    a(paramArrayOfByte, paramArrayOfByte.length);
    a();
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public int a(int paramInt)
  {
    t.b(this.x.h)._last_flowid = paramInt;
    return paramInt;
  }
  
  public int a(String paramString, boolean paramBoolean, WUserSigInfo paramWUserSigInfo)
  {
    if (this.x.e()) {}
    for (int i1 = b(paramString, paramBoolean, paramWUserSigInfo);; i1 = e())
    {
      if (i1 == -1000)
      {
        paramString = new ErrMsg();
        paramString.setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_4));
        a(paramString);
      }
      return i1;
    }
  }
  
  public int a(tlv_t161 paramtlv_t161)
  {
    tlv_t173 localtlv_t173 = new tlv_t173();
    tlv_t172 localtlv_t172 = new tlv_t172();
    tlv_t17f localtlv_t17f = new tlv_t17f();
    paramtlv_t161 = paramtlv_t161.get_data();
    int i1 = paramtlv_t161.length;
    if (localtlv_t17f.get_tlv(paramtlv_t161, 2, i1) > 0) {
      a(localtlv_t17f);
    }
    if (localtlv_t173.get_tlv(paramtlv_t161, 2, i1) > 0) {
      a(localtlv_t173);
    }
    if (localtlv_t172.get_tlv(paramtlv_t161, 2, i1) > 0)
    {
      this.x.m = 1;
      this.x.r = localtlv_t172.get_data();
      util.LOGI("get rollback sig", "");
    }
    return 0;
  }
  
  public int a(tlv_t173 paramtlv_t173)
  {
    paramtlv_t173 = paramtlv_t173.get_data();
    int i3;
    int i2;
    int i1;
    if ((paramtlv_t173 != null) && (paramtlv_t173.length > 2))
    {
      i3 = util.buf_to_int8(paramtlv_t173, 1);
      i2 = 2;
      i1 = 0;
    }
    for (;;)
    {
      if ((i1 >= i3) || (paramtlv_t173.length < i2 + 1)) {}
      int i4;
      byte[] arrayOfByte;
      do
      {
        do
        {
          do
          {
            return 0;
            i4 = util.buf_to_int8(paramtlv_t173, i2);
            i5 = i2 + 1;
          } while (paramtlv_t173.length < i5 + 2);
          i2 = util.buf_to_int16(paramtlv_t173, i5);
          i5 += 2;
        } while (paramtlv_t173.length < i5 + i2);
        arrayOfByte = new byte[i2];
        System.arraycopy(paramtlv_t173, i5, arrayOfByte, 0, i2);
        i2 = i5 + i2;
      } while (paramtlv_t173.length < i2 + 2);
      int i5 = util.buf_to_int16(paramtlv_t173, i2);
      i2 += 2;
      b(i4, arrayOfByte, i5);
      i1 += 1;
    }
  }
  
  public int a(tlv_t17f paramtlv_t17f)
  {
    paramtlv_t17f = paramtlv_t17f.get_data();
    int i3;
    int i2;
    int i1;
    if ((paramtlv_t17f != null) && (paramtlv_t17f.length > 2))
    {
      i3 = util.buf_to_int8(paramtlv_t17f, 1);
      i2 = 2;
      i1 = 0;
    }
    for (;;)
    {
      if ((i1 >= i3) || (paramtlv_t17f.length < i2 + 1)) {}
      int i4;
      byte[] arrayOfByte;
      do
      {
        do
        {
          do
          {
            return 0;
            i4 = util.buf_to_int8(paramtlv_t17f, i2);
            i5 = i2 + 1;
          } while (paramtlv_t17f.length < i5 + 2);
          i2 = util.buf_to_int16(paramtlv_t17f, i5);
          i5 += 2;
        } while (paramtlv_t17f.length < i5 + i2);
        arrayOfByte = new byte[i2];
        System.arraycopy(paramtlv_t17f, i5, arrayOfByte, 0, i2);
        i2 = i5 + i2;
      } while (paramtlv_t17f.length < i2 + 2);
      int i5 = util.buf_to_int16(paramtlv_t17f, i2);
      i2 += 2;
      a(i4, arrayOfByte, i5);
      i1 += 1;
    }
  }
  
  public int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = cryptor.decrypt(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2);
    if (paramArrayOfByte1 == null) {
      return -1002;
    }
    this.g = paramArrayOfByte1.length;
    if (paramArrayOfByte1.length + this.f + 2 > this.b)
    {
      this.b = (paramArrayOfByte1.length + this.f + 2);
      paramArrayOfByte2 = new byte[this.b];
      System.arraycopy(this.h, 0, paramArrayOfByte2, 0, this.c);
      this.h = paramArrayOfByte2;
    }
    System.arraycopy(paramArrayOfByte1, 0, this.h, paramInt1, paramArrayOfByte1.length);
    paramInt1 = this.f;
    this.c = (paramArrayOfByte1.length + (paramInt1 + 2));
    return 0;
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = "";
    int i1 = paramInt / 2;
    if ((H != 0) && (I != null) && (I.length() > 0)) {
      localObject2 = I;
    }
    for (;;)
    {
      J = (String)localObject2;
      return localObject2;
      if (i1 < 1)
      {
        Object localObject1;
        if (paramBoolean) {
          if (t.D == 1)
          {
            if (paramInt == 0) {
              localObject2 = new String(util.get_wap_server_ipv6_host1(t.t));
            }
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = new String(util.get_wap_server_host1(t.t));
            }
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 0) {
            break;
          }
          localObject2 = c(paramBoolean);
          break;
          localObject1 = localObject2;
          if (t.D == 2)
          {
            if (paramInt == 0) {
              localObject2 = new String(util.get_wap_server_ipv6_host2(t.t));
            }
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = new String(util.get_wap_server_host2(t.t));
              continue;
              if (t.D == 1)
              {
                if (paramInt == 0) {
                  localObject2 = new String(util.get_server_ipv6_host1(t.t));
                }
                localObject1 = localObject2;
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  localObject1 = new String(util.get_server_host1(t.t));
                }
              }
              else
              {
                localObject1 = localObject2;
                if (t.D == 2)
                {
                  if (paramInt == 0) {
                    localObject2 = new String(util.get_server_ipv6_host2(t.t));
                  }
                  localObject1 = localObject2;
                  if (TextUtils.isEmpty((CharSequence)localObject2)) {
                    localObject1 = new String(util.get_server_host2(t.t));
                  }
                }
              }
            }
          }
        }
      }
      if (i1 < 2) {
        localObject2 = c(paramBoolean);
      } else if (i1 < 3) {
        localObject2 = d(paramBoolean);
      } else if (i1 < 4) {
        localObject2 = b(paramBoolean);
      } else {
        localObject2 = a(paramBoolean);
      }
    }
  }
  
  public String a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return C[((int)(java.lang.Math.random() * 2147483647.0D) % C.length)];
    }
    return D[((int)(java.lang.Math.random() * 2147483647.0D) % D.length)];
  }
  
  public void a()
  {
    util.int8_to_buf(this.h, this.c, 3);
    this.c += 1;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt3 = this.j + 1;
    this.j = paramInt3;
    this.c = 0;
    util.int8_to_buf(this.h, this.c, 2);
    this.c += 1;
    util.int16_to_buf(this.h, this.c, this.d + 2 + paramInt8);
    this.c += 2;
    util.int16_to_buf(this.h, this.c, paramInt1);
    this.c += 2;
    util.int16_to_buf(this.h, this.c, paramInt2);
    this.c += 2;
    util.int16_to_buf(this.h, this.c, paramInt3);
    this.c += 2;
    util.int32_to_buf(this.h, this.c, (int)paramLong);
    this.c += 4;
    util.int8_to_buf(this.h, this.c, 3);
    this.c += 1;
    util.int8_to_buf(this.h, this.c, 7);
    this.c += 1;
    util.int8_to_buf(this.h, this.c, paramInt4);
    this.c += 1;
    util.int32_to_buf(this.h, this.c, paramInt5);
    this.c += 4;
    util.int32_to_buf(this.h, this.c, paramInt6);
    this.c += 4;
    util.int32_to_buf(this.h, this.c, paramInt7);
    this.c += 4;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte)
  {
    a(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte, int paramInt8)
  {
    a(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    a(paramArrayOfByte, paramInt8);
    a();
  }
  
  void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return;
    }
    if (paramInt1 == 1) {
      if (t.D == 1) {
        util.set_server_ipv6_host1(t.t, paramArrayOfByte);
      }
    }
    for (;;)
    {
      util.LOGI("ipv6 net type:" + t.D + " type:" + paramInt1 + " host:" + new String(paramArrayOfByte) + " port:" + paramInt2, "" + this.x.f);
      return;
      if (t.D == 2)
      {
        util.set_server_ipv6_host2(t.t, paramArrayOfByte);
        continue;
        if (paramInt1 == 2) {
          if (t.D == 1) {
            util.set_wap_server_ipv6_host1(t.t, paramArrayOfByte);
          } else if (t.D == 2) {
            util.set_wap_server_ipv6_host2(t.t, paramArrayOfByte);
          }
        }
      }
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    a(this.i, this.t, paramLong, this.m, t.w, this.p, paramArrayOfByte);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte, oicq_request.EncryptionMethod paramEncryptionMethod)
  {
    if (paramEncryptionMethod == oicq_request.EncryptionMethod.EM_ST)
    {
      b(paramLong, paramArrayOfByte);
      return;
    }
    if (paramEncryptionMethod == oicq_request.EncryptionMethod.EM_ECDH)
    {
      a(paramLong, paramArrayOfByte);
      return;
    }
    util.LOGI("getRequestEncrptedPackage unknown encryption method " + paramEncryptionMethod, "" + paramLong);
  }
  
  public void a(Socket paramSocket)
  {
    this.x.am = paramSocket;
  }
  
  public void a(WloginSigInfo paramWloginSigInfo)
  {
    if (true == paramWloginSigInfo.isWtSessionTicketExpired()) {}
    while ((paramWloginSigInfo.wtSessionTicket == null) || (paramWloginSigInfo.wtSessionTicketKey == null)) {
      return;
    }
    this.A = ((byte[])paramWloginSigInfo.wtSessionTicket.clone());
    this.B = ((byte[])paramWloginSigInfo.wtSessionTicketKey.clone());
  }
  
  public void a(tlv_t149 paramtlv_t149)
  {
    try
    {
      ErrMsg localErrMsg = new ErrMsg();
      if (paramtlv_t149 != null)
      {
        localErrMsg.setType(paramtlv_t149.get_type());
        localErrMsg.setTitle(new String(paramtlv_t149.get_title()));
        localErrMsg.setMessage(new String(paramtlv_t149.get_content()));
        localErrMsg.setOtherinfo(new String(paramtlv_t149.get_otherinfo()));
        new d(t.t, localErrMsg).start();
      }
      return;
    }
    catch (Exception paramtlv_t149) {}
  }
  
  public void a(ErrMsg paramErrMsg)
  {
    async_context localasync_context = t.b(this.x.h);
    localasync_context._last_err_msg = new ErrMsg(0, "", "", "");
    if (paramErrMsg != null) {}
    try
    {
      localasync_context._last_err_msg = ((ErrMsg)paramErrMsg.clone());
      return;
    }
    catch (CloneNotSupportedException paramErrMsg)
    {
      localasync_context._last_err_msg = new ErrMsg(0, "", "", "");
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.c + paramInt + 1 > this.b)
    {
      this.b = (this.c + paramInt + 1 + 128);
      byte[] arrayOfByte = new byte[this.b];
      System.arraycopy(this.h, 0, arrayOfByte, 0, this.c);
      this.h = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.h, this.c, paramInt);
    this.c += paramInt;
  }
  
  public byte[] a(tlv_t169 paramtlv_t169)
  {
    Object localObject4 = new tlv_t106();
    Object localObject3 = new tlv_t10c();
    Object localObject2 = new tlv_t16a();
    Object localObject1 = new tlv_t145();
    paramtlv_t169 = paramtlv_t169.get_data();
    int i1 = paramtlv_t169.length;
    if (((tlv_t106)localObject4).get_tlv(paramtlv_t169, 2, i1) < 0) {}
    while ((((tlv_t10c)localObject3).get_tlv(paramtlv_t169, 2, i1) < 0) || (((tlv_t16a)localObject2).get_tlv(paramtlv_t169, 2, i1) < 0)) {
      return null;
    }
    paramtlv_t169 = ((tlv_t106)localObject4).get_buf();
    localObject3 = ((tlv_t10c)localObject3).get_buf();
    localObject2 = ((tlv_t16a)localObject2).get_buf();
    localObject1 = ((tlv_t145)localObject1).get_tlv_145(t.A);
    localObject4 = new byte[paramtlv_t169.length + 3 + localObject3.length + localObject2.length + localObject1.length];
    localObject4[0] = 64;
    util.int16_to_buf((byte[])localObject4, 1, 4);
    System.arraycopy(paramtlv_t169, 0, localObject4, 3, paramtlv_t169.length);
    i1 = paramtlv_t169.length + 3;
    System.arraycopy(localObject3, 0, localObject4, i1, localObject3.length);
    i1 += localObject3.length;
    System.arraycopy(localObject2, 0, localObject4, i1, localObject2.length);
    i1 += localObject2.length;
    System.arraycopy(localObject1, 0, localObject4, i1, localObject1.length);
    i1 = localObject1.length;
    return localObject4;
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    if (this.x.m == 0) {
      return a(paramArrayOfByte, this.x.c, this.x.n, this.x.p);
    }
    return a(paramArrayOfByte, this.x.c);
  }
  
  byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.int16_to_buf(arrayOfByte, 0, paramInt1);
    util.int16_to_buf(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  protected byte[] a(byte[] paramArrayOfByte1, oicq_request.EncryptionMethod paramEncryptionMethod, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (oicq_request.EncryptionMethod.EM_ST == paramEncryptionMethod) {
      return b(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
    }
    if (oicq_request.EncryptionMethod.EM_ECDH == paramEncryptionMethod) {
      return a(paramArrayOfByte1);
    }
    util.LOGI("encryptBody unknown encryption method " + paramEncryptionMethod, "");
    return null;
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return new byte[0];
    }
    if (this.x.m == 2) {}
    for (int i1 = 3;; i1 = 2)
    {
      paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
      byte[] arrayOfByte = new byte[paramArrayOfByte2.length + 2 + 2 + 2 + paramArrayOfByte1.length];
      util.int8_to_buf(arrayOfByte, 0, 1);
      util.int8_to_buf(arrayOfByte, 1, i1);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 2, paramArrayOfByte2.length);
      i1 = paramArrayOfByte2.length + 2;
      util.int16_to_buf(arrayOfByte, i1, 258);
      i1 += 2;
      util.int16_to_buf(arrayOfByte, i1, 0);
      i1 += 2;
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, i1, paramArrayOfByte1.length);
      i1 = paramArrayOfByte1.length;
      return arrayOfByte;
    }
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte3);
    paramArrayOfByte3 = new byte[paramArrayOfByte2.length + 2 + paramArrayOfByte1.length];
    util.int16_to_buf(paramArrayOfByte3, 0, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, 2, paramArrayOfByte2.length);
    int i1 = paramArrayOfByte2.length + 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, i1, paramArrayOfByte1.length);
    i1 = paramArrayOfByte1.length;
    return paramArrayOfByte3;
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte3 == null) || (paramArrayOfByte4 == null)) {
      return new byte[0];
    }
    paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte4);
    paramArrayOfByte4 = new byte[paramArrayOfByte2.length + 2 + 2 + 2 + paramArrayOfByte3.length + paramArrayOfByte1.length];
    util.int8_to_buf(paramArrayOfByte4, 0, 1);
    util.int8_to_buf(paramArrayOfByte4, 1, 1);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte4, 2, paramArrayOfByte2.length);
    int i1 = paramArrayOfByte2.length + 2;
    util.int16_to_buf(paramArrayOfByte4, i1, 258);
    i1 += 2;
    util.int16_to_buf(paramArrayOfByte4, i1, paramArrayOfByte3.length);
    i1 += 2;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte4, i1, paramArrayOfByte3.length);
    i1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte4, i1, paramArrayOfByte1.length);
    i1 = paramArrayOfByte1.length;
    return paramArrayOfByte4;
  }
  
  public int b()
  {
    int i2 = -1009;
    int i1 = this.c;
    if (i1 <= this.f + 2) {
      return i2;
    }
    this.g = (i1 - this.f - 2);
    i1 = util.buf_to_int16(this.h, 13);
    util.LOGI("enrypt method " + this.y + " rsp flag " + i1, "");
    if ((this.y == oicq_request.EncryptionMethod.EM_ECDH) && (i1 == 0)) {
      if (this.x.m == 0)
      {
        i2 = a(this.h, this.f + 1, this.g, this.x.p);
        i1 = i2;
        if (i2 < 0)
        {
          util.LOGI("use ecdh decrypt_body failed", "");
          i2 = a(this.h, this.f + 1, this.g, this.x.c);
          i1 = i2;
          if (i2 < 0)
          {
            util.LOGI("use kc decrypt_body failed", "");
            i1 = i2;
          }
        }
      }
    }
    for (;;)
    {
      i2 = i1;
      if (i1 < 0) {
        break;
      }
      return d(this.h, this.f + 1, this.g);
      i2 = a(this.h, this.f + 1, this.g, this.x.c);
      i1 = i2;
      if (i2 < 0)
      {
        util.LOGI("use kc decrypt_body failed", "");
        i1 = i2;
        continue;
        Object localObject;
        if ((this.y == oicq_request.EncryptionMethod.EM_ST) && (3 == i1))
        {
          i2 = a(this.h, this.f + 1, this.g, this.B);
          i1 = i2;
          if (i2 < 0)
          {
            t.aq.attr_api(2494911);
            localObject = t.b(this.x.h);
            if (localObject != null) {
              this.x.c(this.x.f, ((async_context)localObject)._sappid);
            }
            util.LOGI("use session key decrypt_body failed", "");
            i1 = -1025;
          }
        }
        else if ((this.y == oicq_request.EncryptionMethod.EM_ECDH) && (true == this.z) && (4 == i1))
        {
          localObject = cryptor.decrypt(this.h, this.f + 1, this.g, this.x.p);
          if (localObject == null)
          {
            util.LOGI("decrypted outer body failed", "" + this.x.f);
            return -1002;
          }
          i1 = util.buf_to_int16((byte[])localObject, 0);
          if (i1 > localObject.length - 2)
          {
            util.LOGI("peer public key len wrong " + i1, "" + this.x.f);
            return -1009;
          }
          byte[] arrayOfByte = new byte[i1];
          System.arraycopy(localObject, 2, arrayOfByte, 0, i1);
          arrayOfByte = new EcdhCrypt(this.a).calShareKeyMd5ByPeerPublicKey(arrayOfByte);
          if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
            return -1002;
          }
          localObject = cryptor.decrypt((byte[])localObject, i1 + 2, localObject.length - 2 - i1, arrayOfByte);
          if (localObject == null)
          {
            t.aq.attr_api(2461266);
            util.LOGI("use share key md5 decrypt failed", "" + this.x.f);
            return -1002;
          }
          if (this.h.length < this.f + 2 + localObject.length)
          {
            this.b = (this.f + 2 + localObject.length);
            arrayOfByte = new byte[this.b];
            System.arraycopy(this.h, 0, arrayOfByte, 0, this.f + 1);
            this.h = arrayOfByte;
          }
          System.arraycopy(localObject, 0, this.h, this.f + 1, localObject.length);
          i1 = this.f;
          this.c = (localObject.length + (i1 + 2));
          i1 = 0;
        }
        else
        {
          util.LOGI("unknown encryption method " + this.y, "");
          i1 = -1024;
        }
      }
    }
  }
  
  /* Error */
  public int b(String paramString, boolean paramBoolean, WUserSigInfo paramWUserSigInfo)
  {
    // Byte code:
    //   0: new 460	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 677	java/lang/Object:getClass	()Ljava/lang/Class;
    //   11: invokevirtual 682	java/lang/Class:getName	()Ljava/lang/String;
    //   14: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 684
    //   20: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: new 460	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   33: ldc 110
    //   35: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   42: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   45: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   58: getfield 685	oicq/wlogin_sdk/request/t:l	I
    //   61: istore 4
    //   63: aload_0
    //   64: invokevirtual 687	oicq/wlogin_sdk/request/oicq_request:c	()[B
    //   67: astore 7
    //   69: invokestatic 218	java/lang/System:currentTimeMillis	()J
    //   72: lstore 5
    //   74: new 460	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 689
    //   84: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 691
    //   94: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: getfield 160	oicq/wlogin_sdk/request/oicq_request:v	Ljava/lang/String;
    //   101: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 693
    //   107: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 4
    //   112: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc_w 695
    //   118: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_2
    //   122: invokevirtual 698	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   125: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: new 460	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   135: ldc 110
    //   137: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   144: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   147: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: new 700	oicq/wlogin_sdk/request/WtloginMsfListener
    //   159: dup
    //   160: aload_1
    //   161: aload_0
    //   162: getfield 160	oicq/wlogin_sdk/request/oicq_request:v	Ljava/lang/String;
    //   165: aload 7
    //   167: iload 4
    //   169: iload_2
    //   170: aload_3
    //   171: invokespecial 703	oicq/wlogin_sdk/request/WtloginMsfListener:<init>	(Ljava/lang/String;Ljava/lang/String;[BIZLoicq/wlogin_sdk/request/WUserSigInfo;)V
    //   174: astore_3
    //   175: new 705	java/lang/Thread
    //   178: dup
    //   179: aload_3
    //   180: ldc_w 707
    //   183: invokespecial 710	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 711	java/lang/Thread:start	()V
    //   191: aload_1
    //   192: iload 4
    //   194: i2l
    //   195: invokevirtual 715	java/lang/Thread:join	(J)V
    //   198: aload_3
    //   199: invokevirtual 718	oicq/wlogin_sdk/request/WtloginMsfListener:getRetData	()[B
    //   202: astore_1
    //   203: aload_1
    //   204: ifnonnull +240 -> 444
    //   207: new 460	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   214: ldc_w 720
    //   217: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_3
    //   221: invokevirtual 723	oicq/wlogin_sdk/request/WtloginMsfListener:getRet	()I
    //   224: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: new 460	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   237: ldc 110
    //   239: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_0
    //   243: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   246: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   249: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   252: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: sipush -1000
    //   261: istore 4
    //   263: aload_0
    //   264: getfield 156	oicq/wlogin_sdk/request/oicq_request:t	I
    //   267: sipush 2066
    //   270: if_icmpeq +112 -> 382
    //   273: new 202	oicq/wlogin_sdk/report/report_t3
    //   276: dup
    //   277: invokespecial 203	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   280: astore_3
    //   281: aload_3
    //   282: aload_0
    //   283: getfield 156	oicq/wlogin_sdk/request/oicq_request:t	I
    //   286: putfield 206	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   289: aload_3
    //   290: aload_0
    //   291: getfield 158	oicq/wlogin_sdk/request/oicq_request:u	I
    //   294: putfield 209	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   297: aload_3
    //   298: iload 4
    //   300: putfield 212	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   303: aload_3
    //   304: invokestatic 218	java/lang/System:currentTimeMillis	()J
    //   307: lload 5
    //   309: lsub
    //   310: l2i
    //   311: putfield 221	oicq/wlogin_sdk/report/report_t3:_used	I
    //   314: aload_3
    //   315: iconst_0
    //   316: putfield 224	oicq/wlogin_sdk/report/report_t3:_try	I
    //   319: aload_3
    //   320: ldc 110
    //   322: putfield 227	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   325: aload_3
    //   326: ldc 110
    //   328: putfield 230	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   331: aload_3
    //   332: iconst_0
    //   333: putfield 236	oicq/wlogin_sdk/report/report_t3:_port	I
    //   336: aload_3
    //   337: iconst_0
    //   338: putfield 239	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   341: aload_3
    //   342: iconst_0
    //   343: putfield 246	oicq/wlogin_sdk/report/report_t3:_net	I
    //   346: aload_3
    //   347: ldc 110
    //   349: putfield 249	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   352: iload 4
    //   354: ifne +143 -> 497
    //   357: aload_3
    //   358: aload 7
    //   360: arraylength
    //   361: putfield 252	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   364: aload_3
    //   365: aload_1
    //   366: arraylength
    //   367: putfield 255	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   370: aload_3
    //   371: iconst_3
    //   372: putfield 258	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   375: getstatic 262	oicq/wlogin_sdk/request/t:aq	Loicq/wlogin_sdk/report/Reporter;
    //   378: aload_3
    //   379: invokevirtual 268	oicq/wlogin_sdk/report/Reporter:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   382: new 460	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   389: aload_0
    //   390: invokevirtual 677	java/lang/Object:getClass	()Ljava/lang/Class;
    //   393: invokevirtual 682	java/lang/Class:getName	()Ljava/lang/String;
    //   396: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: ldc_w 725
    //   402: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: iload 4
    //   407: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: new 460	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   420: ldc 110
    //   422: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_0
    //   426: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   429: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   432: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   435: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   441: iload 4
    //   443: ireturn
    //   444: aload_0
    //   445: aload_1
    //   446: aload_1
    //   447: arraylength
    //   448: invokevirtual 727	oicq/wlogin_sdk/request/oicq_request:b	([BI)V
    //   451: iconst_0
    //   452: istore 4
    //   454: goto -191 -> 263
    //   457: astore_3
    //   458: aconst_null
    //   459: astore_1
    //   460: aload_3
    //   461: new 460	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   468: ldc 110
    //   470: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload_0
    //   474: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   477: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   480: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   483: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 731	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   489: sipush -1000
    //   492: istore 4
    //   494: goto -231 -> 263
    //   497: aload_3
    //   498: iconst_0
    //   499: putfield 252	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   502: aload_3
    //   503: iconst_0
    //   504: putfield 255	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   507: goto -137 -> 370
    //   510: astore_3
    //   511: goto -51 -> 460
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	oicq_request
    //   0	514	1	paramString	String
    //   0	514	2	paramBoolean	boolean
    //   0	514	3	paramWUserSigInfo	WUserSigInfo
    //   61	432	4	i1	int
    //   72	236	5	l1	long
    //   67	292	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   74	203	457	java/lang/Exception
    //   207	258	510	java/lang/Exception
    //   444	451	510	java/lang/Exception
  }
  
  public int b(byte[] paramArrayOfByte)
  {
    return util.buf_to_int16(paramArrayOfByte, 1);
  }
  
  public String b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return E[((int)(java.lang.Math.random() * 2147483647.0D) % E.length)];
    }
    return F[((int)(java.lang.Math.random() * 2147483647.0D) % F.length)];
  }
  
  void b(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return;
    }
    if (paramInt1 == 1) {
      if (t.D == 1) {
        util.set_server_host1(t.t, paramArrayOfByte);
      }
    }
    for (;;)
    {
      util.LOGI("net type:" + t.D + " type:" + paramInt1 + " host:" + new String(paramArrayOfByte) + " port:" + paramInt2, "" + this.x.f);
      return;
      if (t.D == 2)
      {
        util.set_server_host2(t.t, paramArrayOfByte);
        continue;
        if (paramInt1 == 2) {
          if (t.D == 1) {
            util.set_wap_server_host1(t.t, paramArrayOfByte);
          } else if (t.D == 2) {
            util.set_wap_server_host2(t.t, paramArrayOfByte);
          }
        }
      }
    }
  }
  
  public void b(long paramLong, byte[] paramArrayOfByte)
  {
    b(this.i, this.t, paramLong, this.m, t.w, this.p, paramArrayOfByte);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > this.b)
    {
      this.b = (paramInt + 128);
      this.h = new byte[this.b];
    }
    this.c = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.h, 0, paramInt);
  }
  
  byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.int16_to_buf(arrayOfByte, 0, paramInt1);
    util.int16_to_buf(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    if (this.x.m == 0) {
      return a(arrayOfByte, this.x.c, this.x.n, this.x.p);
    }
    return a(arrayOfByte, this.x.c);
  }
  
  protected byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
  }
  
  public int c(byte[] paramArrayOfByte, int paramInt)
  {
    this.w = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public String c(boolean paramBoolean)
  {
    String[] arrayOfString = new String[2];
    if (paramBoolean)
    {
      arrayOfString[0] = "wlogin.qq.com";
      arrayOfString[1] = "wlogin1.qq.com";
    }
    for (;;)
    {
      return arrayOfString[java.lang.Math.abs(new java.util.Random().nextInt() % arrayOfString.length)];
      arrayOfString[0] = "wtlogin.qq.com";
      arrayOfString[1] = "wtlogin1.qq.com";
    }
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    tlv_t146 localtlv_t146 = new tlv_t146();
    paramInt1 = localtlv_t146.get_tlv(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = t.b(this.x.h);
    if (paramInt1 >= 0)
    {
      paramArrayOfByte._last_err_msg.setTitle(new String(localtlv_t146.get_title()));
      paramArrayOfByte._last_err_msg.setMessage(new String(localtlv_t146.get_msg()));
      paramArrayOfByte._last_err_msg.setType(localtlv_t146.get_type());
      paramArrayOfByte._last_err_msg.setOtherinfo(new String(localtlv_t146.get_errorinfo()));
    }
  }
  
  public byte[] c()
  {
    byte[] arrayOfByte = new byte[this.c];
    System.arraycopy(this.h, 0, arrayOfByte, 0, this.c);
    return arrayOfByte;
  }
  
  public byte[] c(byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((t.B == null) || (t.B.length <= 0))
    {
      localObject = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, "%4;7t>;28<fc.5*6".getBytes());
      if (localObject != null) {
        break label210;
      }
    }
    label210:
    for (paramArrayOfByte = (byte[])paramArrayOfByte.clone();; paramArrayOfByte = (byte[])localObject)
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 16))
      {
        return (byte[])null;
        localObject = new byte[16];
        if (t.B.length > localObject.length) {
          System.arraycopy(t.B, 0, localObject, 0, localObject.length);
        }
        for (;;)
        {
          arrayOfByte = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, (byte[])localObject);
          if (arrayOfByte != null)
          {
            localObject = arrayOfByte;
            if (arrayOfByte.length > 0) {
              break;
            }
          }
          localObject = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, "%4;7t>;28<fc.5*6".getBytes());
          break;
          System.arraycopy(t.B, 0, localObject, 0, t.B.length);
          i1 = t.B.length;
          while (i1 < localObject.length)
          {
            localObject[i1] = ((byte)(i1 + 1));
            i1 += 1;
          }
        }
      }
      int i1 = paramArrayOfByte.length - 16;
      localObject = new byte[i1];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, i1);
      byte[] arrayOfByte = new byte[16];
      System.arraycopy(paramArrayOfByte, i1, arrayOfByte, 0, 16);
      t.b(this.x.h)._tgtgt_key = arrayOfByte;
      return localObject;
    }
  }
  
  public byte[] c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte3 == null)) {
      return new byte[16];
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length + paramArrayOfByte3.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    int i1 = paramArrayOfByte1.length + 0;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i1, paramArrayOfByte2.length);
    i1 += paramArrayOfByte2.length;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, i1, paramArrayOfByte3.length);
    i1 = paramArrayOfByte3.length;
    return MD5.toMD5Byte(arrayOfByte);
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i1;
    if (paramInt2 < 5)
    {
      i1 = -1009;
      return i1;
    }
    tlv_t104 localtlv_t104 = new tlv_t104();
    tlv_t105 localtlv_t105 = new tlv_t105();
    tlv_t113 localtlv_t113 = new tlv_t113();
    tlv_t119 localtlv_t119 = new tlv_t119();
    tlv_t10d localtlv_t10d = new tlv_t10d();
    tlv_t10e localtlv_t10e = new tlv_t10e();
    tlv_t10a localtlv_t10a = new tlv_t10a();
    tlv_t114 localtlv_t114 = new tlv_t114();
    tlv_t103 localtlv_t103 = new tlv_t103();
    tlv_t11a localtlv_t11a = new tlv_t11a();
    tlv_t102 localtlv_t102 = new tlv_t102();
    tlv_t10b localtlv_t10b = new tlv_t10b();
    tlv_t11c localtlv_t11c = new tlv_t11c();
    tlv_t11d localtlv_t11d = new tlv_t11d();
    Object localObject5 = new tlv_t120();
    Object localObject1 = new tlv_t121();
    tlv_t130 localtlv_t130 = new tlv_t130();
    tlv_t108 localtlv_t108 = new tlv_t108();
    Object localObject10 = new tlv_t106();
    tlv_t10c localtlv_t10c = new tlv_t10c();
    Object localObject3 = new tlv_t125();
    tlv_t11f localtlv_t11f = new tlv_t11f();
    Object localObject7 = new tlv_t138();
    tlv_t132 localtlv_t132 = new tlv_t132();
    tlv_t149 localtlv_t149 = new tlv_t149();
    tlv_t150 localtlv_t150 = new tlv_t150();
    Object localObject6 = new tlv_t143();
    tlv_t305 localtlv_t305 = new tlv_t305();
    tlv_t164 localtlv_t164 = new tlv_t164();
    tlv_t165 localtlv_t165 = new tlv_t165();
    Object localObject12 = new tlv_t167();
    Object localObject11 = new tlv_t16a();
    Object localObject13 = new tlv_t169();
    tlv_t161 localtlv_t161 = new tlv_t161();
    tlv_t171 localtlv_t171 = new tlv_t171();
    tlv_t localtlv_t = new tlv_t(1298);
    tlv_t16d localtlv_t16d = new tlv_t16d();
    tlv_t174 localtlv_t174 = new tlv_t174();
    tlv_t178 localtlv_t178 = new tlv_t178();
    Object localObject8 = new tlv_t179();
    Object localObject14 = new tlv_t17d();
    tlv_t17e localtlv_t17e = new tlv_t17e();
    tlv_t126 localtlv_t126 = new tlv_t126();
    tlv_t182 localtlv_t182 = new tlv_t182();
    tlv_t183 localtlv_t183 = new tlv_t183();
    tlv_t186 localtlv_t186 = new tlv_t186();
    tlv_t402 localtlv_t402 = new tlv_t402();
    Object localObject9 = new tlv_t403();
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte3 = null;
    byte[] arrayOfByte4 = null;
    byte[] arrayOfByte5 = null;
    Object localObject2 = null;
    byte[] arrayOfByte6 = null;
    tlv_t136 localtlv_t136 = new tlv_t136();
    tlv_t118 localtlv_t118 = new tlv_t118();
    async_context localasync_context = t.b(this.x.h);
    long l4 = localasync_context._sappid;
    long l5 = localasync_context._appid;
    if (this.t == 2064) {
      switch (this.u)
      {
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 12: 
      case 14: 
      case 16: 
      case 21: 
      default: 
        return -1012;
      case 9: 
        paramInt2 = 0;
      }
    }
    label924:
    label1192:
    label3040:
    label4705:
    for (;;)
    {
      label630:
      i1 = c(paramArrayOfByte, paramInt1 + 2);
      int i4 = paramInt1 + 5;
      this.x.d = null;
      label874:
      int i2;
      int i5;
      int i3;
      switch (i1)
      {
      default: 
        c(paramArrayOfByte, i4, this.c - i4 - 1);
        paramInt1 = i1;
      case 0: 
        do
        {
          do
          {
            localObject2 = new StringBuilder().append("get_response_body cmd= 0x").append(Integer.toHexString(this.t)).append(" subCmd= 0x").append(Integer.toHexString(this.u)).append(" type:").append(i1).append(" ret:");
            if (paramInt1 <= 0) {
              break label7185;
            }
            localObject1 = "0x" + Integer.toHexString(paramInt1);
            util.LOGI(localObject1, "" + this.x.f);
            if (paramInt1 != 0) {
              break label7194;
            }
            a(null);
            i1 = paramInt1;
            if ((i1 != 10) && (i1 != 161) && (i1 != 162) && (i1 != 164) && (i1 != 165) && (i1 != 166) && (i1 != 154))
            {
              paramInt1 = i1;
              if (i1 >= 128)
              {
                paramInt1 = i1;
                if (i1 > 143) {}
              }
            }
            else
            {
              paramInt1 = -1000;
            }
            i1 = paramInt1;
            if (paramInt2 == 2) {
              break;
            }
            i1 = paramInt1;
            if (paramInt2 == 6) {
              break;
            }
            i1 = paramInt1;
            if (paramInt2 == 7) {
              break;
            }
            a(paramInt2);
            return paramInt1;
            paramInt2 = 1;
            break label630;
            paramInt2 = 2;
            break label630;
            paramInt2 = 3;
            break label630;
            paramInt2 = 4;
            break label630;
            paramInt2 = 5;
            break label630;
            paramInt2 = 6;
            break label630;
            paramInt2 = 7;
            break label630;
            paramInt2 = 0;
            break label630;
            paramInt2 = 0;
            break label630;
            paramInt2 = 0;
            break label630;
            if (paramInt2 != 1) {
              break label2450;
            }
            if (this.x.b == null) {
              return -1006;
            }
            if (localtlv_t150.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
              this.x.d = localtlv_t150;
            }
            if (localtlv_t161.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
              a(localtlv_t161);
            }
            i2 = localtlv_t119.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1, this.x.b);
            paramInt1 = i2;
          } while (i2 < 0);
          localObject8 = localtlv_t119.get_data();
          i2 = 2;
          i5 = localObject8.length;
          if (localtlv_t149.get_tlv((byte[])localObject8, 2, i5) > 0) {
            a(localtlv_t149);
          }
          if (localtlv_t130.get_tlv((byte[])localObject8, 2, i5) > 0) {
            this.x.a(localtlv_t130.get_time(), localtlv_t130.get_ipaddr());
          }
          if (localtlv_t113.get_tlv((byte[])localObject8, 2, i5) >= 0)
          {
            this.x.f = localtlv_t113.get_uin();
            localasync_context._uin = this.x.f;
            if (!localasync_context.ifQQLoginInQim(t.ax)) {
              break label2952;
            }
          }
          localObject14 = new tlv_t(1320);
          if (((tlv_t)localObject14).get_tlv((byte[])localObject8, 2, i5) > 0)
          {
            util.LOGI("get tlv528 and put into context from seq " + this.x.h, "" + this.x.f);
            localasync_context.tlv528 = ((tlv_t)localObject14);
          }
          localObject14 = new tlv_t(1328);
          if (((tlv_t)localObject14).get_tlv((byte[])localObject8, 2, i5) > 0)
          {
            util.LOGI("get tlv530 and put into context from seq " + this.x.h, "" + this.x.f);
            localasync_context.tlv530 = ((tlv_t)localObject14);
          }
          localtlv_t10d.get_tlv((byte[])localObject8, 2, i5);
          localtlv_t10e.get_tlv((byte[])localObject8, 2, i5);
          localtlv_t10a.get_tlv((byte[])localObject8, 2, i5);
          localtlv_t114.get_tlv((byte[])localObject8, 2, i5);
          i3 = localtlv_t11a.get_tlv((byte[])localObject8, 2, i5);
          paramInt1 = i3;
        } while (i3 < 0);
        if (localtlv_t118.get_tlv((byte[])localObject8, 2, i5) < 0) {
          util.LOGI("t118 get failed", "" + this.x.f);
        }
        if (localtlv_t103.get_tlv((byte[])localObject8, 2, i5) >= 0) {
          localObject2 = localtlv_t103.get_data();
        }
        if (localtlv_t108.get_tlv((byte[])localObject8, 2, i5) >= 0) {
          util.set_ksid(t.t, localtlv_t108.get_data());
        }
        if (localtlv_t102.get_tlv((byte[])localObject8, 2, i5) >= 0) {
          arrayOfByte1 = localtlv_t102.get_data();
        }
        if (localtlv_t10b.get_tlv((byte[])localObject8, 2, i5) >= 0) {
          arrayOfByte2 = localtlv_t10b.get_data();
        }
        if (localtlv_t11c.get_tlv((byte[])localObject8, 2, i5) >= 0) {
          arrayOfByte3 = localtlv_t11c.get_data();
        }
        if (((tlv_t120)localObject5).get_tlv((byte[])localObject8, 2, i5) >= 0) {
          arrayOfByte4 = ((tlv_t120)localObject5).get_data();
        }
        if (((tlv_t121)localObject1).get_tlv((byte[])localObject8, 2, i5) >= 0) {
          arrayOfByte5 = ((tlv_t121)localObject1).get_data();
        }
        if (((tlv_t125)localObject3).get_tlv((byte[])localObject8, 2, i5) >= 0)
        {
          localObject1 = ((tlv_t125)localObject3).get_openid();
          arrayOfByte6 = ((tlv_t125)localObject3).get_openkey();
        }
        break;
      }
      label3556:
      label3685:
      label3945:
      label4714:
      label4850:
      label7283:
      for (;;)
      {
        if (localtlv_t186.get_tlv((byte[])localObject8, 2, i5) >= 0)
        {
          localObject3 = this.x.g;
          if (!util.check_uin_account((String)localObject3).booleanValue()) {
            break label2979;
          }
          localObject5 = this.x.e(this.x.f);
          localObject3 = localObject5;
          if (localObject5 != null)
          {
            localObject3 = localObject5;
            if (((String)localObject5).length() > 0)
            {
              this.x.a((String)localObject5, Long.valueOf(this.x.f), localtlv_t186.getPwdflag());
              localObject3 = localObject5;
            }
          }
        }
        for (;;)
        {
          util.LOGI("put t186: name: " + (String)localObject3 + " uin: " + this.x.f + " pwd=" + localtlv_t186.getPwdflag(), "");
          try
          {
            localObject3 = new tlv_t(1335);
            paramInt1 = ((tlv_t)localObject3).get_tlv((byte[])localObject8, 2, i5);
            if (paramInt1 >= 0)
            {
              localObject3 = ((tlv_t)localObject3).get_data();
              if ((localObject3 != null) && (localObject3.length > 0))
              {
                localObject5 = new byte[localObject3.length - 2];
                System.arraycopy(localObject3, 2, localObject5, 0, localObject3.length - 2);
                i3 = ProtocolDet.setLoginExtraData(t.t, (byte[])localObject5);
                util.LOGI("0x537 resp:" + paramInt1 + ":" + localObject3.length + " setRes:" + i3 + " tuple:" + localObject5.length, "" + this.x.f);
              }
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              util.LOGI("tlv537 error " + Log.getStackTraceString(localThrowable), "");
              continue;
              this.x.j = new WFastLoginInfo();
            }
            paramInt1 = localtlv_t10c.get_tlv((byte[])localObject8, 2, i5);
            i3 = ((tlv_t106)localObject10).get_tlv((byte[])localObject8, 2, i5);
            if ((paramInt1 < 0) || (i3 < 0)) {
              break label3116;
            }
            localObject4 = localtlv_t10c.get_data();
            localObject12[0] = ((byte[])b(((tlv_t106)localObject10).get_data(), (byte[])localObject4).clone());
            if (((tlv_t16a)localObject11).get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label3138;
            }
            localObject12[1] = ((tlv_t16a)localObject11).get_data();
            localObject5 = new tlv_t(1329);
            paramInt1 = ((tlv_t)localObject5).get_tlv((byte[])localObject8, 2, i5);
            util.LOGI("retT531: " + paramInt1 + this.x.f);
            if (paramInt1 < 0) {
              break label3556;
            }
            localObject11 = new tlv_t106();
            localtlv_t10c = new tlv_t10c();
            localObject4 = new tlv_t16a();
            localObject10 = new tlv_t113();
            paramInt1 = ((tlv_t)localObject11).get_tlv(((tlv_t)localObject5).get_data(), 2, ((tlv_t)localObject5).get_data_len());
            i3 = localtlv_t10c.get_tlv(((tlv_t)localObject5).get_data(), 2, ((tlv_t)localObject5).get_data_len());
            int i6 = ((tlv_t)localObject4).get_tlv(((tlv_t)localObject5).get_data(), 2, ((tlv_t)localObject5).get_data_len());
            int i7 = ((tlv_t)localObject10).get_tlv(((tlv_t)localObject5).get_data(), 2, ((tlv_t)localObject5).get_data_len());
            if ((paramInt1 < 0) || (i3 < 0) || (i6 < 0) || (i7 < 0)) {
              break label3484;
            }
            localObject5 = b(((tlv_t)localObject11).get_data(), localtlv_t10c.get_data());
            localObject4 = ((tlv_t)localObject4).get_data();
            l1 = util.buf_to_int32(((tlv_t)localObject10).get_data(), 0);
            localasync_context.tlv113 = ((tlv_t)localObject10);
            l2 = l1 & 0xFFFFFFFF;
            for (;;)
            {
              if (((tlv_t403)localObject9).get_tlv((byte[])localObject8, 2, i5) >= 0) {
                localObject12[4] = ((tlv_t403)localObject9).get_data();
              }
              if (localasync_context._sec_guid_flag)
              {
                localObject12[2] = localasync_context._G;
                localObject12[3] = localasync_context._dpwd;
                localObject12[4] = localasync_context._t403.get_data();
                localasync_context._sec_guid_flag = false;
              }
              localObject9 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 16, 0 });
              paramInt1 = 0;
              while (paramInt1 < 16)
              {
                localObject9[paramInt1] = new byte[0];
                paramInt1 += 1;
              }
              util.LOGI("Get data from 0x531 failed: " + paramInt1 + ";" + i3 + ";" + i6 + ";" + i7 + ";" + this.x.f);
              l2 = 0L;
              localObject4 = null;
              localObject5 = null;
            }
            if (localtlv_t136.get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label3590;
            }
            localObject9[0] = localtlv_t136.get_data();
            if (localtlv_t132.get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label3619;
            }
            localObject9[1] = localtlv_t132.get_access_token();
            localObject1 = localtlv_t132.get_openid();
            if (((tlv_t143)localObject6).get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label3641;
            }
            localObject9[2] = ((tlv_t143)localObject6).get_data();
            if (localtlv_t305.get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label3663;
            }
            localObject9[3] = localtlv_t305.get_data();
            if (localtlv_t164.get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label3685;
            }
            localObject9[4] = localtlv_t164.get_data();
            if (localtlv_t171.get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label3707;
            }
            localObject9[5] = localtlv_t171.get_data();
            if (localtlv_t.get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label3730;
            }
            localObject9[6] = localtlv_t.get_data();
            if (localtlv_t16d.get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label3753;
            }
            localObject9[7] = localtlv_t16d.get_data();
            localObject6 = new tlv_t199();
            if (((tlv_t199)localObject6).get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label7294;
            }
          }
          util.LOGI("tgt len:" + util.buf_len(localtlv_t10a.get_data()) + " tgt_key len:" + util.buf_len(localtlv_t10d.get_data()) + " st len:" + util.buf_len(localtlv_t114.get_data()) + " st_key len:" + util.buf_len(localtlv_t10e.get_data()) + " stwx_web len:" + util.buf_len((byte[])localObject2) + " lskey len:" + util.buf_len(arrayOfByte3) + " skey len:" + util.buf_len(arrayOfByte4) + " sig64 len:" + util.buf_len(arrayOfByte5) + " openid len:" + util.buf_len((byte[])localObject1) + " openkey len:" + util.buf_len(arrayOfByte6) + " pwdflag: " + localtlv_t186.get_data_len() + " " + localtlv_t186.getPwdflag(), "" + this.x.f);
          if (((tlv_t169)localObject13).get_tlv((byte[])localObject8, 2, i5) >= 0)
          {
            localObject3 = a((tlv_t169)localObject13);
            if ((localObject3 == null) || (localObject3.length <= 0)) {
              break label3040;
            }
            this.x.j = new WFastLoginInfo((byte[])localObject3);
          }
          localObject13 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 3, 0 });
          if (((tlv_t167)localObject12).get_tlv((byte[])localObject8, 2, i5) >= 0)
          {
            localObject13[0] = ((tlv_t167)localObject12).get_img_type();
            localObject13[1] = ((tlv_t167)localObject12).get_img_format();
            localObject13[2] = ((tlv_t167)localObject12).get_img_url();
          }
          localObject12 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 5, 0 });
          paramInt1 = 0;
          while (paramInt1 < 5)
          {
            localObject12[paramInt1] = new byte[0];
            paramInt1 += 1;
          }
          if (paramInt2 == 2)
          {
            if (localtlv_t183.get_tlv(paramArrayOfByte, i4, this.c - i4) >= 0) {
              localasync_context._msalt = localtlv_t183.getMsalt();
            }
            if (f() == 3)
            {
              if (localtlv_t113.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
              {
                this.x.f = localtlv_t113.get_uin();
                localasync_context._uin = this.x.f;
                if (!localasync_context.ifQQLoginInQim(t.ax)) {
                  break label2579;
                }
              }
              for (;;)
              {
                if (localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
                  localasync_context._t104 = localtlv_t104;
                }
                paramInt1 = 0;
                break;
                this.x.a(this.x.g, Long.valueOf(this.x.f));
              }
            }
            if (localtlv_t150.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
              this.x.d = localtlv_t150;
            }
            if (localtlv_t161.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
              a(localtlv_t161);
            }
            i2 = localtlv_t119.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1, localasync_context._tgtgt_key);
            break label1192;
          }
          if ((paramInt2 == 3) || (paramInt2 == 7))
          {
            if (localtlv_t183.get_tlv(paramArrayOfByte, i4, this.c - i4) >= 0) {
              localasync_context._msalt = localtlv_t183.getMsalt();
            }
            if (localtlv_t113.get_tlv(paramArrayOfByte, i4, this.c - i4) >= 0)
            {
              this.x.f = localtlv_t113.get_uin();
              this.x.a(this.x.g, Long.valueOf(this.x.f));
            }
            i2 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t104 = localtlv_t104;
            paramInt1 = 0;
            break;
          }
          if (22 == this.u)
          {
            i2 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t104 = localtlv_t104;
            paramInt1 = 0;
            break;
          }
          if (localtlv_t150.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
            this.x.d = localtlv_t150;
          }
          if (localtlv_t161.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
            a(localtlv_t161);
          }
          i2 = localtlv_t119.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1, localasync_context._tgtgt_key);
          r.K = 0;
          break label1192;
          this.x.a(this.x.g, Long.valueOf(this.x.f));
          break label1313;
          this.x.a((String)localObject3, Long.valueOf(this.x.f), localtlv_t186.getPwdflag());
        }
        Object localObject4;
        long l1;
        long l2;
        label3707:
        localObject9[8] = ((tlv_t199)localObject6).getPayToken();
        localObject1 = ((tlv_t199)localObject6).getOpenId();
        label4600:
        label7294:
        for (;;)
        {
          localObject6 = new tlv_t200();
          if (((tlv_t200)localObject6).get_tlv((byte[])localObject8, 2, i5) >= 0)
          {
            localObject9[9] = ((tlv_t200)localObject6).getPf();
            localObject9[10] = ((tlv_t200)localObject6).getPfKey();
          }
          localObject6 = new tlv_t(515);
          if (((tlv_t)localObject6).get_tlv((byte[])localObject8, 2, i5) >= 0)
          {
            localObject9[11] = ((tlv_t)localObject6).get_data();
            util.LOGI("get DA2 in rsp", "");
            localObject6 = new tlv_t(791);
            if (((tlv_t)localObject6).get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label4705;
            }
            WloginSigInfo._QRPUSHSig = ((tlv_t)localObject6).get_data();
            localObject6 = new tlv_t(307);
            if (((tlv_t)localObject6).get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label4714;
            }
            localObject9[13] = ((tlv_t)localObject6).get_data();
            localObject6 = new tlv_t(308);
            if (((tlv_t)localObject6).get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label4748;
            }
            localObject9[14] = ((tlv_t)localObject6).get_data();
            if ((t.ab) && ((this.u == 9) || (this.u == 15) || (this.u == 20)))
            {
              localObject6 = new tlv_t322();
              ((tlv_t322)localObject6).get_tlv((byte[])localObject8, 2, i5);
              localObject6 = ((tlv_t322)localObject6).get_data();
              if ((localObject6 == null) || (localObject6.length <= 0)) {
                break label4782;
              }
              localObject9[15] = localObject6;
              localObject6 = util.buf_to_string((byte[])localObject6);
              util.LOGI("get t322, value=" + (String)localObject6, "" + this.x.f);
            }
            util.LOGI("encrypt_a1 len:" + util.buf_len(localObject12[0]) + " no_pic_sig len:" + util.buf_len(localObject12[1]) + " G len:" + util.buf_len(localObject12[2]) + " dpwd len:" + util.buf_len(localObject12[3]) + " randseed len:" + util.buf_len(localObject12[4]) + " vkey len:" + util.buf_len(localObject9[0]) + " openid len:" + util.buf_len((byte[])localObject1) + " access_token len:" + util.buf_len(localObject9[1]) + " d2 len:" + util.buf_len(localObject9[2]) + " d2_key len:" + util.buf_len(localObject9[3]) + " sid len:" + util.buf_len(localObject9[4]) + " aq_sig len:" + util.buf_len(localObject9[5]) + " pskey len:" + util.buf_len(localObject9[6]) + " super_key len:" + util.buf_len(localObject9[7]) + " paytoken len:" + util.buf_len(localObject9[8]) + " pf len:" + util.buf_len(localObject9[9]) + " pfkey len:" + util.buf_len(localObject9[10]) + " da2 len:" + util.buf_len(localObject9[11]) + " wt session ticket:" + util.buf_len(localObject9[13]) + " wt session ticket key:" + util.buf_len(localObject9[14]) + " device_token len:" + util.buf_len(localObject9[15]), "" + this.x.f);
            if (localtlv_t11f.get_tlv((byte[])localObject8, 2, i5) < 0) {
              break label7286;
            }
          }
          for (long l3 = localtlv_t11f.get_tk_pri() & 0xFFFFFFFF;; l3 = 4294967295L)
          {
            localObject6 = new long[7];
            paramInt1 = 2;
            l1 = 2160000L;
            paramInt1 = ((tlv_t138)localObject7).get_tlv((byte[])localObject8, paramInt1, i5);
            if (paramInt1 >= 0)
            {
              if (((tlv_t138)localObject7).get_a2_chg_time() == 0) {
                break label7283;
              }
              l1 = ((tlv_t138)localObject7).get_a2_chg_time();
            }
            for (;;)
            {
              if (((tlv_t138)localObject7).get_lskey_chg_time() != 0)
              {
                localObject6[0] = ((tlv_t138)localObject7).get_lskey_chg_time();
                if (((tlv_t138)localObject7).get_skey_chg_time() == 0) {
                  break label4800;
                }
                localObject6[1] = ((tlv_t138)localObject7).get_skey_chg_time();
                if (((tlv_t138)localObject7).get_vkey_chg_time() == 0) {
                  break label4810;
                }
                localObject6[2] = ((tlv_t138)localObject7).get_vkey_chg_time();
                if (((tlv_t138)localObject7).get_a8_chg_time() == 0) {
                  break label4820;
                }
                localObject6[3] = ((tlv_t138)localObject7).get_a8_chg_time();
                if (((tlv_t138)localObject7).get_stweb_chg_time() == 0) {
                  break label4830;
                }
                localObject6[4] = ((tlv_t138)localObject7).get_stweb_chg_time();
                if (((tlv_t138)localObject7).get_d2_chg_time() == 0) {
                  break label4840;
                }
                localObject6[5] = ((tlv_t138)localObject7).get_d2_chg_time();
              }
              for (;;)
              {
                if (((tlv_t138)localObject7).get_sid_chg_time() == 0) {
                  break label4850;
                }
                localObject6[6] = ((tlv_t138)localObject7).get_sid_chg_time();
                break label4533;
                util.LOGI("no DA2 in rsp", "");
                break;
                WloginSigInfo._QRPUSHSig = new byte[0];
                break label3910;
                util.LOGW("get t133 failed", "" + this.x.f);
                break label3945;
                util.LOGW("get t134 failed", "" + this.x.f);
                break label3980;
                localObject6 = "null";
                break label4065;
                localObject6[0] = 1641600L;
                break label4582;
                localObject6[1] = 86400L;
                break label4600;
                localObject6[2] = 1728000L;
                break label4618;
                localObject6[3] = 72000L;
                break label4636;
                localObject6[4] = 6000L;
                break label4654;
                localObject6[5] = 1728000L;
              }
              localObject6[6] = 1728000L;
              break label4533;
              util.LOGI("sappid:" + l4 + " appid:" + l5 + " app_pri:" + l3 + " login_bitmap:" + localasync_context._login_bitmap + " tk_valid:" + 0L + " a2_valid:" + l1 + " lskey_valid:" + localObject6[0] + " skey_valid:" + localObject6[1] + " vkey_valid:" + localObject6[2] + " a8_valid:" + localObject6[3] + " stweb_valid:" + localObject6[4] + " d2_valid:" + localObject6[5] + " sid_valid:" + localObject6[6], "" + this.x.f);
              localObject7 = new WloginSimpleInfo();
              ((WloginSimpleInfo)localObject7).setUin(this.x.f);
              ((WloginSimpleInfo)localObject7).setFace(localtlv_t11a.get_face());
              ((WloginSimpleInfo)localObject7).setAge(localtlv_t11a.get_age());
              ((WloginSimpleInfo)localObject7).setGender(localtlv_t11a.get_gender());
              ((WloginSimpleInfo)localObject7).setNick(localtlv_t11a.get_nick());
              ((WloginSimpleInfo)localObject7).setReserveUinInfo((byte[][])localObject13);
              ((WloginSimpleInfo)localObject7).setMainDisplayName(localtlv_t118.get_data());
              this.x.at = localasync_context._main_sigmap;
              paramInt1 = this.x.a(this.x.f, l4, (byte[][])localObject12, l5, l3, t.f(), t.f() + 0L, t.f() + l1, (WloginSimpleInfo)localObject7, localtlv_t10a.get_data(), localtlv_t10d.get_data(), localtlv_t114.get_data(), localtlv_t10e.get_data(), (byte[])localObject2, arrayOfByte2, arrayOfByte1, arrayOfByte3, arrayOfByte4, arrayOfByte5, (byte[])localObject1, arrayOfByte6, (byte[][])localObject9, (long[])localObject6, localasync_context._login_bitmap);
              if (paramInt1 != 0)
              {
                localObject1 = new ErrMsg();
                ((ErrMsg)localObject1).setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
                a((ErrMsg)localObject1);
                util.LOGI("put_siginfo fail,ret=" + paramInt1, "" + this.x.f);
                break;
              }
              paramInt1 = i2;
              if (localObject5 != null)
              {
                paramInt1 = i2;
                if (0L != l2)
                {
                  paramInt1 = localObject12.length;
                  localObject1 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt1, 0 });
                  localObject1[0] = localObject5;
                  localObject1[1] = localObject4;
                  paramInt1 = localObject9.length;
                  localObject2 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt1, 0 });
                  i3 = this.x.a(l2, 16L, (byte[][])localObject1, 16L, l3, t.f(), t.f() + 0L, t.f() + l1, (WloginSimpleInfo)localObject7, null, null, null, null, null, null, null, null, null, null, null, null, (byte[][])localObject2, (long[])localObject6, localasync_context._login_bitmap);
                  paramInt1 = i2;
                  if (i3 != 0)
                  {
                    localObject1 = new ErrMsg();
                    ((ErrMsg)localObject1).setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
                    a((ErrMsg)localObject1);
                    util.LOGI("put_siginfo fail " + i3, "" + l2);
                    paramInt1 = i3;
                    break;
                  }
                }
              }
              for (;;)
              {
                paramInt1 = localtlv_t11d.get_tlv((byte[])localObject8, paramInt1, i5);
                if (paramInt1 < 0) {
                  break;
                }
                this.x.a(this.x.f, localtlv_t11d.get_appid(), t.f(), t.f() + 0L, localtlv_t11d.get_st(), localtlv_t11d.get_stkey());
              }
              paramInt1 = 0;
              break;
              util.LOGI("cmd " + Integer.toHexString(this.t) + " subcmd " + Integer.toHexString(this.u) + " result " + i1 + " will clean sig for uin " + this.x.f + " appid " + l4, "");
              this.x.e(this.x.f, l4);
              c(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i1;
              break;
              i2 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              localasync_context._t104 = localtlv_t104;
              localObject1 = new tlv_t192();
              if (((tlv_t192)localObject1).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
              {
                a(new ErrMsg(i1, "", "", ((tlv_t192)localObject1).getUrl()));
                paramInt1 = i1;
                break;
              }
              i2 = localtlv_t105.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              localasync_context._t105 = localtlv_t105;
              if (localtlv_t165.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {}
              for (localasync_context._t165 = localtlv_t165;; localasync_context._t165 = new tlv_t165())
              {
                a(null);
                break;
              }
              this.x.e(this.x.f, l4);
              i2 = localtlv_t130.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              this.x.a(localtlv_t130.get_time(), localtlv_t130.get_ipaddr());
              c(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i1;
              break;
              localObject1 = new tlv_t(405);
              i2 = ((tlv_t)localObject1).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              WloginSigInfo._LHSig = ((tlv_t)localObject1).get_data();
              c(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i1;
              break;
              if (localtlv_t113.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
              {
                this.x.f = localtlv_t113.get_uin();
                this.x.a(this.x.g, Long.valueOf(this.x.f));
              }
              i2 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              localasync_context._t104 = localtlv_t104;
              i2 = localtlv_t174.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              localasync_context._t174 = localtlv_t174;
              if (localtlv_t178.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
              {
                localasync_context._devlock_info.CountryCode = new String(localtlv_t178.get_country_code());
                localasync_context._devlock_info.Mobile = new String(localtlv_t178.get_mobile());
                localasync_context._devlock_info.MbItemSmsCodeStatus = localtlv_t178.get_smscode_status();
                localasync_context._devlock_info.AvailableMsgCount = localtlv_t178.get_available_msg_cnt();
                localasync_context._devlock_info.TimeLimit = localtlv_t178.get_time_limit();
              }
              localObject1 = new tlv_t196();
              if (((tlv_t196)localObject1).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
              {
                localasync_context._devlock_info.BakCountryCode = ((tlv_t196)localObject1).getCountryCode();
                localasync_context._devlock_info.BakMobile = ((tlv_t196)localObject1).getBakMobile();
                localasync_context._devlock_info.BakMobileState = ((tlv_t196)localObject1).getBakMobileState();
              }
              localObject1 = new tlv_t204();
              if (((tlv_t204)localObject1).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) > 0) {
                localasync_context._devlock_info.OtherDevLockVerifyUrl = new String(((tlv_t204)localObject1).get_data());
              }
              if (((tlv_t179)localObject8).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
                localasync_context._devlock_info.UnionVerifyUrl = new String(((tlv_t179)localObject8).get_verify_url());
              }
              if (((tlv_t17d)localObject14).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
              {
                localasync_context._devlock_info.MbGuideType = ((tlv_t17d)localObject14).get_mb_guide_type();
                localasync_context._devlock_info.MbGuideMsg = new String(((tlv_t17d)localObject14).get_mb_guide_msg());
                localasync_context._devlock_info.MbGuideInfoType = ((tlv_t17d)localObject14).get_mb_guide_info_type();
                localasync_context._devlock_info.MbGuideInfo = new String(((tlv_t17d)localObject14).get_mb_guide_info());
              }
              if (localtlv_t17e.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0) {
                localasync_context._devlock_info.VerifyReason = new String(localtlv_t17e.get_data());
              }
              if (localtlv_t402.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
              {
                localasync_context._t402 = localtlv_t402;
                if (((tlv_t403)localObject9).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) < 0) {
                  break label6645;
                }
              }
              for (localasync_context._t403 = ((tlv_t403)localObject9);; localasync_context._t403 = new tlv_t403())
              {
                c(paramArrayOfByte, i4, this.c - i4 - 1);
                paramInt1 = i1;
                break;
                localasync_context._t402 = new tlv_t402();
                break label6581;
              }
              c(paramArrayOfByte, i4, this.c - i4 - 1);
              this.x.a(this.x.g);
              paramInt1 = i1;
              break;
              i2 = localtlv_t161.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              a(localtlv_t161);
              c(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i1;
              break;
              if (localtlv_t113.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1) >= 0)
              {
                this.x.f = localtlv_t113.get_uin();
                this.x.a(this.x.g, Long.valueOf(this.x.f));
              }
              i2 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              localasync_context._t104 = localtlv_t104;
              i2 = localtlv_t402.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              localasync_context._t402 = localtlv_t402;
              i2 = ((tlv_t403)localObject9).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              localasync_context._t403 = ((tlv_t403)localObject9);
              c(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i1;
              break;
              i2 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              localasync_context._t104 = localtlv_t104;
              i2 = localtlv_t126.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              localasync_context._t126 = localtlv_t126;
              i2 = localtlv_t182.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              localasync_context._smslogin_msgcnt = localtlv_t182.getMsgCnt();
              localasync_context._smslogin_timelimit = localtlv_t182.getTimeLimit();
              i2 = localtlv_t183.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              localasync_context._msalt = localtlv_t183.getMsalt();
              paramInt1 = 0;
              break;
              i2 = localtlv_t104.get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              localObject1 = new tlv_t52b();
              i2 = ((tlv_t52b)localObject1).get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              paramInt1 = i2;
              if (i2 < 0) {
                break;
              }
              t.al = localtlv_t104.get_data();
              localasync_context._smslogin_zone = ((tlv_t52b)localObject1).get_zone();
              localasync_context._smslogin_hint_mobile = ((tlv_t52b)localObject1).get_mobile();
              paramInt1 = 0;
              break;
              localObject1 = Integer.valueOf(paramInt1);
              break label874;
              new tlv_t508().get_tlv(paramArrayOfByte, i4, this.c - i4 - 1);
              i1 = paramInt1;
              if (!tlv_t508.doFetch) {
                break label924;
              }
              paramArrayOfByte = new ErrMsg();
              i2 = new h(this.x, this.t, this.u, paramArrayOfByte).b(paramInt1);
              i1 = paramInt1;
              if (i2 == -1000) {
                break label924;
              }
              a(paramArrayOfByte);
              i1 = i2;
              break label924;
            }
          }
        }
        label6645:
        label7286:
        localObject1 = null;
      }
      label4065:
      label4582:
      label4840:
      paramInt2 = 0;
    }
  }
  
  public String d(boolean paramBoolean)
  {
    new String();
    if (paramBoolean) {
      return "sslv6.wlogin.qq.com";
    }
    return "wlogin-v6.qq.com";
  }
  
  public Socket d()
  {
    return this.x.am;
  }
  
  /* Error */
  public int e()
  {
    // Byte code:
    //   0: new 460	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 677	java/lang/Object:getClass	()Ljava/lang/Class;
    //   11: invokevirtual 682	java/lang/Class:getName	()Ljava/lang/String;
    //   14: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 1681
    //   20: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: new 460	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   33: ldc 110
    //   35: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   42: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   45: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: invokevirtual 687	oicq/wlogin_sdk/request/oicq_request:c	()[B
    //   58: astore 22
    //   60: iconst_0
    //   61: istore_3
    //   62: iconst_0
    //   63: istore_1
    //   64: iconst_0
    //   65: istore_2
    //   66: aload_0
    //   67: invokevirtual 1683	oicq/wlogin_sdk/request/oicq_request:d	()Ljava/net/Socket;
    //   70: astore 15
    //   72: iconst_0
    //   73: istore 9
    //   75: iconst_0
    //   76: istore 8
    //   78: iconst_0
    //   79: istore 4
    //   81: ldc 110
    //   83: astore 16
    //   85: ldc 110
    //   87: astore 14
    //   89: lconst_0
    //   90: lstore 12
    //   92: iload_2
    //   93: bipush 10
    //   95: if_icmpge +3397 -> 3492
    //   98: iload_2
    //   99: ifeq +9 -> 108
    //   102: getstatic 396	oicq/wlogin_sdk/request/t:t	Landroid/content/Context;
    //   105: invokestatic 1686	oicq/wlogin_sdk/tools/util:chg_retry_type	(Landroid/content/Context;)V
    //   108: getstatic 396	oicq/wlogin_sdk/request/t:t	Landroid/content/Context;
    //   111: invokestatic 1690	oicq/wlogin_sdk/tools/util:is_wap_retry	(Landroid/content/Context;)Z
    //   114: istore 11
    //   116: aload_0
    //   117: aconst_null
    //   118: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   121: iload_2
    //   122: ifeq +27 -> 149
    //   125: aload_0
    //   126: getfield 156	oicq/wlogin_sdk/request/oicq_request:t	I
    //   129: sipush 2066
    //   132: if_icmpeq +17 -> 149
    //   135: aload_0
    //   136: iload_1
    //   137: lload 12
    //   139: iload 4
    //   141: iload_2
    //   142: iload 11
    //   144: iload 8
    //   146: invokespecial 1692	oicq/wlogin_sdk/request/oicq_request:a	(IJIIZZ)V
    //   149: invokestatic 218	java/lang/System:currentTimeMillis	()J
    //   152: lstore 12
    //   154: iload 11
    //   156: ifeq +1510 -> 1666
    //   159: new 460	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 1694
    //   169: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: iload_2
    //   173: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: ldc_w 1696
    //   179: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: new 460	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   192: ldc 110
    //   194: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   201: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   204: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: iload_2
    //   215: iload 11
    //   217: invokevirtual 1698	oicq/wlogin_sdk/request/oicq_request:a	(IZ)Ljava/lang/String;
    //   220: astore 21
    //   222: iload 8
    //   224: istore 9
    //   226: iload 8
    //   228: istore 10
    //   230: getstatic 396	oicq/wlogin_sdk/request/t:t	Landroid/content/Context;
    //   233: invokestatic 1701	oicq/wlogin_sdk/tools/util:is_wap_proxy_retry	(Landroid/content/Context;)Z
    //   236: istore 8
    //   238: iload 8
    //   240: ifeq +3243 -> 3483
    //   243: iload 8
    //   245: istore 9
    //   247: iload 8
    //   249: istore 10
    //   251: invokestatic 1704	oicq/wlogin_sdk/tools/util:get_proxy_ip	()Ljava/lang/String;
    //   254: astore 17
    //   256: iload 8
    //   258: istore 9
    //   260: iload 8
    //   262: istore 10
    //   264: invokestatic 1707	oicq/wlogin_sdk/tools/util:get_proxy_port	()I
    //   267: istore 5
    //   269: aload 17
    //   271: ifnull +25 -> 296
    //   274: iload 8
    //   276: istore 9
    //   278: iload 8
    //   280: istore 10
    //   282: aload 17
    //   284: invokevirtual 394	java/lang/String:length	()I
    //   287: ifle +9 -> 296
    //   290: iload 5
    //   292: iconst_m1
    //   293: if_icmpne +3205 -> 3498
    //   296: iconst_0
    //   297: istore 10
    //   299: iconst_0
    //   300: istore 8
    //   302: iconst_0
    //   303: istore 9
    //   305: new 460	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 1709
    //   315: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload 17
    //   320: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: ldc_w 1711
    //   326: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: iload 5
    //   331: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   334: ldc_w 1713
    //   337: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: iconst_0
    //   341: invokevirtual 698	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   344: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: new 460	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   354: ldc 110
    //   356: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_0
    //   360: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   363: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   366: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   369: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: goto +3123 -> 3498
    //   378: iload 8
    //   380: ifeq +495 -> 875
    //   383: iload 8
    //   385: istore 9
    //   387: iload 8
    //   389: istore 10
    //   391: new 1715	java/net/URL
    //   394: dup
    //   395: new 460	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 1717
    //   405: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload 17
    //   410: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc_w 1083
    //   416: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: iload 5
    //   421: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   424: ldc_w 1719
    //   427: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokespecial 1721	java/net/URL:<init>	(Ljava/lang/String;)V
    //   436: astore 19
    //   438: iload_1
    //   439: istore 5
    //   441: aload 14
    //   443: astore 17
    //   445: aload 14
    //   447: astore 18
    //   449: new 460	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 1723
    //   459: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: iload 8
    //   464: invokevirtual 698	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   467: ldc_w 1725
    //   470: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 19
    //   475: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   478: ldc_w 1727
    //   481: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload 21
    //   486: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: new 460	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   499: ldc 110
    //   501: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload_0
    //   505: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   508: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   511: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   514: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: iload_1
    //   521: istore 5
    //   523: aload 14
    //   525: astore 17
    //   527: aload 14
    //   529: astore 18
    //   531: aload 19
    //   533: invokevirtual 1731	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   536: checkcast 1733	java/net/HttpURLConnection
    //   539: astore 19
    //   541: iload_1
    //   542: istore 5
    //   544: aload 14
    //   546: astore 17
    //   548: aload 14
    //   550: astore 18
    //   552: aload 19
    //   554: ldc_w 1735
    //   557: invokevirtual 1738	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   560: iload 8
    //   562: ifeq +24 -> 586
    //   565: iload_1
    //   566: istore 5
    //   568: aload 14
    //   570: astore 17
    //   572: aload 14
    //   574: astore 18
    //   576: aload 19
    //   578: ldc_w 1740
    //   581: aload 21
    //   583: invokevirtual 1743	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: iload_1
    //   587: istore 5
    //   589: aload 14
    //   591: astore 17
    //   593: aload 14
    //   595: astore 18
    //   597: aload 19
    //   599: ldc_w 1745
    //   602: ldc_w 1747
    //   605: invokevirtual 1743	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: iload_1
    //   609: istore 5
    //   611: aload 14
    //   613: astore 17
    //   615: aload 14
    //   617: astore 18
    //   619: aload 19
    //   621: ldc_w 1749
    //   624: ldc_w 1751
    //   627: invokevirtual 1743	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: iload_1
    //   631: istore 5
    //   633: aload 14
    //   635: astore 17
    //   637: aload 14
    //   639: astore 18
    //   641: aload 19
    //   643: ldc_w 1753
    //   646: aload 22
    //   648: arraylength
    //   649: invokestatic 1755	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   652: invokevirtual 1743	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   655: iload_1
    //   656: istore 5
    //   658: aload 14
    //   660: astore 17
    //   662: aload 14
    //   664: astore 18
    //   666: aload 19
    //   668: aload_0
    //   669: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   672: getfield 685	oicq/wlogin_sdk/request/t:l	I
    //   675: invokevirtual 1758	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   678: iload_1
    //   679: istore 5
    //   681: aload 14
    //   683: astore 17
    //   685: aload 14
    //   687: astore 18
    //   689: aload 19
    //   691: aload_0
    //   692: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   695: getfield 685	oicq/wlogin_sdk/request/t:l	I
    //   698: invokevirtual 1761	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   701: iload_1
    //   702: istore 5
    //   704: aload 14
    //   706: astore 17
    //   708: aload 14
    //   710: astore 18
    //   712: aload 19
    //   714: iconst_1
    //   715: invokevirtual 1765	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   718: iload_1
    //   719: istore 5
    //   721: aload 14
    //   723: astore 17
    //   725: aload 14
    //   727: astore 18
    //   729: aload 19
    //   731: iconst_1
    //   732: invokevirtual 1768	java/net/HttpURLConnection:setDoInput	(Z)V
    //   735: iload_1
    //   736: istore 5
    //   738: aload 14
    //   740: astore 17
    //   742: aload 14
    //   744: astore 18
    //   746: ldc_w 1770
    //   749: new 460	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   756: ldc 110
    //   758: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: aload_0
    //   762: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   765: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   768: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   771: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   777: iload_1
    //   778: istore 5
    //   780: aload 14
    //   782: astore 17
    //   784: aload 14
    //   786: astore 18
    //   788: aload 19
    //   790: aload_0
    //   791: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   794: getfield 685	oicq/wlogin_sdk/request/t:l	I
    //   797: i2l
    //   798: invokestatic 1775	oicq/wlogin_sdk/request/i:a	(Ljava/net/HttpURLConnection;J)Z
    //   801: ifne +314 -> 1115
    //   804: iload_1
    //   805: istore 5
    //   807: aload 14
    //   809: astore 17
    //   811: aload 14
    //   813: astore 18
    //   815: ldc_w 1777
    //   818: new 460	java/lang/StringBuilder
    //   821: dup
    //   822: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   825: ldc 110
    //   827: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: aload_0
    //   831: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   834: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   837: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   840: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   846: iload_1
    //   847: istore 5
    //   849: sipush -1026
    //   852: iload_1
    //   853: if_icmpeq +8 -> 861
    //   856: sipush -1000
    //   859: istore 5
    //   861: iload_2
    //   862: iconst_1
    //   863: iadd
    //   864: istore_2
    //   865: iload 5
    //   867: istore_1
    //   868: iload 11
    //   870: istore 9
    //   872: goto -780 -> 92
    //   875: iload 8
    //   877: istore 9
    //   879: iload 8
    //   881: istore 10
    //   883: aload_0
    //   884: aload 21
    //   886: iconst_0
    //   887: aload_0
    //   888: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   891: getfield 685	oicq/wlogin_sdk/request/t:l	I
    //   894: i2l
    //   895: invokestatic 1782	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   898: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   901: iload 8
    //   903: istore 9
    //   905: iload 8
    //   907: istore 10
    //   909: aload_0
    //   910: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   913: ifnull +2563 -> 3476
    //   916: iload 8
    //   918: istore 9
    //   920: iload 8
    //   922: istore 10
    //   924: aload_0
    //   925: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   928: invokevirtual 274	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   931: invokevirtual 280	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   934: astore 19
    //   936: iload 8
    //   938: istore 9
    //   940: iload 8
    //   942: istore 10
    //   944: aload 14
    //   946: aload 19
    //   948: invokevirtual 1786	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   951: ifeq +90 -> 1041
    //   954: iload 8
    //   956: istore 9
    //   958: iload 8
    //   960: istore 10
    //   962: new 536	java/lang/Exception
    //   965: dup
    //   966: new 460	java/lang/StringBuilder
    //   969: dup
    //   970: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   973: ldc_w 1788
    //   976: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: aload 14
    //   981: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokespecial 1789	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   990: athrow
    //   991: astore 17
    //   993: iload 9
    //   995: istore 8
    //   997: new 460	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1004: ldc_w 1791
    //   1007: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: aload 17
    //   1012: invokevirtual 1792	java/net/ConnectException:toString	()Ljava/lang/String;
    //   1015: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1021: ldc 110
    //   1023: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1026: iload_2
    //   1027: iconst_1
    //   1028: iadd
    //   1029: istore_2
    //   1030: sipush -1026
    //   1033: istore_1
    //   1034: iload 11
    //   1036: istore 9
    //   1038: goto -946 -> 92
    //   1041: iload_1
    //   1042: istore 5
    //   1044: aload 19
    //   1046: astore 17
    //   1048: aload 19
    //   1050: astore 18
    //   1052: aload_0
    //   1053: aconst_null
    //   1054: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1057: aload 19
    //   1059: astore 20
    //   1061: aload 19
    //   1063: astore 14
    //   1065: iload_1
    //   1066: istore 5
    //   1068: aload 14
    //   1070: astore 17
    //   1072: aload 14
    //   1074: astore 18
    //   1076: new 1715	java/net/URL
    //   1079: dup
    //   1080: new 460	java/lang/StringBuilder
    //   1083: dup
    //   1084: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1087: ldc_w 1717
    //   1090: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: aload 20
    //   1095: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: ldc_w 1719
    //   1101: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1107: invokespecial 1721	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1110: astore 19
    //   1112: goto -674 -> 438
    //   1115: iload_1
    //   1116: istore 5
    //   1118: aload 14
    //   1120: astore 17
    //   1122: aload 14
    //   1124: astore 18
    //   1126: ldc_w 1794
    //   1129: new 460	java/lang/StringBuilder
    //   1132: dup
    //   1133: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1136: ldc 110
    //   1138: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: aload_0
    //   1142: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1145: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   1148: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1151: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1154: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1157: iload_1
    //   1158: istore 5
    //   1160: aload 14
    //   1162: astore 17
    //   1164: aload 14
    //   1166: astore 18
    //   1168: aload 19
    //   1170: invokevirtual 1798	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1173: astore 20
    //   1175: iload_1
    //   1176: istore 5
    //   1178: aload 14
    //   1180: astore 17
    //   1182: aload 14
    //   1184: astore 18
    //   1186: aload 20
    //   1188: aload 22
    //   1190: iconst_0
    //   1191: aload 22
    //   1193: arraylength
    //   1194: invokevirtual 1803	java/io/OutputStream:write	([BII)V
    //   1197: iload_1
    //   1198: istore 5
    //   1200: aload 14
    //   1202: astore 17
    //   1204: aload 14
    //   1206: astore 18
    //   1208: aload 20
    //   1210: invokevirtual 1806	java/io/OutputStream:flush	()V
    //   1213: iload_1
    //   1214: istore 5
    //   1216: aload 14
    //   1218: astore 17
    //   1220: aload 14
    //   1222: astore 18
    //   1224: aload 19
    //   1226: invokevirtual 1809	java/net/HttpURLConnection:getResponseCode	()I
    //   1229: istore_1
    //   1230: iload_1
    //   1231: istore 5
    //   1233: aload 14
    //   1235: astore 17
    //   1237: aload 14
    //   1239: astore 18
    //   1241: new 460	java/lang/StringBuilder
    //   1244: dup
    //   1245: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1248: ldc_w 1811
    //   1251: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: iload_1
    //   1255: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1258: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1261: new 460	java/lang/StringBuilder
    //   1264: dup
    //   1265: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1268: ldc 110
    //   1270: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: aload_0
    //   1274: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1277: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   1280: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1283: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1286: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1289: sipush 200
    //   1292: iload_1
    //   1293: if_icmpeq +54 -> 1347
    //   1296: iload_1
    //   1297: istore 5
    //   1299: aload 14
    //   1301: astore 17
    //   1303: aload 14
    //   1305: astore 18
    //   1307: new 460	java/lang/StringBuilder
    //   1310: dup
    //   1311: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1314: ldc_w 1813
    //   1317: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: iload_1
    //   1321: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: ldc 110
    //   1329: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1332: sipush -1000
    //   1335: istore_1
    //   1336: iload_2
    //   1337: iconst_1
    //   1338: iadd
    //   1339: istore_2
    //   1340: iload 11
    //   1342: istore 9
    //   1344: goto -1252 -> 92
    //   1347: iload_1
    //   1348: istore 5
    //   1350: aload 14
    //   1352: astore 17
    //   1354: aload 14
    //   1356: astore 18
    //   1358: aload 19
    //   1360: invokevirtual 1817	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1363: astore 19
    //   1365: aload 19
    //   1367: astore 18
    //   1369: aload 15
    //   1371: astore 19
    //   1373: aload 16
    //   1375: astore 17
    //   1377: aload 14
    //   1379: astore 15
    //   1381: aload 19
    //   1383: astore 14
    //   1385: aload 14
    //   1387: astore 16
    //   1389: iload_2
    //   1390: istore_1
    //   1391: ldc_w 1819
    //   1394: new 460	java/lang/StringBuilder
    //   1397: dup
    //   1398: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1401: ldc 110
    //   1403: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: aload_0
    //   1407: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1410: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   1413: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1416: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1419: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1422: iconst_0
    //   1423: istore 5
    //   1425: iconst_0
    //   1426: istore 6
    //   1428: aload 14
    //   1430: astore 16
    //   1432: iload_2
    //   1433: istore_1
    //   1434: iload 6
    //   1436: aload_0
    //   1437: getfield 128	oicq/wlogin_sdk/request/oicq_request:f	I
    //   1440: iconst_1
    //   1441: iadd
    //   1442: if_icmpge +36 -> 1478
    //   1445: aload 14
    //   1447: astore 16
    //   1449: iload_2
    //   1450: istore_1
    //   1451: aload 18
    //   1453: aload_0
    //   1454: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   1457: iload 6
    //   1459: aload_0
    //   1460: getfield 128	oicq/wlogin_sdk/request/oicq_request:f	I
    //   1463: iconst_1
    //   1464: iadd
    //   1465: iload 6
    //   1467: isub
    //   1468: invokevirtual 1824	java/io/InputStream:read	([BII)I
    //   1471: istore 5
    //   1473: iload 5
    //   1475: ifge +1091 -> 2566
    //   1478: iload 5
    //   1480: ifge +1096 -> 2576
    //   1483: aload 14
    //   1485: astore 16
    //   1487: iload_2
    //   1488: istore_1
    //   1489: new 460	java/lang/StringBuilder
    //   1492: dup
    //   1493: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1496: ldc_w 1826
    //   1499: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: iload 5
    //   1504: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1507: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1510: ldc 110
    //   1512: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1515: sipush -1000
    //   1518: istore 5
    //   1520: iload_2
    //   1521: iconst_1
    //   1522: iadd
    //   1523: istore_2
    //   1524: aload 14
    //   1526: astore 16
    //   1528: iload 11
    //   1530: ifne +42 -> 1572
    //   1533: aload 14
    //   1535: astore 16
    //   1537: iload_2
    //   1538: istore_1
    //   1539: aload 14
    //   1541: invokevirtual 1831	java/net/Socket:close	()V
    //   1544: aload 14
    //   1546: astore 16
    //   1548: iload_2
    //   1549: istore_1
    //   1550: aload_0
    //   1551: aconst_null
    //   1552: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1555: aconst_null
    //   1556: astore 16
    //   1558: aconst_null
    //   1559: astore 14
    //   1561: iload_2
    //   1562: istore_1
    //   1563: aload_0
    //   1564: aconst_null
    //   1565: invokevirtual 1833	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   1568: aload 14
    //   1570: astore 16
    //   1572: aload 15
    //   1574: astore 14
    //   1576: aload 16
    //   1578: astore 15
    //   1580: iload 5
    //   1582: istore_1
    //   1583: iload 11
    //   1585: istore 9
    //   1587: aload 17
    //   1589: astore 16
    //   1591: goto -1499 -> 92
    //   1594: astore 18
    //   1596: iload 10
    //   1598: istore 8
    //   1600: aload 14
    //   1602: astore 17
    //   1604: iload_1
    //   1605: istore 5
    //   1607: new 460	java/lang/StringBuilder
    //   1610: dup
    //   1611: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1614: ldc_w 1835
    //   1617: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: aload 18
    //   1622: invokevirtual 1836	java/lang/Exception:toString	()Ljava/lang/String;
    //   1625: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1631: ldc 110
    //   1633: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1636: iload 5
    //   1638: istore_1
    //   1639: sipush -1026
    //   1642: iload 5
    //   1644: if_icmpeq +7 -> 1651
    //   1647: sipush -1000
    //   1650: istore_1
    //   1651: iload_2
    //   1652: iconst_1
    //   1653: iadd
    //   1654: istore_2
    //   1655: aload 17
    //   1657: astore 14
    //   1659: iload 11
    //   1661: istore 9
    //   1663: goto -1571 -> 92
    //   1666: new 460	java/lang/StringBuilder
    //   1669: dup
    //   1670: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1673: ldc_w 1838
    //   1676: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1679: iload_2
    //   1680: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1683: ldc_w 1696
    //   1686: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1689: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1692: new 460	java/lang/StringBuilder
    //   1695: dup
    //   1696: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1699: ldc 110
    //   1701: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1704: aload_0
    //   1705: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1708: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   1711: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1714: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1717: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1720: aload 15
    //   1722: ifnonnull +1751 -> 3473
    //   1725: ldc 110
    //   1727: astore 17
    //   1729: iconst_1
    //   1730: istore 4
    //   1732: iconst_1
    //   1733: istore 5
    //   1735: aload_0
    //   1736: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1739: ifnonnull +98 -> 1837
    //   1742: aload_0
    //   1743: iload_2
    //   1744: iload 11
    //   1746: invokevirtual 1698	oicq/wlogin_sdk/request/oicq_request:a	(IZ)Ljava/lang/String;
    //   1749: astore 17
    //   1751: new 460	java/lang/StringBuilder
    //   1754: dup
    //   1755: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1758: ldc_w 1840
    //   1761: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: aload 17
    //   1766: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1769: ldc_w 1842
    //   1772: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1778: new 460	java/lang/StringBuilder
    //   1781: dup
    //   1782: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1785: ldc 110
    //   1787: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: aload_0
    //   1791: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1794: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   1797: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1800: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1803: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1806: aload_0
    //   1807: aload_0
    //   1808: iload 11
    //   1810: invokevirtual 233	oicq/wlogin_sdk/request/oicq_request:e	(Z)I
    //   1813: putfield 152	oicq/wlogin_sdk/request/oicq_request:r	I
    //   1816: aload_0
    //   1817: aload 17
    //   1819: aload_0
    //   1820: getfield 152	oicq/wlogin_sdk/request/oicq_request:r	I
    //   1823: aload_0
    //   1824: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1827: getfield 685	oicq/wlogin_sdk/request/t:l	I
    //   1830: i2l
    //   1831: invokestatic 1782	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   1834: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1837: aload_0
    //   1838: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1841: ifnull +86 -> 1927
    //   1844: aload_0
    //   1845: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1848: invokevirtual 274	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1851: ifnonnull +76 -> 1927
    //   1854: aload_0
    //   1855: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1858: invokevirtual 274	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1861: ifnonnull +34 -> 1895
    //   1864: ldc_w 1844
    //   1867: new 460	java/lang/StringBuilder
    //   1870: dup
    //   1871: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1874: ldc 110
    //   1876: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1879: aload_0
    //   1880: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1883: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   1886: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1889: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1892: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1895: sipush -1007
    //   1898: istore_1
    //   1899: iload_2
    //   1900: iconst_1
    //   1901: iadd
    //   1902: istore_2
    //   1903: aload_0
    //   1904: aconst_null
    //   1905: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1908: aconst_null
    //   1909: astore 15
    //   1911: aload_0
    //   1912: aconst_null
    //   1913: invokevirtual 1833	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   1916: iload 5
    //   1918: istore 4
    //   1920: iload 11
    //   1922: istore 9
    //   1924: goto -1832 -> 92
    //   1927: aload_0
    //   1928: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1931: ifnonnull +168 -> 2099
    //   1934: aload_0
    //   1935: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1938: ifnonnull +94 -> 2032
    //   1941: new 460	java/lang/StringBuilder
    //   1944: dup
    //   1945: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1948: ldc_w 1840
    //   1951: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1954: aload 17
    //   1956: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1959: ldc_w 1846
    //   1962: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1968: new 460	java/lang/StringBuilder
    //   1971: dup
    //   1972: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   1975: ldc 110
    //   1977: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1980: aload_0
    //   1981: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1984: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   1987: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1990: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1993: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1996: sipush -1007
    //   1999: istore 4
    //   2001: iload_2
    //   2002: iconst_1
    //   2003: iadd
    //   2004: istore_2
    //   2005: aload_0
    //   2006: aconst_null
    //   2007: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2010: aconst_null
    //   2011: astore 15
    //   2013: aload_0
    //   2014: aconst_null
    //   2015: invokevirtual 1833	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2018: iload 4
    //   2020: istore_1
    //   2021: iload 5
    //   2023: istore 4
    //   2025: iload 11
    //   2027: istore 9
    //   2029: goto -1937 -> 92
    //   2032: new 460	java/lang/StringBuilder
    //   2035: dup
    //   2036: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2039: ldc_w 1848
    //   2042: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2045: aload 16
    //   2047: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2050: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2053: new 460	java/lang/StringBuilder
    //   2056: dup
    //   2057: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2060: ldc 110
    //   2062: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: aload_0
    //   2066: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2069: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   2072: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2075: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2078: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2081: iload_1
    //   2082: istore 4
    //   2084: sipush -1026
    //   2087: iload_1
    //   2088: if_icmpeq -87 -> 2001
    //   2091: sipush -1000
    //   2094: istore 4
    //   2096: goto -95 -> 2001
    //   2099: aload_0
    //   2100: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2103: invokevirtual 274	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   2106: invokevirtual 280	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2109: astore 16
    //   2111: new 460	java/lang/StringBuilder
    //   2114: dup
    //   2115: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2118: ldc_w 1840
    //   2121: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2124: aload 17
    //   2126: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: ldc_w 1850
    //   2132: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2135: aload_0
    //   2136: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2139: invokevirtual 1851	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   2142: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2145: ldc_w 1853
    //   2148: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2151: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2154: new 460	java/lang/StringBuilder
    //   2157: dup
    //   2158: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2161: ldc 110
    //   2163: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2166: aload_0
    //   2167: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2170: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   2173: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2176: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2179: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2182: aload 15
    //   2184: ifnonnull +1286 -> 3470
    //   2187: new 460	java/lang/StringBuilder
    //   2190: dup
    //   2191: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2194: ldc_w 1855
    //   2197: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2200: aload_0
    //   2201: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2204: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2207: ldc_w 1842
    //   2210: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2213: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2216: new 460	java/lang/StringBuilder
    //   2219: dup
    //   2220: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2223: ldc 110
    //   2225: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2228: aload_0
    //   2229: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2232: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   2235: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2238: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2241: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2244: new 1828	java/net/Socket
    //   2247: dup
    //   2248: invokespecial 1856	java/net/Socket:<init>	()V
    //   2251: astore 15
    //   2253: aload_0
    //   2254: aload 15
    //   2256: invokevirtual 1833	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2259: aload 15
    //   2261: aload_0
    //   2262: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2265: aload_0
    //   2266: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2269: getfield 685	oicq/wlogin_sdk/request/t:l	I
    //   2272: invokevirtual 1860	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   2275: aload 15
    //   2277: aload_0
    //   2278: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2281: getfield 685	oicq/wlogin_sdk/request/t:l	I
    //   2284: invokevirtual 1863	java/net/Socket:setSoTimeout	(I)V
    //   2287: aload 15
    //   2289: aload_0
    //   2290: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2293: arraylength
    //   2294: invokevirtual 1866	java/net/Socket:setReceiveBufferSize	(I)V
    //   2297: new 460	java/lang/StringBuilder
    //   2300: dup
    //   2301: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2304: ldc_w 1855
    //   2307: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2310: aload_0
    //   2311: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2314: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2317: ldc_w 1868
    //   2320: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2323: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2326: new 460	java/lang/StringBuilder
    //   2329: dup
    //   2330: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2333: ldc 110
    //   2335: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2338: aload_0
    //   2339: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2342: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   2345: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2348: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2351: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2354: ldc_w 1870
    //   2357: new 460	java/lang/StringBuilder
    //   2360: dup
    //   2361: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2364: ldc 110
    //   2366: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2369: aload_0
    //   2370: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2373: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   2376: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2379: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2382: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2385: aload 15
    //   2387: invokevirtual 1871	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   2390: astore 17
    //   2392: aload 17
    //   2394: aload 22
    //   2396: iconst_0
    //   2397: aload 22
    //   2399: arraylength
    //   2400: invokevirtual 1803	java/io/OutputStream:write	([BII)V
    //   2403: aload 17
    //   2405: invokevirtual 1806	java/io/OutputStream:flush	()V
    //   2408: aload 15
    //   2410: invokevirtual 1872	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   2413: astore 18
    //   2415: aload 14
    //   2417: astore 17
    //   2419: aload 15
    //   2421: astore 14
    //   2423: aload 17
    //   2425: astore 15
    //   2427: aload 16
    //   2429: astore 17
    //   2431: goto -1046 -> 1385
    //   2434: astore 15
    //   2436: new 460	java/lang/StringBuilder
    //   2439: dup
    //   2440: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2443: ldc_w 1874
    //   2446: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2449: aload 15
    //   2451: invokevirtual 1792	java/net/ConnectException:toString	()Ljava/lang/String;
    //   2454: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2457: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2460: ldc 110
    //   2462: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2465: sipush -1026
    //   2468: istore_1
    //   2469: iload_2
    //   2470: iconst_1
    //   2471: iadd
    //   2472: istore_2
    //   2473: aload_0
    //   2474: aconst_null
    //   2475: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2478: aconst_null
    //   2479: astore 15
    //   2481: aload_0
    //   2482: aconst_null
    //   2483: invokevirtual 1833	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2486: iload 11
    //   2488: istore 9
    //   2490: goto -2398 -> 92
    //   2493: astore 15
    //   2495: new 460	java/lang/StringBuilder
    //   2498: dup
    //   2499: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2502: ldc_w 1876
    //   2505: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2508: aload 15
    //   2510: invokestatic 1185	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2513: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2516: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2519: ldc 110
    //   2521: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2524: iload_1
    //   2525: istore 5
    //   2527: sipush -1026
    //   2530: iload_1
    //   2531: if_icmpeq +8 -> 2539
    //   2534: sipush -1000
    //   2537: istore 5
    //   2539: iload_2
    //   2540: iconst_1
    //   2541: iadd
    //   2542: istore_2
    //   2543: aload_0
    //   2544: aconst_null
    //   2545: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2548: aconst_null
    //   2549: astore 15
    //   2551: aload_0
    //   2552: aconst_null
    //   2553: invokevirtual 1833	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2556: iload 5
    //   2558: istore_1
    //   2559: iload 11
    //   2561: istore 9
    //   2563: goto -2471 -> 92
    //   2566: iload 6
    //   2568: iload 5
    //   2570: iadd
    //   2571: istore 6
    //   2573: goto -1145 -> 1428
    //   2576: aload 14
    //   2578: astore 16
    //   2580: iload_2
    //   2581: istore_1
    //   2582: aload_0
    //   2583: aload_0
    //   2584: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2587: invokevirtual 1878	oicq/wlogin_sdk/request/oicq_request:b	([B)I
    //   2590: istore 6
    //   2592: iload 6
    //   2594: istore_1
    //   2595: aload 14
    //   2597: astore 16
    //   2599: iload_2
    //   2600: istore_3
    //   2601: iload_1
    //   2602: aload_0
    //   2603: getfield 128	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2606: iconst_1
    //   2607: iadd
    //   2608: if_icmpgt +107 -> 2715
    //   2611: aload 14
    //   2613: astore 16
    //   2615: iload_2
    //   2616: istore_3
    //   2617: new 460	java/lang/StringBuilder
    //   2620: dup
    //   2621: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2624: ldc_w 1880
    //   2627: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2630: iload_1
    //   2631: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2634: ldc_w 1882
    //   2637: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2640: aload_0
    //   2641: getfield 128	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2644: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2647: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2650: ldc 110
    //   2652: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2655: sipush -1000
    //   2658: istore 5
    //   2660: iload_2
    //   2661: iconst_1
    //   2662: iadd
    //   2663: istore_2
    //   2664: aload 14
    //   2666: astore 16
    //   2668: iload 11
    //   2670: ifne +840 -> 3510
    //   2673: aload 14
    //   2675: astore 16
    //   2677: iload_2
    //   2678: istore_3
    //   2679: aload 14
    //   2681: invokevirtual 1831	java/net/Socket:close	()V
    //   2684: aload 14
    //   2686: astore 16
    //   2688: iload_2
    //   2689: istore_3
    //   2690: aload_0
    //   2691: aconst_null
    //   2692: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2695: aconst_null
    //   2696: astore 14
    //   2698: aconst_null
    //   2699: astore 16
    //   2701: iload_2
    //   2702: istore_3
    //   2703: aload_0
    //   2704: aconst_null
    //   2705: invokevirtual 1833	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2708: aload 14
    //   2710: astore 16
    //   2712: goto +798 -> 3510
    //   2715: aload 14
    //   2717: astore 16
    //   2719: iload_2
    //   2720: istore_3
    //   2721: iload_1
    //   2722: aload_0
    //   2723: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2726: arraylength
    //   2727: if_icmplt +108 -> 2835
    //   2730: aload 14
    //   2732: astore 16
    //   2734: iload_2
    //   2735: istore_3
    //   2736: new 460	java/lang/StringBuilder
    //   2739: dup
    //   2740: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2743: ldc_w 1880
    //   2746: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2749: iload_1
    //   2750: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2753: ldc_w 1884
    //   2756: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2759: aload_0
    //   2760: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2763: arraylength
    //   2764: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2767: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2770: ldc 110
    //   2772: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2775: sipush -1000
    //   2778: istore 5
    //   2780: iload_2
    //   2781: iconst_1
    //   2782: iadd
    //   2783: istore_2
    //   2784: aload 14
    //   2786: astore 16
    //   2788: iload 11
    //   2790: ifne +744 -> 3534
    //   2793: aload 14
    //   2795: astore 16
    //   2797: iload_2
    //   2798: istore_3
    //   2799: aload 14
    //   2801: invokevirtual 1831	java/net/Socket:close	()V
    //   2804: aload 14
    //   2806: astore 16
    //   2808: iload_2
    //   2809: istore_3
    //   2810: aload_0
    //   2811: aconst_null
    //   2812: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2815: aconst_null
    //   2816: astore 14
    //   2818: aconst_null
    //   2819: astore 16
    //   2821: iload_2
    //   2822: istore_3
    //   2823: aload_0
    //   2824: aconst_null
    //   2825: invokevirtual 1833	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2828: aload 14
    //   2830: astore 16
    //   2832: goto +702 -> 3534
    //   2835: aload 14
    //   2837: astore 16
    //   2839: iload_2
    //   2840: istore_3
    //   2841: aload_0
    //   2842: getfield 128	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2845: iconst_1
    //   2846: iadd
    //   2847: istore 7
    //   2849: iload_1
    //   2850: iload 7
    //   2852: isub
    //   2853: istore 6
    //   2855: iload 6
    //   2857: ifle +30 -> 2887
    //   2860: aload 14
    //   2862: astore 16
    //   2864: iload_2
    //   2865: istore_3
    //   2866: aload 18
    //   2868: aload_0
    //   2869: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2872: iload 7
    //   2874: iload 6
    //   2876: invokevirtual 1824	java/io/InputStream:read	([BII)I
    //   2879: istore 5
    //   2881: iload 5
    //   2883: iconst_m1
    //   2884: if_icmpne +122 -> 3006
    //   2887: iload 5
    //   2889: iconst_m1
    //   2890: if_icmpne +133 -> 3023
    //   2893: aload 14
    //   2895: astore 16
    //   2897: iload_2
    //   2898: istore_3
    //   2899: new 460	java/lang/StringBuilder
    //   2902: dup
    //   2903: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   2906: ldc_w 1886
    //   2909: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2912: iload 5
    //   2914: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2917: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2920: ldc 110
    //   2922: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2925: sipush -1000
    //   2928: istore 5
    //   2930: iload_2
    //   2931: iconst_1
    //   2932: iadd
    //   2933: istore_2
    //   2934: aload 14
    //   2936: astore 16
    //   2938: iload 11
    //   2940: ifne +42 -> 2982
    //   2943: aload 14
    //   2945: astore 16
    //   2947: iload_2
    //   2948: istore_3
    //   2949: aload 14
    //   2951: invokevirtual 1831	java/net/Socket:close	()V
    //   2954: aload 14
    //   2956: astore 16
    //   2958: iload_2
    //   2959: istore_3
    //   2960: aload_0
    //   2961: aconst_null
    //   2962: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2965: aconst_null
    //   2966: astore 16
    //   2968: aconst_null
    //   2969: astore 14
    //   2971: iload_2
    //   2972: istore_3
    //   2973: aload_0
    //   2974: aconst_null
    //   2975: invokevirtual 1833	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2978: aload 14
    //   2980: astore 16
    //   2982: aload 15
    //   2984: astore 14
    //   2986: iload_1
    //   2987: istore_3
    //   2988: aload 16
    //   2990: astore 15
    //   2992: iload 5
    //   2994: istore_1
    //   2995: iload 11
    //   2997: istore 9
    //   2999: aload 17
    //   3001: astore 16
    //   3003: goto -2911 -> 92
    //   3006: iload 7
    //   3008: iload 5
    //   3010: iadd
    //   3011: istore 7
    //   3013: iload 6
    //   3015: iload 5
    //   3017: isub
    //   3018: istore 6
    //   3020: goto -165 -> 2855
    //   3023: iload 5
    //   3025: istore_3
    //   3026: iload_1
    //   3027: istore 5
    //   3029: iload 11
    //   3031: istore 9
    //   3033: iload_3
    //   3034: istore_1
    //   3035: iload_2
    //   3036: bipush 6
    //   3038: if_icmplt +371 -> 3409
    //   3041: iload_1
    //   3042: istore_3
    //   3043: sipush -1026
    //   3046: iload_1
    //   3047: if_icmpeq +7 -> 3054
    //   3050: sipush -1000
    //   3053: istore_3
    //   3054: iload_3
    //   3055: ifne +13 -> 3068
    //   3058: aload_0
    //   3059: aload_0
    //   3060: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   3063: iload 5
    //   3065: invokevirtual 727	oicq/wlogin_sdk/request/oicq_request:b	([BI)V
    //   3068: iload_3
    //   3069: ifne +171 -> 3240
    //   3072: aload_0
    //   3073: getfield 156	oicq/wlogin_sdk/request/oicq_request:t	I
    //   3076: sipush 2066
    //   3079: if_icmpeq +161 -> 3240
    //   3082: new 202	oicq/wlogin_sdk/report/report_t3
    //   3085: dup
    //   3086: invokespecial 203	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   3089: astore 14
    //   3091: aload 14
    //   3093: aload_0
    //   3094: getfield 156	oicq/wlogin_sdk/request/oicq_request:t	I
    //   3097: putfield 206	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   3100: aload 14
    //   3102: aload_0
    //   3103: getfield 158	oicq/wlogin_sdk/request/oicq_request:u	I
    //   3106: putfield 209	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   3109: aload 14
    //   3111: iload_3
    //   3112: putfield 212	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   3115: aload 14
    //   3117: invokestatic 218	java/lang/System:currentTimeMillis	()J
    //   3120: lload 12
    //   3122: lsub
    //   3123: l2i
    //   3124: putfield 221	oicq/wlogin_sdk/report/report_t3:_used	I
    //   3127: aload 14
    //   3129: iload_2
    //   3130: putfield 224	oicq/wlogin_sdk/report/report_t3:_try	I
    //   3133: aload 14
    //   3135: getstatic 114	oicq/wlogin_sdk/request/oicq_request:J	Ljava/lang/String;
    //   3138: putfield 227	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   3141: aload 14
    //   3143: getfield 227	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   3146: ifnonnull +10 -> 3156
    //   3149: aload 14
    //   3151: ldc 110
    //   3153: putfield 227	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   3156: aload_0
    //   3157: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3160: ifnonnull +254 -> 3414
    //   3163: aload 14
    //   3165: ldc 110
    //   3167: putfield 230	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   3170: aload 14
    //   3172: aload_0
    //   3173: getfield 152	oicq/wlogin_sdk/request/oicq_request:r	I
    //   3176: putfield 236	oicq/wlogin_sdk/report/report_t3:_port	I
    //   3179: aload 14
    //   3181: iload 4
    //   3183: putfield 239	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   3186: aload 14
    //   3188: getstatic 243	oicq/wlogin_sdk/request/t:D	I
    //   3191: putfield 246	oicq/wlogin_sdk/report/report_t3:_net	I
    //   3194: aload 14
    //   3196: ldc 110
    //   3198: putfield 249	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   3201: aload 14
    //   3203: aload 22
    //   3205: arraylength
    //   3206: putfield 252	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   3209: aload 14
    //   3211: iload 5
    //   3213: putfield 255	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   3216: iload 9
    //   3218: ifeq +223 -> 3441
    //   3221: iload 8
    //   3223: ifeq +209 -> 3432
    //   3226: aload 14
    //   3228: iconst_2
    //   3229: putfield 258	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   3232: getstatic 262	oicq/wlogin_sdk/request/t:aq	Loicq/wlogin_sdk/report/Reporter;
    //   3235: aload 14
    //   3237: invokevirtual 268	oicq/wlogin_sdk/report/Reporter:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   3240: new 460	java/lang/StringBuilder
    //   3243: dup
    //   3244: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   3247: aload_0
    //   3248: invokevirtual 677	java/lang/Object:getClass	()Ljava/lang/Class;
    //   3251: invokevirtual 682	java/lang/Class:getName	()Ljava/lang/String;
    //   3254: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3257: ldc_w 1888
    //   3260: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3263: iload_3
    //   3264: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3267: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3270: new 460	java/lang/StringBuilder
    //   3273: dup
    //   3274: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   3277: ldc 110
    //   3279: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3282: aload_0
    //   3283: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   3286: getfield 481	oicq/wlogin_sdk/request/t:f	J
    //   3289: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3292: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3295: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3298: iload_3
    //   3299: ireturn
    //   3300: astore 14
    //   3302: iload_3
    //   3303: istore_2
    //   3304: iload_1
    //   3305: istore_3
    //   3306: iload_2
    //   3307: istore_1
    //   3308: new 460	java/lang/StringBuilder
    //   3311: dup
    //   3312: invokespecial 461	java/lang/StringBuilder:<init>	()V
    //   3315: ldc_w 1890
    //   3318: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3321: aload 14
    //   3323: invokestatic 1185	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3326: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3329: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3332: ldc 110
    //   3334: invokestatic 369	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3337: sipush -1000
    //   3340: istore 5
    //   3342: iload_3
    //   3343: iconst_1
    //   3344: iadd
    //   3345: istore_2
    //   3346: aload 16
    //   3348: astore 14
    //   3350: iload 11
    //   3352: ifne +29 -> 3381
    //   3355: aload 16
    //   3357: invokevirtual 1893	java/net/Socket:isConnected	()Z
    //   3360: ifeq +8 -> 3368
    //   3363: aload 16
    //   3365: invokevirtual 1831	java/net/Socket:close	()V
    //   3368: aload_0
    //   3369: aconst_null
    //   3370: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3373: aconst_null
    //   3374: astore 14
    //   3376: aload_0
    //   3377: aconst_null
    //   3378: invokevirtual 1833	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   3381: iload_1
    //   3382: istore_3
    //   3383: aload 14
    //   3385: astore 16
    //   3387: iload 5
    //   3389: istore_1
    //   3390: iload 11
    //   3392: istore 9
    //   3394: aload 15
    //   3396: astore 14
    //   3398: aload 16
    //   3400: astore 15
    //   3402: aload 17
    //   3404: astore 16
    //   3406: goto -3314 -> 92
    //   3409: iconst_0
    //   3410: istore_3
    //   3411: goto -357 -> 3054
    //   3414: aload 14
    //   3416: aload_0
    //   3417: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3420: invokevirtual 274	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   3423: invokevirtual 280	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   3426: putfield 230	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   3429: goto -259 -> 3170
    //   3432: aload 14
    //   3434: iconst_1
    //   3435: putfield 258	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   3438: goto -206 -> 3232
    //   3441: aload 14
    //   3443: iconst_0
    //   3444: putfield 258	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   3447: goto -215 -> 3232
    //   3450: astore 14
    //   3452: goto -84 -> 3368
    //   3455: astore 14
    //   3457: goto -149 -> 3308
    //   3460: astore 18
    //   3462: goto -1625 -> 1837
    //   3465: astore 18
    //   3467: goto -1860 -> 1607
    //   3470: goto -1116 -> 2354
    //   3473: goto -1291 -> 2182
    //   3476: aload 21
    //   3478: astore 20
    //   3480: goto -2415 -> 1065
    //   3483: aconst_null
    //   3484: astore 17
    //   3486: iconst_m1
    //   3487: istore 5
    //   3489: goto -3111 -> 378
    //   3492: iload_3
    //   3493: istore 5
    //   3495: goto -460 -> 3035
    //   3498: goto -3120 -> 378
    //   3501: astore 17
    //   3503: aload 18
    //   3505: astore 14
    //   3507: goto -2510 -> 997
    //   3510: aload 15
    //   3512: astore 14
    //   3514: iload_1
    //   3515: istore_3
    //   3516: aload 16
    //   3518: astore 15
    //   3520: iload 5
    //   3522: istore_1
    //   3523: iload 11
    //   3525: istore 9
    //   3527: aload 17
    //   3529: astore 16
    //   3531: goto -3439 -> 92
    //   3534: aload 15
    //   3536: astore 14
    //   3538: iload_1
    //   3539: istore_3
    //   3540: aload 16
    //   3542: astore 15
    //   3544: iload 5
    //   3546: istore_1
    //   3547: iload 11
    //   3549: istore 9
    //   3551: aload 17
    //   3553: astore 16
    //   3555: goto -3463 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3558	0	this	oicq_request
    //   63	3484	1	i1	int
    //   65	3281	2	i2	int
    //   61	3479	3	i3	int
    //   79	3103	4	i4	int
    //   267	3278	5	i5	int
    //   1426	1593	6	i6	int
    //   2847	165	7	i7	int
    //   76	3146	8	bool1	boolean
    //   73	3477	9	bool2	boolean
    //   228	1369	10	bool3	boolean
    //   114	3434	11	bool4	boolean
    //   90	3031	12	l1	long
    //   87	3149	14	localObject1	Object
    //   3300	22	14	localThrowable1	Throwable
    //   3348	94	14	localObject2	Object
    //   3450	1	14	localException1	Exception
    //   3455	1	14	localThrowable2	Throwable
    //   3505	32	14	localObject3	Object
    //   70	2356	15	localObject4	Object
    //   2434	16	15	localConnectException1	java.net.ConnectException
    //   2479	1	15	localObject5	Object
    //   2493	16	15	localThrowable3	Throwable
    //   2549	994	15	localObject6	Object
    //   83	3471	16	localObject7	Object
    //   254	556	17	localObject8	Object
    //   991	20	17	localConnectException2	java.net.ConnectException
    //   1046	2439	17	localObject9	Object
    //   3501	51	17	localConnectException3	java.net.ConnectException
    //   447	1005	18	localObject10	Object
    //   1594	27	18	localException2	Exception
    //   2413	454	18	localInputStream	java.io.InputStream
    //   3460	1	18	localException3	Exception
    //   3465	39	18	localException4	Exception
    //   436	946	19	localObject11	Object
    //   1059	2420	20	localObject12	Object
    //   220	3257	21	str	String
    //   58	3146	22	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   230	238	991	java/net/ConnectException
    //   251	256	991	java/net/ConnectException
    //   264	269	991	java/net/ConnectException
    //   282	290	991	java/net/ConnectException
    //   305	375	991	java/net/ConnectException
    //   391	438	991	java/net/ConnectException
    //   883	901	991	java/net/ConnectException
    //   909	916	991	java/net/ConnectException
    //   924	936	991	java/net/ConnectException
    //   944	954	991	java/net/ConnectException
    //   962	991	991	java/net/ConnectException
    //   230	238	1594	java/lang/Exception
    //   251	256	1594	java/lang/Exception
    //   264	269	1594	java/lang/Exception
    //   282	290	1594	java/lang/Exception
    //   305	375	1594	java/lang/Exception
    //   391	438	1594	java/lang/Exception
    //   883	901	1594	java/lang/Exception
    //   909	916	1594	java/lang/Exception
    //   924	936	1594	java/lang/Exception
    //   944	954	1594	java/lang/Exception
    //   962	991	1594	java/lang/Exception
    //   2187	2354	2434	java/net/ConnectException
    //   2354	2415	2434	java/net/ConnectException
    //   2187	2354	2493	java/lang/Throwable
    //   2354	2415	2493	java/lang/Throwable
    //   1391	1422	3300	java/lang/Throwable
    //   1434	1445	3300	java/lang/Throwable
    //   1451	1473	3300	java/lang/Throwable
    //   1489	1515	3300	java/lang/Throwable
    //   1539	1544	3300	java/lang/Throwable
    //   1550	1555	3300	java/lang/Throwable
    //   1563	1568	3300	java/lang/Throwable
    //   2582	2592	3300	java/lang/Throwable
    //   3355	3368	3450	java/lang/Exception
    //   2601	2611	3455	java/lang/Throwable
    //   2617	2655	3455	java/lang/Throwable
    //   2679	2684	3455	java/lang/Throwable
    //   2690	2695	3455	java/lang/Throwable
    //   2703	2708	3455	java/lang/Throwable
    //   2721	2730	3455	java/lang/Throwable
    //   2736	2775	3455	java/lang/Throwable
    //   2799	2804	3455	java/lang/Throwable
    //   2810	2815	3455	java/lang/Throwable
    //   2823	2828	3455	java/lang/Throwable
    //   2841	2849	3455	java/lang/Throwable
    //   2866	2881	3455	java/lang/Throwable
    //   2899	2925	3455	java/lang/Throwable
    //   2949	2954	3455	java/lang/Throwable
    //   2960	2965	3455	java/lang/Throwable
    //   2973	2978	3455	java/lang/Throwable
    //   1806	1837	3460	java/lang/Exception
    //   449	520	3465	java/lang/Exception
    //   531	541	3465	java/lang/Exception
    //   552	560	3465	java/lang/Exception
    //   576	586	3465	java/lang/Exception
    //   597	608	3465	java/lang/Exception
    //   619	630	3465	java/lang/Exception
    //   641	655	3465	java/lang/Exception
    //   666	678	3465	java/lang/Exception
    //   689	701	3465	java/lang/Exception
    //   712	718	3465	java/lang/Exception
    //   729	735	3465	java/lang/Exception
    //   746	777	3465	java/lang/Exception
    //   788	804	3465	java/lang/Exception
    //   815	846	3465	java/lang/Exception
    //   1052	1057	3465	java/lang/Exception
    //   1076	1112	3465	java/lang/Exception
    //   1126	1157	3465	java/lang/Exception
    //   1168	1175	3465	java/lang/Exception
    //   1186	1197	3465	java/lang/Exception
    //   1208	1213	3465	java/lang/Exception
    //   1224	1230	3465	java/lang/Exception
    //   1241	1289	3465	java/lang/Exception
    //   1307	1332	3465	java/lang/Exception
    //   1358	1365	3465	java/lang/Exception
    //   449	520	3501	java/net/ConnectException
    //   531	541	3501	java/net/ConnectException
    //   552	560	3501	java/net/ConnectException
    //   576	586	3501	java/net/ConnectException
    //   597	608	3501	java/net/ConnectException
    //   619	630	3501	java/net/ConnectException
    //   641	655	3501	java/net/ConnectException
    //   666	678	3501	java/net/ConnectException
    //   689	701	3501	java/net/ConnectException
    //   712	718	3501	java/net/ConnectException
    //   729	735	3501	java/net/ConnectException
    //   746	777	3501	java/net/ConnectException
    //   788	804	3501	java/net/ConnectException
    //   815	846	3501	java/net/ConnectException
    //   1052	1057	3501	java/net/ConnectException
    //   1076	1112	3501	java/net/ConnectException
    //   1126	1157	3501	java/net/ConnectException
    //   1168	1175	3501	java/net/ConnectException
    //   1186	1197	3501	java/net/ConnectException
    //   1208	1213	3501	java/net/ConnectException
    //   1224	1230	3501	java/net/ConnectException
    //   1241	1289	3501	java/net/ConnectException
    //   1307	1332	3501	java/net/ConnectException
    //   1358	1365	3501	java/net/ConnectException
  }
  
  public int e(boolean paramBoolean)
  {
    if (paramBoolean) {}
    return 443;
  }
  
  public int f()
  {
    return t.b(this.x.h)._last_flowid;
  }
  
  public void g()
  {
    this.z = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.oicq_request
 * JD-Core Version:    0.7.0.1
 */