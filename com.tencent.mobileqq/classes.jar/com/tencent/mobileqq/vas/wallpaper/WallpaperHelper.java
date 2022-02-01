package com.tencent.mobileqq.vas.wallpaper;

import adkr;
import android.app.WallpaperColors;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import arnz;
import aroa;
import biaq;
import bicd;
import bieh;
import biei;
import biej;
import biel;
import bien;
import bieo;
import bieq;
import biet;
import bieu;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.jvm.functions.Function0;

public final class WallpaperHelper
{
  private bieh jdField_a_of_type_Bieh;
  private bien jdField_a_of_type_Bien;
  private bieq jdField_a_of_type_Bieq;
  private WallpaperHelper.ReTryRunnable jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable = new WallpaperHelper.ReTryRunnable(this);
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private biel a(bien parambien, bieh parambieh)
  {
    this.jdField_a_of_type_JavaLangString = null;
    Object localObject = new File(parambieh.b);
    QLog.i("VipWallpaper", 1, "use " + parambieh.toString() + " imgFile exists = " + ((File)localObject).exists());
    if (!parambieh.jdField_a_of_type_JavaLangString.equals("0"))
    {
      localObject = new biei(this, parambien, parambieh, (File)localObject);
      if ((aroa.c().a()) && (parambien.a()))
      {
        parambien = new File(parambieh.b.replace("aioImage", "aio_bg.mp4"));
        if (parambien.exists())
        {
          parambieh = bicd.a().a(parambien, true, (Function0)localObject);
          this.jdField_a_of_type_JavaLangString = "wallpaper-video";
          parambien = parambieh;
          if (parambieh != null) {}
        }
      }
    }
    for (parambien = (Drawable)((Function0)localObject).invoke();; parambien = null)
    {
      if (parambien == null) {
        parambien = VipWallpaperService.a();
      }
      for (;;)
      {
        if (parambien != null)
        {
          QLog.i("VipWallpaper", 1, "use " + parambien.getClass().getName());
          return new bieo(parambien);
        }
        QLog.i("VipWallpaper", 1, "drawable error");
        return null;
      }
      parambieh = null;
      break;
    }
  }
  
  private bien a(SurfaceHolder paramSurfaceHolder)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return new bieu(paramSurfaceHolder);
    }
    return new biet(paramSurfaceHolder);
  }
  
  private void a(bieh parambieh, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.jdField_a_of_type_Bieh = null;
        }
      } while (parambieh.equals(this.jdField_a_of_type_Bieh));
      b();
      biel localbiel = a(this.jdField_a_of_type_Bien, parambieh);
      if (localbiel != null)
      {
        this.jdField_a_of_type_Bieq = new bieq(localbiel, this.jdField_a_of_type_Bien);
        this.jdField_a_of_type_Bieq.a();
        this.jdField_a_of_type_Bieh = parambieh;
        return;
      }
      this.jdField_a_of_type_Bieh = null;
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.a(parambieh);
    } while (!paramBoolean);
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable, 3000L);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bieq != null)
    {
      this.jdField_a_of_type_Bieq.d();
      this.jdField_a_of_type_Bieq = null;
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
    this.jdField_a_of_type_Bien = a(paramSurfaceHolder);
    paramContext = VipWallpaperService.a(paramContext);
    paramContext.registerOnSharedPreferenceChangeListener(new biej(this));
    a(VipWallpaperService.a(paramContext), true);
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Bieq != null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Bieq.a(paramInt2, paramInt3);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bieq == null) {
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
        this.jdField_a_of_type_Bieq.b();
      } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!biaq.a()));
      QAPM.setAbFactor("壁纸服务", this.jdField_a_of_type_JavaLangString, adkr.class);
    } while (!QLog.isColorLevel());
    QLog.d("VipWallpaper", 2, "wallpaperType=" + this.jdField_a_of_type_JavaLangString);
    return;
    this.jdField_a_of_type_Bieq.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper
 * JD-Core Version:    0.7.0.1
 */