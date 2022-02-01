package com.tencent.tavsticker.core;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerImageEffect;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerTimeEffect;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerUserData;
import com.tencent.tavsticker.model.TAVStickerLayerType;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.libpag.PAGComposition;
import org.libpag.PAGImageLayer;
import org.libpag.PAGLayer;
import org.libpag.PAGMarker;
import org.libpag.PAGVideoRange;

public class TAVStickerParser
{
  private static long getParentLayerEndTime(PAGLayer paramPAGLayer)
  {
    long l1 = 0L;
    if (paramPAGLayer == null) {
      return 0L;
    }
    PAGLayer localPAGLayer = getRootLayer(paramPAGLayer);
    if (localPAGLayer == null) {
      return 0L;
    }
    long l2 = localPAGLayer.duration();
    paramPAGLayer = paramPAGLayer.parent();
    if (paramPAGLayer != null) {
      l1 = paramPAGLayer.localTimeToGlobal(paramPAGLayer.startTime()) + paramPAGLayer.duration();
    }
    return Math.min(l1, l2);
  }
  
  private static long getParentLayerStartTime(PAGLayer paramPAGLayer)
  {
    if (paramPAGLayer == null) {
      return 0L;
    }
    paramPAGLayer = paramPAGLayer.parent();
    long l;
    if (paramPAGLayer != null) {
      l = paramPAGLayer.localTimeToGlobal(paramPAGLayer.startTime());
    } else {
      l = 0L;
    }
    return Math.max(0L, l);
  }
  
  private static PAGLayer getRootLayer(PAGLayer paramPAGLayer)
  {
    if (paramPAGLayer != null)
    {
      while (paramPAGLayer.parent() != null) {
        paramPAGLayer = paramPAGLayer.parent();
      }
      return paramPAGLayer;
    }
    return null;
  }
  
  private static TAVStickerLayerType getStickerLayerType(PAGLayer paramPAGLayer)
  {
    TAVStickerLayerType localTAVStickerLayerType2 = TAVStickerLayerType.Unknown;
    TAVStickerLayerType localTAVStickerLayerType1 = localTAVStickerLayerType2;
    if (paramPAGLayer != null)
    {
      switch (paramPAGLayer.layerType())
      {
      default: 
        return localTAVStickerLayerType2;
      case 6: 
        return TAVStickerLayerType.PreCompose;
      case 5: 
        return TAVStickerLayerType.Image;
      case 4: 
        return TAVStickerLayerType.Shape;
      case 3: 
        return TAVStickerLayerType.Text;
      case 2: 
        return TAVStickerLayerType.Solid;
      case 1: 
        return TAVStickerLayerType.Null;
      }
      localTAVStickerLayerType1 = TAVStickerLayerType.Unknown;
    }
    return localTAVStickerLayerType1;
  }
  
  private static List<TAVStickerLayerInfo.TAVStickerImageEffect> parseImageEffects(PAGLayer paramPAGLayer)
  {
    if (paramPAGLayer == null) {
      return null;
    }
    return new ArrayList();
  }
  
