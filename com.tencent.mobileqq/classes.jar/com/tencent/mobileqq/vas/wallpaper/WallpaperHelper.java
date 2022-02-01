package com.tencent.mobileqq.vas.wallpaper;

import adbt;
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
import aqyi;
import aqyj;
import bgzd;
import bhak;
import bhbt;
import bhdx;
import bhdy;
import bhea;
import bhec;
import bhed;
import bhef;
import bhei;
import bhej;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class WallpaperHelper
{
  private bhdx jdField_a_of_type_Bhdx;
  private bhec jdField_a_of_type_Bhec;
  private bhef jdField_a_of_type_Bhef;
  private WallpaperHelper.ReTryRunnable jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable = new WallpaperHelper.ReTryRunnable(this);
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private bhea a(bhec parambhec, bhdx parambhdx)
  {
    this.jdField_a_of_type_JavaLangString = null;
    File localFile = new File(parambhdx.b);
    QLog.i("VipWallpaper", 1, "use " + parambhdx.toString() + " imgFile exists = " + localFile.exists());
    Object localObject1;
    if (!parambhdx.jdField_a_of_type_JavaLangString.equals("0")) {
      if ((aqyj.c().a()) && (parambhec.a()))
      {
        Drawable localDrawable = bhbt.a().a(new File(parambhdx.c), true);
        this.jdField_a_of_type_JavaLangString = "wallpaper-video";
        localObject1 = localDrawable;
        if (localDrawable == null)
        {
          localObject1 = localDrawable;
          if (aqyj.c().c())
          {
            localObject1 = localDrawable;
            if (parambhec.a())
            {
              parambhec = bhbt.a().a(parambhdx.b, new Handler(ThreadManagerV2.getFileThreadLooper()), false);
              localObject1 = parambhec;
              if (bhbt.c(parambhec))
              {
                this.jdField_a_of_type_JavaLangString = "wallpaper-aetc";
                localObject1 = parambhec;
              }
            }
          }
        }
        if ((localObject1 == null) && (ChatBackgroundManager.b(localFile))) {
          if (!this.b)
          {
            parambhec = bgzd.a();
            if (parambhec.isLoaded()) {
              this.b = true;
            }
          }
          else
          {
            if (!this.b) {
              break label401;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        parambhec = new ApngDrawable(localFile, null);
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          try
          {
            ((ApngDrawable)parambhec).getImage().setSupportGlobalPasued(false);
            this.jdField_a_of_type_JavaLangString = "wallpaper-apng";
            if (parambhec != null) {
              continue;
            }
          }
          catch (Throwable localThrowable1)
          {
            continue;
            continue;
            continue;
          }
          try
          {
            parambhdx = BitmapFactory.decodeFile(parambhdx.b);
            if (parambhdx != null)
            {
              parambhec = new BitmapDrawable(parambhdx);
              this.jdField_a_of_type_JavaLangString = "wallpaper-static";
              if (parambhec == null)
              {
                parambhec = VipWallpaperService.a();
                if (parambhec != null)
                {
                  QLog.i("VipWallpaper", 1, "use " + parambhec.getClass().getName());
                  return new bhed(parambhec);
                  if (!parambhec.a()) {
                    break;
                  }
                  this.b = parambhec.b();
                  break;
                  localThrowable2 = localThrowable2;
                  parambhec = (bhec)localObject1;
                  localObject1 = localThrowable2;
                  ((Throwable)localObject1).printStackTrace();
                }
              }
            }
          }
          catch (Throwable parambhdx)
          {
            parambhdx.printStackTrace();
            parambhdx = null;
            continue;
            QLog.i("VipWallpaper", 1, "drawable error");
            return null;
          }
        }
      }
      label401:
      parambhec = localThrowable1;
      continue;
      Object localObject2 = null;
      break;
      parambhec = null;
    }
  }
  
  private bhec a(SurfaceHolder paramSurfaceHolder)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return new bhej(paramSurfaceHolder);
    }
    return new bhei(paramSurfaceHolder);
  }
  
  private void a(bhdx parambhdx, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.jdField_a_of_type_Bhdx = null;
        }
      } while (parambhdx.equals(this.jdField_a_of_type_Bhdx));
      b();
      bhea localbhea = a(this.jdField_a_of_type_Bhec, parambhdx);
      if (localbhea != null)
      {
        this.jdField_a_of_type_Bhef = new bhef(localbhea, this.jdField_a_of_type_Bhec);
        this.jdField_a_of_type_Bhef.a();
        this.jdField_a_of_type_Bhdx = parambhdx;
        return;
      }
      this.jdField_a_of_type_Bhdx = null;
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.a(parambhdx);
    } while (!paramBoolean);
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable, 3000L);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bhef != null)
    {
      this.jdField_a_of_type_Bhef.d();
      this.jdField_a_of_type_Bhef = null;
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
    this.jdField_a_of_type_Bhec = a(paramSurfaceHolder);
    paramContext = VipWallpaperService.a(paramContext);
    paramContext.registerOnSharedPreferenceChangeListener(new bhdy(this));
    a(VipWallpaperService.a(paramContext), true);
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Bhef != null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Bhef.a(paramInt2, paramInt3);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bhef == null) {
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
        this.jdField_a_of_type_Bhef.b();
      } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!bhak.a()));
      QAPM.setAbFactor("壁纸服务", this.jdField_a_of_type_JavaLangString, adbt.class);
    } while (!QLog.isColorLevel());
    QLog.d("VipWallpaper", 2, "wallpaperType=" + this.jdField_a_of_type_JavaLangString);
    return;
    this.jdField_a_of_type_Bhef.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper
 * JD-Core Version:    0.7.0.1
 */