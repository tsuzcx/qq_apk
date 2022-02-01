package com.tencent.mobileqq.qqlive.trtc.engine;

import com.tencent.qphone.base.util.QLog;

class TRTCFakeEngineImpl$1$1
  implements TRTCInitCallback
{
  TRTCFakeEngineImpl$1$1(TRTCFakeEngineImpl.1 param1, int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TRTCServerIPCModule TRTCInitCallback, engine state ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", code ");
    localStringBuilder.append(paramInt2);
    QLog.i("TRTCFakeEngineImpl", 1, localStringBuilder.toString());
    TRTCFakeEngineImpl.a(this.b.d, paramInt1);
    if (paramInt1 == 2) {
      TRTCFakeEngineImpl.b(this.b.d);
    }
    if (this.b.a != null) {
      this.b.a.a(TRTCFakeEngineImpl.a(this.b.d), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.engine.TRTCFakeEngineImpl.1.1
 * JD-Core Version:    0.7.0.1
 */