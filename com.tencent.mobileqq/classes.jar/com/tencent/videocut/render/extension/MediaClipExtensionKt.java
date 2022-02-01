package com.tencent.videocut.render.extension;

import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.ClipSource.ClipType;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.render.TransformFuncKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"anchor", "Lcom/tencent/videocut/model/PointF;", "Lcom/tencent/videocut/model/MediaClip;", "getAnchor", "(Lcom/tencent/videocut/model/MediaClip;)Lcom/tencent/videocut/model/PointF;", "resId", "", "getResId", "(Lcom/tencent/videocut/model/MediaClip;)Ljava/lang/String;", "size", "Lcom/tencent/videocut/model/SizeF;", "getSize", "(Lcom/tencent/videocut/model/MediaClip;)Lcom/tencent/videocut/model/SizeF;", "toClipSource", "Lcom/tencent/tavcut/model/ClipSource;", "", "toEditViewTransform", "Lcom/tencent/videocut/render/model/EditViewTransform;", "renderSize", "toMediaClip", "updateVolume", "value", "", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class MediaClipExtensionKt
{
  @NotNull
  public static final ClipSource a(@NotNull ClipSource paramClipSource, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramClipSource, "$this$updateVolume");
    String str1 = paramClipSource.sourceId;
    String str2 = paramClipSource.path;
    ClipSource.ClipType localClipType = paramClipSource.type;
    Rect localRect = paramClipSource.clipRect;
    return new ClipSource(str1, str2, localClipType, paramClipSource.duration, paramClipSource.speed, Float.valueOf(paramFloat), paramClipSource.startOffset, null, null, null, localRect, null, 2944, null);
  }
  
  @Nullable
  public static final MediaClip a(@NotNull ClipSource paramClipSource)
  {
    Intrinsics.checkParameterIsNotNull(paramClipSource, "$this$toMediaClip");
    String str1 = paramClipSource.sourceId;
    if (str1 == null) {
      str1 = "";
    }
    String str2 = paramClipSource.path;
    if (str2 == null) {
      str2 = "";
    }
    long l2 = paramClipSource.duration;
    float f2 = (float)paramClipSource.duration;
    Object localObject = paramClipSource.speed;
    float f1;
    if (localObject != null) {
      f1 = ((Float)localObject).floatValue();
    } else {
      f1 = 1.0F;
    }
    long l3 = (f2 / f1);
    long l4 = paramClipSource.duration;
    if (paramClipSource.type == ClipSource.ClipType.PHOTO) {
      localObject = MediaType.IMAGE;
    } else {
      localObject = MediaType.VIDEO;
    }
    SizeF localSizeF = new SizeF(720, 1280, null, 4, null);
    paramClipSource = paramClipSource.startOffset;
    long l1;
    if (paramClipSource != null) {
      l1 = paramClipSource.longValue();
    } else {
      l1 = 0L;
    }
    return new MediaClip(new ResourceModel(str1, str2, l3, 0L, l2, l1, l4, (MediaType)localObject, localSizeF, 1.0F, null, null, null, null, null, null, 64512, null), TransformFuncKt.a(), null, null, null, null, 60, null);
  }
  
  @NotNull
  public static final String a(@NotNull MediaClip paramMediaClip)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaClip, "$this$resId");
    paramMediaClip = paramMediaClip.resource;
    if (paramMediaClip != null)
    {
      paramMediaClip = paramMediaClip.id;
      if (paramMediaClip != null) {
        return paramMediaClip;
      }
    }
    return "";
  }
  
  @NotNull
  public static final List<ClipSource> a(@NotNull List<MediaClip> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$toClipSource");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      int i;
      if (((MediaClip)localObject2).resource != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramList.add(localObject2);
      }
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = c((MediaClip)((Iterator)localObject1).next());
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      paramList.add(localObject2);
    }
    return (List)paramList;
  }
  
  @NotNull
  public static final SizeF b(@NotNull MediaClip paramMediaClip)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaClip, "$this$size");
    paramMediaClip = paramMediaClip.resource;
    if (paramMediaClip != null)
    {
      paramMediaClip = paramMediaClip.size;
      if (paramMediaClip != null) {
        return paramMediaClip;
      }
    }
    return new SizeF(0.0F, 0.0F, null, 7, null);
  }
  
  @NotNull
  public static final List<MediaClip> b(@NotNull List<ClipSource> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$toMediaClip");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      int i;
      if (((ClipSource)localObject2).path != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramList.add(localObject2);
      }
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = a((ClipSource)((Iterator)localObject1).next());
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      paramList.add(localObject2);
    }
    return (List)paramList;
  }
  
  @Nullable
  public static final ClipSource c(@NotNull MediaClip paramMediaClip)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaClip, "$this$toClipSource");
    ResourceModel localResourceModel = paramMediaClip.resource;
    if (localResourceModel != null)
    {
      paramMediaClip = localResourceModel.picClipRect;
      if (paramMediaClip == null) {
        paramMediaClip = new RectF(0.0F, 0.0F, 0.0F, 0.0F, null, 31, null);
      }
      String str1 = localResourceModel.id;
      String str2 = localResourceModel.path;
      ClipSource.ClipType localClipType;
      if (localResourceModel.type == MediaType.IMAGE) {
        localClipType = ClipSource.ClipType.PHOTO;
      } else {
        localClipType = ClipSource.ClipType.VIDEO;
      }
      float f1 = paramMediaClip.left;
      float f2 = paramMediaClip.right;
      paramMediaClip = new Rect(f1, paramMediaClip.top, f2, paramMediaClip.bottom, null, 16, null);
      long l = localResourceModel.selectDuration;
      if (localResourceModel.scaleDuration != 0L) {
        f1 = (float)localResourceModel.selectDuration / (float)localResourceModel.scaleDuration;
      } else {
        f1 = 1.0F;
      }
      return new ClipSource(str1, str2, localClipType, l, Float.valueOf(f1), Float.valueOf(localResourceModel.volume), Long.valueOf(localResourceModel.selectStart), null, null, null, paramMediaClip, null, 2944, null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.extension.MediaClipExtensionKt
 * JD-Core Version:    0.7.0.1
 */