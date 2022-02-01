package com.tencent.tkd.weibo.framework;

import android.content.Context;
import android.widget.ImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface IImageLoader
{
  public abstract void a(@NotNull Context paramContext, @NotNull String paramString, @Nullable ImageView paramImageView, @NotNull IImageLoader.ImageLoaderOption paramImageLoaderOption);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.IImageLoader
 * JD-Core Version:    0.7.0.1
 */