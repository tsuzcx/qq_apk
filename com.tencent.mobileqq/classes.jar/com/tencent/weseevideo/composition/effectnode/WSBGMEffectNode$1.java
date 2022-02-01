package com.tencent.weseevideo.composition.effectnode;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;
import java.nio.ByteBuffer;

class WSBGMEffectNode$1
  implements TAVAudioProcessorNode.TAVAudioProcessorEffect
{
  AudioMixer jdField_a_of_type_ComTencentTavDecoderAudioMixer = new AudioMixer();
  
  WSBGMEffectNode$1(WSBGMEffectNode paramWSBGMEffectNode) {}
  
  public ByteBuffer processAudioPCM(CMTime paramCMTime, ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo)
  {
    return this.jdField_a_of_type_ComTencentTavDecoderAudioMixer.processBytes(paramByteBuffer, 1.0F, WSBGMEffectNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodeWSBGMEffectNode), 1.0F);
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSBGMEffectNode.1
 * JD-Core Version:    0.7.0.1
 */