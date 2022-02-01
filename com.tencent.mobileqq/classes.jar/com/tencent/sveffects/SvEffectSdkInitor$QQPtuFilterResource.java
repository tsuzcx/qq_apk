package com.tencent.sveffects;

import bnkt;
import bnky;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;

public class SvEffectSdkInitor$QQPtuFilterResource
  implements PtuFilterResource
{
  public boolean checkPendantVersionOK()
  {
    return bnky.a(bnkt.b);
  }
  
  public String getPortraitPathDir()
  {
    return getSoPathDir();
  }
  
  public String getSoPathDir()
  {
    return bnky.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQPtuFilterResource
 * JD-Core Version:    0.7.0.1
 */