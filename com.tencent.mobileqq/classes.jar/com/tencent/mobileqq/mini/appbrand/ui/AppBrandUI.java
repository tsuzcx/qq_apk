package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.fake.FakeSdkBrandUI;
import com.tencent.mobileqq.mini.fake.IFakeBrandUI;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import common.config.service.QzoneConfig;
import mqq.os.MqqHandler;

public class AppBrandUI
  extends MiniBaseActivity
{
  public static final String TAG = "miniapp-start_AppBrandUI";
  private boolean enableMemoryDetect = true;
  protected IFakeBrandUI mFakeBrandUI;
  private QQCustomDialog mRestartDialog;
  
  private void detectMemory()
  {
    doDetectMemory();
    ThreadManager.getFileThreadHandler().postDelayed(new AppBrandUI.3(this), 60000L);
  }
  
  private void doDetectMemory()
  {
    if (!this.enableMemoryDetect) {}
    ActivityManager.MemoryInfo localMemoryInfo;
    do
    {
      return;
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_process_mem_detect_enable", 1) == 1) {}
      for (int i = 1; i == 0; i = 0)
      {
        QLog.i("miniapp-start_AppBrandUI", 1, "MemoryDetect disabled by config!");
        return;
      }
      try
      {
        float f1 = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_process_mem_detect_alerm", 0.95F);
        ActivityManager localActivityManager = (ActivityManager)getSystemService("activity");
        localMemoryInfo = new ActivityManager.MemoryInfo();
        localActivityManager.getMemoryInfo(localMemoryInfo);
        float f2 = (float)(Runtime.getRuntime().maxMemory() * 1.0D / 1048576.0D);
        float f3 = (float)(Runtime.getRuntime().totalMemory() * 1.0D / 1048576.0D);
        float f4 = (float)(Runtime.getRuntime().freeMemory() * 1.0D / 1048576.0D);
        QLog.i("miniapp-start_AppBrandUI", 1, "MemoryDetect maxMemory=" + f2 + " currMemory=" + f3 + " freeMemory=" + f4 + " percent=" + f3 / f2 + " alermThreshold=" + f1);
        if (f3 / f2 >= f1)
        {
          ThreadManager.getUIHandler().post(new AppBrandUI.4(this));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-start_AppBrandUI", 1, "", localThrowable);
        return;
      }
      QLog.i("miniapp-start_AppBrandUI", 1, "MemoryInfo availMem=" + localMemoryInfo.availMem + " threshold=" + localMemoryInfo.threshold + " lowMemory=" + localMemoryInfo.lowMemory);
    } while (!localMemoryInfo.lowMemory);
    ThreadManager.getUIHandler().post(new AppBrandUI.5(this));
  }
  
  private void enableDetectMemory(boolean paramBoolean)
  {
    this.enableMemoryDetect = paramBoolean;
    QLog.i("miniapp-start_AppBrandUI", 1, "MemoryDetect enableDetectMemory:" + this.enableMemoryDetect);
  }
  
  private void showRestartDialog()
  {
    try
    {
      int i = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_process_mem_alert_mode", 0);
      if (i == 0)
      {
        Toast.makeText(this, 2131694195, 0).show();
        return;
      }
      if (i == 1)
      {
        if (this.mRestartDialog == null)
        {
          this.mRestartDialog = new QQCustomDialog(this, 2131755842);
          this.mRestartDialog.setContentView(2131559060);
          this.mRestartDialog.setTitle(2131694156);
          this.mRestartDialog.setMessage(2131694195);
          this.mRestartDialog.setPositiveButton(HardCodeUtil.a(2131705911), new AppBrandUI.6(this));
          this.mRestartDialog.setNegativeButton(HardCodeUtil.a(2131705908), new AppBrandUI.7(this));
          this.mRestartDialog.setCanceledOnTouchOutside(true);
        }
        if (!this.mRestartDialog.isShowing())
        {
          QLog.i("miniapp-start_AppBrandUI", 1, "Show Memory Alerm Dialog");
          this.mRestartDialog.show();
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-start_AppBrandUI", 1, "", localThrowable);
    }
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (getFakeBrandUI().doDispatchKeyEvent(paramKeyEvent)) {
      return true;
    }
    return super.doDispatchKeyEvent(paramKeyEvent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    getFakeBrandUI().doOnActivityResult(this, paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnBackPressed");
    getFakeBrandUI().doOnBackPressed(this, true);
  }
  
  public void doOnBackPressedWithOutReport()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnBackPressedWithOutReport");
    getFakeBrandUI().doOnBackPressed(this, false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnCreate");
    setRequestedOrientation(1);
    this.mActNeedImmersive = false;
    getFakeBrandUI().doBeforeOnCreate(this, paramBundle);
    ThreadManager.getFileThreadHandler().postDelayed(new AppBrandUI.1(this), 10000L);
    super.doOnCreate(paramBundle);
    return getFakeBrandUI().doOnCreate(this, paramBundle);
  }
  
  public void doOnDestroy()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnDestroy");
    getFakeBrandUI().doOnDestroy(this);
    this.mFakeBrandUI = null;
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnNewIntent");
    super.doOnNewIntent(paramIntent);
    getFakeBrandUI().doOnNewIntent(this, paramIntent);
  }
  
  public void doOnPause()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnPause");
    getFakeBrandUI().doOnPause(this);
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnResume");
    super.doOnResume();
    getFakeBrandUI().doOnResume(this);
    enableDetectMemory(true);
  }
  
  public void doOnStart()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnStart");
    super.doOnStart();
    getFakeBrandUI().doOnStart(this);
    if ((MiniAppInfo)getIntent().getParcelableExtra("KEY_APPINFO") != null) {
      ThreadManagerV2.excute(new AppBrandUI.2(this), 16, null, true);
    }
  }
  
  public void doOnStop()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnStop");
    super.doOnStop();
    getFakeBrandUI().doOnStop(this);
    enableDetectMemory(false);
  }
  
  protected void doRefreshMiniBadge(Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doRefreshMiniBadge");
    super.doRefreshMiniBadge(paramBundle);
    getFakeBrandUI().doRefreshMiniBadge(this, paramBundle);
  }
  
  public void finish()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "finish");
    getFakeBrandUI().finish(this);
    super.finish();
  }
  
  public IFakeBrandUI getFakeBrandUI()
  {
    if (this.mFakeBrandUI != null) {
      return this.mFakeBrandUI;
    }
    this.mFakeBrandUI = new FakeSdkBrandUI();
    return this.mFakeBrandUI;
  }
  
  public boolean isWrapContent()
  {
    return getFakeBrandUI().isWrapContent(this);
  }
  
  public boolean moveTaskToBack(boolean paramBoolean)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "moveTaskToBack nonRoot=" + paramBoolean);
    getFakeBrandUI().moveTaskToBack(this, paramBoolean, true);
    return super.moveTaskToBack(paramBoolean);
  }
  
  public boolean moveTaskToBack(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "moveTaskToBack nonRoot=" + paramBoolean1 + " bAnim=" + paramBoolean2);
    return getFakeBrandUI().moveTaskToBack(this, paramBoolean1, paramBoolean2);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    QLog.d("miniapp-start_AppBrandUI", 1, "onConfigurationChanged");
  }
  
  public void onProcessBackground(Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "onProcessBackground");
    super.onProcessBackground(paramBundle);
    getFakeBrandUI().onProcessBackground(this, paramBundle);
  }
  
  public void onProcessForeGround(Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "onProcessForeGround");
    super.onProcessForeGround(paramBundle);
    getFakeBrandUI().onProcessForeGround(this, paramBundle);
  }
  
  public void onRefreshMiniBadge(Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "onRefreshMiniBadge");
    super.onRefreshMiniBadge(paramBundle);
    getFakeBrandUI().onRefreshMiniBadge(this, paramBundle);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI
 * JD-Core Version:    0.7.0.1
 */