package com.tencent.mobileqq.vas.wallpaper;

import android.app.WallpaperColors;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.SurfaceHolder;
import aorj;
import aork;
import bdpr;
import bdrw;
import bdss;
import bdst;
import bdsv;
import bdsx;
import bdsy;
import bdta;
import bdtd;
import bdte;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class WallpaperHelper
{
  private bdss jdField_a_of_type_Bdss;
  private bdsx jdField_a_of_type_Bdsx;
  private bdta jdField_a_of_type_Bdta;
  private WallpaperHelper.ReTryRunnable jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable = new WallpaperHelper.ReTryRunnable(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private bdsv a(bdsx parambdsx, bdss parambdss)
  {
    Object localObject2 = new File(parambdss.b);
    QLog.i("VipWallpaper", 1, "use " + parambdss.toString() + " imgFile exists = " + ((File)localObject2).exists());
    Object localObject1;
    bdpr localbdpr;
    if (!parambdss.a.equals("0")) {
      if ((aork.c().a()) && (parambdsx.a()))
      {
        localObject1 = bdrw.a().a(parambdss.c);
        if ((localObject1 == null) && (ChatBackgroundManager.b((File)localObject2))) {
          if (!this.b)
          {
            localbdpr = bdpr.a();
            if (localbdpr.isLoaded()) {
              this.b = true;
            }
          }
          else
          {
            if (!this.b) {
              break label365;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new ApngDrawable((File)localObject2, null);
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          try
          {
            ((ApngDrawable)localObject2).getImage().setSupportGlobalPasued(false);
            localObject1 = localObject2;
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = localObject1;
              if (aork.c().b())
              {
                localObject2 = localObject1;
                if (parambdsx.a()) {
                  localObject2 = bdrw.a().a(parambdss.b, new Handler(ThreadManagerV2.getFileThreadLooper()), false);
                }
              }
            }
            if (localObject2 != null) {
              continue;
            }
          }
          catch (Throwable localThrowable2)
          {
            localObject1 = localObject2;
            continue;
            continue;
            parambdsx = (bdsx)localObject2;
            continue;
          }
          try
          {
            parambdsx = BitmapFactory.decodeFile(parambdss.b);
            if (parambdsx != null)
            {
              parambdsx = new BitmapDrawable(parambdsx);
              if (parambdsx == null)
              {
                parambdsx = VipWallpaperService.a();
                if (parambdsx != null)
                {
                  QLog.i("VipWallpaper", 1, "use " + parambdsx.getClass().getName());
                  return new bdsy(parambdsx);
                  if (!localbdpr.a()) {
                    break;
                  }
                  this.b = localbdpr.b();
                  break;
                  localThrowable1 = localThrowable1;
                  localThrowable1.printStackTrace();
                }
              }
            }
          }
          catch (Throwable parambdsx)
          {
            parambdsx.printStackTrace();
            parambdsx = null;
            continue;
            QLog.i("VipWallpaper", 1, "drawable error");
            return null;
          }
        }
      }
      label365:
      continue;
      localObject1 = null;
      break;
      parambdsx = null;
    }
  }
  
  private bdsx a(SurfaceHolder paramSurfaceHolder)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return new bdte(paramSurfaceHolder);
    }
    return new bdtd(paramSurfaceHolder);
  }
  
  private void a(bdss parambdss, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.jdField_a_of_type_Bdss = null;
        }
      } while (parambdss.equals(this.jdField_a_of_type_Bdss));
      b();
      bdsv localbdsv = a(this.jdField_a_of_type_Bdsx, parambdss);
      if (localbdsv != null)
      {
        this.jdField_a_of_type_Bdta = new bdta(localbdsv, this.jdField_a_of_type_Bdsx);
        this.jdField_a_of_type_Bdta.a();
        this.jdField_a_of_type_Bdss = parambdss;
        return;
      }
      this.jdField_a_of_type_Bdss = null;
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.a(parambdss);
    } while (!paramBoolean);
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable, 3000L);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bdta != null)
    {
      this.jdField_a_of_type_Bdta.d();
      this.jdField_a_of_type_Bdta = null;
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
    this.jdField_a_of_type_Bdsx = a(paramSurfaceHolder);
    paramContext = VipWallpaperService.a(paramContext);
    paramContext.registerOnSharedPreferenceChangeListener(new bdst(this));
    a(VipWallpaperService.a(paramContext), true);
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Bdta != null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Bdta.a(paramInt2, paramInt3);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bdta == null)
    {
      if (paramBoolean)
      {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
        ThreadManagerV2.getUIHandlerV2().post(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
      }
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bdta.b();
      return;
    }
    this.jdField_a_of_type_Bdta.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper
 * JD-Core Version:    0.7.0.1
 */