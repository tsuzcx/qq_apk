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
    if (this.renderSize == null) {}
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
    if (this.videoChannels == null) {
      localObject3 = CMTime.CMTimeZero;
    }
    int j;
    Object localObject1;
    Object localObject2;
    int i;
    do
    {
      return localObject3;
      j = this.videoChannels.size();
      localObject1 = CMTime.CMTimeZero;
      localObject2 = CMTime.CMTimeZero;
      i = 0;
      localObject3 = localObject1;
    } while (i >= j);
    List localList = (List)this.videoChannels.get(i);
    Object localObject4 = localObject2;
    Object localObject3 = localObject1;
    if (localList != null)
    {
      localObject3 = localList.iterator();
      label80:
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (TAVTransitionableVideo)((Iterator)localObject3).next();
        if (localObject4 == null) {
          break label162;
        }
        localObject2 = ((CMTime)localObject2).add(((TAVTransitionableVideo)localObject4).getDuration());
      }
    }
    label162:
    for (;;)
    {
      break label80;
      if (((CMTime)localObject2).bigThan((CMTime)localObject1)) {}
      for (;;)
      {
        localObject4 = CMTime.CMTimeZero;
        localObject3 = localObject2;
        i += 1;
        localObject2 = localObject4;
        localObject1 = localObject3;
        break;
        localObject2 = localObject1;
      }
    }
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
    return "TAVComposition{\nrenderSize=" + this.renderSize + ", renderLayoutMode=" + this.renderLayoutMode + ", backgroundColor=" + this.backgroundColor + ", frameDuration=" + this.frameDuration + "\nvideoChannels=" + this.videoChannels + "\naudioChannels=" + this.audioChannels + "\noverlays=" + this.overlays + "\naudios=" + this.audios + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.TAVComposition
 * JD-Core Version:    0.7.0.1
 */