  public static List<TAVStickerLayerInfo> parsePagComposition(PAGComposition paramPAGComposition, long paramLong)
  {
    if (paramPAGComposition == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramPAGComposition.numLayers();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramPAGComposition.getLayerAt(i);
      if (localObject != null) {
        if (6 == ((PAGLayer)localObject).layerType())
        {
          if ((localObject instanceof PAGComposition))
          {
            localObject = parsePagComposition((PAGComposition)localObject, paramLong);
            if (!CollectionUtil.isEmptyList((List)localObject)) {
              localArrayList.addAll(localArrayList.size(), (Collection)localObject);
            }
          }
        }
        else
        {
          localObject = parsePagLayer((PAGLayer)localObject);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static TAVStickerLayerInfo parsePagLayer(PAGLayer paramPAGLayer)
  {
    List localList2 = null;
    List localList1 = null;
    if (paramPAGLayer == null) {
      return null;
    }
    int i = paramPAGLayer.layerType();
    if ((5 != i) && (3 != i) && (4 != i)) {
      return null;
    }
    long l2 = paramPAGLayer.localTimeToGlobal(paramPAGLayer.startTime());
    long l3 = paramPAGLayer.duration() + l2;
    Object localObject2 = CMTimeRange.CMTimeRangeInvalid;
    long l5 = getParentLayerStartTime(paramPAGLayer);
    long l4 = getParentLayerEndTime(paramPAGLayer);
    Object localObject1 = localList2;
    if (l4 > 0L)
    {
      if (l5 > l4) {
        return null;
      }
      long l1 = l2;
      if (l2 < l5) {
        l1 = l5;
      }
      localObject1 = localList2;
      if (l1 < l4)
      {
        l2 = l3;
        if (l3 > l4) {
          l2 = l4;
        }
        l2 -= l1;
        localObject1 = localObject2;
        if (l2 > 0L) {
          localObject1 = new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(l1)), new CMTime(TAVStickerUtil.microsecond2Seconds(l2)));
        }
        localObject2 = localList1;
        if (5 == i)
        {
          localObject2 = localList1;
          if ((paramPAGLayer instanceof PAGImageLayer)) {
            localObject2 = parseTimeEffects((PAGImageLayer)paramPAGLayer, l2);
          }
        }
        localList1 = parseImageEffects(paramPAGLayer);
        localList2 = parseUserDataList(paramPAGLayer);
        TAVStickerLayerType localTAVStickerLayerType = getStickerLayerType(paramPAGLayer);
        localObject1 = new TAVStickerLayerInfo(paramPAGLayer.editableIndex(), localTAVStickerLayerType, (CMTimeRange)localObject1, (List)localObject2, localList1, localList2);
      }
    }
    return localObject1;
  }
  
  private static List<TAVStickerLayerInfo.TAVStickerTimeEffect> parseTimeEffects(PAGImageLayer paramPAGImageLayer, long paramLong)
  {
    if ((paramPAGImageLayer != null) && (paramLong > 0L))
    {
      ArrayList localArrayList = new ArrayList();
      paramPAGImageLayer = paramPAGImageLayer.getVideoRanges();
      if (paramPAGImageLayer != null)
      {
        int i = paramPAGImageLayer.length;
        int j = 0;
        long l1 = 0L;
        while (j < i)
        {
          CMTimeRange localCMTimeRange = paramPAGImageLayer[j];
          if (localCMTimeRange != null)
          {
            long l4 = localCMTimeRange.startTime;
            long l3 = localCMTimeRange.endTime - l4;
            long l5 = localCMTimeRange.playDuration;
            boolean bool = localCMTimeRange.reversed;
            long l2 = l3;
            if (l3 <= 0L) {
              l2 = 0L;
            }
            if (l5 > 0L)
            {
              float f1 = (float)l2 * 1.0F / (float)l5;
              localCMTimeRange = CMTimeRange.CMTimeRangeInvalid;
              localCMTimeRange = CMTimeRange.CMTimeRangeInvalid;
              l2 = l5 + l1;
              if (l1 < paramLong)
              {
                if (l2 > paramLong) {
                  l3 = paramLong;
                } else {
                  l3 = l2;
                }
                l3 -= l1;
                if (l3 > 0L)
                {
                  localCMTimeRange = new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(l1)), new CMTime(TAVStickerUtil.microsecond2Seconds(l3)));
                  float f2 = f1 * (float)l3;
                  f1 = f2;
                  if (0.0F == f2) {
                    f1 = 20000.0F;
                  }
                  localArrayList.add(new TAVStickerLayerInfo.TAVStickerTimeEffect(new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(l4)), new CMTime(f1 / 1000000.0F)), localCMTimeRange, bool));
                }
                l1 = l2;
              }
            }
          }
          j += 1;
        }
      }
      Collections.sort(localArrayList, new TAVStickerParser.1());
      return localArrayList;
    }
    return null;
  }
  
  private static List<TAVStickerLayerInfo.TAVStickerUserData> parseUserDataList(PAGLayer paramPAGLayer)
  {
    if (paramPAGLayer == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramPAGLayer = paramPAGLayer.markers();
    if ((paramPAGLayer != null) && (paramPAGLayer.length > 0))
    {
      int j = paramPAGLayer.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramPAGLayer[i];
        if (localObject != null) {
          localArrayList.add(new TAVStickerLayerInfo.TAVStickerUserData(new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(localObject.mStartTime)), new CMTime(TAVStickerUtil.microsecond2Seconds(localObject.mDuration))), localObject.mComment));
        }
        i += 1;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerParser
 * JD-Core Version:    0.7.0.1
 */