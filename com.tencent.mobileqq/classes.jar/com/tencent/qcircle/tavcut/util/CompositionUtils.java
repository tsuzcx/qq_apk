package com.tencent.qcircle.tavcut.util;

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
    if (paramTAVComposition == null) {
      return;
    }
    paramTAVComposition = paramTAVComposition.getVideoChannels();
    if (CollectionUtil.isEmptyList(paramTAVComposition)) {
      return;
    }
    paramTAVComposition = paramTAVComposition.iterator();
    break label58;
    label25:
    do
    {
      if (!paramTAVComposition.hasNext()) {
        break;
      }
      localObject1 = (List)paramTAVComposition.next();
    } while (CollectionUtil.isEmptyList((List)localObject1));
    Object localObject1 = ((List)localObject1).iterator();
    for (;;)
    {
      label58:
      if (!((Iterator)localObject1).hasNext()) {
        break label25;
      }
      Object localObject2 = (TAVClip)((Iterator)localObject1).next();
      if ((localObject2 == null) || (((TAVClip)localObject2).getVideoConfiguration() == null) || (((TAVClip)localObject2).getVideoConfiguration().getEffects() == null) || (((TAVClip)localObject2).getVideoConfiguration().getEffects().size() < 1)) {
        break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.util.CompositionUtils
 * JD-Core Version:    0.7.0.1
 */