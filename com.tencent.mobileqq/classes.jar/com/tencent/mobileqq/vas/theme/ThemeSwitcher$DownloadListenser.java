package com.tencent.mobileqq.vas.theme;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateCallback;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ThemeSwitcher$DownloadListenser
  implements Runnable
{
  private final long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile long b;
  
  public ThemeSwitcher$DownloadListenser(ThemeSwitcher paramThemeSwitcher, boolean paramBoolean)
  {
    long l;
    if (paramBoolean) {
      l = 5000L;
    } else {
      l = 180000L;
    }
    this.jdField_a_of_type_Long = l;
    if (paramBoolean) {
      paramThemeSwitcher = "update_timeout";
    } else {
      paramThemeSwitcher = "download_timeout";
    }
    this.jdField_a_of_type_JavaLangString = paramThemeSwitcher;
    this.b = (SystemClock.uptimeMillis() + this.jdField_a_of_type_Long);
    a();
  }
  
  private void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt != 2) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.this$0.a = null;
      if (TextUtils.isEmpty(paramString2))
      {
        if (TextUtils.isEmpty(ThemeSwitcher.a(this.this$0).d()))
        {
          ThemeSwitcher.a(this.this$0, paramInt, false);
          return;
        }
        QLog.e("ThemeSwitcher", 1, "download err, but local exists");
        ThemeSwitcher.a(this.this$0);
        return;
      }
      ThemeSwitcher.a(this.this$0).a(paramAppRuntime.getApp(), paramString1, paramString2);
      ThemeSwitcher.a(this.this$0);
    }
  }
  
  private boolean a()
  {
    long l = SystemClock.uptimeMillis();
    if (l > this.b) {
      return true;
    }
    ThreadManager.getSubThreadHandler().postDelayed(this, this.b + 10L - l);
    return false;
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (this.this$0.a() == null) {
      return;
    }
    String str = ThemeUtil.getIDFromSCID(paramString);
    if (ThemeSwitcher.a(this.this$0).a().equals(str))
    {
      this.b = (SystemClock.uptimeMillis() + this.jdField_a_of_type_Long);
      if ((paramString.startsWith(ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX)) && (ThemeSwitcher.a(this.this$0) != null)) {
        ThemeSwitcher.a(this.this$0).onProgress(paramLong1, paramLong2);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    AppRuntime localAppRuntime = this.this$0.a();
    if (localAppRuntime == null) {
      return;
    }
    String str = ThemeUtil.getIDFromSCID(paramString1);
    if (ThemeSwitcher.a(this.this$0).a().equals(str))
    {
      this.b = (SystemClock.uptimeMillis() + this.jdField_a_of_type_Long);
      if (paramInt != 0)
      {
        a(localAppRuntime, null, null, 1);
        return;
      }
      if (paramString1.startsWith(ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX))
      {
        a(localAppRuntime, paramString1, paramString2, 0);
        ThemeReporter.a(null, "theme_detail", ThemeSwitcher.a(this.this$0), 153, 1, 35, str, "20000000", ThemeReporter.jdField_a_of_type_JavaLangString, "");
      }
    }
  }
  
  public void run()
  {
    if (a())
    {
      AppRuntime localAppRuntime = this.this$0.a();
      if (localAppRuntime == null) {
        return;
      }
      QLog.e("ThemeSwitcher", 1, "downloadTheme timeout");
      HashMap localHashMap = new HashMap();
      localHashMap.put("reportKey", this.jdField_a_of_type_JavaLangString);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "individual_v2_theme_download_fail", false, 0L, -1L, localHashMap, "", true);
      a(localAppRuntime, null, null, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.ThemeSwitcher.DownloadListenser
 * JD-Core Version:    0.7.0.1
 */