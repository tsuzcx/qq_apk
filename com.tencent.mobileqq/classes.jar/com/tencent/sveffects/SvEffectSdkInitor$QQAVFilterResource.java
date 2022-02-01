package com.tencent.sveffects;

import com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;

public class SvEffectSdkInitor$QQAVFilterResource
  implements AVFilterResource
{
  public String getFilterResPath()
  {
    return ((ICaptureVideoFilterManager)QRoute.api(ICaptureVideoFilterManager.class)).getQQFilterResPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQAVFilterResource
 * JD-Core Version:    0.7.0.1
 */