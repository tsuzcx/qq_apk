package com.tencent.videocut.render;

import com.tencent.videocut.model.BackgroundFillMode;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.RatioType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.render.model.RatioTypeEnum;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"DEFAULT_BACKGROUND_COLOR", "", "DEFAULT_COLOR_BACKGROUND_ID", "getDEFAULT_COLOR_BACKGROUND_ID", "()Ljava/lang/String;", "adaptSourceSizeByRenderSize", "Lcom/tencent/videocut/model/SizeF;", "renderSizeF", "sourceSize", "computeVideoSize", "ratio", "", "maxSize", "", "createDefaultBackgroundModel", "Lcom/tencent/videocut/model/BackgroundModel;", "videos", "", "Lcom/tencent/videocut/model/MediaClip;", "fillScale", "getDefaultSize", "getMaxSize", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class FrameFuncKt
{
  @NotNull
  private static final String a;
  
  static
  {
    String str = UUID.randomUUID().toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "UUID.randomUUID().toString()");
    a = str;
  }
  
  private static final int a()
  {
    return Math.max(720, 1280);
  }
  
  @Nullable
  public static final BackgroundModel a(@NotNull List<MediaClip> paramList, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "videos");
    paramList = a(paramList);
    if (paramList != null)
    {
      String str = a;
      RatioType localRatioType = RatioTypeEnum.ORIGINAL.getType();
      return new BackgroundModel(str, paramList, BackgroundFillMode.SOLID_COLOR, "#ff000000", null, localRatioType, null, null, paramFloat, null, 720, null);
    }
    return null;
  }
  
  @NotNull
  public static final SizeF a(float paramFloat, int paramInt)
  {
    if (paramFloat <= 0)
    {
      paramFloat = paramInt;
      return new SizeF(paramFloat, paramFloat, null, 4, null);
    }
    if (paramFloat > 1)
    {
      f = paramInt;
      return new SizeF(f, f / paramFloat, null, 4, null);
    }
    float f = paramInt;
    return new SizeF(f * paramFloat, f, null, 4, null);
  }
  
  @NotNull
  public static final SizeF a(@NotNull SizeF paramSizeF1, @NotNull SizeF paramSizeF2)
  {
    Intrinsics.checkParameterIsNotNull(paramSizeF1, "renderSizeF");
    Intrinsics.checkParameterIsNotNull(paramSizeF2, "sourceSize");
    float f = paramSizeF1.width / paramSizeF1.height;
    if (paramSizeF2.width / paramSizeF2.height >= f)
    {
      f = paramSizeF1.width / paramSizeF2.width;
      return new SizeF(paramSizeF1.width, paramSizeF2.height * f, null, 4, null);
    }
    f = paramSizeF1.height / paramSizeF2.height;
    return new SizeF(paramSizeF2.width * f, paramSizeF1.height, null, 4, null);
  }
  
  @Nullable
  public static final SizeF a(@NotNull List<MediaClip> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "videos");
    paramList = (MediaClip)CollectionsKt.firstOrNull(paramList);
    if (paramList != null)
    {
      paramList = paramList.resource;
      if (paramList != null)
      {
        paramList = paramList.size;
        if ((paramList != null) && (paramList.height > 0)) {
          return a(paramList.width / paramList.height, a());
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.FrameFuncKt
 * JD-Core Version:    0.7.0.1
 */