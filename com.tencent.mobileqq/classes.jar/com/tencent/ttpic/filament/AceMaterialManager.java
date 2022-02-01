package com.tencent.ttpic.filament;

import com.google.android.filament.gltfio.AceMaterialInfo;
import com.tencent.ttpic.util.ColorUtil;

public enum AceMaterialManager
{
  INSTANCE;
  
  private float faceLightness = 0.0F;
  private FilamentFilter filter;
  private float[] key = { 30.0F, 80.0F };
  private AceMaterialInfo materialInfo;
  private float[] value = { 30000.0F, 80000.0F };
  
  private AceMaterialManager() {}
  
  public static String getEngineVersion()
  {
    return AceMaterialInfo.getEngineVersion();
  }
  
  public static String getGlbInfo(String paramString)
  {
    return AceMaterialInfo.getGlbInfo(paramString);
  }
  
  public static AceMaterialManager getInstance()
  {
    return INSTANCE;
  }
  
  public void addBone(String paramString)
  {
    AceMaterialInfo localAceMaterialInfo = this.materialInfo;
    if (localAceMaterialInfo != null) {
      localAceMaterialInfo.addBone(paramString);
    }
  }
  
  public void deleteBone(String paramString)
  {
    AceMaterialInfo localAceMaterialInfo = this.materialInfo;
    if (localAceMaterialInfo != null) {
      localAceMaterialInfo.deleteBone(paramString);
    }
  }
  
  public float[] getDirectionColor()
  {
    return this.materialInfo.getDirectionColor();
  }
  
  public int getDirectionIntensity()
  {
    return this.materialInfo.getDirectionIntensity();
  }
  
  public float getFaceLightness()
  {
    return this.faceLightness;
  }
  
  public FilamentFilter getFilter()
  {
    return this.filter;
  }
  
  public int getIblIntensity()
  {
    return this.materialInfo.getIblIntensity();
  }
  
  public int getIblRotation()
  {
    return this.materialInfo.getIblRotation();
  }
  
  public float[] getLightDirection()
  {
    float[] arrayOfFloat = this.materialInfo.getLightDirection();
    return FilamentUtil.xyz2lglt(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
  }
  
  public AceMaterialInfo getMaterialInfo()
  {
    return this.materialInfo;
  }
  
  public float[] getPosition()
  {
    AceMaterialInfo localAceMaterialInfo = this.materialInfo;
    if (localAceMaterialInfo != null) {
      return localAceMaterialInfo.getPosition();
    }
    return null;
  }
  
  public float[] getRotation()
  {
    Object localObject = this.materialInfo;
    if (localObject == null) {
      return null;
    }
    localObject = ((AceMaterialInfo)localObject).getRotation();
    return new float[] { localObject[0] * 180.0F / 3.141593F, localObject[1] * 180.0F / 3.141593F, localObject[2] * 180.0F / 3.141593F };
  }
  
  public float[] getScale()
  {
    return this.materialInfo.getScale();
  }
  
  public boolean hasMaterialInfo()
  {
    return this.materialInfo != null;
  }
  
  public void removeMaterialInfo()
  {
    this.materialInfo = null;
  }
  
  public void setDirectionColor(String paramString)
  {
    paramString = ColorUtil.hex2Rgb(paramString);
    AceMaterialInfo localAceMaterialInfo = this.materialInfo;
    if (localAceMaterialInfo != null) {
      localAceMaterialInfo.setDirectionColor(paramString[0] / 255.0F, paramString[1] / 255.0F, paramString[2] / 255.0F);
    }
  }
  
  public void setDirectionIntensity(int paramInt)
  {
    AceMaterialInfo localAceMaterialInfo = this.materialInfo;
    if (localAceMaterialInfo != null) {
      localAceMaterialInfo.setDirectionIntensity(paramInt);
    }
  }
  
  public void setFaceLightness(float paramFloat)
  {
    this.faceLightness = paramFloat;
  }
  
  public void setFilter(FilamentFilter paramFilamentFilter)
  {
    this.filter = paramFilamentFilter;
  }
  
  public void setFilterNativeObject(long paramLong)
  {
    this.materialInfo = new AceMaterialInfo(paramLong);
  }
  
  public void setIblIntensity(int paramInt)
  {
    AceMaterialInfo localAceMaterialInfo = this.materialInfo;
    if (localAceMaterialInfo != null) {
      localAceMaterialInfo.setIblIntensity(paramInt);
    }
  }
  
  public void setIblRotation(int paramInt)
  {
    AceMaterialInfo localAceMaterialInfo = this.materialInfo;
    if (localAceMaterialInfo != null) {
      localAceMaterialInfo.setIblDegree(paramInt);
    }
  }
  
  public void setLightDirection(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = FilamentUtil.lglt2xyz(paramFloat1, paramFloat2);
    AceMaterialInfo localAceMaterialInfo = this.materialInfo;
    if (localAceMaterialInfo != null) {
      localAceMaterialInfo.setLightDirection(-arrayOfFloat[0], arrayOfFloat[1], -arrayOfFloat[2]);
    }
  }
  
  public void setLightIntensity(int paramInt) {}
  
  public void setPosition(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AceMaterialInfo localAceMaterialInfo = this.materialInfo;
    if (localAceMaterialInfo != null) {
      localAceMaterialInfo.setPosition(paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  public void setRotation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AceMaterialInfo localAceMaterialInfo = this.materialInfo;
    if (localAceMaterialInfo != null) {
      localAceMaterialInfo.setRotation(paramFloat1 * 3.141593F / 180.0F, paramFloat2 * 3.141593F / 180.0F, paramFloat3 * 3.141593F / 180.0F);
    }
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AceMaterialInfo localAceMaterialInfo = this.materialInfo;
    if (localAceMaterialInfo != null) {
      localAceMaterialInfo.setScale(paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  public boolean updateBoneGravity(String paramString, float[] paramArrayOfFloat)
  {
    return this.materialInfo.updateBoneGravity(paramString, paramArrayOfFloat);
  }
  
  public boolean updateBoneNoRotationUpdate(String paramString, int paramInt)
  {
    return this.materialInfo.updateBoneNoRotation(paramString, paramInt);
  }
  
  public boolean updateBoneParams(String paramString1, int paramInt, String paramString2, float paramFloat)
  {
    return this.materialInfo.updateBoneParams(paramString1, paramInt, paramString2, paramFloat);
  }
  
  public void updateIntensity(float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 == 1) {
        this.value[paramInt1] = paramFloat;
      }
    }
    else {
      this.key[paramInt1] = paramFloat;
    }
    AceMaterialInfo localAceMaterialInfo = this.materialInfo;
    if (localAceMaterialInfo != null) {
      localAceMaterialInfo.updateIntensityMap(this.key, this.value);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filament.AceMaterialManager
 * JD-Core Version:    0.7.0.1
 */