package com.tencent.weseevideo.composition.builder;

import com.tencent.weseevideo.composition.VideoRenderChainManager;

public abstract interface MediaBuilderListener
{
  public abstract void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.builder.MediaBuilderListener
 * JD-Core Version:    0.7.0.1
 */