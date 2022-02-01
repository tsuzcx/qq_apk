package cooperation.qzone;

import android.app.Activity;
import android.content.IntentFilter;
import android.view.KeyEvent;
import cooperation.qzone.util.QZLog;

public class WatchActivityManager
{
  public static String TAG = "WatchActivityManager";
  private Activity activity;
  private boolean mActivityStopped = false;
  private boolean mPressHomeKey = false;
  private boolean mPressMenuKey = false;
  private boolean mPressScreenOff = false;
  public WatchActivityManager.ScreenKeyReceiver mScreenReceiver = new WatchActivityManager.ScreenKeyReceiver(this, null);
  
  private void registKeyReceiver()
  {
    if (this.activity != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.activity.registerReceiver(this.mScreenReceiver, localIntentFilter);
    }
  }
  
  private void resetKeyFlag()
  {
    this.mPressScreenOff = false;
    this.mPressHomeKey = false;
    this.mPressMenuKey = false;
    this.mActivityStopped = false;
  }
  
  private void unRegistKeyReceiver()
  {
    Activity localActivity = this.activity;
    if (localActivity != null) {
      localActivity.unregisterReceiver(this.mScreenReceiver);
    }
  }
  
  public boolean hasJump()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ljh, mActivityStopped = ");
    localStringBuilder.append(this.mActivityStopped);
    localStringBuilder.append(", mPressScreenOff = ");
    localStringBuilder.append(this.mPressScreenOff);
    localStringBuilder.append(", mPressMenuKey = ");
    localStringBuilder.append(this.mPressMenuKey);
    localStringBuilder.append(", mPressHomeKey = ");
    localStringBuilder.append(this.mPressHomeKey);
    QZLog.i(str, 4, localStringBuilder.toString());
    return (this.mActivityStopped) && (!this.mPressScreenOff) && (!this.mPressMenuKey) && (!this.mPressHomeKey);
  }
  
  public void onCreate(Activity paramActivity)
  {
    this.activity = paramActivity;
    registKeyReceiver();
  }
  
  public void onDestroy()
  {
    unRegistKeyReceiver();
  }
  
  public void onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 82) {
      return;
    }
    this.mPressMenuKey = true;
  }
  
  public void onResume()
  {
    resetKeyFlag();
  }
  
  public void onStop()
  {
    this.mActivityStopped = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.WatchActivityManager
 * JD-Core Version:    0.7.0.1
 */