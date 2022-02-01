package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

class TXLivePusherImpl$2
  implements Runnable
{
  TXLivePusherImpl$2(TXLivePusherImpl paramTXLivePusherImpl) {}
  
  public void run()
  {
    TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
    localTXRecordResult.retCode = -1;
    localTXRecordResult.descMsg = "record video failed";
    if (TXLivePusherImpl.j(this.a) != null) {
      TXLivePusherImpl.j(this.a).onRecordComplete(localTXRecordResult);
    }
    TXCLog.w(TXLivePusherImpl.w(), "record complete fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl.2
 * JD-Core Version:    0.7.0.1
 */