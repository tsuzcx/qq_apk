package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.util.LruCache;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager$VideoThumbLruCache;", "Landroid/util/LruCache;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/LRUKey;", "", "maxSize", "(I)V", "entryRemoved", "", "evicted", "", "key", "oldValue", "newValue", "(ZLcom/tencent/mobileqq/wink/editor/clipping/thumbnail/LRUKey;ILjava/lang/Integer;)V", "sizeOf", "value", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
final class ThumbnailProviderManager$VideoThumbLruCache
  extends LruCache<LRUKey, Integer>
{
  public ThumbnailProviderManager$VideoThumbLruCache(int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(@NotNull LRUKey paramLRUKey, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramLRUKey, "key");
    return paramInt / 1024;
  }
  
  protected void a(boolean paramBoolean, @NotNull LRUKey paramLRUKey, int paramInt, @Nullable Integer paramInteger)
  {
    Intrinsics.checkParameterIsNotNull(paramLRUKey, "key");
    super.entryRemoved(paramBoolean, paramLRUKey, Integer.valueOf(paramInt), paramInteger);
    if (!paramBoolean) {
      return;
    }
    Iterator localIterator = ((Iterable)ThumbnailProviderManager.a(ThumbnailProviderManager.a)).iterator();
    while (localIterator.hasNext())
    {
      paramInteger = localIterator.next();
      ThumbnailAssetProvider localThumbnailAssetProvider = (ThumbnailAssetProvider)paramInteger;
      if (Intrinsics.areEqual(paramLRUKey.a(), localThumbnailAssetProvider.a())) {
        break label86;
      }
    }
    paramInteger = null;
    label86:
    paramInteger = (ThumbnailAssetProvider)paramInteger;
    if (paramInteger != null) {
      paramInteger.a(paramLRUKey.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager.VideoThumbLruCache
 * JD-Core Version:    0.7.0.1
 */