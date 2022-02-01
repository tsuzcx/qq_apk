package com.tencent.superplayer.api;

import com.tencent.qqlive.tvkplayer.TVideoMgr.OnTVideoLogListener;
import com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener;

class SuperPlayerSDKMgr$InnerLogListener
  implements TVideoMgr.OnTVideoLogListener, TPPlayerMgr.OnLogListener
{
  public int d(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.access$100() != null) {
      return SuperPlayerSDKMgr.access$100().d(paramString1, paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.access$100() != null) {
      return SuperPlayerSDKMgr.access$100().e(paramString1, paramString2);
    }
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.access$100() != null) {
      return SuperPlayerSDKMgr.access$100().i(paramString1, paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.access$100() != null) {
      return SuperPlayerSDKMgr.access$100().v(paramString1, paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    if (SuperPlayerSDKMgr.access$100() != null) {
      return SuperPlayerSDKMgr.access$100().w(paramString1, paramString2);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerSDKMgr.InnerLogListener
 * JD-Core Version:    0.7.0.1
 */