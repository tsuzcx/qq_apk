package com.tencent.tavkit.composition.audio;

public abstract interface TAVAudioProcessorNode
{
  public abstract TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor();
  
  public abstract String getIdentifier();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.audio.TAVAudioProcessorNode
 * JD-Core Version:    0.7.0.1
 */