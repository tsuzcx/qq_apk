package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.util.LruCache;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailAssetCache;", "", "assetPath", "", "lruCache", "Landroid/util/LruCache;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/LRUKey;", "", "(Ljava/lang/String;Landroid/util/LruCache;)V", "getAssetPath", "()Ljava/lang/String;", "getLruCache", "()Landroid/util/LruCache;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ThumbnailAssetCache
{
  @NotNull
  private final String a;
  @NotNull
  private final LruCache<LRUKey, Integer> b;
  
  public ThumbnailAssetCache(@NotNull String paramString, @NotNull LruCache<LRUKey, Integer> paramLruCache)
  {
    this.a = paramString;
    this.b = paramLruCache;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  @NotNull
  public final LruCache<LRUKey, Integer> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailAssetCache
 * JD-Core Version:    0.7.0.1
 */