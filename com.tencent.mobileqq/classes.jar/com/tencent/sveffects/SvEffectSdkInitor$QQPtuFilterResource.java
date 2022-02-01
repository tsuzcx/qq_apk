package com.tencent.sveffects;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;

public class SvEffectSdkInitor$QQPtuFilterResource
  implements PtuFilterResource
{
  public boolean checkPendantVersionOK()
  {
    return ((IAEResUtil)QRoute.api(IAEResUtil.class)).checkAEResVersionOK(AEResInfo.AE_RES_BASE_PACKAGE);
  }
  
  public String getPortraitPathDir()
  {
    return getSoPathDir();
  }
  
  public String getSoPathDir()
  {
    return ((IAEResUtil)QRoute.api(IAEResUtil.class)).getFinalUnzipFilePath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQPtuFilterResource
 * JD-Core Version:    0.7.0.1
 */