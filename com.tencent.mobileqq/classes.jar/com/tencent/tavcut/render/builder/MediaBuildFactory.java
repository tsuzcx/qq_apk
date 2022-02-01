package com.tencent.tavcut.render.builder;

import com.tencent.tavcut.render.builder.light.LightMediaBuilder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/builder/MediaBuildFactory;", "", "()V", "getMediaBuilder", "Lcom/tencent/tavcut/render/builder/IMediaBuilder;", "renderType", "", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class MediaBuildFactory
{
  public static final MediaBuildFactory a = new MediaBuildFactory();
  
  @NotNull
  public final IMediaBuilder a(int paramInt)
  {
    return (IMediaBuilder)LightMediaBuilder.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.builder.MediaBuildFactory
 * JD-Core Version:    0.7.0.1
 */