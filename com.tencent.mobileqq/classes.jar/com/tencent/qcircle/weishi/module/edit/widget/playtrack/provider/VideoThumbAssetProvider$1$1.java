package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.CMTime;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class VideoThumbAssetProvider$1$1
  implements Runnable
{
  VideoThumbAssetProvider$1$1(VideoThumbAssetProvider.1 param1, CMTime paramCMTime, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (VideoThumbAssetProvider.access$000(this.this$1.this$0) != null) {
      VideoThumbAssetProvider.access$000(this.this$1.this$0).addCover(this.val$startTime, this.val$bitmap);
    }
    Object localObject1 = String.valueOf(this.val$startTime.getTimeUs() / 1000L);
    Object localObject2 = (List)VideoThumbAssetProvider.access$100(this.this$1.this$0).get(localObject1);
    if (localObject2 != null)
    {
      VideoThumbAssetProvider.access$100(this.this$1.this$0).remove(localObject1);
      if (VideoThumbAssetProvider.access$200(this.this$1.this$0) != null)
      {
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          VideoThumbAssetProvider.access$200(this.this$1.this$0).onThumbGenerated(localObject2, this.val$startTime, this.val$bitmap);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbAssetProvider.1.1
 * JD-Core Version:    0.7.0.1
 */