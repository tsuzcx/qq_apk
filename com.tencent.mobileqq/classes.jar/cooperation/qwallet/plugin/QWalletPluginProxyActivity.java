package cooperation.qwallet.plugin;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.DebugHelper;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class QWalletPluginProxyActivity
  extends PluginProxyActivity
  implements IActivity
{
  private static final String TAG = "QWalletPluginProxyActivity";
  protected static long mQWalletPLockBgIntervalTime = -1L;
  private long lastTipsTime;
  protected boolean mIsPause = false;
  protected boolean mIsStartTouchEvent = false;
  protected boolean mIsStop = false;
  protected long mQWalletPLockLastBgTime;
  public IPluginActivity mRealActivity;
  protected long mResumeStartTime = 0L;
  protected QWalletPluginProxyActivity.MyBroadcastReceiver myReceiver;
  protected QWalletPluginProxyActivity.TouchEventReceiver touchEventReceiver;
  protected QWalletPluginProxyActivity.TouchEventStartReceiver touchEventStartReceiver;
  
  public static void handleNoCatchCrash(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e0expr(TypeTransformer.java:441)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:710)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void initPatterLock()
  {
    for (;;)
    {
      try
      {
        Bundle localBundle = getIntent().getBundleExtra("pluginsdk_inner_intent_extras");
        if (localBundle == null) {
          break label187;
        }
        if (mQWalletPLockBgIntervalTime < 0L) {
          mQWalletPLockBgIntervalTime = localBundle.getLong("pluginsdk_is_QWallet_PLock_Bg_interval_time", -1L);
        }
        bool = localBundle.getBoolean("pluginsdk_is_Use_QWallet_PatternLock", false);
        if (!bool) {
          getIntent().getBooleanExtra("pluginsdk_is_Use_QWallet_PatternLock", false);
        }
        if (mQWalletPLockBgIntervalTime < 0L) {
          mQWalletPLockBgIntervalTime = getIntent().getLongExtra("pluginsdk_is_QWallet_PLock_Bg_interval_time", -1L);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (DebugHelper.sDebug) {
          DebugHelper.log("plugin_tag", "qwallet read data exception.", localOutOfMemoryError);
        }
        if (QLog.isColorLevel()) {
          QLog.e("initPatterLock", 2, "OutOfMemoryError");
        }
      }
      catch (Exception localException1)
      {
        if (DebugHelper.sDebug) {
          DebugHelper.log("plugin_tag", "qwallet read data exception.", localException1);
        }
      }
      try
      {
        this.myReceiver = new QWalletPluginProxyActivity.MyBroadcastReceiver(this, null);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("pluginsdk_QWallet_PatternLock_closeAll");
        registerReceiver(this.myReceiver, localIntentFilter);
        return;
      }
      catch (Exception localException2)
      {
        if (DebugHelper.sDebug) {
          DebugHelper.log("plugin_tag", "register exception.", localException2);
        }
        return;
      }
      label187:
      boolean bool = false;
    }
  }
  
  private boolean isStackLocked(ActivityManager paramActivityManager)
  {
    Class localClass = Class.forName("android.app.ActivityManager");
    int i = localClass.getDeclaredField("LOCK_TASK_MODE_NONE").getInt(ActivityManager.class);
    boolean bool2 = false;
    paramActivityManager = localClass.getDeclaredMethod("getLockTaskModeState", new Class[0]).invoke(paramActivityManager, new Object[0]);
    boolean bool1 = bool2;
    if (paramActivityManager != null)
    {
      bool1 = bool2;
      if ((paramActivityManager instanceof Integer))
      {
        bool1 = bool2;
        if (((Integer)paramActivityManager).intValue() != i) {
          bool1 = true;
        }
      }
    }
    return bool1;
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
  
  protected boolean enablePatternLock()
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
          QQToast.a(this, HardCodeUtil.a(R.string.bS), 0).a();
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
    Object localObject1 = this.mPluginActivity;
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    localObject1 = localObject2;
    if ((this.mPluginActivity instanceof BasePluginActivity))
    {
      BasePluginActivity localBasePluginActivity = (BasePluginActivity)this.mPluginActivity;
      localObject1 = localObject2;
      if (localBasePluginActivity.getIntent() != null) {
        localObject1 = localBasePluginActivity.getIntent().getExtras();
      }
    }
    return localObject1;
  }
  
  public String getPluginID()
  {
    return ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).getQWalletPluginId();
  }
  
  protected Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return QWalletPluginProxyActivity.class;
  }
  
  protected void handleCrash(Bundle paramBundle, Throwable paramThrowable)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e0expr(TypeTransformer.java:441)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:710)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected boolean isPatternLockOpened()
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
    return this.mIsPause ^ true;
  }
  
  protected boolean isWrapContent()
  {
    if (super.getIntent() != null) {
      return super.getIntent().getBooleanExtra("QWalletExtra.isFling", false);
    }
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate mLaunchActivity : ");
      paramBundle.append(this.mLaunchActivity);
      QLog.d("QWalletPluginProxyActivity", 2, paramBundle.toString());
    }
    initPatterLock();
    if (this.mPluginActivity != null)
    {
      this.mRealActivity = this.mPluginActivity;
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
  }
  
  protected void onDestroy()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy mLaunchActivity : ");
      localStringBuilder.append(this.mLaunchActivity);
      QLog.d("QWalletPluginProxyActivity", 2, localStringBuilder.toString());
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
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onPause()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause mLaunchActivity : ");
      localStringBuilder.append(this.mLaunchActivity);
      QLog.d("QWalletPluginProxyActivity", 2, localStringBuilder.toString());
    }
    this.mIsPause = true;
    super.onPause();
  }
  
  protected void onResume()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume mLaunchActivity : ");
      localStringBuilder.append(this.mLaunchActivity);
      QLog.d("QWalletPluginProxyActivity", 2, localStringBuilder.toString());
    }
    this.mIsPause = false;
    this.mResumeStartTime = System.currentTimeMillis();
    super.onResume();
  }
  
  protected void onStart()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStart mLaunchActivity : ");
      localStringBuilder.append(this.mLaunchActivity);
      QLog.d("QWalletPluginProxyActivity", 2, localStringBuilder.toString());
    }
    this.mIsStop = false;
    super.onStart();
  }
  
  protected void onStop()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStop mLaunchActivity : ");
      localStringBuilder.append(this.mLaunchActivity);
      QLog.d("QWalletPluginProxyActivity", 2, localStringBuilder.toString());
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
  
  protected void startUnlockActivity(boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */