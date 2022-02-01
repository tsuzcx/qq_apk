package com.tencent.qcircle.weseevideo.composition.effectnode;

import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;
import org.light.AudioOutput;

public class LightSdkAudioNode
  implements TAVAudioProcessorNode
{
  public static final String TAG = "LightSdkAudioNode";
  private AudioOutput audioReader;
  private float videoVolume = 1.0F;
  
  public LightSdkAudioNode(AudioOutput paramAudioOutput)
  {
    this.audioReader = paramAudioOutput;
  }
  
  public TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor()
  {
    return new LightSdkAudioNode.1(this);
  }
  
  public String getIdentifier()
  {
    return "LightSdkAudioNode";
  }
  
  public float getVideoVolume()
  {
    return this.videoVolume;
  }
  
  public void updateVideoVolume(float paramFloat)
  {
    this.videoVolume = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.LightSdkAudioNode
 * JD-Core Version:    0.7.0.1
 */