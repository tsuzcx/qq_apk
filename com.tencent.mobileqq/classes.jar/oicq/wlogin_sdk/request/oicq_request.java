package oicq.wlogin_sdk.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.loginsecsdk.ProtocolDet;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import oicq.wlogin_sdk.pow.b;
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
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tlv_type.tlv_t546;
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
    int i1;
    if (!this.z) {
      i1 = 7;
    } else {
      i1 = 135;
    }
    a(paramInt1, paramInt2, paramLong, i1, paramInt3, paramInt4, paramInt5, paramInt6);
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
    InetSocketAddress localInetSocketAddress = this.q;
    if (localInetSocketAddress == null) {
      localreport_t3._ip = "";
    } else {
      localreport_t3._ip = localInetSocketAddress.getAddress().getHostAddress();
    }
    localreport_t3._port = e(paramBoolean1);
    localreport_t3._conn = paramInt2;
    localreport_t3._net = t.E;
    localreport_t3._str = "";
    localreport_t3._slen = 0;
    localreport_t3._rlen = 0;
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        localreport_t3._wap = 2;
      } else {
        localreport_t3._wap = 1;
      }
    }
    else {
      localreport_t3._wap = 0;
    }
    t.at.add_t3(localreport_t3);
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
    int i1;
    if (this.x.e()) {
      i1 = b(paramString, paramBoolean, paramWUserSigInfo);
    } else {
      i1 = e();
    }
    if (i1 == -1000)
    {
      paramString = new ErrMsg();
      paramString.setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_4));
      a(paramString);
    }
    return i1;
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
      paramtlv_t161 = this.x;
      paramtlv_t161.m = 1;
      paramtlv_t161.s = localtlv_t172.get_data();
      util.LOGI("get rollback sig", "");
    }
    return 0;
  }
  
  public int a(tlv_t173 paramtlv_t173)
  {
    paramtlv_t173 = paramtlv_t173.get_data();
    if ((paramtlv_t173 != null) && (paramtlv_t173.length > 2))
    {
      int i3 = util.buf_to_int8(paramtlv_t173, 1);
      int i1 = 0;
      int i2 = 2;
      while (i1 < i3)
      {
        int i4 = paramtlv_t173.length;
        int i5 = i2 + 1;
        if (i4 < i5) {
          return 0;
        }
        i4 = util.buf_to_int8(paramtlv_t173, i2);
        int i6 = paramtlv_t173.length;
        i2 = i5 + 2;
        if (i6 < i2) {
          return 0;
        }
        i6 = util.buf_to_int16(paramtlv_t173, i5);
        int i7 = paramtlv_t173.length;
        i5 = i2 + i6;
        if (i7 < i5) {
          return 0;
        }
        byte[] arrayOfByte = new byte[i6];
        System.arraycopy(paramtlv_t173, i2, arrayOfByte, 0, i6);
        i6 = paramtlv_t173.length;
        i2 = i5 + 2;
        if (i6 < i2) {
          return 0;
        }
        b(i4, arrayOfByte, util.buf_to_int16(paramtlv_t173, i5));
        i1 += 1;
      }
    }
    return 0;
  }
  
  public int a(tlv_t17f paramtlv_t17f)
  {
    paramtlv_t17f = paramtlv_t17f.get_data();
    if ((paramtlv_t17f != null) && (paramtlv_t17f.length > 2))
    {
      int i3 = util.buf_to_int8(paramtlv_t17f, 1);
      int i1 = 0;
      int i2 = 2;
      while (i1 < i3)
      {
        int i4 = paramtlv_t17f.length;
        int i5 = i2 + 1;
        if (i4 < i5) {
          return 0;
        }
        i4 = util.buf_to_int8(paramtlv_t17f, i2);
        int i6 = paramtlv_t17f.length;
        i2 = i5 + 2;
        if (i6 < i2) {
          return 0;
        }
        i6 = util.buf_to_int16(paramtlv_t17f, i5);
        int i7 = paramtlv_t17f.length;
        i5 = i2 + i6;
        if (i7 < i5) {
          return 0;
        }
        byte[] arrayOfByte = new byte[i6];
        System.arraycopy(paramtlv_t17f, i2, arrayOfByte, 0, i6);
        i6 = paramtlv_t17f.length;
        i2 = i5 + 2;
        if (i6 < i2) {
          return 0;
        }
        a(i4, arrayOfByte, util.buf_to_int16(paramtlv_t17f, i5));
        i1 += 1;
      }
    }
    return 0;
  }
  
  public int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = cryptor.decrypt(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2);
    if (paramArrayOfByte1 == null) {
      return -1002;
    }
    this.g = paramArrayOfByte1.length;
    paramInt2 = paramArrayOfByte1.length;
    int i1 = this.f;
    if (paramInt2 + i1 + 2 > this.b)
    {
      this.b = (paramArrayOfByte1.length + i1 + 2);
      paramArrayOfByte2 = new byte[this.b];
      System.arraycopy(this.h, 0, paramArrayOfByte2, 0, this.c);
      this.h = paramArrayOfByte2;
    }
    System.arraycopy(paramArrayOfByte1, 0, this.h, paramInt1, paramArrayOfByte1.length);
    this.c = (this.f + 2 + paramArrayOfByte1.length);
    return 0;
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt / 2;
    Object localObject1;
    if (H != 0)
    {
      localObject1 = I;
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        localObject1 = I;
        break label359;
      }
    }
    if (i1 < 1)
    {
      Object localObject2 = "";
      if (paramBoolean)
      {
        if (t.E == 1)
        {
          if (paramInt == 0) {
            localObject2 = new String(util.get_wap_server_ipv6_host1(t.u));
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = new String(util.get_wap_server_host1(t.u));
            break label285;
          }
        }
        else
        {
          localObject1 = localObject2;
          if (t.E == 2)
          {
            if (paramInt == 0) {
              localObject2 = new String(util.get_wap_server_ipv6_host2(t.u));
            }
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject2 = new String(util.get_wap_server_host2(t.u));
              break label285;
            }
          }
        }
      }
      else if (t.E == 1)
      {
        if (paramInt == 0) {
          localObject2 = new String(util.get_server_ipv6_host1(t.u));
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new String(util.get_server_host1(t.u));
          break label285;
        }
      }
      else
      {
        localObject1 = localObject2;
        if (t.E == 2)
        {
          if (paramInt == 0) {
            localObject2 = new String(util.get_server_ipv6_host2(t.u));
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = new String(util.get_server_host2(t.u));
            break label285;
          }
        }
      }
      localObject2 = localObject1;
      label285:
      localObject1 = localObject2;
      if (((String)localObject2).length() <= 0) {
        localObject1 = c(paramBoolean);
      }
    }
    else if (i1 < 2)
    {
      localObject1 = c(paramBoolean);
    }
    else if (i1 < 3)
    {
      localObject1 = d(paramBoolean);
    }
    else if (i1 < 4)
    {
      localObject1 = b(paramBoolean);
    }
    else
    {
      localObject1 = a(paramBoolean);
    }
    label359:
    J = (String)localObject1;
    return localObject1;
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
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return;
      }
      if (paramInt1 == 1)
      {
        if (t.E == 1) {
          util.set_server_ipv6_host1(t.u, paramArrayOfByte);
        } else if (t.E == 2) {
          util.set_server_ipv6_host2(t.u, paramArrayOfByte);
        }
      }
      else if (paramInt1 == 2) {
        if (t.E == 1) {
          util.set_wap_server_ipv6_host1(t.u, paramArrayOfByte);
        } else if (t.E == 2) {
          util.set_wap_server_ipv6_host2(t.u, paramArrayOfByte);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ipv6 net type:");
      localStringBuilder.append(t.E);
      localStringBuilder.append(" type:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" host:");
      localStringBuilder.append(new String(paramArrayOfByte));
      localStringBuilder.append(" port:");
      localStringBuilder.append(paramInt2);
      paramArrayOfByte = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.x.f);
      util.LOGI(paramArrayOfByte, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    a(this.i, this.t, paramLong, this.m, t.x, this.p, paramArrayOfByte);
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
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("getRequestEncrptedPackage unknown encryption method ");
    paramArrayOfByte.append(paramEncryptionMethod);
    paramArrayOfByte = paramArrayOfByte.toString();
    paramEncryptionMethod = new StringBuilder();
    paramEncryptionMethod.append("");
    paramEncryptionMethod.append(paramLong);
    util.LOGI(paramArrayOfByte, paramEncryptionMethod.toString());
  }
  
  public void a(Socket paramSocket)
  {
    this.x.ap = paramSocket;
  }
  
  public void a(WloginSigInfo paramWloginSigInfo)
  {
    if (true == paramWloginSigInfo.isWtSessionTicketExpired()) {
      return;
    }
    if ((paramWloginSigInfo.wtSessionTicket != null) && (paramWloginSigInfo.wtSessionTicketKey != null))
    {
      this.A = ((byte[])paramWloginSigInfo.wtSessionTicket.clone());
      this.B = ((byte[])paramWloginSigInfo.wtSessionTicketKey.clone());
    }
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
        new d(t.u, localErrMsg).start();
      }
      return;
    }
    catch (Exception paramtlv_t149) {}
  }
  
  public void a(ErrMsg paramErrMsg)
  {
    async_context localasync_context = t.b(this.x.h);
    localasync_context._last_err_msg = new ErrMsg(0, 0, "", "", "");
    if (paramErrMsg != null) {}
    try
    {
      localasync_context._last_err_msg = ((ErrMsg)paramErrMsg.clone());
      return;
    }
    catch (CloneNotSupportedException paramErrMsg)
    {
      label46:
      break label46;
    }
    localasync_context._last_err_msg = new ErrMsg(0, 0, "", "", "");
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = this.c;
    if (paramInt + i1 + 1 > this.b)
    {
      this.b = (paramInt + i1 + 1 + 128);
      byte[] arrayOfByte = new byte[this.b];
      System.arraycopy(this.h, 0, arrayOfByte, 0, i1);
      this.h = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.h, this.c, paramInt);
    this.c += paramInt;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, tlv_t178 paramtlv_t178, tlv_t179 paramtlv_t179, tlv_t17d paramtlv_t17d, async_context paramasync_context)
  {
    StringBuffer localStringBuffer = new StringBuffer("handleDevlockInfo");
    int i1 = paramtlv_t178.get_tlv(paramArrayOfByte, paramInt, this.c - paramInt - 1);
    localStringBuffer.append(",t178 = ");
    localStringBuffer.append(i1);
    if (i1 >= 0)
    {
      paramasync_context._devlock_info.CountryCode = new String(paramtlv_t178.get_country_code());
      paramasync_context._devlock_info.Mobile = new String(paramtlv_t178.get_mobile());
      paramasync_context._devlock_info.MbItemSmsCodeStatus = paramtlv_t178.get_smscode_status();
      paramasync_context._devlock_info.AvailableMsgCount = paramtlv_t178.get_available_msg_cnt();
      paramasync_context._devlock_info.TimeLimit = paramtlv_t178.get_time_limit();
    }
    paramtlv_t178 = new tlv_t196();
    i1 = paramtlv_t178.get_tlv(paramArrayOfByte, paramInt, this.c - paramInt - 1);
    localStringBuffer.append(",t196 = ");
    localStringBuffer.append(i1);
    if (i1 >= 0)
    {
      paramasync_context._devlock_info.BakCountryCode = paramtlv_t178.getCountryCode();
      paramasync_context._devlock_info.BakMobile = paramtlv_t178.getBakMobile();
      paramasync_context._devlock_info.BakMobileState = paramtlv_t178.getBakMobileState();
    }
    paramtlv_t178 = new tlv_t204();
    i1 = paramtlv_t178.get_tlv(paramArrayOfByte, paramInt, this.c - paramInt - 1);
    localStringBuffer.append(",t204 = ");
    localStringBuffer.append(i1);
    if (i1 > 0) {
      paramasync_context._devlock_info.OtherDevLockVerifyUrl = new String(paramtlv_t178.get_data());
    }
    i1 = paramtlv_t179.get_tlv(paramArrayOfByte, paramInt, this.c - paramInt - 1);
    localStringBuffer.append(",t179 = ");
    localStringBuffer.append(i1);
    if (i1 >= 0) {
      paramasync_context._devlock_info.UnionVerifyUrl = new String(paramtlv_t179.get_verify_url());
    }
    paramInt = paramtlv_t17d.get_tlv(paramArrayOfByte, paramInt, this.c - paramInt - 1);
    localStringBuffer.append(",t17d = ");
    localStringBuffer.append(paramInt);
    if (paramInt >= 0)
    {
      paramasync_context._devlock_info.MbGuideType = paramtlv_t17d.get_mb_guide_type();
      paramasync_context._devlock_info.MbGuideMsg = new String(paramtlv_t17d.get_mb_guide_msg());
      paramasync_context._devlock_info.MbGuideInfoType = paramtlv_t17d.get_mb_guide_info_type();
      paramasync_context._devlock_info.MbGuideInfo = new String(paramtlv_t17d.get_mb_guide_info());
    }
    util.LOGI(localStringBuffer.toString(), "");
  }
  
  public byte[] a(tlv_t169 paramtlv_t169)
  {
    Object localObject4 = new tlv_t106();
    Object localObject3 = new tlv_t10c();
    Object localObject2 = new tlv_t16a();
    Object localObject1 = new tlv_t145();
    paramtlv_t169 = paramtlv_t169.get_data();
    int i1 = paramtlv_t169.length;
    if (((tlv_t106)localObject4).get_tlv(paramtlv_t169, 2, i1) < 0) {
      return null;
    }
    if (((tlv_t10c)localObject3).get_tlv(paramtlv_t169, 2, i1) < 0) {
      return null;
    }
    if (((tlv_t16a)localObject2).get_tlv(paramtlv_t169, 2, i1) < 0) {
      return null;
    }
    paramtlv_t169 = ((tlv_t106)localObject4).get_buf();
    localObject3 = ((tlv_t10c)localObject3).get_buf();
    localObject2 = ((tlv_t16a)localObject2).get_buf();
    localObject1 = ((tlv_t145)localObject1).get_tlv_145(t.B);
    localObject4 = new byte[paramtlv_t169.length + 3 + localObject3.length + localObject2.length + localObject1.length];
    localObject4[0] = 64;
    util.int16_to_buf((byte[])localObject4, 1, 4);
    System.arraycopy(paramtlv_t169, 0, localObject4, 3, paramtlv_t169.length);
    i1 = 3 + paramtlv_t169.length;
    System.arraycopy(localObject3, 0, localObject4, i1, localObject3.length);
    i1 += localObject3.length;
    System.arraycopy(localObject2, 0, localObject4, i1, localObject2.length);
    System.arraycopy(localObject1, 0, localObject4, i1 + localObject2.length, localObject1.length);
    i1 = localObject1.length;
    return localObject4;
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    if (this.x.m == 0) {
      return a(paramArrayOfByte, this.x.c, this.x.n, this.x.p, this.x.r);
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
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("encryptBody unknown encryption method ");
    paramArrayOfByte1.append(paramEncryptionMethod);
    util.LOGI(paramArrayOfByte1.toString(), "");
    return null;
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      if (this.x.m == 2) {
        i1 = 3;
      } else {
        i1 = 2;
      }
      paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
      byte[] arrayOfByte = new byte[paramArrayOfByte2.length + 2 + 2 + 2 + paramArrayOfByte1.length];
      util.int8_to_buf(arrayOfByte, 0, 1);
      util.int8_to_buf(arrayOfByte, 1, i1);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 2, paramArrayOfByte2.length);
      int i1 = paramArrayOfByte2.length + 2;
      util.int16_to_buf(arrayOfByte, i1, 258);
      i1 += 2;
      util.int16_to_buf(arrayOfByte, i1, 0);
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, i1 + 2, paramArrayOfByte1.length);
      i1 = paramArrayOfByte1.length;
      return arrayOfByte;
    }
    return new byte[0];
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte3);
    paramArrayOfByte3 = new byte[paramArrayOfByte2.length + 2 + paramArrayOfByte1.length];
    util.int16_to_buf(paramArrayOfByte3, 0, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, 2, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, 2 + paramArrayOfByte2.length, paramArrayOfByte1.length);
    int i1 = paramArrayOfByte1.length;
    return paramArrayOfByte3;
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null) && (paramArrayOfByte4 != null)) {
      try
      {
        paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte4);
        paramArrayOfByte4 = new byte[paramArrayOfByte2.length + 2 + 2 + 2 + 2 + paramArrayOfByte3.length + paramArrayOfByte1.length];
        util.int8_to_buf(paramArrayOfByte4, 0, 2);
        util.int8_to_buf(paramArrayOfByte4, 1, 1);
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte4, 2, paramArrayOfByte2.length);
        int i1 = paramArrayOfByte2.length + 2;
        util.int16_to_buf(paramArrayOfByte4, i1, 305);
        i1 += 2;
        util.int16_to_buf(paramArrayOfByte4, i1, paramInt);
        paramInt = i1 + 2;
        util.int16_to_buf(paramArrayOfByte4, paramInt, paramArrayOfByte3.length);
        paramInt += 2;
        System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte4, paramInt, paramArrayOfByte3.length);
        System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte4, paramInt + paramArrayOfByte3.length, paramArrayOfByte1.length);
        paramInt = paramArrayOfByte1.length;
        return paramArrayOfByte4;
      }
      catch (Throwable paramArrayOfByte1)
      {
        util.printThrowable(paramArrayOfByte1, "ecdh_encrypt_body");
        return new byte[0];
      }
    }
    return new byte[0];
  }
  
  public int b()
  {
    int i1 = this.c;
    int i2 = this.f;
    if (i1 <= i2 + 2) {
      return -1009;
    }
    this.g = (i1 - i2 - 2);
    i2 = util.buf_to_int16(this.h, 13);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("enrypt method ");
    ((StringBuilder)localObject1).append(this.y);
    ((StringBuilder)localObject1).append(" rsp flag ");
    ((StringBuilder)localObject1).append(i2);
    util.LOGI(((StringBuilder)localObject1).toString(), "");
    localObject1 = this.y;
    Object localObject2 = oicq_request.EncryptionMethod.EM_ECDH;
    i1 = 0;
    if ((localObject1 == localObject2) && (i2 == 0))
    {
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
      else
      {
        i2 = a(this.h, this.f + 1, this.g, this.x.c);
        i1 = i2;
        if (i2 < 0)
        {
          util.LOGI("use kc decrypt_body failed", "");
          i1 = i2;
        }
      }
    }
    else if ((this.y == oicq_request.EncryptionMethod.EM_ST) && (3 == i2))
    {
      i2 = a(this.h, this.f + 1, this.g, this.B);
      i1 = i2;
      if (i2 < 0)
      {
        t.at.attr_api(2494911);
        localObject1 = t.b(this.x.h);
        if (localObject1 != null)
        {
          localObject2 = this.x;
          ((t)localObject2).c(((t)localObject2).f, ((async_context)localObject1)._sappid);
        }
        util.LOGI("use session key decrypt_body failed", "");
        i1 = -1025;
      }
    }
    else if ((this.y == oicq_request.EncryptionMethod.EM_ECDH) && (true == this.z) && (4 == i2))
    {
      localObject1 = cryptor.decrypt(this.h, this.f + 1, this.g, this.x.p);
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.x.f);
        util.LOGI("decrypted outer body failed", ((StringBuilder)localObject1).toString());
        return -1002;
      }
      i2 = util.buf_to_int16((byte[])localObject1, 0);
      if (i2 > localObject1.length - 2)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("peer public key len wrong ");
        ((StringBuilder)localObject1).append(i2);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.x.f);
        util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
        return -1009;
      }
      localObject2 = new byte[i2];
      System.arraycopy(localObject1, 2, localObject2, 0, i2);
      localObject2 = new EcdhCrypt(this.a).calShareKeyMd5ByPeerPublicKey((byte[])localObject2);
      if (localObject2 != null)
      {
        if (localObject2.length == 0) {
          return -1002;
        }
        localObject1 = cryptor.decrypt((byte[])localObject1, i2 + 2, localObject1.length - 2 - i2, (byte[])localObject2);
        if (localObject1 == null)
        {
          t.at.attr_api(2461266);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(this.x.f);
          util.LOGI("use share key md5 decrypt failed", ((StringBuilder)localObject1).toString());
          return -1002;
        }
        localObject2 = this.h;
        i2 = localObject2.length;
        int i3 = this.f;
        if (i2 < i3 + 2 + localObject1.length)
        {
          this.b = (i3 + 2 + localObject1.length);
          byte[] arrayOfByte = new byte[this.b];
          System.arraycopy(localObject2, 0, arrayOfByte, 0, i3 + 1);
          this.h = arrayOfByte;
        }
        System.arraycopy(localObject1, 0, this.h, this.f + 1, localObject1.length);
        this.c = (this.f + 2 + localObject1.length);
      }
      else
      {
        return -1002;
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unknown encryption method ");
      ((StringBuilder)localObject1).append(this.y);
      util.LOGI(((StringBuilder)localObject1).toString(), "");
      i1 = -1024;
    }
    if (i1 < 0) {
      return i1;
    }
    return d(this.h, this.f + 1, this.g);
  }
  
  public int b(String paramString, boolean paramBoolean, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getClass().getName());
    ((StringBuilder)localObject1).append(":snd_rcv_req_msf ...");
    localObject1 = ((StringBuilder)localObject1).toString();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("");
    localStringBuilder1.append(this.x.f);
    util.LOGI((String)localObject1, localStringBuilder1.toString());
    int i1 = this.x.l;
    byte[] arrayOfByte = c();
    long l1 = System.currentTimeMillis();
    localStringBuilder1 = null;
    localObject1 = localStringBuilder1;
    try
    {
      Object localObject2 = new StringBuilder();
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append("WtloginMsfListener uin:");
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(" service_cmd:");
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(this.v);
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(" timeout:");
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(i1);
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(" flag:");
      localObject1 = localStringBuilder1;
      ((StringBuilder)localObject2).append(paramBoolean);
      localObject1 = localStringBuilder1;
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localStringBuilder1;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localObject1 = localStringBuilder1;
      localStringBuilder2.append("");
      localObject1 = localStringBuilder1;
      localStringBuilder2.append(this.x.f);
      localObject1 = localStringBuilder1;
      util.LOGI((String)localObject2, localStringBuilder2.toString());
      localObject1 = localStringBuilder1;
      paramWUserSigInfo = new WtloginMsfListener(paramString, this.v, arrayOfByte, i1, paramBoolean, paramWUserSigInfo);
      localObject1 = localStringBuilder1;
      paramString = new Thread(paramWUserSigInfo, "Wtlogin_msf");
      localObject1 = localStringBuilder1;
      paramString.start();
      localObject1 = localStringBuilder1;
      paramString.join(i1);
      localObject1 = localStringBuilder1;
      paramString = paramWUserSigInfo.getRetData();
      if (paramString == null)
      {
        localObject1 = paramString;
        localStringBuilder1 = new StringBuilder();
        localObject1 = paramString;
        localStringBuilder1.append("recv data from server failed, ret=");
        localObject1 = paramString;
        localStringBuilder1.append(paramWUserSigInfo.getRet());
        localObject1 = paramString;
        paramWUserSigInfo = localStringBuilder1.toString();
        localObject1 = paramString;
        localStringBuilder1 = new StringBuilder();
        localObject1 = paramString;
        localStringBuilder1.append("");
        localObject1 = paramString;
        localStringBuilder1.append(this.x.f);
        localObject1 = paramString;
        util.LOGI(paramWUserSigInfo, localStringBuilder1.toString());
      }
      else
      {
        localObject1 = paramString;
        b(paramString, paramString.length);
        i1 = 0;
      }
    }
    catch (Exception paramString)
    {
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("");
      paramWUserSigInfo.append(this.x.f);
      util.printException(paramString, paramWUserSigInfo.toString());
      paramString = (String)localObject1;
      i1 = -1000;
    }
    if (this.t != 2066)
    {
      paramWUserSigInfo = new report_t3();
      paramWUserSigInfo._cmd = this.t;
      paramWUserSigInfo._sub = this.u;
      paramWUserSigInfo._rst2 = i1;
      paramWUserSigInfo._used = ((int)(System.currentTimeMillis() - l1));
      paramWUserSigInfo._try = 0;
      paramWUserSigInfo._host = "";
      paramWUserSigInfo._ip = "";
      paramWUserSigInfo._port = 0;
      paramWUserSigInfo._conn = 0;
      paramWUserSigInfo._net = 0;
      paramWUserSigInfo._str = "";
      if (i1 == 0)
      {
        paramWUserSigInfo._slen = arrayOfByte.length;
        paramWUserSigInfo._rlen = paramString.length;
      }
      else
      {
        paramWUserSigInfo._slen = 0;
        paramWUserSigInfo._rlen = 0;
      }
      paramWUserSigInfo._wap = 3;
      t.at.add_t3(paramWUserSigInfo);
    }
    paramString = new StringBuilder();
    paramString.append(getClass().getName());
    paramString.append(":snd_rcv_req_msf ret=");
    paramString.append(i1);
    paramString = paramString.toString();
    paramWUserSigInfo = new StringBuilder();
    paramWUserSigInfo.append("");
    paramWUserSigInfo.append(this.x.f);
    util.LOGI(paramString, paramWUserSigInfo.toString());
    return i1;
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
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return;
      }
      if (paramInt1 == 1)
      {
        if (t.E == 1) {
          util.set_server_host1(t.u, paramArrayOfByte);
        } else if (t.E == 2) {
          util.set_server_host2(t.u, paramArrayOfByte);
        }
      }
      else if (paramInt1 == 2) {
        if (t.E == 1) {
          util.set_wap_server_host1(t.u, paramArrayOfByte);
        } else if (t.E == 2) {
          util.set_wap_server_host2(t.u, paramArrayOfByte);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("net type:");
      localStringBuilder.append(t.E);
      localStringBuilder.append(" type:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" host:");
      localStringBuilder.append(new String(paramArrayOfByte));
      localStringBuilder.append(" port:");
      localStringBuilder.append(paramInt2);
      paramArrayOfByte = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.x.f);
      util.LOGI(paramArrayOfByte, localStringBuilder.toString());
    }
  }
  
  public void b(long paramLong, byte[] paramArrayOfByte)
  {
    b(this.i, this.t, paramLong, this.m, t.x, this.p, paramArrayOfByte);
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
      return a(arrayOfByte, this.x.c, this.x.n, this.x.p, this.x.r);
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
    else
    {
      arrayOfString[0] = "wtlogin.qq.com";
      arrayOfString[1] = "wtlogin1.qq.com";
    }
    return arrayOfString[java.lang.Math.abs(new java.util.Random().nextInt() % arrayOfString.length)];
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    tlv_t146 localtlv_t146 = new tlv_t146();
    paramInt1 = localtlv_t146.get_tlv(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = t.b(this.x.h);
    if (paramInt1 >= 0)
    {
      paramArrayOfByte._last_err_msg.setVersion(localtlv_t146.get_ver());
      paramArrayOfByte._last_err_msg.setTitle(new String(localtlv_t146.get_title()));
      paramArrayOfByte._last_err_msg.setMessage(new String(localtlv_t146.get_msg()));
      paramArrayOfByte._last_err_msg.setType(localtlv_t146.get_type());
      paramArrayOfByte._last_err_msg.setOtherinfo(new String(localtlv_t146.get_errorinfo()));
    }
  }
  
  public byte[] c()
  {
    int i1 = this.c;
    byte[] arrayOfByte = new byte[i1];
    System.arraycopy(this.h, 0, arrayOfByte, 0, i1);
    return arrayOfByte;
  }
  
  public byte[] c(byte[] paramArrayOfByte)
  {
    Object localObject1;
    int i1;
    if ((t.C != null) && (t.C.length > 0))
    {
      localObject1 = new byte[16];
      if (t.C.length > localObject1.length)
      {
        System.arraycopy(t.C, 0, localObject1, 0, localObject1.length);
      }
      else
      {
        System.arraycopy(t.C, 0, localObject1, 0, t.C.length);
        int i2;
        for (i1 = t.C.length; i1 < localObject1.length; i1 = i2)
        {
          i2 = i1 + 1;
          localObject1[i1] = ((byte)i2);
        }
      }
      localObject2 = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, (byte[])localObject1);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length > 0) {}
      }
      else
      {
        localObject1 = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, "%4;7t>;28<fc.5*6".getBytes());
      }
    }
    else
    {
      localObject1 = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, "%4;7t>;28<fc.5*6".getBytes());
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = (byte[])paramArrayOfByte.clone();
    }
    if ((localObject2 != null) && (localObject2.length >= 16))
    {
      i1 = localObject2.length - 16;
      paramArrayOfByte = new byte[i1];
      System.arraycopy(localObject2, 0, paramArrayOfByte, 0, i1);
      localObject1 = new byte[16];
      System.arraycopy(localObject2, i1, localObject1, 0, 16);
      t.b(this.x.h)._tgtgt_key = ((byte[])localObject1);
      return paramArrayOfByte;
    }
    return (byte[])null;
  }
  
  public byte[] c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null))
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length + paramArrayOfByte3.length];
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      int i1 = paramArrayOfByte1.length + 0;
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i1, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, i1 + paramArrayOfByte2.length, paramArrayOfByte3.length);
      i1 = paramArrayOfByte3.length;
      return MD5.toMD5Byte(arrayOfByte);
    }
    return new byte[16];
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 5) {
      return -1009;
    }
    Object localObject19 = new tlv_t104();
    Object localObject15 = new tlv_t105();
    Object localObject24 = new tlv_t113();
    Object localObject4 = new tlv_t119();
    tlv_t10d localtlv_t10d = new tlv_t10d();
    tlv_t10e localtlv_t10e = new tlv_t10e();
    tlv_t10a localtlv_t10a = new tlv_t10a();
    tlv_t114 localtlv_t114 = new tlv_t114();
    Object localObject16 = new tlv_t103();
    Object localObject13 = new tlv_t11a();
    Object localObject14 = new tlv_t102();
    Object localObject6 = new tlv_t10b();
    Object localObject7 = new tlv_t11c();
    tlv_t11d localtlv_t11d = new tlv_t11d();
    Object localObject8 = new tlv_t120();
    Object localObject9 = new tlv_t121();
    tlv_t130 localtlv_t130 = new tlv_t130();
    Object localObject5 = new tlv_t108();
    Object localObject20 = new tlv_t106();
    tlv_t10c localtlv_t10c = new tlv_t10c();
    Object localObject2 = new tlv_t125();
    tlv_t11f localtlv_t11f = new tlv_t11f();
    Object localObject18 = new tlv_t138();
    tlv_t132 localtlv_t132 = new tlv_t132();
    tlv_t149 localtlv_t149 = new tlv_t149();
    tlv_t150 localtlv_t150 = new tlv_t150();
    tlv_t143 localtlv_t143 = new tlv_t143();
    tlv_t305 localtlv_t305 = new tlv_t305();
    tlv_t164 localtlv_t164 = new tlv_t164();
    Object localObject17 = new tlv_t165();
    Object localObject22 = new tlv_t167();
    Object localObject21 = new tlv_t16a();
    Object localObject23 = new tlv_t169();
    tlv_t161 localtlv_t161 = new tlv_t161();
    tlv_t171 localtlv_t171 = new tlv_t171();
    tlv_t localtlv_t = new tlv_t(1298);
    tlv_t16d localtlv_t16d = new tlv_t16d();
    tlv_t174 localtlv_t174 = new tlv_t174();
    tlv_t178 localtlv_t178 = new tlv_t178();
    tlv_t179 localtlv_t179 = new tlv_t179();
    tlv_t17d localtlv_t17d = new tlv_t17d();
    tlv_t17e localtlv_t17e = new tlv_t17e();
    tlv_t126 localtlv_t126 = new tlv_t126();
    tlv_t182 localtlv_t182 = new tlv_t182();
    tlv_t183 localtlv_t183 = new tlv_t183();
    Object localObject12 = new tlv_t186();
    tlv_t402 localtlv_t402 = new tlv_t402();
    Object localObject11 = new tlv_t403();
    Object localObject10 = new tlv_t546();
    tlv_t136 localtlv_t136 = new tlv_t136();
    tlv_t118 localtlv_t118 = new tlv_t118();
    Object localObject1 = t.b(this.x.h);
    long l4 = ((async_context)localObject1)._sappid;
    long l5 = ((async_context)localObject1)._appid;
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
      case 18: 
        paramInt2 = 7;
        break;
      case 15: 
        paramInt2 = 5;
        break;
      case 13: 
        paramInt2 = 4;
        break;
      case 10: 
      case 11: 
        paramInt2 = 1;
        break;
      case 7: 
        paramInt2 = 6;
        break;
      case 4: 
        paramInt2 = 3;
        break;
      case 2: 
        paramInt2 = 2;
        break;
      }
    } else {
      paramInt2 = 0;
    }
    int i2 = c(paramArrayOfByte, paramInt1 + 2);
    paramInt1 += 5;
    t localt = this.x;
    localt.d = null;
    label805:
    int i1;
    if (i2 != 0) {
      if (i2 != 1)
      {
        if (i2 == 2) {
          break label1913;
        }
        if (i2 != 15) {
          if (i2 != 16) {
            if (i2 != 20) {
              if ((i2 != 41) && (i2 != 116))
              {
                if (i2 != 160)
                {
                  if (i2 == 176) {
                    break label1291;
                  }
                  if (i2 == 180) {
                    break label1226;
                  }
                  if (i2 == 204) {
                    break label1057;
                  }
                  if (i2 == 208) {
                    break label910;
                  }
                  if (i2 == 232) {
                    break label805;
                  }
                  if (i2 != 239)
                  {
                    c(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
                    break label2540;
                  }
                }
                break label1324;
                i1 = ((tlv_t104)localObject19).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
                if (i1 >= 0)
                {
                  localObject2 = new tlv_t52b();
                  i1 = ((tlv_t52b)localObject2).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
                  if (i1 >= 0)
                  {
                    t.am = ((tlv_t104)localObject19).get_data();
                    ((async_context)localObject1)._smslogin_zone = ((tlv_t52b)localObject2).get_zone();
                    ((async_context)localObject1)._smslogin_hint_mobile = ((tlv_t52b)localObject2).get_mobile();
                    label892:
                    i1 = paramInt1;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      i3 = paramInt2;
      paramInt1 = 0;
      paramInt2 = i1;
      i1 = i3;
      break label8034;
      label910:
      i1 = ((tlv_t104)localObject19).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
      if (i1 >= 0)
      {
        ((async_context)localObject1)._t104 = ((tlv_t104)localObject19);
        i1 = localtlv_t126.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
        if (i1 >= 0)
        {
          ((async_context)localObject1)._t126 = localtlv_t126;
          i1 = localtlv_t182.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
          if (i1 >= 0)
          {
            ((async_context)localObject1)._smslogin_msgcnt = localtlv_t182.getMsgCnt();
            ((async_context)localObject1)._smslogin_timelimit = localtlv_t182.getTimeLimit();
            i1 = localtlv_t183.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
            if (i1 >= 0)
            {
              ((async_context)localObject1)._msalt = localtlv_t183.getMsalt();
              break label892;
              label1057:
              if (((tlv_t113)localObject24).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1) >= 0)
              {
                this.x.f = ((tlv_t113)localObject24).get_uin();
                localObject2 = this.x;
                ((t)localObject2).a(((t)localObject2).g, Long.valueOf(this.x.f));
              }
              i1 = ((tlv_t104)localObject19).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
              if (i1 >= 0)
              {
                do
                {
                  ((async_context)localObject1)._t104 = ((tlv_t104)localObject19);
                  i1 = localtlv_t402.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
                } while (i1 < 0);
                ((async_context)localObject1)._t402 = localtlv_t402;
                i1 = ((tlv_t403)localObject11).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
                if (i1 >= 0)
                {
                  ((async_context)localObject1)._t403 = ((tlv_t403)localObject11);
                  c(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
                  break;
                  label1226:
                  i1 = localtlv_t161.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
                  if (i1 >= 0) {
                    break label1267;
                  }
                }
              }
            }
          }
        }
      }
      label1267:
      do
      {
        do
        {
          i3 = paramInt1;
          i4 = paramInt2;
          paramInt1 = i1;
          paramInt2 = i3;
          i1 = i4;
          break label8034;
          a(localtlv_t161);
          c(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
          break;
          c(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
          localObject2 = this.x;
          ((t)localObject2).a(((t)localObject2).g);
          break;
          if (((tlv_t113)localObject24).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1) >= 0)
          {
            this.x.f = ((tlv_t113)localObject24).get_uin();
            localObject2 = this.x;
            ((t)localObject2).a(((t)localObject2).g, Long.valueOf(this.x.f));
          }
          i1 = ((tlv_t104)localObject19).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
        } while (i1 < 0);
        ((async_context)localObject1)._t104 = ((tlv_t104)localObject19);
        i1 = localtlv_t174.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
      } while (i1 < 0);
      label1291:
      label1324:
      ((async_context)localObject1)._t174 = localtlv_t174;
      i1 = paramInt1;
      a(paramArrayOfByte, paramInt1, localtlv_t178, localtlv_t179, localtlv_t17d, (async_context)localObject1);
      if (localtlv_t17e.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0) {
        ((async_context)localObject1)._devlock_info.VerifyReason = new String(localtlv_t17e.get_data());
      }
      localObject2 = localObject1;
      if (localtlv_t402.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0) {
        ((async_context)localObject2)._t402 = localtlv_t402;
      } else {
        ((async_context)localObject2)._t402 = new tlv_t402();
      }
      if (((tlv_t403)localObject11).get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0) {
        ((async_context)localObject2)._t403 = ((tlv_t403)localObject11);
      } else {
        ((async_context)localObject2)._t403 = new tlv_t403();
      }
      c(paramArrayOfByte, i1, this.c - i1 - 1);
      break;
      i1 = paramInt1;
      localObject2 = new tlv_t(405);
      i3 = ((tlv_t)localObject2).get_tlv(paramArrayOfByte, i1, this.c - i1 - 1);
      if (i3 < 0)
      {
        i1 = i3;
      }
      else
      {
        WloginSigInfo._LHSig = ((tlv_t)localObject2).get_data();
        c(paramArrayOfByte, i1, this.c - i1 - 1);
        break;
        i1 = paramInt1;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cmd ");
        ((StringBuilder)localObject2).append(Integer.toHexString(this.t));
        ((StringBuilder)localObject2).append(" subcmd ");
        ((StringBuilder)localObject2).append(Integer.toHexString(this.u));
        ((StringBuilder)localObject2).append(" result ");
        ((StringBuilder)localObject2).append(i2);
        ((StringBuilder)localObject2).append(" seq error uin ");
        ((StringBuilder)localObject2).append(this.x.f);
        ((StringBuilder)localObject2).append(" appid ");
        ((StringBuilder)localObject2).append(l4);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        c(paramArrayOfByte, i1, this.c - i1 - 1);
        break;
        i1 = paramInt1;
        localt.e(localt.f, l4);
        i3 = localtlv_t130.get_tlv(paramArrayOfByte, i1, this.c - i1 - 1);
        if (i3 < 0)
        {
          i1 = i3;
        }
        else
        {
          this.x.a(localtlv_t130.get_time(), localtlv_t130.get_ipaddr());
          c(paramArrayOfByte, i1, this.c - i1 - 1);
          break;
          i1 = paramInt1;
          break label2387;
          label1913:
          localObject2 = localObject1;
          i1 = paramInt1;
          localObject4 = "";
          i3 = ((tlv_t104)localObject19).get_tlv(paramArrayOfByte, i1, this.c - i1 - 1);
          if (i3 >= 0) {
            break label1971;
          }
        }
      }
      for (i1 = i3;; i1 = i3)
      {
        i3 = paramInt1;
        i4 = paramInt2;
        paramInt1 = i1;
        paramInt2 = i3;
        i1 = i4;
        break label8034;
        label1971:
        ((async_context)localObject2)._t104 = ((tlv_t104)localObject19);
        localObject5 = new tlv_t192();
        if (((tlv_t192)localObject5).get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0)
        {
          util.LOGI("return 0x192", (String)localObject4);
          i1 = ((tlv_t546)localObject10).get_tlv(paramArrayOfByte, i1, this.c - i1 - 1);
          if (i1 >= 0)
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("get tlv546 success len:");
            ((StringBuilder)localObject6).append(((tlv_t546)localObject10).get_data_len());
            util.LOGI(((StringBuilder)localObject6).toString(), (String)localObject4);
            ((async_context)localObject2)._t546 = ((tlv_t546)localObject10);
          }
          else
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("get tlv546 fail ret:");
            ((StringBuilder)localObject6).append(i1);
            util.LOGI(((StringBuilder)localObject6).toString(), (String)localObject4);
            ((async_context)localObject2)._t546 = new tlv_t546();
          }
          b.a(((tlv_t546)localObject10).get_data());
          a(new ErrMsg(0, i2, "", "", ((tlv_t192)localObject5).getUrl()));
          break label2540;
        }
        i3 = ((tlv_t105)localObject15).get_tlv(paramArrayOfByte, i1, this.c - i1 - 1);
        if (i3 >= 0) {
          break;
        }
      }
      ((async_context)localObject2)._t105 = ((tlv_t105)localObject15);
      if (((tlv_t165)localObject17).get_tlv(paramArrayOfByte, i1, this.c - i1 - 1) >= 0) {
        ((async_context)localObject2)._t165 = ((tlv_t165)localObject17);
      } else {
        ((async_context)localObject2)._t165 = new tlv_t165();
      }
      i1 = ((tlv_t546)localObject10).get_tlv(paramArrayOfByte, i1, this.c - i1 - 1);
      if (i1 >= 0)
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("get tlv546 success len:");
        ((StringBuilder)localObject5).append(((tlv_t546)localObject10).get_data_len());
        util.LOGI(((StringBuilder)localObject5).toString(), (String)localObject4);
        ((async_context)localObject2)._t546 = ((tlv_t546)localObject10);
      }
      else
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("get tlv546 fail ret:");
        ((StringBuilder)localObject5).append(i1);
        util.LOGI(((StringBuilder)localObject5).toString(), (String)localObject4);
        ((async_context)localObject2)._t546 = new tlv_t546();
      }
      b.a(((tlv_t546)localObject10).get_data());
      a(null);
      break;
      label2387:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("cmd ");
      ((StringBuilder)localObject2).append(Integer.toHexString(this.t));
      ((StringBuilder)localObject2).append(" subcmd ");
      ((StringBuilder)localObject2).append(Integer.toHexString(this.u));
      ((StringBuilder)localObject2).append(" result ");
      ((StringBuilder)localObject2).append(i2);
      ((StringBuilder)localObject2).append(" will clean sig for uin ");
      ((StringBuilder)localObject2).append(this.x.f);
      ((StringBuilder)localObject2).append(" appid ");
      ((StringBuilder)localObject2).append(l4);
      util.LOGI(((StringBuilder)localObject2).toString(), "");
      localObject2 = this.x;
      ((t)localObject2).e(((t)localObject2).f, l4);
      c(paramArrayOfByte, i1, this.c - i1 - 1);
      label2540:
      i1 = paramInt1;
      int i4 = paramInt2;
      i3 = i2;
      paramInt1 = i2;
      paramInt2 = i1;
      i1 = i4;
      i2 = i3;
      break label8034;
      i3 = i2;
      localObject17 = "";
      localObject15 = localObject1;
      if (paramInt2 == 1)
      {
        if (localt.b == null) {
          return -1006;
        }
        if (localtlv_t150.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1) >= 0) {
          this.x.d = localtlv_t150;
        }
        if (localtlv_t161.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1) >= 0) {
          a(localtlv_t161);
        }
        i1 = ((tlv_t119)localObject4).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1, this.x.b);
      }
      else
      {
        localObject10 = localObject4;
        if (paramInt2 == 2)
        {
          if (localtlv_t183.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1) >= 0) {
            ((async_context)localObject15)._msalt = localtlv_t183.getMsalt();
          }
          if (f() == 3)
          {
            i1 = ((tlv_t113)localObject24).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
            if (i1 >= 0)
            {
              this.x.f = ((tlv_t113)localObject24).get_uin();
              ((async_context)localObject15)._uin = this.x.f;
              if (!((async_context)localObject15).ifQQLoginInQim(t.aA))
              {
                localObject2 = this.x;
                ((t)localObject2).a(((t)localObject2).g, Long.valueOf(this.x.f));
              }
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("flowid == 2 t113 = ");
            ((StringBuilder)localObject2).append(i1);
            util.LOGI(((StringBuilder)localObject2).toString(), String.valueOf(this.x.f));
            if (((tlv_t104)localObject19).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1) >= 0) {
              ((async_context)localObject15)._t104 = ((tlv_t104)localObject19);
            }
          }
          else
          {
            if (localtlv_t150.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1) >= 0) {
              this.x.d = localtlv_t150;
            }
            if (localtlv_t161.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1) >= 0) {
              a(localtlv_t161);
            }
            i1 = ((tlv_t119)localObject10).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1, ((async_context)localObject15)._tgtgt_key);
            label2954:
            break label3113;
          }
        }
        else
        {
          if ((paramInt2 == 3) || (paramInt2 == 7)) {
            break label7846;
          }
          if (22 != this.u) {
            break label3032;
          }
          i1 = ((tlv_t104)localObject19).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1);
          if (i1 >= 0) {}
        }
      }
      label3032:
      do
      {
        do
        {
          i2 = paramInt2;
          paramInt2 = paramInt1;
          paramInt1 = i1;
          i1 = i2;
          i2 = i3;
          break label8034;
          ((async_context)localObject15)._t104 = ((tlv_t104)localObject19);
          i1 = paramInt1;
          break;
          if (localtlv_t150.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1) >= 0) {
            this.x.d = localtlv_t150;
          }
          if (localtlv_t161.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1) >= 0) {
            a(localtlv_t161);
          }
          i1 = ((tlv_t119)localObject10).get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1, ((async_context)localObject15)._tgtgt_key);
          r.K = 0;
          break label2954;
        } while (i1 < 0);
        localObject19 = ((tlv_t119)localObject4).get_data();
        i5 = localObject19.length;
        if (localtlv_t149.get_tlv((byte[])localObject19, 2, i5) > 0) {
          a(localtlv_t149);
        }
        localObject4 = new tlv_t543();
        i1 = ((tlv_t543)localObject4).get_tlv((byte[])localObject19, 2, i5);
        ((async_context)localObject15).tlv543In119 = ((tlv_t543)localObject4);
        if (localtlv_t130.get_tlv((byte[])localObject19, 2, i5) > 0) {
          this.x.a(localtlv_t130.get_time(), localtlv_t130.get_ipaddr());
        }
        i4 = ((tlv_t113)localObject24).get_tlv((byte[])localObject19, 2, i5);
        if (i4 >= 0)
        {
          this.x.f = ((tlv_t113)localObject24).get_uin();
          ((async_context)localObject15)._uin = this.x.f;
          if (!((async_context)localObject15).ifQQLoginInQim(t.aA))
          {
            localObject4 = this.x;
            ((t)localObject4).a(((t)localObject4).g, Long.valueOf(this.x.f));
          }
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("quickLoginByGateway retTlv543In119:");
        ((StringBuilder)localObject4).append(i1);
        ((StringBuilder)localObject4).append(" ,rett113=");
        ((StringBuilder)localObject4).append(i4);
        util.LOGI(((StringBuilder)localObject4).toString());
        localObject4 = new tlv_t(1320);
        if (((tlv_t)localObject4).get_tlv((byte[])localObject19, 2, i5) > 0)
        {
          localObject10 = new StringBuilder();
          ((StringBuilder)localObject10).append("get tlv528 and put into context from seq ");
          ((StringBuilder)localObject10).append(this.x.h);
          localObject10 = ((StringBuilder)localObject10).toString();
          localObject24 = new StringBuilder();
          ((StringBuilder)localObject24).append((String)localObject17);
          ((StringBuilder)localObject24).append(this.x.f);
          util.LOGI((String)localObject10, ((StringBuilder)localObject24).toString());
          ((async_context)localObject15).tlv528 = ((tlv_t)localObject4);
        }
        localObject4 = new tlv_t(1328);
        if (((tlv_t)localObject4).get_tlv((byte[])localObject19, 2, i5) > 0)
        {
          localObject10 = new StringBuilder();
          ((StringBuilder)localObject10).append("get tlv530 and put into context from seq ");
          ((StringBuilder)localObject10).append(this.x.h);
          localObject10 = ((StringBuilder)localObject10).toString();
          localObject24 = new StringBuilder();
          ((StringBuilder)localObject24).append((String)localObject17);
          ((StringBuilder)localObject24).append(this.x.f);
          util.LOGI((String)localObject10, ((StringBuilder)localObject24).toString());
          ((async_context)localObject15).tlv530 = ((tlv_t)localObject4);
        }
        localtlv_t10d.get_tlv((byte[])localObject19, 2, i5);
        localtlv_t10e.get_tlv((byte[])localObject19, 2, i5);
        localtlv_t10a.get_tlv((byte[])localObject19, 2, i5);
        localtlv_t114.get_tlv((byte[])localObject19, 2, i5);
        i1 = ((tlv_t11a)localObject13).get_tlv((byte[])localObject19, 2, i5);
      } while (i1 < 0);
      label3113:
      i1 = paramInt2;
      if (localtlv_t118.get_tlv((byte[])localObject19, 2, i5) < 0)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject17);
        ((StringBuilder)localObject4).append(this.x.f);
        util.LOGI("t118 get failed", ((StringBuilder)localObject4).toString());
      }
      if (((tlv_t103)localObject16).get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject4 = ((tlv_t103)localObject16).get_data();
      } else {
        localObject4 = null;
      }
      if (((tlv_t108)localObject5).get_tlv((byte[])localObject19, 2, i5) >= 0) {
        util.set_ksid(t.u, ((tlv_t108)localObject5).get_data());
      }
      if (((tlv_t102)localObject14).get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject5 = ((tlv_t102)localObject14).get_data();
      } else {
        localObject5 = null;
      }
      if (((tlv_t10b)localObject6).get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject6 = ((tlv_t10b)localObject6).get_data();
      } else {
        localObject6 = null;
      }
      if (((tlv_t11c)localObject7).get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject7 = ((tlv_t11c)localObject7).get_data();
      } else {
        localObject7 = null;
      }
      if (((tlv_t120)localObject8).get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject8 = ((tlv_t120)localObject8).get_data();
      } else {
        localObject8 = null;
      }
      if (((tlv_t121)localObject9).get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject9 = ((tlv_t121)localObject9).get_data();
      } else {
        localObject9 = null;
      }
      localObject10 = localObject2;
      if (((tlv_t125)localObject10).get_tlv((byte[])localObject19, 2, i5) >= 0)
      {
        localObject2 = ((tlv_t125)localObject10).get_openid();
        localObject10 = ((tlv_t125)localObject10).get_openkey();
      }
      else
      {
        localObject2 = null;
        localObject10 = null;
      }
      localObject14 = localObject12;
      if (((tlv_t186)localObject14).get_tlv((byte[])localObject19, 2, i5) >= 0)
      {
        localObject12 = this.x.g;
        if (util.check_uin_account((String)localObject12).booleanValue())
        {
          localObject12 = this.x;
          localObject12 = ((t)localObject12).e(((t)localObject12).f);
          if ((localObject12 != null) && (((String)localObject12).length() > 0))
          {
            localObject16 = this.x;
            ((t)localObject16).a((String)localObject12, Long.valueOf(((t)localObject16).f), ((tlv_t186)localObject14).getPwdflag());
          }
        }
        else
        {
          localObject16 = this.x;
          ((t)localObject16).a((String)localObject12, Long.valueOf(((t)localObject16).f), ((tlv_t186)localObject14).getPwdflag());
        }
        localObject16 = new StringBuilder();
        ((StringBuilder)localObject16).append("put t186: name: ");
        ((StringBuilder)localObject16).append((String)localObject12);
        ((StringBuilder)localObject16).append(" uin: ");
        ((StringBuilder)localObject16).append(this.x.f);
        ((StringBuilder)localObject16).append(" pwd=");
        ((StringBuilder)localObject16).append(((tlv_t186)localObject14).getPwdflag());
        util.LOGI(((StringBuilder)localObject16).toString(), (String)localObject17);
      }
      localObject12 = localObject2;
      try
      {
        localObject2 = new tlv_t(1335);
        i4 = ((tlv_t)localObject2).get_tlv((byte[])localObject19, 2, i5);
        if (i4 >= 0)
        {
          localObject2 = ((tlv_t)localObject2).get_data();
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            localObject16 = new byte[localObject2.length - 2];
            try
            {
              i6 = localObject2.length;
              try
              {
                System.arraycopy(localObject2, 2, localObject16, 0, i6 - 2);
                i6 = ProtocolDet.setLoginExtraData(t.u, (byte[])localObject16);
                localObject24 = new StringBuilder();
                ((StringBuilder)localObject24).append("0x537 resp:");
                ((StringBuilder)localObject24).append(i4);
                ((StringBuilder)localObject24).append(":");
                ((StringBuilder)localObject24).append(localObject2.length);
                ((StringBuilder)localObject24).append(" setRes:");
                ((StringBuilder)localObject24).append(i6);
                ((StringBuilder)localObject24).append(" tuple:");
                ((StringBuilder)localObject24).append(localObject16.length);
                localObject2 = ((StringBuilder)localObject24).toString();
                localObject16 = new StringBuilder();
                ((StringBuilder)localObject16).append((String)localObject17);
                ((StringBuilder)localObject16).append(this.x.f);
                util.LOGI((String)localObject2, ((StringBuilder)localObject16).toString());
              }
              catch (Throwable localThrowable1) {}
            }
            catch (Throwable localThrowable2) {}
          }
        }
        localObject16 = localObject13;
      }
      catch (Throwable localThrowable3)
      {
        localObject16 = new StringBuilder();
        ((StringBuilder)localObject16).append("tlv537 error ");
        ((StringBuilder)localObject16).append(Log.getStackTraceString(localThrowable3));
        util.LOGI(((StringBuilder)localObject16).toString(), (String)localObject17);
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("tgt len:");
      ((StringBuilder)localObject3).append(util.buf_len(localtlv_t10a.get_data()));
      ((StringBuilder)localObject3).append(" tgt_key len:");
      ((StringBuilder)localObject3).append(util.buf_len(localtlv_t10d.get_data()));
      ((StringBuilder)localObject3).append(" st len:");
      ((StringBuilder)localObject3).append(util.buf_len(localtlv_t114.get_data()));
      ((StringBuilder)localObject3).append(" st_key len:");
      ((StringBuilder)localObject3).append(util.buf_len(localtlv_t10e.get_data()));
      ((StringBuilder)localObject3).append(" stwx_web len:");
      ((StringBuilder)localObject3).append(util.buf_len((byte[])localObject4));
      ((StringBuilder)localObject3).append(" lskey len:");
      ((StringBuilder)localObject3).append(util.buf_len((byte[])localObject7));
      ((StringBuilder)localObject3).append(" skey len:");
      ((StringBuilder)localObject3).append(util.buf_len((byte[])localObject8));
      ((StringBuilder)localObject3).append(" sig64 len:");
      ((StringBuilder)localObject3).append(util.buf_len((byte[])localObject9));
      ((StringBuilder)localObject3).append(" openid len:");
      ((StringBuilder)localObject3).append(util.buf_len((byte[])localObject12));
      ((StringBuilder)localObject3).append(" openkey len:");
      ((StringBuilder)localObject3).append(util.buf_len((byte[])localObject10));
      ((StringBuilder)localObject3).append(" pwdflag: ");
      ((StringBuilder)localObject3).append(((tlv_t186)localObject14).get_data_len());
      ((StringBuilder)localObject3).append(" ");
      ((StringBuilder)localObject3).append(((tlv_t186)localObject14).getPwdflag());
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject13 = new StringBuilder();
      ((StringBuilder)localObject13).append((String)localObject17);
      ((StringBuilder)localObject13).append(this.x.f);
      util.LOGI((String)localObject3, ((StringBuilder)localObject13).toString());
      if (((tlv_t169)localObject23).get_tlv((byte[])localObject19, 2, i5) >= 0)
      {
        localObject3 = a((tlv_t169)localObject23);
        if ((localObject3 != null) && (localObject3.length > 0)) {
          this.x.j = new WFastLoginInfo((byte[])localObject3);
        } else {
          this.x.j = new WFastLoginInfo();
        }
      }
      localObject23 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 3, 0 });
      if (((tlv_t167)localObject22).get_tlv((byte[])localObject19, 2, i5) >= 0)
      {
        localObject23[0] = ((tlv_t167)localObject22).get_img_type();
        localObject23[1] = ((tlv_t167)localObject22).get_img_format();
        localObject23[2] = ((tlv_t167)localObject22).get_img_url();
      }
      localObject22 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 5, 0 });
      i4 = 0;
      while (i4 < 5)
      {
        localObject22[i4] = new byte[0];
        i4 += 1;
      }
      i4 = localtlv_t10c.get_tlv((byte[])localObject19, 2, i5);
      int i6 = ((tlv_t106)localObject20).get_tlv((byte[])localObject19, 2, i5);
      if ((i4 >= 0) && (i6 >= 0))
      {
        localObject3 = localtlv_t10c.get_data();
        localObject22[0] = ((byte[])b(((tlv_t106)localObject20).get_data(), (byte[])localObject3).clone());
      }
      if (((tlv_t16a)localObject21).get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject22[1] = ((tlv_t16a)localObject21).get_data();
      }
      localObject13 = new tlv_t(1329);
      i4 = ((tlv_t)localObject13).get_tlv((byte[])localObject19, 2, i5);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("retT531: ");
      ((StringBuilder)localObject3).append(i4);
      ((StringBuilder)localObject3).append(this.x.f);
      util.LOGI(((StringBuilder)localObject3).toString());
      if (i4 >= 0)
      {
        localObject20 = new tlv_t106();
        localObject21 = new tlv_t10c();
        localObject14 = new tlv_t16a();
        localObject3 = new tlv_t113();
        i4 = ((tlv_t)localObject20).get_tlv(((tlv_t)localObject13).get_data(), 2, ((tlv_t)localObject13).get_data_len());
        i6 = ((tlv_t)localObject21).get_tlv(((tlv_t)localObject13).get_data(), 2, ((tlv_t)localObject13).get_data_len());
        int i7 = ((tlv_t)localObject14).get_tlv(((tlv_t)localObject13).get_data(), 2, ((tlv_t)localObject13).get_data_len());
        int i8 = ((tlv_t)localObject3).get_tlv(((tlv_t)localObject13).get_data(), 2, ((tlv_t)localObject13).get_data_len());
        if ((i4 >= 0) && (i6 >= 0) && (i7 >= 0) && (i8 >= 0))
        {
          localObject13 = b(((tlv_t)localObject20).get_data(), ((tlv_t)localObject21).get_data());
          localObject14 = ((tlv_t)localObject14).get_data();
          l2 = util.buf_to_int32(((tlv_t)localObject3).get_data(), 0) & 0xFFFFFFFF;
          ((async_context)localObject15).tlv113 = ((tlv_t)localObject3);
          break label5326;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Get data from 0x531 failed: ");
        ((StringBuilder)localObject3).append(i4);
        ((StringBuilder)localObject3).append(";");
        ((StringBuilder)localObject3).append(i6);
        ((StringBuilder)localObject3).append(";");
        ((StringBuilder)localObject3).append(i7);
        ((StringBuilder)localObject3).append(";");
        ((StringBuilder)localObject3).append(i8);
        ((StringBuilder)localObject3).append(";");
        ((StringBuilder)localObject3).append(this.x.f);
        util.LOGI(((StringBuilder)localObject3).toString());
      }
      localObject13 = null;
      long l2 = 0L;
      localObject14 = null;
      label5326:
      if (((tlv_t403)localObject11).get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject22[4] = ((tlv_t403)localObject11).get_data();
      }
      if (((async_context)localObject15)._sec_guid_flag)
      {
        localObject22[2] = ((async_context)localObject15)._G;
        localObject22[3] = ((async_context)localObject15)._dpwd;
        localObject22[4] = ((async_context)localObject15)._t403.get_data();
        ((async_context)localObject15)._sec_guid_flag = false;
      }
      localObject20 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 16, 0 });
      i4 = 0;
      while (i4 < 16)
      {
        localObject20[i4] = new byte[0];
        i4 += 1;
      }
      if (localtlv_t136.get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject20[0] = localtlv_t136.get_data();
      }
      localObject3 = localObject12;
      if (localtlv_t132.get_tlv((byte[])localObject19, 2, i5) >= 0)
      {
        localObject20[1] = localtlv_t132.get_access_token();
        localObject3 = localtlv_t132.get_openid();
      }
      if (localtlv_t143.get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject20[2] = localtlv_t143.get_data();
      }
      if (localtlv_t305.get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject20[3] = localtlv_t305.get_data();
      }
      if (localtlv_t164.get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject20[4] = localtlv_t164.get_data();
      }
      if (localtlv_t171.get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject20[5] = localtlv_t171.get_data();
      }
      if (localtlv_t.get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject20[6] = localtlv_t.get_data();
      }
      if (localtlv_t16d.get_tlv((byte[])localObject19, 2, i5) >= 0) {
        localObject20[7] = localtlv_t16d.get_data();
      }
      localObject11 = new tlv_t199();
      if (((tlv_t199)localObject11).get_tlv((byte[])localObject19, 2, i5) >= 0)
      {
        localObject20[8] = ((tlv_t199)localObject11).getPayToken();
        localObject3 = ((tlv_t199)localObject11).getOpenId();
      }
      localObject11 = new tlv_t200();
      if (((tlv_t200)localObject11).get_tlv((byte[])localObject19, 2, i5) >= 0)
      {
        localObject20[9] = ((tlv_t200)localObject11).getPf();
        localObject20[10] = ((tlv_t200)localObject11).getPfKey();
      }
      localObject11 = new tlv_t(515);
      if (((tlv_t)localObject11).get_tlv((byte[])localObject19, 2, i5) >= 0)
      {
        localObject20[11] = ((tlv_t)localObject11).get_data();
        util.LOGI("get DA2 in rsp", (String)localObject17);
      }
      else
      {
        util.LOGI("no DA2 in rsp", (String)localObject17);
      }
      localObject11 = new tlv_t(791);
      if (((tlv_t)localObject11).get_tlv((byte[])localObject19, 2, i5) >= 0) {
        WloginSigInfo._QRPUSHSig = ((tlv_t)localObject11).get_data();
      } else {
        WloginSigInfo._QRPUSHSig = new byte[0];
      }
      localObject11 = new tlv_t(307);
      if (((tlv_t)localObject11).get_tlv((byte[])localObject19, 2, i5) >= 0)
      {
        localObject20[13] = ((tlv_t)localObject11).get_data();
      }
      else
      {
        localObject11 = new StringBuilder();
        ((StringBuilder)localObject11).append((String)localObject17);
        ((StringBuilder)localObject11).append(this.x.f);
        util.LOGW("get t133 failed", ((StringBuilder)localObject11).toString());
      }
      localObject11 = new tlv_t(308);
      if (((tlv_t)localObject11).get_tlv((byte[])localObject19, 2, i5) >= 0)
      {
        localObject20[14] = ((tlv_t)localObject11).get_data();
      }
      else
      {
        localObject11 = new StringBuilder();
        ((StringBuilder)localObject11).append((String)localObject17);
        ((StringBuilder)localObject11).append(this.x.f);
        util.LOGW("get t134 failed", ((StringBuilder)localObject11).toString());
      }
      if (t.ac)
      {
        i4 = this.u;
        if ((i4 == 9) || (i4 == 15) || (i4 == 20))
        {
          localObject11 = new tlv_t322();
          ((tlv_t322)localObject11).get_tlv((byte[])localObject19, 2, i5);
          localObject11 = ((tlv_t322)localObject11).get_data();
          if ((localObject11 != null) && (localObject11.length > 0))
          {
            localObject20[15] = localObject11;
            localObject11 = util.buf_to_string((byte[])localObject11);
          }
          else
          {
            localObject11 = "null";
          }
          localObject12 = new StringBuilder();
          ((StringBuilder)localObject12).append("get t322, value=");
          ((StringBuilder)localObject12).append((String)localObject11);
          localObject11 = ((StringBuilder)localObject12).toString();
          localObject12 = new StringBuilder();
          ((StringBuilder)localObject12).append((String)localObject17);
          ((StringBuilder)localObject12).append(this.x.f);
          util.LOGI((String)localObject11, ((StringBuilder)localObject12).toString());
        }
      }
      localObject11 = new StringBuilder();
      ((StringBuilder)localObject11).append("encrypt_a1 len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject22[0]));
      ((StringBuilder)localObject11).append(" no_pic_sig len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject22[1]));
      ((StringBuilder)localObject11).append(" G len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject22[2]));
      ((StringBuilder)localObject11).append(" dpwd len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject22[3]));
      ((StringBuilder)localObject11).append(" randseed len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject22[4]));
      ((StringBuilder)localObject11).append(" vkey len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[0]));
      ((StringBuilder)localObject11).append(" openid len:");
      ((StringBuilder)localObject11).append(util.buf_len((byte[])localObject3));
      ((StringBuilder)localObject11).append(" access_token len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[1]));
      ((StringBuilder)localObject11).append(" d2 len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[2]));
      ((StringBuilder)localObject11).append(" d2_key len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[3]));
      ((StringBuilder)localObject11).append(" sid len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[4]));
      ((StringBuilder)localObject11).append(" aq_sig len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[5]));
      ((StringBuilder)localObject11).append(" pskey len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[6]));
      ((StringBuilder)localObject11).append(" super_key len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[7]));
      ((StringBuilder)localObject11).append(" paytoken len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[8]));
      ((StringBuilder)localObject11).append(" pf len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[9]));
      ((StringBuilder)localObject11).append(" pfkey len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[10]));
      ((StringBuilder)localObject11).append(" da2 len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[11]));
      ((StringBuilder)localObject11).append(" wt session ticket:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[13]));
      ((StringBuilder)localObject11).append(" wt session ticket key:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[14]));
      ((StringBuilder)localObject11).append(" device_token len:");
      ((StringBuilder)localObject11).append(util.buf_len(localObject20[15]));
      localObject11 = ((StringBuilder)localObject11).toString();
      localObject12 = new StringBuilder();
      ((StringBuilder)localObject12).append((String)localObject17);
      ((StringBuilder)localObject12).append(this.x.f);
      util.LOGI((String)localObject11, ((StringBuilder)localObject12).toString());
      long l3;
      if (localtlv_t11f.get_tlv((byte[])localObject19, 2, i5) >= 0) {
        l3 = localtlv_t11f.get_tk_pri() & 0xFFFFFFFF;
      } else {
        l3 = 4294967295L;
      }
      localObject11 = new long[7];
      long l1 = 2160000L;
      i4 = 2;
      for (;;)
      {
        i4 = ((tlv_t138)localObject18).get_tlv((byte[])localObject19, i4, i5);
        if (i4 < 0) {
          break;
        }
        if (((tlv_t138)localObject18).get_a2_chg_time() != 0) {
          l1 = ((tlv_t138)localObject18).get_a2_chg_time();
        }
        if (((tlv_t138)localObject18).get_lskey_chg_time() != 0) {
          localObject11[0] = ((tlv_t138)localObject18).get_lskey_chg_time();
        } else {
          localObject11[0] = 1641600L;
        }
        if (((tlv_t138)localObject18).get_skey_chg_time() != 0) {
          localObject11[1] = ((tlv_t138)localObject18).get_skey_chg_time();
        } else {
          localObject11[1] = 86400L;
        }
        if (((tlv_t138)localObject18).get_vkey_chg_time() != 0) {
          localObject11[2] = ((tlv_t138)localObject18).get_vkey_chg_time();
        } else {
          localObject11[2] = 1728000L;
        }
        if (((tlv_t138)localObject18).get_a8_chg_time() != 0) {
          localObject11[3] = ((tlv_t138)localObject18).get_a8_chg_time();
        } else {
          localObject11[3] = 72000L;
        }
        if (((tlv_t138)localObject18).get_stweb_chg_time() != 0) {
          localObject11[4] = ((tlv_t138)localObject18).get_stweb_chg_time();
        } else {
          localObject11[4] = 6000L;
        }
        if (((tlv_t138)localObject18).get_d2_chg_time() != 0) {
          localObject11[5] = ((tlv_t138)localObject18).get_d2_chg_time();
        } else {
          localObject11[5] = 1728000L;
        }
        if (((tlv_t138)localObject18).get_sid_chg_time() != 0) {
          localObject11[6] = ((tlv_t138)localObject18).get_sid_chg_time();
        } else {
          localObject11[6] = 1728000L;
        }
      }
      localObject12 = new StringBuilder();
      ((StringBuilder)localObject12).append("sappid:");
      ((StringBuilder)localObject12).append(l4);
      ((StringBuilder)localObject12).append(" appid:");
      ((StringBuilder)localObject12).append(l5);
      ((StringBuilder)localObject12).append(" app_pri:");
      ((StringBuilder)localObject12).append(l3);
      ((StringBuilder)localObject12).append(" login_bitmap:");
      ((StringBuilder)localObject12).append(((async_context)localObject15)._login_bitmap);
      ((StringBuilder)localObject12).append(" tk_valid:");
      ((StringBuilder)localObject12).append(0L);
      ((StringBuilder)localObject12).append(" a2_valid:");
      ((StringBuilder)localObject12).append(l1);
      ((StringBuilder)localObject12).append(" lskey_valid:");
      ((StringBuilder)localObject12).append(localObject11[0]);
      ((StringBuilder)localObject12).append(" skey_valid:");
      ((StringBuilder)localObject12).append(localObject11[1]);
      ((StringBuilder)localObject12).append(" vkey_valid:");
      ((StringBuilder)localObject12).append(localObject11[2]);
      ((StringBuilder)localObject12).append(" a8_valid:");
      ((StringBuilder)localObject12).append(localObject11[3]);
      ((StringBuilder)localObject12).append(" stweb_valid:");
      ((StringBuilder)localObject12).append(localObject11[4]);
      ((StringBuilder)localObject12).append(" d2_valid:");
      ((StringBuilder)localObject12).append(localObject11[5]);
      ((StringBuilder)localObject12).append(" sid_valid:");
      ((StringBuilder)localObject12).append(localObject11[6]);
      localObject12 = ((StringBuilder)localObject12).toString();
      localObject18 = new StringBuilder();
      ((StringBuilder)localObject18).append((String)localObject17);
      ((StringBuilder)localObject18).append(this.x.f);
      util.LOGI((String)localObject12, ((StringBuilder)localObject18).toString());
      localObject12 = new WloginSimpleInfo();
      ((WloginSimpleInfo)localObject12).setUin(this.x.f);
      ((WloginSimpleInfo)localObject12).setFace(((tlv_t11a)localObject16).get_face());
      ((WloginSimpleInfo)localObject12).setAge(((tlv_t11a)localObject16).get_age());
      ((WloginSimpleInfo)localObject12).setGender(((tlv_t11a)localObject16).get_gender());
      ((WloginSimpleInfo)localObject12).setNick(((tlv_t11a)localObject16).get_nick());
      ((WloginSimpleInfo)localObject12).setReserveUinInfo((byte[][])localObject23);
      ((WloginSimpleInfo)localObject12).setMainDisplayName(localtlv_t118.get_data());
      this.x.aw = ((async_context)localObject15)._main_sigmap;
      localObject16 = this.x;
      i4 = ((t)localObject16).a(((t)localObject16).f, l4, (byte[][])localObject22, l5, l3, t.f(), t.f() + 0L, t.f() + l1, (WloginSimpleInfo)localObject12, localtlv_t10a.get_data(), localtlv_t10d.get_data(), localtlv_t114.get_data(), localtlv_t10e.get_data(), (byte[])localObject4, (byte[])localObject6, (byte[])localObject5, (byte[])localObject7, (byte[])localObject8, (byte[])localObject9, (byte[])localObject3, (byte[])localObject10, (byte[][])localObject20, (long[])localObject11, ((async_context)localObject15)._login_bitmap);
      if (i4 != 0)
      {
        localObject3 = new ErrMsg();
        ((ErrMsg)localObject3).setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
        a((ErrMsg)localObject3);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("put_siginfo fail,ret=");
        ((StringBuilder)localObject3).append(i4);
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject17);
        ((StringBuilder)localObject4).append(this.x.f);
        util.LOGI((String)localObject3, ((StringBuilder)localObject4).toString());
      }
      for (paramInt2 = i4;; paramInt2 = i4)
      {
        i2 = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i2;
        i2 = i3;
        break label8034;
        if ((localObject13 == null) || (0L == l2)) {
          break;
        }
        localObject3 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { localObject22.length, 0 });
        localObject3[0] = localObject13;
        localObject3[1] = localObject14;
        localObject4 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { localObject20.length, 0 });
        i4 = this.x.a(l2, 16L, (byte[][])localObject3, 16L, l3, t.f(), t.f() + 0L, t.f() + l1, (WloginSimpleInfo)localObject12, null, null, null, null, null, null, null, null, null, null, null, null, (byte[][])localObject4, (long[])localObject11, ((async_context)localObject15)._login_bitmap);
        if (i4 == 0) {
          break;
        }
        localObject3 = new ErrMsg();
        ((ErrMsg)localObject3).setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
        a((ErrMsg)localObject3);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("put_siginfo fail ");
        ((StringBuilder)localObject3).append(i4);
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject17);
        ((StringBuilder)localObject4).append(l2);
        util.LOGI((String)localObject3, ((StringBuilder)localObject4).toString());
      }
      i1 = 2;
      for (;;)
      {
        i1 = localtlv_t11d.get_tlv((byte[])localObject19, i1, i5);
        if (i1 < 0) {
          break;
        }
        localObject3 = this.x;
        ((t)localObject3).a(((t)localObject3).f, localtlv_t11d.get_appid(), t.f(), t.f() + 0L, localtlv_t11d.get_st(), localtlv_t11d.get_stkey());
      }
      i1 = paramInt1;
      continue;
      label7846:
      i4 = paramInt2;
      int i5 = this.c;
      localObject3 = paramArrayOfByte;
      i1 = paramInt1;
      if (localtlv_t183.get_tlv((byte[])localObject3, i1, i5 - paramInt1) >= 0) {
        ((async_context)localObject15)._msalt = localtlv_t183.getMsalt();
      }
      paramInt1 = ((tlv_t113)localObject24).get_tlv((byte[])localObject3, i1, this.c - i1);
      if (paramInt1 >= 0)
      {
        this.x.f = ((tlv_t113)localObject24).get_uin();
        localObject4 = this.x;
        ((t)localObject4).a(((t)localObject4).g, Long.valueOf(this.x.f));
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("flowid == 3 || flowid == 7 t113 = ");
      ((StringBuilder)localObject4).append(paramInt1);
      util.LOGI(((StringBuilder)localObject4).toString(), String.valueOf(this.x.f));
      paramInt1 = ((tlv_t104)localObject19).get_tlv((byte[])localObject3, i1, this.c - i1);
      if (paramInt1 < 0)
      {
        paramInt2 = i1;
        i1 = i4;
        i2 = i3;
        break label8034;
      }
      ((async_context)localObject15)._t104 = ((tlv_t104)localObject19);
    }
    label8034:
    Object localObject3 = paramArrayOfByte;
    paramArrayOfByte = new tlv_t543();
    int i3 = paramArrayOfByte.get_tlv((byte[])localObject3, paramInt2, this.c - paramInt2 - 1);
    ((async_context)localObject1)._t543 = paramArrayOfByte;
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("tlv543_ret:");
    paramArrayOfByte.append(i3);
    util.LOGI(paramArrayOfByte.toString(), "");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("get_response_body cmd= 0x");
    ((StringBuilder)localObject1).append(Integer.toHexString(this.t));
    ((StringBuilder)localObject1).append(" subCmd= 0x");
    ((StringBuilder)localObject1).append(Integer.toHexString(this.u));
    ((StringBuilder)localObject1).append(" type:");
    ((StringBuilder)localObject1).append(i2);
    ((StringBuilder)localObject1).append(" ret:");
    if (paramInt1 > 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("0x");
      paramArrayOfByte.append(Integer.toHexString(paramInt1));
      paramArrayOfByte = paramArrayOfByte.toString();
    }
    else
    {
      paramArrayOfByte = Integer.valueOf(paramInt1);
    }
    ((StringBuilder)localObject1).append(paramArrayOfByte);
    paramArrayOfByte = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(this.x.f);
    util.LOGI(paramArrayOfByte, ((StringBuilder)localObject1).toString());
    if (paramInt1 == 0)
    {
      a(null);
      paramInt2 = paramInt1;
    }
    else
    {
      new tlv_t508().get_tlv((byte[])localObject3, paramInt2, this.c - paramInt2 - 1);
      paramInt2 = paramInt1;
      if (tlv_t508.doFetch)
      {
        paramArrayOfByte = new ErrMsg();
        i2 = new h(this.x, this.t, this.u, paramArrayOfByte).b(paramInt1);
        paramInt2 = paramInt1;
        if (i2 != -1000)
        {
          a(paramArrayOfByte);
          paramInt2 = i2;
        }
      }
    }
    if ((paramInt2 != 10) && (paramInt2 != 161) && (paramInt2 != 162) && (paramInt2 != 164) && (paramInt2 != 165) && (paramInt2 != 166) && (paramInt2 != 154))
    {
      paramInt1 = paramInt2;
      if (paramInt2 >= 128)
      {
        paramInt1 = paramInt2;
        if (paramInt2 > 143) {}
      }
    }
    else
    {
      paramInt1 = -1000;
    }
    if ((i1 != 2) && (i1 != 6) && (i1 != 7)) {
      a(i1);
    }
    return paramInt1;
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
    return this.x.ap;
  }
  
  /* Error */
  public int e()
  {
    // Byte code:
    //   0: new 468	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   7: astore 15
    //   9: aload 15
    //   11: aload_0
    //   12: invokevirtual 814	java/lang/Object:getClass	()Ljava/lang/Class;
    //   15: invokevirtual 819	java/lang/Class:getName	()Ljava/lang/String;
    //   18: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload 15
    //   24: ldc_w 1765
    //   27: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 15
    //   33: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 15
    //   38: new 468	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   45: astore 16
    //   47: aload 16
    //   49: ldc 110
    //   51: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 16
    //   57: aload_0
    //   58: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   61: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   64: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 15
    //   70: aload 16
    //   72: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload_0
    //   79: invokevirtual 824	oicq/wlogin_sdk/request/oicq_request:c	()[B
    //   82: astore 21
    //   84: aload_0
    //   85: invokevirtual 1767	oicq/wlogin_sdk/request/oicq_request:d	()Ljava/net/Socket;
    //   88: astore 17
    //   90: lconst_0
    //   91: lstore 8
    //   93: ldc 110
    //   95: astore 15
    //   97: aload 15
    //   99: astore 16
    //   101: iconst_0
    //   102: istore 13
    //   104: iconst_0
    //   105: istore_2
    //   106: iconst_0
    //   107: istore_3
    //   108: iconst_0
    //   109: istore 4
    //   111: iconst_0
    //   112: istore 12
    //   114: iconst_0
    //   115: istore_1
    //   116: iload_3
    //   117: bipush 10
    //   119: if_icmpge +3260 -> 3379
    //   122: iload_3
    //   123: ifeq +9 -> 132
    //   126: getstatic 395	oicq/wlogin_sdk/request/t:u	Landroid/content/Context;
    //   129: invokestatic 1770	oicq/wlogin_sdk/tools/util:chg_retry_type	(Landroid/content/Context;)V
    //   132: getstatic 395	oicq/wlogin_sdk/request/t:u	Landroid/content/Context;
    //   135: invokestatic 1774	oicq/wlogin_sdk/tools/util:is_wap_retry	(Landroid/content/Context;)Z
    //   138: istore 13
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   145: iload_3
    //   146: ifeq +30 -> 176
    //   149: aload_0
    //   150: getfield 156	oicq/wlogin_sdk/request/oicq_request:t	I
    //   153: sipush 2066
    //   156: if_icmpeq +20 -> 176
    //   159: aload_0
    //   160: iload_2
    //   161: lload 8
    //   163: iload 4
    //   165: iload_3
    //   166: iload 13
    //   168: iload 12
    //   170: invokespecial 1776	oicq/wlogin_sdk/request/oicq_request:a	(IJIIZZ)V
    //   173: goto +3 -> 176
    //   176: invokestatic 218	java/lang/System:currentTimeMillis	()J
    //   179: lstore 8
    //   181: iload 13
    //   183: ifeq +1376 -> 1559
    //   186: new 468	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   193: astore 18
    //   195: aload 18
    //   197: ldc_w 1778
    //   200: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: iload_3
    //   205: istore 6
    //   207: aload 18
    //   209: iload 6
    //   211: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 18
    //   217: ldc_w 1780
    //   220: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 18
    //   226: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: astore 18
    //   231: new 468	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   238: astore 19
    //   240: aload 19
    //   242: ldc 110
    //   244: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 19
    //   250: aload_0
    //   251: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   254: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   257: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 18
    //   263: aload 19
    //   265: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_0
    //   272: iload 6
    //   274: iload 13
    //   276: invokevirtual 1782	oicq/wlogin_sdk/request/oicq_request:a	(IZ)Ljava/lang/String;
    //   279: astore 19
    //   281: getstatic 395	oicq/wlogin_sdk/request/t:u	Landroid/content/Context;
    //   284: invokestatic 1785	oicq/wlogin_sdk/tools/util:is_wap_proxy_retry	(Landroid/content/Context;)Z
    //   287: istore 14
    //   289: iload 14
    //   291: ifeq +224 -> 515
    //   294: invokestatic 1788	oicq/wlogin_sdk/tools/util:get_proxy_ip	()Ljava/lang/String;
    //   297: astore 18
    //   299: invokestatic 1791	oicq/wlogin_sdk/tools/util:get_proxy_port	()I
    //   302: istore 5
    //   304: aload 18
    //   306: ifnull +49 -> 355
    //   309: aload 18
    //   311: invokevirtual 393	java/lang/String:length	()I
    //   314: istore 7
    //   316: iload 7
    //   318: ifle +37 -> 355
    //   321: iload 5
    //   323: iconst_m1
    //   324: if_icmpne +6 -> 330
    //   327: goto +28 -> 355
    //   330: iload 14
    //   332: istore 12
    //   334: goto +191 -> 525
    //   337: astore 18
    //   339: iload 14
    //   341: istore 12
    //   343: goto +1092 -> 1435
    //   346: astore 18
    //   348: iload 14
    //   350: istore 12
    //   352: goto +1148 -> 1500
    //   355: new 468	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   362: astore 20
    //   364: aload 20
    //   366: ldc_w 1793
    //   369: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 20
    //   375: aload 18
    //   377: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 20
    //   383: ldc_w 1795
    //   386: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 20
    //   392: iload 5
    //   394: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 20
    //   400: ldc_w 1797
    //   403: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 20
    //   409: iconst_0
    //   410: invokevirtual 835	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 20
    //   416: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: astore 20
    //   421: new 468	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   428: astore 22
    //   430: aload 22
    //   432: ldc 110
    //   434: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_0
    //   439: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   442: astore 23
    //   444: aload 22
    //   446: aload 23
    //   448: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   451: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload 20
    //   457: aload 22
    //   459: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: iconst_0
    //   466: istore 12
    //   468: goto +57 -> 525
    //   471: astore 18
    //   473: goto +10 -> 483
    //   476: astore 18
    //   478: goto +13 -> 491
    //   481: astore 18
    //   483: iconst_0
    //   484: istore 12
    //   486: goto +949 -> 1435
    //   489: astore 18
    //   491: iconst_0
    //   492: istore 12
    //   494: goto +1006 -> 1500
    //   497: astore 18
    //   499: iload 14
    //   501: istore 12
    //   503: goto +932 -> 1435
    //   506: astore 18
    //   508: iload 14
    //   510: istore 12
    //   512: goto +988 -> 1500
    //   515: aconst_null
    //   516: astore 18
    //   518: iconst_m1
    //   519: istore 5
    //   521: iload 14
    //   523: istore 12
    //   525: iload 12
    //   527: ifeq +82 -> 609
    //   530: new 468	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   537: astore 20
    //   539: aload 20
    //   541: ldc_w 1799
    //   544: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload 20
    //   550: aload 18
    //   552: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload 20
    //   558: ldc_w 1366
    //   561: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload 20
    //   567: iload 5
    //   569: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload 20
    //   575: ldc_w 1801
    //   578: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: new 1803	java/net/URL
    //   585: dup
    //   586: aload 20
    //   588: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokespecial 1804	java/net/URL:<init>	(Ljava/lang/String;)V
    //   594: astore 18
    //   596: goto +222 -> 818
    //   599: astore 18
    //   601: goto -98 -> 503
    //   604: astore 18
    //   606: goto -94 -> 512
    //   609: aload_0
    //   610: aload 19
    //   612: iconst_0
    //   613: aload_0
    //   614: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   617: getfield 822	oicq/wlogin_sdk/request/t:l	I
    //   620: i2l
    //   621: invokestatic 1809	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   624: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   627: aload_0
    //   628: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   631: astore 18
    //   633: aload 18
    //   635: ifnull +130 -> 765
    //   638: aload_0
    //   639: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   642: invokevirtual 236	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   645: invokevirtual 242	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   648: astore 18
    //   650: aload 15
    //   652: astore 20
    //   654: aload 20
    //   656: aload 18
    //   658: invokevirtual 1813	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   661: istore 14
    //   663: iload 14
    //   665: ifne +41 -> 706
    //   668: aload_0
    //   669: aconst_null
    //   670: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   673: aload 18
    //   675: astore 15
    //   677: goto +92 -> 769
    //   680: astore 19
    //   682: aload 18
    //   684: astore 15
    //   686: aload 19
    //   688: astore 18
    //   690: goto +67 -> 757
    //   693: astore 19
    //   695: aload 18
    //   697: astore 15
    //   699: aload 19
    //   701: astore 18
    //   703: goto -191 -> 512
    //   706: new 468	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   713: astore 18
    //   715: aload 18
    //   717: ldc_w 1815
    //   720: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: aload 18
    //   726: aload 20
    //   728: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: new 535	java/lang/Exception
    //   735: dup
    //   736: aload 18
    //   738: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokespecial 1816	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   744: athrow
    //   745: astore 18
    //   747: goto +10 -> 757
    //   750: astore 18
    //   752: goto +10 -> 762
    //   755: astore 18
    //   757: goto -254 -> 503
    //   760: astore 18
    //   762: goto -250 -> 512
    //   765: aload 19
    //   767: astore 18
    //   769: new 468	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   776: astore 20
    //   778: aload 20
    //   780: ldc_w 1799
    //   783: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload 20
    //   789: aload 18
    //   791: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: aload 20
    //   797: ldc_w 1801
    //   800: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: pop
    //   804: new 1803	java/net/URL
    //   807: dup
    //   808: aload 20
    //   810: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: invokespecial 1804	java/net/URL:<init>	(Ljava/lang/String;)V
    //   816: astore 18
    //   818: new 468	java/lang/StringBuilder
    //   821: dup
    //   822: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   825: astore 20
    //   827: aload 20
    //   829: ldc_w 1818
    //   832: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: pop
    //   836: aload 20
    //   838: iload 12
    //   840: invokevirtual 835	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: aload 20
    //   846: ldc_w 1820
    //   849: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload 20
    //   855: aload 18
    //   857: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   860: pop
    //   861: aload 20
    //   863: ldc_w 1822
    //   866: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: pop
    //   870: aload 20
    //   872: aload 19
    //   874: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: pop
    //   878: aload 20
    //   880: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: astore 20
    //   885: new 468	java/lang/StringBuilder
    //   888: dup
    //   889: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   892: astore 22
    //   894: aload 22
    //   896: ldc 110
    //   898: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: pop
    //   902: aload 22
    //   904: aload_0
    //   905: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   908: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   911: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: aload 20
    //   917: aload 22
    //   919: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   925: aload 18
    //   927: invokevirtual 1826	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   930: checkcast 1828	java/net/HttpURLConnection
    //   933: astore 18
    //   935: aload 18
    //   937: ldc_w 1830
    //   940: invokevirtual 1833	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   943: iload 12
    //   945: ifeq +26 -> 971
    //   948: aload 18
    //   950: ldc_w 1835
    //   953: aload 19
    //   955: invokevirtual 1838	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   958: goto +13 -> 971
    //   961: astore 18
    //   963: goto -273 -> 690
    //   966: astore 18
    //   968: goto -265 -> 703
    //   971: aload 18
    //   973: ldc_w 1840
    //   976: ldc_w 1842
    //   979: invokevirtual 1838	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   982: aload 18
    //   984: ldc_w 1844
    //   987: ldc_w 1846
    //   990: invokevirtual 1838	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   993: aload 18
    //   995: ldc_w 1848
    //   998: aload 21
    //   1000: arraylength
    //   1001: invokestatic 1850	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1004: invokevirtual 1838	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1007: aload 18
    //   1009: aload_0
    //   1010: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1013: getfield 822	oicq/wlogin_sdk/request/t:l	I
    //   1016: invokevirtual 1853	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1019: aload 18
    //   1021: aload_0
    //   1022: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1025: getfield 822	oicq/wlogin_sdk/request/t:l	I
    //   1028: invokevirtual 1856	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1031: aload 18
    //   1033: iconst_1
    //   1034: invokevirtual 1860	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1037: aload 18
    //   1039: iconst_1
    //   1040: invokevirtual 1863	java/net/HttpURLConnection:setDoInput	(Z)V
    //   1043: new 468	java/lang/StringBuilder
    //   1046: dup
    //   1047: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1050: astore 19
    //   1052: aload 19
    //   1054: ldc 110
    //   1056: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: pop
    //   1060: aload 19
    //   1062: aload_0
    //   1063: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1066: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   1069: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1072: pop
    //   1073: ldc_w 1865
    //   1076: aload 19
    //   1078: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1081: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1084: aload 18
    //   1086: aload_0
    //   1087: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1090: getfield 822	oicq/wlogin_sdk/request/t:l	I
    //   1093: i2l
    //   1094: invokestatic 1870	oicq/wlogin_sdk/request/i:a	(Ljava/net/HttpURLConnection;J)Z
    //   1097: ifne +58 -> 1155
    //   1100: new 468	java/lang/StringBuilder
    //   1103: dup
    //   1104: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1107: astore 18
    //   1109: aload 18
    //   1111: ldc 110
    //   1113: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: pop
    //   1117: aload 18
    //   1119: aload_0
    //   1120: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1123: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   1126: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1129: pop
    //   1130: ldc_w 1872
    //   1133: aload 18
    //   1135: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1138: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1141: sipush -1026
    //   1144: iload_2
    //   1145: if_icmpeq +2584 -> 3729
    //   1148: sipush -1000
    //   1151: istore_3
    //   1152: goto +2579 -> 3731
    //   1155: new 468	java/lang/StringBuilder
    //   1158: dup
    //   1159: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1162: astore 19
    //   1164: aload 19
    //   1166: ldc 110
    //   1168: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: pop
    //   1172: aload 19
    //   1174: aload_0
    //   1175: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1178: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   1181: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1184: pop
    //   1185: ldc_w 1874
    //   1188: aload 19
    //   1190: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1193: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1196: aload 18
    //   1198: invokevirtual 1878	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1201: astore 19
    //   1203: aload 19
    //   1205: aload 21
    //   1207: iconst_0
    //   1208: aload 21
    //   1210: arraylength
    //   1211: invokevirtual 1883	java/io/OutputStream:write	([BII)V
    //   1214: aload 19
    //   1216: invokevirtual 1886	java/io/OutputStream:flush	()V
    //   1219: aload 18
    //   1221: invokevirtual 1889	java/net/HttpURLConnection:getResponseCode	()I
    //   1224: istore 5
    //   1226: new 468	java/lang/StringBuilder
    //   1229: dup
    //   1230: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1233: astore 19
    //   1235: aload 19
    //   1237: ldc_w 1891
    //   1240: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: pop
    //   1244: aload 19
    //   1246: iload 5
    //   1248: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1251: pop
    //   1252: aload 19
    //   1254: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1257: astore 19
    //   1259: new 468	java/lang/StringBuilder
    //   1262: dup
    //   1263: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1266: astore 20
    //   1268: aload 20
    //   1270: ldc 110
    //   1272: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: pop
    //   1276: aload 20
    //   1278: aload_0
    //   1279: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1282: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   1285: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1288: pop
    //   1289: aload 19
    //   1291: aload 20
    //   1293: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1296: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1299: sipush 200
    //   1302: iload 5
    //   1304: if_icmpeq +51 -> 1355
    //   1307: new 468	java/lang/StringBuilder
    //   1310: dup
    //   1311: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1314: astore 18
    //   1316: aload 18
    //   1318: ldc_w 1893
    //   1321: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: pop
    //   1325: aload 18
    //   1327: iload 5
    //   1329: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1332: pop
    //   1333: aload 18
    //   1335: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1338: ldc 110
    //   1340: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1343: iload 6
    //   1345: iconst_1
    //   1346: iadd
    //   1347: istore_2
    //   1348: sipush -1000
    //   1351: istore_3
    //   1352: goto +196 -> 1548
    //   1355: aload 18
    //   1357: invokevirtual 1897	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1360: astore 18
    //   1362: aload 17
    //   1364: astore 19
    //   1366: aload 18
    //   1368: astore 17
    //   1370: aload 15
    //   1372: astore 18
    //   1374: aload 19
    //   1376: astore 15
    //   1378: aload 16
    //   1380: astore 19
    //   1382: goto +1179 -> 2561
    //   1385: astore 18
    //   1387: iload 5
    //   1389: istore_2
    //   1390: goto +45 -> 1435
    //   1393: astore 18
    //   1395: goto +10 -> 1405
    //   1398: astore 18
    //   1400: goto +10 -> 1410
    //   1403: astore 18
    //   1405: goto +30 -> 1435
    //   1408: astore 18
    //   1410: goto +90 -> 1500
    //   1413: astore 18
    //   1415: goto +10 -> 1425
    //   1418: astore 18
    //   1420: goto +10 -> 1430
    //   1423: astore 18
    //   1425: goto +10 -> 1435
    //   1428: astore 18
    //   1430: goto +70 -> 1500
    //   1433: astore 18
    //   1435: new 468	java/lang/StringBuilder
    //   1438: dup
    //   1439: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1442: astore 19
    //   1444: aload 19
    //   1446: ldc_w 1899
    //   1449: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: pop
    //   1453: aload 19
    //   1455: aload 18
    //   1457: invokevirtual 1900	java/lang/Exception:toString	()Ljava/lang/String;
    //   1460: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: pop
    //   1464: aload 19
    //   1466: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1469: ldc 110
    //   1471: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1474: sipush -1026
    //   1477: iload_2
    //   1478: if_icmpeq +10 -> 1488
    //   1481: sipush -1000
    //   1484: istore_3
    //   1485: goto +5 -> 1490
    //   1488: iload_2
    //   1489: istore_3
    //   1490: iload 6
    //   1492: iconst_1
    //   1493: iadd
    //   1494: istore_2
    //   1495: goto +53 -> 1548
    //   1498: astore 18
    //   1500: new 468	java/lang/StringBuilder
    //   1503: dup
    //   1504: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1507: astore 19
    //   1509: aload 19
    //   1511: ldc_w 1902
    //   1514: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1517: pop
    //   1518: aload 19
    //   1520: aload 18
    //   1522: invokevirtual 1903	java/net/ConnectException:toString	()Ljava/lang/String;
    //   1525: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: pop
    //   1529: aload 19
    //   1531: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1534: ldc 110
    //   1536: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1539: iload 6
    //   1541: iconst_1
    //   1542: iadd
    //   1543: istore_2
    //   1544: sipush -1026
    //   1547: istore_3
    //   1548: iload_2
    //   1549: istore 5
    //   1551: iload_3
    //   1552: istore_2
    //   1553: iload 5
    //   1555: istore_3
    //   1556: goto -1440 -> 116
    //   1559: lload 8
    //   1561: lstore 10
    //   1563: iload_3
    //   1564: istore 5
    //   1566: new 468	java/lang/StringBuilder
    //   1569: dup
    //   1570: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1573: astore 18
    //   1575: aload 18
    //   1577: ldc_w 1905
    //   1580: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1583: pop
    //   1584: aload 18
    //   1586: iload 5
    //   1588: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1591: pop
    //   1592: aload 18
    //   1594: ldc_w 1780
    //   1597: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: pop
    //   1601: aload 18
    //   1603: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1606: astore 18
    //   1608: new 468	java/lang/StringBuilder
    //   1611: dup
    //   1612: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1615: astore 19
    //   1617: aload 19
    //   1619: ldc 110
    //   1621: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: pop
    //   1625: aload 19
    //   1627: aload_0
    //   1628: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1631: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   1634: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1637: pop
    //   1638: aload 18
    //   1640: aload 19
    //   1642: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1645: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1648: aload 17
    //   1650: ifnonnull +587 -> 2237
    //   1653: aload_0
    //   1654: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1657: ifnonnull +129 -> 1786
    //   1660: aload_0
    //   1661: iload 5
    //   1663: iload 13
    //   1665: invokevirtual 1782	oicq/wlogin_sdk/request/oicq_request:a	(IZ)Ljava/lang/String;
    //   1668: astore 18
    //   1670: new 468	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1677: astore 19
    //   1679: aload 19
    //   1681: ldc_w 1907
    //   1684: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: pop
    //   1688: aload 19
    //   1690: aload 18
    //   1692: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1695: pop
    //   1696: aload 19
    //   1698: ldc_w 1909
    //   1701: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1704: pop
    //   1705: aload 19
    //   1707: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1710: astore 19
    //   1712: new 468	java/lang/StringBuilder
    //   1715: dup
    //   1716: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1719: astore 20
    //   1721: aload 20
    //   1723: ldc 110
    //   1725: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1728: pop
    //   1729: aload 20
    //   1731: aload_0
    //   1732: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1735: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   1738: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1741: pop
    //   1742: aload 19
    //   1744: aload 20
    //   1746: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1749: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1752: aload_0
    //   1753: aload_0
    //   1754: iload 13
    //   1756: invokevirtual 245	oicq/wlogin_sdk/request/oicq_request:e	(Z)I
    //   1759: putfield 152	oicq/wlogin_sdk/request/oicq_request:r	I
    //   1762: aload_0
    //   1763: aload 18
    //   1765: aload_0
    //   1766: getfield 152	oicq/wlogin_sdk/request/oicq_request:r	I
    //   1769: aload_0
    //   1770: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1773: getfield 822	oicq/wlogin_sdk/request/t:l	I
    //   1776: i2l
    //   1777: invokestatic 1809	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   1780: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1783: goto +7 -> 1790
    //   1786: ldc 110
    //   1788: astore 18
    //   1790: iload 13
    //   1792: istore 14
    //   1794: aload_0
    //   1795: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1798: astore 19
    //   1800: aload 19
    //   1802: ifnull +98 -> 1900
    //   1805: aload 19
    //   1807: invokevirtual 236	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1810: ifnonnull +90 -> 1900
    //   1813: aload_0
    //   1814: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1817: invokevirtual 236	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1820: ifnonnull +44 -> 1864
    //   1823: new 468	java/lang/StringBuilder
    //   1826: dup
    //   1827: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1830: astore 17
    //   1832: aload 17
    //   1834: ldc 110
    //   1836: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1839: pop
    //   1840: aload 17
    //   1842: aload_0
    //   1843: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1846: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   1849: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1852: pop
    //   1853: ldc_w 1911
    //   1856: aload 17
    //   1858: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1861: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1864: iload 5
    //   1866: iconst_1
    //   1867: iadd
    //   1868: istore_3
    //   1869: aload_0
    //   1870: aconst_null
    //   1871: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1874: aload_0
    //   1875: aconst_null
    //   1876: invokevirtual 1913	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   1879: iload 14
    //   1881: istore 13
    //   1883: lload 10
    //   1885: lstore 8
    //   1887: sipush -1007
    //   1890: istore_2
    //   1891: iconst_1
    //   1892: istore 4
    //   1894: aconst_null
    //   1895: astore 17
    //   1897: goto -1781 -> 116
    //   1900: aload_0
    //   1901: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1904: astore 19
    //   1906: aload 19
    //   1908: ifnonnull +209 -> 2117
    //   1911: aload 19
    //   1913: ifnonnull +92 -> 2005
    //   1916: new 468	java/lang/StringBuilder
    //   1919: dup
    //   1920: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1923: astore 17
    //   1925: aload 17
    //   1927: ldc_w 1907
    //   1930: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1933: pop
    //   1934: aload 17
    //   1936: aload 18
    //   1938: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: pop
    //   1942: aload 17
    //   1944: ldc_w 1915
    //   1947: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1950: pop
    //   1951: aload 17
    //   1953: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1956: astore 17
    //   1958: new 468	java/lang/StringBuilder
    //   1961: dup
    //   1962: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   1965: astore 18
    //   1967: aload 18
    //   1969: ldc 110
    //   1971: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1974: pop
    //   1975: aload 18
    //   1977: aload_0
    //   1978: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1981: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   1984: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1987: pop
    //   1988: aload 17
    //   1990: aload 18
    //   1992: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1995: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1998: sipush -1007
    //   2001: istore_2
    //   2002: goto +90 -> 2092
    //   2005: new 468	java/lang/StringBuilder
    //   2008: dup
    //   2009: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   2012: astore 17
    //   2014: aload 17
    //   2016: ldc_w 1917
    //   2019: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2022: pop
    //   2023: aload 17
    //   2025: aload 16
    //   2027: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2030: pop
    //   2031: aload 17
    //   2033: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2036: astore 17
    //   2038: new 468	java/lang/StringBuilder
    //   2041: dup
    //   2042: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   2045: astore 18
    //   2047: aload 18
    //   2049: ldc 110
    //   2051: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2054: pop
    //   2055: aload 18
    //   2057: aload_0
    //   2058: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2061: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   2064: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2067: pop
    //   2068: aload 17
    //   2070: aload 18
    //   2072: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2075: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2078: sipush -1026
    //   2081: iload_2
    //   2082: if_icmpeq +10 -> 2092
    //   2085: sipush -1000
    //   2088: istore_2
    //   2089: goto +3 -> 2092
    //   2092: iload 5
    //   2094: iconst_1
    //   2095: iadd
    //   2096: istore_3
    //   2097: aload_0
    //   2098: aconst_null
    //   2099: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2102: aload_0
    //   2103: aconst_null
    //   2104: invokevirtual 1913	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2107: iload 14
    //   2109: istore 13
    //   2111: iconst_1
    //   2112: istore 4
    //   2114: goto +1192 -> 3306
    //   2117: aload 19
    //   2119: invokevirtual 236	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   2122: invokevirtual 242	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2125: astore 16
    //   2127: new 468	java/lang/StringBuilder
    //   2130: dup
    //   2131: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   2134: astore 19
    //   2136: aload 19
    //   2138: ldc_w 1907
    //   2141: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2144: pop
    //   2145: aload 19
    //   2147: aload 18
    //   2149: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2152: pop
    //   2153: aload 19
    //   2155: ldc_w 1919
    //   2158: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2161: pop
    //   2162: aload 19
    //   2164: aload_0
    //   2165: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2168: invokevirtual 1920	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   2171: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2174: pop
    //   2175: aload 19
    //   2177: ldc_w 1922
    //   2180: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2183: pop
    //   2184: aload 19
    //   2186: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2189: astore 18
    //   2191: new 468	java/lang/StringBuilder
    //   2194: dup
    //   2195: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   2198: astore 19
    //   2200: aload 19
    //   2202: ldc 110
    //   2204: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2207: pop
    //   2208: aload 19
    //   2210: aload_0
    //   2211: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2214: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   2217: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2220: pop
    //   2221: aload 18
    //   2223: aload 19
    //   2225: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2228: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2231: iconst_1
    //   2232: istore 4
    //   2234: goto +3 -> 2237
    //   2237: iload 13
    //   2239: istore 14
    //   2241: aload 17
    //   2243: ifnonnull +1496 -> 3739
    //   2246: new 468	java/lang/StringBuilder
    //   2249: dup
    //   2250: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   2253: astore 17
    //   2255: aload 17
    //   2257: ldc_w 1924
    //   2260: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2263: pop
    //   2264: aload 17
    //   2266: aload_0
    //   2267: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2270: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2273: pop
    //   2274: aload 17
    //   2276: ldc_w 1909
    //   2279: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2282: pop
    //   2283: aload 17
    //   2285: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2288: astore 17
    //   2290: new 468	java/lang/StringBuilder
    //   2293: dup
    //   2294: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   2297: astore 18
    //   2299: aload 18
    //   2301: ldc 110
    //   2303: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2306: pop
    //   2307: aload 18
    //   2309: aload_0
    //   2310: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2313: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   2316: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2319: pop
    //   2320: aload 17
    //   2322: aload 18
    //   2324: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2327: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2330: new 1926	java/net/Socket
    //   2333: dup
    //   2334: invokespecial 1927	java/net/Socket:<init>	()V
    //   2337: astore 17
    //   2339: aload_0
    //   2340: aload 17
    //   2342: invokevirtual 1913	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2345: aload 17
    //   2347: aload_0
    //   2348: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2351: aload_0
    //   2352: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2355: getfield 822	oicq/wlogin_sdk/request/t:l	I
    //   2358: invokevirtual 1931	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   2361: aload 17
    //   2363: aload_0
    //   2364: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2367: getfield 822	oicq/wlogin_sdk/request/t:l	I
    //   2370: invokevirtual 1934	java/net/Socket:setSoTimeout	(I)V
    //   2373: aload 17
    //   2375: aload_0
    //   2376: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2379: arraylength
    //   2380: invokevirtual 1937	java/net/Socket:setReceiveBufferSize	(I)V
    //   2383: new 468	java/lang/StringBuilder
    //   2386: dup
    //   2387: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   2390: astore 18
    //   2392: aload 18
    //   2394: ldc_w 1924
    //   2397: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2400: pop
    //   2401: aload 18
    //   2403: aload_0
    //   2404: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2407: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2410: pop
    //   2411: aload 18
    //   2413: ldc_w 1939
    //   2416: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2419: pop
    //   2420: aload 18
    //   2422: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2425: astore 18
    //   2427: new 468	java/lang/StringBuilder
    //   2430: dup
    //   2431: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   2434: astore 19
    //   2436: aload 19
    //   2438: ldc 110
    //   2440: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2443: pop
    //   2444: aload 19
    //   2446: aload_0
    //   2447: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2450: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   2453: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2456: pop
    //   2457: aload 18
    //   2459: aload 19
    //   2461: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2464: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2467: goto +3 -> 2470
    //   2470: new 468	java/lang/StringBuilder
    //   2473: dup
    //   2474: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   2477: astore 18
    //   2479: aload 18
    //   2481: ldc 110
    //   2483: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2486: pop
    //   2487: aload 18
    //   2489: aload_0
    //   2490: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2493: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   2496: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2499: pop
    //   2500: ldc_w 1941
    //   2503: aload 18
    //   2505: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2508: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2511: aload 17
    //   2513: invokevirtual 1942	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   2516: astore 18
    //   2518: aload 18
    //   2520: aload 21
    //   2522: iconst_0
    //   2523: aload 21
    //   2525: arraylength
    //   2526: invokevirtual 1883	java/io/OutputStream:write	([BII)V
    //   2529: aload 18
    //   2531: invokevirtual 1886	java/io/OutputStream:flush	()V
    //   2534: aload 17
    //   2536: invokevirtual 1943	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   2539: astore 18
    //   2541: aload 16
    //   2543: astore 19
    //   2545: aload 18
    //   2547: astore 16
    //   2549: aload 15
    //   2551: astore 18
    //   2553: aload 17
    //   2555: astore 15
    //   2557: aload 16
    //   2559: astore 17
    //   2561: new 468	java/lang/StringBuilder
    //   2564: dup
    //   2565: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   2568: astore 16
    //   2570: aload 16
    //   2572: ldc 110
    //   2574: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2577: pop
    //   2578: aload 16
    //   2580: aload_0
    //   2581: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2584: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   2587: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2590: pop
    //   2591: ldc_w 1945
    //   2594: aload 16
    //   2596: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2599: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2602: iconst_0
    //   2603: istore_2
    //   2604: iconst_0
    //   2605: istore 5
    //   2607: iload_2
    //   2608: aload_0
    //   2609: getfield 128	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2612: iconst_1
    //   2613: iadd
    //   2614: if_icmpge +31 -> 2645
    //   2617: aload 17
    //   2619: aload_0
    //   2620: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2623: iload_2
    //   2624: aload_0
    //   2625: getfield 128	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2628: iconst_1
    //   2629: iadd
    //   2630: iload_2
    //   2631: isub
    //   2632: invokevirtual 1950	java/io/InputStream:read	([BII)I
    //   2635: istore 5
    //   2637: iload 5
    //   2639: ifge +1103 -> 3742
    //   2642: goto +3 -> 2645
    //   2645: iload 5
    //   2647: ifge +107 -> 2754
    //   2650: new 468	java/lang/StringBuilder
    //   2653: dup
    //   2654: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   2657: astore 16
    //   2659: aload 16
    //   2661: ldc_w 1952
    //   2664: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2667: pop
    //   2668: aload 16
    //   2670: iload 5
    //   2672: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2675: pop
    //   2676: aload 16
    //   2678: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2681: ldc 110
    //   2683: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2686: iload_3
    //   2687: iconst_1
    //   2688: iadd
    //   2689: istore_2
    //   2690: iload_2
    //   2691: istore_3
    //   2692: aload 15
    //   2694: astore 16
    //   2696: iload_1
    //   2697: istore 5
    //   2699: iload 13
    //   2701: ifne +43 -> 2744
    //   2704: aload 15
    //   2706: invokevirtual 1955	java/net/Socket:close	()V
    //   2709: aload_0
    //   2710: aconst_null
    //   2711: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2714: aload_0
    //   2715: aconst_null
    //   2716: invokevirtual 1913	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2719: aconst_null
    //   2720: astore 17
    //   2722: iload_2
    //   2723: istore_3
    //   2724: goto +493 -> 3217
    //   2727: astore 16
    //   2729: aconst_null
    //   2730: astore 15
    //   2732: iload_2
    //   2733: istore_3
    //   2734: goto +400 -> 3134
    //   2737: astore 16
    //   2739: iload_2
    //   2740: istore_3
    //   2741: goto +393 -> 3134
    //   2744: aload 16
    //   2746: astore 17
    //   2748: iload 5
    //   2750: istore_1
    //   2751: goto +466 -> 3217
    //   2754: aload_0
    //   2755: aload_0
    //   2756: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2759: invokevirtual 1957	oicq/wlogin_sdk/request/oicq_request:b	([B)I
    //   2762: istore_2
    //   2763: iload_2
    //   2764: aload_0
    //   2765: getfield 128	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2768: iconst_1
    //   2769: iadd
    //   2770: if_icmpgt +130 -> 2900
    //   2773: new 468	java/lang/StringBuilder
    //   2776: dup
    //   2777: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   2780: astore 16
    //   2782: aload 16
    //   2784: ldc_w 1959
    //   2787: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2790: pop
    //   2791: aload 16
    //   2793: iload_2
    //   2794: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2797: pop
    //   2798: aload 16
    //   2800: ldc_w 1961
    //   2803: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2806: pop
    //   2807: aload 16
    //   2809: aload_0
    //   2810: getfield 128	oicq/wlogin_sdk/request/oicq_request:f	I
    //   2813: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2816: pop
    //   2817: aload 16
    //   2819: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2822: ldc 110
    //   2824: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2827: iload_3
    //   2828: iconst_1
    //   2829: iadd
    //   2830: istore_3
    //   2831: iload_3
    //   2832: istore_1
    //   2833: iload 13
    //   2835: ifne +54 -> 2889
    //   2838: iload_3
    //   2839: istore_1
    //   2840: aload 15
    //   2842: invokevirtual 1955	java/net/Socket:close	()V
    //   2845: iload_3
    //   2846: istore_1
    //   2847: aload_0
    //   2848: aconst_null
    //   2849: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2852: iload_3
    //   2853: istore_1
    //   2854: aload_0
    //   2855: aconst_null
    //   2856: invokevirtual 1913	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2859: aconst_null
    //   2860: astore 17
    //   2862: iload_3
    //   2863: istore_1
    //   2864: goto +29 -> 2893
    //   2867: astore 16
    //   2869: iload_2
    //   2870: istore_3
    //   2871: iload_1
    //   2872: istore_2
    //   2873: iload_3
    //   2874: istore_1
    //   2875: goto -146 -> 2729
    //   2878: astore 16
    //   2880: iload_2
    //   2881: istore_3
    //   2882: iload_1
    //   2883: istore_2
    //   2884: iload_3
    //   2885: istore_1
    //   2886: goto -147 -> 2739
    //   2889: aload 15
    //   2891: astore 17
    //   2893: iload_1
    //   2894: istore_3
    //   2895: iload_2
    //   2896: istore_1
    //   2897: goto +320 -> 3217
    //   2900: iload_2
    //   2901: aload_0
    //   2902: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2905: arraylength
    //   2906: if_icmplt +93 -> 2999
    //   2909: new 468	java/lang/StringBuilder
    //   2912: dup
    //   2913: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   2916: astore 16
    //   2918: aload 16
    //   2920: ldc_w 1959
    //   2923: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2926: pop
    //   2927: aload 16
    //   2929: iload_2
    //   2930: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2933: pop
    //   2934: aload 16
    //   2936: ldc_w 1963
    //   2939: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2942: pop
    //   2943: aload 16
    //   2945: aload_0
    //   2946: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2949: arraylength
    //   2950: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2953: pop
    //   2954: aload 16
    //   2956: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2959: ldc 110
    //   2961: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2964: iload_3
    //   2965: iconst_1
    //   2966: iadd
    //   2967: istore_3
    //   2968: iload_3
    //   2969: istore_1
    //   2970: iload 13
    //   2972: ifne -83 -> 2889
    //   2975: iload_3
    //   2976: istore_1
    //   2977: aload 15
    //   2979: invokevirtual 1955	java/net/Socket:close	()V
    //   2982: iload_3
    //   2983: istore_1
    //   2984: aload_0
    //   2985: aconst_null
    //   2986: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2989: iload_3
    //   2990: istore_1
    //   2991: aload_0
    //   2992: aconst_null
    //   2993: invokevirtual 1913	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2996: goto -137 -> 2859
    //   2999: aload_0
    //   3000: getfield 128	oicq/wlogin_sdk/request/oicq_request:f	I
    //   3003: iconst_1
    //   3004: iadd
    //   3005: istore 6
    //   3007: iload_2
    //   3008: iload 6
    //   3010: isub
    //   3011: istore_1
    //   3012: iload_1
    //   3013: ifle +752 -> 3765
    //   3016: aload 17
    //   3018: aload_0
    //   3019: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   3022: iload 6
    //   3024: iload_1
    //   3025: invokevirtual 1950	java/io/InputStream:read	([BII)I
    //   3028: istore 5
    //   3030: iload 5
    //   3032: iconst_m1
    //   3033: if_icmpne +717 -> 3750
    //   3036: goto +3 -> 3039
    //   3039: iload 5
    //   3041: iconst_m1
    //   3042: if_icmpne +74 -> 3116
    //   3045: new 468	java/lang/StringBuilder
    //   3048: dup
    //   3049: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   3052: astore 16
    //   3054: aload 16
    //   3056: ldc_w 1965
    //   3059: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3062: pop
    //   3063: aload 16
    //   3065: iload 5
    //   3067: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3070: pop
    //   3071: aload 16
    //   3073: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3076: ldc 110
    //   3078: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3081: iload_3
    //   3082: iconst_1
    //   3083: iadd
    //   3084: istore_3
    //   3085: iload_3
    //   3086: istore_1
    //   3087: iload 13
    //   3089: ifne -200 -> 2889
    //   3092: iload_3
    //   3093: istore_1
    //   3094: aload 15
    //   3096: invokevirtual 1955	java/net/Socket:close	()V
    //   3099: iload_3
    //   3100: istore_1
    //   3101: aload_0
    //   3102: aconst_null
    //   3103: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3106: iload_3
    //   3107: istore_1
    //   3108: aload_0
    //   3109: aconst_null
    //   3110: invokevirtual 1913	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   3113: goto -254 -> 2859
    //   3116: iload 5
    //   3118: istore_1
    //   3119: iload_2
    //   3120: istore 5
    //   3122: goto +262 -> 3384
    //   3125: astore 16
    //   3127: iload_2
    //   3128: istore_1
    //   3129: goto +5 -> 3134
    //   3132: astore 16
    //   3134: new 468	java/lang/StringBuilder
    //   3137: dup
    //   3138: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   3141: astore 17
    //   3143: aload 17
    //   3145: ldc_w 1967
    //   3148: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3151: pop
    //   3152: aload 17
    //   3154: aload 16
    //   3156: invokestatic 1378	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3159: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3162: pop
    //   3163: aload 17
    //   3165: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3168: ldc 110
    //   3170: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3173: iload_3
    //   3174: iconst_1
    //   3175: iadd
    //   3176: istore_2
    //   3177: iload_2
    //   3178: istore_3
    //   3179: aload 15
    //   3181: astore 16
    //   3183: iload_1
    //   3184: istore 5
    //   3186: iload 13
    //   3188: ifne -444 -> 2744
    //   3191: aload 15
    //   3193: invokevirtual 1970	java/net/Socket:isConnected	()Z
    //   3196: ifeq +8 -> 3204
    //   3199: aload 15
    //   3201: invokevirtual 1955	java/net/Socket:close	()V
    //   3204: aload_0
    //   3205: aconst_null
    //   3206: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3209: aload_0
    //   3210: aconst_null
    //   3211: invokevirtual 1913	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   3214: goto -495 -> 2719
    //   3217: aload 19
    //   3219: astore 16
    //   3221: sipush -1000
    //   3224: istore_2
    //   3225: aload 18
    //   3227: astore 15
    //   3229: goto -3113 -> 116
    //   3232: astore 17
    //   3234: new 468	java/lang/StringBuilder
    //   3237: dup
    //   3238: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   3241: astore 18
    //   3243: aload 18
    //   3245: ldc_w 1972
    //   3248: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3251: pop
    //   3252: aload 18
    //   3254: aload 17
    //   3256: invokestatic 1378	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3259: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3262: pop
    //   3263: aload 18
    //   3265: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3268: ldc 110
    //   3270: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3273: sipush -1026
    //   3276: iload_2
    //   3277: if_icmpeq +10 -> 3287
    //   3280: sipush -1000
    //   3283: istore_2
    //   3284: goto +3 -> 3287
    //   3287: iload 5
    //   3289: iconst_1
    //   3290: iadd
    //   3291: istore_3
    //   3292: aload_0
    //   3293: aconst_null
    //   3294: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3297: aload_0
    //   3298: aconst_null
    //   3299: invokevirtual 1913	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   3302: iload 14
    //   3304: istore 13
    //   3306: goto +67 -> 3373
    //   3309: astore 17
    //   3311: new 468	java/lang/StringBuilder
    //   3314: dup
    //   3315: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   3318: astore 18
    //   3320: aload 18
    //   3322: ldc_w 1974
    //   3325: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3328: pop
    //   3329: aload 18
    //   3331: aload 17
    //   3333: invokevirtual 1903	java/net/ConnectException:toString	()Ljava/lang/String;
    //   3336: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3339: pop
    //   3340: aload 18
    //   3342: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3345: ldc 110
    //   3347: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3350: iload 5
    //   3352: iconst_1
    //   3353: iadd
    //   3354: istore_3
    //   3355: aload_0
    //   3356: aconst_null
    //   3357: putfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3360: aload_0
    //   3361: aconst_null
    //   3362: invokevirtual 1913	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   3365: iload 14
    //   3367: istore 13
    //   3369: sipush -1026
    //   3372: istore_2
    //   3373: aconst_null
    //   3374: astore 17
    //   3376: goto -3260 -> 116
    //   3379: iload_1
    //   3380: istore 5
    //   3382: iload_2
    //   3383: istore_1
    //   3384: iload_3
    //   3385: bipush 6
    //   3387: if_icmplt +19 -> 3406
    //   3390: iload_1
    //   3391: istore_2
    //   3392: sipush -1026
    //   3395: iload_1
    //   3396: if_icmpeq +12 -> 3408
    //   3399: sipush -1000
    //   3402: istore_2
    //   3403: goto +5 -> 3408
    //   3406: iconst_0
    //   3407: istore_2
    //   3408: iload_2
    //   3409: ifne +13 -> 3422
    //   3412: aload_0
    //   3413: aload_0
    //   3414: getfield 154	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   3417: iload 5
    //   3419: invokevirtual 862	oicq/wlogin_sdk/request/oicq_request:b	([BI)V
    //   3422: iload_2
    //   3423: ifne +209 -> 3632
    //   3426: aload_0
    //   3427: getfield 156	oicq/wlogin_sdk/request/oicq_request:t	I
    //   3430: sipush 2066
    //   3433: if_icmpeq +199 -> 3632
    //   3436: new 202	oicq/wlogin_sdk/report/report_t3
    //   3439: dup
    //   3440: invokespecial 203	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   3443: astore 15
    //   3445: aload 15
    //   3447: aload_0
    //   3448: getfield 156	oicq/wlogin_sdk/request/oicq_request:t	I
    //   3451: putfield 206	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   3454: aload 15
    //   3456: aload_0
    //   3457: getfield 158	oicq/wlogin_sdk/request/oicq_request:u	I
    //   3460: putfield 209	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   3463: aload 15
    //   3465: iload_2
    //   3466: putfield 212	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   3469: aload 15
    //   3471: invokestatic 218	java/lang/System:currentTimeMillis	()J
    //   3474: lload 8
    //   3476: lsub
    //   3477: l2i
    //   3478: putfield 221	oicq/wlogin_sdk/report/report_t3:_used	I
    //   3481: aload 15
    //   3483: iload_3
    //   3484: putfield 224	oicq/wlogin_sdk/report/report_t3:_try	I
    //   3487: aload 15
    //   3489: getstatic 114	oicq/wlogin_sdk/request/oicq_request:J	Ljava/lang/String;
    //   3492: putfield 227	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   3495: aload 15
    //   3497: getfield 227	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   3500: ifnonnull +10 -> 3510
    //   3503: aload 15
    //   3505: ldc 110
    //   3507: putfield 227	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   3510: aload_0
    //   3511: getfield 150	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   3514: astore 16
    //   3516: aload 16
    //   3518: ifnonnull +13 -> 3531
    //   3521: aload 15
    //   3523: ldc 110
    //   3525: putfield 230	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   3528: goto +16 -> 3544
    //   3531: aload 15
    //   3533: aload 16
    //   3535: invokevirtual 236	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   3538: invokevirtual 242	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   3541: putfield 230	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   3544: aload 15
    //   3546: aload_0
    //   3547: getfield 152	oicq/wlogin_sdk/request/oicq_request:r	I
    //   3550: putfield 248	oicq/wlogin_sdk/report/report_t3:_port	I
    //   3553: aload 15
    //   3555: iload 4
    //   3557: putfield 251	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   3560: aload 15
    //   3562: getstatic 255	oicq/wlogin_sdk/request/t:E	I
    //   3565: putfield 258	oicq/wlogin_sdk/report/report_t3:_net	I
    //   3568: aload 15
    //   3570: ldc 110
    //   3572: putfield 261	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   3575: aload 15
    //   3577: aload 21
    //   3579: arraylength
    //   3580: putfield 264	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   3583: aload 15
    //   3585: iload 5
    //   3587: putfield 267	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   3590: iload 13
    //   3592: ifeq +26 -> 3618
    //   3595: iload 12
    //   3597: ifeq +12 -> 3609
    //   3600: aload 15
    //   3602: iconst_2
    //   3603: putfield 270	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   3606: goto +18 -> 3624
    //   3609: aload 15
    //   3611: iconst_1
    //   3612: putfield 270	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   3615: goto +9 -> 3624
    //   3618: aload 15
    //   3620: iconst_0
    //   3621: putfield 270	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   3624: getstatic 274	oicq/wlogin_sdk/request/t:at	Loicq/wlogin_sdk/report/Reporter;
    //   3627: aload 15
    //   3629: invokevirtual 280	oicq/wlogin_sdk/report/Reporter:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   3632: new 468	java/lang/StringBuilder
    //   3635: dup
    //   3636: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   3639: astore 15
    //   3641: aload 15
    //   3643: aload_0
    //   3644: invokevirtual 814	java/lang/Object:getClass	()Ljava/lang/Class;
    //   3647: invokevirtual 819	java/lang/Class:getName	()Ljava/lang/String;
    //   3650: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3653: pop
    //   3654: aload 15
    //   3656: ldc_w 1976
    //   3659: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3662: pop
    //   3663: aload 15
    //   3665: iload_2
    //   3666: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3669: pop
    //   3670: aload 15
    //   3672: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3675: astore 15
    //   3677: new 468	java/lang/StringBuilder
    //   3680: dup
    //   3681: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   3684: astore 16
    //   3686: aload 16
    //   3688: ldc 110
    //   3690: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3693: pop
    //   3694: aload 16
    //   3696: aload_0
    //   3697: getfield 291	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   3700: getfield 489	oicq/wlogin_sdk/request/t:f	J
    //   3703: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3706: pop
    //   3707: aload 15
    //   3709: aload 16
    //   3711: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3714: invokestatic 368	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3717: iload_2
    //   3718: ireturn
    //   3719: astore 19
    //   3721: goto -1931 -> 1790
    //   3724: astore 15
    //   3726: goto -522 -> 3204
    //   3729: iload_2
    //   3730: istore_3
    //   3731: iload 6
    //   3733: iconst_1
    //   3734: iadd
    //   3735: istore_2
    //   3736: goto -2241 -> 1495
    //   3739: goto -1269 -> 2470
    //   3742: iload_2
    //   3743: iload 5
    //   3745: iadd
    //   3746: istore_2
    //   3747: goto -1140 -> 2607
    //   3750: iload 6
    //   3752: iload 5
    //   3754: iadd
    //   3755: istore 6
    //   3757: iload_1
    //   3758: iload 5
    //   3760: isub
    //   3761: istore_1
    //   3762: goto -750 -> 3012
    //   3765: goto -726 -> 3039
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3768	0	this	oicq_request
    //   115	3647	1	i1	int
    //   105	3642	2	i2	int
    //   107	3624	3	i3	int
    //   109	3447	4	i4	int
    //   302	3459	5	i5	int
    //   205	3551	6	i6	int
    //   314	3	7	i7	int
    //   91	3384	8	l1	long
    //   1561	323	10	l2	long
    //   112	3484	12	bool1	boolean
    //   102	3489	13	bool2	boolean
    //   287	3079	14	bool3	boolean
    //   7	3701	15	localObject1	Object
    //   3724	1	15	localException1	Exception
    //   45	2650	16	localObject2	Object
    //   2727	1	16	localThrowable1	Throwable
    //   2737	8	16	localThrowable2	Throwable
    //   2780	38	16	localStringBuilder1	StringBuilder
    //   2867	1	16	localThrowable3	Throwable
    //   2878	1	16	localThrowable4	Throwable
    //   2916	156	16	localStringBuilder2	StringBuilder
    //   3125	1	16	localThrowable5	Throwable
    //   3132	23	16	localThrowable6	Throwable
    //   3181	529	16	localObject3	Object
    //   88	3076	17	localObject4	Object
    //   3232	23	17	localThrowable7	Throwable
    //   3309	23	17	localConnectException1	java.net.ConnectException
    //   3374	1	17	localObject5	Object
    //   193	117	18	localObject6	Object
    //   337	1	18	localException2	Exception
    //   346	30	18	localConnectException2	java.net.ConnectException
    //   471	1	18	localException3	Exception
    //   476	1	18	localConnectException3	java.net.ConnectException
    //   481	1	18	localException4	Exception
    //   489	1	18	localConnectException4	java.net.ConnectException
    //   497	1	18	localException5	Exception
    //   506	1	18	localConnectException5	java.net.ConnectException
    //   516	79	18	localObject7	Object
    //   599	1	18	localException6	Exception
    //   604	1	18	localConnectException6	java.net.ConnectException
    //   631	106	18	localObject8	Object
    //   745	1	18	localException7	Exception
    //   750	1	18	localConnectException7	java.net.ConnectException
    //   755	1	18	localException8	Exception
    //   760	1	18	localConnectException8	java.net.ConnectException
    //   767	182	18	localObject9	Object
    //   961	1	18	localException9	Exception
    //   966	119	18	localConnectException9	java.net.ConnectException
    //   1107	266	18	localObject10	Object
    //   1385	1	18	localException10	Exception
    //   1393	1	18	localException11	Exception
    //   1398	1	18	localConnectException10	java.net.ConnectException
    //   1403	1	18	localException12	Exception
    //   1408	1	18	localConnectException11	java.net.ConnectException
    //   1413	1	18	localException13	Exception
    //   1418	1	18	localConnectException12	java.net.ConnectException
    //   1423	1	18	localException14	Exception
    //   1428	1	18	localConnectException13	java.net.ConnectException
    //   1433	23	18	localException15	Exception
    //   1498	23	18	localConnectException14	java.net.ConnectException
    //   1573	1768	18	localObject11	Object
    //   238	373	19	localObject12	Object
    //   680	7	19	localException16	Exception
    //   693	261	19	localConnectException15	java.net.ConnectException
    //   1050	2168	19	localObject13	Object
    //   3719	1	19	localException17	Exception
    //   362	1383	20	localObject14	Object
    //   82	3496	21	arrayOfByte	byte[]
    //   428	490	22	localStringBuilder3	StringBuilder
    //   442	5	23	localt	t
    // Exception table:
    //   from	to	target	type
    //   309	316	337	java/lang/Exception
    //   309	316	346	java/net/ConnectException
    //   444	465	471	java/lang/Exception
    //   444	465	476	java/net/ConnectException
    //   355	444	481	java/lang/Exception
    //   355	444	489	java/net/ConnectException
    //   294	304	497	java/lang/Exception
    //   294	304	506	java/net/ConnectException
    //   530	596	599	java/lang/Exception
    //   530	596	604	java/net/ConnectException
    //   668	673	680	java/lang/Exception
    //   668	673	693	java/net/ConnectException
    //   654	663	745	java/lang/Exception
    //   706	745	745	java/lang/Exception
    //   654	663	750	java/net/ConnectException
    //   706	745	750	java/net/ConnectException
    //   638	650	755	java/lang/Exception
    //   638	650	760	java/net/ConnectException
    //   948	958	961	java/lang/Exception
    //   948	958	966	java/net/ConnectException
    //   1226	1299	1385	java/lang/Exception
    //   1307	1343	1385	java/lang/Exception
    //   1355	1362	1385	java/lang/Exception
    //   1031	1141	1393	java/lang/Exception
    //   1155	1226	1393	java/lang/Exception
    //   1031	1141	1398	java/net/ConnectException
    //   1155	1226	1398	java/net/ConnectException
    //   1226	1299	1398	java/net/ConnectException
    //   1307	1343	1398	java/net/ConnectException
    //   1355	1362	1398	java/net/ConnectException
    //   818	943	1403	java/lang/Exception
    //   971	1031	1403	java/lang/Exception
    //   818	943	1408	java/net/ConnectException
    //   971	1031	1408	java/net/ConnectException
    //   769	818	1413	java/lang/Exception
    //   769	818	1418	java/net/ConnectException
    //   609	633	1423	java/lang/Exception
    //   609	633	1428	java/net/ConnectException
    //   281	289	1433	java/lang/Exception
    //   281	289	1498	java/net/ConnectException
    //   2714	2719	2727	java/lang/Throwable
    //   2704	2714	2737	java/lang/Throwable
    //   2854	2859	2867	java/lang/Throwable
    //   2991	2996	2867	java/lang/Throwable
    //   3108	3113	2867	java/lang/Throwable
    //   2840	2845	2878	java/lang/Throwable
    //   2847	2852	2878	java/lang/Throwable
    //   2977	2982	2878	java/lang/Throwable
    //   2984	2989	2878	java/lang/Throwable
    //   3094	3099	2878	java/lang/Throwable
    //   3101	3106	2878	java/lang/Throwable
    //   2763	2827	3125	java/lang/Throwable
    //   2900	2964	3125	java/lang/Throwable
    //   2999	3007	3125	java/lang/Throwable
    //   3016	3030	3125	java/lang/Throwable
    //   3045	3081	3125	java/lang/Throwable
    //   2561	2602	3132	java/lang/Throwable
    //   2607	2637	3132	java/lang/Throwable
    //   2650	2686	3132	java/lang/Throwable
    //   2754	2763	3132	java/lang/Throwable
    //   2246	2467	3232	java/lang/Throwable
    //   2470	2541	3232	java/lang/Throwable
    //   2246	2467	3309	java/net/ConnectException
    //   2470	2541	3309	java/net/ConnectException
    //   1752	1783	3719	java/lang/Exception
    //   3191	3204	3724	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.oicq_request
 * JD-Core Version:    0.7.0.1
 */