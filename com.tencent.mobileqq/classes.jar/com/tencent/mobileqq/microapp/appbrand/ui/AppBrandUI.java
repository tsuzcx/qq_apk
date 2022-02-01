package com.tencent.mobileqq.microapp.appbrand.ui;

import Wallet.ApkgConfig;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.app.b.b;
import com.tencent.mobileqq.microapp.appbrand.j;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.microapp.widget.input.a.a;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;

public class AppBrandUI
  extends BaseActivity
{
  j a;
  b.b b = new d(this);
  private Intent c = null;
  private FrameLayout d;
  private boolean e;
  private boolean f;
  private SoftKeyboardStateHelper g;
  private SoftKeyboardStateHelper.SoftKeyboardStateListener h = new a(this);
  
  private void a()
  {
    this.e = false;
    if (this.a.c() < 1)
    {
      finish();
      return;
    }
    a(true, false);
  }
  
  private void a(MiniAppConfig paramMiniAppConfig)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ThreadManagerV2.excute(new b(this, paramMiniAppConfig), 16, null, false);
  }
  
  private void b(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.getRuntimeType() == 1))
    {
      com.tencent.mobileqq.microapp.appbrand.a locala = this.a.a(paramMiniAppConfig.config.mini_appid, paramMiniAppConfig.getRuntimeType());
      if ((locala != null) && (paramMiniAppConfig.isDebugVersionChange(locala.c.f))) {
        this.a.c(locala);
      }
    }
  }
  
  private boolean b()
  {
    com.tencent.mobileqq.microapp.appbrand.a locala1 = this.a.a();
    com.tencent.mobileqq.microapp.appbrand.a locala2 = this.a.b();
    return (locala1 != null) && (locala1.c.f.launchParam.scene == 1214) && (locala2 != null) && ("101495732".equals(locala2.a));
  }
  
  private void c()
  {
    com.tencent.mobileqq.microapp.appbrand.a locala1 = this.a.a();
    com.tencent.mobileqq.microapp.appbrand.a locala2 = this.a.b();
    if ((locala1 != null) && (locala2 != null)) {
      locala1.g.animate().translationY(locala1.g.getMeasuredHeight()).setDuration(400L).setListener(new c(this, locala1, locala2));
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("moveTaskToBack nonRoot=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",bAnim=");
      localStringBuilder.append(paramBoolean2);
      QLog.d("AppBrandUI", 4, localStringBuilder.toString());
    }
    if (b())
    {
      c();
      return true;
    }
    paramBoolean1 = super.moveTaskToBack(paramBoolean1);
    if (paramBoolean2) {
      com.tencent.mobileqq.microapp.a.c.b(this);
    }
    return paramBoolean1;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnActivityResult requestCode=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",resultCode=");
      localStringBuilder.append(paramInt2);
      QLog.d("AppBrandUI", 1, localStringBuilder.toString());
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1) {
        bool1 = false;
      }
      this.e = bool1;
      this.f = false;
      return;
    }
    MiniAppController.getInstance().notifyResultListener(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    int i = this.a.c();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBackPressed appBrandRuntimeSize=");
      ((StringBuilder)localObject).append(i);
      QLog.d("AppBrandUI", 4, ((StringBuilder)localObject).toString());
    }
    if (i > 0)
    {
      localObject = this.a.a();
      if (((com.tencent.mobileqq.microapp.appbrand.a)localObject).g.handleBackPressed()) {
        return;
      }
      i = ((com.tencent.mobileqq.microapp.appbrand.a)localObject).g.getPageCount();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onBackPressed pageCount=");
        localStringBuilder.append(i);
        QLog.d("AppBrandUI", 4, localStringBuilder.toString());
      }
      if (i > 1)
      {
        ((com.tencent.mobileqq.microapp.appbrand.a)localObject).g.navigateBack(1, true);
        return;
      }
      a(true, true);
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    com.tencent.mobileqq.microapp.app.b.a().addObserver(this.b);
    paramBundle = com.tencent.mobileqq.microapp.app.b.a();
    com.tencent.mobileqq.microapp.widget.input.a locala = com.tencent.mobileqq.microapp.widget.input.a.a();
    locala.getClass();
    paramBundle.addObserver(new a.a(locala));
    this.c = getIntent();
    this.d = new FrameLayout(this);
    this.d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setContentView(this.d);
    if (this.a == null) {
      this.a = new j(this, this.d);
    }
    this.g = new SoftKeyboardStateHelper(this.d);
    this.g.a(this.h);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandUI", 4, "onDestroy");
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((j)localObject).d();
    }
    com.tencent.mobileqq.microapp.app.b.a().deleteObserver(this.b);
    this.b = null;
    localObject = this.g;
    if (localObject != null) {
      ((SoftKeyboardStateHelper)localObject).b(this.h);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandUI", 4, "onNewIntent");
    }
    int j = 0;
    int i = j;
    if (paramIntent != null) {
      try
      {
        boolean bool = paramIntent.getBooleanExtra("key_appbrand_bring_ui_to_front", false);
        i = j;
        if (bool) {
          i = 1;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        i = j;
      }
    }
    if (i != 0)
    {
      paramIntent = this.a;
      if ((paramIntent == null) || (paramIntent.c() == 0)) {
        finish();
      }
      return;
    }
    this.c = paramIntent;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandUI", 4, "onPause");
    }
    if (this.f) {
      return;
    }
    com.tencent.mobileqq.microapp.appbrand.a locala = this.a.a();
    if (locala != null) {
      locala.c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResume isLoadFail=");
      ((StringBuilder)localObject1).append(this.e);
      QLog.d("AppBrandUI", 4, ((StringBuilder)localObject1).toString());
    }
    MiniAppConfig localMiniAppConfig;
    try
    {
      localObject1 = (MiniAppConfig)this.c.getSerializableExtra("CONFIG");
    }
    catch (Throwable localThrowable1)
    {
      localThrowable1.printStackTrace();
      localMiniAppConfig = null;
    }
    if (localMiniAppConfig == null)
    {
      a(true, false);
      return;
    }
    b(localMiniAppConfig);
    a(localMiniAppConfig);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onResume miniConfig.launchParam.tempState=");
      ((StringBuilder)localObject2).append(localMiniAppConfig.launchParam.tempState);
      ((StringBuilder)localObject2).append("---");
      ((StringBuilder)localObject2).append(DeviceInfoUtil.a());
      QLog.d("AppBrandUI", 4, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = localMiniAppConfig.config.mini_appid;
    Object localObject3 = this.a.a((String)localObject2, localMiniAppConfig.getRuntimeType());
    if (localMiniAppConfig.launchParam.tempState != 0)
    {
      if (localObject3 != null) {
        ((com.tencent.mobileqq.microapp.appbrand.a)localObject3).a(localMiniAppConfig);
      }
      return;
    }
    localMiniAppConfig.launchParam.tempState = 1;
    try
    {
      ResultReceiver localResultReceiver = (ResultReceiver)this.c.getParcelableExtra("receiver");
      if (localResultReceiver != null) {
        localResultReceiver.send(0, null);
      }
    }
    catch (Throwable localThrowable2)
    {
      localThrowable2.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume appid=");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(",app_name=");
      localStringBuilder.append(localMiniAppConfig.config.app_name);
      localStringBuilder.append(",entryPath=");
      localStringBuilder.append(localMiniAppConfig.launchParam.entryPath);
      localStringBuilder.append(",appBrandRunTime=");
      localStringBuilder.append(localObject3);
      QLog.d("AppBrandUI", 4, localStringBuilder.toString());
    }
    if (localObject3 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onResume appBrandRunTime not found! isLoadFail=");
        ((StringBuilder)localObject3).append(this.e);
        QLog.d("AppBrandUI", 4, ((StringBuilder)localObject3).toString());
      }
      if (this.e)
      {
        a();
        return;
      }
      this.e = true;
      this.f = true;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onResume startActivityForResult isLoadFail=");
        ((StringBuilder)localObject3).append(this.e);
        ((StringBuilder)localObject3).append(",appid =");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(",entryPath=");
        ((StringBuilder)localObject3).append(localMiniAppConfig.launchParam.entryPath);
        QLog.d("AppBrandUI", 4, ((StringBuilder)localObject3).toString());
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("public_fragment_window_feature", 1);
      ((Intent)localObject2).putExtra("CONFIG", localMiniAppConfig);
      com.tencent.mobileqq.microapp.a.c.a(this);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onResume bringToFront appBrandRunTime=");
      ((StringBuilder)localObject2).append(localObject3);
      QLog.d("AppBrandUI", 4, ((StringBuilder)localObject2).toString());
    }
    this.a.a((com.tencent.mobileqq.microapp.appbrand.a)localObject3);
    if (!TextUtils.isEmpty(localMiniAppConfig.launchParam.entryPath)) {
      ((com.tencent.mobileqq.microapp.appbrand.a)localObject3).a(localMiniAppConfig.launchParam.entryPath);
    }
    ((com.tencent.mobileqq.microapp.appbrand.a)localObject3).a(localMiniAppConfig);
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandUI", 4, "finish");
    }
    if (isFinishing()) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      super.finishAndRemoveTask();
    } else {
      super.finish();
    }
    com.tencent.mobileqq.microapp.a.c.b(this);
  }
  
  protected boolean isWrapContent()
  {
    j localj = this.a;
    return (localj != null) && (localj.a() != null) && (this.a.a().g != null) && (this.a.a().g.pageLinkedList != null) && (this.a.a().g.pageLinkedList.peek() != null) && (((AbsAppBrandPage)this.a.a().g.pageLinkedList.peek()).isHomePage());
  }
  
  public boolean moveTaskToBack(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandUI", 4, "moveTaskToBack");
    }
    return super.moveTaskToBack(paramBoolean);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.ui.AppBrandUI
 * JD-Core Version:    0.7.0.1
 */