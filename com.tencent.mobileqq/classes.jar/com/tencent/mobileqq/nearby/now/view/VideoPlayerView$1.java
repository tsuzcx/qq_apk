package com.tencent.mobileqq.nearby.now.view;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;

final class VideoPlayerView$1
  implements TVK_ICacheMgr.IPreloadCallback
{
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPreLoadFailed() called with: s = [");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], i = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], s1 = [");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("]");
    QLog.i("VideoPlayerView", 2, localStringBuilder.toString());
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPreLoadSucess() called with: s = [");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], s1 = [");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("]");
    QLog.i("VideoPlayerView", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerView.1
 * JD-Core Version:    0.7.0.1
 */