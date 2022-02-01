package com.tencent.tavcut.creator;

import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.model.ClipSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/creator/IClipSourceCreator;", "", "createPhotoClipSource", "Lcom/tencent/tavcut/model/ClipSource;", "path", "", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "createVideoClipSource", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IClipSourceCreator
{
  @NotNull
  public abstract ClipSource a(@NotNull String paramString, @NotNull TimeRange paramTimeRange);
  
  @NotNull
  public abstract ClipSource b(@NotNull String paramString, @NotNull TimeRange paramTimeRange);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.creator.IClipSourceCreator
 * JD-Core Version:    0.7.0.1
 */