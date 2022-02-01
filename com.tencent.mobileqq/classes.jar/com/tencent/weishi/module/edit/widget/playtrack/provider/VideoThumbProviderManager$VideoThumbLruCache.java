package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;

class VideoThumbProviderManager$VideoThumbLruCache
  extends LruCache<BaseVideoThumbAssetCache.LRUKey, Integer>
{
  VideoThumbProviderManager$VideoThumbLruCache(VideoThumbProviderManager paramVideoThumbProviderManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected void entryRemoved(boolean paramBoolean, @NonNull BaseVideoThumbAssetCache.LRUKey paramLRUKey, @NonNull Integer paramInteger1, @Nullable Integer paramInteger2)
  {
    super.entryRemoved(paramBoolean, paramLRUKey, paramInteger1, paramInteger2);
    if (!paramBoolean) {}
    do
    {
      return;
      paramInteger1 = VideoThumbProviderManager.access$400(this.this$0, paramLRUKey.assetId, VideoThumbProviderManager.access$200(this.this$0));
    } while (paramInteger1 == null);
    paramInteger1.releaseBitmap(paramLRUKey.time);
  }
  
  protected int sizeOf(@NonNull BaseVideoThumbAssetCache.LRUKey paramLRUKey, @NonNull Integer paramInteger)
  {
    return paramInteger.intValue() / 1024;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager.VideoThumbLruCache
 * JD-Core Version:    0.7.0.1
 */