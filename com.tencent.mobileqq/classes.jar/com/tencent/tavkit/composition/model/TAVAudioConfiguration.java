package com.tencent.tavkit.composition.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVAudioConfiguration
{
  private TAVAudioConfiguration.VolumeEdge endVolumeEdge;
  @NonNull
  private final List<TAVAudioProcessorNode> nodes;
  private TAVAudioConfiguration.VolumeEdge startVolumeEdge;
  private float volume;
  private List<TAVAudioConfiguration.VolumeEdge> volumeEdges;
  
  public TAVAudioConfiguration()
  {
    this(1.0F);
  }
  
  public TAVAudioConfiguration(float paramFloat)
  {
    this(paramFloat, null, null);
  }
  
  public TAVAudioConfiguration(float paramFloat, List<TAVAudioProcessorNode> paramList)
  {
    this(paramFloat, paramList, null);
  }
  
  public TAVAudioConfiguration(float paramFloat, List<TAVAudioProcessorNode> paramList, List<TAVAudioConfiguration.VolumeEdge> paramList1)
  {
    this.volume = paramFloat;
    this.nodes = new ArrayList();
    if (paramList != null) {
      this.nodes.addAll(paramList);
    }
    this.volumeEdges = new ArrayList();
    if (paramList1 != null) {
      this.volumeEdges.addAll(paramList1);
    }
  }
  
  public TAVAudioConfiguration(List<TAVAudioConfiguration.VolumeEdge> paramList)
  {
    this(1.0F, null, paramList);
  }
  
  public void addAudioProcessorNode(@NonNull TAVAudioProcessorNode paramTAVAudioProcessorNode)
  {
    this.nodes.add(paramTAVAudioProcessorNode);
  }
  
  public void addVolumeEdge(TAVAudioConfiguration.VolumeEdge paramVolumeEdge)
  {
    if (paramVolumeEdge == null) {
      return;
    }
    if (this.volumeEdges == null) {
      this.volumeEdges = new ArrayList();
    }
    this.volumeEdges.add(0, paramVolumeEdge);
  }
  
  public TAVAudioConfiguration clone()
  {
    return new TAVAudioConfiguration(this.volume, this.nodes);
  }
  
  public TAVAudioConfiguration.VolumeEdge getEndVolumeEdge()
  {
    return this.endVolumeEdge;
  }
  
  public List<TAVAudioProcessorNode> getNodes()
  {
    return this.nodes;
  }
  
  public TAVAudioConfiguration.VolumeEdge getStartVolumeEdge()
  {
    return this.startVolumeEdge;
  }
  
  public float getVolume()
  {
    return this.volume;
  }
  
  public float getVolume(@NonNull CMTime paramCMTime)
  {
    if ((this.startVolumeEdge != null) && (this.startVolumeEdge.getTimeRange() != null) && (this.startVolumeEdge.getTimeRange().containsTime(paramCMTime))) {
      return this.startVolumeEdge.getVolume(paramCMTime.sub(this.startVolumeEdge.getTimeRange().getStart()));
    }
    if ((this.endVolumeEdge != null) && (this.endVolumeEdge.getTimeRange() != null) && (this.endVolumeEdge.getTimeRange().containsTime(paramCMTime))) {
      return this.endVolumeEdge.getVolume(paramCMTime.sub(this.endVolumeEdge.getTimeRange().getStart()));
    }
    if ((this.volumeEdges != null) && (!this.volumeEdges.isEmpty()))
    {
      Iterator localIterator = this.volumeEdges.iterator();
      while (localIterator.hasNext())
      {
        TAVAudioConfiguration.VolumeEdge localVolumeEdge = (TAVAudioConfiguration.VolumeEdge)localIterator.next();
        if ((localVolumeEdge != null) && (localVolumeEdge.getTimeRange() != null) && (localVolumeEdge.getTimeRange().containsTime(paramCMTime))) {
          return localVolumeEdge.getVolume(paramCMTime.sub(localVolumeEdge.getTimeRange().getStart()));
        }
      }
    }
    return this.volume;
  }
  
  public void setAudioProcessorNodes(@Nullable List<TAVAudioProcessorNode> paramList)
  {
    this.nodes.clear();
    if (paramList != null) {
      this.nodes.addAll(paramList);
    }
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
  
  public String toString()
  {
    return "TAVAudioConfiguration{volume=" + this.volume + ", startVolumeEdge=" + this.startVolumeEdge + ", endVolumeEdge=" + this.endVolumeEdge + ", nodes=" + this.nodes + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVAudioConfiguration
 * JD-Core Version:    0.7.0.1
 */