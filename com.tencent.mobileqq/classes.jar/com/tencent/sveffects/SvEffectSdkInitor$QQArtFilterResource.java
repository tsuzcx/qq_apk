package com.tencent.sveffects;

import com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;

public class SvEffectSdkInitor$QQArtFilterResource
  implements ArtFilterResource
{
  public String getCommonPrefix()
  {
    return VideoFilterTools.c;
  }
  
  public String getFilterResPath()
  {
    if (SvEffectSdkInitor.a) {
      return dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.b;
    }
    return com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.b;
  }
  
  public String getModelPath()
  {
    return "";
  }
  
  public String getReshapePath()
  {
    return "";
  }
  
  public String getSoPathDir()
  {
    return PtvFilterSoLoad.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQArtFilterResource
 * JD-Core Version:    0.7.0.1
 */