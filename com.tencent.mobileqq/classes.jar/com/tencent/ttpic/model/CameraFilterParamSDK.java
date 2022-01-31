package com.tencent.ttpic.model;

import android.graphics.PointF;
import java.util.HashMap;
import java.util.Map;

public class CameraFilterParamSDK
{
  public int effectIndex = 0;
  public float faceCenterX = 0.5F;
  public float faceCenterY = 0.5F;
  public int faceRotation = 0;
  public float faceWidth = 0.0F;
  public int filterId = 0;
  public String flagId;
  public boolean isBlackOpen = false;
  public boolean isBlurOpen = false;
  private boolean lowEnergy = false;
  public int smoothLevel = -1;
  
  private Map<String, Object> getSmoothMapCommon()
  {
    HashMap localHashMap = new HashMap();
    switch (this.smoothLevel)
    {
    default: 
      return localHashMap;
    case 0: 
      localHashMap.put("opttype", Float.valueOf(0.0F));
      localHashMap.put("radius", Float.valueOf(0.0F));
      localHashMap.put("whitenmag", Float.valueOf(0.0F));
      return localHashMap;
    case 1: 
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.2F));
      localHashMap.put("whitenmag", Float.valueOf(0.2F));
      return localHashMap;
    case 2: 
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.35F));
      localHashMap.put("whitenmag", Float.valueOf(0.2F));
      return localHashMap;
    case 3: 
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.5F));
      localHashMap.put("whitenmag", Float.valueOf(0.25F));
      return localHashMap;
    case 4: 
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.625F));
      localHashMap.put("whitenmag", Float.valueOf(0.25F));
      return localHashMap;
    }
    localHashMap.put("opttype", Float.valueOf(1.0F));
    localHashMap.put("radius", Float.valueOf(0.75F));
    localHashMap.put("whitenmag", Float.valueOf(0.25F));
    return localHashMap;
  }
  
  private Map<String, Object> getSmoothMapLowEnergy()
  {
    HashMap localHashMap = new HashMap();
    switch (this.smoothLevel)
    {
    default: 
      return localHashMap;
    case 0: 
      localHashMap.put("opttype", Float.valueOf(0.0F));
      localHashMap.put("radius", Float.valueOf(0.0F));
      localHashMap.put("whitenmag", Float.valueOf(0.0F));
      return localHashMap;
    case 1: 
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.1F));
      localHashMap.put("whitenmag", Float.valueOf(0.2F));
      return localHashMap;
    case 2: 
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.1725F));
      localHashMap.put("whitenmag", Float.valueOf(0.2F));
      return localHashMap;
    case 3: 
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.25F));
      localHashMap.put("whitenmag", Float.valueOf(0.25F));
      return localHashMap;
    case 4: 
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.3125F));
      localHashMap.put("whitenmag", Float.valueOf(0.25F));
      return localHashMap;
    }
    localHashMap.put("opttype", Float.valueOf(1.0F));
    localHashMap.put("radius", Float.valueOf(0.375F));
    localHashMap.put("whitenmag", Float.valueOf(0.25F));
    return localHashMap;
  }
  
  public CameraFilterParamSDK copyParam()
  {
    CameraFilterParamSDK localCameraFilterParamSDK = new CameraFilterParamSDK();
    localCameraFilterParamSDK.smoothLevel = this.smoothLevel;
    localCameraFilterParamSDK.effectIndex = this.effectIndex;
    localCameraFilterParamSDK.filterId = this.filterId;
    localCameraFilterParamSDK.flagId = this.flagId;
    localCameraFilterParamSDK.isBlurOpen = this.isBlurOpen;
    localCameraFilterParamSDK.faceCenterX = this.faceCenterX;
    localCameraFilterParamSDK.faceCenterY = this.faceCenterY;
    localCameraFilterParamSDK.faceWidth = this.faceWidth;
    localCameraFilterParamSDK.faceRotation = this.faceRotation;
    localCameraFilterParamSDK.isBlackOpen = this.isBlackOpen;
    return localCameraFilterParamSDK;
  }
  
  public void enableLowEnergy(boolean paramBoolean)
  {
    this.lowEnergy = paramBoolean;
  }
  
  public Map<String, Object> getBlurMap(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (this.faceWidth > 0.0D)
    {
      localHashMap.put("circle", Boolean.valueOf(false));
      localHashMap.put("tx", Float.valueOf(this.faceCenterX));
      if (paramBoolean) {}
      for (float f = 1.0F - this.faceCenterY;; f = this.faceCenterY)
      {
        localHashMap.put("ty", Float.valueOf(f));
        localHashMap.put("radius", Float.valueOf(this.faceWidth / 2.0F));
        localHashMap.put("angle", Float.valueOf(this.faceRotation + 180.0F));
        if ((!paramBoolean) && (this.faceRotation % 180 == 0)) {
          localHashMap.put("angle", Float.valueOf(this.faceRotation));
        }
        return localHashMap;
      }
    }
    localHashMap.put("tx", Float.valueOf(0.5F));
    localHashMap.put("ty", Float.valueOf(0.5F));
    localHashMap.put("radius", Float.valueOf(0.35F));
    localHashMap.put("circle", Boolean.valueOf(true));
    return localHashMap;
  }
  
  public PointF getRealFaceCenter()
  {
    PointF localPointF = new PointF(this.faceCenterX, this.faceCenterY);
    switch (this.faceRotation)
    {
    case 0: 
    default: 
      return localPointF;
    case 90: 
      localPointF.y = (1.0F - this.faceCenterX);
      localPointF.x = this.faceCenterY;
      return localPointF;
    case 270: 
      localPointF.y = this.faceCenterX;
      localPointF.x = (1.0F - this.faceCenterY);
      return localPointF;
    }
    localPointF.y = (1.0F - this.faceCenterY);
    localPointF.x = (1.0F - this.faceCenterX);
    return localPointF;
  }
  
  public Map<String, Object> getSmoothMap()
  {
    if (this.lowEnergy) {
      return getSmoothMapLowEnergy();
    }
    return getSmoothMapCommon();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.CameraFilterParamSDK
 * JD-Core Version:    0.7.0.1
 */