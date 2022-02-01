package com.tencent.xweb.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.JsRuntime.JsRuntimeType;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ab;
import com.tencent.xweb.internal.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class h
{
  public static String a = "";
  public static String b = "";
  static WebView.c c = WebView.c.a;
  static ab d = null;
  static boolean e = false;
  private static boolean f = false;
  
  public static void A()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 26L, 1L);
    }
  }
  
  public static void B()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 14L, 1L);
    }
  }
  
  public static void C()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 15L, 1L);
    }
  }
  
  public static void D()
  {
    ab localab = d;
    if (localab == null) {
      return;
    }
    localab.a(577L, 83L, 1L);
  }
  
  public static void E()
  {
    ab localab = d;
    if (localab == null) {
      return;
    }
    localab.a(577L, 87L, 1L);
  }
  
  public static void F()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 180L, 1L);
    }
  }
  
  public static void G()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 181L, 1L);
    }
  }
  
  public static void H()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 182L, 1L);
    }
  }
  
  public static void I()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 183L, 1L);
    }
  }
  
  public static void J()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 184L, 1L);
    }
  }
  
  public static void K()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 189L, 1L);
    }
  }
  
  public static void L()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 190L, 1L);
    }
  }
  
  public static void M()
  {
    ab localab = d;
    if (localab == null) {
      return;
    }
    localab.a(577L, 88L, 1L);
  }
  
  public static boolean N()
  {
    return d != null;
  }
  
  public static void O()
  {
    a(938L, 89L, 1L);
  }
  
  public static void P()
  {
    a(938L, 90L, 1L);
  }
  
  public static void Q()
  {
    a(938L, 91L, 1L);
  }
  
  public static WebView.c a()
  {
    return WebView.getCurWebType();
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (d == null) {
      return;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedTransportOld("REPORT_DAILY");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("id_");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("_key_");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
    if (str.equals(localSharedPreferences.getString((String)localObject, ""))) {
      return;
    }
    d.a(paramInt1, paramInt2, 1L);
    localSharedPreferences.edit().putString((String)localObject, str).commit();
  }
  
  public static void a(int paramInt, String paramString)
  {
    ab localab = d;
    if (localab != null) {
      localab.a(paramInt, paramString);
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    if (d != null)
    {
      int i = 0;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              paramInt = i;
            } else if (paramBoolean) {
              paramInt = 166;
            } else {
              paramInt = 162;
            }
          }
          else if (paramBoolean) {
            paramInt = 165;
          } else {
            paramInt = 161;
          }
        }
        else if (paramBoolean) {
          paramInt = 164;
        } else {
          paramInt = 160;
        }
      }
      else if (paramBoolean) {
        paramInt = 163;
      } else {
        paramInt = 159;
      }
      if (paramInt > 0) {
        d.a(577L, paramInt, 1L);
      }
    }
  }
  
  public static void a(long paramLong)
  {
    ab localab = d;
    if ((localab != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      localab.a(577, 577, 2, 3, 1, (int)paramLong);
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, paramLong, paramInt);
    }
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3)
  {
    ab localab = d;
    if (localab != null) {
      localab.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  public static void a(WebView.c paramc)
  {
    c = paramc;
  }
  
  public static void a(WebView.c paramc, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("kv_");
    ((StringBuilder)localObject).append(h.b.a.a);
    ((StringBuilder)localObject).append(paramc.toString());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    if (c.b(((StringBuilder)localObject).toString()))
    {
      localObject = new h.a(h.b.a.a);
      ((h.a)localObject).a(21, Integer.valueOf(paramInt));
      if (paramc == WebView.c.b)
      {
        ((h.a)localObject).a(22, Integer.valueOf(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
      }
      else
      {
        WebView.c localc = WebView.c.c;
        paramInt = 0;
        if (paramc != localc) {}
      }
    }
    try
    {
      int i = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
      paramInt = i;
    }
    catch (Exception localException)
    {
      label125:
      break label125;
    }
    Log.e("onUseCoreFailed", "get tbs core version failed");
    ((h.a)localObject).a(22, Integer.valueOf(paramInt));
    break label180;
    if (paramc == WebView.c.d) {
      ((h.a)localObject).a(22, Integer.valueOf(XWalkEnvironment.safeGetChromiunVersion()));
    } else {
      ((h.a)localObject).a(22, Integer.valueOf(0));
    }
    label180:
    ((h.a)localObject).a(23, Integer.valueOf(201201));
    if ("armeabi-v7a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
      ((h.a)localObject).a(24, Integer.valueOf(h.b.a.d));
    } else if ("arm64-v8a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
      ((h.a)localObject).a(24, Integer.valueOf(h.b.a.e));
    }
    ((h.a)localObject).a(25, Integer.valueOf(paramc.ordinal()));
    ((h.a)localObject).a();
  }
  
  public static void a(ab paramab)
  {
    d = paramab;
  }
  
  public static void a(String paramString)
  {
    if (paramString != null) {
      b = paramString;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (d != null)
    {
      b(paramString);
      a = t();
      d.a(577L, 4L, 1L);
      ab localab = d;
      int j = XWalkEnvironment.getAvailableVersion();
      int k = c(paramString);
      paramString = a;
      int i;
      if (JsRuntime.a() == null) {
        i = 100;
      } else {
        i = JsRuntime.a().ordinal();
      }
      localab.a(15003, 201201, j, 0, k, paramString, i, -1, 0, 0, 0, paramInt, "");
    }
  }
  
  public static void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (d != null)
    {
      h();
      d.a(577L, 5L, 1L);
      d.a(15003, "");
      ab localab = d;
      int j = XWalkEnvironment.getAvailableVersion();
      int k = c(paramString);
      paramString = a;
      int i;
      if (JsRuntime.a() == null) {
        i = 100;
      } else {
        i = JsRuntime.a().ordinal();
      }
      localab.a(15003, 201201, j, 0, k, paramString, i, -1, 1, paramInt1, (int)paramLong, paramInt2, "");
    }
  }
  
  public static void a(String paramString, long paramLong, int paramInt)
  {
    a(paramLong);
    ab localab = d;
    if ((localab != null) && (paramLong > 0L) && (paramLong < 300000L))
    {
      int j = (int)paramLong;
      localab.a(577, 577, 6, 7, 1, j);
      localab = d;
      int k = XWalkEnvironment.getAvailableVersion();
      int m = c(paramString);
      paramString = a;
      int i;
      if (JsRuntime.a() == null) {
        i = 100;
      } else {
        i = JsRuntime.a().ordinal();
      }
      localab.a(15003, 201201, k, 0, m, paramString, i, -1, 1, 0, j, paramInt, "");
    }
  }
  
  public static void a(String paramString, WebView paramWebView)
  {
    try
    {
      ab localab = d;
      if (localab == null) {
        return;
      }
      g();
      if (paramWebView.isX5WrappedSysKernel()) {
        f();
      }
      if ((paramString != null) && ("https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(paramString.trim()))) {
        d.a(903L, 102L, 1L);
      }
      int i = e();
      int j = WebView.getCurWebType().ordinal() - 1;
      if ((i >= 30) && (j >= 0)) {
        d.a(903L, i + 0 + j, 1L);
      }
      if ("toolsmp".equals(b)) {
        if (b()) {
          d.a(903L, 107L, 1L);
        } else if (c()) {
          d.a(903L, 109L, 1L);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (d == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 51;
    } else {
      i = 60;
    }
    if ("FullScreenVideo".equals(paramString))
    {
      d.a(577L, 185L, 1L);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      d.a(1068L, i, 1L);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      d.a(1071L, i, 1L);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      d.a(1069L, i, 1L);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      d.a(1070L, i, 1L);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      d.a(1544L, i, 1L);
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 15625) || (paramInt == 15626);
  }
  
  public static void b(int paramInt)
  {
    if (!"toolsmp".equals(b)) {
      return;
    }
    int j;
    if (a() == WebView.c.b)
    {
      j = 200;
    }
    else
    {
      if (a() != WebView.c.c) {
        return;
      }
      j = 220;
    }
    int i;
    if (paramInt < 0)
    {
      i = 3;
    }
    else
    {
      i = paramInt;
      if (paramInt > 9) {
        i = 4;
      }
    }
    a(903L, j + i, 1L);
  }
  
  public static void b(int paramInt, boolean paramBoolean)
  {
    if (d != null)
    {
      int i = 0;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              paramInt = i;
            } else if (paramBoolean) {
              paramInt = 158;
            } else {
              paramInt = 154;
            }
          }
          else if (paramBoolean) {
            paramInt = 157;
          } else {
            paramInt = 153;
          }
        }
        else if (paramBoolean) {
          paramInt = 156;
        } else {
          paramInt = 152;
        }
      }
      else if (paramBoolean) {
        paramInt = 155;
      } else {
        paramInt = 151;
      }
      if (paramInt > 0) {
        d.a(577L, paramInt, 1L);
      }
    }
  }
  
  public static void b(long paramLong)
  {
    ab localab = d;
    if ((localab != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      localab.a(577, 577, 48, 49, 1, (int)paramLong);
    }
  }
  
  public static void b(long paramLong1, long paramLong2, long paramLong3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("report idkey id = ");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" key = ");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(" value = ");
    ((StringBuilder)localObject).append(paramLong3);
    Log.i("WXWebReporter", ((StringBuilder)localObject).toString());
    localObject = d;
    if (localObject != null) {
      ((ab)localObject).a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  public static void b(WebView.c paramc)
  {
    if (d == null) {
      return;
    }
    int i;
    if (paramc == WebView.c.b) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject;
    if (i != 0)
    {
      localObject = "REPORT_APK_VER_TIME";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("REPORT_APK_VER_TIME_");
      ((StringBuilder)localObject).append(paramc);
      localObject = ((StringBuilder)localObject).toString();
    }
    String str3 = new SimpleDateFormat("yyyyMMdd").format(new Date());
    String str2 = XWalkEnvironment.getSharedPreferences().getString((String)localObject, "");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    if (paramc == WebView.c.b)
    {
      i = XWalkEnvironment.getSharedPreferences().getInt("REPORT_XWEB_APK_VER", 0);
      int j = XWalkEnvironment.getAvailableVersion();
      if (j <= 0) {
        return;
      }
      if ((j != i) || (!str3.equals(str1)))
      {
        d.a(577L, j % 50 + 100, 1L);
        XWalkEnvironment.getSharedPreferences().edit().putInt("REPORT_XWEB_APK_VER", j).commit();
      }
    }
    if (str3.equals(str1)) {
      return;
    }
    if (paramc == WebView.c.b)
    {
      if (XWalkEnvironment.getAvailableVersion() <= 0) {
        return;
      }
      i = 99;
    }
    else if (paramc == WebView.c.d)
    {
      i = 97;
    }
    else
    {
      if (paramc != WebView.c.c) {
        return;
      }
      i = 98;
    }
    d.a(577L, i, 1L);
    XWalkEnvironment.getSharedPreferences().edit().putString((String)localObject, str3).commit();
  }
  
  public static void b(String paramString)
  {
    ab localab = d;
    if (localab != null)
    {
      localab.a(577L, 0L, 1L);
      if ((b.equals("toolsmp")) && (paramString != null) && (c(paramString) == 2)) {
        d.a(903L, 101L, 1L);
      }
      if (b.equals("toolsmp"))
      {
        if (WebView.getCurWebType() == WebView.c.b) {
          d.a(903L, 105L, 1L);
        } else if (WebView.getCurWebType() == WebView.c.c) {
          d.a(903L, 104L, 1L);
        }
      }
      else if ((b.equals("tools")) && (paramString != null) && (c(paramString) == 1)) {
        d.a(903L, 103L, 1L);
      }
      if (!f)
      {
        boolean bool = b.equals("tools");
        int i = 73;
        if (bool) {
          i = 70;
        } else if ((!b.equals("appbrand")) && (!b.equals("support"))) {
          i = -1;
        }
        int j = WebView.getCurWebType().ordinal() - 1;
        if ((i >= 70) && (j >= 0))
        {
          f = true;
          a(577, i + j);
        }
      }
    }
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    if (d == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 52;
    } else {
      i = 61;
    }
    if ("FullScreenVideo".equals(paramString))
    {
      d.a(577L, 186L, 1L);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      d.a(1068L, i, 1L);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      d.a(1071L, i, 1L);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      d.a(1069L, i, 1L);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      d.a(1070L, i, 1L);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      d.a(1544L, i, 1L);
    }
  }
  
  static boolean b()
  {
    return (c == WebView.c.b) && (WebView.getCurWebType() != c);
  }
  
  public static int c(String paramString)
  {
    if (paramString.startsWith("https://servicewechat.com/")) {
      return 0;
    }
    if ((!paramString.startsWith("http://mp.weixin.qq.com/")) && (!paramString.startsWith("https://mp.weixin.qq.com/")) && (!paramString.startsWith("https://servicewechat.com/preload/")) && (!paramString.startsWith("http://mp.weixinbridge.com/"))) {
      return 2;
    }
    return 1;
  }
  
  public static void c(long paramLong)
  {
    ab localab = d;
    if ((localab != null) && (localab != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      localab.a(577, 577, 11, 12, 1, (int)paramLong);
    }
  }
  
  public static void c(WebView.c paramc)
  {
    if (d == null) {
      return;
    }
    if (paramc == WebView.c.b)
    {
      d.a(577L, 61L, 1L);
      a(577, 62);
    }
  }
  
  public static void c(String paramString, boolean paramBoolean)
  {
    if (d == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 54;
    } else {
      i = 62;
    }
    if ("FullScreenVideo".equals(paramString))
    {
      d.a(577L, 187L, 1L);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      d.a(1068L, i, 1L);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      d.a(1071L, i, 1L);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      d.a(1069L, i, 1L);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      d.a(1070L, i, 1L);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      d.a(1544L, i, 1L);
    }
  }
  
  static boolean c()
  {
    return (WebView.getCurWebType() == WebView.c.b) && (WebView.getCurWebType() != c);
  }
  
  public static void d()
  {
    String str = XWalkEnvironment.getRuntimeAbi();
    if ("armeabi-v7a".equals(str)) {
      localObject = "arm64-v8a";
    } else {
      localObject = "armeabi-v7a";
    }
    int i = XWalkEnvironment.getInstalledNewstVersion(str);
    int j = XWalkEnvironment.getInstalledNewstVersion((String)localObject);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportCoreInstalled cur abi ver = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", predown ver = ");
    ((StringBuilder)localObject).append(j);
    Log.i("WXWebReporter", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(i);
    boolean bool = c.a("report_core_ver", ((StringBuilder)localObject).toString());
    if ((c.b("report_core_daily")) || (bool)) {
      if (i <= 0) {
        b(1367L, 251L, 1L);
      } else {
        b(1367L, i % 100 + 0, 1L);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(j);
    bool = c.a("report_core_ver_predown", ((StringBuilder)localObject).toString());
    if ((c.b("report_core_daily_predown")) || (bool)) {
      if (j <= 0) {
        b(1367L, 252L, 1L);
      } else {
        b(1367L, j % 100 + 100, 1L);
      }
    }
    if ("armeabi-v7a".equalsIgnoreCase(str))
    {
      localObject = XWalkEnvironment.getDeviceAbi();
      if ("armeabi-v7a".equalsIgnoreCase((String)localObject))
      {
        a(1367, 253);
        return;
      }
      if ("arm64-v8a".equalsIgnoreCase((String)localObject)) {
        a(1367, 254);
      }
    }
  }
  
  public static void d(long paramLong)
  {
    ab localab = d;
    if ((localab != null) && (localab != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      localab.a(577, 577, 22, 23, 1, (int)paramLong);
    }
  }
  
  public static void d(WebView.c paramc)
  {
    if (d == null) {
      return;
    }
    int i = h.1.a[paramc.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        i = 80;
      }
      else
      {
        i = 81;
      }
    }
    else {
      i = 82;
    }
    d.a(577L, i, 1L);
  }
  
  public static void d(String paramString)
  {
    if (d == null) {
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      d.a(1068L, 57L, 1L);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      d.a(1071L, 57L, 1L);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      d.a(1069L, 57L, 1L);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      d.a(1070L, 57L, 1L);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      d.a(1544L, 57L, 1L);
    }
  }
  
  public static void d(String paramString, boolean paramBoolean)
  {
    if (d == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 55;
    } else {
      i = 63;
    }
    if ("FullScreenVideo".equals(paramString))
    {
      d.a(577L, 188L, 1L);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      d.a(1068L, i, 1L);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      d.a(1071L, i, 1L);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      d.a(1069L, i, 1L);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      d.a(1070L, i, 1L);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      d.a(1544L, i, 1L);
    }
  }
  
  static int e()
  {
    if (b.equals("mm")) {
      return 30;
    }
    if (b.equals("tools")) {
      return 36;
    }
    if (b.equals("toolsmp")) {
      return 42;
    }
    if (b.equals("appbrand")) {
      return 48;
    }
    if (b.equals("support")) {
      return 54;
    }
    return -1;
  }
  
  public static void e(long paramLong)
  {
    ab localab = d;
    if ((localab != null) && (localab != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      localab.a(577, 577, 27, 28, 1, (int)paramLong);
    }
  }
  
  public static void e(WebView.c paramc)
  {
    if (d == null) {
      return;
    }
    int i = h.1.a[paramc.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        i = 84;
      }
      else
      {
        i = 85;
      }
    }
    else {
      i = 86;
    }
    d.a(577L, i, 1L);
  }
  
  public static void e(String paramString)
  {
    if (d == null) {
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      d.a(1068L, 66L, 1L);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      d.a(1071L, 66L, 1L);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      d.a(1069L, 66L, 1L);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      d.a(1070L, 66L, 1L);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      d.a(1544L, 66L, 1L);
    }
  }
  
  public static void e(String paramString, boolean paramBoolean)
  {
    if (d == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 59;
    } else {
      i = 65;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      d.a(1068L, i, 1L);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      d.a(1071L, i, 1L);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      d.a(1069L, i, 1L);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      d.a(1070L, i, 1L);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      d.a(1544L, i, 1L);
    }
  }
  
  public static void f()
  {
    boolean bool = b.equals("mm");
    int j = 75;
    int i = 0;
    if (bool)
    {
      i = 74;
      j = 79;
    }
    else if (b.equals("tools"))
    {
      i = 70;
    }
    else if (b.equals("toolsmp"))
    {
      i = 71;
    }
    else if (b.equals("appbrand"))
    {
      i = 72;
      j = 77;
    }
    else if (b.equals("support"))
    {
      i = 73;
      j = 78;
    }
    else
    {
      j = 0;
    }
    if (i != 0) {
      d.a(903L, i, 1L);
    }
    if (j != 0) {
      a(903, j);
    }
  }
  
  public static void f(long paramLong)
  {
    ab localab = d;
    if ((localab != null) && (localab != null) && (paramLong > 0L) && (paramLong < 120000L)) {
      localab.a(577, 577, 16, 17, 1, (int)paramLong);
    }
  }
  
  public static void f(String paramString, boolean paramBoolean)
  {
    int j = e.b(paramString).b();
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 100;
    }
    a(1511L, i + j % 100, 1L);
  }
  
  public static void g()
  {
    if (e) {
      return;
    }
    if ("toolsmp".equals(b)) {
      if (b()) {
        a(903, 106);
      } else if (c()) {
        a(903, 108);
      }
    }
    int i = e();
    int j = WebView.getCurWebType().ordinal() - 1;
    if ((i >= 30) && (j >= 0))
    {
      e = true;
      a(903, i + 3 + j);
    }
  }
  
  public static void h()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 1L, 1L);
    }
  }
  
  public static void i()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 46L, 1L);
    }
  }
  
  public static void j()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 47L, 1L);
    }
  }
  
  public static void k()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 52L, 1L);
    }
  }
  
  public static void l()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 53L, 1L);
    }
  }
  
  public static void m()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 54L, 1L);
    }
  }
  
  public static void n()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 55L, 1L);
    }
  }
  
  public static void o()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 56L, 1L);
    }
  }
  
  public static void p()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 57L, 1L);
    }
  }
  
  public static void q()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 58L, 1L);
    }
  }
  
  public static void r()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 59L, 1L);
    }
  }
  
  public static void s()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 167L, 1L);
    }
  }
  
  public static String t()
  {
    return UUID.randomUUID().toString().replace("-", "");
  }
  
  public static void u()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 9L, 1L);
    }
  }
  
  public static void v()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 10L, 1L);
    }
  }
  
  public static void w()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 60L, 1L);
    }
  }
  
  public static void x()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 20L, 1L);
    }
  }
  
  public static void y()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 21L, 1L);
    }
  }
  
  public static void z()
  {
    ab localab = d;
    if (localab != null) {
      localab.a(577L, 25L, 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.util.h
 * JD-Core Version:    0.7.0.1
 */