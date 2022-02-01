package com.tencent.mobileqq.vas.wallpaper;

import acxt;
import android.app.WallpaperColors;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import arlh;
import arli;
import bhpu;
import bhrj;
import bhvc;
import bhvd;
import bhve;
import bhvg;
import bhvi;
import bhvj;
import bhvl;
import bhvo;
import bhvp;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qapmsdk.base.reporter.ab.AbProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.jvm.functions.Function0;

public final class WallpaperHelper
{
  private bhvc jdField_a_of_type_Bhvc;
  private bhvi jdField_a_of_type_Bhvi;
  private bhvl jdField_a_of_type_Bhvl;
  private WallpaperHelper.ReTryRunnable jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable = new WallpaperHelper.ReTryRunnable(this);
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private bhvg a(bhvi parambhvi, bhvc parambhvc)
  {
    this.jdField_a_of_type_JavaLangString = null;
    Object localObject = new File(parambhvc.b);
    QLog.i("VipWallpaper", 1, "use " + parambhvc.toString() + " imgFile exists = " + ((File)localObject).exists());
    if (!parambhvc.jdField_a_of_type_JavaLangString.equals("0"))
    {
      localObject = new bhvd(this, parambhvi, parambhvc, (File)localObject);
      if ((arli.c().a()) && (parambhvi.a()))
      {
        parambhvi = new File(parambhvc.b.replace("aioImage", "aio_bg.mp4"));
        if (parambhvi.exists())
        {
          parambhvc = bhrj.a().a(parambhvi, true, (Function0)localObject);
          this.jdField_a_of_type_JavaLangString = "wallpaper-video";
          parambhvi = parambhvc;
          if (parambhvc != null) {}
        }
      }
    }
    for (parambhvi = (Drawable)((Function0)localObject).invoke();; parambhvi = null)
    {
      if (parambhvi == null) {
        parambhvi = VipWallpaperService.a();
      }
      for (;;)
      {
        if (parambhvi != null)
        {
          QLog.i("VipWallpaper", 1, "use " + parambhvi.getClass().getName());
          return new bhvj(parambhvi);
        }
        QLog.i("VipWallpaper", 1, "drawable error");
        return null;
      }
      parambhvc = null;
      break;
    }
  }
  
  private bhvi a(SurfaceHolder paramSurfaceHolder)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return new bhvp(paramSurfaceHolder);
    }
    return new bhvo(paramSurfaceHolder);
  }
  
  private void a(bhvc parambhvc, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.jdField_a_of_type_Bhvc = null;
        }
      } while (parambhvc.equals(this.jdField_a_of_type_Bhvc));
      b();
      bhvg localbhvg = a(this.jdField_a_of_type_Bhvi, parambhvc);
      if (localbhvg != null)
      {
        this.jdField_a_of_type_Bhvl = new bhvl(localbhvg, this.jdField_a_of_type_Bhvi);
        this.jdField_a_of_type_Bhvl.a();
        this.jdField_a_of_type_Bhvc = parambhvc;
        return;
      }
      this.jdField_a_of_type_Bhvc = null;
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.a(parambhvc);
    } while (!paramBoolean);
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable, 3000L);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bhvl != null)
    {
      this.jdField_a_of_type_Bhvl.d();
      this.jdField_a_of_type_Bhvl = null;
    }
  }
  
  public WallpaperColors a()
  {
    if (Build.VERSION.SDK_INT >= 27)
    {
      Color localColor = Color.valueOf(Color.parseColor("#ff000000"));
      QLog.i("VipWallpaper", 1, "onComputeColors " + localColor.toString());
      return new WallpaperColors(localColor, localColor, localColor);
    }
    return null;
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(Context paramContext, SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bhvi = a(paramSurfaceHolder);
    paramContext = VipWallpaperService.a(paramContext);
    paramContext.registerOnSharedPreferenceChangeListener(new bhve(this));
    a(VipWallpaperService.a(paramContext), true);
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Bhvl != null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Bhvl.a(paramInt2, paramInt3);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bhvl == null) {
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
        this.jdField_a_of_type_Bhvl.b();
      } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!bhpu.a()));
      AbProxy.setAbFactor("壁纸服务", this.jdField_a_of_type_JavaLangString, acxt.class);
    } while (!QLog.isColorLevel());
    QLog.d("VipWallpaper", 2, "wallpaperType=" + this.jdField_a_of_type_JavaLangString);
    return;
    this.jdField_a_of_type_Bhvl.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper
 * JD-Core Version:    0.7.0.1
 */