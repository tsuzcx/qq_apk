package com.tencent.tavcut.creator;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.TimeStretchMode;
import com.tencent.tavcut.render.util.TimeStretchModeExtKt;
import com.tencent.tavcut.rendermodel.inputsource.InputSourceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/creator/InputSourceCreator;", "Lcom/tencent/tavcut/creator/IInputSourceCreator;", "()V", "createAudioClipData", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "id", "", "path", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "createImageData", "createJsData", "createLutFilterData", "createPagAsset", "pagPath", "loopCount", "", "timeStretchMode", "Lcom/tencent/tavcut/composition/model/component/TimeStretchMode;", "createRenderTarget", "inputKey", "createShaderData", "createTextureData", "createVideoClipData", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class InputSourceCreator
  implements IInputSourceCreator
{
  public static final InputSourceCreator a = new InputSourceCreator();
  
  @NotNull
  public InputSource a(@NotNull String paramString1, int paramInt, @NotNull String paramString2, @NotNull TimeStretchMode paramTimeStretchMode)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "pagPath");
    Intrinsics.checkParameterIsNotNull(paramString2, "id");
    Intrinsics.checkParameterIsNotNull(paramTimeStretchMode, "timeStretchMode");
    return new InputSource(paramString2, InputSourceType.PAGFileData.name(), paramString1, paramString1, new TimeRange(0L, 0L, null, 4, null), Integer.valueOf(paramInt), null, null, Integer.valueOf(TimeStretchModeExtKt.a(paramTimeStretchMode)), null, 704, null);
  }
  
  @NotNull
  public InputSource a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "pagPath");
    Intrinsics.checkParameterIsNotNull(paramString2, "id");
    return a(paramString1, -1, paramString2, TimeStretchMode.REPEAT);
  }
  
  @NotNull
  public InputSource a(@NotNull String paramString1, @NotNull String paramString2, @NotNull TimeRange paramTimeRange)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "id");
    Intrinsics.checkParameterIsNotNull(paramString2, "path");
    Intrinsics.checkParameterIsNotNull(paramTimeRange, "timeRange");
    return new InputSource(paramString1, InputSourceType.AudioClipData.name(), paramString2, paramString2, paramTimeRange, Integer.valueOf(0), null, null, null, null, 960, null);
  }
  
  @NotNull
  public InputSource a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "id");
    Intrinsics.checkParameterIsNotNull(paramString2, "path");
    Intrinsics.checkParameterIsNotNull(paramString3, "inputKey");
    return new InputSource(paramString1, InputSourceType.RenderTarget.name(), paramString2, paramString2, null, null, null, paramString3, null, null, 880, null);
  }
  
  @NotNull
  public InputSource b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "path");
    Intrinsics.checkParameterIsNotNull(paramString2, "id");
    return new InputSource(paramString2, InputSourceType.LUTFilterData.name(), paramString1, paramString1, new TimeRange(0L, 0L, null, 4, null), Integer.valueOf(-1), null, null, null, null, 960, null);
  }
  
  @NotNull
  public InputSource b(@NotNull String paramString1, @NotNull String paramString2, @NotNull TimeRange paramTimeRange)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "id");
    Intrinsics.checkParameterIsNotNull(paramString2, "path");
    Intrinsics.checkParameterIsNotNull(paramTimeRange, "timeRange");
    return new InputSource(paramString1, InputSourceType.VideoClipData.name(), paramString2, paramString2, paramTimeRange, Integer.valueOf(0), null, null, null, null, 960, null);
  }
  
  @NotNull
  public InputSource c(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "id");
    Intrinsics.checkParameterIsNotNull(paramString2, "path");
    return new InputSource(paramString1, InputSourceType.ImageData.name(), paramString2, paramString2, new TimeRange(0L, 0L, null, 4, null), Integer.valueOf(0), null, null, null, null, 960, null);
  }
  
  @NotNull
  public InputSource d(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "id");
    Intrinsics.checkParameterIsNotNull(paramString2, "path");
    return new InputSource(paramString1, InputSourceType.TextureData.name(), paramString2, paramString2, null, Integer.valueOf(0), null, null, null, null, 976, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.creator.InputSourceCreator
 * JD-Core Version:    0.7.0.1
 */