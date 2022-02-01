package com.tencent.tavcut.render.audio.voicechanger;

import com.tencent.tavcut.render.log.TavLogger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/audio/voicechanger/VoiceChanger;", "", "sampleRate", "", "voiceKind", "environment", "(III)V", "changeFrames", "", "recordedFrame", "initVoiceChanger", "", "release", "", "releaseVoiceChanger", "short2Byte", "", "sData", "writeVoiceFrameByShort", "writeVoiceFrames", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class VoiceChanger
{
  public static final VoiceChanger.Companion a = new VoiceChanger.Companion(null);
  
  static
  {
    try
    {
      System.loadLibrary("voicechanger_shared");
      System.loadLibrary("tavcut_voice");
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("voice changer loadLibrary Error:");
      localStringBuilder.append(localException.getMessage());
      TavLogger.e("VoiceChanger", localStringBuilder.toString());
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("voice changer UnsatisfiedLinkError:");
      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
      TavLogger.e("VoiceChanger", localStringBuilder.toString());
    }
  }
  
  private final native short[] changeFrames(short[] paramArrayOfShort);
  
  private final native long initVoiceChanger(int paramInt1, int paramInt2, int paramInt3);
  
  private final native void releaseVoiceChanger();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.audio.voicechanger.VoiceChanger
 * JD-Core Version:    0.7.0.1
 */