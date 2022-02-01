package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import com.tencent.qcircle.tavcut.util.Logger;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

class VideoThumbVideoCache$1
  implements Runnable
{
  VideoThumbVideoCache$1(VideoThumbVideoCache paramVideoThumbVideoCache, long paramLong) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    localObject1 = VideoThumbVideoCache.access$100((VideoThumbVideoCache)localObject1, VideoThumbVideoCache.access$000((VideoThumbVideoCache)localObject1), this.val$time, false);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("bitmap start recycle:");
    ((StringBuilder)localObject2).append(((BaseVideoThumbAssetCache.SeekListResult)localObject1).isNormalized);
    Logger.i("VideoThumbVideoCache", ((StringBuilder)localObject2).toString());
    if (!((BaseVideoThumbAssetCache.SeekListResult)localObject1).isNormalized)
    {
      localObject1 = (BaseVideoThumbAssetCache.BitmapPoint)VideoThumbVideoCache.access$000(this.this$0).remove(((BaseVideoThumbAssetCache.SeekListResult)localObject1).index);
      VideoThumbVideoCache.access$200(this.this$0).remove(String.valueOf(((BaseVideoThumbAssetCache.BitmapPoint)localObject1).time));
      localObject2 = this.this$0;
      ((VideoThumbVideoCache)localObject2).mCacheSize -= ((BaseVideoThumbAssetCache.BitmapPoint)localObject1).bitmap.getAllocationByteCount();
      if ((((BaseVideoThumbAssetCache.BitmapPoint)localObject1).bitmap != null) && (!((BaseVideoThumbAssetCache.BitmapPoint)localObject1).bitmap.isRecycled()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("bitmap recycle:");
        ((StringBuilder)localObject2).append(((BaseVideoThumbAssetCache.BitmapPoint)localObject1).time);
        Logger.i("VideoThumbVideoCache", ((StringBuilder)localObject2).toString());
        ((BaseVideoThumbAssetCache.BitmapPoint)localObject1).bitmap.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbVideoCache.1
 * JD-Core Version:    0.7.0.1
 */