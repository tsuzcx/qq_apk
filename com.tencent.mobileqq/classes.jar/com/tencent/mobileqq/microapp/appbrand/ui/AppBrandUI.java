package com.tencent.mobileqq.microapp.appbrand.ui;

import Wallet.ApkgConfig;
import adpn;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import ayvq;
import ayvr;
import bdgk;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMiniApp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.activity.LoadingFragment;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.app.b.b;
import com.tencent.mobileqq.microapp.appbrand.j;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.microapp.sdk.MiniAppLifeUtil;
import com.tencent.mobileqq.microapp.widget.input.a.a;
import com.tencent.qphone.base.util.QLog;
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
  private ayvq g;
  private ayvr h = new a(this);
  
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
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandUI", 4, "moveTaskToBack nonRoot=" + paramBoolean1 + ",bAnim=" + paramBoolean2);
    }
    try
    {
      MiniAppLifeUtil.notifyLifeAction(0, this.a.a().c.f);
      label57:
      if (b())
      {
        c();
        paramBoolean1 = true;
      }
      boolean bool;
      do
      {
        return paramBoolean1;
        bool = super.moveTaskToBack(paramBoolean1);
        paramBoolean1 = bool;
      } while (!paramBoolean2);
      com.tencent.mobileqq.microapp.b.a.b(this);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      break label57;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandUI", 1, "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {}
      for (;;)
      {
        this.e = bool;
        this.f = false;
        return;
        bool = false;
      }
    }
    MiniAppController.getInstance().notifyResultListener(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    int i = this.a.c();
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandUI", 4, "onBackPressed appBrandRuntimeSize=" + i);
    }
    if (i > 0)
    {
      com.tencent.mobileqq.microapp.appbrand.a locala = this.a.a();
      if (locala.g.handleBackPressed()) {
        return;
      }
      i = locala.g.getPageCount();
      if (QLog.isColorLevel()) {
        QLog.d("AppBrandUI", 4, "onBackPressed pageCount=" + i);
      }
      if (i > 1)
      {
        locala.g.navigateBack(1, true);
        return;
      }
      a(true, true);
      return;
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
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
    this.g = new ayvq(this.d);
    this.g.a(this.h);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandUI", 4, "onDestroy");
    }
    if (this.a != null) {
      this.a.d();
    }
    com.tencent.mobileqq.microapp.app.b.a().deleteObserver(this.b);
    this.b = null;
    if (this.g != null) {
      this.g.b(this.h);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    int j = 0;
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandUI", 4, "onNewIntent");
    }
    int i = j;
    if (paramIntent != null) {}
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
      for (;;)
      {
        localThrowable.printStackTrace();
        i = j;
      }
      this.c = paramIntent;
    }
    if (i != 0)
    {
      if ((this.a == null) || (this.a.c() == 0)) {
        finish();
      }
      return;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandUI", 4, "onPause");
    }
    if (this.f) {}
    com.tencent.mobileqq.microapp.appbrand.a locala;
    do
    {
      return;
      locala = this.a.a();
    } while (locala == null);
    locala.c();
  }
  
  public void doOnResume()
  {
    Object localObject1 = null;
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandUI", 4, "onResume isLoadFail=" + this.e);
    }
    try
    {
      MiniAppConfig localMiniAppConfig = (MiniAppConfig)this.c.getSerializableExtra("CONFIG");
      localObject1 = localMiniAppConfig;
    }
    catch (Throwable localThrowable1)
    {
      Object localObject2;
      com.tencent.mobileqq.microapp.appbrand.a locala;
      do
      {
        for (;;)
        {
          localThrowable1.printStackTrace();
        }
        b(localObject1);
        a(localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("AppBrandUI", 4, "onResume miniConfig.launchParam.tempState=" + localObject1.launchParam.tempState + "---" + bdgk.a());
        }
        localObject2 = localObject1.config.mini_appid;
        locala = this.a.a((String)localObject2, localObject1.getRuntimeType());
        if (localObject1.launchParam.tempState == 0) {
          break;
        }
      } while (locala == null);
      locala.a(localObject1);
      return;
      localObject1.launchParam.tempState = 1;
      try
      {
        ResultReceiver localResultReceiver = (ResultReceiver)this.c.getParcelableExtra("receiver");
        if (localResultReceiver != null) {
          localResultReceiver.send(0, null);
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
        }
        this.e = true;
        this.f = true;
        if (!QLog.isColorLevel()) {
          break label419;
        }
        QLog.d("AppBrandUI", 4, "onResume startActivityForResult isLoadFail=" + this.e + ",appid =" + (String)localObject2 + ",entryPath=" + localObject1.launchParam.entryPath);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("public_fragment_window_feature", 1);
        ((Intent)localObject2).putExtra("CONFIG", localObject1);
        adpn.a(this, (Intent)localObject2, PublicFragmentActivityForMiniApp.class, LoadingFragment.class, 1);
        com.tencent.mobileqq.microapp.b.a.a(this);
        return;
      }
      if (!QLog.isColorLevel()) {
        break label287;
      }
      QLog.d("AppBrandUI", 4, "onResume appid=" + (String)localObject2 + ",app_name=" + localObject1.config.app_name + ",entryPath=" + localObject1.launchParam.entryPath + ",appBrandRunTime=" + locala);
      if (locala != null) {
        break label462;
      }
      if (!QLog.isColorLevel()) {
        break label326;
      }
      QLog.d("AppBrandUI", 4, "onResume appBrandRunTime not found! isLoadFail=" + this.e);
      if (!this.e) {
        break label348;
      }
      a();
      return;
      if (!QLog.isColorLevel()) {
        break label494;
      }
      QLog.d("AppBrandUI", 4, "onResume bringToFront appBrandRunTime=" + locala);
      this.a.a(locala);
      if (TextUtils.isEmpty(localObject1.launchParam.entryPath)) {
        break label526;
      }
      locala.a(localObject1.launchParam.entryPath);
      locala.a(localObject1);
    }
    if (localObject1 == null)
    {
      a(true, false);
      return;
    }
    label287:
    label326:
    label348:
    label494:
    return;
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
    }
    for (;;)
    {
      com.tencent.mobileqq.microapp.b.a.b(this);
      return;
      super.finish();
    }
  }
  
  public boolean isWrapContent()
  {
    return (this.a != null) && (this.a.a() != null) && (this.a.a().g != null) && (this.a.a().g.pageLinkedList != null) && (this.a.a().g.pageLinkedList.peek() != null) && (((AbsAppBrandPage)this.a.a().g.pageLinkedList.peek()).isHomePage());
  }
  
  public boolean moveTaskToBack(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandUI", 4, "moveTaskToBack");
    }
    return super.moveTaskToBack(paramBoolean);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.ui.AppBrandUI
 * JD-Core Version:    0.7.0.1
 */