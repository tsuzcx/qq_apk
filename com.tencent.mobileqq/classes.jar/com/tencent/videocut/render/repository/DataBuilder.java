package com.tencent.videocut.render.repository;

import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.picker.MediaData;
import com.tencent.videocut.render.FrameFuncKt;
import com.tencent.videocut.render.TransformFuncKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/repository/DataBuilder;", "", "()V", "buildMediaModel", "Lcom/tencent/videocut/model/MediaModel;", "mediaDatas", "", "Lcom/tencent/videocut/picker/MediaData;", "backgroundFillScale", "", "mediaDataToMediaClip", "Lcom/tencent/videocut/model/MediaClip;", "mediaData", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class DataBuilder
{
  public static final DataBuilder a = new DataBuilder();
  
  @NotNull
  public final MediaModel a(@NotNull List<MediaData> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "mediaDatas");
    paramList = b(paramList);
    return new MediaModel(UUID.randomUUID().toString(), null, null, null, null, null, paramList, null, null, FrameFuncKt.a(paramList, 0.0F, 2, null), null, null, null, null, null, null, null, null, 261566, null);
  }
  
  @NotNull
  public final List<MediaClip> b(@NotNull List<MediaData> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "mediaData");
    List localList = (List)new ArrayList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      MediaData localMediaData = (MediaData)localIterator.next();
      long l = localMediaData.d();
      paramList = localMediaData.f();
      if (paramList == null) {
        paramList = " ";
      }
      int i;
      if (((CharSequence)paramList).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        paramList = localMediaData.e();
      }
      String str = UUID.randomUUID().toString();
      Intrinsics.checkExpressionValueIsNotNull(str, "UUID.randomUUID().toString()");
      MediaType localMediaType;
      if (localMediaData.a() == 1) {
        localMediaType = MediaType.IMAGE;
      } else {
        localMediaType = MediaType.VIDEO;
      }
      localList.add(new MediaClip(new ResourceModel(str, paramList, l, 0L, l, 0L, l, localMediaType, new SizeF(localMediaData.b(), localMediaData.c(), null, 4, null), 1.0F, null, null, null, null, null, null, 64512, null), TransformFuncKt.a(), null, null, null, null, 60, null));
    }
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.repository.DataBuilder
 * JD-Core Version:    0.7.0.1
 */