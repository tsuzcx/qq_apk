package com.tencent.tavkit.component;

import android.support.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.utils.TAVTimeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TAVTimeEffectBuilder
{
  private TAVClip clip;
  private TAVTimeEffect[] timeEffects;
  
  public TAVTimeEffectBuilder() {}
  
  public TAVTimeEffectBuilder(TAVClip paramTAVClip, List<TAVTimeEffect> paramList)
  {
    this.clip = paramTAVClip;
    this.timeEffects = ((TAVTimeEffect[])paramList.toArray());
  }
  
  public TAVTimeEffectBuilder(TAVClip paramTAVClip, TAVTimeEffect... paramVarArgs)
  {
    this.clip = paramTAVClip;
    this.timeEffects = paramVarArgs;
  }
  
  private void addSegmentToChannel(TAVClip paramTAVClip, TAVTimeEffectBuilder.TAVClipSegment paramTAVClipSegment, List<TAVClip> paramList)
  {
    paramTAVClip = paramTAVClip.clone();
    paramTAVClip.getResource().setSourceTimeRange(TAVTimeEffectBuilder.TAVClipSegment.access$100(paramTAVClipSegment));
    paramTAVClip.getResource().setScaledDuration(TAVTimeEffectBuilder.TAVClipSegment.access$100(paramTAVClipSegment).getDuration());
    paramList.add(paramTAVClip);
  }
  
  private void addSegmentToChannelWithTimeEffect(TAVClip paramTAVClip, TAVTimeEffectBuilder.TAVClipSegment paramTAVClipSegment, List<TAVClip> paramList)
  {
    int i = 0;
    while (i < TAVTimeEffectBuilder.TAVClipSegment.access$000(paramTAVClipSegment).getLoopCount())
    {
      Object localObject1;
      if ((paramTAVClip.getResource() instanceof TAVAssetTrackResource))
      {
        localObject1 = ((TAVAssetTrackResource)paramTAVClip.getResource()).getAsset();
        if (TAVTimeEffectBuilder.TAVClipSegment.access$000(paramTAVClipSegment).isFreeze())
        {
          localObject1 = new TAVAssetTrackResource((Asset)localObject1);
          localObject2 = new CMTime(1L, 30);
          if (TAVTimeEffectBuilder.TAVClipSegment.access$000(paramTAVClipSegment).isReverse()) {
            ((TAVResource)localObject1).setSourceTimeRange(new CMTimeRange(TAVTimeEffectBuilder.TAVClipSegment.access$100(paramTAVClipSegment).getEnd().sub((CMTime)localObject2), (CMTime)localObject2));
          } else {
            ((TAVResource)localObject1).setSourceTimeRange(new CMTimeRange(TAVTimeEffectBuilder.TAVClipSegment.access$100(paramTAVClipSegment).getStart(), (CMTime)localObject2));
          }
        }
        else
        {
          if (TAVTimeEffectBuilder.TAVClipSegment.access$000(paramTAVClipSegment).isReverse()) {
            localObject1 = new TAVAssetTrackResource((Asset)localObject1);
          } else {
            localObject1 = new TAVAssetTrackResource((Asset)localObject1);
          }
          ((TAVResource)localObject1).setSourceTimeRange(new CMTimeRange(TAVTimeEffectBuilder.TAVClipSegment.access$100(paramTAVClipSegment).getStart(), TAVTimeEffectBuilder.TAVClipSegment.access$000(paramTAVClipSegment).getTimeRange().getDuration().divide(TAVTimeEffectBuilder.TAVClipSegment.access$000(paramTAVClipSegment).getLoopCount())));
        }
      }
      else
      {
        localObject1 = paramTAVClip.getResource().clone();
      }
      if (TAVTimeEffectBuilder.TAVClipSegment.access$000(paramTAVClipSegment).getLoopCount() == 0) {
        ((TAVResource)localObject1).setScaledDuration(TAVTimeEffectBuilder.TAVClipSegment.access$100(paramTAVClipSegment).getDuration());
      } else {
        ((TAVResource)localObject1).setScaledDuration(TAVTimeEffectBuilder.TAVClipSegment.access$100(paramTAVClipSegment).getDuration().divide(TAVTimeEffectBuilder.TAVClipSegment.access$000(paramTAVClipSegment).getLoopCount()));
      }
      if (TAVTimeEffectBuilder.TAVClipSegment.access$000(paramTAVClipSegment).getScaledDuration().value > 0L) {
        if (TAVTimeEffectBuilder.TAVClipSegment.access$000(paramTAVClipSegment).getLoopCount() == 0) {
          ((TAVResource)localObject1).setScaledDuration(TAVTimeEffectBuilder.TAVClipSegment.access$000(paramTAVClipSegment).getScaledDuration());
        } else {
          ((TAVResource)localObject1).setScaledDuration(TAVTimeEffectBuilder.TAVClipSegment.access$000(paramTAVClipSegment).getScaledDuration().divide(TAVTimeEffectBuilder.TAVClipSegment.access$000(paramTAVClipSegment).getLoopCount()));
        }
      }
      Object localObject2 = paramTAVClip.clone();
      ((TAVClip)localObject2).setResource((TAVResource)localObject1);
      paramList.add(localObject2);
      i += 1;
    }
  }
  
  @Nullable
  private List<TAVTimeEffect> availableTimeEffectsFromClip(TAVClip paramTAVClip)
  {
    if (this.timeEffects == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramTAVClip = paramTAVClip.getResource();
    TAVTimeEffect[] arrayOfTAVTimeEffect = this.timeEffects;
    int k = arrayOfTAVTimeEffect.length;
    int i = 0;
    while (i < k)
    {
      TAVTimeEffect localTAVTimeEffect = arrayOfTAVTimeEffect[i];
      CMTimeRange localCMTimeRange1 = TAVTimeUtil.getIntersection(paramTAVClip.getSourceTimeRange(), localTAVTimeEffect.getTimeRange());
      if ((localCMTimeRange1 != null) && (localCMTimeRange1.getDuration().value > 0L))
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          CMTimeRange localCMTimeRange2 = TAVTimeUtil.getIntersection(((TAVTimeEffect)localIterator.next()).getTimeRange(), localCMTimeRange1);
          if ((localCMTimeRange2 != null) && (localCMTimeRange2.getDuration().value > 0L))
          {
            j = 1;
            break label144;
          }
        }
        int j = 0;
        label144:
        if (j == 0) {
          localArrayList.add(localTAVTimeEffect);
        }
      }
      i += 1;
    }
    Collections.sort(localArrayList, new TAVTimeEffectBuilder.1(this));
    return localArrayList;
  }
  
  private void initChannelWithClip(TAVClip paramTAVClip, List<TAVClip> paramList)
  {
    Iterator localIterator = segmentsWithClip(paramTAVClip).iterator();
    while (localIterator.hasNext())
    {
      TAVTimeEffectBuilder.TAVClipSegment localTAVClipSegment = (TAVTimeEffectBuilder.TAVClipSegment)localIterator.next();
      if (TAVTimeEffectBuilder.TAVClipSegment.access$000(localTAVClipSegment) == null) {
        addSegmentToChannel(paramTAVClip, localTAVClipSegment, paramList);
      } else {
        addSegmentToChannelWithTimeEffect(paramTAVClip, localTAVClipSegment, paramList);
      }
    }
  }
  
  private List<TAVTimeEffectBuilder.TAVClipSegment> segmentsWithClip(TAVClip paramTAVClip)
  {
    Object localObject1 = paramTAVClip.getResource();
    Object localObject2 = ((TAVResource)localObject1).getSourceTimeRange().getStart();
    ArrayList localArrayList = new ArrayList();
    paramTAVClip = traverseTimeEffect(paramTAVClip, (TAVResource)localObject1, localArrayList, (CMTime)localObject2);
    localObject1 = ((TAVResource)localObject1).getSourceTimeRange().getEnd().sub(paramTAVClip);
    if (((CMTime)localObject1).value > 0L)
    {
      localObject2 = new TAVTimeEffectBuilder.TAVClipSegment(null);
      TAVTimeEffectBuilder.TAVClipSegment.access$102((TAVTimeEffectBuilder.TAVClipSegment)localObject2, new CMTimeRange(paramTAVClip, (CMTime)localObject1));
      localArrayList.add(localObject2);
    }
    return localArrayList;
  }
  
  private CMTime traverseTimeEffect(TAVClip paramTAVClip, TAVResource paramTAVResource, List<TAVTimeEffectBuilder.TAVClipSegment> paramList, CMTime paramCMTime)
  {
    paramTAVClip = availableTimeEffectsFromClip(paramTAVClip);
    if (paramTAVClip == null) {
      return paramCMTime;
    }
    paramTAVClip = paramTAVClip.iterator();
    while (paramTAVClip.hasNext())
    {
      TAVTimeEffect localTAVTimeEffect = (TAVTimeEffect)paramTAVClip.next();
      CMTime localCMTime = localTAVTimeEffect.getTimeRange().getStart().sub(paramCMTime);
      if (localCMTime.value > 0L)
      {
        TAVTimeEffectBuilder.TAVClipSegment localTAVClipSegment = new TAVTimeEffectBuilder.TAVClipSegment(null);
        TAVTimeEffectBuilder.TAVClipSegment.access$102(localTAVClipSegment, new CMTimeRange(paramCMTime, localCMTime));
        paramList.add(localTAVClipSegment);
      }
      paramCMTime = new TAVTimeEffectBuilder.TAVClipSegment(null);
      TAVTimeEffectBuilder.TAVClipSegment.access$102(paramCMTime, new CMTimeRange(localTAVTimeEffect.getTimeRange().getStart().add(paramTAVResource.getSourceTimeRange().getStart()), localTAVTimeEffect.getTimeRange().getDuration()));
      TAVTimeEffectBuilder.TAVClipSegment.access$002(paramCMTime, localTAVTimeEffect);
      paramList.add(paramCMTime);
      paramCMTime = TAVTimeEffectBuilder.TAVClipSegment.access$100(paramCMTime).getEnd();
    }
    return paramCMTime;
  }
  
  public List<TAVClip> build()
  {
    ArrayList localArrayList = new ArrayList();
    CMTimeRange localCMTimeRange = this.clip.getResource().getSourceTimeRange();
    if ((localCMTimeRange != null) && (localCMTimeRange.getDuration().value != 0L))
    {
      initChannelWithClip(this.clip, localArrayList);
      return localArrayList;
    }
    return null;
  }
  
  public void setClip(TAVClip paramTAVClip)
  {
    this.clip = paramTAVClip;
  }
  
  public void setTimeEffects(TAVTimeEffect[] paramArrayOfTAVTimeEffect)
  {
    this.timeEffects = paramArrayOfTAVTimeEffect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVTimeEffectBuilder
 * JD-Core Version:    0.7.0.1
 */