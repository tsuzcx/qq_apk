package cooperation.qzone;

import ambb;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import cooperation.qzone.util.FileUtils;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class CrashGuard
{
  private static final int DEFAULT_CRASH_DURATION_AFTER_LAUNCH = 15;
  private static final int DEFAULT_CRASH_MAX_COUNT = 2;
  private static long appLaunchTime;
  private static int crashBetweenLaunch = -1;
  private Runnable clearTimestamp;
  private CrashGuard.CrashListener crashListener;
  public AtomicBoolean isTimeOvered = new AtomicBoolean(false);
  private Handler mHandler;
  
  public static void clearFileCache(Context paramContext)
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "imageV2";
    if (str != null) {
      FileUtils.a(new File(str));
    }
    str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "video";
    if (str != null) {
      FileUtils.a(new File(str));
    }
    str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "paster";
    if (str != null) {
      FileUtils.a(new File(str));
    }
    FileUtils.a(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.mobileqq" + File.separator + "cache" + File.separator + "video_cache"));
    str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "file";
    if (str != null) {
      FileUtils.a(new File(str));
    }
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "qzone" + File.separator + "feeds";
    if (paramContext != null) {
      FileUtils.a(new File(paramContext));
    }
  }
  
  public static int getCrashDurationAfterLaunch()
  {
    return QzoneConfig.getInstance().getConfig("SafeModeSetting", "StartDuration", 15) * 1000;
  }
  
  public static int getCrashMaxCount()
  {
    return QzoneConfig.getInstance().getConfig("SafeModeSetting", "CrashMax", 2);
  }
  
  public static CrashGuard getInstance()
  {
    return CrashGuard.H.a;
  }
  
  public void clearCache(BaseApplication paramBaseApplication, String paramString)
  {
    clearFileCache(paramBaseApplication);
    if (!TextUtils.isEmpty(paramString)) {
      paramBaseApplication.deleteDatabase(SecurityUtil.a(paramString));
    }
    paramBaseApplication = paramBaseApplication.getFilesDir().getParent() + File.separator + "shared_prefs";
    if (!TextUtils.isEmpty(paramBaseApplication))
    {
      FileUtils.a(new File(paramBaseApplication + File.separator + "qz_predownload_config.xml"));
      FileUtils.a(new File(paramBaseApplication + File.separator + "QZ_Per_Config.xml"));
      FileUtils.a(new File(paramBaseApplication + File.separator + "QZONE_UNREAD.xml"));
    }
    paramBaseApplication = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "MobileQQ" + File.separator + "trace";
    if (paramBaseApplication != null) {
      FileUtils.a(new File(paramBaseApplication));
    }
  }
  
  public void onAppLaunch(long paramLong, Handler paramHandler, CrashGuard.CrashListener paramCrashListener)
  {
    appLaunchTime = System.currentTimeMillis();
    this.mHandler = paramHandler;
    this.crashListener = paramCrashListener;
    if (this.clearTimestamp == null) {
      this.clearTimestamp = new ambb(this, paramLong);
    }
    if (crashBetweenLaunch < 0) {
      crashBetweenLaunch = getCrashDurationAfterLaunch();
    }
    this.mHandler.postDelayed(this.clearTimestamp, crashBetweenLaunch);
  }
  
  public void onException(Throwable paramThrowable, long paramLong)
  {
    int j = 0;
    if (this.crashListener != null) {
      this.crashListener.a(paramThrowable);
    }
    if (this.isTimeOvered.get()) {
      return;
    }
    if (this.clearTimestamp != null) {
      this.mHandler.removeCallbacks(this.clearTimestamp);
    }
    int i = LocalMultiProcConfig.getInt4Uin("key_crash_count", 0, paramLong);
    if (crashBetweenLaunch < 0) {
      crashBetweenLaunch = getCrashDurationAfterLaunch();
    }
    if (System.currentTimeMillis() - appLaunchTime <= crashBetweenLaunch)
    {
      i += 1;
      paramThrowable = String.valueOf(paramLong);
      if (i < getCrashMaxCount()) {
        break label164;
      }
      QLog.i("QZLog", 1, "crash in a row, clearCache " + paramThrowable);
      clearCache(BaseApplication.getContext(), paramThrowable);
      i = j;
    }
    label164:
    for (;;)
    {
      LocalMultiProcConfig.putInt4Uin("key_crash_count", i, paramLong);
      return;
      QLog.i("QZLog", 1, "clear crash count with overtime");
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qzone.CrashGuard
 * JD-Core Version:    0.7.0.1
 */