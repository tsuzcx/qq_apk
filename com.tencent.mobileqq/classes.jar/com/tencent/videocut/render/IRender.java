package com.tencent.videocut.render;

import com.tencent.videocut.model.MediaModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/IRender;", "", "update", "", "mediaModel", "Lcom/tencent/videocut/model/MediaModel;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IRender
{
  public abstract void b(@NotNull MediaModel paramMediaModel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.IRender
 * JD-Core Version:    0.7.0.1
 */