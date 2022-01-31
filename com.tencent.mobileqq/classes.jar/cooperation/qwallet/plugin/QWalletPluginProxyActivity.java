package cooperation.qwallet.plugin;

import alpo;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
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
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore 5
    //   8: iload_2
    //   9: istore_3
    //   10: iload 4
    //   12: istore_1
    //   13: aload_0
    //   14: invokevirtual 124	cooperation/qwallet/plugin/QWalletPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   17: ldc 126
    //   19: invokevirtual 132	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   22: astore 6
    //   24: iload 5
    //   26: istore_1
    //   27: aload 6
    //   29: ifnull +50 -> 79
    //   32: iload_2
    //   33: istore_3
    //   34: iload 4
    //   36: istore_1
    //   37: getstatic 59	cooperation/qwallet/plugin/QWalletPluginProxyActivity:mQWalletPLockBgIntervalTime	J
    //   40: lconst_0
    //   41: lcmp
    //   42: ifge +21 -> 63
    //   45: iload_2
    //   46: istore_3
    //   47: iload 4
    //   49: istore_1
    //   50: aload 6
    //   52: ldc 29
    //   54: ldc2_w 56
    //   57: invokevirtual 138	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   60: putstatic 59	cooperation/qwallet/plugin/QWalletPluginProxyActivity:mQWalletPLockBgIntervalTime	J
    //   63: iload_2
    //   64: istore_3
    //   65: iload 4
    //   67: istore_1
    //   68: aload 6
    //   70: ldc 26
    //   72: iconst_0
    //   73: invokevirtual 142	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   76: istore_2
    //   77: iload_2
    //   78: istore_1
    //   79: iload_1
    //   80: istore_2
    //   81: iload_1
    //   82: ifne +16 -> 98
    //   85: iload_1
    //   86: istore_3
    //   87: aload_0
    //   88: invokevirtual 124	cooperation/qwallet/plugin/QWalletPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   91: ldc 26
    //   93: iconst_0
    //   94: invokevirtual 145	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   97: istore_2
    //   98: iload_2
    //   99: istore 4
    //   101: iload_2
    //   102: istore_3
    //   103: iload_2
    //   104: istore_1
    //   105: getstatic 59	cooperation/qwallet/plugin/QWalletPluginProxyActivity:mQWalletPLockBgIntervalTime	J
    //   108: lconst_0
    //   109: lcmp
    //   110: ifge +25 -> 135
    //   113: iload_2
    //   114: istore_3
    //   115: iload_2
    //   116: istore_1
    //   117: aload_0
    //   118: invokevirtual 124	cooperation/qwallet/plugin/QWalletPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   121: ldc 29
    //   123: ldc2_w 56
    //   126: invokevirtual 148	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   129: putstatic 59	cooperation/qwallet/plugin/QWalletPluginProxyActivity:mQWalletPLockBgIntervalTime	J
    //   132: iload_2
    //   133: istore 4
    //   135: iload 4
    //   137: ifeq +43 -> 180
    //   140: aload_0
    //   141: new 150	cooperation/qwallet/plugin/QWalletPluginProxyActivity$MyBroadcastReceiver
    //   144: dup
    //   145: aload_0
    //   146: aconst_null
    //   147: invokespecial 153	cooperation/qwallet/plugin/QWalletPluginProxyActivity$MyBroadcastReceiver:<init>	(Lcooperation/qwallet/plugin/QWalletPluginProxyActivity;Lcooperation/qwallet/plugin/QWalletPluginProxyActivity$1;)V
    //   150: putfield 155	cooperation/qwallet/plugin/QWalletPluginProxyActivity:myReceiver	Lcooperation/qwallet/plugin/QWalletPluginProxyActivity$MyBroadcastReceiver;
    //   153: new 157	android/content/IntentFilter
    //   156: dup
    //   157: invokespecial 158	android/content/IntentFilter:<init>	()V
    //   160: astore 6
    //   162: aload 6
    //   164: ldc 11
    //   166: invokevirtual 161	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   169: aload_0
    //   170: aload_0
    //   171: getfield 155	cooperation/qwallet/plugin/QWalletPluginProxyActivity:myReceiver	Lcooperation/qwallet/plugin/QWalletPluginProxyActivity$MyBroadcastReceiver;
    //   174: aload 6
    //   176: invokevirtual 165	cooperation/qwallet/plugin/QWalletPluginProxyActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   179: pop
    //   180: return
    //   181: astore 6
    //   183: iload_3
    //   184: istore 4
    //   186: getstatic 170	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   189: ifeq -54 -> 135
    //   192: ldc 172
    //   194: ldc 174
    //   196: aload 6
    //   198: invokestatic 178	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: iload_3
    //   202: istore 4
    //   204: goto -69 -> 135
    //   207: astore 6
    //   209: getstatic 170	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   212: ifeq +12 -> 224
    //   215: ldc 172
    //   217: ldc 174
    //   219: aload 6
    //   221: invokestatic 178	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: iload_1
    //   225: istore 4
    //   227: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq -95 -> 135
    //   233: ldc 185
    //   235: iconst_2
    //   236: ldc 187
    //   238: invokestatic 191	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: iload_1
    //   242: istore 4
    //   244: goto -109 -> 135
    //   247: astore 6
    //   249: getstatic 170	com/tencent/mobileqq/pluginsdk/DebugHelper:sDebug	Z
    //   252: ifeq -72 -> 180
    //   255: ldc 172
    //   257: ldc 193
    //   259: aload 6
    //   261: invokestatic 178	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   264: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	QWalletPluginProxyActivity
    //   12	230	1	bool1	boolean
    //   1	132	2	bool2	boolean
    //   9	193	3	bool3	boolean
    //   3	240	4	bool4	boolean
    //   6	19	5	bool5	boolean
    //   22	153	6	localObject	Object
    //   181	16	6	localException1	Exception
    //   207	13	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   247	13	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   13	24	181	java/lang/Exception
    //   37	45	181	java/lang/Exception
    //   50	63	181	java/lang/Exception
    //   68	77	181	java/lang/Exception
    //   87	98	181	java/lang/Exception
    //   105	113	181	java/lang/Exception
    //   117	132	181	java/lang/Exception
    //   13	24	207	java/lang/OutOfMemoryError
    //   37	45	207	java/lang/OutOfMemoryError
    //   50	63	207	java/lang/OutOfMemoryError
    //   68	77	207	java/lang/OutOfMemoryError
    //   87	98	207	java/lang/OutOfMemoryError
    //   105	113	207	java/lang/OutOfMemoryError
    //   117	132	207	java/lang/OutOfMemoryError
    //   140	180	247	java/lang/Exception
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
          QQToast.a(this, alpo.a(2131711821), 0).a();
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
  
  public boolean isWrapContent()
  {
    boolean bool = false;
    if (super.getIntent() != null) {
      bool = super.getIntent().getBooleanExtra("QWalletExtra.isFling", false);
    }
    return bool;
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
    if ((paramBoolean) && (mQWalletPLockBgIntervalTime > 0L))
    {
      long l = System.currentTimeMillis();
      if (this.mQWalletPLockLastBgTime + mQWalletPLockBgIntervalTime > l) {
        return;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */