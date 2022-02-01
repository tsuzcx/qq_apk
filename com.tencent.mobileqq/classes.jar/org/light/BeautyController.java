package org.light;

import android.util.Log;
import java.util.Map;

public class BeautyController
{
  static final String LIPS_STRENGTH_DEFULT = "0";
  public static final int MAKEUP_TYPE_BEAUTY_MULTIPLY = 3;
  public static final int MAKEUP_TYPE_LIPS = 1;
  public static final int MAKEUP_TYPE_SOFT_LIGHT = 2;
  static final String MULTIPLY_STRENGTH_DEFAULT = "0";
  static final String SOFTLIGHT_STRENGTH_DEFAULT = "0";
  private static final String TAG = "BeautyController";
  private CameraConfig config;
  private Map<String, String> configData;
  
  public BeautyController(Map<String, String> paramMap)
  {
    this.configData = paramMap;
  }
  
  private String formatDecimalValue(int paramInt)
  {
    return Float.toString(paramInt / 100.0F);
  }
  
  public void enableAssetBeautyMakeup(int paramInt, boolean paramBoolean)
  {
    Object localObject = "true";
    Map localMap;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3)
        {
          localMap = this.configData;
          if (!paramBoolean) {
            localObject = "false";
          }
          localMap.put("makeup.makeupMultiply.enable", localObject);
        }
      }
      else
      {
        localMap = this.configData;
        if (!paramBoolean) {
          localObject = "false";
        }
        localMap.put("makeup.softLight.enable", localObject);
      }
    }
    else
    {
      localMap = this.configData;
      if (!paramBoolean) {
        localObject = "false";
      }
      localMap.put("makeup.lips.enable", localObject);
    }
    localObject = this.config;
    if (localObject != null) {
      ((CameraConfig)localObject).setConfigData(this.configData);
    }
  }
  
  public void enableBasicBeautyMakeup(int paramInt, boolean paramBoolean)
  {
    Object localObject = "true";
    if (paramBoolean) {
      this.configData.put("beauty.faceFeature.enable", "true");
    }
    Map localMap;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3)
        {
          localMap = this.configData;
          if (!paramBoolean) {
            localObject = "false";
          }
          localMap.put("beauty.makeupMultiply.enable", localObject);
        }
      }
      else
      {
        localMap = this.configData;
        if (!paramBoolean) {
          localObject = "false";
        }
        localMap.put("beauty.softLight.enable", localObject);
      }
    }
    else
    {
      localMap = this.configData;
      if (!paramBoolean) {
        localObject = "false";
      }
      localMap.put("beauty.lips.enable", localObject);
    }
    localObject = this.config;
    if (localObject != null) {
      ((CameraConfig)localObject).setConfigData(this.configData);
    }
  }
  
  public boolean isAssetHasMakeUp(int paramInt)
  {
    CameraConfig localCameraConfig = this.config;
    if (localCameraConfig != null) {
      return localCameraConfig.hasCertainRenderComponent(paramInt);
    }
    return false;
  }
  
  public void openAndUpdateBasicLips(String paramString, int paramInt1, int paramInt2)
  {
    enableAssetBeautyMakeup(1, false);
    enableBasicBeautyMakeup(1, true);
    this.configData.put("beauty.faceFeatureLipsLut", formatDecimalValue(paramInt1));
    this.configData.put("beauty.lips.lipsMask", paramString);
    this.configData.put("beauty.lips.lipsType", String.valueOf(paramInt2));
    paramString = this.config;
    if (paramString != null) {
      paramString.setConfigData(this.configData);
    }
  }
  
  public void openAndUpdateBasicMultiply(String paramString, int paramInt)
  {
    enableAssetBeautyMakeup(3, false);
    enableBasicBeautyMakeup(3, true);
    this.configData.put("beauty.faceFeature.enable", "true");
    this.configData.put("beauty.faceFeatureRedCheek", formatDecimalValue(paramInt));
    this.configData.put("beauty.makeupMultiply.multiplyMask", paramString);
    paramString = this.config;
    if (paramString != null) {
      paramString.setConfigData(this.configData);
    }
  }
  
  public void openAndUpdateBasicSoftLight(String paramString, int paramInt)
  {
    enableAssetBeautyMakeup(2, false);
    enableBasicBeautyMakeup(2, true);
    this.configData.put("beauty.faceFeature.enable", "true");
    this.configData.put("beauty.faceFeatureSoftlight", formatDecimalValue(paramInt));
    this.configData.put("beauty.softLight.softLightMask", paramString);
    paramString = this.config;
    if (paramString != null) {
      paramString.setConfigData(this.configData);
    }
  }
  
  public void setBeautyLipsLevel(int paramInt)
  {
    this.configData.put("beauty.faceFeatureLipsLut", formatDecimalValue(paramInt));
    CameraConfig localCameraConfig = this.config;
    if (localCameraConfig != null) {
      localCameraConfig.setConfigData(this.configData);
    }
  }
  
  public void setBeautyMultiplyLevel(int paramInt)
  {
    this.configData.put("beauty.faceFeatureRedCheek", formatDecimalValue(paramInt));
    CameraConfig localCameraConfig = this.config;
    if (localCameraConfig != null) {
      localCameraConfig.setConfigData(this.configData);
    }
  }
  
  public void setBeautyMultiplyMask(String paramString)
  {
    this.configData.put("beauty.faceFeature.enable", "true");
    this.configData.put("beauty.makeupMultiply.multiplyMask", paramString);
    paramString = this.config;
    if (paramString != null) {
      paramString.setConfigData(this.configData);
    }
  }
  
  public void setBeautySoftLevel(int paramInt)
  {
    this.configData.put("beauty.faceFeatureSoftlight", formatDecimalValue(paramInt));
    CameraConfig localCameraConfig = this.config;
    if (localCameraConfig != null) {
      localCameraConfig.setConfigData(this.configData);
    }
  }
  
  public void setCameraConfig(CameraConfig paramCameraConfig)
  {
    this.config = paramCameraConfig;
    paramCameraConfig.setConfigData(this.configData);
  }
  
  public void setLipsLut(String paramString, int paramInt)
  {
    this.configData.put("beauty.lips.lipsMask", paramString);
    this.configData.put("beauty.lips.lipsType", String.valueOf(paramInt));
    Object localObject = this.config;
    if (localObject != null) {
      ((CameraConfig)localObject).setConfigData(this.configData);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setLipsLut ");
    ((StringBuilder)localObject).append(paramString);
    Log.d("BeautyController", ((StringBuilder)localObject).toString());
  }
  
  public void setSoftLightMask(String paramString)
  {
    this.configData.put("beauty.faceFeature.enable", "true");
    this.configData.put("beauty.softLight.softLightMask", paramString);
    paramString = this.config;
    if (paramString != null) {
      paramString.setConfigData(this.configData);
    }
  }
  
  public void setStrength(int paramInt, float paramFloat)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          this.configData.put("beauty.faceFeatureRedCheek", String.valueOf(paramFloat));
        }
      }
      else {
        this.configData.put("beauty.faceFeatureSoftlight", String.valueOf(paramFloat));
      }
    }
    else {
      this.configData.put("beauty.faceFeatureLipsLut", String.valueOf(paramFloat));
    }
    CameraConfig localCameraConfig = this.config;
    if (localCameraConfig != null) {
      localCameraConfig.setConfigData(this.configData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.BeautyController
 * JD-Core Version:    0.7.0.1
 */