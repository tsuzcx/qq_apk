package com.tencent.sveffects;

import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;

public class SvEffectSdkInitor$QQAVFilterResource
  implements AVFilterResource
{
  public String a()
  {
    if (SvEffectSdkInitor.a) {
      return "assets://qaveffect/filter/";
    }
    return CaptureVideoFilterManager.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQAVFilterResource
 * JD-Core Version:    0.7.0.1
 */