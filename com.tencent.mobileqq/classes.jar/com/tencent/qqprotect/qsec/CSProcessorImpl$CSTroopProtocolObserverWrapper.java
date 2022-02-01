package com.tencent.qqprotect.qsec;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;

class CSProcessorImpl$CSTroopProtocolObserverWrapper
  extends ProtoUtils.TroopProtocolObserver
{
  protected ICSProcessor.ICSProcessorListener a;
  protected byte[] a;
  
  public CSProcessorImpl$CSTroopProtocolObserverWrapper(byte[] paramArrayOfByte, ICSProcessor.ICSProcessorListener paramICSProcessorListener)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentQqprotectQsecICSProcessor$ICSProcessorListener = paramICSProcessorListener;
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = this.jdField_a_of_type_ComTencentQqprotectQsecICSProcessor$ICSProcessorListener;
    if (paramBundle != null) {
      paramBundle.a(paramInt, this.jdField_a_of_type_ArrayOfByte, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CSProcessorImpl.CSTroopProtocolObserverWrapper
 * JD-Core Version:    0.7.0.1
 */