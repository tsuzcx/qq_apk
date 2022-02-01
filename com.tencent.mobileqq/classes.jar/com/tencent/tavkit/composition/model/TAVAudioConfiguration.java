package com.tencent.tavkit.composition.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class TAVAudioConfiguration
{
  private TAVAudioConfiguration.VolumeEdge endVolumeEdge;
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
  
  private Float getEdgesVolume(@NonNull CMTime paramCMTime)
  {
    List localList = this.volumeEdges;
    if ((localList != null) && (!localList.isEmpty())) {
      return Utils.getEdgesVolume(paramCMTime, this.volumeEdges, this.volume);
    }
    return null;
  }
  
  private Float getStartEndVolume(@NonNull CMTime paramCMTime)
  {
    if (Utils.containsTime(paramCMTime, this.startVolumeEdge)) {
      return Float.valueOf(Utils.getEdgeVolumeByTime(paramCMTime, this.startVolumeEdge, this.volume));
    }
    if (Utils.containsTime(paramCMTime, this.endVolumeEdge)) {
      return Float.valueOf(Utils.getEdgeVolumeByTime(paramCMTime, this.endVolumeEdge, this.volume));
    }
    return null;
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
    Float localFloat = getStartEndVolume(paramCMTime);
    if (localFloat != null) {
      return localFloat.floatValue();
    }
    paramCMTime = getEdgesVolume(paramCMTime);
    if (paramCMTime != null) {
      return paramCMTime.floatValue();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVAudioConfiguration{volume=");
    localStringBuilder.append(this.volume);
    localStringBuilder.append(", startVolumeEdge=");
    localStringBuilder.append(this.startVolumeEdge);
    localStringBuilder.append(", endVolumeEdge=");
    localStringBuilder.append(this.endVolumeEdge);
    localStringBuilder.append(", nodes=");
    localStringBuilder.append(this.nodes);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVAudioConfiguration
 * JD-Core Version:    0.7.0.1
 */