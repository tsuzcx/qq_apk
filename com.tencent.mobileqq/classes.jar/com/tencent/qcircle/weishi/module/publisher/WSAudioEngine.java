package com.tencent.qcircle.weishi.module.publisher;

import com.tencent.qcircle.weseevideo.composition.effectnode.LightSdkAudioNode;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSBGMEffectNode;
import com.tencent.qcircle.weseevideo.model.utils.AudioUtils;
import com.tencent.qcircle.weseevideo.model.utils.AudioUtils.AudioSymbol;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.utils.ListUtils;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.light.AudioOutput;

public class WSAudioEngine
{
  public static final int SAMPLE_COUNT = 2048;
  private static final String TAG = "WSAudioEngine";
  private LightSdkAudioNode audioNode;
  private AudioOutput audioReader;
  private WSBGMEffectNode bgmNode;
  private TAVComposition composition;
  
  public WSAudioEngine(TAVComposition paramTAVComposition, AudioOutput paramAudioOutput)
  {
    this.composition = paramTAVComposition;
    this.audioReader = paramAudioOutput;
    this.bgmNode = new WSBGMEffectNode();
    this.audioNode = new LightSdkAudioNode(this.audioReader);
  }
  
  public void initBgm(List<? extends TAVClip> paramList, float paramFloat)
  {
    if (CollectionUtil.isEmptyList(paramList)) {
      return;
    }
    this.bgmNode.updateBgmVolume(paramFloat);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      TAVClip localTAVClip = (TAVClip)localIterator.next();
      TAVAudioConfiguration localTAVAudioConfiguration = new TAVAudioConfiguration();
      localTAVAudioConfiguration.setVolume(paramFloat);
      localTAVAudioConfiguration.setAudioProcessorNodes(ListUtils.listWithObjects(new TAVAudioProcessorNode[] { this.bgmNode }));
      localTAVClip.setAudioConfiguration(localTAVAudioConfiguration);
    }
    AudioUtils.markAudioSymbol(AudioUtils.AudioSymbol.BGM, paramList);
    AudioUtils.updateCompositionAudiosBySymbol(this.composition, paramList, AudioUtils.AudioSymbol.BGM);
  }
  
  public void initEmptyClip(float paramFloat)
  {
    this.audioNode.updateVideoVolume(paramFloat);
    TAVClip localTAVClip = new TAVClip(this.composition.getDuration(), true);
    Object localObject = new TAVAudioConfiguration();
    ((TAVAudioConfiguration)localObject).setVolume(paramFloat);
    ((TAVAudioConfiguration)localObject).setAudioProcessorNodes(ListUtils.listWithObjects(new TAVAudioProcessorNode[] { this.audioNode }));
    localTAVClip.setAudioConfiguration((TAVAudioConfiguration)localObject);
    localObject = new ArrayList();
    ((List)localObject).add(localTAVClip);
    this.composition.addAudioChannel((List)localObject);
  }
  
  public void initTTS(List<? extends TAVClip> paramList)
  {
    if (CollectionUtil.isEmptyList(paramList)) {
      return;
    }
    AudioUtils.updateCompositionAudiosBySymbol(this.composition, paramList, AudioUtils.AudioSymbol.TTS);
  }
  
  public void updateBgm(List<? extends TAVClip> paramList)
  {
    if (CollectionUtil.isEmptyList(paramList)) {
      return;
    }
    this.composition.setAudios(null);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      TAVClip localTAVClip = (TAVClip)localIterator.next();
      TAVAudioConfiguration localTAVAudioConfiguration = new TAVAudioConfiguration();
      localTAVAudioConfiguration.setAudioProcessorNodes(ListUtils.listWithObjects(new TAVAudioProcessorNode[] { this.bgmNode }));
      localTAVClip.setAudioConfiguration(localTAVAudioConfiguration);
    }
    this.composition.setAudios(paramList);
  }
  
  public void updateBgmVolume(float paramFloat)
  {
    this.bgmNode.updateBgmVolume(paramFloat);
  }
  
  public void updateVideoVolume(float paramFloat)
  {
    this.audioNode.updateVideoVolume(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weishi.module.publisher.WSAudioEngine
 * JD-Core Version:    0.7.0.1
 */