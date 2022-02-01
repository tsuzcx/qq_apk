package com.tencent.tavkit.composition.audio;

import android.support.annotation.NonNull;
import com.tencent.tav.core.AudioTapProcessor;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TAVAudioTapProcessor
  implements AudioTapProcessor
{
  private final List<TAVAudioConfigurationSegment> audioConfigurationSegmentList;
  private final HashMap<String, AudioTapProcessor> audioTapProcessorHashMap = new HashMap();
  
  public TAVAudioTapProcessor(@NonNull List<TAVAudioConfigurationSegment> paramList)
  {
    this.audioConfigurationSegmentList = paramList;
  }
  
  public AudioTapProcessor getAudioTapProcessor(TAVAudioProcessorNode paramTAVAudioProcessorNode)
  {
    String str = paramTAVAudioProcessorNode.getIdentifier();
    AudioTapProcessor localAudioTapProcessor = (AudioTapProcessor)this.audioTapProcessorHashMap.get(str);
    Object localObject = localAudioTapProcessor;
    if (localAudioTapProcessor == null)
    {
      localObject = paramTAVAudioProcessorNode.createAudioProcessor();
      this.audioTapProcessorHashMap.put(str, localObject);
    }
    return localObject;
  }
  
  public ByteBuffer processAudioPCM(CMTime paramCMTime, ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo)
  {
    Iterator localIterator = this.audioConfigurationSegmentList.iterator();
    while (localIterator.hasNext()) {
      paramByteBuffer = processAudioPCM(paramCMTime, paramByteBuffer, paramAudioInfo, (TAVAudioConfigurationSegment)localIterator.next());
    }
    return paramByteBuffer;
  }
  
  public ByteBuffer processAudioPCM(CMTime paramCMTime, ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo, TAVAudioConfigurationSegment paramTAVAudioConfigurationSegment)
  {
    ByteBuffer localByteBuffer = paramByteBuffer;
    if (paramTAVAudioConfigurationSegment != null)
    {
      if (!paramTAVAudioConfigurationSegment.compositionTimeRange.containsTime(paramCMTime)) {
        return paramByteBuffer;
      }
      paramTAVAudioConfigurationSegment = paramTAVAudioConfigurationSegment.audioConfiguration;
      if (paramTAVAudioConfigurationSegment.getNodes() == null) {
        return paramByteBuffer;
      }
      paramTAVAudioConfigurationSegment = paramTAVAudioConfigurationSegment.getNodes().iterator();
      for (;;)
      {
        localByteBuffer = paramByteBuffer;
        if (!paramTAVAudioConfigurationSegment.hasNext()) {
          break;
        }
        paramByteBuffer = processAudioPcm(paramCMTime, paramByteBuffer, paramAudioInfo, (TAVAudioProcessorNode)paramTAVAudioConfigurationSegment.next());
      }
    }
    return localByteBuffer;
  }
  
  public ByteBuffer processAudioPcm(CMTime paramCMTime, ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo, TAVAudioProcessorNode paramTAVAudioProcessorNode)
  {
    AudioTapProcessor localAudioTapProcessor = getAudioTapProcessor(paramTAVAudioProcessorNode);
    paramTAVAudioProcessorNode = paramByteBuffer;
    if (localAudioTapProcessor != null) {
      paramTAVAudioProcessorNode = localAudioTapProcessor.processAudioPCM(paramCMTime, paramByteBuffer, paramAudioInfo);
    }
    return paramTAVAudioProcessorNode;
  }
  
  public void release()
  {
    Iterator localIterator = this.audioTapProcessorHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((AudioTapProcessor)localIterator.next()).release();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVAudioTapProcessor{audioConfigurationSegmentList=");
    localStringBuilder.append(this.audioConfigurationSegmentList);
    localStringBuilder.append(", audioTapProcessorHashMap=");
    localStringBuilder.append(this.audioTapProcessorHashMap);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.audio.TAVAudioTapProcessor
 * JD-Core Version:    0.7.0.1
 */