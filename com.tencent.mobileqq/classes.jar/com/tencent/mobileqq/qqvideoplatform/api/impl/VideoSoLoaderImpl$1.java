package com.tencent.mobileqq.qqvideoplatform.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

class VideoSoLoaderImpl$1
  implements OnLoadListener
{
  VideoSoLoaderImpl$1(VideoSoLoaderImpl paramVideoSoLoaderImpl, LoadSoCallback paramLoadSoCallback) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (LogUtil.isColorLevel())
    {
      paramLoadExtResult = new StringBuilder();
      paramLoadExtResult.append("initSDKAsync, onLoadResult, resCode = ");
      paramLoadExtResult.append(paramInt);
      LogUtil.d("[VideoPlatform]VideoSoManagerImpl", 2, paramLoadExtResult.toString());
    }
    if (paramInt == 0)
    {
      this.a.onLoad(true);
      return;
    }
    this.a.onLoad(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.api.impl.VideoSoLoaderImpl.1
 * JD-Core Version:    0.7.0.1
 */