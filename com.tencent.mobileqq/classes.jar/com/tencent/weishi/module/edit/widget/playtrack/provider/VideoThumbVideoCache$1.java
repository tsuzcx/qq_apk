package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import com.tencent.tavcut.util.Logger;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

class VideoThumbVideoCache$1
  implements Runnable
{
  VideoThumbVideoCache$1(VideoThumbVideoCache paramVideoThumbVideoCache, long paramLong) {}
  
  public void run()
  {
    Object localObject = VideoThumbVideoCache.access$100(this.this$0, VideoThumbVideoCache.access$000(this.this$0), this.val$time, false);
    Logger.i("VideoThumbVideoCache", "bitmap start recycle:" + ((BaseVideoThumbAssetCache.SeekListResult)localObject).isNormalized);
    if (!((BaseVideoThumbAssetCache.SeekListResult)localObject).isNormalized)
    {
      localObject = (BaseVideoThumbAssetCache.BitmapPoint)VideoThumbVideoCache.access$000(this.this$0).remove(((BaseVideoThumbAssetCache.SeekListResult)localObject).index);
      VideoThumbVideoCache.access$200(this.this$0).remove(String.valueOf(((BaseVideoThumbAssetCache.BitmapPoint)localObject).time));
      VideoThumbVideoCache localVideoThumbVideoCache = this.this$0;
      localVideoThumbVideoCache.mCacheSize -= ((BaseVideoThumbAssetCache.BitmapPoint)localObject).bitmap.getAllocationByteCount();
      if ((((BaseVideoThumbAssetCache.BitmapPoint)localObject).bitmap != null) && (!((BaseVideoThumbAssetCache.BitmapPoint)localObject).bitmap.isRecycled()))
      {
        Logger.i("VideoThumbVideoCache", "bitmap recycle:" + ((BaseVideoThumbAssetCache.BitmapPoint)localObject).time);
        ((BaseVideoThumbAssetCache.BitmapPoint)localObject).bitmap.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbVideoCache.1
 * JD-Core Version:    0.7.0.1
 */