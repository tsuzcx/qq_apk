package com.tencent.trtc;

import com.tencent.liteav.basic.log.TXCLog.a;

class TRTCCloud$a
  implements TXCLog.a
{
  private TRTCCloudListener.TRTCLogListener a = null;
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    TRTCCloudListener.TRTCLogListener localTRTCLogListener = this.a;
    if (localTRTCLogListener != null) {
      localTRTCLogListener.onLog(paramString2, paramInt, paramString1);
    }
  }
  
  public void a(TRTCCloudListener.TRTCLogListener paramTRTCLogListener)
  {
    this.a = paramTRTCLogListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloud.a
 * JD-Core Version:    0.7.0.1
 */