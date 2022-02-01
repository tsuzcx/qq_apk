package com.tencent.mobileqq.confess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

public class ConfessConfig
{
  private static File I = new File(BaseApplicationImpl.getApplication().getFilesDir(), "confess_talk");
  public static final String a = HardCodeUtil.a(2131900570);
  public static final String b = HardCodeUtil.a(2131900568);
  public static final String c = HardCodeUtil.a(2131900573);
  public static final String d = HardCodeUtil.a(2131900574);
  public static final String e = HardCodeUtil.a(2131900569);
  public static final String f = HardCodeUtil.a(2131900571);
  public static final String g = HardCodeUtil.a(2131900576);
  public static final String h = HardCodeUtil.a(2131900572);
  public int A;
  public String B;
  public int C = 24;
  public String D;
  public int E;
  public long F;
  public int G;
  boolean H = false;
  private long J;
  private int K;
  private String L;
  private long M;
  private boolean N;
  private String O;
  private long P;
  private final Random Q;
  private int R;
  private Object S = new Object();
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public float o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public int y;
  public int z;
  
  public ConfessConfig(String paramString)
  {
    this.L = paramString;
    paramString = SharedPreUtils.a(this.L, "confess_config_sp");
    this.Q = new Random(SystemClock.elapsedRealtime());
    this.J = paramString.getLong("lLastVanishTime", 0L);
    this.K = paramString.getInt("nContinuousVanishCount", 0);
    a(null, true);
    ThreadManager.postImmediately(new ConfessConfig.1(this), null, true);
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    int i1 = localCalendar1.get(6);
    int i4 = localCalendar1.get(1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    int i3 = localCalendar2.get(6);
    int i2 = localCalendar1.get(1);
    i1 -= i3;
    i3 = i1;
    if (i2 != i4) {
      for (;;)
      {
        i3 = i1;
        if (i2 >= i4) {
          break;
        }
        if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
          i1 += 366;
        } else {
          i1 += 365;
        }
        i2 += 1;
      }
    }
    return i3;
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      paramAppInterface = ((ConfessManager)paramAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).d();
      if (paramAppInterface == null) {
        paramAppInterface = "https://ti.qq.com/honest-say/holmes.html?_nav_alpha=0&_wwv=4&_qStyle=1";
      } else {
        paramAppInterface = paramAppInterface.D;
      }
      if (!TextUtils.isEmpty(paramAppInterface))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAppInterface);
        localStringBuilder.append("&fromUin=");
        localStringBuilder.append(NearbyURLSafeUtil.b(paramString1));
        paramAppInterface = localStringBuilder.toString();
        paramString1 = new StringBuilder();
        paramString1.append(paramAppInterface);
        paramString1.append("&toUin=");
        paramString1.append(NearbyURLSafeUtil.b(paramString2));
        paramAppInterface = paramString1.toString();
        paramString1 = new StringBuilder();
        paramString1.append(paramAppInterface);
        paramString1.append("&topicId=");
        paramString1.append(paramInt);
        paramString1 = paramString1.toString();
        if (paramBoolean) {
          paramAppInterface = "1";
        } else {
          paramAppInterface = "0";
        }
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append("&isConfessor=");
        paramString2.append(paramAppInterface);
        paramAppInterface = paramString2.toString();
        paramString1 = new Intent(paramContext, QQBrowserActivity.class);
        paramString1.putExtra("hide_more_button", true);
        paramString1.putExtra("hide_operation_bar", true);
        paramString1.putExtra("url", paramAppInterface);
        paramContext.startActivity(paramString1);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, String.format("saveRedPointShow key:%s value:%d", new Object[] { paramString, Long.valueOf(paramLong) }));
    }
    SharedPreUtils.a(paramQQAppInterface.getAccount(), "confess_config_sp").edit().putLong(paramString, paramLong).apply();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    this.N = false;
    this.M = 0L;
    this.P = 0L;
    this.O = "";
    this.R = 0;
    this.z = 1;
    this.A = 0;
    this.B = "";
    this.C = 24;
    this.E = 5;
    this.G = 0;
    if (TextUtils.isEmpty(paramString))
    {
      this.i = 0;
      this.j = 0;
      this.k = 0;
      this.l = 0;
      this.m = 0;
      this.n = 0;
      this.o = 5.0F;
    }
    else
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("min")) {
          this.j = localJSONObject.getInt("min");
        }
        if (localJSONObject.has("max")) {
          this.k = localJSONObject.getInt("max");
        }
        if (localJSONObject.has("delta")) {
          this.l = localJSONObject.getInt("delta");
        }
        if (localJSONObject.has("X")) {
          this.m = localJSONObject.getInt("X");
        }
        if (localJSONObject.has("Y")) {
          this.n = localJSONObject.getInt("Y");
        }
        if (localJSONObject.has("contactEntryUrl")) {
          this.s = localJSONObject.getString("contactEntryUrl");
        }
        if (localJSONObject.has("boxEntryUrl")) {
          this.r = localJSONObject.getString("boxEntryUrl");
        }
        if (localJSONObject.has("title")) {
          this.p = localJSONObject.getString("title");
        }
        if (localJSONObject.has("subtitle")) {
          this.q = localJSONObject.getString("subtitle");
        }
        if (localJSONObject.has("changeInterval")) {
          this.o = ((float)localJSONObject.getDouble("changeInterval"));
        }
        if (localJSONObject.has("frdRecUrl")) {
          this.t = localJSONObject.getString("frdRecUrl");
        }
        if (localJSONObject.has("frdRecMsgSwitch")) {
          this.R = localJSONObject.getInt("frdRecMsgSwitch");
        }
        if (localJSONObject.has("detailUrl")) {
          this.u = localJSONObject.getString("detailUrl");
        }
        if (localJSONObject.has("settingUrl")) {
          this.w = localJSONObject.getString("settingUrl");
        }
        if (localJSONObject.has("entryBoxSwitch")) {
          this.z = localJSONObject.getInt("entryBoxSwitch");
        }
        if (localJSONObject.has("entryContactSwitch")) {
          this.A = localJSONObject.getInt("entryContactSwitch");
        }
        if (localJSONObject.has("redPointText")) {
          this.B = localJSONObject.getString("redPointText");
        }
        if (localJSONObject.has("blockTime")) {
          this.C = localJSONObject.getInt("blockTime");
        }
        if (localJSONObject.has("groupCfsListUrl")) {
          this.v = localJSONObject.getString("groupCfsListUrl");
        }
        if (localJSONObject.has("rankingSwitch")) {
          this.y = localJSONObject.getInt("rankingSwitch");
        }
        if (localJSONObject.has("rankingUrl")) {
          this.x = localJSONObject.getString("rankingUrl");
        }
        if (localJSONObject.has("holmesCount")) {
          this.E = localJSONObject.optInt("holmesCount", 5);
        }
        if (localJSONObject.has("holmesUrl")) {
          this.D = localJSONObject.optString("holmesUrl");
        }
        if (localJSONObject.has("holmesSwitch")) {
          this.G = localJSONObject.optInt("holmesSwitch", 0);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    if (TextUtils.isEmpty(this.s)) {
      this.s = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=contact_tab";
    }
    if (TextUtils.isEmpty(this.r)) {
      this.r = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
    }
    if (TextUtils.isEmpty(this.p)) {
      this.p = a;
    }
    if (TextUtils.isEmpty(this.q)) {
      this.q = b;
    }
    if (TextUtils.isEmpty(this.t)) {
      this.t = "https://ti.qq.com/honest-say/friends-received.html?_bid=3104&_wv=9191&_qStyle=1&adtag=message_box";
    }
    if (TextUtils.isEmpty(this.u)) {
      this.u = "https://ti.qq.com/honest-say/confess-detail.html?_bid=3104&_wv=9191&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&ADTAG=aio_card";
    }
    if (TextUtils.isEmpty(this.w)) {
      this.w = "https://ti.qq.com/honest-say/setting.html?_wv=9191&_wwv=4&_qStyle=1&adtag=message_box";
    }
    if (TextUtils.isEmpty(this.B)) {
      this.B = c;
    }
    if (TextUtils.isEmpty(this.v)) {
      this.v = "https://ti.qq.com/honest-say/group-received.html?_bid=3104&_wv=9191&_qStyle=1";
    }
    if (TextUtils.isEmpty(this.x)) {
      this.x = "https://ti.qq.com/honest-say/rank.html?_wv=9191&_wwv=4&_qStyle=1";
    }
    if (TextUtils.isEmpty(this.D)) {
      this.D = "https://ti.qq.com/honest-say/holmes.html?_nav_alpha=0&_wwv=4&_qStyle=1";
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!paramBoolean)
    {
      this.F = MessageCache.c();
      a((QQAppInterface)localObject, "rec_config_time", this.F);
    }
    else
    {
      this.F = b((QQAppInterface)localObject, "rec_config_time");
    }
    if (QLog.isDevelopLevel())
    {
      Locale localLocale = Locale.getDefault();
      if (paramBoolean) {
        localObject = "local";
      } else {
        localObject = "server";
      }
      QLog.i("ConfessConfig", 4, String.format(localLocale, "parse %s config: %s", new Object[] { localObject, paramString }));
    }
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return false;
    }
    return ((ConfessManager)paramAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).d().d();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    if (paramQQAppInterface == null) {
      return false;
    }
    if (SharedPreUtils.a(paramQQAppInterface.getAccount(), "confess_config_sp").getLong(paramString, 0L) > 0L) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return SharedPreUtils.a(paramQQAppInterface.getAccount(), "confess_config_sp").edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static long b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return SharedPreUtils.a(paramQQAppInterface.getAccount(), "confess_config_sp").getLong(paramString, 0L);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateHolmesTipsNeedShow key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" value:");
      localStringBuilder.append(paramBoolean);
      QLog.i("ConfessConfig", 2, localStringBuilder.toString());
    }
    paramQQAppInterface = SharedPreUtils.a(paramQQAppInterface.getAccount(), "confess_config_sp").edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("holmes_tips_show_");
    localStringBuilder.append(paramString);
    return paramQQAppInterface.putBoolean(localStringBuilder.toString(), paramBoolean).commit();
  }
  
  public static boolean b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveConfig2File config is: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("ConfessConfig", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(I.getPath());
    ((StringBuilder)localObject).append(File.separator);
    String str = ((StringBuilder)localObject).toString();
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    boolean bool = FileUtils.writeFile(str, "confess_talk.cfg", (String)localObject);
    paramString = new StringBuilder();
    paramString.append("saveConfig2File result : ");
    paramString.append(bool);
    QLog.i("ConfessConfig", 1, paramString.toString());
    return bool;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return SharedPreUtils.a(paramQQAppInterface.getAccount(), "confess_config_sp").getBoolean(paramString, false);
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = SharedPreUtils.a(paramQQAppInterface.getAccount(), "confess_config_sp");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("holmes_tips_show_");
    localStringBuilder.append(paramString);
    return paramQQAppInterface.getBoolean(localStringBuilder.toString(), false);
  }
  
  private String f()
  {
    StringBuilder localStringBuilder;
    String str2;
    try
    {
      String str1 = FileUtils.readFileToString(new File(I, "confess_talk.cfg"));
    }
    catch (IOException localIOException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfigFromFile exception : ");
      localStringBuilder.append(QLog.getStackTraceString(localIOException));
      QLog.i("ConfessConfig", 1, localStringBuilder.toString());
      str2 = "";
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfigFromFile config is: ");
      localStringBuilder.append(str2);
      QLog.i("ConfessConfig", 2, localStringBuilder.toString());
    }
    return str2;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    String str;
    if (a(paramQQAppInterface, "redpoint_leba_show"))
    {
      str = this.B;
      paramQQAppInterface = str;
      if (str == null) {
        return c;
      }
    }
    else
    {
      str = this.p;
      paramQQAppInterface = str;
      if (str == null) {
        paramQQAppInterface = a;
      }
    }
    return paramQQAppInterface;
  }
  
  public void a()
  {
    if (this.H) {
      return;
    }
    String str = f();
    synchronized (this.S)
    {
      if (!this.H)
      {
        a(str, true);
        this.H = true;
      }
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onGetConfigFromServer config :");
      ((StringBuilder)???).append(paramString);
      QLog.i("ConfessConfig", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.S)
    {
      a(paramString, false);
      return b(paramString);
    }
  }
  
  public String b()
  {
    long l1 = SystemClock.elapsedRealtime();
    if ((!TextUtils.isEmpty(this.O)) && (Math.abs(l1 - this.P) < (this.o * 60000.0F))) {
      return this.O;
    }
    if (TextUtils.isEmpty(this.q))
    {
      this.O = "";
    }
    else if (!this.q.contains("N"))
    {
      this.O = this.q;
    }
    else
    {
      int i1 = this.k;
      if ((i1 > 0) && (i1 > this.j))
      {
        i1 = this.Q.nextInt(i1);
        int i2 = this.k;
        int i3 = this.j;
        this.P = l1;
        NumberFormat localNumberFormat = NumberFormat.getNumberInstance();
        this.O = this.q.replace("N", localNumberFormat.format(i1 % (i2 - i3 + 1) + i3));
      }
      else
      {
        this.O = "";
      }
    }
    return this.O;
  }
  
  public boolean c()
  {
    long l1 = SystemClock.elapsedRealtime();
    if (Math.abs(l1 - this.M) < 60000L) {
      return this.N;
    }
    if (this.A >= 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (TextUtils.isEmpty(this.s)) {
        bool2 = false;
      }
    }
    boolean bool1 = bool2;
    if (bool2) {
      if (a(NetConnInfoCenter.getServerTimeMillis(), this.J) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (this.K >= this.m) {
        if (a(NetConnInfoCenter.getServerTimeMillis(), this.J) > this.n) {
          bool2 = true;
        } else {
          bool2 = false;
        }
      }
    }
    this.M = l1;
    this.N = bool2;
    return bool2;
  }
  
  public boolean d()
  {
    return this.G == 1;
  }
  
  public boolean e()
  {
    return this.R == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(140);
    localStringBuilder.append("HonestSayConfig{");
    localStringBuilder.append("nSwitch: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", frdRecMsgSwitch: ");
    localStringBuilder.append(this.R);
    localStringBuilder.append(", nMin: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", nMax: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", nDelta: ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", nX: ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", nY: ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", fChangeInterval: ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", title: ");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", subtitle: ");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", contactEntryUrl: ");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", boxEntryUrl: ");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", detailUrl: ");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", settingUrl: ");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", lLastVanishTime: ");
    localStringBuilder.append(this.J);
    localStringBuilder.append(", nContinuousVanishCount: ");
    localStringBuilder.append(this.K);
    localStringBuilder.append(", rankingUrl: ");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", rankSwitch: ");
    localStringBuilder.append(this.y);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessConfig
 * JD-Core Version:    0.7.0.1
 */