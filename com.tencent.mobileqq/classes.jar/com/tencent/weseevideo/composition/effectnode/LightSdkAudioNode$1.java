package com.tencent.weseevideo.composition.effectnode;

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
  AudioMixer jdField_a_of_type_ComTencentTavDecoderAudioMixer = new AudioMixer();
  
  LightSdkAudioNode$1(LightSdkAudioNode paramLightSdkAudioNode) {}
  
  public ByteBuffer processAudioPCM(CMTime paramCMTime, ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo)
  {
    paramAudioInfo = LightSdkAudioNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodeLightSdkAudioNode).copyNextSample();
    if (paramAudioInfo == null) {
      return null;
    }
    paramByteBuffer = paramAudioInfo;
    if (EffectNodeOrderUtils.a(paramCMTime, paramAudioInfo.pts))
    {
      LightSdkAudioNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodeLightSdkAudioNode).seekTo(paramCMTime.getTimeUs());
      paramByteBuffer = LightSdkAudioNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodeLightSdkAudioNode).copyNextSample();
    }
    paramCMTime = paramByteBuffer.data;
    paramCMTime.order(ByteOrder.LITTLE_ENDIAN);
    return this.jdField_a_of_type_ComTencentTavDecoderAudioMixer.processBytes(paramCMTime, 1.0F, LightSdkAudioNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodeLightSdkAudioNode), 1.0F);
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.LightSdkAudioNode.1
 * JD-Core Version:    0.7.0.1
 */