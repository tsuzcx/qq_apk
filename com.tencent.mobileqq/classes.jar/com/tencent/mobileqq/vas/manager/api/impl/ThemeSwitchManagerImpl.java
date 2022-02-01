package com.tencent.mobileqq.vas.manager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.theme.ThemeCleaner;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class ThemeSwitchManagerImpl
  implements IThemeSwitchManager
{
  QQProgressDialog a;
  public ThemeDiyStyleLogic.StyleCallBack b;
  public AppRuntime c = MobileQQ.sMobileQQ.waitAppRuntime(null);
  View d;
  Bitmap e;
  ImageView f;
  public AtomicBoolean g = new AtomicBoolean(false);
  WeakReference<Activity> h;
  Handler i = new ThemeSwitchManagerImpl.2(this, Looper.getMainLooper());
  private ThemeCleaner j = new ThemeCleaner();
  
  public ThemeSwitchManagerImpl()
  {
    this.c.getApplication().registerReceiver(this.j, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
  }
  
  protected void a(Activity paramActivity)
  {
    if (this.d == null)
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getDecorView();
        if (paramActivity != null) {
          this.d = paramActivity.getRootView();
        }
      }
    }
  }
  
  protected void a(Activity paramActivity, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      ImageView localImageView = this.f;
      if ((localImageView != null) && (localImageView.getParent() != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeSwitchManager", 2, new Object[] { "doScreenShot, last one has not remove-->", this.f });
        }
        ((ViewGroup)this.f.getParent()).removeView(this.f);
      }
      this.e = Bitmap.createBitmap(paramBitmap);
      this.f = new ImageView(paramActivity);
      this.f.setImageBitmap(this.e);
      if (((IVasDepTemp)QRoute.api(IVasDepTemp.class)).isQQBrowserActivity(paramActivity))
      {
        this.f.setAlpha(220);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeSwitchManager", 2, "doScreenShot, refActivity is QQBrowserActivity");
        }
      }
      paramActivity = (ViewGroup)this.d;
      this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      paramActivity.addView(this.f);
    }
  }
  
  public void clearOnErr()
  {
    this.i.sendEmptyMessage(201);
  }
  
  public void doScreenShot()
  {
    try
    {
      if ((this.h != null) && (this.h.get() != null))
      {
        Activity localActivity = (Activity)this.h.get();
        a(localActivity);
        if (this.d == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ThemeSwitchManager", 2, "doScreenShot, rootView is null");
          return;
        }
        boolean bool1 = this.d.isDrawingCacheEnabled();
        boolean bool2 = this.d.willNotCacheDrawing();
        this.d.setDrawingCacheEnabled(true);
        this.d.setWillNotCacheDrawing(false);
        a(localActivity, this.d.getDrawingCache());
        this.d.setDrawingCacheEnabled(bool1);
        this.d.setWillNotCacheDrawing(bool2);
      }
      else
      {
        QLog.e("ThemeSwitchManager", 1, "doScreenShot, currActivityRef is null");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ThemeSwitchManager", 1, "doScreenShot oom, no animation", localThrowable);
      this.e = null;
      Object localObject = this.f;
      if ((localObject != null) && (((ImageView)localObject).getParent() != null)) {
        ((ViewGroup)this.f.getParent()).removeView(this.f);
      }
      this.f = null;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("drawingCache is:");
        ((StringBuilder)localObject).append(this.e);
        QLog.d("ThemeSwitchManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
  }
  
  public boolean getIsEnableAnimate(Bundle paramBundle)
  {
    Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.theme_profile.name(), "1|1|1");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getIsEnableAnimate profileStr:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("ThemeSwitchManager", 2, ((StringBuilder)localObject2).toString());
    }
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject1);
    boolean bool3 = false;
    if (!bool1)
    {
      localObject2 = new Integer[3];
      localObject2[0] = Integer.valueOf(0);
      localObject2[1] = Integer.valueOf(0);
      localObject2[2] = Integer.valueOf(0);
      int k = ((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser((String)localObject1, (Integer[])localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getIsEnableAnimate size:");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(", params:");
        ((StringBuilder)localObject1).append(localObject2);
        QLog.i("ThemeSwitchManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (k >= 3)
      {
        if (localObject2[0].intValue() == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2;
        if (localObject2[1].intValue() == 1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        if (localObject2[2].intValue() == 1) {
          bool3 = true;
        }
        if (paramBundle != null)
        {
          paramBundle.putBoolean("dynamic_switch", bool1);
          paramBundle.putBoolean("dynamic_enable", bool2);
          paramBundle.putBoolean("dynamic_webview_enable", bool3);
        }
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public ThemeDiyStyleLogic.StyleCallBack getstyleCallBack()
  {
    return this.b;
  }
  
  public void onDestroy()
  {
    if (this.j != null) {
      this.c.getApplication().unregisterReceiver(this.j);
    }
    this.c = null;
    QQProgressDialog localQQProgressDialog = this.a;
    if (localQQProgressDialog != null)
    {
      if (localQQProgressDialog.isShowing()) {
        this.a.dismiss();
      }
      this.a = null;
    }
  }
  
  public void onPostThemeChanged()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing()))
    {
      this.a.dismiss();
      this.a = null;
    }
    if (this.d == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, "onPostThemeChanged rootView is null");
      }
      return;
    }
    if (this.e != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, new Object[] { "onPostThemeChanged, isAnimating: ", Boolean.valueOf(this.g.get()), " tmpScreenShot: ", this.f });
      }
      if ((!this.g.get()) && (this.f != null))
      {
        this.g.set(true);
        localObject = new AlphaAnimation(1.0F, 0.1F);
        ((Animation)localObject).setDuration(501L);
        ((Animation)localObject).setInterpolator(new LinearInterpolator());
        ((Animation)localObject).setFillAfter(true);
        ((Animation)localObject).setAnimationListener(new ThemeSwitchManagerImpl.1(this));
        this.f.startAnimation((Animation)localObject);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ThemeSwitchManager", 2, "onPostThemeChanged drawingCache is null");
    }
    this.d = null;
  }
  
  public void openSwitchDialog(Activity paramActivity)
  {
    this.h = new WeakReference(paramActivity);
    this.i.sendEmptyMessage(200);
  }
  
  public void setstyleCallBack(@NotNull ThemeDiyStyleLogic.StyleCallBack paramStyleCallBack)
  {
    this.b = paramStyleCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.manager.api.impl.ThemeSwitchManagerImpl
 * JD-Core Version:    0.7.0.1
 */