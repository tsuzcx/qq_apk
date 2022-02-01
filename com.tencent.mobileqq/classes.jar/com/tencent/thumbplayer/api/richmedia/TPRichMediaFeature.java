package com.tencent.thumbplayer.api.richmedia;

import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TPRichMediaFeature
{
  private List<String> mBinding;
  private String mFeatureType;
  private boolean mIsSelected = false;
  
  public TPRichMediaFeature(TPNativeRichMediaFeature paramTPNativeRichMediaFeature)
  {
    this.mFeatureType = paramTPNativeRichMediaFeature.getFeatureType();
    this.mBinding = new ArrayList(Arrays.asList(paramTPNativeRichMediaFeature.getBinding()));
    this.mIsSelected = paramTPNativeRichMediaFeature.isSelected();
  }
  
  public List<String> getBinding()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.api.richmedia.TPRichMediaFeature
 * JD-Core Version:    0.7.0.1
 */