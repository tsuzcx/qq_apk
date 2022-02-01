package com.tencent.tavkit.composition;

import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.component.effectchain.IVideoEffectContext;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.utils.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVComposition
{
  private List<List<? extends TAVTransitionableAudio>> audioChannels = new ArrayList();
  private List<? extends TAVAudio> audios;
  private int backgroundColor = -16777216;
  private CMTime frameDuration;
  private TAVVideoEffect globalVideoEffect;
  private List<? extends TAVVideo> overlays;
  private VideoComposition.RenderLayoutMode renderLayoutMode;
  private CGSize renderSize;
  private TAVVideoEffect sourceVideoEffect;
  private List<List<? extends TAVTransitionableVideo>> videoChannels = new ArrayList();
  private TAVVideoMixEffect videoMixEffect;
  
  public TAVComposition() {}
  
  public TAVComposition(List<TAVClip> paramList)
  {
    this(paramList, paramList);
  }
  
  public TAVComposition(List<? extends TAVTransitionableVideo> paramList, List<? extends TAVTransitionableAudio> paramList1)
  {
    this();
    addVideoChannel(paramList);
    addAudioChannel(paramList1);
  }
  
  public TAVComposition(TAVClip... paramVarArgs)
  {
    this(ListUtils.listWithObjects(paramVarArgs));
  }
  
  public void addAudioChannel(List<? extends TAVTransitionableAudio> paramList)
  {
    if (this.audioChannels == null) {
      this.audioChannels = new ArrayList();
    }
    this.audioChannels.add(new ArrayList(paramList));
  }
  
  public void addVideoChannel(List<? extends TAVTransitionableVideo> paramList)
  {
    if (this.videoChannels == null) {
      this.videoChannels = new ArrayList();
    }
    this.videoChannels.add(new ArrayList(paramList));
    paramList = this.renderSize;
  }
  
  public void attachVideoEffectChain(IVideoEffectContext paramIVideoEffectContext)
  {
    this.sourceVideoEffect = paramIVideoEffectContext.getSourceVideoEffect();
    this.videoMixEffect = paramIVideoEffectContext.getVideoMixEffect();
    this.globalVideoEffect = paramIVideoEffectContext.getGlobalVideoEffect();
  }
  
  public List<List<? extends TAVTransitionableAudio>> getAudioChannels()
  {
    return this.audioChannels;
  }
  
  public List<? extends TAVAudio> getAudios()
  {
    return this.audios;
  }
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public CMTime getDuration()
  {
    Object localObject1 = this.videoChannels;
    if (localObject1 == null) {
      return CMTime.CMTimeZero;
    }
    int j = ((List)localObject1).size();
    localObject1 = CMTime.CMTimeZero;
    Object localObject2 = CMTime.CMTimeZero;
    int i = 0;
    while (i < j)
    {
      List localList = (List)this.videoChannels.get(i);
      Object localObject3 = localObject1;
      Object localObject4 = localObject2;
      if (localList != null)
      {
        localObject3 = localList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (TAVTransitionableVideo)((Iterator)localObject3).next();
          if (localObject4 != null) {
            localObject2 = ((CMTime)localObject2).add(((TAVTransitionableVideo)localObject4).getDuration());
          }
        }
        localObject3 = localObject1;
        if (((CMTime)localObject2).bigThan((CMTime)localObject1)) {
          localObject3 = localObject2;
        }
        localObject4 = CMTime.CMTimeZero;
      }
      i += 1;
      localObject1 = localObject3;
      localObject2 = localObject4;
    }
    return localObject1;
  }
  
  public CMTime getFrameDuration()
  {
    return this.frameDuration;
  }
  
  public TAVVideoEffect getGlobalVideoEffect()
  {
    return this.globalVideoEffect;
  }
  
  public List<? extends TAVVideo> getOverlays()
  {
    return this.overlays;
  }
  
  public VideoComposition.RenderLayoutMode getRenderLayoutMode()
  {
    return this.renderLayoutMode;
  }
  
  public CGSize getRenderSize()
  {
    return this.renderSize;
  }
  
  public TAVVideoEffect getSourceVideoEffect()
  {
    return this.sourceVideoEffect;
  }
  
  public List<List<? extends TAVTransitionableVideo>> getVideoChannels()
  {
    return this.videoChannels;
  }
  
  public TAVVideoMixEffect getVideoMixEffect()
  {
    return this.videoMixEffect;
  }
  
  public void setAudioChannels(List<List<? extends TAVTransitionableAudio>> paramList)
  {
    this.audioChannels = paramList;
  }
  
  public void setAudios(List<? extends TAVAudio> paramList)
  {
    this.audios = paramList;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
  
  public void setFrameDuration(CMTime paramCMTime)
  {
    this.frameDuration = paramCMTime;
  }
  
  public void setGlobalVideoEffect(TAVVideoEffect paramTAVVideoEffect)
  {
    this.globalVideoEffect = paramTAVVideoEffect;
  }
  
  public void setOverlays(List<? extends TAVVideo> paramList)
  {
    this.overlays = paramList;
  }
  
  public void setRenderLayoutMode(VideoComposition.RenderLayoutMode paramRenderLayoutMode)
  {
    this.renderLayoutMode = paramRenderLayoutMode;
  }
  
  public void setRenderSize(CGSize paramCGSize)
  {
    this.renderSize = paramCGSize;
  }
  
  public void setSourceVideoEffect(TAVVideoEffect paramTAVVideoEffect)
  {
    this.sourceVideoEffect = paramTAVVideoEffect;
  }
  
  public void setVideoChannels(List<List<? extends TAVTransitionableVideo>> paramList)
  {
    this.videoChannels = paramList;
  }
  
  public void setVideoMixEffect(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    this.videoMixEffect = paramTAVVideoMixEffect;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVComposition{\nrenderSize=");
    localStringBuilder.append(this.renderSize);
    localStringBuilder.append(", renderLayoutMode=");
    localStringBuilder.append(this.renderLayoutMode);
    localStringBuilder.append(", backgroundColor=");
    localStringBuilder.append(this.backgroundColor);
    localStringBuilder.append(", frameDuration=");
    localStringBuilder.append(this.frameDuration);
    localStringBuilder.append("\nvideoChannels=");
    localStringBuilder.append(this.videoChannels);
    localStringBuilder.append("\naudioChannels=");
    localStringBuilder.append(this.audioChannels);
    localStringBuilder.append("\noverlays=");
    localStringBuilder.append(this.overlays);
    localStringBuilder.append("\naudios=");
    localStringBuilder.append(this.audios);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.composition.TAVComposition
 * JD-Core Version:    0.7.0.1
 */