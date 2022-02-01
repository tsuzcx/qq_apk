package com.tencent.weseevideo.composition.effectnode;

import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;

public class WSBGMEffectNode
  implements TAVAudioProcessorNode
{
  private float a = 1.0F;
  
  public void a(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor()
  {
    return new WSBGMEffectNode.1(this);
  }
  
  public String getIdentifier()
  {
    return "WSBGMEffectNode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSBGMEffectNode
 * JD-Core Version:    0.7.0.1
 */