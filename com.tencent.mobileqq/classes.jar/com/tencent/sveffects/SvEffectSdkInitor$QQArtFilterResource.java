package com.tencent.sveffects;

import com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;

public class SvEffectSdkInitor$QQArtFilterResource
  implements ArtFilterResource
{
  public String getCommonPrefix()
  {
    return ((IVideoFilterTools)QRoute.api(IVideoFilterTools.class)).getCommonPrefix();
  }
  
  public String getFilterResPath()
  {
    return ((ICaptureVideoFilterManager)QRoute.api(ICaptureVideoFilterManager.class)).getQQFilterResPath();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQArtFilterResource
 * JD-Core Version:    0.7.0.1
 */