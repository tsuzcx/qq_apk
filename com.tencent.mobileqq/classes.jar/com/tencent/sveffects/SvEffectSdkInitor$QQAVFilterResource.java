package com.tencent.sveffects;

import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;

public class SvEffectSdkInitor$QQAVFilterResource
  implements AVFilterResource
{
  public String getFilterResPath()
  {
    if (SvEffectSdkInitor.a) {
      return dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.b;
    }
    return com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQAVFilterResource
 * JD-Core Version:    0.7.0.1
 */