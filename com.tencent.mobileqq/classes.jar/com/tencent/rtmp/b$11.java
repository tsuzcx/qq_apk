package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

class b$11
  implements Runnable
{
  b$11(b paramb) {}
  
  public void run()
  {
    TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
    localTXRecordResult.retCode = -1;
    localTXRecordResult.descMsg = "record video failed";
    if (b.g(this.a) != null) {
      b.g(this.a).onRecordComplete(localTXRecordResult);
    }
    TXCLog.w(b.x(), "record complete fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.b.11
 * JD-Core Version:    0.7.0.1
 */