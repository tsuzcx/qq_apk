package com.tencent.qcircle.weseevideo.composition.effectnode;

import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;

public class WSBGMEffectNode
  implements TAVAudioProcessorNode
{
  public static final String TAG = "WSBGMEffectNode";
  private float bgmVolume = 1.0F;
  
  public TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor()
  {
    return new WSBGMEffectNode.1(this);
  }
  
  public float getBgmVolume()
  {
    return this.bgmVolume;
  }
  
  public String getIdentifier()
  {
    return "WSBGMEffectNode";
  }
  
  public void updateBgmVolume(float paramFloat)
  {
    this.bgmVolume = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.WSBGMEffectNode
 * JD-Core Version:    0.7.0.1
 */