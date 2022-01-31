package com.tencent.ttpic.openapi.util;

import android.support.annotation.NonNull;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.device.DeviceUtils;

public class RenderLevelHelper
{
  public static final int MAX_FPS = 18;
  private static RenderLevelHelper.DOWNGRADE_LEVEL mDowngradeLevel = null;
  
  public static RenderLevelHelper.DOWNGRADE_LEVEL getDowngradeLevel()
  {
    return mDowngradeLevel;
  }
  
  public static RenderLevelHelper.DOWNGRADE_LEVEL getInitRenderLevel()
  {
    RenderLevelHelper.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL1;
    if (DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
      localDOWNGRADE_LEVEL1 = RenderLevelHelper.DOWNGRADE_LEVEL.HIGH;
    }
    RenderLevelHelper.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL2;
    for (;;)
    {
      localDOWNGRADE_LEVEL2 = getScreenLevel();
      if (localDOWNGRADE_LEVEL1.value <= localDOWNGRADE_LEVEL2.value) {
        break;
      }
      return localDOWNGRADE_LEVEL1;
      if (DeviceUtils.hasDeviceLow(AEModule.getContext())) {
        localDOWNGRADE_LEVEL1 = RenderLevelHelper.DOWNGRADE_LEVEL.MEDIUM;
      } else {
        localDOWNGRADE_LEVEL1 = RenderLevelHelper.DOWNGRADE_LEVEL.LOW;
      }
    }
    return localDOWNGRADE_LEVEL2;
  }
  
  @NonNull
  public static RenderLevelHelper.DOWNGRADE_LEVEL getRenderLevel()
  {
    if (mDowngradeLevel != null) {
      return mDowngradeLevel;
    }
    initRenderLevel(RenderLevelHelper.RenderLevelType.PUDDING);
    return mDowngradeLevel;
  }
  
  public static RenderLevelHelper.DOWNGRADE_LEVEL getScreenLevel()
  {
    int i = DeviceUtils.getScreenWidth(AEModule.getContext());
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
    RenderLevelHelper.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL;
    if (paramRenderLevelType == RenderLevelHelper.RenderLevelType.PUDDING) {
      if (DeviceUtils.hasDeviceNormal(AEModule.getContext()))
      {
        paramRenderLevelType = RenderLevelHelper.DOWNGRADE_LEVEL.HIGH;
        localDOWNGRADE_LEVEL = getScreenLevel();
        if (paramRenderLevelType.value <= localDOWNGRADE_LEVEL.value) {
          break label102;
        }
      }
    }
    for (;;)
    {
      setDowngradeLevel(paramRenderLevelType);
      return;
      if (DeviceUtils.hasDeviceLow(AEModule.getContext()))
      {
        paramRenderLevelType = RenderLevelHelper.DOWNGRADE_LEVEL.MEDIUM;
        break;
      }
      paramRenderLevelType = RenderLevelHelper.DOWNGRADE_LEVEL.LOW;
      break;
      if (DeviceUtils.hasDeviceVHigh(AEModule.getContext()))
      {
        paramRenderLevelType = RenderLevelHelper.DOWNGRADE_LEVEL.HIGH;
        break;
      }
      if (DeviceUtils.hasDeviceLow(AEModule.getContext()))
      {
        paramRenderLevelType = RenderLevelHelper.DOWNGRADE_LEVEL.MEDIUM;
        break;
      }
      paramRenderLevelType = RenderLevelHelper.DOWNGRADE_LEVEL.LOW;
      break;
      label102:
      paramRenderLevelType = localDOWNGRADE_LEVEL;
    }
  }
  
  public static void setDowngradeLevel(RenderLevelHelper.DOWNGRADE_LEVEL paramDOWNGRADE_LEVEL)
  {
    mDowngradeLevel = paramDOWNGRADE_LEVEL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.RenderLevelHelper
 * JD-Core Version:    0.7.0.1
 */