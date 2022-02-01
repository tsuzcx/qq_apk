package com.tencent.tavcut.creator;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.TimeStretchMode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/creator/IInputSourceCreator;", "", "createAudioClipData", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "id", "", "path", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "createImageData", "createJsData", "createLutFilterData", "createPagAsset", "pagPath", "loopCount", "", "timeStretchMode", "Lcom/tencent/tavcut/composition/model/component/TimeStretchMode;", "createRenderTarget", "inputKey", "createShaderData", "createTextureData", "createVideoClipData", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IInputSourceCreator
{
  @NotNull
  public abstract InputSource a(@NotNull String paramString1, int paramInt, @NotNull String paramString2, @NotNull TimeStretchMode paramTimeStretchMode);
  
  @NotNull
  public abstract InputSource a(@NotNull String paramString1, @NotNull String paramString2);
  
  @NotNull
  public abstract InputSource a(@NotNull String paramString1, @NotNull String paramString2, @NotNull TimeRange paramTimeRange);
  
  @NotNull
  public abstract InputSource a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3);
  
  @NotNull
  public abstract InputSource b(@NotNull String paramString1, @NotNull String paramString2);
  
  @NotNull
  public abstract InputSource b(@NotNull String paramString1, @NotNull String paramString2, @NotNull TimeRange paramTimeRange);
  
  @NotNull
  public abstract InputSource c(@NotNull String paramString1, @NotNull String paramString2);
  
  @NotNull
  public abstract InputSource d(@NotNull String paramString1, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.creator.IInputSourceCreator
 * JD-Core Version:    0.7.0.1
 */