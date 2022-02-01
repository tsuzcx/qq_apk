package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient.Observer;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;

class VideoFeedsIPCClient$1
  extends QIPCModule
{
  VideoFeedsIPCClient$1(VideoFeedsIPCClient paramVideoFeedsIPCClient, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    synchronized (VideoFeedsIPCClient.access$000(this.a))
    {
      Iterator localIterator = VideoFeedsIPCClient.access$000(this.a).iterator();
      while (localIterator.hasNext()) {
        ((IVideoFeedsIPCClient.Observer)localIterator.next()).a(paramString, paramBundle);
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsIPCClient.1
 * JD-Core Version:    0.7.0.1
 */