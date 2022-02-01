package com.tencent.mobileqq.voicechange.impl;

import android.content.Context;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioComponentProcessor;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper;
import com.tencent.mobileqq.voicechange.VoiceChange;

public class VoiceChangeHelperImpl
  implements IVoiceChangeHelper
{
  public AudioComponentProcessor createVoiceChangeObj(Context paramContext, int paramInt, String paramString)
  {
    return new VoiceChange(paramContext, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.impl.VoiceChangeHelperImpl
 * JD-Core Version:    0.7.0.1
 */