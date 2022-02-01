package com.tencent.tav.core;

import java.util.Iterator;
import java.util.List;

public class AudioMix<InputParameters extends AudioMixInputParameters>
{
  protected List<InputParameters> inputParameters;
  
  public AudioMix(List<InputParameters> paramList)
  {
    this.inputParameters = paramList;
  }
  
  public List<InputParameters> getInputParameters()
  {
    return this.inputParameters;
  }
  
  public InputParameters getInputParametersWithTrackID(int paramInt)
  {
    Iterator localIterator = this.inputParameters.iterator();
    while (localIterator.hasNext())
    {
      AudioMixInputParameters localAudioMixInputParameters = (AudioMixInputParameters)localIterator.next();
      if (localAudioMixInputParameters.getTrackID() == paramInt) {
        return localAudioMixInputParameters;
      }
    }
    return null;
  }
  
  public void release()
  {
    Iterator localIterator = this.inputParameters.iterator();
    while (localIterator.hasNext())
    {
      AudioMixInputParameters localAudioMixInputParameters = (AudioMixInputParameters)localIterator.next();
      if ((localAudioMixInputParameters != null) && (localAudioMixInputParameters.getAudioTapProcessor() != null)) {
        localAudioMixInputParameters.getAudioTapProcessor().release();
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioMix{inputParameters=");
    localStringBuilder.append(this.inputParameters);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.AudioMix
 * JD-Core Version:    0.7.0.1
 */