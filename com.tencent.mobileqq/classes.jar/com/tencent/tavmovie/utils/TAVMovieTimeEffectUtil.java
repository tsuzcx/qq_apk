package com.tencent.tavmovie.utils;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.component.TAVTimeEffect;
import com.tencent.tavkit.component.TAVTimeEffectBuilder;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TAVMovieTimeEffectUtil
{
  private static List<TAVTimeEffect> adjustTimeEffects(List<TAVClip> paramList, List<TAVTimeEffect> paramList1)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramList1 == null) || (paramList1.size() == 0)) {
      return paramList1;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = ((TAVClip)paramList.get(0)).getResource().getSourceTimeRange().getStart().sub(((TAVTimeEffect)paramList1.get(0)).getTimeRange().getStart());
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      TAVTimeEffect localTAVTimeEffect1 = (TAVTimeEffect)paramList1.next();
      TAVTimeEffect localTAVTimeEffect2 = new TAVTimeEffect();
      localTAVTimeEffect2.setTimeRange(new CMTimeRange(localTAVTimeEffect1.getTimeRange().getStart().add(paramList), localTAVTimeEffect1.getTimeRange().getDuration()));
      localTAVTimeEffect2.setScaledDuration(localTAVTimeEffect1.getScaledDuration());
      localTAVTimeEffect2.setReverse(localTAVTimeEffect1.isReverse());
      localTAVTimeEffect2.setFreeze(localTAVTimeEffect1.isFreeze());
      localTAVTimeEffect2.setLoopCount(localTAVTimeEffect1.getLoopCount());
      localArrayList.add(localTAVTimeEffect2);
    }
    return localArrayList;
  }
  
  public static List<TAVClip> applyTimeEffects(List<TAVClip> paramList, List<TAVMovieTimeEffect> paramList1)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = paramList1.iterator();
    while (((Iterator)localObject1).hasNext()) {
      localArrayList2.add(((TAVMovieTimeEffect)((Iterator)localObject1).next()).calculateSourceDuration());
    }
    int i = 0;
    for (;;)
    {
      if ((i >= localArrayList2.size()) || (paramList.isEmpty())) {
        return localArrayList1;
      }
      CMTime localCMTime = (CMTime)localArrayList2.get(i);
      localObject1 = (TAVMovieTimeEffect)paramList1.get(i);
      int k = ((TAVMovieTimeEffect)localObject1).getLoop();
      float f = ((TAVMovieTimeEffect)localObject1).getSpeed();
      localObject1 = (TAVClip)paramList.remove(0);
      Object localObject2 = ((TAVClip)localObject1).getResource().getSourceTimeRange().getDuration();
      ArrayList localArrayList3 = new ArrayList();
      int j;
      if (((CMTime)localObject2).equalsTo(localCMTime))
      {
        j = 0;
        while (j < k)
        {
          ((TAVClip)localObject1).getResource().setScaledDuration(((TAVClip)localObject1).getResource().getSourceTimeRange().getDuration().divide(f));
          localArrayList3.add(((TAVClip)localObject1).clone());
          j += 1;
        }
      }
      Object localObject3;
      Object localObject4;
      if (((CMTime)localObject2).bigThan(localCMTime))
      {
        localObject2 = ((CMTime)localObject2).sub(localCMTime);
        localObject3 = ((TAVClip)localObject1).getResource().getSourceTimeRange().getStart();
        localObject4 = ((TAVClip)localObject1).clone();
        ((TAVClip)localObject4).getResource().setSourceTimeRange(new CMTimeRange(((CMTime)localObject3).add(localCMTime), (CMTime)localObject2));
        paramList.add(0, localObject4);
        ((TAVClip)localObject1).getResource().setSourceTimeRange(new CMTimeRange((CMTime)localObject3, localCMTime));
        j = 0;
        while (j < k)
        {
          ((TAVClip)localObject1).getResource().setScaledDuration(((TAVClip)localObject1).getResource().getSourceTimeRange().getDuration().divide(f));
          localArrayList3.add(((TAVClip)localObject1).clone());
          j += 1;
        }
      }
      if (((CMTime)localObject2).smallThan(localCMTime))
      {
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject1);
        localObject2 = localCMTime.sub((CMTime)localObject2);
        localObject1 = CMTime.CMTimeZero;
        if ((!((CMTime)localObject2).bigThan(CMTime.CMTimeZero)) || (paramList.isEmpty()))
        {
          if (((CMTime)localObject1).bigThan(localCMTime))
          {
            localObject2 = (TAVClip)((List)localObject3).get(((List)localObject3).size() - 1);
            localObject4 = ((TAVClip)localObject2).clone();
            localObject1 = ((CMTime)localObject1).sub(localCMTime);
            localCMTime = ((TAVClip)localObject2).getResource().getSourceTimeRange().getDuration().sub((CMTime)localObject1);
            ((TAVClip)localObject2).getResource().setSourceTimeRange(new CMTimeRange(((TAVClip)localObject2).getResource().getSourceTimeRange().getStart(), localCMTime));
            ((TAVClip)localObject4).getResource().setSourceTimeRange(new CMTimeRange(((TAVClip)localObject4).getResource().getSourceTimeRange().getStart().add(localCMTime), (CMTime)localObject1));
            paramList.add(0, localObject4);
          }
          j = 0;
        }
        for (;;)
        {
          if (j >= k) {
            break label711;
          }
          localObject1 = ((List)localObject3).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (TAVClip)((Iterator)localObject1).next();
              ((TAVClip)localObject2).getResource().setScaledDuration(((TAVClip)localObject2).getResource().getSourceTimeRange().getDuration().divide(f));
              continue;
              TAVClip localTAVClip = (TAVClip)paramList.remove(0);
              localObject4 = localTAVClip.getResource().getSourceTimeRange().getDuration();
              ((List)localObject3).add(localTAVClip);
              localObject1 = ((CMTime)localObject1).add((CMTime)localObject4);
              localObject2 = ((CMTime)localObject2).sub((CMTime)localObject4);
              break;
            }
          }
          localArrayList3.addAll(CloneUtil.cloneTAVClips((List)localObject3));
          j += 1;
        }
      }
      label711:
      localArrayList1.addAll(localArrayList3);
      i += 1;
    }
  }
  
  public static List<TAVClip> applyTimeEffectsNew(List<TAVClip> paramList, List<TAVMovieTimeEffect> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramList == null) || (paramList.isEmpty())) {
      localObject1 = localArrayList;
    }
    CMTime localCMTime;
    do
    {
      return localObject1;
      localCMTime = CMTime.CMTimeZero;
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        localCMTime = localCMTime.add(((TAVClip)((Iterator)localObject1).next()).getResource().getSourceTimeRange().getDuration());
      }
      localObject1 = paramList;
    } while (paramList1 == null);
    Iterator localIterator = paramList1.iterator();
    TAVMovieTimeEffect localTAVMovieTimeEffect;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localTAVMovieTimeEffect = (TAVMovieTimeEffect)localIterator.next();
      localObject2 = CloneUtil.cloneTAVClips(paramList);
      if ((localTAVMovieTimeEffect != null) && (localTAVMovieTimeEffect.getSourceTimeRange() != null)) {
        if (localTAVMovieTimeEffect.getSourceTimeRange().getStart().smallThan(localCMTime)) {
          break label156;
        }
      }
    }
    label156:
    while (!localTAVMovieTimeEffect.getSourceTimeRange().getStart().smallThan(localTAVMovieTimeEffect.getSourceTimeRange().getEnd())) {
      return localArrayList;
    }
    paramList1 = localTAVMovieTimeEffect.getSourceTimeRange().getStart();
    int i = 0;
    if (i < ((List)localObject2).size())
    {
      paramList1 = paramList1.sub(((TAVClip)paramList.get(i)).getResource().getSourceTimeRange().getDuration());
      if (paramList1.bigThan(CMTime.CMTimeZero)) {}
    }
    for (int j = i;; j = -1)
    {
      Object localObject3 = ((TAVClip)((List)localObject2).get(j)).getResource().getSourceTimeRange().getEnd().add(paramList1);
      paramList1 = localTAVMovieTimeEffect.getSourceTimeRange().getEnd();
      i = 0;
      label273:
      if (i < ((List)localObject2).size())
      {
        paramList1 = paramList1.sub(((TAVClip)paramList.get(i)).getResource().getSourceTimeRange().getDuration());
        if (paramList1.bigThan(CMTime.CMTimeZero)) {}
      }
      for (;;)
      {
        localObject1 = paramList1;
        if (paramList1.bigThan(CMTime.CMTimeZero))
        {
          i = ((List)localObject2).size() - 1;
          localObject1 = CMTime.CMTimeZero;
        }
        paramList1 = ((TAVClip)paramList.get(i)).getResource().getSourceTimeRange().getEnd().add((CMTime)localObject1);
        localObject1 = (TAVClip)((List)localObject2).get(j);
        localObject3 = new CMTimeRange((CMTime)localObject3, ((TAVClip)localObject1).getResource().getSourceTimeRange().getEnd().sub((CMTime)localObject3));
        ((TAVClip)localObject1).getResource().setSourceTimeRange((CMTimeRange)localObject3);
        localObject1 = (TAVClip)((List)localObject2).get(i);
        paramList1 = new CMTimeRange(((TAVClip)localObject1).getResource().getSourceTimeRange().getStart(), paramList1.sub(((TAVClip)localObject1).getResource().getSourceTimeRange().getStart()));
        ((TAVClip)localObject1).getResource().setSourceTimeRange(paramList1);
        paramList1 = ((List)localObject2).subList(j, i + 1);
        localObject1 = paramList1.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (TAVClip)((Iterator)localObject1).next();
            ((TAVClip)localObject2).getResource().setScaledDuration(((TAVClip)localObject2).getResource().getSourceTimeRange().getDuration().divide(localTAVMovieTimeEffect.getSpeed()));
            continue;
            i += 1;
            break;
            i += 1;
            break label273;
          }
        }
        localArrayList.addAll(paramList1);
        break;
        i = -1;
      }
    }
  }
  
  public static List<TAVClip> applyTimeEffectsOld(List<TAVClip> paramList, List<TAVMovieTimeEffect> paramList1)
  {
    if ((paramList1 == null) || (paramList1.size() == 0)) {}
    while ((paramList == null) || (paramList.size() == 0)) {
      return paramList;
    }
    ArrayList localArrayList1 = new ArrayList();
    TAVTimeEffectBuilder localTAVTimeEffectBuilder = new TAVTimeEffectBuilder();
    ArrayList localArrayList2 = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject2 = ((TAVMovieTimeEffect)paramList1.get(0)).getTimeRange().getStart();
    Iterator localIterator1 = paramList.iterator();
    Object localObject1;
    int i;
    while (localIterator1.hasNext())
    {
      TAVClip localTAVClip = (TAVClip)localIterator1.next();
      localTAVTimeEffectBuilder.setClip(localTAVClip);
      Object localObject3 = new CMTimeRange(localTAVClip.getStartTime(), localTAVClip.getResource().getSourceTimeRange().getDuration());
      Object localObject4 = new ArrayList();
      localObject1 = new HashMap();
      Iterator localIterator2 = paramList1.iterator();
      TAVMovieTimeEffect localTAVMovieTimeEffect;
      while (localIterator2.hasNext())
      {
        localTAVMovieTimeEffect = (TAVMovieTimeEffect)localIterator2.next();
        if (localTAVMovieTimeEffect.getTimeRange().getEnd().compare((CMTime)localObject2) > 0)
        {
          Object localObject5 = localTAVMovieTimeEffect.clone();
          Object localObject6 = localTAVMovieTimeEffect.getTimeRange().getStart().sub((CMTime)localObject2);
          i = 0;
          if (((CMTime)localObject6).getTimeUs() < 0L)
          {
            ((TAVMovieTimeEffect)localObject5).setTimeRange(new CMTimeRange(CMTime.CMTimeZero, localTAVMovieTimeEffect.getTimeRange().getDuration().add((CMTime)localObject6)));
            if (localTAVMovieTimeEffect.getLoop() > 1) {
              i = 1;
            }
          }
          for (;;)
          {
            localObject6 = getIntersection((CMTimeRange)localObject3, ((TAVMovieTimeEffect)localObject5).getTimeRange());
            if (!((CMTimeRange)localObject3).containsTimeRange(((TAVMovieTimeEffect)localObject5).getTimeRange())) {
              break label365;
            }
            ((List)localObject4).add(((TAVMovieTimeEffect)localObject5).convertToTimeEffect());
            if (i == 0) {
              break;
            }
            ((Map)localObject1).put(localTAVMovieTimeEffect, Boolean.valueOf(true));
            break;
            ((TAVMovieTimeEffect)localObject5).setTimeRange(new CMTimeRange((CMTime)localObject6, localTAVMovieTimeEffect.getTimeRange().getDuration()));
          }
          label365:
          if (!CMTimeRange.CMTimeRangeInvalid.equals(localObject6))
          {
            localObject5 = ((TAVMovieTimeEffect)localObject5).clone();
            ((TAVMovieTimeEffect)localObject5).setTimeRange((CMTimeRange)localObject6);
            localObject5 = ((TAVMovieTimeEffect)localObject5).convertToTimeEffect();
            ((List)localObject4).add(localObject5);
            if (localTAVMovieTimeEffect.getLoop() > 1)
            {
              if (!localArrayList2.contains(localTAVMovieTimeEffect)) {
                localArrayList2.add(localTAVMovieTimeEffect);
              }
              if (((TAVTimeEffect)localObject5).getTimeRange().getStart().equalsTo(CMTime.CMTimeZero)) {
                ((Map)localObject1).put(localTAVMovieTimeEffect, Boolean.valueOf(true));
              } else {
                ((Map)localObject1).put(localTAVMovieTimeEffect, Boolean.valueOf(false));
              }
            }
          }
        }
      }
      localObject3 = adjustTimeEffects(paramList, (List)localObject4);
      localObject4 = new TAVTimeEffect[((List)localObject3).size()];
      i = 0;
      while (i < ((List)localObject3).size())
      {
        localObject4[i] = ((TAVTimeEffect)((List)localObject3).get(i));
        i += 1;
      }
      localTAVTimeEffectBuilder.setTimeEffects((TAVTimeEffect[])localObject4);
      localObject4 = localTAVTimeEffectBuilder.build();
      localArrayList1.addAll((Collection)localObject4);
      if (!((Map)localObject1).isEmpty())
      {
        localIterator2 = ((Map)localObject1).entrySet().iterator();
        if (localIterator2.hasNext())
        {
          localObject1 = (Map.Entry)localIterator2.next();
          localTAVMovieTimeEffect = (TAVMovieTimeEffect)((Map.Entry)localObject1).getKey();
          boolean bool = ((Boolean)((Map.Entry)localObject1).getValue()).booleanValue();
          localObject1 = null;
          if (localHashMap != null) {
            localObject1 = (List)localHashMap.get(localTAVMovieTimeEffect);
          }
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new ArrayList();
          }
          if (bool) {
            ((List)localObject3).add(((List)localObject4).subList(0, localTAVMovieTimeEffect.getLoop()));
          }
          for (;;)
          {
            localHashMap.put(localTAVMovieTimeEffect, localObject3);
            break;
            ((List)localObject3).add(((List)localObject4).subList(((List)localObject4).size() - localTAVMovieTimeEffect.getLoop(), ((List)localObject4).size()));
          }
        }
      }
      localObject2 = ((CMTime)localObject2).add(localTAVClip.getResource().getSourceTimeRange().getDuration());
    }
    paramList = localArrayList2.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (TAVMovieTimeEffect)paramList.next();
      paramList1 = (List)localHashMap.get(localObject1);
      if ((paramList1 != null) && (paramList1.size() > 0) && (((TAVMovieTimeEffect)localObject1).getLoop() > 1))
      {
        localObject1 = (List)paramList1.get(0);
        int k = localArrayList1.indexOf(((List)localObject1).get(0));
        int m = paramList1.size();
        i = 0;
        while (i < ((List)localObject1).size())
        {
          int j = 0;
          while (j < paramList1.size())
          {
            localObject2 = (List)paramList1.get(j);
            int n = k + j + i * m;
            localArrayList1.remove(n);
            localArrayList1.add(n, ((List)localObject2).get(i));
            j += 1;
          }
          i += 1;
        }
      }
    }
    return localArrayList1;
  }
  
  public static CMTimeRange createMaxTimeRange(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    if (paramCMTimeRange1 == null) {
      return paramCMTimeRange2;
    }
    if (paramCMTimeRange2 == null) {
      return paramCMTimeRange1;
    }
    if (paramCMTimeRange1.getStartUs() <= paramCMTimeRange2.getStartUs()) {
      return new CMTimeRange(paramCMTimeRange1.getStart(), paramCMTimeRange2.getEnd().sub(paramCMTimeRange1.getStart()));
    }
    return new CMTimeRange(paramCMTimeRange2.getStart(), paramCMTimeRange1.getEnd().sub(paramCMTimeRange2.getStart()));
  }
  
  public static CMTimeRange getIntersection(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    if ((paramCMTimeRange1 == null) || (paramCMTimeRange2 == null))
    {
      localCMTimeRange = CMTimeRange.CMTimeRangeInvalid;
      return localCMTimeRange;
    }
    paramCMTimeRange1 = paramCMTimeRange1.clone();
    CMTimeRange localCMTimeRange = paramCMTimeRange2.clone();
    if (paramCMTimeRange1.getStartUs() > localCMTimeRange.getStartUs()) {
      paramCMTimeRange2 = localCMTimeRange;
    }
    for (;;)
    {
      if ((paramCMTimeRange2.getEndUs() > paramCMTimeRange1.getStartUs()) && (paramCMTimeRange2.getEndUs() < paramCMTimeRange1.getEndUs())) {
        return new CMTimeRange(paramCMTimeRange1.getStart(), paramCMTimeRange2.getEnd().sub(paramCMTimeRange1.getStart()));
      }
      localCMTimeRange = paramCMTimeRange1;
      if (paramCMTimeRange2.getEndUs() >= paramCMTimeRange1.getEndUs()) {
        break;
      }
      if (paramCMTimeRange2.getEndUs() < paramCMTimeRange1.getStartUs()) {
        return CMTimeRange.CMTimeRangeInvalid;
      }
      return CMTimeRange.CMTimeRangeInvalid;
      paramCMTimeRange2 = paramCMTimeRange1;
      paramCMTimeRange1 = localCMTimeRange;
    }
  }
  
  public static List<TAVMovieTimeEffect> getNoOverlapTimeEffects(List<TAVMovieTimeEffect> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    List localList = sortMovieTimeEffects(paramList);
    int j = localList.size();
    paramList = ((TAVMovieTimeEffect)localList.get(0)).clone();
    localArrayList.add(paramList);
    paramList = paramList.getTimeRange();
    int i = 1;
    while (i < j)
    {
      TAVMovieTimeEffect localTAVMovieTimeEffect = ((TAVMovieTimeEffect)localList.get(i)).clone();
      CMTimeRange localCMTimeRange1 = localTAVMovieTimeEffect.getTimeRange();
      paramList = getUnions(paramList, localCMTimeRange1);
      CMTimeRange localCMTimeRange2 = paramList[1];
      if ((localCMTimeRange2 != null) && (localCMTimeRange1.containsTimeRange(localCMTimeRange2)))
      {
        localTAVMovieTimeEffect.setTimeRange(localCMTimeRange2);
        localArrayList.add(localTAVMovieTimeEffect);
      }
      paramList = createMaxTimeRange(paramList[0], paramList[1]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static CMTimeRange[] getUnions(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    CMTimeRange[] arrayOfCMTimeRange = new CMTimeRange[2];
    if (paramCMTimeRange1 == null)
    {
      arrayOfCMTimeRange[0] = paramCMTimeRange2;
      return arrayOfCMTimeRange;
    }
    if (paramCMTimeRange2 == null)
    {
      arrayOfCMTimeRange[0] = paramCMTimeRange1;
      return arrayOfCMTimeRange;
    }
    paramCMTimeRange1 = paramCMTimeRange1.clone();
    paramCMTimeRange2 = paramCMTimeRange2.clone();
    CMTimeRange localCMTimeRange;
    if (paramCMTimeRange1.getStartUs() > paramCMTimeRange2.getStartUs())
    {
      localCMTimeRange = paramCMTimeRange2;
      paramCMTimeRange2 = paramCMTimeRange1;
    }
    for (;;)
    {
      arrayOfCMTimeRange[0] = localCMTimeRange;
      if ((localCMTimeRange.getEndUs() >= paramCMTimeRange2.getStartUs()) && (localCMTimeRange.getEndUs() < paramCMTimeRange2.getEndUs()))
      {
        arrayOfCMTimeRange[1] = new CMTimeRange(localCMTimeRange.getEnd(), paramCMTimeRange2.getEnd().sub(localCMTimeRange.getEnd()));
        return arrayOfCMTimeRange;
      }
      if (localCMTimeRange.getEndUs() >= paramCMTimeRange2.getEndUs())
      {
        arrayOfCMTimeRange[1] = null;
        return arrayOfCMTimeRange;
      }
      if (localCMTimeRange.getEndUs() >= paramCMTimeRange2.getStartUs()) {
        break;
      }
      arrayOfCMTimeRange[1] = paramCMTimeRange2;
      return arrayOfCMTimeRange;
      localCMTimeRange = paramCMTimeRange1;
    }
  }
  
  public static List<TAVMovieTimeEffect> pretreatTimeEffects(List<TAVMovieTimeEffect> paramList)
  {
    if (paramList == null) {
      return null;
    }
    return getNoOverlapTimeEffects(paramList);
  }
  
  public static List<TAVMovieTimeEffect> sortMovieTimeEffects(List<TAVMovieTimeEffect> paramList)
  {
    Collections.sort(paramList, new TAVMovieTimeEffectUtil.1());
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavmovie.utils.TAVMovieTimeEffectUtil
 * JD-Core Version:    0.7.0.1
 */