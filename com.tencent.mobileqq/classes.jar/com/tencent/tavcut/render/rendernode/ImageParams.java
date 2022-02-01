package com.tencent.tavcut.render.rendernode;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/rendernode/ImageParams;", "", "()V", "videoChannelImages", "", "Lcom/tencent/tavcut/render/rendernode/ImageParams$ImageTrackPair;", "getVideoChannelImages", "()Ljava/util/List;", "setVideoChannelImages", "(Ljava/util/List;)V", "ImageTrackPair", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class ImageParams
{
  @NotNull
  private List<ImageParams.ImageTrackPair> a = (List)new ArrayList();
  
  @NotNull
  public final List<ImageParams.ImageTrackPair> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.rendernode.ImageParams
 * JD-Core Version:    0.7.0.1
 */