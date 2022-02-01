package com.tencent.mobileqq.vas.wallpaper;

import android.app.WallpaperColors;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.Model;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.View;
import com.tencent.mobileqq.vas.wallpaper.model.DrawDrawableWallpaperModel;
import com.tencent.mobileqq.vas.wallpaper.presenter.DrawWallpaperPresenter;
import com.tencent.mobileqq.vas.wallpaper.view.DrawCanvasWallpaperView;
import com.tencent.mobileqq.vas.wallpaper.view.DrawHardwareWallpaperView;
import com.tencent.qapmsdk.base.reporter.ab.AbProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.abfactor.AbFactorProfileCardBg;
import java.io.File;
import kotlin.jvm.functions.Function0;

public final class WallpaperHelper
{
  private VipWallpaperService.WallpaperConfig jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$WallpaperConfig = null;
  private WallpaperHelper.ReTryRunnable jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable = new WallpaperHelper.ReTryRunnable(this);
  private DrawWallpaperContract.View jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$View = null;
  private DrawWallpaperPresenter jdField_a_of_type_ComTencentMobileqqVasWallpaperPresenterDrawWallpaperPresenter = null;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  private DrawWallpaperContract.Model a(DrawWallpaperContract.View paramView, VipWallpaperService.WallpaperConfig paramWallpaperConfig)
  {
    this.jdField_a_of_type_JavaLangString = null;
    Object localObject = new File(paramWallpaperConfig.b);
    QLog.i("VipWallpaper", 1, "use " + paramWallpaperConfig.toString() + " imgFile exists = " + ((File)localObject).exists());
    if (!paramWallpaperConfig.jdField_a_of_type_JavaLangString.equals("0"))
    {
      localObject = new WallpaperHelper.1(this, paramView, paramWallpaperConfig, (File)localObject);
      if ((QVipSDKProcessor.c().a()) && (paramView.a()))
      {
        paramView = new File(paramWallpaperConfig.b.replace("aioImage", "aio_bg.mp4"));
        if (paramView.exists())
        {
          paramWallpaperConfig = GLDrawableWraper.a().a(paramView, true, (Function0)localObject);
          this.jdField_a_of_type_JavaLangString = "wallpaper-video";
          paramView = paramWallpaperConfig;
          if (paramWallpaperConfig != null) {}
        }
      }
    }
    for (paramView = (Drawable)((Function0)localObject).invoke();; paramView = null)
    {
      if (paramView == null) {
        paramView = VipWallpaperService.a();
      }
      for (;;)
      {
        if (paramView != null)
        {
          QLog.i("VipWallpaper", 1, "use " + paramView.getClass().getName());
          return new DrawDrawableWallpaperModel(paramView);
        }
        QLog.i("VipWallpaper", 1, "drawable error");
        return null;
      }
      paramWallpaperConfig = null;
      break;
    }
  }
  
  private DrawWallpaperContract.View a(SurfaceHolder paramSurfaceHolder)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return new DrawHardwareWallpaperView(paramSurfaceHolder);
    }
    return new DrawCanvasWallpaperView(paramSurfaceHolder);
  }
  
  private void a(VipWallpaperService.WallpaperConfig paramWallpaperConfig, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$WallpaperConfig = null;
        }
      } while (paramWallpaperConfig.equals(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$WallpaperConfig));
      b();
      DrawWallpaperContract.Model localModel = a(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$View, paramWallpaperConfig);
      if (localModel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVasWallpaperPresenterDrawWallpaperPresenter = new DrawWallpaperPresenter(localModel, this.jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$View);
        this.jdField_a_of_type_ComTencentMobileqqVasWallpaperPresenterDrawWallpaperPresenter.a();
        this.jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$WallpaperConfig = paramWallpaperConfig;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$WallpaperConfig = null;
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.a(paramWallpaperConfig);
    } while (!paramBoolean);
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable, 3000L);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasWallpaperPresenterDrawWallpaperPresenter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperPresenterDrawWallpaperPresenter.d();
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperPresenterDrawWallpaperPresenter = null;
    }
  }
  
  protected WallpaperColors a()
  {
    if (Build.VERSION.SDK_INT >= 27)
    {
      Color localColor = Color.valueOf(Color.parseColor("#ff000000"));
      QLog.i("VipWallpaper", 1, "onComputeColors " + localColor.toString());
      return new WallpaperColors(localColor, localColor, localColor);
    }
    return null;
  }
  
  protected void a()
  {
    b();
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(Context paramContext, SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$View = a(paramSurfaceHolder);
    paramContext = VipWallpaperService.a(paramContext);
    paramContext.registerOnSharedPreferenceChangeListener(new WallpaperHelper.ConfigChangeListener(this));
    a(VipWallpaperService.a(paramContext), true);
  }
  
  protected void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVasWallpaperPresenterDrawWallpaperPresenter != null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperPresenterDrawWallpaperPresenter.a(paramInt2, paramInt3);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasWallpaperPresenterDrawWallpaperPresenter == null) {
      if (paramBoolean)
      {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
        ThreadManagerV2.getUIHandlerV2().post(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
      }
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqVasWallpaperPresenterDrawWallpaperPresenter.b();
      } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!VasStatisticCollector.a()));
      AbProxy.setAbFactor("壁纸服务", this.jdField_a_of_type_JavaLangString, AbFactorProfileCardBg.class);
    } while (!QLog.isColorLevel());
    QLog.d("VipWallpaper", 2, "wallpaperType=" + this.jdField_a_of_type_JavaLangString);
    return;
    this.jdField_a_of_type_ComTencentMobileqqVasWallpaperPresenterDrawWallpaperPresenter.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper
 * JD-Core Version:    0.7.0.1
 */