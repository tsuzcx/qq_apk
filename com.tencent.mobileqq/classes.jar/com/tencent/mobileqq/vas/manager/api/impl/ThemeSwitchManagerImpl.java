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
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler = new ThemeSwitchManagerImpl.2(this, Looper.getMainLooper());
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ThemeCleaner jdField_a_of_type_ComTencentMobileqqVasThemeThemeCleaner = new ThemeCleaner();
  public ThemeDiyStyleLogic.StyleCallBack a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  public AtomicBoolean a;
  public AppRuntime a;
  
  public ThemeSwitchManagerImpl()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_MqqAppAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.jdField_a_of_type_MqqAppAppRuntime.getApplication().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqVasThemeThemeCleaner, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
  }
  
  public void clearOnErr()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(201);
  }
  
  public void doScreenShot()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        Object localObject1 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          localObject3 = ((Activity)localObject1).getWindow();
          if (localObject3 != null)
          {
            localObject3 = ((Window)localObject3).getDecorView();
            if (localObject3 != null) {
              this.jdField_a_of_type_AndroidViewView = ((View)localObject3).getRootView();
            }
          }
        }
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ThemeSwitchManager", 2, "doScreenShot, rootView is null");
          return;
        }
        boolean bool1 = this.jdField_a_of_type_AndroidViewView.isDrawingCacheEnabled();
        boolean bool2 = this.jdField_a_of_type_AndroidViewView.willNotCacheDrawing();
        this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(true);
        this.jdField_a_of_type_AndroidViewView.setWillNotCacheDrawing(false);
        Object localObject3 = this.jdField_a_of_type_AndroidViewView.getDrawingCache();
        if (localObject3 != null)
        {
          if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getParent() != null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ThemeSwitchManager", 2, new Object[] { "doScreenShot, last one has not remove-->", this.jdField_a_of_type_AndroidWidgetImageView });
            }
            ((ViewGroup)this.jdField_a_of_type_AndroidWidgetImageView.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetImageView);
          }
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((Bitmap)localObject3);
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView((Context)localObject1);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          if (((IVasDepTemp)QRoute.api(IVasDepTemp.class)).isQQBrowserActivity((Activity)localObject1))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(220);
            if (QLog.isColorLevel()) {
              QLog.d("ThemeSwitchManager", 2, "doScreenShot, refActivity is QQBrowserActivity");
            }
          }
          localObject1 = (ViewGroup)this.jdField_a_of_type_AndroidViewView;
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          ((ViewGroup)localObject1).addView(this.jdField_a_of_type_AndroidWidgetImageView);
        }
        this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(bool1);
        this.jdField_a_of_type_AndroidViewView.setWillNotCacheDrawing(bool2);
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
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      Object localObject2 = this.jdField_a_of_type_AndroidWidgetImageView;
      if ((localObject2 != null) && (((ImageView)localObject2).getParent() != null)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidWidgetImageView.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetImageView);
      }
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("drawingCache is:");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidGraphicsBitmap);
        QLog.d("ThemeSwitchManager", 2, ((StringBuilder)localObject2).toString());
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
      int i = ((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser((String)localObject1, (Integer[])localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getIsEnableAnimate size:");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", params:");
        ((StringBuilder)localObject1).append(localObject2);
        QLog.i("ThemeSwitchManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (i >= 3)
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
    return this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyStyleLogic$StyleCallBack;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasThemeThemeCleaner != null) {
      this.jdField_a_of_type_MqqAppAppRuntime.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqVasThemeThemeCleaner);
    }
    this.jdField_a_of_type_MqqAppAppRuntime = null;
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null)
    {
      if (localQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  public void onPostThemeChanged()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, "onPostThemeChanged rootView is null");
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, new Object[] { "onPostThemeChanged, isAnimating: ", Boolean.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()), " tmpScreenShot: ", this.jdField_a_of_type_AndroidWidgetImageView });
      }
      if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localObject = new AlphaAnimation(1.0F, 0.1F);
        ((Animation)localObject).setDuration(501L);
        ((Animation)localObject).setInterpolator(new LinearInterpolator());
        ((Animation)localObject).setFillAfter(true);
        ((Animation)localObject).setAnimationListener(new ThemeSwitchManagerImpl.1(this));
        this.jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ThemeSwitchManager", 2, "onPostThemeChanged drawingCache is null");
    }
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void openSwitchDialog(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(200);
  }
  
  public void setstyleCallBack(@NotNull ThemeDiyStyleLogic.StyleCallBack paramStyleCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyStyleLogic$StyleCallBack = paramStyleCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.manager.api.impl.ThemeSwitchManagerImpl
 * JD-Core Version:    0.7.0.1
 */