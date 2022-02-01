package com.tencent.tavcut.render.builder;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/builder/IMediaBuilderListener;", "", "buildCompleted", "", "errorCode", "", "output", "Lcom/tencent/tavcut/render/builder/MediaBuilderOutput;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IMediaBuilderListener
{
  public abstract void a(int paramInt, @Nullable MediaBuilderOutput paramMediaBuilderOutput);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.builder.IMediaBuilderListener
 * JD-Core Version:    0.7.0.1
 */