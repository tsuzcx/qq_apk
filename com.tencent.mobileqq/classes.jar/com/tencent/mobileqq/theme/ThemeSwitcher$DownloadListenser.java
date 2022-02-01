package com.tencent.mobileqq.theme;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateCallback;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

class ThemeSwitcher$DownloadListenser
  implements Runnable
{
  private final long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile long b;
  
  public ThemeSwitcher$DownloadListenser(ThemeSwitcher paramThemeSwitcher, boolean paramBoolean)
  {
    long l;
    if (paramBoolean)
    {
      l = 5000L;
      this.jdField_a_of_type_Long = l;
      if (!paramBoolean) {
        break label71;
      }
    }
    label71:
    for (paramThemeSwitcher = "update_timeout";; paramThemeSwitcher = "download_timeout")
    {
      this.jdField_a_of_type_JavaLangString = paramThemeSwitcher;
      this.b = (SystemClock.uptimeMillis() + this.jdField_a_of_type_Long);
      a();
      return;
      l = 180000L;
      break;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt != 2) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      ThemeSwitcher.a(this.this$0, null);
      if (!TextUtils.isEmpty(paramString2)) {
        break label84;
      }
      if (TextUtils.isEmpty(ThemeSwitcher.a(this.this$0).d())) {
        ThemeSwitcher.a(this.this$0, paramInt, false);
      }
    }
    else
    {
      return;
    }
    QLog.e("ThemeSwitcher", 1, "download err, but local exists");
    ThemeSwitcher.a(this.this$0);
    return;
    label84:
    ThemeSwitcher.a(this.this$0).a(paramQQAppInterface.getApp(), paramString1, paramString2);
    ThemeSwitcher.a(this.this$0);
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
    if (this.this$0.a() == null) {}
    do
    {
      String str;
      do
      {
        return;
        str = ThemeUtil.getIDFromSCID(paramString);
      } while (!ThemeSwitcher.a(this.this$0).a().equals(str));
      this.b = (SystemClock.uptimeMillis() + this.jdField_a_of_type_Long);
    } while ((!paramString.startsWith(ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX)) || (ThemeSwitcher.a(this.this$0) == null));
    ThemeSwitcher.a(this.this$0).onProgress(paramLong1, paramLong2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.this$0.a();
    if (localQQAppInterface == null) {}
    String str;
    do
    {
      do
      {
        return;
        str = ThemeUtil.getIDFromSCID(paramString1);
      } while (!ThemeSwitcher.a(this.this$0).a().equals(str));
      this.b = (SystemClock.uptimeMillis() + this.jdField_a_of_type_Long);
      if (paramInt != 0)
      {
        a(localQQAppInterface, null, null, 1);
        return;
      }
    } while (!paramString1.startsWith(ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX));
    a(localQQAppInterface, paramString1, paramString2, 0);
    ThemeReporter.a(null, "theme_detail", ThemeSwitcher.a(this.this$0), 153, 1, 35, str, "20000000", ThemeReporter.jdField_a_of_type_JavaLangString, "");
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface;
    if (a())
    {
      localQQAppInterface = this.this$0.a();
      if (localQQAppInterface != null) {}
    }
    else
    {
      return;
    }
    QLog.e("ThemeSwitcher", 1, "downloadTheme timeout");
    VasMonitorHandler.a(null, "individual_v2_theme_download_fail", this.jdField_a_of_type_JavaLangString, this.this$0.toString(), ThemeSwitcher.a(this.this$0).a(), ThemeSwitcher.a(this.this$0), "", 0.0F, 0.0F);
    HashMap localHashMap = new HashMap();
    localHashMap.put("reportKey", this.jdField_a_of_type_JavaLangString);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "individual_v2_theme_download_fail", false, 0L, -1L, localHashMap, "", true);
    a(localQQAppInterface, null, null, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitcher.DownloadListenser
 * JD-Core Version:    0.7.0.1
 */