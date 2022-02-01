package com.tencent.mobileqq.shortvideo.filter;

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
  private static final int DEFAULT_FBO = -1;
  private static int ResExist = 0;
  private static int ResFailed = -1;
  private static int ResGenerating = 0;
  private static int ResUncheck = 0;
  private static final String TAG = "QQLowLightFilter";
  private static boolean enableNightMode = false;
  public static String lowLightDir = SdkContext.getInstance().getResources().getLowLightResource().getLowLightDir() + "capture_qsvf" + File.separator + "lowlight";
  public static String lowLightPath = lowLightDir + File.separator + "LowLight.png";
  public static int mLowLightResStatus = 0;
  private boolean bwork = false;
  private int lastHeight = 0;
  private int lastWidth = 0;
  private DenoiseRender mDenoiseRender = null;
  private LowLightRender mLowLightRender = null;
  
  static
  {
    ResExist = 2;
    ResGenerating = 1;
  }
  
  public QQLowLightFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(10, paramQQFilterRenderManager);
  }
  
  private static void CheckLowLightRes()
  {
    if (!new File(lowLightPath).exists())
    {
      mLowLightResStatus = ResGenerating;
      new Thread(new QQLowLightFilter.1(), "ShortVideoEffect_LowLightThread").start();
      return;
    }
    mLowLightResStatus = ResExist;
  }
  
  public static boolean bResCheckedFailed()
  {
    return mLowLightResStatus == ResFailed;
  }
  
  public static boolean bResReady()
  {
    boolean bool = false;
    if (mLowLightResStatus == ResUncheck) {
      CheckLowLightRes();
    }
    if (mLowLightResStatus == ResExist) {
      bool = true;
    }
    return bool;
  }
  
  private void destroyRender()
  {
    if (this.mLowLightRender != null)
    {
      this.mLowLightRender.destroy();
      this.mLowLightRender = null;
    }
    if (this.mDenoiseRender != null)
    {
      this.mDenoiseRender.destroy();
      this.mDenoiseRender = null;
    }
  }
  
  public static void enableNightMode(boolean paramBoolean)
  {
    enableNightMode = paramBoolean;
  }
  
  private static void generateLowlightRes()
  {
    File localFile = new File(lowLightPath);
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
          mLowLightResStatus = ResFailed;
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
          SLog.w("QQLowLightFilter", "LowLightTools saveBitmap:" + localException);
        }
        mLowLightResStatus = ResExist;
      }
    }
  }
  
  public boolean isFilterWork()
  {
    return this.bwork;
  }
  
  public void onDrawFrame()
  {
    if (this.mLowLightRender == null)
    {
      if (!bResReady()) {
        break label208;
      }
      this.mLowLightRender = new LowLightRender(SdkContext.getInstance().getApplication(), lowLightDir);
      if (SLog.isEnable()) {
        SLog.d("lowlightRender_time", "小太阳耗时 create with res");
      }
    }
    if (this.mDenoiseRender == null)
    {
      this.mDenoiseRender = new DenoiseRender(SdkContext.getInstance().getApplication());
      this.mDenoiseRender.setUpdateRate(15.0F);
    }
    this.lastWidth = getQQFilterRenderManager().getFilterWidth();
    this.lastHeight = getQQFilterRenderManager().getFilterHeight();
    if ((enableNightMode) && (this.mLowLightRender != null))
    {
      if ((SdkContext.getInstance().getDpcSwitcher().isDeNoiseSwitchOpen()) && (this.mDenoiseRender != null))
      {
        this.mInputTextureID = this.mDenoiseRender.process(this.mInputTextureID, -1, this.lastWidth, this.lastHeight).getTextureId();
        QQFilterLogManager.setFilterStatus("QQDeNoiseFilter", true);
      }
      for (;;)
      {
        this.mOutputTextureID = this.mLowLightRender.process(this.mInputTextureID, -1, this.lastWidth, this.lastHeight).getTextureId();
        QQFilterLogManager.setFilterStatus("QQLowLightFilter", true);
        this.bwork = true;
        return;
        label208:
        if (bResCheckedFailed())
        {
          this.mLowLightRender = new LowLightRender(SdkContext.getInstance().getApplication());
          if (!SLog.isEnable()) {
            break;
          }
          SLog.d("lowlightRender_time", "小太阳耗时 create without res");
          break;
        }
        if (!SLog.isEnable()) {
          break;
        }
        SLog.d("lowlightRender_time", "小太阳耗时 create wait");
        break;
        QQFilterLogManager.setFilterStatus("QQDeNoiseFilter", false);
      }
    }
    this.mOutputTextureID = this.mInputTextureID;
    QQFilterLogManager.setFilterStatus("QQLowLightFilter", false);
    this.bwork = false;
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    if ((this.lastHeight != paramInt1) || (this.lastHeight != paramInt2)) {
      destroyRender();
    }
  }
  
  public void onSurfaceDestroy()
  {
    destroyRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter
 * JD-Core Version:    0.7.0.1
 */