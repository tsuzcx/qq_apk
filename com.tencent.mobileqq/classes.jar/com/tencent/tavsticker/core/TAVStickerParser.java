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
    if (paramPAGLayer == null) {}
    PAGLayer localPAGLayer;
    do
    {
      return 0L;
      localPAGLayer = getRootLayer(paramPAGLayer);
    } while (localPAGLayer == null);
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
    if (paramPAGLayer != null) {}
    for (long l = paramPAGLayer.localTimeToGlobal(paramPAGLayer.startTime());; l = 0L) {
      return Math.max(0L, l);
    }
  }
  
  private static PAGLayer getRootLayer(PAGLayer paramPAGLayer)
  {
    if (paramPAGLayer != null) {
      for (;;)
      {
        localPAGLayer = paramPAGLayer;
        if (paramPAGLayer.parent() == null) {
          break;
        }
        paramPAGLayer = paramPAGLayer.parent();
      }
    }
    PAGLayer localPAGLayer = null;
    return localPAGLayer;
  }
  
  private static TAVStickerLayerType getStickerLayerType(PAGLayer paramPAGLayer)
  {
    TAVStickerLayerType localTAVStickerLayerType = TAVStickerLayerType.Unknown;
    if (paramPAGLayer != null) {}
    switch (paramPAGLayer.layerType())
    {
    default: 
      return localTAVStickerLayerType;
    case 0: 
      return TAVStickerLayerType.Unknown;
    case 1: 
      return TAVStickerLayerType.Null;
    case 2: 
      return TAVStickerLayerType.Solid;
    case 3: 
      return TAVStickerLayerType.Text;
    case 4: 
      return TAVStickerLayerType.Shape;
    case 5: 
      return TAVStickerLayerType.Image;
    }
    return TAVStickerLayerType.PreCompose;
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
    if (i < j)
    {
      Object localObject = paramPAGComposition.getLayerAt(i);
      if (localObject != null)
      {
        if (6 != ((PAGLayer)localObject).layerType()) {
          break label102;
        }
        if ((localObject instanceof PAGComposition))
        {
          localObject = parsePagComposition((PAGComposition)localObject, paramLong);
          if (!CollectionUtil.isEmptyList((List)localObject)) {
            localArrayList.addAll(localArrayList.size(), (Collection)localObject);
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label102:
        localObject = parsePagLayer((PAGLayer)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public static TAVStickerLayerInfo parsePagLayer(PAGLayer paramPAGLayer)
  {
    if (paramPAGLayer == null) {
      return null;
    }
    int i = paramPAGLayer.layerType();
    long l1;
    long l2;
    CMTimeRange localCMTimeRange;
    long l3;
    if ((5 == i) || (3 == i) || (4 == i))
    {
      l1 = paramPAGLayer.localTimeToGlobal(paramPAGLayer.startTime());
      l2 = l1 + paramPAGLayer.duration();
      localCMTimeRange = CMTimeRange.CMTimeRangeInvalid;
      long l4 = getParentLayerStartTime(paramPAGLayer);
      l3 = getParentLayerEndTime(paramPAGLayer);
      if ((l3 <= 0L) || (l4 > l3)) {
        return null;
      }
      if (l1 >= l4) {
        break label232;
      }
      l1 = l4;
    }
    label229:
    label232:
    for (;;)
    {
      if (l1 < l3)
      {
        if (l2 <= l3) {
          break label229;
        }
        l2 = l3;
      }
      for (;;)
      {
        l2 -= l1;
        if (l2 > 0L) {
          localCMTimeRange = new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(l1)), new CMTime(TAVStickerUtil.microsecond2Seconds(l2)));
        }
        List localList2 = null;
        List localList1 = localList2;
        if (5 == i)
        {
          localList1 = localList2;
          if ((paramPAGLayer instanceof PAGImageLayer)) {
            localList1 = parseTimeEffects((PAGImageLayer)paramPAGLayer, l2);
          }
        }
        localList2 = parseImageEffects(paramPAGLayer);
        List localList3 = parseUserDataList(paramPAGLayer);
        TAVStickerLayerType localTAVStickerLayerType = getStickerLayerType(paramPAGLayer);
        return new TAVStickerLayerInfo(paramPAGLayer.editableIndex(), localTAVStickerLayerType, localCMTimeRange, localList1, localList2, localList3);
        return null;
        return null;
      }
    }
  }
  
  private static List<TAVStickerLayerInfo.TAVStickerTimeEffect> parseTimeEffects(PAGImageLayer paramPAGImageLayer, long paramLong)
  {
    if ((paramPAGImageLayer == null) || (paramLong <= 0L)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    long l1 = 0L;
    paramPAGImageLayer = paramPAGImageLayer.getVideoRanges();
    int i;
    if (paramPAGImageLayer != null)
    {
      int j = paramPAGImageLayer.length;
      i = 0;
      if (i < j)
      {
        CMTimeRange localCMTimeRange = paramPAGImageLayer[i];
        if (localCMTimeRange == null) {
          break label305;
        }
        long l4 = localCMTimeRange.startTime;
        long l3 = localCMTimeRange.endTime - l4;
        long l5 = localCMTimeRange.playDuration;
        boolean bool = localCMTimeRange.reversed;
        long l2 = l3;
        if (l3 <= 0L) {
          l2 = 0L;
        }
        if (l5 <= 0L) {
          break label305;
        }
        float f1 = (float)l2 * 1.0F / (float)l5;
        localCMTimeRange = CMTimeRange.CMTimeRangeInvalid;
        localCMTimeRange = CMTimeRange.CMTimeRangeInvalid;
        l3 = l1 + l5;
        if (l1 >= paramLong) {
          break label305;
        }
        l2 = l3;
        if (l3 > paramLong) {
          l2 = paramLong;
        }
        l2 -= l1;
        if (l2 > 0L)
        {
          localCMTimeRange = new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(l1)), new CMTime(TAVStickerUtil.microsecond2Seconds(l2)));
          float f2 = (float)l2 * f1;
          f1 = f2;
          if (0.0F == f2) {
            f1 = 20000.0F;
          }
          localArrayList.add(new TAVStickerLayerInfo.TAVStickerTimeEffect(new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(l4)), new CMTime(f1 / 1000000.0F)), localCMTimeRange, bool));
        }
        l1 += l5;
      }
    }
    label305:
    for (;;)
    {
      i += 1;
      break;
      Collections.sort(localArrayList, new TAVStickerParser.1());
      return localArrayList;
    }
  }
  
  private static List<TAVStickerLayerInfo.TAVStickerUserData> parseUserDataList(PAGLayer paramPAGLayer)
  {
    if (paramPAGLayer == null) {
      paramPAGLayer = null;
    }
    ArrayList localArrayList;
    PAGMarker[] arrayOfPAGMarker;
    do
    {
      do
      {
        return paramPAGLayer;
        localArrayList = new ArrayList();
        arrayOfPAGMarker = paramPAGLayer.markers();
        paramPAGLayer = localArrayList;
      } while (arrayOfPAGMarker == null);
      paramPAGLayer = localArrayList;
    } while (arrayOfPAGMarker.length <= 0);
    int j = arrayOfPAGMarker.length;
    int i = 0;
    for (;;)
    {
      paramPAGLayer = localArrayList;
      if (i >= j) {
        break;
      }
      paramPAGLayer = arrayOfPAGMarker[i];
      if (paramPAGLayer != null) {
        localArrayList.add(new TAVStickerLayerInfo.TAVStickerUserData(new CMTimeRange(new CMTime(TAVStickerUtil.microsecond2Seconds(paramPAGLayer.mStartTime)), new CMTime(TAVStickerUtil.microsecond2Seconds(paramPAGLayer.mDuration))), paramPAGLayer.mComment));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerParser
 * JD-Core Version:    0.7.0.1
 */