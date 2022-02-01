package com.tencent.sveffects;

import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;

public class SvEffectSdkInitor$QQPtuFilterResource
  implements PtuFilterResource
{
  public boolean checkPendantVersionOK()
  {
    return AEResUtil.a(AEResInfo.b);
  }
  
  public String getPortraitPathDir()
  {
    return getSoPathDir();
  }
  
  public String getSoPathDir()
  {
    return AEResUtil.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQPtuFilterResource
 * JD-Core Version:    0.7.0.1
 */