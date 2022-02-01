package com.tencent.tavkit.component;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.Comparator;

class TAVTimeEffectBuilder$1
  implements Comparator<TAVTimeEffect>
{
  TAVTimeEffectBuilder$1(TAVTimeEffectBuilder paramTAVTimeEffectBuilder) {}
  
  public int compare(TAVTimeEffect paramTAVTimeEffect1, TAVTimeEffect paramTAVTimeEffect2)
  {
    paramTAVTimeEffect1 = paramTAVTimeEffect1.getTimeRange().getStart();
    paramTAVTimeEffect2 = paramTAVTimeEffect2.getTimeRange().getStart();
    if (paramTAVTimeEffect1.equalsTo(paramTAVTimeEffect2)) {
      return 0;
    }
    if (paramTAVTimeEffect1.bigThan(paramTAVTimeEffect2)) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVTimeEffectBuilder.1
 * JD-Core Version:    0.7.0.1
 */