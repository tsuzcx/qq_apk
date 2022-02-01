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
    if (!this.enableMemoryDetect) {
      return;
    }
    int i;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_process_mem_detect_enable", 1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      QLog.i("miniapp-start_AppBrandUI", 1, "MemoryDetect disabled by config!");
      return;
    }
    try
    {
      float f1 = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_process_mem_detect_alerm", 0.95F);
      Object localObject = (ActivityManager)getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
      long l = Runtime.getRuntime().maxMemory();
      double d = l;
      Double.isNaN(d);
      float f2 = (float)(d * 1.0D / 1048576.0D);
      l = Runtime.getRuntime().totalMemory();
      d = l;
      Double.isNaN(d);
      float f3 = (float)(d * 1.0D / 1048576.0D);
      l = Runtime.getRuntime().freeMemory();
      d = l;
      Double.isNaN(d);
      float f4 = (float)(d * 1.0D / 1048576.0D);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MemoryDetect maxMemory=");
      ((StringBuilder)localObject).append(f2);
      ((StringBuilder)localObject).append(" currMemory=");
      ((StringBuilder)localObject).append(f3);
      ((StringBuilder)localObject).append(" freeMemory=");
      ((StringBuilder)localObject).append(f4);
      ((StringBuilder)localObject).append(" percent=");
      f2 = f3 / f2;
      ((StringBuilder)localObject).append(f2);
      ((StringBuilder)localObject).append(" alermThreshold=");
      ((StringBuilder)localObject).append(f1);
      QLog.i("miniapp-start_AppBrandUI", 1, ((StringBuilder)localObject).toString());
      if (f2 >= f1)
      {
        ThreadManager.getUIHandler().post(new AppBrandUI.4(this));
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MemoryInfo availMem=");
      ((StringBuilder)localObject).append(localMemoryInfo.availMem);
      ((StringBuilder)localObject).append(" threshold=");
      ((StringBuilder)localObject).append(localMemoryInfo.threshold);
      ((StringBuilder)localObject).append(" lowMemory=");
      ((StringBuilder)localObject).append(localMemoryInfo.lowMemory);
      QLog.i("miniapp-start_AppBrandUI", 1, ((StringBuilder)localObject).toString());
      if (localMemoryInfo.lowMemory)
      {
        ThreadManager.getUIHandler().post(new AppBrandUI.5(this));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-start_AppBrandUI", 1, "", localThrowable);
    }
  }
  
  private void enableDetectMemory(boolean paramBoolean)
  {
    this.enableMemoryDetect = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MemoryDetect enableDetectMemory:");
    localStringBuilder.append(this.enableMemoryDetect);
    QLog.i("miniapp-start_AppBrandUI", 1, localStringBuilder.toString());
  }
  
  private void showRestartDialog()
  {
    try
    {
      int i = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_process_mem_alert_mode", 0);
      if (i == 0)
      {
        Toast.makeText(this, 2131891789, 0).show();
        return;
      }
      if (i == 1)
      {
        if (this.mRestartDialog == null)
        {
          this.mRestartDialog = new QQCustomDialog(this, 2131953338);
          this.mRestartDialog.setContentView(2131624587);
          this.mRestartDialog.setTitle(2131891739);
          this.mRestartDialog.setMessage(2131891789);
          this.mRestartDialog.setPositiveButton(HardCodeUtil.a(2131899883), new AppBrandUI.6(this));
          this.mRestartDialog.setNegativeButton(HardCodeUtil.a(2131898212), new AppBrandUI.7(this));
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnActivityResult requestCode=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" resultCode=");
    localStringBuilder.append(paramInt2);
    QLog.i("miniapp-start_AppBrandUI", 1, localStringBuilder.toString());
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnCreate");
    setRequestedOrientation(1);
    this.mActNeedImmersive = false;
    getFakeBrandUI().doBeforeOnCreate(this, paramBundle);
    ThreadManager.getFileThreadHandler().postDelayed(new AppBrandUI.1(this), 10000L);
    super.doOnCreate(paramBundle);
    return getFakeBrandUI().doOnCreate(this, paramBundle);
  }
  
  protected void doOnDestroy()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnDestroy");
    getFakeBrandUI().doOnDestroy(this);
    this.mFakeBrandUI = null;
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnNewIntent");
    super.doOnNewIntent(paramIntent);
    getFakeBrandUI().doOnNewIntent(this, paramIntent);
  }
  
  protected void doOnPause()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnPause");
    getFakeBrandUI().doOnPause(this);
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnResume");
    super.doOnResume();
    getFakeBrandUI().doOnResume(this);
    enableDetectMemory(true);
  }
  
  protected void doOnStart()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnStart");
    super.doOnStart();
    getFakeBrandUI().doOnStart(this);
    if ((MiniAppInfo)getIntent().getParcelableExtra("KEY_APPINFO") != null) {
      ThreadManagerV2.excute(new AppBrandUI.2(this), 16, null, true);
    }
  }
  
  protected void doOnStop()
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
    IFakeBrandUI localIFakeBrandUI = this.mFakeBrandUI;
    if (localIFakeBrandUI != null) {
      return localIFakeBrandUI;
    }
    this.mFakeBrandUI = new FakeSdkBrandUI();
    return this.mFakeBrandUI;
  }
  
  protected boolean isWrapContent()
  {
    return getFakeBrandUI().isWrapContent(this);
  }
  
  public boolean moveTaskToBack(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("moveTaskToBack nonRoot=");
    localStringBuilder.append(paramBoolean);
    QLog.i("miniapp-start_AppBrandUI", 1, localStringBuilder.toString());
    getFakeBrandUI().moveTaskToBack(this, paramBoolean, true);
    return super.moveTaskToBack(paramBoolean);
  }
  
  public boolean moveTaskToBack(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("moveTaskToBack nonRoot=");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" bAnim=");
    localStringBuilder.append(paramBoolean2);
    QLog.i("miniapp-start_AppBrandUI", 1, localStringBuilder.toString());
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
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI
 * JD-Core Version:    0.7.0.1
 */