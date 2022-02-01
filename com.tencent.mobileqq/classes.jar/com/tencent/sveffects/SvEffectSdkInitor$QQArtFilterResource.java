package com.tencent.sveffects;

import akus;
import baah;
import bbxj;
import bnxl;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;

public class SvEffectSdkInitor$QQArtFilterResource
  implements ArtFilterResource
{
  public String getCommonPrefix()
  {
    return akus.c;
  }
  
  public String getFilterResPath()
  {
    if (SvEffectSdkInitor.isDovCapture) {
      return bnxl.b;
    }
    return baah.b;
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
    return bbxj.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQArtFilterResource
 * JD-Core Version:    0.7.0.1
 */