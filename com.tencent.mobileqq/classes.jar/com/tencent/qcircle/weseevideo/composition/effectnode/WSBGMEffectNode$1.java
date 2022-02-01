package com.tencent.qcircle.weseevideo.composition.effectnode;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;
import java.nio.ByteBuffer;

class WSBGMEffectNode$1
  implements TAVAudioProcessorNode.TAVAudioProcessorEffect
{
  AudioMixer audioMixer = new AudioMixer();
  
  WSBGMEffectNode$1(WSBGMEffectNode paramWSBGMEffectNode) {}
  
  public ByteBuffer processAudioPCM(CMTime paramCMTime, ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo)
  {
    return this.audioMixer.processBytes(paramByteBuffer, 1.0F, WSBGMEffectNode.access$000(this.this$0), 1.0F);
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.WSBGMEffectNode.1
 * JD-Core Version:    0.7.0.1
 */