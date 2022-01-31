package com.tencent.mobileqq.shortvideo.filter;

import aibi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.lowlight.LowLightTools;
import com.tencent.mobileqq.shortvideo.resource.LowLightResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.DpcSwitcher;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class QQLowLightFilter
  extends QQBaseFilter
{
  public static String a;
  public static String b;
  private static boolean b;
  public static int e;
  private static int h;
  private static int i;
  private static int j;
  private static int k;
  private DenoiseRender jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = null;
  private LowLightRender jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int f = 0;
  private int g = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = SdkContext.a().a().a().a() + "capture_qsvf" + File.separator + "lowlight";
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + File.separator + "LowLight.png";
    e = 0;
    h = 2;
    i = 1;
    j = -1;
    k = 0;
    jdField_b_of_type_Boolean = false;
  }
  
  public QQLowLightFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(10, paramQQFilterRenderManager);
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = null;
    }
  }
  
  public static boolean b()
  {
    boolean bool = false;
    if (e == k) {
      i();
    }
    if (e == h) {
      bool = true;
    }
    return bool;
  }
  
  private static void c()
  {
    File localFile = new File(jdField_b_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      Object localObject = LowLightTools.getLowLightImage(3.0F, 0.88F, 0.96F, 1.22F, false);
      try
      {
        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile));
        ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 100, localBufferedOutputStream);
        localBufferedOutputStream.flush();
        localBufferedOutputStream.close();
        if (!localFile.exists())
        {
          e = j;
          return;
          localObject = localFile.getParentFile();
          if (((File)localObject).exists()) {
            continue;
          }
          ((File)localObject).mkdirs();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          SLog.b("QQLowLightFilter", "LowLightTools saveBitmap:" + localException);
        }
        e = h;
      }
    }
  }
  
  public static boolean c()
  {
    return e == j;
  }
  
  private static void i()
  {
    if (!new File(jdField_b_of_type_JavaLangString).exists())
    {
      e = i;
      new Thread(new aibi()).start();
      return;
    }
    e = h;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.g != paramInt1) || (this.g != paramInt2)) {
      b();
    }
  }
  
  public void e()
  {
    b();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender == null)
    {
      if (!b()) {
        break label207;
      }
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = new LowLightRender(SdkContext.a().a(), jdField_a_of_type_JavaLangString);
      if (SLog.a()) {
        SLog.d("lowlightRender_time", "小太阳耗时 create with res");
      }
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender == null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = new DenoiseRender(SdkContext.a().a());
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.setUpdateRate(15.0F);
    }
    this.f = a().f();
    this.g = a().g();
    if ((jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender != null))
    {
      if ((SdkContext.a().a().c()) && (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender != null))
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.process(this.jdField_a_of_type_Int, -1, this.f, this.g).getTextureId();
        QQFilterLogManager.a("QQDeNoiseFilter", true);
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender.process(this.jdField_a_of_type_Int, -1, this.f, this.g).getTextureId();
        QQFilterLogManager.a("QQLowLightFilter", true);
        this.jdField_a_of_type_Boolean = true;
        return;
        label207:
        if (c())
        {
          this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = new LowLightRender(SdkContext.a().a());
          if (!SLog.a()) {
            break;
          }
          SLog.d("lowlightRender_time", "小太阳耗时 create without res");
          break;
        }
        if (!SLog.a()) {
          break;
        }
        SLog.d("lowlightRender_time", "小太阳耗时 create wait");
        break;
        QQFilterLogManager.a("QQDeNoiseFilter", false);
      }
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    QQFilterLogManager.a("QQLowLightFilter", false);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean i_()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter
 * JD-Core Version:    0.7.0.1
 */