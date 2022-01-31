package mqq.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;

public class BaseActivity
  extends Activity
{
  private AppRuntime app;
  private boolean isResume;
  protected boolean mIsShadow;
  private AppRuntime mProcRuntime;
  private MobileQQ mqq;
  
  public final AppRuntime getAppRuntime()
  {
    return this.app;
  }
  
  protected String getModuleId()
  {
    return null;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected boolean isLatecyWaitRuntime()
  {
    return false;
  }
  
  public final boolean isResume()
  {
    return this.isResume;
  }
  
  protected boolean isShadow()
  {
    return false;
  }
  
  protected void onAccountChanged() {}
  
  protected void onAccoutChangeFailed() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    onCreateNoRuntime(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onCreate");
    }
    if (!isLatecyWaitRuntime()) {
      waitAppRuntime();
    }
  }
  
  protected void onCreateNoRuntime(Bundle paramBundle)
  {
    this.mIsShadow = isShadow();
    if (!this.mIsShadow) {
      super.onCreate(paramBundle);
    }
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onCreateNoRuntime");
    }
    this.mqq = MobileQQ.getMobileQQ();
    this.mqq.addActivity(this);
  }
  
  protected void onDestroy()
  {
    if (!this.mIsShadow) {
      super.onDestroy();
    }
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onDestroy");
    }
    this.mqq.removeActivity(this);
    this.mqq = null;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    finish();
  }
  
  protected void onPause()
  {
    if (!this.mIsShadow) {
      super.onPause();
    }
    Foreground.onPause(this.mProcRuntime);
    this.isResume = false;
  }
  
  protected void onResume()
  {
    if (!this.mIsShadow) {
      super.onResume();
    }
    Foreground.onResume(this.mProcRuntime);
    this.isResume = true;
  }
  
  protected void onStart()
  {
    if (!this.mIsShadow) {
      super.onStart();
    }
    Foreground.onStart(this.mProcRuntime, this);
  }
  
  protected void onStop()
  {
    if (!this.mIsShadow) {
      super.onStop();
    }
    Foreground.onStop(this.mProcRuntime);
  }
  
  void setAppRuntime(AppRuntime paramAppRuntime)
  {
    this.mProcRuntime = paramAppRuntime;
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime != null) {
      localAppRuntime = paramAppRuntime.getAppRuntime(getModuleId());
    }
    this.app = localAppRuntime;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (!this.mIsShadow)
    {
      paramIntent.putExtra("preAct", getClass().getSimpleName());
      paramIntent.putExtra("preAct_time", System.currentTimeMillis());
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public final void superFinish()
  {
    super.finish();
  }
  
  public AppRuntime waitAppRuntime()
  {
    AppRuntime localAppRuntime = this.mqq.waitAppRuntime(this);
    if (localAppRuntime == null) {
      return null;
    }
    this.mProcRuntime = localAppRuntime;
    this.app = localAppRuntime.getAppRuntime(getModuleId());
    return this.app;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.BaseActivity
 * JD-Core Version:    0.7.0.1
 */