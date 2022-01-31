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
import aovs;
import aovt;
import bdua;
import bdwf;
import bdxb;
import bdxc;
import bdxe;
import bdxg;
import bdxh;
import bdxj;
import bdxm;
import bdxn;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class WallpaperHelper
{
  private bdxb jdField_a_of_type_Bdxb;
  private bdxg jdField_a_of_type_Bdxg;
  private bdxj jdField_a_of_type_Bdxj;
  private WallpaperHelper.ReTryRunnable jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable = new WallpaperHelper.ReTryRunnable(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private bdxe a(bdxg parambdxg, bdxb parambdxb)
  {
    Object localObject2 = new File(parambdxb.b);
    QLog.i("VipWallpaper", 1, "use " + parambdxb.toString() + " imgFile exists = " + ((File)localObject2).exists());
    Object localObject1;
    bdua localbdua;
    if (!parambdxb.a.equals("0")) {
      if ((aovt.c().a()) && (parambdxg.a()))
      {
        localObject1 = bdwf.a().a(parambdxb.c);
        if ((localObject1 == null) && (ChatBackgroundManager.b((File)localObject2))) {
          if (!this.b)
          {
            localbdua = bdua.a();
            if (localbdua.isLoaded()) {
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
              if (aovt.c().b())
              {
                localObject2 = localObject1;
                if (parambdxg.a()) {
                  localObject2 = bdwf.a().a(parambdxb.b, new Handler(ThreadManagerV2.getFileThreadLooper()), false);
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
            parambdxg = (bdxg)localObject2;
            continue;
          }
          try
          {
            parambdxg = BitmapFactory.decodeFile(parambdxb.b);
            if (parambdxg != null)
            {
              parambdxg = new BitmapDrawable(parambdxg);
              if (parambdxg == null)
              {
                parambdxg = VipWallpaperService.a();
                if (parambdxg != null)
                {
                  QLog.i("VipWallpaper", 1, "use " + parambdxg.getClass().getName());
                  return new bdxh(parambdxg);
                  if (!localbdua.a()) {
                    break;
                  }
                  this.b = localbdua.b();
                  break;
                  localThrowable1 = localThrowable1;
                  localThrowable1.printStackTrace();
                }
              }
            }
          }
          catch (Throwable parambdxg)
          {
            parambdxg.printStackTrace();
            parambdxg = null;
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
      parambdxg = null;
    }
  }
  
  private bdxg a(SurfaceHolder paramSurfaceHolder)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return new bdxn(paramSurfaceHolder);
    }
    return new bdxm(paramSurfaceHolder);
  }
  
  private void a(bdxb parambdxb, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.jdField_a_of_type_Bdxb = null;
        }
      } while (parambdxb.equals(this.jdField_a_of_type_Bdxb));
      b();
      bdxe localbdxe = a(this.jdField_a_of_type_Bdxg, parambdxb);
      if (localbdxe != null)
      {
        this.jdField_a_of_type_Bdxj = new bdxj(localbdxe, this.jdField_a_of_type_Bdxg);
        this.jdField_a_of_type_Bdxj.a();
        this.jdField_a_of_type_Bdxb = parambdxb;
        return;
      }
      this.jdField_a_of_type_Bdxb = null;
      this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable.a(parambdxb);
    } while (!paramBoolean);
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable);
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper$ReTryRunnable, 3000L);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bdxj != null)
    {
      this.jdField_a_of_type_Bdxj.d();
      this.jdField_a_of_type_Bdxj = null;
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
    this.jdField_a_of_type_Bdxg = a(paramSurfaceHolder);
    paramContext = VipWallpaperService.a(paramContext);
    paramContext.registerOnSharedPreferenceChangeListener(new bdxc(this));
    a(VipWallpaperService.a(paramContext), true);
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Bdxj != null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Bdxj.a(paramInt2, paramInt3);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bdxj == null)
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
      this.jdField_a_of_type_Bdxj.b();
      return;
    }
    this.jdField_a_of_type_Bdxj.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper
 * JD-Core Version:    0.7.0.1
 */