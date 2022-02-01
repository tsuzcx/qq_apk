package com.tencent.ttpic.openapi.util;

import android.support.annotation.NonNull;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.device.DeviceUtils;
import org.light.device.LightDeviceUtils;

public class RenderLevelHelper
{
  public static final int MAX_FPS = 18;
  private static RenderLevelHelper.DOWNGRADE_LEVEL mDowngradeLevel;
  
  public static RenderLevelHelper.DOWNGRADE_LEVEL getDowngradeLevel()
  {
    return mDowngradeLevel;
  }
  
  public static RenderLevelHelper.DOWNGRADE_LEVEL getInitRenderLevel()
  {
    RenderLevelHelper.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL1;
    if (DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
      localDOWNGRADE_LEVEL1 = RenderLevelHelper.DOWNGRADE_LEVEL.HIGH;
    } else if (DeviceUtils.hasDeviceLow(AEModule.getContext())) {
      localDOWNGRADE_LEVEL1 = RenderLevelHelper.DOWNGRADE_LEVEL.MEDIUM;
    } else {
      localDOWNGRADE_LEVEL1 = RenderLevelHelper.DOWNGRADE_LEVEL.LOW;
    }
    RenderLevelHelper.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL2 = getScreenLevel();
    if (localDOWNGRADE_LEVEL1.value > localDOWNGRADE_LEVEL2.value) {
      return localDOWNGRADE_LEVEL1;
    }
    return localDOWNGRADE_LEVEL2;
  }
  
  @NonNull
  public static RenderLevelHelper.DOWNGRADE_LEVEL getRenderLevel()
  {
    RenderLevelHelper.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL = mDowngradeLevel;
    if (localDOWNGRADE_LEVEL != null) {
      return localDOWNGRADE_LEVEL;
    }
    initRenderLevel(RenderLevelHelper.RenderLevelType.PUDDING);
    return mDowngradeLevel;
  }
  
  public static RenderLevelHelper.DOWNGRADE_LEVEL getScreenLevel()
  {
    int i = LightDeviceUtils.getScreenWidth(AEModule.getContext());
    if (i >= 1080) {
      return RenderLevelHelper.DOWNGRADE_LEVEL.HIGH;
    }
    if (i >= 720) {
      return RenderLevelHelper.DOWNGRADE_LEVEL.MEDIUM;
    }
    return RenderLevelHelper.DOWNGRADE_LEVEL.LOW;
  }
  
  public static void initRenderLevel(RenderLevelHelper.RenderLevelType paramRenderLevelType)
  {
    if (paramRenderLevelType == RenderLevelHelper.RenderLevelType.PUDDING)
    {
      if (DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
        paramRenderLevelType = RenderLevelHelper.DOWNGRADE_LEVEL.HIGH;
      } else if (DeviceUtils.hasDeviceLow(AEModule.getContext())) {
        paramRenderLevelType = RenderLevelHelper.DOWNGRADE_LEVEL.MEDIUM;
      } else {
        paramRenderLevelType = RenderLevelHelper.DOWNGRADE_LEVEL.LOW;
      }
    }
    else if (DeviceUtils.hasDeviceVHigh(AEModule.getContext())) {
      paramRenderLevelType = RenderLevelHelper.DOWNGRADE_LEVEL.HIGH;
    } else if (DeviceUtils.hasDeviceLow(AEModule.getContext())) {
      paramRenderLevelType = RenderLevelHelper.DOWNGRADE_LEVEL.MEDIUM;
    } else {
      paramRenderLevelType = RenderLevelHelper.DOWNGRADE_LEVEL.LOW;
    }
    RenderLevelHelper.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL = getScreenLevel();
    if (paramRenderLevelType.value <= localDOWNGRADE_LEVEL.value) {
      paramRenderLevelType = localDOWNGRADE_LEVEL;
    }
    setDowngradeLevel(paramRenderLevelType);
  }
  
  public static void setDowngradeLevel(RenderLevelHelper.DOWNGRADE_LEVEL paramDOWNGRADE_LEVEL)
  {
    mDowngradeLevel = paramDOWNGRADE_LEVEL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.RenderLevelHelper
 * JD-Core Version:    0.7.0.1
 */