package cooperation.qwallet.plugin;

import Override;
import amtj;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.proxy.BuscardLoadNFCProxyActivity;
import cooperation.qwallet.plugin.proxy.QWalletNFCProxyActivity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class QWalletPluginProxyActivity
  extends PluginProxyActivity
{
  public static final String ACTION_KEY_EVENT = "action_key_event";
  public static final String ACTION_QWALLET_PATTERN_LOCK_COLSEALL = "pluginsdk_QWallet_PatternLock_closeAll";
  public static final String ACTION_TOUCH_EVENT = "action_touch_event";
  public static final String ACTION_TOUCH_START = "action_touch_start";
  public static final String EXTRA_KEY_EVENT = "extra_key_event";
  public static final String PARAM_DISABLE_PATTERN_LOCK = "pluginsdk_disable_PatternLock";
  public static final String PARAM_IS_USE_QWALLET_PATTERN_LOCK = "pluginsdk_is_Use_QWallet_PatternLock";
  public static final String PARAM_QWALLET_PLOCK_BG_INTVERAL_TIME = "pluginsdk_is_QWallet_PLock_Bg_interval_time";
  private static final String TAG = "QWalletPluginProxyActivity";
  public static boolean mIsEnterPayBridge;
  protected static long mQWalletPLockBgIntervalTime = -1L;
  public static int sEnterQWalletPluginCount;
  public static long sReporteSeq;
  private long lastTipsTime;
  protected boolean mIsPause;
  protected boolean mIsStartTouchEvent;
  protected boolean mIsStop;
  protected long mQWalletPLockLastBgTime;
  public IPluginActivity mRealActivity;
  protected long mResumeStartTime;
  protected QWalletPluginProxyActivity.MyBroadcastReceiver myReceiver;
  protected QWalletPluginProxyActivity.TouchEventReceiver touchEventReceiver;
  protected QWalletPluginProxyActivity.TouchEventStartReceiver touchEventStartReceiver;
  
  public static void handleNoCatchCrash(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (sEnterQWalletPluginCount > 0)
      {
        sEnterQWalletPluginCount = 0;
        StringBuilder localStringBuilder = new StringBuilder().append("seq=").append(sReporteSeq).append("&from=");
        if (mIsEnterPayBridge) {
          i = 1;
        }
        VACDReportUtil.a(i, "qqwallet", "crash", "NoCatch", null, 668815, paramString);
      }
    } while (sReporteSeq <= 0L);
    VACDReportUtil.endReport(sReporteSeq, "crash", null, 668815, paramString);
    sReporteSeq = 0L;
  }
  
  /* Error */
  private void initPatterLock()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokevirtual 124	cooperation/qwallet/plugin/QWalletPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   6: ldc 126
    //   8: invokevirtual 132	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull +31 -> 44
    //   16: getstatic 59	cooperation/qwallet/plugin/QWalletPluginProxyActivity:mQWalletPLockBgIntervalTime	J
    //   19: lconst_0
    //   20: lcmp
    //   21: ifge +15 -> 36
    //   24: aload_2
    //   25: ldc 29
    //   27: ldc2_w 56
    //   30: invokevirtual 138	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   33: putstatic 59	cooperation/qwallet/plugin/QWalletPluginProxyActivity:mQWalletPLockBgIntervalTime	J
    //   36: aload_2
    //   37: ldc 26
    //   39: iconst_0
    //   40: invokevirtual 142	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   43: istore_1
    //   44: iload_1
    //   45: ifne +14 -> 59
    //   48: aload_0
    //   49: invokevirtual 124	cooperation/qwallet/plugin/QWalletPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   52: ldc 26
    //   54: iconst_0
    //   55: invokevirtual 145	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   58: pop
    //   59: getstatic 59	cooperation/qwallet/plugin/QWalletPluginProxyActivity:mQWalletPLockBgIntervalTime	J
    //   62: lconst_0
    //   63: lcmp
    //   64: ifge +18 -> 82
    //   67: aload_0
    //   68: invokevirtual 124	cooperation/qwallet/plugin/QWalletPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   71: ldc 29
    //   73: ldc2_w 56
    //   76: invokevirtual 148	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   79: putstatic 59	cooperation/qwallet/plugin/QWalletPluginProxyActivity:mQWalletPLockBgIntervalTime	J
    //   82: aload_0
    //   83: new 150	cooperation/qwallet/plugin/QWalletPluginProxyActivity$MyBroadcastReceiver
    //   86: dup
    //   87: aload_0
    //   88: aconst_null
    //   89: invokespecial 153	cooperation/qwallet/plugin/QWalletPluginProxyActivity$MyBroadcastReceiver:<init>	(Lcooperation/qwallet/plugin/QWalletPluginProxyActivity;Lcooperation/qwallet/plugin/QWalletPluginProxyActivity$1;)V
    //   92: putfield 155	cooperation/qwallet/plugin/QWalletPluginProxyActivity:myReceiver	Lcooperation/qwallet/plugin/QWalletPluginProxyActivity$MyBroadcastReceiver;
    //   95: new 157	android/content/IntentFilter
    //   98: dup
    //   99: invokespecial 158	android/content/IntentFilter:<init>	()V
    //   102: astore_2
    //   103: aload_2
    //   104: ldc 11
    //   106: invokevirtual 161	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 155	cooperation/qwallet/plugin/QWalletPluginProxyActivity:myReceiver	Lcooperation/qwallet/plugin/QWalletPluginProxyActivity$MyBroadcastReceiver;
    //   114: aload_2
    //   115: invokevirtual 165	cooperation/qwallet/plugin/QWalletPluginProxyActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   118: pop
    //   119: return
    //   120: astore_2
    //   121: getstatic 170	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   124: ifeq -42 -> 82
    //   127: ldc 172
    //   129: ldc 174
    //   131: aload_2
    //   132: invokestatic 178	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: goto -53 -> 82
    //   138: astore_2
    //   139: getstatic 170	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   142: ifeq +11 -> 153
    //   145: ldc 172
    //   147: ldc 174
    //   149: aload_2
    //   150: invokestatic 178	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -74 -> 82
    //   159: ldc 185
    //   161: iconst_2
    //   162: ldc 187
    //   164: invokestatic 191	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: goto -85 -> 82
    //   170: astore_2
    //   171: getstatic 170	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   174: ifeq -55 -> 119
    //   177: ldc 172
    //   179: ldc 193
    //   181: aload_2
    //   182: invokestatic 178	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   185: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	QWalletPluginProxyActivity
    //   1	44	1	bool	boolean
    //   11	104	2	localObject	Object
    //   120	12	2	localException1	Exception
    //   138	12	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   170	12	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	12	120	java/lang/Exception
    //   16	36	120	java/lang/Exception
    //   36	44	120	java/lang/Exception
    //   48	59	120	java/lang/Exception
    //   59	82	120	java/lang/Exception
    //   2	12	138	java/lang/OutOfMemoryError
    //   16	36	138	java/lang/OutOfMemoryError
    //   36	44	138	java/lang/OutOfMemoryError
    //   48	59	138	java/lang/OutOfMemoryError
    //   59	82	138	java/lang/OutOfMemoryError
    //   82	119	170	java/lang/Exception
  }
  
  private boolean isStackLocked(ActivityManager paramActivityManager)
  {
    Class localClass = Class.forName("android.app.ActivityManager");
    int i = localClass.getDeclaredField("LOCK_TASK_MODE_NONE").getInt(ActivityManager.class);
    paramActivityManager = localClass.getDeclaredMethod("getLockTaskModeState", new Class[0]).invoke(paramActivityManager, new Object[0]);
    if ((paramActivityManager != null) && ((paramActivityManager instanceof Integer))) {
      return ((Integer)paramActivityManager).intValue() != i;
    }
    return false;
  }
  
  protected static void openUrl(BasePluginActivity paramBasePluginActivity, String paramString)
  {
    try
    {
      paramBasePluginActivity.getClassLoader().loadClass("com.qwallet.activity.QvipPayFullWindowActivity").getMethod("openUrl", new Class[] { BasePluginActivity.class, String.class, Boolean.TYPE, Integer.TYPE, String.class }).invoke(null, new Object[] { paramBasePluginActivity, paramString, Boolean.valueOf(true), Integer.valueOf(0), "from_qwallet_success_page" });
      return;
    }
    catch (Exception paramBasePluginActivity)
    {
      paramBasePluginActivity.printStackTrace();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean enablePatternLock()
  {
    Bundle localBundle = getInnerBundle();
    if (localBundle != null)
    {
      if (localBundle.getBoolean("pluginsdk_disable_PatternLock", false)) {
        return false;
      }
      if (super.enablePatternLock()) {
        return true;
      }
      return localBundle.getBoolean("pluginsdk_is_Use_QWallet_PatternLock", false);
    }
    return super.enablePatternLock();
  }
  
  @TargetApi(21)
  public void finish()
  {
    if (this.mIsStartTouchEvent)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("cn.abel.action.broadcast");
      sendBroadcast(localIntent);
    }
    try
    {
      if ((Build.VERSION.SDK_INT >= 21) && (getPluginActivity() != null) && (getPluginActivity().contains("ConfirmTransactionActivity")) && (getInnerBundle() != null) && (getInnerBundle().containsKey("app_info")) && (getInnerBundle().getString("app_info").contains("thirdpartapp")) && (isStackLocked((ActivityManager)getSystemService("activity"))))
      {
        long l = System.currentTimeMillis();
        if (l - this.lastTipsTime > 3000L)
        {
          this.lastTipsTime = l;
          QQToast.a(this, amtj.a(2131710553), 0).a();
        }
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      super.finish();
    }
  }
  
  protected Bundle getInnerBundle()
  {
    if (this.mPluginActivity == null) {
      return null;
    }
    if ((this.mPluginActivity instanceof BasePluginActivity))
    {
      localObject = (BasePluginActivity)this.mPluginActivity;
      if (((BasePluginActivity)localObject).getIntent() == null) {}
    }
    for (Object localObject = ((BasePluginActivity)localObject).getIntent().getExtras();; localObject = null) {
      return localObject;
    }
  }
  
  public String getPluginID()
  {
    return "qwallet_plugin.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    if ("com.tenpay.android.qqplugin.activity.BusCardActivity".equals(paramString)) {
      return QWalletNFCProxyActivity.class;
    }
    if ("com.tenpay.android.qqplugin.activity.RedepositActivity".equals(paramString)) {
      return BuscardLoadNFCProxyActivity.class;
    }
    return QWalletPluginProxyActivity.class;
  }
  
  public void handleCrash(Bundle paramBundle, Throwable paramThrowable)
  {
    int j = 0;
    long l;
    if (paramBundle != null)
    {
      l = paramBundle.getLong("report_seq", 0L);
      if (l <= 0L)
      {
        paramBundle = paramBundle.getBundle("QWalletExtra.PayBridge.PayBundle");
        if (paramBundle != null) {
          l = paramBundle.getLong("vacreport_key_seq", 0L);
        }
      }
    }
    for (;;)
    {
      paramBundle = new StringBuilder(256);
      if (paramThrowable != null)
      {
        paramBundle.append(paramThrowable.toString());
        if (paramThrowable.getStackTrace() != null)
        {
          paramThrowable = paramThrowable.getStackTrace();
          i = 0;
          while ((i < paramThrowable.length) && (i < 16))
          {
            paramBundle.append("\n ");
            paramBundle.append(paramThrowable[i].toString());
            i += 1;
          }
        }
      }
      paramBundle = paramBundle.toString();
      paramThrowable = new StringBuilder().append("seq=").append(sReporteSeq).append("&from=");
      int i = j;
      if (mIsEnterPayBridge) {
        i = 1;
      }
      VACDReportUtil.a(i, "qqwallet", "crash", "Catch", null, 668814, paramBundle);
      VACDReportUtil.endReport(l, "crash", null, 668814, paramBundle);
      return;
      continue;
      l = 0L;
    }
  }
  
  public boolean isPatternLockOpened()
  {
    Bundle localBundle = getInnerBundle();
    if (localBundle != null)
    {
      if (localBundle.getBoolean("pluginsdk_disable_PatternLock", false)) {
        return false;
      }
      if (localBundle.getBoolean("pluginsdk_is_Use_QWallet_PatternLock", false)) {
        return true;
      }
    }
    return super.isPatternLockOpened();
  }
  
  public final boolean isResume()
  {
    return !this.mIsPause;
  }
  
  public boolean isWrapContent()
  {
    boolean bool = false;
    if (super.getIntent() != null) {
      bool = super.getIntent().getBooleanExtra("QWalletExtra.isFling", false);
    }
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletPluginProxyActivity", 2, "onCreate mLaunchActivity : " + this.mLaunchActivity);
    }
    initPatterLock();
    if (this.mPluginActivity != null) {
      this.mRealActivity = this.mPluginActivity;
    }
    try
    {
      this.touchEventStartReceiver = new QWalletPluginProxyActivity.TouchEventStartReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_touch_start");
      registerReceiver(this.touchEventStartReceiver, paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletPluginProxyActivity", 2, "onDestroy mLaunchActivity : " + this.mLaunchActivity);
    }
    super.onDestroy();
    try
    {
      if (this.touchEventReceiver != null)
      {
        unregisterReceiver(this.touchEventReceiver);
        this.touchEventReceiver = null;
      }
      if (this.myReceiver != null)
      {
        unregisterReceiver(this.myReceiver);
        this.myReceiver = null;
      }
      if (this.touchEventStartReceiver != null)
      {
        unregisterReceiver(this.touchEventStartReceiver);
        this.touchEventStartReceiver = null;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletPluginProxyActivity", 2, "onPause mLaunchActivity : " + this.mLaunchActivity);
    }
    this.mIsPause = true;
    super.onPause();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletPluginProxyActivity", 2, "onResume mLaunchActivity : " + this.mLaunchActivity);
    }
    this.mIsPause = false;
    this.mResumeStartTime = System.currentTimeMillis();
    super.onResume();
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletPluginProxyActivity", 2, "onStart mLaunchActivity : " + this.mLaunchActivity);
    }
    this.mIsStop = false;
    super.onStart();
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletPluginProxyActivity", 2, "onStop mLaunchActivity : " + this.mLaunchActivity);
    }
    this.mQWalletPLockLastBgTime = System.currentTimeMillis();
    this.mIsStop = true;
    super.onStop();
  }
  
  public void startQWalletUnlockActivity(boolean paramBoolean)
  {
    if ((paramBoolean) && (mQWalletPLockBgIntervalTime > 0L) && (System.currentTimeMillis() - this.mQWalletPLockLastBgTime < mQWalletPLockBgIntervalTime * 1000L)) {
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugintest", 2, "startQWalletUnlockActivity");
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("action_mode", 1);
      localIntent.putExtra("is_for_entrance", true);
      localIntent.putExtra("is_from_background", true);
      localIntent.putExtra("pluginsdk_disable_PatternLock", true);
      startPluginActivityForResult(this, "com.qwallet.activity.patternlock.PatternLockActivity", localIntent, 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void startUnlockActivity(boolean paramBoolean)
  {
    Bundle localBundle = getInnerBundle();
    if ((localBundle != null) && (localBundle.getBoolean("pluginsdk_is_Use_QWallet_PatternLock", false)))
    {
      startQWalletUnlockActivity(paramBoolean);
      return;
    }
    super.startUnlockActivity(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */