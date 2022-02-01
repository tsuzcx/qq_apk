package com.tencent.tavcut.render.builder.light;

import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.ClipSource.ClipType;
import com.tencent.tavcut.rendermodel.transform.MatrixTransform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.ClipAsset;
import org.light.PhotoClip;
import org.light.TimeLine;
import org.light.VideoClip;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/builder/light/LightEntityTransHelper;", "", "()V", "transClipSourcesToClipAssets", "", "Lorg/light/ClipAsset;", "clipSources", "Lcom/tencent/tavcut/model/ClipSource;", "transLightTimeLineToTimeline", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "timeLines", "", "Lorg/light/TimeLine;", "([Lorg/light/TimeLine;)Ljava/util/List;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class LightEntityTransHelper
{
  public static final LightEntityTransHelper a = new LightEntityTransHelper();
  
  @JvmStatic
  @NotNull
  public static final List<ClipAsset> a(@NotNull List<ClipSource> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clipSources");
    List localList = (List)new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ClipSource localClipSource = (ClipSource)localIterator.next();
      if (localClipSource.type == ClipSource.ClipType.PHOTO)
      {
        paramList = new PhotoClip();
        paramList.photoEffectPath = localClipSource.photoEffectPath;
        paramList = (ClipAsset)paramList;
      }
      else
      {
        paramList = new VideoClip();
        Object localObject = localClipSource.speed;
        float f2 = 1.0F;
        if (localObject != null) {
          f1 = ((Float)localObject).floatValue();
        } else {
          f1 = 1.0F;
        }
        paramList.speed = f1;
        localObject = localClipSource.volume;
        float f1 = f2;
        if (localObject != null) {
          f1 = ((Float)localObject).floatValue();
        }
        paramList.volume = f1;
        localObject = localClipSource.startOffset;
        long l;
        if (localObject != null) {
          l = ((Long)localObject).longValue();
        } else {
          l = 0L;
        }
        paramList.startOffset = l;
        paramList = (ClipAsset)paramList;
      }
      paramList.duration = localClipSource.duration;
      paramList.path = localClipSource.path;
      paramList.matrix = MatrixTransform.transListMatrixToMatrix(localClipSource.matrix);
      localList.add(paramList);
    }
    return localList;
  }
  
  @JvmStatic
  @NotNull
  public static final List<Timeline> a(@NotNull TimeLine[] paramArrayOfTimeLine)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfTimeLine, "timeLines");
    List localList = (List)new ArrayList();
    int j = paramArrayOfTimeLine.length;
    int i = 0;
    while (i < j)
    {
      TimeLine localTimeLine = paramArrayOfTimeLine[i];
      localList.add(new Timeline(Integer.valueOf(localTimeLine.entityID), localTimeLine.type, new com.tencent.tavcut.composition.model.component.TimeRange(localTimeLine.range.startTime, localTimeLine.range.duration, null, 4, null), Long.valueOf(localTimeLine.time), localTimeLine.event, null, 32, null));
      i += 1;
    }
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.builder.light.LightEntityTransHelper
 * JD-Core Version:    0.7.0.1
 */