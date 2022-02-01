package com.tencent.mobileqq.vas.wallpaper;

import android.app.WallpaperColors;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.tencent.android.gldrawable.api.AutoEtcOptions;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IFactoryStub;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
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
import org.jetbrains.annotations.Nullable;

public final class WallpaperHelper
{
  private boolean a = false;
  private DrawWallpaperPresenter b = null;
  private DrawWallpaperContract.View c = null;
  private VipWallpaperService.WallpaperConfig d = null;
  private boolean e = false;
  private String f = "";
  private WallpaperHelper.ReTryRunnable g = new WallpaperHelper.ReTryRunnable(this);
  
  @Nullable
  private Drawable a(DrawWallpaperContract.View paramView, VipWallpaperService.WallpaperConfig paramWallpaperConfig, File paramFile)
  {
    boolean bool = QVipSDKProcessor.e().c();
    Object localObject = null;
    if ((bool) && (paramView.a()))
    {
      paramView = new AutoEtcOptions();
      paramView.setFilePath(paramWallpaperConfig.b);
      IGLDrawable localIGLDrawable = GLDrawableApi.factory().setWorkHandler(new Handler(ThreadManagerV2.getFileThreadLooper())).useCache(false).fromBundle(paramView.toBundle());
      paramView = localIGLDrawable;
      if ((localIGLDrawable instanceof IGLDrawable))
      {
        this.f = "wallpaper-aetc";
        paramView = localIGLDrawable;
      }
    }
    else
    {
      paramView = null;
    }
    paramFile = a(paramFile, paramView);
    paramView = paramFile;
    if (paramFile == null)
    {
      try
      {
        paramWallpaperConfig = BitmapFactory.decodeFile(paramWallpaperConfig.b);
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
        paramWallpaperConfig = localObject;
      }
      paramView = paramFile;
      if (paramWallpaperConfig != null)
      {
        paramView = new BitmapDrawable(paramWallpaperConfig);
        this.f = "wallpaper-static";
      }
    }
    return paramView;
  }
  
  @Nullable
  private Drawable a(File paramFile, Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    Drawable localDrawable;
    if (paramDrawable == null)
    {
      localObject = paramDrawable;
      if (ChatBackgroundManager.b(paramFile))
      {
        if (!this.e)
        {
          localObject = VasApngIPCModule.a();
          if (((VasApngIPCModule)localObject).isLoaded()) {
            this.e = true;
          } else if (((VasApngIPCModule)localObject).d()) {
            this.e = ((VasApngIPCModule)localObject).e();
          }
        }
        localObject = paramDrawable;
        if (this.e)
        {
          try
          {
            paramFile = new ApngDrawable(paramFile, null);
            try
            {
              ((ApngDrawable)paramFile).getImage().setSupportGlobalPasued(false);
              this.f = "wallpaper-apng";
              return paramFile;
            }
            catch (Throwable localThrowable)
            {
              paramDrawable = paramFile;
              paramFile = localThrowable;
            }
            paramFile.printStackTrace();
          }
          catch (Throwable paramFile) {}
          localDrawable = paramDrawable;
        }
      }
    }
    return localDrawable;
  }
  
  private DrawWallpaperContract.Model a(DrawWallpaperContract.View paramView, VipWallpaperService.WallpaperConfig paramWallpaperConfig)
  {
    this.f = null;
    Object localObject = new File(paramWallpaperConfig.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("use ");
    localStringBuilder.append(paramWallpaperConfig.toString());
    localStringBuilder.append(" imgFile exists = ");
    localStringBuilder.append(((File)localObject).exists());
    QLog.i("VipWallpaper", 1, localStringBuilder.toString());
    if (!paramWallpaperConfig.a.equals("0"))
    {
      localObject = new WallpaperHelper.1(this, paramView, paramWallpaperConfig, (File)localObject);
      if ((QVipSDKProcessor.e().a()) && (paramView.a()))
      {
        paramView = new File(paramWallpaperConfig.b.replace("aioImage", "aio_bg.mp4"));
        if (paramView.exists())
        {
          paramWallpaperConfig = GLDrawableApi.asyncFactory((Function0)localObject, new WallpaperHelper.2(this, paramView));
          this.f = "wallpaper-video";
          break label166;
        }
      }
      paramWallpaperConfig = null;
      label166:
      paramView = paramWallpaperConfig;
      if (paramWallpaperConfig == null) {
        paramView = (Drawable)((Function0)localObject).invoke();
      }
    }
    else
    {
      paramView = null;
    }
    paramWallpaperConfig = paramView;
    if (paramView == null) {
      paramWallpaperConfig = VipWallpaperService.a();
    }
    if (paramWallpaperConfig != null)
    {
      paramView = new StringBuilder();
      paramView.append("use ");
      paramView.append(paramWallpaperConfig.getClass().getName());
      QLog.i("VipWallpaper", 1, paramView.toString());
      return new DrawDrawableWallpaperModel(paramWallpaperConfig);
    }
    QLog.i("VipWallpaper", 1, "drawable error");
    return null;
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
    if (this.a) {
      return;
    }
    if (paramBoolean) {
      this.g.b = null;
    }
    if (!paramWallpaperConfig.equals(this.d))
    {
      c();
      DrawWallpaperContract.Model localModel = a(this.c, paramWallpaperConfig);
      if (localModel != null)
      {
        this.b = new DrawWallpaperPresenter(localModel, this.c);
        this.b.a();
        this.d = paramWallpaperConfig;
        return;
      }
      this.d = null;
      this.g.a(paramWallpaperConfig);
      if (paramBoolean)
      {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.g);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.g, 3000L);
      }
    }
  }
  
  private void c()
  {
    DrawWallpaperPresenter localDrawWallpaperPresenter = this.b;
    if (localDrawWallpaperPresenter != null)
    {
      localDrawWallpaperPresenter.d();
      this.b = null;
    }
  }
  
  protected void a()
  {
    c();
    this.a = true;
  }
  
  protected void a(Context paramContext, SurfaceHolder paramSurfaceHolder)
  {
    this.a = false;
    this.c = a(paramSurfaceHolder);
    paramContext = VipWallpaperService.a(paramContext);
    paramContext.registerOnSharedPreferenceChangeListener(new WallpaperHelper.ConfigChangeListener(this));
    a(VipWallpaperService.a(paramContext), true);
  }
  
  protected void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    paramSurfaceHolder = this.b;
    if ((paramSurfaceHolder != null) && (!this.a)) {
      paramSurfaceHolder.a(paramInt2, paramInt3);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      if (paramBoolean)
      {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.g);
        ThreadManagerV2.getUIHandlerV2().post(this.g);
      }
      return;
    }
    if (paramBoolean)
    {
      ((DrawWallpaperPresenter)localObject).b();
      if ((!TextUtils.isEmpty(this.f)) && (VasStatisticCollector.a()))
      {
        AbProxy.setAbFactor("壁纸服务", this.f, AbFactorProfileCardBg.class);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("wallpaperType=");
          ((StringBuilder)localObject).append(this.f);
          QLog.d("VipWallpaper", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    else
    {
      ((DrawWallpaperPresenter)localObject).c();
    }
  }
  
  protected WallpaperColors b()
  {
    if (Build.VERSION.SDK_INT >= 27)
    {
      Color localColor = Color.valueOf(Color.parseColor("#ff000000"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onComputeColors ");
      localStringBuilder.append(localColor.toString());
      QLog.i("VipWallpaper", 1, localStringBuilder.toString());
      return new WallpaperColors(localColor, localColor, localColor);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper
 * JD-Core Version:    0.7.0.1
 */