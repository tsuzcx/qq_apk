package com.tencent.mobileqq.vas.wallpaper;

import achl;
import android.app.WallpaperColors;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import aqhx;
import aqhy;
import bgha;
import bgio;
import bgks;
import bgkt;
import bgku;
import bgkw;
import bgky;
import bgkz;
import bglb;
import bgle;
import bglf;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.jvm.functions.Function0;

public final class WallpaperHelper
{
  private bgks jdField_a_of_type_Bgks;
  private bgky jdField_a_of_type_Bgky;
  private bglb jdField_a_of_type_Bglb;
  private WallpaperHelper.ReTryRunnable jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable = new WallpaperHelper.ReTryRunnable(this);
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private bgkw a(bgky parambgky, bgks parambgks)
  {
    this.jdField_a_of_type_JavaLangString = null;
    Object localObject = new File(parambgks.b);
    QLog.i("VipWallpaper", 1, "use " + parambgks.toString() + " imgFile exists = " + ((File)localObject).exists());
    if (!parambgks.jdField_a_of_type_JavaLangString.equals("0"))
    {
      localObject = new bgkt(this, parambgky, parambgks, (File)localObject);
      if ((aqhy.c().a()) && (parambgky.a()))
      {
        parambgky = new File(parambgks.b.replace("aioImage", "aio_bg.mp4"));
        if (parambgky.exists())
        {
          parambgks = bgio.a().a(parambgky, true, (Function0)localObject);
          this.jdField_a_of_type_JavaLangString = "wallpaper-video";
          parambgky = parambgks;
          if (parambgks != null) {}
        }
      }
    }
    for (parambgky = (Drawable)((Function0)localObject).invoke();; parambgky = null)
    {
      if (parambgky == null) {
        parambgky = VipWallpaperService.a();
      }
      for (;;)
      {
        if (parambgky != null)
        {
          QLog.i("VipWallpaper", 1, "use " + parambgky.getClass().getName());
          return new bgkz(parambgky);
        }
        QLog.i("VipWallpaper", 1, "drawable error");
        return null;
      }
      parambgks = null;
      break;
    }
  }
  
  private bgky a(SurfaceHolder paramSurfaceHolder)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return new bglf(paramSurfaceHolder);
    }
    return new bgle(paramSurfaceHolder);
  }
  
  private void a(bgks parambgks, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.jdField_a_of_type_Bgks = null;
        }
      } while (parambgks.equals(this.jdField_a_of_type_Bgks));
      b();
      bgkw localbgkw = a(this.jdField_a_of_type_Bgky, parambgks);
      if (localbgkw != null)
      {
        this.jdField_a_of_type_Bglb = new bglb(localbgkw, this.jdField_a_of_type_Bgky);
        this.jdField_a_of_type_Bglb.a();
        this.jdField_a_of_type_Bgks = parambgks;
        return;
      }
      this.jdField_a_of_type_Bgks = null;
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.a(parambgks);
    } while (!paramBoolean);
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable, 3000L);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bglb != null)
    {
      this.jdField_a_of_type_Bglb.d();
      this.jdField_a_of_type_Bglb = null;
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
    this.jdField_a_of_type_Bgky = a(paramSurfaceHolder);
    paramContext = VipWallpaperService.a(paramContext);
    paramContext.registerOnSharedPreferenceChangeListener(new bgku(this));
    a(VipWallpaperService.a(paramContext), true);
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Bglb != null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Bglb.a(paramInt2, paramInt3);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bglb == null) {
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
        this.jdField_a_of_type_Bglb.b();
      } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!bgha.a()));
      QAPM.setAbFactor("壁纸服务", this.jdField_a_of_type_JavaLangString, achl.class);
    } while (!QLog.isColorLevel());
    QLog.d("VipWallpaper", 2, "wallpaperType=" + this.jdField_a_of_type_JavaLangString);
    return;
    this.jdField_a_of_type_Bglb.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper
 * JD-Core Version:    0.7.0.1
 */