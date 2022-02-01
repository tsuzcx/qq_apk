package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

class b$12
  implements Runnable
{
  b$12(b paramb, String paramString1, String paramString2) {}
  
  public void run()
  {
    TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
    localTXRecordResult.retCode = 0;
    localTXRecordResult.descMsg = "record success";
    localTXRecordResult.videoPath = this.a;
    localTXRecordResult.coverPath = this.b;
    if (b.g(this.c) != null) {
      b.g(this.c).onRecordComplete(localTXRecordResult);
    }
    TXCLog.w(b.x(), "record complete success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.b.12
 * JD-Core Version:    0.7.0.1
 */