package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener;

class VideoPlaySDKManager$2
  implements SuperPlayerSDKMgr.ILogListener
{
  VideoPlaySDKManager$2(VideoPlaySDKManager paramVideoPlaySDKManager) {}
  
  public int d(String paramString1, String paramString2)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    LogUtil.e(paramString1, 1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.i(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.v(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.w(paramString1, 2, paramString2);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlaySDKManager.2
 * JD-Core Version:    0.7.0.1
 */