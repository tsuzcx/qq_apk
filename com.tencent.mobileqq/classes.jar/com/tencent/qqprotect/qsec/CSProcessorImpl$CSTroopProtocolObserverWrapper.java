package com.tencent.qqprotect.qsec;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;

class CSProcessorImpl$CSTroopProtocolObserverWrapper
  extends ProtoUtils.TroopProtocolObserver
{
  protected byte[] a;
  protected ICSProcessor.ICSProcessorListener b;
  
  public CSProcessorImpl$CSTroopProtocolObserverWrapper(byte[] paramArrayOfByte, ICSProcessor.ICSProcessorListener paramICSProcessorListener)
  {
    this.a = paramArrayOfByte;
    this.b = paramICSProcessorListener;
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = this.b;
    if (paramBundle != null) {
      paramBundle.a(paramInt, this.a, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CSProcessorImpl.CSTroopProtocolObserverWrapper
 * JD-Core Version:    0.7.0.1
 */