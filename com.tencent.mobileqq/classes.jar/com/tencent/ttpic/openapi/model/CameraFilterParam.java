package com.tencent.ttpic.openapi.model;

import android.graphics.PointF;
import com.tencent.ttpic.openapi.filter.FaceFeatureParam;
import java.util.HashMap;
import java.util.Map;

public class CameraFilterParam
{
  public float adjustValue = 1.0F;
  public int beautyLevel = 0;
  public float blackCornerAlpha = 0.0F;
  public String blendImage;
  public int blendMode = -1;
  public float blurAlpha = 0.0F;
  public float clarityAdjustValue = 0.8F;
  public float colorToneAlpha = 0.0F;
  public float contrastLevel = 0.0F;
  public int effectIndex = 0;
  public float exposureLevel = 50.0F;
  public float eyeLightenAlpha = 0.1575F;
  public float eyeLightenAlpha_573 = 0.8F;
  public float faceCenterX = 0.5F;
  public float faceCenterY = 0.5F;
  public float faceFeatureAdjustValue_573 = 0.8F;
  public float faceFeatureNormalFactor = 1.0F;
  public FaceFeatureParam faceFeatureParam = new FaceFeatureParam(0.8F);
  public int faceRotation = 0;
  public int filterId = 0;
  public String flagId;
  public int[] histogram;
  public boolean isBlackOpen = true;
  public boolean isBlurOpen = true;
  public float removePounchAlpha = 0.4F;
  public float removePounchAlpha_573 = 0.7F;
  public float removeWrinklesAlpha = 0.0F;
  public float removeWrinklesAlpha2 = 0.0F;
  public int smoothLevel = -1;
  public float toothWhitenAdjustValue = 0.0F;
  
  public CameraFilterParam copyParam()
  {
    CameraFilterParam localCameraFilterParam = new CameraFilterParam();
    localCameraFilterParam.smoothLevel = this.smoothLevel;
    localCameraFilterParam.effectIndex = this.effectIndex;
    localCameraFilterParam.filterId = this.filterId;
    localCameraFilterParam.flagId = this.flagId;
    localCameraFilterParam.isBlurOpen = this.isBlurOpen;
    localCameraFilterParam.faceCenterX = this.faceCenterX;
    localCameraFilterParam.faceCenterY = this.faceCenterY;
    localCameraFilterParam.faceRotation = this.faceRotation;
    localCameraFilterParam.isBlackOpen = this.isBlackOpen;
    localCameraFilterParam.beautyLevel = this.beautyLevel;
    localCameraFilterParam.removePounchAlpha_573 = this.removePounchAlpha_573;
    localCameraFilterParam.removePounchAlpha = this.removePounchAlpha;
    localCameraFilterParam.eyeLightenAlpha = this.eyeLightenAlpha;
    localCameraFilterParam.eyeLightenAlpha_573 = this.eyeLightenAlpha_573;
    localCameraFilterParam.adjustValue = this.adjustValue;
    localCameraFilterParam.faceFeatureParam = this.faceFeatureParam;
    localCameraFilterParam.faceFeatureAdjustValue_573 = this.faceFeatureAdjustValue_573;
    localCameraFilterParam.clarityAdjustValue = this.clarityAdjustValue;
    localCameraFilterParam.exposureLevel = this.exposureLevel;
    localCameraFilterParam.toothWhitenAdjustValue = this.toothWhitenAdjustValue;
    localCameraFilterParam.colorToneAlpha = this.colorToneAlpha;
    localCameraFilterParam.contrastLevel = this.contrastLevel;
    localCameraFilterParam.blurAlpha = this.blurAlpha;
    localCameraFilterParam.blackCornerAlpha = this.blackCornerAlpha;
    localCameraFilterParam.removeWrinklesAlpha = this.removeWrinklesAlpha;
    localCameraFilterParam.removeWrinklesAlpha2 = this.removeWrinklesAlpha2;
    localCameraFilterParam.histogram = this.histogram;
    localCameraFilterParam.blendImage = this.blendImage;
    localCameraFilterParam.blendMode = this.blendMode;
    return localCameraFilterParam;
  }
  
  public Map<String, Object> getBlurMap(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    Float localFloat = Float.valueOf(0.5F);
    localHashMap.put("tx", localFloat);
    localHashMap.put("ty", localFloat);
    localHashMap.put("radius", Float.valueOf(0.35F));
    localHashMap.put("circle", Boolean.valueOf(true));
    return localHashMap;
  }
  
  public PointF getRealFaceCenter()
  {
    PointF localPointF = new PointF(this.faceCenterX, this.faceCenterY);
    int i = this.faceRotation;
    if (i != 0)
    {
      if (i != 90)
      {
        if (i != 180)
        {
          if (i != 270) {
            return localPointF;
          }
          localPointF.y = this.faceCenterX;
          localPointF.x = (1.0F - this.faceCenterY);
          return localPointF;
        }
        localPointF.y = (1.0F - this.faceCenterY);
        localPointF.x = (1.0F - this.faceCenterX);
        return localPointF;
      }
      localPointF.y = (1.0F - this.faceCenterX);
      localPointF.x = this.faceCenterY;
    }
    return localPointF;
  }
  
  public Map<String, Object> getSmoothMap()
  {
    HashMap localHashMap = new HashMap();
    int i = this.smoothLevel;
    if (i != -1)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return localHashMap;
              }
              localHashMap.put("opttype", Float.valueOf(1.0F));
              localHashMap.put("smoothMag", Float.valueOf(0.75F));
              localHashMap.put("whitenmag", Float.valueOf(0.25F));
              return localHashMap;
            }
            localHashMap.put("opttype", Float.valueOf(1.0F));
            localHashMap.put("smoothMag", Float.valueOf(0.625F));
            localHashMap.put("whitenmag", Float.valueOf(0.25F));
            return localHashMap;
          }
          localHashMap.put("opttype", Float.valueOf(1.0F));
          localHashMap.put("smoothMag", Float.valueOf(0.5F));
          localHashMap.put("whitenmag", Float.valueOf(0.25F));
          return localHashMap;
        }
        localHashMap.put("opttype", Float.valueOf(1.0F));
        localHashMap.put("smoothMag", Float.valueOf(0.35F));
        localHashMap.put("whitenmag", Float.valueOf(0.2F));
        return localHashMap;
      }
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("smoothMag", Float.valueOf(0.2F));
      localHashMap.put("whitenmag", Float.valueOf(0.2F));
      return localHashMap;
    }
    localHashMap.put("opttype", Float.valueOf(0.0F));
    localHashMap.put("smoothMag", Float.valueOf(0.0F));
    localHashMap.put("whitenmag", Float.valueOf(0.0F));
    return localHashMap;
  }
  
  public Map<String, Object> getSmoothMap(int paramInt)
  {
    this.beautyLevel = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("smoothMag", Float.valueOf(paramInt / 100.0F * 0.9F));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.CameraFilterParam
 * JD-Core Version:    0.7.0.1
 */