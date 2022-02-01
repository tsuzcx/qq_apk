package cooperation.qwallet.plugin;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeNavigationBarUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppActivity;
import mqq.app.Foreground;

public class QWalletLockScreenActivity
  extends AppActivity
  implements View.OnClickListener
{
  public static int lsActivity_count;
  private final int MSG_FINISH_ACTIVITY = 2;
  private final int MSG_START_UNLOCKACTIVITY = 9;
  private BaseQQAppInterface app;
  String content;
  TextView contentView;
  private Handler handler = new QWalletLockScreenActivity.1(this, Looper.getMainLooper());
  private RelativeLayout mBackBtn;
  QWalletLockScreenActivity.ScreenBroadcastReceiver mScreenReceiver;
  String time;
  TextView timeView;
  String title;
  TextView titleView;
  
  private void initNavigationBarColor()
  {
    ThemeNavigationBarUtil.a(getWindow());
  }
  
  @TargetApi(16)
  private boolean isKeyguardLock()
  {
    if ((Build.VERSION.SDK_INT == 20) && (Build.VERSION.RELEASE.equals("L")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.push", 2, "QWalletLockScreenActivity isKeyguardLock SDK is androidL !");
      }
      return true;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      try
      {
        KeyguardManager localKeyguardManager = (KeyguardManager)getSystemService("keyguard");
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("QWalletLockScreenActivity kgm.isKeyguardLocked()=");
          localStringBuilder.append(localKeyguardManager.isKeyguardLocked());
          localStringBuilder.append(". kgm.isKeyguardSecure()=");
          localStringBuilder.append(localKeyguardManager.isKeyguardSecure());
          QLog.e("Q.qwallet.push", 2, localStringBuilder.toString());
        }
        if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
        {
          boolean bool = localKeyguardManager.isKeyguardSecure();
          if (bool) {
            return true;
          }
        }
        return false;
      }
      catch (SecurityException localSecurityException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("QWalletLockScreenActivity kgm.isKeyguardLocked()=");
          localStringBuilder.append(localSecurityException);
          QLog.e("Q.qwallet.push", 2, localStringBuilder.toString());
        }
      }
    }
    return true;
  }
  
  private void registerListener()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    registerReceiver(this.mScreenReceiver, localIntentFilter);
  }
  
  private void unlockAndStartPayBridgeActivity()
  {
    boolean bool = isKeyguardLock();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QWalletLockScreenActivity isKeyGuardLock=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.qwallet.push", 2, ((StringBuilder)localObject).toString());
    }
    if (!bool)
    {
      localObject = new Intent(this, ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).getQQLSUnlockActivityClazz());
      ((Intent)localObject).putExtra("key_wallet_unlock", true);
      startActivity((Intent)localObject);
      return;
    }
    moveTaskToBack(true);
    finish();
  }
  
  protected void doOnBackPressed()
  {
    super.doOnBackPressed();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity onBackPressed=== ");
    }
    if (!isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity onBackPressed not finish ");
      }
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("QWalletLockScreenActivity doOnCreate taskId");
      paramBundle.append(getTaskId());
      paramBundle.append(Thread.currentThread().getId());
      QLog.d("Q.qwallet.push", 2, paramBundle.toString());
    }
    setContentView(R.layout.A);
    getWindow().addFlags(524288);
    this.mScreenReceiver = new QWalletLockScreenActivity.ScreenBroadcastReceiver(this, null);
    registerListener();
    initNavigationBarColor();
    this.app = ((BaseQQAppInterface)getAppRuntime());
    if (this.app == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity app null,  finish");
      }
      finish();
      return true;
    }
    this.title = getIntent().getStringExtra("title");
    this.content = getIntent().getStringExtra("content");
    this.time = getIntent().getStringExtra("time");
    this.titleView = ((TextView)findViewById(R.id.cC));
    this.contentView = ((TextView)findViewById(R.id.bz));
    this.timeView = ((TextView)findViewById(R.id.bA));
    this.titleView.setText(this.title);
    this.contentView.setText(this.content);
    this.timeView.setText(this.time);
    this.mBackBtn = ((RelativeLayout)findViewById(R.id.n));
    this.mBackBtn.setOnClickListener(this);
    this.contentView.setOnClickListener(this);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity new brightWakeLock");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    QWalletLockScreenActivity.ScreenBroadcastReceiver localScreenBroadcastReceiver = this.mScreenReceiver;
    if (localScreenBroadcastReceiver != null) {
      unregisterReceiver(localScreenBroadcastReceiver);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Object localObject = ((ActivityManager)getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QWalletLockScreenActivity doOnPause by :");
        localStringBuilder.append((String)localObject);
        QLog.d("Q.qwallet.push", 2, localStringBuilder.toString());
      }
      if ("com.tencent.mobileqq.activity.GesturePWDUnlockActivity".equals(localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity doOnPause by locking activity need to front");
        }
        localObject = new Intent(this, QWalletLockScreenActivity.class);
        ((Intent)localObject).addFlags(131072);
        startActivity((Intent)localObject);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QWalletLockScreenActivity doOnPause taskId");
      ((StringBuilder)localObject).append(getTaskId());
      QLog.d("Q.qwallet.push", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    boolean bool = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QQUtils$isScreenLocked(this);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QWalletLockScreenActivity doOnStart isScreenLocked=");
      localStringBuilder.append(bool);
      QLog.d("Q.qwallet.push", 2, localStringBuilder.toString());
    }
    if (!bool) {
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.bz)
    {
      paramView = this.handler.obtainMessage(9);
      Handler localHandler = this.handler;
      long l;
      if (((IQWalletTemp)QRoute.api(IQWalletTemp.class)).GesturePWDUtils$getJumpLock(this, this.app.getCurrentAccountUin())) {
        l = 500L;
      } else {
        l = 0L;
      }
      localHandler.sendMessageDelayed(paramView, l);
      return;
    }
    if (paramView.getId() == R.id.n)
    {
      paramView = this.handler.obtainMessage(2);
      this.handler.sendMessageDelayed(paramView, 1500L);
    }
  }
  
  protected void onStart()
  {
    Foreground.sCountActivity.decrementAndGet();
    super.onStart();
  }
  
  protected void onStop()
  {
    Foreground.sCountActivity.incrementAndGet();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletLockScreenActivity
 * JD-Core Version:    0.7.0.1
 */