package com.tencent.tkd.topicsdk.interfaces;

import org.jetbrains.annotations.NotNull;

public abstract interface IVideoCompressor
{
  public abstract void a(@NotNull String paramString, @NotNull IVideoCompressor.Callback paramCallback);
  
  public abstract void a(@NotNull String paramString, @NotNull IVideoCompressor.VideoCompressListener paramVideoCompressListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.interfaces.IVideoCompressor
 * JD-Core Version:    0.7.0.1
 */