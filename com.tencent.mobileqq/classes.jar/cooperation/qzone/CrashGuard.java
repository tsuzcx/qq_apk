package cooperation.qzone;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.FileUtils;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class CrashGuard
{
  private static final int DEFAULT_CRASH_DURATION_AFTER_LAUNCH = 15;
  private static final int DEFAULT_CRASH_MAX_COUNT = 2;
  private static long appLaunchTime = 0L;
  private static int crashBetweenLaunch = -1;
  private Runnable clearTimestamp;
  private CrashGuard.CrashListener crashListener;
  AtomicBoolean isTimeOvered = new AtomicBoolean(false);
  private Handler mHandler;
  
  public static void clearFileCache(Context paramContext)
  {
    CacheManager.clearFileCache(paramContext);
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
    return CrashGuard.H.instance;
  }
  
  public void clearCache(BaseApplication paramBaseApplication, String paramString)
  {
    clearFileCache(paramBaseApplication);
    if (!TextUtils.isEmpty(paramString)) {
      paramBaseApplication.deleteDatabase(SecurityUtil.a(paramString));
    }
    paramString = new StringBuilder();
    paramString.append(paramBaseApplication.getFilesDir().getParent());
    paramString.append(File.separator);
    paramString.append("shared_prefs");
    paramBaseApplication = paramString.toString();
    if (!TextUtils.isEmpty(paramBaseApplication))
    {
      paramString = new StringBuilder();
      paramString.append(paramBaseApplication);
      paramString.append(File.separator);
      paramString.append("qz_predownload_config.xml");
      FileUtils.deleteFile(new File(paramString.toString()));
      paramString = new StringBuilder();
      paramString.append(paramBaseApplication);
      paramString.append(File.separator);
      paramString.append("QZ_Per_Config.xml");
      FileUtils.deleteFile(new File(paramString.toString()));
      paramString = new StringBuilder();
      paramString.append(paramBaseApplication);
      paramString.append(File.separator);
      paramString.append("QZONE_UNREAD.xml");
      FileUtils.deleteFile(new File(paramString.toString()));
    }
    paramBaseApplication = new StringBuilder();
    paramBaseApplication.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    paramBaseApplication.append(File.separator);
    paramBaseApplication.append("tencent");
    paramBaseApplication.append(File.separator);
    paramBaseApplication.append("MobileQQ");
    paramBaseApplication.append(File.separator);
    paramBaseApplication.append("trace");
    paramBaseApplication = VFSAssistantUtils.getSDKPrivatePath(paramBaseApplication.toString());
    if (paramBaseApplication != null) {
      FileUtils.deleteFile(new File(paramBaseApplication));
    }
  }
  
  public void onAppLaunch(long paramLong, Handler paramHandler, CrashGuard.CrashListener paramCrashListener)
  {
    appLaunchTime = System.currentTimeMillis();
    this.mHandler = paramHandler;
    this.crashListener = paramCrashListener;
    if (this.clearTimestamp == null) {
      this.clearTimestamp = new CrashGuard.1(this, paramLong);
    }
    if (crashBetweenLaunch < 0) {
      crashBetweenLaunch = getCrashDurationAfterLaunch();
    }
    this.mHandler.postDelayed(this.clearTimestamp, crashBetweenLaunch);
  }
  
  public void onException(Throwable paramThrowable, long paramLong)
  {
    Object localObject = this.crashListener;
    if (localObject != null) {
      ((CrashGuard.CrashListener)localObject).onCrashHandle(paramThrowable);
    }
    if (this.isTimeOvered.get()) {
      return;
    }
    paramThrowable = this.clearTimestamp;
    if (paramThrowable != null) {
      this.mHandler.removeCallbacks(paramThrowable);
    }
    int j = 0;
    int i = LocalMultiProcConfig.getInt4Uin("key_crash_count", 0, paramLong);
    if (crashBetweenLaunch < 0) {
      crashBetweenLaunch = getCrashDurationAfterLaunch();
    }
    if (System.currentTimeMillis() - appLaunchTime <= crashBetweenLaunch)
    {
      i += 1;
    }
    else
    {
      QLog.i("QZLog", 1, "clear crash count with overtime");
      i = 0;
    }
    paramThrowable = String.valueOf(paramLong);
    if (i >= getCrashMaxCount())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("crash in a row, clearCache ");
      ((StringBuilder)localObject).append(paramThrowable);
      QLog.i("QZLog", 1, ((StringBuilder)localObject).toString());
      clearCache(BaseApplication.getContext(), paramThrowable);
      i = j;
    }
    LocalMultiProcConfig.putInt4Uin("key_crash_count", i, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.CrashGuard
 * JD-Core Version:    0.7.0.1
 */