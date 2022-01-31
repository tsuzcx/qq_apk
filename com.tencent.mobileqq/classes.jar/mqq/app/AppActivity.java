package mqq.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import mqq.util.WeakReference;

@TargetApi(16)
public class AppActivity
  extends Activity
{
  private boolean mIsFinishingInOnCreate;
  private boolean mIsResultWaiting;
  protected boolean mIsResume;
  private boolean mIsSplashing;
  private boolean mIsStartSkipped;
  private Intent mNewIntent;
  private Bundle mOnCreateBundle;
  private Bundle mOnRestoreBundle;
  private Bundle mPostCreateBundle;
  private AppRuntime mProRuntime;
  private int mRequestCode;
  private int mResultCode;
  private Intent mResultData;
  protected AppRuntime mRuntime;
  private int mWindowFocusState = -1;
  
  @Deprecated
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (this.mIsSplashing) {
      return false;
    }
    return doDispatchKeyEvent(paramKeyEvent);
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
    updateRuntime();
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
  
  protected void doOnStart() {}
  
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
  }
  
  @Deprecated
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    requestWindowFeature(localIntent);
    this.mIsSplashing = MobileQQ.sMobileQQ.onActivityCreate(this, localIntent);
    super.onCreate(paramBundle);
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
  
  protected void requestWindowFeature(Intent paramIntent) {}
  
  void setAppRuntime(AppRuntime paramAppRuntime)
  {
    updateRuntime();
  }
  
  public boolean showPreview()
  {
    return false;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramIntent.putExtra("preAct", getClass().getSimpleName());
    paramIntent.putExtra("preAct_time", System.currentTimeMillis());
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void superFinish()
  {
    super.finish();
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
  
  void updateRuntime()
  {
    AppRuntime localAppRuntime2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.mProRuntime = localAppRuntime2;
    AppRuntime localAppRuntime1 = localAppRuntime2;
    if (localAppRuntime2 != null)
    {
      String str = getModuleId();
      localAppRuntime1 = localAppRuntime2;
      if (!TextUtils.isEmpty(str)) {
        localAppRuntime1 = localAppRuntime2.getAppRuntime(str);
      }
    }
    this.mRuntime = localAppRuntime1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.AppActivity
 * JD-Core Version:    0.7.0.1
 */