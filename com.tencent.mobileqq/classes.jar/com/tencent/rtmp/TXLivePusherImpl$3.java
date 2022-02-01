package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

class TXLivePusherImpl$3
  implements Runnable
{
  TXLivePusherImpl$3(TXLivePusherImpl paramTXLivePusherImpl, String paramString1, String paramString2) {}
  
  public void run()
  {
    TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
    localTXRecordResult.retCode = 0;
    localTXRecordResult.descMsg = "record success";
    localTXRecordResult.videoPath = this.a;
    localTXRecordResult.coverPath = this.b;
    if (TXLivePusherImpl.j(this.c) != null) {
      TXLivePusherImpl.j(this.c).onRecordComplete(localTXRecordResult);
    }
    TXCLog.w(TXLivePusherImpl.w(), "record complete success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl.3
 * JD-Core Version:    0.7.0.1
 */