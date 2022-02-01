package com.tencent.xaction.api;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/IMemoryLruCache;", "", "evictAll", "", "get", "Landroid/graphics/Bitmap;", "key", "", "put", "obj", "remove", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public abstract interface IMemoryLruCache
{
  @Nullable
  public abstract Bitmap a(@NotNull String paramString);
  
  public abstract void a(@NotNull String paramString, @NotNull Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.IMemoryLruCache
 * JD-Core Version:    0.7.0.1
 */