package com.tencent.thumbplayer.core.richmedia;

public class TPNativeRichMediaFeature
{
  private String[] mBinding = new String[0];
  private String mFeatureType;
  private boolean mIsSelected = false;
  
  public String[] getBinding()
  {
    return this.mBinding;
  }
  
  public String getFeatureType()
  {
    return this.mFeatureType;
  }
  
  public boolean isSelected()
  {
    return this.mIsSelected;
  }
  
  public void setBinding(String[] paramArrayOfString)
  {
    this.mBinding = paramArrayOfString;
  }
  
  public void setFeatureType(String paramString)
  {
    this.mFeatureType = paramString;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.mIsSelected = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeature
 * JD-Core Version:    0.7.0.1
 */