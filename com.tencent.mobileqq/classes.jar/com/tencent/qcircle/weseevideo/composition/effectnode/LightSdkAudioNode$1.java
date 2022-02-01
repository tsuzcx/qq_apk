package com.tencent.qcircle.weseevideo.composition.effectnode;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.light.AudioFrame;
import org.light.AudioOutput;

class LightSdkAudioNode$1
  implements TAVAudioProcessorNode.TAVAudioProcessorEffect
{
  AudioMixer audioMixer = new AudioMixer();
  
  LightSdkAudioNode$1(LightSdkAudioNode paramLightSdkAudioNode) {}
  
  public ByteBuffer processAudioPCM(CMTime paramCMTime, ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo)
  {
    paramAudioInfo = LightSdkAudioNode.access$000(this.this$0).copyNextSample();
    if (paramAudioInfo == null) {
      return null;
    }
    paramByteBuffer = paramAudioInfo;
    if (EffectNodeOrderUtils.shouldSeek(paramCMTime, paramAudioInfo.pts))
    {
      LightSdkAudioNode.access$000(this.this$0).seekTo(paramCMTime.getTimeUs());
      paramByteBuffer = LightSdkAudioNode.access$000(this.this$0).copyNextSample();
    }
    paramCMTime = paramByteBuffer.data;
    paramCMTime.order(ByteOrder.LITTLE_ENDIAN);
    return this.audioMixer.processBytes(paramCMTime, 1.0F, LightSdkAudioNode.access$100(this.this$0), 1.0F);
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.LightSdkAudioNode.1
 * JD-Core Version:    0.7.0.1
 */