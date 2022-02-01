package com.tencent.util;

import android.os.Build;
import com.tencent.ttpic.baseutils.log.LogUtils;

public class PhoneProperty
{
  public static final String DEVICE = Build.DEVICE.toLowerCase();
  public static final String MANUFACTURER = Build.MANUFACTURER.toLowerCase();
  public static final String MODEL;
  private static final String TAG = "PhoneProperty";
  private static PhoneProperty phoneProperty = null;
  private boolean cannotReuseFrameBuffer = false;
  private boolean delayDisplayGSLView = false;
  private int delayFrameCount = 0;
  private String deviceType = null;
  private int faceBeautyType = 0;
  private boolean gpuProcessNeedBackTexture = false;
  private boolean gpuWorkaroundFor544MP = false;
  private boolean gpuWorkaroundForTU880 = false;
  private boolean hdrFilterProcessLargePic = false;
  private boolean isAdaptive = false;
  private boolean nightModuleUseNightFilter = true;
  private boolean notUseSurfaceTexture = false;
  private boolean partMatch = false;
  private boolean restrictPreviewData = false;
  private boolean showLog = false;
  private boolean smallPicture = false;
  private boolean useCPUDecodeYUV = false;
  
  static
  {
    MODEL = Build.MODEL.toLowerCase();
  }
  
  private PhoneProperty()
  {
    if (this.showLog)
    {
      LogUtils.i("PhoneProperty", "******MODEL*****" + Build.MODEL);
      LogUtils.i("PhoneProperty", "******BRAND*****" + Build.BRAND);
      LogUtils.i("PhoneProperty", "*******DEVICE****" + Build.DEVICE);
      LogUtils.i("PhoneProperty", "*****DISPLAY******" + Build.DISPLAY);
      LogUtils.i("PhoneProperty", "*****HARDWARE******" + Build.HARDWARE);
      LogUtils.i("PhoneProperty", "******MANUFACTURER*****" + Build.MANUFACTURER);
      LogUtils.i("PhoneProperty", "*****PRODUCT******" + Build.PRODUCT);
      LogUtils.i("PhoneProperty", "******TAGS*****" + Build.TAGS);
      LogUtils.i("PhoneProperty", "*****USER******" + Build.USER);
      LogUtils.i("PhoneProperty", "****TYPE*******" + Build.TYPE);
    }
  }
  
  public static PhoneProperty instance()
  {
    if (phoneProperty == null) {
      phoneProperty = new PhoneProperty();
    }
    return phoneProperty;
  }
  
  public int getDelayFrameCount()
  {
    return this.delayFrameCount;
  }
  
  public int getFaceBeautyType()
  {
    return this.faceBeautyType;
  }
  
  public String getPhonePropertyMethod(String paramString)
  {
    return "set" + paramString.substring(0, 1).toUpperCase() + paramString.substring(1);
  }
  
  public boolean hasFaceDetection()
  {
    return false;
  }
  
  public boolean isAdaptive()
  {
    return (this.isAdaptive) || (this.partMatch);
  }
  
  public boolean isCannotReuseFrameBuffer()
  {
    return this.cannotReuseFrameBuffer;
  }
  
  public boolean isDelayDisplayGSLView()
  {
    return this.delayDisplayGSLView;
  }
  
  public boolean isGpuProcessNeedBackTexture()
  {
    return this.gpuProcessNeedBackTexture;
  }
  
  public boolean isGpuWorkaroundForTU880()
  {
    return this.gpuWorkaroundForTU880;
  }
  
  public boolean isHdrFilterProcessLargePic()
  {
    return this.hdrFilterProcessLargePic;
  }
  
  public boolean isNightModuleUseNightFilter()
  {
    return this.nightModuleUseNightFilter;
  }
  
  public boolean isNotUseSurfaceTexture()
  {
    return this.notUseSurfaceTexture;
  }
  
  public boolean isRestrictPreviewData()
  {
    return this.restrictPreviewData;
  }
  
  public boolean isUseCPUDecodeYUV()
  {
    return this.useCPUDecodeYUV;
  }
  
  public boolean isUseSmallPicture()
  {
    return this.smallPicture;
  }
  
  public void setCannotReuseFrameBuffer(boolean paramBoolean)
  {
    this.cannotReuseFrameBuffer = paramBoolean;
  }
  
  public void setDelayDisplayGSLView(boolean paramBoolean)
  {
    this.delayDisplayGSLView = paramBoolean;
  }
  
  public void setDelayFrameCount(int paramInt)
  {
    this.delayFrameCount = paramInt;
  }
  
  public void setFaceBeautyType(int paramInt)
  {
    this.faceBeautyType = paramInt;
  }
  
  public void setGpuProcessNeedBackTexture(boolean paramBoolean)
  {
    this.gpuProcessNeedBackTexture = paramBoolean;
  }
  
  public void setGpuWorkaroundForTU880(boolean paramBoolean)
  {
    this.gpuWorkaroundForTU880 = paramBoolean;
  }
  
  public void setHasFaceDetection(boolean paramBoolean) {}
  
  public void setHdrFilterProcessLargePic(boolean paramBoolean)
  {
    this.hdrFilterProcessLargePic = paramBoolean;
  }
  
  public void setNightModuleUseNightFilter(boolean paramBoolean)
  {
    this.nightModuleUseNightFilter = paramBoolean;
  }
  
  public void setNotUseSurfaceTexture(boolean paramBoolean)
  {
    this.notUseSurfaceTexture = paramBoolean;
  }
  
  public void setRestrictPreviewData(boolean paramBoolean)
  {
    this.restrictPreviewData = paramBoolean;
  }
  
  public void setSmallPicture(boolean paramBoolean)
  {
    this.smallPicture = paramBoolean;
  }
  
  public void setUseCPUDecodeYUV(boolean paramBoolean)
  {
    this.useCPUDecodeYUV = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.PhoneProperty
 * JD-Core Version:    0.7.0.1
 */