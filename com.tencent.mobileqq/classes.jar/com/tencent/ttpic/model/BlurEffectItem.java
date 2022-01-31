package com.tencent.ttpic.model;

public class BlurEffectItem
{
  private double blurStrength;
  private int blurType;
  private String imageMaskId;
  private ImageMaskItem imageMaskItem = null;
  private FaceMaskItem mFaceMaskItem;
  private int maskType;
  private int renderOrder;
  
  public double getBlurStrength()
  {
    return this.blurStrength;
  }
  
  public int getBlurType()
  {
    return this.blurType;
  }
  
  public FaceMaskItem getFaceMaskItem()
  {
    return this.mFaceMaskItem;
  }
  
  public String getImageMaskId()
  {
    return this.imageMaskId;
  }
  
  public ImageMaskItem getImageMaskItem()
  {
    return this.imageMaskItem;
  }
  
  public int getMaskType()
  {
    return this.maskType;
  }
  
  public int getRenderOrder()
  {
    return this.renderOrder;
  }
  
  public void setBlurStrength(double paramDouble)
  {
    this.blurStrength = paramDouble;
  }
  
  public void setBlurType(int paramInt)
  {
    this.blurType = paramInt;
  }
  
  public void setFaceMaskItem(FaceMaskItem paramFaceMaskItem)
  {
    this.mFaceMaskItem = paramFaceMaskItem;
  }
  
  public void setImageMaskId(String paramString)
  {
    this.imageMaskId = paramString;
  }
  
  public void setImageMaskItem(ImageMaskItem paramImageMaskItem)
  {
    this.imageMaskItem = paramImageMaskItem;
  }
  
  public void setMaskType(int paramInt)
  {
    this.maskType = paramInt;
  }
  
  public void setRenderOrder(int paramInt)
  {
    this.renderOrder = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.model.BlurEffectItem
 * JD-Core Version:    0.7.0.1
 */