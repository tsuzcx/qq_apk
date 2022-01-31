package com.tencent.sveffects;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;

public class SvEffectSdkInitor$QQArtFilterResource
  implements ArtFilterResource
{
  public String a()
  {
    if (SvEffectSdkInitor.a) {
      return dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.b;
    }
    return com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.b;
  }
  
  public String b()
  {
    return PtvFilterSoLoad.c(BaseApplicationImpl.getContext());
  }
  
  public String c()
  {
    return VideoFilterTools.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQArtFilterResource
 * JD-Core Version:    0.7.0.1
 */