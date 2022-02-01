package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import com.qwallet.temp.IQWalletTemp.ITempString;

class VoiceRedPacketHelperImpl$4
  implements IQWalletTemp.ITempString
{
  VoiceRedPacketHelperImpl$4(VoiceRedPacketHelperImpl paramVoiceRedPacketHelperImpl, VoiceRedPacketHelperImpl.OnGetSkeyListener paramOnGetSkeyListener) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.a.a(paramString);
      return;
    }
    this.b.onError(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl.4
 * JD-Core Version:    0.7.0.1
 */