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
  private static File jdField_a_of_type_JavaIoFile = new File(BaseApplicationImpl.getApplication().getFilesDir(), "confess_talk");
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f;
  public static final String g;
  public static final String h;
  public float a;
  public int a;
  public long a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final Random jdField_a_of_type_JavaUtilRandom;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private long c;
  public int d;
  private long d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  private int m;
  public String m;
  private int n;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  private String t;
  private String u;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131702577);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131702575);
    jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131702580);
    jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131702581);
    jdField_e_of_type_JavaLangString = HardCodeUtil.a(2131702576);
    jdField_f_of_type_JavaLangString = HardCodeUtil.a(2131702578);
    jdField_g_of_type_JavaLangString = HardCodeUtil.a(2131702583);
    jdField_h_of_type_JavaLangString = HardCodeUtil.a(2131702579);
  }
  
  public ConfessConfig(String paramString)
  {
    this.jdField_j_of_type_Int = 24;
    this.t = paramString;
    paramString = SharedPreUtils.a(this.t, "confess_config_sp");
    this.jdField_a_of_type_JavaUtilRandom = new Random(SystemClock.elapsedRealtime());
    this.jdField_b_of_type_Long = paramString.getLong("lLastVanishTime", 0L);
    this.jdField_m_of_type_Int = paramString.getInt("nContinuousVanishCount", 0);
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
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return SharedPreUtils.a(paramQQAppInterface.getAccount(), "confess_config_sp").getLong(paramString, 0L);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      paramAppInterface = ((ConfessManager)paramAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
      if (paramAppInterface == null) {
        paramAppInterface = "https://ti.qq.com/honest-say/holmes.html?_nav_alpha=0&_wwv=4&_qStyle=1";
      } else {
        paramAppInterface = paramAppInterface.s;
      }
      if (!TextUtils.isEmpty(paramAppInterface))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAppInterface);
        localStringBuilder.append("&fromUin=");
        localStringBuilder.append(NearbyURLSafeUtil.a(paramString1));
        paramAppInterface = localStringBuilder.toString();
        paramString1 = new StringBuilder();
        paramString1.append(paramAppInterface);
        paramString1.append("&toUin=");
        paramString1.append(NearbyURLSafeUtil.a(paramString2));
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
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.u = "";
    this.jdField_n_of_type_Int = 0;
    this.jdField_h_of_type_Int = 1;
    this.jdField_i_of_type_Int = 0;
    this.r = "";
    this.jdField_j_of_type_Int = 24;
    this.jdField_k_of_type_Int = 5;
    this.jdField_l_of_type_Int = 0;
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      this.jdField_d_of_type_Int = 0;
      this.jdField_e_of_type_Int = 0;
      this.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_Float = 5.0F;
    }
    else
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("min")) {
          this.jdField_b_of_type_Int = localJSONObject.getInt("min");
        }
        if (localJSONObject.has("max")) {
          this.jdField_c_of_type_Int = localJSONObject.getInt("max");
        }
        if (localJSONObject.has("delta")) {
          this.jdField_d_of_type_Int = localJSONObject.getInt("delta");
        }
        if (localJSONObject.has("X")) {
          this.jdField_e_of_type_Int = localJSONObject.getInt("X");
        }
        if (localJSONObject.has("Y")) {
          this.jdField_f_of_type_Int = localJSONObject.getInt("Y");
        }
        if (localJSONObject.has("contactEntryUrl")) {
          this.jdField_l_of_type_JavaLangString = localJSONObject.getString("contactEntryUrl");
        }
        if (localJSONObject.has("boxEntryUrl")) {
          this.jdField_k_of_type_JavaLangString = localJSONObject.getString("boxEntryUrl");
        }
        if (localJSONObject.has("title")) {
          this.jdField_i_of_type_JavaLangString = localJSONObject.getString("title");
        }
        if (localJSONObject.has("subtitle")) {
          this.jdField_j_of_type_JavaLangString = localJSONObject.getString("subtitle");
        }
        if (localJSONObject.has("changeInterval")) {
          this.jdField_a_of_type_Float = ((float)localJSONObject.getDouble("changeInterval"));
        }
        if (localJSONObject.has("frdRecUrl")) {
          this.jdField_m_of_type_JavaLangString = localJSONObject.getString("frdRecUrl");
        }
        if (localJSONObject.has("frdRecMsgSwitch")) {
          this.jdField_n_of_type_Int = localJSONObject.getInt("frdRecMsgSwitch");
        }
        if (localJSONObject.has("detailUrl")) {
          this.jdField_n_of_type_JavaLangString = localJSONObject.getString("detailUrl");
        }
        if (localJSONObject.has("settingUrl")) {
          this.p = localJSONObject.getString("settingUrl");
        }
        if (localJSONObject.has("entryBoxSwitch")) {
          this.jdField_h_of_type_Int = localJSONObject.getInt("entryBoxSwitch");
        }
        if (localJSONObject.has("entryContactSwitch")) {
          this.jdField_i_of_type_Int = localJSONObject.getInt("entryContactSwitch");
        }
        if (localJSONObject.has("redPointText")) {
          this.r = localJSONObject.getString("redPointText");
        }
        if (localJSONObject.has("blockTime")) {
          this.jdField_j_of_type_Int = localJSONObject.getInt("blockTime");
        }
        if (localJSONObject.has("groupCfsListUrl")) {
          this.o = localJSONObject.getString("groupCfsListUrl");
        }
        if (localJSONObject.has("rankingSwitch")) {
          this.jdField_g_of_type_Int = localJSONObject.getInt("rankingSwitch");
        }
        if (localJSONObject.has("rankingUrl")) {
          this.q = localJSONObject.getString("rankingUrl");
        }
        if (localJSONObject.has("holmesCount")) {
          this.jdField_k_of_type_Int = localJSONObject.optInt("holmesCount", 5);
        }
        if (localJSONObject.has("holmesUrl")) {
          this.s = localJSONObject.optString("holmesUrl");
        }
        if (localJSONObject.has("holmesSwitch")) {
          this.jdField_l_of_type_Int = localJSONObject.optInt("holmesSwitch", 0);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    if (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
      this.jdField_l_of_type_JavaLangString = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=contact_tab";
    }
    if (TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
      this.jdField_k_of_type_JavaLangString = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
    }
    if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
      this.jdField_i_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
    }
    if (TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
      this.jdField_j_of_type_JavaLangString = jdField_b_of_type_JavaLangString;
    }
    if (TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) {
      this.jdField_m_of_type_JavaLangString = "https://ti.qq.com/honest-say/friends-received.html?_bid=3104&_wv=9191&_qStyle=1&adtag=message_box";
    }
    if (TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString)) {
      this.jdField_n_of_type_JavaLangString = "https://ti.qq.com/honest-say/confess-detail.html?_bid=3104&_wv=9191&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&ADTAG=aio_card";
    }
    if (TextUtils.isEmpty(this.p)) {
      this.p = "https://ti.qq.com/honest-say/setting.html?_wv=9191&_wwv=4&_qStyle=1&adtag=message_box";
    }
    if (TextUtils.isEmpty(this.r)) {
      this.r = jdField_c_of_type_JavaLangString;
    }
    if (TextUtils.isEmpty(this.o)) {
      this.o = "https://ti.qq.com/honest-say/group-received.html?_bid=3104&_wv=9191&_qStyle=1";
    }
    if (TextUtils.isEmpty(this.q)) {
      this.q = "https://ti.qq.com/honest-say/rank.html?_wv=9191&_wwv=4&_qStyle=1";
    }
    if (TextUtils.isEmpty(this.s)) {
      this.s = "https://ti.qq.com/honest-say/holmes.html?_nav_alpha=0&_wwv=4&_qStyle=1";
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Long = MessageCache.a();
      a((QQAppInterface)localObject, "rec_config_time", this.jdField_a_of_type_Long);
    }
    else
    {
      this.jdField_a_of_type_Long = a((QQAppInterface)localObject, "rec_config_time");
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
    return ((ConfessManager)paramAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b().b();
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
  
  private String b()
  {
    StringBuilder localStringBuilder;
    String str2;
    try
    {
      String str1 = FileUtils.readFileToString(new File(jdField_a_of_type_JavaIoFile, "confess_talk.cfg"));
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
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return SharedPreUtils.a(paramQQAppInterface.getAccount(), "confess_config_sp").getBoolean(paramString, false);
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
    ((StringBuilder)localObject).append(jdField_a_of_type_JavaIoFile.getPath());
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
    paramQQAppInterface = SharedPreUtils.a(paramQQAppInterface.getAccount(), "confess_config_sp");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("holmes_tips_show_");
    localStringBuilder.append(paramString);
    return paramQQAppInterface.getBoolean(localStringBuilder.toString(), false);
  }
  
  public String a()
  {
    long l1 = SystemClock.elapsedRealtime();
    if ((!TextUtils.isEmpty(this.u)) && (Math.abs(l1 - this.jdField_d_of_type_Long) < (this.jdField_a_of_type_Float * 60000.0F))) {
      return this.u;
    }
    if (TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))
    {
      this.u = "";
    }
    else if (!this.jdField_j_of_type_JavaLangString.contains("N"))
    {
      this.u = this.jdField_j_of_type_JavaLangString;
    }
    else
    {
      int i1 = this.jdField_c_of_type_Int;
      if ((i1 > 0) && (i1 > this.jdField_b_of_type_Int))
      {
        i1 = this.jdField_a_of_type_JavaUtilRandom.nextInt(i1);
        int i2 = this.jdField_c_of_type_Int;
        int i3 = this.jdField_b_of_type_Int;
        this.jdField_d_of_type_Long = l1;
        NumberFormat localNumberFormat = NumberFormat.getNumberInstance();
        this.u = this.jdField_j_of_type_JavaLangString.replace("N", localNumberFormat.format(i1 % (i2 - i3 + 1) + i3));
      }
      else
      {
        this.u = "";
      }
    }
    return this.u;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    String str;
    if (a(paramQQAppInterface, "redpoint_leba_show"))
    {
      str = this.r;
      paramQQAppInterface = str;
      if (str == null) {
        return jdField_c_of_type_JavaLangString;
      }
    }
    else
    {
      str = this.jdField_i_of_type_JavaLangString;
      paramQQAppInterface = str;
      if (str == null) {
        paramQQAppInterface = jdField_a_of_type_JavaLangString;
      }
    }
    return paramQQAppInterface;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    String str = b();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        a(str, true);
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
  }
  
  public boolean a()
  {
    long l1 = SystemClock.elapsedRealtime();
    if (Math.abs(l1 - this.jdField_c_of_type_Long) < 60000L) {
      return this.jdField_b_of_type_Boolean;
    }
    if (this.jdField_i_of_type_Int >= 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
        bool2 = false;
      }
    }
    boolean bool1 = bool2;
    if (bool2) {
      if (a(NetConnInfoCenter.getServerTimeMillis(), this.jdField_b_of_type_Long) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (this.jdField_m_of_type_Int >= this.jdField_e_of_type_Int) {
        if (a(NetConnInfoCenter.getServerTimeMillis(), this.jdField_b_of_type_Long) > this.jdField_f_of_type_Int) {
          bool2 = true;
        } else {
          bool2 = false;
        }
      }
    }
    this.jdField_c_of_type_Long = l1;
    this.jdField_b_of_type_Boolean = bool2;
    return bool2;
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
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      a(paramString, false);
      return b(paramString);
    }
  }
  
  public boolean b()
  {
    return this.jdField_l_of_type_Int == 1;
  }
  
  public boolean c()
  {
    return this.jdField_n_of_type_Int == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(140);
    localStringBuilder.append("HonestSayConfig{");
    localStringBuilder.append("nSwitch: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", frdRecMsgSwitch: ");
    localStringBuilder.append(this.jdField_n_of_type_Int);
    localStringBuilder.append(", nMin: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", nMax: ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", nDelta: ");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", nX: ");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", nY: ");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", fChangeInterval: ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", title: ");
    localStringBuilder.append(this.jdField_i_of_type_JavaLangString);
    localStringBuilder.append(", subtitle: ");
    localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
    localStringBuilder.append(", contactEntryUrl: ");
    localStringBuilder.append(this.jdField_l_of_type_JavaLangString);
    localStringBuilder.append(", boxEntryUrl: ");
    localStringBuilder.append(this.jdField_k_of_type_JavaLangString);
    localStringBuilder.append(", detailUrl: ");
    localStringBuilder.append(this.jdField_n_of_type_JavaLangString);
    localStringBuilder.append(", settingUrl: ");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", lLastVanishTime: ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", nContinuousVanishCount: ");
    localStringBuilder.append(this.jdField_m_of_type_Int);
    localStringBuilder.append(", rankingUrl: ");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", rankSwitch: ");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessConfig
 * JD-Core Version:    0.7.0.1
 */