package com.tencent.sveffects;

import baah;
import bnxl;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;

public class SvEffectSdkInitor$QQAVFilterResource
  implements AVFilterResource
{
  public String getFilterResPath()
  {
    if (SvEffectSdkInitor.isDovCapture) {
      return bnxl.b;
    }
    return baah.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQAVFilterResource
 * JD-Core Version:    0.7.0.1
 */