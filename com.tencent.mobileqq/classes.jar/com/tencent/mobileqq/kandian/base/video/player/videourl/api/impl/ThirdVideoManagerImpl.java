package com.tencent.mobileqq.kandian.base.video.player.videourl.api.impl;

import com.tencent.mobileqq.kandian.base.video.player.videourl.AbsVideoUrlInfo;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.api.IThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.api.UrlToUUIDCallback;

public class ThirdVideoManagerImpl
  implements IThirdVideoManager
{
  public String getUrlByVid(String paramString)
  {
    return ThirdVideoManager.a(paramString);
  }
  
  public AbsVideoUrlInfo getVidUrlObjectFromCache(String paramString)
  {
    return ThirdVideoManager.b(paramString);
  }
  
  public void sendUrlToUUIDRequest(String paramString, UrlToUUIDCallback paramUrlToUUIDCallback)
  {
    ThirdVideoManager.a().a(paramString, paramUrlToUUIDCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.videourl.api.impl.ThirdVideoManagerImpl
 * JD-Core Version:    0.7.0.1
 */