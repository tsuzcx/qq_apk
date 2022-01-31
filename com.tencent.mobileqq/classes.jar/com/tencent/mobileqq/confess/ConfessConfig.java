package com.tencent.mobileqq.confess;

import abyr;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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
  public float a;
  public int a;
  public long a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private final Random jdField_a_of_type_JavaUtilRandom;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  private long jdField_b_of_type_Long;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private long c;
  public String c;
  public int d;
  private long d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  private int jdField_j_of_type_Int;
  private String jdField_j_of_type_JavaLangString;
  private int jdField_k_of_type_Int;
  private String jdField_k_of_type_JavaLangString;
  
  public ConfessConfig(String paramString)
  {
    this.jdField_i_of_type_Int = 24;
    this.jdField_j_of_type_JavaLangString = paramString;
    paramString = SharedPreUtils.a(this.jdField_j_of_type_JavaLangString, "confess_config_sp");
    this.jdField_a_of_type_JavaUtilRandom = new Random(SystemClock.elapsedRealtime());
    this.jdField_b_of_type_Long = paramString.getLong("lLastVanishTime", 0L);
    this.jdField_j_of_type_Int = paramString.getInt("nContinuousVanishCount", 0);
    a(null, true);
    ThreadManager.postImmediately(new abyr(this), null, true);
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    int m = localCalendar1.get(6);
    int i2 = localCalendar1.get(1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    int i1 = localCalendar2.get(6);
    int n = localCalendar1.get(1);
    m -= i1;
    i1 = m;
    if (n != i2)
    {
      i1 = m;
      if (n < i2)
      {
        if (((n % 4 == 0) && (n % 100 != 0)) || (n % 400 == 0)) {
          m += 366;
        }
        for (;;)
        {
          n += 1;
          break;
          m += 365;
        }
      }
    }
    return i1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return SharedPreUtils.a(paramQQAppInterface.getAccount(), "confess_config_sp").getLong(paramString, 0L);
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
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_k_of_type_Int = 0;
    this.jdField_g_of_type_Int = 1;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_i_of_type_Int = 24;
    label267:
    Locale localLocale;
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      this.jdField_d_of_type_Int = 0;
      this.jdField_e_of_type_Int = 0;
      this.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_Float = 5.0F;
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        this.jdField_d_of_type_JavaLangString = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=contact_tab";
      }
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = "每一个好友都有闪光点。";
      }
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = "最近真的很流行玩这个，快快加入吧。";
      }
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = "https://ti.qq.com/honest-say/friends-received.html?_bid=3104&_wv=9191&_qStyle=1&adtag=message_box";
      }
      if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        this.jdField_f_of_type_JavaLangString = "https://ti.qq.com/honest-say/confess-detail.html?_bid=3104&_wv=9191&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&ADTAG=aio_card";
      }
      if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
        this.jdField_h_of_type_JavaLangString = "https://ti.qq.com/honest-say/setting.html?_wv=9191&_wwv=4&_qStyle=1&adtag=message_box";
      }
      if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
        this.jdField_i_of_type_JavaLangString = "题库更新啦！快来抢先体验吧！";
      }
      if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
        this.jdField_g_of_type_JavaLangString = "https://ti.qq.com/honest-say/group-received.html?_bid=3104&_wv=9191&_qStyle=1";
      }
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramBoolean) {
        break label733;
      }
      this.jdField_a_of_type_Long = MessageCache.a();
      a((QQAppInterface)localObject, "rec_config_time", this.jdField_a_of_type_Long);
      if (QLog.isDevelopLevel())
      {
        localLocale = Locale.getDefault();
        if (!paramBoolean) {
          break label747;
        }
      }
    }
    label733:
    label747:
    String str;
    for (Object localObject = "local";; str = "server")
    {
      for (;;)
      {
        QLog.i("ConfessConfig", 4, String.format(localLocale, "parse %s config: %s", new Object[] { localObject, paramString }));
        return;
        try
        {
          localObject = new JSONObject(paramString);
          if (((JSONObject)localObject).has("min")) {
            this.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("min");
          }
          if (((JSONObject)localObject).has("max")) {
            this.jdField_c_of_type_Int = ((JSONObject)localObject).getInt("max");
          }
          if (((JSONObject)localObject).has("delta")) {
            this.jdField_d_of_type_Int = ((JSONObject)localObject).getInt("delta");
          }
          if (((JSONObject)localObject).has("X")) {
            this.jdField_e_of_type_Int = ((JSONObject)localObject).getInt("X");
          }
          if (((JSONObject)localObject).has("Y")) {
            this.jdField_f_of_type_Int = ((JSONObject)localObject).getInt("Y");
          }
          if (((JSONObject)localObject).has("contactEntryUrl")) {
            this.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).getString("contactEntryUrl");
          }
          if (((JSONObject)localObject).has("boxEntryUrl")) {
            this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).getString("boxEntryUrl");
          }
          if (((JSONObject)localObject).has("title")) {
            this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("title");
          }
          if (((JSONObject)localObject).has("subtitle")) {
            this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("subtitle");
          }
          if (((JSONObject)localObject).has("changeInterval")) {
            this.jdField_a_of_type_Float = ((float)((JSONObject)localObject).getDouble("changeInterval"));
          }
          if (((JSONObject)localObject).has("frdRecUrl")) {
            this.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).getString("frdRecUrl");
          }
          if (((JSONObject)localObject).has("frdRecMsgSwitch")) {
            this.jdField_k_of_type_Int = ((JSONObject)localObject).getInt("frdRecMsgSwitch");
          }
          if (((JSONObject)localObject).has("detailUrl")) {
            this.jdField_f_of_type_JavaLangString = ((JSONObject)localObject).getString("detailUrl");
          }
          if (((JSONObject)localObject).has("settingUrl")) {
            this.jdField_h_of_type_JavaLangString = ((JSONObject)localObject).getString("settingUrl");
          }
          if (((JSONObject)localObject).has("entryBoxSwitch")) {
            this.jdField_g_of_type_Int = ((JSONObject)localObject).getInt("entryBoxSwitch");
          }
          if (((JSONObject)localObject).has("entryContactSwitch")) {
            this.jdField_h_of_type_Int = ((JSONObject)localObject).getInt("entryContactSwitch");
          }
          if (((JSONObject)localObject).has("redPointText")) {
            this.jdField_i_of_type_JavaLangString = ((JSONObject)localObject).getString("redPointText");
          }
          if (((JSONObject)localObject).has("blockTime")) {
            this.jdField_i_of_type_Int = ((JSONObject)localObject).getInt("blockTime");
          }
          if (!((JSONObject)localObject).has("groupCfsListUrl")) {
            break;
          }
          this.jdField_g_of_type_JavaLangString = ((JSONObject)localObject).getString("groupCfsListUrl");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      break;
      this.jdField_a_of_type_Long = a(localException, "rec_config_time");
      break label267;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    while (SharedPreUtils.a(paramQQAppInterface.getAccount(), "confess_config_sp").getLong(paramString, 0L) <= 0L) {
      return false;
    }
    return true;
  }
  
  private String b()
  {
    Object localObject = "";
    try
    {
      String str = FileUtils.b(new File(jdField_a_of_type_JavaIoFile, "confess_talk.cfg"));
      localObject = str;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.i("ConfessConfig", 1, "getConfigFromFile exception : " + QLog.getStackTraceString(localIOException));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, "getConfigFromFile config is: " + (String)localObject);
    }
    return localObject;
  }
  
  public static boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, "saveConfig2File config is: " + paramString);
    }
    String str2 = jdField_a_of_type_JavaIoFile.getPath() + File.separator;
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    boolean bool = FileUtils.a(str2, "confess_talk.cfg", str1);
    QLog.i("ConfessConfig", 1, "saveConfig2File result : " + bool);
    return bool;
  }
  
  public String a()
  {
    long l = SystemClock.elapsedRealtime();
    if ((!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) && (Math.abs(l - this.jdField_d_of_type_Long) < (this.jdField_a_of_type_Float * 60000.0F))) {
      return this.jdField_k_of_type_JavaLangString;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_k_of_type_JavaLangString = "";
    }
    for (;;)
    {
      return this.jdField_k_of_type_JavaLangString;
      if (!this.jdField_b_of_type_JavaLangString.contains("N"))
      {
        this.jdField_k_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      else if ((this.jdField_c_of_type_Int > 0) && (this.jdField_c_of_type_Int > this.jdField_b_of_type_Int))
      {
        int m = this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_c_of_type_Int);
        int n = this.jdField_c_of_type_Int;
        int i1 = this.jdField_b_of_type_Int;
        int i2 = this.jdField_b_of_type_Int;
        this.jdField_d_of_type_Long = l;
        NumberFormat localNumberFormat = NumberFormat.getNumberInstance();
        this.jdField_k_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace("N", localNumberFormat.format(m % (n - i1 + 1) + i2));
      }
      else
      {
        this.jdField_k_of_type_JavaLangString = "";
      }
    }
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (a(paramQQAppInterface, "redpoint_contact_show"))
    {
      if (this.jdField_i_of_type_JavaLangString == null) {
        return "题库更新啦！快来抢先体验吧！";
      }
      return this.jdField_i_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_JavaLangString == null) {
      return "每一个好友都有闪光点。";
    }
    return this.jdField_a_of_type_JavaLangString;
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
    boolean bool3 = true;
    long l = SystemClock.elapsedRealtime();
    if (Math.abs(l - this.jdField_c_of_type_Long) < 60000L) {
      return this.jdField_b_of_type_Boolean;
    }
    boolean bool1;
    if (this.jdField_h_of_type_Int >= 1)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          bool2 = false;
        }
      }
      bool1 = bool2;
      if (bool2)
      {
        if (a(NetConnInfoCenter.getServerTimeMillis(), this.jdField_b_of_type_Long) == 0) {
          break label132;
        }
        bool1 = true;
      }
      label80:
      if ((!bool1) || (this.jdField_j_of_type_Int < this.jdField_e_of_type_Int)) {
        break label142;
      }
      if (a(NetConnInfoCenter.getServerTimeMillis(), this.jdField_b_of_type_Long) <= this.jdField_f_of_type_Int) {
        break label137;
      }
      bool1 = bool3;
    }
    label132:
    label137:
    label142:
    for (;;)
    {
      this.jdField_c_of_type_Long = l;
      this.jdField_b_of_type_Boolean = bool1;
      return bool1;
      bool1 = false;
      break;
      bool1 = false;
      break label80;
      bool1 = false;
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, "onGetConfigFromServer config :" + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      a(paramString, false);
      return b(paramString);
    }
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = SharedPreUtils.a(this.jdField_j_of_type_JavaLangString, "confess_config_sp");
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    long l = NetConnInfoCenter.getServerTimeMillis();
    int m = a(l, this.jdField_b_of_type_Long);
    if (m != 1) {
      this.jdField_j_of_type_Int = 0;
    }
    this.jdField_b_of_type_Long = l;
    this.jdField_j_of_type_Int += 1;
    localSharedPreferences.edit().putLong("lLastVanishTime", this.jdField_b_of_type_Long).putInt("nContinuousVanishCount", this.jdField_j_of_type_Int).apply();
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, String.format(Locale.getDefault(), "onVanish dif: %s, time: %s  count: %s", new Object[] { Integer.valueOf(m), Long.valueOf(this.jdField_b_of_type_Long), Integer.valueOf(this.jdField_j_of_type_Int) }));
    }
    ConfessMsgUtil.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public boolean b()
  {
    return this.jdField_k_of_type_Int == 1;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, "onGetContactRedPoint");
    }
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_j_of_type_Int = 0;
    SharedPreUtils.a(this.jdField_j_of_type_JavaLangString, "confess_config_sp").edit().putLong("lLastVanishTime", this.jdField_b_of_type_Long).putInt("nContinuousVanishCount", this.jdField_j_of_type_Int);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(140);
    localStringBuilder.append("HonestSayConfig{").append("nSwitch: ").append(this.jdField_a_of_type_Int).append(", frdRecMsgSwitch: ").append(this.jdField_k_of_type_Int).append(", nMin: ").append(this.jdField_b_of_type_Int).append(", nMax: ").append(this.jdField_c_of_type_Int).append(", nDelta: ").append(this.jdField_d_of_type_Int).append(", nX: ").append(this.jdField_e_of_type_Int).append(", nY: ").append(this.jdField_f_of_type_Int).append(", fChangeInterval: ").append(this.jdField_a_of_type_Float).append(", title: ").append(this.jdField_a_of_type_JavaLangString).append(", subtitle: ").append(this.jdField_b_of_type_JavaLangString).append(", contactEntryUrl: ").append(this.jdField_d_of_type_JavaLangString).append(", boxEntryUrl: ").append(this.jdField_c_of_type_JavaLangString).append(", detailUrl: ").append(this.jdField_f_of_type_JavaLangString).append(", settingUrl: ").append(this.jdField_h_of_type_JavaLangString).append(", lLastVanishTime: ").append(this.jdField_b_of_type_Long).append(", nContinuousVanishCount: ").append(this.jdField_j_of_type_Int).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessConfig
 * JD-Core Version:    0.7.0.1
 */