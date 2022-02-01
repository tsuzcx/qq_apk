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
import java.io.OutputStream;

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
  public static String lowLightDir;
  public static String lowLightPath;
  public static int mLowLightResStatus;
  private boolean bwork = false;
  private int lastHeight = 0;
  private int lastWidth = 0;
  private DenoiseRender mDenoiseRender = null;
  private LowLightRender mLowLightRender = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SdkContext.getInstance().getResources().getLowLightResource().getLowLightDir());
    localStringBuilder.append("capture_qsvf");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("lowlight");
    lowLightDir = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(lowLightDir);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("LowLight.png");
    lowLightPath = localStringBuilder.toString();
    mLowLightResStatus = 0;
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
    if (mLowLightResStatus == ResUncheck) {
      CheckLowLightRes();
    }
    return mLowLightResStatus == ResExist;
  }
  
  private void destroyRender()
  {
    Object localObject = this.mLowLightRender;
    if (localObject != null)
    {
      ((LowLightRender)localObject).destroy();
      this.mLowLightRender = null;
    }
    localObject = this.mDenoiseRender;
    if (localObject != null)
    {
      ((DenoiseRender)localObject).destroy();
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
    if (localFile.exists())
    {
      localFile.delete();
    }
    else
    {
      localObject1 = localFile.getParentFile();
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
    }
    Object localObject1 = LowLightTools.getLowLightImage(3.0F, 0.88F, 0.96F, 1.22F, false);
    try
    {
      localObject2 = new BufferedOutputStream(new FileOutputStream(localFile));
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
      ((BufferedOutputStream)localObject2).flush();
      ((BufferedOutputStream)localObject2).close();
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("LowLightTools saveBitmap:");
      ((StringBuilder)localObject2).append(localException);
      SLog.w("QQLowLightFilter", ((StringBuilder)localObject2).toString());
    }
    if (!localFile.exists())
    {
      mLowLightResStatus = ResFailed;
      return;
    }
    mLowLightResStatus = ResExist;
  }
  
  public boolean isFilterWork()
  {
    return this.bwork;
  }
  
  public void onDrawFrame()
  {
    if (this.mLowLightRender == null) {
      if (bResReady())
      {
        this.mLowLightRender = new LowLightRender(SdkContext.getInstance().getApplication(), lowLightDir);
        if (SLog.isEnable()) {
          SLog.d("lowlightRender_time", "小太阳耗时 create with res");
        }
      }
      else if (bResCheckedFailed())
      {
        this.mLowLightRender = new LowLightRender(SdkContext.getInstance().getApplication());
        if (SLog.isEnable()) {
          SLog.d("lowlightRender_time", "小太阳耗时 create without res");
        }
      }
      else if (SLog.isEnable())
      {
        SLog.d("lowlightRender_time", "小太阳耗时 create wait");
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
      if (SdkContext.getInstance().getDpcSwitcher().isDeNoiseSwitchOpen())
      {
        DenoiseRender localDenoiseRender = this.mDenoiseRender;
        if (localDenoiseRender != null)
        {
          this.mInputTextureID = localDenoiseRender.process(this.mInputTextureID, -1, this.lastWidth, this.lastHeight).getTextureId();
          QQFilterLogManager.setFilterStatus("QQDeNoiseFilter", true);
          break label233;
        }
      }
      QQFilterLogManager.setFilterStatus("QQDeNoiseFilter", false);
      label233:
      this.mOutputTextureID = this.mLowLightRender.process(this.mInputTextureID, -1, this.lastWidth, this.lastHeight).getTextureId();
      QQFilterLogManager.setFilterStatus("QQLowLightFilter", true);
      this.bwork = true;
      return;
    }
    this.mOutputTextureID = this.mInputTextureID;
    QQFilterLogManager.setFilterStatus("QQLowLightFilter", false);
    this.bwork = false;
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    int i = this.lastHeight;
    if ((i != paramInt1) || (i != paramInt2)) {
      destroyRender();
    }
  }
  
  public void onSurfaceDestroy()
  {
    destroyRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter
 * JD-Core Version:    0.7.0.1
 */