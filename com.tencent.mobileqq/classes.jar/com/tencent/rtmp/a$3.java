package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.o;

class a$3
  implements o
{
  a$3(a parama) {}
  
  public void onRenderVideoFrame(String paramString, int paramInt, TXSVideoFrame paramTXSVideoFrame)
  {
    if ((paramTXSVideoFrame != null) && (paramTXSVideoFrame.width > 0))
    {
      if (paramTXSVideoFrame.height <= 0) {
        return;
      }
      paramString = a.f(this.a);
      a.a(this.a, null);
      TXLivePlayer.ITXVideoRawDataListener localITXVideoRawDataListener = a.g(this.a);
      if ((localITXVideoRawDataListener != null) && (paramString != null))
      {
        if (paramString.length >= paramTXSVideoFrame.width * paramTXSVideoFrame.height * 3 / 2)
        {
          paramTXSVideoFrame.loadYUVArray(paramString);
          localITXVideoRawDataListener.onVideoRawDataAvailable(paramString, paramTXSVideoFrame.width, paramTXSVideoFrame.height, (int)paramTXSVideoFrame.pts);
          paramTXSVideoFrame.release();
          return;
        }
        TXCLog.e("TXLivePlayer", "raw data buffer length is too large");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.a.3
 * JD-Core Version:    0.7.0.1
 */