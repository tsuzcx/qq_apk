package com.tencent.weseevideo.composition.effectnode;

import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;
import org.light.AudioOutput;

public class LightSdkAudioNode
  implements TAVAudioProcessorNode
{
  private float jdField_a_of_type_Float = 1.0F;
  private AudioOutput jdField_a_of_type_OrgLightAudioOutput;
  
  public LightSdkAudioNode(AudioOutput paramAudioOutput)
  {
    this.jdField_a_of_type_OrgLightAudioOutput = paramAudioOutput;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor()
  {
    return new LightSdkAudioNode.1(this);
  }
  
  public String getIdentifier()
  {
    return "LightSdkAudioNode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.LightSdkAudioNode
 * JD-Core Version:    0.7.0.1
 */