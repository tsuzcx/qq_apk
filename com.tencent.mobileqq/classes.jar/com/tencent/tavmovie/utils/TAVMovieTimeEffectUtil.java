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
    if ((paramList != null) && (paramList.size() != 0) && (paramList1 != null))
    {
      if (paramList1.size() == 0) {
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
    return paramList1;
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
    while (i < localArrayList2.size())
    {
      if (paramList.isEmpty()) {
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
        while ((((CMTime)localObject2).bigThan(CMTime.CMTimeZero)) && (!paramList.isEmpty()))
        {
          TAVClip localTAVClip = (TAVClip)paramList.remove(0);
          localObject4 = localTAVClip.getResource().getSourceTimeRange().getDuration();
          ((List)localObject3).add(localTAVClip);
          localObject1 = ((CMTime)localObject1).add((CMTime)localObject4);
          localObject2 = ((CMTime)localObject2).sub((CMTime)localObject4);
        }
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
        while (j < k)
        {
          localObject1 = ((List)localObject3).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (TAVClip)((Iterator)localObject1).next();
            ((TAVClip)localObject2).getResource().setScaledDuration(((TAVClip)localObject2).getResource().getSourceTimeRange().getDuration().divide(f));
          }
          localArrayList3.addAll(CloneUtil.cloneTAVClips((List)localObject3));
          j += 1;
        }
      }
      localArrayList1.addAll(localArrayList3);
      i += 1;
    }
    return localArrayList1;
  }
  
  public static List<TAVClip> applyTimeEffectsNew(List<TAVClip> paramList, List<TAVMovieTimeEffect> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return localArrayList;
      }
      CMTime localCMTime = CMTime.CMTimeZero;
      Object localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        localCMTime = localCMTime.add(((TAVClip)((Iterator)localObject1).next()).getResource().getSourceTimeRange().getDuration());
      }
      if (paramList1 == null) {
        return paramList;
      }
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        TAVMovieTimeEffect localTAVMovieTimeEffect = (TAVMovieTimeEffect)localIterator.next();
        Object localObject2 = CloneUtil.cloneTAVClips(paramList);
        if ((localTAVMovieTimeEffect != null) && (localTAVMovieTimeEffect.getSourceTimeRange() != null))
        {
          if (!localTAVMovieTimeEffect.getSourceTimeRange().getStart().smallThan(localCMTime)) {
            return localArrayList;
          }
          if (!localTAVMovieTimeEffect.getSourceTimeRange().getStart().smallThan(localTAVMovieTimeEffect.getSourceTimeRange().getEnd())) {
            return localArrayList;
          }
          paramList1 = localTAVMovieTimeEffect.getSourceTimeRange().getStart();
          int k = 0;
          int i = 0;
          while (i < ((List)localObject2).size())
          {
            paramList1 = paramList1.sub(((TAVClip)paramList.get(i)).getResource().getSourceTimeRange().getDuration());
            if (!paramList1.bigThan(CMTime.CMTimeZero))
            {
              j = i;
              break label252;
            }
            i += 1;
          }
          int j = -1;
          label252:
          Object localObject3 = ((TAVClip)((List)localObject2).get(j)).getResource().getSourceTimeRange().getEnd().add(paramList1);
          paramList1 = localTAVMovieTimeEffect.getSourceTimeRange().getEnd();
          i = k;
          while (i < ((List)localObject2).size())
          {
            paramList1 = paramList1.sub(((TAVClip)paramList.get(i)).getResource().getSourceTimeRange().getDuration());
            if (!paramList1.bigThan(CMTime.CMTimeZero)) {
              break label347;
            }
            i += 1;
          }
          i = -1;
          label347:
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
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (TAVClip)((Iterator)localObject1).next();
            ((TAVClip)localObject2).getResource().setScaledDuration(((TAVClip)localObject2).getResource().getSourceTimeRange().getDuration().divide(localTAVMovieTimeEffect.getSpeed()));
          }
          localArrayList.addAll(paramList1);
        }
      }
    }
    return localArrayList;
  }
  
  public static List<TAVClip> applyTimeEffectsOld(List<TAVClip> paramList, List<TAVMovieTimeEffect> paramList1)
  {
    if (paramList1 != null)
    {
      if (paramList1.size() == 0) {
        return paramList;
      }
      if (paramList != null)
      {
        if (paramList.size() == 0) {
          return paramList;
        }
        ArrayList localArrayList1 = new ArrayList();
        TAVTimeEffectBuilder localTAVTimeEffectBuilder = new TAVTimeEffectBuilder();
        ArrayList localArrayList2 = new ArrayList();
        HashMap localHashMap = new HashMap();
        CMTime localCMTime = ((TAVMovieTimeEffect)paramList1.get(0)).getTimeRange().getStart();
        Object localObject1 = paramList.iterator();
        Object localObject2;
        int i;
        while (((Iterator)localObject1).hasNext())
        {
          TAVClip localTAVClip = (TAVClip)((Iterator)localObject1).next();
          localTAVTimeEffectBuilder.setClip(localTAVClip);
          Object localObject4 = new CMTimeRange(localTAVClip.getStartTime(), localTAVClip.getResource().getSourceTimeRange().getDuration());
          Object localObject5 = new ArrayList();
          Object localObject3 = new HashMap();
          localObject2 = paramList1.iterator();
          TAVMovieTimeEffect localTAVMovieTimeEffect;
          while (((Iterator)localObject2).hasNext())
          {
            localTAVMovieTimeEffect = (TAVMovieTimeEffect)((Iterator)localObject2).next();
            if (localTAVMovieTimeEffect.getTimeRange().getEnd().compare(localCMTime) > 0) {
              for (;;)
              {
                Object localObject6 = localTAVMovieTimeEffect.clone();
                Object localObject7 = localTAVMovieTimeEffect.getTimeRange().getStart().sub(localCMTime);
                if (((CMTime)localObject7).getTimeUs() < 0L)
                {
                  ((TAVMovieTimeEffect)localObject6).setTimeRange(new CMTimeRange(CMTime.CMTimeZero, localTAVMovieTimeEffect.getTimeRange().getDuration().add((CMTime)localObject7)));
                  if (localTAVMovieTimeEffect.getLoop() > 1)
                  {
                    i = 1;
                    break label311;
                  }
                }
                else
                {
                  ((TAVMovieTimeEffect)localObject6).setTimeRange(new CMTimeRange((CMTime)localObject7, localTAVMovieTimeEffect.getTimeRange().getDuration()));
                }
                i = 0;
                label311:
                localObject7 = getIntersection((CMTimeRange)localObject4, ((TAVMovieTimeEffect)localObject6).getTimeRange());
                if (((CMTimeRange)localObject4).containsTimeRange(((TAVMovieTimeEffect)localObject6).getTimeRange()))
                {
                  ((List)localObject5).add(((TAVMovieTimeEffect)localObject6).convertToTimeEffect());
                  if (i != 0) {
                    ((Map)localObject3).put(localTAVMovieTimeEffect, Boolean.valueOf(true));
                  }
                }
                else if (!CMTimeRange.CMTimeRangeInvalid.equals(localObject7))
                {
                  localObject6 = ((TAVMovieTimeEffect)localObject6).clone();
                  ((TAVMovieTimeEffect)localObject6).setTimeRange((CMTimeRange)localObject7);
                  localObject6 = ((TAVMovieTimeEffect)localObject6).convertToTimeEffect();
                  ((List)localObject5).add(localObject6);
                  if (localTAVMovieTimeEffect.getLoop() > 1)
                  {
                    if (!localArrayList2.contains(localTAVMovieTimeEffect)) {
                      localArrayList2.add(localTAVMovieTimeEffect);
                    }
                    if (((TAVTimeEffect)localObject6).getTimeRange().getStart().equalsTo(CMTime.CMTimeZero)) {
                      ((Map)localObject3).put(localTAVMovieTimeEffect, Boolean.valueOf(true));
                    } else {
                      ((Map)localObject3).put(localTAVMovieTimeEffect, Boolean.valueOf(false));
                    }
                  }
                }
              }
            }
          }
          localObject2 = adjustTimeEffects(paramList, (List)localObject5);
          localObject4 = new TAVTimeEffect[((List)localObject2).size()];
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject4[i] = ((TAVTimeEffect)((List)localObject2).get(i));
            i += 1;
          }
          localTAVTimeEffectBuilder.setTimeEffects((TAVTimeEffect[])localObject4);
          localObject4 = localTAVTimeEffectBuilder.build();
          localArrayList1.addAll((Collection)localObject4);
          if (!((Map)localObject3).isEmpty())
          {
            localObject5 = ((Map)localObject3).entrySet().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject2 = (Map.Entry)((Iterator)localObject5).next();
              localTAVMovieTimeEffect = (TAVMovieTimeEffect)((Map.Entry)localObject2).getKey();
              boolean bool = ((Boolean)((Map.Entry)localObject2).getValue()).booleanValue();
              localObject3 = (List)localHashMap.get(localTAVMovieTimeEffect);
              localObject2 = localObject3;
              if (localObject3 == null) {
                localObject2 = new ArrayList();
              }
              if (bool) {
                ((List)localObject2).add(((List)localObject4).subList(0, localTAVMovieTimeEffect.getLoop()));
              } else {
                ((List)localObject2).add(((List)localObject4).subList(((List)localObject4).size() - localTAVMovieTimeEffect.getLoop(), ((List)localObject4).size()));
              }
              localHashMap.put(localTAVMovieTimeEffect, localObject2);
            }
          }
          localCMTime = localCMTime.add(localTAVClip.getResource().getSourceTimeRange().getDuration());
        }
        paramList = localArrayList2.iterator();
        while (paramList.hasNext())
        {
          localObject1 = (TAVMovieTimeEffect)paramList.next();
          paramList1 = (List)localHashMap.get(localObject1);
          if ((paramList1 != null) && (paramList1.size() > 0)) {
            if (((TAVMovieTimeEffect)localObject1).getLoop() > 1)
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
            else {}
          }
        }
        return localArrayList1;
      }
    }
    return paramList;
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
    if ((paramCMTimeRange1 != null) && (paramCMTimeRange2 != null))
    {
      paramCMTimeRange1 = paramCMTimeRange1.clone();
      paramCMTimeRange2 = paramCMTimeRange2.clone();
      CMTimeRange localCMTimeRange2 = paramCMTimeRange1;
      CMTimeRange localCMTimeRange1 = paramCMTimeRange2;
      if (paramCMTimeRange1.getStartUs() > paramCMTimeRange2.getStartUs())
      {
        localCMTimeRange1 = paramCMTimeRange1;
        localCMTimeRange2 = paramCMTimeRange2;
      }
      if ((localCMTimeRange2.getEndUs() > localCMTimeRange1.getStartUs()) && (localCMTimeRange2.getEndUs() < localCMTimeRange1.getEndUs())) {
        return new CMTimeRange(localCMTimeRange1.getStart(), localCMTimeRange2.getEnd().sub(localCMTimeRange1.getStart()));
      }
      if (localCMTimeRange2.getEndUs() >= localCMTimeRange1.getEndUs()) {
        return localCMTimeRange1;
      }
      if (localCMTimeRange2.getEndUs() < localCMTimeRange1.getStartUs()) {
        return CMTimeRange.CMTimeRangeInvalid;
      }
      return CMTimeRange.CMTimeRangeInvalid;
    }
    return CMTimeRange.CMTimeRangeInvalid;
  }
  
  public static List<TAVMovieTimeEffect> getNoOverlapTimeEffects(List<TAVMovieTimeEffect> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
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
    return null;
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
    CMTimeRange localCMTimeRange2 = paramCMTimeRange1;
    CMTimeRange localCMTimeRange1 = paramCMTimeRange2;
    if (paramCMTimeRange1.getStartUs() > paramCMTimeRange2.getStartUs())
    {
      localCMTimeRange1 = paramCMTimeRange1;
      localCMTimeRange2 = paramCMTimeRange2;
    }
    arrayOfCMTimeRange[0] = localCMTimeRange2;
    if ((localCMTimeRange2.getEndUs() >= localCMTimeRange1.getStartUs()) && (localCMTimeRange2.getEndUs() < localCMTimeRange1.getEndUs()))
    {
      arrayOfCMTimeRange[1] = new CMTimeRange(localCMTimeRange2.getEnd(), localCMTimeRange1.getEnd().sub(localCMTimeRange2.getEnd()));
      return arrayOfCMTimeRange;
    }
    if (localCMTimeRange2.getEndUs() >= localCMTimeRange1.getEndUs())
    {
      arrayOfCMTimeRange[1] = null;
      return arrayOfCMTimeRange;
    }
    if (localCMTimeRange2.getEndUs() < localCMTimeRange1.getStartUs()) {
      arrayOfCMTimeRange[1] = localCMTimeRange1;
    }
    return arrayOfCMTimeRange;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.utils.TAVMovieTimeEffectUtil
 * JD-Core Version:    0.7.0.1
 */