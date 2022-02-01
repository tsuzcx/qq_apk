package com.tencent.sveffects;

import also;
import bbgq;
import bdee;
import bpnd;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;

public class SvEffectSdkInitor$QQArtFilterResource
  implements ArtFilterResource
{
  public String getCommonPrefix()
  {
    return also.c;
  }
  
  public String getFilterResPath()
  {
    if (SvEffectSdkInitor.isDovCapture) {
      return bpnd.b;
    }
    return bbgq.b;
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
    return bdee.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQArtFilterResource
 * JD-Core Version:    0.7.0.1
 */