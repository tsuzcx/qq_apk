package com.tencent.tavmovie.base;

import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration.VolumeEdge;

public class TAVMovieAudioConfiguration
  implements Cloneable
{
  private TAVAudioConfiguration.VolumeEdge endVolumeEdge;
  private TAVAudioConfiguration.VolumeEdge startVolumeEdge;
  private float volume = 1.0F;
  
  public TAVMovieAudioConfiguration clone()
  {
    TAVMovieAudioConfiguration localTAVMovieAudioConfiguration = new TAVMovieAudioConfiguration();
    localTAVMovieAudioConfiguration.volume = this.volume;
    localTAVMovieAudioConfiguration.startVolumeEdge = this.startVolumeEdge;
    localTAVMovieAudioConfiguration.endVolumeEdge = this.endVolumeEdge;
    return localTAVMovieAudioConfiguration;
  }
  
  public TAVAudioConfiguration convertToConfiguration()
  {
    TAVAudioConfiguration localTAVAudioConfiguration = new TAVAudioConfiguration();
    localTAVAudioConfiguration.setVolume(this.volume);
    localTAVAudioConfiguration.setStartVolumeEdge(this.startVolumeEdge);
    localTAVAudioConfiguration.setEndVolumeEdge(this.endVolumeEdge);
    return localTAVAudioConfiguration;
  }
  
  public TAVAudioConfiguration.VolumeEdge getEndVolumeEdge()
  {
    return this.endVolumeEdge;
  }
  
  public TAVAudioConfiguration.VolumeEdge getStartVolumeEdge()
  {
    return this.startVolumeEdge;
  }
  
  public float getVolume()
  {
    return this.volume;
  }
  
  public void setEndVolumeEdge(TAVAudioConfiguration.VolumeEdge paramVolumeEdge)
  {
    this.endVolumeEdge = paramVolumeEdge;
  }
  
  public void setStartVolumeEdge(TAVAudioConfiguration.VolumeEdge paramVolumeEdge)
  {
    this.startVolumeEdge = paramVolumeEdge;
  }
  
  public void setVolume(float paramFloat)
  {
    this.volume = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.base.TAVMovieAudioConfiguration
 * JD-Core Version:    0.7.0.1
 */