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
    Object localObject = this.startVolumeEdge;
    float f1;
    float f2;
    if ((localObject != null) && (((TAVAudioConfiguration.VolumeEdge)localObject).getTimeRange() != null) && (this.startVolumeEdge.getTimeRange().containsTime(paramCMTime)))
    {
      f1 = this.volume;
      localObject = this.startVolumeEdge;
      f2 = ((TAVAudioConfiguration.VolumeEdge)localObject).getVolume(paramCMTime.sub(((TAVAudioConfiguration.VolumeEdge)localObject).getTimeRange().getStart()));
    }
    for (;;)
    {
      return f1 * f2;
      localObject = this.endVolumeEdge;
      if ((localObject != null) && (((TAVAudioConfiguration.VolumeEdge)localObject).getTimeRange() != null) && (this.endVolumeEdge.getTimeRange().containsTime(paramCMTime)))
      {
        f1 = this.volume;
        localObject = this.endVolumeEdge;
        f2 = ((TAVAudioConfiguration.VolumeEdge)localObject).getVolume(paramCMTime.sub(((TAVAudioConfiguration.VolumeEdge)localObject).getTimeRange().getStart()));
      }
      else
      {
        localObject = this.volumeEdges;
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break;
        }
        localObject = this.volumeEdges.iterator();
        TAVAudioConfiguration.VolumeEdge localVolumeEdge;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localVolumeEdge = (TAVAudioConfiguration.VolumeEdge)((Iterator)localObject).next();
        } while ((localVolumeEdge == null) || (localVolumeEdge.getTimeRange() == null) || (!localVolumeEdge.getTimeRange().containsTime(paramCMTime)));
        f1 = this.volume;
        f2 = localVolumeEdge.getVolume(paramCMTime.sub(localVolumeEdge.getTimeRange().getStart()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVAudioConfiguration
 * JD-Core Version:    0.7.0.1
 */