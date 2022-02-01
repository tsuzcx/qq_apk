package mqq.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.util.AndroidOUIWrapperUtil;
import mqq.util.WeakReference;

@TargetApi(16)
public class AppActivity
  extends Activity
{
  public static Locale locale;
  public static int localeId;
  public static IActivityDispatchCallback sActivityDispatchCallback;
  private boolean mIsFinishingInOnCreate;
  private boolean mIsResultWaiting;
  protected boolean mIsResume;
  private boolean mIsSplashing;
  private boolean mIsStartSkipped;
  private Intent mNewIntent;
  private Bundle mOnCreateBundle;
  private Bundle mOnRestoreBundle;
  private SparseArray<List> mPermissionCallerMap = new SparseArray();
  private Bundle mPostCreateBundle;
  private AppRuntime mProRuntime;
  private int mRequestCode;
  private int mResultCode;
  private Intent mResultData;
  protected AppRuntime mRuntime;
  private int mWindowFocusState = -1;
  
  private boolean isActivityLocaleUpdated(Locale paramLocale)
  {
    if ((locale == null) || (paramLocale == null)) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = locale.getLanguage().equals(paramLocale.getLanguage());
      bool2 = locale.getCountry().equals(paramLocale.getCountry());
    } while ((bool1) && (bool2));
    return true;
  }
  
  private boolean isLocaleCN()
  {
    return localeId == 2052;
  }
  
  public static void setActivityDispatchCallback(IActivityDispatchCallback paramIActivityDispatchCallback)
  {
    sActivityDispatchCallback = paramIActivityDispatchCallback;
  }
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 2);
    return super.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public int checkSelfPermission(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return super.checkSelfPermission(paramString);
    }
    return 0;
  }
  
  @Deprecated
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (this.mIsSplashing) {
      return false;
    }
    return doDispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (sActivityDispatchCallback != null) {
      sActivityDispatchCallback.disaptchTouchEventCallback(this, paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  protected boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void doOnBackPressed()
  {
    try
    {
      super.onBackPressed();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("qqBaseActivity", 2, "", localThrowable);
    }
  }
  
  protected void doOnConfigurationChanged(Configuration paramConfiguration) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    MobileQQ.sMobileQQ.appActivities.add(new WeakReference(this));
    this.mOnCreateBundle = null;
    setAppRuntime(MobileQQ.sMobileQQ.waitAppRuntime(null));
    if (isActivityLocaleUpdated(getResources().getConfiguration().locale))
    {
      paramBundle = getResources();
      Configuration localConfiguration = paramBundle.getConfiguration();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(paramBundle.getDisplayMetrics());
      localConfiguration.locale = locale;
      paramBundle.updateConfiguration(localConfiguration, paramBundle.getDisplayMetrics());
      paramBundle.getDisplayMetrics().setTo(localDisplayMetrics);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    MobileQQ.sMobileQQ.appActivities.remove(new WeakReference(this));
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent) {}
  
  protected void doOnPause() {}
  
  protected void doOnPostCreate(Bundle paramBundle)
  {
    this.mPostCreateBundle = null;
  }
  
  protected void doOnPostResume() {}
  
  protected void doOnRestoreInstanceState(Bundle paramBundle) {}
  
  protected void doOnResume() {}
  
  protected void doOnSaveInstanceState(Bundle paramBundle) {}
  
  protected void doOnStart()
  {
    if (isActivityLocaleUpdated(getResources().getConfiguration().locale)) {
      recreate();
    }
  }
  
  protected void doOnStop() {}
  
  protected void doOnUserLeaveHint() {}
  
  protected void doOnWindowFocusChanged(boolean paramBoolean) {}
  
  public final AppRuntime getAppRuntime()
  {
    return this.mRuntime;
  }
  
  protected String getModuleId()
  {
    return null;
  }
  
  public Resources getResources()
  {
    if (isLocaleCN()) {
      return super.getResources();
    }
    return getApplicationContext().getResources();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public final boolean isResume()
  {
    return this.mIsResume;
  }
  
  protected void onAccountChanged() {}
  
  protected void onAccoutChangeFailed() {}
  
  @Deprecated
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.mIsSplashing) {
      doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      this.mIsResultWaiting = true;
      this.mRequestCode = paramInt1;
      this.mResultCode = paramInt2;
      this.mResultData = paramIntent;
    }
  }
  
  @Deprecated
  public void onBackPressed()
  {
    if (this.mIsSplashing) {
      return;
    }
    doOnBackPressed();
  }
  
  @Deprecated
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mIsSplashing) {
      doOnConfigurationChanged(paramConfiguration);
    }
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  @Deprecated
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    requestWindowFeature(localIntent);
    this.mIsSplashing = MobileQQ.sMobileQQ.onActivityCreate(this, localIntent);
    if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
      AndroidOUIWrapperUtil.fixOrientation(this);
    }
    super.onCreate(paramBundle);
    Foreground.onCreate(this);
    if (this.mIsSplashing)
    {
      this.mOnCreateBundle = paramBundle;
      return;
    }
    doOnCreate(paramBundle);
  }
  
  @Deprecated
  protected void onDestroy()
  {
    if ((!this.mIsSplashing) || (this.mIsFinishingInOnCreate)) {
      doOnDestroy();
    }
    super.onDestroy();
    Foreground.onDestroy(this);
    this.mProRuntime = null;
  }
  
  @Deprecated
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mIsSplashing) {
      return false;
    }
    return doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    finish();
  }
  
  @Deprecated
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (!this.mIsSplashing)
    {
      doOnNewIntent(paramIntent);
      return;
    }
    this.mNewIntent = paramIntent;
  }
  
  @Deprecated
  protected void onPause()
  {
    if (!this.mIsSplashing) {
      doOnPause();
    }
    Foreground.onPause(this.mProRuntime);
    this.mIsResume = false;
    super.onPause();
  }
  
  @Deprecated
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    if (!this.mIsSplashing)
    {
      doOnPostCreate(paramBundle);
      return;
    }
    this.mPostCreateBundle = paramBundle;
  }
  
  @Deprecated
  protected void onPostResume()
  {
    super.onPostResume();
    if (!this.mIsSplashing) {
      doOnPostResume();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramArrayOfInt.length == 0) {}
    List localList;
    do
    {
      return;
      localList = (List)this.mPermissionCallerMap.get(paramInt);
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (localObject != null) {
            if ((localObject instanceof QQPermissionCallback))
            {
              localObject = (QQPermissionCallback)localObject;
              ArrayList localArrayList = new ArrayList();
              int i = 0;
              while (i < paramArrayOfInt.length)
              {
                if (paramArrayOfInt[i] != 0) {
                  localArrayList.add(paramArrayOfString[i]);
                }
                i += 1;
              }
              if (localArrayList.size() > 0) {
                ((QQPermissionCallback)localObject).deny(paramInt, paramArrayOfString, paramArrayOfInt);
              } else {
                ((QQPermissionCallback)localObject).grant(paramInt, paramArrayOfString, paramArrayOfInt);
              }
            }
            else
            {
              QQPermissionHelper.requestResult(localObject, paramInt, paramArrayOfString, paramArrayOfInt);
            }
          }
        }
      }
    } while (localList == null);
    this.mPermissionCallerMap.remove(paramInt);
  }
  
  @Deprecated
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (!this.mIsSplashing)
    {
      doOnRestoreInstanceState(paramBundle);
      return;
    }
    this.mOnRestoreBundle = paramBundle;
  }
  
  @Deprecated
  protected void onResume()
  {
    try
    {
      super.onResume();
      this.mIsResume = true;
      Foreground.onResume(this.mProRuntime);
      if (!this.mIsSplashing) {
        doOnResume();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      for (;;)
      {
        QLog.d("AppActivity", 1, "super onResume", localIllegalArgumentException1);
        try
        {
          Field localField = Activity.class.getDeclaredField("mCalled");
          localField.setAccessible(true);
          localField.set(this, Boolean.valueOf(true));
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localNoSuchFieldException.printStackTrace();
        }
        catch (SecurityException localSecurityException)
        {
          localSecurityException.printStackTrace();
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          localIllegalArgumentException2.printStackTrace();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        QLog.d("AppActivity", 1, "super onResume", localNullPointerException);
      }
    }
  }
  
  @Deprecated
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!this.mIsSplashing) {
      doOnSaveInstanceState(paramBundle);
    }
  }
  
  @Deprecated
  protected void onStart()
  {
    super.onStart();
    Foreground.onStart(this.mProRuntime, this);
    if (!this.mIsSplashing)
    {
      doOnStart();
      return;
    }
    this.mIsStartSkipped = true;
  }
  
  @Deprecated
  protected void onStop()
  {
    Foreground.onStop(this.mProRuntime);
    if (!this.mIsSplashing) {
      doOnStop();
    }
    for (;;)
    {
      super.onStop();
      return;
      this.mIsStartSkipped = false;
    }
  }
  
  @Deprecated
  protected void onUserLeaveHint()
  {
    if (!this.mIsSplashing) {
      doOnUserLeaveHint();
    }
    super.onUserLeaveHint();
  }
  
  @Deprecated
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    MobileQQ.sMobileQQ.onActivityFocusChanged(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (sActivityDispatchCallback != null) {
      sActivityDispatchCallback.onWindowFocusChanged(this, paramBoolean);
    }
    if (!this.mIsSplashing)
    {
      doOnWindowFocusChanged(paramBoolean);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.mWindowFocusState = i;
      return;
    }
  }
  
  public boolean preloadData(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    return false;
  }
  
  public void preloadUi() {}
  
  public void realOnCreate()
  {
    boolean bool = true;
    if (this.mIsSplashing)
    {
      this.mIsSplashing = false;
      if ((!doOnCreate(this.mOnCreateBundle)) || (isFinishing())) {
        break label178;
      }
      Foreground.updateRuntimeState(this.mProRuntime);
      if (this.mIsStartSkipped)
      {
        doOnStart();
        this.mIsStartSkipped = false;
        if (this.mOnRestoreBundle != null)
        {
          doOnRestoreInstanceState(this.mOnRestoreBundle);
          this.mOnRestoreBundle = null;
        }
        doOnPostCreate(this.mPostCreateBundle);
        if (this.mIsResultWaiting)
        {
          doOnActivityResult(this.mRequestCode, this.mResultCode, this.mResultData);
          this.mIsResultWaiting = false;
          this.mResultData = null;
        }
        if (this.mNewIntent != null)
        {
          doOnNewIntent(this.mNewIntent);
          this.mNewIntent = null;
        }
        if (isResume())
        {
          doOnResume();
          doOnPostResume();
        }
        if (this.mWindowFocusState != -1)
        {
          if (this.mWindowFocusState != 1) {
            break label173;
          }
          doOnWindowFocusChanged(bool);
        }
      }
    }
    label173:
    label178:
    while (!isFinishing()) {
      for (;;)
      {
        return;
        bool = false;
      }
    }
    this.mIsSplashing = true;
    this.mIsFinishingInOnCreate = true;
  }
  
  @TargetApi(24)
  public void requestPermissions(Object paramObject, int paramInt, String... paramVarArgs)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, new Object[] { "fight.requestPermissions-", paramVarArgs });
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramVarArgs.length;
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = paramVarArgs[i];
      if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission((String)localObject) != 0)) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localObject = (List)this.mPermissionCallerMap.get(paramInt);
      paramVarArgs = (String[])localObject;
      if (localObject == null) {
        paramVarArgs = new ArrayList();
      }
      k = paramVarArgs.size();
      i = 0;
      if (i >= k) {
        break label264;
      }
      localObject = paramVarArgs.get(i);
      if ((localObject == null) || (localObject != paramObject)) {}
    }
    label264:
    for (i = j;; i = 0)
    {
      if (i == 0)
      {
        paramVarArgs.add(paramObject);
        this.mPermissionCallerMap.put(paramInt, paramVarArgs);
      }
      requestPermissions((String[])localArrayList.toArray(new String[localArrayList.size()]), paramInt);
      return;
      i += 1;
      break;
      if ((paramObject instanceof QQPermissionCallback))
      {
        ((QQPermissionCallback)paramObject).grant(paramInt, paramVarArgs, null);
        return;
      }
      QQPermissionHelper.doExecuteSuccess(paramObject, paramInt);
      return;
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent) {}
  
  public void sendBroadcast(Intent paramIntent)
  {
    MobileQQ.restrictBroadcast(paramIntent);
    super.sendBroadcast(paramIntent);
    MobileQQ.sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    MobileQQ.restrictBroadcast(paramIntent);
    super.sendBroadcast(paramIntent, paramString);
    MobileQQ.sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    MobileQQ.restrictBroadcast(paramIntent);
    super.sendOrderedBroadcast(paramIntent, paramString);
    MobileQQ.sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    MobileQQ.restrictBroadcast(paramIntent);
    super.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
    MobileQQ.sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  void setAppRuntime(AppRuntime paramAppRuntime)
  {
    this.mProRuntime = paramAppRuntime;
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime != null)
    {
      String str = getModuleId();
      localAppRuntime = paramAppRuntime;
      if (!TextUtils.isEmpty(str)) {
        localAppRuntime = paramAppRuntime.getAppRuntime(str);
      }
    }
    this.mRuntime = localAppRuntime;
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if (!AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
      super.setRequestedOrientation(paramInt);
    }
  }
  
  public boolean showPreview()
  {
    return false;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramIntent.putExtra("preAct", getClass().getSimpleName());
    paramIntent.putExtra("preAct_time", System.currentTimeMillis());
    paramIntent.putExtra("preAct_elapsedRealtime", SystemClock.elapsedRealtime());
    FileProvider7Helper.intentCompatForN(this, paramIntent);
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 0);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 1);
    return super.startService(paramIntent);
  }
  
  public void superFinish()
  {
    super.finish();
  }
  
  public void superSetRequestedOrientation(int paramInt)
  {
    super.setRequestedOrientation(paramInt);
  }
  
  public final void superStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.startActivityForResult(paramIntent, -1, paramBundle);
      return;
    }
    super.startActivityForResult(paramIntent, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.AppActivity
 * JD-Core Version:    0.7.0.1
 */