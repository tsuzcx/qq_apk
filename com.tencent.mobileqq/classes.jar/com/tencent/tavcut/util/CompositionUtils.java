package com.tencent.tavcut.util;

import com.tencent.autotemplate.filter.TAVTimeRangeAspectFillEffect;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.Iterator;
import java.util.List;

public class CompositionUtils
{
  public static void removeTAVAspectEffect(TAVComposition paramTAVComposition)
  {
    if (paramTAVComposition == null) {}
    label23:
    do
    {
      return;
      while (!paramTAVComposition.hasNext())
      {
        do
        {
          paramTAVComposition = paramTAVComposition.getVideoChannels();
        } while (CollectionUtil.isEmptyList(paramTAVComposition));
        paramTAVComposition = paramTAVComposition.iterator();
        break;
      }
      localObject1 = (List)paramTAVComposition.next();
    } while (CollectionUtil.isEmptyList((List)localObject1));
    Object localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (TAVClip)((Iterator)localObject1).next();
      if ((localObject2 == null) || (((TAVClip)localObject2).getVideoConfiguration() == null) || (((TAVClip)localObject2).getVideoConfiguration().getEffects() == null) || (((TAVClip)localObject2).getVideoConfiguration().getEffects().size() < 1)) {
        break label23;
      }
      localObject2 = ((TAVClip)localObject2).getVideoConfiguration().getEffects().iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (((TAVVideoEffect)((Iterator)localObject2).next() instanceof TAVTimeRangeAspectFillEffect)) {
          ((Iterator)localObject2).remove();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.util.CompositionUtils
 * JD-Core Version:    0.7.0.1
 */